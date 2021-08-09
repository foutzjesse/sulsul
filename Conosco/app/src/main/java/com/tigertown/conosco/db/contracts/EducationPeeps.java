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
		return PERSON_ID + ", " + EDUCATION_ID;
	}
	
	@Override
	public List<ForeignKey> GetForeignKeys()
	{
		return Arrays.asList(new ForeignKey("fk_person", PERSON_ID, Peeps.TABLE_NAME, Peeps.ID),
			new ForeignKey("fk_education", EDUCATION_ID, EducationData.TABLE_NAME, EducationData.ID));
	}
}
