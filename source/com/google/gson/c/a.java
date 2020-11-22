package com.google.gson.c;

import com.google.gson.b.b;
import java.lang.reflect.Type;

public class a<T>
{
  final Class<? super T> a;
  final Type b;
  final int c;
  
  protected a()
  {
    this.b = a(getClass());
    this.a = b.e(this.b);
    this.c = this.b.hashCode();
  }
  
  a(Type paramType)
  {
    this.b = b.d((Type)com.google.gson.b.a.a(paramType));
    this.a = b.e(this.b);
    this.c = this.b.hashCode();
  }
  
  public static a<?> a(Type paramType)
  {
    return new a(paramType);
  }
  
  static Type a(Class<?> paramClass)
  {
    paramClass = paramClass.getGenericSuperclass();
    if (!(paramClass instanceof Class)) {
      return b.d(((java.lang.reflect.ParameterizedType)paramClass).getActualTypeArguments()[0]);
    }
    throw new RuntimeException("Missing type parameter.");
  }
  
  public static <T> a<T> b(Class<T> paramClass)
  {
    return new a(paramClass);
  }
  
  public final Class<? super T> a()
  {
    return this.a;
  }
  
  public final Type b()
  {
    return this.b;
  }
  
  public final boolean equals(Object paramObject)
  {
    return ((paramObject instanceof a)) && (b.a(this.b, ((a)paramObject).b));
  }
  
  public final int hashCode()
  {
    return this.c;
  }
  
  public final String toString()
  {
    return b.f(this.b);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\gson\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */