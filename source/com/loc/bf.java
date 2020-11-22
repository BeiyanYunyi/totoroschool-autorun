package com.loc;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class bf
  implements Closeable
{
  static final Pattern a = Pattern.compile("[a-z0-9_-]{1,120}");
  static ThreadPoolExecutor b = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), p);
  private static final ThreadFactory p = new ThreadFactory()
  {
    private final AtomicInteger a = new AtomicInteger(1);
    
    public final Thread newThread(Runnable paramAnonymousRunnable)
    {
      StringBuilder localStringBuilder = new StringBuilder("disklrucache#");
      localStringBuilder.append(this.a.getAndIncrement());
      return new Thread(paramAnonymousRunnable, localStringBuilder.toString());
    }
  };
  private static final OutputStream r = new OutputStream()
  {
    public final void write(int paramAnonymousInt)
      throws IOException
    {}
  };
  private final File c;
  private final File d;
  private final File e;
  private final File f;
  private final int g;
  private long h;
  private final int i;
  private long j = 0L;
  private Writer k;
  private int l = 1000;
  private final LinkedHashMap<String, c> m = new LinkedHashMap(0, 0.75F, true);
  private int n;
  private long o = 0L;
  private final Callable<Void> q = new Callable()
  {
    private Void a()
      throws Exception
    {
      synchronized (bf.this)
      {
        if (bf.a(bf.this) == null) {
          return null;
        }
        bf.b(bf.this);
        if (bf.c(bf.this))
        {
          bf.d(bf.this);
          bf.e(bf.this);
        }
        return null;
      }
    }
  };
  
  private bf(File paramFile, long paramLong)
  {
    this.c = paramFile;
    this.g = 1;
    this.d = new File(paramFile, "journal");
    this.e = new File(paramFile, "journal.tmp");
    this.f = new File(paramFile, "journal.bkp");
    this.i = 1;
    this.h = paramLong;
  }
  
  public static bf a(File paramFile, long paramLong)
    throws IOException
  {
    Object localObject;
    if (paramLong > 0L)
    {
      localObject = new File(paramFile, "journal.bkp");
      if (((File)localObject).exists())
      {
        File localFile = new File(paramFile, "journal");
        if (localFile.exists()) {
          ((File)localObject).delete();
        } else {
          a((File)localObject, localFile, false);
        }
      }
      localObject = new bf(paramFile, paramLong);
      if (!((bf)localObject).d.exists()) {}
    }
    try
    {
      ((bf)localObject).g();
      ((bf)localObject).h();
      ((bf)localObject).k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(((bf)localObject).d, true), bh.a));
      return (bf)localObject;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    ((bf)localObject).d();
    paramFile.mkdirs();
    paramFile = new bf(paramFile, paramLong);
    paramFile.i();
    return paramFile;
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  public static void a()
  {
    if ((b != null) && (!b.isShutdown())) {
      b.shutdown();
    }
  }
  
  private void a(a parama, boolean paramBoolean)
    throws IOException
  {
    for (;;)
    {
      int i2;
      try
      {
        c localc = a.a(parama);
        if (c.b(localc) == parama)
        {
          int i3 = 0;
          i2 = i3;
          if (paramBoolean)
          {
            i2 = i3;
            if (!c.e(localc))
            {
              int i1 = 0;
              i2 = i3;
              if (i1 < this.i)
              {
                if (a.b(parama)[i1] != 0)
                {
                  if (!localc.b(i1).exists())
                  {
                    parama.c();
                    return;
                  }
                  i1 += 1;
                  continue;
                }
                parama.c();
                parama = new StringBuilder("Newly created entry didn't create value for index ");
                parama.append(i1);
                throw new IllegalStateException(parama.toString());
              }
            }
          }
          Object localObject;
          long l1;
          if (i2 < this.i)
          {
            parama = localc.b(i2);
            if (paramBoolean)
            {
              if (parama.exists())
              {
                localObject = localc.a(i2);
                parama.renameTo((File)localObject);
                l1 = c.c(localc)[i2];
                long l2 = ((File)localObject).length();
                c.c(localc)[i2] = l2;
                this.j = (this.j - l1 + l2);
              }
            }
            else {
              a(parama);
            }
          }
          else
          {
            this.n += 1;
            c.a(localc, null);
            if ((c.e(localc) | paramBoolean))
            {
              c.a(localc);
              parama = this.k;
              localObject = new StringBuilder("CLEAN ");
              ((StringBuilder)localObject).append(c.d(localc));
              ((StringBuilder)localObject).append(localc.a());
              ((StringBuilder)localObject).append('\n');
              parama.write(((StringBuilder)localObject).toString());
              if (paramBoolean)
              {
                l1 = this.o;
                this.o = (1L + l1);
                c.a(localc, l1);
              }
            }
            else
            {
              this.m.remove(c.d(localc));
              parama = this.k;
              localObject = new StringBuilder("REMOVE ");
              ((StringBuilder)localObject).append(c.d(localc));
              ((StringBuilder)localObject).append('\n');
              parama.write(((StringBuilder)localObject).toString());
            }
            this.k.flush();
            if ((this.j > this.h) || (j())) {
              f().submit(this.q);
            }
          }
        }
        else
        {
          throw new IllegalStateException();
        }
      }
      finally {}
      i2 += 1;
    }
  }
  
  private static void a(File paramFile)
    throws IOException
  {
    if (paramFile.exists())
    {
      if (paramFile.delete()) {
        return;
      }
      throw new IOException();
    }
  }
  
  private static void a(File paramFile1, File paramFile2, boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean) {
      a(paramFile2);
    }
    if (paramFile1.renameTo(paramFile2)) {
      return;
    }
    throw new IOException();
  }
  
  private a d(String paramString)
    throws IOException
  {
    try
    {
      k();
      e(paramString);
      Object localObject = (c)this.m.get(paramString);
      if (localObject == null)
      {
        localObject = new c(paramString, (byte)0);
        this.m.put(paramString, localObject);
      }
      else
      {
        locala = c.b((c)localObject);
        if (locala != null) {
          return null;
        }
      }
      a locala = new a((c)localObject, (byte)0);
      c.a((c)localObject, locala);
      localObject = this.k;
      StringBuilder localStringBuilder = new StringBuilder("DIRTY ");
      localStringBuilder.append(paramString);
      localStringBuilder.append('\n');
      ((Writer)localObject).write(localStringBuilder.toString());
      this.k.flush();
      return locala;
    }
    finally {}
  }
  
  private static void e(String paramString)
  {
    if (a.matcher(paramString).matches()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("keys must match regex [a-z0-9_-]{1,120}: \"");
    localStringBuilder.append(paramString);
    localStringBuilder.append("\"");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private static ThreadPoolExecutor f()
  {
    try
    {
      if ((b == null) || (b.isShutdown())) {
        b = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(256), p);
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return b;
  }
  
  private void g()
    throws IOException
  {
    bg localbg = new bg(new FileInputStream(this.d), bh.a);
    int i1;
    label593:
    for (;;)
    {
      try
      {
        localObject1 = localbg.a();
        localObject3 = localbg.a();
        localObject5 = localbg.a();
        localObject4 = localbg.a();
        str = localbg.a();
        if (("libcore.io.DiskLruCache".equals(localObject1)) && ("1".equals(localObject3)) && (Integer.toString(this.g).equals(localObject5)) && (Integer.toString(this.i).equals(localObject4)))
        {
          boolean bool = "".equals(str);
          if (bool) {
            i1 = 0;
          }
        }
      }
      finally
      {
        Object localObject1;
        Object localObject3;
        Object localObject5;
        Object localObject4;
        String str;
        int i2;
        bh.a(localbg);
      }
      try
      {
        str = localbg.a();
        i2 = str.indexOf(' ');
        if (i2 != -1)
        {
          int i3 = i2 + 1;
          int i4 = str.indexOf(' ', i3);
          if (i4 == -1)
          {
            localObject3 = str.substring(i3);
            localObject1 = localObject3;
            if (i2 == 6)
            {
              localObject1 = localObject3;
              if (str.startsWith("REMOVE"))
              {
                this.m.remove(localObject3);
                break label593;
              }
            }
          }
          else
          {
            localObject1 = str.substring(i3, i4);
          }
          localObject4 = (c)this.m.get(localObject1);
          localObject3 = localObject4;
          if (localObject4 == null)
          {
            localObject3 = new c((String)localObject1, (byte)0);
            this.m.put(localObject1, localObject3);
          }
          if ((i4 != -1) && (i2 == 5) && (str.startsWith("CLEAN")))
          {
            localObject1 = str.substring(i4 + 1).split(" ");
            c.a((c)localObject3);
            c.a((c)localObject3, null);
            c.a((c)localObject3, (String[])localObject1);
            break label593;
          }
          if ((i4 == -1) && (i2 == 5) && (str.startsWith("DIRTY")))
          {
            c.a((c)localObject3, new a((c)localObject3, (byte)0));
            break label593;
          }
          if ((i4 == -1) && (i2 == 4) && (str.startsWith("READ"))) {
            break label593;
          }
          localObject1 = new StringBuilder("unexpected journal line: ");
          ((StringBuilder)localObject1).append(str);
          throw new IOException(((StringBuilder)localObject1).toString());
        }
        localObject1 = new StringBuilder("unexpected journal line: ");
        ((StringBuilder)localObject1).append(str);
        throw new IOException(((StringBuilder)localObject1).toString());
      }
      catch (EOFException localEOFException)
      {
        continue;
        i1 += 1;
      }
      this.n = (i1 - this.m.size());
      bh.a(localbg);
      return;
      localObject5 = new StringBuilder("unexpected journal header: [");
      ((StringBuilder)localObject5).append((String)localObject1);
      ((StringBuilder)localObject5).append(", ");
      ((StringBuilder)localObject5).append((String)localObject3);
      ((StringBuilder)localObject5).append(", ");
      ((StringBuilder)localObject5).append((String)localObject4);
      ((StringBuilder)localObject5).append(", ");
      ((StringBuilder)localObject5).append(str);
      ((StringBuilder)localObject5).append("]");
      throw new IOException(((StringBuilder)localObject5).toString());
    }
  }
  
  private void h()
    throws IOException
  {
    a(this.e);
    Iterator localIterator = this.m.values().iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      a locala = c.b(localc);
      int i2 = 0;
      int i1 = 0;
      if (locala == null)
      {
        while (i1 < this.i)
        {
          this.j += c.c(localc)[i1];
          i1 += 1;
        }
      }
      else
      {
        c.a(localc, null);
        i1 = i2;
        while (i1 < this.i)
        {
          a(localc.a(i1));
          a(localc.b(i1));
          i1 += 1;
        }
        localIterator.remove();
      }
    }
  }
  
  /* Error */
  private void i()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 178	com/loc/bf:k	Ljava/io/Writer;
    //   6: ifnull +10 -> 16
    //   9: aload_0
    //   10: getfield 178	com/loc/bf:k	Ljava/io/Writer;
    //   13: invokevirtual 449	java/io/Writer:close	()V
    //   16: new 158	java/io/BufferedWriter
    //   19: dup
    //   20: new 160	java/io/OutputStreamWriter
    //   23: dup
    //   24: new 162	java/io/FileOutputStream
    //   27: dup
    //   28: aload_0
    //   29: getfield 127	com/loc/bf:e	Ljava/io/File;
    //   32: invokespecial 450	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   35: getstatic 170	com/loc/bh:a	Ljava/nio/charset/Charset;
    //   38: invokespecial 173	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   41: invokespecial 176	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   44: astore_2
    //   45: aload_2
    //   46: ldc_w 360
    //   49: invokevirtual 275	java/io/Writer:write	(Ljava/lang/String;)V
    //   52: aload_2
    //   53: ldc_w 452
    //   56: invokevirtual 275	java/io/Writer:write	(Ljava/lang/String;)V
    //   59: aload_2
    //   60: ldc_w 368
    //   63: invokevirtual 275	java/io/Writer:write	(Ljava/lang/String;)V
    //   66: aload_2
    //   67: ldc_w 452
    //   70: invokevirtual 275	java/io/Writer:write	(Ljava/lang/String;)V
    //   73: aload_2
    //   74: aload_0
    //   75: getfield 114	com/loc/bf:g	I
    //   78: invokestatic 373	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   81: invokevirtual 275	java/io/Writer:write	(Ljava/lang/String;)V
    //   84: aload_2
    //   85: ldc_w 452
    //   88: invokevirtual 275	java/io/Writer:write	(Ljava/lang/String;)V
    //   91: aload_2
    //   92: aload_0
    //   93: getfield 133	com/loc/bf:i	I
    //   96: invokestatic 373	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   99: invokevirtual 275	java/io/Writer:write	(Ljava/lang/String;)V
    //   102: aload_2
    //   103: ldc_w 452
    //   106: invokevirtual 275	java/io/Writer:write	(Ljava/lang/String;)V
    //   109: aload_2
    //   110: ldc_w 452
    //   113: invokevirtual 275	java/io/Writer:write	(Ljava/lang/String;)V
    //   116: aload_0
    //   117: getfield 103	com/loc/bf:m	Ljava/util/LinkedHashMap;
    //   120: invokevirtual 429	java/util/LinkedHashMap:values	()Ljava/util/Collection;
    //   123: invokeinterface 435 1 0
    //   128: astore_3
    //   129: aload_3
    //   130: invokeinterface 440 1 0
    //   135: ifeq +113 -> 248
    //   138: aload_3
    //   139: invokeinterface 444 1 0
    //   144: checkcast 22	com/loc/bf$c
    //   147: astore_1
    //   148: aload_1
    //   149: invokestatic 207	com/loc/bf$c:b	(Lcom/loc/bf$c;)Lcom/loc/bf$a;
    //   152: ifnull +47 -> 199
    //   155: new 220	java/lang/StringBuilder
    //   158: dup
    //   159: ldc_w 324
    //   162: invokespecial 223	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   165: astore 4
    //   167: aload 4
    //   169: aload_1
    //   170: invokestatic 262	com/loc/bf$c:d	(Lcom/loc/bf$c;)Ljava/lang/String;
    //   173: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload 4
    //   179: bipush 10
    //   181: invokevirtual 270	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload 4
    //   187: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: astore_1
    //   191: aload_2
    //   192: aload_1
    //   193: invokevirtual 275	java/io/Writer:write	(Ljava/lang/String;)V
    //   196: goto -67 -> 129
    //   199: new 220	java/lang/StringBuilder
    //   202: dup
    //   203: ldc_w 259
    //   206: invokespecial 223	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   209: astore 4
    //   211: aload 4
    //   213: aload_1
    //   214: invokestatic 262	com/loc/bf$c:d	(Lcom/loc/bf$c;)Ljava/lang/String;
    //   217: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload 4
    //   223: aload_1
    //   224: invokevirtual 267	com/loc/bf$c:a	()Ljava/lang/String;
    //   227: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload 4
    //   233: bipush 10
    //   235: invokevirtual 270	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload 4
    //   241: invokevirtual 233	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: astore_1
    //   245: goto -54 -> 191
    //   248: aload_2
    //   249: invokevirtual 449	java/io/Writer:close	()V
    //   252: aload_0
    //   253: getfield 123	com/loc/bf:d	Ljava/io/File;
    //   256: invokevirtual 144	java/io/File:exists	()Z
    //   259: ifeq +15 -> 274
    //   262: aload_0
    //   263: getfield 123	com/loc/bf:d	Ljava/io/File;
    //   266: aload_0
    //   267: getfield 131	com/loc/bf:f	Ljava/io/File;
    //   270: iconst_1
    //   271: invokestatic 150	com/loc/bf:a	(Ljava/io/File;Ljava/io/File;Z)V
    //   274: aload_0
    //   275: getfield 127	com/loc/bf:e	Ljava/io/File;
    //   278: aload_0
    //   279: getfield 123	com/loc/bf:d	Ljava/io/File;
    //   282: iconst_0
    //   283: invokestatic 150	com/loc/bf:a	(Ljava/io/File;Ljava/io/File;Z)V
    //   286: aload_0
    //   287: getfield 131	com/loc/bf:f	Ljava/io/File;
    //   290: invokevirtual 147	java/io/File:delete	()Z
    //   293: pop
    //   294: aload_0
    //   295: new 158	java/io/BufferedWriter
    //   298: dup
    //   299: new 160	java/io/OutputStreamWriter
    //   302: dup
    //   303: new 162	java/io/FileOutputStream
    //   306: dup
    //   307: aload_0
    //   308: getfield 123	com/loc/bf:d	Ljava/io/File;
    //   311: iconst_1
    //   312: invokespecial 165	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   315: getstatic 170	com/loc/bh:a	Ljava/nio/charset/Charset;
    //   318: invokespecial 173	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   321: invokespecial 176	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   324: putfield 178	com/loc/bf:k	Ljava/io/Writer;
    //   327: aload_0
    //   328: monitorexit
    //   329: return
    //   330: astore_1
    //   331: aload_2
    //   332: invokevirtual 449	java/io/Writer:close	()V
    //   335: aload_1
    //   336: athrow
    //   337: astore_1
    //   338: aload_0
    //   339: monitorexit
    //   340: aload_1
    //   341: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	342	0	this	bf
    //   147	98	1	localObject1	Object
    //   330	6	1	localObject2	Object
    //   337	4	1	localObject3	Object
    //   44	288	2	localBufferedWriter	BufferedWriter
    //   128	11	3	localIterator	Iterator
    //   165	75	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   45	129	330	finally
    //   129	191	330	finally
    //   191	196	330	finally
    //   199	245	330	finally
    //   2	16	337	finally
    //   16	45	337	finally
    //   248	274	337	finally
    //   274	327	337	finally
    //   331	337	337	finally
  }
  
  private boolean j()
  {
    return (this.n >= 2000) && (this.n >= this.m.size());
  }
  
  private void k()
  {
    if (this.k != null) {
      return;
    }
    throw new IllegalStateException("cache is closed");
  }
  
  private void l()
    throws IOException
  {
    for (;;)
    {
      if ((this.j <= this.h) && (this.m.size() <= this.l)) {
        return;
      }
      c((String)((Map.Entry)this.m.entrySet().iterator().next()).getKey());
    }
  }
  
  public final b a(String paramString)
    throws IOException
  {
    for (;;)
    {
      c localc;
      InputStream[] arrayOfInputStream;
      Writer localWriter;
      StringBuilder localStringBuilder;
      try
      {
        k();
        e(paramString);
        localc = (c)this.m.get(paramString);
        if (localc == null) {
          return null;
        }
        boolean bool = c.e(localc);
        if (!bool) {
          return null;
        }
        arrayOfInputStream = new InputStream[this.i];
        i2 = 0;
        i1 = 0;
      }
      finally {}
      try
      {
        if (i1 < this.i)
        {
          arrayOfInputStream[i1] = new FileInputStream(localc.a(i1));
          i1 += 1;
          continue;
        }
        this.n += 1;
        localWriter = this.k;
        localStringBuilder = new StringBuilder("READ ");
        localStringBuilder.append(paramString);
        localStringBuilder.append('\n');
        localWriter.append(localStringBuilder.toString());
        if (j()) {
          f().submit(this.q);
        }
        paramString = new b(paramString, c.f(localc), arrayOfInputStream, c.c(localc), (byte)0);
        return paramString;
      }
      catch (FileNotFoundException paramString)
      {
        i1 = i2;
        continue;
      }
      if ((i1 >= this.i) || (arrayOfInputStream[i1] == null)) {
        continue;
      }
      bh.a(arrayOfInputStream[i1]);
      i1 += 1;
    }
    return null;
  }
  
  public final void a(int paramInt)
  {
    int i1;
    if (paramInt < 10)
    {
      i1 = 10;
    }
    else
    {
      i1 = paramInt;
      if (paramInt > 10000) {
        i1 = 10000;
      }
    }
    this.l = i1;
  }
  
  public final a b(String paramString)
    throws IOException
  {
    return d(paramString);
  }
  
  public final File b()
  {
    return this.c;
  }
  
  public final void c()
    throws IOException
  {
    try
    {
      k();
      l();
      this.k.flush();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final boolean c(String paramString)
    throws IOException
  {
    try
    {
      k();
      e(paramString);
      Object localObject2 = (c)this.m.get(paramString);
      int i1 = 0;
      if ((localObject2 != null) && (c.b((c)localObject2) == null))
      {
        while (i1 < this.i)
        {
          localObject1 = ((c)localObject2).a(i1);
          if ((((File)localObject1).exists()) && (!((File)localObject1).delete()))
          {
            paramString = new StringBuilder("failed to delete ");
            paramString.append(localObject1);
            throw new IOException(paramString.toString());
          }
          this.j -= c.c(localObject2)[i1];
          c.c((c)localObject2)[i1] = 0L;
          i1 += 1;
        }
        this.n += 1;
        Object localObject1 = this.k;
        localObject2 = new StringBuilder("REMOVE ");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append('\n');
        ((Writer)localObject1).append(((StringBuilder)localObject2).toString());
        this.m.remove(paramString);
        if (j()) {
          f().submit(this.q);
        }
        return true;
      }
      return false;
    }
    finally {}
  }
  
  public final void close()
    throws IOException
  {
    try
    {
      Object localObject1 = this.k;
      if (localObject1 == null) {
        return;
      }
      localObject1 = new ArrayList(this.m.values()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        c localc = (c)((Iterator)localObject1).next();
        if (c.b(localc) != null) {
          c.b(localc).c();
        }
      }
      l();
      this.k.close();
      this.k = null;
      return;
    }
    finally {}
  }
  
  public final void d()
    throws IOException
  {
    close();
    bh.a(this.c);
  }
  
  public final class a
  {
    private final bf.c b;
    private final boolean[] c;
    private boolean d;
    private boolean e;
    
    private a(bf.c paramc)
    {
      this.b = paramc;
      if (bf.c.e(paramc)) {
        this$1 = null;
      } else {
        this$1 = new boolean[bf.f(bf.this)];
      }
      this.c = bf.this;
    }
    
    public final OutputStream a()
      throws IOException
    {
      File localFile;
      if (bf.f(bf.this) > 0) {
        synchronized (bf.this)
        {
          if (bf.c.b(this.b) == this)
          {
            if (!bf.c.e(this.b)) {
              this.c[0] = true;
            }
            localFile = this.b.b(0);
          }
          try
          {
            localObject1 = new FileOutputStream(localFile);
          }
          catch (FileNotFoundException localFileNotFoundException1)
          {
            Object localObject1;
            for (;;) {}
          }
          bf.g(bf.this).mkdirs();
        }
      }
      try
      {
        localObject1 = new FileOutputStream(localFile);
        localObject1 = new a((OutputStream)localObject1, (byte)0);
        return (OutputStream)localObject1;
      }
      catch (FileNotFoundException localFileNotFoundException2)
      {
        StringBuilder localStringBuilder;
        for (;;) {}
      }
      localObject1 = bf.e();
      return (OutputStream)localObject1;
      throw new IllegalStateException();
      localObject2 = finally;
      throw ((Throwable)localObject2);
      localStringBuilder = new StringBuilder("Expected index 0 to be greater than 0 and less than the maximum value count of ");
      localStringBuilder.append(bf.f(bf.this));
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    
    public final void b()
      throws IOException
    {
      if (this.d)
      {
        bf.a(bf.this, this, false);
        bf.this.c(bf.c.d(this.b));
      }
      else
      {
        bf.a(bf.this, this, true);
      }
      this.e = true;
    }
    
    public final void c()
      throws IOException
    {
      bf.a(bf.this, this, false);
    }
    
    private final class a
      extends FilterOutputStream
    {
      private a(OutputStream paramOutputStream)
      {
        super();
      }
      
      public final void close()
      {
        try
        {
          this.out.close();
          return;
        }
        catch (IOException localIOException)
        {
          for (;;) {}
        }
        bf.a.c(bf.a.this);
      }
      
      public final void flush()
      {
        try
        {
          this.out.flush();
          return;
        }
        catch (IOException localIOException)
        {
          for (;;) {}
        }
        bf.a.c(bf.a.this);
      }
      
      public final void write(int paramInt)
      {
        try
        {
          this.out.write(paramInt);
          return;
        }
        catch (IOException localIOException)
        {
          for (;;) {}
        }
        bf.a.c(bf.a.this);
      }
      
      public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      {
        try
        {
          this.out.write(paramArrayOfByte, paramInt1, paramInt2);
          return;
        }
        catch (IOException paramArrayOfByte)
        {
          for (;;) {}
        }
        bf.a.c(bf.a.this);
      }
    }
  }
  
  public final class b
    implements Closeable
  {
    private final String b;
    private final long c;
    private final InputStream[] d;
    private final long[] e;
    
    private b(String paramString, long paramLong, InputStream[] paramArrayOfInputStream, long[] paramArrayOfLong)
    {
      this.b = paramString;
      this.c = paramLong;
      this.d = paramArrayOfInputStream;
      this.e = paramArrayOfLong;
    }
    
    public final InputStream a()
    {
      return this.d[0];
    }
    
    public final void close()
    {
      InputStream[] arrayOfInputStream = this.d;
      int j = arrayOfInputStream.length;
      int i = 0;
      while (i < j)
      {
        bh.a(arrayOfInputStream[i]);
        i += 1;
      }
    }
  }
  
  private final class c
  {
    private final String b;
    private final long[] c;
    private boolean d;
    private bf.a e;
    private long f;
    
    private c(String paramString)
    {
      this.b = paramString;
      this.c = new long[bf.f(bf.this)];
    }
    
    private static IOException a(String[] paramArrayOfString)
      throws IOException
    {
      StringBuilder localStringBuilder = new StringBuilder("unexpected journal line: ");
      localStringBuilder.append(Arrays.toString(paramArrayOfString));
      throw new IOException(localStringBuilder.toString());
    }
    
    public final File a(int paramInt)
    {
      File localFile = bf.g(bf.this);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
      localStringBuilder.append(".");
      localStringBuilder.append(paramInt);
      return new File(localFile, localStringBuilder.toString());
    }
    
    public final String a()
      throws IOException
    {
      StringBuilder localStringBuilder = new StringBuilder();
      long[] arrayOfLong = this.c;
      int j = arrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        long l = arrayOfLong[i];
        localStringBuilder.append(' ');
        localStringBuilder.append(l);
        i += 1;
      }
      return localStringBuilder.toString();
    }
    
    public final File b(int paramInt)
    {
      File localFile = bf.g(bf.this);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
      localStringBuilder.append(".");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(".tmp");
      return new File(localFile, localStringBuilder.toString());
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\bf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */