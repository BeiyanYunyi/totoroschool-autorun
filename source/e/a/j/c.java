package e.a.j;

import e.a.g.f;
import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

public abstract class c
{
  public static c a(X509TrustManager paramX509TrustManager)
  {
    return f.c().a(paramX509TrustManager);
  }
  
  public abstract List<Certificate> a(List<Certificate> paramList, String paramString)
    throws SSLPeerUnverifiedException;
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\j\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */