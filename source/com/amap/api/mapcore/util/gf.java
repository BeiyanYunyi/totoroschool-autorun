package com.amap.api.mapcore.util;

public class gf
{
  private final int a = 37;
  private int b = 0;
  
  public int a()
  {
    return this.b;
  }
  
  public gf a(byte paramByte)
  {
    this.b = (this.b * this.a + paramByte);
    return this;
  }
  
  public gf a(char paramChar)
  {
    this.b = (this.b * this.a + paramChar);
    return this;
  }
  
  public gf a(double paramDouble)
  {
    return a(Double.doubleToLongBits(paramDouble));
  }
  
  public gf a(float paramFloat)
  {
    this.b = (this.b * this.a + Float.floatToIntBits(paramFloat));
    return this;
  }
  
  public gf a(int paramInt)
  {
    this.b = (this.b * this.a + paramInt);
    return this;
  }
  
  public gf a(long paramLong)
  {
    this.b = (this.b * this.a + (int)(paramLong ^ paramLong >> 32));
    return this;
  }
  
  public gf a(Object paramObject)
  {
    if (paramObject == null)
    {
      this.b *= this.a;
      return this;
    }
    if (paramObject.getClass().isArray())
    {
      if ((paramObject instanceof long[]))
      {
        a((long[])paramObject);
        return this;
      }
      if ((paramObject instanceof int[]))
      {
        a((int[])paramObject);
        return this;
      }
      if ((paramObject instanceof short[]))
      {
        a((short[])paramObject);
        return this;
      }
      if ((paramObject instanceof char[]))
      {
        a((char[])paramObject);
        return this;
      }
      if ((paramObject instanceof byte[]))
      {
        a((byte[])paramObject);
        return this;
      }
      if ((paramObject instanceof double[]))
      {
        a((double[])paramObject);
        return this;
      }
      if ((paramObject instanceof float[]))
      {
        a((float[])paramObject);
        return this;
      }
      if ((paramObject instanceof boolean[]))
      {
        a((boolean[])paramObject);
        return this;
      }
      a((Object[])paramObject);
      return this;
    }
    this.b = (this.b * this.a + paramObject.hashCode());
    return this;
  }
  
  public gf a(short paramShort)
  {
    this.b = (this.b * this.a + paramShort);
    return this;
  }
  
  public gf a(boolean paramBoolean)
  {
    this.b = (this.b * this.a + (paramBoolean ^ true));
    return this;
  }
  
  public gf a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
    {
      this.b *= this.a;
      return this;
    }
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      a(paramArrayOfByte[i]);
      i += 1;
    }
    return this;
  }
  
  public gf a(char[] paramArrayOfChar)
  {
    if (paramArrayOfChar == null)
    {
      this.b *= this.a;
      return this;
    }
    int i = 0;
    while (i < paramArrayOfChar.length)
    {
      a(paramArrayOfChar[i]);
      i += 1;
    }
    return this;
  }
  
  public gf a(double[] paramArrayOfDouble)
  {
    if (paramArrayOfDouble == null)
    {
      this.b *= this.a;
      return this;
    }
    int i = 0;
    while (i < paramArrayOfDouble.length)
    {
      a(paramArrayOfDouble[i]);
      i += 1;
    }
    return this;
  }
  
  public gf a(float[] paramArrayOfFloat)
  {
    if (paramArrayOfFloat == null)
    {
      this.b *= this.a;
      return this;
    }
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      a(paramArrayOfFloat[i]);
      i += 1;
    }
    return this;
  }
  
  public gf a(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt == null)
    {
      this.b *= this.a;
      return this;
    }
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      a(paramArrayOfInt[i]);
      i += 1;
    }
    return this;
  }
  
  public gf a(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong == null)
    {
      this.b *= this.a;
      return this;
    }
    int i = 0;
    while (i < paramArrayOfLong.length)
    {
      a(paramArrayOfLong[i]);
      i += 1;
    }
    return this;
  }
  
  public gf a(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject == null)
    {
      this.b *= this.a;
      return this;
    }
    int i = 0;
    while (i < paramArrayOfObject.length)
    {
      a(paramArrayOfObject[i]);
      i += 1;
    }
    return this;
  }
  
  public gf a(short[] paramArrayOfShort)
  {
    if (paramArrayOfShort == null)
    {
      this.b *= this.a;
      return this;
    }
    int i = 0;
    while (i < paramArrayOfShort.length)
    {
      a(paramArrayOfShort[i]);
      i += 1;
    }
    return this;
  }
  
  public gf a(boolean[] paramArrayOfBoolean)
  {
    if (paramArrayOfBoolean == null)
    {
      this.b *= this.a;
      return this;
    }
    int i = 0;
    while (i < paramArrayOfBoolean.length)
    {
      a(paramArrayOfBoolean[i]);
      i += 1;
    }
    return this;
  }
  
  public int hashCode()
  {
    return a();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\gf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */