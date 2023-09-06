
package com.refined.stylish.sanhdieu.ref;
import java.util.ArrayList;


import java.util.Random;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.HashSet;

 
public abstract class VDHMenu<T> implements InvocationHandler {
    private final HashMap<String, Method> mMethods = new HashMap<>();
    private static final HashSet<String> globalFilters = new HashSet<>();

    static {
        globalFilters.add("toString");
        globalFilters.add("hashCode");
        globalFilters.add("equals");
    }

    
    private String get_name(String name, Class clszz) {
        return name;
    }

    protected VDHMenu() {
        setName(this.getClass().getSimpleName());

        Class clszz = getClass();
        while (clszz != null) {
            
            Method[] methods = clszz.getDeclaredMethods();
            for (Method method : methods) {
                BUScaleImpl serviceInterface = method.getAnnotation(BUScaleImpl.class);
                if (serviceInterface != null) {
                    if (!Modifier.isPublic(method.getModifiers())) {
                        method.setAccessible(true);
                    }
                    
                    final String name = get_name(serviceInterface.value(), clszz);
                    if (!mMethods.containsKey(name)) {
                        mMethods.put(name, method);
                    }
                }
            }
            clszz = clszz.getSuperclass();
        }
    }

    public void attach(YDSound aidl) {
        this.mAidl = aidl;
    }

    public YDSound getAidl() {
        return this.mAidl;
    }

    private YDSound mAidl;

     
    private String mName;
     
    private T mSource;
     
    private T mProxy;

    public final Object invoke(Object object, Method method, Object[] objects) throws Throwable {
        try {
            final String methodName = method.getName();
            final Method hookMethod = mMethods.get(methodName);
            if (hookMethod != null) {
                return hookMethod.invoke(this, mSource, method, objects);
            } else if (globalFilters.contains(methodName)) {
                return method.invoke(mSource, objects);
            } else {
                return onInvoke(mSource, method, objects);
            }
        } catch (InvocationTargetException e) {
            GGBIndex.e(mName + ".invoke", e);
            throw e.getCause(); 
        } catch (Throwable e) {
            GGBIndex.e(mName + ".invoke", e);
            throw e.getCause();
        }
    }

    public final String getName() {
        return mName;
    }

     
    protected final VDHMenu<T> setName(String name) {
        this.mName = name;
        return this;
    }

    public final <V extends T> V getSource() {
        return (V) mSource;
    }

    public final <V extends T> V getProxy() {
        return (V) mProxy;
    }

    public final Object callSource(Method method, Object... objects) throws Throwable {
        try {
            return method.invoke(mSource, objects);
        } catch (InvocationTargetException e) {
            GGBIndex.e(mName + ".invoke", e);
            throw e.getCause(); 
        } catch (Throwable e) {
            GGBIndex.e(mName + ".invoke", e);
            throw e.getCause();
        }
    }

    public final Method findMethod(String methodName) {
        if (mSource != null) {
            Method[] methods = mSource.getClass().getMethods();
            for (Method method : methods) {
                if (methodName.equals(method.getName())) {
                    return method;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        if (mName != null) {
            return mName;
        } else if (mAidl != null) {
            return mAidl.toString();
        } else {
            return super.toString();
        }
    }

    public VDHMenu<T> setSource(T source) {
        if (source == null) {
            throw new NullPointerException("source is null!");
        }
        this.mSource = source;
        return this;
    }

    public T makeProxy(T proxyClassObject) {
        return makeProxy(proxyClassObject.getClass());
    }

    public T makeProxy(Class proxyClass) {
        if (mProxy == null) {
            if (proxyClass == null) {
                throw new NullPointerException("interfaces Class is null!");
            }
            final MSaveCenter mClass = new MSaveCenter(proxyClass);
            mProxy = (T) Proxy.newProxyInstance(proxyClass.getClassLoader(), mClass.getInterfaces(true), this);
        }
        return mProxy;
    }


     
    protected Object onInvoke(Object source, Method method, Object[] args) throws Throwable {
        return method.invoke(source, args);
    }
}
