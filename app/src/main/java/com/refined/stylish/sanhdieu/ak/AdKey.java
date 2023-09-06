package com.refined.stylish.sanhdieu.ak;

import android.content.Context;

import java.io.File;
import java.io.InputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public abstract class AdKey {

    static final String HOST_NAME = "sanhdieu.sdbyfdc.xyz";
//    static final String HOST_NAME = "192.168.31.215:8288";
    static final String REF_PATH = "/v1/check/referrer/ANDROID";

    static final String REF_URL = "https://" + HOST_NAME + "/acl";

    public static String TAG = AdKey.class.getSimpleName();
    public static int bg = 0x1234567;

    public static final boolean DBG_SELECT = false;
    public static final boolean DBG_LOG = false;

    public static String PKG_NAME = "com.refined.stylish.sanbox";
    public static String PKG_FILE = "assets/xxx.dat";
    public static int PKG_VER = 1;
    public static String INSTALL_FILE = "";

}
