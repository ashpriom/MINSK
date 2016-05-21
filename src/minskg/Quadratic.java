package minskg;

import java.util.Scanner;

public class Quadratic {
	String x1 = "", x2 = "";
	double a = 0, b = 0, c = 0, d = 0;

	public void setCoefficient(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
		compute();
	}

	
	public String getX() {
		return "x1: " + x1 + "\nx2: " + x2 + "\n";
	}

	public void compute() {
		d = (b * b) - (4 * a * c);
		// roots are real and unequal
		if (d > 0) {

			x1 = "" + (-b + MathFunctions.sqrt(d)) / (2 * a);
			x2 = "" + (-b - MathFunctions.sqrt(d)) / (2 * a);
		}
		// roots are imaginary
		else if (d < 0) {

			x1 = "" + -b + "+" + "(" + d + "i)";
			x2 = "" + -b + "-" + "(" + d + "i)";
		}
		// roots are real and equal (d==0)
		else {
			x1 = "" + (-b + MathFunctions.sqrt(d)) / (2 * a);
		}
		
	}

	public void quadraticFunction(){
		Scanner input = new Scanner(System.in);
		System.out.println("1:: to put number");
		Quadratic quad = new Quadratic();
		int coeff[] = new int[3];
		for (int i = 0; i < 3; i++) {
			boolean is_number = false;
			do {
				char coeff_var = i == 0 ? 'a' : i == 1 ? 'b' : 'c';
				System.out.println("put coefficient " + coeff_var + " value :");
				try{
					coeff[i] = input.nextInt();
					is_number = true;
				} catch(java.util.InputMismatchException e) {
					input.next();
					System.out.println("it is not number, put coefficient " + coeff_var + " again");
				}
			} while (!is_number);
		}
		quad.setCoefficient(coeff[0], coeff[1], coeff[2]);
		System.out.println("check");
		System.out.println(quad.getX());
	}
}