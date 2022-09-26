package com.tigertown.conosco.views;
import android.app.*;
import com.tigertown.conosco.global.*;
import com.tigertown.conosco.global.modelInterfaces.*;
import com.tigertown.conosco.presenters.*;
import android.os.*;
import com.tigertown.conosco.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;
import android.content.*;
import java.util.*;
import com.tigertown.conosco.adapters.*;
import android.widget.AdapterView.*;
import com.tigertown.conosco.dataModels.*;

public class PersonEdit extends Activity implements IView<IPerson>
{
	private PersonPresenter presenter;
	private Integer id;
	private ImageView imgthumbnail;
	AlertDialog.Builder builder1;
	
	public EditText howMet, hometown, residence,
		job, imageFile, interests, notes, name;
	public Button saveButton, giftsButton, anniversariesButton, favesButton, linkContactButton, educationButton, associationButton;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		id = getIntent().getExtras().getInt("personId");
		
		setContentView(R.layout.personedit);
		presenter = new PersonPresenter(this);

		//fields
		name = (EditText)findViewById(R.id.name);
		howMet = (EditText)findViewById(R.id.howmet);
		hometown = (EditText)findViewById(R.id.hometown);
		residence = (EditText)findViewById(R.id.residence);
		job = (EditText)findViewById(R.id.job);
		imageFile = (EditText)findViewById(R.id.imagefile);
		interests = (EditText)findViewById(R.id.interests);
		notes = (EditText)findViewById(R.id.personnotes);
		giftsButton = (Button)findViewById(R.id.gifts);
		giftsButton.setOnClickListener(getGiftsClickListener());
		anniversariesButton = (Button)findViewById(R.id.anniversariesList);
		anniversariesButton.setOnClickListener(getAnniversariesClickListener());
		favesButton = (Button)findViewById(R.id.faves);
		favesButton.setOnClickListener(getFavesClickListener());
		linkContactButton = (Button)findViewById(R.id.linkContact);
		linkContactButton.setOnClickListener(getContactClickListener());
		educationButton = (Button)findViewById(R.id.educationList);
		educationButton.setOnClickListener(getEducationClickListener());
		associationButton = (Button)findViewById(R.id.associationList);
		associationButton.setOnClickListener(getAssociationClickListener());
		saveButton = (Button)findViewById(R.id.saveperson);
		saveButton.setOnClickListener(getSaveClickListener());
		builder1 = new AlertDialog.Builder(this);
		imgthumbnail = (ImageView)findViewById(R.id.imgthumbnail);
		
		presenter.loadData(id);
	}

	@Override
	protected void onRestart()
	{
		super.onRestart();
		presenter.loadData(id);
	}
	
	@Override
	public void load(IPerson data)
	{
		name.setText(data.getName());
		howMet.setText(data.getHowMet());
		hometown.setText(data.getHometown());
		residence.setText(data.getResidence());
		job.setText(data.getJob());
		imageFile.setText(data.getImageFile());
		interests.setText(data.getInterests());
		notes.setText(data.getNotes());
	}
	
	private <T extends ArrayAdapter> void loadListView(ListView list, T adapter, OnItemClickListener listener) {
		list.setAdapter(adapter);
		list.setOnItemClickListener(listener);
	}
	
	
	private OnClickListener getSaveClickListener() {
		return new OnClickListener() {
			public void onClick(View v) {
				try{
					presenter.update(howMet.getText().toString(), 
						hometown.getText().toString(), 
						residence.getText().toString(), 
						job.getText().toString(), 
						imageFile.getText().toString(), 
						interests.getText().toString(), 
						notes.getText().toString(),
						name.getText().toString());
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
	
	private OnClickListener getGiftsClickListener() {
		return new OnClickListener() {
			public void onClick(View v) {
					Intent intent = new Intent(PersonEdit.this, GiftIdeaList.class);
					intent.putExtra("personId", (int)id);
					startActivity(intent);
			}
		};
	}
	
	private OnClickListener getAnniversariesClickListener() {
		return new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(PersonEdit.this, AnniversaryList.class);
				intent.putExtra("personId", (int)id);
				startActivity(intent);
			}
		};
	}
	
	private OnClickListener getFavesClickListener() {
		return new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(PersonEdit.this, FaveList.class);
				intent.putExtra("personId", (int)id);
				startActivity(intent);
			}
		};
	}
	
	private OnClickListener getContactClickListener() {
		return new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(PersonEdit.this, Contact.class);
				//intent.putExtra("personId", (int)id);
				startActivity(intent);
			}
		};
	}
	
	private OnClickListener getAssociationClickListener() {
		return new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(PersonEdit.this, AssociationList.class);
				intent.putExtra("personId", (int)id);
				startActivity(intent);
			}
		};
	}
	
	private OnClickListener getEducationClickListener() {
		return new OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(PersonEdit.this, EducationList.class);
				intent.putExtra("personId", (int)id);
				startActivity(intent);
			}
		};
	}
}
