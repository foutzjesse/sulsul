package com.tigertown.conosco.db.io;
import android.database.*;
import com.tigertown.conosco.db.contracts.*;
import com.tigertown.conosco.dataModels.*;
import java.util.*;
import com.tigertown.conosco.global.modelInterfaces.*;
import com.tigertown.conosco.global.*;
import android.database.sqlite.*;

public class AssociationIoClient extends IoClientBase<IAssociation> implements IPersonalDataIo<IAssociation>
{
	public AssociationIoClient() {
		super(Associations.TABLE_NAME);
	}

	@Override
	public Association convertRow(Cursor c)
	{
		int id = getInt(c, Associations.PERSON_ID);
		String value = getString(c, Associations.VALUE);
				
		return new Association(id, value);
	}

	public IAssociation getEmptyRecord()
	{
		return new Association();
	}
	
	@Override
	public String getDeleteWhereClause(HashMap<String, String> data)
	{
		// TODO: Implement this method
		return null;
	}
	
	public List<IAssociation> read(int id)
	{
		List<IAssociation> list = new ArrayList<IAssociation>();

		String selectQuery = "SELECT * FROM " + super.table + " WHERE " + Associations.PERSON_ID + " = " + id;

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

	public void insertSingle(IAssociation record) {
		HashMap<String, String> columns = new HashMap<String, String>();

		columns.put(Associations.PERSON_ID, sqlize(record.getId()));
		columns.put(Associations.VALUE, record.getValue());

		insertSingle(columns);
	}

	public void upsertSingle(String oldValue, IAssociation record) {
		if (oldValue == null)
			insertSingle(record);
		else {
			deleteSingle(new HashMap<String, String>(Map.of(Associations.PERSON_ID, String.valueOf(record.getId()), Associations.VALUE, oldValue)));
			insertSingle(record);
		}
	}

	public void deleteSingle(IAssociation record)
	{
		deleteSingle(new HashMap<String, String>(Map.of(Associations.PERSON_ID, String.valueOf(record.getId()), Associations.VALUE, record.getValue())));
	}

	@Override
	public void updateSingle(HashMap<String, String> data)
	{
		// use upsert instead
	}

	@Override
	public String getUpdateWhereClause()
	{
		return Associations.PERSON_ID + " = ? AND " + Associations.VALUE + " = ?";
	}

	@Override
	public String[] getUpdateWhereClauseValues(HashMap<String, String> data)
	{
		return new String[]{data.get(Associations.PERSON_ID), data.get(Associations.VALUE)};
	}
}
