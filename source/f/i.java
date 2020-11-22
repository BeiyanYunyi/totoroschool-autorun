package f;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class i
  extends t
{
  private t a;
  
  public i(t paramt)
  {
    if (paramt != null)
    {
      this.a = paramt;
      return;
    }
    throw new IllegalArgumentException("delegate == null");
  }
  
  public final i a(t paramt)
  {
    if (paramt != null)
    {
      this.a = paramt;
      return this;
    }
    throw new IllegalArgumentException("delegate == null");
  }
  
  public final t a()
  {
    return this.a;
  }
  
  public t a(long paramLong)
  {
    return this.a.a(paramLong);
  }
  
  public t a(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.a.a(paramLong, paramTimeUnit);
  }
  
  public long d()
  {
    return this.a.d();
  }
  
  public t f()
  {
    return this.a.f();
  }
  
  public void g()
    throws IOException
  {
    this.a.g();
  }
  
  public boolean n_()
  {
    return this.a.n_();
  }
  
  public t o_()
  {
    return this.a.o_();
  }
  
  public long p_()
  {
    return this.a.p_();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\f\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */