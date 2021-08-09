package com.tigertown.conosco.db.contracts;
import java.util.*;
import android.util.*;
import com.tigertown.conosco.global.*;

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
	
	@Override
	public List<Pair<String, String>> GetColumns()
	{
		return Arrays.asList(Pair.create(ID, DataTypes.GUID), //store id as X'123456789012...'
			Pair.create(NAME, DataTypes.TEXT),
			Pair.create(ICON, DataTypes.TEXT),
			Pair.create(GROUPING, DataTypes.TEXT),
			Pair.create(DESCRIPTION, DataTypes.TEXT),
			Pair.create(NOTES, DataTypes.TEXT));
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
