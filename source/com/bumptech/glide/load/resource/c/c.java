package com.bumptech.glide.load.resource.c;

import android.content.Context;
import com.bumptech.glide.load.c.o;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.f;
import java.io.File;
import java.io.InputStream;

public class c
  implements com.bumptech.glide.e.b<InputStream, b>
{
  private final i a;
  private final j b;
  private final o c;
  private final com.bumptech.glide.load.resource.b.c<b> d;
  
  public c(Context paramContext, com.bumptech.glide.load.b.a.c paramc)
  {
    this.a = new i(paramContext, paramc);
    this.d = new com.bumptech.glide.load.resource.b.c(this.a);
    this.b = new j(paramc);
    this.c = new o();
  }
  
  public e<File, b> a()
  {
    return this.d;
  }
  
  public e<InputStream, b> b()
  {
    return this.a;
  }
  
  public com.bumptech.glide.load.b<InputStream> c()
  {
    return this.c;
  }
  
  public f<b> d()
  {
    return this.b;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\resource\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */