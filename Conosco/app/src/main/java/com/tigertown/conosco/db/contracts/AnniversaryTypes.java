package com.tigertown.conosco.db.contracts;
import java.util.*;
import android.util.*;
import com.tigertown.conosco.global.*;

public final class AnniversaryTypes extends ContractBase implements IContract
{
	private AnniversaryTypes() {}
	
	public static final String TABLE_NAME = "anniversarytypes";
	
	@Override
	public String GetName()
	{
		return TABLE_NAME;
	}
	
	public static final String NAME = "name";
	
	@Override
	public List<Pair<String, String>> GetColumns()
	{
		return Arrays.asList(Pair.create(NAME, DataTypes.TEXT));
	}

	@Override
	public String GetPrimaryKey()
	{
		return NAME;
	}
	
	@Override
	public List<ForeignKey> GetForeignKeys()
	{
		return new ArrayList<ForeignKey>();
	}
}
