package com.amap.api.mapcore.util;

public abstract class bj
  implements bn
{
  protected int a;
  protected az b;
  
  public bj(int paramInt, az paramaz)
  {
    this.a = paramInt;
    this.b = paramaz;
  }
  
  public void a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Wrong call delete()  State: ");
    localStringBuilder.append(b());
    localStringBuilder.append("  ");
    localStringBuilder.append(getClass());
    bc.a(localStringBuilder.toString());
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Wrong call fail()  State: ");
    localStringBuilder.append(b());
    localStringBuilder.append("  ");
    localStringBuilder.append(getClass());
    bc.a(localStringBuilder.toString());
  }
  
  public boolean a(bj parambj)
  {
    return parambj.b() == b();
  }
  
  public int b()
  {
    return this.a;
  }
  
  public void b(bj parambj)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b());
    localStringBuilder.append(" ==> ");
    localStringBuilder.append(parambj.b());
    localStringBuilder.append("   ");
    localStringBuilder.append(getClass());
    localStringBuilder.append("==>");
    localStringBuilder.append(parambj.getClass());
    bc.a(localStringBuilder.toString());
  }
  
  public void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Wrong call start()  State: ");
    localStringBuilder.append(b());
    localStringBuilder.append("  ");
    localStringBuilder.append(getClass());
    bc.a(localStringBuilder.toString());
  }
  
  public void d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Wrong call continueDownload()  State: ");
    localStringBuilder.append(b());
    localStringBuilder.append("  ");
    localStringBuilder.append(getClass());
    bc.a(localStringBuilder.toString());
  }
  
  public void e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Wrong call pause()  State: ");
    localStringBuilder.append(b());
    localStringBuilder.append("  ");
    localStringBuilder.append(getClass());
    bc.a(localStringBuilder.toString());
  }
  
  public void f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Wrong call hasNew()  State: ");
    localStringBuilder.append(b());
    localStringBuilder.append("  ");
    localStringBuilder.append(getClass());
    bc.a(localStringBuilder.toString());
  }
  
  public void g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Wrong call complete()  State: ");
    localStringBuilder.append(b());
    localStringBuilder.append("  ");
    localStringBuilder.append(getClass());
    bc.a(localStringBuilder.toString());
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */