package com.plumbum.gamecore;

public class Cell {
    private Warrior localWarrior;

    @Override
    public String toString() {
        if (localWarrior == null) {
            return "*";
        } else {
            return String.valueOf(localWarrior.commandSymbol);
        }
    }

    public Cell(){

    }
}
