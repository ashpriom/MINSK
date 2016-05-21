package minskg;

/**
 * @author teamG
 */

public class TrigonometricFn {

	/**
	 * @param x the radians value  
	 * @return the sine of the argument
	 */
	public static double computeSine(double x) {
		double sum = 0;
		if (x > 6.283188) {
			x = ((x * 1000000) % (6.283188 * 1000000)) / 1000000;
		}
		if (x != 0) {
			int i = 1;
			while (i <= 10) {
				int tmp = (2 * i) - 1;
				double q = MathFn.computePower(x, tmp);
				double fact_i = MathFn.computeFactorial(tmp);
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

	/**
	 * to calculate cosine
	 * @param x the radians value
	 * @return the cosine of the argument
	 */
	public static double computeCosine(double x) {
		if (x > 6.28319) {
			x = ((x * 100000) % (6.28319 * 100000)) / 100000;
		}
		double deg = 57.2958 * x;
		double cos_deg = 90 - deg;
		double cos_rad = cos_deg * 0.0174533;
		return computeSine(cos_rad);
	}

	/**
	 * to calculate arc cosine
	 * @param x the value whose arc cosine to be returned
	 * @return the arc cosine of the argument
	 */
	public static double computeArcCosine(double x) {
		double n = x<0?1:0;
		x = Math.abs(x);
		double r = -0.0187293;
		r = r * x;
		r = r + 0.0742610;
		r = r * x;
		r = r - 0.2121144;
		r = r * x;
		r = r + 1.5707288;
		r = r * Math.sqrt(1.0 - x);
		r = r - 2 * n * r;
		return n * 3.14159265358979 + r;
	}
}
