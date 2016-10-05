package Administration;

import ui.UIAuxiliaryMethods;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by Francesco Cozzolino on 19/09/2016.
 */
public class Administration {

    private PrintStream out;

    private Administration() {
        out = new PrintStream(System.out);
    }

    private void scanStudentsName(String name) {
        out.printf("%s ", name);
    }

    private void scanStudentsScores(Scanner scanner) {
        double scores;
        double totalScore = 0;
        double averaScore = 0;
        int counter = 0;

        while (scanner.hasNext()) {
            scores = scanner.nextInt();
            totalScore = totalScore + scores;
            counter++;
        }

        averaScore = totalScore / counter;

        if (averaScore >= 5.5 && averaScore < 6) {
            out.printf("has an average of 6-");
            return;
        } else {
            double averaScoreRounded = ((int) ((averaScore * 2) + 0.5)) / 2.0;
            if (averaScore % 1 == 0) {
                out.printf("has an average of %.0f", averaScoreRounded);
            } else {
                out.printf("has an average of %.1f", averaScoreRounded);
            }
        }
    }

    private void scanStudentsSimilarScores(Scanner scanner) {
        scanner.useDelimiter("=");

        out.print("\n\t");
        while (scanner.hasNextInt()) {
            int similarScores = scanner.nextInt();

            if (similarScores == 0) {
                out.printf("_");
            } else if (similarScores >= 20) {
                out.printf("^");
            } else if (similarScores < 20 && similarScores > 0) {
                out.printf("-");
            }

        }
        out.print("\n");
    }

    private void scanOtherStudentsName(Scanner scanner) {
        scanner.useDelimiter(",");
        while (scanner.hasNext()) {
            String otherName = scanner.next();

            if (otherName != null) {
                out.printf("\t%s\n", otherName);
            } else {
                out.printf("No other matches found");

            }
        }
    }

    private void scannerFile() {
        Scanner file = UIAuxiliaryMethods.askUserForInput().getScanner();

        while (file.hasNextLine()) {

            String firstLine = file.nextLine();
            Scanner scannerFirstLine = new Scanner(firstLine).useDelimiter("_+");
            scanStudentsName(scannerFirstLine.next());
            scanStudentsScores(new Scanner(scannerFirstLine.next()));

            String secondLine = file.nextLine();
            Scanner scannerSecondLine = new Scanner(secondLine).useDelimiter(";");
            scanStudentsSimilarScores(new Scanner(scannerSecondLine.next()));
            if (scannerSecondLine.hasNext()) {
                scanOtherStudentsName(new Scanner(scannerSecondLine.next()));
            }
        }
    }

    private void start() {
        scannerFile();

    }

    public static void main(String[] args) {
        new Administration().start();
    }

}

