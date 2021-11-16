package com.tigertown.conosco.presenters;
import java.util.*;
import com.tigertown.conosco.global.modelInterfaces.*;
import com.tigertown.conosco.db.io.*;
import com.tigertown.conosco.global.*;

public class PeepsListPresenter extends PresenterBase<List<IPerson>>
{
	PersonIoClient ioClient = new PersonIoClient();
	
	public PeepsListPresenter(IView<List<IPerson>> v) {
		super(v);
	}
	
	public void loadData() {
		record = ioClient.read();
		this.presentData();
	}
	
	@Override
	public void save()
	{
		// not needed for this view type
	}
}
