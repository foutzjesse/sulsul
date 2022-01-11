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

public class EducationEdit extends Activity implements IView<IEducationDatum>
{
    Integer id, personId;
    
    EditText school, degree, major, notes, year;
    Button saveButton;
    private EducationPresenter presenter;
	ArrayAdapter<String> adapter;
	AlertDialog.Builder builder1;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	
		personId = getIntent().getExtras().getInt("personId");
		id = getIntent().getExtras().getInt("id");
		
		setContentView(R.layout.educationedit);
		presenter = new EducationPresenter(this, id, personId);

		school = (EditText)findViewById(R.id.school);
		degree = (EditText)findViewById(R.id.degree);
		major = (EditText)findViewById(R.id.major);
		notes = (EditText)findViewById(R.id.notes);
		year = (EditText)findViewById(R.id.gradYear);
		saveButton = (Button)findViewById(R.id.save);
		saveButton.setOnClickListener(getClickListener());
		builder1 = new AlertDialog.Builder(this);

		presenter.loadData(id);
	}

	@Override
	protected void onRestart()
	{
		super.onRestart();
	}

	private OnClickListener getClickListener() {
		return new OnClickListener() {
			public void onClick(View v) {
				try{
					presenter.update(school.getText().toString(), year.getText().toString(), degree.getText().toString(), major.getText().toString(), notes.getText().toString());
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
	public void load(IEducationDatum data) {
		school.setText(data.getSchool());
		
		String y = String.valueOf(data.getYear());
		year.setText((y == "null") ? null : y);
		degree.setText(data.getDegree());
		major.setText(data.getMajor());
		notes.setText(data.getNotes());
	}
}
