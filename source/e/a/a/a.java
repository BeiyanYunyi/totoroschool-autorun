package e.a.a;

import e.a.c.h;
import e.ac;
import e.ac.a;
import e.ad;
import e.s.a;
import e.u;
import f.d;
import f.l;
import f.r;
import f.t;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public final class a
  implements u
{
  final e a;
  
  public a(e parame)
  {
    this.a = parame;
  }
  
  private ac a(final b paramb, ac paramac)
    throws IOException
  {
    if (paramb == null) {
      return paramac;
    }
    Object localObject = paramb.a();
    if (localObject == null) {
      return paramac;
    }
    paramb = new f.s()
    {
      boolean a;
      
      public void close()
        throws IOException
      {
        if ((!this.a) && (!e.a.c.a(this, 100, TimeUnit.MILLISECONDS)))
        {
          this.a = true;
          paramb.b();
        }
        this.b.close();
      }
      
      public long read(f.c paramAnonymousc, long paramAnonymousLong)
        throws IOException
      {
        try
        {
          paramAnonymousLong = this.b.read(paramAnonymousc, paramAnonymousLong);
          if (paramAnonymousLong == -1L)
          {
            if (!this.a)
            {
              this.a = true;
              this.d.close();
            }
            return -1L;
          }
          paramAnonymousc.a(this.d.b(), paramAnonymousc.a() - paramAnonymousLong, paramAnonymousLong);
          this.d.v();
          return paramAnonymousLong;
        }
        catch (IOException paramAnonymousc)
        {
          if (!this.a)
          {
            this.a = true;
            paramb.b();
          }
          throw paramAnonymousc;
        }
      }
      
      public t timeout()
      {
        return this.b.timeout();
      }
    };
    localObject = paramac.a("Content-Type");
    long l = paramac.g().contentLength();
    return paramac.h().a(new h((String)localObject, l, l.a(paramb))).a();
  }
  
  private static ac a(ac paramac)
  {
    ac localac = paramac;
    if (paramac != null)
    {
      localac = paramac;
      if (paramac.g() != null) {
        localac = paramac.h().a(null).a();
      }
    }
    return localac;
  }
  
  private static e.s a(e.s params1, e.s params2)
  {
    s.a locala = new s.a();
    int k = params1.a();
    int j = 0;
    int i = 0;
    while (i < k)
    {
      String str1 = params1.a(i);
      String str2 = params1.b(i);
      if (((!"Warning".equalsIgnoreCase(str1)) || (!str2.startsWith("1"))) && ((b(str1)) || (!a(str1)) || (params2.a(str1) == null))) {
        e.a.a.a.a(locala, str1, str2);
      }
      i += 1;
    }
    k = params2.a();
    i = j;
    while (i < k)
    {
      params1 = params2.a(i);
      if ((!b(params1)) && (a(params1))) {
        e.a.a.a.a(locala, params1, params2.b(i));
      }
      i += 1;
    }
    return locala.a();
  }
  
  static boolean a(String paramString)
  {
    return (!"Connection".equalsIgnoreCase(paramString)) && (!"Keep-Alive".equalsIgnoreCase(paramString)) && (!"Proxy-Authenticate".equalsIgnoreCase(paramString)) && (!"Proxy-Authorization".equalsIgnoreCase(paramString)) && (!"TE".equalsIgnoreCase(paramString)) && (!"Trailers".equalsIgnoreCase(paramString)) && (!"Transfer-Encoding".equalsIgnoreCase(paramString)) && (!"Upgrade".equalsIgnoreCase(paramString));
  }
  
  static boolean b(String paramString)
  {
    return ("Content-Length".equalsIgnoreCase(paramString)) || ("Content-Encoding".equalsIgnoreCase(paramString)) || ("Content-Type".equalsIgnoreCase(paramString));
  }
  
  /* Error */
  public ac a(e.u.a parama)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 17	e/a/a/a:a	Le/a/a/e;
    //   4: ifnull +22 -> 26
    //   7: aload_0
    //   8: getfield 17	e/a/a/a:a	Le/a/a/e;
    //   11: aload_1
    //   12: invokeinterface 147 1 0
    //   17: invokeinterface 152 2 0
    //   22: astore_2
    //   23: goto +5 -> 28
    //   26: aconst_null
    //   27: astore_2
    //   28: new 154	e/a/a/c$a
    //   31: dup
    //   32: invokestatic 159	java/lang/System:currentTimeMillis	()J
    //   35: aload_1
    //   36: invokeinterface 147 1 0
    //   41: aload_2
    //   42: invokespecial 162	e/a/a/c$a:<init>	(JLe/aa;Le/ac;)V
    //   45: invokevirtual 165	e/a/a/c$a:a	()Le/a/a/c;
    //   48: astore 5
    //   50: aload 5
    //   52: getfield 170	e/a/a/c:a	Le/aa;
    //   55: astore_3
    //   56: aload 5
    //   58: getfield 173	e/a/a/c:b	Le/ac;
    //   61: astore 4
    //   63: aload_0
    //   64: getfield 17	e/a/a/a:a	Le/a/a/e;
    //   67: ifnull +14 -> 81
    //   70: aload_0
    //   71: getfield 17	e/a/a/a:a	Le/a/a/e;
    //   74: aload 5
    //   76: invokeinterface 176 2 0
    //   81: aload_2
    //   82: ifnull +15 -> 97
    //   85: aload 4
    //   87: ifnonnull +10 -> 97
    //   90: aload_2
    //   91: invokevirtual 32	e/ac:g	()Le/ad;
    //   94: invokestatic 181	e/a/c:a	(Ljava/io/Closeable;)V
    //   97: aload_3
    //   98: ifnonnull +63 -> 161
    //   101: aload 4
    //   103: ifnonnull +58 -> 161
    //   106: new 69	e/ac$a
    //   109: dup
    //   110: invokespecial 182	e/ac$a:<init>	()V
    //   113: aload_1
    //   114: invokeinterface 147 1 0
    //   119: invokevirtual 185	e/ac$a:a	(Le/aa;)Le/ac$a;
    //   122: getstatic 191	e/y:HTTP_1_1	Le/y;
    //   125: invokevirtual 194	e/ac$a:a	(Le/y;)Le/ac$a;
    //   128: sipush 504
    //   131: invokevirtual 197	e/ac$a:a	(I)Le/ac$a;
    //   134: ldc -57
    //   136: invokevirtual 202	e/ac$a:a	(Ljava/lang/String;)Le/ac$a;
    //   139: getstatic 206	e/a/c:c	Le/ad;
    //   142: invokevirtual 72	e/ac$a:a	(Le/ad;)Le/ac$a;
    //   145: ldc2_w 207
    //   148: invokevirtual 211	e/ac$a:a	(J)Le/ac$a;
    //   151: invokestatic 159	java/lang/System:currentTimeMillis	()J
    //   154: invokevirtual 213	e/ac$a:b	(J)Le/ac$a;
    //   157: invokevirtual 75	e/ac$a:a	()Le/ac;
    //   160: areturn
    //   161: aload_3
    //   162: ifnonnull +20 -> 182
    //   165: aload 4
    //   167: invokevirtual 59	e/ac:h	()Le/ac$a;
    //   170: aload 4
    //   172: invokestatic 215	e/a/a/a:a	(Le/ac;)Le/ac;
    //   175: invokevirtual 218	e/ac$a:b	(Le/ac;)Le/ac$a;
    //   178: invokevirtual 75	e/ac$a:a	()Le/ac;
    //   181: areturn
    //   182: aload_1
    //   183: aload_3
    //   184: invokeinterface 219 2 0
    //   189: astore_1
    //   190: aload_1
    //   191: ifnonnull +14 -> 205
    //   194: aload_2
    //   195: ifnull +10 -> 205
    //   198: aload_2
    //   199: invokevirtual 32	e/ac:g	()Le/ad;
    //   202: invokestatic 181	e/a/c:a	(Ljava/io/Closeable;)V
    //   205: aload 4
    //   207: ifnull +104 -> 311
    //   210: aload_1
    //   211: invokevirtual 221	e/ac:b	()I
    //   214: sipush 304
    //   217: if_icmpne +86 -> 303
    //   220: aload 4
    //   222: invokevirtual 59	e/ac:h	()Le/ac$a;
    //   225: aload 4
    //   227: invokevirtual 224	e/ac:f	()Le/s;
    //   230: aload_1
    //   231: invokevirtual 224	e/ac:f	()Le/s;
    //   234: invokestatic 226	e/a/a/a:a	(Le/s;Le/s;)Le/s;
    //   237: invokevirtual 229	e/ac$a:a	(Le/s;)Le/ac$a;
    //   240: aload_1
    //   241: invokevirtual 232	e/ac:k	()J
    //   244: invokevirtual 211	e/ac$a:a	(J)Le/ac$a;
    //   247: aload_1
    //   248: invokevirtual 235	e/ac:l	()J
    //   251: invokevirtual 213	e/ac$a:b	(J)Le/ac$a;
    //   254: aload 4
    //   256: invokestatic 215	e/a/a/a:a	(Le/ac;)Le/ac;
    //   259: invokevirtual 218	e/ac$a:b	(Le/ac;)Le/ac$a;
    //   262: aload_1
    //   263: invokestatic 215	e/a/a/a:a	(Le/ac;)Le/ac;
    //   266: invokevirtual 237	e/ac$a:a	(Le/ac;)Le/ac$a;
    //   269: invokevirtual 75	e/ac$a:a	()Le/ac;
    //   272: astore_2
    //   273: aload_1
    //   274: invokevirtual 32	e/ac:g	()Le/ad;
    //   277: invokevirtual 240	e/ad:close	()V
    //   280: aload_0
    //   281: getfield 17	e/a/a/a:a	Le/a/a/e;
    //   284: invokeinterface 242 1 0
    //   289: aload_0
    //   290: getfield 17	e/a/a/a:a	Le/a/a/e;
    //   293: aload 4
    //   295: aload_2
    //   296: invokeinterface 245 3 0
    //   301: aload_2
    //   302: areturn
    //   303: aload 4
    //   305: invokevirtual 32	e/ac:g	()Le/ad;
    //   308: invokestatic 181	e/a/c:a	(Ljava/io/Closeable;)V
    //   311: aload_1
    //   312: invokevirtual 59	e/ac:h	()Le/ac$a;
    //   315: aload 4
    //   317: invokestatic 215	e/a/a/a:a	(Le/ac;)Le/ac;
    //   320: invokevirtual 218	e/ac$a:b	(Le/ac;)Le/ac$a;
    //   323: aload_1
    //   324: invokestatic 215	e/a/a/a:a	(Le/ac;)Le/ac;
    //   327: invokevirtual 237	e/ac$a:a	(Le/ac;)Le/ac$a;
    //   330: invokevirtual 75	e/ac$a:a	()Le/ac;
    //   333: astore_1
    //   334: aload_0
    //   335: getfield 17	e/a/a/a:a	Le/a/a/e;
    //   338: ifnull +54 -> 392
    //   341: aload_1
    //   342: invokestatic 250	e/a/c/e:b	(Le/ac;)Z
    //   345: ifeq +27 -> 372
    //   348: aload_1
    //   349: aload_3
    //   350: invokestatic 253	e/a/a/c:a	(Le/ac;Le/aa;)Z
    //   353: ifeq +19 -> 372
    //   356: aload_0
    //   357: aload_0
    //   358: getfield 17	e/a/a/a:a	Le/a/a/e;
    //   361: aload_1
    //   362: invokeinterface 256 2 0
    //   367: aload_1
    //   368: invokespecial 258	e/a/a/a:a	(Le/a/a/b;Le/ac;)Le/ac;
    //   371: areturn
    //   372: aload_3
    //   373: invokevirtual 263	e/aa:b	()Ljava/lang/String;
    //   376: invokestatic 266	e/a/c/f:a	(Ljava/lang/String;)Z
    //   379: ifeq +13 -> 392
    //   382: aload_0
    //   383: getfield 17	e/a/a/a:a	Le/a/a/e;
    //   386: aload_3
    //   387: invokeinterface 269 2 0
    //   392: aload_1
    //   393: areturn
    //   394: astore_1
    //   395: aload_2
    //   396: ifnull +10 -> 406
    //   399: aload_2
    //   400: invokevirtual 32	e/ac:g	()Le/ad;
    //   403: invokestatic 181	e/a/c:a	(Ljava/io/Closeable;)V
    //   406: aload_1
    //   407: athrow
    //   408: astore_2
    //   409: aload_1
    //   410: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	411	0	this	a
    //   0	411	1	parama	e.u.a
    //   22	378	2	localac1	ac
    //   408	1	2	localIOException	IOException
    //   55	332	3	localaa	e.aa
    //   61	255	4	localac2	ac
    //   48	27	5	localc	c
    // Exception table:
    //   from	to	target	type
    //   182	190	394	finally
    //   382	392	408	java/io/IOException
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */