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

public class MathFn {

	/**
	 * to calculate power
	 * 
	 * @param a
	 *            the base
	 * @param b
	 *            the exponent
	 * @return b-th power of a
	 */
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

	/**
	 * to calculate square root
	 * 
	 * @param number
	 *            a value
	 * @return the positive square root of the number. If the argument is NaN or
	 *         less than zero, the result is NaN
	 */
	public static double computeSqrt(double number) {
		double first = 0;
		double x;
		double last = 0.0;
		x = number;
		for (;number!=0;) {
			first = (x + number / x) / 2.0;
			x = first;
			if (last == first)
				break;
			last = first;
		}
		return first;
	}

	/**
	 * to calculate factorial
	 * 
	 * @param x
	 *            a value
	 * @return factorial of x
	 */
	public static double computeFactorial(int x) {

		double f = (double) x;
		for (int i = x - 1; i > 0; i--) {
			f = f * (double) i;
		}
		return f;
	}

	/**
	 * to calculate cube root with 10 decimal digits result
	 * 
	 * @param x
	 *            a value
	 * @return a cube root of x
	 */
	public static double computeCbrt(double x) {
		return computeCbrt(x, 18);
	}

	/**
	 * to calculate cube root with i-th decimal digits result
	 * 
	 * @param x
	 *            a value
	 * @param digit
	 *            number of digit of cubic function to return
	 * @return a cube root of x
	 */
	public static double computeCbrt(double x, int digit) {
		boolean isNegative = false;

		if (x < 0) {
			isNegative = true;
			x *= -1;
		}
		if (x < 1) {
			return computeCbrtDigit(isNegative ? x * -1 : x, 0, digit);
		} else if (x < 2) {
			return computeCbrtDigit(isNegative ? x * -1 : x, isNegative ? -1 : 1, digit);
		}
		double j=1;
		double e=0;
		for (;e==0;j++) {
			if(MathFn.computePower(MathFn.computePower(10, j),3)>x){
				e=MathFn.computePower(10, j-1);
			}
		}
		int i;
		for(i = 2; i<10;i++){
			if(MathFn.computePower(e*i,3)>x){
				--i;
				break;
			}
		}
		
		
		double y = e*i;
		for (; e >= 1; e/=10) {
			for (int l = 1; l < 10; l++) {
				if(MathFn.computePower(y+(e*l),3)>x){
					y = y+(e*(l-1));
					break;
				}
			}
		}
		
		return computeCbrtDigit(isNegative ? x * -1 : x, isNegative ? y * -1 : y, digit);
	}

	/**
	 * to calculate cube root focus on the number of digits
	 * 
	 * @param x
	 *            a value
	 * @param y
	 *            the integer result
	 * @param digit
	 *            number of digit of cubic function to return
	 * @return a cube root of x
	 */
	private static double computeCbrtDigit(double x, double y, int digit) {
		double value = 0;
		boolean isNegative = false;
		if (x < 0) {
			x *= -1;
			y *= -1;
			isNegative = true;
		}
		for (int i = 1; i < digit; i++) {
			int j;
			for (j = 1; j < 10; j++) {
				value = (y * MathFn.computePower(10, i) + j) / MathFn.computePower(10, i);
				if (value * value * value > x) {
					y = value - (1 / MathFn.computePower(10, i));
					break;
				}
			}
			if (j == 10) {
				y = value;
			}
		}
		return isNegative ? y * -1 : y;
	}
}