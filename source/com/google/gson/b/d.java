package com.google.gson.b;

import com.google.gson.b;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.t;
import com.google.gson.u;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class d
  implements u, Cloneable
{
  public static final d a = new d();
  private double b = -1.0D;
  private int c = 136;
  private boolean d = true;
  private boolean e;
  private List<com.google.gson.a> f = Collections.emptyList();
  private List<com.google.gson.a> g = Collections.emptyList();
  
  private boolean a(com.google.gson.a.d paramd)
  {
    return (paramd == null) || (paramd.a() <= this.b);
  }
  
  private boolean a(com.google.gson.a.d paramd, com.google.gson.a.e parame)
  {
    return (a(paramd)) && (a(parame));
  }
  
  private boolean a(com.google.gson.a.e parame)
  {
    return (parame == null) || (parame.a() > this.b);
  }
  
  private boolean a(Class<?> paramClass)
  {
    return (!Enum.class.isAssignableFrom(paramClass)) && ((paramClass.isAnonymousClass()) || (paramClass.isLocalClass()));
  }
  
  private boolean b(Class<?> paramClass)
  {
    return (paramClass.isMemberClass()) && (!c(paramClass));
  }
  
  private boolean c(Class<?> paramClass)
  {
    return (paramClass.getModifiers() & 0x8) != 0;
  }
  
  protected d a()
  {
    try
    {
      d locald = (d)super.clone();
      return locald;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
  }
  
  public <T> t<T> a(final com.google.gson.e parame, final com.google.gson.c.a<T> parama)
  {
    Class localClass = parama.a();
    final boolean bool1 = a(localClass, true);
    final boolean bool2 = a(localClass, false);
    if ((!bool1) && (!bool2)) {
      return null;
    }
    new t()
    {
      private t<T> f;
      
      private t<T> b()
      {
        t localt = this.f;
        if (localt != null) {
          return localt;
        }
        localt = parame.a(d.this, parama);
        this.f = localt;
        return localt;
      }
      
      public void a(JsonWriter paramAnonymousJsonWriter, T paramAnonymousT)
        throws IOException
      {
        if (bool1)
        {
          paramAnonymousJsonWriter.nullValue();
          return;
        }
        b().a(paramAnonymousJsonWriter, paramAnonymousT);
      }
      
      public T b(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        if (bool2)
        {
          paramAnonymousJsonReader.skipValue();
          return null;
        }
        return (T)b().b(paramAnonymousJsonReader);
      }
    };
  }
  
  public boolean a(Class<?> paramClass, boolean paramBoolean)
  {
    if ((this.b != -1.0D) && (!a((com.google.gson.a.d)paramClass.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e)paramClass.getAnnotation(com.google.gson.a.e.class)))) {
      return true;
    }
    if ((!this.d) && (b(paramClass))) {
      return true;
    }
    if (a(paramClass)) {
      return true;
    }
    if (paramBoolean) {
      localObject = this.f;
    } else {
      localObject = this.g;
    }
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((com.google.gson.a)((Iterator)localObject).next()).a(paramClass)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(Field paramField, boolean paramBoolean)
  {
    if ((this.c & paramField.getModifiers()) != 0) {
      return true;
    }
    if ((this.b != -1.0D) && (!a((com.google.gson.a.d)paramField.getAnnotation(com.google.gson.a.d.class), (com.google.gson.a.e)paramField.getAnnotation(com.google.gson.a.e.class)))) {
      return true;
    }
    if (paramField.isSynthetic()) {
      return true;
    }
    Object localObject;
    if (this.e)
    {
      localObject = (com.google.gson.a.a)paramField.getAnnotation(com.google.gson.a.a.class);
      if (localObject != null)
      {
        if (paramBoolean)
        {
          if (!((com.google.gson.a.a)localObject).a()) {
            return true;
          }
        }
        else if (((com.google.gson.a.a)localObject).b()) {}
      }
      else {
        return true;
      }
    }
    if ((!this.d) && (b(paramField.getType()))) {
      return true;
    }
    if (a(paramField.getType())) {
      return true;
    }
    if (paramBoolean) {
      localObject = this.f;
    } else {
      localObject = this.g;
    }
    if (!((List)localObject).isEmpty())
    {
      paramField = new b(paramField);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((com.google.gson.a)((Iterator)localObject).next()).a(paramField)) {
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\gson\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */