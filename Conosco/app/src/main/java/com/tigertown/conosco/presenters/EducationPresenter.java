package com.tigertown.conosco.presenters;
import com.tigertown.conosco.global.*;
import com.tigertown.conosco.dataModels.*;
import com.tigertown.conosco.global.modelInterfaces.*;
import com.tigertown.conosco.db.io.*;
import java.util.*;

public class EducationPresenter extends PresenterBase<IEducationDatum>
{
	private EducationIoClient ioClient = new FaveIoClient();
	private int personId;
    private Integer id;
	
	public EducationPresenter(IView<IFave> v, Integer i, int pid) {
		super(v);
        id = i;
		personId = pid;
	}
	
	public void loadData(Integer id) {
		if (id != null)
			
			record = ioClient.readbyId(id);
		else
			record = new EducationDatum();
			
		this.presentData();
	}
	
	public void update(String s, Integer y, String d, String m, String n) {
		updateSchool(s);
        updateYear(y);
        updateDegree(d);
        updateMajor(m);
        updateNotes(n);
	}
	
	public void updateSchool (String s) {
		record.setSchool(s);
	}
	
	public void updateYear (Integer i) {
        record.setYear(i);
    }
    
    public void updateDegree (String s) {
        record.setDegree(s);
    }
    
    public void updateMajor (String s) {
        record.setMajor(s);
    }
    
    public void updateNotes (String s) {
        record.updateNotes(s);
    }
		
	public void save() {
		ioClient.upsertSingle(record);
	}	
}
