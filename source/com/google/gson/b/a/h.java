package com.google.gson.b.a;

import com.google.gson.b.g;
import com.google.gson.c.a;
import com.google.gson.e;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.t;
import com.google.gson.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class h
  extends t<Object>
{
  public static final u a = new u()
  {
    public <T> t<T> a(e paramAnonymouse, a<T> paramAnonymousa)
    {
      if (paramAnonymousa.a() == Object.class) {
        return new h(paramAnonymouse);
      }
      return null;
    }
  };
  private final e b;
  
  h(e parame)
  {
    this.b = parame;
  }
  
  public void a(JsonWriter paramJsonWriter, Object paramObject)
    throws IOException
  {
    if (paramObject == null)
    {
      paramJsonWriter.nullValue();
      return;
    }
    t localt = this.b.a(paramObject.getClass());
    if ((localt instanceof h))
    {
      paramJsonWriter.beginObject();
      paramJsonWriter.endObject();
      return;
    }
    localt.a(paramJsonWriter, paramObject);
  }
  
  public Object b(JsonReader paramJsonReader)
    throws IOException
  {
    Object localObject = paramJsonReader.peek();
    switch (2.a[localObject.ordinal()])
    {
    default: 
      throw new IllegalStateException();
    case 6: 
      paramJsonReader.nextNull();
      return null;
    case 5: 
      return Boolean.valueOf(paramJsonReader.nextBoolean());
    case 4: 
      return Double.valueOf(paramJsonReader.nextDouble());
    case 3: 
      return paramJsonReader.nextString();
    case 2: 
      localObject = new g();
      paramJsonReader.beginObject();
      while (paramJsonReader.hasNext()) {
        ((Map)localObject).put(paramJsonReader.nextName(), b(paramJsonReader));
      }
      paramJsonReader.endObject();
      return localObject;
    }
    localObject = new ArrayList();
    paramJsonReader.beginArray();
    while (paramJsonReader.hasNext()) {
      ((List)localObject).add(b(paramJsonReader));
    }
    paramJsonReader.endArray();
    return localObject;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\gson\b\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */