package com.tigertown.conosco.global.data;

public class School {
    public Integer id;
    public String name;
    public String location;
    public String mascot;
    public String colors;

    public School(Integer i, String n, String l, String m, String c) {
        this.id = i;
        this.name = n;
        this.location = l;
        this.mascot = m;
        this.colors = c;
    }

    public School(String n, String l, String m, String c) {
        this(null, n, l, m, c);
    }
}