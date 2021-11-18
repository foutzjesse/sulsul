package com.tigertown.conosco.views;

public class Contact extends AppCompatActivity {
	private ImageView thumbnail;
	private TextView contactInfo;
	private Button button;
	
	private static final int CONTACT_PERMISSION_CODE = 1;
	private static final int CONTACT_PICK_CODE = 2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact);
		
		thumbnail = findViewById(R.id.thumbnail);
		contactInfo = findViewById(R.id.contactInfo);
		button = findViewById(R.id.clicktopick);
		
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onCLick(View v) {
				if(checkContactPermission()) {
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
		String[] perm = (Manifest.permission.READ_CONTACTS);
		
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
					String id = c1.getString(c1.getColumnIndex(ContactsContract.Contacts.ID));
					String name = c1.getString(c1.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
					String thumbnailUri = c1.getString(c1.getColumnIndex(ContactsContract.Contacts.PHOTO_THUMBNAIL_URI));
					//figure out how to open contacts app
					contactInfo.append("ID: "+id);
					contactInfo.append("Name: "+name);
					
					if (thumbnailUri != null)
						thumbnail.setImageURI(Uri.parse(thumbnailUri));
					else
						thumbnail.setImageResource(R.drawable.ic_person);
				}
				c1.close();
			}
		}
	}
}
