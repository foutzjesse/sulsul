package com.tigertown.conosco.db.contracts;
import java.util.*;
import android.util.*;
import com.tigertown.conosco.global.*;
import com.tigertown.conosco.db.*;

public final class RelationshipTypes
{
	private RelationshipTypes() {}
	
	public static final String TABLE_NAME = "relationshiptypes";
	
	public static final String NAME = "name";
	
	public static List<Pair<String, String>> GetColumns()
	{
		return Arrays.asList(Pair.create(NAME, DataTypes.TEXT));
	}

	public static String GetPrimaryKey()
	{
		return NAME;
	}
	
	public static List<ForeignKey> GetForeignKeys()
	{
		return new ArrayList<ForeignKey>();
	}

	public static final String CREATE_TABLE = 
		ContractHelper.CreateTable(TABLE_NAME, GetColumns(), GetPrimaryKey(), GetForeignKeys());
}
