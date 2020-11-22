package com.amap.api.mapcore.util;

import java.util.Locale;
import java.util.Random;

public class dp
{
  private static String a = "0123456789";
  
  public static String a()
  {
    Object localObject1 = new Random();
    int i = ((Random)localObject1).nextInt(10);
    Object localObject2 = String.format(Locale.US, "%05d", new Object[] { Integer.valueOf(i) });
    i = ((Random)localObject1).nextInt(10);
    int j = ((Random)localObject1).nextInt(100);
    localObject1 = new a(a, j).a(i, (String)localObject2);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(String.format(Locale.US, "%01d", new Object[] { Integer.valueOf(i) }));
    ((StringBuilder)localObject2).append(String.format(Locale.US, "%02d", new Object[] { Integer.valueOf(j) }));
    return ((StringBuilder)localObject2).toString();
  }
  
  static class a
  {
    private String a;
    private int b = 1103515245;
    private int c = 12345;
    
    public a()
    {
      this(11);
    }
    
    public a(int paramInt)
    {
      this("ABCDEFGHIJKLMNOPQRSTUVWXYZ", paramInt);
    }
    
    public a(String paramString, int paramInt)
    {
      this.a = a(paramString, paramInt, paramString.length());
    }
    
    public char a(int paramInt, boolean paramBoolean)
    {
      int j = this.a.length();
      int i = paramInt;
      if (paramBoolean) {
        i = j - paramInt;
      }
      return this.a.charAt(i);
    }
    
    public int a(char paramChar, boolean paramBoolean)
    {
      int i = this.a.length();
      char c1 = this.a.indexOf(paramChar);
      paramChar = c1;
      if (paramBoolean) {
        paramChar = i - c1;
      }
      return paramChar;
    }
    
    public int a(int paramInt)
    {
      return (int)(paramInt * this.b + this.c & 0x7FFFFFFF);
    }
    
    public String a(int paramInt, String paramString)
    {
      return a(false, paramInt, paramString);
    }
    
    public String a(String paramString, int paramInt1, int paramInt2)
    {
      StringBuffer localStringBuffer = new StringBuffer(paramString);
      int k = paramString.length();
      int j = 0;
      int i = paramInt1;
      paramInt1 = j;
      while (paramInt1 < paramInt2)
      {
        i = a(i);
        j = i % k;
        i = a(i);
        int m = i % k;
        char c1 = localStringBuffer.charAt(j);
        localStringBuffer.setCharAt(j, localStringBuffer.charAt(m));
        localStringBuffer.setCharAt(m, c1);
        paramInt1 += 1;
      }
      return localStringBuffer.toString();
    }
    
    public String a(boolean paramBoolean, int paramInt, String paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int j = this.a.length();
      int k = paramString.length();
      int i = 0;
      while (i < k)
      {
        int m = a(paramString.charAt(i), paramBoolean);
        if (m < 0) {
          break;
        }
        localStringBuilder.append(a((m + paramInt + i) % j, paramBoolean));
        i += 1;
      }
      if (localStringBuilder.length() == k) {
        return localStringBuilder.toString();
      }
      return null;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\dp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */