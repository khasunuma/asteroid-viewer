package jp.yumix.asteroid.color;

import static java.lang.Math.pow;

import java.util.stream.DoubleStream;

public final class ColorTemperature {

	private final double temperature;
	
	public ColorTemperature(double colorIndex, double materialRatio, double surfaceGravity) {
		final double arg1 = 3.939654;
		final double arg2 = -0.395361 * colorIndex;
		final double arg3 = 0.2082113 * pow(colorIndex, 2);
		final double arg4 = -0.0604097* pow(colorIndex, 3);
		final double arg5 = 0.027153 * materialRatio;
		final double arg6 = 0.005036 * pow(materialRatio, 2);
		final double arg7 = 0.007367 * surfaceGravity;
		final double arg8 = -0.01069 * colorIndex * surfaceGravity;
		double logTeff = DoubleStream.of(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8).sum();
		temperature = pow(10, logTeff);
	}
	
	public ColorTemperature(double colorIndex) {
		this(colorIndex, 0, 0);
	}
	
	public double get() {
		return temperature;
	}
	
}
