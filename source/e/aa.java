package e;

import e.a.c;
import e.a.c.f;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;

public final class aa
{
  final t a;
  final String b;
  final s c;
  @Nullable
  final ab d;
  final Map<Class<?>, Object> e;
  @Nullable
  private volatile d f;
  
  aa(a parama)
  {
    this.a = parama.a;
    this.b = parama.b;
    this.c = parama.c.a();
    this.d = parama.d;
    this.e = c.a(parama.e);
  }
  
  public t a()
  {
    return this.a;
  }
  
  @Nullable
  public String a(String paramString)
  {
    return this.c.a(paramString);
  }
  
  public String b()
  {
    return this.b;
  }
  
  public s c()
  {
    return this.c;
  }
  
  @Nullable
  public ab d()
  {
    return this.d;
  }
  
  public a e()
  {
    return new a(this);
  }
  
  public d f()
  {
    d locald = this.f;
    if (locald != null) {
      return locald;
    }
    locald = d.a(this.c);
    this.f = locald;
    return locald;
  }
  
  public boolean g()
  {
    return this.a.c();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Request{method=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", url=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", tags=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public static class a
  {
    @Nullable
    t a;
    String b;
    s.a c;
    @Nullable
    ab d;
    Map<Class<?>, Object> e = Collections.emptyMap();
    
    public a()
    {
      this.b = "GET";
      this.c = new s.a();
    }
    
    a(aa paramaa)
    {
      this.a = paramaa.a;
      this.b = paramaa.b;
      this.d = paramaa.d;
      Object localObject;
      if (paramaa.e.isEmpty()) {
        localObject = Collections.emptyMap();
      } else {
        localObject = new LinkedHashMap(paramaa.e);
      }
      this.e = ((Map)localObject);
      this.c = paramaa.c.b();
    }
    
    public a a(ab paramab)
    {
      return a("POST", paramab);
    }
    
    public a a(s params)
    {
      this.c = params.b();
      return this;
    }
    
    public a a(t paramt)
    {
      if (paramt != null)
      {
        this.a = paramt;
        return this;
      }
      throw new NullPointerException("url == null");
    }
    
    public <T> a a(Class<? super T> paramClass, @Nullable T paramT)
    {
      if (paramClass != null)
      {
        if (paramT == null)
        {
          this.e.remove(paramClass);
          return this;
        }
        if (this.e.isEmpty()) {
          this.e = new LinkedHashMap();
        }
        this.e.put(paramClass, paramClass.cast(paramT));
        return this;
      }
      throw new NullPointerException("type == null");
    }
    
    public a a(String paramString)
    {
      if (paramString != null)
      {
        Object localObject;
        if (paramString.regionMatches(true, 0, "ws:", 0, 3))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("http:");
          ((StringBuilder)localObject).append(paramString.substring(3));
          localObject = ((StringBuilder)localObject).toString();
        }
        else
        {
          localObject = paramString;
          if (paramString.regionMatches(true, 0, "wss:", 0, 4))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("https:");
            ((StringBuilder)localObject).append(paramString.substring(4));
            localObject = ((StringBuilder)localObject).toString();
          }
        }
        return a(t.e((String)localObject));
      }
      throw new NullPointerException("url == null");
    }
    
    public a a(String paramString, @Nullable ab paramab)
    {
      if (paramString != null)
      {
        if (paramString.length() != 0)
        {
          if ((paramab != null) && (!f.c(paramString)))
          {
            paramab = new StringBuilder();
            paramab.append("method ");
            paramab.append(paramString);
            paramab.append(" must not have a request body.");
            throw new IllegalArgumentException(paramab.toString());
          }
          if ((paramab == null) && (f.b(paramString)))
          {
            paramab = new StringBuilder();
            paramab.append("method ");
            paramab.append(paramString);
            paramab.append(" must have a request body.");
            throw new IllegalArgumentException(paramab.toString());
          }
          this.b = paramString;
          this.d = paramab;
          return this;
        }
        throw new IllegalArgumentException("method.length() == 0");
      }
      throw new NullPointerException("method == null");
    }
    
    public a a(String paramString1, String paramString2)
    {
      this.c.c(paramString1, paramString2);
      return this;
    }
    
    public aa a()
    {
      if (this.a != null) {
        return new aa(this);
      }
      throw new IllegalStateException("url == null");
    }
    
    public a b(String paramString)
    {
      this.c.b(paramString);
      return this;
    }
    
    public a b(String paramString1, String paramString2)
    {
      this.c.a(paramString1, paramString2);
      return this;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */