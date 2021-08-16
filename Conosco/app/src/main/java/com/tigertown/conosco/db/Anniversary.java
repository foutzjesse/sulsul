package com.tigertown.conosco.global.data;

public class Anniversary {
    public Integer id;
    public String type;
    public LocalDate date;
    public Boolean notify;

    public Anniversary(Integer i, String t, String d, int n) {
        this.id = i;
        this.type = t;
        this.date = LocalDate.parse(d); //turn d into CharSequence?
        this.notify = (n == 1);
    }

    public Anniversary (String t, String d, int n) {
        this(null, t, d, n)
    }
}