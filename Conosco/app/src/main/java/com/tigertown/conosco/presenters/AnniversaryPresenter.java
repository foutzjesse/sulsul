package com.tigertown.conosco.presenters;
import com.tigertown.conosco.global.*;
import java.time.*;
import com.tigertown.conosco.dataModels.*;
import com.tigertown.conosco.global.modelInterfaces.*;
import com.tigertown.conosco.db.io.*;
import java.util.*;

public class AnniversaryPresenter
{
	private Anniversary record;
	private IView<IAnniversary> view;
	private AnniversaryTypesIoClient atioc = new AnniversaryTypesIoClient();
	
	public AnniversaryPresenter(IView<IAnniversary> v) {
		this.view = v;
		record = new Anniversary("Wedding", "2013-05-04");
	}
	
	
	public void loadData() {
		view.load(record);
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
		//view.update(record.toString());
	}
	
	public void updateDate(String d) {
		//TODO add error handling
		LocalDate ld = LocalDate.parse(d);
		record.setDate(ld);
		//view.update(record.toString());
	}
	
	public void updateNotify(Boolean n) {
		record.setNotify(n);
		//view.update(record.toString());
	}
}
