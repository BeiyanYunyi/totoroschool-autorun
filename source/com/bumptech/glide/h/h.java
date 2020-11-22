package com.bumptech.glide.h;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.os.Looper;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public final class h
{
  private static final char[] a = "0123456789abcdef".toCharArray();
  private static final char[] b = new char[64];
  private static final char[] c = new char[40];
  
  public static int a(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return paramInt1 * paramInt2 * a(paramConfig);
  }
  
  private static int a(Bitmap.Config paramConfig)
  {
    Bitmap.Config localConfig = paramConfig;
    if (paramConfig == null) {
      localConfig = Bitmap.Config.ARGB_8888;
    }
    switch (1.a[localConfig.ordinal()])
    {
    default: 
      return 4;
    case 2: 
    case 3: 
      return 2;
    }
    return 1;
  }
  
  @TargetApi(19)
  public static int a(Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 19) {}
    try
    {
      int i = paramBitmap.getAllocationByteCount();
      return i;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;) {}
    }
    return paramBitmap.getHeight() * paramBitmap.getRowBytes();
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    synchronized (b)
    {
      paramArrayOfByte = a(paramArrayOfByte, b);
      return paramArrayOfByte;
    }
  }
  
  private static String a(byte[] paramArrayOfByte, char[] paramArrayOfChar)
  {
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      int k = i * 2;
      paramArrayOfChar[k] = a[(j >>> 4)];
      paramArrayOfChar[(k + 1)] = a[(j & 0xF)];
      i += 1;
    }
    return new String(paramArrayOfChar);
  }
  
  public static <T> List<T> a(Collection<T> paramCollection)
  {
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      localArrayList.add(paramCollection.next());
    }
    return localArrayList;
  }
  
  public static <T> Queue<T> a(int paramInt)
  {
    return new ArrayDeque(paramInt);
  }
  
  public static void a()
  {
    if (b()) {
      return;
    }
    throw new IllegalArgumentException("You must call this method on the main thread");
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return (b(paramInt1)) && (b(paramInt2));
  }
  
  public static boolean b()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  private static boolean b(int paramInt)
  {
    return (paramInt > 0) || (paramInt == Integer.MIN_VALUE);
  }
  
  public static boolean c()
  {
    return b() ^ true;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\h\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */