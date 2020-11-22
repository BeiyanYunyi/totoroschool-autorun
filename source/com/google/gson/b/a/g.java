package com.google.gson.b.a;

import com.google.gson.b.b;
import com.google.gson.b.c;
import com.google.gson.b.h;
import com.google.gson.c.a;
import com.google.gson.o;
import com.google.gson.r;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.t;
import com.google.gson.u;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class g
  implements u
{
  final boolean a;
  private final c b;
  
  public g(c paramc, boolean paramBoolean)
  {
    this.b = paramc;
    this.a = paramBoolean;
  }
  
  private t<?> a(com.google.gson.e parame, Type paramType)
  {
    if ((paramType != Boolean.TYPE) && (paramType != Boolean.class)) {
      return parame.a(a.a(paramType));
    }
    return n.f;
  }
  
  public <T> t<T> a(com.google.gson.e parame, a<T> parama)
  {
    Object localObject = parama.b();
    if (!Map.class.isAssignableFrom(parama.a())) {
      return null;
    }
    localObject = b.b((Type)localObject, b.e((Type)localObject));
    t localt1 = a(parame, localObject[0]);
    t localt2 = parame.a(a.a(localObject[1]));
    parama = this.b.a(parama);
    return new a(parame, localObject[0], localt1, localObject[1], localt2, parama);
  }
  
  private final class a<K, V>
    extends t<Map<K, V>>
  {
    private final t<K> b;
    private final t<V> c;
    private final h<? extends Map<K, V>> d;
    
    public a(Type paramType1, t<K> paramt, Type paramType2, t<V> paramt1, h<? extends Map<K, V>> paramh)
    {
      this.b = new m(paramType1, paramType2, paramt);
      this.c = new m(paramType1, paramh, paramt1);
      h localh;
      this.d = localh;
    }
    
    private String a(com.google.gson.j paramj)
    {
      if (paramj.i())
      {
        paramj = paramj.m();
        if (paramj.p()) {
          return String.valueOf(paramj.a());
        }
        if (paramj.o()) {
          return Boolean.toString(paramj.f());
        }
        if (paramj.q()) {
          return paramj.b();
        }
        throw new AssertionError();
      }
      if (paramj.j()) {
        return "null";
      }
      throw new AssertionError();
    }
    
    public Map<K, V> a(JsonReader paramJsonReader)
      throws IOException
    {
      Object localObject = paramJsonReader.peek();
      if (localObject == JsonToken.NULL)
      {
        paramJsonReader.nextNull();
        return null;
      }
      Map localMap = (Map)this.d.a();
      if (localObject == JsonToken.BEGIN_ARRAY)
      {
        paramJsonReader.beginArray();
        while (paramJsonReader.hasNext())
        {
          paramJsonReader.beginArray();
          localObject = this.b.b(paramJsonReader);
          if (localMap.put(localObject, this.c.b(paramJsonReader)) == null)
          {
            paramJsonReader.endArray();
          }
          else
          {
            paramJsonReader = new StringBuilder();
            paramJsonReader.append("duplicate key: ");
            paramJsonReader.append(localObject);
            throw new r(paramJsonReader.toString());
          }
        }
        paramJsonReader.endArray();
        return localMap;
      }
      paramJsonReader.beginObject();
      while (paramJsonReader.hasNext())
      {
        com.google.gson.b.e.INSTANCE.promoteNameToValue(paramJsonReader);
        localObject = this.b.b(paramJsonReader);
        if (localMap.put(localObject, this.c.b(paramJsonReader)) != null)
        {
          paramJsonReader = new StringBuilder();
          paramJsonReader.append("duplicate key: ");
          paramJsonReader.append(localObject);
          throw new r(paramJsonReader.toString());
        }
      }
      paramJsonReader.endObject();
      return localMap;
    }
    
    public void a(JsonWriter paramJsonWriter, Map<K, V> paramMap)
      throws IOException
    {
      if (paramMap == null)
      {
        paramJsonWriter.nullValue();
        return;
      }
      if (!g.this.a)
      {
        paramJsonWriter.beginObject();
        paramMap = paramMap.entrySet().iterator();
        while (paramMap.hasNext())
        {
          localObject = (Map.Entry)paramMap.next();
          paramJsonWriter.name(String.valueOf(((Map.Entry)localObject).getKey()));
          this.c.a(paramJsonWriter, ((Map.Entry)localObject).getValue());
        }
        paramJsonWriter.endObject();
        return;
      }
      Object localObject = new ArrayList(paramMap.size());
      ArrayList localArrayList = new ArrayList(paramMap.size());
      paramMap = paramMap.entrySet().iterator();
      int m = 0;
      int k = 0;
      int i = 0;
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        com.google.gson.j localj = this.b.a(localEntry.getKey());
        ((List)localObject).add(localj);
        localArrayList.add(localEntry.getValue());
        if ((!localj.g()) && (!localj.h())) {
          j = 0;
        } else {
          j = 1;
        }
        i |= j;
      }
      if (i != 0)
      {
        paramJsonWriter.beginArray();
        j = ((List)localObject).size();
        i = k;
        while (i < j)
        {
          paramJsonWriter.beginArray();
          com.google.gson.b.j.a((com.google.gson.j)((List)localObject).get(i), paramJsonWriter);
          this.c.a(paramJsonWriter, localArrayList.get(i));
          paramJsonWriter.endArray();
          i += 1;
        }
        paramJsonWriter.endArray();
        return;
      }
      paramJsonWriter.beginObject();
      int j = ((List)localObject).size();
      i = m;
      while (i < j)
      {
        paramJsonWriter.name(a((com.google.gson.j)((List)localObject).get(i)));
        this.c.a(paramJsonWriter, localArrayList.get(i));
        i += 1;
      }
      paramJsonWriter.endObject();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\gson\b\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */