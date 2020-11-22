package com.google.gson.b.a;

import com.google.gson.b.b;
import com.google.gson.e;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.t;
import com.google.gson.u;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;

public final class a<E>
  extends t<Object>
{
  public static final u a = new u()
  {
    public <T> t<T> a(e paramAnonymouse, com.google.gson.c.a<T> paramAnonymousa)
    {
      paramAnonymousa = paramAnonymousa.b();
      if ((!(paramAnonymousa instanceof GenericArrayType)) && ((!(paramAnonymousa instanceof Class)) || (!((Class)paramAnonymousa).isArray()))) {
        return null;
      }
      paramAnonymousa = b.g(paramAnonymousa);
      return new a(paramAnonymouse, paramAnonymouse.a(com.google.gson.c.a.a(paramAnonymousa)), b.e(paramAnonymousa));
    }
  };
  private final Class<E> b;
  private final t<E> c;
  
  public a(e parame, t<E> paramt, Class<E> paramClass)
  {
    this.c = new m(parame, paramt, paramClass);
    this.b = paramClass;
  }
  
  public void a(JsonWriter paramJsonWriter, Object paramObject)
    throws IOException
  {
    if (paramObject == null)
    {
      paramJsonWriter.nullValue();
      return;
    }
    paramJsonWriter.beginArray();
    int i = 0;
    int j = Array.getLength(paramObject);
    while (i < j)
    {
      Object localObject = Array.get(paramObject, i);
      this.c.a(paramJsonWriter, localObject);
      i += 1;
    }
    paramJsonWriter.endArray();
  }
  
  public Object b(JsonReader paramJsonReader)
    throws IOException
  {
    if (paramJsonReader.peek() == JsonToken.NULL)
    {
      paramJsonReader.nextNull();
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramJsonReader.beginArray();
    while (paramJsonReader.hasNext()) {
      localArrayList.add(this.c.b(paramJsonReader));
    }
    paramJsonReader.endArray();
    int j = localArrayList.size();
    paramJsonReader = Array.newInstance(this.b, j);
    int i = 0;
    while (i < j)
    {
      Array.set(paramJsonReader, i, localArrayList.get(i));
      i += 1;
    }
    return paramJsonReader;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\gson\b\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */