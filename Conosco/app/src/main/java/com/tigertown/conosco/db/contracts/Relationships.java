package com.tigertown.conosco.db.contracts;
import java.util.*;
import android.util.*;
import com.tigertown.conosco.global.*;
import com.tigertown.conosco.db.*;

public final class Relationships extends ContractBase implements IContract
{
	private Relationships() {}
	
	public static final String TABLE_NAME = "relationships";
	
	@Override
	public String GetName()
	{
		return TABLE_NAME;
	}
	
	public static final String PERSON_ID = "personid";
	public static final String TYPE = "type";
	public static final String NAME_ID = "name_id";
	
	@Override
	public List<Pair<String, String>> GetColumns()
	{
		return Arrays.asList(Pair.create(PERSON_ID, DataTypes.GUID),
			Pair.create(TYPE, DataTypes.TEXT),
			Pair.create(NAME_ID, DataTypes.GUID));
	}

	@Override
	public String GetPrimaryKey()
	{
		return PERSON_ID + ", " + TYPE + ", " + NAME_ID;
	}
	
	@Override
	public List<ForeignKey> GetForeignKeys()
	{
		return Arrays.asList(new ForeignKey("fk_" + TABLE_NAME + PERSON_ID, PERSON_ID, Peeps.TABLE_NAME, Peeps.ID),
							 new ForeignKey("fk_" + TABLE_NAME + TYPE, TYPE, RelationshipTypes.TABLE_NAME, RelationshipTypes.NAME),
							 new ForeignKey("fk_" + TABLE_NAME + NAME_ID, NAME_ID, Names.TABLE_NAME, Names.ID));
	}
}
