package com.tigertown.conosco.db.io;
import com.tigertown.conosco.dataModels.*;
import java.util.*;
import android.database.*;
import com.tigertown.conosco.global.modelInterfaces.*;
import android.database.sqlite.*;
import com.tigertown.conosco.global.*;
import com.tigertown.conosco.db.contracts.*;
import android.content.*;

public class ContactIoClient extends IoClientBase<IPersonContact> implements IPersonalDataIo<IPersonContact>
{
    public ContactIoClient(){
		super(ContactsPeeps.TABLE_NAME);
	}
    
	public List<IPersonContact> read(int id)
	{
		List<IPersonContact> list = new ArrayList<IPersonContact>();

		String selectQuery = "SELECT * FROM " + super.table + " WHERE " + GiftIdeas.ID + " = " + id;

		SQLiteDatabase db = Singletons.dbHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		if(cursor.moveToFirst()){
			do{
				list.add(convertRow(cursor));
			} while(cursor.moveToNext());
		}

		cursor.close();
		db.close();

		return list;
	}
	
	@Override
	public IPersonContact convertRow(Cursor c)
	{
		int id = getInt(c, ContactsPeeps.PERSON_ID);
		int type = getInt(c, ContactsPeeps.TYPE);
		String value = getString(c, ContactsPeeps.CONTACT);

		return new PersonContact(id, type, value);
	}
	
	public void insertSingle(IPersonContact record) {
		HashMap<String, String> columns = new HashMap<String, String>();

		columns.put(ContactsPeeps.PERSON_ID, sqlize(record.getId()));
		columns.put(ContactsPeeps.TYPE, sqlize(record.getType()));
		columns.put(ContactsPeeps.CONTACT, record.getValue());

		insertSingle(columns);
	}

	public void upsertSingle(Integer oldType, String oldValue, IPersonContact record) {
		if (oldType == null && oldValue == null)
			insertSingle(record);
		else {
			deleteSingle(new HashMap<String, String>(Map.of(ContactsPeeps.PERSON_ID, String.valueOf(record.getId()), ContactsPeeps.TYPE, String.valueOf(oldType), ContactsPeeps.CONTACT, String.valueOf(oldValue))));
			insertSingle(record);
		}
	}

	public void deleteSingle(IPersonContact record)
	{
		deleteSingle(new HashMap<String, String>(Map.of(ContactsPeeps.PERSON_ID, String.valueOf(record.getId()), ContactsPeeps.TYPE, String.valueOf(record.getType()), ContactsPeeps.CONTACT, String.valueOf(record.getValue()))));
	}

	@Override
	public void updateSingle(HashMap<String, String> data)
	{
		// use upsert instead
	}

	@Override
	public String getUpdateWhereClause()
	{
		return ContactsPeeps.PERSON_ID + " = ? AND " + ContactsPeeps.TYPE + " = ? AND " + ContactsPeeps.CONTACT + " = ?";
	}

	@Override
	public String[] getUpdateWhereClauseValues(HashMap<String, String> data)
	{
		return new String[]{data.get(ContactsPeeps.PERSON_ID), data.get(ContactsPeeps.TYPE), data.get(ContactsPeeps.CONTACT)};
	}

	@Override
	public String getDeleteWhereClause(HashMap<String, String> data)
	{
		return String.format("%s = %s AND %s = %s AND %s = %s", ContactsPeeps.PERSON_ID, data.get(ContactsPeeps.PERSON_ID), ContactsPeeps.TYPE, data.get(ContactsPeeps.TYPE), ContactsPeeps.CONTACT, data.get(ContactsPeeps.CONTACT));
	}
}
