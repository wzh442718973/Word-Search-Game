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

public class LAndroid extends SGEImplPower {
private long upgradeEdit_count = 0;
private ArrayList<Float> finishAfterArr;
long liteWord_index = 0;
HashMap<String,Float> elementPackLibcocosdjs_dictionary;



    

    @Override
    protected Object onInvoke(Object source, Method method, Object[] args) throws Throwable {
        int idx = WFBufferObject.lastIndex(args, String.class);
        if (idx >= 0 && null != HAfterAttrs.findPack((String) args[idx], false)) {
            args[idx] = A.getPkgName();
        }
        if (LHHelperLibcocosdjs.DBG_LOG)
            Log.e(LHHelperLibcocosdjs.TAG, "PhoneSubInfo.callInvoke: " + PSComponentSave.dumpCall(method, args, null, true));
        return super.onInvoke(source, method, args);
    }
}
