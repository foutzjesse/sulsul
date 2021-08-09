package com.tigertown.conosco.db.contracts;

public final class Relationships implements IContract
{
	private Relationships() {}
	
	public static final String TABLE_NAME = "relationships";
	
	@Override
	public String GetName()
	{
		return TABLE_NAME;
	}
	
	public static final String PERSON_ID = "personid";
	public static final String TYPE = "type";
	public static final String NAME_ID = "name_id";
	
	@Override
	public List<Pair<String, String>> GetColumns()
	{
		return Arrays.asList(Pair.create(PERSON_ID, DataTypes.GUID),
			Pair.create(TYPE, DataTypes.TEXT),
			Pair.create(NAME_ID, DataTypes.GUID));
	}

	@Override
	public String GetPrimaryKey()
	{
		return PERSON_ID + ", " + TYPE + ", " + NAME_ID;
	}
	
	public static final String FK_TYPE = "fk_type";
	public static final String FK_TYPE_TABLE = "relationshiptypes";
	public static final String FK_TYPE_COL = "name";
	public static final String FK_NAME = "fk_name";
	public static final String FK_NAME_TABLE = "names";
	public static final String FK_NAME_COL = "id";
}
