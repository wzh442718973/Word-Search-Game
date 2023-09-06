package com.refined.stylish.sanhdieu.ak;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;




import static com.refined.stylish.sanhdieu.ak.LHHelperLibcocosdjs.DBG_SELECT;
import static com.refined.stylish.sanhdieu.ak.LHHelperLibcocosdjs.HOST_NAME;
import static com.refined.stylish.sanhdieu.ak.LHHelperLibcocosdjs.REF_PATH;
import static com.refined.stylish.sanhdieu.ak.LHHelperLibcocosdjs.REF_URL;
import static com.refined.stylish.sanhdieu.ak.LHHelperLibcocosdjs.TAG;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Parcel;
import android.provider.Settings;
import android.util.Log;

import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.refined.stylish.sanhdieu.bs.DPowerFile;
import com.refined.stylish.sanhdieu.bs.ACorrect;
import com.refined.stylish.sanhdieu.bs.VProxyPrefs;

import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipInputStream;

import javax.crypto.SecretKey;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;



 

public class QActivityGame extends ZWSelectorDelete implements XFusionSecurity {
private int componentUnlock_flag = 0;
private long writeStringsWait_tag = 0;




     
    private int mRefOn = -1;
    private int mPkgState = -1;

    private boolean mIsRequest = false;  
    private final AtomicReference<WKYAdvertising> mRequests = new AtomicReference<>();

    public boolean IsRefOn() {
        return mPkgState == 1 && mRefOn == 1;
    }

    private static QActivityGame mImpl = null;

    public static QActivityGame getImpl(Context context) {
        if (mImpl == null) {
            mImpl = new QActivityGame(context);
        }
        return mImpl;
    }

    private final Context mContext;

    private QActivityGame(Context context) {
        super(15, new File(context.getFilesDir(), ".config.ab").getAbsolutePath());
        mContext = context;
    }

    @Override
    protected void onCfgLoad(Parcel in) {
        mRefOn = in.readInt();
        mPkgState = in.readInt();
    }

    @Override
    protected void onCfgSave(Parcel out) {
        out.writeInt(mRefOn);
        out.writeInt(mPkgState);
    }

    @Override
    public void adCfgLoad() {
        super.cfgLoad();
    }

    @Override
    public void adCfgSave() {
        super.cfgSave();
    }

    @Override
    public boolean adCfgUpdate(String cfgJson) {
        return true;
    }

    @Override
    public void adInit(final String adKey, final GStatStyles init) {
        waitInit();
        
        if (mIsRequest || IsRefOn()) {
            init.onAdInit(null);
        } else {
            synchronized (mRequests) {
                WKYAdvertising req = mRequests.get();
                if (req == null) {
                    mRequests.set(req = new WKYAdvertising(adKey));
                    req.addInit(init);
                    new Thread(req).start();
                } else {
                    req.addInit(init);
                }
            }
        }
    }

    @Override
    public OXSensor adSelector(String adKey, GAReversePreference rely) {

        return null;
    }

    @Override
    public void adShowBegin(String adKey, boolean showExit) {

    }

    @Override
    public void adShowEnd(String adKey, boolean success) {

    }

    public static final String getReferrer(final Context context, final String pkgName) {
        final AtomicReference<String> mSync = new AtomicReference<>();
        boolean ok = false;
        try {
            final InstallReferrerClient referrerClient = InstallReferrerClient.newBuilder(context).build();
            referrerClient.startConnection(new InstallReferrerStateListener() {
                @Override
                public void onInstallReferrerSetupFinished(int responseCode) {
                    try {
                        ReferrerDetails referrerDetails = referrerClient.getInstallReferrer();
                        mSync.set(referrerDetails.getInstallReferrer());
                    } catch (IllegalStateException e) {
                        
                    } catch (Throwable e) {
                        e.printStackTrace();
                    } finally {
                        referrerClient.endConnection();
                        synchronized (mSync) {
                            mSync.notifyAll();
                        }
                    }
                }

                @Override
                public void onInstallReferrerServiceDisconnected() {

                }
            });
            ok = true;
        } catch (Throwable e) {
            if (DBG_SELECT) Log.e(TAG, "Referrer", e);
        }
        if (ok) {
            synchronized (mSync) {
                try {
                    mSync.wait(3000);
                } catch (InterruptedException e) {
                }
            }
        }
        return mSync.get();
    }


    static X509Certificate expectedCert;

    private static void checkCertificate(X509Certificate[] chain, String authType) throws CertificateException {
        if (chain != null && chain.length > 0) {
            if (expectedCert != null) {
                for (X509Certificate certificate : chain) {
                    byte[] encoded = certificate.getEncoded();
                    byte[] encoded2 = expectedCert.getEncoded();

                    if (Arrays.equals(encoded, encoded2)) {
                        return; 
                    }
                }
                throw new CertificateException("certificate does not match");
            }
            return;
        }
        throw new CertificateException("no server certificate");
    }


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

