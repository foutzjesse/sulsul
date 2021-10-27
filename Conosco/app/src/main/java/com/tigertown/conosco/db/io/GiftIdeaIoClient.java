package com.tigertown.conosco.db.io;
import com.tigertown.conosco.dataModels.*;
import com.tigertown.conosco.global.modelInterfaces.*;
import android.database.*;
import com.tigertown.conosco.db.contracts.*;
import java.util.*;
import android.database.sqlite.*;
import com.tigertown.conosco.global.*;

public class GiftIdeaIoClient extends IoClientBase<IGiftIdea>
{
	public GiftIdeaIoClient() {
		super(GiftIdeas.TABLE_NAME);
	}
	
	public List<IGiftIdea> read(int id)
	{
		List<IGiftIdea> list = new ArrayList<IGiftIdea>();

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
	public IGiftIdea convertRow(Cursor c)
	{
		int id = getInt(c, GiftIdeas.ID);
		String value = getString(c, GiftIdeas.VALUE);
		
		return new GiftIdea(id, value);
	}
	
	public void insertSingle(IGiftIdea record) {
		HashMap<String, String> columns = new HashMap<String, String>();
		
		columns.put(GiftIdeas.ID, sqlize(record.getPersonid()));
		columns.put(GiftIdeas.VALUE, record.getValue());
		
		insertSingle(columns);
	}
	
	public void upsertSingle(String oldValue, IGiftIdea record) {
		if (oldValue == null)
			insertSingle(record);
		else {
			deleteSingle((HashMap<String, String>)Map.of(GiftIdeas.ID, String.valueOf(record.getPersonid()), GiftIdeas.VALUE, oldValue));
			insertSingle(record);
		}
	}

	@Override
	public void updateSingle(HashMap<String, String> data)
	{
		// use upsert instead
	}

	@Override
	public String getUpdateWhereClause()
	{
		return GiftIdeas.ID + " = ? AND " + GiftIdeas.VALUE + " = ?";
	}

	@Override
	public String[] getUpdateWhereClauseValues(HashMap<String, String> data)
	{
		return new String[]{data.get("id"), data.get("value")};
	}
}
