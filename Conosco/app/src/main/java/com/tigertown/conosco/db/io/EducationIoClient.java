package com.tigertown.conosco.db.io;
import com.tigertown.conosco.dataModels.*;
import com.tigertown.conosco.global.modelInterfaces.*;
import android.database.*;
import com.tigertown.conosco.db.contracts.*;
import java.util.*;
import android.database.sqlite.*;
import com.tigertown.conosco.global.*;

public class EducationIoClient extends IoClientBase<IEducationDatum> implements IPersonalDataIo<IEducationDatum>
{
	public EducationIoClient() {
		super(EducationData.TABLE_NAME);
	}
	
	public List<IEducationDatum> read(int id)
	{
		List<IEducationDatum> list = new ArrayList<IEducationDatum>();

		String selectQuery = "SELECT * FROM " + super.table + " WHERE " + EducationData.PERSON_ID + " = " + id;

		SQLiteDatabase db = Singletons.dbHelper.getReadableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		if(cursor.moveToFirst()){
			do{
				list.add(convertRow(cursor));
			} while(cursor.moveToNext());
		}

		cursor.close();
		db.close();
		
		return list;
	}

	@Override
	public IEducationDatum convertRow(Cursor c)
	{
        Integer id = getInt(c, EducationData.ID);
        int personId = getInt(c, EducationData.PERSON_ID);
        String school = getString(c, EducationData.SCHOOL);
        Integer year = getInt(c, EducationData.YEAR);
        String degree = getString(c, EducationData.DEGREE);
        String major = getString(c, EducationData.MAJOR);
        String notes = getString(c, EducationData.NOTES);
        
        return new EducationDatum(id, personId, school, year, degree, major, notes);
	}
	
	public void insertSingle(IEducationDatum record) {
		HashMap<String, String> columns = new HashMap<String, String>();
		
		columns.put(EducationData.PERSON_ID, sqlize(record.getPersonId()));
		columns.put(EducationData.SCHOOL, record.getSchool());
        columns.put(EducationData.YEAR, sqlize(record.getYear()));
        columns.put(EducationData.DEGREE, record.getDegree());
        columns.put(EducationData.MAJOR, record.getMajor());
        columns.put(EducationData.NOTES, record.getNotes());
		
		insertSingle(columns);
	}
	
	public void upsertSingle(IEducationDatum record) {
        if (record.getId() == null)
			insertSingle(record);
		else {
			updateSingle(record);
		}
	}
	
	public void deleteSingle(IEducationDatum record)
	{
		deleteSingle(new HashMap<String, String>(Map.of(EducationData.ID, String.valueOf(record.getId()))));
	}

	public void updateSingle(IEducationDatum record)
	{
		HashMap<String, String> columns = new HashMap<String, String>();
		
        columns.put(EducationData.ID, sqlize(record.getId()));
		columns.put(EducationData.PERSON_ID, sqlize(record.getPersonId()));
		columns.put(EducationData.SCHOOL, record.getSchool());
        columns.put(EducationData.YEAR, sqlize(record.getYear()));
        columns.put(EducationData.DEGREE, record.getDegree());
        columns.put(EducationData.MAJOR, record.getMajor());
        columns.put(EducationData.NOTES, record.getNotes());
		
		updateSingle(columns);
	}

	@Override
	public String getUpdateWhereClause()
	{
		return EducationData.ID + " = ?";
	}

	@Override
	public String[] getUpdateWhereClauseValues(HashMap<String, String> data)
	{
		return new String[]{data.get("id")};
	}

	@Override
	public String getDeleteWhereClause(HashMap<String, String> data)
	{
		return String.format("%s = %s", EducationData.ID, data.get("id"));
	}
}
