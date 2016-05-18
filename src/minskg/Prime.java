package minskg;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
	public boolean isPrime(long number) {
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
	 * 
	 * @param value String
	 * @return if the value is positive number,true. if not, false
	 */
	public boolean isPositiveNumber(String value){
		return value.matches("^[0-9]+$");
	}
/**
 * source file: http://www.primos.mat.br/primeiros_10000_primos.txt
 * to test tons of numbers, if it is prime number or not and save the result on output.txt
 * or to test a single number, if it is prime number or not. 
 * @param args unused
 * @throws FileNotFoundException no file 
 */
	public void primeFunction() throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		String choice = "";
		System.out.println("1:: to put number");
		System.out.println("2:: to read tons of number from primeiros_10000_primos.txt");
		boolean is_choice = false;
		do {
			if(is_choice){
				System.out.println("choice "+ choice +" is not available");
			}
			choice = input.next();
		}while(is_choice=!(choice.equals("1") || choice.equals("2")));
		Prime p = new Prime();
		//test single value
		if(choice.equals("1")){
			System.out.println("number ::");	
		String value = input.next();
		if(p.isPositiveNumber(value)){
			int positive_number = Integer.parseInt(value);
			System.out.println(positive_number +" is "+(p.isPrime(positive_number)?"":" not ")+" prime number");
		}else{
			System.out.println(value+" is not prime number");
		}
		}else{
		
		File f = new File("primeiros_10000_primos.txt");
		input = new Scanner(f);
		if (input.hasNext()) {
			int number;
			File file = new File ("prime_output.txt");
		    PrintWriter writer = new PrintWriter(file);
			for(int count = input.nextInt();count>0;count--){
				number = input.nextInt();
				writer.println(number+" is "+(p.isPrime(number)?"":" not ")+" prime number");
			}
			writer.close();
		}
		}
	}
}