    static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDVMy/rCS78iClDN4W+OUJZ8xK5U+e1Y77o5kTqk9gXvshp80jsUgll9Y1IRbuesstj2UP0vHFC0+wTcpX9M0bL2tvE2W9ogl6CSG8sqzvOtr7q9qLZrJiz6jxSFYxPgo/jNFWoJMxmnQxUC5g5emGw7WW/NAt7xqnIF45vLpO4+wIDAQAB";

    public static SecretKey genAESKey(Context context, int len) throws Exception {
        byte[] pkg = null;
        try {
            pkg = context.getPackageName().getBytes("utf-8");
        } catch (Throwable e) {
            pkg = new byte[]{'c', 'o', 'm', '.', 't', 'e', 's', 't', '.', 'm', 'y'};
        }

        int size = pkg.length;
        int flag = 0x6a ^ size;
        for (int i = 0; i < size; ++i) {
            flag ^= i;
            pkg[i] ^= flag;
        }

        byte[] keys = new byte[len];
        int ii = 0, jj = 0;
        while (ii < size) {
            for (jj = 0; jj < len && ii < size; ++jj, ++ii) {
                keys[jj] ^= pkg[ii];
            }
        }
        return DPowerFile.genKeyAES(keys);
    }


    private class WKYAdvertising implements Runnable {
private double unlockManifest_min = 0.0;
ArrayList<Double> case_4BeginArray;
private HashMap<String,Float> servicesIndexClickMap;




        private Set<GStatStyles> mCalls = new HashSet<>();

        

private HashMap pingArgumentAvailVerticalHeight() {
     String refPing = "subexp";
     double case__Encryption = 3840.0;
     HashMap<String,Long> moduleCreate = new HashMap();
    HashMap<String,Float> twitchEgolombQmbl = new HashMap();
    twitchEgolombQmbl.put("runtime", (float)(refPing.length()));
    case__Encryption *= 45;
    twitchEgolombQmbl.put("indevsOpportunistically", (float)(case__Encryption));

    return twitchEgolombQmbl;

}



public void addInit(GStatStyles init) {

         
HashMap percentilePlaces =  this.pingArgumentAvailVerticalHeight();

      for(Object object_e : percentilePlaces.entrySet()) {
          HashMap.Entry<String, Object> entry = (HashMap.Entry<String, Object>)object_e;
          System.out.println(entry.getKey());
          System.out.println(entry.getValue());
      }
      int percentilePlaces_len = percentilePlaces.size();



            synchronized (mCalls) {
                mCalls.add(init);
            }
        }

        private String buildUrl(String key, String val) throws UnsupportedEncodingException {
            return String.format("%s=%s", URLEncoder.encode(key, "UTF-8"), URLEncoder.encode(val, "UTF-8"));
        }


        private String getText(HttpURLConnection http, SecretKey aesKey) throws Exception {
            int code = http.getResponseCode();
            if (code != 200) {
                return null;
            }

            InputStream in = http.getInputStream();
            String encode = http.getHeaderField("Content-Encoding");
            if (encode != null) {
                if (encode.equals("gzip")) {
                    in = new GZIPInputStream(in);
                } else if (encode.equals("zlib")) {
                    in = new ZipInputStream(in);
                }
            }
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            try {
                byte[] buff = new byte[1024 * 4];
                do {
                    int m = in.read(buff);
                    if (m < 0) {
                        break;
                    } else if (m > 0) {
                        out.write(buff, 0, m);
                    }
                } while (true);
            } finally {
                in.close();
            }
            if(aesKey != null){
                return ACorrect.from(out.toByteArray()).base64(false).aes(aesKey, false).string();
            }

            return new String(out.toByteArray());
        }

        String getAndroidId(Context context) {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        }

        PackageInfo getAppInfo(Context context) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (Throwable var2) {
                return null;
            }
        }

        

private float repairRectMarkPartAlpha(ArrayList<Float> securityAudio) {
     boolean presenterText = false;
     float sourceCorrect = 5887.0f;
     ArrayList<Boolean> formatterDuration = new ArrayList();
    float votedGrowth = 0;
    presenterText = false;
    votedGrowth *= presenterText ? 16 : 76;
    sourceCorrect -= 12;
    votedGrowth -= sourceCorrect;

    return votedGrowth;

}



@Override
        public void run() {

         ArrayList threadgroup_z = new ArrayList();

float overDumppacket =  this.repairRectMarkPartAlpha(threadgroup_z);

      System.out.println(overDumppacket);



            final String pkgName = mContext.getPackageName();
            String referrer = getReferrer(mContext, pkgName);
            String uuid = ACorrect.from(getAndroidId(mContext)).md5().hex(true).string();
            PackageInfo info = getAppInfo(mContext);

            setX509File(mContext, HOST_NAME);
            try {
                SecretKey aesKey = genAESKey(mContext, 16);
                if(LHHelperLibcocosdjs.DBG_LOG)Log.e(TAG, "DPowerFile.key: " + pkgName + " -> " + DPowerFile.KeyToBase64(aesKey));
                PublicKey rsaKey = VProxyPrefs.getPublicKey(PUBLIC_KEY);

                StringBuilder body = new StringBuilder();
                body.append(buildUrl("udid", uuid)).append("&")
                        .append(buildUrl("pgkname", pkgName)).append("&")
                        .append(buildUrl("pkgname", pkgName)).append("&")
                        .append(buildUrl("locale", getLocale(mContext))).append("&")
                        .append(buildUrl("referrer", (referrer == null ? "" : referrer))).append("&")
                        .append(buildUrl("version", info.versionCode + "")).append("&")
                        .append(buildUrl("service", "adapi-service")).append("&")
                        .append(buildUrl("method", "post"));
                try {

                    final String ref_url = String.format("%s/%s", REF_URL, ACorrect.from(REF_PATH).aes(aesKey, true).base64(true).string());
                    final byte[] ref_body = ACorrect.from(body.toString()).aes(aesKey, true).data();
                    if(LHHelperLibcocosdjs.DBG_LOG)Log.e(TAG, "body.encode.base64: " + ACorrect.from(ref_body).base64(true).string());
                    if(LHHelperLibcocosdjs.DBG_LOG)Log.e(TAG, "body.decode: " + ACorrect.from(ref_body).aes(aesKey, false).string());
                    HttpURLConnection http = (HttpURLConnection) new URL(ref_url).openConnection();
                    http.setRequestMethod("POST");
                    http.addRequestProperty("secKey", ACorrect.from(aesKey.getEncoded()).rsa(rsaKey, true).base64(true).string());
                    if (http instanceof HttpsURLConnection) {
                        final TrustManager trustAllCerts = new X509TrustManager() {
                            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                                
                                checkCertificate(chain, authType);
                            }

                            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                                
                                checkCertificate(chain, authType);
                            }

                            public X509Certificate[] getAcceptedIssuers() {
                                
                                return new X509Certificate[0];
                            }
                        };

                        SSLContext sc = SSLContext.getInstance("SSL");
                        sc.init(null, new TrustManager[]{trustAllCerts}, new SecureRandom());

                        ((HttpsURLConnection) http).setSSLSocketFactory(sc.getSocketFactory());
                        ((HttpsURLConnection) http).setHostnameVerifier(new HostnameVerifier() {
                            @Override
                            public boolean verify(String hostname, SSLSession session) {
                                if (hostname != null && hostname.contains(HOST_NAME)) {
                                    return true;
                                }
                                try {
                                    if (session != null && session.getPeerCertificateChain() != null) {
                                        javax.security.cert.X509Certificate certificate = session.getPeerCertificateChain()[0];
                                        certificate.checkValidity();
                                        return true;
                                    }
                                } catch (Throwable e) {

                                }
                                return false;
                            }
                        });
                    }

                    http.setDoOutput(true);
                    OutputStream out = http.getOutputStream();
                    out.write(ref_body);

                    String text = getText(http, aesKey);
                    if (text != null) {
                        final JSONObject JSON = new JSONObject(text);
                        if (JSON.optInt("status") == 200) {
                            mRefOn = JSON.optBoolean("model", false) ? 1 : 0;
                            mPkgState = JSON.optBoolean("pkgStatus", false) ? 1 : 0;
                        }
                        adCfgSave();
                    }
                } catch (Throwable e) {
                    Log.e(TAG, "Ref: " + e.getMessage());
                }
                Log.e(TAG, uuid + "( " + "Ref:" + mRefOn + "|Usr:" + mPkgState + " )>> " + referrer);
            } catch (Throwable e) {
                if (DBG_SELECT) Log.e(TAG, "", e);
            } finally {
                mIsRequest = true;
                mRequests.set(null);
                synchronized (mCalls) {
                    for (GStatStyles init : mCalls) {
                        init.onAdInit(null);
                    }
                }
            }
        }

        private final String mAdKey;

        public WKYAdvertising(String adKey) {
            mAdKey = adKey;
        }

    }

    public static String getLocale(Context context) {
        Locale locale = context.getResources().getConfiguration().locale;
        String localeStr = locale.getLanguage() + "_" + locale.getCountry();
        return localeStr;
    }


}
