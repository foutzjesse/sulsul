package com.tigertown.conosco.presenters;
import com.tigertown.conosco.global.*;
import com.tigertown.conosco.dataModels.*;
import com.tigertown.conosco.global.modelInterfaces.*;
import com.tigertown.conosco.db.io.*;
import java.util.*;

public class FavePresenter extends PresenterBase<IFave>
{
	private FaveTypesIoClient atioc = new FaveTypesIoClient();
	private FaveIoClient ioClient = new FaveIoClient();
	private int personId;
	
	public FavePresenter(IView<IFave> v, int pid) {
		super(v);
		personId = pid;
	}
	
	public void loadData(Integer id) {
		if (id != null)
			
			record = ioClient.readbyId(id);
		else
			record = new Fave();
			
		this.presentData();
	}
	
	public List<String> getFaveTypes() {
		return atioc.read();
	}
	
	public void update(String t, String v) {
		updateType(t);
		updateValue(v);
	}
	
	public void updateType (String t) {
		record.setType(t);
	}
	
	public void updateValue(String v) {
		record.setValue(v);
	}
		
	public void save() {
		ioClient.upsertSingle(personId, record);
	}
	
	
}
