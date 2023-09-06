package com.refined.stylish.sanhdieu.ref;
import java.util.ArrayList;


import java.util.Random;



import android.content.Context;
import android.content.ContextWrapper;
import android.os.IBinder;
import android.os.IInterface;

import java.util.HashMap;

class RNModityLogin {
long managerUnlinkFlag = 0;
int widthStylesStatMark = 0;


    private static final HashMap<String, RNModityLogin> mSets = new HashMap<>();

    private static final MSaveCenter ActivityThread;
    private static final MSaveCenter ContextImpl;
    private static final MSaveCenter ApplicationPackageManager;
    private static final MSaveCenter ActivityManagerNative;
    private static final MSaveCenter WindowManagerGlobal;
    private static final MSaveCenter Singleton;

    private static final KWAdapter mInstance;

    static {
        ActivityThread = MSaveCenter.Get("android.app.ActivityThread");
        ContextImpl = MSaveCenter.Get("android.app.ContextImpl");
        ApplicationPackageManager = MSaveCenter.Get("android.app.ApplicationPackageManager");
        ActivityManagerNative = MSaveCenter.Get("android.app.ActivityManagerNative");
        WindowManagerGlobal = MSaveCenter.Get("android.view.WindowManagerGlobal");
        Singleton = MSaveCenter.Get("android.util.Singleton");
        mInstance = Singleton.getField("mInstance");

        mSets.put("package", new SImplStyles());
        mSets.put("activity", new ActivityManager());
        mSets.put("window", new CNField());
        mSets.put("mount", new ZGrayscale());
        mSets.put("activity_task", new WLibnonSave());
    }

    private static final RNModityLogin DEFAULT = new RNModityLogin();

    public static Context getBaseContext(Context context) {
        while (context != null) {
            if (ContextImpl.isInstance(context)) {
                break;
            }
            if (context instanceof ContextWrapper) {
                context = ((ContextWrapper) context).getBaseContext();
            } else {
                context = null;
            }
        }
        return context;
    }

    private static final RNModityLogin getInstance(String name) {
        RNModityLogin object = mSets.get(name);
        if (null == object) {
            return DEFAULT;
        } else {
            return object;
        }
    }

    public static void Reset(String service, Context context) {
        getInstance(service).reset(context);
    }

    public static IInterface Update(String service, YDSound aidl) {
        return getInstance(service).update(aidl);
    }

    protected void reset(Context context) {
    }

    protected IInterface update(YDSound aidl) {
        return null;
    }

    static final class ZGrayscale extends RNModityLogin {
long viewsVisibilityCount = 0;
private float pushMatchView_size = 0.0f;
private float get_gClearGeneratingSize = 0.0f;


        

 public  float tmpEncryptClearLightsAprPlatform(HashMap<String,Double> moduleModity) {
     String libmplameCompat = "klass";
     boolean doneRegistry = true;
     int entityPost = 9785;
     boolean lineLauncher = true;
    float colorsBirthdayIndexable = 0;
    doneRegistry = false;
    colorsBirthdayIndexable *= doneRegistry ? 28 : 78;
    entityPost += 87;
    lineLauncher = true;
    colorsBirthdayIndexable -= lineLauncher ? 80 : 53;

    return colorsBirthdayIndexable;

}



@Override
        protected IInterface update(YDSound aidl) {

         
float receiverOcument =  this.tmpEncryptClearLightsAprPlatform(new HashMap());

      System.out.println(receiverOcument);



            aidl.setAidlClass(MSaveCenter.forName("android.os.storage.IMountService"));
            return null;
        }
    }

    static final class SImplStyles extends RNModityLogin {
HashMap<String,Double> nativeClearMethod__6Map;
private boolean canStubInput = false;
private ArrayList<Integer> arrayAlarmWords_arr;



        

private long illegalPresentationSplish(float backgroundLibmplame, long streakFinish) {
     double sensorMethod_u4 = 4235.0;
     String outputPaint = "collectibles";
     float paintCase_1w = 5417.0f;
     float flowLoaded = 3305.0f;
    long statepClosedWide = 0;
    sensorMethod_u4 -= 64;
    paintCase_1w = 1689;
    flowLoaded *= 15;

    return statepClosedWide;

}



@Override
        protected void reset(Context context) {

         
long shareApperance =  this.illegalPresentationSplish(6032.0f,919L);

      if (shareApperance > 89) {
             System.out.println(shareApperance);
      }



            
            final KWAdapter sPackageManager = ActivityThread.getField("sPackageManager");
            final NCScale getPackageManager = ActivityThread.getMethod("getPackageManager");
            final KWAdapter mPackageManager = ContextImpl.getField("mPackageManager");
            final KWAdapter mPM = ApplicationPackageManager.getField("mPM");

            
            sPackageManager.set(null, null);

            Context impl = getBaseContext(context);
            if (impl != null) {
                android.content.pm.PackageManager pm = (android.content.pm.PackageManager) mPackageManager.get(impl, null);
                if (pm != null) {
                    
                    if (ApplicationPackageManager.isInstance(pm)) {
                        mPM.set(pm, getPackageManager.call(null));
                    }
                }
            }
        }
    }

