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
import java.time.*;

public class GiftIdeaEdit extends Activity implements IView<IGiftIdea> //remove implements from final mainactivity?
{
	private GiftIdeaPresenter presenter;

	EditText value;
	Button save;
	AlertDialog.Builder builder1;
	int personId;
	String oldValue;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		personId = getIntent().getExtras().getInt("personId");
		oldValue = getIntent().getExtras().getString("value");

		setContentView(R.layout.giftideaedit);

		value = (EditText)findViewById(R.id.giftvalue);
		save = (Button)findViewById(R.id.savegift);
		save.setOnClickListener(getClickListener());
		presenter = new GiftIdeaPresenter(this, personId, oldValue);
		builder1 = new AlertDialog.Builder(this);

		presenter.loadData(personId, oldValue);
	}

	private OnClickListener getClickListener() {
		return new OnClickListener() {
			public void onClick(View v) {
				try{
					presenter.update(value.getText().toString());
					presenter.save();
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
	public void load(IGiftIdea data) {
		value.setText(data.getValue());
	}
}
