package com.tigertown.conosco.global;

//For singleton objects that can't be created in the Singleton pattern
//e.g. due to constructor requirements
//initialize in MainActivity if possible
public static final class ContactTypes
{
	public static final int PHONE = 0;
	public static final int URL = 1;
}
