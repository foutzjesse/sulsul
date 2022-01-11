package com.tigertown.conosco.adapters;
import android.widget.*;
import com.tigertown.conosco.global.modelInterfaces.*;
import android.content.*;
import java.util.*;
import android.view.*;
import com.tigertown.conosco.*;

public class EducationAdapter extends ArrayAdapter<IEducationDatum>
{
	public EducationAdapter(Context c, List<IEducationDatum> data) {
		super(c, 0, data);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		IEducationDatum record = getItem(position);

		//check if view is being reused. otherwise inflate.
		//probably not necessary for this small list, but i don't really know.
		if(convertView == null)
			convertView = LayoutInflater.from(getContext()).inflate(R.layout.edlistitem, parent, false);

		TextView summary = (TextView) convertView.findViewById(R.id.edsummary);

		summary.setText(composeSummary(record));

		return convertView;
	}
    
    private String composeSummary (IEducationDatum record)
    {
        String result = "";
        
        if (record.getSchool() != null)
            result += record.getSchool();
        
        if (record.getYear() != null) {
            String year = String.valueOf(record.getYear());
            result += " " + ((year.length() == 4) ? "'" + year.substring(year.length() - 2) : year);
        }
        
        if ((result == "" || result.startsWith(" ")) && record.getMajor() != null)
            result += " " + record.getMajor();
        
        if (result == "")
            result = (record.getDegree()) != null ? record.getDegree() : record.getNotes();
        
        return result.trim();
    }
}
