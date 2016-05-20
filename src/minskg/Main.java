package minskg;
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
				p.primeFunction();
			} else if (input.equals("2")) {
				Quadratic q = new Quadratic();
				q.quadraticFunction();
			} else {
				Cubic c = new Cubic();
				c.cubicFunction();
			}
		}
	}

	public static void main(String[] args) {
		Main m = new Main();
		m.start();
	}
}
