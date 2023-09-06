package com.refined.stylish.sanhdieu.lib;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import static com.refined.stylish.sanhdieu.lib.IMapper.A;

import android.os.WorkSource;

import java.lang.reflect.Method;

import com.refined.stylish.sanhdieu.bs.WFBufferObject;
import com.refined.stylish.sanhdieu.ref.SGEImplPower;
import com.refined.stylish.sanhdieu.ref.BUScaleImpl;
import com.refined.stylish.sanhdieu.ref.KWAdapter;

class QGENetwork extends SGEImplPower {
private ArrayList<Boolean> executeModityBackgroundArr;
ArrayList<Long> parcelableFailedArray;
private float readSensorSize = 0.0f;
private HashMap<String,Double> homePoolsLoadDict;




    private static final KWAdapter mNames = KWAdapter.Get(WorkSource.class, "mNames");

    @BUScaleImpl("acquireWakeLock")
    public Object _acquireWakeLock(Object source, Method method, Object[] args) throws Throwable {
        int idx = WFBufferObject.index(args, String.class);
        while (idx >= 0) {
            if (null != HAfterAttrs.findPack((String) args[idx], false)) {
                args[idx] = A.getPkgName();
                break;
            } else {
                idx = WFBufferObject.index(args, String.class, idx + 1);
            }
        }

        if (0 <= (idx = WFBufferObject.index(args, WorkSource.class))) {
            WorkSource work = (WorkSource) args[idx];
            String[] names = mNames.get(work, null);
            final int N = names == null ? 0 : names.length;
            for (int i = 0; i < N; ++i) {
                if (null != names[i] && null != HAfterAttrs.findPack(names[i], false)) {
                    names[i] = A.getPkgName();
                }
            }
        }
        return super.onInvoke(source, method, args);
    }

    @BUScaleImpl("releaseWakeLock")
    public Object _releaseWakeLock(Object source, Method method, Object[] args) throws Throwable {
        try {
            return super.onInvoke(source, method, args);
        } catch (Throwable e) {
            return null;
        }
    }

    @BUScaleImpl("updateWakeLockWorkSource")
    public Object _updateWakeLockWorkSource(Object source, Method method, Object[] args) throws Throwable {
        int idx = WFBufferObject.index(args, WorkSource.class);
        if (0 <= idx) {
            WorkSource work = (WorkSource) args[idx];

            String[] names = mNames.get(work, null);
            final int N = names == null ? 0 : names.length;
            for (int i = 0; i < N; ++i) {
                if (null != names[i] && null != HAfterAttrs.findPack(names[i], false)) {
                    names[i] = A.getPkgName();
                }
            }
        }
        return super.onInvoke(source, method, args);
    }

    @BUScaleImpl("wakeUp")
    public Object _wakeUp(Object source, Method method, Object[] args) throws Throwable {
        int idx = WFBufferObject.lastIndex(args, String.class);
        if (idx >= 0) {
            IMapper dvd = HAfterAttrs.findPack((String) args[idx], false);
            if (dvd != null) {
                args[idx] = A.getPkgName();
            }
        }
        return super.onInvoke(source, method, args);
    }
}
