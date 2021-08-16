package com.tigertown.conosco.global.data;

public class EducationDatum {
    public Integer id;
    public int schoolid;
    public int year;
    public String degree;
    public String major;
    public String notes;

    public EducationDatum(Integer i, int s, int y, String d, String m, String n) {
        this.id = i;
        this.schoolid = s;
        this.year = y;
        this.degree = d;
        this.major = m;
        this.notes = n;
    }

    public EducationDatum(int s, int y, String d, String m, String n) {
        this(null, s, y, d, m, n);
    }
}