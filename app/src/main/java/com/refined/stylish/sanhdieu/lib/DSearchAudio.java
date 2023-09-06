
package com.refined.stylish.sanhdieu.lib;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



import static com.refined.stylish.sanhdieu.lib.RHSourceBroker.ActivityClientRecord_activityInfo;
import static com.refined.stylish.sanhdieu.lib.RHSourceBroker.ActivityClientRecord_intent;
import static com.refined.stylish.sanhdieu.lib.RHSourceBroker.BIND_SERVICE;
import static com.refined.stylish.sanhdieu.lib.RHSourceBroker.CREATE_SERVICE;
import static com.refined.stylish.sanhdieu.lib.RHSourceBroker.CreateServiceData_info;
import static com.refined.stylish.sanhdieu.lib.RHSourceBroker.CreateServiceData_intent;
import static com.refined.stylish.sanhdieu.lib.RHSourceBroker.EXECUTE_TRANSACTION;
import static com.refined.stylish.sanhdieu.lib.RHSourceBroker.INSTALL_PROVIDER;
import static com.refined.stylish.sanhdieu.lib.RHSourceBroker.LAUNCH_ACTIVITY;
import static com.refined.stylish.sanhdieu.lib.RHSourceBroker.RECEIVER;
import static com.refined.stylish.sanhdieu.lib.RHSourceBroker.ReceiverData_info;
import static com.refined.stylish.sanhdieu.lib.RHSourceBroker.ReceiverData_intent;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ServiceInfo;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.util.List;

import com.refined.stylish.sanhdieu.ak.LHHelperLibcocosdjs;
import com.refined.stylish.sanhdieu.ref.MSaveCenter;
import com.refined.stylish.sanhdieu.ref.KWAdapter;
import com.refined.stylish.sanhdieu.ref.NCScale;

final class DSearchAudio implements Handler.Callback {

    private static final boolean DBG_LOG = LHHelperLibcocosdjs.DBG_LOG;

    private static void copy(ActivityInfo src, ActivityInfo obj) {
        obj.packageName = src.packageName;
        obj.processName = src.processName;
        obj.targetActivity = src.targetActivity;
        obj.taskAffinity = src.taskAffinity;
        obj.applicationInfo = src.applicationInfo;
        obj.exported = src.exported;
        obj.name = src.name;
        obj.metaData = src.metaData;
    }

    private static final MSaveCenter ClientTransaction = MSaveCenter.Get("android.app.servertransaction.ClientTransaction");
    private static final MSaveCenter LaunchActivityItem = MSaveCenter.Get("android.app.servertransaction.LaunchActivityItem");
    private static final MSaveCenter ClientTransactionHandler = MSaveCenter.Get("android.app.ClientTransactionHandler");
    private static final NCScale preExecute = ClientTransaction.getMethod("preExecute", ClientTransactionHandler.get());

    private static final KWAdapter mInfo = LaunchActivityItem.getField("mInfo");
    private static final KWAdapter mIntent = LaunchActivityItem.getField("mIntent");

    @Override
    public boolean handleMessage(Message msg) {
        if (DBG_LOG) Log.e(LHHelperLibcocosdjs.TAG, "handleMessage: " + msg.what);
        int msgId = msg.what;
        if (msgId == EXECUTE_TRANSACTION) {

            Object mActivityCallbacks = ClientTransaction.getField("mActivityCallbacks").get(msg.obj, null);
            if (mActivityCallbacks instanceof List) {
                List list = ((List) mActivityCallbacks);
                for (int i = 0; i < list.size(); ++i) {
                    Object item = list.get(0);
                    if (LaunchActivityItem.isInstance(item)) {
                        Intent intent = mIntent.get(item, null);
                        ActivityInfo info = mInfo.get(item, null);

                        ActivityInfo newInfo = HAfterAttrs.getActivityInfo(info, false);
                        if (newInfo != null) {
                            copy(newInfo, info);
                            mInfo.set(item, newInfo);

                            preExecute.call(msg.obj, RHSourceBroker.mActivityThread);

                            intent.setPackage(newInfo.packageName);
                            intent.setComponent(new ComponentName(newInfo.packageName, newInfo.name));

                            if (DBG_LOG)
                                Log.e(LHHelperLibcocosdjs.TAG, "EXECUTE_TRANSACTION: " + newInfo + " >> " + intent);
                        }
                    }
                }
            } else {
                Log.e(LHHelperLibcocosdjs.TAG, "兼容测试: " + (mActivityCallbacks == null ? "null" : mActivityCallbacks.getClass()));
                System.exit(0);
            }
        } else if (msgId == LAUNCH_ACTIVITY) {
            Object mActivityClientRecord = msg.obj;
            ActivityInfo info = ActivityClientRecord_activityInfo.get(mActivityClientRecord, null);
            Intent _intent = ActivityClientRecord_intent.get(mActivityClientRecord, null);

            ActivityInfo newInfo = HAfterAttrs.getActivityInfo(info, false);
            if (newInfo != null) {
                ActivityClientRecord_activityInfo.set(mActivityClientRecord, newInfo);
                _intent.setComponent(new ComponentName(newInfo.packageName, newInfo.name));

                if (DBG_LOG) Log.e(LHHelperLibcocosdjs.TAG, "LAUNCH_ACTIVITY: " + newInfo + " >> " + _intent);
            }
        } else if (msgId == RECEIVER) {
            Object mReceiverData = msg.obj;
            ActivityInfo info = ReceiverData_info.get(mReceiverData, null);
            Intent intent = ReceiverData_intent.get(mReceiverData, null);

            ActivityInfo newInfo = HAfterAttrs.getReceiverInfo(info, false);
            if (newInfo != null) {
                ReceiverData_info.set(mReceiverData, newInfo);
                intent.setComponent(new ComponentName(newInfo.packageName, newInfo.name));

                if (DBG_LOG) Log.e(LHHelperLibcocosdjs.TAG, "RECEIVER: " + newInfo + " >> " + intent);
            }
        } else if (msgId == CREATE_SERVICE) {
            Object mCreateServiceData = msg.obj;

            ServiceInfo info = CreateServiceData_info.get(mCreateServiceData, null);
            Intent intent = CreateServiceData_intent.get(mCreateServiceData, null);
            if (DBG_LOG) Log.e(LHHelperLibcocosdjs.TAG, "CREATE_SERVICE: " + mCreateServiceData);
            ServiceInfo newInfo = HAfterAttrs.getServiceInfo(info, false);
            if (newInfo != null) {
                CreateServiceData_info.set(mCreateServiceData, newInfo);
                if (intent != null) {
                    intent.setComponent(new ComponentName(newInfo.packageName, newInfo.name));
                }
                if (DBG_LOG) Log.e(LHHelperLibcocosdjs.TAG, "CREATE_SERVICE: " + newInfo + " >> " + intent);
            }
        } else if (msgId == BIND_SERVICE) {
            Object mBindServiceData = msg.obj;
        } else if (msgId == INSTALL_PROVIDER) {
            if (DBG_LOG) Log.e(LHHelperLibcocosdjs.TAG, "INSTALL_PROVIDER");
        }
        return false;
    }
}
