package com.tigertown.conosco.presenters;
import java.util.*;
import com.tigertown.conosco.global.*;

public class PersonalListPresenter<T> extends PresenterBase<List<T>>
{
	IPersonalDataIo ioClient;
	
	public PersonalListPresenter(IView<List<T>> v, IPersonalDataIo io) {
		super(v);
		ioClient = io;
	}
	
	public void loadData(Integer id) {
		record = ioClient.read(id); //record is a list
		this.presentData();
	}

	@Override
	public void save()
	{
		// not needed for this view type
	}
}
