package com.tigertown.conosco.db.contracts;
import java.util.*;
import android.util.*;
import com.tigertown.conosco.global.*;
import com.tigertown.conosco.db.*;

public final class ContactsPeeps
{
	private ContactsPeeps() {}

	public static final String TABLE_NAME = "contactspeeps";

	public static final String PERSON_ID = "personid";
	public static final String TYPE = "type";
	public static final String CONTACT = "contact";

	public static List<Pair<String, String>> GetColumns()
	{
		return Arrays.asList(Pair.create(PERSON_ID, DataTypes.INT),
							 Pair.create(TYPE, DataTypes.INT),
							 Pair.create(CONTACT, DataTypes.TEXT)); //phone contact is a number
	}

	public static String GetPrimaryKey()
	{
		return PERSON_ID + ", " + TYPE + ", " + CONTACT;
	}

	public static List<ForeignKey> GetForeignKeys()
	{
		return Arrays.asList(new ForeignKey("fk_" + TABLE_NAME + PERSON_ID, PERSON_ID, Peeps.TABLE_NAME, Peeps.ID));
	}

	public static final String CREATE_TABLE = 
		ContractHelper.CreateTable(TABLE_NAME, GetColumns(), GetPrimaryKey(), GetForeignKeys());
}
