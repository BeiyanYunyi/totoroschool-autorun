package com.totoro.school.b.a;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.PowerManager;
import com.totoro.school.utils.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b
{
  protected Intent a;
  protected int b;
  
  protected b(Intent paramIntent, int paramInt)
  {
    this.a = paramIntent;
    this.b = paramInt;
  }
  
  public static List<b> a(final Activity paramActivity, String paramString)
  {
    if (((Boolean)n.b(paramActivity, "isDoPowerWhite", Boolean.valueOf(false))).booleanValue()) {
      return null;
    }
    n.a(paramActivity, "isDoPowerWhite", Boolean.valueOf(true));
    ArrayList localArrayList = new ArrayList();
    String str = paramString;
    if (paramString == null) {
      str = "核心服务的持续运行";
    }
    paramString = a(paramActivity).iterator();
    while (paramString.hasNext())
    {
      b localb = (b)paramString.next();
      if (localb.c(paramActivity))
      {
        AlertDialog.Builder localBuilder;
        StringBuilder localStringBuilder;
        switch (localb.b)
        {
        default: 
          break;
        case 115: 
          localBuilder = new AlertDialog.Builder(paramActivity).setCancelable(false);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("需要关闭 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 的后台耗电优化");
          localBuilder = localBuilder.setTitle(localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("需要关闭 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 的后台耗电优化。\n\n");
          localStringBuilder.append("请点击『确定』，在弹出的『后台耗电优化』中，将 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 对应的开关关闭。");
          localBuilder.setMessage(localStringBuilder.toString()).setPositiveButton("确定", new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              this.a.a(paramActivity);
            }
          }).show();
          localArrayList.add(localb);
          break;
        case 114: 
          localBuilder = new AlertDialog.Builder(paramActivity).setCancelable(false);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("需要允许 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 的后台运行");
          localBuilder = localBuilder.setTitle(localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("需要允许 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 的后台自启、后台 GPS 和后台运行。\n\n");
          localStringBuilder.append("请点击『确定』，在弹出的『后台管理』中，分别找到『后台自启』、『后台 GPS』和『后台运行』，将 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 对应的开关打开。");
          localBuilder.setMessage(localStringBuilder.toString()).setPositiveButton("确定", new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              this.a.a(paramActivity);
            }
          }).show();
          localArrayList.add(localb);
          break;
        case 113: 
          localBuilder = new AlertDialog.Builder(paramActivity).setCancelable(false);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("需要允许 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 的自启动");
          localBuilder = localBuilder.setTitle(localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("需要允许 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 的自启动。\n\n");
          localStringBuilder.append("请点击『确定』，在弹出的『酷管家』中，找到『软件管理』->『自启动管理』，取消勾选 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append("，将 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 的状态改为『已允许』。");
          localBuilder.setMessage(localStringBuilder.toString()).setPositiveButton("确定", new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              this.a.a(paramActivity);
            }
          }).show();
          localArrayList.add(localb);
          break;
        case 112: 
          localBuilder = new AlertDialog.Builder(paramActivity).setCancelable(false);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("需要禁止 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 被自动清理");
          localBuilder = localBuilder.setTitle(localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("需要禁止 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 被自动清理。\n\n");
          localStringBuilder.append("请点击『确定』，在弹出的『应用保护』中，将 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 对应的开关关闭。");
          localBuilder.setMessage(localStringBuilder.toString()).setPositiveButton("确定", new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              this.a.a(paramActivity);
            }
          }).show();
          localArrayList.add(localb);
          break;
        case 110: 
          localBuilder = new AlertDialog.Builder(paramActivity).setCancelable(false);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 需要加入应用自启和绿色后台白名单");
          localBuilder = localBuilder.setTitle(localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("需要允许 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 的自启动和后台运行。\n\n");
          localStringBuilder.append("请点击『确定』，在弹出的『系统管家』中，分别找到『应用管理』->『应用自启』和『绿色后台』->『清理白名单』，将 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 添加到白名单。");
          localBuilder.setMessage(localStringBuilder.toString()).setPositiveButton("确定", new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              this.a.a(paramActivity);
            }
          }).show();
          localArrayList.add(localb);
          break;
        case 109: 
          localBuilder = new AlertDialog.Builder(paramActivity).setCancelable(false);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("需要允许 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 的后台运行");
          localBuilder = localBuilder.setTitle(localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("需要允许 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 在后台高耗电时运行。\n\n");
          localStringBuilder.append("请点击『确定』，在弹出的『后台高耗电』中，将 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 对应的开关打开。");
          localBuilder.setMessage(localStringBuilder.toString()).setPositiveButton("确定", new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              this.a.a(paramActivity);
            }
          }).show();
          localArrayList.add(localb);
          break;
        case 107: 
          localBuilder = new AlertDialog.Builder(paramActivity).setCancelable(false);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("需要允许 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 的自启动");
          localBuilder = localBuilder.setTitle(localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("需要 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 在屏幕关闭时继续运行。\n\n");
          localStringBuilder.append("请点击『确定』，在弹出的『电池』页面中，点击『未监视的应用程序』->『添加应用程序』，勾选 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append("，然后点击『完成』。");
          localBuilder.setMessage(localStringBuilder.toString()).setPositiveButton("确定", new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              this.a.a(paramActivity);
            }
          }).show();
          localArrayList.add(localb);
          break;
        case 105: 
          localBuilder = new AlertDialog.Builder(paramActivity).setCancelable(false);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 需要在待机时保持运行");
          localBuilder = localBuilder.setTitle(localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("需要 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 在待机时保持运行。\n\n");
          localStringBuilder.append("请点击『确定』，在弹出的『待机耗电管理』中，将 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 对应的开关打开。");
          localBuilder.setMessage(localStringBuilder.toString()).setPositiveButton("确定", new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              this.a.a(paramActivity);
            }
          }).show();
          localArrayList.add(localb);
          break;
        case 104: 
          localBuilder = new AlertDialog.Builder(paramActivity).setCancelable(false);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("需要允许 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 保持后台运行");
          localBuilder = localBuilder.setTitle(localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("需要允许 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 保持后台运行。\n\n");
          localStringBuilder.append("请点击『确定』，在弹出的应用信息界面中，将『后台管理』选项更改为『保持后台运行』。");
          localBuilder.setMessage(localStringBuilder.toString()).setPositiveButton("确定", new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              this.a.a(paramActivity);
            }
          }).show();
          localArrayList.add(localb);
          break;
        case 103: 
          localBuilder = new AlertDialog.Builder(paramActivity).setCancelable(false);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("需要允许 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 的自启动");
          localBuilder = localBuilder.setTitle(localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("需要 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 在屏幕关闭时继续运行。\n\n");
          localStringBuilder.append("请点击『确定』，在弹出的『智能管理器』中，点击『内存』，选择『自启动应用程序』选项卡，将 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 对应的开关打开。");
          localBuilder.setMessage(localStringBuilder.toString()).setPositiveButton("确定", new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              this.a.a(paramActivity);
            }
          }).show();
          localArrayList.add(localb);
          break;
        case 102: 
          localBuilder = new AlertDialog.Builder(paramActivity).setCancelable(false);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("需要关闭 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 的神隐模式");
          localBuilder = localBuilder.setTitle(localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("需要关闭 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 的神隐模式。\n\n");
          localStringBuilder.append("请点击『确定』，在弹出的 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 神隐模式设置中，选择『无限制』，然后选择『允许定位』。");
          localBuilder.setMessage(localStringBuilder.toString()).setPositiveButton("确定", new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              this.a.a(paramActivity);
            }
          }).show();
          localArrayList.add(localb);
          break;
        case 101: 
        case 106: 
        case 108: 
        case 111: 
        case 116: 
          localBuilder = new AlertDialog.Builder(paramActivity).setCancelable(false);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("需要允许 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 的自启动");
          localBuilder = localBuilder.setTitle(localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("需要 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 加入到自启动白名单。\n\n");
          localStringBuilder.append("请点击『确定』，在弹出的『自启动管理』中，将 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 对应的开关打开。");
          localBuilder.setMessage(localStringBuilder.toString()).setPositiveButton("确定", new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              this.a.a(paramActivity);
            }
          }).show();
          localArrayList.add(localb);
          break;
        case 100: 
        case 117: 
          localBuilder = new AlertDialog.Builder(paramActivity).setCancelable(false);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 需要加入锁屏清理白名单");
          localBuilder = localBuilder.setTitle(localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("需要 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 加入到锁屏清理白名单。\n\n");
          localStringBuilder.append("请点击『确定』，在弹出的『锁屏清理』列表中，将 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 对应的开关打开。");
          localBuilder.setMessage(localStringBuilder.toString()).setPositiveButton("确定", new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              this.a.a(paramActivity);
            }
          }).show();
          localArrayList.add(localb);
          break;
        case 99: 
          localBuilder = new AlertDialog.Builder(paramActivity).setCancelable(false);
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("需要允许 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 自动启动");
          localBuilder = localBuilder.setTitle(localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append("需要允许 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 的自动启动。\n\n");
          localStringBuilder.append("请点击『确定』，在弹出的『自启管理』中，将 ");
          localStringBuilder.append(b(paramActivity));
          localStringBuilder.append(" 对应的开关打开。");
          localBuilder.setMessage(localStringBuilder.toString()).setPositiveButton("确定", new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              this.a.a(paramActivity);
            }
          }).show();
          localArrayList.add(localb);
          break;
        case 98: 
          if ((Build.VERSION.SDK_INT >= 24) && (!((PowerManager)paramActivity.getSystemService("power")).isIgnoringBatteryOptimizations(paramActivity.getPackageName())))
          {
            localBuilder = new AlertDialog.Builder(paramActivity).setCancelable(false);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("需要忽略 ");
            localStringBuilder.append(b(paramActivity));
            localStringBuilder.append(" 的电池优化");
            localBuilder = localBuilder.setTitle(localStringBuilder.toString());
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(str);
            localStringBuilder.append("需要 ");
            localStringBuilder.append(b(paramActivity));
            localStringBuilder.append(" 加入到电池优化的忽略名单。\n\n");
            localStringBuilder.append("请点击『确定』，在弹出的『忽略电池优化』对话框中，选择『是』。");
            localBuilder.setMessage(localStringBuilder.toString()).setPositiveButton("确定", new DialogInterface.OnClickListener()
            {
              public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
              {
                this.a.a(paramActivity);
              }
            }).show();
            localArrayList.add(localb);
          }
          break;
        }
      }
    }
    return localArrayList;
  }
  
  public static List<b> a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    if ((Build.VERSION.SDK_INT >= 24) && (!((PowerManager)paramContext.getSystemService("power")).isIgnoringBatteryOptimizations(paramContext.getPackageName())))
    {
      localIntent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("package:");
      localStringBuilder.append(paramContext.getPackageName());
      localIntent.setData(Uri.parse(localStringBuilder.toString()));
      localArrayList.add(new b(localIntent, 98));
    }
    Intent localIntent = new Intent();
    localIntent.setAction("huawei.intent.action.HSM_BOOTAPP_MANAGER");
    localArrayList.add(new b(localIntent, 99));
    localIntent = new Intent();
    localIntent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity"));
    localArrayList.add(new b(localIntent, 100));
    localIntent = new Intent();
    localIntent.setAction("miui.intent.action.OP_AUTO_START");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localArrayList.add(new b(localIntent, 101));
    localIntent = new Intent();
    localIntent.setComponent(new ComponentName("com.miui.powerkeeper", "com.miui.powerkeeper.ui.HiddenAppsConfigActivity"));
    localIntent.putExtra("package_name", paramContext.getPackageName());
    localIntent.putExtra("package_label", b(paramContext));
    localArrayList.add(new b(localIntent, 102));
    localIntent = paramContext.getPackageManager().getLaunchIntentForPackage("com.samsung.android.sm");
    if (localIntent != null) {
      localArrayList.add(new b(localIntent, 103));
    }
    localIntent = new Intent();
    localIntent.setComponent(new ComponentName("com.samsung.android.sm_cn", "com.samsung.android.sm.ui.battery.BatteryActivity"));
    localArrayList.add(new b(localIntent, 107));
    localIntent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
    localIntent.addCategory("android.intent.category.DEFAULT");
    localIntent.putExtra("packageName", paramContext.getPackageName());
    localArrayList.add(new b(localIntent, 104));
    paramContext = new Intent();
    paramContext.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.powerui.PowerAppPermissionActivity"));
    localArrayList.add(new b(paramContext, 105));
    paramContext = new Intent();
    paramContext.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity"));
    localArrayList.add(new b(paramContext, 106));
    paramContext = new Intent();
    paramContext.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.startup.StartupAppListActivity"));
    localArrayList.add(new b(paramContext, 108));
    paramContext = new Intent();
    paramContext.setComponent(new ComponentName("com.vivo.abe", "com.vivo.applicationbehaviorengine.ui.ExcessivePowerManagerActivity"));
    localArrayList.add(new b(paramContext, 109));
    paramContext = new Intent();
    paramContext.setComponent(new ComponentName("com.gionee.softmanager", "com.gionee.softmanager.MainActivity"));
    localArrayList.add(new b(paramContext, 110));
    paramContext = new Intent();
    paramContext.setComponent(new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity"));
    localArrayList.add(new b(paramContext, 111));
    paramContext = new Intent();
    paramContext.setComponent(new ComponentName("com.letv.android.letvsafe", "com.letv.android.letvsafe.BackgroundAppManageActivity"));
    localArrayList.add(new b(paramContext, 112));
    paramContext = new Intent();
    paramContext.setComponent(new ComponentName("com.yulong.android.security", "com.yulong.android.seccenter.tabbarmain"));
    localArrayList.add(new b(paramContext, 113));
    paramContext = new Intent();
    paramContext.setComponent(new ComponentName("com.lenovo.security", "com.lenovo.security.purebackground.PureBackgroundActivity"));
    localArrayList.add(new b(paramContext, 114));
    paramContext = new Intent();
    paramContext.setComponent(new ComponentName("com.lenovo.powersetting", "com.lenovo.powersetting.ui.Settings$HighPowerApplicationsActivity"));
    localArrayList.add(new b(paramContext, 115));
    paramContext = new Intent();
    paramContext.setComponent(new ComponentName("com.zte.heartyservice", "com.zte.heartyservice.autorun.AppAutoRunManager"));
    localArrayList.add(new b(paramContext, 116));
    paramContext = new Intent();
    paramContext.setComponent(new ComponentName("com.zte.heartyservice", "com.zte.heartyservice.setting.ClearAppSettingsActivity"));
    localArrayList.add(new b(paramContext, 117));
    return localArrayList;
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      Object localObject = paramContext.getPackageManager();
      localObject = ((PackageManager)localObject).getApplicationLabel(((PackageManager)localObject).getApplicationInfo(paramContext.getPackageName(), 0)).toString();
      return (String)localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    return paramContext.getPackageName();
  }
  
  protected void a(Activity paramActivity)
  {
    try
    {
      paramActivity.startActivity(this.a);
      return;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  protected boolean c(Context paramContext)
  {
    paramContext = paramContext.getPackageManager().queryIntentActivities(this.a, 65536);
    return (paramContext != null) && (paramContext.size() > 0);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\b\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */