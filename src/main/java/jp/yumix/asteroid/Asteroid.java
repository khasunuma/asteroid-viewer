package jp.yumix.asteroid;

public enum Asteroid {
	
    Ceres(974.0 / 2.0, 974.6 / 2.0, 974.0 / 2.0, 0.713, 0.090),
    Pluto(2370.0 / 2.0, 0.82, 0.56),
    Eris(2326.0 / 2.0, 0.71, 0.88),
    Haumea(996.0 / 2.0, 1960.0 / 2.0, 1518.0 / 2.0, 0.626, 0.6),
    Makemake(1502.0 / 2.0, 1430.0 / 2.0, 0.7, 0.77),
    Sedna(995.0 / 2.0, 1.24, 0.33),
    Orcus(1502.0 / 2.0, 0.68, 0.09),
    Quaoar(890.0 / 2.0, 1.58, 0.069);
	
    private final double polarRadius;
    
    private final double equatorLongRadius;
    
    private final double equatorShortRadius;
    
    private final double colorIndex;
    
    private final double albedo;
    
	Asteroid(double polarRadius, double equatorLongRadius, double equatorShortRadius, double colorIndex, double albedo) {
		this.polarRadius = polarRadius;
		this.equatorLongRadius = equatorLongRadius;
		this.equatorShortRadius = equatorShortRadius;
		this.colorIndex = colorIndex;
		this.albedo = albedo;
	}
	
	Asteroid(double polarRadius, double equatorRadius, double colorIndex, double albedo) {
		this(polarRadius, equatorRadius, equatorRadius, colorIndex, albedo);
	}
	
	Asteroid(double radius, double colorIndex, double albedo) {
		this(radius, radius, radius, colorIndex, albedo);
	}

	public double getPolarRadius() {
		return polarRadius;
	}

	public double getEquatorLongRadius() {
		return equatorLongRadius;
	}

	public double getEquatorShortRadius() {
		return equatorShortRadius;
	}

	public double getColorIndex() {
		return colorIndex;
	}

	public double getAlbedo() {
		return albedo;
	}

	@Override
	public String toString() {
		return String.format("%s [ radius: %.1f km, B-V: %.2f, albedo: %.3f ]", 
				name(), (polarRadius + equatorLongRadius + equatorShortRadius) / 3.0, 
				colorIndex, albedo);
	}
	
}
