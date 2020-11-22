package com.bumptech.glide.load.c;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.a.c;

public abstract class q<T>
  implements l<Uri, T>
{
  private final Context a;
  private final l<d, T> b;
  
  public q(Context paramContext, l<d, T> paraml)
  {
    this.a = paramContext;
    this.b = paraml;
  }
  
  private static boolean a(String paramString)
  {
    return ("file".equals(paramString)) || ("content".equals(paramString)) || ("android.resource".equals(paramString));
  }
  
  protected abstract c<T> a(Context paramContext, Uri paramUri);
  
  protected abstract c<T> a(Context paramContext, String paramString);
  
  public final c<T> a(Uri paramUri, int paramInt1, int paramInt2)
  {
    String str = paramUri.getScheme();
    if (a(str))
    {
      if (a.a(paramUri))
      {
        paramUri = a.b(paramUri);
        return a(this.a, paramUri);
      }
      return a(this.a, paramUri);
    }
    if ((this.b != null) && (("http".equals(str)) || ("https".equals(str)))) {
      return this.b.a(new d(paramUri.toString()), paramInt1, paramInt2);
    }
    return null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\c\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */