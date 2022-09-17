package com.plumbum;

import com.plumbum.gamecore.MainSimulator;
import com.plumbum.gamecore.Warrior;
import com.plumbum.gamersai.StupidBot;

import java.sql.Array;

public class MySoldiers {
    public static void main(String[] args){
        MainSimulator newWorld = new MainSimulator(34, 20, 10, 2);

        newWorld.displaySimulation();
    }
}
