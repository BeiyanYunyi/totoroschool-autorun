package com.amap.api.mapcore.util;

public class dt
{
  public short[] a;
  public int b;
  public boolean c;
  
  public dt()
  {
    this(true, 16);
  }
  
  public dt(boolean paramBoolean, int paramInt)
  {
    this.c = paramBoolean;
    this.a = new short[paramInt];
  }
  
  public short a(int paramInt)
  {
    if (paramInt < this.b) {
      return this.a[paramInt];
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("index can't be >= size: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" >= ");
    localStringBuilder.append(this.b);
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public void a()
  {
    this.b = 0;
  }
  
  public void a(short paramShort)
  {
    short[] arrayOfShort2 = this.a;
    short[] arrayOfShort1 = arrayOfShort2;
    if (this.b == arrayOfShort2.length) {
      arrayOfShort1 = d(Math.max(8, (int)(this.b * 1.75F)));
    }
    int i = this.b;
    this.b = (i + 1);
    arrayOfShort1[i] = paramShort;
  }
  
  public short b(int paramInt)
  {
    if (paramInt < this.b)
    {
      localObject = this.a;
      short s = localObject[paramInt];
      this.b -= 1;
      if (this.c)
      {
        System.arraycopy(localObject, paramInt + 1, localObject, paramInt, this.b - paramInt);
        return s;
      }
      localObject[paramInt] = localObject[this.b];
      return s;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("index can't be >= size: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" >= ");
    ((StringBuilder)localObject).append(this.b);
    throw new IndexOutOfBoundsException(((StringBuilder)localObject).toString());
  }
  
  public short[] c(int paramInt)
  {
    paramInt = this.b + paramInt;
    if (paramInt > this.a.length) {
      d(Math.max(8, paramInt));
    }
    return this.a;
  }
  
  protected short[] d(int paramInt)
  {
    short[] arrayOfShort = new short[paramInt];
    System.arraycopy(this.a, 0, arrayOfShort, 0, Math.min(this.b, arrayOfShort.length));
    this.a = arrayOfShort;
    return arrayOfShort;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof dt)) {
      return false;
    }
    paramObject = (dt)paramObject;
    int j = this.b;
    if (j != ((dt)paramObject).b) {
      return false;
    }
    int i = 0;
    while (i < j)
    {
      if (this.a[i] != paramObject.a[i]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public int hashCode()
  {
    return 42;
  }
  
  public String toString()
  {
    if (this.b == 0) {
      return "[]";
    }
    short[] arrayOfShort = this.a;
    StringBuilder localStringBuilder = new StringBuilder(32);
    localStringBuilder.append('[');
    localStringBuilder.append(arrayOfShort[0]);
    int i = 1;
    while (i < this.b)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append(arrayOfShort[i]);
      i += 1;
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\dt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */