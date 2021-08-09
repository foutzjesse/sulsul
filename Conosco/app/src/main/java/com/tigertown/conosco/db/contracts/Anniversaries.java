package com.tigertown.conosco.db.contracts;

public final class Anniversaries
{
	private Anniversaries() {}
	
	public static final String TABLE_NAME = "anniversaries";
	public static final String ID = "id";
  	public static final String TYPE = "type";
  	public static final String DATE = "date";
  	public static final String NOTIFY = "notify";
	
	public static final String FK_TYPE = "fk_type";
	public static final String FK_TYPE_TABLE = "anniversarytypes";
	public static final String FK_TYPE_COL = "name";
}
