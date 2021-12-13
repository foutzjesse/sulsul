package com.tigertown.conosco.global.modelInterfaces;

public interface IEducationDatum
{
	void setId(Integer id);
	Integer getId();
	void setYear(Integer year);
	Integer getYear();
	void setPersonId(int personId);
	int getPersonId();
	void setSchool(String school);
	String getSchool();
	void setDegree(String degree);
	String getDegree();
	void setMajor(String major);
	String getMajor();
	void setNotes(String notes);
	public String getNotes();
}
