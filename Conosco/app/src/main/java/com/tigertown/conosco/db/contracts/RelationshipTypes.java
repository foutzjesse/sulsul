package com.tigertown.conosco.db.contracts;

public final class RelationshipTypes implements IContract
{
	private RelationshipTypes() {}
	
	public static final String TABLE_NAME = "relationshiptypes";
	
	@Override
	public String GetName()
	{
		return TABLE_NAME;
	}
	
	public static final String NAME = "name";
}
