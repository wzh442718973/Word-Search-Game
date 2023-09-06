package com.refined.stylish.sanhdieu.ref;
import java.util.Random;




import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

 
public final class MSaveCenter extends EOInitZoom<Class> {
private String elementInterface_t4SlideStr;
int binderStopped_index = 0;




    
    public static final String KMCAttrs = "2023.03.20";
    private static final HashMap<Object, Map<String, Class>> mClassMaps = new HashMap<Object, Map<String, Class>>();

    private static final ClassLoader DEFAULT = MSaveCenter.class.getClassLoader();

    public static final Class forName(String clsName) {
        return forName(clsName, DEFAULT);
    }

    public static final Class forName(String clsName, ClassLoader classLoader) {
        if (clsName == null) {
            return null;
        }
        synchronized (mClassMaps) {
            if (classLoader == null) {
                classLoader = DEFAULT;
            }
            Map<String, Class> classMap = mClassMaps.get(classLoader);
            if (classMap == null) {
                mClassMaps.put(classLoader, classMap = new HashMap<String, Class>());
            }
            Class clazz = classMap.get(clsName);
            if (clazz == null) {
                try {
                    classMap.put(clsName, clazz = Class.forName(clsName, true, classLoader));
                } catch (Throwable e) {
                    if (e instanceof ClassNotFoundException) {
                        if (DBG_LOG) System.out.print("Not Found Class!< " + clsName + " >\n");
                    } else {
                        throw new RuntimeException(e);
                    }
                }
            }
            return clazz;
        }
    }

    public static final MSaveCenter Get(String clsName) {
        return new MSaveCenter(forName(clsName, null));
    }

    public static final MSaveCenter Get(String clsName, ClassLoader classLoader) {
        return new MSaveCenter(forName(clsName, classLoader));
    }

    public MSaveCenter(Class clszz) {
        super(clszz, clszz);
    }

    public final PFormatter getConstructor(Class... params) {
        return PFormatter.Get(get(), params);
    }

    public final KWAdapter getField(String fieldName) {
        return KWAdapter.Get(get(), fieldName);
    }

    public final NCScale getMethod(String methodName, Class... params) {
        return NCScale.Get(get(), methodName, params);
    }

    public final KWAdapter[] getFields(String fieldName, Class type) {
        ArrayList<KWAdapter> list = new ArrayList<>(10);
        if (mValue != null) {
            Field field = null;
            if (fieldName != null) {
                try {
                    field = mValue.getDeclaredField(fieldName);
                } catch (NoSuchFieldException e) {
                }
            }
            if (field != null) {
                list.add(new KWAdapter(this.mValue, field));
            } else if (type != null) {
                Field[] fields = mValue.getDeclaredFields();
                for (Field _field : fields) {
                    if (type.isAssignableFrom(_field.getType())) {
                        list.add(new KWAdapter(this.mValue, _field));
                    }
                }
            }
        }
        return list.toArray(new KWAdapter[list.size()]);
    }

    static boolean Equals(Class[] src, Class[] obj) {
        final int M = src == null ? 0 : src.length;
        final int N = obj == null ? 0 : obj.length;
        if (M == N) {
            for (int i = 0; i < N; ++i) {
                if (src[i] != obj[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public final NCScale[] getMethods(String methodName, Class rType, Class... parames) {
        ArrayList<NCScale> list = new ArrayList<>(10);
        if (mValue != null) {
            Method method = null;
            if (methodName != null) {
                try {
                    method = mValue.getDeclaredMethod(methodName, parames);
                } catch (NoSuchMethodException e) {
                }
            }
            if (method != null) {
                list.add(new NCScale(mValue, method));
            } else if (rType != null) {
                Method[] methods = mValue.getDeclaredMethods();
                for (Method _method : methods) {
                    Class _rType = _method.getReturnType();
                    Class[] _parames = _method.getParameterTypes();

                    if (!rType.isAssignableFrom(_rType)) {
                        continue;
                    }
                    if (Equals(parames, _parames)) {
                        list.add(new NCScale(mValue, _method));
                    }
                }
            }
        }
        return list.toArray(new NCScale[list.size()]);
    }

    public final boolean isInstance(Object object) {
        final Class clszz = get();
        if (clszz == null || object == null) {
            return false;
        } else {
            return clszz.isInstance(object);
        }
    }

    public final boolean isParent(Class cls) {
        final Class clszz = get();
        if (clszz == null || cls == null) {
            return false;
        } else {
            return clszz.isAssignableFrom(cls);
        }
    }

    public final MSaveCenter getSubClass(String subClsName) {
        if (mValue == null) {
            return new MSaveCenter(null);
        } else {
            return Get(mValue.getName() + "$" + subClsName, mValue.getClassLoader());
        }
    }

    public final MSaveCenter getSuperClass() {
        return new MSaveCenter(mValue == null ? null : mValue.getSuperclass());
    }

    public Class[] getInterfaces(boolean containSuper) {
        Set<Class> sets = new HashSet<>();
        Class clszz = mValue;
        while (clszz != null) {
            if (clszz.isInterface()) {
                sets.add(clszz);
            }
            Class[] ins = clszz.getInterfaces();
            if (ins != null && ins.length > 0) {
                sets.addAll(Arrays.asList(ins));
            }
            clszz = containSuper ? clszz.getSuperclass() : null;
        }

        return sets.toArray(new Class[sets.size()]);
    }
}