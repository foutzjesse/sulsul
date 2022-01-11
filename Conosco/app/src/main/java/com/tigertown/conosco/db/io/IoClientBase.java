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
			
			if (datum.getValue() != null)
				values.put((String)datum.getKey(), (String)datum.getValue());
			else
				values.putNull((String)datum.getKey());
		}

		db.update(table, values, getUpdateWhereClause(), getUpdateWhereClauseValues(data));

		db.close();
	}
	
	public void deleteSingle(HashMap<String, String> data) {
		SQLiteDatabase db = Singletons.dbHelper.getWritableDatabase();
		String where = getUpdateWhereClause();
		String[] args = getUpdateWhereClauseValues(data);
		db.delete(table, where, args);
		//String q = String.format("DELETE FROM %s WHERE %s", table, getDeleteWhereClause(data));
		//db.execSQL(q);
		db.close();
	}

	public abstract String getUpdateWhereClause();
	
	public abstract String[] getUpdateWhereClauseValues(HashMap<String, String> data);
	
	public abstract String getDeleteWhereClause(HashMap<String, String> data);

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
		return (i != null) ? i.toString() : null;
	}
	
	public String sqlize(Boolean b) {
		return b ? "1" : "0";
	}
	
	public String sqlize(String s) {
		return (s != null) ? "'" + s + "'" : "null";
	}
	
	public Integer getInt(Cursor c, String key) {
		if (!c.isNull(c.getColumnIndex(key)))
			return c.getInt(c.getColumnIndex(key));
			
		return null;
	}
	
	public String getString(Cursor c, String key) {
		return c.getString(c.getColumnIndex(key));
	}
}
