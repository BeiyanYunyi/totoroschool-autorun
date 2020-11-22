package e.a.g;

import e.y;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

final class c
  extends f
{
  final Method a;
  final Method b;
  
  c(Method paramMethod1, Method paramMethod2)
  {
    this.a = paramMethod1;
    this.b = paramMethod2;
  }
  
  public static c a()
  {
    try
    {
      c localc = new c(SSLParameters.class.getMethod("setApplicationProtocols", new Class[] { String[].class }), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
      return localc;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
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
      paramSSLSocket = (String)this.b.invoke(paramSSLSocket, new Object[0]);
      if (paramSSLSocket != null)
      {
        boolean bool = paramSSLSocket.equals("");
        if (!bool) {
          return paramSSLSocket;
        }
      }
      return null;
    }
    catch (IllegalAccessException|InvocationTargetException paramSSLSocket)
    {
      throw e.a.c.a("unable to get selected protocols", paramSSLSocket);
    }
  }
  
  public void a(SSLSocket paramSSLSocket, String paramString, List<y> paramList)
  {
    try
    {
      paramString = paramSSLSocket.getSSLParameters();
      paramList = a(paramList);
      this.a.invoke(paramString, new Object[] { paramList.toArray(new String[paramList.size()]) });
      paramSSLSocket.setSSLParameters(paramString);
      return;
    }
    catch (IllegalAccessException|InvocationTargetException paramSSLSocket)
    {
      throw e.a.c.a("unable to set ssl parameters", paramSSLSocket);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\g\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */