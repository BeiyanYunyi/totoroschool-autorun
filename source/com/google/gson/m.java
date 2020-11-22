package com.google.gson;

import com.google.gson.b.g;
import java.util.Map.Entry;
import java.util.Set;

public final class m
  extends j
{
  private final g<String, j> a = new g();
  
  public void a(String paramString, j paramj)
  {
    Object localObject = paramj;
    if (paramj == null) {
      localObject = l.a;
    }
    this.a.put(paramString, localObject);
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof m)) && (((m)paramObject).a.equals(this.a)));
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public Set<Map.Entry<String, j>> o()
  {
    return this.a.entrySet();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\gson\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */