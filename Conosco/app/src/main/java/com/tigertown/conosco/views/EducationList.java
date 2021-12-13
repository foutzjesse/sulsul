package com.tigertown.conosco.views;
import com.tigertown.conosco.global.modelInterfaces.*;
import com.tigertown.conosco.presenters.*;
import com.tigertown.conosco.adapters.*;
import android.os.*;
import com.tigertown.conosco.global.*;
import android.content.*;
import com.tigertown.conosco.db.io.*;

public class EducationList extends PersonalList<IEducationDatum, EducationAdapter>
{
	/*@Override
	public PersonalListPresenter<IFave> getPresenter()
	{
		return new PersonalListPresenter<IFave>(this, new FavesPeepsIoClient());
	}
	
	@Override
	public Intent createIntent()
	{
		return new Intent(FaveList.this, FaveEdit.class);
	}

	@Override
	public void getAdditionalKeyInfo(Intent intent, IFave record)
	{
		intent.putExtra("recordId", (record == null) ? (Integer)null : record.getId());
	}

	@Override
	public FaveAdapter getAdapter()
	{
		return new FaveAdapter(this, data);
	}*/
}
