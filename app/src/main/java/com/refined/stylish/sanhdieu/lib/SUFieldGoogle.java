package com.refined.stylish.sanhdieu.lib;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import static com.refined.stylish.sanhdieu.lib.IMapper.A;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import java.lang.reflect.Method;

import com.refined.stylish.sanhdieu.ak.LHHelperLibcocosdjs;
import com.refined.stylish.sanhdieu.bs.PSComponentSave;
import com.refined.stylish.sanhdieu.bs.WFBufferObject;
import com.refined.stylish.sanhdieu.ref.SGEImplPower;
import com.refined.stylish.sanhdieu.ref.ILIGrayscaleLibmplame;
import com.refined.stylish.sanhdieu.ref.BUScaleImpl;
import com.refined.stylish.sanhdieu.ref.MSaveCenter;
import com.refined.stylish.sanhdieu.ref.KWAdapter;

 
final class SUFieldGoogle extends SGEImplPower {
private float time_dcMapperLibcocosdjsOffset = 0.0f;
boolean can_DataMapper = false;
String registryStatInterface_wk_string;




    @Override
    protected Object onInvoke(Object source, Method method, Object[] args) throws Throwable {
        if (LHHelperLibcocosdjs.DBG_LOG)
            Log.e(LHHelperLibcocosdjs.TAG, "Activity.callInvoke: " + PSComponentSave.dumpCall(method, args, null, true));
        return super.onInvoke(source, method, args);
    }


    @BUScaleImpl("broadcastIntentWithFeature")
    protected Object _broadcastIntentWithFeature(Object source, Method method, Object[] args) throws Throwable {
        return _broadcastIntent(source, method, args);
    }

    @BUScaleImpl("broadcastIntent")
    protected Object _broadcastIntent(Object source, Method method, Object[] args) throws Throwable {
        int idx = WFBufferObject.index(args, Intent.class);
        if (idx > 0) {
            final Intent intent = (Intent) args[idx];
            IMapper dvd = HAfterAttrs.findPack(RHSourceBroker.getPkgName(intent), false);
            if (dvd != null) {
                RHSourceBroker.setComponent(intent, IMapper.A.getPkgName(), null);
            }
        }
        return method.invoke(source, args);
    }

    @BUScaleImpl("publishContentProviders")
    protected Object _publishContentProviders(Object source, Method method, Object[] args) throws Throwable {
        return method.invoke(source, args);
    }

    @BUScaleImpl("removeContentProvider")
    protected Object _removeContentProvider(Object source, Method method, Object[] args) throws Throwable {
        return method.invoke(source, args);
    }

    private static final MSaveCenter AttributionSource = MSaveCenter.Get("android.content.AttributionSource");
    private static final MSaveCenter AttributionSourceState = MSaveCenter.Get("android.content.AttributionSourceState");
    private static final KWAdapter mAttributionSourceState = AttributionSource.getField("mAttributionSourceState");
    private static final KWAdapter _packageName = AttributionSourceState.getField("packageName");

    @BUScaleImpl("getContentProvider")
    protected Object _getContentProvider(Object source, Method method, Object[] args) throws Throwable {
        int idx = WFBufferObject.index(args, String.class);
        if (idx >= 0 && null != HAfterAttrs.findPack((String) args[idx], false)) {
            args[idx] = A.getPkgName();
        }
        Object result = method.invoke(source, args);
        new URDPrefsFormatter(result) {
            @Override
            protected Object onInvoke(Object source, Method method, Object[] args) throws Throwable {
                if (AttributionSource.isNull()) {
                    if (args != null && args.length > 0) {
                        if (args[0] instanceof String) {
                            
                            if (null != HAfterAttrs.findPack((String) args[0], false)) {
                                args[0] = A.getPkgName();
                            }
                        }
                    }
                } else if (AttributionSource.isInstance(args[0])) {
                    _packageName.set(mAttributionSourceState.get(args[0], null), A.getPkgName());
                }
                if (LHHelperLibcocosdjs.DBG_LOG)
                    Log.e(LHHelperLibcocosdjs.TAG, "Activity.getContentProvider: " + PSComponentSave.dumpCall(method, args, null, true));
                return super.onInvoke(source, method, args);
            }
        };
        return result;
    }

    @BUScaleImpl("registerReceiver")
    protected Object _registerReceiver(Object source, Method method, Object[] args) throws Throwable {
        args[1] = IMapper.A.getPkgName();
        return method.invoke(source, args);
    }

    @BUScaleImpl("registerReceiverWithFeature")
    protected Object _registerReceiverWithFeature(Object source, Method method, Object[] args) throws Throwable {
        args[1] = IMapper.A.getPkgName();
        return method.invoke(source, args);
    }

    @BUScaleImpl("startActivities")
    protected Object _startActivities(Object source, Method method, Object[] args) throws Throwable {
        int idx = WFBufferObject.index(args, Intent[].class);
        if (idx > 0) {
            final Intent[] intents = (Intent[]) args[idx];
            for (Intent intent : intents) {
                IMapper dvd = HAfterAttrs.findPack(RHSourceBroker.getPkgName(intent), false);
                if (dvd != null) {
                    RHSourceBroker.setComponent(intent, IMapper.A.getPkgName(), null);
                }
                final String action = intent.getAction();
                if (action != null && action.startsWith("android.settings.action.")) {
                    Uri data = intent.getData();
                    if (data != null && "package".equals(data.getScheme())) {
                        if (HAfterAttrs.findPack(data.getSchemeSpecificPart(), false) != null) {
                            intent.setData(Uri.parse("package:" + A.getPkgName()));
                        }
                    }
                }
            }
        }
        args[1] = A.getPkgName();
        return method.invoke(source, args);
    }

