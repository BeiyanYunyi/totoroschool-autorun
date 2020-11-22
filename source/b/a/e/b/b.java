package b.a.e.b;

import b.a.d.d;

public final class b
{
  static final d<Object, Object> a = new a();
  
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return -1;
    }
    if (paramInt1 > paramInt2) {
      return 1;
    }
    return 0;
  }
  
  public static int a(int paramInt, String paramString)
  {
    if (paramInt > 0) {
      return paramInt;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" > 0 required but it was ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static int a(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2) {
      return -1;
    }
    if (paramLong1 > paramLong2) {
      return 1;
    }
    return 0;
  }
  
  public static long a(long paramLong, String paramString)
  {
    if (paramLong > 0L) {
      return paramLong;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" > 0 required but it was ");
    localStringBuilder.append(paramLong);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public static <T> d<T, T> a()
  {
    return a;
  }
  
  public static <T> T a(T paramT, String paramString)
  {
    if (paramT != null) {
      return paramT;
    }
    throw new NullPointerException(paramString);
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  static final class a
    implements d<Object, Object>
  {
    public boolean a(Object paramObject1, Object paramObject2)
    {
      return b.a(paramObject1, paramObject2);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */