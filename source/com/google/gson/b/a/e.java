package com.google.gson.b.a;

import com.google.gson.g;
import com.google.gson.l;
import com.google.gson.m;
import com.google.gson.o;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class e
  extends JsonReader
{
  private static final Reader a = new Reader()
  {
    public void close()
      throws IOException
    {
      throw new AssertionError();
    }
    
    public int read(char[] paramAnonymousArrayOfChar, int paramAnonymousInt1, int paramAnonymousInt2)
      throws IOException
    {
      throw new AssertionError();
    }
  };
  private static final Object b = new Object();
  private Object[] c;
  private int d;
  private String[] e;
  private int[] f;
  
  private void a(JsonToken paramJsonToken)
    throws IOException
  {
    if (peek() == paramJsonToken) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected ");
    localStringBuilder.append(paramJsonToken);
    localStringBuilder.append(" but was ");
    localStringBuilder.append(peek());
    localStringBuilder.append(d());
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  private void a(Object paramObject)
  {
    if (this.d == this.c.length)
    {
      arrayOfObject = new Object[this.d * 2];
      int[] arrayOfInt = new int[this.d * 2];
      String[] arrayOfString = new String[this.d * 2];
      System.arraycopy(this.c, 0, arrayOfObject, 0, this.d);
      System.arraycopy(this.f, 0, arrayOfInt, 0, this.d);
      System.arraycopy(this.e, 0, arrayOfString, 0, this.d);
      this.c = arrayOfObject;
      this.f = arrayOfInt;
      this.e = arrayOfString;
    }
    Object[] arrayOfObject = this.c;
    int i = this.d;
    this.d = (i + 1);
    arrayOfObject[i] = paramObject;
  }
  
  private Object b()
  {
    return this.c[(this.d - 1)];
  }
  
  private Object c()
  {
    Object localObject = this.c;
    int i = this.d - 1;
    this.d = i;
    localObject = localObject[i];
    this.c[this.d] = null;
    return localObject;
  }
  
  private String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" at path ");
    localStringBuilder.append(getPath());
    return localStringBuilder.toString();
  }
  
  public void a()
    throws IOException
  {
    a(JsonToken.NAME);
    Map.Entry localEntry = (Map.Entry)((Iterator)b()).next();
    a(localEntry.getValue());
    a(new o((String)localEntry.getKey()));
  }
  
  public void beginArray()
    throws IOException
  {
    a(JsonToken.BEGIN_ARRAY);
    a(((g)b()).iterator());
    this.f[(this.d - 1)] = 0;
  }
  
  public void beginObject()
    throws IOException
  {
    a(JsonToken.BEGIN_OBJECT);
    a(((m)b()).o().iterator());
  }
  
  public void close()
    throws IOException
  {
    this.c = new Object[] { b };
    this.d = 1;
  }
  
  public void endArray()
    throws IOException
  {
    a(JsonToken.END_ARRAY);
    c();
    c();
    if (this.d > 0)
    {
      int[] arrayOfInt = this.f;
      int i = this.d - 1;
      arrayOfInt[i] += 1;
    }
  }
  
  public void endObject()
    throws IOException
  {
    a(JsonToken.END_OBJECT);
    c();
    c();
    if (this.d > 0)
    {
      int[] arrayOfInt = this.f;
      int i = this.d - 1;
      arrayOfInt[i] += 1;
    }
  }
  
  public String getPath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('$');
    int i;
    for (int j = 0; j < this.d; j = i + 1)
    {
      Object[] arrayOfObject;
      if ((this.c[j] instanceof g))
      {
        arrayOfObject = this.c;
        j += 1;
        i = j;
        if ((arrayOfObject[j] instanceof Iterator))
        {
          localStringBuilder.append('[');
          localStringBuilder.append(this.f[j]);
          localStringBuilder.append(']');
          i = j;
        }
      }
      else
      {
        i = j;
        if ((this.c[j] instanceof m))
        {
          arrayOfObject = this.c;
          j += 1;
          i = j;
          if ((arrayOfObject[j] instanceof Iterator))
          {
            localStringBuilder.append('.');
            i = j;
            if (this.e[j] != null)
            {
              localStringBuilder.append(this.e[j]);
              i = j;
            }
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public boolean hasNext()
    throws IOException
  {
    JsonToken localJsonToken = peek();
    return (localJsonToken != JsonToken.END_OBJECT) && (localJsonToken != JsonToken.END_ARRAY);
  }
  
  public boolean nextBoolean()
    throws IOException
  {
    a(JsonToken.BOOLEAN);
    boolean bool = ((o)c()).f();
    if (this.d > 0)
    {
      int[] arrayOfInt = this.f;
      int i = this.d - 1;
      arrayOfInt[i] += 1;
    }
    return bool;
  }
  
  public double nextDouble()
    throws IOException
  {
    Object localObject = peek();
    if ((localObject != JsonToken.NUMBER) && (localObject != JsonToken.STRING))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Expected ");
      localStringBuilder.append(JsonToken.NUMBER);
      localStringBuilder.append(" but was ");
      localStringBuilder.append(localObject);
      localStringBuilder.append(d());
      throw new IllegalStateException(localStringBuilder.toString());
    }
    double d1 = ((o)b()).c();
    if ((!isLenient()) && ((Double.isNaN(d1)) || (Double.isInfinite(d1))))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("JSON forbids NaN and infinities: ");
      ((StringBuilder)localObject).append(d1);
      throw new NumberFormatException(((StringBuilder)localObject).toString());
    }
    c();
    if (this.d > 0)
    {
      localObject = this.f;
      int i = this.d - 1;
      localObject[i] += 1;
    }
    return d1;
  }
  
  public int nextInt()
    throws IOException
  {
    Object localObject = peek();
    if ((localObject != JsonToken.NUMBER) && (localObject != JsonToken.STRING))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Expected ");
      localStringBuilder.append(JsonToken.NUMBER);
      localStringBuilder.append(" but was ");
      localStringBuilder.append(localObject);
      localStringBuilder.append(d());
      throw new IllegalStateException(localStringBuilder.toString());
    }
    int i = ((o)b()).e();
    c();
    if (this.d > 0)
    {
      localObject = this.f;
      int j = this.d - 1;
      localObject[j] += 1;
    }
    return i;
  }
  
  public long nextLong()
    throws IOException
  {
    Object localObject = peek();
    if ((localObject != JsonToken.NUMBER) && (localObject != JsonToken.STRING))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Expected ");
      localStringBuilder.append(JsonToken.NUMBER);
      localStringBuilder.append(" but was ");
      localStringBuilder.append(localObject);
      localStringBuilder.append(d());
      throw new IllegalStateException(localStringBuilder.toString());
    }
    long l = ((o)b()).d();
    c();
    if (this.d > 0)
    {
      localObject = this.f;
      int i = this.d - 1;
      localObject[i] += 1;
    }
    return l;
  }
  
  public String nextName()
    throws IOException
  {
    a(JsonToken.NAME);
    Map.Entry localEntry = (Map.Entry)((Iterator)b()).next();
    String str = (String)localEntry.getKey();
    this.e[(this.d - 1)] = str;
    a(localEntry.getValue());
    return str;
  }
  
  public void nextNull()
    throws IOException
  {
    a(JsonToken.NULL);
    c();
    if (this.d > 0)
    {
      int[] arrayOfInt = this.f;
      int i = this.d - 1;
      arrayOfInt[i] += 1;
    }
  }
  
  public String nextString()
    throws IOException
  {
    Object localObject1 = peek();
    Object localObject2;
    if ((localObject1 != JsonToken.STRING) && (localObject1 != JsonToken.NUMBER))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Expected ");
      ((StringBuilder)localObject2).append(JsonToken.STRING);
      ((StringBuilder)localObject2).append(" but was ");
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append(d());
      throw new IllegalStateException(((StringBuilder)localObject2).toString());
    }
    localObject1 = ((o)c()).b();
    if (this.d > 0)
    {
      localObject2 = this.f;
      int i = this.d - 1;
      localObject2[i] += 1;
    }
    return (String)localObject1;
  }
  
  public JsonToken peek()
    throws IOException
  {
    if (this.d == 0) {
      return JsonToken.END_DOCUMENT;
    }
    Object localObject = b();
    if ((localObject instanceof Iterator))
    {
      boolean bool = this.c[(this.d - 2)] instanceof m;
      localObject = (Iterator)localObject;
      if (((Iterator)localObject).hasNext())
      {
        if (bool) {
          return JsonToken.NAME;
        }
        a(((Iterator)localObject).next());
        return peek();
      }
      if (bool) {
        return JsonToken.END_OBJECT;
      }
      return JsonToken.END_ARRAY;
    }
    if ((localObject instanceof m)) {
      return JsonToken.BEGIN_OBJECT;
    }
    if ((localObject instanceof g)) {
      return JsonToken.BEGIN_ARRAY;
    }
    if ((localObject instanceof o))
    {
      localObject = (o)localObject;
      if (((o)localObject).q()) {
        return JsonToken.STRING;
      }
      if (((o)localObject).o()) {
        return JsonToken.BOOLEAN;
      }
      if (((o)localObject).p()) {
        return JsonToken.NUMBER;
      }
      throw new AssertionError();
    }
    if ((localObject instanceof l)) {
      return JsonToken.NULL;
    }
    if (localObject == b) {
      throw new IllegalStateException("JsonReader is closed");
    }
    throw new AssertionError();
  }
  
  public void skipValue()
    throws IOException
  {
    if (peek() == JsonToken.NAME)
    {
      nextName();
      this.e[(this.d - 2)] = "null";
    }
    else
    {
      c();
      if (this.d > 0) {
        this.e[(this.d - 1)] = "null";
      }
    }
    if (this.d > 0)
    {
      int[] arrayOfInt = this.f;
      int i = this.d - 1;
      arrayOfInt[i] += 1;
    }
  }
  
  public String toString()
  {
    return getClass().getSimpleName();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\gson\b\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */