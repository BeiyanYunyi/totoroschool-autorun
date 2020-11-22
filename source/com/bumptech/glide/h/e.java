package com.bumptech.glide.h;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public class e<T, Y>
{
  private final LinkedHashMap<T, Y> a = new LinkedHashMap(100, 0.75F, true);
  private int b;
  private final int c;
  private int d = 0;
  
  public e(int paramInt)
  {
    this.c = paramInt;
    this.b = paramInt;
  }
  
  private void c()
  {
    b(this.b);
  }
  
  protected int a(Y paramY)
  {
    return 1;
  }
  
  public void a()
  {
    b(0);
  }
  
  protected void a(T paramT, Y paramY) {}
  
  public int b()
  {
    return this.d;
  }
  
  public Y b(T paramT)
  {
    return (Y)this.a.get(paramT);
  }
  
  public Y b(T paramT, Y paramY)
  {
    if (a(paramY) >= this.b)
    {
      a(paramT, paramY);
      return null;
    }
    paramT = this.a.put(paramT, paramY);
    if (paramY != null) {
      this.d += a(paramY);
    }
    if (paramT != null) {
      this.d -= a(paramT);
    }
    c();
    return paramT;
  }
  
  protected void b(int paramInt)
  {
    while (this.d > paramInt)
    {
      Object localObject2 = (Map.Entry)this.a.entrySet().iterator().next();
      Object localObject1 = ((Map.Entry)localObject2).getValue();
      this.d -= a(localObject1);
      localObject2 = ((Map.Entry)localObject2).getKey();
      this.a.remove(localObject2);
      a(localObject2, localObject1);
    }
  }
  
  public Y c(T paramT)
  {
    paramT = this.a.remove(paramT);
    if (paramT != null) {
      this.d -= a(paramT);
    }
    return paramT;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\h\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */