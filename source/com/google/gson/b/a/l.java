package com.google.gson.b.a;

import com.google.gson.c.a;
import com.google.gson.e;
import com.google.gson.h;
import com.google.gson.i;
import com.google.gson.p;
import com.google.gson.q;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.t;
import com.google.gson.u;
import java.io.IOException;

public final class l<T>
  extends t<T>
{
  final e a;
  private final q<T> b;
  private final i<T> c;
  private final a<T> d;
  private final u e;
  private final l<T>.a f = new a(null);
  private t<T> g;
  
  public l(q<T> paramq, i<T> parami, e parame, a<T> parama, u paramu)
  {
    this.b = paramq;
    this.c = parami;
    this.a = parame;
    this.d = parama;
    this.e = paramu;
  }
  
  private t<T> b()
  {
    t localt = this.g;
    if (localt != null) {
      return localt;
    }
    localt = this.a.a(this.e, this.d);
    this.g = localt;
    return localt;
  }
  
  public void a(JsonWriter paramJsonWriter, T paramT)
    throws IOException
  {
    if (this.b == null)
    {
      b().a(paramJsonWriter, paramT);
      return;
    }
    if (paramT == null)
    {
      paramJsonWriter.nullValue();
      return;
    }
    com.google.gson.b.j.a(this.b.a(paramT, this.d.b(), this.f), paramJsonWriter);
  }
  
  public T b(JsonReader paramJsonReader)
    throws IOException
  {
    if (this.c == null) {
      return (T)b().b(paramJsonReader);
    }
    paramJsonReader = com.google.gson.b.j.a(paramJsonReader);
    if (paramJsonReader.j()) {
      return null;
    }
    return (T)this.c.a(paramJsonReader, this.d.b(), this.f);
  }
  
  private final class a
    implements h, p
  {
    private a() {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\gson\b\a\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */