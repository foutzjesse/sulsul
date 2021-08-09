package com.tigertown.conosco.db.contracts;

public final class Traits implements IContract
{
	private Traits() {}
	
	public static final String TABLE_NAME = "traits";
	
	@Override
	public String GetName()
	{
		return TABLE_NAME;
	}
	
	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String ICON = "icon";
	public static final String GROUPING = "grouping";
	public static final String DESCRIPTION = "description";
	public static final String NOTES = "notes";
}
