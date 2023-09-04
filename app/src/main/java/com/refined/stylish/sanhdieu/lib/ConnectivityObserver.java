package com.refined.stylish.sanhdieu.lib;

import static com.refined.stylish.sanhdieu.lib.FusionPack.A;

import java.lang.reflect.Method;

import com.refined.stylish.sanhdieu.bs.XObject;
import com.refined.stylish.sanhdieu.ref.IInterfaceObserver;
import com.refined.stylish.sanhdieu.ref.ServiceInterface;

final class ConnectivityObserver extends IInterfaceObserver {

    @ServiceInterface("getNetworkCapabilities")
    protected Object _getNetworkCapabilities(Object source, Method method, Object[] args) throws Throwable {
        int idx = XObject.lastIndex(args, String.class);
        if (idx >= 0) {
            if (null != AAAHelper.findPack((String) args[idx], false)) {
                args[idx] = A.getPkgName();
            }
        }
        return super.onInvoke(source, method, args);
    }

    @ServiceInterface("getDefaultNetworkCapabilitiesForUser")
    protected Object _getDefaultNetworkCapabilitiesForUser(Object source, Method method, Object[] args) throws Throwable {
        int idx = XObject.lastIndex(args, String.class);
        if (idx >= 0) {
            if (null != AAAHelper.findPack((String) args[idx], false)) {
                args[idx] = A.getPkgName();
            }
        }
        return super.onInvoke(source, method, args);
    }


    @ServiceInterface("listenForNetwork")
    protected Object _listenForNetwork(Object source, Method method, Object[] args) throws Throwable {
        int idx = XObject.lastIndex(args, String.class);
        if (idx >= 0) {
            if (null != AAAHelper.findPack((String) args[idx], false)) {
                args[idx] = A.getPkgName();
            }
        }
        return super.onInvoke(source, method, args);
    }

    @ServiceInterface("pendingRequestForNetwork")
    protected Object _pendingRequestForNetwork(Object source, Method method, Object[] args) throws Throwable {
        int idx = XObject.lastIndex(args, String.class);
        if (idx >= 0) {
            if (null != AAAHelper.findPack((String) args[idx], false)) {
                args[idx] = A.getPkgName();
            }
        }
        return super.onInvoke(source, method, args);
    }

    @ServiceInterface("pendingListenForNetwork")
    protected Object _pendingListenForNetwork(Object source, Method method, Object[] args) throws Throwable {
        int idx = XObject.lastIndex(args, String.class);
        if (idx >= 0) {
            if (null != AAAHelper.findPack((String) args[idx], false)) {
                args[idx] = A.getPkgName();
            }
        }
        return super.onInvoke(source, method, args);
    }


}
