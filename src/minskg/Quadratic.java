package minskg;

import java.util.Scanner;

/** 
 * @author teamG
 */

public class Quadratic {
	String x1 = "", x2 = "";
	double a = 0, b = 0, c = 0;

	/**
	 * set constants a,b,c of the cubic equation; ax^2+bx+c = 0
	 * @param a	coefficient of quadratic term; value a from a * x^2
	 * @param b coefficient of term; value b from b * x
	 * @param c constant c
	 */
	public void setCoefficient(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
		compute();
	}

	
	/**
	 * to get 2 possible x on cubic equation
	 * @return string of 2 x values
	 */
	public String getX() {
		return "x1: " + x1 + "\nx2: " + x2 + "\n";
	}

	/**
	 * use formula (-b+-sqrt(b^2-4ac))/2a
	 */
	public void compute() {
		double d =(b * b) - (4 * a * c);
		// roots are real and unequal
		if (d > 0) {
			x1 = "" + ((-b + MathFn.computeSqrt(d)) / (2 * a));
			x2 = "" + ((-b - MathFn.computeSqrt(d)) / (2 * a));
		}
		// roots are imaginary
		else if (d < 0) {
			double r = MathFn.computeSqrt(-d)/(2*a);
			x1 = "" + (-b/(2*a)) + "+" + r + "i";
			x2 = "" + (-b/(2*a)) + "-" + r + "i";
		}
		// roots are real and equal (d==0)
		else {
			x1 = "" + (-b + MathFn.computeSqrt(d)) / (2 * a);
		}
	}

	/**
	 * to check the summation of 3 absolute value is prime number
	 * @param a coefficient of quadratic term
	 * @param b coefficient of linear term
	 * @param c constant
	 * @return true if it is sum of 3 absolute value is prime number, if not false
	 */
	public static boolean isPrimeOf3Absolute(double a, double b, double c) {
		if (a == 0)
			return false;
		if (a < 0)
			a = a * -1;
		if (b < 0)
			b = b * -1;
		if (c < 0)
			c = c * -1;
		double absVal = a + b + c;
		int abs = (int) absVal;
		if (absVal % abs != 0)
			return false;
		if (Prime.isPrime(abs))
			return true;
		else
			return false;

	}

	
	/**
	 * to use a quadratic equation
	 */
	public void quadraticFunction() {
		Scanner input = new Scanner(System.in);
		System.out.println("1: Enter coefficient values for calculating roots of Quadratic equation");
		Quadratic quad = new Quadratic();
		double coeff[] = new double[3];
		for (int i = 0; i < 3; i++) {
			boolean is_number = false;
			do {
				char coeff_var = i == 0 ? 'a' : i == 1 ? 'b' : 'c';
				System.out.println("Enter coefficient " + coeff_var + " value :");
				try {
					coeff[i] = input.nextDouble();
					is_number = true;
				} catch (java.util.InputMismatchException e) {
					input.next();
					System.out.println("It is not number, enter coefficient " + coeff_var + " as a number");
				}
			} while (!is_number);
		}
		if (isPrimeOf3Absolute(coeff[0], coeff[1], coeff[2])) {
			quad.setCoefficient(coeff[0], coeff[1], coeff[2]);
			System.out.println(quad.getX());
		} else {
			System.out.println("Sum of the absolute values for coeeficients is not a prime number. Try again.");
		}
	}
}