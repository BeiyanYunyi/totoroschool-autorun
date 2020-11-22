package e;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum af
{
  final String javaName;
  
  static
  {
    TLS_1_2 = new af("TLS_1_2", 1, "TLSv1.2");
    TLS_1_1 = new af("TLS_1_1", 2, "TLSv1.1");
    TLS_1_0 = new af("TLS_1_0", 3, "TLSv1");
  }
  
  private af(String paramString)
  {
    this.javaName = paramString;
  }
  
  public static af forJavaName(String paramString)
  {
    int i = paramString.hashCode();
    if (i != 79201641)
    {
      if (i != 79923350)
      {
        switch (i)
        {
        default: 
          break;
        case -503070501: 
          if (!paramString.equals("TLSv1.3")) {
            break;
          }
          i = 0;
          break;
        case -503070502: 
          if (!paramString.equals("TLSv1.2")) {
            break;
          }
          i = 1;
          break;
        case -503070503: 
          if (!paramString.equals("TLSv1.1")) {
            break;
          }
          i = 2;
          break;
        }
      }
      else if (paramString.equals("TLSv1"))
      {
        i = 3;
        break label119;
      }
    }
    else if (paramString.equals("SSLv3"))
    {
      i = 4;
      break label119;
    }
    i = -1;
    switch (i)
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unexpected TLS version: ");
      localStringBuilder.append(paramString);
      throw new IllegalArgumentException(localStringBuilder.toString());
    case 4: 
      return SSL_3_0;
    case 3: 
      return TLS_1_0;
    case 2: 
      return TLS_1_1;
    case 1: 
      label119:
      return TLS_1_2;
    }
    return TLS_1_3;
  }
  
  static List<af> forJavaNames(String... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(forJavaName(paramVarArgs[i]));
      i += 1;
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public String javaName()
  {
    return this.javaName;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */