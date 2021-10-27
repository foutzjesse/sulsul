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

public class AnniversaryEdit extends Activity implements IView<IAnniversary> //remove implements from final mainactivity?
{
	private AnniversaryPresenter presenter;

	Spinner spinner;
	ArrayAdapter<String> adapter;
	EditText date;
	CheckBox checkBox;
	Button button;
	AlertDialog.Builder builder1;
	TextView idThing;
	int personId;
	Integer recordId;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	
		personId = getIntent().getExtras().getInt("personId");
		recordId = getIntent().getExtras().getInt("recordId");
		
		setContentView(R.layout.anniversaryedit);
		presenter = new AnniversaryPresenter(this, personId);

		date = (EditText)findViewById(R.id.textThing);
		checkBox = (CheckBox)findViewById(R.id.chequebox);
		loadSpinner();
		button = (Button)findViewById(R.id.botan);
		button.setOnClickListener(getClickListener());
		builder1 = new AlertDialog.Builder(this);
		idThing = (TextView)findViewById(R.id.idThing);

		presenter.loadData(recordId);
	}

	private void loadSpinner() {
		spinner = (Spinner)findViewById(R.id.spinna);

		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, presenter.getAnniversaryTypes());
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
	}

	private OnClickListener getClickListener() {
		return new OnClickListener() {
			public void onClick(View v) {
				try{
					presenter.update(spinner.getSelectedItem().toString(), date.getText().toString(), checkBox.isChecked());
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

	private void setSpinner(String value) {
		if (value != null) {
			int pos = adapter.getPosition(value);
			spinner.setSelection(pos);
		}
	}

	@Override
	public void load(IAnniversary data) {
		date.setText(data.getDate() == null ? null : data.getDate().toString());
		this.loadSpinner();
		this.setSpinner(data.getType());
		checkBox.setChecked(data.getNotify());
	}
}
