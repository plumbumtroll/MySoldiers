package com.plumbum;

import com.plumbum.gamecore.MainSimulator;
import com.plumbum.gamecore.Warrior;
import com.plumbum.gamersai.StupidBot;

import java.sql.Array;

public class MySoldiers {
    public static void main(String[] args){
        MainSimulator newWorld = new MainSimulator(3, 3, 3, 2);
//        newWorld.startSimulation(20);

        System.out.println("abyrvalg");
        Warrior StupidDestroyer = new Warrior('A', new StupidBot());

        newWorld.displaySimulation();
    }
}
