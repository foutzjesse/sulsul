package com.tigertown.conosco.db.contracts;
import java.util.*;
import android.util.*;
import com.tigertown.conosco.global.*;
import com.tigertown.conosco.db.*;

public final class AnniversariesPeeps
{
	private AnniversariesPeeps() {}
	
	public static final String TABLE_NAME = "anniversariespeeps";
	
	public static final String PERSON_ID = "personid";
  	public static final String ANNIVERSARY_ID = "anniversaryid";
	
	public static List<Pair<String, String>> GetColumns()
	{
		return Arrays.asList(Pair.create(PERSON_ID, DataTypes.INT), //store id as X"123456789012..."
			Pair.create(ANNIVERSARY_ID, DataTypes.GUID));
	}

	public static String GetPrimaryKey()
	{
		return PERSON_ID + ", " + ANNIVERSARY_ID;
	}
  
	public static List<ForeignKey> GetForeignKeys()
	{
		return Arrays.asList(new ForeignKey("fk_" + TABLE_NAME + PERSON_ID, PERSON_ID, Peeps.TABLE_NAME, Peeps.ID),
							 new ForeignKey("fk_" + TABLE_NAME + ANNIVERSARY_ID, ANNIVERSARY_ID, Anniversaries.TABLE_NAME, Anniversaries.ID));
	}

	public static final String CREATE_TABLE = 
		ContractHelper.CreateTable(TABLE_NAME, GetColumns(), GetPrimaryKey(), GetForeignKeys());
}
