package com.tigertown.conosco.db.external;
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
import com.tigertown.conosco.db.io.*;
public class ContactProvider {
    public Uri getContactImage(string id)
    {
        Uri result;
        
        // Build the Uri to query to table
        Uri queryUri = Uri.withAppendedPath(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, id); //Uri.encode(id) instead?

        // Query the table
        Cursor c1 = managedQuery(queryUri, null, null, null, null);

        //get the image uri
        if (c1.moveToFirst())
            result = Uri.parse(c1.getString(c1.getColumnIndex(ContactsContract.Contacts.PHOTO_THUMBNAIL_URI)));
    }
}
