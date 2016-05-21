package minskg;

public class MathFn {

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

	// calculates the factorial
	public static double factorial(int x) {

		double f = (double) x;
		for (int i = x - 1; i > 0; i--) {
			f = f * (double) i;
		}
		return f;
	}

	public static double cuberoot(double x) {
		return cuberoot(x, 10);
	}

	public static double cuberoot(double x, int digit) {
		double y = 0;
		if (x < 0) {
			for (int i = -1; i > x; i--) {
				if (i * i * i < x) {
					y = i + 1;
					break;
				}
			}
		} else {
			for (int i = 0; i < x; i++) {
				if (i * i * i > x) {
					y = i - 1;
					break;
				}
			}
		}
		System.out.println("y::" + y);
		return cuberootdigit(x, y, digit);
	}

	public static double cuberootdigit(double x, double y, int digit) {
		double value = 0;
		if (x < 0) {
			for (int i = 1; i < digit; i++) {
				for (int j = 1; j < 10; j++) {
					value = (y * MathFn.pow(10, i) - j) / MathFn.pow(10, i);
					if (value * value * value < x) {
						y = value + (1 / MathFn.pow(10, i));
						break;
					}
				}
			}
		} else {
			for (int i = 1; i < digit; i++) {
				for (int j = 1; j < 10; j++) {
					value = (y * MathFn.pow(10, i) + j) / MathFn.pow(10, i);
					if (value * value * value > x) {
						y = value - (1 / MathFn.pow(10, i));
						break;
					}
				}
			}
		}
		return y;
	}
}
