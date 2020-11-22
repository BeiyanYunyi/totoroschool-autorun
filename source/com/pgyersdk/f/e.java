package com.pgyersdk.f;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.util.Base64;
import java.io.FileOutputStream;
import java.io.IOException;

public class e
{
  private static int a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = new BitmapFactory.Options();
    int i = 1;
    paramContext.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, paramContext);
    while (paramContext.outWidth / i >= paramInt) {
      i *= 2;
    }
    return i;
  }
  
  public static Bitmap a(Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inSampleSize = a(paramContext, paramString, paramInt1);
    return a(BitmapFactory.decodeFile(paramString, localOptions), paramInt1, paramInt2);
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap != null)
    {
      float f1 = paramInt1 / paramBitmap.getWidth();
      float f2 = paramInt2 / paramBitmap.getHeight();
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(f1, f2);
      return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
    }
    return null;
  }
  
  public static Bitmap a(String paramString)
  {
    try
    {
      paramString = Base64.decode(paramString, 0);
      paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static Boolean a(Bitmap paramBitmap, String paramString)
  {
    if (paramBitmap == null) {
      return Boolean.valueOf(false);
    }
    Object localObject = null;
    try
    {
      paramString = new FileOutputStream(paramString);
      try
      {
        paramBitmap.compress(Bitmap.CompressFormat.JPEG, 100, paramString);
        paramString.close();
        return Boolean.valueOf(true);
      }
      catch (Exception localException)
      {
        paramBitmap = paramString;
        paramString = localException;
      }
      f.a("PgyerSDK", "Could not save screenshot.", paramString);
    }
    catch (Exception paramString)
    {
      paramBitmap = localException;
    }
    if (paramBitmap != null) {
      try
      {
        paramBitmap.close();
      }
      catch (IOException paramBitmap)
      {
        paramBitmap.printStackTrace();
      }
    }
    return Boolean.valueOf(false);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\f\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */