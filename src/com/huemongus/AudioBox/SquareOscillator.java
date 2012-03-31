package com.huemongus.AudioBox;

public class SquareOscillator implements Oscillator {
	private double freq = 440;
	private double angle;
	private double val = 0.5;
	private double pwm = 0.5;
	@Override
	public void setFrequency(double hz) {
		freq = hz;
	}
	public void setPWM(double value) {
		pwm = value;
	}
	@Override
	public void generate(double[] buffer, int length) {
		double step = freq/AudioSettings.Frequency;
		for (int i = 0; i < length; i++) {
			if (angle >= 1) {
				val = -val;
				angle = 0;
			}
			buffer[i] = val;
			angle += step;
		}
	}
}
