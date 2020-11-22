package com.bumptech.glide.load.c;

import com.bumptech.glide.load.b;
import java.io.InputStream;

public class o
  implements b<InputStream>
{
  public String a()
  {
    return "";
  }
  
  /* Error */
  public boolean a(InputStream paramInputStream, java.io.OutputStream paramOutputStream)
  {
    // Byte code:
    //   0: invokestatic 24	com/bumptech/glide/h/a:a	()Lcom/bumptech/glide/h/a;
    //   3: invokevirtual 28	com/bumptech/glide/h/a:b	()[B
    //   6: astore 4
    //   8: aload_1
    //   9: aload 4
    //   11: invokevirtual 34	java/io/InputStream:read	([B)I
    //   14: istore_3
    //   15: iload_3
    //   16: iconst_m1
    //   17: if_icmpeq +14 -> 31
    //   20: aload_2
    //   21: aload 4
    //   23: iconst_0
    //   24: iload_3
    //   25: invokevirtual 40	java/io/OutputStream:write	([BII)V
    //   28: goto -20 -> 8
    //   31: invokestatic 24	com/bumptech/glide/h/a:a	()Lcom/bumptech/glide/h/a;
    //   34: aload 4
    //   36: invokevirtual 43	com/bumptech/glide/h/a:a	([B)Z
    //   39: pop
    //   40: iconst_1
    //   41: ireturn
    //   42: astore_1
    //   43: goto +33 -> 76
    //   46: astore_1
    //   47: ldc 45
    //   49: iconst_3
    //   50: invokestatic 51	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   53: ifeq +12 -> 65
    //   56: ldc 45
    //   58: ldc 53
    //   60: aload_1
    //   61: invokestatic 57	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   64: pop
    //   65: invokestatic 24	com/bumptech/glide/h/a:a	()Lcom/bumptech/glide/h/a;
    //   68: aload 4
    //   70: invokevirtual 43	com/bumptech/glide/h/a:a	([B)Z
    //   73: pop
    //   74: iconst_0
    //   75: ireturn
    //   76: invokestatic 24	com/bumptech/glide/h/a:a	()Lcom/bumptech/glide/h/a;
    //   79: aload 4
    //   81: invokevirtual 43	com/bumptech/glide/h/a:a	([B)Z
    //   84: pop
    //   85: aload_1
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	o
    //   0	87	1	paramInputStream	InputStream
    //   0	87	2	paramOutputStream	java.io.OutputStream
    //   14	11	3	i	int
    //   6	74	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   8	15	42	finally
    //   20	28	42	finally
    //   47	65	42	finally
    //   8	15	46	java/io/IOException
    //   20	28	46	java/io/IOException
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\c\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */