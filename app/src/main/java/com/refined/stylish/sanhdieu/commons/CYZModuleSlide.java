
package com.refined.stylish.sanhdieu.commons;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



 

public enum CYZModuleSlide {
    NONE(0, 0),
    EAST(1, 0),
    WEST(-1, 0),
    NORTH(0, -1),
    SOUTH(0, 1),
    SOUTH_EAST(1, 1),
    NORTH_WEST(-1, -1),
    SOUTH_WEST(-1, 1),
    NORTH_EAST(1, -1);

    public final int xOff;
    public final int yOff;

    CYZModuleSlide(int xOff, int yOff) {
        this.xOff = xOff;
        this.yOff = yOff;
    }

    public CYZModuleSlide nextDirection() {
        int idx = (ordinal() + 1) % values().length;
        if (values()[idx] == NONE)
            idx++;
        return values()[idx];
    }

    public static CYZModuleSlide fromLine(CTVLocalLibjcore start, CTVLocalLibjcore end) {

         
        if (start.row == end.row && start.col != end.col) {
            if (start.col < end.col) return EAST;
            else return WEST;
        }
         
        else if (start.col == end.col && start.row != end.row) {
            if (start.row < end.row) return SOUTH;
            else return NORTH;
        }
        else {
            int diffX = Math.abs(start.col - end.col);
            int diffY = Math.abs(start.row - end.row);

             
            if (diffX == diffY && diffX != 0) {
                if (start.col < end.col && start.row < end.row) return SOUTH_EAST;
                if (start.col > end.col && start.row > end.row) return NORTH_WEST;
                if (start.col > end.col && start.row < end.row) return SOUTH_WEST;
                else return NORTH_EAST;
            }
        }

        return NONE;
    }
}