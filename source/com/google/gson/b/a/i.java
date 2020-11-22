package com.google.gson.b.a;

import com.google.gson.b.h;
import com.google.gson.c.a;
import com.google.gson.c.a<*>;
import com.google.gson.e;
import com.google.gson.r;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.google.gson.t;
import com.google.gson.u;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class i
  implements u
{
  private final com.google.gson.b.c a;
  private final com.google.gson.d b;
  private final com.google.gson.b.d c;
  private final d d;
  
  public i(com.google.gson.b.c paramc, com.google.gson.d paramd, com.google.gson.b.d paramd1, d paramd2)
  {
    this.a = paramc;
    this.b = paramd;
    this.c = paramd1;
    this.d = paramd2;
  }
  
  private b a(final e parame, final Field paramField, String paramString, final a<?> parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    final boolean bool2 = com.google.gson.b.i.a(parama.a());
    Object localObject1 = (com.google.gson.a.b)paramField.getAnnotation(com.google.gson.a.b.class);
    if (localObject1 != null) {
      localObject1 = this.d.a(this.a, parame, parama, (com.google.gson.a.b)localObject1);
    } else {
      localObject1 = null;
    }
    final boolean bool1;
    if (localObject1 != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    final Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = parame.a(parama);
    }
    new b(paramString, paramBoolean1, paramBoolean2)
    {
      void a(JsonReader paramAnonymousJsonReader, Object paramAnonymousObject)
        throws IOException, IllegalAccessException
      {
        paramAnonymousJsonReader = localObject2.b(paramAnonymousJsonReader);
        if ((paramAnonymousJsonReader != null) || (!bool2)) {
          paramField.set(paramAnonymousObject, paramAnonymousJsonReader);
        }
      }
      
      void a(JsonWriter paramAnonymousJsonWriter, Object paramAnonymousObject)
        throws IOException, IllegalAccessException
      {
        Object localObject = paramField.get(paramAnonymousObject);
        if (bool1) {
          paramAnonymousObject = localObject2;
        } else {
          paramAnonymousObject = new m(parame, localObject2, parama.b());
        }
        ((t)paramAnonymousObject).a(paramAnonymousJsonWriter, localObject);
      }
      
      public boolean a(Object paramAnonymousObject)
        throws IOException, IllegalAccessException
      {
        boolean bool2 = this.i;
        boolean bool1 = false;
        if (!bool2) {
          return false;
        }
        if (paramField.get(paramAnonymousObject) != paramAnonymousObject) {
          bool1 = true;
        }
        return bool1;
      }
    };
  }
  
  private List<String> a(Field paramField)
  {
    Object localObject = (com.google.gson.a.c)paramField.getAnnotation(com.google.gson.a.c.class);
    if (localObject == null) {
      return Collections.singletonList(this.b.translateName(paramField));
    }
    paramField = ((com.google.gson.a.c)localObject).a();
    localObject = ((com.google.gson.a.c)localObject).b();
    if (localObject.length == 0) {
      return Collections.singletonList(paramField);
    }
    ArrayList localArrayList = new ArrayList(localObject.length + 1);
    localArrayList.add(paramField);
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(localObject[i]);
      i += 1;
    }
    return localArrayList;
  }
  
  private Map<String, b> a(e parame, a<?> parama, Class<?> paramClass)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if (paramClass.isInterface()) {
      return localLinkedHashMap;
    }
    Type localType1 = parama.b();
    Object localObject1 = parama;
    while (paramClass != Object.class)
    {
      Field[] arrayOfField = paramClass.getDeclaredFields();
      int m = arrayOfField.length;
      int i = 0;
      while (i < m)
      {
        Field localField = arrayOfField[i];
        boolean bool1 = a(localField, true);
        boolean bool2 = a(localField, false);
        if ((bool1) || (bool2))
        {
          localField.setAccessible(true);
          Type localType2 = com.google.gson.b.b.a(((a)localObject1).b(), paramClass, localField.getGenericType());
          List localList = a(localField);
          int j = localList.size();
          parama = null;
          int k = 0;
          while (k < j)
          {
            Object localObject2 = (String)localList.get(k);
            if (k != 0) {
              bool1 = false;
            }
            localObject2 = (b)localLinkedHashMap.put(localObject2, a(parame, localField, (String)localObject2, a.a(localType2), bool1, bool2));
            if (parama == null) {
              parama = (a<?>)localObject2;
            }
            k += 1;
          }
          if (parama != null) {}
        }
        else
        {
          i += 1;
          continue;
        }
        parame = new StringBuilder();
        parame.append(localType1);
        parame.append(" declares multiple JSON fields named ");
        parame.append(parama.h);
        throw new IllegalArgumentException(parame.toString());
      }
      localObject1 = a.a(com.google.gson.b.b.a(((a)localObject1).b(), paramClass, paramClass.getGenericSuperclass()));
      paramClass = ((a)localObject1).a();
    }
    return localLinkedHashMap;
  }
  
  static boolean a(Field paramField, boolean paramBoolean, com.google.gson.b.d paramd)
  {
    return (!paramd.a(paramField.getType(), paramBoolean)) && (!paramd.a(paramField, paramBoolean));
  }
  
  public <T> t<T> a(e parame, a<T> parama)
  {
    Class localClass = parama.a();
    if (!Object.class.isAssignableFrom(localClass)) {
      return null;
    }
    return new a(this.a.a(parama), a(parame, parama, localClass));
  }
  
  public boolean a(Field paramField, boolean paramBoolean)
  {
    return a(paramField, paramBoolean, this.c);
  }
  
  public static final class a<T>
    extends t<T>
  {
    private final h<T> a;
    private final Map<String, i.b> b;
    
    a(h<T> paramh, Map<String, i.b> paramMap)
    {
      this.a = paramh;
      this.b = paramMap;
    }
    
    public void a(JsonWriter paramJsonWriter, T paramT)
      throws IOException
    {
      if (paramT == null)
      {
        paramJsonWriter.nullValue();
        return;
      }
      paramJsonWriter.beginObject();
      try
      {
        Iterator localIterator = this.b.values().iterator();
        while (localIterator.hasNext())
        {
          i.b localb = (i.b)localIterator.next();
          if (localb.a(paramT))
          {
            paramJsonWriter.name(localb.h);
            localb.a(paramJsonWriter, paramT);
          }
        }
        paramJsonWriter.endObject();
        return;
      }
      catch (IllegalAccessException paramJsonWriter)
      {
        throw new AssertionError(paramJsonWriter);
      }
    }
    
    public T b(JsonReader paramJsonReader)
      throws IOException
    {
      if (paramJsonReader.peek() == JsonToken.NULL)
      {
        paramJsonReader.nextNull();
        return null;
      }
      Object localObject1 = this.a.a();
      try
      {
        paramJsonReader.beginObject();
        while (paramJsonReader.hasNext())
        {
          Object localObject2 = paramJsonReader.nextName();
          localObject2 = (i.b)this.b.get(localObject2);
          if ((localObject2 != null) && (((i.b)localObject2).j)) {
            ((i.b)localObject2).a(paramJsonReader, localObject1);
          } else {
            paramJsonReader.skipValue();
          }
        }
        paramJsonReader.endObject();
        return (T)localObject1;
      }
      catch (IllegalAccessException paramJsonReader)
      {
        throw new AssertionError(paramJsonReader);
      }
      catch (IllegalStateException paramJsonReader)
      {
        throw new r(paramJsonReader);
      }
    }
  }
  
  static abstract class b
  {
    final String h;
    final boolean i;
    final boolean j;
    
    protected b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.h = paramString;
      this.i = paramBoolean1;
      this.j = paramBoolean2;
    }
    
    abstract void a(JsonReader paramJsonReader, Object paramObject)
      throws IOException, IllegalAccessException;
    
    abstract void a(JsonWriter paramJsonWriter, Object paramObject)
      throws IOException, IllegalAccessException;
    
    abstract boolean a(Object paramObject)
      throws IOException, IllegalAccessException;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\gson\b\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */