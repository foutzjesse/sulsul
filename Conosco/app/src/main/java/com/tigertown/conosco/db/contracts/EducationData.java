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
	public static final String SCHOOL_ID = "schoolid";
	public static final String YEAR = "year";
	public static final String DEGREE = "degree";
	public static final String MAJOR = "major";
	public static final String NOTES = "notes";
	
	public static List<Pair<String, String>> GetColumns()
	{
		return Arrays.asList(Pair.create(ID, DataTypes.GUID), //store id as X'123456789012...'
			Pair.create(SCHOOL_ID, DataTypes.GUID),
			Pair.create(YEAR, DataTypes.INT),
			Pair.create(DEGREE, DataTypes.TEXT),
			Pair.create(MAJOR, DataTypes.TEXT),
			Pair.create(NOTES, DataTypes.TEXT));
	}

	public static String GetPrimaryKey()
	{
		return ID;
	}
	
	public static List<ForeignKey> GetForeignKeys()
	{
		return Arrays.asList(new ForeignKey("fk_" + TABLE_NAME + SCHOOL_ID, SCHOOL_ID, Schools.TABLE_NAME, Schools.ID));
	}
	
	public static final String CREATE_TABLE = 
		ContractHelper.CreateTable(TABLE_NAME, GetColumns(), GetPrimaryKey(), GetForeignKeys());
}
