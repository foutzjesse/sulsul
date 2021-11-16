package com.tigertown.conosco.views;
import com.tigertown.conosco.global.modelInterfaces.*;
import com.tigertown.conosco.presenters.*;
import com.tigertown.conosco.adapters.*;
import android.os.*;
import com.tigertown.conosco.global.*;
import android.content.*;
import com.tigertown.conosco.db.io.*;

public class GiftIdeaList extends PersonalList<IGiftIdea, GiftIdeaAdapter>
{
	@Override
	public PersonalListPresenter<IGiftIdea> getPresenter()
	{
		return new PersonalListPresenter<IGiftIdea>(this, new GiftIdeaIoClient());
	}
	
	@Override
	public Intent createIntent()
	{
		return new Intent(GiftIdeaList.this, GiftIdeaEdit.class);
	}

	@Override
	public void getAdditionalKeyInfo(Intent intent, IGiftIdea record)
	{
		intent.putExtra("value", (record == null) ? (String)null : record.getValue());
	}

	@Override
	public GiftIdeaAdapter getAdapter()
	{
		return new GiftIdeaAdapter(this, data);
	}
}
