package com.tigertown.conosco.db.contracts;

public final class EducationData implements IContract
{
	private EducationData() {}
	
	public static final String TABLE_NAME = "educationdata";
	
	@Override
	public String GetName()
	{
		return TABLE_NAME;
	}
	
	public static final String ID = "id";
	public static final String SCHOOL_NAME = "school";
	public static final String YEAR = "year";
	public static final String DEGREE = "degree";
	public static final String MAJOR = "major";
	public static final String NOTES = "notes";
}
