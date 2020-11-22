package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;

public class ak
{
  private Context a;
  
  public ak(Context paramContext)
  {
    this.a = paramContext;
  }
  
  private boolean a(String paramString1, Context paramContext, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    String str = dx.b(paramContext);
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(".dat");
      localObject = new File(((StringBuilder)localObject).toString());
      if ((((File)localObject).exists()) && (!bc.b((File)localObject)))
      {
        bc.a("deleteDownload delete some thing wrong!");
        return false;
      }
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(paramString2);
        bc.b(((StringBuilder)localObject).toString());
        bc.b(paramString1, paramContext);
        return true;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return false;
      }
      catch (IOException paramString1)
      {
        paramString1.printStackTrace();
        return false;
      }
      return false;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return false;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private boolean b(az paramaz)
  {
    if (paramaz != null)
    {
      String str2 = paramaz.getPinyin();
      boolean bool1 = a(str2, this.a, "vmap/");
      String str1 = str2;
      if (str2.equals("quanguogaiyaotu")) {
        str1 = "quanguo";
      }
      boolean bool3 = a(str1, this.a, "map/");
      boolean bool2 = true;
      int i;
      if ((!bool3) && (!bool1)) {
        i = 0;
      } else {
        i = 1;
      }
      bool1 = bool2;
      if (!b(bc.c(paramaz.getUrl()), this.a, "map/")) {
        if (i != 0) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
      }
      if (bool1)
      {
        paramaz.i();
        return bool1;
      }
      paramaz.h();
      return false;
    }
    return false;
  }
  
  private boolean b(String paramString1, Context paramContext, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    String str = dx.a(paramContext);
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(paramString1);
      localObject = new File(((StringBuilder)localObject).toString());
      if ((((File)localObject).exists()) && (!bc.b((File)localObject)))
      {
        bc.a("deleteDownload delete some thing wrong!");
        return false;
      }
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(paramString2);
        bc.b(((StringBuilder)localObject).toString());
        bc.b(paramString1, paramContext);
        return true;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return false;
      }
      catch (IOException paramString1)
      {
        paramString1.printStackTrace();
        return false;
      }
      return false;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return false;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void a(az paramaz)
  {
    b(paramaz);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */