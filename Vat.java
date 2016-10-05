package assignement2;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by Gebruiker on 11/09/2016.
 */
public class Vat {
	PrintStream out;
	Scanner in;

	Vat() {
		out = new PrintStream(System.out);
		in =  new Scanner(System.in);
	}

	private static double NO_VAT_CALC(int a) {
		double vat = a;
		double vatNum = (1 + (21 / 100));
		double price_without_vat = a - vatNum;
		return price_without_vat;
	}

	public static void main(String[] args) {
		new Vat().Start();
	}

	void Start() {
		out.printf("Enter the price of an article including VAT: ");
		int i = in.nextInt();
		out.printf("The price of the article excluding the VAT:  " + NO_VAT_CALC(i));
	}
}

