package com.tigertown.conosco.db.contracts;

public final class EducationPeeps
{
	private EducationPeeps() {}
	
	public static final String TABLE_NAME = "educationpeeps";
	
	public static final String PERSON_ID = "personid";
	public static final String EDUCATION_ID = "educationid";
	
	public static final String FK_PERSON = "fk_person";
	public static final String FK_PERSON_TABLE = "peeps";
	public static final String FK_PERSON_COL = "id";
	public static final String FK_EDUCATION = "fk_education";
	public static final String FK_EDUCATION_TABLE = "educationdata";
	public static final String FK_EDUCATION_COL = "id";
}
