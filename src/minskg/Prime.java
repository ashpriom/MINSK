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

}