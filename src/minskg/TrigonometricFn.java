package minskg;

public class TrigonometricFn {
	private double PI = 3.141592653589793;

	public static double computeSine(double x) {
		double sum = 0;
		if (x > 6.283188) {
			x = ((x * 1000000) % (6.283188 * 1000000)) / 1000000;
		}
		if (x != 0) {
			int i = 1;
			while (i <= 10) {
				int tmp = (2 * i) - 1;
				double q = MathFn.pow(x, tmp);
				double fact_i = MathFn.factorial(tmp);
				if (i % 2 == 1) {
					sum += (q / fact_i);
				} else {
					sum -= (q / fact_i);
				}
				i += 1;
			}
		}
		return sum;
	}

	public static double computeCosine(double radians) {
		if (radians > 6.28319) {
			radians = ((radians * 100000) % (6.28319 * 100000)) / 100000;
		}
		double deg = 57.2958 * radians;
		double cos_deg = 90 - deg;
		double cos_rad = cos_deg * 0.0174533;
		return computeSine(cos_rad);
	}

	public static double computeArcCosine(double x) {
		double negate = x<0?1:0;
		x = Math.abs(x);
		double ret = -0.0187293;
		ret = ret * x;
		ret = ret + 0.0742610;
		ret = ret * x;
		ret = ret - 0.2121144;
		ret = ret * x;
		ret = ret + 1.5707288;
		ret = ret * Math.sqrt(1.0 - x);
		ret = ret - 2 * negate * ret;
		return negate * 3.14159265358979 + ret;
	}

}
