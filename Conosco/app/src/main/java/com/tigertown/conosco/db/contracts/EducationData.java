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
	
	@Override
	public List<Pair<String, String>> GetColumns()
	{
		return Arrays.asList(Pair.create(ID, DataTypes.GUID), //store id as X'123456789012...'
			Pair.create(SCHOOL_NAME, DataTypes.TEXT),
			Pair.create(YEAR, DataTypes.INTEGER),
			Pair.create(DEGREE, DataTypes.TEXT),
			Pair.create(MAJOR, DataTypes.TEXT),
			Pair.create(NOTES, DataTypes.TEXT));
	}

	@Override
	public String GetPrimaryKey()
	{
		return ID;
	}
}
