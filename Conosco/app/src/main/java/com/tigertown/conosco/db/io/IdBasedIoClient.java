package com.tigertown.conosco.db.io;
import android.database.*;
import android.database.sqlite.*;
import com.tigertown.conosco.global.*;
import java.util.*;
import android.content.*;

public abstract class IdBasedIoClient<T> extends IoClientBase<T>
{
	public IdBasedIoClient(String t) {
		super(t);
	}

	@Override
	public abstract T convertRow(Cursor c);
	
	public abstract T getEmptyRecord();
	
	public T read(int id) {
		T result = this.getEmptyRecord();
		
		String selectQuery = "SELECT * FROM " + super.table + " WHERE id = " + id;

		SQLiteDatabase db = Singletons.dbHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		if(cursor.moveToFirst()){
			result = convertRow(cursor);
		}

		cursor.close();
		db.close();
		
		return result;
	}
	
	public abstract HashMap<String, String> processRecordForUpsert(T record);
	
	public void processId(HashMap<String, String> map, Integer id) {
		if (id != null) {
			map.put("id", sqlize(id));
		}
	}
	
	public void upsertSingle(T record) {
		SQLiteDatabase db = Singletons.dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

		HashMap<String, String> columns = processRecordForUpsert(record);
		if(columns==null) throw new NullPointerException("idbased");
		
		Iterator iterator = columns.entrySet().iterator();

		while (iterator.hasNext()) {
			Map.Entry datum = (Map.Entry)iterator.next();
			values.put((String)datum.getKey(), (String)datum.getValue());
		}

		if (!columns.containsKey("id")) { //null id means new row. db will auto generate id.
			db.insert(super.table, null, values);
		}
		else {
			db.update(super.table, values, "id = ?", new String[]{columns.get("id")});
		}
		
		db.close();
	}
}
