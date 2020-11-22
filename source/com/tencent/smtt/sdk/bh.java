package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.libwebp;
import com.tencent.smtt.utils.TbsLog;
import java.util.Map;

class bh
{
  private Context a = null;
  private Context b = null;
  private String c = null;
  private String[] d = null;
  private DexLoader e = null;
  private String f = "TbsDexOpt";
  private String g = null;
  
  public bh(Context paramContext1, Context paramContext2, String paramString1, String paramString2, String[] paramArrayOfString, String paramString3)
  {
    TbsLog.i("TbsWizard", "construction start...");
    if ((paramContext1 != null) && ((paramContext2 != null) || (TbsShareManager.getHostCorePathAppDefined() != null)) && (!TextUtils.isEmpty(paramString1)) && (paramArrayOfString != null) && (paramArrayOfString.length != 0))
    {
      this.a = paramContext1.getApplicationContext();
      this.b = paramContext2;
      this.c = paramString1;
      this.d = paramArrayOfString;
      this.f = paramString2;
      int i = 0;
      while (i < this.d.length)
      {
        paramString1 = new StringBuilder();
        paramString1.append("#2 mDexFileList[");
        paramString1.append(i);
        paramString1.append("]: ");
        paramString1.append(this.d[i]);
        TbsLog.i("TbsWizard", paramString1.toString());
        i += 1;
      }
      paramString1 = new StringBuilder();
      paramString1.append("new DexLoader #2 libraryPath is ");
      paramString1.append(paramString3);
      paramString1.append(" mCallerAppContext is ");
      paramString1.append(this.a);
      paramString1.append(" dexOutPutDir is ");
      paramString1.append(paramString2);
      TbsLog.i("TbsWizard", paramString1.toString());
      this.e = new DexLoader(paramString3, this.a, this.d, paramString2, QbSdk.n);
      libwebp.loadWepLibraryIfNeed(paramContext2, this.c);
      if ("com.nd.android.pandahome2".equals(this.a.getApplicationInfo().packageName))
      {
        paramContext2 = this.e;
        paramString1 = this.a;
        paramContext2.invokeStaticMethod("com.tencent.tbs.common.beacon.X5CoreBeaconUploader", "getInstance", new Class[] { Context.class }, new Object[] { paramString1 });
      }
      if (QbSdk.n != null)
      {
        paramContext2 = this.e;
        paramString1 = QbSdk.n;
        paramContext2.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[] { Map.class }, new Object[] { paramString1 });
      }
      i = a(paramContext1);
      if (i >= 0)
      {
        TbsLog.i("TbsWizard", "construction end...");
        return;
      }
      paramContext1 = new StringBuilder();
      paramContext1.append("TbsWizard init error: ");
      paramContext1.append(i);
      paramContext1.append("; msg: ");
      paramContext1.append(this.g);
      throw new Exception(paramContext1.toString());
    }
    paramString2 = new StringBuilder();
    paramString2.append("TbsWizard paramter error:-1callerContext:");
    paramString2.append(paramContext1);
    paramString2.append("hostcontext");
    paramString2.append(paramContext2);
    paramString2.append("isEmpty");
    paramString2.append(TextUtils.isEmpty(paramString1));
    paramString2.append("dexfileList");
    paramString2.append(paramArrayOfString);
    throw new Exception(paramString2.toString());
  }
  
  public bh(Context paramContext1, Context paramContext2, String paramString1, String paramString2, String[] paramArrayOfString, String paramString3, String paramString4)
  {
    this.a = paramContext1.getApplicationContext();
    this.b = paramContext2;
    this.c = paramString1;
    this.d = paramArrayOfString;
    this.f = paramString2;
    int i = 0;
    while (i < this.d.length)
    {
      paramContext2 = new StringBuilder();
      paramContext2.append("#1 mDexFileList[");
      paramContext2.append(i);
      paramContext2.append("]: ");
      paramContext2.append(this.d[i]);
      TbsLog.i("TbsWizard", paramContext2.toString());
      i += 1;
    }
    paramContext2 = new StringBuilder();
    paramContext2.append("new DexLoader #1 libraryPath is ");
    paramContext2.append(paramString3);
    paramContext2.append(" mCallerAppContext is ");
    paramContext2.append(this.a);
    paramContext2.append(" dexOutPutDir is ");
    paramContext2.append(paramString2);
    TbsLog.i("TbsWizard", paramContext2.toString());
    this.e = new DexLoader(paramString3, this.a, this.d, paramString2, QbSdk.n);
    paramContext2 = new StringBuilder();
    paramContext2.append("initTesRuntimeEnvironmentAndNotLoadSo callerContext is ");
    paramContext2.append(paramContext1);
    paramContext2.append(" mHostContext is ");
    paramContext2.append(this.b);
    paramContext2.append(" mDexLoader is ");
    paramContext2.append(this.e);
    paramContext2.append(" mtbsInstallLocation is ");
    paramContext2.append(this.c);
    paramContext2.append(" mDexOptPath is ");
    paramContext2.append(this.f);
    TbsLog.i("TbsWizard", paramContext2.toString());
    paramContext2 = this.e;
    paramString1 = Integer.TYPE;
    paramString2 = this.b;
    paramArrayOfString = this.e;
    paramString3 = this.c;
    paramString4 = this.f;
    String str = QbSdk.a();
    paramContext2.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironmentAndNotLoadSo", new Class[] { Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, paramString1, String.class }, new Object[] { paramContext1, paramString2, paramArrayOfString, paramString3, paramString4, "3.6.0.1315", Integer.valueOf(43612), str });
  }
  
  private int a(Context paramContext)
  {
    Object localObject1;
    Object localObject3;
    Object localObject4;
    String str1;
    String str2;
    String str3;
    if ((this.b == null) && (TbsShareManager.getHostCorePathAppDefined() != null))
    {
      localObject1 = this.e;
      localObject2 = Integer.TYPE;
      localObject3 = this.b;
      localObject4 = this.e;
      str1 = this.c;
      str2 = this.f;
      str3 = QbSdk.a();
      String str4 = TbsShareManager.getHostCorePathAppDefined();
      localObject1 = ((DexLoader)localObject1).invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[] { Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, localObject2, String.class, String.class }, new Object[] { paramContext, localObject3, localObject4, str1, str2, "3.6.0.1315", Integer.valueOf(43612), str3, str4 });
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("initTesRuntimeEnvironment callerContext is ");
      ((StringBuilder)localObject1).append(paramContext);
      ((StringBuilder)localObject1).append(" mHostContext is ");
      ((StringBuilder)localObject1).append(this.b);
      ((StringBuilder)localObject1).append(" mDexLoader is ");
      ((StringBuilder)localObject1).append(this.e);
      ((StringBuilder)localObject1).append(" mtbsInstallLocation is ");
      ((StringBuilder)localObject1).append(this.c);
      ((StringBuilder)localObject1).append(" mDexOptPath is ");
      ((StringBuilder)localObject1).append(this.f);
      TbsLog.i("TbsWizard", ((StringBuilder)localObject1).toString());
      localObject1 = this.e;
      localObject2 = Integer.TYPE;
      localObject3 = this.b;
      localObject4 = this.e;
      str1 = this.c;
      str2 = this.f;
      str3 = QbSdk.a();
      localObject1 = ((DexLoader)localObject1).invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[] { Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, localObject2, String.class }, new Object[] { paramContext, localObject3, localObject4, str1, str2, "3.6.0.1315", Integer.valueOf(43612), str3 });
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      c();
      d();
      localObject1 = this.e;
      localObject2 = this.b;
      localObject3 = this.e;
      localObject4 = this.c;
      str1 = this.f;
      localObject2 = ((DexLoader)localObject1).invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[] { Context.class, Context.class, DexLoader.class, String.class, String.class }, new Object[] { paramContext, localObject2, localObject3, localObject4, str1 });
    }
    int i;
    if (localObject2 == null)
    {
      i = -3;
    }
    else if ((localObject2 instanceof Integer))
    {
      i = ((Integer)localObject2).intValue();
    }
    else if ((localObject2 instanceof Throwable))
    {
      TbsCoreLoadStat.getInstance().a(this.a, 328, (Throwable)localObject2);
      i = -5;
    }
    else
    {
      i = -4;
    }
    if (i < 0)
    {
      paramContext = this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
      if ((paramContext instanceof Throwable))
      {
        localObject1 = (Throwable)paramContext;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("#");
        ((StringBuilder)localObject2).append(((Throwable)localObject1).getMessage());
        ((StringBuilder)localObject2).append("; cause: ");
        ((StringBuilder)localObject2).append(((Throwable)localObject1).getCause());
        ((StringBuilder)localObject2).append("; th: ");
        ((StringBuilder)localObject2).append(localObject1);
        this.g = ((StringBuilder)localObject2).toString();
      }
      if (!(paramContext instanceof String)) {
        return i;
      }
      paramContext = (String)paramContext;
    }
    else
    {
      paramContext = null;
    }
    this.g = paramContext;
    return i;
  }
  
  private void c()
  {
    this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "setTesSdkVersionName", new Class[] { String.class }, new Object[] { "3.6.0.1315" });
  }
  
  private void d()
  {
    this.e.setStaticField("com.tencent.tbs.tbsshell.TBSShell", "VERSION", Integer.valueOf(43612));
  }
  
  public String a()
  {
    Object localObject1 = this.e;
    Object localObject2 = Boolean.TYPE;
    String str = null;
    Object[] arrayOfObject = new Object[0];
    localObject2 = ((DexLoader)localObject1).invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "invokeStaticMethod", new Class[] { localObject2, String.class, String.class, Class[].class, Object[].class }, new Object[] { Boolean.valueOf(true), "com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, arrayOfObject });
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.e.invokeStaticMethod("com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]);
    }
    if (localObject1 != null)
    {
      str = String.valueOf(localObject1);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append(" ReaderPackName=");
      ((StringBuilder)localObject1).append(TbsReaderView.gReaderPackName);
      ((StringBuilder)localObject1).append(" ReaderPackVersion=");
      ((StringBuilder)localObject1).append(TbsReaderView.gReaderPackVersion);
      str = ((StringBuilder)localObject1).toString();
    }
    localObject1 = str;
    if (str == null) {
      localObject1 = "X5 core get nothing...";
    }
    return (String)localObject1;
  }
  
  public void a(Context paramContext1, Context paramContext2, String paramString1, String paramString2, String[] paramArrayOfString, String paramString3)
  {
    this.a = paramContext1.getApplicationContext();
    this.b = paramContext2;
    this.c = paramString1;
    this.d = paramArrayOfString;
    this.f = paramString2;
    libwebp.loadWepLibraryIfNeed(paramContext2, this.c);
    if (QbSdk.n != null)
    {
      paramContext2 = this.e;
      paramString1 = QbSdk.n;
      paramContext2.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[] { Map.class }, new Object[] { paramString1 });
    }
    int i = a(paramContext1);
    if (i >= 0) {
      return;
    }
    paramContext1 = new StringBuilder();
    paramContext1.append("continueInit init error: ");
    paramContext1.append(i);
    paramContext1.append("; msg: ");
    paramContext1.append(this.g);
    throw new Exception(paramContext1.toString());
  }
  
  public boolean a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    paramContext = this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "installLocalQbApk", new Class[] { Context.class, String.class, String.class, Bundle.class }, new Object[] { paramContext, paramString1, paramString2, paramBundle });
    if (paramContext == null) {
      return false;
    }
    return ((Boolean)paramContext).booleanValue();
  }
  
  public DexLoader b()
  {
    return this.e;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */