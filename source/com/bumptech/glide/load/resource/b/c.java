package com.bumptech.glide.load.resource.b;

import com.bumptech.glide.load.e;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class c<T>
  implements e<File, T>
{
  private static final a a = new a();
  private e<InputStream, T> b;
  private final a c;
  
  public c(e<InputStream, T> parame)
  {
    this(parame, a);
  }
  
  c(e<InputStream, T> parame, a parama)
  {
    this.b = parame;
    this.c = parama;
  }
  
  /* Error */
  public com.bumptech.glide.load.b.k<T> a(File paramFile, int paramInt1, int paramInt2)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 34	com/bumptech/glide/load/resource/b/c:c	Lcom/bumptech/glide/load/resource/b/c$a;
    //   4: aload_1
    //   5: invokevirtual 41	com/bumptech/glide/load/resource/b/c$a:a	(Ljava/io/File;)Ljava/io/InputStream;
    //   8: astore 4
    //   10: aload_0
    //   11: getfield 32	com/bumptech/glide/load/resource/b/c:b	Lcom/bumptech/glide/load/e;
    //   14: aload 4
    //   16: iload_2
    //   17: iload_3
    //   18: invokeinterface 44 4 0
    //   23: astore_1
    //   24: aload 4
    //   26: ifnull +8 -> 34
    //   29: aload 4
    //   31: invokevirtual 49	java/io/InputStream:close	()V
    //   34: aload_1
    //   35: areturn
    //   36: astore_1
    //   37: goto +7 -> 44
    //   40: astore_1
    //   41: aconst_null
    //   42: astore 4
    //   44: aload 4
    //   46: ifnull +8 -> 54
    //   49: aload 4
    //   51: invokevirtual 49	java/io/InputStream:close	()V
    //   54: aload_1
    //   55: athrow
    //   56: astore 4
    //   58: aload_1
    //   59: areturn
    //   60: astore 4
    //   62: goto -8 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	this	c
    //   0	65	1	paramFile	File
    //   0	65	2	paramInt1	int
    //   0	65	3	paramInt2	int
    //   8	42	4	localInputStream	InputStream
    //   56	1	4	localIOException1	java.io.IOException
    //   60	1	4	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   10	24	36	finally
    //   0	10	40	finally
    //   29	34	56	java/io/IOException
    //   49	54	60	java/io/IOException
  }
  
  public String a()
  {
    return "";
  }
  
  static class a
  {
    public InputStream a(File paramFile)
      throws FileNotFoundException
    {
      return new FileInputStream(paramFile);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\resource\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */