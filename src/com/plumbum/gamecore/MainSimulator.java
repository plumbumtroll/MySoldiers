package com.plumbum.gamecore;

import com.plumbum.gamecore.actions.Action;
import com.plumbum.gamecore.actions.Movement;
import com.plumbum.gamecore.utils.Operations;
import com.plumbum.gamersai.StupidBot;

import java.awt.*;

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

        Point p = new Point(0, 0);
        for (int i = 0; i < commandSize; i++) {
            Warrior currentWarrior = population[i];
            map[p.x][p.y].placeWarrior(currentWarrior);
            p.x++;
            if (p.x >= getWidth()){
                p.x = 0;
                p.y++;
            }
        }

        p.move(getWidth() - 1, getHeight() - 1);
        for (int i = 0; i < commandSize; i++) {
            Warrior currentWarrior = population[i+commandSize];
            map[p.x][p.y].placeWarrior(currentWarrior);
            p.x--;
            if (p.x < 0){
                p.x = getWidth() - 1;
                p.y--;
            }
        }
    }

    public int getWidth() {
        return map.length;
    }

    public int getHeight() {
        return map[0].length;
    }

    public Cell getCell(int x, int y) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight())
            return null;

        return map[x][y];
    }

    public Cell getCell(Point point) {
        return this.getCell(point.x, point.y);
    }

    public void displaySimulation () {
        for (int y = 0; y < this.getHeight(); y++) {
            for (int x = 0; x < this.getWidth(); x++) {
                System.out.print(getCell(x, y));
            }
            System.out.println();
        }
    }

    public void startSimulation(int duration) {

        for (int i = 0; i < duration; i++) {
            makeOneTick();
            this.displaySimulation();
            System.out.println();
        }
    }

    public void makeOneTick() {
        for (int x = 0; x < getWidth(); x++) {
            for (int y = 0; y < getHeight(); y++) {
                // todo: реализовать ограниченный обзор для каждого челика и передачу этой информации в объект behaviour
                Warrior warrior = getCell(x, y).localWarrior;
                if (warrior == null)
                    continue;

                Action result = warrior.behaviour.toDoMove(map);

                Point currentPoint = new Point(x, y);

                if (result instanceof Movement movement) {
                    Cell targetCell = this.getCell(Operations.addVector(currentPoint, movement.movementVector));
                    if (targetCell != null && targetCell.localWarrior == null) {
                        targetCell.placeWarrior(warrior);
                        this.getCell(x, y).localWarrior = null;
                    }

                    // todo: реализовать движение с промежуточным буфером поля
                }

                // todo: обработка хода солдатика
            }
        }
    }
}
