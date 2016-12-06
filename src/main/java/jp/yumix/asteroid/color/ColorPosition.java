package jp.yumix.asteroid.color;

import static java.lang.Math.pow;

public final class ColorPosition {

	private final double x;
	
	private final double y;
	
	public ColorPosition(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public static ColorPosition of(double temperature) {
		if (temperature > 7000.0) {
			final double x = 0.237040 + 0.24748e3 / temperature + 1.9018e6 / pow(temperature, 2) - 2.0064e9 / pow(temperature, 3);
			final double y = -3.000 * (x * x) + 2.870 * x - 0.275;
			return new ColorPosition(x, y);
		} else {
			final double x = 0.244063 + 0.09911e3 / temperature + 2.9678e6 / pow(temperature, 2) - 4.6070e9 / pow(temperature, 3);
			final double y = -3.000 * (x * x) + 2.870 * x - 0.275;
			return new ColorPosition(x, y);
		}
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
}
