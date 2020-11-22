package com.totoro.school.zxing.a;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.util.List;
import java.util.regex.Pattern;

final class b
{
  private static final String a = "b";
  private static final Pattern b = Pattern.compile(",");
  private final Context c;
  private Point d;
  private Point e;
  private int f;
  private String g;
  
  b(Context paramContext)
  {
    this.c = paramContext;
  }
  
  private static int a(CharSequence paramCharSequence, int paramInt)
  {
    paramCharSequence = b.split(paramCharSequence);
    int n = paramCharSequence.length;
    int i = 0;
    int j = 0;
    for (;;)
    {
      String str;
      if (i < n) {
        str = paramCharSequence[i].trim();
      }
      try
      {
        double d1 = Double.parseDouble(str);
        int m = (int)(10.0D * d1);
        double d2 = paramInt;
        Double.isNaN(d2);
        int k = j;
        if (Math.abs(d2 - d1) < Math.abs(paramInt - j)) {
          k = m;
        }
        i += 1;
        j = k;
      }
      catch (NumberFormatException paramCharSequence) {}
    }
    return j;
    return paramInt;
  }
  
  private static Point a(Camera.Parameters paramParameters, Point paramPoint)
  {
    Object localObject2 = paramParameters.get("preview-size-values");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramParameters.get("preview-size-value");
    }
    paramParameters = null;
    if (localObject1 != null)
    {
      paramParameters = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("preview-size-values parameter: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      Log.d(paramParameters, ((StringBuilder)localObject2).toString());
      paramParameters = a((CharSequence)localObject1, paramPoint);
    }
    localObject1 = paramParameters;
    if (paramParameters == null) {
      localObject1 = new Point(paramPoint.x >> 3 << 3, paramPoint.y >> 3 << 3);
    }
    return (Point)localObject1;
  }
  
  private static Point a(CharSequence paramCharSequence, Point paramPoint)
  {
    paramCharSequence = b.split(paramCharSequence);
    int i4 = paramCharSequence.length;
    int k = 0;
    int j = 0;
    int i = 0;
    int n;
    int i1;
    int i2;
    for (int m = Integer.MAX_VALUE;; m = i2)
    {
      n = j;
      i1 = i;
      if (k >= i4) {
        break;
      }
      String str1 = paramCharSequence[k].trim();
      i1 = str1.indexOf('x');
      if (i1 < 0)
      {
        str2 = a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Bad preview-size: ");
        localStringBuilder.append(str1);
        Log.w(str2, localStringBuilder.toString());
        i2 = m;
      }
      try
      {
        n = Integer.parseInt(str1.substring(0, i1));
        i1 = Integer.parseInt(str1.substring(i1 + 1));
        int i3 = Math.abs(n - paramPoint.x) + Math.abs(i1 - paramPoint.y);
        if (i3 == 0)
        {
          i = n;
          n = i1;
          i1 = i;
          break;
        }
        i2 = m;
        if (i3 >= m) {
          break label244;
        }
        i2 = i3;
        j = i1;
        i = n;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        label244:
        for (;;) {}
      }
      String str2 = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Bad preview-size: ");
      localStringBuilder.append(str1);
      Log.w(str2, localStringBuilder.toString());
      i2 = m;
      k += 1;
    }
    if ((i1 > 0) && (n > 0)) {
      return new Point(i1, n);
    }
    return null;
  }
  
  private void a(Camera.Parameters paramParameters)
  {
    if ((Build.MODEL.contains("Behold II")) && (c.a == 3)) {
      paramParameters.set("flash-value", 1);
    } else {
      paramParameters.set("flash-value", 2);
    }
    paramParameters.set("flash-mode", "off");
  }
  
  private void b(Camera.Parameters paramParameters)
  {
    String str1 = paramParameters.get("zoom-supported");
    if ((str1 != null) && (!Boolean.parseBoolean(str1))) {
      return;
    }
    j = 27;
    str1 = paramParameters.get("max-zoom");
    i = j;
    if (str1 != null) {}
    try
    {
      d1 = Double.parseDouble(str1);
      k = (int)(d1 * 10.0D);
      i = j;
      if (27 <= k) {
        break label120;
      }
      i = k;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      double d1;
      int k;
      String str2;
      Object localObject1;
      for (;;) {}
    }
    str2 = a;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Bad max-zoom: ");
    ((StringBuilder)localObject1).append(str1);
    Log.w(str2, ((StringBuilder)localObject1).toString());
    i = j;
    label120:
    str2 = paramParameters.get("taking-picture-zoom-max");
    j = i;
    if (str2 != null) {}
    try
    {
      k = Integer.parseInt(str2);
      j = i;
      if (i <= k) {
        break label207;
      }
      j = k;
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      Object localObject2;
      label207:
      for (;;) {}
    }
    localObject1 = a;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Bad taking-picture-zoom-max: ");
    ((StringBuilder)localObject2).append(str2);
    Log.w((String)localObject1, ((StringBuilder)localObject2).toString());
    j = i;
    localObject1 = paramParameters.get("mot-zoom-values");
    i = j;
    if (localObject1 != null) {
      i = a((CharSequence)localObject1, j);
    }
    localObject2 = paramParameters.get("mot-zoom-step");
    j = i;
    if (localObject2 != null) {}
    try
    {
      k = (int)(Double.parseDouble(((String)localObject2).trim()) * 10.0D);
      j = i;
      if (k > 1) {
        j = i - i % k;
      }
    }
    catch (NumberFormatException localNumberFormatException3)
    {
      for (;;)
      {
        j = i;
      }
    }
    if ((str1 != null) || (localObject1 != null))
    {
      d1 = j;
      Double.isNaN(d1);
      paramParameters.set("zoom", String.valueOf(d1 / 10.0D));
    }
    if (str2 != null) {
      paramParameters.set("taking-picture-zoom", j);
    }
  }
  
  Point a()
  {
    return this.e;
  }
  
  void a(Camera paramCamera)
  {
    paramCamera = paramCamera.getParameters();
    this.f = paramCamera.getPreviewFormat();
    this.g = paramCamera.get("preview-format");
    Display localDisplay = ((WindowManager)this.c.getSystemService("window")).getDefaultDisplay();
    int i = localDisplay.getWidth();
    int j = localDisplay.getHeight();
    this.d = new Point(i, j);
    if (i < j)
    {
      this.e = a(paramCamera, new Point(j, i));
      return;
    }
    this.e = a(paramCamera, this.d);
  }
  
  Point b()
  {
    return this.d;
  }
  
  void b(Camera paramCamera)
  {
    Camera.Parameters localParameters = paramCamera.getParameters();
    Object localObject = localParameters.getSupportedPreviewSizes();
    if (((List)localObject).size() > 2) {
      i = ((List)localObject).size() / 2 + 1;
    } else {
      i = ((List)localObject).size() / 2;
    }
    int j = ((Camera.Size)((List)localObject).get(i)).width;
    int i = ((Camera.Size)((List)localObject).get(i)).height;
    localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Setting preview size: ");
    localStringBuilder.append(this.e);
    Log.d((String)localObject, localStringBuilder.toString());
    paramCamera.setDisplayOrientation(90);
    this.e.x = j;
    this.e.y = i;
    localParameters.setPreviewSize(j, i);
    a(localParameters);
    b(localParameters);
    paramCamera.setParameters(localParameters);
  }
  
  int c()
  {
    return this.f;
  }
  
  String d()
  {
    return this.g;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\zxing\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */