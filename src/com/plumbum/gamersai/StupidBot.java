package com.plumbum.gamersai;

import com.plumbum.gamecore.Cell;
import com.plumbum.gamecore.IBot;
import com.plumbum.gamecore.actions.Action;
import com.plumbum.gamecore.actions.Movement;

import java.util.Random;

public class StupidBot implements IBot {

    Random random;

    public StupidBot(){
        random = new Random();
    }

    @Override
    public Action toDoMove(Cell[][] information) {
        return new Movement(random.nextInt( 3) - 1, random.nextInt( 3) - 1);
    }
}