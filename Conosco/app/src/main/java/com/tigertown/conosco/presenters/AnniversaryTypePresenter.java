package com.tigertown.conosco.presenters;
import com.tigertown.conosco.db.io.*;
import com.tigertown.conosco.db.contracts.*;
import com.tigertown.conosco.global.*;

public class AnniversaryTypePresenter extends PresenterBase<String>
{
	AnniversaryTypesIoClient ioClient = new AnniversaryTypesIoClient();

	public AnniversaryTypePresenter(IView<String> v) {
		super(v);
	}
	
	public void loadData(Integer id) {
		record = (String)null;
		this.presentData();
	}
	
	public void update(String s) {
		record = s;
	}

	@Override
	public void save()
	{
		ioClient.insertSingle(AnniversaryTypes.NAME, record);
	}
}
