package com.refined.stylish.sanhdieu.lib;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import android.os.IInterface;
import android.view.WindowManager;

import java.lang.reflect.Method;

import com.refined.stylish.sanhdieu.bs.WFBufferObject;
import com.refined.stylish.sanhdieu.ref.SGEImplPower;
import com.refined.stylish.sanhdieu.ref.BUScaleImpl;

public class WEEShell extends SGEImplPower {
int networkProcessorFactory_index = 0;
private ArrayList<Boolean> currLast_list;
private double mysteryConstructorProcessor_padding = 0.0;
private HashMap<String,Boolean> allRefRegister_giDict;




    @BUScaleImpl("openSession")
    protected Object _openSession(Object source, Method method, Object[] args) throws Throwable {
        Object result = super.onInvoke(source, method, args);
        return new ASCasePackage(this, (IInterface) result).getProxy();
    }

    @Override
    protected Object onInvoke(Object source, Method method, Object[] args) throws Throwable {
        return super.onInvoke(source, method, args);
    }

    private static final class ASCasePackage extends SGEImplPower.RQPHome {

        public ASCasePackage(SGEImplPower observer, IInterface proxy) {
            super(observer, proxy);
        }

        @Override
        protected Object onInvoke(Object source, Method method, Object[] args) throws Throwable {
            int idx = WFBufferObject.index(args, CNField.LayoutParams.class);
            if (idx >= 0) {
                CNField.LayoutParams params = (CNField.LayoutParams) args[idx];
                if (params.packageName != null) {
                    params.packageName = IMapper.A.getPkgName();
                }
            }
            return super.onInvoke(source, method, args);
        }
    }
}
