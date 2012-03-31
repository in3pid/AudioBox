package com.huemongus.AudioBox;

import android.util.Log;

public class Player implements Runnable {
	private AudioGenerator source;
	private volatile boolean running;
	public Player(AudioGenerator source) {
		this.source = source;
	}
	public void run() {		
		double[] buffer = new double[AudioSettings.BufferSize];
		AudioOutput out = new AudioOutput();			        
		out.open();
		running = true;
		while (running) {
			source.generate(buffer, AudioSettings.BufferSize);
			out.write(buffer, AudioSettings.BufferSize);
		}
		out.close();
	}
	public void stop() {
		running = false;		
	}
};
