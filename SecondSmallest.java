package assignement2;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by Francesco Cozzolino on 13/09/2016.
 */
public class SecondSmallest {
	private PrintStream out;
	private Scanner scanner;

	private SecondSmallest() {
		out = new PrintStream(System.out);
		scanner = new Scanner(System.in);
	}

	public static void main(String[] args) {
		new SecondSmallest().Start();
	}

	private void setNumbers() {
		String numberSet = scanner.nextLine();
		Scanner stringReading = new Scanner(numberSet);
		int firstNum = stringReading.nextInt();
		int secondNum = stringReading.nextInt();
		while (stringReading.hasNextInt()) {
			int nextInt = stringReading.nextInt();
			if (nextInt > firstNum && nextInt < secondNum) {
				secondNum = nextInt;
			} else if (nextInt < firstNum) {
				secondNum = firstNum;
				firstNum = nextInt;
			}
		}
		out.printf("The second smallest number: %d", secondNum);
	}

	private void Start() {
		setNumbers();
	}
}



