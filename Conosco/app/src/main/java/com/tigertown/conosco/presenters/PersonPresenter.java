package com.tigertown.conosco.presenters;
import com.tigertown.conosco.global.modelInterfaces.*;
import com.tigertown.conosco.global.*;
import com.tigertown.conosco.db.io.*;

public class PersonPresenter extends PresenterBase<IPerson>
{
	private PersonIoClient ioClient = new PersonIoClient();
	
	public PersonPresenter(IView<IPerson> v) {
		super(v);
	}

	public void loadData(Integer id) {
		record = ioClient.read(id);
		this.presentData();
	}

	public void update(String h, String ht, String r, String j, String im, String i, String n, String name) {
		record.setName(name);
		record.setHowMet(h);
		record.setHometown(ht);
		record.setResidence(r);
		record.setJob(j);
		record.setImageFile(im);
		record.setInterests(i);
		record.setNotes(n);
	}

	public void save() {
		ioClient.upsertSingle(record);
	}
}
