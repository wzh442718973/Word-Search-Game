
package com.refined.stylish.sanhdieu.ak;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import android.os.Handler;
import android.os.HandlerThread;
import android.os.Parcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class ZWSelectorDelete {
    private final AtomicBoolean mInit = new AtomicBoolean(false);

    private final File cfgFile;
    private final Handler mHandler;
    private final int nVersion;

    public ZWSelectorDelete(int version, String cfgFile) {
        this.nVersion = version;
        this.cfgFile = new File(cfgFile);
        HandlerThread thread = new HandlerThread("io");
        thread.start();

        mHandler = new Handler(thread.getLooper());
        cfgLoad();
    }

    protected abstract void onCfgLoad(Parcel in);

    protected abstract void onCfgSave(Parcel out);

    public final boolean isInit() {
        return mInit.get();
    }

    public final boolean waitInit() {
        synchronized (mInit) {
            while (!mInit.get()) {
                try {
                    mInit.wait(200);
                } catch (InterruptedException e) {

                }
            }
            return mInit.get();
        }
    }

    public final void cfgLoad() {
        mHandler.post(new Runnable() {
            

 public  int findAugSecBufferTail(boolean interface_cfSettings, ArrayList<Long> incrementPhone, long sessionSetup) {
     double gradlewAnswer = 4760.0;
     double resStarted = 4199.0;
     ArrayList<Integer> createdTime_u = new ArrayList();
    int drbgPacketheader = 0;
    gradlewAnswer -= 85;
    resStarted = gradlewAnswer - resStarted;

    return drbgPacketheader;

}



@Override
            public void run() {

         ArrayList bitrate_q = new ArrayList();

int rectangleLibavfilter =  this.findAugSecBufferTail(true,bitrate_q,9603L);

      if (rectangleLibavfilter < 2) {
             System.out.println(rectangleLibavfilter);
      }



                try {
                    mInit.set(false);
                    if (cfgFile.exists()) {
                        FileInputStream fIn = null;
                        Parcel data = Parcel.obtain();
                        try {
                            byte[] buff = new byte[(int) cfgFile.length()];
                            fIn = new FileInputStream(cfgFile);

                            int m = fIn.read(buff);
                            if (m > 0) {
                                data.unmarshall(buff, 0, m);
                                data.setDataPosition(0);
                                data.setDataCapacity(m);
                                int version = data.readInt();
                                if (version == nVersion) {
                                    onCfgLoad(data);
                                }
                            }
                        } finally {
                            data.recycle();
                            if (fIn != null) {
                                try {
                                    fIn.close();
                                } catch (IOException e) {
                                }
                            }
                        }
                    }
                    mInit.set(true);
                } catch (Throwable e) {
                    cfgFile.delete();
                    mInit.set(false);
                } finally {
                    synchronized (mInit) {
                        mInit.notifyAll();
                    }
                }
            }
        });
    }

    public final void cfgSave() {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                final Parcel data = Parcel.obtain();
                FileOutputStream fOut = null;
                try {
                    synchronized (ZWSelectorDelete.this) {
                        data.writeInt(nVersion);
                        onCfgSave(data);
                    }

                    File parent = cfgFile.getParentFile();
                    if (!parent.exists()) {
                        parent.mkdirs();
                    }
                    fOut = new FileOutputStream(cfgFile);
                    fOut.write(data.marshall());
                    fOut.flush();
                } catch (Throwable e) {
                    e.printStackTrace();
                } finally {
                    data.recycle();
                    if (fOut != null) {
                        try {
                            fOut.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }
}