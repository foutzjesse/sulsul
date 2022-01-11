package com.tigertown.conosco.views;
import com.tigertown.conosco.presenters.*;
import android.widget.*;
import android.app.*;
import com.tigertown.conosco.global.*;
import android.os.*;
import com.tigertown.conosco.*;
import android.view.View.*;
import android.view.*;
import android.content.*;
import android.widget.AdapterView.*;
import java.util.*;

public abstract class PersonalList<T1, T2 extends ArrayAdapter> extends Activity implements IView<List<T1>>
{
	private PersonalListPresenter<T1> presenter;
	protected Integer id;
	protected List<T1> data;
	
	public ListView list;
	public ImageButton add;
	AlertDialog.Builder builder1;
	
	public abstract PersonalListPresenter<T1> getPresenter();

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		presenter = getPresenter();
		Bundle extras = getIntent().getExtras();
		id = extras.getInt("personId");
		setContentView(R.layout.personallist);
		
		//fields
		list = (ListView) findViewById(R.id.items);
		add = (ImageButton) findViewById(R.id.additem);
		add.setOnClickListener(getAddListener());
		builder1 = new AlertDialog.Builder(this);
		
		presenter.loadData(id);
	}

	@Override
	protected void onRestart()
	{
		super.onRestart();
		presenter.loadData(id);
	}
	
	public abstract T2 getAdapter();

	@Override
	public void load(List<T1> data)
	{
		this.data = data;
		list.setAdapter(getAdapter());
		list.setOnItemClickListener(getEditListener());
	}

	public abstract Intent createIntent();
	public abstract void getAdditionalKeyInfo(Intent intent, T1 record);

	private void openEditWindow(T1 record) {
		Intent intent = createIntent();

		intent.putExtra("personId", id);
		getAdditionalKeyInfo(intent, record);

		startActivity(intent);

		//todo make it refresh when you go back to person view
	}

	private OnClickListener getAddListener() {
		return new OnClickListener() {
			public void onClick(View v) {
				try{
					openEditWindow((T1)null);
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

	private OnItemClickListener getEditListener() {
		return new OnItemClickListener(){
			public void onItemClick(AdapterView<?> av, View junk, int pos, long junque) {
				openEditWindow((T1)av.getItemAtPosition(pos));
			}
		};
	}
}
