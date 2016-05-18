package minskg;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public void start() {
		Scanner sc = new Scanner(System.in);
		String input;
		boolean flag = false;
		while (true) {
			System.out.println("Choose 1) Prime 2) Quadratic 3) Cubic");
			do {
				if (flag) {
					System.out.println("choose again");
				}
				input = sc.next();
			} while (flag = !(input.equals("1") || input.equals("2") || input.equals("3")));
			if (input.equals("1")) {
				Prime p = new Prime();
				try {
					p.primeFunction();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (input.equals("2")) {
				Quadratic q = new Quadratic();
				try {
					q.quadraticFunction();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				Cubic c = new Cubic();
				try {
					c.cubicFunction();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.start();
	}
}
