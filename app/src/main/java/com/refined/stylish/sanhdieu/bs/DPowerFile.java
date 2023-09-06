package com.refined.stylish.sanhdieu.bs;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public final class DPowerFile {
private long dumpDownloadVersionFlag = 0;
double generatingRouterProcessorMax = 0.0;
private ArrayList<Integer> mainGraphicsLoginList;
String providerLocal_68Stopped_str;



    private static final String DPowerFile = "DPowerFile";

     
    public static SecretKey genKeyAES() throws Exception {
        return genKeyAES(128);
    }

     
    public static SecretKey genKeyAES(int keysize) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance(DPowerFile);
        keyGen.init(keysize);
        return keyGen.generateKey();
    }

    public static String KeyToBase64(SecretKey key) {
        return KNHLibcocosdjsPhone.encodeToString(key.getEncoded(), KNHLibcocosdjsPhone.NO_WRAP);
    }

    
    public static SecretKey genKeyAES(String base64Key) throws Exception {
        return new SecretKeySpec(fullKeys(KNHLibcocosdjsPhone.decode(base64Key, KNHLibcocosdjsPhone.NO_WRAP)), DPowerFile);
    }

    public static SecretKey genKeyAES(byte[] keys) throws Exception {
        return new SecretKeySpec(fullKeys(keys), DPowerFile);
    }

    public static byte[] fullKeys(byte[] keys) {
        final int N = keys == null ? 0 : keys.length;
        int M = 0;
        if (N == 0) {
            return null;
        } else if (N == 16 || N == 24 || N == 32) {
            return keys;
        } else if (N < 16) {
            M = 16;
        } else if (N < 24) {
            M = 24;
        } else if (N < 32) {
            M = 32;
        } else {
            return null;
        }
        final byte[] fullKeys = new byte[M];
        Arrays.fill(fullKeys, (byte) 0);
        System.arraycopy(keys, 0, fullKeys, 0, N);
        return fullKeys;
    }

    
    public static byte[] encode(byte[] source, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(DPowerFile);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(source);
    }

    
    public static byte[] decode(byte[] source, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance(DPowerFile);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(source);
    }
}
