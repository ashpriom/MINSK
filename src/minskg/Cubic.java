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
public class Cubic {
	/*
	 * the algorithm source : http://www.1728.org/cubic2.htm
	 */
	String x1 = "", x2 = "", x3 = "";
	double a = 0, b = 0, c = 0, d = 0;

	/**
	 * get 3 possible x on cubic equation
	 * 
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
		double f = ((3 * c / a) - (Math.pow(b, 2) / Math.pow(a, 2))) / 3d;
		text += "\n" + "f:" + f;
		double g = ((2 * Math.pow(b, 3) / Math.pow(a, 3)) - (9 * b * c / Math.pow(a, 2)) + (27 * d / a)) / 27;
		text += "\n" + "g:" + g;
		double h = (g * g / 4) + (Math.pow(f, 3) / 27);
		text += "\n" + "h:" + h;

		if (h > 0) {
			double r = -(g / 2) + MathFunctions.sqrt(h);
			double s = Math.cbrt(r);
			double t = -(g / 2) - MathFunctions.sqrt(h);
			double u = Math.cbrt(t);
			text += "\n" + "----case1----\n" + "r:" + r + "\n" + "s:" + s;
			text += "\n" + "t:" + t + "\n" + "u:" + u;
			x1 = "" + ((s + u) - (b / (3 * a)));
			x2 = "" + (-(s + u) / 2 - (b / (3 * a))) + "+i*" + (((s - u) * MathFunctions.sqrt(3) / 2d));
			x3 = "" + (-(s + u) / 2 - (b / (3 * a))) + "-i*" + (((s - u) * MathFunctions.sqrt(3) / 2d));
		} else if (f == 0 && g == 0 && h == 0) {
			text += "\n" + "case2";
			x1 = "" + (Math.cbrt(d / a) * -1);
			x2 = "" + (Math.cbrt(d / a) * -1);
			x3 = "" + (Math.cbrt(d / a) * -1);

		} else {
			double i = MathFunctions.sqrt(((g * g) / 4) - h);
			double j = Math.cbrt(i);
			double k = Math.acos(-(g / (2 * i)));
			double l = j * -1;
			double m = Sine.computeCosine(k / 3);
			double n = MathFunctions.sqrt(3) * Sine.computeSine(k / 3);
			double p = (b / (3d * a)) * -1;
			text += "\n----case3----\ni:" + i + "\nj:" + j + "\nk:" + k;
			text += "\nl:" + l + "\nm:" + m + "\nn:" + n + "\np:" + p;
			x1 = "" + ((2 * j * Math.cos(k / 3d)) - (b / (3d * a)));
			x2 = "" + (l * (m + n) + p);
			x3 = "" + (l * (m - n) + p);
		}
		System.out.println(text);
	}

	
	/**
	 * use formula to find X there are 3 cases If h > 0, there is only 1 real
	 * root and is solved by another method. If f=0, g=0 and h = 0, all 3 roots
	 * are real and equal. If h <= 0, as is the case here, all 3 roots are real.
	 */
	public void computeWithoutBuildin() {
		String text = "";
		double f = ((3 * c / a) - (Math.pow(b, 2) / Math.pow(a, 2))) / 3d;
		text += "\n" + "f:" + f;
		double g = ((2 * Math.pow(b, 3) / Math.pow(a, 3)) - (9 * b * c / Math.pow(a, 2)) + (27 * d / a)) / 27;
		text += "\n" + "g:" + g;
		double h = (g * g / 4) + (Math.pow(f, 3) / 27);
		text += "\n" + "h:" + h;

		if (h > 0) {
			double r = -(g / 2) + MathFunctions.sqrt(h);
			double s = Math.cbrt(r);
			double t = -(g / 2) - MathFunctions.sqrt(h);
			double u = Math.cbrt(t);
			text += "\n" + "----case1----\n" + "r:" + r + "\n" + "s:" + s;
			text += "\n" + "t:" + t + "\n" + "u:" + u;
			x1 = "" + ((s + u) - (b / (3 * a)));
			x2 = "" + (-(s + u) / 2 - (b / (3 * a))) + "+i*" + (((s - u) * MathFunctions.sqrt(3) / 2d));
			x3 = "" + (-(s + u) / 2 - (b / (3 * a))) + "-i*" + (((s - u) * MathFunctions.sqrt(3) / 2d));
		} else if (f == 0 && g == 0 && h == 0) {
			text += "\n" + "case2";
			x1 = "" + (Math.cbrt(d / a) * -1);
			x2 = "" + (Math.cbrt(d / a) * -1);
			x3 = "" + (Math.cbrt(d / a) * -1);

		} else {
			double i = MathFunctions.sqrt(((g * g) / 4) - h);
			double j = MathFunctions.cbrt(i);
			double k = Math.acos(-(g / (2 * i)));
			double l = j * -1;
			double m = Sine.computeCosine(k / 3);
			double n = MathFunctions.sqrt(3) * Sine.computeSine(k / 3);
			double p = (b / (3d * a)) * -1;
			text += "\n----case3----\ni:" + i + "\nj:" + j + "\nk:" + k;
			text += "\nl:" + l + "\nm:" + m + "\nn:" + n + "\np:" + p;
			x1 = "" + ((2 * j * Math.cos(k / 3d)) - (b / (3d * a)));
			x2 = "" + (l * (m + n) + p);
			x3 = "" + (l * (m - n) + p);
		}
		System.out.println(text);
	}
	
	
	/**
	 * set constants a,b,c,d of the cubic equation; ax^3+bx^2+cx+d = 0
	 * 
	 * @param a
	 *            cubic coefficient; value a from a * x^3
	 * @param b
	 *            quadratic coefficient; value b from b * x^2
	 * @param c
	 *            linear coefficient; value c from c * x
	 * @param d
	 *            constant d
	 */
	public void setCoefficient(int a, int b, int c, int d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		compute();
	}

	/**
	 * to test a couple of cubic equation and save the result on
	 * cubic_output.txt or to test a cubic equation
	 * 
	 * @param args
	 *            unused
	 * @throws FileNotFoundException
	 *             no file
	 */
	public void cubicFunction() {
		Scanner input = new Scanner(System.in);
		Cubic c = new Cubic();
		int coeff[] = new int[4];
		for (int i = 0; i < 4; i++) {
			boolean is_number = false;
			do {
				char coeff_var = i == 0 ? 'a' : i == 1 ? 'b' : i == 2 ? 'c' : 'd';
				System.out.println("put coefficient " + coeff_var + " value :");
				try{
					is_number = true;
					coeff[i] = input.nextInt();
				}catch(Exception e){
					System.out.println("it is not number, put coefficient " + coeff_var + " again");
					input.next();
				}
			} while (!is_number);
		}
		c.setCoefficient(coeff[0], coeff[1], coeff[2], coeff[3]);
		System.out.println(c.getX());
	}
}
