package com.tigertown.conosco.dataModels;
import java.time.*;
import android.widget.*;
import android.app.*;
import com.tigertown.conosco.global.modelInterfaces.*;
import java.util.*;

public class Association implements IAssociation {
    private Integer id;
    private String value;
	
    public Association(Integer i, String v) {
        this.id = i;
        this.value = v;
    }
	
	public Association() {
		this("");
	}

	public Association(String v) {
		this(null, v);
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer i) {
		this.id = i;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public void setValue(String s) {
		this.value = s;
	}
}
