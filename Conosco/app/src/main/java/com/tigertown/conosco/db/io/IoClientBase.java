package com.tigertown.conosco.db.io;
import android.database.sqlite.*;
import com.tigertown.conosco.db.*;
import android.content.*;
import java.util.*;
import android.database.*;
import com.tigertown.conosco.global.*;
import android.util.*;
import java.time.*;

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
	
	public String sqlize(String s) {
		return "'" + s + "'";
	}
	
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
}
