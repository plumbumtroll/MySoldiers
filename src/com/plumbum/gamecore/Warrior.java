package com.plumbum.gamecore;

public class Warrior {
    private char commandSymbol;
    private IBot behaviour;

    public Warrior(char commandSymbol, IBot behaviour) {
        this.commandSymbol = commandSymbol;
        this.behaviour = behaviour;
    }

    public IBot getBehaviour(){
        return behaviour;
    }
}
