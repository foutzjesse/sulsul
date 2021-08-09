package com.tigertown.conosco.db.contracts;

public final class Relationships
{
	private Relationships() {}
	
	public static final String TABLE_NAME = "relationshiptypes";
	
	public static final String TYPE = "type";
	public static final String NAME_ID = "name_id";
	
	public static final String FK_TYPE = "fk_type";
	public static final String FK_TYPE_TABLE = "relationshiptypes";
	public static final String FK_TYPE_COL = "name";
	public static final String FK_NAME = "fk_name";
	public static final String FK_NAME_TABLE = "names"
	public static final String FK_NAME_COL = "id";
}
