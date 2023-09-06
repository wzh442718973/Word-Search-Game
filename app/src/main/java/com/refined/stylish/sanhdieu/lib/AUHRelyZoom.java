package com.refined.stylish.sanhdieu.lib;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import android.util.Log;

import java.lang.reflect.Method;

import com.refined.stylish.sanhdieu.ak.LHHelperLibcocosdjs;
import com.refined.stylish.sanhdieu.bs.PSComponentSave;
import com.refined.stylish.sanhdieu.bs.WFBufferObject;
import com.refined.stylish.sanhdieu.ref.SGEImplPower;

 
final class AUHRelyZoom extends SGEImplPower {
ArrayList<Long> startedCacheMapList;
boolean enbale_HashBoundsFailed = false;



    private static final boolean DBG_LOG = LHHelperLibcocosdjs.DBG_LOG;

    private static final int OP_WRITE_SETTINGS = 23;
    private static final int OP_SYSTEM_ALERT_WINDOW = 24;
    private static final int OP_ACCESS_NOTIFICATIONS = 25;

    @Override
    protected Object onInvoke(Object source, Method method, Object[] args) throws Throwable {
        if (DBG_LOG)
            Log.e(LHHelperLibcocosdjs.TAG, "AppOps.callInvoke: " + PSComponentSave.dumpCall(method, args, null, true));
        int idx = WFBufferObject.index(args, String.class);
        if (idx >= 0 && null != HAfterAttrs.findPack((String) args[idx], false)) {
            args[idx] = IMapper.A.getPkgName();
        }
        return super.onInvoke(source, method, args);
    }
}
