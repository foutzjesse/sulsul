package com.tigertown.conosco.db.io;
import com.tigertown.conosco.dataModels.*;
import java.util.*;
import android.database.*;
import com.tigertown.conosco.global.modelInterfaces.*;
import android.database.sqlite.*;
import com.tigertown.conosco.global.*;
import com.tigertown.conosco.db.contracts.*;
import android.content.*;

public class AnniversariesPeepsIoClient
{
	private String table = AnniversariesPeeps.TABLE_NAME;
	private AnniversaryIoClient anniversaryClient = new AnniversaryIoClient();
	
	public List<IAnniversary> read(Integer personId) {
		List<IAnniversary> list = new ArrayList<IAnniversary>();

		String selectQuery = "SELECT * FROM " + table + " WHERE personid = " + personId;

		SQLiteDatabase db = Singletons.dbHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		if(cursor.moveToFirst()){
			do{
				list.add(anniversaryClient.read(cursor.getInt(1)));
			} while(cursor.moveToNext());
		}

		cursor.close();
		db.close();

		return list;
	}
	
	public static final void writeTest(int personId, int recordId) {
		SQLiteDatabase db = Singletons.dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
		
			values.put(AnniversariesPeeps.PERSON_ID, personId);
		values.put(AnniversariesPeeps.ANNIVERSARY_ID, recordId);

        db.insert(AnniversariesPeeps.TABLE_NAME, null, values);
        db.close();
	}
}
