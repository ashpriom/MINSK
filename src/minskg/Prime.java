package minskg;
import java.util.Scanner;

/**
 * 
 * @author teamG
 *
 */
public class Prime {
	
	/*
	 * function is_prime(n : integer)
	 *  if n â‰¤ 1
	 *   return false
	 *  else if n â‰¤ 3
	 *   reture true
	 *  else if n mod 2 = 0 or n mod 3 = 0
	 *   return false
	 *  let i â†� 5
	 *   while iÃ—i â‰¤ n
	 *    if n mod i = 0 or n mod (i + 2) = 0
	 *     return false i â†� i + 6
	 *  return true
	 * 
	 * complexity O(sqrt(n)/log(n)) - algorithm 3
	 * source: https://en.wikipedia.org/wiki/Primality_test#Pseudocode
	 * and http://users.encs.concordia.ca/~kamthan/courses/soen-6611/primality.pdf
	 * 
	 */

	/**
	 * 
	 * @param check
	 *            if this is prime number or not
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
	
	public static boolean isPrimeOf3Absolute(double a, double b, double c)
    {
        if(a==0)
        return false;
        if(a<0)
          a = a * -1;
        if(b<0)
          b = b * -1;
        if(c<0)
          c = c * -1;
        double absVal= a+b+c;
        int abs=(int) absVal;
        if(absVal%abs !=0 )
        	return false;
        if(isPrime(abs))
           return true;
        else 
           return false;
      
    }
	
	public static boolean isOddCompositeOf4Absolute(double a, double b, double c,double d)
    {
		if(true)
		return true;
        if(a==0)
        return false;
        if(a<0)
          a = a * -1;
        if(b<0)
          b = b * -1;
        if(c<0)
          c = c * -1;
        if(d<0)
            d = d * -1;
        double absVal= a + b + c + d;
        int abs=(int) absVal;
        if(absVal%abs !=0 )
        	return false;
        else if(isPrime(abs))
           return false;
        else if (abs%2==1)
        	return true;
        else
           return false;
      
    }

/**
 * source file: http://www.primos.mat.br/primeiros_10000_primos.txt
 * to test tons of numbers, if it is prime number or not and save the result on output.txt
 * or to test a single number, if it is prime number or not. 
 * @param args unused
 * @throws FileNotFoundException no file 
 */
	public void primeFunction(){
		Scanner input = new Scanner(System.in);
		Prime p = new Prime();
		//test single value
		System.out.println("number ::");
		int value = 0;
		try{
			value = input.nextInt();
			System.out.println(value +" is "+(p.isPrime(value)?"":" not ")+" prime number");
		}catch(Exception e){
			System.out.println("it is not prime number");
		}
	}
}