package com.tigertown.conosco.db.io;
import android.database.sqlite.*;
import com.tigertown.conosco.db.*;
import android.content.*;
import java.util.*;
import android.database.*;
import com.tigertown.conosco.global.*;

public abstract class IoClientBase<T>
{
	public void insertSingle(String table, String column, String label) {
        SQLiteDatabase db = Singletons.dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, label);

        db.insert(table, null, values);
        db.close();
    }

    public List<T> read(String table)
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
}
