package com.bumptech.glide.a;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
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
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a
  implements Closeable
{
  final ThreadPoolExecutor a = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
  private final File b;
  private final File c;
  private final File d;
  private final File e;
  private final int f;
  private long g;
  private final int h;
  private long i = 0L;
  private Writer j;
  private final LinkedHashMap<String, b> k = new LinkedHashMap(0, 0.75F, true);
  private int l;
  private long m = 0L;
  private final Callable<Void> n = new Callable()
  {
    public Void a()
      throws Exception
    {
      synchronized (a.this)
      {
        if (a.a(a.this) == null) {
          return null;
        }
        a.b(a.this);
        if (a.c(a.this))
        {
          a.d(a.this);
          a.a(a.this, 0);
        }
        return null;
      }
    }
  };
  
  private a(File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    this.b = paramFile;
    this.f = paramInt1;
    this.c = new File(paramFile, "journal");
    this.d = new File(paramFile, "journal.tmp");
    this.e = new File(paramFile, "journal.bkp");
    this.h = paramInt2;
    this.g = paramLong;
  }
  
  private a a(String paramString, long paramLong)
    throws IOException
  {
    try
    {
      f();
      b localb = (b)this.k.get(paramString);
      if (paramLong != -1L) {
        if (localb != null)
        {
          long l1 = b.e(localb);
          if (l1 == paramLong) {}
        }
        else
        {
          return null;
        }
      }
      if (localb == null)
      {
        localb = new b(paramString, null);
        this.k.put(paramString, localb);
      }
      else
      {
        locala = b.a(localb);
        if (locala != null) {
          return null;
        }
      }
      a locala = new a(localb, null);
      b.a(localb, locala);
      this.j.append("DIRTY");
      this.j.append(' ');
      this.j.append(paramString);
      this.j.append('\n');
      this.j.flush();
      return locala;
    }
    finally {}
  }
  
  public static a a(File paramFile, int paramInt1, int paramInt2, long paramLong)
    throws IOException
  {
    if (paramLong > 0L)
    {
      if (paramInt2 > 0)
      {
        Object localObject = new File(paramFile, "journal.bkp");
        if (((File)localObject).exists())
        {
          File localFile = new File(paramFile, "journal");
          if (localFile.exists()) {
            ((File)localObject).delete();
          } else {
            a((File)localObject, localFile, false);
          }
        }
        localObject = new a(paramFile, paramInt1, paramInt2, paramLong);
        if (((a)localObject).c.exists()) {
          try
          {
            ((a)localObject).b();
            ((a)localObject).c();
            return (a)localObject;
          }
          catch (IOException localIOException)
          {
            PrintStream localPrintStream = System.out;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("DiskLruCache ");
            localStringBuilder.append(paramFile);
            localStringBuilder.append(" is corrupt: ");
            localStringBuilder.append(localIOException.getMessage());
            localStringBuilder.append(", removing");
            localPrintStream.println(localStringBuilder.toString());
            ((a)localObject).a();
          }
        }
        paramFile.mkdirs();
        paramFile = new a(paramFile, paramInt1, paramInt2, paramLong);
        paramFile.d();
        return paramFile;
      }
      throw new IllegalArgumentException("valueCount <= 0");
    }
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  private void a(a parama, boolean paramBoolean)
    throws IOException
  {
    for (;;)
    {
      int i2;
      try
      {
        b localb = a.a(parama);
        if (b.a(localb) == parama)
        {
          int i3 = 0;
          i2 = i3;
          if (paramBoolean)
          {
            i2 = i3;
            if (!b.d(localb))
            {
              int i1 = 0;
              i2 = i3;
              if (i1 < this.h)
              {
                if (a.b(parama)[i1] != 0)
                {
                  if (!localb.b(i1).exists())
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
          long l1;
          if (i2 < this.h)
          {
            parama = localb.b(i2);
            if (paramBoolean)
            {
              if (parama.exists())
              {
                File localFile = localb.a(i2);
                parama.renameTo(localFile);
                l1 = b.b(localb)[i2];
                long l2 = localFile.length();
                b.b(localb)[i2] = l2;
                this.i = (this.i - l1 + l2);
              }
            }
            else {
              a(parama);
            }
          }
          else
          {
            this.l += 1;
            b.a(localb, null);
            if ((b.d(localb) | paramBoolean))
            {
              b.a(localb, true);
              this.j.append("CLEAN");
              this.j.append(' ');
              this.j.append(b.c(localb));
              this.j.append(localb.a());
              this.j.append('\n');
              if (paramBoolean)
              {
                l1 = this.m;
                this.m = (1L + l1);
                b.a(localb, l1);
              }
            }
            else
            {
              this.k.remove(b.c(localb));
              this.j.append("REMOVE");
              this.j.append(' ');
              this.j.append(b.c(localb));
              this.j.append('\n');
            }
            this.j.flush();
            if ((this.i > this.g) || (e())) {
              this.a.submit(this.n);
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
  
  private void b()
    throws IOException
  {
    localb = new b(new FileInputStream(this.c), c.a);
    for (;;)
    {
      try
      {
        str1 = localb.a();
        str2 = localb.a();
        localObject2 = localb.a();
        str3 = localb.a();
        str4 = localb.a();
        if (("libcore.io.DiskLruCache".equals(str1)) && ("1".equals(str2)) && (Integer.toString(this.f).equals(localObject2)) && (Integer.toString(this.h).equals(str3)))
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
        c.a(localb);
      }
      try
      {
        d(localb.a());
        i1 += 1;
      }
      catch (EOFException localEOFException) {}
    }
    this.l = (i1 - this.k.size());
    if (localb.b()) {
      d();
    } else {
      this.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c, true), c.a));
    }
    c.a(localb);
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
  
  private void c()
    throws IOException
  {
    a(this.d);
    Iterator localIterator = this.k.values().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      a locala = b.a(localb);
      int i2 = 0;
      int i1 = 0;
      if (locala == null)
      {
        while (i1 < this.h)
        {
          this.i += b.b(localb)[i1];
          i1 += 1;
        }
      }
      else
      {
        b.a(localb, null);
        i1 = i2;
        while (i1 < this.h)
        {
          a(localb.a(i1));
          a(localb.b(i1));
          i1 += 1;
        }
        localIterator.remove();
      }
    }
  }
  
  /* Error */
  private void d()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 138	com/bumptech/glide/a/a:j	Ljava/io/Writer;
    //   6: ifnull +10 -> 16
    //   9: aload_0
    //   10: getfield 138	com/bumptech/glide/a/a:j	Ljava/io/Writer;
    //   13: invokevirtual 381	java/io/Writer:close	()V
    //   16: new 331	java/io/BufferedWriter
    //   19: dup
    //   20: new 333	java/io/OutputStreamWriter
    //   23: dup
    //   24: new 335	java/io/FileOutputStream
    //   27: dup
    //   28: aload_0
    //   29: getfield 94	com/bumptech/glide/a/a:d	Ljava/io/File;
    //   32: invokespecial 382	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   35: getstatic 300	com/bumptech/glide/a/c:a	Ljava/nio/charset/Charset;
    //   38: invokespecial 341	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   41: invokespecial 344	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   44: astore_1
    //   45: aload_1
    //   46: ldc_w 306
    //   49: invokevirtual 385	java/io/Writer:write	(Ljava/lang/String;)V
    //   52: aload_1
    //   53: ldc_w 387
    //   56: invokevirtual 385	java/io/Writer:write	(Ljava/lang/String;)V
    //   59: aload_1
    //   60: ldc_w 314
    //   63: invokevirtual 385	java/io/Writer:write	(Ljava/lang/String;)V
    //   66: aload_1
    //   67: ldc_w 387
    //   70: invokevirtual 385	java/io/Writer:write	(Ljava/lang/String;)V
    //   73: aload_1
    //   74: aload_0
    //   75: getfield 81	com/bumptech/glide/a/a:f	I
    //   78: invokestatic 319	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   81: invokevirtual 385	java/io/Writer:write	(Ljava/lang/String;)V
    //   84: aload_1
    //   85: ldc_w 387
    //   88: invokevirtual 385	java/io/Writer:write	(Ljava/lang/String;)V
    //   91: aload_1
    //   92: aload_0
    //   93: getfield 100	com/bumptech/glide/a/a:h	I
    //   96: invokestatic 319	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   99: invokevirtual 385	java/io/Writer:write	(Ljava/lang/String;)V
    //   102: aload_1
    //   103: ldc_w 387
    //   106: invokevirtual 385	java/io/Writer:write	(Ljava/lang/String;)V
    //   109: aload_1
    //   110: ldc_w 387
    //   113: invokevirtual 385	java/io/Writer:write	(Ljava/lang/String;)V
    //   116: aload_0
    //   117: getfield 52	com/bumptech/glide/a/a:k	Ljava/util/LinkedHashMap;
    //   120: invokevirtual 360	java/util/LinkedHashMap:values	()Ljava/util/Collection;
    //   123: invokeinterface 366 1 0
    //   128: astore_2
    //   129: aload_2
    //   130: invokeinterface 371 1 0
    //   135: ifeq +126 -> 261
    //   138: aload_2
    //   139: invokeinterface 375 1 0
    //   144: checkcast 13	com/bumptech/glide/a/a$b
    //   147: astore_3
    //   148: aload_3
    //   149: invokestatic 130	com/bumptech/glide/a/a$b:a	(Lcom/bumptech/glide/a/a$b;)Lcom/bumptech/glide/a/a$a;
    //   152: ifnull +51 -> 203
    //   155: new 178	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   162: astore 4
    //   164: aload 4
    //   166: ldc_w 389
    //   169: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload 4
    //   175: aload_3
    //   176: invokestatic 266	com/bumptech/glide/a/a$b:c	(Lcom/bumptech/glide/a/a$b;)Ljava/lang/String;
    //   179: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 4
    //   185: bipush 10
    //   187: invokevirtual 392	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_1
    //   192: aload 4
    //   194: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokevirtual 385	java/io/Writer:write	(Ljava/lang/String;)V
    //   200: goto -71 -> 129
    //   203: new 178	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 179	java/lang/StringBuilder:<init>	()V
    //   210: astore 4
    //   212: aload 4
    //   214: ldc_w 394
    //   217: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload 4
    //   223: aload_3
    //   224: invokestatic 266	com/bumptech/glide/a/a$b:c	(Lcom/bumptech/glide/a/a$b;)Ljava/lang/String;
    //   227: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload 4
    //   233: aload_3
    //   234: invokevirtual 268	com/bumptech/glide/a/a$b:a	()Ljava/lang/String;
    //   237: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload 4
    //   243: bipush 10
    //   245: invokevirtual 392	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload_1
    //   250: aload 4
    //   252: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokevirtual 385	java/io/Writer:write	(Ljava/lang/String;)V
    //   258: goto -129 -> 129
    //   261: aload_1
    //   262: invokevirtual 381	java/io/Writer:close	()V
    //   265: aload_0
    //   266: getfield 90	com/bumptech/glide/a/a:c	Ljava/io/File;
    //   269: invokevirtual 158	java/io/File:exists	()Z
    //   272: ifeq +15 -> 287
    //   275: aload_0
    //   276: getfield 90	com/bumptech/glide/a/a:c	Ljava/io/File;
    //   279: aload_0
    //   280: getfield 98	com/bumptech/glide/a/a:e	Ljava/io/File;
    //   283: iconst_1
    //   284: invokestatic 164	com/bumptech/glide/a/a:a	(Ljava/io/File;Ljava/io/File;Z)V
    //   287: aload_0
    //   288: getfield 94	com/bumptech/glide/a/a:d	Ljava/io/File;
    //   291: aload_0
    //   292: getfield 90	com/bumptech/glide/a/a:c	Ljava/io/File;
    //   295: iconst_0
    //   296: invokestatic 164	com/bumptech/glide/a/a:a	(Ljava/io/File;Ljava/io/File;Z)V
    //   299: aload_0
    //   300: getfield 98	com/bumptech/glide/a/a:e	Ljava/io/File;
    //   303: invokevirtual 161	java/io/File:delete	()Z
    //   306: pop
    //   307: aload_0
    //   308: new 331	java/io/BufferedWriter
    //   311: dup
    //   312: new 333	java/io/OutputStreamWriter
    //   315: dup
    //   316: new 335	java/io/FileOutputStream
    //   319: dup
    //   320: aload_0
    //   321: getfield 90	com/bumptech/glide/a/a:c	Ljava/io/File;
    //   324: iconst_1
    //   325: invokespecial 338	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   328: getstatic 300	com/bumptech/glide/a/c:a	Ljava/nio/charset/Charset;
    //   331: invokespecial 341	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   334: invokespecial 344	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   337: putfield 138	com/bumptech/glide/a/a:j	Ljava/io/Writer;
    //   340: aload_0
    //   341: monitorexit
    //   342: return
    //   343: astore_2
    //   344: aload_1
    //   345: invokevirtual 381	java/io/Writer:close	()V
    //   348: aload_2
    //   349: athrow
    //   350: astore_1
    //   351: aload_0
    //   352: monitorexit
    //   353: aload_1
    //   354: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	355	0	this	a
    //   44	301	1	localBufferedWriter	BufferedWriter
    //   350	4	1	localObject1	Object
    //   128	11	2	localIterator	Iterator
    //   343	6	2	localObject2	Object
    //   147	87	3	localb	b
    //   162	89	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   45	129	343	finally
    //   129	200	343	finally
    //   203	258	343	finally
    //   2	16	350	finally
    //   16	45	350	finally
    //   261	287	350	finally
    //   287	340	350	finally
    //   344	350	350	finally
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
            this.k.remove(localObject2);
          }
        }
      }
      else
      {
        localObject1 = paramString.substring(i2, i3);
      }
      b localb = (b)this.k.get(localObject1);
      Object localObject2 = localb;
      if (localb == null)
      {
        localObject2 = new b((String)localObject1, null);
        this.k.put(localObject1, localObject2);
      }
      if ((i3 != -1) && (i1 == "CLEAN".length()) && (paramString.startsWith("CLEAN")))
      {
        paramString = paramString.substring(i3 + 1).split(" ");
        b.a((b)localObject2, true);
        b.a((b)localObject2, null);
        b.a((b)localObject2, paramString);
        return;
      }
      if ((i3 == -1) && (i1 == "DIRTY".length()) && (paramString.startsWith("DIRTY")))
      {
        b.a((b)localObject2, new a((b)localObject2, null));
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
  
  private boolean e()
  {
    return (this.l >= 2000) && (this.l >= this.k.size());
  }
  
  private void f()
  {
    if (this.j != null) {
      return;
    }
    throw new IllegalStateException("cache is closed");
  }
  
  private void g()
    throws IOException
  {
    while (this.i > this.g) {
      c((String)((Map.Entry)this.k.entrySet().iterator().next()).getKey());
    }
  }
  
  public c a(String paramString)
    throws IOException
  {
    try
    {
      f();
      b localb = (b)this.k.get(paramString);
      if (localb == null) {
        return null;
      }
      boolean bool = b.d(localb);
      if (!bool) {
        return null;
      }
      File[] arrayOfFile = localb.a;
      int i2 = arrayOfFile.length;
      int i1 = 0;
      while (i1 < i2)
      {
        bool = arrayOfFile[i1].exists();
        if (!bool) {
          return null;
        }
        i1 += 1;
      }
      this.l += 1;
      this.j.append("READ");
      this.j.append(' ');
      this.j.append(paramString);
      this.j.append('\n');
      if (e()) {
        this.a.submit(this.n);
      }
      paramString = new c(paramString, b.e(localb), localb.a, b.b(localb), null);
      return paramString;
    }
    finally {}
  }
  
  public void a()
    throws IOException
  {
    close();
    c.a(this.b);
  }
  
  public a b(String paramString)
    throws IOException
  {
    return a(paramString, -1L);
  }
  
  public boolean c(String paramString)
    throws IOException
  {
    try
    {
      f();
      b localb = (b)this.k.get(paramString);
      int i1 = 0;
      if ((localb != null) && (b.a(localb) == null))
      {
        while (i1 < this.h)
        {
          File localFile = localb.a(i1);
          if ((localFile.exists()) && (!localFile.delete()))
          {
            paramString = new StringBuilder();
            paramString.append("failed to delete ");
            paramString.append(localFile);
            throw new IOException(paramString.toString());
          }
          this.i -= b.b(localb)[i1];
          b.b(localb)[i1] = 0L;
          i1 += 1;
        }
        this.l += 1;
        this.j.append("REMOVE");
        this.j.append(' ');
        this.j.append(paramString);
        this.j.append('\n');
        this.k.remove(paramString);
        if (e()) {
          this.a.submit(this.n);
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
      Object localObject1 = this.j;
      if (localObject1 == null) {
        return;
      }
      localObject1 = new ArrayList(this.k.values()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        b localb = (b)((Iterator)localObject1).next();
        if (b.a(localb) != null) {
          b.a(localb).b();
        }
      }
      g();
      this.j.close();
      this.j = null;
      return;
    }
    finally {}
  }
  
  public final class a
  {
    private final a.b b;
    private final boolean[] c;
    private boolean d;
    
    private a(a.b paramb)
    {
      this.b = paramb;
      if (a.b.d(paramb)) {
        this$1 = null;
      } else {
        this$1 = new boolean[a.e(a.this)];
      }
      this.c = a.this;
    }
    
    public File a(int paramInt)
      throws IOException
    {
      synchronized (a.this)
      {
        if (a.b.a(this.b) == this)
        {
          if (!a.b.d(this.b)) {
            this.c[paramInt] = true;
          }
          File localFile = this.b.b(paramInt);
          if (!a.f(a.this).exists()) {
            a.f(a.this).mkdirs();
          }
          return localFile;
        }
        throw new IllegalStateException();
      }
    }
    
    public void a()
      throws IOException
    {
      a.a(a.this, this, true);
      this.d = true;
    }
    
    public void b()
      throws IOException
    {
      a.a(a.this, this, false);
    }
    
    public void c()
    {
      if (!this.d) {}
      try
      {
        b();
        return;
      }
      catch (IOException localIOException) {}
    }
  }
  
  private final class b
  {
    File[] a;
    File[] b;
    private final String d;
    private final long[] e;
    private boolean f;
    private a.a g;
    private long h;
    
    private b(String paramString)
    {
      this.d = paramString;
      this.e = new long[a.e(a.this)];
      this.a = new File[a.e(a.this)];
      this.b = new File[a.e(a.this)];
      paramString = new StringBuilder(paramString);
      paramString.append('.');
      int j = paramString.length();
      int i = 0;
      while (i < a.e(a.this))
      {
        paramString.append(i);
        this.a[i] = new File(a.f(a.this), paramString.toString());
        paramString.append(".tmp");
        this.b[i] = new File(a.f(a.this), paramString.toString());
        paramString.setLength(j);
        i += 1;
      }
    }
    
    private void a(String[] paramArrayOfString)
      throws IOException
    {
      int i;
      if (paramArrayOfString.length == a.e(a.this)) {
        i = 0;
      }
      try
      {
        while (i < paramArrayOfString.length)
        {
          this.e[i] = Long.parseLong(paramArrayOfString[i]);
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
      return this.a[paramInt];
    }
    
    public String a()
      throws IOException
    {
      StringBuilder localStringBuilder = new StringBuilder();
      long[] arrayOfLong = this.e;
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
      return this.b[paramInt];
    }
  }
  
  public final class c
  {
    private final String b;
    private final long c;
    private final long[] d;
    private final File[] e;
    
    private c(String paramString, long paramLong, File[] paramArrayOfFile, long[] paramArrayOfLong)
    {
      this.b = paramString;
      this.c = paramLong;
      this.e = paramArrayOfFile;
      this.d = paramArrayOfLong;
    }
    
    public File a(int paramInt)
    {
      return this.e[paramInt];
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */