package assignement2;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by Gebruiker on 12/09/2016.
 */
class Plumber2 {
	private PrintStream out;
	private Scanner scanner;

	private Plumber2() {
		out = new PrintStream(System.out);
		scanner = new Scanner(System.in);
	}

	private double totalCost(double wage, double hours) {
		final double CALL_OUT_COST = 16;
		double hoursRounded = Math.round(hours);
		double totalCostRounded = (wage * hoursRounded) + CALL_OUT_COST;
		return totalCostRounded;
	}

	private void plumber_wage() {
		out.print("Insert wage\n");
		double wage = scanner.nextDouble();
		out.print("Insert how many hours\n");
		double hours = scanner.nextDouble();
		double finalPrice = totalCost(wage, hours);
		out.printf("Total cost of repair is %.2f", finalPrice);
	}

	public static void main(String[] args) {
		new Plumber2().start();
	}

	private void start() {
		plumber_wage();
	}
}

