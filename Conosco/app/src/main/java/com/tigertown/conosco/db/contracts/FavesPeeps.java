package com.tigertown.conosco.db.contracts;
import java.util.*;
import android.util.*;
import com.tigertown.conosco.global.*;
import com.tigertown.conosco.db.*;

public final class FavesPeeps
{
	private FavesPeeps() {}
	
	public static final String TABLE_NAME = "favespeeps";
	
	public static final String PERSON_ID = "personid";
	public static final String FAVE_ID = "faveid";
	
	public static List<Pair<String, String>> GetColumns()
	{
		return Arrays.asList(Pair.create(PERSON_ID, DataTypes.INT),
			Pair.create(FAVE_ID, DataTypes.INT));
	}

	public static String GetPrimaryKey()
	{
		return PERSON_ID + ", " + FAVE_ID;
	}

	public static List<ForeignKey> GetForeignKeys()
	{
		return Arrays.asList(new ForeignKey("fk_" + TABLE_NAME + PERSON_ID, PERSON_ID, Peeps.TABLE_NAME, Peeps.ID),
							 new ForeignKey("fk_" + TABLE_NAME + FAVE_ID, FAVE_ID, Faves.TABLE_NAME, Faves.ID));
	}

	public static final String CREATE_TABLE = 
		ContractHelper.CreateTable(TABLE_NAME, GetColumns(), GetPrimaryKey(), GetForeignKeys());
}
