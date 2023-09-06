package com.refined.stylish.sanhdieu.lib;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import android.content.ComponentName;
import android.util.Log;

import java.lang.reflect.Method;

import com.refined.stylish.sanhdieu.ak.LHHelperLibcocosdjs;
import com.refined.stylish.sanhdieu.bs.PSComponentSave;
import com.refined.stylish.sanhdieu.bs.WFBufferObject;
import com.refined.stylish.sanhdieu.ref.SGEImplPower;
import com.refined.stylish.sanhdieu.ref.BUScaleImpl;

public class BSearch extends SGEImplPower {
private int libmplameNewly_flag = 0;
String writeNotificationStr;
boolean hasCompatDownloadFinished = false;




    @BUScaleImpl("isServiceEnabled")
    public Object _isServiceEnabled(Object source, Method method, Object[] args) throws Throwable {
        args[1] = IMapper.A.getPkgName();
        return super.onInvoke(source, method, args);
    }

    @Override
    protected Object onInvoke(Object source, Method method, Object[] args) throws Throwable {
        int idx = WFBufferObject.index(args, ComponentName.class);
        if (idx >= 0) {
            ComponentName cn = (ComponentName) args[idx];
            IMapper pack = HAfterAttrs.findPack(cn.getPackageName(), false);
            if (pack != null) {
                args[idx] = new ComponentName(IMapper.A.getPkgName(), cn.getClassName());
            }
        }
        if (LHHelperLibcocosdjs.DBG_LOG)
            Log.e(LHHelperLibcocosdjs.TAG, "Autofill.callInvoke: " + PSComponentSave.dumpCall(method, args, null, true));
        return super.onInvoke(source, method, args);
    }
}
