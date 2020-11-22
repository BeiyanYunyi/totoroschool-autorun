package com.amap.api.mapcore.util;

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

public final class hs
  implements Closeable
{
  static final Pattern a = Pattern.compile("[a-z0-9_-]{1,120}");
  static ThreadPoolExecutor b = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), q);
  private static final ThreadFactory q = new ThreadFactory()
  {
    private final AtomicInteger a = new AtomicInteger(1);
    
    public Thread newThread(Runnable paramAnonymousRunnable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("disklrucache#");
      localStringBuilder.append(this.a.getAndIncrement());
      return new Thread(paramAnonymousRunnable, localStringBuilder.toString());
    }
  };
  private static final OutputStream s = new OutputStream()
  {
    public void write(int paramAnonymousInt)
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
  private ht o;
  private long p = 0L;
  private final Callable<Void> r = new Callable()
  {
    public Void a()
      throws Exception
    {
      synchronized (hs.this)
      {
        if (hs.a(hs.this) == null) {
          return null;
        }
        hs.b(hs.this);
        if (hs.c(hs.this))
        {
          hs.d(hs.this);
          hs.a(hs.this, 0);
        }
        return null;
      }
    }
  };
  
  private hs(File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    this.c = paramFile;
    this.g = paramInt1;
    this.d = new File(paramFile, "journal");
    this.e = new File(paramFile, "journal.tmp");
    this.f = new File(paramFile, "journal.bkp");
    this.i = paramInt2;
    this.h = paramLong;
  }
  
  private a a(String paramString, long paramLong)
    throws IOException
  {
    try
    {
      l();
      e(paramString);
      Object localObject = (c)this.m.get(paramString);
      if (paramLong != -1L) {
        if (localObject != null)
        {
          long l1 = c.e((c)localObject);
          if (l1 == paramLong) {}
        }
        else
        {
          return null;
        }
      }
      if (localObject == null)
      {
        localObject = new c(paramString, null);
        this.m.put(paramString, localObject);
      }
      else
      {
        locala = c.a((c)localObject);
        if (locala != null) {
          return null;
        }
      }
      a locala = new a((c)localObject, null);
      c.a((c)localObject, locala);
      localObject = this.k;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DIRTY ");
      localStringBuilder.append(paramString);
      localStringBuilder.append('\n');
      ((Writer)localObject).write(localStringBuilder.toString());
      this.k.flush();
      return locala;
    }
    finally {}
  }
  
  public static hs a(File paramFile, int paramInt1, int paramInt2, long paramLong)
    throws IOException
  {
    Object localObject;
    if (paramLong > 0L) {
      if (paramInt2 > 0)
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
        localObject = new hs(paramFile, paramInt1, paramInt2, paramLong);
        if (!((hs)localObject).d.exists()) {}
      }
    }
    try
    {
      ((hs)localObject).h();
      ((hs)localObject).i();
      ((hs)localObject).k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(((hs)localObject).d, true), hv.a));
      return (hs)localObject;
    }
    catch (Throwable localThrowable)
    {
      for (;;) {}
    }
    ((hs)localObject).f();
    paramFile.mkdirs();
    paramFile = new hs(paramFile, paramInt1, paramInt2, paramLong);
    paramFile.j();
    return paramFile;
    throw new IllegalArgumentException("valueCount <= 0");
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
        if (c.a(localc) == parama)
        {
          int i3 = 0;
          i2 = i3;
          if (paramBoolean)
          {
            i2 = i3;
            if (!c.d(localc))
            {
              int i1 = 0;
              i2 = i3;
              if (i1 < this.i)
              {
                if (a.b(parama)[i1] != 0)
                {
                  if (!localc.b(i1).exists())
                  {
                    parama.b();
                    return;
                  }
                  i1 += 1;
                  continue;
                }
                parama.b();
                parama = new StringBuilder();
                parama.append("Newly created entry didn't create value for index ");
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
                l1 = c.b(localc)[i2];
                long l2 = ((File)localObject).length();
                c.b(localc)[i2] = l2;
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
            if ((c.d(localc) | paramBoolean))
            {
              c.a(localc, true);
              parama = this.k;
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("CLEAN ");
              ((StringBuilder)localObject).append(c.c(localc));
              ((StringBuilder)localObject).append(localc.a());
              ((StringBuilder)localObject).append('\n');
              parama.write(((StringBuilder)localObject).toString());
              if (paramBoolean)
              {
                l1 = this.p;
                this.p = (1L + l1);
                c.a(localc, l1);
              }
            }
            else
            {
              this.m.remove(c.c(localc));
              parama = this.k;
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("REMOVE ");
              ((StringBuilder)localObject).append(c.c(localc));
              ((StringBuilder)localObject).append('\n');
              parama.write(((StringBuilder)localObject).toString());
            }
            this.k.flush();
            if ((this.j > this.h) || (k())) {
              b().submit(this.r);
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
  
  public static ThreadPoolExecutor b()
  {
    try
    {
      if ((b == null) || (b.isShutdown())) {
        b = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(256), q);
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return b;
  }
  
  private void d(String paramString)
    throws IOException
  {
    int i1 = paramString.indexOf(' ');
    if (i1 != -1)
    {
      int i2 = i1 + 1;
      int i3 = paramString.indexOf(' ', i2);
      if (i3 == -1)
      {
        localObject2 = paramString.substring(i2);
        localObject1 = localObject2;
        if (i1 == "REMOVE".length())
        {
          localObject1 = localObject2;
          if (paramString.startsWith("REMOVE")) {
            this.m.remove(localObject2);
          }
        }
      }
      else
      {
        localObject1 = paramString.substring(i2, i3);
      }
      c localc = (c)this.m.get(localObject1);
      Object localObject2 = localc;
      if (localc == null)
      {
        localObject2 = new c((String)localObject1, null);
        this.m.put(localObject1, localObject2);
      }
      if ((i3 != -1) && (i1 == "CLEAN".length()) && (paramString.startsWith("CLEAN")))
      {
        paramString = paramString.substring(i3 + 1).split(" ");
        c.a((c)localObject2, true);
        c.a((c)localObject2, null);
        c.a((c)localObject2, paramString);
        return;
      }
      if ((i3 == -1) && (i1 == "DIRTY".length()) && (paramString.startsWith("DIRTY")))
      {
        c.a((c)localObject2, new a((c)localObject2, null));
        return;
      }
      if ((i3 == -1) && (i1 == "READ".length()) && (paramString.startsWith("READ"))) {
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("unexpected journal line: ");
      ((StringBuilder)localObject1).append(paramString);
      throw new IOException(((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("unexpected journal line: ");
    ((StringBuilder)localObject1).append(paramString);
    throw new IOException(((StringBuilder)localObject1).toString());
  }
  
  private void e(String paramString)
  {
    if (a.matcher(paramString).matches()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("keys must match regex [a-z0-9_-]{1,120}: \"");
    localStringBuilder.append(paramString);
    localStringBuilder.append("\"");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private void h()
    throws IOException
  {
    localhu = new hu(new FileInputStream(this.d), hv.a);
    for (;;)
    {
      try
      {
        str1 = localhu.a();
        str2 = localhu.a();
        localObject2 = localhu.a();
        str3 = localhu.a();
        str4 = localhu.a();
        if (("libcore.io.DiskLruCache".equals(str1)) && ("1".equals(str2)) && (Integer.toString(this.g).equals(localObject2)) && (Integer.toString(this.i).equals(str3)))
        {
          boolean bool = "".equals(str4);
          if (bool) {
            i1 = 0;
          }
        }
      }
      finally
      {
        String str1;
        String str2;
        Object localObject2;
        String str3;
        String str4;
        int i1;
        hv.a(localhu);
      }
      try
      {
        d(localhu.a());
        i1 += 1;
      }
      catch (EOFException localEOFException) {}
    }
    this.n = (i1 - this.m.size());
    hv.a(localhu);
    return;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("unexpected journal header: [");
    ((StringBuilder)localObject2).append(str1);
    ((StringBuilder)localObject2).append(", ");
    ((StringBuilder)localObject2).append(str2);
    ((StringBuilder)localObject2).append(", ");
    ((StringBuilder)localObject2).append(str3);
    ((StringBuilder)localObject2).append(", ");
    ((StringBuilder)localObject2).append(str4);
    ((StringBuilder)localObject2).append("]");
    throw new IOException(((StringBuilder)localObject2).toString());
  }
  
  private void i()
    throws IOException
  {
    a(this.e);
    Iterator localIterator = this.m.values().iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      a locala = c.a(localc);
      int i2 = 0;
      int i1 = 0;
      if (locala == null)
      {
        while (i1 < this.i)
        {
          this.j += c.b(localc)[i1];
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
  private void j()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 175	com/amap/api/mapcore/util/hs:k	Ljava/io/Writer;
    //   6: ifnull +10 -> 16
    //   9: aload_0
    //   10: getfield 175	com/amap/api/mapcore/util/hs:k	Ljava/io/Writer;
    //   13: invokevirtual 464	java/io/Writer:close	()V
    //   16: new 221	java/io/BufferedWriter
    //   19: dup
    //   20: new 223	java/io/OutputStreamWriter
    //   23: dup
    //   24: new 225	java/io/FileOutputStream
    //   27: dup
    //   28: aload_0
    //   29: getfield 129	com/amap/api/mapcore/util/hs:e	Ljava/io/File;
    //   32: invokespecial 465	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   35: getstatic 233	com/amap/api/mapcore/util/hv:a	Ljava/nio/charset/Charset;
    //   38: invokespecial 236	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   41: invokespecial 239	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   44: astore_1
    //   45: aload_1
    //   46: ldc_w 414
    //   49: invokevirtual 196	java/io/Writer:write	(Ljava/lang/String;)V
    //   52: aload_1
    //   53: ldc_w 467
    //   56: invokevirtual 196	java/io/Writer:write	(Ljava/lang/String;)V
    //   59: aload_1
    //   60: ldc_w 420
    //   63: invokevirtual 196	java/io/Writer:write	(Ljava/lang/String;)V
    //   66: aload_1
    //   67: ldc_w 467
    //   70: invokevirtual 196	java/io/Writer:write	(Ljava/lang/String;)V
    //   73: aload_1
    //   74: aload_0
    //   75: getfield 116	com/amap/api/mapcore/util/hs:g	I
    //   78: invokestatic 424	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   81: invokevirtual 196	java/io/Writer:write	(Ljava/lang/String;)V
    //   84: aload_1
    //   85: ldc_w 467
    //   88: invokevirtual 196	java/io/Writer:write	(Ljava/lang/String;)V
    //   91: aload_1
    //   92: aload_0
    //   93: getfield 135	com/amap/api/mapcore/util/hs:i	I
    //   96: invokestatic 424	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   99: invokevirtual 196	java/io/Writer:write	(Ljava/lang/String;)V
    //   102: aload_1
    //   103: ldc_w 467
    //   106: invokevirtual 196	java/io/Writer:write	(Ljava/lang/String;)V
    //   109: aload_1
    //   110: ldc_w 467
    //   113: invokevirtual 196	java/io/Writer:write	(Ljava/lang/String;)V
    //   116: aload_0
    //   117: getfield 105	com/amap/api/mapcore/util/hs:m	Ljava/util/LinkedHashMap;
    //   120: invokevirtual 444	java/util/LinkedHashMap:values	()Ljava/util/Collection;
    //   123: invokeinterface 450 1 0
    //   128: astore_2
    //   129: aload_2
    //   130: invokeinterface 455 1 0
    //   135: ifeq +125 -> 260
    //   138: aload_2
    //   139: invokeinterface 459 1 0
    //   144: checkcast 22	com/amap/api/mapcore/util/hs$c
    //   147: astore_3
    //   148: aload_3
    //   149: invokestatic 167	com/amap/api/mapcore/util/hs$c:a	(Lcom/amap/api/mapcore/util/hs$c;)Lcom/amap/api/mapcore/util/hs$a;
    //   152: ifnull +50 -> 202
    //   155: new 177	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   162: astore 4
    //   164: aload 4
    //   166: ldc -76
    //   168: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload 4
    //   174: aload_3
    //   175: invokestatic 308	com/amap/api/mapcore/util/hs$c:c	(Lcom/amap/api/mapcore/util/hs$c;)Ljava/lang/String;
    //   178: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload 4
    //   184: bipush 10
    //   186: invokevirtual 187	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload_1
    //   191: aload 4
    //   193: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokevirtual 196	java/io/Writer:write	(Ljava/lang/String;)V
    //   199: goto -70 -> 129
    //   202: new 177	java/lang/StringBuilder
    //   205: dup
    //   206: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   209: astore 4
    //   211: aload 4
    //   213: ldc_w 305
    //   216: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload 4
    //   222: aload_3
    //   223: invokestatic 308	com/amap/api/mapcore/util/hs$c:c	(Lcom/amap/api/mapcore/util/hs$c;)Ljava/lang/String;
    //   226: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload 4
    //   232: aload_3
    //   233: invokevirtual 310	com/amap/api/mapcore/util/hs$c:a	()Ljava/lang/String;
    //   236: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload 4
    //   242: bipush 10
    //   244: invokevirtual 187	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload_1
    //   249: aload 4
    //   251: invokevirtual 191	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokevirtual 196	java/io/Writer:write	(Ljava/lang/String;)V
    //   257: goto -128 -> 129
    //   260: aload_1
    //   261: invokevirtual 464	java/io/Writer:close	()V
    //   264: aload_0
    //   265: getfield 125	com/amap/api/mapcore/util/hs:d	Ljava/io/File;
    //   268: invokevirtual 207	java/io/File:exists	()Z
    //   271: ifeq +15 -> 286
    //   274: aload_0
    //   275: getfield 125	com/amap/api/mapcore/util/hs:d	Ljava/io/File;
    //   278: aload_0
    //   279: getfield 133	com/amap/api/mapcore/util/hs:f	Ljava/io/File;
    //   282: iconst_1
    //   283: invokestatic 213	com/amap/api/mapcore/util/hs:a	(Ljava/io/File;Ljava/io/File;Z)V
    //   286: aload_0
    //   287: getfield 129	com/amap/api/mapcore/util/hs:e	Ljava/io/File;
    //   290: aload_0
    //   291: getfield 125	com/amap/api/mapcore/util/hs:d	Ljava/io/File;
    //   294: iconst_0
    //   295: invokestatic 213	com/amap/api/mapcore/util/hs:a	(Ljava/io/File;Ljava/io/File;Z)V
    //   298: aload_0
    //   299: getfield 133	com/amap/api/mapcore/util/hs:f	Ljava/io/File;
    //   302: invokevirtual 210	java/io/File:delete	()Z
    //   305: pop
    //   306: aload_0
    //   307: new 221	java/io/BufferedWriter
    //   310: dup
    //   311: new 223	java/io/OutputStreamWriter
    //   314: dup
    //   315: new 225	java/io/FileOutputStream
    //   318: dup
    //   319: aload_0
    //   320: getfield 125	com/amap/api/mapcore/util/hs:d	Ljava/io/File;
    //   323: iconst_1
    //   324: invokespecial 228	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   327: getstatic 233	com/amap/api/mapcore/util/hv:a	Ljava/nio/charset/Charset;
    //   330: invokespecial 236	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   333: invokespecial 239	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   336: putfield 175	com/amap/api/mapcore/util/hs:k	Ljava/io/Writer;
    //   339: aload_0
    //   340: monitorexit
    //   341: return
    //   342: astore_2
    //   343: aload_1
    //   344: invokevirtual 464	java/io/Writer:close	()V
    //   347: aload_2
    //   348: athrow
    //   349: astore_1
    //   350: aload_0
    //   351: monitorexit
    //   352: aload_1
    //   353: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	this	hs
    //   44	300	1	localBufferedWriter	BufferedWriter
    //   349	4	1	localObject1	Object
    //   128	11	2	localIterator	Iterator
    //   342	6	2	localObject2	Object
    //   147	86	3	localc	c
    //   162	88	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   45	129	342	finally
    //   129	199	342	finally
    //   202	257	342	finally
    //   2	16	349	finally
    //   16	45	349	finally
    //   260	286	349	finally
    //   286	339	349	finally
    //   343	349	349	finally
  }
  
  private boolean k()
  {
    return (this.n >= 2000) && (this.n >= this.m.size());
  }
  
  private void l()
  {
    if (this.k != null) {
      return;
    }
    throw new IllegalStateException("cache is closed");
  }
  
  private void m()
    throws IOException
  {
    for (;;)
    {
      if ((this.j <= this.h) && (this.m.size() <= this.l)) {
        return;
      }
      String str = (String)((Map.Entry)this.m.entrySet().iterator().next()).getKey();
      c(str);
      if (this.o != null) {
        this.o.a(str);
      }
    }
  }
  
  public b a(String paramString)
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
        l();
        e(paramString);
        localc = (c)this.m.get(paramString);
        if (localc == null) {
          return null;
        }
        boolean bool = c.d(localc);
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
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("READ ");
        localStringBuilder.append(paramString);
        localStringBuilder.append('\n');
        localWriter.append(localStringBuilder.toString());
        if (k()) {
          b().submit(this.r);
        }
        paramString = new b(paramString, c.e(localc), arrayOfInputStream, c.b(localc), null);
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
      hv.a(arrayOfInputStream[i1]);
      i1 += 1;
    }
    return null;
  }
  
  public void a(int paramInt)
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
  
  public a b(String paramString)
    throws IOException
  {
    return a(paramString, -1L);
  }
  
  public File c()
  {
    return this.c;
  }
  
  public boolean c(String paramString)
    throws IOException
  {
    try
    {
      l();
      e(paramString);
      Object localObject2 = (c)this.m.get(paramString);
      int i1 = 0;
      if ((localObject2 != null) && (c.a((c)localObject2) == null))
      {
        while (i1 < this.i)
        {
          localObject1 = ((c)localObject2).a(i1);
          if ((((File)localObject1).exists()) && (!((File)localObject1).delete()))
          {
            paramString = new StringBuilder();
            paramString.append("failed to delete ");
            paramString.append(localObject1);
            throw new IOException(paramString.toString());
          }
          this.j -= c.b(localObject2)[i1];
          c.b((c)localObject2)[i1] = 0L;
          i1 += 1;
        }
        this.n += 1;
        Object localObject1 = this.k;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("REMOVE ");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append('\n');
        ((Writer)localObject1).append(((StringBuilder)localObject2).toString());
        this.m.remove(paramString);
        if (k()) {
          b().submit(this.r);
        }
        return true;
      }
      return false;
    }
    finally {}
  }
  
  public void close()
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
        if (c.a(localc) != null) {
          c.a(localc).b();
        }
      }
      m();
      this.k.close();
      this.k = null;
      return;
    }
    finally {}
  }
  
  public boolean d()
  {
    try
    {
      Writer localWriter = this.k;
      boolean bool;
      if (localWriter == null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void e()
    throws IOException
  {
    try
    {
      l();
      m();
      this.k.flush();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void f()
    throws IOException
  {
    close();
    hv.a(this.c);
  }
  
  public final class a
  {
    private final hs.c b;
    private final boolean[] c;
    private boolean d;
    private boolean e;
    
    private a(hs.c paramc)
    {
      this.b = paramc;
      if (hs.c.d(paramc)) {
        this$1 = null;
      } else {
        this$1 = new boolean[hs.e(hs.this)];
      }
      this.c = hs.this;
    }
    
    public OutputStream a(int paramInt)
      throws IOException
    {
      if ((paramInt >= 0) && (paramInt < hs.e(hs.this)))
      {
        synchronized (hs.this)
        {
          File localFile;
          if (hs.c.a(this.b) == this)
          {
            if (!hs.c.d(this.b)) {
              this.c[paramInt] = true;
            }
            localFile = this.b.b(paramInt);
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
          hs.f(hs.this).mkdirs();
          try
          {
            localObject1 = new FileOutputStream(localFile);
            localObject1 = new a((OutputStream)localObject1, null);
            return (OutputStream)localObject1;
          }
          catch (FileNotFoundException localFileNotFoundException2)
          {
            StringBuilder localStringBuilder;
            for (;;) {}
          }
          localObject1 = hs.g();
          return (OutputStream)localObject1;
          throw new IllegalStateException();
        }
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Expected index ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" to be greater than 0 and less than the maximum value count of ");
        localStringBuilder.append(hs.e(hs.this));
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
    }
    
    public void a()
      throws IOException
    {
      if (this.d)
      {
        hs.a(hs.this, this, false);
        hs.this.c(hs.c.c(this.b));
      }
      else
      {
        hs.a(hs.this, this, true);
      }
      this.e = true;
    }
    
    public void b()
      throws IOException
    {
      hs.a(hs.this, this, false);
    }
    
    private class a
      extends FilterOutputStream
    {
      private a(OutputStream paramOutputStream)
      {
        super();
      }
      
      public void close()
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
        hs.a.a(hs.a.this, true);
      }
      
      public void flush()
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
        hs.a.a(hs.a.this, true);
      }
      
      public void write(int paramInt)
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
        hs.a.a(hs.a.this, true);
      }
      
      public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
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
        hs.a.a(hs.a.this, true);
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
    
    public InputStream a(int paramInt)
    {
      return this.d[paramInt];
    }
    
    public void close()
    {
      InputStream[] arrayOfInputStream = this.d;
      int j = arrayOfInputStream.length;
      int i = 0;
      while (i < j)
      {
        hv.a(arrayOfInputStream[i]);
        i += 1;
      }
    }
  }
  
  private final class c
  {
    private final String b;
    private final long[] c;
    private boolean d;
    private hs.a e;
    private long f;
    
    private c(String paramString)
    {
      this.b = paramString;
      this.c = new long[hs.e(hs.this)];
    }
    
    private void a(String[] paramArrayOfString)
      throws IOException
    {
      int i;
      if (paramArrayOfString.length == hs.e(hs.this)) {
        i = 0;
      }
      try
      {
        while (i < paramArrayOfString.length)
        {
          this.c[i] = Long.parseLong(paramArrayOfString[i]);
          i += 1;
        }
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;) {}
      }
      throw b(paramArrayOfString);
      throw b(paramArrayOfString);
    }
    
    private IOException b(String[] paramArrayOfString)
      throws IOException
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unexpected journal line: ");
      localStringBuilder.append(Arrays.toString(paramArrayOfString));
      throw new IOException(localStringBuilder.toString());
    }
    
    public File a(int paramInt)
    {
      File localFile = hs.f(hs.this);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
      localStringBuilder.append(".");
      localStringBuilder.append(paramInt);
      return new File(localFile, localStringBuilder.toString());
    }
    
    public String a()
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
    
    public File b(int paramInt)
    {
      File localFile = hs.f(hs.this);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
      localStringBuilder.append(".");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(".tmp");
      return new File(localFile, localStringBuilder.toString());
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\hs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */