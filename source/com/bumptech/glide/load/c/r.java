package com.bumptech.glide.load.c;

import com.bumptech.glide.load.a.c;
import java.net.URL;

public class r<T>
  implements l<URL, T>
{
  private final l<d, T> a;
  
  public r(l<d, T> paraml)
  {
    this.a = paraml;
  }
  
  public c<T> a(URL paramURL, int paramInt1, int paramInt2)
  {
    return this.a.a(new d(paramURL), paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\c\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */