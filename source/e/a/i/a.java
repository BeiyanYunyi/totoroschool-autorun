package e.a.i;

import e.a.c;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a
{
  private static final byte[] a = { 42 };
  private static final String[] b = new String[0];
  private static final String[] c = { "*" };
  private static final a d = new a();
  private final AtomicBoolean e = new AtomicBoolean(false);
  private final CountDownLatch f = new CountDownLatch(1);
  private byte[] g;
  private byte[] h;
  
  public static a a()
  {
    return d;
  }
  
  private static String a(byte[] paramArrayOfByte, byte[][] paramArrayOfByte1, int paramInt)
  {
    int n = paramArrayOfByte.length;
    int i1 = 0;
    if (i1 < n)
    {
      int i = (i1 + n) / 2;
      while ((i > -1) && (paramArrayOfByte[i] != 10)) {
        i -= 1;
      }
      int i4 = i + 1;
      i = 1;
      int i5;
      for (;;)
      {
        i5 = i4 + i;
        if (paramArrayOfByte[i5] == 10) {
          break;
        }
        i += 1;
      }
      int i6 = i5 - i4;
      int j = paramInt;
      int m = 0;
      i = 0;
      int k = 0;
      for (;;)
      {
        int i2;
        if (m != 0)
        {
          m = 0;
          i2 = 46;
        }
        else
        {
          i2 = paramArrayOfByte1[j][i] & 0xFF;
        }
        int i7 = i2 - (paramArrayOfByte[(i4 + k)] & 0xFF);
        if (i7 == 0)
        {
          i2 = k + 1;
          int i3 = i + 1;
          if (i2 == i6)
          {
            i = i3;
            k = i2;
          }
          else
          {
            i = i3;
            k = i2;
            if (paramArrayOfByte1[j].length != i3) {
              continue;
            }
            if (j != paramArrayOfByte1.length - 1) {
              break label316;
            }
            k = i2;
            i = i3;
          }
        }
        if (i7 < 0)
        {
          i = i4 - 1;
          label211:
          n = i;
          break;
        }
        if (i7 > 0) {}
        for (i = i5 + 1;; i = i5 + 1)
        {
          i1 = i;
          break;
          k = i6 - k;
          i = paramArrayOfByte1[j].length - i;
          for (;;)
          {
            j += 1;
            if (j >= paramArrayOfByte1.length) {
              break;
            }
            i += paramArrayOfByte1[j].length;
          }
          if (i < k)
          {
            i = i4 - 1;
            break label211;
          }
          if (i <= k) {
            break label300;
          }
        }
        label300:
        return new String(paramArrayOfByte, i4, i6, c.e);
        label316:
        j += 1;
        m = 1;
        i = -1;
        k = i2;
      }
    }
    return null;
  }
  
  private String[] a(String[] paramArrayOfString)
  {
    boolean bool = this.e.get();
    int j = 0;
    if ((!bool) && (this.e.compareAndSet(false, true))) {
      b();
    }
    try
    {
      this.f.await();
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
    Thread.currentThread().interrupt();
    try
    {
      if (this.g != null)
      {
        byte[][] arrayOfByte = new byte[paramArrayOfString.length][];
        int i = 0;
        while (i < paramArrayOfString.length)
        {
          arrayOfByte[i] = paramArrayOfString[i].getBytes(c.e);
          i += 1;
        }
        i = 0;
        while (i < arrayOfByte.length)
        {
          paramArrayOfString = a(this.g, arrayOfByte, i);
          if (paramArrayOfString != null) {
            break label133;
          }
          i += 1;
        }
        paramArrayOfString = null;
        label133:
        if (arrayOfByte.length > 1)
        {
          localObject2 = (byte[][])arrayOfByte.clone();
          i = 0;
          while (i < localObject2.length - 1)
          {
            localObject2[i] = a;
            localObject1 = a(this.g, (byte[][])localObject2, i);
            if (localObject1 != null) {
              break label198;
            }
            i += 1;
          }
        }
        Object localObject1 = null;
        label198:
        if (localObject1 != null)
        {
          i = j;
          while (i < arrayOfByte.length - 1)
          {
            localObject2 = a(this.h, arrayOfByte, i);
            if (localObject2 != null) {
              break label244;
            }
            i += 1;
          }
        }
        Object localObject2 = null;
        label244:
        if (localObject2 != null)
        {
          paramArrayOfString = new StringBuilder();
          paramArrayOfString.append("!");
          paramArrayOfString.append((String)localObject2);
          return paramArrayOfString.toString().split("\\.");
        }
        if ((paramArrayOfString == null) && (localObject1 == null)) {
          return c;
        }
        if (paramArrayOfString != null) {
          paramArrayOfString = paramArrayOfString.split("\\.");
        } else {
          paramArrayOfString = b;
        }
        if (localObject1 != null) {
          localObject1 = ((String)localObject1).split("\\.");
        } else {
          localObject1 = b;
        }
        if (paramArrayOfString.length > localObject1.length) {
          return paramArrayOfString;
        }
        return (String[])localObject1;
      }
      throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
    }
    finally {}
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: invokespecial 134	e/a/i/a:c	()V
    //   6: iload_1
    //   7: ifeq +9 -> 16
    //   10: invokestatic 82	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   13: invokevirtual 85	java/lang/Thread:interrupt	()V
    //   16: return
    //   17: astore_2
    //   18: goto +34 -> 52
    //   21: astore_2
    //   22: invokestatic 139	e/a/g/f:c	()Le/a/g/f;
    //   25: iconst_5
    //   26: ldc -115
    //   28: aload_2
    //   29: invokevirtual 144	e/a/g/f:a	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   32: iload_1
    //   33: ifeq +9 -> 42
    //   36: invokestatic 82	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   39: invokevirtual 85	java/lang/Thread:interrupt	()V
    //   42: return
    //   43: invokestatic 147	java/lang/Thread:interrupted	()Z
    //   46: pop
    //   47: iconst_1
    //   48: istore_1
    //   49: goto -47 -> 2
    //   52: iload_1
    //   53: ifeq +9 -> 62
    //   56: invokestatic 82	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   59: invokevirtual 85	java/lang/Thread:interrupt	()V
    //   62: aload_2
    //   63: athrow
    //   64: astore_2
    //   65: goto -22 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	this	a
    //   1	52	1	i	int
    //   17	1	2	localObject	Object
    //   21	42	2	localIOException	java.io.IOException
    //   64	1	2	localInterruptedIOException	java.io.InterruptedIOException
    // Exception table:
    //   from	to	target	type
    //   2	6	17	finally
    //   22	32	17	finally
    //   43	47	17	finally
    //   2	6	21	java/io/IOException
    //   2	6	64	java/io/InterruptedIOException
  }
  
  /* Error */
  private void c()
    throws java.io.IOException
  {
    // Byte code:
    //   0: ldc 2
    //   2: ldc -107
    //   4: invokevirtual 155	java/lang/Class:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   7: astore_1
    //   8: aload_1
    //   9: ifnonnull +4 -> 13
    //   12: return
    //   13: new 157	f/j
    //   16: dup
    //   17: aload_1
    //   18: invokestatic 162	f/l:a	(Ljava/io/InputStream;)Lf/s;
    //   21: invokespecial 165	f/j:<init>	(Lf/s;)V
    //   24: invokestatic 168	f/l:a	(Lf/s;)Lf/e;
    //   27: astore_1
    //   28: aload_1
    //   29: invokeinterface 174 1 0
    //   34: newarray <illegal type>
    //   36: astore_2
    //   37: aload_1
    //   38: aload_2
    //   39: invokeinterface 177 2 0
    //   44: aload_1
    //   45: invokeinterface 174 1 0
    //   50: newarray <illegal type>
    //   52: astore_3
    //   53: aload_1
    //   54: aload_3
    //   55: invokeinterface 177 2 0
    //   60: aload_1
    //   61: invokestatic 180	e/a/c:a	(Ljava/io/Closeable;)V
    //   64: aload_0
    //   65: monitorenter
    //   66: aload_0
    //   67: aload_2
    //   68: putfield 87	e/a/i/a:g	[B
    //   71: aload_0
    //   72: aload_3
    //   73: putfield 102	e/a/i/a:h	[B
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_0
    //   79: getfield 50	e/a/i/a:f	Ljava/util/concurrent/CountDownLatch;
    //   82: invokevirtual 183	java/util/concurrent/CountDownLatch:countDown	()V
    //   85: return
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    //   91: astore_2
    //   92: aload_1
    //   93: invokestatic 180	e/a/c:a	(Ljava/io/Closeable;)V
    //   96: aload_2
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	this	a
    //   7	54	1	localObject1	Object
    //   86	7	1	localCloseable	java.io.Closeable
    //   36	32	2	arrayOfByte1	byte[]
    //   91	6	2	localObject2	Object
    //   52	21	3	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   66	78	86	finally
    //   87	89	86	finally
    //   28	60	91	finally
  }
  
  public String a(String paramString)
  {
    if (paramString != null)
    {
      Object localObject = IDN.toUnicode(paramString).split("\\.");
      String[] arrayOfString = a((String[])localObject);
      if ((localObject.length == arrayOfString.length) && (arrayOfString[0].charAt(0) != '!')) {
        return null;
      }
      int i;
      if (arrayOfString[0].charAt(0) == '!') {
        i = localObject.length - arrayOfString.length;
      } else {
        i = localObject.length - (arrayOfString.length + 1);
      }
      localObject = new StringBuilder();
      paramString = paramString.split("\\.");
      while (i < paramString.length)
      {
        ((StringBuilder)localObject).append(paramString[i]);
        ((StringBuilder)localObject).append('.');
        i += 1;
      }
      ((StringBuilder)localObject).deleteCharAt(((StringBuilder)localObject).length() - 1);
      return ((StringBuilder)localObject).toString();
    }
    throw new NullPointerException("domain == null");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\i\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */