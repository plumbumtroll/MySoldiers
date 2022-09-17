package com.plumbum.gamecore.utils;

import com.plumbum.gamecore.entities.Vector;

import java.awt.*;

public class Operations {
    public static Point addVector(Point point, Vector vector){
        return new Point(point.x + vector.dx, point.y + vector.dy);
    }

}
