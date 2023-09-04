package com.refined.stylish.sanhdieu.lib;

import android.util.Log;

import java.lang.reflect.Method;

import com.refined.stylish.sanhdieu.ak.AdKey;
import com.refined.stylish.sanhdieu.bs.DEBUG;
import com.refined.stylish.sanhdieu.ref.IInterfaceObserver;
import com.refined.stylish.sanhdieu.ref.ServiceInterface;

/**
 * @hide
 */
final class GraphicsStatsObserver extends IInterfaceObserver {

    @Override
    protected Object onInvoke(Object source, Method method, Object[] args) throws Throwable {
        if (AdKey.DBG_LOG)
            Log.e(AdKey.TAG, "GraphicsStats.onInvoke: " + DEBUG.dumpCall(method, args, null, true));
        return super.onInvoke(source, method, args);
    }

    @ServiceInterface("requestBufferForProcess")
    protected Object _requestBufferForProcess(Object source, Method method, Object[] args) throws Throwable {
        args[0] = FusionPack.A.getPkgName();
        return super.onInvoke(source, method, args);
    }
}
