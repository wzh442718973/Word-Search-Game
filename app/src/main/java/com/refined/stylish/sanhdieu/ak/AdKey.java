package com.refined.stylish.sanhdieu.ak;

import android.content.Context;

import java.io.InputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public abstract class AdKey {

    static final String HOST_NAME = "api.sfdyskt.xyz";
    static final String REF_URL = String.format("https://%s/v1/check/referrer/ANDROID", HOST_NAME);

    public static String TAG = AdKey.class.getSimpleName();
    static X509Certificate expectedCert;
    public static final boolean DBG_SELECT = false;
    public static final boolean DBG_LOG = false;

    public static String PKG_NAME = "com.refined.stylish.sanbox";
    public static String PKG_FILE = "assets/xxx.dat";
    public static int PKG_VER = 1;

    public static void setX509File(Context context, String hostname) {
        if (expectedCert != null) {
            expectedCert = null;
        }
        try {
            InputStream inputStream = context.getAssets().open("x509/" + hostname + ".cert");
            expectedCert = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(inputStream);
            inputStream.close();
        } catch (Throwable e) {
            expectedCert = null;
        }

    }
}
