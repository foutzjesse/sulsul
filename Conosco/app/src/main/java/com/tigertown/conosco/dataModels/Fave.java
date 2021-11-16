package com.tigertown.conosco.dataModels;
import java.time.*;
import android.widget.*;
import android.app.*;
import com.tigertown.conosco.global.modelInterfaces.*;
import java.util.*;

public class Fave implements IFave {
    private Integer id;
	private String type;
    private String value;
	
    public Fave(Integer i, String t, String v) {
        this.id = i;
        this.type = t;
        this.value = v;
    }
	
	public Fave() {
		this("", "");
	}

	public Fave(String t, String v) {
		this(null, t, v);
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
	
	public String getValue() {
		return this.value;
	}
	
	public void setValue(String s) {
		this.value = s;
	}
}
