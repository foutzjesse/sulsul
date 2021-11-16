package com.tigertown.conosco.db.io;
import android.database.*;
import com.tigertown.conosco.db.contracts.*;
import com.tigertown.conosco.dataModels.*;
import java.util.*;
import com.tigertown.conosco.global.modelInterfaces.*;
import com.tigertown.conosco.global.*;

public class FaveIoClient extends IdBasedIoClient<IFave, IPersonJoinRecord>
{
	public FaveIoClient() {
		super(Faves.TABLE_NAME, FavesPeeps.TABLE_NAME, FavesPeeps.FAVE_ID);
	}

	@Override
	public Fave convertRow(Cursor c)
	{
		int id = getInt(c, Faves.ID); // c.getInt(c.getColumnIndexOrThrow(Anniversaries.ID));
		String type = getString(c, Faves.TYPE); //c.getString(c.getColumnIndexOrThrow(Anniversaries.TYPE));
		String value = getString(c, Faves.VALUE); //c.getString(c.getColumnIndexOrThrow(Anniversaries.DATE));
				
		return new Fave(id, type, value);
	}

	@Override
	public Fave getEmptyRecord()
	{
		return new Fave();
	}

	@Override
	public HashMap<String, String> processRecordForUpsert(IFave record)
	{
		HashMap<String, String> result = new HashMap<String, String>();
		
		processId(result, record.getId());
		
		result.put(Faves.TYPE, record.getType());
		result.put(Faves.VALUE, record.getValue());
				
		return result;
	}
	
	@Override
	public String getDeleteWhereClause(HashMap<String, String> data)
	{
		// TODO: Implement this method
		return null;
	}
}
