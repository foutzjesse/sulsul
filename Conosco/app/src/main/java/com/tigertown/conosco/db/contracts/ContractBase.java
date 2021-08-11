package com.tigertown.conosco.db.contracts;
import com.tigertown.conosco.global.*;
import java.util.*;
import android.util.*;

public abstract class ContractBase
{

	public abstract String GetName();

	public abstract List<Pair<String, String>> GetColumns();

	public abstract String GetPrimaryKey();

	public abstract List<ForeignKey> GetForeignKeys();
	
	public String CreateTable() {
		String result = "CREATE TABLE " + GetName() + " (";
		
		for (Pair<String, String> c : GetColumns()) {
			result += (c.first + " " + c.second + ", ");
		}
		
		result += ("PRIMARY KEY (" + GetPrimaryKey() + "), ");
		
		for (ForeignKey f : GetForeignKeys()) {
			result += "CONSTRAINT " + f.name 
				+ " FOREIGN KEY (" + f.columns + ") REFERENCES "
				+ f.foreignTable + " (" + f.foreignColumns + "), ";
		}
	
		if (result.endsWith(", ")) {
			result = result.substring(0, result.length() - 3);
		}
		
		result += ")";
		
		return result;
	}
}
