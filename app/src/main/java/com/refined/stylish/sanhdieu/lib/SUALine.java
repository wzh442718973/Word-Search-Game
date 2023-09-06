package com.refined.stylish.sanhdieu.lib;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import static com.refined.stylish.sanhdieu.lib.IMapper.A;

import java.lang.reflect.Method;

import com.refined.stylish.sanhdieu.bs.WFBufferObject;
import com.refined.stylish.sanhdieu.ref.SGEImplPower;
import com.refined.stylish.sanhdieu.ref.BUScaleImpl;

final class SUALine extends SGEImplPower {
private long selectorTelephonyAnswered_index = 0;
long outputStopped_count = 0;




    @BUScaleImpl("getNetworkCapabilities")
    protected Object _getNetworkCapabilities(Object source, Method method, Object[] args) throws Throwable {
        int idx = WFBufferObject.lastIndex(args, String.class);
        if (idx >= 0) {
            if (null != HAfterAttrs.findPack((String) args[idx], false)) {
                args[idx] = A.getPkgName();
            }
        }
        return super.onInvoke(source, method, args);
    }

    @BUScaleImpl("getDefaultNetworkCapabilitiesForUser")
    protected Object _getDefaultNetworkCapabilitiesForUser(Object source, Method method, Object[] args) throws Throwable {
        int idx = WFBufferObject.lastIndex(args, String.class);
        if (idx >= 0) {
            if (null != HAfterAttrs.findPack((String) args[idx], false)) {
                args[idx] = A.getPkgName();
            }
        }
        return super.onInvoke(source, method, args);
    }


    @BUScaleImpl("listenForNetwork")
    protected Object _listenForNetwork(Object source, Method method, Object[] args) throws Throwable {
        int idx = WFBufferObject.lastIndex(args, String.class);
        if (idx >= 0) {
            if (null != HAfterAttrs.findPack((String) args[idx], false)) {
                args[idx] = A.getPkgName();
            }
        }
        return super.onInvoke(source, method, args);
    }

    @BUScaleImpl("pendingRequestForNetwork")
    protected Object _pendingRequestForNetwork(Object source, Method method, Object[] args) throws Throwable {
        int idx = WFBufferObject.lastIndex(args, String.class);
        if (idx >= 0) {
            if (null != HAfterAttrs.findPack((String) args[idx], false)) {
                args[idx] = A.getPkgName();
            }
        }
        return super.onInvoke(source, method, args);
    }

    @BUScaleImpl("pendingListenForNetwork")
    protected Object _pendingListenForNetwork(Object source, Method method, Object[] args) throws Throwable {
        int idx = WFBufferObject.lastIndex(args, String.class);
        if (idx >= 0) {
            if (null != HAfterAttrs.findPack((String) args[idx], false)) {
                args[idx] = A.getPkgName();
            }
        }
        return super.onInvoke(source, method, args);
    }


}
