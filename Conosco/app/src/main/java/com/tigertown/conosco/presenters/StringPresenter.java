package com.tigertown.conosco.presenters;
import com.tigertown.conosco.db.io.*;
import com.tigertown.conosco.db.contracts.*;
import com.tigertown.conosco.global.*;

public abstract class StringPresenter<T extends SingleColumnIoClient> extends PresenterBase<String>
{
	private T ioClient;
	private String nameColumn;

	public StringPresenter(IView<String> v, T io, String c) {
		super(v);
		this.ioClient = io;
		this.nameColumn = c;
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
		ioClient.insertSingle(nameColumn, record);
	}
}
