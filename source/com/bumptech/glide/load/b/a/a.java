package com.bumptech.glide.load.b.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

class a
  implements g
{
  private final b a = new b();
  private final e<a, Bitmap> b = new e();
  
  private static String d(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("x");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("], ");
    localStringBuilder.append(paramConfig);
    return localStringBuilder.toString();
  }
  
  private static String d(Bitmap paramBitmap)
  {
    return d(paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getConfig());
  }
  
  public Bitmap a()
  {
    return (Bitmap)this.b.a();
  }
  
  public Bitmap a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    paramConfig = this.a.a(paramInt1, paramInt2, paramConfig);
    return (Bitmap)this.b.a(paramConfig);
  }
  
  public void a(Bitmap paramBitmap)
  {
    a locala = this.a.a(paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getConfig());
    this.b.a(locala, paramBitmap);
  }
  
  public String b(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return d(paramInt1, paramInt2, paramConfig);
  }
  
  public String b(Bitmap paramBitmap)
  {
    return d(paramBitmap);
  }
  
  public int c(Bitmap paramBitmap)
  {
    return com.bumptech.glide.h.h.a(paramBitmap);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AttributeStrategy:\n  ");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
  
  static class a
    implements h
  {
    private final a.b a;
    private int b;
    private int c;
    private Bitmap.Config d;
    
    public a(a.b paramb)
    {
      this.a = paramb;
    }
    
    public void a()
    {
      this.a.a(this);
    }
    
    public void a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
    {
      this.b = paramInt1;
      this.c = paramInt2;
      this.d = paramConfig;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool1 = paramObject instanceof a;
      boolean bool2 = false;
      if (bool1)
      {
        paramObject = (a)paramObject;
        bool1 = bool2;
        if (this.b == ((a)paramObject).b)
        {
          bool1 = bool2;
          if (this.c == ((a)paramObject).c)
          {
            bool1 = bool2;
            if (this.d == ((a)paramObject).d) {
              bool1 = true;
            }
          }
        }
        return bool1;
      }
      return false;
    }
    
    public int hashCode()
    {
      int j = this.b;
      int k = this.c;
      int i;
      if (this.d != null) {
        i = this.d.hashCode();
      } else {
        i = 0;
      }
      return (j * 31 + k) * 31 + i;
    }
    
    public String toString()
    {
      return a.c(this.b, this.c, this.d);
    }
  }
  
  static class b
    extends b<a.a>
  {
    protected a.a a()
    {
      return new a.a(this);
    }
    
    public a.a a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
    {
      a.a locala = (a.a)c();
      locala.a(paramInt1, paramInt2, paramConfig);
      return locala;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\b\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */