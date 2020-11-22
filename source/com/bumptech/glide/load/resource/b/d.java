package com.bumptech.glide.load.resource.b;

import com.bumptech.glide.load.b.k;
import com.bumptech.glide.load.c.o;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.f;
import java.io.File;
import java.io.InputStream;

public class d
  implements com.bumptech.glide.e.b<InputStream, File>
{
  private static final a a = new a(null);
  private final e<File, File> b = new a();
  private final com.bumptech.glide.load.b<InputStream> c = new o();
  
  public e<File, File> a()
  {
    return this.b;
  }
  
  public e<InputStream, File> b()
  {
    return a;
  }
  
  public com.bumptech.glide.load.b<InputStream> c()
  {
    return this.c;
  }
  
  public f<File> d()
  {
    return com.bumptech.glide.load.resource.b.b();
  }
  
  private static class a
    implements e<InputStream, File>
  {
    public k<File> a(InputStream paramInputStream, int paramInt1, int paramInt2)
    {
      throw new Error("You cannot decode a File from an InputStream by default, try either #diskCacheStratey(DiskCacheStrategy.SOURCE) to avoid this call or #decoder(ResourceDecoder) to replace this Decoder");
    }
    
    public String a()
    {
      return "";
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\resource\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */