package com.huemongus.AudioBox;

import com.huemongus.AudioBox.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class OscillatorActivity extends Activity {
	static final String[] OSCILLATORS = { "Sine", "Square" };
	private Activity here;
	private ViewGroup layout;
	private Oscillator oscillator;
	private View oscillatorView;
	private OnItemSelectedListener selectListener = new OnItemSelectedListener() {
		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
			if (oscillatorView != null) {
				layout.removeView(oscillatorView);
			}
			oscillator = OscillatorFactory.make(OSCILLATORS[pos]);
			oscillatorView = OscillatorViewFactory.make(OSCILLATORS[pos], here, layout, oscillator);
			if (oscillatorView != null) layout.addView(oscillatorView);
		}
		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
		}
	};
	private OnClickListener buttonListener = new OnClickListener() {
		public void onClick(View v) {
			if (oscillator == null) return;
			double[] buffer = new double[AudioSettings.BufferSize];
			AudioOutput out = new AudioOutput();			        
			out.open();
			oscillator.generate(buffer, AudioSettings.BufferSize);
			out.write(buffer, AudioSettings.BufferSize);
			out.close();
		}
	};
	public OscillatorActivity() { super(); here = this; }
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.oscillator);
	    layout = (ViewGroup) findViewById(R.id.oscillator_layout);
	    Spinner spinner = (Spinner) findViewById(R.id.oscillator_spinner);
	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, OSCILLATORS);
	    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinner.setAdapter(adapter);
	    spinner.setOnItemSelectedListener(selectListener);
	    Button button = (Button) findViewById(R.id.oscillator_try);
	    button.setOnClickListener(buttonListener);
	}
}