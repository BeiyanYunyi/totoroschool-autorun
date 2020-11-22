package e;

import e.a.c.g;
import e.a.c.j;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

final class z
  implements e
{
  final x a;
  final j b;
  final f.a c;
  final aa d;
  final boolean e;
  @Nullable
  private p f;
  private boolean g;
  
  private z(x paramx, aa paramaa, boolean paramBoolean)
  {
    this.a = paramx;
    this.d = paramaa;
    this.e = paramBoolean;
    this.b = new j(paramx, paramBoolean);
    this.c = new f.a()
    {
      protected void a()
      {
        z.this.c();
      }
    };
    this.c.a(paramx.a(), TimeUnit.MILLISECONDS);
  }
  
  static z a(x paramx, aa paramaa, boolean paramBoolean)
  {
    paramaa = new z(paramx, paramaa, paramBoolean);
    paramaa.f = paramx.z().a(paramaa);
    return paramaa;
  }
  
  private void i()
  {
    Object localObject = e.a.g.f.c().a("response.body().close()");
    this.b.a(localObject);
  }
  
  public aa a()
  {
    return this.d;
  }
  
  @Nullable
  IOException a(@Nullable IOException paramIOException)
  {
    if (!this.c.m_()) {
      return paramIOException;
    }
    InterruptedIOException localInterruptedIOException = new InterruptedIOException("timeout");
    if (paramIOException != null) {
      localInterruptedIOException.initCause(paramIOException);
    }
    return localInterruptedIOException;
  }
  
  public void a(f paramf)
  {
    try
    {
      if (!this.g)
      {
        this.g = true;
        i();
        this.f.a(this);
        this.a.u().a(new a(paramf));
        return;
      }
      throw new IllegalStateException("Already Executed");
    }
    finally {}
  }
  
  /* Error */
  public ac b()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 115	e/z:g	Z
    //   6: ifne +107 -> 113
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield 115	e/z:g	Z
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_0
    //   17: invokespecial 117	e/z:i	()V
    //   20: aload_0
    //   21: getfield 47	e/z:c	Lf/a;
    //   24: invokevirtual 144	f/a:c	()V
    //   27: aload_0
    //   28: getfield 67	e/z:f	Le/p;
    //   31: aload_0
    //   32: invokevirtual 122	e/p:a	(Le/e;)V
    //   35: aload_0
    //   36: getfield 31	e/z:a	Le/x;
    //   39: invokevirtual 126	e/x:u	()Le/n;
    //   42: aload_0
    //   43: invokevirtual 146	e/n:a	(Le/z;)V
    //   46: aload_0
    //   47: invokevirtual 149	e/z:h	()Le/ac;
    //   50: astore_1
    //   51: aload_1
    //   52: ifnull +16 -> 68
    //   55: aload_0
    //   56: getfield 31	e/z:a	Le/x;
    //   59: invokevirtual 126	e/x:u	()Le/n;
    //   62: aload_0
    //   63: invokevirtual 151	e/n:b	(Le/z;)V
    //   66: aload_1
    //   67: areturn
    //   68: new 142	java/io/IOException
    //   71: dup
    //   72: ldc -103
    //   74: invokespecial 154	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   77: athrow
    //   78: astore_1
    //   79: goto +21 -> 100
    //   82: astore_1
    //   83: aload_0
    //   84: aload_1
    //   85: invokevirtual 156	e/z:a	(Ljava/io/IOException;)Ljava/io/IOException;
    //   88: astore_1
    //   89: aload_0
    //   90: getfield 67	e/z:f	Le/p;
    //   93: aload_0
    //   94: aload_1
    //   95: invokevirtual 159	e/p:a	(Le/e;Ljava/io/IOException;)V
    //   98: aload_1
    //   99: athrow
    //   100: aload_0
    //   101: getfield 31	e/z:a	Le/x;
    //   104: invokevirtual 126	e/x:u	()Le/n;
    //   107: aload_0
    //   108: invokevirtual 151	e/n:b	(Le/z;)V
    //   111: aload_1
    //   112: athrow
    //   113: new 136	java/lang/IllegalStateException
    //   116: dup
    //   117: ldc -118
    //   119: invokespecial 139	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   122: athrow
    //   123: astore_1
    //   124: aload_0
    //   125: monitorexit
    //   126: aload_1
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	z
    //   50	17	1	localac	ac
    //   78	1	1	localObject1	Object
    //   82	3	1	localIOException1	IOException
    //   88	24	1	localIOException2	IOException
    //   123	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   35	51	78	finally
    //   68	78	78	finally
    //   83	100	78	finally
    //   35	51	82	java/io/IOException
    //   68	78	82	java/io/IOException
    //   2	16	123	finally
    //   113	123	123	finally
    //   124	126	123	finally
  }
  
  public void c()
  {
    this.b.a();
  }
  
  public boolean d()
  {
    return this.b.b();
  }
  
  public z e()
  {
    return a(this.a, this.d, this.e);
  }
  
  String f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str;
    if (d()) {
      str = "canceled ";
    } else {
      str = "";
    }
    localStringBuilder.append(str);
    if (this.e) {
      str = "web socket";
    } else {
      str = "call";
    }
    localStringBuilder.append(str);
    localStringBuilder.append(" to ");
    localStringBuilder.append(g());
    return localStringBuilder.toString();
  }
  
  String g()
  {
    return this.d.a().n();
  }
  
  ac h()
    throws IOException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.a.x());
    localArrayList.add(this.b);
    localArrayList.add(new e.a.c.a(this.a.h()));
    localArrayList.add(new e.a.a.a(this.a.i()));
    localArrayList.add(new e.a.b.a(this.a));
    if (!this.e) {
      localArrayList.addAll(this.a.y());
    }
    localArrayList.add(new e.a.c.b(this.e));
    return new g(localArrayList, null, null, null, 0, this.d, this, this.f, this.a.b(), this.a.c(), this.a.d()).a(this.d);
  }
  
  final class a
    extends e.a.b
  {
    private final f d;
    
    a(f paramf)
    {
      super(new Object[] { z.this.g() });
      this.d = paramf;
    }
    
    String a()
    {
      return z.this.d.a().f();
    }
    
    /* Error */
    void a(java.util.concurrent.ExecutorService paramExecutorService)
    {
      // Byte code:
      //   0: getstatic 22	e/z$a:a	Z
      //   3: ifne +30 -> 33
      //   6: aload_0
      //   7: getfield 27	e/z$a:b	Le/z;
      //   10: getfield 59	e/z:a	Le/x;
      //   13: invokevirtual 65	e/x:u	()Le/n;
      //   16: invokestatic 71	java/lang/Thread:holdsLock	(Ljava/lang/Object;)Z
      //   19: ifne +6 -> 25
      //   22: goto +11 -> 33
      //   25: new 73	java/lang/AssertionError
      //   28: dup
      //   29: invokespecial 75	java/lang/AssertionError:<init>	()V
      //   32: athrow
      //   33: aload_1
      //   34: aload_0
      //   35: invokeinterface 81 2 0
      //   40: return
      //   41: astore_1
      //   42: goto +64 -> 106
      //   45: astore_1
      //   46: new 83	java/io/InterruptedIOException
      //   49: dup
      //   50: ldc 85
      //   52: invokespecial 88	java/io/InterruptedIOException:<init>	(Ljava/lang/String;)V
      //   55: astore_2
      //   56: aload_2
      //   57: aload_1
      //   58: invokevirtual 92	java/io/InterruptedIOException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
      //   61: pop
      //   62: aload_0
      //   63: getfield 27	e/z$a:b	Le/z;
      //   66: invokestatic 95	e/z:a	(Le/z;)Le/p;
      //   69: aload_0
      //   70: getfield 27	e/z$a:b	Le/z;
      //   73: aload_2
      //   74: invokevirtual 100	e/p:a	(Le/e;Ljava/io/IOException;)V
      //   77: aload_0
      //   78: getfield 40	e/z$a:d	Le/f;
      //   81: aload_0
      //   82: getfield 27	e/z$a:b	Le/z;
      //   85: aload_2
      //   86: invokeinterface 105 3 0
      //   91: aload_0
      //   92: getfield 27	e/z$a:b	Le/z;
      //   95: getfield 59	e/z:a	Le/x;
      //   98: invokevirtual 65	e/x:u	()Le/n;
      //   101: aload_0
      //   102: invokevirtual 110	e/n:b	(Le/z$a;)V
      //   105: return
      //   106: aload_0
      //   107: getfield 27	e/z$a:b	Le/z;
      //   110: getfield 59	e/z:a	Le/x;
      //   113: invokevirtual 65	e/x:u	()Le/n;
      //   116: aload_0
      //   117: invokevirtual 110	e/n:b	(Le/z$a;)V
      //   120: aload_1
      //   121: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	122	0	this	a
      //   0	122	1	paramExecutorService	java.util.concurrent.ExecutorService
      //   55	31	2	localInterruptedIOException	InterruptedIOException
      // Exception table:
      //   from	to	target	type
      //   33	40	41	finally
      //   46	91	41	finally
      //   33	40	45	java/util/concurrent/RejectedExecutionException
    }
    
    z b()
    {
      return z.this;
    }
    
    /* Error */
    protected void c()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 27	e/z$a:b	Le/z;
      //   4: getfield 117	e/z:c	Lf/a;
      //   7: invokevirtual 121	f/a:c	()V
      //   10: iconst_1
      //   11: istore_1
      //   12: aload_0
      //   13: getfield 27	e/z$a:b	Le/z;
      //   16: invokevirtual 125	e/z:h	()Le/ac;
      //   19: astore_3
      //   20: aload_0
      //   21: getfield 27	e/z$a:b	Le/z;
      //   24: getfield 128	e/z:b	Le/a/c/j;
      //   27: invokevirtual 132	e/a/c/j:b	()Z
      //   30: istore_2
      //   31: iload_2
      //   32: ifeq +28 -> 60
      //   35: aload_0
      //   36: getfield 40	e/z$a:d	Le/f;
      //   39: aload_0
      //   40: getfield 27	e/z$a:b	Le/z;
      //   43: new 114	java/io/IOException
      //   46: dup
      //   47: ldc -122
      //   49: invokespecial 135	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   52: invokeinterface 105 3 0
      //   57: goto +17 -> 74
      //   60: aload_0
      //   61: getfield 40	e/z$a:d	Le/f;
      //   64: aload_0
      //   65: getfield 27	e/z$a:b	Le/z;
      //   68: aload_3
      //   69: invokeinterface 139 3 0
      //   74: aload_0
      //   75: getfield 27	e/z$a:b	Le/z;
      //   78: getfield 59	e/z:a	Le/x;
      //   81: invokevirtual 65	e/x:u	()Le/n;
      //   84: aload_0
      //   85: invokevirtual 110	e/n:b	(Le/z$a;)V
      //   88: return
      //   89: astore_3
      //   90: goto +101 -> 191
      //   93: astore_3
      //   94: iconst_0
      //   95: istore_1
      //   96: aload_0
      //   97: getfield 27	e/z$a:b	Le/z;
      //   100: aload_3
      //   101: invokevirtual 142	e/z:a	(Ljava/io/IOException;)Ljava/io/IOException;
      //   104: astore_3
      //   105: iload_1
      //   106: ifeq +53 -> 159
      //   109: invokestatic 147	e/a/g/f:c	()Le/a/g/f;
      //   112: astore 4
      //   114: new 149	java/lang/StringBuilder
      //   117: dup
      //   118: invokespecial 150	java/lang/StringBuilder:<init>	()V
      //   121: astore 5
      //   123: aload 5
      //   125: ldc -104
      //   127: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   130: pop
      //   131: aload 5
      //   133: aload_0
      //   134: getfield 27	e/z$a:b	Le/z;
      //   137: invokevirtual 157	e/z:f	()Ljava/lang/String;
      //   140: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   143: pop
      //   144: aload 4
      //   146: iconst_4
      //   147: aload 5
      //   149: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   152: aload_3
      //   153: invokevirtual 163	e/a/g/f:a	(ILjava/lang/String;Ljava/lang/Throwable;)V
      //   156: goto -82 -> 74
      //   159: aload_0
      //   160: getfield 27	e/z$a:b	Le/z;
      //   163: invokestatic 95	e/z:a	(Le/z;)Le/p;
      //   166: aload_0
      //   167: getfield 27	e/z$a:b	Le/z;
      //   170: aload_3
      //   171: invokevirtual 100	e/p:a	(Le/e;Ljava/io/IOException;)V
      //   174: aload_0
      //   175: getfield 40	e/z$a:d	Le/f;
      //   178: aload_0
      //   179: getfield 27	e/z$a:b	Le/z;
      //   182: aload_3
      //   183: invokeinterface 105 3 0
      //   188: goto -114 -> 74
      //   191: aload_0
      //   192: getfield 27	e/z$a:b	Le/z;
      //   195: getfield 59	e/z:a	Le/x;
      //   198: invokevirtual 65	e/x:u	()Le/n;
      //   201: aload_0
      //   202: invokevirtual 110	e/n:b	(Le/z$a;)V
      //   205: aload_3
      //   206: athrow
      //   207: astore_3
      //   208: goto -112 -> 96
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	211	0	this	a
      //   11	95	1	i	int
      //   30	2	2	bool	boolean
      //   19	50	3	localac	ac
      //   89	1	3	localObject	Object
      //   93	8	3	localIOException1	IOException
      //   104	102	3	localIOException2	IOException
      //   207	1	3	localIOException3	IOException
      //   112	33	4	localf	e.a.g.f
      //   121	27	5	localStringBuilder	StringBuilder
      // Exception table:
      //   from	to	target	type
      //   12	31	89	finally
      //   35	57	89	finally
      //   60	74	89	finally
      //   96	105	89	finally
      //   109	156	89	finally
      //   159	188	89	finally
      //   12	31	93	java/io/IOException
      //   35	57	207	java/io/IOException
      //   60	74	207	java/io/IOException
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */