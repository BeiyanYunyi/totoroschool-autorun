package e.a.b;

import e.a.a;
import e.k;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

public final class b
{
  private final List<k> a;
  private int b = 0;
  private boolean c;
  private boolean d;
  
  public b(List<k> paramList)
  {
    this.a = paramList;
  }
  
  private boolean b(SSLSocket paramSSLSocket)
  {
    int i = this.b;
    while (i < this.a.size())
    {
      if (((k)this.a.get(i)).a(paramSSLSocket)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public k a(SSLSocket paramSSLSocket)
    throws IOException
  {
    int i = this.b;
    int j = this.a.size();
    while (i < j)
    {
      localObject = (k)this.a.get(i);
      if (((k)localObject).a(paramSSLSocket))
      {
        this.b = (i + 1);
        break label64;
      }
      i += 1;
    }
    Object localObject = null;
    label64:
    if (localObject != null)
    {
      this.c = b(paramSSLSocket);
      a.a.a((k)localObject, paramSSLSocket, this.d);
      return (k)localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unable to find acceptable protocols. isFallback=");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append(", modes=");
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(", supported protocols=");
    ((StringBuilder)localObject).append(Arrays.toString(paramSSLSocket.getEnabledProtocols()));
    throw new UnknownServiceException(((StringBuilder)localObject).toString());
  }
  
  public boolean a(IOException paramIOException)
  {
    boolean bool2 = true;
    this.d = true;
    if (!this.c) {
      return false;
    }
    if ((paramIOException instanceof ProtocolException)) {
      return false;
    }
    if ((paramIOException instanceof InterruptedIOException)) {
      return false;
    }
    boolean bool3 = paramIOException instanceof SSLHandshakeException;
    if ((bool3) && ((paramIOException.getCause() instanceof CertificateException))) {
      return false;
    }
    if ((paramIOException instanceof SSLPeerUnverifiedException)) {
      return false;
    }
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (!(paramIOException instanceof SSLProtocolException))
      {
        if ((paramIOException instanceof SSLException)) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */