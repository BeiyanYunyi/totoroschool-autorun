package e;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

public abstract interface o
{
  public static final o a = new o()
  {
    public List<InetAddress> a(String paramAnonymousString)
      throws UnknownHostException
    {
      if (paramAnonymousString != null) {
        try
        {
          List localList = Arrays.asList(InetAddress.getAllByName(paramAnonymousString));
          return localList;
        }
        catch (NullPointerException localNullPointerException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Broken system behaviour for dns lookup of ");
          localStringBuilder.append(paramAnonymousString);
          paramAnonymousString = new UnknownHostException(localStringBuilder.toString());
          paramAnonymousString.initCause(localNullPointerException);
          throw paramAnonymousString;
        }
      }
      throw new UnknownHostException("hostname == null");
    }
  };
  
  public abstract List<InetAddress> a(String paramString)
    throws UnknownHostException;
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */