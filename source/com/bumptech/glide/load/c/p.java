package com.bumptech.glide.load.c;

import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.a.c;
import java.io.File;

public class p<T>
  implements l<String, T>
{
  private final l<Uri, T> a;
  
  public p(l<Uri, T> paraml)
  {
    this.a = paraml;
  }
  
  private static Uri a(String paramString)
  {
    return Uri.fromFile(new File(paramString));
  }
  
  public c<T> a(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (paramString.startsWith("/"))
    {
      paramString = a(paramString);
    }
    else
    {
      Uri localUri = Uri.parse(paramString);
      if (localUri.getScheme() == null) {
        paramString = a(paramString);
      } else {
        paramString = localUri;
      }
    }
    return this.a.a(paramString, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\c\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */