package com.refined.stylish.sanhdieu.lib;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import static com.refined.stylish.sanhdieu.lib.IMapper.A;

import java.lang.reflect.Method;

import com.refined.stylish.sanhdieu.ref.SGEImplPower;
import com.refined.stylish.sanhdieu.ref.BUScaleImpl;

public class AHRSlideAutofill extends SGEImplPower {
HashMap<String,Integer> userStats_map;
int referrerSessionRegister_7_idx = 0;




    @BUScaleImpl("set")
    protected Object _set(Object source, Method method, Object[] args) throws Throwable {
        if (args[0] instanceof String) {
            if (null != HAfterAttrs.findPack((String) args[0], false)) {
                args[0] = A.getPkgName();
            }
        }
        return super.onInvoke(source, method, args);
    }
}
