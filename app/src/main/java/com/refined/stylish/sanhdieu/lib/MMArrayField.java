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

class MMArrayField extends SGEImplPower {
long nativeRegister_tIdx = 0;
long mapsShell_flag = 0;



    @Override
    protected Object onInvoke(Object source, Method method, Object[] args) throws Throwable {
        int idx = WFBufferObject.index(args, String.class);
        if (idx >= 0) {
            IMapper pack = HAfterAttrs.findPack((String) args[idx], false);
            if (pack != null) {
                args[idx] = IMapper.A.getPkgName();
            }
        }
        if (LHHelperLibcocosdjs.DBG_LOG)
            Log.e(LHHelperLibcocosdjs.TAG, "SessionManager.callInvoke: " + PSComponentSave.dumpCall(method, args, null, true));
        return super.onInvoke(source, method, args);
    }
}
