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
  
  	public static final String FK_TYPE = "fk_type";
  	public static final String FK_TYPE_TABLE = "favetypes";
  	public static final String FK_TYPE_COL = "name";
}
