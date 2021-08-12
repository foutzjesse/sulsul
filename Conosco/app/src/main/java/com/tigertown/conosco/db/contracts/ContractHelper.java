package com.tigertown.conosco.db.contracts;
import com.tigertown.conosco.global.*;
import java.util.*;
import android.util.*;

public final class ContractHelper
{
	private ContractHelper() {}
	
	public static final String CreateTable(String name, List<Pair<String, String>> columns, String pk, List<ForeignKey> fks) {
		String result = "CREATE TABLE IF NOT EXISTS " + name + " (";
		
		for (Pair<String, String> c : columns) {
			result += (c.first + " " + c.second + ", ");
		}
		
		result += ("PRIMARY KEY (" + pk + "), ");
		
		for (ForeignKey f : fks) {
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
