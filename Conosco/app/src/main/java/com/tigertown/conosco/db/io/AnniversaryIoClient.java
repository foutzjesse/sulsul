package com.tigertown.conosco.db.io;
import android.database.*;
import com.tigertown.conosco.db.contracts.*;
import com.tigertown.conosco.dataModels.*;
import java.util.*;

public class AnniversaryIoClient extends IdBasedIoClient<Anniversary>
{
	public AnniversaryIoClient() {
		super(Anniversaries.TABLE_NAME);
	}

	@Override
	public Anniversary convertRow(Cursor c)
	{
		int id = c.getInt(c.getColumnIndexOrThrow(Anniversaries.ID));
		String type = c.getString(c.getColumnIndexOrThrow(Anniversaries.TYPE));
		String date = c.getString(c.getColumnIndexOrThrow(Anniversaries.DATE));
		int notify = c.getInt(c.getColumnIndexOrThrow(Anniversaries.NOTIFY));
		
		return new Anniversary(id, type, date, notify);
	}

	@Override
	public Anniversary getEmptyRecord()
	{
		return new Anniversary();
	}

	@Override
	public HashMap<String, String> processRecordForUpsert(Anniversary record)
	{
		HashMap<String, String> result = new HashMap<String, String>();
		
		processId(result, record.getId());
		
		result.put(Anniversaries.TYPE, sqlize(record.getType()));
		result.put(Anniversaries.DATE, sqlize(record.getDate()));
		result.put(Anniversaries.NOTIFY, sqlize(record.getNotify()));
		
		return result;
	}
	
	//testing only
	public String getFirstId() {
		List<Anniversary> data = read();
		String result = null;
		for (Anniversary a : data)
			result = sqlize(a.getId());
		
		return result;
	}
}
