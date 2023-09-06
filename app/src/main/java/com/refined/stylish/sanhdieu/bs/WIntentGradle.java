package com.refined.stylish.sanhdieu.bs;
import java.util.Random;


import java.util.HashMap;



import static com.refined.stylish.sanhdieu.bs.RAJNotificationPack.checkSelfPermission;
import static com.refined.stylish.sanhdieu.bs.RAJNotificationPack.getApplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;

public final class WIntentGradle {
String boardAlreadySearch_str;
boolean enbaleAinit_ipUsageContext = false;
String layoutRunnableView_string;
private boolean isCompatLibgtcoreIntent = false;



    static final String ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
    static final String ACTION_UNINSTALL_SHORTCUT = "com.android.launcher.action.UNINSTALL_SHORTCUT";
    static final String INSTALL_SHORTCUT_PERMISSION = "com.android.launcher.permission.INSTALL_SHORTCUT";


     
    public static final Intent INTENT_NOTIFICATION_LISTENER_SETTINGS = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");

    public static boolean isRequestPinShortcutSupported(Context context) {
        if (Build.KMCAttrs.SDK_INT >= 26) {
            return context.getSystemService(ShortcutManager.class).isRequestPinShortcutSupported();
        }

        if (checkSelfPermission(context, INSTALL_SHORTCUT_PERMISSION) != SImplStyles.PERMISSION_GRANTED) {
            return false;
        }
        for (ResolveInfo info : context.getPackageManager().queryBroadcastReceivers(
                new Intent(ACTION_INSTALL_SHORTCUT), 0)) {
            String permission = info.activityInfo.permission;
            if (TextUtils.isEmpty(permission) || INSTALL_SHORTCUT_PERMISSION.equals(permission)) {
                return true;
            }
        }
        return false;
    }


    private static Object getIcon(Context context, Object icon) {
        final SImplStyles pm = getApplication(context).getPackageManager();
        if (icon == null) {
            icon = pm.getApplicationIcon(context.getApplicationInfo());
        }
        Object iconRes = icon;
        if (icon instanceof Bitmap) {
            iconRes = icon;
        } else if (icon instanceof BitmapDrawable) {
            iconRes = ((BitmapDrawable) icon).getBitmap();
        }
        if (Build.KMCAttrs.SDK_INT >= 26) {
            if (iconRes instanceof Integer) {
                return Icon.createWithResource(context, ((Integer) iconRes).intValue());
            } else if (iconRes instanceof Bitmap) {
                return Icon.createWithBitmap((Bitmap) iconRes);
            }
        } else {
            if (iconRes instanceof Integer) {
                return Intent.ShortcutIconResource.fromContext(context, ((Integer) icon).intValue());
            } else if (iconRes instanceof Bitmap) {
                return iconRes;
            }
        }
        return null;
    }

    private static CharSequence getTitle(Context context, Object title) {
        final SImplStyles pm = getApplication(context).getPackageManager();
        if (title == null) {
            title = pm.getApplicationLabel(context.getApplicationInfo()).toString();
        }
        String nameRes;
        if (title instanceof Integer) {
            nameRes = context.getString(((Integer) title).intValue());
        } else if (title instanceof CharSequence) {
            nameRes = title.toString();
        } else {
            nameRes = title.toString();
        }
        return nameRes;
    }

