package minskg;

public class MathFunctions {

	public static double computePower(double a, double b) {

		if (b < 0)
			return 1 / computePower(a, -b);
		else if (b == 0)
			return 1;
		else if (b == 1)
			return a;
		else
			return a * computePower(a, b - 1);
	}

	public static double computeSqrt(double number) {
		double x = 0, sqrt = number / 2;

		do {
			x = sqrt;
			sqrt = (x + (number / x)) / 2;

		} while ((x - sqrt) != 0);

		return sqrt;
	}

	public double computeSummation(double number){
		return number*(number+1)/2;
	}
	
	public int computeRound(double number) {

		double absval = (number < 0) ? -number : number;
		int i = (int) absval;
		double result = absval - (double) i;
		if (result < 0.5) {
			return number < 0 ? -i : i;
		} else {
			return number < 0 ? -(i + 1) : i + 1;
		}
	}

	public double computeCosine(double radianVal) {
		int expFact = 2;
		double negationFac = 1.0, powSeries = 0.0, factResult = 0.0;

		while (factResult < Double.POSITIVE_INFINITY) {// stop when
														// factorialResult
														// overflow is reached

			factResult = computeFactorial(expFact);// calculate the factorial

			powSeries = 1 + (negationFac * (computePower(radianVal, expFact)) / factResult);// the
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
	public static double computeFactorial(int x) {

		double f = (double) x;
		for (int i = x - 1; i > 0; i--) {
			f = f * (double) i;
		}
		return f;
	}

	public static double computeCubeRoot(double x) {
		   int s;
		   int y, b, y2;

		   y2 = 0;
		   y = 0;
		   for (s = 30; s >= 0; s = s - 3) {
		      y2 = 4*y2;
		      y = 2*y;
		      b = (3*(y2 + y) + 1) << s;
		      if (x >= b) {
		         x = x - b;
		         y2 = y2 + 2*y + 1;
		         y = y + 1;
		      }
		   }
		   return y;
		}

	public static void main(String args[]) {
		MathFunctions mf = new MathFunctions();
		double y = mf.computeCubeRoot(3);
		System.out.println(y);
		System.out.println(Math.cbrt(3));
	}

}
