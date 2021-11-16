package com.tigertown.conosco.adapters;
import android.widget.*;
import com.tigertown.conosco.global.modelInterfaces.*;
import android.content.*;
import java.util.*;
import android.view.*;
import com.tigertown.conosco.*;

public class PersonAdapter extends ArrayAdapter<IPerson>
{
	public PersonAdapter(Context c, List<IPerson> data) {
		super(c, 0, data);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		IPerson record = getItem(position);

		//check if view is being reused. otherwise inflate.
		if(convertView == null)
			convertView = LayoutInflater.from(getContext()).inflate(R.layout.peepslistitem, parent, false);

		TextView value = (TextView) convertView.findViewById(R.id.name);

		value.setText(record.getName());

		return convertView;
	}
}
