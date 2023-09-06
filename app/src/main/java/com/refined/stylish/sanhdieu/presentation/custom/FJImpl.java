
package com.refined.stylish.sanhdieu.presentation.custom;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import java.util.Observable;

 

public abstract class FJImpl extends Observable {

    public abstract int getColCount();
    public abstract int getRowCount();
    public abstract char getLetter(int row, int col);

}
