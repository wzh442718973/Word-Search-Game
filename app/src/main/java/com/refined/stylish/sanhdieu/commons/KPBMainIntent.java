
package com.refined.stylish.sanhdieu.commons;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import java.util.Locale;

 

public abstract class KPBMainIntent {

    public static String fromInteger(int duration) {
        if (duration <= 0)
            return "00:00";

        int secs = duration % 60;
        int min = duration / 60;

        return String.format(Locale.US, "%02d:%02d", min, secs);
    }

}