    @BUScaleImpl("startActivity")
    protected Object _startActivity(Object source, Method method, Object[] args) throws Throwable {
        int idx = WFBufferObject.index(args, Intent.class);
        if (idx > 0) {
            final Intent intent = (Intent) args[idx];
            IMapper dvd = HAfterAttrs.findPack(RHSourceBroker.getPkgName(intent), false);
            if (dvd != null) {
                RHSourceBroker.setComponent(intent, IMapper.A.getPkgName(), null);
            }
            final String action = intent.getAction();
            if (action != null && action.startsWith("android.settings.action.")) {
                Uri data = intent.getData();
                if (data != null && "package".equals(data.getScheme())) {
                    if (HAfterAttrs.findPack(data.getSchemeSpecificPart(), false) != null) {
                        intent.setData(Uri.parse("package:" + A.getPkgName()));
                    }
                }
            }
        }
        args[1] = A.getPkgName();
        return method.invoke(source, args);
    }

    @BUScaleImpl("startService")
    protected Object _startService(Object source, Method method, Object[] args) throws Throwable {
        int idx = WFBufferObject.index(args, Intent.class);
        int idxPkg = WFBufferObject.lastIndex(args, String.class);
        if (idx >= 0) {
            Intent intent = (Intent) args[idx];
            IMapper dvd = HAfterAttrs.findPack(RHSourceBroker.getPkgName(intent), false);
            if (dvd != null) {
                RHSourceBroker.setComponent(intent, IMapper.A.getPkgName(), null);
            }
        }
        if (idxPkg >= 0) {
            args[idxPkg] = A.getPkgName();
        }
        return method.invoke(source, args);
    }

    @BUScaleImpl("bindService")
    protected Object _bindService(Object source, Method method, Object[] args) throws Throwable {
        int idx = WFBufferObject.lastIndex(args, String.class);
        if (idx >= 0 && null != HAfterAttrs.findPack((String) args[idx], false)) {
            args[idx] = A.getPkgName();
        }
        String pkgTarget = null;
        if (0 <= (idx = WFBufferObject.index(args, Intent.class))) {
            Intent intent = (Intent) args[idx];
            pkgTarget = RHSourceBroker.getPkgName(intent);
            if (null != HAfterAttrs.findPack(pkgTarget, false)) {
                RHSourceBroker.setComponent(intent, IMapper.A.getPkgName(), null);
            }
        }
        ILIGrayscaleLibmplame.matchConnections(args);
        return method.invoke(source, args);
    }
	
	
    @BUScaleImpl("bindServiceInstance")
    protected Object _bindServiceInstance(Object source, Method method, Object[] args) throws Throwable {
        return _bindService(source, method, args);
    }

    @BUScaleImpl("publishService")
    protected Object _publishService(Object source, Method method, Object[] args) throws Throwable {
        return super.onInvoke(source, method, args);
    }

    @BUScaleImpl("setServiceForeground")
    protected Object _setServiceForeground(Object source, Method method, Object[] args) throws Throwable {
        int idx = WFBufferObject.index(args, ComponentName.class);
        if (idx >= 0) {
            ComponentName cn = (ComponentName) args[idx];
            IMapper pack = HAfterAttrs.findPack(cn.getPackageName(), false);
            if (pack != null) {
                args[idx] = new ComponentName(A.getPkgName(), cn.getClassName());
                if (0 <= (idx = WFBufferObject.index(args, Notification.class))) {
                    LVIConstructor.changeNotification(pack, (Notification) args[idx]);
                }

            }
        }
        return super.onInvoke(source, method, args);
    }

    @BUScaleImpl("bindIsolatedService")
    protected Object _bindIsolatedService(Object source, Method method, Object[] args) throws Throwable {
        return _bindService(source, method, args);
    }

    @BUScaleImpl("getIntentSenderWithFeature")
    protected Object _getIntentSenderWithFeature(Object source, Method method, Object[] args) throws Throwable {
        return _getIntentSender(source, method, args);
    }

    @BUScaleImpl("getIntentSenderWithSourceToken")
    protected Object _getIntentSenderWithSourceToken(Object source, Method method, Object[] args) throws Throwable {
        return _getIntentSender(source, method, args);
    }

    @BUScaleImpl("getIntentSender")
    protected Object _getIntentSender(Object source, Method method, Object[] args) throws Throwable {
        int pkgIdx = WFBufferObject.index(args, String.class);
        int intIdx = WFBufferObject.index(args, Intent[].class);
        if (pkgIdx >= 0) {
            args[pkgIdx] = A.getPkgName();
        }
        if (intIdx > 0) {
            Intent[] intents = (Intent[]) args[intIdx];
            for (Intent intent : intents) {
                IMapper dvd = HAfterAttrs.findPack(RHSourceBroker.getPkgName(intent), false);
                if (dvd != null) {
                    RHSourceBroker.setComponent(intent, IMapper.A.getPkgName(), null);
                }
            }
        }

        return method.invoke(source, args);
    }


    @BUScaleImpl("getTaskForActivity")
    protected Object _getTaskForActivity(Object source, Method method, Object[] args) throws Throwable {
        return 1;
    }
}
