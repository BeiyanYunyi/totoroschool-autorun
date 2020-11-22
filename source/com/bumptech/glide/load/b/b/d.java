package com.bumptech.glide.load.b.b;

import java.io.File;

public class d
  implements a.a
{
  private final int a;
  private final a b;
  
  public d(a parama, int paramInt)
  {
    this.a = paramInt;
    this.b = parama;
  }
  
  public a a()
  {
    File localFile = this.b.a();
    if (localFile == null) {
      return null;
    }
    if ((!localFile.mkdirs()) && ((!localFile.exists()) || (!localFile.isDirectory()))) {
      return null;
    }
    return e.a(localFile, this.a);
  }
  
  public static abstract interface a
  {
    public abstract File a();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\b\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */