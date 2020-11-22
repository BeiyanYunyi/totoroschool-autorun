package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build.VERSION;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class dm
{
  private static int a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[(paramInt + 0)];
    int j = paramArrayOfByte[(paramInt + 1)];
    int k = paramArrayOfByte[(paramInt + 2)];
    return paramArrayOfByte[(paramInt + 3)] << 24 | i & 0xFF | j << 8 | k << 16;
  }
  
  private static Bitmap a(InputStream paramInputStream)
    throws Exception
  {
    Object localObject = BitmapFactory.decodeStream(paramInputStream);
    paramInputStream = a((Bitmap)localObject);
    if (NinePatch.isNinePatchChunk(paramInputStream))
    {
      Bitmap localBitmap = Bitmap.createBitmap((Bitmap)localObject, 1, 1, ((Bitmap)localObject).getWidth() - 2, ((Bitmap)localObject).getHeight() - 2);
      ((Bitmap)localObject).recycle();
      if (Build.VERSION.SDK_INT >= 28)
      {
        localObject = localBitmap.getClass().getDeclaredMethod("setNinePatchChunk", new Class[] { byte[].class });
        ((Method)localObject).setAccessible(true);
        ((Method)localObject).invoke(localBitmap, new Object[] { paramInputStream });
        return localBitmap;
      }
      localObject = localBitmap.getClass().getDeclaredField("mNinePatchChunk");
      ((Field)localObject).setAccessible(true);
      ((Field)localObject).set(localBitmap, paramInputStream);
      return localBitmap;
    }
    return (Bitmap)localObject;
  }
  
  public static Drawable a(Context paramContext, String paramString)
    throws Exception
  {
    paramString = b(paramContext, paramString);
    if (paramString.getNinePatchChunk() == null) {
      return new BitmapDrawable(paramContext.getResources(), paramString);
    }
    Rect localRect = new Rect();
    a(paramString.getNinePatchChunk(), localRect);
    return new NinePatchDrawable(paramContext.getResources(), paramString, paramString.getNinePatchChunk(), localRect, null);
  }
  
  private static void a(Bitmap paramBitmap, byte[] paramArrayOfByte)
  {
    int[] arrayOfInt = new int[paramBitmap.getWidth() - 2];
    paramBitmap.getPixels(arrayOfInt, 0, arrayOfInt.length, 1, paramBitmap.getHeight() - 1, arrayOfInt.length, 1);
    int j = 0;
    int i = 0;
    while (i < arrayOfInt.length)
    {
      if (-16777216 == arrayOfInt[i])
      {
        a(paramArrayOfByte, 12, i);
        break;
      }
      i += 1;
    }
    i = arrayOfInt.length - 1;
    while (i >= 0)
    {
      if (-16777216 == arrayOfInt[i])
      {
        a(paramArrayOfByte, 16, arrayOfInt.length - i - 2);
        break;
      }
      i -= 1;
    }
    arrayOfInt = new int[paramBitmap.getHeight() - 2];
    paramBitmap.getPixels(arrayOfInt, 0, 1, paramBitmap.getWidth() - 1, 0, 1, arrayOfInt.length);
    i = j;
    while (i < arrayOfInt.length)
    {
      if (-16777216 == arrayOfInt[i])
      {
        a(paramArrayOfByte, 20, i);
        break;
      }
      i += 1;
    }
    i = arrayOfInt.length - 1;
    while (i >= 0)
    {
      if (-16777216 == arrayOfInt[i])
      {
        a(paramArrayOfByte, 24, arrayOfInt.length - i - 2);
        return;
      }
      i -= 1;
    }
  }
  
  private static void a(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    paramOutputStream.write(paramInt >> 0 & 0xFF);
    paramOutputStream.write(paramInt >> 8 & 0xFF);
    paramOutputStream.write(paramInt >> 16 & 0xFF);
    paramOutputStream.write(paramInt >> 24 & 0xFF);
  }
  
  private static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[(paramInt1 + 0)] = ((byte)(paramInt2 >> 0));
    paramArrayOfByte[(paramInt1 + 1)] = ((byte)(paramInt2 >> 8));
    paramArrayOfByte[(paramInt1 + 2)] = ((byte)(paramInt2 >> 16));
    paramArrayOfByte[(paramInt1 + 3)] = ((byte)(paramInt2 >> 24));
  }
  
  private static void a(byte[] paramArrayOfByte, Rect paramRect)
  {
    paramRect.left = a(paramArrayOfByte, 12);
    paramRect.right = a(paramArrayOfByte, 16);
    paramRect.top = a(paramArrayOfByte, 20);
    paramRect.bottom = a(paramArrayOfByte, 24);
  }
  
  private static byte[] a(Bitmap paramBitmap)
    throws IOException
  {
    int j = paramBitmap.getWidth();
    int i3 = paramBitmap.getHeight();
    Object localObject = new ByteArrayOutputStream();
    int i = 0;
    while (i < 32)
    {
      ((ByteArrayOutputStream)localObject).write(0);
      i += 1;
    }
    i = j - 2;
    int[] arrayOfInt = new int[i];
    paramBitmap.getPixels(arrayOfInt, 0, j, 1, 0, i, 1);
    if (arrayOfInt[0] == -16777216) {
      k = 1;
    } else {
      k = 0;
    }
    if (arrayOfInt[(arrayOfInt.length - 1)] == -16777216) {
      m = 1;
    } else {
      m = 0;
    }
    int i4 = arrayOfInt.length;
    j = 0;
    int i1 = 0;
    for (i = 0; j < i4; i = n)
    {
      i2 = i1;
      n = i;
      if (i1 != arrayOfInt[j])
      {
        n = i + 1;
        a((OutputStream)localObject, j);
        i2 = arrayOfInt[j];
      }
      j += 1;
      i1 = i2;
    }
    j = i;
    if (m != 0)
    {
      j = i + 1;
      a((OutputStream)localObject, arrayOfInt.length);
    }
    int n = j + 1;
    i = n;
    if (k != 0) {
      i = n - 1;
    }
    int k = i;
    if (m != 0) {
      k = i - 1;
    }
    i = i3 - 2;
    arrayOfInt = new int[i];
    paramBitmap.getPixels(arrayOfInt, 0, 1, 0, 1, 1, i);
    if (arrayOfInt[0] == -16777216) {
      m = 1;
    } else {
      m = 0;
    }
    if (arrayOfInt[(arrayOfInt.length - 1)] == -16777216) {
      n = 1;
    } else {
      n = 0;
    }
    int i5 = arrayOfInt.length;
    i1 = 0;
    i3 = 0;
    for (i = 0; i1 < i5; i = i2)
    {
      i4 = i3;
      i2 = i;
      if (i3 != arrayOfInt[i1])
      {
        i2 = i + 1;
        a((OutputStream)localObject, i1);
        i4 = arrayOfInt[i1];
      }
      i1 += 1;
      i3 = i4;
    }
    i1 = i;
    if (n != 0)
    {
      i1 = i + 1;
      a((OutputStream)localObject, arrayOfInt.length);
    }
    int i2 = i1 + 1;
    i = i2;
    if (m != 0) {
      i = i2 - 1;
    }
    int m = i;
    if (n != 0) {
      m = i - 1;
    }
    i = 0;
    for (;;)
    {
      n = k * m;
      if (i >= n) {
        break;
      }
      a((OutputStream)localObject, 1);
      i += 1;
    }
    localObject = ((ByteArrayOutputStream)localObject).toByteArray();
    localObject[0] = 1;
    localObject[1] = ((byte)j);
    localObject[2] = ((byte)i1);
    localObject[3] = ((byte)n);
    a(paramBitmap, (byte[])localObject);
    return (byte[])localObject;
  }
  
  private static Bitmap b(Context paramContext, String paramString)
    throws Exception
  {
    paramContext = dr.a(paramContext).open(paramString);
    paramString = a(paramContext);
    paramContext.close();
    return paramString;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\dm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */