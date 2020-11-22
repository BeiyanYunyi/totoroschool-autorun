package com.google.gson;

import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public abstract class j
{
  public Number a()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public String b()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public double c()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public long d()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public int e()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public boolean f()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public boolean g()
  {
    return this instanceof g;
  }
  
  public boolean h()
  {
    return this instanceof m;
  }
  
  public boolean i()
  {
    return this instanceof o;
  }
  
  public boolean j()
  {
    return this instanceof l;
  }
  
  public m k()
  {
    if (h()) {
      return (m)this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Not a JSON Object: ");
    localStringBuilder.append(this);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public g l()
  {
    if (g()) {
      return (g)this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Not a JSON Array: ");
    localStringBuilder.append(this);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public o m()
  {
    if (i()) {
      return (o)this;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Not a JSON Primitive: ");
    localStringBuilder.append(this);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  Boolean n()
  {
    throw new UnsupportedOperationException(getClass().getSimpleName());
  }
  
  public String toString()
  {
    try
    {
      Object localObject = new StringWriter();
      JsonWriter localJsonWriter = new JsonWriter((Writer)localObject);
      localJsonWriter.setLenient(true);
      com.google.gson.b.j.a(this, localJsonWriter);
      localObject = ((StringWriter)localObject).toString();
      return (String)localObject;
    }
    catch (IOException localIOException)
    {
      throw new AssertionError(localIOException);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\gson\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */