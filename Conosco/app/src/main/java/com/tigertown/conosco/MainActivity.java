package com.tigertown.conosco;

import android.app.*;
import android.os.*;
import com.tigertown.conosco.db.*;
import android.database.sqlite.*;
import android.content.*;
import com.tigertown.conosco.views.*;
import android.widget.*;
import android.view.View.*;
import java.util.*;
import android.view.*;
import android.view.inputmethod.*;
import com.tigertown.conosco.db.contracts.*;
import com.tigertown.conosco.global.*;
import com.tigertown.conosco.db.io.*;
import java.time.*;
import android.widget.AdapterView.*;
import com.tigertown.conosco.presenters.*;
import com.tigertown.conosco.global.modelInterfaces.*;

public class MainActivity extends Activity implements IView<IAnniversary> //remove implements from final mainactivity?
{
	private AnniversaryPresenter presenter;
	
	Spinner spinner;
	ArrayAdapter<String> adapter;
	EditText textThing;
	CheckBox checkBox;
	Button button;
	AlertDialog.Builder builder1;
	TextView idThing;
	Integer id = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		Singletons.dbHelper = new DbHelper(this);
		
		setContentView(R.layout.main);
		presenter = new AnniversaryPresenter(this);
		 
		textThing = (EditText)findViewById(R.id.textThing);
		checkBox = (CheckBox)findViewById(R.id.chequebox);
		loadSpinner();
		button = (Button)findViewById(R.id.botan);
		button.setOnClickListener(getClickListener());
		builder1 = new AlertDialog.Builder(this);
		idThing = (TextView)findViewById(R.id.idThing);
		
		presenter.loadData(id);
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
					presenter.update(spinner.getSelectedItem().toString(), textThing.getText().toString(), checkBox.isChecked());
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
			builder1.setMessage(value + adapter.getCount() + pos);
			builder1.setCancelable(true); 
			builder1.setPositiveButton( "Yes", new DialogInterface.OnClickListener() { public void onClick(DialogInterface dialog, int id) { dialog.cancel(); } }); 
			builder1.setNegativeButton( "No", new DialogInterface.OnClickListener() { public void onClick(DialogInterface dialog, int id) { dialog.cancel(); } }); 
			AlertDialog alert11 = builder1.create(); 
			alert11.show();
			spinner.setSelection(pos);
		}
	}
	
	@Override
	public void load(IAnniversary data) {
		textThing.setText(data.getDate().toString());
		this.loadSpinner();
		this.setSpinner(data.getType());
		checkBox.setChecked(data.getNotify());
		String poop = presenter.getOneId();
		if (poop == null)
			poop = "null";
		
		idThing.setText(poop);
	}
	
	public void save() {
		try{
			Toast.makeText(this, textThing.getText().toString(), 1000);
		//presenter.update(spinner.getSelectedItem().toString(), textThing.getText().toString(), checkBox.isChecked());
		}
		catch (Exception e) {
			
		}
	}
	
	
	
	
	
}
