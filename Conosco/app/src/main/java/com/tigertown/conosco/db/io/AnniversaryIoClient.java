package com.tigertown.conosco.db.io;
import android.database.*;
import com.tigertown.conosco.db.contracts.*;
import com.tigertown.conosco.dataModels.*;
import java.util.*;
import com.tigertown.conosco.global.modelInterfaces.*;

public class AnniversaryIoClient extends IdBasedIoClient<IAnniversary, IPersonJoinRecord>
{
	public AnniversaryIoClient() {
		super(Anniversaries.TABLE_NAME, AnniversariesPeeps.TABLE_NAME, AnniversariesPeeps.ANNIVERSARY_ID);
	}

	@Override
	public Anniversary convertRow(Cursor c)
	{
		int id = getInt(c, Anniversaries.ID); // c.getInt(c.getColumnIndexOrThrow(Anniversaries.ID));
		String type = getString(c, Anniversaries.TYPE); //c.getString(c.getColumnIndexOrThrow(Anniversaries.TYPE));
		String date = getString(c, Anniversaries.DATE); //c.getString(c.getColumnIndexOrThrow(Anniversaries.DATE));
		int notify = getInt(c, Anniversaries.NOTIFY); //c.getInt(c.getColumnIndexOrThrow(Anniversaries.NOTIFY));
		
		return new Anniversary(id, type, date, notify);
	}

	@Override
	public Anniversary getEmptyRecord()
	{
		return new Anniversary();
	}

	@Override
	public HashMap<String, String> processRecordForUpsert(IAnniversary record)
	{
		HashMap<String, String> result = new HashMap<String, String>();
		
		processId(result, record.getId());
		
		result.put(Anniversaries.TYPE, record.getType());
		result.put(Anniversaries.DATE, sqlize(record.getDate()));
		result.put(Anniversaries.NOTIFY, sqlize(record.getNotify()));
		
		return result;
	}
	
	//testing only
	public String getFirstId() {
		List<IAnniversary> data = read();
		String result = null;
		for (IAnniversary a : data)
			result = sqlize(a.getId());
		
		return result;
	}
}
