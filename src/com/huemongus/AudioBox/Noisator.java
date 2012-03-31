package com.huemongus.AudioBox;

public class Noisator implements AudioGenerator {
	private AudioGenerator noise = new NoiseGenerator();
	private SimpleLowPassFilter shaper = new SimpleLowPassFilter();	
	@Override
	public void generate(double[] buffer, int length) {
		noise.generate(buffer, length);
		shaper.shape(buffer, length);
	}
	public int getSmoothing() {
		return shaper.getSmoothing();
	}
	public void setSmoothing(int smoothing) {
		shaper.setSmoothing(smoothing);
	}
}