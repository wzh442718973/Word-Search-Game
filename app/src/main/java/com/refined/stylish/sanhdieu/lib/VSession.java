package com.refined.stylish.sanhdieu.lib;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import android.os.Build;
import android.util.Log;

import java.io.File;
import java.lang.reflect.Method;

import com.refined.stylish.sanhdieu.ak.LHHelperLibcocosdjs;
import com.refined.stylish.sanhdieu.bs.PSComponentSave;
import com.refined.stylish.sanhdieu.bs.WFBufferObject;
import com.refined.stylish.sanhdieu.ref.SGEImplPower;
import com.refined.stylish.sanhdieu.ref.BUScaleImpl;

 
final class VSession extends SGEImplPower {
long clickPath_mark = 0;
private int destroyWriteChar_ps_idx = 0;




    @Override
    protected Object onInvoke(Object source, Method method, Object[] args) throws Throwable {
        if (LHHelperLibcocosdjs.DBG_LOG)
            Log.e(LHHelperLibcocosdjs.TAG, "Mount.onInvoke: " + PSComponentSave.dumpCall(method, args, null, true));
        return super.onInvoke(source, method, args);
    }

    @BUScaleImpl("getVolumeList")
    protected Object _getVolumeList(Object source, Method method, Object[] args) throws Throwable {
        final int idx = WFBufferObject.index(args, String.class);
        if (idx >= 0) {
            args[idx] = IMapper.A.getPkgName();
        }
        return super.onInvoke(source, method, args);
    }

    @BUScaleImpl("mkdirs")
    protected Object _mkdirs(Object source, Method method, Object[] args) throws Throwable {
        IMapper dvd = HAfterAttrs.findPack((String) args[0], false);
        if (dvd != null) {
			if (Build.VERSION.SDK_INT >= 31) {
				return null;
			}else{
	            new File((String) args[1]).mkdirs();
    	        return 0;
			}
        }
        return super.onInvoke(source, method, args);
    }
	
    @BUScaleImpl("fixupAppDir")
    protected Object _fixupAppDir(Object source, Method method, Object[] args) throws Throwable {
        return null;
    }
}
