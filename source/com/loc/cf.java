package com.loc;

import java.io.File;

public final class cf
  extends cj
{
  private int b;
  private String c;
  
  public cf(int paramInt, String paramString, cj paramcj)
  {
    super(paramcj);
    this.b = paramInt;
    this.c = paramString;
  }
  
  private static int a(String paramString)
  {
    try
    {
      paramString = new File(paramString);
      if (!paramString.exists()) {
        return 0;
      }
      int i = paramString.list().length;
      return i;
    }
    catch (Throwable paramString)
    {
      aj.b(paramString, "fus", "gfn");
    }
    return 0;
  }
  
  protected final boolean a()
  {
    return a(this.c) >= this.b;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\cf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */