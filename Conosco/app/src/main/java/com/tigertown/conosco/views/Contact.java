package com.tigertown.conosco.views;
import android.*;
import android.annotation.*;
import android.app.*;
import android.content.*;
import android.content.pm.*;
import android.database.*;
import android.net.*;
import android.os.*;
import android.provider.*;
import android.support.v4.app.*;
import android.support.v4.content.*;
import android.view.*;
import android.widget.*;

public class Contact extends Activity {
	private ImageView thumbnail;
	private TextView contactInfo;
	private Button button;
	private int contactId;
	
	private static final int CONTACT_PERMISSION_CODE = 1;
	private static final int CONTACT_PICK_CODE = 2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(com.tigertown.conosco.R.layout.contact);
		
		thumbnail = (ImageView)findViewById(com.tigertown.conosco.R.id.contactthumbnail);
		contactInfo = (TextView)findViewById(com.tigertown.conosco.R.id.contactInfo);
		button = (Button)findViewById(com.tigertown.conosco.R.id.clicktopick);
		
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(checkPermission()) {
					pickContactIntent();
				}
				else {
					requestPermission();
				}
			}
		});
	}
	
	private boolean checkPermission(){
		return ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) == (PackageManager.PERMISSION_GRANTED);
	}
	
	private void requestPermission(){
		String[] perm = {Manifest.permission.READ_CONTACTS};
		
		ActivityCompat.requestPermissions(this, perm, CONTACT_PERMISSION_CODE);
	}
	
	private void pickContactIntent(){
		Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
		
		startActivityForResult(intent, CONTACT_PICK_CODE);
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == CONTACT_PERMISSION_CODE){
			if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
				pickContactIntent();
			else
			{
				//denied
			}
		}
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK){
			if(requestCode == CONTACT_PICK_CODE){
				contactInfo.setText("");
				
				Cursor c1;
				
				Uri uri = data.getData();
				
				c1 = getContentResolver().query(uri, null, null, null, null);
				
				if (c1.moveToFirst()){
					String id = c1.getString(c1.getColumnIndex(ContactsContract.Contacts._ID));
					String name = c1.getString(c1.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
					String thumbnailUri = c1.getString(c1.getColumnIndex(ContactsContract.Contacts.PHOTO_THUMBNAIL_URI));
					//figure out how to open contacts app
					contactInfo.append("ID: "+id);
					contactInfo.append("Name: "+name);
					
					if (thumbnailUri != null)
						thumbnail.setImageURI(Uri.parse(thumbnailUri));
					//else
						//thumbnail.setImageResource(R.drawable.ic_person);
				}
				c1.close();
			}
		}
	}
}
