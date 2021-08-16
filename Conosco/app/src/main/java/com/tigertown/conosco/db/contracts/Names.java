package com.tigertown.conosco.db.contracts;
import java.util.*;
import android.util.*;
import com.tigertown.conosco.global.*;
import com.tigertown.conosco.db.*;

public final class Names
{
	//cant instantiate it
	private Names() {}

	public static final String TABLE_NAME = "names";
	
	public static final String ID = "id";
	public static final String FN = "fn";
	public static final String LN = "ln";
	public static final String MN = "mn";
	public static final String PHONETIC = "phonetic";
	public static final String NICKNAME = "nickname";
	public static final String DISPLAY = "display";
	
	public static List<Pair<String, String>> GetColumns()
	{
		return Arrays.asList(Pair.create(ID, DataTypes.INTPK),
			Pair.create(FN, DataTypes.TEXT),
			Pair.create(LN, DataTypes.TEXT),
			Pair.create(MN, DataTypes.TEXT),
			Pair.create(PHONETIC, DataTypes.TEXT),
			Pair.create(NICKNAME, DataTypes.TEXT),
			Pair.create(DISPLAY, DataTypes.TEXT));
	}
	
	public static String GetPrimaryKey()
	{
		return "";
	}
	
	public static List<ForeignKey> GetForeignKeys()
	{
		return new ArrayList<ForeignKey>();
	}

	public static final String CREATE_TABLE = 
		ContractHelper.CreateTable(TABLE_NAME, GetColumns(), GetPrimaryKey(), GetForeignKeys());
}
