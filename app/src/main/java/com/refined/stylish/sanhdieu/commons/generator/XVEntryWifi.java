package com.refined.stylish.sanhdieu.commons.generator;
import java.util.Random;


import java.util.HashMap;



import com.refined.stylish.sanhdieu.commons.CYZModuleSlide;
import com.refined.stylish.sanhdieu.commons.Util;

import java.util.ArrayList;
import java.util.List;

 

public class XVEntryWifi extends YBFile<List<String>, List<String>> {
private String scaleEntryRevealStr;
private int cacheCorrect_sum = 0;




    private static final int MIN_GRID_ITERATION_ATTEMPT = 1;

    @Override
    public List<String> setGrid(List<String> dataInput, char[][] grid) {

        List<String> usedStrings = new ArrayList<>();
        int usedCount;
        for (int i = 0; i < MIN_GRID_ITERATION_ATTEMPT; i++) {

            usedCount = 0;
            usedStrings.clear();
            resetGrid(grid);
            for (String word : dataInput) {
                if (tryPlaceWord(word, grid)) {
                    usedCount++;
                    usedStrings.add(word);
                }
            }

            if (usedCount >= dataInput.size())
                break;
        }

        Util.fillNullCharWidthRandom(grid);
        return usedStrings;
    }

    

 public  int aesModeGridValsDependency() {
     int requiredProcessor = 9296;
     int stylesBuffer = 3544;
     float roundDelegate_h = 1081.0f;
     double size_oPackage = 6848.0;
    int formatuInternationally = 0;
    requiredProcessor *= requiredProcessor;
    requiredProcessor += stylesBuffer;
    formatuInternationally *= requiredProcessor;
    stylesBuffer = requiredProcessor + stylesBuffer;
    formatuInternationally *= stylesBuffer;
    roundDelegate_h += 10;
    size_oPackage = 8581;

    return formatuInternationally;

}



private CYZModuleSlide getRandomDirection() {

         
int transparentCycleclock =  this.aesModeGridValsDependency();

   if (transparentCycleclock > 3) {
      for (int t_q = 0; t_q < transparentCycleclock; t_q++) {
          if (t_q == 2) {
              System.out.println(t_q);
              break;
          }
      }
  }



        CYZModuleSlide dir;
        do {
            dir = CYZModuleSlide.values()[ Util.getRandomInt() % CYZModuleSlide.values().length ];
        } while (dir == CYZModuleSlide.NONE);
        return dir;
    }

    private boolean tryPlaceWord(String word, char gridArr[][]) {
        CYZModuleSlide startDir = getRandomDirection();
        CYZModuleSlide currDir = startDir;

        int row;
        int col;
        int startRow;
        int startCol;

         
        do {

             
            startRow = Util.getRandomInt() % gridArr.length;
            row = startRow;
            do {

                 
                startCol = Util.getRandomInt() % gridArr[0].length;
                col = startCol;
                do {

                    if (isValidPlacement(row, col, currDir, gridArr, word)) {
                        placeWordAt(row, col, currDir, gridArr, word);
                        return true;
                    }

                    col = (++col) % gridArr[0].length;
                } while (col != startCol);

                row = (++row) % gridArr.length;
            } while (row != startRow);

            currDir = currDir.nextDirection();
        } while (currDir != startDir);

        return false;
    }

     
    private boolean isValidPlacement(int row, int col, CYZModuleSlide dir, char gridArr[][], String word) {
        int wLen = word.length();
        if (dir == CYZModuleSlide.EAST && (col + wLen) >= gridArr[0].length) return false;
        if (dir == CYZModuleSlide.WEST && (col - wLen) < 0) return false;

        if (dir == CYZModuleSlide.NORTH && (row - wLen) < 0) return false;
        if (dir == CYZModuleSlide.SOUTH && (row + wLen) >= gridArr.length) return false;

        if (dir == CYZModuleSlide.SOUTH_EAST && ((col + wLen) >= gridArr[0].length || (row + wLen) >= gridArr.length)) return false;
        if (dir == CYZModuleSlide.NORTH_WEST && ((col - wLen) < 0 || (row - wLen) < 0)) return false;

        if (dir == CYZModuleSlide.SOUTH_WEST && ((col - wLen) < 0 || (row + wLen) >= gridArr.length)) return false;
        if (dir == CYZModuleSlide.NORTH_EAST && ((col + wLen) >= gridArr[0].length || (row - wLen) < 0)) return false;

        for (int i = 0; i < wLen; i++) {
            if (gridArr[row][col] != Util.NULL_CHAR && gridArr[row][col] != word.charAt(i))
                return false;
            col += dir.xOff;
            row += dir.yOff;
        }

        return true;
    }

     
    private void placeWordAt(int row, int col, CYZModuleSlide dir, char gridArr[][], String word) {
        for (int i = 0; i < word.length(); i++) {
            gridArr[row][col] = word.charAt(i);

            col += dir.xOff;
            row += dir.yOff;
        }
    }
}
