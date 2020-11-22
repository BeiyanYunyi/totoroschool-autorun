package com.google.gson.b;

import java.io.ObjectStreamException;
import java.math.BigDecimal;

public final class f
  extends Number
{
  private final String value;
  
  public f(String paramString)
  {
    this.value = paramString;
  }
  
  private Object writeReplace()
    throws ObjectStreamException
  {
    return new BigDecimal(this.value);
  }
  
  public double doubleValue()
  {
    return Double.parseDouble(this.value);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof f))
    {
      paramObject = (f)paramObject;
      if (this.value != ((f)paramObject).value)
      {
        if (this.value.equals(((f)paramObject).value)) {
          return true;
        }
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public float floatValue()
  {
    return Float.parseFloat(this.value);
  }
  
  public int hashCode()
  {
    return this.value.hashCode();
  }
  
  public int intValue()
  {
    try
    {
      int i = Integer.parseInt(this.value);
      return i;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      long l;
      label21:
      for (;;) {}
    }
    try
    {
      l = Long.parseLong(this.value);
      return (int)l;
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      break label21;
    }
    return new BigDecimal(this.value).intValue();
  }
  
  public long longValue()
  {
    try
    {
      long l = Long.parseLong(this.value);
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;) {}
    }
    return new BigDecimal(this.value).longValue();
  }
  
  public String toString()
  {
    return this.value;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\gson\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */