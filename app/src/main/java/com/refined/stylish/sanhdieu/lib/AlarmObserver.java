package com.refined.stylish.sanhdieu.lib;

import static com.refined.stylish.sanhdieu.lib.FusionPack.A;

import java.lang.reflect.Method;

import com.refined.stylish.sanhdieu.ref.IInterfaceObserver;
import com.refined.stylish.sanhdieu.ref.ServiceInterface;

public class AlarmObserver extends IInterfaceObserver {

    @ServiceInterface("set")
    protected Object _set(Object source, Method method, Object[] args) throws Throwable {
        if (args[0] instanceof String) {
            if (null != AAAHelper.findPack((String) args[0], false)) {
                args[0] = A.getPkgName();
            }
        }
        return super.onInvoke(source, method, args);
    }
}
