package com.tigertown.conosco.dataModels;
import java.time.*;
import android.widget.*;
import android.app.*;
import com.tigertown.conosco.global.modelInterfaces.*;
import java.util.*;

public class Anniversary implements IAnniversary {
    private Integer id;
	private String type;
    private LocalDate date;
    private Boolean notify;
	
    public Anniversary(Integer i, String t, String d, int n) {
        this.id = i;
        this.type = t;
		
        this.date = (d != null && d != "") ? LocalDate.parse(d) : null;
		
		this.notify = (n == 1);
    }
	
	public Anniversary() {
		this("", "");
	}

    public Anniversary (String t, String d, int n) {
        this(null, t, d, n);
    }
	
	public Anniversary(String t, String d) {
		this(null, t, d, 0);
	}
	
	public Integer getId() {
		return this.id;
	}

	public String getType() {
		return this.type;
	}
	
	public void setType(String s) {
		if (this.type != s) {
			this.type = s;
		}
	}
	
	public LocalDate getDate() {
		return this.date;
	}
	
	public void setDate(LocalDate d) {
		this.date = d;
	}
	
	public Boolean getNotify() {
		return this.notify;
	}
	
	public void setNotify (Boolean n) {
		if (this.notify != n) {
			this.notify = n;
		}
	}
}
