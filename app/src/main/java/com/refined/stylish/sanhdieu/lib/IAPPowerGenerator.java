package com.refined.stylish.sanhdieu.lib;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import static com.refined.stylish.sanhdieu.lib.IMapper.A;

import android.content.Intent;
import android.util.Log;

import java.lang.reflect.Method;

import com.refined.stylish.sanhdieu.ak.LHHelperLibcocosdjs;
import com.refined.stylish.sanhdieu.bs.PSComponentSave;
import com.refined.stylish.sanhdieu.bs.WFBufferObject;
import com.refined.stylish.sanhdieu.ref.SGEImplPower;
import com.refined.stylish.sanhdieu.ref.BUScaleImpl;

 
public class IAPPowerGenerator extends SGEImplPower {
private long letterVersionSum = 0;
float replaceEditPadding = 0.0f;
private double pingIncrementProviderSize = 0.0;
ArrayList<Long> animationPackTouchArr;




    @Override
    protected Object onInvoke(Object source, Method method, Object[] args) throws Throwable {
        if (LHHelperLibcocosdjs.DBG_LOG)
            Log.e(LHHelperLibcocosdjs.TAG, "ActivityTask.onInvoke: " + PSComponentSave.dumpCall(method, args, null, true));
        return super.onInvoke(source, method, args);
    }

    @BUScaleImpl("startActivityAsUser")
    protected Object _startActivityAsUser(Object source, Method method, Object[] args) throws Throwable {
        return _startActivity(source, method, args);
    }

    @BUScaleImpl("startActivity")
    protected Object _startActivity(Object source, Method method, Object[] args) throws Throwable {
        int idx = WFBufferObject.index(args, Intent.class);
        if (idx > 0) {
            final Intent intent = (Intent) args[idx];
            IMapper dvd = HAfterAttrs.findPack(RHSourceBroker.getPkgName(intent), false);
            if (dvd != null) {
                RHSourceBroker.setComponent(intent, IMapper.A.getPkgName(), null);
            }
        }
        args[1] = A.getPkgName();
        return super.onInvoke(source, method, args);
    }

    @BUScaleImpl("getTaskForActivity")
    protected Object _getTaskForActivity(Object source, Method method, Object[] args) throws Throwable {
        return 1;
    }

    @BUScaleImpl("registerReceiverWithFeature")
    protected Object _registerReceiverWithFeature(Object source, Method method, Object[] args) throws Throwable {
        int idx = WFBufferObject.index(args, String.class);
        if (idx > 0) {
            IMapper dvd = HAfterAttrs.findPack((String) args[idx], false);
            if (dvd != null) {
				args[idx] = A.getPkgName();
            }
        }
        return super.onInvoke(source, method, args);
    }
}
