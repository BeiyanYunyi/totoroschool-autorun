package com.amap.api.maps.model;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.amap.api.mapcore.util.dg.a;
import com.amap.api.mapcore.util.dx;
import com.amap.api.mapcore.util.lq;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public final class BitmapDescriptorFactory
{
  public static final float HUE_AZURE = 210.0F;
  public static final float HUE_BLUE = 240.0F;
  public static final float HUE_CYAN = 180.0F;
  public static final float HUE_GREEN = 120.0F;
  public static final float HUE_MAGENTA = 300.0F;
  public static final float HUE_ORANGE = 30.0F;
  public static final float HUE_RED = 0.0F;
  public static final float HUE_ROSE = 330.0F;
  public static final float HUE_VIOLET = 270.0F;
  public static final float HUE_YELLOW = 60.0F;
  private static final String ICON_ID_PREFIX = "com.amap.api.icon_";
  private static int nextId;
  
  public static BitmapDescriptor defaultMarker()
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(dg.a.b.name());
      ((StringBuilder)localObject).append(".png");
      localObject = fromAsset(((StringBuilder)localObject).toString());
      return (BitmapDescriptor)localObject;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static BitmapDescriptor defaultMarker(float paramFloat)
  {
    int i = (int)(paramFloat + 15.0F);
    try
    {
      f = i / 30 * 30;
      paramFloat = 'Ŋ';
      if (f <= paramFloat) {
        break label70;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        float f;
        StringBuilder localStringBuilder;
        Object localObject;
        continue;
        paramFloat = f;
        if (f < 0.0F) {
          paramFloat = 0.0F;
        }
        String str = "";
        if (paramFloat == 0.0F) {
          str = "RED";
        } else if (paramFloat == 30.0F) {
          str = "ORANGE";
        } else if (paramFloat == 60.0F) {
          str = "YELLOW";
        } else if (paramFloat == 120.0F) {
          str = "GREEN";
        } else if (paramFloat == 180.0F) {
          str = "CYAN";
        } else if (paramFloat == 210.0F) {
          str = "AZURE";
        } else if (paramFloat == 240.0F) {
          str = "BLUE";
        } else if (paramFloat == 270.0F) {
          str = "VIOLET";
        } else if (paramFloat == 300.0F) {
          str = "MAGENTA";
        } else if (paramFloat == 330.0F) {
          str = "ROSE";
        }
      }
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(".png");
    localObject = fromAsset(localStringBuilder.toString());
    return (BitmapDescriptor)localObject;
    return null;
  }
  
  public static BitmapDescriptor fromAsset(String paramString)
  {
    try
    {
      Object localObject = getContext();
      if (localObject != null) {
        return fromBitmap(dx.a((Context)localObject, paramString));
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("/assets/");
      ((StringBuilder)localObject).append(paramString);
      paramString = BitmapDescriptorFactory.class.getResourceAsStream(((StringBuilder)localObject).toString());
      localObject = BitmapFactory.decodeStream(paramString);
      paramString.close();
      paramString = fromBitmap((Bitmap)localObject);
      return paramString;
    }
    catch (Throwable paramString)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static BitmapDescriptor fromBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      if (nextId == Integer.MAX_VALUE) {
        nextId = 0;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("com.amap.api.icon_");
      int i = nextId + 1;
      nextId = i;
      localStringBuilder.append(i);
      paramBitmap = new BitmapDescriptor(paramBitmap, localStringBuilder.toString());
      return paramBitmap;
    }
    catch (Throwable paramBitmap) {}
    return null;
  }
  
  public static BitmapDescriptor fromFile(String paramString)
  {
    try
    {
      Object localObject = getContext();
      if (localObject != null)
      {
        localObject = ((Context)localObject).openFileInput(paramString);
        paramString = BitmapFactory.decodeStream((InputStream)localObject);
        ((FileInputStream)localObject).close();
        localObject = fromBitmap(paramString);
        paramString.recycle();
        return (BitmapDescriptor)localObject;
      }
      return null;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  public static BitmapDescriptor fromPath(String paramString)
  {
    try
    {
      paramString = fromBitmap(BitmapFactory.decodeFile(paramString));
      return paramString;
    }
    catch (Throwable paramString)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static BitmapDescriptor fromResource(int paramInt)
  {
    try
    {
      Object localObject = getContext();
      if (localObject != null)
      {
        localObject = fromBitmap(BitmapFactory.decodeStream(((Context)localObject).getResources().openRawResource(paramInt)));
        return (BitmapDescriptor)localObject;
      }
      return null;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public static BitmapDescriptor fromView(View paramView)
  {
    try
    {
      Object localObject = getContext();
      if (localObject != null)
      {
        localObject = new FrameLayout((Context)localObject);
        ((FrameLayout)localObject).addView(paramView);
        ((FrameLayout)localObject).setDrawingCacheEnabled(true);
        paramView = fromBitmap(dx.a((View)localObject));
        return paramView;
      }
      return null;
    }
    catch (Throwable paramView) {}
    return null;
  }
  
  public static Context getContext()
  {
    Object localObject2 = lq.a;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      try
      {
        localObject1 = Class.forName("com.amap.api.wrapper.MapFragmentDelegateWrapper");
        localObject2 = ((Class)localObject1).getConstructor(new Class[] { Integer.TYPE }).newInstance(new Object[] { Integer.valueOf(0) });
        localObject1 = (Context)((Class)localObject1).getDeclaredMethod("getContext", new Class[0]).invoke(localObject2, new Object[0]);
      }
      catch (Throwable localThrowable)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("BitmapDescriptor catch e:");
        ((StringBuilder)localObject2).append(localThrowable.toString());
        Log.d("mapcore", ((StringBuilder)localObject2).toString());
        return null;
      }
    }
    return localThrowable;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\maps\model\BitmapDescriptorFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */