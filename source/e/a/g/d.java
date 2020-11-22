package e.a.g;

import e.a.c;
import e.y;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

class d
  extends f
{
  private final Method a;
  private final Method b;
  private final Method c;
  private final Class<?> d;
  private final Class<?> e;
  
  d(Method paramMethod1, Method paramMethod2, Method paramMethod3, Class<?> paramClass1, Class<?> paramClass2)
  {
    this.a = paramMethod1;
    this.b = paramMethod2;
    this.c = paramMethod3;
    this.d = paramClass1;
    this.e = paramClass2;
  }
  
  public static f a()
  {
    try
    {
      Object localObject1 = Class.forName("org.eclipse.jetty.alpn.ALPN");
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("org.eclipse.jetty.alpn.ALPN");
      ((StringBuilder)localObject2).append("$Provider");
      localObject2 = Class.forName(((StringBuilder)localObject2).toString());
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("org.eclipse.jetty.alpn.ALPN");
      ((StringBuilder)localObject3).append("$ClientProvider");
      localObject3 = Class.forName(((StringBuilder)localObject3).toString());
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("org.eclipse.jetty.alpn.ALPN");
      ((StringBuilder)localObject4).append("$ServerProvider");
      localObject4 = Class.forName(((StringBuilder)localObject4).toString());
      localObject1 = new d(((Class)localObject1).getMethod("put", new Class[] { SSLSocket.class, localObject2 }), ((Class)localObject1).getMethod("get", new Class[] { SSLSocket.class }), ((Class)localObject1).getMethod("remove", new Class[] { SSLSocket.class }), (Class)localObject3, (Class)localObject4);
      return (f)localObject1;
    }
    catch (ClassNotFoundException|NoSuchMethodException localClassNotFoundException)
    {
      for (;;) {}
    }
    return null;
  }
  
  @Nullable
  public String a(SSLSocket paramSSLSocket)
  {
    try
    {
      paramSSLSocket = (a)Proxy.getInvocationHandler(this.b.invoke(null, new Object[] { paramSSLSocket }));
      if ((!paramSSLSocket.a) && (paramSSLSocket.b == null))
      {
        f.c().a(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);
        return null;
      }
      if (paramSSLSocket.a) {
        return null;
      }
      paramSSLSocket = paramSSLSocket.b;
      return paramSSLSocket;
    }
    catch (InvocationTargetException|IllegalAccessException paramSSLSocket)
    {
      throw c.a("unable to get selected protocol", paramSSLSocket);
    }
  }
  
  public void a(SSLSocket paramSSLSocket, String paramString, List<y> paramList)
  {
    Object localObject = a(paramList);
    try
    {
      paramString = f.class.getClassLoader();
      paramList = this.d;
      Class localClass = this.e;
      localObject = new a((List)localObject);
      paramString = Proxy.newProxyInstance(paramString, new Class[] { paramList, localClass }, (InvocationHandler)localObject);
      this.a.invoke(null, new Object[] { paramSSLSocket, paramString });
      return;
    }
    catch (InvocationTargetException|IllegalAccessException paramSSLSocket)
    {
      throw c.a("unable to set alpn", paramSSLSocket);
    }
  }
  
  public void b(SSLSocket paramSSLSocket)
  {
    try
    {
      this.c.invoke(null, new Object[] { paramSSLSocket });
      return;
    }
    catch (IllegalAccessException|InvocationTargetException paramSSLSocket)
    {
      throw c.a("unable to remove alpn", paramSSLSocket);
    }
  }
  
  private static class a
    implements InvocationHandler
  {
    boolean a;
    String b;
    private final List<String> c;
    
    a(List<String> paramList)
    {
      this.c = paramList;
    }
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
      throws Throwable
    {
      String str = paramMethod.getName();
      Class localClass = paramMethod.getReturnType();
      paramObject = paramArrayOfObject;
      if (paramArrayOfObject == null) {
        paramObject = c.b;
      }
      if ((str.equals("supports")) && (Boolean.TYPE == localClass)) {
        return Boolean.valueOf(true);
      }
      if ((str.equals("unsupported")) && (Void.TYPE == localClass))
      {
        this.a = true;
        return null;
      }
      if ((str.equals("protocols")) && (paramObject.length == 0)) {
        return this.c;
      }
      if (((str.equals("selectProtocol")) || (str.equals("select"))) && (String.class == localClass) && (paramObject.length == 1) && ((paramObject[0] instanceof List)))
      {
        paramObject = (List)paramObject[0];
        int j = ((List)paramObject).size();
        int i = 0;
        while (i < j)
        {
          if (this.c.contains(((List)paramObject).get(i)))
          {
            paramObject = (String)((List)paramObject).get(i);
            this.b = ((String)paramObject);
            return paramObject;
          }
          i += 1;
        }
        paramObject = (String)this.c.get(0);
        this.b = ((String)paramObject);
        return paramObject;
      }
      if (((str.equals("protocolSelected")) || (str.equals("selected"))) && (paramObject.length == 1))
      {
        this.b = ((String)paramObject[0]);
        return null;
      }
      return paramMethod.invoke(this, (Object[])paramObject);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\g\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */