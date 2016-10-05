package assignement2;
/**
 * Created by Gebruiker on 15/09/2016.
 */
import java.io.PrintStream;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Othello2 {
	private PrintStream out;
	private Scanner in;

	private Othello2() {
		out = new PrintStream(System.out);
		in = new Scanner(System.in);
	}

	public static void main(String[] args) {
		new Othello2().start();
	}

	private String timeConverterHumans(int milliseconds) {
		String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(milliseconds),
				TimeUnit.MILLISECONDS.toMinutes(milliseconds) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milliseconds)),
				TimeUnit.MILLISECONDS.toSeconds(milliseconds) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliseconds)));
		return hms;
	}

	private void start() {
		int time1 = 0;
		int time2 = 0;
		out.printf("Enter the first time in ms\n");
		time1 = in.nextInt();
		out.printf("Enter the second time in ms\n");
		time2 = in.nextInt();
		if (time1 > time2) {
			out.printf("The human player time is ");
			out.printf(timeConverterHumans(time1));
			out.printf("\nComputer player time: %dms\n", time2);
		} else {
			out.printf("The human player time is ");
			out.printf(timeConverterHumans(time2));
			out.printf("\nComputer player time: %dms\n", time1);
		}
	}
}

