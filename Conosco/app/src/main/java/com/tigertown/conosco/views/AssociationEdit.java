package com.tigertown.conosco.views;

import android.app.*;
import android.os.*;
import android.content.*;
import android.widget.*;
import android.view.*;
import com.tigertown.conosco.global.*;
import android.widget.AdapterView.*;
import com.tigertown.conosco.presenters.*;
import com.tigertown.conosco.global.modelInterfaces.*;
import com.tigertown.conosco.*;
import java.util.*;

public class AssociationEdit extends Activity implements IView<IAssociation>
{
	private AssociationPresenter presenter;

	EditText value;
	Button save;
	ImageButton delete;
	AlertDialog.Builder builder1;
	int personId;
	String oldValue;


	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		personId = getIntent().getExtras().getInt("personId");
		oldValue = getIntent().getExtras().getString("value");

		setContentView(R.layout.associationedit);

		value = (EditText)findViewById(R.id.value);
		save = (Button)findViewById(R.id.save);
		save.setOnClickListener(getSaveListener());
		delete = (ImageButton)findViewById(R.id.delete);
		delete.setOnClickListener(getDeleteListener());
		presenter = new AssociationPresenter(this, personId, oldValue);
		builder1 = new AlertDialog.Builder(this);

		presenter.loadData(personId, oldValue);
	}

	private OnClickListener getDeleteListener() {
		return new OnClickListener() {
			public void onClick(View v) {
				try{
					presenter.delete();
					finish();
				}
				catch (Exception e) {
					builder1.setMessage(e.getMessage() + e.getClass());
					builder1.setCancelable(true); 
					builder1.setPositiveButton( "Yes", new DialogInterface.OnClickListener() { public void onClick(DialogInterface dialog, int id) { dialog.cancel(); } }); 
					builder1.setNegativeButton( "No", new DialogInterface.OnClickListener() { public void onClick(DialogInterface dialog, int id) { dialog.cancel(); } }); 
					AlertDialog alert11 = builder1.create(); 
					alert11.show();
				}
			}
		};
	}

	private OnClickListener getSaveListener() {
		return new OnClickListener() {
			public void onClick(View v) {
				try{
					presenter.update(value.getText().toString());
					presenter.save();
					finish();
				}
				catch (Exception e) {
					builder1.setMessage(e.getMessage() + e.getClass());
					builder1.setCancelable(true); 
					builder1.setPositiveButton( "Yes", new DialogInterface.OnClickListener() { public void onClick(DialogInterface dialog, int id) { dialog.cancel(); } }); 
					builder1.setNegativeButton( "No", new DialogInterface.OnClickListener() { public void onClick(DialogInterface dialog, int id) { dialog.cancel(); } }); 
					AlertDialog alert11 = builder1.create(); 
					alert11.show();
				}
			}
		};
	}

	@Override
	public void load(IAssociation data) {
		value.setText(data.getValue());
	}
}
