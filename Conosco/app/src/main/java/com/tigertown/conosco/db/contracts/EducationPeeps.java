package com.tigertown.conosco.db.contracts;
import java.util.*;
import android.util.*;
import com.tigertown.conosco.global.*;

public final class EducationPeeps implements IContract
{
	private EducationPeeps() {}
	
	public static final String TABLE_NAME = "educationpeeps";
	
	@Override
	public String GetName()
	{
		return TABLE_NAME;
	}
	
	public static final String PERSON_ID = "personid";
	public static final String EDUCATION_ID = "educationid";
	
	@Override
	public List<Pair<String, String>> GetColumns()
	{
		return Arrays.asList(Pair.create(PERSON_ID, DataTypes.GUID), //store id as X'123456789012...'
			Pair.create(EDUCATION_ID, DataTypes.GUID));
	}

	@Override
	public String GetPrimaryKey()
	{
		return PERSON_ID + ', ' + EDUCATION_ID;
	}
	
	public static final String FK_PERSON = "fk_person";
	public static final String FK_PERSON_TABLE = "peeps";
	public static final String FK_PERSON_COL = "id";
	public static final String FK_EDUCATION = "fk_education";
	public static final String FK_EDUCATION_TABLE = "educationdata";
	public static final String FK_EDUCATION_COL = "id";
}
