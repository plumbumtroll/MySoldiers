package com.plumbum.gamecore.actions;

import com.plumbum.gamecore.entities.Vector;

public class Movement extends Action {

    public Vector movementVector;
    Cell Target; // оно нам нужно?

    public Movement(int x, int y) {
        movementVector = new Vector(x, y);
    }
}
