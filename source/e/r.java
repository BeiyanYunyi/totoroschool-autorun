package e;

import e.a.c;
import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class r
{
  private final af a;
  private final h b;
  private final List<Certificate> c;
  private final List<Certificate> d;
  
  private r(af paramaf, h paramh, List<Certificate> paramList1, List<Certificate> paramList2)
  {
    this.a = paramaf;
    this.b = paramh;
    this.c = paramList1;
    this.d = paramList2;
  }
  
  public static r a(SSLSession paramSSLSession)
    throws IOException
  {
    Object localObject = paramSSLSession.getCipherSuite();
    h localh;
    af localaf;
    if (localObject != null) {
      if (!"SSL_NULL_WITH_NULL_NULL".equals(localObject))
      {
        localh = h.a((String)localObject);
        localObject = paramSSLSession.getProtocol();
        if (localObject != null) {
          if (!"NONE".equals(localObject)) {
            localaf = af.forJavaName((String)localObject);
          }
        }
      }
    }
    try
    {
      localObject = paramSSLSession.getPeerCertificates();
    }
    catch (SSLPeerUnverifiedException localSSLPeerUnverifiedException)
    {
      for (;;) {}
    }
    localObject = null;
    if (localObject != null) {
      localObject = c.a((Object[])localObject);
    } else {
      localObject = Collections.emptyList();
    }
    paramSSLSession = paramSSLSession.getLocalCertificates();
    if (paramSSLSession != null) {
      paramSSLSession = c.a(paramSSLSession);
    } else {
      paramSSLSession = Collections.emptyList();
    }
    return new r(localaf, localh, (List)localObject, paramSSLSession);
    throw new IOException("tlsVersion == NONE");
    throw new IllegalStateException("tlsVersion == null");
    throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
    throw new IllegalStateException("cipherSuite == null");
  }
  
  public h a()
  {
    return this.b;
  }
  
  public List<Certificate> b()
  {
    return this.c;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool1 = paramObject instanceof r;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (r)paramObject;
    bool1 = bool2;
    if (this.a.equals(((r)paramObject).a))
    {
      bool1 = bool2;
      if (this.b.equals(((r)paramObject).b))
      {
        bool1 = bool2;
        if (this.c.equals(((r)paramObject).c))
        {
          bool1 = bool2;
          if (this.d.equals(((r)paramObject).d)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return (((527 + this.a.hashCode()) * 31 + this.b.hashCode()) * 31 + this.c.hashCode()) * 31 + this.d.hashCode();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */