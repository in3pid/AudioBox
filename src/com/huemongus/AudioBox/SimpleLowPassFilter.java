package com.huemongus.AudioBox;

// http://phrogz.net/js/framerate-independent-low-pass-filter.html

public class SimpleLowPassFilter implements AudioShaper {
	private int smoothing = 1;
	private double value;
	public void shape(double[] buffer, int length) {
//		double value = buffer[0];
		for (int i = 0; i < length; i++) {
			double c = buffer[i];
			value += (c - value) / smoothing;
			buffer[i] = value;
		}
	}
	public int getSmoothing() {
		return smoothing;
	}
	public void setSmoothing(int smoothing) {
		this.smoothing = smoothing < 1? 1: smoothing;
	}
}
