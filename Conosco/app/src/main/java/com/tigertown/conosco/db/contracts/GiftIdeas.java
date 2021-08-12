package com.tigertown.conosco.db.contracts;
import java.util.*;
import android.util.*;
import com.tigertown.conosco.global.*;
import com.tigertown.conosco.db.*;

public final class GiftIdeas
{
	private GiftIdeas() {}

	public static final String TABLE_NAME = "giftideas";

	public static final String ID = "personid";
  	public static final String VALUE = "value";
  	
	public static List<Pair<String, String>> GetColumns()
	{
		return Arrays.asList(Pair.create(ID, DataTypes.GUID), //store id as X'123456789012...'
							 Pair.create(VALUE, DataTypes.TEXT));
	}

	public static String GetPrimaryKey()
	{
		return ID + ", " + VALUE;
	}

	public static List<ForeignKey> GetForeignKeys()
	{
		return Arrays.asList(new ForeignKey("fk_" + TABLE_NAME + ID, ID, Peeps.TABLE_NAME, Peeps.ID));
	}

	public static final String CREATE_TABLE = 
		ContractHelper.CreateTable(TABLE_NAME, GetColumns(), GetPrimaryKey(), GetForeignKeys());
}
