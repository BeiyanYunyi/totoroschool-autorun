package e.a.a;

import e.a.f.a;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

public final class d
  implements Closeable, Flushable
{
  static final Pattern a = Pattern.compile("[a-z0-9_-]{1,120}");
  final a b;
  final int c;
  f.d d;
  final LinkedHashMap<String, b> e;
  int f;
  boolean g;
  boolean h;
  boolean i;
  private long k;
  private long l;
  private long m;
  private final Executor n;
  private final Runnable o;
  
  private void d()
  {
    try
    {
      boolean bool = b();
      if (!bool) {
        return;
      }
      throw new IllegalStateException("cache is closed");
    }
    finally {}
  }
  
  void a(a parama, boolean paramBoolean)
    throws IOException
  {
    for (;;)
    {
      int i2;
      try
      {
        b localb = parama.a;
        if (localb.f == parama)
        {
          int i3 = 0;
          i2 = i3;
          if (paramBoolean)
          {
            i2 = i3;
            if (!localb.e)
            {
              int i1 = 0;
              i2 = i3;
              if (i1 < this.c)
              {
                if (parama.b[i1] != 0)
                {
                  if (!this.b.b(localb.d[i1]))
                  {
                    parama.b();
                    return;
                  }
                  i1 += 1;
                  continue;
                }
                parama.b();
                parama = new StringBuilder();
                parama.append("Newly created entry didn't create value for index ");
                parama.append(i1);
                throw new IllegalStateException(parama.toString());
              }
            }
          }
          long l1;
          if (i2 < this.c)
          {
            parama = localb.d[i2];
            if (paramBoolean)
            {
              if (this.b.b(parama))
              {
                File localFile = localb.c[i2];
                this.b.a(parama, localFile);
                l1 = localb.b[i2];
                long l2 = this.b.c(localFile);
                localb.b[i2] = l2;
                this.l = (this.l - l1 + l2);
              }
            }
            else {
              this.b.a(parama);
            }
          }
          else
          {
            this.f += 1;
            localb.f = null;
            if ((localb.e | paramBoolean))
            {
              localb.e = true;
              this.d.b("CLEAN").i(32);
              this.d.b(localb.a);
              localb.a(this.d);
              this.d.i(10);
              if (paramBoolean)
              {
                l1 = this.m;
                this.m = (1L + l1);
                localb.g = l1;
              }
            }
            else
            {
              this.e.remove(localb.a);
              this.d.b("REMOVE").i(32);
              this.d.b(localb.a);
              this.d.i(10);
            }
            this.d.flush();
            if ((this.l > this.k) || (a())) {
              this.n.execute(this.o);
            }
          }
        }
        else
        {
          throw new IllegalStateException();
        }
      }
      finally {}
      i2 += 1;
    }
  }
  
  boolean a()
  {
    return (this.f >= 2000) && (this.f >= this.e.size());
  }
  
  boolean a(b paramb)
    throws IOException
  {
    if (paramb.f != null) {
      paramb.f.a();
    }
    int i1 = 0;
    while (i1 < this.c)
    {
      this.b.a(paramb.c[i1]);
      this.l -= paramb.b[i1];
      paramb.b[i1] = 0L;
      i1 += 1;
    }
    this.f += 1;
    this.d.b("REMOVE").i(32).b(paramb.a).i(10);
    this.e.remove(paramb.a);
    if (a()) {
      this.n.execute(this.o);
    }
    return true;
  }
  
  public boolean b()
  {
    try
    {
      boolean bool = this.h;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  void c()
    throws IOException
  {
    while (this.l > this.k) {
      a((b)this.e.values().iterator().next());
    }
    this.i = false;
  }
  
  public void close()
    throws IOException
  {
    for (;;)
    {
      int i1;
      try
      {
        if ((this.g) && (!this.h))
        {
          b[] arrayOfb = (b[])this.e.values().toArray(new b[this.e.size()]);
          int i2 = arrayOfb.length;
          i1 = 0;
          if (i1 < i2)
          {
            b localb = arrayOfb[i1];
            if (localb.f != null) {
              localb.f.b();
            }
          }
          else
          {
            c();
            this.d.close();
            this.d = null;
            this.h = true;
          }
        }
        else
        {
          this.h = true;
          return;
        }
      }
      finally {}
      i1 += 1;
    }
  }
  
  public void flush()
    throws IOException
  {
    try
    {
      boolean bool = this.g;
      if (!bool) {
        return;
      }
      d();
      c();
      this.d.flush();
      return;
    }
    finally {}
  }
  
  public final class a
  {
    final d.b a;
    final boolean[] b;
    private boolean d;
    
    void a()
    {
      int i;
      if (this.a.f == this) {
        i = 0;
      }
      for (;;)
      {
        if (i < this.c.c) {}
        try
        {
          this.c.b.a(this.a.d[i]);
          i += 1;
          continue;
          this.a.f = null;
          return;
        }
        catch (IOException localIOException)
        {
          for (;;) {}
        }
      }
    }
    
    public void b()
      throws IOException
    {
      synchronized (this.c)
      {
        if (!this.d)
        {
          if (this.a.f == this) {
            this.c.a(this, false);
          }
          this.d = true;
          return;
        }
        throw new IllegalStateException();
      }
    }
  }
  
  private final class b
  {
    final String a;
    final long[] b;
    final File[] c;
    final File[] d;
    boolean e;
    d.a f;
    long g;
    
    void a(f.d paramd)
      throws IOException
    {
      long[] arrayOfLong = this.b;
      int j = arrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        long l = arrayOfLong[i];
        paramd.i(32).m(l);
        i += 1;
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */