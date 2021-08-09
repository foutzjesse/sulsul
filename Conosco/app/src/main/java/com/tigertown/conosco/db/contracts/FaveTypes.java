package com.tigertown.conosco.db.contracts;

public final class FaveTypes implements IContract
{
	private FaveTypes() {}
	
	public static final String TABLE_NAME = "favetypes";
	
	@Override
	public String GetName()
	{
		return TABLE_NAME;
	}
	
	public static final String NAME = "name";
}
