package com.huemongus.AudioBox;

public class SineOscillator implements Oscillator {
	private double freq = 440;
	private double angle = 0;
	@Override
	public void setFrequency(double hz) {
		freq = hz;
	}
	public double getFrequency() {
		return freq;
	}
	@Override
	public void generate(double[] buffer, int length) {
		double step = 2*Math.PI*freq/AudioSettings.Frequency;
		for (int i = 0; i < length; i++) {
			buffer[i] = Math.sin(angle)/2;
			angle += step;
		}
	}
}