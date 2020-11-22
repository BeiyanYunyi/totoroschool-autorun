package com.amap.api.mapcore.util;

public class di
{
  public int[] a;
  public int b;
  public boolean c;
  
  public di()
  {
    this(true, 16);
  }
  
  public di(boolean paramBoolean, int paramInt)
  {
    this.c = paramBoolean;
    this.a = new int[paramInt];
  }
  
  public void a()
  {
    this.b = 0;
  }
  
  public void a(int paramInt)
  {
    int[] arrayOfInt2 = this.a;
    int[] arrayOfInt1 = arrayOfInt2;
    if (this.b == arrayOfInt2.length) {
      arrayOfInt1 = d(Math.max(8, (int)(this.b * 1.75F)));
    }
    int i = this.b;
    this.b = (i + 1);
    arrayOfInt1[i] = paramInt;
  }
  
  public int b(int paramInt)
  {
    if (paramInt < this.b)
    {
      localObject = this.a;
      int i = localObject[paramInt];
      this.b -= 1;
      if (this.c)
      {
        System.arraycopy(localObject, paramInt + 1, localObject, paramInt, this.b - paramInt);
        return i;
      }
      localObject[paramInt] = localObject[this.b];
      return i;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("index can't be >= size: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" >= ");
    ((StringBuilder)localObject).append(this.b);
    throw new IndexOutOfBoundsException(((StringBuilder)localObject).toString());
  }
  
  public int[] c(int paramInt)
  {
    paramInt = this.b + paramInt;
    if (paramInt > this.a.length) {
      d(Math.max(8, paramInt));
    }
    return this.a;
  }
  
  protected int[] d(int paramInt)
  {
    int[] arrayOfInt = new int[paramInt];
    System.arraycopy(this.a, 0, arrayOfInt, 0, Math.min(this.b, arrayOfInt.length));
    this.a = arrayOfInt;
    return arrayOfInt;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof di)) {
      return false;
    }
    paramObject = (di)paramObject;
    int j = this.b;
    if (j != ((di)paramObject).b) {
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
    int[] arrayOfInt = this.a;
    StringBuilder localStringBuilder = new StringBuilder(32);
    localStringBuilder.append('[');
    localStringBuilder.append(arrayOfInt[0]);
    int i = 1;
    while (i < this.b)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append(arrayOfInt[i]);
      i += 1;
    }
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\di.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */