package com.bumptech.glide.load.b;

import android.util.Log;
import com.bumptech.glide.h.d;
import com.bumptech.glide.load.e;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class a<A, T, Z>
{
  private static final b a = new b();
  private final f b;
  private final int c;
  private final int d;
  private final com.bumptech.glide.load.a.c<A> e;
  private final com.bumptech.glide.e.b<A, T> f;
  private final com.bumptech.glide.load.g<T> g;
  private final com.bumptech.glide.load.resource.e.c<T, Z> h;
  private final a i;
  private final b j;
  private final com.bumptech.glide.g k;
  private final b l;
  private volatile boolean m;
  
  public a(f paramf, int paramInt1, int paramInt2, com.bumptech.glide.load.a.c<A> paramc, com.bumptech.glide.e.b<A, T> paramb, com.bumptech.glide.load.g<T> paramg, com.bumptech.glide.load.resource.e.c<T, Z> paramc1, a parama, b paramb1, com.bumptech.glide.g paramg1)
  {
    this(paramf, paramInt1, paramInt2, paramc, paramb, paramg, paramc1, parama, paramb1, paramg1, a);
  }
  
  a(f paramf, int paramInt1, int paramInt2, com.bumptech.glide.load.a.c<A> paramc, com.bumptech.glide.e.b<A, T> paramb, com.bumptech.glide.load.g<T> paramg, com.bumptech.glide.load.resource.e.c<T, Z> paramc1, a parama, b paramb1, com.bumptech.glide.g paramg1, b paramb2)
  {
    this.b = paramf;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramc;
    this.f = paramb;
    this.g = paramg;
    this.h = paramc1;
    this.i = parama;
    this.j = paramb1;
    this.k = paramg1;
    this.l = paramb2;
  }
  
  private k<Z> a(k<T> paramk)
  {
    long l1 = d.a();
    paramk = c(paramk);
    if (Log.isLoggable("DecodeJob", 2)) {
      a("Transformed resource from source", l1);
    }
    b(paramk);
    l1 = d.a();
    paramk = d(paramk);
    if (Log.isLoggable("DecodeJob", 2)) {
      a("Transcoded transformed from source", l1);
    }
    return paramk;
  }
  
  private k<T> a(com.bumptech.glide.load.c paramc)
    throws IOException
  {
    Object localObject1 = this.i.a().a(paramc);
    if (localObject1 == null) {
      return null;
    }
    try
    {
      localObject1 = this.f.a().a(localObject1, this.c, this.d);
      if (localObject1 == null) {}
      return (k<T>)localObject1;
    }
    finally
    {
      this.i.a().b(paramc);
    }
  }
  
  private k<T> a(A paramA)
    throws IOException
  {
    if (this.j.cacheSource()) {
      return b(paramA);
    }
    long l1 = d.a();
    paramA = this.f.b().a(paramA, this.c, this.d);
    if (Log.isLoggable("DecodeJob", 2)) {
      a("Decoded from source", l1);
    }
    return paramA;
  }
  
  private void a(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(" in ");
    localStringBuilder.append(d.a(paramLong));
    localStringBuilder.append(", key: ");
    localStringBuilder.append(this.b);
    Log.v("DecodeJob", localStringBuilder.toString());
  }
  
  private k<T> b(A paramA)
    throws IOException
  {
    long l1 = d.a();
    paramA = new c(this.f.c(), paramA);
    this.i.a().a(this.b.a(), paramA);
    if (Log.isLoggable("DecodeJob", 2)) {
      a("Wrote source to cache", l1);
    }
    l1 = d.a();
    paramA = a(this.b.a());
    if ((Log.isLoggable("DecodeJob", 2)) && (paramA != null)) {
      a("Decoded source from cache", l1);
    }
    return paramA;
  }
  
  private void b(k<T> paramk)
  {
    if (paramk != null)
    {
      if (!this.j.cacheResult()) {
        return;
      }
      long l1 = d.a();
      paramk = new c(this.f.d(), paramk);
      this.i.a().a(this.b, paramk);
      if (Log.isLoggable("DecodeJob", 2)) {
        a("Wrote transformed from source to cache", l1);
      }
      return;
    }
  }
  
  private k<T> c(k<T> paramk)
  {
    if (paramk == null) {
      return null;
    }
    k localk = this.g.a(paramk, this.c, this.d);
    if (!paramk.equals(localk)) {
      paramk.d();
    }
    return localk;
  }
  
  private k<Z> d(k<T> paramk)
  {
    if (paramk == null) {
      return null;
    }
    return this.h.a(paramk);
  }
  
  private k<T> e()
    throws Exception
  {
    try
    {
      long l1 = d.a();
      Object localObject1 = this.e.a(this.k);
      if (Log.isLoggable("DecodeJob", 2)) {
        a("Fetched data", l1);
      }
      boolean bool = this.m;
      if (bool) {
        return null;
      }
      localObject1 = a(localObject1);
      return (k<T>)localObject1;
    }
    finally
    {
      this.e.a();
    }
  }
  
  public k<Z> a()
    throws Exception
  {
    if (!this.j.cacheResult()) {
      return null;
    }
    long l1 = d.a();
    k localk = a(this.b);
    if (Log.isLoggable("DecodeJob", 2)) {
      a("Decoded transformed from cache", l1);
    }
    l1 = d.a();
    localk = d(localk);
    if (Log.isLoggable("DecodeJob", 2)) {
      a("Transcoded transformed from cache", l1);
    }
    return localk;
  }
  
  public k<Z> b()
    throws Exception
  {
    if (!this.j.cacheSource()) {
      return null;
    }
    long l1 = d.a();
    k localk = a(this.b.a());
    if (Log.isLoggable("DecodeJob", 2)) {
      a("Decoded source from cache", l1);
    }
    return a(localk);
  }
  
  public k<Z> c()
    throws Exception
  {
    return a(e());
  }
  
  public void d()
  {
    this.m = true;
    this.e.c();
  }
  
  static abstract interface a
  {
    public abstract com.bumptech.glide.load.b.b.a a();
  }
  
  static class b
  {
    public OutputStream a(File paramFile)
      throws FileNotFoundException
    {
      return new BufferedOutputStream(new FileOutputStream(paramFile));
    }
  }
  
  class c<DataType>
    implements com.bumptech.glide.load.b.b.a.b
  {
    private final com.bumptech.glide.load.b<DataType> b;
    private final DataType c;
    
    public c(DataType paramDataType)
    {
      this.b = paramDataType;
      Object localObject;
      this.c = localObject;
    }
    
    /* Error */
    public boolean a(File paramFile)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 6
      //   3: aconst_null
      //   4: astore 4
      //   6: aload_0
      //   7: getfield 21	com/bumptech/glide/load/b/a$c:a	Lcom/bumptech/glide/load/b/a;
      //   10: invokestatic 39	com/bumptech/glide/load/b/a:a	(Lcom/bumptech/glide/load/b/a;)Lcom/bumptech/glide/load/b/a$b;
      //   13: aload_1
      //   14: invokevirtual 44	com/bumptech/glide/load/b/a$b:a	(Ljava/io/File;)Ljava/io/OutputStream;
      //   17: astore_1
      //   18: aload_0
      //   19: getfield 26	com/bumptech/glide/load/b/a$c:b	Lcom/bumptech/glide/load/b;
      //   22: aload_0
      //   23: getfield 28	com/bumptech/glide/load/b/a$c:c	Ljava/lang/Object;
      //   26: aload_1
      //   27: invokeinterface 49 3 0
      //   32: istore_3
      //   33: iload_3
      //   34: istore_2
      //   35: aload_1
      //   36: ifnull +67 -> 103
      //   39: aload_1
      //   40: invokevirtual 54	java/io/OutputStream:close	()V
      //   43: iload_3
      //   44: ireturn
      //   45: astore 5
      //   47: aload_1
      //   48: astore 4
      //   50: goto +55 -> 105
      //   53: astore 5
      //   55: goto +13 -> 68
      //   58: astore 5
      //   60: goto +45 -> 105
      //   63: astore 5
      //   65: aload 6
      //   67: astore_1
      //   68: aload_1
      //   69: astore 4
      //   71: ldc 56
      //   73: iconst_3
      //   74: invokestatic 62	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
      //   77: ifeq +16 -> 93
      //   80: aload_1
      //   81: astore 4
      //   83: ldc 56
      //   85: ldc 64
      //   87: aload 5
      //   89: invokestatic 68	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   92: pop
      //   93: aload_1
      //   94: ifnull +7 -> 101
      //   97: aload_1
      //   98: invokevirtual 54	java/io/OutputStream:close	()V
      //   101: iconst_0
      //   102: istore_2
      //   103: iload_2
      //   104: ireturn
      //   105: aload 4
      //   107: ifnull +8 -> 115
      //   110: aload 4
      //   112: invokevirtual 54	java/io/OutputStream:close	()V
      //   115: aload 5
      //   117: athrow
      //   118: astore_1
      //   119: iload_3
      //   120: ireturn
      //   121: astore_1
      //   122: goto -21 -> 101
      //   125: astore_1
      //   126: goto -11 -> 115
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	129	0	this	c
      //   0	129	1	paramFile	File
      //   34	70	2	bool1	boolean
      //   32	88	3	bool2	boolean
      //   4	107	4	localFile	File
      //   45	1	5	localObject1	Object
      //   53	1	5	localFileNotFoundException1	FileNotFoundException
      //   58	1	5	localObject2	Object
      //   63	53	5	localFileNotFoundException2	FileNotFoundException
      //   1	65	6	localObject3	Object
      // Exception table:
      //   from	to	target	type
      //   18	33	45	finally
      //   18	33	53	java/io/FileNotFoundException
      //   6	18	58	finally
      //   71	80	58	finally
      //   83	93	58	finally
      //   6	18	63	java/io/FileNotFoundException
      //   39	43	118	java/io/IOException
      //   97	101	121	java/io/IOException
      //   110	115	125	java/io/IOException
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */