package com.huemongus.AudioBox;
import java.util.*;

public class NoiseGenerator implements AudioGenerator {
	public void generate(double[] buffer, int length) {
		for (int i = 0; i < length; i++) buffer[i] = Math.random()-0.5;
	}
}
