package e.a.c;

import e.y;
import java.io.IOException;
import java.net.ProtocolException;

public final class k
{
  public final y a;
  public final int b;
  public final String c;
  
  public k(y paramy, int paramInt, String paramString)
  {
    this.a = paramy;
    this.b = paramInt;
    this.c = paramString;
  }
  
  public static k a(String paramString)
    throws IOException
  {
    boolean bool = paramString.startsWith("HTTP/1.");
    int i = 9;
    if (bool)
    {
      if ((paramString.length() >= 9) && (paramString.charAt(8) == ' '))
      {
        j = paramString.charAt(7) - '0';
        if (j == 0)
        {
          localObject = y.HTTP_1_0;
        }
        else if (j == 1)
        {
          localObject = y.HTTP_1_1;
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Unexpected status line: ");
          ((StringBuilder)localObject).append(paramString);
          throw new ProtocolException(((StringBuilder)localObject).toString());
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Unexpected status line: ");
        ((StringBuilder)localObject).append(paramString);
        throw new ProtocolException(((StringBuilder)localObject).toString());
      }
    }
    else
    {
      if (!paramString.startsWith("ICY ")) {
        break label343;
      }
      localObject = y.HTTP_1_0;
      i = 4;
    }
    int k = paramString.length();
    int j = i + 3;
    if (k >= j) {}
    try
    {
      k = Integer.parseInt(paramString.substring(i, j));
      String str = "";
      if (paramString.length() > j) {
        if (paramString.charAt(j) == ' ')
        {
          str = paramString.substring(i + 4);
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Unexpected status line: ");
          ((StringBuilder)localObject).append(paramString);
          throw new ProtocolException(((StringBuilder)localObject).toString());
        }
      }
      return new k((y)localObject, k, str);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;) {}
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unexpected status line: ");
    ((StringBuilder)localObject).append(paramString);
    throw new ProtocolException(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unexpected status line: ");
    ((StringBuilder)localObject).append(paramString);
    throw new ProtocolException(((StringBuilder)localObject).toString());
    label343:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unexpected status line: ");
    ((StringBuilder)localObject).append(paramString);
    throw new ProtocolException(((StringBuilder)localObject).toString());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str;
    if (this.a == y.HTTP_1_0) {
      str = "HTTP/1.0";
    } else {
      str = "HTTP/1.1";
    }
    localStringBuilder.append(str);
    localStringBuilder.append(' ');
    localStringBuilder.append(this.b);
    if (this.c != null)
    {
      localStringBuilder.append(' ');
      localStringBuilder.append(this.c);
    }
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\c\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */