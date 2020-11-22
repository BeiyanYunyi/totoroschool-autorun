package e.a.h;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.List;

public class a
  extends ProxySelector
{
  public void connectFailed(URI paramURI, SocketAddress paramSocketAddress, IOException paramIOException) {}
  
  public List<Proxy> select(URI paramURI)
  {
    if (paramURI != null) {
      return Collections.singletonList(Proxy.NO_PROXY);
    }
    throw new IllegalArgumentException("uri must not be null");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\h\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */