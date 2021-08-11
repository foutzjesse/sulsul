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
		//loop through IContract classes using reflection
		IContract contract = null;
		
		sqLiteDatabase.execSQL(contract.CreateTable()); 
	} 
	
	@Override 
	public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) { 
		//sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + SampleDBContract.Employer.TABLE_NAME); 
		//onCreate(sqLiteDatabase); 
	}
}
