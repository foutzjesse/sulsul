package com.tigertown.conosco.db.contracts;

public final class FavesPeeps
{
	private FavesPeeps() {}
	
	public static final String TABLE_NAME = "favespeeps";
	public static final String PERSON_ID = "personid";
  public static final String FAVE_ID = "faveid";
  
  public static final String FK_PERSON = "fk_person";
  public static final String FK_PERSON_TABLE = "peeps";
  public static final String FK_PERSON_COL = "id";
  public static final String FK_FAVE = "fk_fave";
  public static final String FK_FAVE_TABLE = "faves";
  public static final String FK_FAVE_COL = "id";
}
