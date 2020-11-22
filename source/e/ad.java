package e;

import f.e;
import f.f;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

public abstract class ad
  implements Closeable
{
  @Nullable
  private Reader reader;
  
  private Charset charset()
  {
    v localv = contentType();
    if (localv != null) {
      return localv.a(e.a.c.e);
    }
    return e.a.c.e;
  }
  
  public static ad create(@Nullable v paramv, final long paramLong, e parame)
  {
    if (parame != null) {
      new ad()
      {
        public long contentLength()
        {
          return paramLong;
        }
        
        @Nullable
        public v contentType()
        {
          return ad.this;
        }
        
        public e source()
        {
          return this.c;
        }
      };
    }
    throw new NullPointerException("source == null");
  }
  
  public static ad create(@Nullable v paramv, f paramf)
  {
    f.c localc = new f.c().a(paramf);
    return create(paramv, paramf.size(), localc);
  }
  
  public static ad create(@Nullable v paramv, String paramString)
  {
    Object localObject1 = e.a.c.e;
    Object localObject2 = paramv;
    if (paramv != null)
    {
      Charset localCharset = paramv.b();
      localObject1 = localCharset;
      localObject2 = paramv;
      if (localCharset == null)
      {
        localObject1 = e.a.c.e;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramv);
        ((StringBuilder)localObject2).append("; charset=utf-8");
        localObject2 = v.b(((StringBuilder)localObject2).toString());
      }
    }
    paramv = new f.c().a(paramString, (Charset)localObject1);
    return create((v)localObject2, paramv.a(), paramv);
  }
  
  public static ad create(@Nullable v paramv, byte[] paramArrayOfByte)
  {
    f.c localc = new f.c().b(paramArrayOfByte);
    return create(paramv, paramArrayOfByte.length, localc);
  }
  
  public final InputStream byteStream()
  {
    return source().f();
  }
  
  public final byte[] bytes()
    throws IOException
  {
    long l = contentLength();
    if (l <= 2147483647L)
    {
      localObject1 = source();
      try
      {
        byte[] arrayOfByte = ((e)localObject1).r();
        e.a.c.a((Closeable)localObject1);
        if (l != -1L)
        {
          if (l == arrayOfByte.length) {
            return arrayOfByte;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Content-Length (");
          ((StringBuilder)localObject1).append(l);
          ((StringBuilder)localObject1).append(") and stream length (");
          ((StringBuilder)localObject1).append(arrayOfByte.length);
          ((StringBuilder)localObject1).append(") disagree");
          throw new IOException(((StringBuilder)localObject1).toString());
        }
        return arrayOfByte;
      }
      finally
      {
        e.a.c.a((Closeable)localObject1);
      }
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Cannot buffer entire body for content length: ");
    ((StringBuilder)localObject1).append(l);
    throw new IOException(((StringBuilder)localObject1).toString());
  }
  
  public final Reader charStream()
  {
    Object localObject = this.reader;
    if (localObject != null) {
      return (Reader)localObject;
    }
    localObject = new a(source(), charset());
    this.reader = ((Reader)localObject);
    return (Reader)localObject;
  }
  
  public void close()
  {
    e.a.c.a(source());
  }
  
  public abstract long contentLength();
  
  @Nullable
  public abstract v contentType();
  
  public abstract e source();
  
  public final String string()
    throws IOException
  {
    e locale = source();
    try
    {
      String str = locale.a(e.a.c.a(locale, charset()));
      return str;
    }
    finally
    {
      e.a.c.a(locale);
    }
  }
  
  static final class a
    extends Reader
  {
    private final e a;
    private final Charset b;
    private boolean c;
    @Nullable
    private Reader d;
    
    a(e parame, Charset paramCharset)
    {
      this.a = parame;
      this.b = paramCharset;
    }
    
    public void close()
      throws IOException
    {
      this.c = true;
      if (this.d != null)
      {
        this.d.close();
        return;
      }
      this.a.close();
    }
    
    public int read(char[] paramArrayOfChar, int paramInt1, int paramInt2)
      throws IOException
    {
      if (!this.c)
      {
        Reader localReader = this.d;
        Object localObject = localReader;
        if (localReader == null)
        {
          localObject = e.a.c.a(this.a, this.b);
          localObject = new InputStreamReader(this.a.f(), (Charset)localObject);
          this.d = ((Reader)localObject);
        }
        return ((Reader)localObject).read(paramArrayOfChar, paramInt1, paramInt2);
      }
      throw new IOException("Stream closed");
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */