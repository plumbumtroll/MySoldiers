package com.plumbum.gamecore;

import com.plumbum.gamersai.StupidBot;
import java.awt.*;
import java.sql.Array;
import java.util.Arrays;

public class MainSimulator {

    Cell[][] map;
    Warrior[] population;

    IBot firstAI;
    IBot secondAI;

    public MainSimulator(int commandSize, int mapWidthX, int mapHeightY) {
        map = new Cell[mapWidthX][mapHeightY];
        for (int x = 0; x < mapWidthX; x++) {
            for (int y = 0; y < mapHeightY; y++) {
                map[x][y] = new Cell();
            }
        }
        population = new Warrior[commandSize * 2];
        for (int i = 0; i < (commandSize - 1); i++) {
            population[i] = new Warrior ('H');
        }
        for (int i = commandSize; i < (commandSize * 2 - 1); i++) {
            population[i] = new Warrior ('R');
        }

        firstAI = new StupidBot();
        secondAI = new StupidBot();
    }

    public void displaySimulation () {
        System.out.println(Arrays.toString(map));

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
