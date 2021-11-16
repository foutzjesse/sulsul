package com.tigertown.conosco.views;
import android.app.*;
import android.os.*;
import android.widget.*;
import com.tigertown.conosco.presenters.*;
import com.tigertown.conosco.global.*;
import java.util.*;
import com.tigertown.conosco.global.modelInterfaces.*;
import com.tigertown.conosco.*;
import android.widget.AdapterView.*;
import android.content.*;
import android.view.*;
import com.tigertown.conosco.adapters.*;

public class PeepsList extends Activity implements IView<List<IPerson>>
{
	private PeepsListPresenter presenter;
	private List<IPerson> data;
	
	public ListView list;
	public ImageButton add;
	AlertDialog.Builder builder1;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		presenter = new PeepsListPresenter(this);
		setContentView(R.layout.personallist);
		
		list = (ListView) findViewById(R.id.items);
		add = (ImageButton) findViewById(R.id.additem);
		add.setOnClickListener(getAddListener());
		builder1 = new AlertDialog.Builder(this);

		presenter.loadData();
	}
	
	@Override
	protected void onRestart()
	{
		super.onRestart();
		presenter.loadData();
	}

	@Override
	public void load(List<IPerson> data)
	{
		this.data = data;
		list.setAdapter(new PersonAdapter(this, data));
		list.setOnItemClickListener(getEditListener());
	}
	
	private void openEditWindow(IPerson record) {
		Intent intent = new Intent(PeepsList.this, PersonEdit.class);
		intent.putExtra("personId", (record != null) ? record.getId() : null);
		
		startActivity(intent);

		//todo make it refresh when you go back to person view
	}

	private OnClickListener getAddListener() {
		return new OnClickListener() {
			public void onClick(View v) {
				try{
					openEditWindow((IPerson)null);
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
				openEditWindow((IPerson)av.getItemAtPosition(pos));
			}
		};
	}
}
