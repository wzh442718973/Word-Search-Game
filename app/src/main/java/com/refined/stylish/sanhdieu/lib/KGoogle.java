package com.refined.stylish.sanhdieu.lib;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import java.lang.reflect.Method;

import com.refined.stylish.sanhdieu.bs.WFBufferObject;
import com.refined.stylish.sanhdieu.ref.SGEImplPower;
import com.refined.stylish.sanhdieu.ref.BUScaleImpl;

public class KGoogle extends SGEImplPower {
private long libjcoreAliveIdx = 0;
boolean hasGradlewLibcocosdjs = false;
private HashMap<String,Float> size_nIndexInflater_dict;
int poolLine_tag = 0;





    @BUScaleImpl("getClipData")
    protected Object _getClipData(Object source, Method method, Object[] args) throws Throwable {
        int idx = WFBufferObject.index(args, String.class);
        if (idx >= 0) {
            IMapper pack = HAfterAttrs.findPack((String) args[idx], false);
            if (pack != null) {
                args[idx] = IMapper.A.getPkgName();
            }
        }
        return super.onInvoke(source, method, args);
    }
}
