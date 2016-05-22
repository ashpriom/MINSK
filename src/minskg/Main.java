package minskg;
import java.util.Scanner;

/**
 * @author teamG
 */

public class Main {
	/**
	 * main menu
	 */
	public void start() {
		Scanner sc = new Scanner(System.in);
		String input;
		boolean flag = false;
		System.out.println("Welcome to MINSK. Choose a number to perform math operation. \n");
		while (true) {
			
			System.out.println("Choose 1) Prime 2) Quadratic 3) Cubic 4) Exit");
			do {
				if (flag) {
					System.out.println("choose again");
				    }
				input = sc.next();
			} while (flag = !(input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4")));
			if (input.equals("1")) {
				Prime p = new Prime();
				p.primeFunction();
			} else if (input.equals("2")) {
				Quadratic q = new Quadratic();
				q.quadraticFunction();
			} else if (input.equals("3")) {
				Cubic c = new Cubic();
				c.cubicFunction();
			} else {
				System.out.println("\nMINSK has been closed. Please run again to calculate.");
				System.exit(0);
			}
		}
	}

	/**
	 * to run the project
	 * @param args unused
	 */
	public static void main(String[] args) {
		Main m = new Main();
		m.start();
	}
}
