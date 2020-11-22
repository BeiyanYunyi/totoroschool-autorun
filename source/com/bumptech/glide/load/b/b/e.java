package com.bumptech.glide.load.b.b;

import android.util.Log;
import com.bumptech.glide.a.a.c;
import java.io.File;
import java.io.IOException;

public class e
  implements a
{
  private static e a;
  private final c b = new c();
  private final j c;
  private final File d;
  private final int e;
  private com.bumptech.glide.a.a f;
  
  protected e(File paramFile, int paramInt)
  {
    this.d = paramFile;
    this.e = paramInt;
    this.c = new j();
  }
  
  private com.bumptech.glide.a.a a()
    throws IOException
  {
    try
    {
      if (this.f == null) {
        this.f = com.bumptech.glide.a.a.a(this.d, 1, 1, this.e);
      }
      com.bumptech.glide.a.a locala = this.f;
      return locala;
    }
    finally {}
  }
  
  public static a a(File paramFile, int paramInt)
  {
    try
    {
      if (a == null) {
        a = new e(paramFile, paramInt);
      }
      paramFile = a;
      return paramFile;
    }
    finally {}
  }
  
  public File a(com.bumptech.glide.load.c paramc)
  {
    paramc = this.c.a(paramc);
    try
    {
      paramc = a().a(paramc);
      if (paramc != null)
      {
        paramc = paramc.a(0);
        return paramc;
      }
    }
    catch (IOException paramc)
    {
      if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
        Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", paramc);
      }
    }
    return null;
  }
  
  /* Error */
  public void a(com.bumptech.glide.load.c paramc, a.b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 39	com/bumptech/glide/load/b/b/e:c	Lcom/bumptech/glide/load/b/b/j;
    //   4: aload_1
    //   5: invokevirtual 59	com/bumptech/glide/load/b/b/j:a	(Lcom/bumptech/glide/load/c;)Ljava/lang/String;
    //   8: astore_3
    //   9: aload_0
    //   10: getfield 30	com/bumptech/glide/load/b/b/e:b	Lcom/bumptech/glide/load/b/b/c;
    //   13: aload_1
    //   14: invokevirtual 87	com/bumptech/glide/load/b/b/c:a	(Lcom/bumptech/glide/load/c;)V
    //   17: aload_0
    //   18: invokespecial 61	com/bumptech/glide/load/b/b/e:a	()Lcom/bumptech/glide/a/a;
    //   21: aload_3
    //   22: invokevirtual 90	com/bumptech/glide/a/a:b	(Ljava/lang/String;)Lcom/bumptech/glide/a/a$a;
    //   25: astore_3
    //   26: aload_3
    //   27: ifnull +35 -> 62
    //   30: aload_2
    //   31: aload_3
    //   32: iconst_0
    //   33: invokevirtual 93	com/bumptech/glide/a/a$a:a	(I)Ljava/io/File;
    //   36: invokeinterface 98 2 0
    //   41: ifeq +7 -> 48
    //   44: aload_3
    //   45: invokevirtual 100	com/bumptech/glide/a/a$a:a	()V
    //   48: aload_3
    //   49: invokevirtual 102	com/bumptech/glide/a/a$a:c	()V
    //   52: goto +10 -> 62
    //   55: astore_2
    //   56: aload_3
    //   57: invokevirtual 102	com/bumptech/glide/a/a$a:c	()V
    //   60: aload_2
    //   61: athrow
    //   62: aload_0
    //   63: getfield 30	com/bumptech/glide/load/b/b/e:b	Lcom/bumptech/glide/load/b/b/c;
    //   66: aload_1
    //   67: invokevirtual 104	com/bumptech/glide/load/b/b/c:b	(Lcom/bumptech/glide/load/c;)V
    //   70: return
    //   71: astore_2
    //   72: goto +25 -> 97
    //   75: astore_2
    //   76: ldc 71
    //   78: iconst_5
    //   79: invokestatic 77	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   82: ifeq -20 -> 62
    //   85: ldc 71
    //   87: ldc 106
    //   89: aload_2
    //   90: invokestatic 83	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   93: pop
    //   94: goto -32 -> 62
    //   97: aload_0
    //   98: getfield 30	com/bumptech/glide/load/b/b/e:b	Lcom/bumptech/glide/load/b/b/c;
    //   101: aload_1
    //   102: invokevirtual 104	com/bumptech/glide/load/b/b/c:b	(Lcom/bumptech/glide/load/c;)V
    //   105: aload_2
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	this	e
    //   0	107	1	paramc	com.bumptech.glide.load.c
    //   0	107	2	paramb	a.b
    //   8	49	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   30	48	55	finally
    //   17	26	71	finally
    //   48	52	71	finally
    //   56	62	71	finally
    //   76	94	71	finally
    //   17	26	75	java/io/IOException
    //   48	52	75	java/io/IOException
    //   56	62	75	java/io/IOException
  }
  
  public void b(com.bumptech.glide.load.c paramc)
  {
    paramc = this.c.a(paramc);
    try
    {
      a().c(paramc);
      return;
    }
    catch (IOException paramc)
    {
      if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
        Log.w("DiskLruCacheWrapper", "Unable to delete from disk cache", paramc);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\b\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */