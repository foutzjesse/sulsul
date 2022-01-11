package com.tigertown.conosco.views;
import com.tigertown.conosco.global.modelInterfaces.*;
import com.tigertown.conosco.presenters.*;
import com.tigertown.conosco.adapters.*;
import android.os.*;
import com.tigertown.conosco.global.*;
import android.content.*;
import com.tigertown.conosco.db.io.*;

public class AssociationList extends PersonalList<IAssociation, AssociationAdapter>
{
	@Override
	public PersonalListPresenter<IAssociation> getPresenter()
	{
		return new PersonalListPresenter<IAssociation>(this, new AssociationIoClient());
	}
	
	@Override
	public Intent createIntent()
	{
		return new Intent(AssociationList.this, AssociationEdit.class);
	}

	@Override
	public void getAdditionalKeyInfo(Intent intent, IAssociation record)
	{
		intent.putExtra("value", (record == null) ? (String)null : record.getValue());
	}

	@Override
	public AssociationAdapter getAdapter()
	{
		return new AssociationAdapter(this, data);
	}
}
