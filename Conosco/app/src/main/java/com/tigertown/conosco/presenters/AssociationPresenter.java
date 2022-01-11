package com.tigertown.conosco.presenters;
import com.tigertown.conosco.global.*;
import com.tigertown.conosco.dataModels.*;
import com.tigertown.conosco.global.modelInterfaces.*;
import com.tigertown.conosco.db.io.*;
import java.util.*;

public class AssociationPresenter extends PresenterBase<IAssociation>
{
	private AssociationIoClient ioClient = new AssociationIoClient();
	private int personId;
	private String oldValue;
	
	public AssociationPresenter(IView<IAssociation> v, int id, String value)
	{
		super(v);
		this.personId = id;
		this.oldValue = value;
	}

	public void loadData(Integer id, String value) {
		record = new Association(id, value);

		this.presentData();
	}

	public void update(String value) {
		record.setValue(value);
	}

	public void save() {
		ioClient.upsertSingle(oldValue, record);
	}

	public void delete() {
		ioClient.deleteSingle(record);
	}
}
