package com.tigertown.conosco.dataModels;

public class Trait {
    public Integer id;
    public String name;
    public String iconfile;
    public String grouping;
    public String description;
    public String notes;

    public Trait(Integer i, String n, String ic, String g, String d, String no) {
        this.id = i;
        this.name = n;
        this.iconfile = ic;
        this.grouping = g;
        this.description = d;
        this.notes = no;
    }
    public Trait(String n, String ic, String g, String d, String no) {
        this(null, n, ic, g, d, no);
    }
}
