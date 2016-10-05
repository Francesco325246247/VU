package assignement2;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by Francesco Cozzolino on 14/09/2016.
 */
public class Collatz {
	private PrintStream out;
	private Scanner scanner;

	private Collatz() {
		out = new PrintStream(System.out);
		scanner = new Scanner(System.in);
	}

	public static void main(String[] args) {
		try {
			new Collatz().Start();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	private void setRootNumber() {
		out.printf("Insert a positive number\n");
		int rootNumber = scanner.nextInt();
		int rootNumberStored = rootNumber;
		int FINAL_NUMBER = 1;
		int counter = 0;
		while (rootNumber != FINAL_NUMBER) {
			if ((rootNumber % 2) == 0) {
				int rootNumberEven = rootNumber / 2;
				rootNumber = rootNumberEven;
			} else {
				int rootNumberOdd = rootNumber * 3 + 1;
				rootNumber = rootNumberOdd;
			}
			out.printf("[" + rootNumber + "]");
			counter++;
		}
		out.printf("\nIt has been solved in [%d] cicles. Root: [%d] Last digit: [%d]", counter, rootNumberStored, rootNumber);
	}

	private void Start() {
		setRootNumber();
	}
}



