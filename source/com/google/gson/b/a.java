package com.google.gson.b;

public final class a
{
  public static <T> T a(T paramT)
  {
    if (paramT != null) {
      return paramT;
    }
    throw new NullPointerException();
  }
  
  public static void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return;
    }
    throw new IllegalArgumentException();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\gson\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */