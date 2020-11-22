package com.loc;

public final class au
{
  protected String a;
  String b;
  String c;
  String d;
  String e;
  int f;
  int g;
  private String h;
  private boolean i = false;
  private boolean j = false;
  private boolean k = true;
  
  public au(String paramString1, String paramString2, boolean paramBoolean)
  {
    this(paramString1, paramString2, paramBoolean, (byte)0);
  }
  
  private au(String paramString1, String paramString2, boolean paramBoolean, byte paramByte)
  {
    this.a = paramString1;
    this.h = paramString2;
    this.i = false;
    this.k = paramBoolean;
    try
    {
      paramString1 = paramString1.split("/");
      paramByte = paramString1.length;
      if (paramByte <= 1) {
        return;
      }
      this.b = paramString1[(paramByte - 1)];
      paramString1 = this.b.split("_");
      this.c = paramString1[0];
      this.d = paramString1[2];
      this.e = paramString1[1];
      this.f = Integer.parseInt(paramString1[3]);
      this.g = Integer.parseInt(paramString1[4].split("\\.")[0]);
      return;
    }
    catch (Throwable paramString1)
    {
      ag.a(paramString1, "DexDownloadItem", "DexDownloadItem");
    }
  }
  
  final String a()
  {
    return this.a;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public final String b()
  {
    return this.h;
  }
  
  public final boolean c()
  {
    return this.i;
  }
  
  public final boolean d()
  {
    return this.j;
  }
  
  public final boolean e()
  {
    return this.k;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */