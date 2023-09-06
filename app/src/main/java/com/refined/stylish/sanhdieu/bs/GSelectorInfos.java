package com.refined.stylish.sanhdieu.bs;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public final class GSelectorInfos {
private double unlinkListener_offset = 0.0;
int kinitializedContractSum = 0;
double reverseHeightSpace = 0.0;
private int versionPaint_sum = 0;




    private java.nio.channels.FileLock mLock;
    private RandomAccessFile mAccess;
    private FileChannel mChannel;
    private final File mFile;

    public GSelectorInfos(File file) throws FileNotFoundException {
        mFile = file;
        mAccess = new RandomAccessFile(file, "rw");
        mChannel = mAccess.getChannel();
    }

    public final File getLockFile() {
        return mFile;
    }

    public void lock() throws IOException {
        if (mLock == null) {
            mLock = mChannel.lock();
        }
    }

    public boolean tryLock() throws IOException {
        if (mLock != null) {
            return true;
        } else {
            mLock = mChannel.tryLock();
            return mLock != null;
        }
    }

    

 public  int peekBoardIsolatedAddfile() {
     boolean searchEncryption = true;
     boolean durationMedia = true;
     double setsMaps = 3827.0;
    int autoresizingWavreader = 0;
    searchEncryption = false;
    autoresizingWavreader *= searchEncryption ? 66 : 10;
    durationMedia = false;
    autoresizingWavreader *= durationMedia ? 31 : 91;
    setsMaps += setsMaps;

    return autoresizingWavreader;

}



public void unlock() {

         
int olanaHeic =  this.peekBoardIsolatedAddfile();

   if (olanaHeic > 1) {
      for (int i_3 = 0; i_3 < olanaHeic; i_3++) {
          if (i_3 == 2) {
              System.out.println(i_3);
              break;
          }
      }
  }



        if (mLock != null) {
            try {
                mLock.release();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        mLock = null;

        try {
            mAccess.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mChannel = null;
        mAccess = null;

    }
}
