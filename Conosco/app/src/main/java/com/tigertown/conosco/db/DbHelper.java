package com.tigertown.conosco.db;
import android.database.sqlite.*;
import android.content.*;
import com.tigertown.conosco.global.*;

public class DbHelper extends SQLiteOpenHelper
{
	private static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "conosco_db";
	
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
		//sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + SampleDBContract.Employer.TABLE_NAME); 
		//onCreate(sqLiteDatabase); 
	}
}