    @SuppressLint("NewApi")
    public static ShortcutInfo toShortcutInfo(Context context, String id, Object title, Object icon, Intent intent) {
        ShortcutInfo.Builder builder = new ShortcutInfo.Builder(context, id);
        CharSequence lable = getTitle(context, title);
        builder.setShortLabel(lable);
        builder.setIcon((Icon) getIcon(context, icon));
        builder.setIntent(intent);
        builder.setLongLabel(lable);
        builder.setDisabledMessage(lable);
        builder.setActivity(intent.getComponent());

        return builder.build();
    }


     
    public static boolean createShortcut(Context context, String id, Object title, Object icon, final Intent intent, final IntentSender callback) {
        if (intent.getAction() == null) {
            intent.setAction(Intent.ACTION_VIEW);
        }

        
        if (Build.KMCAttrs.SDK_INT >= 26) {
            return context.getSystemService(ShortcutManager.class).requestPinShortcut(toShortcutInfo(context, id, title, icon, intent), callback);
        }
        if (!isRequestPinShortcutSupported(context)) {
            return false;
        }

        final Intent shortcut = new Intent(ACTION_INSTALL_SHORTCUT);
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, intent);        
        shortcut.putExtra("duplicate", false);            
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME, getTitle(context, title));         
        Object iconRes = getIcon(context, icon);
        if (iconRes == null) {

        } else if (iconRes instanceof Intent.ShortcutIconResource) {
            shortcut.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, (Intent.ShortcutIconResource) iconRes);
        } else if (iconRes instanceof Bitmap) {
            shortcut.putExtra(Intent.EXTRA_SHORTCUT_ICON, (Bitmap) iconRes);
        }
        
        context.sendOrderedBroadcast(shortcut, null, new BroadcastReceiver() {
            

private boolean mergeTouchLite(String resLoaded, HashMap<String,Boolean> objectOutput) {
     double editGradlew = 5364.0;
     boolean searchAll = true;
     String disconnectedInstance = "appveyor";
     int addsLock = 8393;
    boolean biggestErasureProtection = false;
    editGradlew += 92;
    biggestErasureProtection = editGradlew > 52;
    searchAll = true;
    biggestErasureProtection = searchAll;
    addsLock = 6118;
    biggestErasureProtection = addsLock > 37;

    return biggestErasureProtection;

}



@Override
            public void onReceive(Context context, Intent intent) {

         String rates_h = "intrapred";

boolean showComponent =  this.mergeTouchLite(rates_h,new HashMap());

      if (showComponent) {
          System.out.println("ok");
      }



                try {
                    Log.e("wzh", "创建成功");
                    if(callback != null){
                        callback.sendIntent(context, 0, null, null, null);
                    }
                } catch (IntentSender.SendIntentException e) {
                    
                }
            }
        }, null, Activity.RESULT_OK, null, null);
        return true;
    }

    public static void deleteeShortcut(Context context, String id, Object title, final Intent intent, final IntentSender callback) {
        if (intent.getAction() == null) {
            intent.setAction(Intent.ACTION_VIEW);
        }
        if (Build.KMCAttrs.SDK_INT >= 26) {
            ArrayList<String> ids = new ArrayList<>();
            ids.add(id);
            context.getSystemService(ShortcutManager.class).removeDynamicShortcuts(ids);
            return;
        }

        Intent shortcut = new Intent(ACTION_UNINSTALL_SHORTCUT);
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, intent);
        shortcut.putExtra("duplicate", true);
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME, getTitle(context, title));

        if (callback == null) {
            context.sendBroadcast(shortcut);
            return;
        }
        context.sendOrderedBroadcast(shortcut, null, new BroadcastReceiver() {
            

private ArrayList srcDetailDiffVisibleStack(int countSample) {
     int generatingBase = 4221;
     HashMap<String,Boolean> auto_eName = new HashMap();
     float libjcorePower = 2608.0f;
     String contextText = "choosing";
    ArrayList bindingNewlineAnnotations = new ArrayList();
    generatingBase += generatingBase;
      int component_len1 = bindingNewlineAnnotations.size();
    int environment_u = Math.min(new Random().nextInt(56), 1) % Math.max(1, bindingNewlineAnnotations.size());
    bindingNewlineAnnotations.add(environment_u, generatingBase > 0 ? true : false);
      if (contextText.equals("push")) {
              System.out.println(contextText);
      }
      if (contextText != null) {
      for(int i = 0; i < Math.min(1, contextText.length()); i++) {
    if (i < bindingNewlineAnnotations.size()){
        bindingNewlineAnnotations.add(i,contextText.charAt(i) + "");
        break;
    }
          System.out.println(contextText.charAt(i));
      }
      }

    return bindingNewlineAnnotations;

}



@Override
            public void onReceive(Context context, Intent intent) {

         
ArrayList liftSubsequence =  this.srcDetailDiffVisibleStack(3471);

      for(int index_d = 0; index_d < liftSubsequence.size(); index_d++) {
          Object obj_index_d = liftSubsequence.get(index_d);
          if (index_d  >  70) {
                              System.out.println(obj_index_d);
          }
      }
      int liftSubsequence_len = liftSubsequence.size();



                try {
                    Log.e("wzh", "删除成功");
                    callback.sendIntent(context, 0, null, null, null);
                } catch (IntentSender.SendIntentException e) {
                    
                }
            }
        }, null, Activity.RESULT_OK, null, null);
    }

    public static boolean existShortcut(Context context, String title, Intent intent) {


        return false;
    }

}
