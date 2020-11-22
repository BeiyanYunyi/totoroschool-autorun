package com.google.gson.b;

import com.google.gson.k;
import com.google.gson.l;
import com.google.gson.r;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import com.google.gson.t;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

public final class j
{
  public static com.google.gson.j a(JsonReader paramJsonReader)
    throws com.google.gson.n
  {
    try
    {
      paramJsonReader.peek();
      int i = 0;
      try
      {
        paramJsonReader = (com.google.gson.j)com.google.gson.b.a.n.X.b(paramJsonReader);
        return paramJsonReader;
      }
      catch (EOFException paramJsonReader) {}
      if (i == 0) {
        break label65;
      }
    }
    catch (NumberFormatException paramJsonReader)
    {
      throw new r(paramJsonReader);
    }
    catch (IOException paramJsonReader)
    {
      throw new k(paramJsonReader);
    }
    catch (MalformedJsonException paramJsonReader)
    {
      throw new r(paramJsonReader);
    }
    catch (EOFException paramJsonReader)
    {
      i = 1;
    }
    return l.a;
    label65:
    throw new r(paramJsonReader);
  }
  
  public static Writer a(Appendable paramAppendable)
  {
    if ((paramAppendable instanceof Writer)) {
      return (Writer)paramAppendable;
    }
    return new a(paramAppendable);
  }
  
  public static void a(com.google.gson.j paramj, JsonWriter paramJsonWriter)
    throws IOException
  {
    com.google.gson.b.a.n.X.a(paramJsonWriter, paramj);
  }
  
  private static final class a
    extends Writer
  {
    private final Appendable a;
    private final a b = new a();
    
    a(Appendable paramAppendable)
    {
      this.a = paramAppendable;
    }
    
    public void close() {}
    
    public void flush() {}
    
    public void write(int paramInt)
      throws IOException
    {
      this.a.append((char)paramInt);
    }
    
    public void write(char[] paramArrayOfChar, int paramInt1, int paramInt2)
      throws IOException
    {
      this.b.a = paramArrayOfChar;
      this.a.append(this.b, paramInt1, paramInt2 + paramInt1);
    }
    
    static class a
      implements CharSequence
    {
      char[] a;
      
      public char charAt(int paramInt)
      {
        return this.a[paramInt];
      }
      
      public int length()
      {
        return this.a.length;
      }
      
      public CharSequence subSequence(int paramInt1, int paramInt2)
      {
        return new String(this.a, paramInt1, paramInt2 - paramInt1);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\google\gson\b\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */