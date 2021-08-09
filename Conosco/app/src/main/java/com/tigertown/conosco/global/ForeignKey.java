package com.tigertown.conosco.global;

public class ForeignKey
{
	public ForeignKey(String n, String c, String ft, String fc) {
		name = n;
		columns = c;
		foreignTable = ft;
		foreignColumns = fc;
	}
	
	public String name;
	public String columns;
	public String foreignTable;
	public String foreignColumns;
}
