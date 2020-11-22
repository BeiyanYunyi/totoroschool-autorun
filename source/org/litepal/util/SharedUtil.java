package org.litepal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import org.litepal.LitePalApplication;

public class SharedUtil
{
  private static final String LITEPAL_PREPS = "litepal_prefs";
  private static final String VERSION = "litepal_version";
  
  public static int getLastVersion(String paramString)
  {
    SharedPreferences localSharedPreferences = LitePalApplication.getContext().getSharedPreferences("litepal_prefs", 0);
    if (TextUtils.isEmpty(paramString)) {
      return localSharedPreferences.getInt("litepal_version", 0);
    }
    String str = paramString;
    if (paramString.endsWith(".db")) {
      str = paramString.replace(".db", "");
    }
    paramString = new StringBuilder();
    paramString.append("litepal_version_");
    paramString.append(str);
    return localSharedPreferences.getInt(paramString.toString(), 0);
  }
  
  public static void removeVersion(String paramString)
  {
    SharedPreferences.Editor localEditor = LitePalApplication.getContext().getSharedPreferences("litepal_prefs", 0).edit();
    if (TextUtils.isEmpty(paramString))
    {
      localEditor.remove("litepal_version");
    }
    else
    {
      String str = paramString;
      if (paramString.endsWith(".db")) {
        str = paramString.replace(".db", "");
      }
      paramString = new StringBuilder();
      paramString.append("litepal_version_");
      paramString.append(str);
      localEditor.remove(paramString.toString());
    }
    localEditor.apply();
  }
  
  public static void updateVersion(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = LitePalApplication.getContext().getSharedPreferences("litepal_prefs", 0).edit();
    if (TextUtils.isEmpty(paramString))
    {
      localEditor.putInt("litepal_version", paramInt);
    }
    else
    {
      String str = paramString;
      if (paramString.endsWith(".db")) {
        str = paramString.replace(".db", "");
      }
      paramString = new StringBuilder();
      paramString.append("litepal_version_");
      paramString.append(str);
      localEditor.putInt(paramString.toString(), paramInt);
    }
    localEditor.apply();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\util\SharedUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */