package assignement2;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by Francesco Cozzolino on 09/09/2016.
 */
public class Plumber {
	private PrintStream out;
	private Scanner scanner;

	private Plumber() {
		out = new PrintStream(System.out);
		scanner = new Scanner(System.in);
	}

	private Plumber(double wage, double hours) {
		final double CALL_OUT_COST = 16;
		double total_cost = (wage * hours) + CALL_OUT_COST;
		out.printf("wage = [" + wage + "], hours = [" + hours + "]" + "\nThe total cost of this repair is: " + total_cost);
	}

	public static void main(String[] args) {
		new Plumber().start();
	}

	void start() {
		out.print("Insert wage\n");
		double a = scanner.nextDouble();
		out.print("Insert how many hours\n");
		double b = scanner.nextDouble();
		Plumber plumber1 = new Plumber(a, b);
	}
}
