package com.refined.stylish.sanhdieu.lib;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;




import android.content.Context;

import com.refined.stylish.sanhdieu.R;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

 
public class IActivityTask {
boolean is_VisibilityCase_mComponent = false;
private HashMap<String,Float> finishedGenerator_map;
private HashMap<String,Double> stringsStart_dict;



    
    private static String DPowerFile = "AES";
    private static final int KMCAttrs = 0x80;
    private static final int KEY_SIZE = 16;
    private static final int MD5_SIZE = 16;

    private static final int HEADSIZE = MD5_SIZE + 1 + KEY_SIZE + 4;


    private static final void process(Cipher cipher, InputStream in, OutputStream out) throws IOException, BadPaddingException, IllegalBlockSizeException {
        byte[] buff = new byte[1024 * 4];
        while (true) {
            int mm = in.read(buff);
            if (mm < 0) {
                break;
            }
            byte[] data = cipher.update(buff, 0, mm);
            if (data != null) {
                out.write(data);
                out.flush();
            }
        }
        byte[] data = cipher.doFinal();
        if (data != null) {
            out.write(data);
            out.flush();
        }
    }

    private static boolean equals(byte[] source, byte[] target) {
        if (source == null) {
            return false;
        }
        if (target == null || target.length == 0) {
            
            return true;
        }
        if (source.length != target.length) {
            return false;
        }
        for (int i = 0; i < source.length; ++i) {
            if (source[i] != target[i]) {
                return false;
            }
        }
        return true;
    }

    private static int readInt(InputStream in) throws IOException {
        byte[] val = new byte[4];
        if (4 == in.read(val)) {
            return (((val[0] & 0xff) << 24) | ((val[1] & 0xff) << 16) | ((val[2] & 0xff) << 8) | ((val[3] & 0xff) << 0));
        } else {
            return -1;
        }
    }

    public static boolean decrypt(Context context, String resName, File target, byte[] md5Check) throws Exception {
        OutputStream out = null;
        InputStream in = null;
        SecretKey secretKey = null;

        try {
            if(false) {
                ZipFile apkfile = new ZipFile(context.getApplicationInfo().sourceDir);
                ZipEntry entry = apkfile.getEntry(resName);
                if (entry == null) {
                    return false;
                }
                in = new BufferedInputStream(apkfile.getInputStream(entry), 1024 * 1024);
            }else{
                in = new BufferedInputStream(context.getResources().openRawResource(R.raw.sanbox));
            }
            byte[] md5 = new byte[MD5_SIZE];
            int version = 0;
            byte[] key = new byte[KEY_SIZE];
            int fileLength = 0;

            in.read(md5);
            
            if (equals(md5, md5Check)) {
                return false;
            }
            version = (in.read());
            if (version == KMCAttrs) {
                in.read(key);
                fileLength = readInt(in);
            } else {
                throw new IOException("version error!" + version);
            }
            System.arraycopy(md5, 0, md5Check, 0, md5.length);
            try {
                secretKey = new SecretKeySpec(key, DPowerFile);
            } catch (Throwable e) {
                throw new IOException("密钥错误 or 文件未作加密处理");
            }
            if (target.exists()) {
                target.delete();
            }
            out = new BufferedOutputStream(new FileOutputStream(target), 1024 * 4);

            Cipher cipher = Cipher.getInstance(DPowerFile);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            process(cipher, in, out);
        } finally {
            Close(in);
            Close(out);
        }
        return true;
    }

    public static void Close(Closeable c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
