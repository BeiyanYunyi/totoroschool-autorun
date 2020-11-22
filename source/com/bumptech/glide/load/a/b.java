package com.bumptech.glide.load.a;

import com.bumptech.glide.g;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class b
  implements c<InputStream>
{
  private final byte[] a;
  private final String b;
  
  public b(byte[] paramArrayOfByte, String paramString)
  {
    this.a = paramArrayOfByte;
    this.b = paramString;
  }
  
  public void a() {}
  
  public InputStream b(g paramg)
  {
    return new ByteArrayInputStream(this.a);
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void c() {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */