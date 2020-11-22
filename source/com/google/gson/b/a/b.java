package com.google.gson.b.a;

import com.google.gson.b.c;
import com.google.gson.b.h;
import com.google.gson.c.a;
import com.google.gson.e;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.t;
import com.google.gson.u;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

public final class b
  implements u
{
  private final c a;
  
  public b(c paramc)
  {
    this.a = paramc;
  }
  
  public <T> t<T> a(e parame, a<T> parama)
  {
    Type localType = parama.b();
    Class localClass = parama.a();
    if (!Collection.class.isAssignableFrom(localClass)) {
      return null;
    }
    localType = com.google.gson.b.b.a(localType, localClass);
    return new a(parame, localType, parame.a(a.a(localType)), this.a.a(parama));
  }
  
  private static final class a<E>
    extends t<Collection<E>>
  {
    private final t<E> a;
    private final h<? extends Collection<E>> b;
    
    public a(e parame, Type paramType, t<E> paramt, h<? extends Collection<E>> paramh)
    {
      this.a = new m(parame, paramt, paramType);
      this.b = paramh;
    }
    
    public Collection<E> a(JsonReader paramJsonReader)
      throws IOException
    {
      if (paramJsonReader.peek() == JsonToken.NULL)
      {
        paramJsonReader.nextNull();
        return null;
      }
      Collection localCollection = (Collection)this.b.a();
      paramJsonReader.beginArray();
      while (paramJsonReader.hasNext()) {
        localCollection.add(this.a.b(paramJsonReader));
      }
      paramJsonReader.endArray();
      return localCollection;
    }
    
    public void a(JsonWriter paramJsonWriter, Collection<E> paramCollection)
      throws IOException
    {
      if (paramCollection == null)
      {
        paramJsonWriter.nullValue();
        return;
      }
      paramJsonWriter.beginArray();
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Object localObject = paramCollection.next();
        this.a.a(paramJsonWriter, localObject);
      }
      paramJsonWriter.endArray();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\gson\b\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */