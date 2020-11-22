package com.bumptech.glide.load.c;

import com.bumptech.glide.h.e;
import com.bumptech.glide.h.h;
import java.util.Queue;

public class k<A, B>
{
  private final e<a<A>, B> a;
  
  public k()
  {
    this(250);
  }
  
  public k(int paramInt)
  {
    this.a = new e(paramInt)
    {
      protected void a(k.a<A> paramAnonymousa, B paramAnonymousB)
      {
        paramAnonymousa.a();
      }
    };
  }
  
  public B a(A paramA, int paramInt1, int paramInt2)
  {
    paramA = a.a(paramA, paramInt1, paramInt2);
    Object localObject = this.a.b(paramA);
    paramA.a();
    return (B)localObject;
  }
  
  public void a(A paramA, int paramInt1, int paramInt2, B paramB)
  {
    paramA = a.a(paramA, paramInt1, paramInt2);
    this.a.b(paramA, paramB);
  }
  
  static final class a<A>
  {
    private static final Queue<a<?>> a = h.a(0);
    private int b;
    private int c;
    private A d;
    
    static <A> a<A> a(A paramA, int paramInt1, int paramInt2)
    {
      a locala2 = (a)a.poll();
      a locala1 = locala2;
      if (locala2 == null) {
        locala1 = new a();
      }
      locala1.b(paramA, paramInt1, paramInt2);
      return locala1;
    }
    
    private void b(A paramA, int paramInt1, int paramInt2)
    {
      this.d = paramA;
      this.c = paramInt1;
      this.b = paramInt2;
    }
    
    public void a()
    {
      a.offer(this);
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool1 = paramObject instanceof a;
      boolean bool2 = false;
      if (bool1)
      {
        paramObject = (a)paramObject;
        bool1 = bool2;
        if (this.c == ((a)paramObject).c)
        {
          bool1 = bool2;
          if (this.b == ((a)paramObject).b)
          {
            bool1 = bool2;
            if (this.d.equals(((a)paramObject).d)) {
              bool1 = true;
            }
          }
        }
        return bool1;
      }
      return false;
    }
    
    public int hashCode()
    {
      return (this.b * 31 + this.c) * 31 + this.d.hashCode();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\c\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */