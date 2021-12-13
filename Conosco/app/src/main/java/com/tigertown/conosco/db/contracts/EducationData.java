package com.tigertown.conosco.db.contracts;
import java.util.*;
import android.util.*;
import com.tigertown.conosco.global.*;
import com.tigertown.conosco.db.*;

public final class EducationData
{
	private EducationData() {}
	
	public static final String TABLE_NAME = "educationdata";
	
	public static final String ID = "id";
	public static final String PERSON_ID = "personid";
	public static final String SCHOOL = "school";
	public static final String YEAR = "year";
	public static final String DEGREE = "degree";
	public static final String MAJOR = "major";
	public static final String NOTES = "notes";
	
	public static List<Pair<String, String>> GetColumns()
	{
		return Arrays.asList(Pair.create(ID, DataTypes.INTPK),
			Pair.create(PERSON_ID, DataTypes.INT),
			Pair.create(SCHOOL, DataTypes.TEXT),
			Pair.create(YEAR, DataTypes.INT),
			Pair.create(DEGREE, DataTypes.TEXT),
			Pair.create(MAJOR, DataTypes.TEXT),
			Pair.create(NOTES, DataTypes.TEXT));
	}
	
	public static String GetPrimaryKey()
	{
		return "";
	}

	public static List<ForeignKey> GetForeignKeys()
	{
		return Arrays.asList(new ForeignKey("fk_" + TABLE_NAME + PERSON_ID, PERSON_ID, Peeps.TABLE_NAME, Peeps.ID));
	}
	
	public static final String CREATE_TABLE = 
		ContractHelper.CreateTable(TABLE_NAME, GetColumns(), GetPrimaryKey(), GetForeignKeys());
}
