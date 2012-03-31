package com.huemongus.AudioBox;

import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;

public class AudioOutput {
	private AudioTrack track_;
	private short[] buf_ = new short[AudioSettings.BufferSize];
	public AudioOutput() {
		track_ = new AudioTrack(AudioManager.STREAM_MUSIC, AudioSettings.Frequency, AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT, AudioSettings.BufferSize, AudioTrack.MODE_STREAM);		
	}
	public void open() {
		track_.play();
	}
	public void close() {
		track_.stop();
	}
	public void write(double[] buffer, int length) {
		for (int i = 0; i < length; i++) buf_[i] = (short) (buffer[i]*AudioSettings.Scaling);
		track_.write(buf_, 0, length);
	}
}
