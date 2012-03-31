package com.huemongus.AudioBox;

import android.content.Context;
import android.view.View;

public class OscillatorFactory {
	public static Oscillator make(String kind) {
		if (kind == "Sine") return new SineOscillator();
		if (kind == "Square") return new SquareOscillator();
		return null;
	}
}
