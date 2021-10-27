package com.tigertown.conosco.db.io;
import java.util.*;
import android.database.sqlite.*;
import com.tigertown.conosco.global.*;
import android.database.*;
import android.util.*;

public abstract class SingleColumnIoClient extends IoClientBase<String>
{
	public SingleColumnIoClient(String t) {
		super(t);
	}

	@Override
	public String convertRow(Cursor c) {
		return c.getString(0);
	}
	
	public void insertSingle(String column, String value) {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put(column, value);
		super.insertSingle(data);
	}

	@Override
	public String getUpdateWhereClause()
	{
		return null;
		//throw new Exception("UPDATE is invalid for this object.");
	}

	@Override
	public String[] getUpdateWhereClauseValues(HashMap<String, String> data)
	{
		// TODO: Implement this method
		return null;
	}
}
