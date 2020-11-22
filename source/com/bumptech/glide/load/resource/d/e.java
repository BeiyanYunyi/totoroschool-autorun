package com.bumptech.glide.load.resource.d;

import com.bumptech.glide.load.b.k;
import com.bumptech.glide.load.c.g;
import java.io.IOException;
import java.io.InputStream;

public class e
  implements com.bumptech.glide.load.e<InputStream, a>
{
  private final com.bumptech.glide.load.e<g, a> a;
  
  public e(com.bumptech.glide.load.e<g, a> parame)
  {
    this.a = parame;
  }
  
  public k<a> a(InputStream paramInputStream, int paramInt1, int paramInt2)
    throws IOException
  {
    return this.a.a(new g(paramInputStream, null), paramInt1, paramInt2);
  }
  
  public String a()
  {
    return this.a.a();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\resource\d\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */