package com.tigertown.conosco.db.contracts;

public final class Faves implements IContract
{
	private Faves() {}
	
	public static final String TABLE_NAME = "faves";
	
	@Override
	public String GetName()
	{
		return TABLE_NAME;
	}
	
	public static final String ID = "id";
	public static final String TYPE = "type";
  	public static final String VALUE = "value";
	
	@Override
	public List<Pair<String, String>> GetColumns()
	{
		return Arrays.asList(Pair.create(ID, DataTypes.GUID), //store id as X'123456789012...'
			Pair.create(TYPE, DataTypes.TEXT),
			Pair.create(VALUE, DataTypes.TEXT));
	}

	@Override
	public String GetPrimaryKey()
	{
		return ID;
	}
  
  	public static final String FK_TYPE = "fk_type";
  	public static final String FK_TYPE_TABLE = "favetypes";
  	public static final String FK_TYPE_COL = "name";
}
