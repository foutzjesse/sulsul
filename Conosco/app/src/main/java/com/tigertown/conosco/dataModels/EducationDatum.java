package com.tigertown.conosco.dataModels;

public class EducationDatum {
    private Integer id, year;
    private int personId;
    private String school, degree, major, notes;
    
    public EducationDatum(Integer i, int p, String s, Integer y, String d, String m, String n) {
        this.id = i;
        this.personId = p;
        this.school = s;
        this.year = y;
        this.degree = d;
        this.major = m;
        this.notes = n;
    }

    public EducationDatum(int p, String s, Integer y, String d, String m, String n) {
        this(null, p, s, y, d, m, n);
    }

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getId()
	{
		return id;
	}

	public void setYear(Integer year)
	{
		this.year = year;
	}

	public Integer getYear()
	{
		return year;
	}

	public void setPersonId(int personId)
	{
		this.personId = personId;
	}

	public int getPersonId()
	{
		return personId;
	}

	public void setSchool(String school)
	{
		this.school = school;
	}

	public String getSchool()
	{
		return school;
	}

	public void setDegree(String degree)
	{
		this.degree = degree;
	}

	public String getDegree()
	{
		return degree;
	}

	public void setMajor(String major)
	{
		this.major = major;
	}

	public String getMajor()
	{
		return major;
	}

	public void setNotes(String notes)
	{
		this.notes = notes;
	}

	public String getNotes()
	{
		return notes;
	}
}
