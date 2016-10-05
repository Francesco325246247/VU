package assignement2;

import java.io.PrintStream;
import java.util.Scanner;
/**
 * Created by Gebruiker on 12/09/2016.
 */
public class Othello {
	private PrintStream out;
	private final double MAX_PIECES = 64;
	private Othello() {
		out = new PrintStream(System.out);
	}
	private void Pieces(int a, int b) {
		double percentage_white = (a / MAX_PIECES)*100;
		double percentage_black = (b / MAX_PIECES)*100;
		out.print("There are " + b + " black pieces, and the percentage of black pieces: " + percentage_black + "%\n");
		out.print("There are " + a + " white pieces, and the percentage of black pieces: " + percentage_white + "%\n");
	}
	private void start() {
		Scanner in = new Scanner(System.in);
		out.printf("Insert the number of white pieces\n");
		int white_pieces = in.nextInt();
		double remainer = MAX_PIECES - white_pieces;
		out.printf("\nInsert the number of black pieces. Max pieces allowed: " + (int)remainer + "\n");
		int black_pieces = in.nextInt();
		if (white_pieces + black_pieces <= MAX_PIECES || white_pieces + black_pieces > MAX_PIECES) {
			Pieces(white_pieces, black_pieces);
		} else {
			out.print("Invalid number of pieces. Try again.\n");
			out.print("\n");
			start();
		}
	}
	public static void main(String[] args) {
		new Othello().start();
	}
}