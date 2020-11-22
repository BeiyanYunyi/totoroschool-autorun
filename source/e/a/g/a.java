package e.a.g;

import android.os.Build.VERSION;
import android.util.Log;
import e.y;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

class a
  extends f
{
  private final Class<?> a;
  private final e<Socket> b;
  private final e<Socket> c;
  private final e<Socket> d;
  private final e<Socket> e;
  private final c f = c.a();
  
  a(Class<?> paramClass, e<Socket> parame1, e<Socket> parame2, e<Socket> parame3, e<Socket> parame4)
  {
    this.a = paramClass;
    this.b = parame1;
    this.c = parame2;
    this.d = parame3;
    this.e = parame4;
  }
  
  public static f a()
  {
    e locale1;
    for (;;)
    {
      try
      {
        localObject = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
      }
      catch (ClassNotFoundException localClassNotFoundException1)
      {
        Object localObject;
        e locale3;
        e locale4;
        continue;
      }
      try
      {
        localObject = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
      }
      catch (ClassNotFoundException localClassNotFoundException2)
      {
        return null;
      }
    }
    locale3 = new e(null, "setUseSessionTickets", new Class[] { Boolean.TYPE });
    locale4 = new e(null, "setHostname", new Class[] { String.class });
    e locale2;
    if (e())
    {
      locale1 = new e(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
      locale2 = new e(null, "setAlpnProtocols", new Class[] { byte[].class });
    }
    for (;;)
    {
      localObject = new a((Class)localObject, locale3, locale4, locale1, locale2);
      return (f)localObject;
      locale1 = null;
      locale2 = locale1;
    }
  }
  
  private boolean a(String paramString, Class<?> paramClass, Object paramObject)
    throws InvocationTargetException, IllegalAccessException
  {
    try
    {
      boolean bool = ((Boolean)paramClass.getMethod("isCleartextTrafficPermitted", new Class[] { String.class }).invoke(paramObject, new Object[] { paramString })).booleanValue();
      return bool;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
    return b(paramString, paramClass, paramObject);
  }
  
  private boolean b(String paramString, Class<?> paramClass, Object paramObject)
    throws InvocationTargetException, IllegalAccessException
  {
    try
    {
      boolean bool = ((Boolean)paramClass.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(paramObject, new Object[0])).booleanValue();
      return bool;
    }
    catch (NoSuchMethodException paramClass)
    {
      for (;;) {}
    }
    return super.b(paramString);
  }
  
  private static boolean e()
  {
    if (Security.getProvider("GMSCore_OpenSSL") != null) {
      return true;
    }
    try
    {
      Class.forName("android.net.Network");
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;) {}
    }
    return false;
  }
  
  public e.a.j.c a(X509TrustManager paramX509TrustManager)
  {
    try
    {
      Object localObject = Class.forName("android.net.http.X509TrustManagerExtensions");
      localObject = new a(((Class)localObject).getConstructor(new Class[] { X509TrustManager.class }).newInstance(new Object[] { paramX509TrustManager }), ((Class)localObject).getMethod("checkServerTrusted", new Class[] { X509Certificate[].class, String.class, String.class }));
      return (e.a.j.c)localObject;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return super.a(paramX509TrustManager);
  }
  
  public Object a(String paramString)
  {
    return this.f.a(paramString);
  }
  
  @Nullable
  public String a(SSLSocket paramSSLSocket)
  {
    Object localObject2 = this.d;
    Object localObject1 = null;
    if (localObject2 == null) {
      return null;
    }
    if (!this.d.a(paramSSLSocket)) {
      return null;
    }
    localObject2 = (byte[])this.d.d(paramSSLSocket, new Object[0]);
    paramSSLSocket = (SSLSocket)localObject1;
    if (localObject2 != null) {
      paramSSLSocket = new String((byte[])localObject2, e.a.c.e);
    }
    return paramSSLSocket;
  }
  
  public void a(int paramInt, String paramString, @Nullable Throwable paramThrowable)
  {
    int i = 5;
    if (paramInt != 5) {
      i = 3;
    }
    Object localObject = paramString;
    if (paramThrowable != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append('\n');
      ((StringBuilder)localObject).append(Log.getStackTraceString(paramThrowable));
      localObject = ((StringBuilder)localObject).toString();
    }
    paramInt = 0;
    int k = ((String)localObject).length();
    if (paramInt < k)
    {
      int j = ((String)localObject).indexOf('\n', paramInt);
      if (j == -1) {
        j = k;
      }
      for (;;)
      {
        int m = Math.min(j, paramInt + 4000);
        Log.println(i, "OkHttp", ((String)localObject).substring(paramInt, m));
        if (m >= j)
        {
          paramInt = m + 1;
          break;
        }
        paramInt = m;
      }
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (!this.f.a(paramObject)) {
      a(5, paramString, null);
    }
  }
  
  public void a(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
    throws IOException
  {
    try
    {
      paramSocket.connect(paramInetSocketAddress, paramInt);
      return;
    }
    catch (ClassCastException paramSocket)
    {
      if (Build.VERSION.SDK_INT == 26)
      {
        paramInetSocketAddress = new IOException("Exception in connect");
        paramInetSocketAddress.initCause(paramSocket);
        throw paramInetSocketAddress;
      }
      throw paramSocket;
    }
    catch (SecurityException paramSocket)
    {
      paramInetSocketAddress = new IOException("Exception in connect");
      paramInetSocketAddress.initCause(paramSocket);
      throw paramInetSocketAddress;
    }
    catch (AssertionError paramSocket)
    {
      if (e.a.c.a(paramSocket)) {
        throw new IOException(paramSocket);
      }
      throw paramSocket;
    }
  }
  
  public void a(SSLSocket paramSSLSocket, String paramString, List<y> paramList)
  {
    if (paramString != null)
    {
      this.b.b(paramSSLSocket, new Object[] { Boolean.valueOf(true) });
      this.c.b(paramSSLSocket, new Object[] { paramString });
    }
    if ((this.e != null) && (this.e.a(paramSSLSocket)))
    {
      paramString = b(paramList);
      this.e.d(paramSSLSocket, new Object[] { paramString });
    }
  }
  
  public e.a.j.e b(X509TrustManager paramX509TrustManager)
  {
    try
    {
      Object localObject = paramX509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[] { X509Certificate.class });
      ((Method)localObject).setAccessible(true);
      localObject = new b(paramX509TrustManager, (Method)localObject);
      return (e.a.j.e)localObject;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
    return super.b(paramX509TrustManager);
  }
  
  public SSLContext b()
  {
    int i = 1;
    try
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        int j = Build.VERSION.SDK_INT;
        if (j < 22) {}
      }
      else
      {
        i = 0;
      }
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      for (;;) {}
    }
    if (i != 0) {}
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
  
  public boolean b(String paramString)
  {
    try
    {
      Class localClass = Class.forName("android.security.NetworkSecurityPolicy");
      boolean bool = a(paramString, localClass, localClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
      return bool;
    }
    catch (IllegalAccessException|IllegalArgumentException|InvocationTargetException paramString)
    {
      throw e.a.c.a("unable to determine cleartext support", paramString);
      return super.b(paramString);
    }
    catch (ClassNotFoundException|NoSuchMethodException localClassNotFoundException)
    {
      for (;;) {}
    }
  }
  
  static final class a
    extends e.a.j.c
  {
    private final Object a;
    private final Method b;
    
    a(Object paramObject, Method paramMethod)
    {
      this.a = paramObject;
      this.b = paramMethod;
    }
    
    public List<Certificate> a(List<Certificate> paramList, String paramString)
      throws SSLPeerUnverifiedException
    {
      try
      {
        paramList = (X509Certificate[])paramList.toArray(new X509Certificate[paramList.size()]);
        paramList = (List)this.b.invoke(this.a, new Object[] { paramList, "RSA", paramString });
        return paramList;
      }
      catch (IllegalAccessException paramList)
      {
        throw new AssertionError(paramList);
      }
      catch (InvocationTargetException paramList)
      {
        paramString = new SSLPeerUnverifiedException(paramList.getMessage());
        paramString.initCause(paramList);
        throw paramString;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      return paramObject instanceof a;
    }
    
    public int hashCode()
    {
      return 0;
    }
  }
  
  static final class b
    implements e.a.j.e
  {
    private final X509TrustManager a;
    private final Method b;
    
    b(X509TrustManager paramX509TrustManager, Method paramMethod)
    {
      this.b = paramMethod;
      this.a = paramX509TrustManager;
    }
    
    public X509Certificate a(X509Certificate paramX509Certificate)
    {
      try
      {
        paramX509Certificate = (TrustAnchor)this.b.invoke(this.a, new Object[] { paramX509Certificate });
        if (paramX509Certificate != null)
        {
          paramX509Certificate = paramX509Certificate.getTrustedCert();
          return paramX509Certificate;
        }
        return null;
      }
      catch (IllegalAccessException paramX509Certificate)
      {
        throw e.a.c.a("unable to get issues and signature", paramX509Certificate);
      }
      catch (InvocationTargetException paramX509Certificate) {}
      return null;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof b)) {
        return false;
      }
      paramObject = (b)paramObject;
      return (this.a.equals(((b)paramObject).a)) && (this.b.equals(((b)paramObject).b));
    }
    
    public int hashCode()
    {
      return this.a.hashCode() + this.b.hashCode() * 31;
    }
  }
  
  static final class c
  {
    private final Method a;
    private final Method b;
    private final Method c;
    
    c(Method paramMethod1, Method paramMethod2, Method paramMethod3)
    {
      this.a = paramMethod1;
      this.b = paramMethod2;
      this.c = paramMethod3;
    }
    
    static c a()
    {
      Object localObject1 = null;
      try
      {
        localObject2 = Class.forName("dalvik.system.CloseGuard");
        Method localMethod = ((Class)localObject2).getMethod("get", new Class[0]);
        localObject3 = ((Class)localObject2).getMethod("open", new Class[] { String.class });
        localObject2 = ((Class)localObject2).getMethod("warnIfOpen", new Class[0]);
        localObject1 = localMethod;
      }
      catch (Exception localException)
      {
        Object localObject2;
        Object localObject3;
        for (;;) {}
      }
      localObject2 = null;
      localObject3 = localObject2;
      return new c((Method)localObject1, (Method)localObject3, (Method)localObject2);
    }
    
    Object a(String paramString)
    {
      if (this.a != null) {}
      try
      {
        Object localObject = this.a.invoke(null, new Object[0]);
        this.b.invoke(localObject, new Object[] { paramString });
        return localObject;
      }
      catch (Exception paramString) {}
      return null;
      return null;
    }
    
    boolean a(Object paramObject)
    {
      boolean bool = false;
      if (paramObject != null) {}
      try
      {
        this.c.invoke(paramObject, new Object[0]);
        bool = true;
        return bool;
      }
      catch (Exception paramObject) {}
      return false;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\g\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */