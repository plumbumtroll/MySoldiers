package com.plumbum.gamecore;

import com.plumbum.gamersai.StupidBot;

public class MainSimulator {

    int viewRadius;

    Cell[][] map;
    Warrior[] population;

    public MainSimulator(int commandSize, int mapWidthX, int mapHeightY, int viewRadius) {
        map = new Cell[mapWidthX][mapHeightY];
        for (int x = 0; x < mapWidthX; x++) {
            for (int y = 0; y < mapHeightY; y++) {
                map[x][y] = new Cell();
            }
        }

        IBot firstAI = new StupidBot();
        IBot secondAI = new StupidBot();

        population = new Warrior[commandSize * 2];
        for (int i = 0; i < commandSize; i++) {
            population[i] = new Warrior ('H', firstAI);
        }
        for (int i = commandSize; i < commandSize * 2; i++) {
            population[i] = new Warrior ('R', secondAI);
        }
    }

    public int getWidth () {
        return map[0].length;
    }
    public int getHeight () {
        return map.length;
    }

    public void displaySimulation () {
        for (int y = 0; y < this.getWidth(); y++) {
            for (int x = 0; x < this.getHeight(); x++) {
                System.out.print(map[x][y]);
            }
            System.out.println();
        }
    }

    public void startSimulation(int duration) {

        for (int i = 0; i < duration; i++) {

            for (Warrior warrior : population) {

                IBot behaviour = warrior.getBehaviour();
                // todo: реализовать ограниченный обзор для каждого челика и передачу этой информации в объект behaviour

                int result = behaviour.toDoMove(map);

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
