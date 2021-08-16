package com.tigertown.conosco.db.contracts;
import java.util.*;
import android.util.*;
import com.tigertown.conosco.global.*;
import com.tigertown.conosco.db.*;

public final class EducationPeeps
{
	private EducationPeeps() {}
	
	public static final String TABLE_NAME = "educationpeeps";
	
	public static final String PERSON_ID = "personid";
	public static final String EDUCATION_ID = "educationid";
	
	public static List<Pair<String, String>> GetColumns()
	{
		return Arrays.asList(Pair.create(PERSON_ID, DataTypes.INT), //store id as X'123456789012...'
			Pair.create(EDUCATION_ID, DataTypes.INT));
	}

	public static String GetPrimaryKey()
	{
		return PERSON_ID + ", " + EDUCATION_ID;
	}

	public static List<ForeignKey> GetForeignKeys()
	{
		return Arrays.asList(new ForeignKey("fk_" + TABLE_NAME + PERSON_ID, PERSON_ID, Peeps.TABLE_NAME, Peeps.ID),
							 new ForeignKey("fk_" + TABLE_NAME + EDUCATION_ID, EDUCATION_ID, EducationData.TABLE_NAME, EducationData.ID));
	}

	public static final String CREATE_TABLE = 
		ContractHelper.CreateTable(TABLE_NAME, GetColumns(), GetPrimaryKey(), GetForeignKeys());
}
