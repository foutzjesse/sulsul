package com.tigertown.conosco.db.contracts;

public final class AnniversariesPeeps implements IContract
{
	private AnniversariesPeeps() {}
	
	public static final String TABLE_NAME = "anniversariespeeps";
	
	@Override
	public String GetName()
	{
		return TABLE_NAME;
	}
	
	public static final String PERSON_ID = "personid";
  	public static final String ANNIVERSARY_ID = "anniversaryid";
	
	@Override
	public List<Pair<String, String>> GetColumns()
	{
		return Arrays.asList(Pair.create(PERSON_ID, DataTypes.GUID), //store id as X'123456789012...'
			Pair.create(ANNIVERSARY_ID, DataTypes.GUID));
	}

	@Override
	public String GetPrimaryKey()
	{
		return PERSON_ID || ', ' || ANNIVERSARY_ID;
	}
  
  public static final String FK_PERSON = "fk_person";
  public static final String FK_PERSON_TABLE = "peeps";
  public static final String FK_PERSON_COL = "id";
  public static final String FK_ANNIVERSARY = "fk_anniversary";
  public static final String FK_ANNIVERSARY_TABLE = "anniversaries";
  public static final String FK_ANNIVERSARY_COL = "id";
}
