package com.tigertown.conosco.views;
import android.app.*;
import com.tigertown.conosco.global.*;
import android.widget.*;
import com.tigertown.conosco.presenters.*;
import android.os.*;
import com.tigertown.conosco.*;
import android.view.View.*;
import android.view.*;

public abstract class StringEdit<T extends PresenterBase> extends Activity implements IView<String>
{
	private T presenter;
	
	public StringEdit(T p) {
		this.presenter = p;
	}
	
	EditText text;
	Button save;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stringedit);

		text = (EditText)findViewById(R.id.text);
		save = (Button)findViewById(R.id.savestring);
		save.setOnClickListener(getSaveListener());
		presenter = new AnniversaryTypePresenter(this);
	}

	@Override
	public void load(String data)
	{
		//currently write-only
	}
	
	private OnClickListener getSaveListener() {
		return new OnClickListener() {
			public void onClick(View v) {
				presenter.update(text.getText().toString());
				presenter.save();
				finish();
				//TODO add message for nulls and dupes
			}
		};
	}
}
