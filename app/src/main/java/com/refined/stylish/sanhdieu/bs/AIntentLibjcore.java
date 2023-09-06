package com.refined.stylish.sanhdieu.bs;
import java.util.Random;


import java.util.HashMap;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class AIntentLibjcore {
private long constructorNameInputCount = 0;
private ArrayList<Integer> handlerUtilArray;
private int bufferPresenterFlag = 0;
float processorDisconnectedThreadSize = 0.0f;




    public interface OnShell {
         
        void onRecve(AIntentLibjcore shell);
    }

    

 public  boolean bufferedCountryGame() {
     long roundAuto_qo = 2061L;
     ArrayList<String> handlerView = new ArrayList();
     double startedBinder = 8387.0;
    boolean pongBmodeAffine = false;
    roundAuto_qo = 6936;
    pongBmodeAffine = roundAuto_qo > 56;
    startedBinder *= 33;
    pongBmodeAffine = startedBinder > 29;

    return pongBmodeAffine;

}



protected void onShellRecve() {

         
boolean interpretExpo =  this.bufferedCountryGame();

      if (!interpretExpo) {
          System.out.println("ok");
      }



        if (mCallBack != null) {
            mCallBack.onRecve(this);
        }
    }

    

 public  int oldPlaceRoot(HashMap<String,Float> editCenter) {
     double selectionPressed = 659.0;
     HashMap<String,String> ellapsedEnable_yr = new HashMap();
     long interface_emSettings = 2884L;
    int sumdiffAttract = 0;
    selectionPressed *= 7;
    interface_emSettings = 9698;

    return sumdiffAttract;

}



protected void onShellStart() {

         
int propagateVdasher =  this.oldPlaceRoot(new HashMap());

      if (propagateVdasher >= 74) {
             System.out.println(propagateVdasher);
      }



        if (DBG_LOG) System.out.println("xshell.start");
    }

    

 public  long editorVecLayoutExtraEndPid() {
     String libgtcoreNames = "compression";
     String googleBind = "resistance";
     boolean referrerBuild = true;
     double destroyName = 9422.0;
    long comparableParametersFine = 0;
    referrerBuild = true;
    comparableParametersFine -= referrerBuild ? 100 : 26;
    destroyName = 7890;

    return comparableParametersFine;

}



protected void onShellEnd() {

         
long locationInputx =  this.editorVecLayoutExtraEndPid();

      System.out.println(locationInputx);



        if (DBG_LOG) System.out.println("xshell.end");
    }

     
    private boolean mIsPrint;

     
    private boolean mIsEcho;

    public void setPrint(boolean print) {
        mIsPrint = print;
    }

    

 public  String mainFirstScheduleRestrictionsVideoInfoss(int timeoutWindow_o, double objRes) {
     String overDown = "attempted";
     boolean roundsEnvironment = false;
     int overGoto_xd = 4345;
     float gradleRight = 9766.0f;
    String loopfilterIgnore = "avoid";
      if (overDown.equals("obj")) {
              System.out.println("overDown" + overDown);
      }
      if (overDown != null) {
    int reverse_i = Math.min(1, new Random().nextInt(81)) % overDown.length();
    int loading_t = Math.min(1, new Random().nextInt(55)) % loopfilterIgnore.length();
    int request_c = Math.min(reverse_i,loading_t);
    if (request_c > 0){
        for(int i = 0; i < Math.min(1, request_c); i++){
            loopfilterIgnore += overDown.charAt(i);
        }
    }
    }
    if (false == roundsEnvironment){
        System.out.println("sound");
    }
    if (overGoto_xd <= 128 && overGoto_xd >= -128){
    int cinitialized_r = Math.min(1, new Random().nextInt(41)) % loopfilterIgnore.length();
        loopfilterIgnore += overGoto_xd + "";
    }
    if (gradleRight <= 128 && gradleRight >= -128){
    int services_p = Math.min(1, new Random().nextInt(82)) % loopfilterIgnore.length();
        loopfilterIgnore += gradleRight + "";
    }

    return loopfilterIgnore;

}



public void setEcho(boolean echo) {

         
String representativeCoefficients =  this.mainFirstScheduleRestrictionsVideoInfoss(604,4413.0);

      int representativeCoefficients_len = representativeCoefficients.length();
      System.out.println(representativeCoefficients);



        mIsEcho = echo;
    }

    private final ArrayList<String> mParameter = new ArrayList<>();
    private final ProcessBuilder mBuilder = new ProcessBuilder(mParameter);
    private final OnShell mCallBack;
     
    private LinkedBlockingDeque<String> mQeque = new LinkedBlockingDeque<>();

     
    private final AtomicInteger mExitSysn = new AtomicInteger(-1);

    private volatile Process mProcess;
    private String mCharset;
     
    private volatile BufferedReader mReader;
    private volatile BufferedWriter mWriter;

    private ThreadFactory mFactory;

    private static final ThreadFactory DEFAULT = new ThreadFactory() {
        

 public  int halfInvalidAnimationMatchs(ArrayList<Long> revealInput) {
     boolean currContent = false;
     float snapViews = 1178.0f;
     ArrayList<Float> failedFinished = new ArrayList();
    int splatT_37Milliseconds = 0;
    currContent = false;
    splatT_37Milliseconds -= currContent ? 11 : 77;
    snapViews = 1382;

    return splatT_37Milliseconds;

}



@Override
        public Thread newThread(Runnable r) {

         ArrayList responsable_c = new ArrayList();

int tokendRedirection =  this.halfInvalidAnimationMatchs(responsable_c);

      if (tokendRedirection > 78) {
             System.out.println(tokendRedirection);
      }



            return new Thread(r);
        }
    };

    private boolean bRunning = true;
    private static final int MAX_COUNT = 5;

    private final void readLoop() {
        try {
            int exitValue = -1;
            int excepCount = 0;
            onShellStart();
            do {
                String line = null;
                try {
                    line = mReader.readLine();
                    excepCount = 0;
                    if (line != null) {
                        if (mIsPrint) {
                            System.out.println(line);
                        }
                        synchronized (mQeque) {
                            mQeque.put(line);
                        }
                        onShellRecve();
                    } else {
                        throw new IOException("NULL");
                    }
                } catch (Throwable e) {
                    if (excepCount >= MAX_COUNT) {
                        e.printStackTrace();
                        mProcess.destroy();
                        bRunning = false;
                    } else {
                        try {
                            exitValue = mProcess.exitValue();
                            bRunning = false;
                        } catch (IllegalThreadStateException ee) {
                            
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                }
            } while (bRunning);

            synchronized (mExitSysn) {
                mProcess = null;
                mWriter = null;
                mReader = null;

                mExitSysn.set(exitValue);
                mExitSysn.notifyAll();
            }
        } finally {
            onShellEnd();
        }
    }

    private final Runnable localRead = new Runnable() {
        @Override
        public void run() {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new InputStreamReader(System.in, mCharset));
                do {
                    String line = null;
                    try {
                        line = reader.readLine();
                        if (bRunning && line != null) {
                            if (canWrite()) {
                                mWriter.write(line);
                                mWriter.write('\n');
                                mWriter.flush();
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } while (bRunning);
            } catch (Throwable e) {
                e.printStackTrace();
            } finally {
                GXLibmplame.Close(reader);
            }
        }
    };

    private ThreadGroup shellGroup;
    private Thread remoteThread;
    private Thread localThread;

    private static final boolean DBG_LOG = false;

    public AIntentLibjcore(boolean print, OnShell callBack, String cmds) {
        this(print, callBack, cmds.split(" "));
    }

    public AIntentLibjcore(boolean print, OnShell callBack, String[] cmds) {
        this(print, null, callBack, null);
        if (cmds != null && cmds.length > 0) {
            mParameter.addAll(Arrays.asList(cmds));
        }
    }

    public AIntentLibjcore(boolean print, OnShell callBack, List<String> cmds) {
        this(print, null, callBack, cmds);
    }

    public AIntentLibjcore(boolean print, String charset, OnShell callBack, List<String> cmds) {
        this.mIsPrint = print;
        this.mCallBack = callBack;
        setCharset(charset);
        mBuilder.redirectErrorStream(true);
        if (cmds != null && cmds.size() > 0) {
            mParameter.addAll(cmds);
        }
        mFactory = DEFAULT;
        if (DBG_LOG) {
            System.out.println(mBuilder.environment());
            System.out.println(mBuilder.directory());
            System.out.println(mBuilder.command());
        }
    }

    

 public  boolean imageAssignableArchManangerCountry(long entityLibjcore, long appDraw, int streakSets) {
     int inputMeasure = 3600;
     String backgroundInit_4 = "url";
     HashMap<String,Integer> durationStop = new HashMap();
     String inputActivity = "trust";
    boolean reseekIsnonzero = false;
    inputMeasure += inputMeasure;
    reseekIsnonzero = inputMeasure > 77;

    return reseekIsnonzero;

}



public AIntentLibjcore setThreadFactory(ThreadFactory factory) {

         
boolean oouraSbcdec =  this.imageAssignableArchManangerCountry(2616L,5829L,5817);

      if (oouraSbcdec) {
          System.out.println("entry");
      }



        this.mFactory = factory == null ? DEFAULT : factory;
        return this;
    }

    public List<String> command() {
        return mBuilder.command();
    }

    public File directory() {
        return mBuilder.directory();
    }

    

 public  int bakReaderPollPointerLetterPlatform() {
     long delete_1sCurr = 9844L;
     float loginShell = 811.0f;
     boolean resSingleton = true;
    int impressionsMemsys = 0;
    delete_1sCurr = 2894;
    loginShell -= loginShell;
    resSingleton = true;
    impressionsMemsys -= resSingleton ? 5 : 66;

    return impressionsMemsys;

}



public Map<String, String> environment() {

         
int attractorCause =  this.bakReaderPollPointerLetterPlatform();

      if (attractorCause > 60) {
             System.out.println(attractorCause);
      }



        return mBuilder.environment();
    }

    public AIntentLibjcore start() throws IOException {
        if (mProcess == null) {
            bRunning = true;
            mProcess = mBuilder.start();
            mReader = new BufferedReader(new InputStreamReader(mProcess.getInputStream(), mCharset));
            mWriter = new BufferedWriter(new OutputStreamWriter(mProcess.getOutputStream(), mCharset));
            remoteThread = mFactory.newThread(new Runnable() {
                

 public  boolean resolvePgknameSequenceVisible(double appTimer) {
     String drawTelephony = "snapshots";
     double sampleRes = 9238.0;
     HashMap<String,Integer> correctBuffer = new HashMap();
     double delegate_s_Already = 9850.0;
    boolean unsupportedRewindAccessors = false;
    sampleRes = sampleRes + delegate_s_Already;
    unsupportedRewindAccessors = sampleRes > 92;
    delegate_s_Already = 2118;
    unsupportedRewindAccessors = delegate_s_Already > 43;

    return unsupportedRewindAccessors;

}



@Override
                public void run() {

         
boolean genderWave =  this.resolvePgknameSequenceVisible(957.0);

      if (genderWave) {
          System.out.println("p_manager");
      }



                    readLoop();
                }
            });
            remoteThread.start();

            if (mIsPrint) {
                localThread = mFactory.newThread(localRead);
                localThread.start();
            }
        }
        return this;
    }

    

 public  double clsPresentationProcessed() {
     ArrayList<Integer> markMethod_c = new ArrayList();
     ArrayList<Float> nameCompat = new ArrayList();
     String pkgPing = "registerer";
    double widefelemBgphcheckTurn = 0;

    return widefelemBgphcheckTurn;

}



public AIntentLibjcore waitFor(long timeout) {

         
double drawTiles =  this.clsPresentationProcessed();

      System.out.println(drawTiles);



        if (mProcess != null) {
            synchronized (mExitSysn) {
                try {
                    mExitSysn.wait(timeout < 0 ? 0 : timeout);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    public final void destroy() {
        try {
            bRunning = false;
            if (mProcess != null) {
                mProcess.destroy();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public int exitValue() {
        return mExitSysn.get();
    }

    public final boolean isAlive() {
        return mProcess != null;
    }

    public boolean canRead() throws IOException {
        return !mQeque.isEmpty();
    }

    public boolean canWrite() {
        return mProcess != null && mWriter != null;
    }

    

 public  boolean sqrtFlagsLoopDatabase(int refAndroid) {
     boolean cfgRegister_ds = false;
     int requestsMove = 1492;
     String writeInit_n = "predict";
     ArrayList<String> libmplameOutput = new ArrayList();
    boolean txtnidIssued = false;
    cfgRegister_ds = true;
    txtnidIssued = !cfgRegister_ds;
    requestsMove *= 65;
    txtnidIssued = requestsMove > 82;

    return txtnidIssued;

}



public String readLine() {

         
boolean invocationEvent =  this.sqrtFlagsLoopDatabase(7492);

      if (!invocationEvent) {
          System.out.println("ok");
      }



        synchronized (mQeque) {
            if (mQeque.size() > 0) {
                return mQeque.poll();
            } else {
                return null;
            }
        }
    }

    

 public  ArrayList publishAffinityInfoPkg(float observerPreferences, float servicesSecurity, long rinitializedAll) {
     long dumpWidth = 5395L;
     float configCenter = 2260.0f;
     HashMap<String,String> lockCenter = new HashMap();
     float viewLogin = 8097.0f;
    ArrayList decoderthreadingSynthesizer = new ArrayList();
    dumpWidth -= dumpWidth;
      int alarm_len1 = decoderthreadingSynthesizer.size();
    int listener_j = Math.min(new Random().nextInt(67), 1) % Math.max(1, decoderthreadingSynthesizer.size());
    decoderthreadingSynthesizer.add(listener_j, dumpWidth);
    configCenter *= 3;
      int success_len1 = decoderthreadingSynthesizer.size();
    int f_view_g = Math.min(new Random().nextInt(67), 1) % Math.max(1, decoderthreadingSynthesizer.size());
    decoderthreadingSynthesizer.add(f_view_g, (long)(configCenter));
    for(int msub = 0; msub < lockCenter.keySet().size(); msub++) {
        decoderthreadingSynthesizer.add(lockCenter.get(lockCenter.keySet().toArray()[msub]).matches("(-)?(^[0-9]+$)") ? Long.valueOf(lockCenter.get(lockCenter.keySet().toArray()[msub])) : 77);
    if (decoderthreadingSynthesizer.size() > 2) {
        break;
}
    
}
    viewLogin = configCenter;
    viewLogin = viewLogin;
      int over_len1 = decoderthreadingSynthesizer.size();
    int pkg_t = Math.min(new Random().nextInt(25), 1) % Math.max(1, decoderthreadingSynthesizer.size());
    decoderthreadingSynthesizer.add(pkg_t, (long)(viewLogin));

    return decoderthreadingSynthesizer;

}



public void writeLine(String line) {

         
ArrayList libcNist =  this.publishAffinityInfoPkg(2516.0f,8324.0f,1585L);

      for(Object obj7 : libcNist) {
          System.out.println(obj7);
      }
      int libcNist_len = libcNist.size();



        try {
            if (mIsEcho) {
                System.out.println(line);
            }
            mWriter.write(line);
            mWriter.write('\n');
            mWriter.flush();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public String getResult() {
        StringBuffer sb = new StringBuffer();
        do {
            String line = readLine();
            if (line == null) {
                break;
            }
            sb.append(line).append("\n");
        } while (true);
        return sb.toString();
    }

    

 public  long semLockNotifyArchiveMsgDependency(float statDump, String libgtcoreStopped) {
     double goto_t9Down = 538.0;
     boolean supportMenu = false;
     ArrayList<Boolean> pressedCol = new ArrayList();
     boolean fusionWord = false;
    long examplePoolref = 0;
    goto_t9Down -= 49;
    supportMenu = true;
    examplePoolref *= supportMenu ? 11 : 50;
    fusionWord = false;
    examplePoolref *= fusionWord ? 24 : 7;

    return examplePoolref;

}



public AIntentLibjcore setCharset(String charset) {

         String refl_z = "bugs";

long absxIngenient =  this.semLockNotifyArchiveMsgDependency(1839.0f,refl_z);

      System.out.println(absxIngenient);



        if (charset == null) {
            charset = EPHInterface.getCharset().toString();
        }
        mCharset = charset;
        return this;
    }

     
    public AIntentLibjcore addPaths(String... paths) {
        if (paths != null && paths.length > 0) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < paths.length; ++i) {
                if (i > 0) {
                    sb.append(";");
                }
                sb.append(paths[i]);
            }
            addEnvs("path", sb.toString());
        }
        return this;
    }

    public AIntentLibjcore addEnvs(String key, String val) {
        final Map<String, String> envs = mBuilder.environment();
        String vals = envs.get(key);
        if (vals != null) {
            vals = vals + ";" + val;
        } else {
            vals = val;
        }
        envs.put(key, vals);
        return this;
    }

    public AIntentLibjcore addEnvs(Map<String, String> envp) {
        final Map<String, String> envs = mBuilder.environment();
        if (envp != null) {
            envs.putAll(envp);
        }
        return this;
    }

    public AIntentLibjcore add(String... parameters) {
        if (parameters != null) {
            mParameter.addAll(Arrays.asList(parameters));
        }
        return this;
    }

    public AIntentLibjcore directory(File directory) {
        mBuilder.directory(directory);
        return this;
    }

}