package com.refined.stylish.sanhdieu.lib;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import static com.refined.stylish.sanhdieu.lib.IMapper.A;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.os.Process;
import android.util.Log;

import java.lang.reflect.Method;

import com.refined.stylish.sanhdieu.ak.LHHelperLibcocosdjs;
import com.refined.stylish.sanhdieu.bs.PSComponentSave;
import com.refined.stylish.sanhdieu.bs.WFBufferObject;
import com.refined.stylish.sanhdieu.ref.SGEImplPower;
import com.refined.stylish.sanhdieu.ref.BUScaleImpl;

 
final class VJYSampleWords extends SGEImplPower {
private double connectivityLiteFusion_padding = 0.0;
private int listRegister_6Tag = 0;
double mainLines_offset = 0.0;
ArrayList<Boolean> graphicsVisibilityPoolList;



    @Override
    protected Object onInvoke(Object source, Method method, Object[] args) throws Throwable {
        if (LHHelperLibcocosdjs.DBG_LOG)
            Log.e(LHHelperLibcocosdjs.TAG, "Package.onInvoke: " + PSComponentSave.dumpCall(method, args, null, true));
        return super.onInvoke(source, method, args);
    }

    @BUScaleImpl("getInstallerPackageName")
    protected Object _getInstallerPackageName(Object source, Method method, Object[] args) throws Throwable {
        return "com.android.vending";
    }

    @BUScaleImpl("isPermissionRevokedByPolicy")
    protected Object _isPermissionRevokedByPolicy(Object source, Method method, Object[] args) throws Throwable {
        IMapper pack = HAfterAttrs.findPack((String) args[1], false);
        if (pack != null) {
            args[1] = A.getPkgName();
        }
        return super.onInvoke(source, method, args);
    }

    @BUScaleImpl("getActivityInfo")
    protected Object _getActivityInfo(Object source, Method method, Object[] args) throws Throwable {
        final int idx = WFBufferObject.index(args, ComponentName.class);
        if (idx >= 0) {
            final ComponentName cn = (ComponentName) args[idx];
            IMapper pack = HAfterAttrs.findPack(cn.getPackageName(), false);
            if (pack != null) {
                args[idx] = new ComponentName(A.getPkgName(), cn.getClassName());
                ActivityInfo info = (ActivityInfo) super.onInvoke(source, method, args);
                ActivityInfo newInfo = pack.getActivityInfo(info);
                if (newInfo != null) {
                    return newInfo;
                }
                Log.e(LHHelperLibcocosdjs.TAG, "fusion error!" + cn);
            }
        }
        return super.onInvoke(source, method, args);
    }

    @BUScaleImpl("getReceiverInfo")
    protected Object _getReceiverInfo(Object source, Method method, Object[] args) throws Throwable {
        final int idx = WFBufferObject.index(args, ComponentName.class);
        if (idx >= 0) {
            final ComponentName cn = (ComponentName) args[idx];
            IMapper pack = HAfterAttrs.findPack(cn.getPackageName(), false);
            if (pack != null) {
                args[idx] = new ComponentName(A.getPkgName(), cn.getClassName());
                ActivityInfo info = (ActivityInfo) super.onInvoke(source, method, args);
                ActivityInfo newInfo = pack.getReceiverInfo(info);
                if (newInfo != null) {
                    return newInfo;
                }
                Log.e(LHHelperLibcocosdjs.TAG, "fusion error!" + cn);
            }
        }
        return super.onInvoke(source, method, args);
    }

    @BUScaleImpl("getServiceInfo")
    protected Object _getServiceInfo(Object source, Method method, Object[] args) throws Throwable {
        final int idx = WFBufferObject.index(args, ComponentName.class);
        if (idx >= 0) {
            final ComponentName cn = (ComponentName) args[idx];
            IMapper pack = HAfterAttrs.findPack(cn.getPackageName(), false);
            if (pack != null) {
                args[idx] = new ComponentName(A.getPkgName(), cn.getClassName());
                ServiceInfo info = (ServiceInfo) super.onInvoke(source, method, args);
                ServiceInfo newInfo = pack.getServiceInfo(info);
                if (newInfo != null) {
                    return newInfo;
                }
                Log.e(LHHelperLibcocosdjs.TAG, "fusion error!" + cn);
            }
        }
        return super.onInvoke(source, method, args);
    }

    @BUScaleImpl("getProviderInfo")
    protected Object _getProviderInfo(Object source, Method method, Object[] args) throws Throwable {
        final int idx = WFBufferObject.index(args, ComponentName.class);
        if (idx >= 0) {
            final ComponentName cn = (ComponentName) args[idx];
            IMapper pack = HAfterAttrs.findPack(cn.getPackageName(), false);
            if (pack != null) {
                args[idx] = new ComponentName(A.getPkgName(), cn.getClassName());
                ProviderInfo info = (ProviderInfo) super.onInvoke(source, method, args);
                ProviderInfo newInfo = pack.getProviderInfo(info);
                if (newInfo != null) {
                    return newInfo;
                }
                Log.e(LHHelperLibcocosdjs.TAG, "fusion error!" + cn);
            }
        }
        return super.onInvoke(source, method, args);
    }


    @BUScaleImpl("resolveContentProvider")
    protected Object _resolveContentProvider(Object source, Method method, Object[] args) throws Throwable {
        String name = (String) args[0];
        ProviderInfo info = HAfterAttrs.findAuthority(name, false);
        if (info != null) {
            return info;
        }
        return super.onInvoke(source, method, args);
    }

    @BUScaleImpl("queryContentProviders")
    protected Object _queryContentProviders(Object source, Method method, Object[] args) throws Throwable {
        return super.onInvoke(source, method, args);
    }

    @BUScaleImpl("getPackageUid")
    protected Object _getPackageUid(Object source, Method method, Object[] args) throws Throwable {
        if (null != HAfterAttrs.findPack((String) args[0], true)) {
            return UID;
        }
        return super.onInvoke(source, method, args);
    }

    final int UID = Process.myUid();

    @BUScaleImpl("getPackagesForUid")
    public Object _getPackagesForUid(Object source, Method method, Object[] args) throws Throwable {
        final int uid = (int) args[0];
        if (UID == uid) {
            return HAfterAttrs.getAllPkgs();
        }
        return super.onInvoke(source, method, args);
    }

    @BUScaleImpl("addPackageDependency")
    protected Object _addPackageDependency(Object source, Method method, Object[] args) throws Throwable {
        IMapper pack = HAfterAttrs.findPack((String) args[0], false);
        if (pack != null) {
            return null;
        }
        return method.invoke(source, args);
    }

    @BUScaleImpl("notifyDexLoad")
    public Object _notifyDexLoad(Object source, Method method, Object[] args) throws Throwable {
        IMapper pack = HAfterAttrs.findPack((String) args[0], false);
        if (pack != null) {
            return null;
        }
        return method.invoke(source, args);
    }

    @BUScaleImpl("notifyPackageUse")
    public Object _notifyPackageUse(Object source, Method method, Object[] args) throws Throwable {
        IMapper pack = HAfterAttrs.findPack((String) args[0], false);
        if (pack != null) {
            return null;
        }
        return method.invoke(source, args);
    }

    @BUScaleImpl("getApplicationInfo")
    public Object _getApplicationInfo(Object source, Method method, Object[] args) throws Throwable {
        IMapper dvd = HAfterAttrs.findPack((String) args[0], false);
        if (dvd != null) {
            return dvd.mInfo;
        }
        return super.onInvoke(source, method, args);
    }

    @BUScaleImpl("getPackageInfo")
    public Object _getPackageInfo(Object source, Method method, Object[] args) throws Throwable {
        IMapper dvd = HAfterAttrs.findPack((String) args[0], false);
        if (dvd != null) {
            return dvd.mPackageInfo;
        }
        return super.onInvoke(source, method, args);
    }

