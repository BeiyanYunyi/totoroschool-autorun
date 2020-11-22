package com.google.gson.b.a;

import com.google.gson.c.a;
import com.google.gson.e;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.t;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class m<T>
  extends t<T>
{
  private final e a;
  private final t<T> b;
  private final Type c;
  
  m(e parame, t<T> paramt, Type paramType)
  {
    this.a = parame;
    this.b = paramt;
    this.c = paramType;
  }
  
  private Type a(Type paramType, Object paramObject)
  {
    Object localObject = paramType;
    if (paramObject != null) {
      if ((paramType != Object.class) && (!(paramType instanceof TypeVariable)))
      {
        localObject = paramType;
        if (!(paramType instanceof Class)) {}
      }
      else
      {
        localObject = paramObject.getClass();
      }
    }
    return (Type)localObject;
  }
  
  public void a(JsonWriter paramJsonWriter, T paramT)
    throws IOException
  {
    t localt = this.b;
    Type localType = a(this.c, paramT);
    if (localType != this.c)
    {
      localt = this.a.a(a.a(localType));
      if (((localt instanceof i.a)) && (!(this.b instanceof i.a))) {
        localt = this.b;
      }
    }
    localt.a(paramJsonWriter, paramT);
  }
  
  public T b(JsonReader paramJsonReader)
    throws IOException
  {
    return (T)this.b.b(paramJsonReader);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\gson\b\a\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */