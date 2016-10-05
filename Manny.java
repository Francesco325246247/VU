package assignement2;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by Francesco Cozzolino on 13/09/2016.
 */
public class Manny {
	private final static int MIN_DONATION = 50;
	private Scanner scanner;
	private PrintStream out;

	private Manny() {
		out = new PrintStream(System.out);
		scanner = new Scanner(System.in);
	}

	public static void main(String[] args) {
		new Manny().Start();
	}

	private void setDonation() {
		double totalDonation = 0;
		out.printf("Enter the amount you want to donate:\n");
		double donation = scanner.nextDouble();
		totalDonation += donation;
		while (totalDonation < MIN_DONATION) {
			out.printf("That's not enough.\nEnter the amount you want to donate:\n");
			double donation2 = scanner.nextDouble();
			totalDonation += donation2;
		}
		out.printf("Total amount donated: %.2f .Thank you to be so generous!\n", totalDonation);
	}

	private void Start() {
		setDonation();
	}
}



