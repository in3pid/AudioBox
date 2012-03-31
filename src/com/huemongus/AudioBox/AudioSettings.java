package com.huemongus.AudioBox;

public class AudioSettings {
	public static final int Frequency = 44100;
	public static final int Bits = 16;
	public static final int BufferSize = 512*Bits;
	public static final double Scaling = Math.pow(2, Bits-1);
}
