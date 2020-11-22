package e.a.g;

import e.a.j.e;
import e.x;
import e.y;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public class f
{
  private static final f a = ;
  private static final Logger b = Logger.getLogger(x.class.getName());
  
  private static f a()
  {
    Object localObject = a.a();
    if (localObject != null) {
      return (f)localObject;
    }
    if (d())
    {
      localObject = b.a();
      if (localObject != null) {
        return (f)localObject;
      }
    }
    localObject = c.a();
    if (localObject != null) {
      return (f)localObject;
    }
    localObject = d.a();
    if (localObject != null) {
      return (f)localObject;
    }
    return new f();
  }
  
  public static List<String> a(List<y> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      y localy = (y)paramList.get(i);
      if (localy != y.HTTP_1_0) {
        localArrayList.add(localy.toString());
      }
      i += 1;
    }
    return localArrayList;
  }
  
  static byte[] b(List<y> paramList)
  {
    f.c localc = new f.c();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      y localy = (y)paramList.get(i);
      if (localy != y.HTTP_1_0)
      {
        localc.b(localy.toString().length());
        localc.a(localy.toString());
      }
      i += 1;
    }
    return localc.r();
  }
  
  public static f c()
  {
    return a;
  }
  
  public static boolean d()
  {
    if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
      return true;
    }
    return "Conscrypt".equals(java.security.Security.getProviders()[0].getName());
  }
  
  public e.a.j.c a(X509TrustManager paramX509TrustManager)
  {
    return new e.a.j.a(b(paramX509TrustManager));
  }
  
  public Object a(String paramString)
  {
    if (b.isLoggable(Level.FINE)) {
      return new Throwable(paramString);
    }
    return null;
  }
  
  @Nullable
  public String a(SSLSocket paramSSLSocket)
  {
    return null;
  }
  
  public void a(int paramInt, String paramString, @Nullable Throwable paramThrowable)
  {
    Level localLevel;
    if (paramInt == 5) {
      localLevel = Level.WARNING;
    } else {
      localLevel = Level.INFO;
    }
    b.log(localLevel, paramString, paramThrowable);
  }
  
  public void a(String paramString, Object paramObject)
  {
    Object localObject = paramString;
    if (paramObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
      localObject = ((StringBuilder)localObject).toString();
    }
    a(5, (String)localObject, (Throwable)paramObject);
  }
  
  public void a(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
    throws IOException
  {
    paramSocket.connect(paramInetSocketAddress, paramInt);
  }
  
  public void a(SSLSocket paramSSLSocket, @Nullable String paramString, List<y> paramList) {}
  
  public void a(SSLSocketFactory paramSSLSocketFactory) {}
  
  public e b(X509TrustManager paramX509TrustManager)
  {
    return new e.a.j.b(paramX509TrustManager.getAcceptedIssuers());
  }
  
  public SSLContext b()
  {
    if ("1.7".equals(System.getProperty("java.specification.version"))) {}
    for (;;)
    {
      try
      {
        localSSLContext = SSLContext.getInstance("TLSv1.2");
        return localSSLContext;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException2)
      {
        SSLContext localSSLContext;
        continue;
      }
      try
      {
        localSSLContext = SSLContext.getInstance("TLS");
        return localSSLContext;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException1)
      {
        throw new IllegalStateException("No TLS provider", localNoSuchAlgorithmException1);
      }
    }
  }
  
  public void b(SSLSocket paramSSLSocket) {}
  
  public boolean b(String paramString)
  {
    return true;
  }
  
  public String toString()
  {
    return getClass().getSimpleName();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\g\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */