
package com.refined.stylish.sanhdieu.ak;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



 
public interface XFusionSecurity {
    void adCfgLoad();

    void adCfgSave();

    boolean adCfgUpdate(String cfgJson);

    void adInit(String adKey, GStatStyles init);

    OXSensor adSelector(String adKey, GAReversePreference rely);

    void adShowBegin(String adKey, boolean showExit);

    void adShowEnd(String adKey, boolean success);
}
