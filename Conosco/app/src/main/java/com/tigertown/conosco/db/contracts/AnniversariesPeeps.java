package com.tigertown.conosco.db.contracts;

public final class AnniversariesPeeps
{
	private AnniversariesPeeps() {}
	
	public static final String TABLE_NAME = "anniversariespeeps";
	public static final String PERSON_ID = "personid";
  public static final String ANNIVERSARY_ID = "anniversaryid";
  
  public static final String FK_PERSON = "fk_person";
  public static final String FK_PERSON_TABLE = "peeps";
  public static final String FK_PERSON_COL = "id";
  public static final String FK_ANNIVERSARY = "fk_anniversary";
  public static final String FK_ANNIVERSARY_TABLE = "anniversaries";
  public static final String FK_ANNIVERSARY_COL = "id";
}
