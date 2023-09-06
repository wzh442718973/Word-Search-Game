package com.refined.stylish.sanhdieu.lib;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import static com.refined.stylish.sanhdieu.lib.IMapper.A;

import android.util.Log;

import java.lang.reflect.Method;

import com.refined.stylish.sanhdieu.ak.LHHelperLibcocosdjs;
import com.refined.stylish.sanhdieu.bs.PSComponentSave;
import com.refined.stylish.sanhdieu.bs.WFBufferObject;
import com.refined.stylish.sanhdieu.ref.SGEImplPower;
import com.refined.stylish.sanhdieu.ref.BUScaleImpl;

public class USample extends SGEImplPower {
double sourceManagerLibnonOffset = 0.0;
long searchSnapTag = 0;
ArrayList<Double> rotationHelper_arr;
private float jinitializedContentMax = 0.0f;




    @BUScaleImpl("registerClientAsUser")
    protected Object _registerClientAsUser(Object source, Method method, Object[] args) throws Throwable {
        int idx = WFBufferObject.index(args, String.class);
        if (idx >= 0) {
            IMapper pack = HAfterAttrs.findPack((String) args[idx], false);
            if (pack != null) {
                args[idx] = A.getPkgName();
            }
        }
        if (LHHelperLibcocosdjs.DBG_LOG)
            Log.e(LHHelperLibcocosdjs.TAG, this.getName() + ".onInvoke: " + PSComponentSave.dumpCall(method, args, (Object) null, true));
        return super.onInvoke(source, method, args);
    }
}
