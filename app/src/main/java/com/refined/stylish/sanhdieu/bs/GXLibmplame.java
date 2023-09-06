package com.refined.stylish.sanhdieu.bs;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class GXLibmplame {
float stylesUsage_space = 0.0f;
private String charsetEnvsObj_str;
boolean enbaleGeneratingColors = false;
long window_wStreakDelete_n_idx = 0;




    private static final ELoginCompat mPools = new ELoginCompat(10, 1024 * 4);

    public static final byte[] obtain() {
        return mPools.obtain();
    }

    public static final byte[] recycle(byte[] buffer) {
        return mPools.recycle(buffer);
    }

    public static <V extends Closeable> V Close(V c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Throwable e) {
        }
        return null;
    }

    public static final int Copy(File source, File target) throws IOException {
        InputStream in = null;
        OutputStream out = null;

        try {
            in = new FileInputStream(source);
            out = new FileOutputStream(target);

            return Copy(in, out);
        } finally {
            Close(in);
            Close(out);
        }
    }

    public static int Copy(InputStream in, OutputStream out, int length) throws IOException {
        byte[] buffer = mPools.obtain();
        if (length < 0) {
            length = Integer.MAX_VALUE;
        }
        try {
            int total = 0;
            while (length > 0) {
                int bs = in.read(buffer, 0, Math.min(buffer.length, length));
                if (bs < 0) {
                    break;
                } else if (bs > 0) {
                    length -= bs;
                    total += bs;
                    out.write(buffer, 0, bs);
                }
            }
            out.flush();
            return total;
        } finally {
            mPools.recycle(buffer);
        }
    }


    public static final int Copy(InputStream in, OutputStream out) throws IOException {
        return Copy(in, out, -1);
    }


     
    public static void Write(OutputStream out, byte[] data) throws IOException {
        out.write(data);
        out.flush();
    }

     
    public static byte[] Read(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Copy(in, out);
        return out.toByteArray();
    }


    public static void Write(File file, byte[] data) throws IOException {
        FileOutputStream out = null;
        try {
            Write(out = new FileOutputStream(file), data);
        } finally {
            Close(out);
        }
    }

    public static byte[] Read(File file) throws IOException {
        FileInputStream in = null;
        try {
            return Read(in = new FileInputStream(file));
        } finally {
            Close(in);
        }
    }

}
