package com.huemongus.AudioBox;

public interface Oscillator extends AudioGenerator {
	public void setFrequency(double hz);
	public void generate(double[] buffer, int length);
}
