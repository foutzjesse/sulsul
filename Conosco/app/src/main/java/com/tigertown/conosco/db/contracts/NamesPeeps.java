package com.tigertown.conosco.db.contracts;
import java.util.*;
import android.util.*;
import com.tigertown.conosco.global.*;
import com.tigertown.conosco.db.*;

public final class NamesPeeps
{
	private NamesPeeps() {}
	
	public static final String TABLE_NAME = "namespeeps";
	
	public static final String PERSON_ID = "personid";
  	public static final String NAME_ID = "nameid";

	public static List<Pair<String, String>> GetColumns()
	{
		return Arrays.asList(Pair.create(PERSON_ID, DataTypes.GUID), //store id as X'123456789012...'
			Pair.create(NAME_ID, DataTypes.GUID));
	}

	public static String GetPrimaryKey()
	{
		return PERSON_ID;
	}
	
	public static List<ForeignKey> GetForeignKeys()
	{
		return Arrays.asList(new ForeignKey("fk_" + TABLE_NAME + PERSON_ID, PERSON_ID, Peeps.TABLE_NAME, Peeps.ID),
							 new ForeignKey("fk_" + TABLE_NAME + NAME_ID, NAME_ID, Names.TABLE_NAME, Names.ID));
	}

	public static final String CREATE_TABLE = 
		ContractHelper.CreateTable(TABLE_NAME, GetColumns(), GetPrimaryKey(), GetForeignKeys());
}
