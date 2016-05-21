package minskg;

import java.util.Scanner;

/**
 * @author teamG
 */

public class Prime {

	/*
	 * source:
	 * https://en.wikipedia.org/wiki/Primality_test#Pseudocode and
	 * http://users.encs.concordia.ca/~kamthan/courses/soen-6611/primality.pdf
	 */

	/**
	 * @param number if this is prime number or not
	 * @return true if it is; false if not
	 */
	public static boolean isPrime(long number) {
		if (number <= 1) {
			return false;
		} else if (number <= 3) {
			return true;
		} else if (number % 2 == 0 || number % 3 == 0) {
			return false;
		}
		int i = 5;
		while (i * i <= number) {
			if (number % i == 0 || number % (i + 2) == 0) {
				return false;
			}
			i = i + 6;
		}
		return true;
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
		if (isPrime(abs))
			return true;
		else
			return false;

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
		else if (isPrime(abs))
			return false;
		else if (abs % 2 == 1)
			return true;
		else
			return false;

	}

	/**
	 * to test a single number, if it is prime number or not.
	 */
	public void primeFunction() {
		Scanner input = new Scanner(System.in);
		Prime p = new Prime();
		System.out.println("number ::");
		int value = 0;
		try {
			value = input.nextInt();
			System.out.println(value + " is " + (p.isPrime(value) ? "" : " not ") + " prime number");
		} catch (Exception e) {
			System.out.println("it is not prime number");
		}
	}
}