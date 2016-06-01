/** 
 * @author teamG
 * MINSK
 * SOEN 6611 - G
 * The MIT License (MIT)
 * Copyright (c) 2015 Nuttakit Phichitsakuldes, Ronak Ramanlal Prajapati, Pratyusha Prathikantham
   Syed Ashfaque Uddin Priom, Golnoush Rahimzadeh, Dhanvin Raval, Kumaran Ayyappan Ravi

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in
 all copies or substantial portions of the Software.
*/

package minskg;

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
	public String getX1() {
		return x1;
	}

	public String getX2() {
		return x2;
	}
	
	/**
	 * use formula (-b+-sqrt(b^2-4ac))/2a
	 */
	public void compute() {
		//subtractive cancellation
		
		double d =(b * b) - (4 * a * c);
		// roots are real and unequal
		if (d > 0) {
			double sgn = b>0?1:-1;
			double q = -0.5*(b+sgn*MathFn.computeSqrt(d));
			x1 = ""+(q/a);
			x2 = ""+(c/q);
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
			x2 = "" + (-b + MathFn.computeSqrt(d)) / (2 * a);
		}
	}

	/**
	 * to check the summation of 3 absolute value is prime number
	 * @param a coefficient of quadratic term
	 * @param b coefficient of linear term
	 * @param c constant
	 * @return true if it is sum of 3 absolute value is prime number, if not false
	 */
	public static boolean isPrime(double a, double b, double c) {
		if (a == 0)
			return false;
		else if (a < 0)
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
}