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
}
