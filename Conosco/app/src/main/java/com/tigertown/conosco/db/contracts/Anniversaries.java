package com.tigertown.conosco.db.contracts;
import java.util.*;
import android.util.*;
import com.tigertown.conosco.global.*;
import com.tigertown.conosco.db.*;

public final class Anniversaries
{
	private Anniversaries() {}
	
	public static final String TABLE_NAME = "anniversaries";
	
	public static final String ID = "id";
  	public static final String TYPE = "type";
  	public static final String DATE = "date";
  	public static final String NOTIFY = "notify";

	public static List<Pair<String, String>> GetColumns()
	{
		return Arrays.asList(Pair.create(ID, DataTypes.INTPK),
			Pair.create(TYPE, DataTypes.TEXT),
			Pair.create(DATE, DataTypes.DATE),
			Pair.create(NOTIFY, DataTypes.BOOL));
	}

	public static String GetPrimaryKey()
	{
		return "";
	}
	
	public static List<ForeignKey> GetForeignKeys()
	{
		return Arrays.asList(new ForeignKey("fk_" + TABLE_NAME + TYPE, TYPE, AnniversaryTypes.TABLE_NAME, AnniversaryTypes.NAME));
	}

	public static final String CREATE_TABLE = 
		ContractHelper.CreateTable(TABLE_NAME, GetColumns(), GetPrimaryKey(), GetForeignKeys());
}
