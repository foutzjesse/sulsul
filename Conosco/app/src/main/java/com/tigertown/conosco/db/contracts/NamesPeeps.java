package com.tigertown.conosco.db.contracts;
import java.util.*;
import android.util.*;
import com.tigertown.conosco.global.*;

public final class NamesPeeps extends ContractBase implements IContract
{
	private NamesPeeps() {}
	
	public static final String TABLE_NAME = "namespeeps";

	@Override
	public String GetName()
	{
		return TABLE_NAME;
	}
	
	public static final String PERSON_ID = "personid";
  	public static final String NAME_ID = "nameid";

	@Override
	public List<Pair<String, String>> GetColumns()
	{
		return Arrays.asList(Pair.create(PERSON_ID, DataTypes.GUID), //store id as X'123456789012...'
			Pair.create(NAME_ID, DataTypes.GUID));
	}

	@Override
	public String GetPrimaryKey()
	{
		return PERSON_ID;
	}

	@Override
	public List<ForeignKey> GetForeignKeys()
	{
		return Arrays.asList(new ForeignKey("fk_" + TABLE_NAME + PERSON_ID, PERSON_ID, Peeps.TABLE_NAME, Peeps.ID),
							 new ForeignKey("fk_" + TABLE_NAME + NAME_ID, NAME_ID, Names.TABLE_NAME, Names.ID));
	}
}
