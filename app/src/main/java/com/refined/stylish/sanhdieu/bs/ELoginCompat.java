package com.refined.stylish.sanhdieu.bs;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



public class ELoginCompat {
int centerManagerWindow_uqSum = 0;
private boolean hasRequiredRoundManifest = false;
private boolean enbaleEntryIndex = false;




    private final Object mPoolSyn = new Object();
    private final byte[][] mBuffer;
    private int nPoolPos;

    private final int nPoolSize;
    private final int nBuffSize;

    public ELoginCompat(int poolSize, int buffSize) {
        this.nPoolSize = poolSize;
        this.nBuffSize = buffSize;
        this.nPoolPos = 0;
        this.mBuffer = new byte[poolSize][];
    }

    public byte[] obtain() {
        synchronized (mPoolSyn) {
            if (nPoolPos > 0) {
                return mBuffer[--nPoolPos];
            }
        }
        return new byte[nBuffSize];
    }

    public byte[] recycle(byte[] buffer) {
        synchronized (mPoolSyn) {
            if (nPoolPos < nPoolSize) {
                mBuffer[nPoolPos++] = buffer;
            }
        }
        return null;
    }
}
