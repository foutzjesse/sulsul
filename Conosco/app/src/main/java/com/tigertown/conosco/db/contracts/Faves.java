package com.tigertown.conosco.db.contracts;

public final class Faves
{
	private Faves() {}
	
	public static final String TABLE_NAME = "faves";
	public static final String TYPE = "type";
  public static final String VALUE = "value";
  
  public static final String FK_TYPE = "fk_type";
  public static final String FK_TYPE_TABLE = "favetypes";
  public static final String FK_TYPE_COL = "name";
}
