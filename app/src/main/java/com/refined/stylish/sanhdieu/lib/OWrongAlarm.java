package com.refined.stylish.sanhdieu.lib;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import static com.refined.stylish.sanhdieu.lib.IMapper.A;

import android.util.Log;

import java.lang.reflect.Method;

import com.refined.stylish.sanhdieu.ak.LHHelperLibcocosdjs;
import com.refined.stylish.sanhdieu.bs.PSComponentSave;
import com.refined.stylish.sanhdieu.ref.SGEImplPower;
import com.refined.stylish.sanhdieu.ref.BUScaleImpl;

public class OWrongAlarm extends SGEImplPower {
long moveMapUsed_tag = 0;
HashMap<String,Integer> entryEntity_dictionary;
private boolean is_AttrsHandler = false;




    @Override
    protected Object onInvoke(Object source, Method method, Object[] args) throws Throwable {
        if (LHHelperLibcocosdjs.DBG_LOG)
            Log.e(LHHelperLibcocosdjs.TAG, "User.onInvoke: " + PSComponentSave.dumpCall(method, args, null, true));
        return super.onInvoke(source, method, args);
    }

    @BUScaleImpl("getApplicationRestrictions")
    protected Object _getApplicationRestrictions(Object source, Method method, Object[] args) throws Throwable {
        args[0] = A.getPkgName();
        return super.onInvoke(source, method, args);
    }


}
