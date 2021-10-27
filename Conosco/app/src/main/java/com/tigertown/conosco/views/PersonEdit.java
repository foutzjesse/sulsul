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
	AlertDialog.Builder builder1;
	
	public EditText howMet, hometown, residence,
		job, imageFile, interests, notes, name;
	public ListView anniversaries, giftIdeas;
	public Button saveButton;
	public ImageButton addAnniversary, addGiftIdea;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
//AnniversariesPeepsIoClient.writeTest(1,1);
		id = getIntent().getExtras().getInt("id");
		
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
		anniversaries = (ListView) findViewById(R.id.anniversaries);
		addAnniversary = (ImageButton) findViewById(R.id.addAnniversary);
		addAnniversary.setOnClickListener(getAddAnniversaryClickListener());
		giftIdeas = (ListView) findViewById(R.id.giftIdeas);
		addGiftIdea = (ImageButton) findViewById(R.id.addGiftIdea);
		addGiftIdea.setOnClickListener(getAddGiftIdeaClickListener());
		saveButton = (Button)findViewById(R.id.saveperson);
		saveButton.setOnClickListener(getSaveClickListener());
		builder1 = new AlertDialog.Builder(this);
		
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
		
		loadListView(anniversaries, new AnniversaryAdapter(this, data.getAnniversaries()), getEditAnniversaryListener());
		loadListView(giftIdeas, new GiftIdeaAdapter(this, data.getGiftIdeas()), getEditGiftIdeaListener());
		
		//AnniversaryAdapter anniversaryAdapter = new AnniversaryAdapter(this, data.getAnniversaries());
		//anniversaries.setAdapter(anniversaryAdapter);
		//anniversaries.setOnItemClickListener(getEditAnniversaryListener());
		
		//GiftIdeaAdapter giftAdapter = new GiftIdeaAdapter(this, data.getGiftIdeas());
		//giftIdeas.setAdapter(giftAdapter);
		//giftIdeas.setOnItemClickListener(getEditGiftIdeaListener());
	}
	
	private <T extends ArrayAdapter> void loadListView(ListView list, T adapter, OnClickListener listener) {
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
	
	private OnClickListener getAddGiftIdeaClickListener() {
		return new OnClickListener() {
			public void onClick(View v) {
				try{
					Intent intent = new Intent(PersonEdit.this, GiftIdeaEdit.class);
					intent.putExtra("personId", id);
					intent.putExtra("value", (String)null);
					startActivity(intent);
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
	
	private OnItemClickListener getEditGiftIdeaListener() {
		return new OnItemClickListener(){
			public void onItemClick(AdapterView<?> av, View junk, int pos, long junque) {
				Intent intent = new Intent(PersonEdit.this, GiftIdeaEdit.class);
				IGiftIdea record = (IGiftIdea) av.getItemAtPosition(pos);
				//this is literally the whole record
				intent.putExtra("personId", id);
				intent.putExtra("value", record.getValue());
				startActivity(intent);
				
				//todo make it refresh when you go back to person view
			}
		};
	}
	
	private OnClickListener getAddAnniversaryClickListener() {
		return new OnClickListener() {
			public void onClick(View v) {
				try{
					Intent intent = new Intent(PersonEdit.this, AnniversaryEdit.class);
					intent.putExtra("personId", id);
					intent.putExtra("recordId", (Integer) null);
					startActivity(intent);
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

	private OnItemClickListener getEditAnniversaryListener() {
		return new OnItemClickListener(){
			public void onItemClick(AdapterView<?> av, View junk, int pos, long junque) {
				Intent intent = new Intent(PersonEdit.this, AnniversaryEdit.class);
				IAnniversary record = (IAnniversary) av.getItemAtPosition(pos);
				//todo make it pass the whole record?
				intent.putExtra("personId", id);
				intent.putExtra("recordId", record.getId());
				startActivity(intent);

				//todo make it refresh when you go back to person view
			}
		};
	}
}