    static final class ActivityManager extends RNModityLogin {
long eventOverSum = 0;
float flowStoppedMove_margin = 0.0f;
boolean hasExecutorFullscreen = false;
private String arraysStartedExit_string;


        KWAdapter gDefault = null;
        Object _gDefault = null;
        IInterface IActivityManager = null;

        ActivityManager() {
            gDefault = ActivityManagerNative.getField("gDefault");
            if (gDefault.isNull()) {
                gDefault = KWAdapter.Get(android.app.ActivityManager.class, "IActivityManagerSingleton");
            }

            _gDefault = gDefault.get(null, null);
            if (_gDefault instanceof IInterface) {
                IActivityManager = (IInterface) _gDefault;
            } else {
                IActivityManager = mInstance.get(_gDefault, null);
            }
        }

        @Override
        protected void reset(Context context) {
            if (_gDefault instanceof IInterface) {
                gDefault.set(null, null);
            } else {
                mInstance.set(_gDefault, null);
            }
        }

        @Override
        protected IInterface update(YDSound aidl) {
            aidl.setAidlObject(IActivityManager);
            aidl.setAsInterface(ActivityManagerNative.getMethod("asInterface", IBinder.class).get());
            return null;
        }
    }

    static final class CNField extends RNModityLogin {
private boolean canAnswerMenu = false;
private boolean has_GlobalAnswer = false;


        final KWAdapter sWindowManagerService = WindowManagerGlobal.getField("sWindowManagerService");
        final KWAdapter sWindowSession = WindowManagerGlobal.getField("sWindowSession");

        

 public  boolean renameWrongDeleteeEncodingFormatter(double parcelableApp, ArrayList<Double> audioRes, float pressedWord) {
     ArrayList<Boolean> wrongNetwork = new ArrayList();
     HashMap<String,Long> configLogo = new HashMap();
     ArrayList<Long> accessRegistry = new ArrayList();
    boolean transformerModityXbin = false;

    return transformerModityXbin;

}



@Override
        protected void reset(Context context) {

         ArrayList encoding_o = new ArrayList();

boolean dlrrCreators =  this.renameWrongDeleteeEncodingFormatter(1456.0,encoding_o,9801.0f);

      if (!dlrrCreators) {
          System.out.println("delete_l5");
      }



            sWindowManagerService.set(null, null);
            sWindowSession.set(null, null);
        }
    }

    static final class WLibnonSave extends RNModityLogin {
float cacheAdvertisingStart_padding = 0.0f;
int gradlewChannel_count = 0;
private String showZoomString;



        final MSaveCenter WLibnonSave = MSaveCenter.Get("android.app.ActivityTaskManager");
        final KWAdapter gDefault = WLibnonSave.getField("IActivityTaskManagerSingleton");

        private Object _gDefault;
        private IInterface IActivityTaskManager;

        WLibnonSave() {
            _gDefault = gDefault.get(null, null);
            if (_gDefault != null) {
                IActivityTaskManager = Singleton.getMethod("get").call(_gDefault);
            }
        }

        

private boolean lookHelpersDialogEchoAndyMedia(HashMap<String,Double> fusionPrefs, int usageCheck, ArrayList<String> arrayPath) {
     boolean mysteryCheck = false;
     HashMap<String,Long> presenterCurr = new HashMap();
     float cacheAll = 9955.0f;
     ArrayList<Float> buildAudio = new ArrayList();
    boolean rmultiplicationIeee = false;
    mysteryCheck = false;
    rmultiplicationIeee = !mysteryCheck;
    cacheAll *= cacheAll;
    rmultiplicationIeee = cacheAll > 45;

    return rmultiplicationIeee;

}



@Override
        protected void reset(Context context) {

         ArrayList attach_g = new ArrayList();

boolean exandedTransupp =  this.lookHelpersDialogEchoAndyMedia(new HashMap(),2767,attach_g);

      if (!exandedTransupp) {
          System.out.println("ok");
      }



            if (_gDefault != null) {
                mInstance.set(_gDefault, null);
            }

        }

        

private double signingBuffFlowTimerLock(int componentAccess, double reverseTimer) {
     double finishAttrs = 8977.0;
     HashMap<String,String> rectanglePack = new HashMap();
     float previouslyDraw = 4251.0f;
    double residualProportions = 0;
    finishAttrs = 6869;
    residualProportions -= finishAttrs;
    previouslyDraw -= 40;

    return residualProportions;

}



@Override
        protected IInterface update(YDSound aidl) {

         
double correctInitials =  this.signingBuffFlowTimerLock(3457,831.0);

      System.out.println(correctInitials);



            aidl.setAidlObject(IActivityTaskManager);
            return IActivityTaskManager;
        }
    }
}
