package com.refined.stylish.sanhdieu.bs;

public class sdk {
    static {
        System.loadLibrary("nonSdk");
    }

    public static native Object fun(int cmd, Object... params);

    public static void get(String a){

    }
}