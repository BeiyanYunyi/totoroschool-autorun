package com.google.gson;

import com.google.gson.b.a.f;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

public abstract class t<T>
{
  public final j a(T paramT)
  {
    try
    {
      f localf = new f();
      a(localf, paramT);
      paramT = localf.a();
      return paramT;
    }
    catch (IOException paramT)
    {
      throw new k(paramT);
    }
  }
  
  public final t<T> a()
  {
    new t()
    {
      public void a(JsonWriter paramAnonymousJsonWriter, T paramAnonymousT)
        throws IOException
      {
        if (paramAnonymousT == null)
        {
          paramAnonymousJsonWriter.nullValue();
          return;
        }
        t.this.a(paramAnonymousJsonWriter, paramAnonymousT);
      }
      
      public T b(JsonReader paramAnonymousJsonReader)
        throws IOException
      {
        if (paramAnonymousJsonReader.peek() == JsonToken.NULL)
        {
          paramAnonymousJsonReader.nextNull();
          return null;
        }
        return (T)t.this.b(paramAnonymousJsonReader);
      }
    };
  }
  
  public abstract void a(JsonWriter paramJsonWriter, T paramT)
    throws IOException;
  
  public abstract T b(JsonReader paramJsonReader)
    throws IOException;
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\gson\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */