package com.tigertown.conosco.db.contracts;
import java.util.*;
import android.util.*;
import com.tigertown.conosco.global.*;
import com.tigertown.conosco.db.*;

public final class Traits
{
	private Traits() {}
	
	public static final String TABLE_NAME = "traits";
	
	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String ICON = "icon";
	public static final String GROUPING = "grouping";
	public static final String DESCRIPTION = "description";
	public static final String NOTES = "notes";
	
	public static List<Pair<String, String>> GetColumns()
	{
		return Arrays.asList(Pair.create(ID, DataTypes.INTPK), //store id as X'123456789012...'
			Pair.create(NAME, DataTypes.TEXT),
			Pair.create(ICON, DataTypes.TEXT),
			Pair.create(GROUPING, DataTypes.TEXT),
			Pair.create(DESCRIPTION, DataTypes.TEXT),
			Pair.create(NOTES, DataTypes.TEXT));
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
