package com.huemongus.AudioBox;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class BuildAdapter extends BaseAdapter {
	private final String[] strings = { "1", "2", "3" };
	private Context context;
	public BuildAdapter(Context c) { 
		context = c;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return strings.length;
	}
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		TextView v = new TextView(context);
		v.setText(strings[position]);
		return v;
	}
}
