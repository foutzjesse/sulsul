package com.tigertown.conosco.db.io;
import java.util.*;
import com.tigertown.conosco.db.contracts.*;

public class AnniversaryTypesIoClient extends SingleColumnIoClient
{
	public AnniversaryTypesIoClient() {
		super(AnniversaryTypes.TABLE_NAME);
	}
	
	//public List<String> read() {
	//	return super.read(AnniversaryTypes.TABLE_NAME);
	//}
}
