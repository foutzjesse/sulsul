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
	@Override
	public PersonalListPresenter<IEducationDatum> getPresenter()
	{
		return new PersonalListPresenter<IEducationDatum>(this, new EducationIoClient());
	}
	
	@Override
	public Intent createIntent()
	{
		return new Intent(EducationList.this, EducationEdit.class);
	}

	@Override
	public void getAdditionalKeyInfo(Intent intent, IEducationDatum record)
	{
		intent.putExtra("id", (record == null) ? (Integer)null : record.getId());
		intent.putExtra("personId", this.id);// (record == null) ? (Integer)null : record.getPersonId());
	}

	@Override
	public EducationAdapter getAdapter()
	{
		return new EducationAdapter(this, data);
	}
}
