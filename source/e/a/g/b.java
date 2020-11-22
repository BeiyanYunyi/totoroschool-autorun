package e.a.g;

import e.y;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.conscrypt.Conscrypt;
import org.conscrypt.Conscrypt.ProviderBuilder;

public class b
  extends f
{
  public static b a()
  {
    try
    {
      Class.forName("org.conscrypt.Conscrypt");
      if (!Conscrypt.isAvailable()) {
        return null;
      }
      b localb = new b();
      return localb;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return null;
  }
  
  private Provider e()
  {
    return Conscrypt.newProviderBuilder().provideTrustManager().build();
  }
  
  @Nullable
  public String a(SSLSocket paramSSLSocket)
  {
    if (Conscrypt.isConscrypt(paramSSLSocket)) {
      return Conscrypt.getApplicationProtocol(paramSSLSocket);
    }
    return super.a(paramSSLSocket);
  }
  
  public void a(SSLSocket paramSSLSocket, String paramString, List<y> paramList)
  {
    if (Conscrypt.isConscrypt(paramSSLSocket))
    {
      if (paramString != null)
      {
        Conscrypt.setUseSessionTickets(paramSSLSocket, true);
        Conscrypt.setHostname(paramSSLSocket, paramString);
      }
      Conscrypt.setApplicationProtocols(paramSSLSocket, (String[])f.a(paramList).toArray(new String[0]));
      return;
    }
    super.a(paramSSLSocket, paramString, paramList);
  }
  
  public void a(SSLSocketFactory paramSSLSocketFactory)
  {
    if (Conscrypt.isConscrypt(paramSSLSocketFactory)) {
      Conscrypt.setUseEngineSocket(paramSSLSocketFactory, true);
    }
  }
  
  public SSLContext b()
  {
    try
    {
      SSLContext localSSLContext1 = SSLContext.getInstance("TLSv1.3", e());
      return localSSLContext1;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException1) {}
    try
    {
      SSLContext localSSLContext2 = SSLContext.getInstance("TLS", e());
      return localSSLContext2;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException2)
    {
      for (;;) {}
    }
    throw new IllegalStateException("No TLS provider", localNoSuchAlgorithmException1);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\g\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */