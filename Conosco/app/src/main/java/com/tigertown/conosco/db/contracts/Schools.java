package com.tigertown.conosco.db.contracts;
import java.util.*;
import android.util.*;
import com.tigertown.conosco.global.*;
import com.tigertown.conosco.db.*;

public final class Schools
{
	private Schools() {}

	public static final String TABLE_NAME = "schools";

	public static final String ID = "id";
  	public static final String NAME = "name";
	public static final String LOCATION = "location";
	public static final String MASCOT = "mascot";
	public static final String COLORS = "colors";

	public static List<Pair<String, String>> GetColumns()
	{
		return Arrays.asList(Pair.create(ID, DataTypes.GUID), //store id as X'123456789012...'
							 Pair.create(NAME, DataTypes.TEXT),
							 Pair.create(LOCATION, DataTypes.TEXT),
							 Pair.create(MASCOT, DataTypes.TEXT),
							 Pair.create(COLORS, DataTypes.TEXT));
	}

	public static String GetPrimaryKey()
	{
		return ID;
	}

	public static List<ForeignKey> GetForeignKeys()
	{
		return new ArrayList<ForeignKey>();
	}

	public static final String CREATE_TABLE = 
		ContractHelper.CreateTable(TABLE_NAME, GetColumns(), GetPrimaryKey(), GetForeignKeys());
}
