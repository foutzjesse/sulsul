package com.tigertown.conosco.db.io;
import android.content.*;
import android.database.*;
import android.database.sqlite.*;
import com.tigertown.conosco.global.*;
import java.time.*;
import java.util.*;

public abstract class IoClientBase<T>
{
	private String table;
	
	public IoClientBase(String t) {
		this.table = t;
	}
	
	public void insertSingle(HashMap<String, String> data) {
        SQLiteDatabase db = Singletons.dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
		Iterator iterator = data.entrySet().iterator();
		
		while (iterator.hasNext()) {
			Map.Entry datum = (Map.Entry)iterator.next();
			values.put((String)datum.getKey(), (String)datum.getValue());
		}

        db.insert(table, null, values);
        db.close();
    }
	
	public void updateSingle(HashMap<String, String> data) {
		SQLiteDatabase db = Singletons.dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
		Iterator iterator = data.entrySet().iterator();

		while (iterator.hasNext()) {
			Map.Entry datum = (Map.Entry)iterator.next();
			values.put((String)datum.getKey(), (String)datum.getValue());
		}

		db.update(table, values, getUpdateWhereClause(), getUpdateWhereClauseValues(data));

		db.close();
	}
	
	public void deleteSingle(HashMap<String, String> data) {
		SQLiteDatabase db = Singletons.dbHelper.getWritableDatabase();

		db.delete(table, getUpdateWhereClause(), getUpdateWhereClauseValues(data));

		db.close();
	}
	
	public abstract String getUpdateWhereClause();
	
	public abstract String[] getUpdateWhereClauseValues(HashMap<String, String> data);

    public List<T> read()
	{
		List<T> list = new ArrayList<T>();

		String selectQuery = "SELECT * FROM " + table;

		SQLiteDatabase db = Singletons.dbHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		if(cursor.moveToFirst()){
			do{
				list.add(convertRow(cursor));
			} while(cursor.moveToNext());
		}

		cursor.close();
		db.close();

		return list;
	}
	
	public abstract T convertRow(Cursor c);
	
	public String sqlize (LocalDate d) {
		return d.toString();
	}
	
	public String sqlize(Integer i) {
		return i.toString();
	}
	
	public String sqlize(Boolean b) {
		if (b) {
			return "1";
		}
		
		return "0";
	}
	
	public Integer getInt(Cursor c, String key) {
		return c.getInt(c.getColumnIndex(key));
	}
	
	public String getString(Cursor c, String key) {
		return c.getString(c.getColumnIndex(key));
	}
}
