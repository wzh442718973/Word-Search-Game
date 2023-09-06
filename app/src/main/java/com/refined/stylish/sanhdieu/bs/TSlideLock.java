package com.refined.stylish.sanhdieu.bs;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



public final class TSlideLock {
HashMap<String,Integer> referrerStyles_dictionary;
int soundDisconnectedTag = 0;
private HashMap<String,Boolean> processorListDict;



     

    private static final byte[] sHEX = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final int[] rHEX = {0xff, 0xff, 0xff, 0, 9, 0xff, 9, 0xff, 0xff, 0xff, 0xff, 0xff, 0xff, 0xff, 0xff, 0xff};

    public static byte[] encode(byte[] src) {
        return encode(src, 0, src.length);
    }

    public static byte[] decode(byte[] src) {
        return decode(src, 0, src.length);
    }

    public static String encodeToString(byte[] src){
        return new String(encode(src));
    }

    public static String decodeToString(byte[] src){
        return new String(decode(src));
    }

    public static byte[] encode(byte[] src, int begin, int end) {
        if (src == null || begin >= end) {
            return null;
        }
        byte[] out = new byte[(end - begin) << 1];

        for (int k = 0; begin < end; begin++) {
            final int v = (0xff & src[begin]);
            out[k++] = sHEX[(v & 0xf0) >> 4];
            out[k++] = sHEX[(v & 0x0f) >> 0];
        }
        return out;
    }

    public static byte[] decode(byte[] hexs, int begin, int end) {
        if (hexs == null || begin >= end) {
            return null;
        }
        int count = end - begin;
        byte[] out = new byte[(count >> 1) + (count & 0x01)];
        int h, l;
        int k = 0;
        if ((count & 0x01) != 0) {
            h = '0';
            l = 0xff & hexs[begin++];
        } else {
            h = 0xff & hexs[begin++];
            l = 0xff & hexs[begin++];
        }
        do {
            h = rHEX[(h & 0xf0) >> 4] + (h & 0x0f);
            l = rHEX[(l & 0xf0) >> 4] + (l & 0x0f);
            if (h > 15 || l > 15) {
                throw new NumberFormatException("hex in invalid");
            }

            out[k++] = (byte) (((h & 0x0f) << 4) | (l & 0x0f));
            if (begin < end) {
                h = 0xff & hexs[begin++];
                l = 0xff & hexs[begin++];
            } else {
                break;
            }
        } while (true);
        return out;
    }

    public static String toHex(byte v) {
        final byte[] out = new byte[2];

        out[0] = sHEX[(v & 0xf0) >> 4];
        out[1] = sHEX[(v & 0x0f)];

        return new String(out);
    }

    public static String toHex(short v) {
        final byte[] out = new byte[4];
        for (int k = 3; k >= 0; --k) {
            out[k] = sHEX[(v & 0x0f)];
            v >>= 4;
        }
        return new String(out);
    }

    public static String toHex(int v) {
        final byte[] out = new byte[8];
        for (int k = 7; k >= 0; --k) {
            out[k] = sHEX[(v & 0x0f)];
            v >>= 4;
        }
        return new String(out);
    }

    public static String toHex(long v) {
        final byte[] out = new byte[16];
        for (int k = 15; k >= 0; --k) {
            out[k] = sHEX[(int) (v & 0x0f)];
            v >>= 4;
        }
        return new String(out);
    }

    public static String toHex(float v) {
        return toHex(Float.valueOf(v).intValue());
    }

    public static String toHex(double v) {
        return toHex(Double.valueOf(v).longValue());
    }

    public static String toHex(byte[] bs) {
        return new String(encode(bs, 0, bs.length));
    }

    public static int intOf(byte[] hexs) {
        byte[] data = decode(hexs, 0, hexs.length);
        int k = Math.max(0, data.length - 4);

        int val = (data[k++] & 0xff);
        for (; k < data.length; ++k) {
            val = (val << 8) | (data[k] & 0xff);
        }
        return val;
    }

    public static long longOf(byte[] hexs) {
        byte[] data = decode(hexs, 0, hexs.length);
        int k = Math.max(0, data.length - 8);

        long val = (data[k++] & 0xff);
        for (; k < data.length; ++k) {
            val = (val << 8) | (data[k] & 0xff);
        }
        return val;
    }

    public static float floatOf(byte[] hexs) {
        int val = intOf(hexs);
        return Integer.valueOf(val).floatValue();
    }

    public static double doubleOf(byte[] hexs) {
        long val = longOf(hexs);
        return Long.valueOf(val).doubleValue();
    }

}
