package com.tigertown.conosco.global.data;

public class Fave {
    public Integer id;
    public String type;
    public String value;

    public Fave(Integer i, String t, String v) {
        this.id = i;
        this.type = t;
        this.value = v;
    }

    public Fave(String t, String v) {
        this(null, t, v);
    }
}