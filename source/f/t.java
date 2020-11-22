package f;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class t
{
  public static final t c = new t()
  {
    public t a(long paramAnonymousLong)
    {
      return this;
    }
    
    public t a(long paramAnonymousLong, TimeUnit paramAnonymousTimeUnit)
    {
      return this;
    }
    
    public void g()
      throws IOException
    {}
  };
  private boolean a;
  private long b;
  private long d;
  
  public t a(long paramLong)
  {
    this.a = true;
    this.b = paramLong;
    return this;
  }
  
  public t a(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong >= 0L)
    {
      if (paramTimeUnit != null)
      {
        this.d = paramTimeUnit.toNanos(paramLong);
        return this;
      }
      throw new IllegalArgumentException("unit == null");
    }
    paramTimeUnit = new StringBuilder();
    paramTimeUnit.append("timeout < 0: ");
    paramTimeUnit.append(paramLong);
    throw new IllegalArgumentException(paramTimeUnit.toString());
  }
  
  public long d()
  {
    if (this.a) {
      return this.b;
    }
    throw new IllegalStateException("No deadline");
  }
  
  public t f()
  {
    this.a = false;
    return this;
  }
  
  public void g()
    throws IOException
  {
    if (!Thread.interrupted())
    {
      if (this.a)
      {
        if (this.b - System.nanoTime() > 0L) {
          return;
        }
        throw new InterruptedIOException("deadline reached");
      }
      return;
    }
    Thread.currentThread().interrupt();
    throw new InterruptedIOException("interrupted");
  }
  
  public boolean n_()
  {
    return this.a;
  }
  
  public t o_()
  {
    this.d = 0L;
    return this;
  }
  
  public long p_()
  {
    return this.d;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\f\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */