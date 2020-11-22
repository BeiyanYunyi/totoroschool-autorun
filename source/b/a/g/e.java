package b.a.g;

import b.a.b.b;
import b.a.e.a.d;
import b.a.e.j.n;
import b.a.s;

public final class e<T>
  implements b, s<T>
{
  final s<? super T> a;
  final boolean b;
  b c;
  boolean d;
  b.a.e.j.a<Object> e;
  volatile boolean f;
  
  public e(s<? super T> params)
  {
    this(params, false);
  }
  
  public e(s<? super T> params, boolean paramBoolean)
  {
    this.a = params;
    this.b = paramBoolean;
  }
  
  void a()
  {
    for (;;)
    {
      try
      {
        b.a.e.j.a locala = this.e;
        if (locala == null)
        {
          this.d = false;
          return;
        }
        this.e = null;
        if (!locala.a(this.a)) {
          continue;
        }
        return;
      }
      finally {}
    }
  }
  
  public void dispose()
  {
    this.c.dispose();
  }
  
  public boolean isDisposed()
  {
    return this.c.isDisposed();
  }
  
  public void onComplete()
  {
    if (this.f) {
      return;
    }
    try
    {
      if (this.f) {
        return;
      }
      if (this.d)
      {
        b.a.e.j.a locala2 = this.e;
        b.a.e.j.a locala1 = locala2;
        if (locala2 == null)
        {
          locala1 = new b.a.e.j.a(4);
          this.e = locala1;
        }
        locala1.a(n.complete());
        return;
      }
      this.f = true;
      this.d = true;
      this.a.onComplete();
      return;
    }
    finally {}
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (this.f)
    {
      b.a.h.a.a(paramThrowable);
      return;
    }
    try
    {
      boolean bool = this.f;
      int i = 1;
      if (!bool)
      {
        if (this.d)
        {
          this.f = true;
          b.a.e.j.a locala2 = this.e;
          b.a.e.j.a locala1 = locala2;
          if (locala2 == null)
          {
            locala1 = new b.a.e.j.a(4);
            this.e = locala1;
          }
          paramThrowable = n.error(paramThrowable);
          if (this.b) {
            locala1.a(paramThrowable);
          } else {
            locala1.b(paramThrowable);
          }
          return;
        }
        this.f = true;
        this.d = true;
        i = 0;
      }
      if (i != 0)
      {
        b.a.h.a.a(paramThrowable);
        return;
      }
      this.a.onError(paramThrowable);
      return;
    }
    finally {}
  }
  
  public void onNext(T paramT)
  {
    if (this.f) {
      return;
    }
    if (paramT == null)
    {
      this.c.dispose();
      onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
      return;
    }
    try
    {
      if (this.f) {
        return;
      }
      if (this.d)
      {
        b.a.e.j.a locala2 = this.e;
        b.a.e.j.a locala1 = locala2;
        if (locala2 == null)
        {
          locala1 = new b.a.e.j.a(4);
          this.e = locala1;
        }
        locala1.a(n.next(paramT));
        return;
      }
      this.d = true;
      this.a.onNext(paramT);
      a();
      return;
    }
    finally {}
  }
  
  public void onSubscribe(b paramb)
  {
    if (d.validate(this.c, paramb))
    {
      this.c = paramb;
      this.a.onSubscribe(this);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\g\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */