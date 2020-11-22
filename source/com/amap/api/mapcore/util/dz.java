package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import java.io.FileDescriptor;

public class dz
  extends ea
{
  protected int a;
  protected int b;
  
  public dz(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    a(paramInt1, paramInt2);
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int k = paramOptions.outHeight;
    int m = paramOptions.outWidth;
    if ((k <= paramInt2) && (m <= paramInt1)) {
      return 1;
    }
    int i = Math.round(k / paramInt2);
    int j = Math.round(m / paramInt1);
    if (i >= j) {
      i = j;
    }
    float f1 = m * k;
    float f2 = paramInt1 * paramInt2 * 2;
    while (f1 / (i * i) > f2) {
      i += 1;
    }
    return i;
  }
  
  private Bitmap a(int paramInt)
  {
    return a(this.d, paramInt, this.a, this.b, a());
  }
  
  public static Bitmap a(Resources paramResources, int paramInt1, int paramInt2, int paramInt3, eb parameb)
  {
    parameb = new BitmapFactory.Options();
    parameb.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(paramResources, paramInt1, parameb);
    parameb.inSampleSize = a(parameb, paramInt2, paramInt3);
    parameb.inJustDecodeBounds = false;
    return BitmapFactory.decodeResource(paramResources, paramInt1, parameb);
  }
  
  public static Bitmap a(FileDescriptor paramFileDescriptor, int paramInt1, int paramInt2, eb parameb)
  {
    parameb = new BitmapFactory.Options();
    parameb.inJustDecodeBounds = true;
    BitmapFactory.decodeFileDescriptor(paramFileDescriptor, null, parameb);
    parameb.inSampleSize = a(parameb, paramInt1, paramInt2);
    parameb.inJustDecodeBounds = false;
    return BitmapFactory.decodeFileDescriptor(paramFileDescriptor, null, parameb);
  }
  
  protected Bitmap a(Object paramObject)
  {
    return a(Integer.parseInt(String.valueOf(paramObject)));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\dz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */