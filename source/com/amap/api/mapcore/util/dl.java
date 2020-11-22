package com.amap.api.mapcore.util;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public class dl
  extends ee<a>
{
  private a b;
  
  public a a(int paramInt)
  {
    a locala = (a)this.a;
    if (locala == null)
    {
      locala = new a();
    }
    else
    {
      this.a = locala.f;
      locala.f = null;
    }
    if (locala.e < paramInt) {
      locala.a(paramInt);
    }
    this.b = ((a)ef.a(this.b, locala));
    return locala;
  }
  
  public void a()
  {
    this.b = ((a)b(this.b));
  }
  
  public ShortBuffer b(int paramInt)
  {
    a locala = a(paramInt * 2);
    if (locala.b == null)
    {
      locala.a.clear();
      locala.b = locala.a.asShortBuffer();
    }
    else
    {
      locala.b.clear();
    }
    return locala.b;
  }
  
  public FloatBuffer c(int paramInt)
  {
    a locala = a(paramInt * 4);
    if (locala.c == null)
    {
      locala.a.clear();
      locala.c = locala.a.asFloatBuffer();
    }
    else
    {
      locala.c.clear();
    }
    locala.c.clear();
    return locala.c;
  }
  
  static final class a
    extends ef<a>
  {
    ByteBuffer a;
    ShortBuffer b;
    FloatBuffer c;
    IntBuffer d;
    int e;
    
    void a(int paramInt)
    {
      int i = paramInt;
      if (paramInt < 32768) {
        i = 32768;
      }
      this.a = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
      this.e = i;
      this.b = null;
      this.d = null;
      this.c = null;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\dl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */