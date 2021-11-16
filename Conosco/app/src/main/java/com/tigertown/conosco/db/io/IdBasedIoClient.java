package com.tigertown.conosco.db.io;
import android.database.*;
import android.database.sqlite.*;
import com.tigertown.conosco.global.*;
import java.util.*;
import android.content.*;

public abstract class IdBasedIoClient<T1, T2> extends IoClientBase<T1> implements IPersonalDataIo<T1>
{
	public IdBasedIoClient(String t1, String t2, String t3) {
		super(t1);
		
		joinTable = t2;
		joinIdColumn = t3;
	}
	
	private String joinTable;
	private String joinIdColumn;

	@Override
	public abstract T1 convertRow(Cursor c);
	
	public abstract T1 getEmptyRecord();
	
	//do we really need this?
	public T1 readbyId(int anniversaryId) {
		T1 result = this.getEmptyRecord();
		
		String selectQuery = "SELECT * FROM " + super.table + " WHERE id = " + anniversaryId;

		SQLiteDatabase db = Singletons.dbHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		if(cursor.moveToFirst())
			result = convertRow(cursor);

		cursor.close();
		db.close();
		
		return result;
	}
	
	public List<T1> read(int personId) {
		List<T1> list = new ArrayList<T1>();

		String selectQuery = "SELECT * FROM " + joinTable + " p INNER JOIN " + super.table + " q ON p." + joinIdColumn + " = q.id WHERE p.personid = " + personId;

		SQLiteDatabase db = Singletons.dbHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		if(cursor.moveToFirst())
			do{
				list.add(convertRow(cursor));
			} while(cursor.moveToNext());

		cursor.close();
		db.close();

		return list;
	}
	
	public abstract HashMap<String, String> processRecordForUpsert(T1 record);
	
	public void processId(HashMap<String, String> map, Integer id) {
		if (id != null)
			map.put("id", sqlize(id));
	}
	
	public void upsertSingle(int personId, T1 record) {
		SQLiteDatabase db = Singletons.dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

		HashMap<String, String> columns = processRecordForUpsert(record);
		if(columns==null)
			throw new NullPointerException("idbased");
		
		Iterator iterator = columns.entrySet().iterator();

		while (iterator.hasNext()) {
			Map.Entry datum = (Map.Entry)iterator.next();
			values.put((String)datum.getKey(), (String)datum.getValue());
		}

		if (!columns.containsKey("id")) {//null id means new row. db will auto generate id.
			db.insert(super.table, null, values);
			insertToJoinTable(db, personId);
		}
		else
			db.update(super.table, values, getUpdateWhereClause(), getUpdateWhereClauseValues(columns));
		
		db.close();
	}

	@Override
	public String getUpdateWhereClause()
	{
		return "id = ?";
	}

	@Override
	public String[] getUpdateWhereClauseValues(HashMap<String, String> data)
	{
		return new String[]{data.get("id")};
	}
	
	private void insertToJoinTable(SQLiteDatabase db, int personId) {
		Cursor c = db.rawQuery("SELECT last_insert_rowid()", null);
		c.moveToFirst();
		int recordId = c.getInt(0);
		
		ContentValues values = new ContentValues();
		values.put("personid", personId);
		values.put(joinIdColumn, recordId);
		
		db.insert(joinTable, null, values);
	}
}
