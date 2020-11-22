package e;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import javax.annotation.Nullable;

public final class ae
{
  final a a;
  final Proxy b;
  final InetSocketAddress c;
  
  public ae(a parama, Proxy paramProxy, InetSocketAddress paramInetSocketAddress)
  {
    if (parama != null)
    {
      if (paramProxy != null)
      {
        if (paramInetSocketAddress != null)
        {
          this.a = parama;
          this.b = paramProxy;
          this.c = paramInetSocketAddress;
          return;
        }
        throw new NullPointerException("inetSocketAddress == null");
      }
      throw new NullPointerException("proxy == null");
    }
    throw new NullPointerException("address == null");
  }
  
  public a a()
  {
    return this.a;
  }
  
  public Proxy b()
  {
    return this.b;
  }
  
  public InetSocketAddress c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    return (this.a.i != null) && (this.b.type() == Proxy.Type.HTTP);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof ae))
    {
      paramObject = (ae)paramObject;
      if ((((ae)paramObject).a.equals(this.a)) && (((ae)paramObject).b.equals(this.b)) && (((ae)paramObject).c.equals(this.c))) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return ((527 + this.a.hashCode()) * 31 + this.b.hashCode()) * 31 + this.c.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Route{");
    localStringBuilder.append(this.c);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */