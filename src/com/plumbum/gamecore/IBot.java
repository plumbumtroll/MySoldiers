package com.plumbum.gamecore;

import com.plumbum.gamecore.actions.Action;

public interface IBot {

    Action toDoMove(Cell[][] information);
}
