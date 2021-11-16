package com.tigertown.conosco;
import android.app.*;
import android.os.*;
import com.tigertown.conosco.global.*;
import com.tigertown.conosco.db.*;
import android.widget.*;
import android.view.View.*;
import android.view.*;
import android.content.*;
import com.tigertown.conosco.views.*;

public class MainActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		Singletons.dbHelper = new DbHelper(this);
		//Singletons.dbHelper.AdHocDevPowersGo();
		
		setContentView(R.layout.main);
		
		Button buttonOne = findViewById(R.id.buttonOne);

		buttonOne.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, PeepsList.class);
				startActivity(intent);
			}
		});
	}
}
