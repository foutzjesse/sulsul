package com.tigertown.conosco.db.contracts;
import java.util.*;
import android.util.*;
import com.tigertown.conosco.global.*;
import com.tigertown.conosco.db.*;

public final class Anniversaries extends ContractBase implements IContract
{
	private Anniversaries() {}
	
	public static final String TABLE_NAME = "anniversaries";

	@Override
	public String GetName()
	{
		return TABLE_NAME;
	}
	
	public static final String ID = "id";
  	public static final String TYPE = "type";
  	public static final String DATE = "date";
  	public static final String NOTIFY = "notify";

	@Override
	public List<Pair<String, String>> GetColumns()
	{
		return Arrays.asList(Pair.create(ID, DataTypes.GUID), //store id as X'123456789012...'
			Pair.create(TYPE, DataTypes.TEXT),
			Pair.create(DATE, DataTypes.DATE),
			Pair.create(NOTIFY, DataTypes.BOOL));
	}

	@Override
	public String GetPrimaryKey()
	{
		return ID;
	}
	
	@Override
	public List<ForeignKey> GetForeignKeys()
	{
		return Arrays.asList(new ForeignKey("fk_" + TABLE_NAME + TYPE, TYPE, AnniversaryTypes.TABLE_NAME, AnniversaryTypes.NAME));
	}
}
