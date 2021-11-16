package com.tigertown.conosco.presenters;
import com.tigertown.conosco.global.*;
import com.tigertown.conosco.global.modelInterfaces.*;
import com.tigertown.conosco.db.io.*;
import com.tigertown.conosco.dataModels.*;

public class GiftIdeaPresenter extends PresenterBase<IGiftIdea>
{
	private GiftIdeaIoClient ioClient = new GiftIdeaIoClient();
	private int id;
	private String oldValue;
	
	public GiftIdeaPresenter(IView<IGiftIdea> v, int id, String value)
	{
		super(v);
		this.id = id;
		this.oldValue = value;
	}
	
	public void loadData(Integer id, String value) {
		record = new GiftIdea(id, value); //use ioClient.load when record becomes more complex
		
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
