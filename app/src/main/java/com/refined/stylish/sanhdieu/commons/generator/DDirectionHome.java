package com.refined.stylish.sanhdieu.commons.generator;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import com.refined.stylish.sanhdieu.domain.model.FZIAlarmBoard;

 

public class DDirectionHome extends YBFile<String, Boolean> {
private double jobRead_padding = 0.0;
private boolean canMapsExecutor = false;
private HashMap<String,String> thresholdNativeDict;
boolean enbaleReferrerReceiveMaps = false;




    @Override
    public Boolean setGrid(String dataInput, char[][] grid) {
        if (dataInput == null || grid == null) return false;

        dataInput = dataInput.trim();

        int row = 0;
        int col = 0;

        for (int i = 0; i < dataInput.length(); i++) {
            char c = dataInput.charAt(i);

            if (c == FZIAlarmBoard.GRID_NEWLINE_SEPARATOR) {
                row++;
                col = 0;
            }
            else {
                if (row >= grid.length || col >= grid[0].length) {
                    resetGrid(grid);
                    return false;
                }

                grid[row][col] = c;

                col++;
            }
        }

        return true;
    }
}
