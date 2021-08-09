package com.tigertown.conosco.db.contracts;

public final class Peeps implements IContract
{
	//cant instantiate it
	private Peeps() {}
	
	public static final String TABLE_NAME = "peeps";
	
	@Override
	public String GetName()
	{
		return TABLE_NAME;
	}
	
	public static final String ID_COL = "id";
}
