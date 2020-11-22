package com.google.gson.b.a;

import com.google.gson.g;
import com.google.gson.j;
import com.google.gson.l;
import com.google.gson.m;
import com.google.gson.o;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class f
  extends JsonWriter
{
  private static final Writer a = new Writer()
  {
    public void close()
      throws IOException
    {
      throw new AssertionError();
    }
    
    public void flush()
      throws IOException
    {
      throw new AssertionError();
    }
    
    public void write(char[] paramAnonymousArrayOfChar, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      throw new AssertionError();
    }
  };
  private static final o b = new o("closed");
  private final List<j> c = new ArrayList();
  private String d;
  private j e = l.a;
  
  public f()
  {
    super(a);
  }
  
  private void a(j paramj)
  {
    if (this.d != null)
    {
      if ((!paramj.j()) || (getSerializeNulls())) {
        ((m)b()).a(this.d, paramj);
      }
      this.d = null;
      return;
    }
    if (this.c.isEmpty())
    {
      this.e = paramj;
      return;
    }
    j localj = b();
    if ((localj instanceof g))
    {
      ((g)localj).a(paramj);
      return;
    }
    throw new IllegalStateException();
  }
  
  private j b()
  {
    return (j)this.c.get(this.c.size() - 1);
  }
  
  public j a()
  {
    if (this.c.isEmpty()) {
      return this.e;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected one JSON element but was ");
    localStringBuilder.append(this.c);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public JsonWriter beginArray()
    throws IOException
  {
    g localg = new g();
    a(localg);
    this.c.add(localg);
    return this;
  }
  
  public JsonWriter beginObject()
    throws IOException
  {
    m localm = new m();
    a(localm);
    this.c.add(localm);
    return this;
  }
  
  public void close()
    throws IOException
  {
    if (this.c.isEmpty())
    {
      this.c.add(b);
      return;
    }
    throw new IOException("Incomplete document");
  }
  
  public JsonWriter endArray()
    throws IOException
  {
    if ((!this.c.isEmpty()) && (this.d == null))
    {
      if ((b() instanceof g))
      {
        this.c.remove(this.c.size() - 1);
        return this;
      }
      throw new IllegalStateException();
    }
    throw new IllegalStateException();
  }
  
  public JsonWriter endObject()
    throws IOException
  {
    if ((!this.c.isEmpty()) && (this.d == null))
    {
      if ((b() instanceof m))
      {
        this.c.remove(this.c.size() - 1);
        return this;
      }
      throw new IllegalStateException();
    }
    throw new IllegalStateException();
  }
  
  public void flush()
    throws IOException
  {}
  
  public JsonWriter name(String paramString)
    throws IOException
  {
    if ((!this.c.isEmpty()) && (this.d == null))
    {
      if ((b() instanceof m))
      {
        this.d = paramString;
        return this;
      }
      throw new IllegalStateException();
    }
    throw new IllegalStateException();
  }
  
  public JsonWriter nullValue()
    throws IOException
  {
    a(l.a);
    return this;
  }
  
  public JsonWriter value(double paramDouble)
    throws IOException
  {
    if ((!isLenient()) && ((Double.isNaN(paramDouble)) || (Double.isInfinite(paramDouble))))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("JSON forbids NaN and infinities: ");
      localStringBuilder.append(paramDouble);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    a(new o(Double.valueOf(paramDouble)));
    return this;
  }
  
  public JsonWriter value(long paramLong)
    throws IOException
  {
    a(new o(Long.valueOf(paramLong)));
    return this;
  }
  
  public JsonWriter value(Boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean == null) {
      return nullValue();
    }
    a(new o(paramBoolean));
    return this;
  }
  
  public JsonWriter value(Number paramNumber)
    throws IOException
  {
    if (paramNumber == null) {
      return nullValue();
    }
    if (!isLenient())
    {
      double d1 = paramNumber.doubleValue();
      if ((Double.isNaN(d1)) || (Double.isInfinite(d1)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("JSON forbids NaN and infinities: ");
        localStringBuilder.append(paramNumber);
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
    }
    a(new o(paramNumber));
    return this;
  }
  
  public JsonWriter value(String paramString)
    throws IOException
  {
    if (paramString == null) {
      return nullValue();
    }
    a(new o(paramString));
    return this;
  }
  
  public JsonWriter value(boolean paramBoolean)
    throws IOException
  {
    a(new o(Boolean.valueOf(paramBoolean)));
    return this;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\gson\b\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */