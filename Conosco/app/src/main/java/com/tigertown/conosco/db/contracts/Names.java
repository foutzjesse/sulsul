package com.tigertown.conosco.db.contracts;

public final class Names implements IContract
{
	//cant instantiate it
	private Names() {}

	public static final String TABLE_NAME = "names";
	
	@Override
	public String GetName()
	{
		return TABLE_NAME;
	}
	
	public static final String ID = "id";
	public static final String FN = "fn";
	public static final String LN = "ln";
	public static final String MN = "mn";
	public static final String PHONETIC = "phonetic";
	public static final String NICKNAME = "nickname";
	public static final String DISPLAY = "display";
}
