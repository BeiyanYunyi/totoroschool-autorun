package com.bumptech.glide.load.c.b;

import android.content.Context;
import com.bumptech.glide.load.c.l;
import com.bumptech.glide.load.c.m;
import java.io.InputStream;

public class b
  implements d<byte[]>
{
  private final String a;
  
  public b()
  {
    this("");
  }
  
  @Deprecated
  public b(String paramString)
  {
    this.a = paramString;
  }
  
  public com.bumptech.glide.load.a.c<InputStream> a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new com.bumptech.glide.load.a.b(paramArrayOfByte, this.a);
  }
  
  public static class a
    implements m<byte[], InputStream>
  {
    public l<byte[], InputStream> a(Context paramContext, com.bumptech.glide.load.c.c paramc)
    {
      return new b();
    }
    
    public void a() {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\c\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */