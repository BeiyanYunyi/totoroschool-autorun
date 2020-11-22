package f;

import java.io.IOException;

public abstract class h
  implements s
{
  private final s delegate;
  
  public h(s params)
  {
    if (params != null)
    {
      this.delegate = params;
      return;
    }
    throw new IllegalArgumentException("delegate == null");
  }
  
  public void close()
    throws IOException
  {
    this.delegate.close();
  }
  
  public final s delegate()
  {
    return this.delegate;
  }
  
  public long read(c paramc, long paramLong)
    throws IOException
  {
    return this.delegate.read(paramc, paramLong);
  }
  
  public t timeout()
  {
    return this.delegate.timeout();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("(");
    localStringBuilder.append(this.delegate.toString());
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\f\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */