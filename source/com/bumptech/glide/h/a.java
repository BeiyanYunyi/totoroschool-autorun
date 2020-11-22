package com.bumptech.glide.h;

import android.util.Log;
import java.util.Queue;

public final class a
{
  private static final a b = new a();
  private final Queue<byte[]> a = h.a(0);
  
  public static a a()
  {
    return b;
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    boolean bool = false;
    if (i != 65536) {
      return false;
    }
    synchronized (this.a)
    {
      if (this.a.size() < 32)
      {
        bool = true;
        this.a.offer(paramArrayOfByte);
      }
      return bool;
    }
  }
  
  public byte[] b()
  {
    synchronized (this.a)
    {
      byte[] arrayOfByte = (byte[])this.a.poll();
      ??? = arrayOfByte;
      if (arrayOfByte == null)
      {
        arrayOfByte = new byte[65536];
        ??? = arrayOfByte;
        if (Log.isLoggable("ByteArrayPool", 3))
        {
          Log.d("ByteArrayPool", "Created temp bytes");
          ??? = arrayOfByte;
        }
      }
      return (byte[])???;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\h\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */