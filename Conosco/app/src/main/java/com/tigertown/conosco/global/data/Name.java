package com.tigertown.conosco.global.data;

public class Name {
    public Integer id;
    public String fn;
    public String ln;
    public String mn;
    public String phonetic;
    public String nickname;
    public String display;

    public Name(Integer i, String f, String l, String m, String p, String n, String d) {
        this.id = i;
        this.fn = f;
        this.ln = l;
        this.mn = m;
        this.phonetic = p;
        this.nickname = n;
        this.display = d;
    }

    public Name(String f, String l, String m, String p, String n, String d) {
        this(null, f, l, m, p, n, d);
    }

    public Name(String f, String l, String m, String p, String n) {
        this(null, f, l, m, p, n, f + " " + l);
    }
}