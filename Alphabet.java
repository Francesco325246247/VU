package assignement2;

import java.io.PrintStream;
/**
 * Created by Francesco Cozzolino on 12/09/2016.
 */
public class Alphabet {
	private PrintStream out;

	private Alphabet() {
		out = new PrintStream(System.out);
	}

	public static void main(String[] args) {
		new Alphabet().Start();
	}

	private void setAlphabet() {
		for (char c = 'a'; c <= 'z'; c++) {
			out.printf("[%c] ", c);
		}
	}

	private void Start() {
		setAlphabet();
	}
}



