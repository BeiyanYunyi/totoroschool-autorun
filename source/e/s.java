package e;

import e.a.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

public final class s
{
  private final String[] a;
  
  s(a parama)
  {
    this.a = ((String[])parama.a.toArray(new String[parama.a.size()]));
  }
  
  private s(String[] paramArrayOfString)
  {
    this.a = paramArrayOfString;
  }
  
  public static s a(String... paramVarArgs)
  {
    if (paramVarArgs != null)
    {
      if (paramVarArgs.length % 2 == 0)
      {
        paramVarArgs = (String[])paramVarArgs.clone();
        int k = 0;
        int i = 0;
        int j;
        for (;;)
        {
          j = k;
          if (i >= paramVarArgs.length) {
            break label63;
          }
          if (paramVarArgs[i] == null) {
            break;
          }
          paramVarArgs[i] = paramVarArgs[i].trim();
          i += 1;
        }
        throw new IllegalArgumentException("Headers cannot be null");
        label63:
        while (j < paramVarArgs.length)
        {
          String str1 = paramVarArgs[j];
          String str2 = paramVarArgs[(j + 1)];
          c(str1);
          a(str2, str1);
          j += 2;
        }
        return new s(paramVarArgs);
      }
      throw new IllegalArgumentException("Expected alternating header names and values");
    }
    throw new NullPointerException("namesAndValues == null");
  }
  
  private static String a(String[] paramArrayOfString, String paramString)
  {
    int i = paramArrayOfString.length - 2;
    while (i >= 0)
    {
      if (paramString.equalsIgnoreCase(paramArrayOfString[i])) {
        return paramArrayOfString[(i + 1)];
      }
      i -= 2;
    }
    return null;
  }
  
  static void a(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      int j = paramString1.length();
      int i = 0;
      while (i < j)
      {
        int k = paramString1.charAt(i);
        if (((k > 31) || (k == 9)) && (k < 127)) {
          i += 1;
        } else {
          throw new IllegalArgumentException(c.a("Unexpected char %#04x at %d in %s value: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), paramString2, paramString1 }));
        }
      }
      return;
    }
    paramString1 = new StringBuilder();
    paramString1.append("value for name ");
    paramString1.append(paramString2);
    paramString1.append(" == null");
    throw new NullPointerException(paramString1.toString());
  }
  
  static void c(String paramString)
  {
    if (paramString != null)
    {
      if (!paramString.isEmpty())
      {
        int j = paramString.length();
        int i = 0;
        while (i < j)
        {
          int k = paramString.charAt(i);
          if ((k > 32) && (k < 127)) {
            i += 1;
          } else {
            throw new IllegalArgumentException(c.a("Unexpected char %#04x at %d in header name: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), paramString }));
          }
        }
        return;
      }
      throw new IllegalArgumentException("name is empty");
    }
    throw new NullPointerException("name == null");
  }
  
  public int a()
  {
    return this.a.length / 2;
  }
  
  public String a(int paramInt)
  {
    return this.a[(paramInt * 2)];
  }
  
  @Nullable
  public String a(String paramString)
  {
    return a(this.a, paramString);
  }
  
  public a b()
  {
    a locala = new a();
    Collections.addAll(locala.a, this.a);
    return locala;
  }
  
  public String b(int paramInt)
  {
    return this.a[(paramInt * 2 + 1)];
  }
  
  public List<String> b(String paramString)
  {
    int j = a();
    Object localObject1 = null;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1;
      if (paramString.equalsIgnoreCase(a(i)))
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList(2);
        }
        ((List)localObject2).add(b(i));
      }
      i += 1;
      localObject1 = localObject2;
    }
    if (localObject1 != null) {
      return Collections.unmodifiableList((List)localObject1);
    }
    return Collections.emptyList();
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof s)) && (Arrays.equals(((s)paramObject).a, this.a));
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.a);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = a();
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(a(i));
      localStringBuilder.append(": ");
      localStringBuilder.append(b(i));
      localStringBuilder.append("\n");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static final class a
  {
    final List<String> a = new ArrayList(20);
    
    a a(String paramString)
    {
      int i = paramString.indexOf(":", 1);
      if (i != -1) {
        return b(paramString.substring(0, i), paramString.substring(i + 1));
      }
      if (paramString.startsWith(":")) {
        return b("", paramString.substring(1));
      }
      return b("", paramString);
    }
    
    public a a(String paramString1, String paramString2)
    {
      s.c(paramString1);
      s.a(paramString2, paramString1);
      return b(paramString1, paramString2);
    }
    
    public s a()
    {
      return new s(this);
    }
    
    public a b(String paramString)
    {
      int j;
      for (int i = 0; i < this.a.size(); i = j + 2)
      {
        j = i;
        if (paramString.equalsIgnoreCase((String)this.a.get(i)))
        {
          this.a.remove(i);
          this.a.remove(i);
          j = i - 2;
        }
      }
      return this;
    }
    
    a b(String paramString1, String paramString2)
    {
      this.a.add(paramString1);
      this.a.add(paramString2.trim());
      return this;
    }
    
    public a c(String paramString1, String paramString2)
    {
      s.c(paramString1);
      s.a(paramString2, paramString1);
      b(paramString1);
      b(paramString1, paramString2);
      return this;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */