package com.tigertown.conosco.db.contracts;
import java.util.*;
import android.util.*;
import com.tigertown.conosco.global.*;
import com.tigertown.conosco.db.*;

public final class Peeps
{
	//cant instantiate it
	private Peeps() {}
	
	public static final String TABLE_NAME = "peeps";
	
	public static final String ID = "id";
	public static final String HOW_MET = "howmet";
	public static final String HOMETOWN = "hometown";
	public static final String RESIDENCE = "residence";
	public static final String JOB = "job";
	public static final String IMAGE = "image";
	public static final String INTERESTS = "interests";
	public static final String NOTES = "notes";
	//public static final String GENDER = "gender";
	
	public static List<Pair<String, String>> GetColumns()
	{
		return Arrays.asList(Pair.create(ID, DataTypes.INTPK),
			Pair.create(HOW_MET, DataTypes.TEXT),
							 Pair.create(HOMETOWN, DataTypes.TEXT),
							 Pair.create(RESIDENCE, DataTypes.TEXT),
							 Pair.create(JOB, DataTypes.TEXT),
							 Pair.create(IMAGE, DataTypes.TEXT),
							 Pair.create(INTERESTS, DataTypes.TEXT),
							 Pair.create(NOTES, DataTypes.TEXT)//,
							 //Pair.create(GENDER, DataTypes.TEXT)
							 );
	}

	public static String GetPrimaryKey()
	{
		return "";
	}
	
	public static List<ForeignKey> GetForeignKeys()
	{
		return new ArrayList<ForeignKey>();
	}

	public static final String CREATE_TABLE = 
		ContractHelper.CreateTable(TABLE_NAME, GetColumns(), GetPrimaryKey(), GetForeignKeys());
}
