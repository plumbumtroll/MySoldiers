package com.plumbum.gamecore;

public class Warrior {
    public final char commandSymbol;

    public final IBot behaviour;

    public Warrior(char commandSymbol, IBot behaviour) {
        this.commandSymbol = commandSymbol;
        this.behaviour = behaviour;
    }

    public IBot getBehaviour(){
        return behaviour;
    }
}
