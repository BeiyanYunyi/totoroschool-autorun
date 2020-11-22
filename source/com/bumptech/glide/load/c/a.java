package com.bumptech.glide.load.c;

import android.net.Uri;
import java.util.List;

final class a
{
  private static final int a = "file:///android_asset/".length();
  
  public static boolean a(Uri paramUri)
  {
    boolean bool3 = "file".equals(paramUri.getScheme());
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (!paramUri.getPathSegments().isEmpty())
      {
        bool1 = bool2;
        if ("android_asset".equals(paramUri.getPathSegments().get(0))) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static String b(Uri paramUri)
  {
    return paramUri.toString().substring(a);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */