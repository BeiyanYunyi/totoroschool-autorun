package b.a.j;

import b.a.e.j.a.a;
import b.a.e.j.n;
import b.a.s;

final class b<T>
  extends c<T>
  implements a.a<Object>
{
  final c<T> a;
  boolean b;
  b.a.e.j.a<Object> c;
  volatile boolean d;
  
  b(c<T> paramc)
  {
    this.a = paramc;
  }
  
  void a()
  {
    for (;;)
    {
      try
      {
        b.a.e.j.a locala = this.c;
        if (locala == null)
        {
          this.b = false;
          return;
        }
        this.c = null;
        locala.a(this);
      }
      finally {}
    }
  }
  
  public boolean a(Object paramObject)
  {
    return n.acceptFull(paramObject, this.a);
  }
  
  public void onComplete()
  {
    if (this.d) {
      return;
    }
    try
    {
      if (this.d) {
        return;
      }
      this.d = true;
      if (this.b)
      {
        b.a.e.j.a locala2 = this.c;
        b.a.e.j.a locala1 = locala2;
        if (locala2 == null)
        {
          locala1 = new b.a.e.j.a(4);
          this.c = locala1;
        }
        locala1.a(n.complete());
        return;
      }
      this.b = true;
      this.a.onComplete();
      return;
    }
    finally {}
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (this.d)
    {
      b.a.h.a.a(paramThrowable);
      return;
    }
    try
    {
      int i;
      if (this.d)
      {
        i = 1;
      }
      else
      {
        this.d = true;
        if (this.b)
        {
          b.a.e.j.a locala2 = this.c;
          b.a.e.j.a locala1 = locala2;
          if (locala2 == null)
          {
            locala1 = new b.a.e.j.a(4);
            this.c = locala1;
          }
          locala1.b(n.error(paramThrowable));
          return;
        }
        i = 0;
        this.b = true;
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
    if (this.d) {
      return;
    }
    try
    {
      if (this.d) {
        return;
      }
      if (this.b)
      {
        b.a.e.j.a locala2 = this.c;
        b.a.e.j.a locala1 = locala2;
        if (locala2 == null)
        {
          locala1 = new b.a.e.j.a(4);
          this.c = locala1;
        }
        locala1.a(n.next(paramT));
        return;
      }
      this.b = true;
      this.a.onNext(paramT);
      a();
      return;
    }
    finally {}
  }
  
  public void onSubscribe(b.a.b.b paramb)
  {
    boolean bool = this.d;
    int i = 1;
    int j = 1;
    if (!bool) {
      try
      {
        if (this.d)
        {
          i = j;
        }
        else
        {
          if (this.b)
          {
            b.a.e.j.a locala2 = this.c;
            b.a.e.j.a locala1 = locala2;
            if (locala2 == null)
            {
              locala1 = new b.a.e.j.a(4);
              this.c = locala1;
            }
            locala1.a(n.disposable(paramb));
            return;
          }
          this.b = true;
          i = 0;
        }
      }
      finally {}
    }
    if (i != 0)
    {
      paramb.dispose();
      return;
    }
    this.a.onSubscribe(paramb);
    a();
  }
  
  protected void subscribeActual(s<? super T> params)
  {
    this.a.subscribe(params);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\j\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */