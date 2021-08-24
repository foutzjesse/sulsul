package com.tigertown.conosco.dataModels;

public class Relationship {
    public int personid;
    public String type;
    public int nameid;

    public Relationship(int p, String t, int n) {
        this.personid = p;
        this.type = t;
        this.nameid = n;
    }
}
