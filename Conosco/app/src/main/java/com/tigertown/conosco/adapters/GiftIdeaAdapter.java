package com.tigertown.conosco.adapters;
import android.widget.*;
import com.tigertown.conosco.global.modelInterfaces.*;
import android.content.*;
import java.util.*;
import android.view.*;
import com.tigertown.conosco.*;

public class GiftIdeaAdapter extends ArrayAdapter<IGiftIdea>
{
	public GiftIdeaAdapter(Context c, List<IGiftIdea> data) {
		super(c, 0, data);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		IGiftIdea record = getItem(position);

		//check if view is being reused. otherwise inflate.
		//probably not necessary for this small list, but i don't really know.
		if(convertView == null)
			convertView = LayoutInflater.from(getContext()).inflate(R.layout.giftidealistitem, parent, false);

		TextView value = (TextView) convertView.findViewById(R.id.gift);

		value.setText(record.getValue());

		return convertView;
	}
}
