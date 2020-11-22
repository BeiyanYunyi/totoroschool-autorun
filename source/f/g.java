package f;

import java.io.IOException;

public abstract class g
  implements r
{
  private final r a;
  
  public g(r paramr)
  {
    if (paramr != null)
    {
      this.a = paramr;
      return;
    }
    throw new IllegalArgumentException("delegate == null");
  }
  
  public void a(c paramc, long paramLong)
    throws IOException
  {
    this.a.a(paramc, paramLong);
  }
  
  public void close()
    throws IOException
  {
    this.a.close();
  }
  
  public void flush()
    throws IOException
  {
    this.a.flush();
  }
  
  public t timeout()
  {
    return this.a.timeout();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("(");
    localStringBuilder.append(this.a.toString());
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\f\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */