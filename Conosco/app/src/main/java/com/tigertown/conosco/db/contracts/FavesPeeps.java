package com.tigertown.conosco.db.contracts;
import java.util.*;
import android.util.*;
import com.tigertown.conosco.global.*;

public final class FavesPeeps implements IContract
{
	private FavesPeeps() {}
	
	public static final String TABLE_NAME = "favespeeps";
	
	@Override
	public String GetName()
	{
		return TABLE_NAME;
	}
	
	public static final String PERSON_ID = "personid";
	public static final String FAVE_ID = "faveid";
	
	@Override
	public List<Pair<String, String>> GetColumns()
	{
		return Arrays.asList(Pair.create(PERSON_ID, DataTypes.GUID), //store id as X'123456789012...'
			Pair.create(FAVE_ID, DataTypes.GUID));
	}

	@Override
	public String GetPrimaryKey()
	{
		return PERSON_ID + ', ' + FAVE_ID;
	}

	public static final String FK_PERSON = "fk_person";
	public static final String FK_PERSON_TABLE = "peeps";
	public static final String FK_PERSON_COL = "id";
	public static final String FK_FAVE = "fk_fave";
	public static final String FK_FAVE_TABLE = "faves";
	public static final String FK_FAVE_COL = "id";
}
