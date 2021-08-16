package com.tigertown.conosco.global.data;

public class Name {
    public Integer id;
    public String howmet;
    public String hometown;
    public String residence;
    public String job;
    public String imagefile;
    public String interests;
    public String notes;

    public Name(Integer i, String h, String ht, String r, String j, String im, String i, String n) {
        this.id = i;
        this.howmet = h;
        this.hometown = ht;
        this.residence = r;
        this.job = j;
        this.imagefile = im;
        this.interests = i;
        this.notes = n;
    }

    public Name(String h, String ht, String r, String j, String im, String i, String n) {
        this(null, h, ht, r, j, im, i, n);
    }
}