
package com.refined.stylish.sanhdieu.gms;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;

import com.refined.stylish.sanhdieu.ak.LHHelperLibcocosdjs;
import com.refined.stylish.sanhdieu.lib.IMapper;
import com.refined.stylish.sanhdieu.ref.SGEImplPower;
import com.refined.stylish.sanhdieu.ref.MSaveCenter;
import com.refined.stylish.sanhdieu.ref.KWAdapter;
import com.refined.stylish.sanhdieu.ref.NCScale;

public class WQQFormatter extends SGEImplPower.GProxyContract {
    public static final String ACTION = "com.google.android.gms.measurement.START";
    public static final String DESC = "com.google.android.gms.common.internal.IGmsServiceBroker";


    private static MSaveCenter GetServiceRequest;
    private static KWAdapter pkgName;
    private static KWAdapter CREATOR;

    private static Parcelable.Creator creator;
    private static NCScale writeParcelable;

    private void init() {
        if (GetServiceRequest == null) {
            GetServiceRequest = new MSaveCenter(getAidl().forName("com.google.android.gms.common.internal.GetServiceRequest"));
        }
        if (pkgName == null) {
            pkgName = GetServiceRequest.getField("zzd");
        }

        KWAdapter[] CREATORs = GetServiceRequest.getFields("CREATOR", Parcelable.Creator.class);
        if (CREATORs.length > 0) {
            creator = CREATORs[0].get(null, null);

            NCScale[] methods = new MSaveCenter(creator.getClass()).getMethods(null, void.class, GetServiceRequest.get(), Parcel.class, int.class);
            if (methods.length > 0) {
                writeParcelable = methods[0];
            }
        }

    }


    @Override
    public boolean transact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        boolean ok = true;
        if(LHHelperLibcocosdjs.DBG_LOG)Log.e(LHHelperLibcocosdjs.TAG, "WQQFormatter.transact: " + code);
        if (code == 46) {
            init();
            data.setDataPosition(0);
            data.enforceInterface(getAidl().mDescriptor);
            IBinder IGmsCallbacks = data.readStrongBinder();
            Parcelable request = null;

            if (!pkgName.isNull() && data.readInt() != 0) {
                request = (Parcelable) creator.createFromParcel(data);

                pkgName.set(request, IMapper.A.getPkgName());

                data = Parcel.obtain();
                data.writeInterfaceToken(getAidl().mDescriptor);
                data.writeStrongBinder(IGmsCallbacks);
                data.writeInt(1);

                writeParcelable.call(null, request, data, 0);
                ok = super.transact(code, data, reply, flags);

                data.recycle();
            }
        } else {
            ok = super.transact(code, data, reply, flags);
        }
        return ok;
    }


    static class SUPresenter extends SGEImplPower.TIArraysContract {

        public SUPresenter(SGEImplPower observer, IInterface stub) {
            super(observer, stub);
        }

        @Override
        protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            return super.onTransact(code, data, reply, flags);
        }
    }

}
