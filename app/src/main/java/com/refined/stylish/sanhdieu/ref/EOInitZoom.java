
package com.refined.stylish.sanhdieu.ref;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import java.lang.reflect.Member;

 
abstract class EOInitZoom<V> {

    static boolean DBG_LOG = false;

    protected Class mClszz;

    protected final V mValue;

    @Override
    public String toString() {
        return mValue == null ? "null" : mValue.toString();
    }

    protected EOInitZoom(Class clszz, V value) {
        this.mClszz = clszz;
        this.mValue = value;
    }

    public final Class Class() {
        return this.mClszz;
    }

    public final V get() {
        return mValue;
    }

    public ClassLoader getClassLoader() {
        return this.mClszz == null ? null : this.mClszz.getClassLoader();
    }

    public final boolean isNull() {
        return mValue == null;
    }

    public final String getName() {
        if (mValue == null) {
            return "null";
        } else if (mValue instanceof Member) {
            return ((Member) mValue).getName();
        } else if (mValue instanceof Class) {
            return ((Class) mValue).getName();
        } else {
            return mValue.getClass().getName();
        }
    }
}
