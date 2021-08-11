package com.tigertown.conosco.db.contracts;
import com.tigertown.conosco.global.*;
import java.util.*;
import android.util.*;
import com.tigertown.conosco.db.*;

public final class Groups extends ContractBase implements IContract
{
	private Groups() {}

	public static final String TABLE_NAME = "groups";

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
