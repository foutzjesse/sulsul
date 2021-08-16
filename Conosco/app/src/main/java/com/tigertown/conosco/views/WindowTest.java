package com.tigertown.conosco.views;
import android.support.v7.app.*;
import android.widget.*;
import android.widget.AdapterView.*;
import android.os.*;
import android.view.*;
import com.tigertown.conosco.*;
import com.tigertown.conosco.db.*;
import java.util.*;
import android.view.inputmethod.*;
import android.content.*;

public class WindowTest extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
	Spinner spinner; 
	EditText inputLabel;
	Button btnAdd;
	
	String table = "anniversarytypes";
	String column = "name";

	@Override
	public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState)
	{
		super.onCreate(savedInstanceState, persistentState);
		//add "New..." option
		
		setContentView(R.layout.windowtest);

        spinner = (Spinner) findViewById(R.id.spinner);
        inputLabel = (EditText) findViewById(R.id.inputLabel);
        btnAdd = (Button) findViewById(R.id.btnAdd);

        spinner.setOnItemSelectedListener(this);

        loadSpinnerData();

        btnAdd.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					String label = inputLabel.getText().toString();

					if(label.trim().length() > 0){
						DbHelper db = new DbHelper(getApplicationContext());

						db.insertSingle(table, column, label);

						inputLabel.setText("");

						InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
						imm.hideSoftInputFromWindow(inputLabel.getWindowToken(), 0);

						loadSpinnerData();
					} else {
						Toast.makeText(getApplicationContext(), "Please Enter Label Name", Toast.LENGTH_SHORT).show();
					}
				}
			});
		
	}
	
	private void loadSpinnerData(){
        DbHelper db = new DbHelper(getApplicationContext());
        List<String> labels = db.read(table);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, labels);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String label = parent.getItemAtPosition(position).toString();

        Toast.makeText(parent.getContext(), "You Selected: "+label, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
