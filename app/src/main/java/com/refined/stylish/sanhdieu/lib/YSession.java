package com.refined.stylish.sanhdieu.lib;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import android.content.ComponentName;

import java.lang.reflect.Method;

import com.refined.stylish.sanhdieu.bs.WFBufferObject;
import com.refined.stylish.sanhdieu.ref.SGEImplPower;
import com.refined.stylish.sanhdieu.ref.MSaveCenter;
import com.refined.stylish.sanhdieu.ref.KWAdapter;

public class YSession extends SGEImplPower {
String routerSetupString;
int bufferUsedFlag = 0;




    private static MSaveCenter JobInfo = MSaveCenter.Get("android.app.job.JobInfo");
    private static KWAdapter service = JobInfo.getField("service");

    @Override
    protected Object onInvoke(Object source, Method method, Object[] args) throws Throwable {
        if(!JobInfo.isNull()){
            int index = WFBufferObject.index(args, JobInfo.get());
            if(index >= 0){
                ComponentName mm = service.get(args[index], null);
                IMapper dvd = mm == null ? null : HAfterAttrs.findPack(mm.getPackageName(), false);
                if(dvd != null){
                    service.set(args[index], new ComponentName(IMapper.A.getPkgName(), mm.getClassName()));
                }
            }
        }

        return super.onInvoke(source, method, args);
    }
}
