package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.TextView;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.BaseHoleOptions;
import com.amap.api.maps.model.CircleHoleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.PolygonHoleOptions;
import com.amap.api.maps.utils.SpatialRelationUtil;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.amap.mapcore.interfaces.IMapConfig;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.FPoint3;
import com.autonavi.base.amap.mapcore.FileUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dx
{
  private static FPoint[] a = { FPoint.obtain(), FPoint.obtain(), FPoint.obtain(), FPoint.obtain() };
  private static List<Float> b = new ArrayList(4);
  private static List<Float> c = new ArrayList(4);
  
  public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    return (paramDouble3 - paramDouble1) * (paramDouble6 - paramDouble2) - (paramDouble5 - paramDouble1) * (paramDouble4 - paramDouble2);
  }
  
  public static double a(float paramFloat, double paramDouble1, double paramDouble2)
  {
    double d = paramFloat;
    Double.isNaN(d);
    return 20.0D - Math.log(paramDouble2 / (paramDouble1 * d)) / Math.log(2.0D);
  }
  
  public static float a(float paramFloat1, float paramFloat2)
  {
    float f = paramFloat1;
    if (paramFloat1 > 40.0F)
    {
      int i;
      if (paramFloat2 <= 15.0F) {
        i = 40;
      } else if (paramFloat2 <= 16.0F) {
        i = 56;
      } else if (paramFloat2 <= 17.0F) {
        i = 66;
      } else if (paramFloat2 <= 18.0F) {
        i = 74;
      } else if (paramFloat2 <= 18.0F) {
        i = 78;
      } else {
        i = 80;
      }
      paramFloat2 = i;
      f = paramFloat1;
      if (paramFloat1 > paramFloat2) {
        f = paramFloat2;
      }
    }
    return f;
  }
  
  private static float a(float paramFloat1, float paramFloat2, double paramDouble)
  {
    double d1 = Math.pow(2.0D, 20.0F - paramFloat2);
    double d2 = paramFloat1;
    Double.isNaN(d2);
    return (float)(paramDouble / (d1 * d2));
  }
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    double d1 = paramFloat3;
    double d2 = Math.pow(2.0D, 20.0F - paramFloat2);
    Double.isNaN(d1);
    double d3 = paramFloat1;
    Double.isNaN(d3);
    return (float)(d1 * d2 * d3);
  }
  
  public static float a(DPoint paramDPoint1, DPoint paramDPoint2)
  {
    if ((paramDPoint1 != null) && (paramDPoint2 != null))
    {
      double d1 = paramDPoint1.x;
      double d2 = paramDPoint2.x;
      double d3 = paramDPoint1.y;
      return (float)(Math.atan2(paramDPoint2.y - d3, d2 - d1) / 3.141592653589793D * 180.0D);
    }
    return 0.0F;
  }
  
  public static float a(IMapConfig paramIMapConfig, float paramFloat)
  {
    float f;
    if (paramIMapConfig != null)
    {
      if (paramFloat > paramIMapConfig.getMaxZoomLevel()) {
        return paramIMapConfig.getMaxZoomLevel();
      }
      f = paramFloat;
      if (paramFloat < paramIMapConfig.getMinZoomLevel()) {
        return paramIMapConfig.getMinZoomLevel();
      }
    }
    else
    {
      if (paramFloat > 20.0F) {
        return 20.0F;
      }
      f = paramFloat;
      if (paramFloat < 3.0F) {
        f = 3.0F;
      }
    }
    return f;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    return a(0, Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888), true);
  }
  
  public static int a(int paramInt1, Bitmap paramBitmap, int paramInt2, int paramInt3)
  {
    if (paramBitmap != null)
    {
      if (paramBitmap.isRecycled()) {
        return 0;
      }
      int i = paramInt1;
      if (paramInt1 == 0)
      {
        int[] arrayOfInt = new int[1];
        arrayOfInt[0] = 0;
        GLES20.glGenTextures(1, arrayOfInt, 0);
        i = arrayOfInt[0];
      }
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, i);
      GLUtils.texSubImage2D(3553, 0, paramInt2, paramInt3, paramBitmap);
      return i;
    }
    return 0;
  }
  
  public static int a(int paramInt, Bitmap paramBitmap, boolean paramBoolean)
  {
    paramInt = b(paramInt, paramBitmap, paramBoolean);
    if (paramBitmap != null) {
      paramBitmap.recycle();
    }
    return paramInt;
  }
  
  public static int a(Bitmap paramBitmap)
  {
    return a(paramBitmap, false);
  }
  
  public static int a(Bitmap paramBitmap, boolean paramBoolean)
  {
    return a(0, paramBitmap, paramBoolean);
  }
  
  public static int a(Object[] paramArrayOfObject)
  {
    return Arrays.hashCode(paramArrayOfObject);
  }
  
  public static Bitmap a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt3 * paramInt4;
    for (;;)
    {
      try
      {
        localObject = new int[i];
        arrayOfInt = new int[i];
        IntBuffer localIntBuffer = IntBuffer.wrap((int[])localObject);
        localIntBuffer.position(0);
        GLES20.glReadPixels(paramInt1, paramInt2, paramInt3, paramInt4, 6408, 5121, localIntBuffer);
        paramInt1 = 0;
      }
      catch (Throwable localThrowable)
      {
        int[] arrayOfInt;
        gk.c(localThrowable, "AMapDelegateImpGLSurfaceView", "SavePixels");
        localThrowable.printStackTrace();
        return null;
      }
      Object localObject = Bitmap.createBitmap(paramInt3, paramInt4, Bitmap.Config.ARGB_8888);
      ((Bitmap)localObject).setPixels(arrayOfInt, 0, paramInt3, 0, 0, paramInt3, paramInt4);
      return (Bitmap)localObject;
      while (paramInt1 < paramInt4)
      {
        paramInt2 = 0;
        while (paramInt2 < paramInt3)
        {
          i = localObject[(paramInt1 * paramInt3 + paramInt2)];
          localThrowable[((paramInt4 - paramInt1 - 1) * paramInt3 + paramInt2)] = (i & 0xFF00FF00 | i << 16 & 0xFF0000 | i >> 16 & 0xFF);
          paramInt2 += 1;
        }
        paramInt1 += 1;
      }
    }
  }
  
  public static Bitmap a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = dr.a(paramContext).open(paramString);
      paramString = BitmapFactory.decodeStream(paramContext);
      paramContext.close();
      return paramString;
    }
    catch (Throwable paramContext)
    {
      gk.c(paramContext, "Util", "fromAsset");
    }
    return null;
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat)
  {
    if (paramBitmap == null) {
      return null;
    }
    return Bitmap.createScaledBitmap(paramBitmap, (int)(paramBitmap.getWidth() * paramFloat), (int)(paramBitmap.getHeight() * paramFloat), true);
  }
  
  public static Bitmap a(View paramView)
  {
    try
    {
      b(paramView);
      paramView.destroyDrawingCache();
      paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      paramView.layout(0, 0, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
      paramView = paramView.getDrawingCache();
      if (paramView != null)
      {
        paramView = paramView.copy(Bitmap.Config.ARGB_8888, false);
        return paramView;
      }
      return null;
    }
    catch (Throwable paramView)
    {
      gk.c(paramView, "Utils", "getBitmapFromView");
      paramView.printStackTrace();
    }
    return null;
  }
  
  public static Pair<Float, IPoint> a(AbstractCameraUpdateMessage paramAbstractCameraUpdateMessage, IGLMapState paramIGLMapState, IMapConfig paramIMapConfig)
  {
    paramIGLMapState = paramAbstractCameraUpdateMessage.bounds;
    int i = paramAbstractCameraUpdateMessage.width;
    int j = paramAbstractCameraUpdateMessage.height;
    return a(paramIMapConfig, Math.max(paramAbstractCameraUpdateMessage.paddingLeft, 1), Math.max(paramAbstractCameraUpdateMessage.paddingRight, 1), Math.max(paramAbstractCameraUpdateMessage.paddingTop, 1), Math.max(paramAbstractCameraUpdateMessage.paddingBottom, 1), paramIGLMapState, i, j);
  }
  
  public static Pair<Float, Boolean> a(IMapConfig paramIMapConfig, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    paramIMapConfig.getSZ();
    boolean bool2 = true;
    boolean bool1 = true;
    float f1;
    if ((paramInt1 == paramInt3) && (paramInt2 == paramInt4))
    {
      f1 = paramIMapConfig.getMaxZoomLevel();
      bool1 = bool2;
    }
    else
    {
      float f2 = (float)a(paramIMapConfig.getMapZoomScale(), paramInt6, Math.abs(paramInt4 - paramInt2));
      f1 = (float)a(paramIMapConfig.getMapZoomScale(), paramInt5, Math.abs(paramInt3 - paramInt1));
      f2 = Math.min(f1, f2);
      if (f2 != f1) {
        bool1 = false;
      }
      f1 = Math.min(paramIMapConfig.getMaxZoomLevel(), Math.max(paramIMapConfig.getMinZoomLevel(), f2));
    }
    return new Pair(Float.valueOf(f1), Boolean.valueOf(bool1));
  }
  
  public static Pair<Float, IPoint> a(IMapConfig paramIMapConfig, int paramInt1, int paramInt2, int paramInt3, int paramInt4, LatLngBounds paramLatLngBounds, int paramInt5, int paramInt6)
  {
    if ((paramLatLngBounds != null) && (paramLatLngBounds.northeast != null))
    {
      if (paramLatLngBounds.southwest == null) {
        return null;
      }
      if (paramIMapConfig == null) {
        return null;
      }
      Point localPoint = VirtualEarthProjection.latLongToPixels(paramLatLngBounds.northeast.latitude, paramLatLngBounds.northeast.longitude, 20);
      paramLatLngBounds = VirtualEarthProjection.latLongToPixels(paramLatLngBounds.southwest.latitude, paramLatLngBounds.southwest.longitude, 20);
      int i = localPoint.x - paramLatLngBounds.x;
      int j = paramLatLngBounds.y - localPoint.y;
      int k = paramInt5 - (paramInt1 + paramInt2);
      int m = paramInt6 - (paramInt3 + paramInt4);
      if ((i < 0) && (j < 0)) {
        return null;
      }
      if (i <= 0) {
        i = 1;
      }
      if (j <= 0) {
        j = 1;
      }
      if (k <= 0) {
        k = 1;
      }
      if (m <= 0) {
        m = 1;
      }
      Pair localPair = a(paramIMapConfig, localPoint.x, localPoint.y, paramLatLngBounds.x, paramLatLngBounds.y, k, m);
      float f1 = ((Float)localPair.first).floatValue();
      boolean bool = ((Boolean)localPair.second).booleanValue();
      float f2 = a(paramIMapConfig.getMapZoomScale(), f1, i);
      float f3 = a(paramIMapConfig.getMapZoomScale(), f1, j);
      if (f1 >= paramIMapConfig.getMaxZoomLevel())
      {
        paramInt1 = (int)(paramLatLngBounds.x + (paramInt2 - paramInt1 + f2) * i / (f2 * 2.0F));
        paramInt2 = (int)(localPoint.y + (paramInt4 - paramInt3 + f3) * j / (f3 * 2.0F));
      }
      else if (bool)
      {
        paramInt1 = (int)(paramLatLngBounds.x + (paramInt5 / 2 - paramInt1) / f2 * i);
        paramInt2 = (int)(localPoint.y + (paramInt4 - paramInt3 + f3) * j / (f3 * 2.0F));
      }
      else
      {
        paramInt1 = (int)(paramLatLngBounds.x + (paramInt2 - paramInt1 + f2) * i / (f2 * 2.0F));
        paramInt2 = (int)(localPoint.y + (paramInt6 / 2 - paramInt3) / f3 * j);
      }
      f2 = paramIMapConfig.getAnchorX() - (paramIMapConfig.getMapWidth() >> 1);
      f3 = paramIMapConfig.getAnchorY() - (paramIMapConfig.getMapHeight() >> 1);
      return new Pair(Float.valueOf(f1), IPoint.obtain((int)(paramInt1 + a(paramIMapConfig.getMapZoomScale(), f1, f2)), (int)(paramInt2 + a(paramIMapConfig.getMapZoomScale(), f1, f3))));
    }
    return null;
  }
  
  public static DPoint a(LatLng paramLatLng)
  {
    double d1 = paramLatLng.longitude / 360.0D;
    double d2 = Math.sin(Math.toRadians(paramLatLng.latitude));
    return DPoint.obtain((d1 + 0.5D) * 1.0D, (Math.log((d2 + 1.0D) / (1.0D - d2)) * 0.5D / -6.283185307179586D + 0.5D) * 1.0D);
  }
  
  private static IPoint a(IPoint paramIPoint1, IPoint paramIPoint2, IPoint paramIPoint3, IPoint paramIPoint4)
  {
    IPoint localIPoint = IPoint.obtain(0, 0);
    double d1 = paramIPoint2.y - paramIPoint1.y;
    double d2 = paramIPoint1.x - paramIPoint3.x;
    Double.isNaN(d1);
    Double.isNaN(d2);
    double d3 = paramIPoint2.x - paramIPoint1.x;
    double d4 = paramIPoint1.y - paramIPoint3.y;
    Double.isNaN(d3);
    Double.isNaN(d4);
    d1 = d1 * d2 - d3 * d4;
    d2 = paramIPoint2.y - paramIPoint1.y;
    d3 = paramIPoint4.x - paramIPoint3.x;
    Double.isNaN(d2);
    Double.isNaN(d3);
    d4 = paramIPoint2.x - paramIPoint1.x;
    double d5 = paramIPoint4.y - paramIPoint3.y;
    Double.isNaN(d4);
    Double.isNaN(d5);
    d2 = d2 * d3 - d4 * d5;
    d3 = paramIPoint3.x;
    d4 = paramIPoint4.x - paramIPoint3.x;
    Double.isNaN(d4);
    d4 = d4 * d1 / d2;
    Double.isNaN(d3);
    localIPoint.x = ((int)(d3 + d4));
    d3 = paramIPoint3.y;
    d4 = paramIPoint4.y - paramIPoint3.y;
    Double.isNaN(d4);
    d1 = d4 * d1 / d2;
    Double.isNaN(d3);
    localIPoint.y = ((int)(d3 + d1));
    return localIPoint;
  }
  
  private static FPoint3 a(FPoint paramFPoint1, FPoint paramFPoint2, FPoint3 paramFPoint31, FPoint3 paramFPoint32, int paramInt)
  {
    FPoint3 localFPoint3 = new FPoint3(0.0F, 0.0F, paramInt);
    double d1 = (paramFPoint2.y - paramFPoint1.y) * (paramFPoint1.x - paramFPoint31.x) - (paramFPoint2.x - paramFPoint1.x) * (paramFPoint1.y - paramFPoint31.y);
    double d2 = (paramFPoint2.y - paramFPoint1.y) * (paramFPoint32.x - paramFPoint31.x) - (paramFPoint2.x - paramFPoint1.x) * (paramFPoint32.y - paramFPoint31.y);
    double d3 = paramFPoint31.x;
    double d4 = paramFPoint32.x - paramFPoint31.x;
    Double.isNaN(d4);
    Double.isNaN(d1);
    Double.isNaN(d2);
    d4 = d4 * d1 / d2;
    Double.isNaN(d3);
    localFPoint3.x = ((float)(d3 + d4));
    d3 = paramFPoint31.y;
    d4 = paramFPoint32.y - paramFPoint31.y;
    Double.isNaN(d4);
    Double.isNaN(d1);
    Double.isNaN(d2);
    d1 = d4 * d1 / d2;
    Double.isNaN(d3);
    localFPoint3.y = ((float)(d3 + d1));
    return localFPoint3;
  }
  
  private static FPoint a(FPoint paramFPoint1, FPoint paramFPoint2, FPoint paramFPoint3, FPoint paramFPoint4)
  {
    FPoint localFPoint = FPoint.obtain(0.0F, 0.0F);
    double d1 = (paramFPoint2.y - paramFPoint1.y) * (paramFPoint1.x - paramFPoint3.x) - (paramFPoint2.x - paramFPoint1.x) * (paramFPoint1.y - paramFPoint3.y);
    double d2 = (paramFPoint2.y - paramFPoint1.y) * (paramFPoint4.x - paramFPoint3.x) - (paramFPoint2.x - paramFPoint1.x) * (paramFPoint4.y - paramFPoint3.y);
    double d3 = paramFPoint3.x;
    double d4 = paramFPoint4.x - paramFPoint3.x;
    Double.isNaN(d4);
    Double.isNaN(d1);
    Double.isNaN(d2);
    d4 = d4 * d1 / d2;
    Double.isNaN(d3);
    localFPoint.x = ((float)(d3 + d4));
    d3 = paramFPoint3.y;
    d4 = paramFPoint4.y - paramFPoint3.y;
    Double.isNaN(d4);
    Double.isNaN(d1);
    Double.isNaN(d2);
    d1 = d4 * d1 / d2;
    Double.isNaN(d3);
    localFPoint.y = ((float)(d3 + d1));
    return localFPoint;
  }
  
  public static String a(int paramInt)
  {
    if (paramInt < 1000)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("m");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt / 1000);
    localStringBuilder.append("km");
    return localStringBuilder.toString();
  }
  
  public static String a(Context paramContext)
  {
    paramContext = new File(FileUtil.getMapBaseStorage(paramContext), "data_v6");
    if (!paramContext.exists()) {
      paramContext.mkdir();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext.toString());
    ((StringBuilder)localObject).append(File.separator);
    localObject = new File(((StringBuilder)localObject).toString());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdir();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext.toString());
    ((StringBuilder)localObject).append(File.separator);
    return ((StringBuilder)localObject).toString();
  }
  
  /* Error */
  public static String a(File paramFile)
  {
    // Byte code:
    //   0: new 484	java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial 485	java/lang/StringBuffer:<init>	()V
    //   7: astore 5
    //   9: aconst_null
    //   10: astore_1
    //   11: aconst_null
    //   12: astore_2
    //   13: aconst_null
    //   14: astore_3
    //   15: new 487	java/io/FileInputStream
    //   18: dup
    //   19: aload_0
    //   20: invokespecial 490	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   23: astore_0
    //   24: new 492	java/io/BufferedReader
    //   27: dup
    //   28: new 494	java/io/InputStreamReader
    //   31: dup
    //   32: aload_0
    //   33: ldc_w 496
    //   36: invokespecial 499	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   39: invokespecial 502	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   42: astore_1
    //   43: aload_1
    //   44: invokevirtual 505	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   47: astore_2
    //   48: aload_2
    //   49: ifnull +13 -> 62
    //   52: aload 5
    //   54: aload_2
    //   55: invokevirtual 508	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   58: pop
    //   59: goto -16 -> 43
    //   62: aload_0
    //   63: invokevirtual 509	java/io/FileInputStream:close	()V
    //   66: aload_1
    //   67: invokevirtual 510	java/io/BufferedReader:close	()V
    //   70: goto +292 -> 362
    //   73: astore_0
    //   74: aload_0
    //   75: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   78: goto +284 -> 362
    //   81: astore_0
    //   82: goto +15 -> 97
    //   85: astore_0
    //   86: aload_0
    //   87: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   90: aload_1
    //   91: invokevirtual 510	java/io/BufferedReader:close	()V
    //   94: goto +268 -> 362
    //   97: aload_1
    //   98: invokevirtual 510	java/io/BufferedReader:close	()V
    //   101: goto +8 -> 109
    //   104: astore_1
    //   105: aload_1
    //   106: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   109: aload_0
    //   110: athrow
    //   111: astore 4
    //   113: aload_0
    //   114: astore_2
    //   115: aload_1
    //   116: astore_3
    //   117: aload 4
    //   119: astore_0
    //   120: aload_2
    //   121: astore_1
    //   122: aload_3
    //   123: astore_2
    //   124: goto +245 -> 369
    //   127: astore_3
    //   128: aload_1
    //   129: astore_2
    //   130: aload_3
    //   131: astore_1
    //   132: goto +24 -> 156
    //   135: astore_3
    //   136: aload_1
    //   137: astore_2
    //   138: aload_3
    //   139: astore_1
    //   140: goto +29 -> 169
    //   143: astore_3
    //   144: aconst_null
    //   145: astore_2
    //   146: aload_0
    //   147: astore_1
    //   148: aload_3
    //   149: astore_0
    //   150: goto +219 -> 369
    //   153: astore_1
    //   154: aconst_null
    //   155: astore_2
    //   156: aload_0
    //   157: astore_3
    //   158: aload_2
    //   159: astore_0
    //   160: aload_1
    //   161: astore 4
    //   163: goto +30 -> 193
    //   166: astore_1
    //   167: aconst_null
    //   168: astore_2
    //   169: aload_0
    //   170: astore_3
    //   171: aload_2
    //   172: astore_0
    //   173: aload_1
    //   174: astore 4
    //   176: goto +106 -> 282
    //   179: astore_0
    //   180: aconst_null
    //   181: astore_3
    //   182: aload_2
    //   183: astore_1
    //   184: aload_3
    //   185: astore_2
    //   186: goto +183 -> 369
    //   189: astore 4
    //   191: aconst_null
    //   192: astore_0
    //   193: aload_3
    //   194: astore_1
    //   195: aload_0
    //   196: astore_2
    //   197: aload 4
    //   199: ldc -50
    //   201: ldc_w 513
    //   204: invokestatic 176	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   207: aload_3
    //   208: astore_1
    //   209: aload_0
    //   210: astore_2
    //   211: aload 4
    //   213: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   216: aload_3
    //   217: ifnull +48 -> 265
    //   220: aload_3
    //   221: invokevirtual 509	java/io/FileInputStream:close	()V
    //   224: goto +41 -> 265
    //   227: astore_1
    //   228: goto +19 -> 247
    //   231: astore_1
    //   232: aload_1
    //   233: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   236: aload_0
    //   237: ifnull +125 -> 362
    //   240: aload_0
    //   241: invokevirtual 510	java/io/BufferedReader:close	()V
    //   244: goto +118 -> 362
    //   247: aload_0
    //   248: ifnull +15 -> 263
    //   251: aload_0
    //   252: invokevirtual 510	java/io/BufferedReader:close	()V
    //   255: goto +8 -> 263
    //   258: astore_0
    //   259: aload_0
    //   260: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   263: aload_1
    //   264: athrow
    //   265: aload_0
    //   266: ifnull +96 -> 362
    //   269: aload_0
    //   270: invokevirtual 510	java/io/BufferedReader:close	()V
    //   273: goto +89 -> 362
    //   276: astore 4
    //   278: aconst_null
    //   279: astore_0
    //   280: aload_1
    //   281: astore_3
    //   282: aload_3
    //   283: astore_1
    //   284: aload_0
    //   285: astore_2
    //   286: aload 4
    //   288: ldc -50
    //   290: ldc_w 515
    //   293: invokestatic 176	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   296: aload_3
    //   297: astore_1
    //   298: aload_0
    //   299: astore_2
    //   300: aload 4
    //   302: invokevirtual 516	java/io/FileNotFoundException:printStackTrace	()V
    //   305: aload_3
    //   306: ifnull +48 -> 354
    //   309: aload_3
    //   310: invokevirtual 509	java/io/FileInputStream:close	()V
    //   313: goto +41 -> 354
    //   316: astore_1
    //   317: goto +19 -> 336
    //   320: astore_1
    //   321: aload_1
    //   322: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   325: aload_0
    //   326: ifnull +36 -> 362
    //   329: aload_0
    //   330: invokevirtual 510	java/io/BufferedReader:close	()V
    //   333: goto +29 -> 362
    //   336: aload_0
    //   337: ifnull +15 -> 352
    //   340: aload_0
    //   341: invokevirtual 510	java/io/BufferedReader:close	()V
    //   344: goto +8 -> 352
    //   347: astore_0
    //   348: aload_0
    //   349: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   352: aload_1
    //   353: athrow
    //   354: aload_0
    //   355: ifnull +7 -> 362
    //   358: aload_0
    //   359: invokevirtual 510	java/io/BufferedReader:close	()V
    //   362: aload 5
    //   364: invokevirtual 517	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   367: areturn
    //   368: astore_0
    //   369: aload_1
    //   370: ifnull +56 -> 426
    //   373: aload_1
    //   374: invokevirtual 509	java/io/FileInputStream:close	()V
    //   377: goto +49 -> 426
    //   380: astore_0
    //   381: goto +27 -> 408
    //   384: astore_1
    //   385: aload_1
    //   386: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   389: aload_2
    //   390: ifnull +44 -> 434
    //   393: aload_2
    //   394: invokevirtual 510	java/io/BufferedReader:close	()V
    //   397: goto +37 -> 434
    //   400: astore_1
    //   401: aload_1
    //   402: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   405: goto +29 -> 434
    //   408: aload_2
    //   409: ifnull +15 -> 424
    //   412: aload_2
    //   413: invokevirtual 510	java/io/BufferedReader:close	()V
    //   416: goto +8 -> 424
    //   419: astore_1
    //   420: aload_1
    //   421: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   424: aload_0
    //   425: athrow
    //   426: aload_2
    //   427: ifnull +7 -> 434
    //   430: aload_2
    //   431: invokevirtual 510	java/io/BufferedReader:close	()V
    //   434: aload_0
    //   435: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	436	0	paramFile	File
    //   10	88	1	localBufferedReader	java.io.BufferedReader
    //   104	12	1	localIOException1	IOException
    //   121	27	1	localObject1	Object
    //   153	8	1	localIOException2	IOException
    //   166	8	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   183	26	1	localObject2	Object
    //   227	1	1	localObject3	Object
    //   231	50	1	localIOException3	IOException
    //   283	15	1	localObject4	Object
    //   316	1	1	localObject5	Object
    //   320	54	1	localIOException4	IOException
    //   384	2	1	localIOException5	IOException
    //   400	2	1	localIOException6	IOException
    //   419	2	1	localIOException7	IOException
    //   12	419	2	localObject6	Object
    //   14	109	3	localIOException8	IOException
    //   127	4	3	localIOException9	IOException
    //   135	4	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   143	6	3	localObject7	Object
    //   157	153	3	localObject8	Object
    //   111	7	4	localObject9	Object
    //   161	14	4	localObject10	Object
    //   189	23	4	localIOException10	IOException
    //   276	25	4	localFileNotFoundException3	java.io.FileNotFoundException
    //   7	356	5	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   66	70	73	java/io/IOException
    //   90	94	73	java/io/IOException
    //   240	244	73	java/io/IOException
    //   269	273	73	java/io/IOException
    //   329	333	73	java/io/IOException
    //   358	362	73	java/io/IOException
    //   62	66	81	finally
    //   86	90	81	finally
    //   62	66	85	java/io/IOException
    //   97	101	104	java/io/IOException
    //   43	48	111	finally
    //   52	59	111	finally
    //   43	48	127	java/io/IOException
    //   52	59	127	java/io/IOException
    //   43	48	135	java/io/FileNotFoundException
    //   52	59	135	java/io/FileNotFoundException
    //   24	43	143	finally
    //   24	43	153	java/io/IOException
    //   24	43	166	java/io/FileNotFoundException
    //   15	24	179	finally
    //   15	24	189	java/io/IOException
    //   220	224	227	finally
    //   232	236	227	finally
    //   220	224	231	java/io/IOException
    //   251	255	258	java/io/IOException
    //   15	24	276	java/io/FileNotFoundException
    //   309	313	316	finally
    //   321	325	316	finally
    //   309	313	320	java/io/IOException
    //   340	344	347	java/io/IOException
    //   197	207	368	finally
    //   211	216	368	finally
    //   286	296	368	finally
    //   300	305	368	finally
    //   373	377	380	finally
    //   385	389	380	finally
    //   373	377	384	java/io/IOException
    //   393	397	400	java/io/IOException
    //   430	434	400	java/io/IOException
    //   412	416	419	java/io/IOException
  }
  
  public static String a(InputStream paramInputStream)
  {
    try
    {
      paramInputStream = new String(b(paramInputStream), "utf-8");
      return paramInputStream;
    }
    catch (Throwable paramInputStream)
    {
      gk.c(paramInputStream, "Util", "decodeAssetResData");
      paramInputStream.printStackTrace();
    }
    return null;
  }
  
  public static String a(String paramString, Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("=");
    localStringBuilder.append(String.valueOf(paramObject));
    return localStringBuilder.toString();
  }
  
  public static String a(String... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int k = paramVarArgs.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      localStringBuilder.append(paramVarArgs[i]);
      if (j != paramVarArgs.length - 1) {
        localStringBuilder.append(",");
      }
      j += 1;
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static FloatBuffer a(float[] paramArrayOfFloat)
  {
    try
    {
      Object localObject = ByteBuffer.allocateDirect(paramArrayOfFloat.length * 4);
      ((ByteBuffer)localObject).order(ByteOrder.nativeOrder());
      localObject = ((ByteBuffer)localObject).asFloatBuffer();
      ((FloatBuffer)localObject).put(paramArrayOfFloat);
      ((FloatBuffer)localObject).position(0);
      return (FloatBuffer)localObject;
    }
    catch (Throwable paramArrayOfFloat)
    {
      gk.c(paramArrayOfFloat, "Util", "makeFloatBuffer1");
      paramArrayOfFloat.printStackTrace();
    }
    return null;
  }
  
  public static FloatBuffer a(float[] paramArrayOfFloat, FloatBuffer paramFloatBuffer)
  {
    try
    {
      paramFloatBuffer.clear();
      paramFloatBuffer.put(paramArrayOfFloat);
      paramFloatBuffer.position(0);
      return paramFloatBuffer;
    }
    catch (Throwable paramArrayOfFloat)
    {
      gk.c(paramArrayOfFloat, "Util", "makeFloatBuffer2");
      paramArrayOfFloat.printStackTrace();
    }
    return null;
  }
  
  public static List<IPoint> a(IPoint[] paramArrayOfIPoint, List<IPoint> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = new ArrayList(paramList);
    for (int i = 0; i < 4; i = (byte)(i + 1))
    {
      localArrayList.clear();
      int m = paramList.size();
      int k;
      for (int j = 0;; j = k)
      {
        if (paramBoolean) {
          k = m;
        } else {
          k = m - 1;
        }
        if (j >= k) {
          break;
        }
        IPoint localIPoint1 = (IPoint)paramList.get(j % m);
        k = j + 1;
        IPoint localIPoint2 = (IPoint)paramList.get(k % m);
        if ((j == 0) && (a(localIPoint1, paramArrayOfIPoint[i], paramArrayOfIPoint[((i + 1) % paramArrayOfIPoint.length)]))) {
          localArrayList.add(localIPoint1);
        }
        IPoint localIPoint3 = paramArrayOfIPoint[i];
        j = i + 1;
        if (a(localIPoint1, localIPoint3, paramArrayOfIPoint[(j % paramArrayOfIPoint.length)]))
        {
          if (a(localIPoint2, paramArrayOfIPoint[i], paramArrayOfIPoint[(j % paramArrayOfIPoint.length)])) {
            localArrayList.add(localIPoint2);
          } else {
            localArrayList.add(a(paramArrayOfIPoint[i], paramArrayOfIPoint[(j % paramArrayOfIPoint.length)], localIPoint1, localIPoint2));
          }
        }
        else if (a(localIPoint2, paramArrayOfIPoint[i], paramArrayOfIPoint[(j % paramArrayOfIPoint.length)]))
        {
          localArrayList.add(a(paramArrayOfIPoint[i], paramArrayOfIPoint[(j % paramArrayOfIPoint.length)], localIPoint1, localIPoint2));
          localArrayList.add(localIPoint2);
        }
      }
      paramList.clear();
      j = 0;
      while (j < localArrayList.size())
      {
        paramList.add(localArrayList.get(j));
        j += 1;
      }
    }
    return paramList;
  }
  
  public static List<FPoint> a(FPoint[] paramArrayOfFPoint, List<FPoint> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = new ArrayList(paramList);
    for (int i = 0; i < 4; i = (byte)(i + 1))
    {
      localArrayList.clear();
      int m = paramList.size();
      int k;
      for (int j = 0;; j = k)
      {
        if (paramBoolean) {
          k = m;
        } else {
          k = m - 1;
        }
        if (j >= k) {
          break;
        }
        FPoint localFPoint1 = (FPoint)paramList.get(j % m);
        k = j + 1;
        FPoint localFPoint2 = (FPoint)paramList.get(k % m);
        if ((j == 0) && (a(localFPoint1, paramArrayOfFPoint[i], paramArrayOfFPoint[((i + 1) % paramArrayOfFPoint.length)]))) {
          localArrayList.add(localFPoint1);
        }
        FPoint localFPoint3 = paramArrayOfFPoint[i];
        j = i + 1;
        if (a(localFPoint1, localFPoint3, paramArrayOfFPoint[(j % paramArrayOfFPoint.length)]))
        {
          if (a(localFPoint2, paramArrayOfFPoint[i], paramArrayOfFPoint[(j % paramArrayOfFPoint.length)])) {
            localArrayList.add(localFPoint2);
          } else {
            localArrayList.add(a(paramArrayOfFPoint[i], paramArrayOfFPoint[(j % paramArrayOfFPoint.length)], localFPoint1, localFPoint2));
          }
        }
        else if (a(localFPoint2, paramArrayOfFPoint[i], paramArrayOfFPoint[(j % paramArrayOfFPoint.length)]))
        {
          localArrayList.add(a(paramArrayOfFPoint[i], paramArrayOfFPoint[(j % paramArrayOfFPoint.length)], localFPoint1, localFPoint2));
          localArrayList.add(localFPoint2);
        }
      }
      paramList.clear();
      j = 0;
      while (j < localArrayList.size())
      {
        paramList.add(localArrayList.get(j));
        j += 1;
      }
    }
    return paramList;
  }
  
  public static void a(Rect paramRect)
  {
    if (paramRect != null) {
      paramRect.set(Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
  }
  
  public static void a(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      paramDrawable.setCallback(null);
    }
  }
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT >= 8;
  }
  
  public static boolean a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8)
  {
    paramDouble3 -= paramDouble1;
    paramDouble8 -= paramDouble6;
    paramDouble4 -= paramDouble2;
    double d = paramDouble7 - paramDouble5;
    paramDouble7 = paramDouble3 * paramDouble8 - paramDouble4 * d;
    if (paramDouble7 != 0.0D)
    {
      paramDouble2 -= paramDouble6;
      paramDouble1 -= paramDouble5;
      paramDouble5 = (d * paramDouble2 - paramDouble8 * paramDouble1) / paramDouble7;
      paramDouble1 = (paramDouble2 * paramDouble3 - paramDouble1 * paramDouble4) / paramDouble7;
      if ((paramDouble5 >= 0.0D) && (paramDouble5 <= 1.0D) && (paramDouble1 >= 0.0D) && (paramDouble1 <= 1.0D)) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean a(int paramInt1, int paramInt2, IPoint paramIPoint1, IPoint paramIPoint2)
  {
    double d1 = paramIPoint2.x - paramIPoint1.x;
    double d2 = paramInt2 - paramIPoint1.y;
    double d3 = paramInt1 - paramIPoint1.x;
    double d4 = paramIPoint2.y - paramIPoint1.y;
    Double.isNaN(d1);
    Double.isNaN(d2);
    Double.isNaN(d3);
    Double.isNaN(d4);
    return d1 * d2 - d3 * d4 >= 0.0D;
  }
  
  public static boolean a(Rect paramRect, int paramInt1, int paramInt2)
  {
    return paramRect.contains(paramInt1, paramInt2);
  }
  
  public static boolean a(BaseHoleOptions paramBaseHoleOptions, LatLng paramLatLng)
  {
    if ((paramBaseHoleOptions instanceof CircleHoleOptions))
    {
      paramBaseHoleOptions = (CircleHoleOptions)paramBaseHoleOptions;
      LatLng localLatLng = paramBaseHoleOptions.getCenter();
      double d = paramBaseHoleOptions.getRadius();
      if (localLatLng == null) {
        return false;
      }
      return AMapUtils.calculateLineDistance(localLatLng, paramLatLng) <= d;
    }
    paramBaseHoleOptions = ((PolygonHoleOptions)paramBaseHoleOptions).getPoints();
    if (paramBaseHoleOptions != null)
    {
      if (paramBaseHoleOptions.size() == 0) {
        return false;
      }
      return a(paramLatLng, paramBaseHoleOptions);
    }
    return false;
  }
  
  public static boolean a(CircleHoleOptions paramCircleHoleOptions1, CircleHoleOptions paramCircleHoleOptions2)
  {
    boolean bool = false;
    try
    {
      double d1 = AMapUtils.calculateLineDistance(paramCircleHoleOptions2.getCenter(), paramCircleHoleOptions1.getCenter());
      double d2 = paramCircleHoleOptions1.getRadius();
      double d3 = paramCircleHoleOptions2.getRadius();
      if (d1 < d2 + d3) {
        bool = true;
      }
      return bool;
    }
    catch (Throwable paramCircleHoleOptions1)
    {
      gk.c(paramCircleHoleOptions1, "Util", "isPolygon2CircleIntersect");
      paramCircleHoleOptions1.printStackTrace();
    }
    return false;
  }
  
  public static boolean a(LatLng paramLatLng, List<LatLng> paramList)
  {
    List<LatLng> localList = paramList;
    double d3 = paramLatLng.longitude;
    double d1 = paramLatLng.latitude;
    double d2 = paramLatLng.latitude;
    if (paramList.size() < 3) {
      return false;
    }
    if (!((LatLng)localList.get(0)).equals(localList.get(paramList.size() - 1))) {
      localList.add(localList.get(0));
    }
    int k = 0;
    int i;
    for (int j = 0;; j = i)
    {
      paramLatLng = paramList;
      if (k >= paramList.size() - 1) {
        break;
      }
      double d4 = ((LatLng)paramLatLng.get(k)).longitude;
      double d5 = ((LatLng)paramLatLng.get(k)).latitude;
      k += 1;
      double d6 = ((LatLng)paramLatLng.get(k)).longitude;
      double d7 = ((LatLng)paramLatLng.get(k)).latitude;
      if (b(d3, d1, d4, d5, d6, d7)) {
        return true;
      }
      if (Math.abs(d7 - d5) < 1.0E-9D)
      {
        i = j;
      }
      else
      {
        if (!b(d4, d5, d3, d1, 180.0D, d2)) {
          break label251;
        }
        i = j;
        if (d5 > d7) {
          i = j + 1;
        }
      }
      for (;;)
      {
        break;
        label251:
        if (b(d6, d7, d3, d1, 180.0D, d2))
        {
          i = j;
          if (d7 > d5) {
            i = j + 1;
          }
        }
        else
        {
          i = j;
          if (a(d4, d5, d6, d7, d3, d1, 180.0D, d2)) {
            i = j + 1;
          }
        }
      }
    }
    return j % 2 != 0;
  }
  
  private static boolean a(IPoint paramIPoint1, IPoint paramIPoint2, IPoint paramIPoint3)
  {
    return a(paramIPoint1.x, paramIPoint1.y, paramIPoint2, paramIPoint3);
  }
  
  private static boolean a(FPoint paramFPoint1, FPoint paramFPoint2, FPoint paramFPoint3)
  {
    return (paramFPoint3.x - paramFPoint2.x) * (paramFPoint1.y - paramFPoint2.y) - (paramFPoint1.x - paramFPoint2.x) * (paramFPoint3.y - paramFPoint2.y) >= 0.0D;
  }
  
  public static boolean a(FPoint paramFPoint, FPoint[] paramArrayOfFPoint)
  {
    if (paramArrayOfFPoint == null) {
      return false;
    }
    for (int i = 0; i < paramArrayOfFPoint.length; i = (byte)i)
    {
      FPoint localFPoint = paramArrayOfFPoint[i];
      i += 1;
      if (!a(paramFPoint, localFPoint, paramArrayOfFPoint[(i % paramArrayOfFPoint.length)])) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean a(List<IPoint> paramList, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (paramInt2 < 3) {
      return false;
    }
    int i = paramInt2 - 1;
    paramInt1 = 0;
    double d1 = 0.0D;
    while (paramInt1 < paramInt2)
    {
      IPoint localIPoint1 = (IPoint)paramList.get(i);
      IPoint localIPoint2 = (IPoint)paramList.get(paramInt1);
      double d2 = localIPoint1.x;
      Double.isNaN(d2);
      d2 /= 1000000.0D;
      double d3 = localIPoint2.y;
      Double.isNaN(d3);
      d3 /= 1000000.0D;
      double d4 = localIPoint2.x;
      Double.isNaN(d4);
      d4 /= 1000000.0D;
      double d5 = localIPoint1.y;
      Double.isNaN(d5);
      d1 += d2 * d3 - d4 * (d5 / 1000000.0D);
      i = paramInt1;
      paramInt1 += 1;
    }
    if (d1 < 0.0D) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(List<BaseHoleOptions> paramList, CircleHoleOptions paramCircleHoleOptions)
  {
    int i = 0;
    boolean bool1 = false;
    while (i < paramList.size())
    {
      BaseHoleOptions localBaseHoleOptions = (BaseHoleOptions)paramList.get(i);
      boolean bool2;
      if ((localBaseHoleOptions instanceof PolygonHoleOptions))
      {
        bool2 = b(((PolygonHoleOptions)localBaseHoleOptions).getPoints(), paramCircleHoleOptions);
        bool1 = bool2;
        if (bool2) {
          return true;
        }
      }
      else if ((localBaseHoleOptions instanceof CircleHoleOptions))
      {
        bool2 = a(paramCircleHoleOptions, (CircleHoleOptions)localBaseHoleOptions);
        bool1 = bool2;
        if (bool2) {
          return true;
        }
      }
      i += 1;
    }
    return bool1;
  }
  
  public static boolean a(List<BaseHoleOptions> paramList, PolygonHoleOptions paramPolygonHoleOptions)
  {
    int i = 0;
    boolean bool1 = false;
    while (i < paramList.size())
    {
      Object localObject = (BaseHoleOptions)paramList.get(i);
      boolean bool2;
      if ((localObject instanceof PolygonHoleOptions))
      {
        bool2 = a(((PolygonHoleOptions)localObject).getPoints(), paramPolygonHoleOptions.getPoints());
        bool1 = bool2;
        if (bool2) {
          return true;
        }
      }
      else if ((localObject instanceof CircleHoleOptions))
      {
        localObject = (CircleHoleOptions)localObject;
        bool2 = b(paramPolygonHoleOptions.getPoints(), (CircleHoleOptions)localObject);
        bool1 = bool2;
        if (bool2) {
          return true;
        }
      }
      i += 1;
    }
    return bool1;
  }
  
  public static boolean a(List<LatLng> paramList1, List<LatLng> paramList2)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= paramList2.size()) {
          break label91;
        }
        if (!a((LatLng)paramList2.get(i), paramList1)) {
          break label84;
        }
        return true;
      }
      catch (Throwable paramList1)
      {
        boolean bool;
        gk.c(paramList1, "Util", "isPolygon2PolygonIntersect");
        paramList1.printStackTrace();
        return false;
      }
      if (i < paramList1.size())
      {
        if (a((LatLng)paramList1.get(i), paramList2)) {
          return true;
        }
      }
      else
      {
        bool = b(paramList1, paramList2);
        return bool;
        label84:
        i += 1;
        continue;
        label91:
        i = 0;
        continue;
      }
      i += 1;
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    return a(paramArrayOfByte, paramInt, paramInt, true);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int k;
    int m;
    int i;
    int j;
    try
    {
      localBitmap1 = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
      localBitmap2 = localBitmap1.copy(localBitmap1.getConfig(), true);
      k = localBitmap1.getWidth();
      m = localBitmap1.getHeight();
      i = 0;
    }
    catch (Throwable localThrowable)
    {
      Bitmap localBitmap1;
      Bitmap localBitmap2;
      label55:
      localThrowable.printStackTrace();
      return paramArrayOfByte;
    }
    localBitmap2.setPixel(i, j, paramInt1);
    break label143;
    if (!paramBoolean) {
      localBitmap2.setPixel(i, j, paramInt2);
    }
    label143:
    label152:
    label159:
    for (;;)
    {
      byte[] arrayOfByte2 = b(localBitmap2);
      byte[] arrayOfByte1 = arrayOfByte2;
      if (arrayOfByte2 == null) {
        arrayOfByte1 = paramArrayOfByte;
      }
      localBitmap2.recycle();
      localBitmap1.recycle();
      return arrayOfByte1;
      for (;;)
      {
        if (i >= k) {
          break label159;
        }
        j = 0;
        for (;;)
        {
          if (j >= m) {
            break label152;
          }
          if (i == 0) {
            break label55;
          }
          if (j != 0) {
            break;
          }
          break label55;
          j += 1;
        }
        i += 1;
      }
    }
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    int j;
    int i;
    int k;
    int m;
    int n;
    try
    {
      j = paramArrayOfByte.length;
      i = 0;
      localBitmap1 = BitmapFactory.decodeByteArray(paramArrayOfByte, 0, j);
      localObject = localBitmap1.getConfig();
      k = 1;
      localBitmap2 = localBitmap1.copy((Bitmap.Config)localObject, true);
      localBitmap1.getWidth();
      localBitmap1.getHeight();
      j = 6;
      m = 6;
    }
    catch (Throwable paramArrayOfInt)
    {
      Bitmap localBitmap1;
      Object localObject;
      Bitmap localBitmap2;
      paramArrayOfInt.printStackTrace();
      return paramArrayOfByte;
    }
    if (n < 12)
    {
      localBitmap1.getPixel(n, k);
      if (k < 4 * m) {
        localBitmap2.setPixel(n, k, paramArrayOfInt[i]);
      }
    }
    label176:
    for (;;)
    {
      localObject = b(localBitmap2);
      paramArrayOfInt = (int[])localObject;
      if (localObject == null) {
        paramArrayOfInt = paramArrayOfByte;
      }
      localBitmap2.recycle();
      localBitmap1.recycle();
      return paramArrayOfInt;
      for (;;)
      {
        if (k >= 72) {
          break label176;
        }
        n = 8;
        break;
        i += 1;
        j -= 1;
        m += j;
        n += 1;
        break;
        k += 1;
      }
    }
  }
  
  public static int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, IMapConfig paramIMapConfig, IGLMapState paramIGLMapState, int paramInt5, int paramInt6)
  {
    try
    {
      int i = paramIMapConfig.getMapWidth();
      int j = paramIMapConfig.getMapHeight();
      int k = paramIMapConfig.getAnchorX();
      int m = paramIMapConfig.getAnchorY();
      float f1 = a(paramIMapConfig.getMapZoomScale(), paramIGLMapState.getMapZoomer(), k);
      float f2 = a(paramIMapConfig.getMapZoomScale(), paramIGLMapState.getMapZoomer(), i - k);
      float f3 = a(paramIMapConfig.getMapZoomScale(), paramIGLMapState.getMapZoomer(), m);
      float f4 = a(paramIMapConfig.getMapZoomScale(), paramIGLMapState.getMapZoomer(), j - m);
      float f5 = paramInt3;
      float f6 = paramInt1;
      float f7 = paramInt2;
      float f8 = paramInt4;
      paramInt1 = (int)Math.max(f5 + f1, Math.min(paramInt5, f6 - f2));
      paramInt2 = (int)Math.max(f7 + f3, Math.min(paramInt6, f8 - f4));
      return new int[] { paramInt1, paramInt2 };
    }
    finally {}
  }
  
  public static FPoint[] a(IAMapDelegate paramIAMapDelegate, boolean paramBoolean)
  {
    float f = paramIAMapDelegate.getSkyHeight();
    int i;
    if (paramBoolean)
    {
      i = 100;
      j = 10;
    }
    else
    {
      i = 0;
      j = 0;
    }
    FPoint localFPoint1 = FPoint.obtain();
    int k = -i;
    int j = (int)(f - j);
    paramIAMapDelegate.pixel2Map(k, j, localFPoint1);
    a[0].set(localFPoint1.x, localFPoint1.y);
    FPoint localFPoint2 = FPoint.obtain();
    paramIAMapDelegate.pixel2Map(paramIAMapDelegate.getMapWidth() + i, j, localFPoint2);
    a[1].set(localFPoint2.x, localFPoint2.y);
    FPoint localFPoint3 = FPoint.obtain();
    paramIAMapDelegate.pixel2Map(paramIAMapDelegate.getMapWidth() + i, paramIAMapDelegate.getMapHeight() + i, localFPoint3);
    a[2].set(localFPoint3.x, localFPoint3.y);
    FPoint localFPoint4 = FPoint.obtain();
    paramIAMapDelegate.pixel2Map(k, paramIAMapDelegate.getMapHeight() + i, localFPoint4);
    a[3].set(localFPoint4.x, localFPoint4.y);
    localFPoint1.recycle();
    localFPoint2.recycle();
    localFPoint3.recycle();
    localFPoint4.recycle();
    return a;
  }
  
  public static float b(IMapConfig paramIMapConfig, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    float f2 = paramIMapConfig.getSZ();
    float f1 = f2;
    if (paramInt1 != paramInt3)
    {
      f1 = f2;
      if (paramInt2 != paramInt4)
      {
        f1 = (float)a(paramIMapConfig.getMapZoomScale(), paramInt6, Math.abs(paramInt4 - paramInt2));
        f1 = Math.max((float)a(paramIMapConfig.getMapZoomScale(), paramInt5, Math.abs(paramInt3 - paramInt1)), f1);
      }
    }
    return f1;
  }
  
  public static int b(int paramInt, Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramBitmap != null)
    {
      if (paramBitmap.isRecycled()) {
        return 0;
      }
      int i = paramInt;
      if (paramInt == 0)
      {
        int[] arrayOfInt = new int[1];
        arrayOfInt[0] = 0;
        GLES20.glGenTextures(1, arrayOfInt, 0);
        i = arrayOfInt[0];
      }
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, i);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      if (paramBoolean)
      {
        GLES20.glTexParameterf(3553, 10242, 10497.0F);
        GLES20.glTexParameterf(3553, 10243, 10497.0F);
      }
      else
      {
        GLES20.glTexParameterf(3553, 10242, 33071.0F);
        GLES20.glTexParameterf(3553, 10243, 33071.0F);
      }
      GLUtils.texImage2D(3553, 0, paramBitmap, 0);
      return i;
    }
    return 0;
  }
  
  public static String b(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FileUtil.getMapBaseStorage(paramContext));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("data");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static List<FPoint> b(FPoint[] paramArrayOfFPoint, List<FPoint> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = new ArrayList(paramList);
    for (int i = 0; i < 4; i = (byte)(i + 1))
    {
      localArrayList.clear();
      int m = paramList.size();
      int k;
      for (int j = 0;; j = k)
      {
        if (paramBoolean) {
          k = m;
        } else {
          k = m - 1;
        }
        if (j >= k) {
          break;
        }
        FPoint3 localFPoint31 = (FPoint3)paramList.get(j % m);
        k = j + 1;
        FPoint3 localFPoint32 = (FPoint3)paramList.get(k % m);
        if ((j == 0) && (a(localFPoint31, paramArrayOfFPoint[i], paramArrayOfFPoint[((i + 1) % paramArrayOfFPoint.length)]))) {
          localArrayList.add(localFPoint31);
        }
        FPoint localFPoint = paramArrayOfFPoint[i];
        j = i + 1;
        if (a(localFPoint31, localFPoint, paramArrayOfFPoint[(j % paramArrayOfFPoint.length)]))
        {
          if (a(localFPoint32, paramArrayOfFPoint[i], paramArrayOfFPoint[(j % paramArrayOfFPoint.length)])) {
            localArrayList.add(localFPoint32);
          } else {
            localArrayList.add(a(paramArrayOfFPoint[i], paramArrayOfFPoint[(j % paramArrayOfFPoint.length)], localFPoint31, localFPoint32, localFPoint32.colorIndex));
          }
        }
        else if (a(localFPoint32, paramArrayOfFPoint[i], paramArrayOfFPoint[(j % paramArrayOfFPoint.length)]))
        {
          localArrayList.add(a(paramArrayOfFPoint[i], paramArrayOfFPoint[(j % paramArrayOfFPoint.length)], localFPoint31, localFPoint32, localFPoint31.colorIndex));
          localArrayList.add(localFPoint32);
        }
      }
      paramList.clear();
      j = 0;
      while (j < localArrayList.size())
      {
        paramList.add(localArrayList.get(j));
        j += 1;
      }
    }
    return paramList;
  }
  
  public static void b(int paramInt)
  {
    GLES20.glDeleteTextures(1, new int[] { paramInt }, 0);
  }
  
  public static void b(Rect paramRect, int paramInt1, int paramInt2)
  {
    if (paramRect != null)
    {
      if (paramInt1 < paramRect.left) {
        paramRect.left = paramInt1;
      }
      if (paramInt1 > paramRect.right) {
        paramRect.right = paramInt1;
      }
      if (paramInt2 > paramRect.top) {
        paramRect.top = paramInt2;
      }
      if (paramInt2 < paramRect.bottom) {
        paramRect.bottom = paramInt2;
      }
    }
  }
  
  private static void b(View paramView)
  {
    boolean bool = paramView instanceof ViewGroup;
    int i = 0;
    if (bool) {
      for (;;)
      {
        ViewGroup localViewGroup = (ViewGroup)paramView;
        if (i >= localViewGroup.getChildCount()) {
          break;
        }
        b(localViewGroup.getChildAt(i));
        i += 1;
      }
    }
    if ((paramView instanceof TextView)) {
      ((TextView)paramView).setHorizontallyScrolling(false);
    }
  }
  
  public static boolean b()
  {
    return Build.VERSION.SDK_INT >= 9;
  }
  
  public static boolean b(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    return (Math.abs(a(paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDouble6)) < 1.0E-9D) && ((paramDouble1 - paramDouble3) * (paramDouble1 - paramDouble5) <= 0.0D) && ((paramDouble2 - paramDouble4) * (paramDouble2 - paramDouble6) <= 0.0D);
  }
  
  public static boolean b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0)) {
      return true;
    }
    Log.w("3dmap", "the map must have a size");
    return false;
  }
  
  public static boolean b(List<LatLng> paramList, CircleHoleOptions paramCircleHoleOptions)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramList.size())
      {
        localArrayList.add(paramList.get(i));
        i += 1;
      }
      localArrayList.add(paramList.get(0));
      paramList = new ArrayList();
      i = 0;
      while (i < localArrayList.size())
      {
        int j = i + 1;
        if (j >= localArrayList.size()) {
          return false;
        }
        if (paramCircleHoleOptions.getRadius() < AMapUtils.calculateLineDistance(paramCircleHoleOptions.getCenter(), (LatLng)localArrayList.get(i)))
        {
          if (paramCircleHoleOptions.getRadius() >= AMapUtils.calculateLineDistance(paramCircleHoleOptions.getCenter(), (LatLng)localArrayList.get(j))) {
            return true;
          }
          paramList.clear();
          paramList.add(localArrayList.get(i));
          paramList.add(localArrayList.get(j));
          Pair localPair = SpatialRelationUtil.calShortestDistancePoint(paramList, paramCircleHoleOptions.getCenter());
          float f = AMapUtils.calculateLineDistance(paramCircleHoleOptions.getCenter(), (LatLng)localPair.second);
          double d = paramCircleHoleOptions.getRadius();
          if (d >= f) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0) {
            return true;
          }
          i = j;
        }
        else
        {
          return true;
        }
      }
    }
    catch (Throwable paramList)
    {
      gk.c(paramList, "Util", "isPolygon2CircleIntersect");
      paramList.printStackTrace();
    }
    return false;
  }
  
  private static boolean b(List<LatLng> paramList1, List<LatLng> paramList2)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (i >= paramList1.size()) {
          break label140;
        }
        k = i + 1;
        if (k < paramList1.size()) {
          break label142;
        }
        return false;
      }
      catch (Throwable paramList1)
      {
        int k;
        int m;
        boolean bool;
        gk.c(paramList1, "Util", "isSegmentsIntersect");
        paramList1.printStackTrace();
      }
      if (j < paramList2.size())
      {
        m = j + 1;
        if (m < paramList2.size())
        {
          bool = ds.a((LatLng)paramList1.get(i), (LatLng)paramList1.get(k), (LatLng)paramList2.get(j), (LatLng)paramList2.get(m));
          if (bool) {
            return bool;
          }
          j = m;
          continue;
        }
      }
      i = k;
      continue;
      label140:
      return false;
      label142:
      int j = 0;
    }
  }
  
  /* Error */
  private static byte[] b(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: new 823	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 824	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: getstatic 830	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   12: bipush 100
    //   14: aload_1
    //   15: invokevirtual 834	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   18: pop
    //   19: aload_1
    //   20: invokevirtual 838	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   23: astore_0
    //   24: aload_1
    //   25: invokevirtual 839	java/io/ByteArrayOutputStream:close	()V
    //   28: aload_0
    //   29: areturn
    //   30: astore_1
    //   31: aload_1
    //   32: invokevirtual 179	java/lang/Throwable:printStackTrace	()V
    //   35: aload_0
    //   36: areturn
    //   37: astore_0
    //   38: goto +6 -> 44
    //   41: astore_0
    //   42: aconst_null
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +15 -> 60
    //   48: aload_1
    //   49: invokevirtual 839	java/io/ByteArrayOutputStream:close	()V
    //   52: goto +8 -> 60
    //   55: astore_1
    //   56: aload_1
    //   57: invokevirtual 179	java/lang/Throwable:printStackTrace	()V
    //   60: aload_0
    //   61: athrow
    //   62: aconst_null
    //   63: astore_1
    //   64: aload_1
    //   65: ifnull +14 -> 79
    //   68: aload_1
    //   69: invokevirtual 839	java/io/ByteArrayOutputStream:close	()V
    //   72: aconst_null
    //   73: areturn
    //   74: astore_0
    //   75: aload_0
    //   76: invokevirtual 179	java/lang/Throwable:printStackTrace	()V
    //   79: aconst_null
    //   80: areturn
    //   81: astore_0
    //   82: goto -20 -> 62
    //   85: astore_0
    //   86: goto -22 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	paramBitmap	Bitmap
    //   7	18	1	localByteArrayOutputStream	ByteArrayOutputStream
    //   30	2	1	localThrowable1	Throwable
    //   43	6	1	localObject1	Object
    //   55	2	1	localThrowable2	Throwable
    //   63	6	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   24	28	30	java/lang/Throwable
    //   8	24	37	finally
    //   0	8	41	finally
    //   48	52	55	java/lang/Throwable
    //   68	72	74	java/lang/Throwable
    //   0	8	81	java/lang/Throwable
    //   8	24	85	java/lang/Throwable
  }
  
  public static byte[] b(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['ࠀ'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte, 0, 2048);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static String c(Context paramContext)
  {
    paramContext = a(paramContext);
    if (paramContext == null) {
      return null;
    }
    paramContext = new File(paramContext, "VMAP2");
    if (!paramContext.exists()) {
      paramContext.mkdir();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.toString());
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static boolean c()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  public static boolean d()
  {
    return Build.VERSION.SDK_INT >= 12;
  }
  
  public static boolean d(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getState();
    if ((paramContext != null) && (paramContext != NetworkInfo.State.DISCONNECTED)) {
      return paramContext != NetworkInfo.State.DISCONNECTING;
    }
    return false;
  }
  
  public static fv e()
  {
    try
    {
      if (lk.e == null)
      {
        fv localfv = new fv.a("3dmap", "7.1.0", lk.c).a(new String[] { "com.amap.api.maps", "com.amap.api.mapcore", "com.autonavi.amap.mapcore", "com.autonavi.amap", "com.autonavi.ae", "com.autonavi.base", "com.autonavi.patch", "com.amap.api.3dmap.admic", "com.amap.api.trace", "com.amap.api.trace.core" }).a("7.1.0").a();
        return localfv;
      }
      return lk.e;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    return null;
  }
  
  public static boolean e(Context paramContext)
  {
    paramContext = new File(b(paramContext));
    if (!paramContext.exists()) {
      return true;
    }
    return FileUtil.deleteFile(paramContext);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\dx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */