package com.huemongus.AudioBox;

import com.huemongus.AudioBox.R;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;

public class BuildActivity extends ListActivity {
	private BuildAdapter buildAdapter;
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.build);
	    buildAdapter = new BuildAdapter(this);
	    setListAdapter(buildAdapter);
	}
}
