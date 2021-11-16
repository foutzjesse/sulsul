package com.tigertown.conosco.views;
import com.tigertown.conosco.global.modelInterfaces.*;
import com.tigertown.conosco.presenters.*;
import com.tigertown.conosco.adapters.*;
import android.os.*;
import com.tigertown.conosco.global.*;
import android.content.*;
import com.tigertown.conosco.db.io.*;

public class AnniversaryList extends PersonalList<IAnniversary, AnniversaryAdapter>
{
	@Override
	public PersonalListPresenter<IAnniversary> getPresenter()
	{
		return new PersonalListPresenter<IAnniversary>(this, new AnniversariesPeepsIoClient());
	}
	
	@Override
	public Intent createIntent()
	{
		return new Intent(AnniversaryList.this, AnniversaryEdit.class);
	}

	@Override
	public void getAdditionalKeyInfo(Intent intent, IAnniversary record)
	{
		intent.putExtra("recordId", (record == null) ? (Integer)null : record.getId());
	}

	@Override
	public AnniversaryAdapter getAdapter()
	{
		return new AnniversaryAdapter(this, data);
	}
}
