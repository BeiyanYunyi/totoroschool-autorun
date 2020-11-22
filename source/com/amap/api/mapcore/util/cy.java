package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class cy
{
  static cy b;
  Context a;
  
  private cy(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = b.b(paramString);
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = new BufferedReader(new InputStreamReader(paramString, "utf-8"));
      for (;;)
      {
        String str = paramString.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str);
        localStringBuilder.append('\n');
      }
      paramString.close();
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return localStringBuilder.toString();
  }
  
  public static void a(Context paramContext)
  {
    b = new cy(paramContext);
  }
  
  public InputStream b(String paramString)
  {
    try
    {
      paramString = this.a.getAssets().open(paramString);
      return paramString;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\cy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */