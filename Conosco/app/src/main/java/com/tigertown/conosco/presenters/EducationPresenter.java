package com.tigertown.conosco.presenters;
import com.tigertown.conosco.global.*;
import com.tigertown.conosco.dataModels.*;
import com.tigertown.conosco.global.modelInterfaces.*;
import com.tigertown.conosco.db.io.*;
import java.util.*;

public class EducationPresenter extends PresenterBase<IEducationDatum>
{
	private EducationIoClient ioClient = new EducationIoClient();
	private int personId;
    private Integer id;
	
	public EducationPresenter(IView<IEducationDatum> v, Integer i, int pid) {
		super(v);
        id = i;
		personId = pid;
	}
	
	public void loadData(Integer id) {
		record = ioClient.readSingle(id, personId);
			
		this.presentData();
	}
	
	public void update(String s, String y, String d, String m, String n) {
		updateSchool(s);
        updateYear(y);
        updateDegree(d);
        updateMajor(m);
        updateNotes(n);
	}
	
	public void updateSchool (String s) {
		record.setSchool(s);
	}
	
	public void updateYear (String i) {
		Integer ii = null;
		
		if (i != null && i.length() > 0)
			ii = Integer.parseInt(i);

        record.setYear(ii);
    }
    
    public void updateDegree (String s) {
        record.setDegree(s);
    }
    
    public void updateMajor (String s) {
        record.setMajor(s);
    }
    
    public void updateNotes (String s) {
        record.setNotes(s);
    }
		
	public void save() {
		ioClient.upsertSingle(record);
	}	
}
