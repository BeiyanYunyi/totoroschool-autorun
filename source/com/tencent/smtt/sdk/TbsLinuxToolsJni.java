package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;

class TbsLinuxToolsJni
{
  private static boolean a = false;
  private static boolean b = false;
  
  public TbsLinuxToolsJni(Context paramContext)
  {
    a(paramContext);
  }
  
  private native int ChmodInner(String paramString1, String paramString2);
  
  private void a(Context paramContext)
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("TbsLinuxToolsJni init mbIsInited is ");
      ((StringBuilder)localObject1).append(b);
      TbsLog.i("TbsLinuxToolsJni", ((StringBuilder)localObject1).toString());
      if (b) {
        return;
      }
      b = true;
      try
      {
        Object localObject2;
        if (TbsShareManager.isThirdPartyApp(paramContext))
        {
          localObject2 = TbsShareManager.a();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = TbsShareManager.c(paramContext);
          }
          localObject1 = new File((String)localObject1);
        }
        else
        {
          localObject1 = am.a().r(paramContext);
        }
        if (localObject1 != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(((File)localObject1).getAbsolutePath());
          localStringBuilder.append(File.separator);
          localStringBuilder.append("liblinuxtoolsfortbssdk_jni.so");
          localObject2 = localObject1;
          if (!new File(localStringBuilder.toString()).exists())
          {
            localObject2 = localObject1;
            if (!TbsShareManager.isThirdPartyApp(paramContext)) {
              localObject2 = am.a().q(paramContext);
            }
          }
          if (localObject2 != null)
          {
            paramContext = new StringBuilder();
            paramContext.append("TbsLinuxToolsJni init tbsSharePath is ");
            paramContext.append(((File)localObject2).getAbsolutePath());
            TbsLog.i("TbsLinuxToolsJni", paramContext.toString());
            paramContext = new StringBuilder();
            paramContext.append(((File)localObject2).getAbsolutePath());
            paramContext.append(File.separator);
            paramContext.append("liblinuxtoolsfortbssdk_jni.so");
            System.load(paramContext.toString());
            a = true;
          }
        }
        ChmodInner("/checkChmodeExists", "700");
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        a = false;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("TbsLinuxToolsJni init error !!! ");
        ((StringBuilder)localObject1).append(paramContext.getMessage());
        ((StringBuilder)localObject1).append(" ## ");
        ((StringBuilder)localObject1).append(paramContext.getCause());
        TbsLog.i("TbsLinuxToolsJni", ((StringBuilder)localObject1).toString());
      }
      return;
    }
    finally {}
  }
  
  public int a(String paramString1, String paramString2)
  {
    if (!a)
    {
      TbsLog.e("TbsLinuxToolsJni", "jni not loaded!", true);
      return -1;
    }
    return ChmodInner(paramString1, paramString2);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\TbsLinuxToolsJni.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */