package com.tigertown.conosco.adapters;
import android.widget.*;
import com.tigertown.conosco.global.modelInterfaces.*;
import android.content.*;
import java.util.*;
import android.view.*;
import com.tigertown.conosco.*;

public class AssociationAdapter extends ArrayAdapter<IAssociation>
{
	public AssociationAdapter(Context c, List<IAssociation> data) {
		super(c, 0, data);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		IAssociation assoc = getItem(position);
		
		//check if view is being reused. otherwise inflate.
		//probably not necessary for this small list, but i don't really know.
		if(convertView == null)
			convertView = LayoutInflater.from(getContext()).inflate(R.layout.associationlistitem, parent, false);
			
		TextView value = (TextView) convertView.findViewById(R.id.value);
		
		value.setText(assoc.getValue());
		
		return convertView;
	}
}
