
package com.refined.stylish.sanhdieu.domain.usecases;
import java.util.ArrayList;


import java.util.Random;


import java.util.HashMap;



 

public abstract class KFFile<P extends KFFile.CFGenerator, O extends KFFile.GEProviderMapper> {

    private Callback<O> mCallback;
    private P mParams;

    public void run() {
        execute(mParams);
    }

    protected abstract void execute(P p);

    public Callback<O> getCallback() {
        return mCallback;
    }

    public void setCallback(Callback<O> callback) {
        mCallback = callback;
    }

    public P getParams() {
        return mParams;
    }

    public void setParams(P params) {
        mParams = params;
    }

    public interface Callback<O extends KFFile.GEProviderMapper> {
        void onSuccess(O result);
        void onFailed(String errMsg);
    }

    public interface CFGenerator {}
    public interface GEProviderMapper {}
}
