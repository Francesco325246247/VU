package replay1;

import ui.OthelloReplayUserInterface;
import ui.UIAuxiliaryMethods;
import ui.UserInterfaceFactory;

import java.util.Scanner;

/**
 * Created by Francesco Cozzolino on 20/09/2016.
 */

public class Replay1 {

    private OthelloReplayUserInterface ui;

    private Replay1() {
        UserInterfaceFactory.enableLowResolution(true);
        ui = UserInterfaceFactory.getOthelloReplayUI();

    }

    public static void main(String[] args) {
        new Replay1().start();
    }

    private void watchReplay() {

        Scanner replayFile = UIAuxiliaryMethods.askUserForInput().getScanner();
        Scanner readElement;

        String readLine;
        String stoneColor;
        String playerMove;
        String x_axis_letter;
        int waitingTime;
        int y_axis;
        int x_axis;
        int setStoneColor = 0;

        while (replayFile.hasNextLine()) {

            readLine = replayFile.nextLine();
            readElement = new Scanner(readLine);

            stoneColor = readElement.next();
            waitingTime = readElement.nextInt();
            playerMove = readElement.next();

            if (playerMove.equals("move")) {
                x_axis_letter = readElement.next();

                y_axis = readElement.nextInt();
                x_axis = x_axis_letter.charAt(0) - 96;

                if (stoneColor.equals("black"))
                    setStoneColor = 2;
                else if (stoneColor.equals("white"))
                    setStoneColor = 1;

                ui.place(x_axis - 1, y_axis - 1, setStoneColor);
                ui.showChanges();
                ui.wait(waitingTime);

            }

        }
        replayFile.close();
    }

    private void placeFourStones() {

        final int BLACKSTONECOLOR = 2;
        final int WHITESTONECOLOR = 1;
        int msWait = 3000;

        ui.place(4, 4, WHITESTONECOLOR);
        ui.place(3, 3, WHITESTONECOLOR);
        ui.place(3, 4, BLACKSTONECOLOR);
        ui.place(4, 3, BLACKSTONECOLOR);

        ui.showChanges();
        ui.wait(msWait);
    }

    private void start() {

        placeFourStones();
        watchReplay();

    }

}


