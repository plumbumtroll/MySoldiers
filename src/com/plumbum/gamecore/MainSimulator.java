package com.plumbum.gamecore;

import com.plumbum.gamersai.StupidBot;
import java.awt.*;

public class MainSimulator {

    int[][] map;

    Point[] firstCommand;
    Point[] secondCommand;

    IBot firstAI;
    IBot secondAI;

    public void initWorld(int commandSize, int mapHeight, int mapWidth) {

        firstAI = new StupidBot();
        secondAI = new StupidBot();
    }

    public void startSimulation(int duration) {

        Point з = new Point(1, 2);

        for (int i = 0; i < duration; i++) {

            for (int j = 0; j < firstCommand.length; j++) {

                int result = firstAI.toDoMove(map);

                switch (result) {
                    case (0):
                        // логика обработки того, как солдатик стоит на месте
                        break;
                    case (1):
                        // и т. д.
                        break;
                    case (2):
                        // и т. д.
                        break;
                }
            }

            for (int j = 0; j < secondCommand.length; j++) {

                int result = secondAI.toDoMove(map);
                switch (result) {
                    case (0):
                        // логика обработки того, как солдатик стоит на месте
                        break;
                    case (1):
                        // и т. д.
                        break;
                    case (2):
                        // и т. д.
                        break;
                }
            }
        }
    }
}
