package com.google.gson;

import com.google.gson.b.a;
import com.google.gson.b.f;
import java.math.BigInteger;

public final class o
  extends j
{
  private static final Class<?>[] a = { Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class };
  private Object b;
  
  public o(Boolean paramBoolean)
  {
    a(paramBoolean);
  }
  
  public o(Number paramNumber)
  {
    a(paramNumber);
  }
  
  public o(String paramString)
  {
    a(paramString);
  }
  
  private static boolean a(o paramo)
  {
    boolean bool2 = paramo.b instanceof Number;
    boolean bool1 = false;
    if (bool2)
    {
      paramo = (Number)paramo.b;
      if (((paramo instanceof BigInteger)) || ((paramo instanceof Long)) || ((paramo instanceof Integer)) || ((paramo instanceof Short)) || ((paramo instanceof Byte))) {
        bool1 = true;
      }
      return bool1;
    }
    return false;
  }
  
  private static boolean b(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return true;
    }
    paramObject = paramObject.getClass();
    Class[] arrayOfClass = a;
    int j = arrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfClass[i].isAssignableFrom((Class)paramObject)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public Number a()
  {
    if ((this.b instanceof String)) {
      return new f((String)this.b);
    }
    return (Number)this.b;
  }
  
  void a(Object paramObject)
  {
    if ((paramObject instanceof Character))
    {
      this.b = String.valueOf(((Character)paramObject).charValue());
      return;
    }
    boolean bool;
    if ((!(paramObject instanceof Number)) && (!b(paramObject))) {
      bool = false;
    } else {
      bool = true;
    }
    a.a(bool);
    this.b = paramObject;
  }
  
  public String b()
  {
    if (p()) {
      return a().toString();
    }
    if (o()) {
      return n().toString();
    }
    return (String)this.b;
  }
  
  public double c()
  {
    if (p()) {
      return a().doubleValue();
    }
    return Double.parseDouble(b());
  }
  
  public long d()
  {
    if (p()) {
      return a().longValue();
    }
    return Long.parseLong(b());
  }
  
  public int e()
  {
    if (p()) {
      return a().intValue();
    }
    return Integer.parseInt(b());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (o)paramObject;
      if (this.b == null) {
        return ((o)paramObject).b == null;
      }
      if ((a(this)) && (a((o)paramObject))) {
        return a().longValue() == ((o)paramObject).a().longValue();
      }
      if (((this.b instanceof Number)) && ((((o)paramObject).b instanceof Number)))
      {
        double d1 = a().doubleValue();
        double d2 = ((o)paramObject).a().doubleValue();
        if (d1 != d2)
        {
          if ((Double.isNaN(d1)) && (Double.isNaN(d2))) {
            return true;
          }
          bool = false;
        }
        return bool;
      }
      return this.b.equals(((o)paramObject).b);
    }
    return false;
  }
  
  public boolean f()
  {
    if (o()) {
      return n().booleanValue();
    }
    return Boolean.parseBoolean(b());
  }
  
  public int hashCode()
  {
    if (this.b == null) {
      return 31;
    }
    long l;
    if (a(this))
    {
      l = a().longValue();
      return (int)(l >>> 32 ^ l);
    }
    if ((this.b instanceof Number))
    {
      l = Double.doubleToLongBits(a().doubleValue());
      return (int)(l >>> 32 ^ l);
    }
    return this.b.hashCode();
  }
  
  Boolean n()
  {
    return (Boolean)this.b;
  }
  
  public boolean o()
  {
    return this.b instanceof Boolean;
  }
  
  public boolean p()
  {
    return this.b instanceof Number;
  }
  
  public boolean q()
  {
    return this.b instanceof String;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\gson\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */