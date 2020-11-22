package com.amap.api.location;

import android.content.Context;
import android.text.TextUtils;
import com.loc.dg;
import com.loc.di;
import com.loc.dk;
import com.loc.dn;
import org.json.JSONObject;

public class CoordinateConverter
{
  private static int b = 0;
  private static int c = 1;
  private static int d = 2;
  private static int e = 4;
  private static int f = 8;
  private static int g = 16;
  private static int h = 32;
  private static int i = 64;
  DPoint a = null;
  private Context j;
  private CoordType k = null;
  private DPoint l = null;
  
  public CoordinateConverter(Context paramContext)
  {
    this.j = paramContext;
  }
  
  public static float calculateLineDistance(DPoint paramDPoint1, DPoint paramDPoint2)
  {
    try
    {
      float f1 = dn.a(paramDPoint1, paramDPoint2);
      return f1;
    }
    catch (Throwable paramDPoint1)
    {
      for (;;) {}
    }
    return 0.0F;
  }
  
  public static boolean isAMapDataAvailable(double paramDouble1, double paramDouble2)
  {
    return dg.a(paramDouble1, paramDouble2);
  }
  
  public DPoint convert()
    throws Exception
  {
    for (;;)
    {
      int i4;
      Object localObject8;
      try
      {
        int n;
        int i1;
        int i2;
        int i3;
        Object localObject4;
        Object localObject5;
        Object localObject6;
        Object localObject7;
        Object localObject1;
        if (this.k != null) {
          if (this.l != null) {
            if ((this.l.getLongitude() <= 180.0D) && (this.l.getLongitude() >= -180.0D)) {
              if ((this.l.getLatitude() <= 90.0D) && (this.l.getLatitude() >= -90.0D))
              {
                n = 0;
                i1 = 0;
                i2 = 0;
                i3 = 0;
                i4 = 0;
                m = 0;
                localObject4 = null;
                localObject5 = null;
                localObject6 = null;
                localObject7 = null;
                localObject8 = null;
                localObject1 = null;
              }
            }
          }
        }
        switch (1.a[this.k.ordinal()])
        {
        case 7: 
          if ((b & i) == 0)
          {
            b |= i;
            localObject1 = "gps";
            m = 1;
          }
          localObject4 = di.a(this.j, this.l);
          this.a = ((DPoint)localObject4);
          break;
        case 6: 
          m = n;
          localObject1 = localObject4;
          if ((b & h) == 0)
          {
            localObject1 = "google";
            b |= h;
            m = 1;
          }
          localObject4 = this.l;
          break;
        case 5: 
          m = i1;
          localObject1 = localObject5;
          if ((b & g) == 0)
          {
            localObject1 = "aliyun";
            b |= g;
            m = 1;
          }
          localObject4 = this.l;
          break;
        case 4: 
          m = i2;
          localObject1 = localObject6;
          if ((b & f) == 0)
          {
            localObject1 = "sosomap";
            b |= f;
            m = 1;
          }
          localObject4 = this.l;
          break;
        case 3: 
          m = i3;
          localObject1 = localObject7;
          if ((b & e) == 0)
          {
            localObject1 = "mapabc";
            b |= e;
            m = 1;
          }
          localObject4 = this.l;
          break;
        case 2: 
          this.a = di.b(this.j, this.l);
          m = i4;
          localObject1 = localObject8;
          if ((b & d) == 0)
          {
            localObject1 = "mapbar";
            m = b;
            n = d;
          }
          break;
        case 1: 
          this.a = di.a(this.l);
          m = i4;
          localObject1 = localObject8;
          if ((b & c) == 0)
          {
            localObject1 = "baidu";
            m = b;
            n = c;
            b = m | n;
            m = 1;
          }
          if (m != 0)
          {
            localObject4 = new JSONObject();
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              ((JSONObject)localObject4).put("amap_loc_coordinate", localObject1);
            }
            dk.a(this.j, "O021", (JSONObject)localObject4);
          }
          localObject1 = this.a;
          return (DPoint)localObject1;
          throw new IllegalArgumentException("请传入合理纬度");
          throw new IllegalArgumentException("请传入合理经度");
          throw new IllegalArgumentException("转换坐标源不能为空");
          throw new IllegalArgumentException("转换坐标类型不能为空");
        }
      }
      finally {}
      int m = i4;
      Object localObject3 = localObject8;
    }
  }
  
  public CoordinateConverter coord(DPoint paramDPoint)
    throws Exception
  {
    if (paramDPoint != null) {}
    try
    {
      if ((paramDPoint.getLongitude() <= 180.0D) && (paramDPoint.getLongitude() >= -180.0D))
      {
        if ((paramDPoint.getLatitude() <= 90.0D) && (paramDPoint.getLatitude() >= -90.0D))
        {
          this.l = paramDPoint;
          return this;
        }
        throw new IllegalArgumentException("请传入合理纬度");
      }
      throw new IllegalArgumentException("请传入合理经度");
    }
    finally {}
    throw new IllegalArgumentException("传入经纬度对象为空");
  }
  
  public CoordinateConverter from(CoordType paramCoordType)
  {
    try
    {
      this.k = paramCoordType;
      return this;
    }
    finally
    {
      paramCoordType = finally;
      throw paramCoordType;
    }
  }
  
  public static enum CoordType
  {
    static
    {
      MAPABC = new CoordType("MAPABC", 2);
      SOSOMAP = new CoordType("SOSOMAP", 3);
    }
    
    private CoordType() {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\location\CoordinateConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */