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
import java.util.*;

public class AnniversaryEdit extends Activity implements IView<IAnniversary>
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

	@Override
	protected void onRestart()
	{
		super.onRestart();
		loadSpinner();
	}

	private void loadSpinner() {
		spinner = (Spinner)findViewById(R.id.spinna);
		List<String> data = presenter.getAnniversaryTypes();
		data.add(Singletons.NEW);
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setOnItemSelectedListener(getNewAnniversaryTypeListener());
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
	
	private OnItemSelectedListener getNewAnniversaryTypeListener() {
		return new OnItemSelectedListener(){
			public void onItemSelected(AdapterView<?> av, View junk, int pos, long junque) {
				String item = (String)av.getItemAtPosition(pos);
				
				if(item == Singletons.NEW){
					Intent intent = new Intent(AnniversaryEdit.this, AnniversaryTypeEdit.class);
					startActivity(intent);
				}
			}
			
			public void onNothingSelected(AdapterView<?> av){
				//do nothing
			}
		};
	}
}
