package com.tigertown.conosco.db.contracts;

import org.javatuples;

public abstract class ContractBase
{
  public abstract String GetName();
	public abstract List<Pair<String, String>> GetColumns();
  public abstract List<String> GetPrimaryKey();
  public abstract Quartet<Triplet<String, String, String, String>> GetForeignKeys();
}
