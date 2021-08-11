package com.tigertown.conosco.db.contracts;
import java.util.*;
import android.util.*;
import com.tigertown.conosco.global.*;

public final class FavesPeeps extends ContractBase implements IContract
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
		return PERSON_ID + ", " + FAVE_ID;
	}

	@Override
	public List<ForeignKey> GetForeignKeys()
	{
		return Arrays.asList(new ForeignKey("fk_" + TABLE_NAME + PERSON_ID, PERSON_ID, Peeps.TABLE_NAME, Peeps.ID),
							 new ForeignKey("fk_" + TABLE_NAME + FAVE_ID, FAVE_ID, Faves.TABLE_NAME, Faves.ID));
	}
}
