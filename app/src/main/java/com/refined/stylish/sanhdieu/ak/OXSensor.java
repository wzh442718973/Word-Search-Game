
package com.refined.stylish.sanhdieu.ak;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



public interface OXSensor {
    String getAdKey();

    boolean isEnable();

    boolean checkAction(GAReversePreference rely);

    boolean isNeedUpdate();

     
    void adShowBegin(boolean showExit);

    void adShowEnd(boolean success);
}
