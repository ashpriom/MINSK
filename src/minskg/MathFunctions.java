package minskg;

public class MathFunctions {

	public static double pow(double a, double b) {

		if (b < 0)
			return 1 / pow(a, -b);
		else if (b == 0)
			return 1;
		else if (b == 1)
			return a;
		else
			return a * pow(a, b - 1);
	}

	
	public static double sqrt(double number) {
		double x = 0, y = number;
		int iter = 35; // The greater the number of iteration, The accurate is
						// the result
		while (iter > 0) {
			double t = (x + y) / 2;
			if (t * t == number) // If square of a t is equal to the num itself
									// then
				return t; // Return Root
			else if (t * t > number) // If square of t is greater than the num
				y = t; // Update Upper Bound
			else
				x = t; // Update Lower Bound
			iter--; // Decrease iteration
		}
		return (x + y) / 2; // Return closest value if root is not found in 35
							// iterations
	}

	public static double sum(double number) {
		return number * (number + 1) / 2;
	}

	public static int round(double number) {

		double absval = (number < 0) ? -number : number;
		int i = (int) absval;
		double result = absval - (double) i;
		if (result < 0.5) {
			return number < 0 ? -i : i;
		} else {
			return number < 0 ? -(i + 1) : i + 1;
		}
	}

	public static double cos(double radianVal) {
		int expFact = 2;
		double negationFac = 1.0, powSeries = 0.0, factResult = 0.0;

		while (factResult < Double.POSITIVE_INFINITY) {// stop when
														// factorialResult
														// overflow is reached

			factResult = factorial(expFact);// calculate the factorial

			powSeries = 1 + (negationFac * (pow(radianVal, expFact)) / factResult);// the
																					// next
																					// statement
																					// calculates
																					// power
																					// series

			negationFac *= -1.0;// the negation factor alternates + - + - +.....

			expFact += 2;// increment exponent and factorial term by two
		}
		return radianVal - powSeries;// subtraction, as specified in the formula
	}

	// calculates the factorial
	public static double factorial(int x) {

		double f = (double) x;
		for (int i = x - 1; i > 0; i--) {
			f = f * (double) i;
		}
		return f;
	}

	public static double cbrt(double x) {
		int s;
		int y, b, y2;

		y2 = 0;
		y = 0;
		for (s = 30; s >= 0; s = s - 3) {
			y2 = 4 * y2;
			y = 2 * y;
			b = (3 * (y2 + y) + 1) << s;
			if (x >= b) {
				x = x - b;
				y2 = y2 + 2 * y + 1;
				y = y + 1;
			}
		}
		return y;
	}

	
}
