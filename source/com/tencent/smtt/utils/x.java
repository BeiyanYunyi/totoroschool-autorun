package com.tencent.smtt.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class x
{
  private b a = null;
  private b b = null;
  
  private boolean a(b paramb1, b paramb2)
  {
    if ((paramb1 != null) && (paramb1.a() != null) && (paramb2 != null) && (paramb2.a() != null))
    {
      Object localObject1 = paramb1.a();
      paramb1 = paramb2.a();
      paramb2 = ((Map)localObject1).entrySet().iterator();
      while (paramb2.hasNext())
      {
        Object localObject2 = (Map.Entry)paramb2.next();
        localObject1 = (String)((Map.Entry)localObject2).getKey();
        localObject2 = (a)((Map.Entry)localObject2).getValue();
        if (paramb1.containsKey(localObject1))
        {
          localObject1 = (a)paramb1.get(localObject1);
          if ((((a)localObject2).a() == ((a)localObject1).a()) && (((a)localObject2).b() == ((a)localObject1).b())) {
            break;
          }
        }
        else
        {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public void a(File paramFile)
  {
    this.a = new b(paramFile);
  }
  
  public boolean a()
  {
    if (this.b != null)
    {
      if (this.a == null) {
        return false;
      }
      if ((this.b.a().size() == this.a.a().size()) && (a(this.a, this.b))) {
        return true;
      }
    }
    return false;
  }
  
  public void b(File paramFile)
  {
    this.b = new b(paramFile);
  }
  
  class a
  {
    private String b;
    private long c;
    private long d;
    
    a(String paramString, long paramLong1, long paramLong2)
    {
      this.b = paramString;
      this.c = paramLong1;
      this.d = paramLong2;
    }
    
    long a()
    {
      return this.c;
    }
    
    long b()
    {
      return this.d;
    }
  }
  
  class b
  {
    private Map<String, x.a> b = new HashMap();
    
    b(File paramFile)
    {
      this.b.clear();
      a(paramFile);
    }
    
    private void a(File paramFile)
    {
      if (paramFile.isDirectory())
      {
        paramFile = paramFile.listFiles();
        int i = 0;
        while (i < paramFile.length)
        {
          a(paramFile[i]);
          i += 1;
        }
      }
      if (paramFile.isFile()) {
        a(paramFile.getName(), paramFile.length(), paramFile.lastModified());
      }
    }
    
    private void a(String paramString, long paramLong1, long paramLong2)
    {
      if ((paramString != null) && (paramString.length() > 0) && (paramLong1 > 0L) && (paramLong2 > 0L))
      {
        x.a locala = new x.a(x.this, paramString, paramLong1, paramLong2);
        if (!this.b.containsKey(paramString)) {
          this.b.put(paramString, locala);
        }
      }
    }
    
    Map<String, x.a> a()
    {
      return this.b;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\utils\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */