package com.tigertown.conosco.db.contracts;
import java.util.*;
import android.util.*;
import com.tigertown.conosco.global.*;

public final class GiftIdeas extends ContractBase implements IContract
{
	private GiftIdeas() {}

	public static final String TABLE_NAME = "giftideas";

	@Override
	public String GetName()
	{
		return TABLE_NAME;
	}

	public static final String ID = "personid";
  	public static final String VALUE = "value";
  	
	@Override
	public List<Pair<String, String>> GetColumns()
	{
		return Arrays.asList(Pair.create(ID, DataTypes.GUID), //store id as X'123456789012...'
							 Pair.create(VALUE, DataTypes.TEXT));
	}

	@Override
	public String GetPrimaryKey()
	{
		return ID + ", " + VALUE;
	}

	@Override
	public List<ForeignKey> GetForeignKeys()
	{
		return Arrays.asList(new ForeignKey("fk_" + TABLE_NAME + ID, ID, Peeps.TABLE_NAME, Peeps.ID));
	}
}
