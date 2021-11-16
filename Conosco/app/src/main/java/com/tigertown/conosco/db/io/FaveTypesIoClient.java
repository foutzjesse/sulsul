package com.tigertown.conosco.db.io;
import java.util.*;
import com.tigertown.conosco.db.contracts.*;

public class FaveTypesIoClient extends SingleColumnIoClient
{
	public FaveTypesIoClient() {
		super(FaveTypes.TABLE_NAME);
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
