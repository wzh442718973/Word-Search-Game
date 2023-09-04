package com.refined.stylish.sanhdieu.lib;

import android.util.Log;
import android.view.inputmethod.EditorInfo;

import java.lang.reflect.Method;

import com.refined.stylish.sanhdieu.ak.AdKey;
import com.refined.stylish.sanhdieu.bs.DEBUG;
import com.refined.stylish.sanhdieu.bs.XObject;
import com.refined.stylish.sanhdieu.ref.IInterfaceObserver;
import com.refined.stylish.sanhdieu.ref.ServiceInterface;

public class InputObserver extends IInterfaceObserver {

    @Override
    protected Object onInvoke(Object source, Method method, Object[] args) throws Throwable {
        if (AdKey.DBG_LOG)
            Log.e(AdKey.TAG, "Input.onInvoke: " + DEBUG.dumpCall(method, args, null, true));
        return super.onInvoke(source, method, args);
    }

    @ServiceInterface("startInputOrWindowGainedFocus")
    protected Object _startInputOrWindowGainedFocus(Object source, Method method, Object[] args) throws Throwable {
        final int idx = XObject.index(args, EditorInfo.class);
        if (idx >= 0) {
            EditorInfo attribute = (EditorInfo) args[idx];
            attribute.packageName = FusionPack.A.getPkgName();
        }
        return super.onInvoke(source, method, args);
    }
}
