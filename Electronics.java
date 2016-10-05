package assignement2;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.*;
/**
 * Created by Francesco Cozzolino on 13/09/2016.
 */
public class Electronics {
	private PrintStream out;
	private double product_price = 0;
	private double[] product_array = new double[3];
	private Electronics() {
		out = new PrintStream(System.out);
	}
	public static void main(String[] args) {
			new Electronics().Start();
	}
	private void product_scanner() {
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < product_array.length; i++) {
			out.printf("\nEnter price of the product\n");
			product_price = scanner.nextDouble();
			product_array[i] = product_price;
			for (double aProduct_array : product_array) {
				out.printf("[" + aProduct_array + "]");
			}
			out.printf("\n");
		}
	}
	private void price_discount() {
		double max_discounted = 0;
		Arrays.sort(product_array);
		double max = product_array[product_array.length - 1];
		double discounted = ((max * 15) / 100);
		max_discounted = max - discounted;
		product_array[product_array.length - 1] = max_discounted;
		double total_final_price = DoubleStream.of(product_array).sum();
		for (double aProduct_array : product_array) {
			out.printf("[" + aProduct_array + "]");
		}
		out.printf("\nThe discount is %f\n", discounted);
		out.printf("The total price is %f", total_final_price);
	}
	private void Start() {
		product_scanner();
		price_discount();
	}
}