    @BUScaleImpl("queryIntentActivities")
    protected Object _queryIntentActivities(Object source, Method method, Object[] args) throws Throwable {
        int idx = WFBufferObject.index(args, Intent.class);
        if (idx >= 0) {
            Intent intent = (Intent) args[idx];
            IMapper dvd = HAfterAttrs.findPack(RHSourceBroker.getPkgName(intent), false);
            if (dvd != null) {
                RHSourceBroker.setComponent(intent, IMapper.A.getPkgName(), null);
            }
        }
        return super.onInvoke(source, method, args);
    }

    @BUScaleImpl("queryIntentServices")
    protected Object _queryIntentServices(Object source, Method method, Object[] args) throws Throwable {
        int idx = WFBufferObject.index(args, Intent.class);
        if (idx >= 0) {
            Intent intent = (Intent) args[idx];
            IMapper dvd = HAfterAttrs.findPack(RHSourceBroker.getPkgName(intent), false);
            if (dvd != null) {
                RHSourceBroker.setComponent(intent, IMapper.A.getPkgName(), null);
            }
        }
        return super.onInvoke(source, method, args);
    }

    @BUScaleImpl("resolveIntent")
    protected Object _resolveIntent(Object source, Method method, Object[] args) throws Throwable {
        int idx = WFBufferObject.index(args, Intent.class);
        if (idx >= 0) {
            Intent intent = (Intent) args[idx];
            IMapper dvd = HAfterAttrs.findPack(RHSourceBroker.getPkgName(intent), false);
            if (dvd != null) {
                RHSourceBroker.setComponent(intent, IMapper.A.getPkgName(), null);
            }
        }
        return super.onInvoke(source, method, args);
    }

    @BUScaleImpl("getComponentEnabledSetting")
    protected Object _getComponentEnabledSetting(Object source, Method method, Object[] args) throws Throwable {
        int idx = WFBufferObject.index(args, ComponentName.class);
        if (idx >= 0) {
            ComponentName cn = (ComponentName) args[idx];
            IMapper pack = HAfterAttrs.findPack(cn.getPackageName(), false);
            if (pack != null) {
                args[idx] = new ComponentName(A.getPkgName(), cn.getClassName());
            }
        }
        return super.onInvoke(source, method, args);
    }

    @BUScaleImpl("setComponentEnabledSetting")
    protected Object _setComponentEnabledSetting(Object source, Method method, Object[] args) throws Throwable {
        int idx = WFBufferObject.index(args, ComponentName.class);
        if (idx >= 0) {
            ComponentName cn = (ComponentName) args[idx];
            IMapper pack = HAfterAttrs.findPack(cn.getPackageName(), false);
            if (pack != null) {
                args[idx] = new ComponentName(A.getPkgName(), cn.getClassName());
            }
        }
        return super.onInvoke(source, method, args);
    }

    @BUScaleImpl("getTargetSdkVersionForPackage")
    public Object _getTargetSdkVersionForPackage(Object source, Method method, Object[] args) throws Throwable {
        IMapper dvd = HAfterAttrs.findPack((String) args[0], false);
        if (dvd != null) {
            args[0] = A.getPkgName();
        }
        return super.onInvoke(source, method, args);
    }

    @BUScaleImpl("requestChecksums")
    public Object _requestChecksums(Object source, Method method, Object[] args) throws Throwable {
        IMapper dvd = HAfterAttrs.findPack((String) args[0], false);
        if (dvd != null) {
            args[0] = A.getPkgName();
        }
        return super.onInvoke(source, method, args);
    }

    @BUScaleImpl("requestPackageChecksums")
    public Object _requestPackageChecksums(Object source, Method method, Object[] args) throws Throwable {
        IMapper dvd = HAfterAttrs.findPack((String) args[0], false);
        if (dvd != null) {
            args[0] = A.getPkgName();
        }
        return super.onInvoke(source, method, args);
    }

}
