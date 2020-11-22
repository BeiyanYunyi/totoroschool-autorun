package com.bumptech.glide.load.c;

import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.b;
import java.io.InputStream;
import java.io.OutputStream;

public class h
  implements b<g>
{
  private final b<InputStream> a;
  private final b<ParcelFileDescriptor> b;
  private String c;
  
  public h(b<InputStream> paramb, b<ParcelFileDescriptor> paramb1)
  {
    this.a = paramb;
    this.b = paramb1;
  }
  
  public String a()
  {
    if (this.c == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.a());
      localStringBuilder.append(this.b.a());
      this.c = localStringBuilder.toString();
    }
    return this.c;
  }
  
  public boolean a(g paramg, OutputStream paramOutputStream)
  {
    if (paramg.a() != null) {
      return this.a.a(paramg.a(), paramOutputStream);
    }
    return this.b.a(paramg.b(), paramOutputStream);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\c\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */