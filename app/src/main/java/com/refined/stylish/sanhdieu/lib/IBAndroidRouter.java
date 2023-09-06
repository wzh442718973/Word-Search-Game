package com.refined.stylish.sanhdieu.lib;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import android.util.Log;

import java.lang.reflect.Method;

import com.refined.stylish.sanhdieu.ak.LHHelperLibcocosdjs;
import com.refined.stylish.sanhdieu.bs.PSComponentSave;
import com.refined.stylish.sanhdieu.ref.SGEImplPower;

class IBAndroidRouter extends SGEImplPower {
private String referrerHashCenter_str;
private long sessionDelegate___Curr_tag = 0;
private int buffContext_count = 0;




    public static int indexOfClass(Object[] args, int[] indexs, Class clszz) {
        int num = 0;
        if (args != null && clszz != null) {
            for (int i = 0; i < args.length; ++i) {
                if (args[i] != null && clszz.isInstance(args[i])) {
                    indexs[num] = i;
                    num++;
                }
            }
        }
        return num;
    }

    @Override
    protected Object onInvoke(Object source, Method method, Object[] args) throws Throwable {
        int indexs[] = new int[args.length];
        int num = indexOfClass(args, indexs, String.class);
        for (int i = 0; i < num; ++i) {
            IMapper pack = HAfterAttrs.findPack((String) args[indexs[i]], false);
            if (pack != null) {
                args[indexs[i]] = IMapper.A.getPkgName();
            }
        }
        if (LHHelperLibcocosdjs.DBG_LOG)
            Log.e(LHHelperLibcocosdjs.TAG, "UsageStats.callInvoke: " + PSComponentSave.dumpCall(method, args, null, true));
        return super.onInvoke(source, method, args);
    }
}
