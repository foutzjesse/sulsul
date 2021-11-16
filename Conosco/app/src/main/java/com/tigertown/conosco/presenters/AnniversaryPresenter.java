package com.tigertown.conosco.presenters;
import com.tigertown.conosco.global.*;
import java.time.*;
import com.tigertown.conosco.dataModels.*;
import com.tigertown.conosco.global.modelInterfaces.*;
import com.tigertown.conosco.db.io.*;
import java.util.*;

public class AnniversaryPresenter extends PresenterBase<IAnniversary>
{
	private AnniversaryTypesIoClient atioc = new AnniversaryTypesIoClient();
	private AnniversaryIoClient ioClient = new AnniversaryIoClient();
	private int personId;
	
	public AnniversaryPresenter(IView<IAnniversary> v, int pid) {
		super(v);
		personId = pid;
	}
	
	public void loadData(Integer id) {
		if (id != null)
			
			record = ioClient.readbyId(id);
		else
			record = new Anniversary();
			
		this.presentData();
	}
	
	public List<String> getAnniversaryTypes() {
		return atioc.read();
	}
	
	public void update(String t, String d, Boolean n) {
		updateType(t);
		updateDate(d);
		updateNotify(n);
	}
	
	public void updateType (String t) {
		record.setType(t);
	}
	
	public void updateDate(String d) {
		//TODO add error handling
		LocalDate ld = LocalDate.parse(d);
		record.setDate(ld);
	}
	
	public void updateNotify(Boolean n) {
		record.setNotify(n);
	}
	
	public void save() {
		ioClient.upsertSingle(personId, record);
	}
}
