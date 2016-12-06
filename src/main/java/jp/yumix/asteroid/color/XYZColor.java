package jp.yumix.asteroid.color;

import java.util.stream.DoubleStream;

import javafx.scene.paint.Color;

public final class XYZColor {

	private final double X;
	
	private final double Y;
	
	private final double Z;
	
	public XYZColor(double X, double Y, double Z) {
		this.X = X;
		this.Y = Y;
		this.Z = Z;
	}
	
	public static XYZColor of(double x, double y) {
		final double X = x / y;
		final double Y = 1;
		final double Z = (1 - x - y) / y;
		return new XYZColor(X, Y, Z);
	}
	
	public static XYZColor of(ColorPosition colorPosition) {
		return of(colorPosition.getX(), colorPosition.getY());
	}
	
	public double getX() {
		return X;
	}

	public double getY() {
		return Y;
	}

	public double getZ() {
		return Z;
	}

	public Color toColor() {
		final double red = 3.240970 * X - 1.537383 * Y - 0.498611 * Z;
		final double green = -0.969244 * X + 1.875968 * Y + 0.041555 * Z;
		final double blue = 0.055630 * X - 0.203977 * Y + 1.056972 * Z;
		double maxValue = DoubleStream.of(red, green, blue, 1.0).max().getAsDouble();
		return Color.color(red / maxValue, green / maxValue, blue / maxValue);
	}
	
}
