package com.tencent.smtt.sdk.a;

import a.a;
import android.content.Context;
import android.content.pm.Signature;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsCoreLoadStat;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsShareManager;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.p;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import org.json.JSONObject;

public class b
{
  public static byte[] a;
  
  static
  {
    try
    {
      a = "65dRa93L".getBytes("utf-8");
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
  }
  
  private static String a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64).signatures[0].toByteArray();
        if (paramContext != null)
        {
          Object localObject = MessageDigest.getInstance("SHA-1");
          ((MessageDigest)localObject).update(paramContext);
          paramContext = ((MessageDigest)localObject).digest();
          if (paramContext != null)
          {
            localObject = new StringBuilder("");
            if (paramContext != null)
            {
              if (paramContext.length > 0) {
                break label141;
              }
              return null;
              if (i < paramContext.length)
              {
                String str = Integer.toHexString(paramContext[i] & 0xFF).toUpperCase();
                if (i > 0) {
                  ((StringBuilder)localObject).append(":");
                }
                if (str.length() < 2) {
                  ((StringBuilder)localObject).append(0);
                }
                ((StringBuilder)localObject).append(str);
                i += 1;
                continue;
              }
              paramContext = ((StringBuilder)localObject).toString();
              return paramContext;
            }
            return null;
          }
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
      return null;
      label141:
      int i = 0;
    }
  }
  
  public static void a(a parama, Context paramContext)
  {
    new c("HttpUtils", paramContext, parama).start();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean, long paramLong)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private static JSONObject c(a parama, Context paramContext)
  {
    JSONObject localJSONObject;
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("APPNAME", parama.a);
        localJSONObject.put("TIME", parama.b);
        localJSONObject.put("QUA2", parama.c);
        localJSONObject.put("LC", parama.d);
        localJSONObject.put("GUID", parama.e);
        localJSONObject.put("IMEI", parama.f);
        localJSONObject.put("IMSI", parama.g);
        localJSONObject.put("MAC", parama.h);
        localJSONObject.put("PV", parama.i);
        localJSONObject.put("CORETYPE", parama.j);
        localJSONObject.put("APPVN", parama.k);
        String str;
        if (parama.l == null)
        {
          str = "0";
          localJSONObject.put("SIGNATURE", str);
        }
        else
        {
          str = parama.l;
          continue;
        }
        localJSONObject.put("PROTOCOL_VERSION", 3);
        localJSONObject.put("ANDROID_ID", parama.m);
        if (TbsShareManager.isThirdPartyApp(paramContext))
        {
          localJSONObject.put("HOST_COREVERSION", TbsShareManager.getHostCoreVersions(paramContext));
        }
        else
        {
          localJSONObject.put("HOST_COREVERSION", TbsDownloader.getCoreShareDecoupleCoreVersionByContext(paramContext));
          localJSONObject.put("DECOUPLE_COREVERSION", TbsDownloader.getCoreShareDecoupleCoreVersionByContext(paramContext));
        }
        if (parama.j == 0)
        {
          localJSONObject.put("WIFICONNECTEDTIME", parama.n);
          localJSONObject.put("CORE_EXIST", parama.o);
          i = TbsCoreLoadStat.mLoadErrorCode;
          if (parama.o <= 0) {
            localJSONObject.put("TBS_ERROR_CODE", TbsDownloadConfig.getInstance(paramContext).getDownloadInterruptCode());
          } else {
            localJSONObject.put("TBS_ERROR_CODE", i);
          }
          if (i == -1) {
            TbsLog.e("sdkreport", "ATTENTION: Load errorCode missed!");
          }
        }
        TbsDownloadConfig.getInstance(paramContext).uploadDownloadInterruptCodeIfNeeded(paramContext);
      }
      catch (Exception parama)
      {
        int i;
        continue;
      }
      try
      {
        if (QbSdk.getTID() != null)
        {
          if (parama.a.equals("com.tencent.mobileqq"))
          {
            localJSONObject.put("TID", p.a().a(QbSdk.getTID()));
            i = 1;
            localJSONObject.put("TIDTYPE", i);
            return localJSONObject;
          }
          if (parama.a.equals("com.tencent.mm"))
          {
            localJSONObject.put("TID", QbSdk.getTID());
            i = 0;
            continue;
          }
        }
        return localJSONObject;
      }
      catch (Exception parama) {}
    }
    TbsLog.e("sdkreport", "getPostData exception!");
    return null;
    return localJSONObject;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */