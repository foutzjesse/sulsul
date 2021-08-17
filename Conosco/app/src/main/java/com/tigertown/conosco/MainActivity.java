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

public class MainActivity extends Activity //implements AdapterView.OnItemSelectedListener
{
	AnniversaryTypesIoClient atioc = new AnniversaryTypesIoClient();
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		Singletons.dbHelper = new DbHelper(this);
		setContentView(R.layout.main);
		
		List<String> strings = atioc.read();
		 
		TextView textThing = (TextView)findViewById(R.id.textThing);
		textThing.setText(strings.get(0));
	}
}
