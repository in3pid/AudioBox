package com.huemongus.AudioBox;

import com.huemongus.AudioBox.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class OscillatorViewFactory {
	public static View SquareOscillatorView(Context ctx, ViewGroup parent, final SquareOscillator model) {
		View view = LayoutInflater.from(ctx).inflate(R.layout.square_oscillator, parent, false);
		((SeekBar) view.findViewById(R.id.square_oscillator_pwm)).setOnSeekBarChangeListener(
				new OnSeekBarChangeListener() {
					public void onStopTrackingTouch(SeekBar seekBar) { }
					public void onStartTrackingTouch(SeekBar seekBar) { }
					public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
						if (fromUser) model.setPWM(progress/100);				
					}		
				});
		return view;
	}
	public static View make(String kind, Context ctx, ViewGroup parent, Oscillator model) {
//		if (kind == "Sine") return new SineOscillatorView();
		if (kind == "Square") return SquareOscillatorView(ctx, parent, (SquareOscillator) model);
		return null;
	}
}
