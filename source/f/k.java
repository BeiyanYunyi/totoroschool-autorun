package f;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class k
  implements s
{
  private final e a;
  private final Inflater b;
  private int c;
  private boolean d;
  
  k(e parame, Inflater paramInflater)
  {
    if (parame != null)
    {
      if (paramInflater != null)
      {
        this.a = parame;
        this.b = paramInflater;
        return;
      }
      throw new IllegalArgumentException("inflater == null");
    }
    throw new IllegalArgumentException("source == null");
  }
  
  private void b()
    throws IOException
  {
    if (this.c == 0) {
      return;
    }
    int i = this.c - this.b.getRemaining();
    this.c -= i;
    this.a.i(i);
  }
  
  public final boolean a()
    throws IOException
  {
    if (!this.b.needsInput()) {
      return false;
    }
    b();
    if (this.b.getRemaining() == 0)
    {
      if (this.a.e()) {
        return true;
      }
      o localo = this.a.b().a;
      this.c = (localo.c - localo.b);
      this.b.setInput(localo.a, localo.b, this.c);
      return false;
    }
    throw new IllegalStateException("?");
  }
  
  public void close()
    throws IOException
  {
    if (this.d) {
      return;
    }
    this.b.end();
    this.d = true;
    this.a.close();
  }
  
  public long read(c paramc, long paramLong)
    throws IOException
  {
    if (paramLong >= 0L) {
      if (!this.d) {
        if (paramLong == 0L) {
          return 0L;
        }
      }
    }
    for (;;)
    {
      boolean bool = a();
      label144:
      do
      {
        try
        {
          o localo = paramc.e(1);
          int i = (int)Math.min(paramLong, 8192 - localo.c);
          i = this.b.inflate(localo.a, localo.c, i);
          if (i > 0)
          {
            localo.c += i;
            paramLong = paramc.b;
            long l = i;
            paramc.b = (paramLong + l);
            return l;
          }
          if (!this.b.finished())
          {
            if (!this.b.needsDictionary()) {
              continue;
            }
            break label144;
            throw new EOFException("source exhausted prematurely");
          }
          b();
          if (localo.b == localo.c)
          {
            paramc.a = localo.b();
            p.a(localo);
          }
          return -1L;
        }
        catch (DataFormatException paramc)
        {
          throw new IOException(paramc);
        }
        throw new IllegalStateException("closed");
        paramc = new StringBuilder();
        paramc.append("byteCount < 0: ");
        paramc.append(paramLong);
        throw new IllegalArgumentException(paramc.toString());
      } while (bool);
    }
  }
  
  public t timeout()
  {
    return this.a.timeout();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\f\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */