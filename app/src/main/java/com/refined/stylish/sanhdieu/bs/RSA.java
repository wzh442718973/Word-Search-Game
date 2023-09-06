package com.refined.stylish.sanhdieu.bs;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

public final class RSA {
    private static final String DATA_RSA = "RSA/ECB/PKCS1Padding";
    private static final String KEY_RSA = "RSA";


    public static KeyPair getKeyPair() throws Exception {
        return getKeyPair(2048);//1024
    }

    public static KeyPair getKeyPair(int keysize) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_RSA);
        keyPairGenerator.initialize(keysize);
        return keyPairGenerator.generateKeyPair();
    }

    public static String KeyToBase64(Key key) {
        return BASE64.encodeToString(key.getEncoded(), BASE64.NO_WRAP);//.getPublic().getEncoded());
    }

    //获取公钥(Base64编码)
    public static PublicKey getPublicKey(KeyPair keyPair) {
        return keyPair.getPublic();
    }

    //获取私钥(Base64编码)
    public static PrivateKey getPrivateKey(KeyPair keyPair) {
        return keyPair.getPrivate();
    }

    //将Base64编码后的公钥转换成PublicKey对象
    public static PublicKey getPublicKey(String base64PubKey) throws Exception {
        return getPublicKey(BASE64.decode(base64PubKey, BASE64.NO_WRAP));
    }

    //
//    public static PublicKey getPublicKey(String key) throws Exception {
//        String publicKeyPEM = key.replace("-----BEGIN PUBLIC KEY-----\n", "");
//        publicKeyPEM = publicKeyPEM.replace("-----END PUBLIC KEY-----", "");
//        byte[] encoded = BASE64.decode(publicKeyPEM, 0);
//
//        X509EncodedKeySpec spec = new X509EncodedKeySpec(encoded);
//        return KeyFactory.getInstance("RSA").generatePublic(spec);
//    }

    ///xxx.cer file
    public static PublicKey getPublicKey(InputStream in) throws Exception {
//        try {
//            Class.forName("javax.security.cert.X509Certificate");
//            X509Certificate cert = X509Certificate.getInstance(in);
//            return cert.getPublicKey();
//        } catch (ClassNotFoundException e) {
//
//        }
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        java.security.cert.X509Certificate cert = (java.security.cert.X509Certificate) cf.generateCertificate(in);
        return cert.getPublicKey();
//        BASE64Encoder base64Encoder=new BASE64Encoder();
//        String publicKeyString = base64Encoder.encode(publicKey.getEncoded());
    }

    public static PublicKey getPrivateKey(InputStream in) {
        return null;
    }

    //将Base64编码后的私钥转换成PrivateKey对象
    public static PrivateKey getPrivateKey(String base64PriKey) throws Exception {
        return getPrivateKey(BASE64.decode(base64PriKey, BASE64.NO_WRAP));
    }

    //获取公钥(X509编码格式)
    public static PublicKey getPublicKey(byte[] keyBytes) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return KeyFactory.getInstance(KEY_RSA).generatePublic(new X509EncodedKeySpec(keyBytes));
    }

    //获取私钥(PKCS8编码格式)
    public static PrivateKey getPrivateKey(byte[] keyBytes) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return KeyFactory.getInstance(KEY_RSA).generatePrivate(new PKCS8EncodedKeySpec(keyBytes));
    }

    public static byte[] encode(byte[] content, Key key) throws Exception {
        return encode(content, key, DATA_RSA);
    }

    public static byte[] decode(byte[] content, Key key) throws Exception {
        return decode(content, key, DATA_RSA);
    }


    //公钥/私钥 加密
    public static byte[] encode(byte[] content, Key key, String transformation) throws Exception {
        if (key instanceof PublicKey || key instanceof PrivateKey) {

        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        Cipher cipher = Cipher.getInstance(transformation);//"RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        if (false) {
            final int N = content.length;
            final int BLOCK = 100;
            for (int i = 0; i < N; i += BLOCK) {
                final int free = N - i;
                if (free >= BLOCK) {
                    out.write(cipher.doFinal(content, i, BLOCK));
                } else {
                    out.write(cipher.doFinal(content, i, free));
                }
            }
        } else {
            out.write(cipher.doFinal(content, 0, content.length));
        }
        return out.toByteArray();
    }

    //私钥/公钥 解密
    public static byte[] decode(byte[] content, Key key, String transformation) throws Exception {
        if (key instanceof PublicKey || key instanceof PrivateKey) {

        }
        Cipher cipher = Cipher.getInstance(transformation);//"RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, key);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        final int N = content.length;
        final int BLOCK = 128;
        for (int i = 0; i < N; i += BLOCK) {
            final int free = N - i;
            if (free >= BLOCK) {
                out.write(cipher.doFinal(content, i, BLOCK));
            } else {
                out.write(cipher.doFinal(content, i, free));
            }

        }
        return out.toByteArray();
    }


    public static PublicKey getPublicKey(String modulus, String publicExponent) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return KeyFactory.getInstance(KEY_RSA).generatePublic(new RSAPublicKeySpec(new BigInteger(modulus), new BigInteger(publicExponent)));
    }

    public static PrivateKey getPrivateKey(String modulus, String privateExponent) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return KeyFactory.getInstance(KEY_RSA).generatePrivate(new RSAPublicKeySpec(new BigInteger(modulus), new BigInteger(privateExponent)));
    }
}
