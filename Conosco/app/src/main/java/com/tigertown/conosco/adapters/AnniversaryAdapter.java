package com.tigertown.conosco.adapters;
import android.widget.*;
import com.tigertown.conosco.global.modelInterfaces.*;
import android.content.*;
import java.util.*;
import android.view.*;
import com.tigertown.conosco.*;

public class AnniversaryAdapter extends ArrayAdapter<IAnniversary>
{
	public AnniversaryAdapter(Context c, List<IAnniversary> data) {
		super(c, 0, data);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		IAnniversary anniversary = getItem(position);
		
		//check if view is being reused. otherwise inflate.
		//probably not necessary for this small list, but i don't really know.
		if(convertView == null)
			convertView = LayoutInflater.from(getContext()).inflate(R.layout.anniversarylistitem, parent, false);
			
		TextView type = (TextView) convertView.findViewById(R.id.type);
		TextView date = (TextView) convertView.findViewById(R.id.date);
		
		type.setText(anniversary.getType());
		date.setText(anniversary.getDate().toString());
		
		return convertView;
	}
}
