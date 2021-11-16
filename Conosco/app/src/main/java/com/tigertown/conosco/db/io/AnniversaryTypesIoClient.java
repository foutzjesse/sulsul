package com.tigertown.conosco.db.io;
import java.util.*;
import com.tigertown.conosco.db.contracts.*;

public class AnniversaryTypesIoClient extends SingleColumnIoClient
{
	public AnniversaryTypesIoClient() {
		super(AnniversaryTypes.TABLE_NAME);
	}

	@Override
	public String getDeleteWhereClause(HashMap<String, String> data)
	{
		// TODO: Implement this method
		return null;
	}

	
	//public List<String> read() {
	//	return super.read(AnniversaryTypes.TABLE_NAME);
	//}
}
