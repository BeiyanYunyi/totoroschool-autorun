package e.a.b;

import e.a;
import e.a.c;
import e.ae;
import e.e;
import e.o;
import e.p;
import e.t;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public final class f
{
  private final a a;
  private final d b;
  private final e c;
  private final p d;
  private List<Proxy> e = Collections.emptyList();
  private int f;
  private List<InetSocketAddress> g = Collections.emptyList();
  private final List<ae> h = new ArrayList();
  
  public f(a parama, d paramd, e parame, p paramp)
  {
    this.a = parama;
    this.b = paramd;
    this.c = parame;
    this.d = paramp;
    a(parama.a(), parama.h());
  }
  
  static String a(InetSocketAddress paramInetSocketAddress)
  {
    InetAddress localInetAddress = paramInetSocketAddress.getAddress();
    if (localInetAddress == null) {
      return paramInetSocketAddress.getHostName();
    }
    return localInetAddress.getHostAddress();
  }
  
  private void a(t paramt, Proxy paramProxy)
  {
    if (paramProxy != null)
    {
      this.e = Collections.singletonList(paramProxy);
    }
    else
    {
      paramt = this.a.g().select(paramt.a());
      if ((paramt != null) && (!paramt.isEmpty())) {
        paramt = c.a(paramt);
      } else {
        paramt = c.a(new Proxy[] { Proxy.NO_PROXY });
      }
      this.e = paramt;
    }
    this.f = 0;
  }
  
  private void a(Proxy paramProxy)
    throws IOException
  {
    this.g = new ArrayList();
    Object localObject;
    int i;
    if ((paramProxy.type() != Proxy.Type.DIRECT) && (paramProxy.type() != Proxy.Type.SOCKS))
    {
      localObject = paramProxy.address();
      if ((localObject instanceof InetSocketAddress))
      {
        InetSocketAddress localInetSocketAddress = (InetSocketAddress)localObject;
        localObject = a(localInetSocketAddress);
        i = localInetSocketAddress.getPort();
      }
      else
      {
        paramProxy = new StringBuilder();
        paramProxy.append("Proxy.address() is not an InetSocketAddress: ");
        paramProxy.append(localObject.getClass());
        throw new IllegalArgumentException(paramProxy.toString());
      }
    }
    else
    {
      localObject = this.a.a().f();
      i = this.a.a().g();
    }
    if ((i >= 1) && (i <= 65535))
    {
      if (paramProxy.type() == Proxy.Type.SOCKS)
      {
        this.g.add(InetSocketAddress.createUnresolved((String)localObject, i));
        return;
      }
      this.d.a(this.c, (String)localObject);
      paramProxy = this.a.b().a((String)localObject);
      if (!paramProxy.isEmpty())
      {
        this.d.a(this.c, (String)localObject, paramProxy);
        int j = 0;
        int k = paramProxy.size();
        while (j < k)
        {
          localObject = (InetAddress)paramProxy.get(j);
          this.g.add(new InetSocketAddress((InetAddress)localObject, i));
          j += 1;
        }
        return;
      }
      paramProxy = new StringBuilder();
      paramProxy.append(this.a.b());
      paramProxy.append(" returned no addresses for ");
      paramProxy.append((String)localObject);
      throw new UnknownHostException(paramProxy.toString());
    }
    paramProxy = new StringBuilder();
    paramProxy.append("No route to ");
    paramProxy.append((String)localObject);
    paramProxy.append(":");
    paramProxy.append(i);
    paramProxy.append("; port is out of range");
    throw new SocketException(paramProxy.toString());
  }
  
  private boolean c()
  {
    return this.f < this.e.size();
  }
  
  private Proxy d()
    throws IOException
  {
    if (c())
    {
      localObject = this.e;
      int i = this.f;
      this.f = (i + 1);
      localObject = (Proxy)((List)localObject).get(i);
      a((Proxy)localObject);
      return (Proxy)localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("No route to ");
    ((StringBuilder)localObject).append(this.a.a().f());
    ((StringBuilder)localObject).append("; exhausted proxy configurations: ");
    ((StringBuilder)localObject).append(this.e);
    throw new SocketException(((StringBuilder)localObject).toString());
  }
  
  public void a(ae paramae, IOException paramIOException)
  {
    if ((paramae.b().type() != Proxy.Type.DIRECT) && (this.a.g() != null)) {
      this.a.g().connectFailed(this.a.a().a(), paramae.b().address(), paramIOException);
    }
    this.b.a(paramae);
  }
  
  public boolean a()
  {
    return (c()) || (!this.h.isEmpty());
  }
  
  public a b()
    throws IOException
  {
    if (a())
    {
      ArrayList localArrayList = new ArrayList();
      do
      {
        if (!c()) {
          break;
        }
        Proxy localProxy = d();
        int i = 0;
        int j = this.g.size();
        while (i < j)
        {
          ae localae = new ae(this.a, localProxy, (InetSocketAddress)this.g.get(i));
          if (this.b.c(localae)) {
            this.h.add(localae);
          } else {
            localArrayList.add(localae);
          }
          i += 1;
        }
      } while (localArrayList.isEmpty());
      if (localArrayList.isEmpty())
      {
        localArrayList.addAll(this.h);
        this.h.clear();
      }
      return new a(localArrayList);
    }
    throw new NoSuchElementException();
  }
  
  public static final class a
  {
    private final List<ae> a;
    private int b = 0;
    
    a(List<ae> paramList)
    {
      this.a = paramList;
    }
    
    public boolean a()
    {
      return this.b < this.a.size();
    }
    
    public ae b()
    {
      if (a())
      {
        List localList = this.a;
        int i = this.b;
        this.b = (i + 1);
        return (ae)localList.get(i);
      }
      throw new NoSuchElementException();
    }
    
    public List<ae> c()
    {
      return new ArrayList(this.a);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */