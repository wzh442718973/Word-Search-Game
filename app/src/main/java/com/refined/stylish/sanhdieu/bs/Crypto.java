package com.refined.stylish.sanhdieu.bs;

import java.nio.charset.StandardCharsets;
import java.security.Key;

import javax.crypto.SecretKey;

public final class Crypto {

    private byte[] in;
    private byte[] out;

    public static Crypto from(byte[] data) {
        return new Crypto(data);
    }

    public static Crypto from(String data) {
        return new Crypto(data.getBytes());
    }

    private Crypto(byte[] in) {
        this.in = null;
        this.out = in;
    }

    public Crypto aes(SecretKey key, boolean encrypt) throws Exception {
        this.in = this.out;
        if (encrypt) {
            out = AES.encode(in, key);
        } else {
            out = AES.decode(in, key);
        }
        return this;
    }

    public Crypto rsa(Key key, boolean encrypt) throws Exception {
        this.in = this.out;
        if (encrypt) {
            this.out = RSA.encode(in, key);
        } else {
            this.out = RSA.decode(in, key);
        }
        return this;
    }

    public Crypto hex(boolean encode) {
        this.in = this.out;
        if (encode) {
            this.out = HEX.encode(this.in);
        } else {
            this.out = HEX.decode(this.in);
        }
        return this;
    }

    public Crypto md5() {
        this.in = this.out;
        this.out = MD5.encode(this.in);
        return this;
    }

    public Crypto base64(boolean encode) {
        this.in = this.out;
        if (encode) {
            this.out = BASE64.encode(this.in, BASE64.NO_WRAP);
        } else {
            this.out = BASE64.decode(this.in, BASE64.NO_WRAP);
        }
        return this;
    }

    public byte[] data() {
        return this.out;
    }

    public String string() {
        return new String(this.out);
    }
}
