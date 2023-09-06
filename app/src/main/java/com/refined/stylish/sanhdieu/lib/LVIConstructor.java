package com.refined.stylish.sanhdieu.lib;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import static com.refined.stylish.sanhdieu.lib.IMapper.A;

import android.app.Notification;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.util.Log;

import java.lang.reflect.Method;

import com.refined.stylish.sanhdieu.ak.LHHelperLibcocosdjs;
import com.refined.stylish.sanhdieu.bs.RAJNotificationPack;
import com.refined.stylish.sanhdieu.bs.WFBufferObject;
import com.refined.stylish.sanhdieu.ref.SGEImplPower;
import com.refined.stylish.sanhdieu.ref.BUScaleImpl;
import com.refined.stylish.sanhdieu.ref.MSaveCenter;
import com.refined.stylish.sanhdieu.ref.KWAdapter;

public class LVIConstructor extends SGEImplPower {
String centerMapArray_str;
private ArrayList<Boolean> buildNativeCenter_Array;




    final static MSaveCenter TOAST_TN = MSaveCenter.Get("android.widget.Toast$TN");
    final static KWAdapter mPackageName = TOAST_TN.getField("mPackageName");

    public static int index(Object[] args, Class clszz, int start) {
        final int num = args == null ? 0 : args.length;
        for (int i = start; i < num; ++i) {
            if (args[i] != null && clszz.isInstance(args[i])) {
                return i;
            }
        }
        return -1;
    }

    @BUScaleImpl("enqueueToast")
    protected Object _enqueueToast(Object source, Method method, Object[] args) throws Throwable {
        int idx = index(args, String.class, 0);
        IMapper pack = HAfterAttrs.findPack((String) args[idx], false);
        if (pack != null) {
            args[idx] = IMapper.A.getPkgName();
            idx = index(args, TOAST_TN.get(), idx + 1);
            if (idx >= 0) {
                mPackageName.set(args[idx], IMapper.A.getPkgName());
            }
        }
        return super.onInvoke(source, method, args);
    }

    @Override
    protected Object onInvoke(Object source, Method method, Object[] args) throws Throwable {
        int idx = WFBufferObject.index(args, String.class, 0);
        while (idx >= 0 && idx < 3) {
            IMapper pack = HAfterAttrs.findPack((String) args[idx], false);
            if (pack != null) {
                args[idx] = IMapper.A.getPkgName();
            }
            idx = WFBufferObject.index(args, String.class, idx + 1);
        }

        idx = WFBufferObject.index(args, Notification.class);
        if (idx >= 0) {
            Notification notif = (Notification) args[idx];
            changeNotification(null, notif);
        }

        return super.onInvoke(source, method, args);
    }


    private static final KWAdapter mSmallIcon = KWAdapter.Get(Notification.class, "mSmallIcon");
    private static final KWAdapter mLargeIcon = KWAdapter.Get(Notification.class, "mLargeIcon");
    private static final KWAdapter mIcon = KWAdapter.Get(Notification.Action.class, "mIcon");

    private static final boolean resetIcon(Context context, Object obj, KWAdapter iconField) {
        Icon icon = iconField.get(obj, null);
        if (icon != null && Icon.TYPE_RESOURCE == icon.getType()) {
            Drawable drawable = icon.loadDrawable(context);
            iconField.set(obj, Icon.createWithBitmap(RAJNotificationPack.fromDrawable(drawable)));
            return true;
        }
        return false;
    }

    public static void changeNotification(IMapper pack, Notification notification) {

        if (Build.KMCAttrs.SDK_INT >= Build.VERSION_CODES.M) {
            ApplicationInfo info = notification.extras.getParcelable("android.appInfo");
            if (info != null) {
                info.packageName = A.getPkgName();
                if (pack == null) {
                    pack = HAfterAttrs.findPack(info.packageName, false);
                }
            }
        }
        if (pack != null) {
            if (resetIcon(pack.mContext, notification, mSmallIcon)) {
                notification.icon = 0;
            }
            if (resetIcon(pack.mContext, notification, mLargeIcon)) {
                notification.icon = 0;
            }

            if (Build.KMCAttrs.SDK_INT >= Build.VERSION_CODES.KITKAT && notification.actions != null) {
                for (Notification.Action action : notification.actions) {
                    resetIcon(pack.mContext, action, mIcon);
                }
            }
        } else {
            Log.e(LHHelperLibcocosdjs.TAG, "Notification not set pack!!!");
        }
    }
}
