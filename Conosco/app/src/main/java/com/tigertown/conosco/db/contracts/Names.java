package com.tigertown.conosco.db.contracts;
import java.util.*;
import android.util.*;
import com.tigertown.conosco.global.*;

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
	
	@Override
	public List<Pair<String, String>> GetColumns()
	{
		return Arrays.asList(Pair.create(ID, DataTypes.GUID), //store id as X'123456789012...'
			Pair.create(FN, DataTypes.TEXT),
			Pair.create(LN, DataTypes.TEXT),
			Pair.create(MN, DataTypes.TEXT),
			Pair.create(PHONETIC, DataTypes.TEXT),
			Pair.create(NICKNAME, DataTypes.TEXT),
			Pair.create(DISPLAY, DataTypes.TEXT + " DEFAULT FN || ' ' || LN"));
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
