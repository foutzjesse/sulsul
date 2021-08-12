package com.tigertown.conosco.db.contracts;
import java.util.*;
import android.util.*;
import com.tigertown.conosco.global.*;
import com.tigertown.conosco.db.*;

public final class Faves
{
	private Faves() {}
	
	public static final String TABLE_NAME = "faves";
	
	public static final String ID = "id";
	public static final String TYPE = "type";
  	public static final String VALUE = "value";
	
	public static List<Pair<String, String>> GetColumns()
	{
		return Arrays.asList(Pair.create(ID, DataTypes.GUID), //store id as X'123456789012...'
			Pair.create(TYPE, DataTypes.TEXT),
			Pair.create(VALUE, DataTypes.TEXT));
	}

	public static String GetPrimaryKey()
	{
		return ID;
	}
  
	public static List<ForeignKey> GetForeignKeys()
	{
		return Arrays.asList(new ForeignKey("fk_" + TABLE_NAME + ID, ID, FaveTypes.TABLE_NAME, FaveTypes.NAME));
	}

	public static final String CREATE_TABLE = 
		ContractHelper.CreateTable(TABLE_NAME, GetColumns(), GetPrimaryKey(), GetForeignKeys());
}
