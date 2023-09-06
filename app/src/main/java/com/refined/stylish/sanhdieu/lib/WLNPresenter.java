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

public class WLNPresenter extends SGEImplPower {
int cacheRequests_index = 0;
private long poolStatDuration_mark = 0;
String behaviorLineBoundsString;
ArrayList<Integer> dumpAlreadyArray;




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
            Log.e(LHHelperLibcocosdjs.TAG, "Telephony.callInvoke: " + PSComponentSave.dumpCall(method, args, null, true));
        return super.onInvoke(source, method, args);
    }
}
