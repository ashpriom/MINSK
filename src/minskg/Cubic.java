package minskg;

import java.util.Scanner;

/**
 * @author teamG
 */

public class Cubic {
	/*
	 * the algorithm source : http://www.1728.org/cubic2.htm
	 */
	String x1 = "", x2 = "", x3 = "";
	double a = 0, b = 0, c = 0, d = 0;

	/**
	 * to get 3 possible x on cubic equation
	 * @return string of 3 x values
	 */
	public String getX() {
		return "x1: " + x1 + "\nx2: " + x2 + "\nx3: " + x3 + "\n";
	}

	

	/**
	 * use formula to find X there are 3 cases If h > 0, there is only 1 real
	 * root and is solved by another method. If f=0, g=0 and h = 0, all 3 roots
	 * are real and equal. If h <= 0, as is the case here, all 3 roots are real.
	 */
	public void compute() {
		String text = "";
		double f = ((3 * c / a) - (MathFn.computePower(b, 2) / MathFn.computePower(a, 2))) / 3d;
		text += "\n" + "f:" + f;
		double g = ((2 * MathFn.computePower(b, 3) / MathFn.computePower(a, 3)) - (9 * b * c / MathFn.computePower(a, 2)) + (27 * d / a)) / 27;
		text += "\n" + "g:" + g;
		double h = (g * g / 4) + (MathFn.computePower(f, 3) / 27);
		text += "\n" + "h:" + h;

		if (h > 0) {
			double r = -(g / 2) + MathFn.computeSqrt(h);
			double s = MathFn.computeCbrt(r);
			double t = -(g / 2) - MathFn.computeSqrt(h);
			double u = MathFn.computeCbrt(t);
			text += "\n" + "----case1----\n" + "r:" + r + "\n" + "s:" + s;
			text += "\n" + "t:" + t + "\n" + "u:" + u;
			x1 = "" + ((s + u) - (b / (3 * a)));
			x2 = "" + (-(s + u) / 2 - (b / (3 * a))) + "+i*" + (((s - u) * MathFn.computeSqrt(3) / 2d));
			x3 = "" + (-(s + u) / 2 - (b / (3 * a))) + "-i*" + (((s - u) * MathFn.computeSqrt(3) / 2d));
		} else if (f == 0 && g == 0 && h == 0) {
			text += "\n" + "case2";
			x1 = "" + (MathFn.computeCbrt(d / a) * -1);
			x2 = "" + (MathFn.computeCbrt(d / a) * -1);
			x3 = "" + (MathFn.computeCbrt(d / a) * -1);

		} else {
			double i = MathFn.computeSqrt(((g * g) / 4) - h);
			double j = MathFn.computeCbrt(i);
			double k = TrigonometricFn.computeArcCosine(-(g / (2 * i)));
			double l = j * -1;
			double m = TrigonometricFn.computeCosine(k / 3);
			double n = MathFn.computeSqrt(3) * TrigonometricFn.computeSine(k / 3);
			double p = (b / (3d * a)) * -1;
			text += "\n----case3----\ni:" + i + "\nj:" + j + "\nk:" + k;
			text += "\nl:" + l + "\nm:" + m + "\nn:" + n + "\np:" + p;
			x1 = "" + ((2 * j * TrigonometricFn.computeCosine(k / 3d)) - (b / (3d * a)));
			x2 = "" + (l * (m + n) + p);
			x3 = "" + (l * (m - n) + p);
		}
	}

	/**
	 * set constants a,b,c,d of the cubic equation; ax^3+bx^2+cx+d = 0
	 * @param a coefficient of cubic term; value a from a * x^3
	 * @param b coefficient of quadratic term; value b from b * x^2
	 * @param c coefficient of linear term; value c from c * x
	 * @param d constant d
	 */
	public void setCoefficient(int a, int b, int c, int d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		compute();
	}

	

	/**
	 * to check the summation of 4 absolute value is odd composite number
	 * @param a coefficient of cubic term
	 * @param b coefficient of quadratic term
	 * @param c coefficient of linear term
	 * @param d constant
	 * @return true if it is sum of 4 absolute value is odd composite number, if not false
	 */
	public static boolean isOddCompositeOf4Absolute(double a, double b, double c, double d) {
		if (a == 0)
			return false;
		else if (a < 0)
			a = a * -1;
		if (b < 0)
			b = b * -1;
		if (c < 0)
			c = c * -1;
		if (d < 0)
			d = d * -1;
		double absVal = a + b + c + d;
		int abs = (int) absVal;
		if (absVal % abs != 0)
			return false;
		else if (Prime.isPrime(abs))
			return false;
		else if (abs % 2 == 1)
			return true;
		else
			return false;

	}

	/**
	 * to use a cubic equation
	 */
	public void cubicFunction() {
		Scanner input = new Scanner(System.in);
		Cubic c = new Cubic();
		int coeff[] = new int[4];
		for (int i = 0; i < 4; i++) {
			boolean is_number = false;
			do {
				char coeff_var = i == 0 ? 'a' : i == 1 ? 'b' : i == 2 ? 'c' : 'd';
				System.out.println("put coefficient " + coeff_var + " value : ");
				try{
					is_number = true;
					coeff[i] = input.nextInt();
				}catch(Exception e){
					System.out.println("it is not number, put coefficient " + coeff_var + " again");
					input.next();
				}
			} while (!is_number);
		}
		if(isOddCompositeOf4Absolute(coeff[0], coeff[1], coeff[2], coeff[3])){
			c.setCoefficient(coeff[0], coeff[1], coeff[2], coeff[3]);
			System.out.println(c.getX());
		}else{
			System.out.println("sum of these absolute value is not odd composite number");
		}
	}
}
