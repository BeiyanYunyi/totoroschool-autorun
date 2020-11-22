package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.net.URLEncoder;

public class kf
{
  private String a;
  
  public static boolean a(Context paramContext)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty("android.permission.WRITE_EXTERNAL_STORAGE"))) {
      return fw.a(paramContext, "android.permission.WRITE_EXTERNAL_STORAGE");
    }
    return false;
  }
  
  public kf a(File paramFile)
  {
    if (paramFile == null) {
      return this;
    }
    this.a = paramFile.getAbsolutePath();
    return this;
  }
  
  public kf a(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public String a()
  {
    return this.a;
  }
  
  public kf b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(URLEncoder.encode(paramString));
    this.a = localStringBuilder.toString();
    return this;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\kf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */