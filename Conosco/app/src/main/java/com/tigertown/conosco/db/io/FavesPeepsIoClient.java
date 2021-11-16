package com.tigertown.conosco.db.io;
import com.tigertown.conosco.dataModels.*;
import java.util.*;
import android.database.*;
import com.tigertown.conosco.global.modelInterfaces.*;
import android.database.sqlite.*;
import com.tigertown.conosco.global.*;
import com.tigertown.conosco.db.contracts.*;
import android.content.*;

public class FavesPeepsIoClient implements IPersonalDataIo<IFave>
{
	private String table = FavesPeeps.TABLE_NAME;
	private FaveIoClient faveClient = new FaveIoClient();
	
	public List<IFave> read(int personId) {
		List<IFave> list = new ArrayList<IFave>();

		String selectQuery = "SELECT * FROM " + table + " WHERE personid = " + personId;

		SQLiteDatabase db = Singletons.dbHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		if(cursor.moveToFirst()){
			do{
				list.add(faveClient.readbyId(cursor.getInt(1)));
			} while(cursor.moveToNext());
		}

		cursor.close();
		db.close();

		return list;
	}
	
	/*public static final void writeTest(int personId, int recordId) {
		SQLiteDatabase db = Singletons.dbHelper.getWritableDatabase();
        	ContentValues values = new ContentValues();
		values.put(FavesPeeps.PERSON_ID, personId);
		values.put(FavesPeeps.FAVE_ID, recordId);
	        db.insert(FavesPeeps.TABLE_NAME, null, values);
        	db.close();
	}*/
}
