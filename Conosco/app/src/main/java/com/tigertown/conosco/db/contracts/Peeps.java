package com.tigertown.conosco.db.contracts;
import java.util.*;
import android.util.*;
import com.tigertown.conosco.global.*;

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
	
	public static final String ID = "id";
	
	@Override
	public List<Pair<String, String>> GetColumns()
	{
		return Arrays.asList(Pair.create(ID, DataTypes.GUID)); //store id as X'123456789012...'
	}

	@Override
	public String GetPrimaryKey()
	{
		return ID;
	}
}
