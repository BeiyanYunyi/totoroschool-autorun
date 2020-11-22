package com.google.zxing.oned.rss;

public final class RSSUtils
{
  private static int combins(int paramInt1, int paramInt2)
  {
    int k = paramInt1 - paramInt2;
    int i = k;
    int j = paramInt2;
    if (k > paramInt2)
    {
      j = k;
      i = paramInt2;
    }
    paramInt2 = 1;
    int m = 1;
    k = paramInt1;
    int n;
    for (paramInt1 = m;; paramInt1 = m)
    {
      m = paramInt2;
      n = paramInt1;
      if (k <= j) {
        break;
      }
      n = paramInt2 * k;
      paramInt2 = n;
      m = paramInt1;
      if (paramInt1 <= i)
      {
        paramInt2 = n / paramInt1;
        m = paramInt1 + 1;
      }
      k -= 1;
    }
    while (n <= i)
    {
      m /= n;
      n += 1;
    }
    return m;
  }
  
  public static int getRSSvalue(int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
  {
    int[] arrayOfInt = paramArrayOfInt;
    int i4 = arrayOfInt.length;
    int k = arrayOfInt.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      i += arrayOfInt[j];
      j += 1;
    }
    int n = 0;
    j = 0;
    int i1 = 0;
    int m = i;
    i = j;
    for (;;)
    {
      int i5 = i4 - 1;
      if (n >= i5) {
        break;
      }
      int i6 = 1 << n;
      i |= i6;
      int i2 = 1;
      while (i2 < paramArrayOfInt[n])
      {
        int i7 = m - i2;
        int i8 = i4 - n;
        int i3 = i8 - 2;
        k = combins(i7 - 1, i3);
        j = k;
        if (paramBoolean)
        {
          j = k;
          if (i == 0)
          {
            int i9 = i8 - 1;
            j = k;
            if (i7 - i9 >= i9) {
              j = k - combins(i7 - i8, i3);
            }
          }
        }
        if (i8 - 1 > 1)
        {
          k = i7 - i3;
          i3 = 0;
          while (k > paramInt)
          {
            i3 += combins(i7 - k - 1, i8 - 3);
            k -= 1;
          }
          k = j - i3 * (i5 - n);
        }
        else
        {
          k = j;
          if (i7 > paramInt) {
            k = j - 1;
          }
        }
        i1 += k;
        i2 += 1;
        i &= (i6 ^ 0xFFFFFFFF);
      }
      m -= i2;
      n += 1;
    }
    return i1;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\zxing\oned\rss\RSSUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */