package com.tigertown.conosco.db.contracts;
import java.util.*;
import android.util.*;
import com.tigertown.conosco.global.*;
import com.tigertown.conosco.db.*;

public final class GroupsPeeps
{
	private GroupsPeeps() {}

	public static final String TABLE_NAME = "groupspeeps";

	public static final String PERSON_ID = "personid";
	public static final String GROUP = "group";

	public static List<Pair<String, String>> GetColumns()
	{
		return Arrays.asList(Pair.create(PERSON_ID, DataTypes.GUID), //store id as X'123456789012...'
							 Pair.create(GROUP, DataTypes.GUID));
	}

	public static String GetPrimaryKey()
	{
		return PERSON_ID + ", " + GROUP;
	}

	public static List<ForeignKey> GetForeignKeys()
	{
		return Arrays.asList(new ForeignKey("fk_" + TABLE_NAME + PERSON_ID, PERSON_ID, Peeps.TABLE_NAME, Peeps.ID),
							 new ForeignKey("fk_" + TABLE_NAME + GROUP, GROUP, Groups.TABLE_NAME, Groups.NAME));
	}

	public static final String CREATE_TABLE = 
		ContractHelper.CreateTable(TABLE_NAME, GetColumns(), GetPrimaryKey(), GetForeignKeys());
}
