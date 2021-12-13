package com.tigertown.conosco.db;
import android.database.sqlite.*;
import android.content.*;
import com.tigertown.conosco.global.*;
import java.util.*;
import android.database.*;
import com.tigertown.conosco.db.contracts.*;

public class DbHelper extends SQLiteOpenHelper
{
	private static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "conosco.db";
	
	public DbHelper(Context context) { 
		super(context, DATABASE_NAME, null, DATABASE_VERSION); 
	} 
	
	@Override
	public void onCreate(SQLiteDatabase sqLiteDatabase) {
		//cant use reflection due to foreign keys :-(
		for (String s : InitialMigration.TABLES)
			sqLiteDatabase.execSQL(s);
			
		//seed domain tables
		
		sqLiteDatabase.execSQL(InitialMigration.ANNIVERSARYTYPES);
		sqLiteDatabase.execSQL(InitialMigration.RELATIONSHIPTYPES);
		sqLiteDatabase.execSQL(InitialMigration.FAVETYPES);
		
		//TODO encrypt
	} 
	
	@Override 
	public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) { 
		//
		//onCreate(sqLiteDatabase); 
	}
	
	public void insertSingle(String table, String column, String label) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(column, label);

        db.insert(table, null, values);
        db.close();
    }
	
	public void AdHocDevPowersGo() {
		SQLiteDatabase db = this.getWritableDatabase();
		db.execSQL("DROP TABLE educationdata");
		db.execSQL("DROP TABLE educationpeeps");
		db.execSQL("DROP TABLE schools");
		db.execSQL(EducationData.CREATE_TABLE);
		
		db.close();
	}

    public List<String> read(String table){
        List<String> list = new ArrayList<String>();

        String selectQuery = "SELECT * FROM " + table;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do{
                list.add(cursor.getString(0));
            } while(cursor.moveToNext());
        }

        cursor.close();
        db.close();

        return list;
	}
}
