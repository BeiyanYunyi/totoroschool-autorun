package com.totoro.school.utils;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class m
{
  public static int a = 1;
  
  public static double a(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    paramDouble1 = paramDouble1 * 3.141592653589793D / 180.0D;
    paramDouble3 = paramDouble3 * 3.141592653589793D / 180.0D;
    paramDouble2 = paramDouble2 * 3.141592653589793D / 180.0D;
    paramDouble4 = paramDouble4 * 3.141592653589793D / 180.0D;
    paramDouble1 = Math.round(Math.asin(Math.sqrt(Math.pow(Math.sin((paramDouble1 - paramDouble3) / 2.0D), 2.0D) + Math.cos(paramDouble1) * Math.cos(paramDouble3) * Math.pow(Math.sin((paramDouble2 - paramDouble4) / 2.0D), 2.0D))) * 2.0D * 6378.137D * 10000.0D / 10.0D * 10.0D);
    Double.isNaN(paramDouble1);
    return paramDouble1 / 10.0D;
  }
  
  public static double a(double[][] paramArrayOfDouble1, double[][] paramArrayOfDouble2, double paramDouble1, double paramDouble2)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int n = paramArrayOfDouble1.length;
    int i4 = paramArrayOfDouble2.length;
    int i = 0;
    int k = 0;
    double d5;
    int m;
    double d6;
    double d2;
    double d3;
    int j;
    double d8;
    double d7;
    while (i < n - 1)
    {
      d5 = paramArrayOfDouble1[i][0];
      d4 = paramArrayOfDouble1[i][1];
      m = i + 1;
      d6 = paramArrayOfDouble1[m][0];
      d2 = paramArrayOfDouble1[m][1];
      d3 = d5;
      d1 = d6;
      if (d6 < d5)
      {
        d1 = paramArrayOfDouble1[i][0];
        d2 = paramArrayOfDouble1[i][1];
        d3 = paramArrayOfDouble1[m][0];
        d4 = paramArrayOfDouble1[m][1];
      }
      d5 = Math.round(a(d3, d4, d1, d2) / paramDouble1 * 10.0D);
      Double.isNaN(d5);
      d6 = d5 / 10.0D;
      d5 = d6;
      if (d6 < 1.0D) {
        d5 = 1.0D;
      }
      i = k;
      j = 0;
      for (;;)
      {
        d6 = j;
        if (d6 >= d5) {
          break;
        }
        if (d3 != d1)
        {
          d8 = d1 - d3;
          d7 = (d2 - d4) / d8;
          d8 /= d5;
          Double.isNaN(d6);
          localArrayList2.add(Double.valueOf(d3 * 1.0D + d8 * d6));
          if (d2 == d4)
          {
            localArrayList1.add(Double.valueOf(d4));
          }
          else if (d2 > d4)
          {
            Double.isNaN(d6);
            localArrayList1.add(Double.valueOf(d4 * 1.0D + d8 * d7 * d6 * 1.0D));
          }
          else
          {
            Double.isNaN(d6);
            localArrayList1.add(Double.valueOf(d4 * 1.0D - d8 * d7 * d6 * 1.0D));
          }
        }
        else
        {
          localArrayList2.add(Double.valueOf(d1));
          d7 = (d2 - d4) / d5;
          if (d2 == d4)
          {
            localArrayList1.add(Double.valueOf(d4));
          }
          else if (d2 > d4)
          {
            Double.isNaN(d6);
            localArrayList1.add(Double.valueOf(d4 * 1.0D + d7 * d6 * 1.0D));
          }
          else
          {
            Double.isNaN(d6);
            localArrayList1.add(Double.valueOf(d4 * 1.0D - d7 * d6 * 1.0D));
          }
        }
        i += 1;
        j += 1;
      }
      k = i;
      i = m;
    }
    paramArrayOfDouble1 = System.out;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ik:");
    localStringBuilder.append(k);
    paramArrayOfDouble1.println(localStringBuilder.toString());
    paramArrayOfDouble1 = System.out;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("lb:");
    localStringBuilder.append(i4);
    paramArrayOfDouble1.println(localStringBuilder.toString());
    paramArrayOfDouble1 = "";
    i = 0;
    while (i < localArrayList2.size())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramArrayOfDouble1);
      localStringBuilder.append(localArrayList2.get(i));
      localStringBuilder.append(",");
      paramArrayOfDouble1 = localStringBuilder.toString();
      i += 1;
    }
    paramArrayOfDouble1 = "";
    i = 0;
    while (i < localArrayList1.size())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramArrayOfDouble1);
      localStringBuilder.append(localArrayList1.get(i));
      localStringBuilder.append(",");
      paramArrayOfDouble1 = localStringBuilder.toString();
      i += 1;
    }
    i = 0;
    double d1 = 0.0D;
    double d10 = 0.0D;
    double d4 = 0.0D;
    while (i < i4 - 1)
    {
      d5 = paramArrayOfDouble2[i][0];
      d3 = paramArrayOfDouble2[i][1];
      int i3 = i + 1;
      d6 = paramArrayOfDouble2[i3][0];
      d7 = paramArrayOfDouble2[i3][1];
      d8 = d5;
      d2 = d6;
      if (d6 < d5)
      {
        d2 = paramArrayOfDouble2[i][0];
        d7 = paramArrayOfDouble2[i][1];
        d8 = paramArrayOfDouble2[i3][0];
        d3 = paramArrayOfDouble2[i3][1];
      }
      d5 = Math.round(a(d8, d3, d2, d7) * 1.0D / paramDouble1 * 10.0D);
      Double.isNaN(d5);
      d5 /= 10.0D;
      double d9 = d5;
      if (d5 < 1.0D) {
        d9 = 1.0D;
      }
      d5 = d1;
      int i1 = 0;
      j = -1;
      for (d1 = d4;; d1 = d4)
      {
        d6 = i1;
        if (d6 > d9) {
          break;
        }
        if (d8 != d2)
        {
          d11 = d2 - d8;
          d4 = (d7 - d3) / d11;
          d11 /= d9 * 1.0D;
          Double.isNaN(d6);
          if (d7 == d3)
          {
            d4 = d3;
          }
          else if (d7 > d3)
          {
            Double.isNaN(d6);
            d4 = d3 * 1.0D + d11 * d4 * d6;
          }
          else
          {
            Double.isNaN(d6);
            d4 = d3 * 1.0D - d11 * d4 * d6;
          }
          d6 = d8 * 1.0D + d11 * d6;
        }
        else
        {
          d4 = (d7 - d3) / d9;
          if (d7 != d3) {
            break label1064;
          }
          d4 = d3;
          d6 = d2;
        }
        double d11 = d4;
        break label1122;
        label1064:
        if (d7 > d3) {
          Double.isNaN(d6);
        }
        for (d4 = d3 * 1.0D + d4 * d6;; d4 = d3 * 1.0D - d4 * d6)
        {
          d6 = d2;
          d11 = d4;
          break;
          Double.isNaN(d6);
        }
        label1122:
        i = 0;
        m = 1;
        double d13;
        for (d4 = d1; i < k; d4 = d13)
        {
          n = m;
          int i2 = j;
          d13 = d4;
          if (((Double)localArrayList2.get(i)).doubleValue() * 1.0D != -1.0D)
          {
            n = m;
            i2 = j;
            d13 = d4;
            if (((Double)localArrayList1.get(i)).doubleValue() * 1.0D != -1.0D)
            {
              double d12 = a(d6, d11, ((Double)localArrayList2.get(i)).doubleValue(), ((Double)localArrayList1.get(i)).doubleValue());
              if (m != 0)
              {
                n = m ^ 0x1;
                j = i;
                d1 = d12;
              }
              else
              {
                n = m;
                d1 = d4;
                if (d12 * 1.0D < d4 * 1.0D)
                {
                  j = i;
                  d1 = d12;
                  n = m;
                }
              }
              i2 = j;
              d13 = d1;
              if (d12 * 1.0D < 0.1D) {
                break label1355;
              }
            }
          }
          i += 1;
          m = n;
          j = i2;
        }
        i = j;
        d1 = d4;
        label1355:
        d1 *= 1.0D;
        d4 = paramDouble2 * 1.0D;
        if (d1 <= d4)
        {
          d1 = d5 + 1.0D;
          if (i != -1)
          {
            localArrayList2.set(i, Double.valueOf(-1.0D));
            localArrayList1.set(i, Double.valueOf(-1.0D));
          }
        }
        else
        {
          d4 = 50.0D - (d1 - d4);
          d1 = d5;
          if (d4 > 0.0D) {
            d1 = d5 + d4 / 50.0D;
          }
        }
        d4 = 999.99D;
        d10 += 1.0D;
        i1 += 1;
        j = i;
        d5 = d1;
      }
      i = i3;
      d4 = d1;
      d1 = d5;
    }
    return d1 * 1.0D / (d10 * 1.0D);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\utils\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */