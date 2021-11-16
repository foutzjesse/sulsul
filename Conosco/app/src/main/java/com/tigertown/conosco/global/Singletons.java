package com.tigertown.conosco.global;
import com.tigertown.conosco.db.*;

//For singleton objects that can't be created in the Singleton pattern
//e.g. due to constructor requirements
//initialize in MainActivity if possible
public final class Singletons
{
	private Singletons() {}
	
	public static DbHelper dbHelper;
	
	public static final String NEW = "New...";
}
