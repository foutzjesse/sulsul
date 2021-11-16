package com.tigertown.conosco.db.io;
import android.database.*;
import java.util.*;
import com.tigertown.conosco.db.contracts.*;
import com.tigertown.conosco.dataModels.*;
import com.tigertown.conosco.global.modelInterfaces.*;
import android.database.sqlite.*;
import com.tigertown.conosco.global.*;
import android.content.*;

public class PersonIoClient extends IoClientBase<IPerson>
{
	//private AnniversariesPeepsIoClient anniversaryIoClient = new AnniversariesPeepsIoClient();
	
	public PersonIoClient() {
		super(Peeps.TABLE_NAME);
	}

	public IPerson getEmptyRecord()
	{
		return new Person();
	}

	@Override
	public IPerson convertRow(Cursor c)
	{
		Integer id = getInt(c, Peeps.ID);
		String howmet = getString(c, Peeps.HOW_MET);
		String hometown = getString(c, Peeps.HOMETOWN);
		String residence = getString(c, Peeps.RESIDENCE);
		String job = getString(c, Peeps.JOB);
		String imageFile = getString(c, Peeps.IMAGE);
		String interests = getString(c, Peeps.INTERESTS);
		String notes = getString(c, Peeps.NOTES);
		String name = getString(c, Peeps.NAME);
		
		return new Person(id, howmet, hometown, residence, job, imageFile, interests, notes, name);
	}
	
	public List<IPerson> read() {
		List<IPerson> result = new ArrayList<>();
		
		String selectQuery = "SELECT * FROM " + super.table;

		SQLiteDatabase db = Singletons.dbHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		while (cursor.moveToNext())
			result.add(convertRow(cursor));

		cursor.close();
		db.close();

		return result;
	}
	
	public IPerson read(int id) {
		IPerson result = this.getEmptyRecord();

		String selectQuery = "SELECT * FROM " + super.table + " WHERE id = " + id;

		SQLiteDatabase db = Singletons.dbHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		if(cursor.moveToFirst())
			result = convertRow(cursor);

		cursor.close();
		db.close();

		return result;
	}

	public HashMap<String, String> processRecordForUpsert(IPerson record)
	{
		HashMap<String, String> result = new HashMap<String, String>();

		if (record.getId() != null)
			result.put("id", sqlize(record.getId()));
	
		result.put(Peeps.NAME, record.getName());
		result.put(Peeps.HOW_MET, record.getHowMet());
		result.put(Peeps.HOMETOWN, record.getHometown());
		result.put(Peeps.RESIDENCE, record.getResidence());
		result.put(Peeps.JOB, record.getJob());
		result.put(Peeps.IMAGE, record.getImageFile());
		result.put(Peeps.INTERESTS, record.getInterests());
		result.put(Peeps.NOTES, record.getNotes());

		return result;
	}
	
	public void upsertSingle(IPerson record) {
		HashMap<String, String> columns = processRecordForUpsert(record);
		if(columns==null)
			throw new NullPointerException("person");

		if (!columns.containsKey("id")) //null id means new row. db will auto generate id.
			insertSingle(columns);
		else
			updateSingle(columns);
	}

	@Override
	public String getUpdateWhereClause()
	{
		return "id = ?";
	}

	@Override
	public String[] getUpdateWhereClauseValues(HashMap<String, String> data)
	{
		return new String[]{data.get("id")};
	}

	@Override
	public String getDeleteWhereClause(HashMap<String, String> data)
	{
		// TODO: Implement this method
		return null;
	}
}
