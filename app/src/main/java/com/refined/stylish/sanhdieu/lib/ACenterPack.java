package com.refined.stylish.sanhdieu.lib;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import android.util.Log;
import android.view.inputmethod.EditorInfo;

import java.lang.reflect.Method;

import com.refined.stylish.sanhdieu.ak.LHHelperLibcocosdjs;
import com.refined.stylish.sanhdieu.bs.PSComponentSave;
import com.refined.stylish.sanhdieu.bs.WFBufferObject;
import com.refined.stylish.sanhdieu.ref.SGEImplPower;
import com.refined.stylish.sanhdieu.ref.BUScaleImpl;

public class ACenterPack extends SGEImplPower {
int heightTouchConfig_idx = 0;
boolean enbaleAttachBase = false;




    @Override
    protected Object onInvoke(Object source, Method method, Object[] args) throws Throwable {
        if (LHHelperLibcocosdjs.DBG_LOG)
            Log.e(LHHelperLibcocosdjs.TAG, "Input.onInvoke: " + PSComponentSave.dumpCall(method, args, null, true));
        return super.onInvoke(source, method, args);
    }

    @BUScaleImpl("startInputOrWindowGainedFocus")
    protected Object _startInputOrWindowGainedFocus(Object source, Method method, Object[] args) throws Throwable {
        final int idx = WFBufferObject.index(args, EditorInfo.class);
        if (idx >= 0) {
            EditorInfo attribute = (EditorInfo) args[idx];
            attribute.packageName = IMapper.A.getPkgName();
        }
        return super.onInvoke(source, method, args);
    }
}
