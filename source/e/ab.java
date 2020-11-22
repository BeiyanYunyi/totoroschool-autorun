package e;

import e.a.c;
import f.d;
import f.f;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

public abstract class ab
{
  public static ab create(@Nullable v paramv, final f paramf)
  {
    new ab()
    {
      public long contentLength()
        throws IOException
      {
        return paramf.size();
      }
      
      @Nullable
      public v contentType()
      {
        return ab.this;
      }
      
      public void writeTo(d paramAnonymousd)
        throws IOException
      {
        paramAnonymousd.b(paramf);
      }
    };
  }
  
  public static ab create(@Nullable v paramv, final File paramFile)
  {
    if (paramFile != null) {
      new ab()
      {
        public long contentLength()
        {
          return paramFile.length();
        }
        
        @Nullable
        public v contentType()
        {
          return ab.this;
        }
        
        /* Error */
        public void writeTo(d paramAnonymousd)
          throws IOException
        {
          // Byte code:
          //   0: aconst_null
          //   1: astore_3
          //   2: aload_0
          //   3: getfield 17	e/ab$3:b	Ljava/io/File;
          //   6: invokestatic 41	f/l:a	(Ljava/io/File;)Lf/s;
          //   9: astore_2
          //   10: aload_1
          //   11: aload_2
          //   12: invokeinterface 46 2 0
          //   17: pop2
          //   18: aload_2
          //   19: invokestatic 51	e/a/c:a	(Ljava/io/Closeable;)V
          //   22: return
          //   23: astore_3
          //   24: aload_2
          //   25: astore_1
          //   26: aload_3
          //   27: astore_2
          //   28: goto +6 -> 34
          //   31: astore_2
          //   32: aload_3
          //   33: astore_1
          //   34: aload_1
          //   35: invokestatic 51	e/a/c:a	(Ljava/io/Closeable;)V
          //   38: aload_2
          //   39: athrow
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	40	0	this	3
          //   0	40	1	paramAnonymousd	d
          //   9	19	2	localObject1	Object
          //   31	8	2	localObject2	Object
          //   1	1	3	localObject3	Object
          //   23	10	3	localObject4	Object
          // Exception table:
          //   from	to	target	type
          //   10	18	23	finally
          //   2	10	31	finally
        }
      };
    }
    throw new NullPointerException("file == null");
  }
  
  public static ab create(@Nullable v paramv, String paramString)
  {
    Object localObject1 = c.e;
    Object localObject2 = paramv;
    if (paramv != null)
    {
      Charset localCharset = paramv.b();
      localObject1 = localCharset;
      localObject2 = paramv;
      if (localCharset == null)
      {
        localObject1 = c.e;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramv);
        ((StringBuilder)localObject2).append("; charset=utf-8");
        localObject2 = v.b(((StringBuilder)localObject2).toString());
      }
    }
    return create((v)localObject2, paramString.getBytes((Charset)localObject1));
  }
  
  public static ab create(@Nullable v paramv, byte[] paramArrayOfByte)
  {
    return create(paramv, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static ab create(@Nullable v paramv, final byte[] paramArrayOfByte, final int paramInt1, final int paramInt2)
  {
    if (paramArrayOfByte != null)
    {
      c.a(paramArrayOfByte.length, paramInt1, paramInt2);
      new ab()
      {
        public long contentLength()
        {
          return paramInt2;
        }
        
        @Nullable
        public v contentType()
        {
          return ab.this;
        }
        
        public void writeTo(d paramAnonymousd)
          throws IOException
        {
          paramAnonymousd.c(paramArrayOfByte, paramInt1, paramInt2);
        }
      };
    }
    throw new NullPointerException("content == null");
  }
  
  public long contentLength()
    throws IOException
  {
    return -1L;
  }
  
  @Nullable
  public abstract v contentType();
  
  public abstract void writeTo(d paramd)
    throws IOException;
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */