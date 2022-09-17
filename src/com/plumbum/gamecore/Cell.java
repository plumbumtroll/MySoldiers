package com.plumbum.gamecore;

public class Cell {
    public Warrior localWarrior;

    @Override
    public String toString() {
        if (localWarrior == null) {
            return ".";
        } else {
            return String.valueOf(localWarrior.commandSymbol);
        }
    }

    public void placeWarrior(Warrior placedWarrior) {
        localWarrior = placedWarrior;
    }
}
