package com.tigertown.conosco.db.contracts;
import java.util.*;
import android.util.*;
import com.tigertown.conosco.global.*;

public final class Schools extends ContractBase implements IContract
{
	private Schools() {}

	public static final String TABLE_NAME = "schools";

	@Override
	public String GetName()
	{
		return TABLE_NAME;
	}

	public static final String ID = "id";
  	public static final String NAME = "name";
	public static final String LOCATION = "location";
	public static final String MASCOT = "mascot";
	public static final String COLORS = "colors";

	@Override
	public List<Pair<String, String>> GetColumns()
	{
		return Arrays.asList(Pair.create(ID, DataTypes.GUID), //store id as X'123456789012...'
							 Pair.create(NAME, DataTypes.TEXT),
							 Pair.create(LOCATION, DataTypes.TEXT),
							 Pair.create(MASCOT, DataTypes.TEXT),
							 Pair.create(COLORS, DataTypes.TEXT));
	}

	@Override
	public String GetPrimaryKey()
	{
		return ID;
	}

	@Override
	public List<ForeignKey> GetForeignKeys()
	{
		return new ArrayList<ForeignKey>();
	}
}
