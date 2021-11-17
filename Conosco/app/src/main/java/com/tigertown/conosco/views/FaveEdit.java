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

public class FaveEdit extends Activity implements IView<IFave>
{
	private FavePresenter presenter;

	Spinner type;
	ArrayAdapter<String> adapter;
	EditText value;
	Button saveButton;
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
		
		setContentView(R.layout.faveedit);
		presenter = new FavePresenter(this, personId);

		value = (EditText)findViewById(R.id.faveValue);
		loadSpinner();
		saveButton = (Button)findViewById(R.id.saveFaveButton);
		saveButton.setOnClickListener(getClickListener());
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
		type = (Spinner)findViewById(R.id.faveTypes);
		List<String> data = presenter.getFaveTypes();
		data.add(Singletons.NEW);
		adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		type.setOnItemSelectedListener(getNewFaveTypeListener());
        type.setAdapter(adapter);
	}

	private OnClickListener getClickListener() {
		return new OnClickListener() {
			public void onClick(View v) {
				try{
					presenter.update(type.getSelectedItem().toString(), value.getText().toString());
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
			type.setSelection(pos);
		}
	}

	@Override
	public void load(IFave data) {
		value.setText(data.getValue());
		this.loadSpinner();
		this.setSpinner(data.getType());
	}
	
	private OnItemSelectedListener getNewFaveTypeListener() {
		return new OnItemSelectedListener(){
			public void onItemSelected(AdapterView<?> av, View junk, int pos, long junque) {
				String item = (String)av.getItemAtPosition(pos);
				
				if(item == Singletons.NEW){
					Intent intent = new Intent(FaveEdit.this, FaveTypeEdit.class);
					startActivity(intent);
				}
			}
			
			public void onNothingSelected(AdapterView<?> av){
				//do nothing
			}
		};
	}
}
