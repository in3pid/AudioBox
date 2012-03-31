package com.huemongus.AudioBox;

import com.huemongus.AudioBox.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity {
	public MainActivity() { super(); here = this; }
	private Activity here;
	private AudioGenerator source = new SquareOscillator();
	private Player player = new Player(source);
	private Thread thread;
	private OnClickListener buildButtonListener = new OnClickListener() {
		public void onClick(View v) {
			Intent intent = new Intent(here, BuildActivity.class);
			startActivity(intent);
		}
	};
	private OnClickListener oscillatorButtonListener = new OnClickListener() {
		public void onClick(View v) {
			Intent intent = new Intent(here, OscillatorActivity.class);
			startActivity(intent);
		}
	};
	private OnClickListener startButtonListener = new OnClickListener() {
		public void onClick(View v) {
			if (thread != null) return;
			thread = new Thread(player);
			thread.start();
		}
	};
	private OnClickListener stopButtonListener = new OnClickListener() {
		public void onClick(View v) {
			if (thread == null) return;
			try {
				player.stop();
				thread.join();
				thread = null;
			}
			catch (InterruptedException e) { Log.d("com.huemongus", e.toString()); } 
		}
	};
	private OnSeekBarChangeListener seekBarListener = new OnSeekBarChangeListener() {
		public void onProgressChanged(SeekBar bar, int progress, boolean fromUser) {
//			source.setSmoothing(progress);
		}
		public void onStartTrackingTouch(SeekBar bar) { }
		public void onStopTrackingTouch(SeekBar bar) { }
	};
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);        
		Button buildButton = (Button) findViewById(R.id.button_build);
		buildButton.setOnClickListener(buildButtonListener);
		Button oscillatorButton = (Button) findViewById(R.id.button_oscillator);
		oscillatorButton.setOnClickListener(oscillatorButtonListener);
		
		Button startButton = (Button) findViewById(R.id.button_start);
		startButton.setOnClickListener(startButtonListener);
		Button stopButton = (Button) findViewById(R.id.button_stop);
		stopButton.setOnClickListener(stopButtonListener);
		SeekBar bar = (SeekBar) findViewById(R.id.seekBar1);
		bar.setOnSeekBarChangeListener(seekBarListener);
	}
	public void onStop() {
		super.onStop();
		if (thread == null) return;
		try {
			player.stop();
			thread.join();
			thread = null;
		}
		catch (InterruptedException e) { Log.d("com.huemongus", e.toString()); } 
	}
}