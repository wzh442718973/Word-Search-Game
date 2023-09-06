
package com.refined.stylish.sanhdieu.commons.generator;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



 

public abstract class YBFile<InputType, OutputValue> {

    public abstract OutputValue setGrid(InputType dataInput, char grid[][]);

    protected void resetGrid(char grid[][]) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = '\0';
            }
        }
    }

}
