package e.a.c;

import e.a;
import e.aa;
import e.aa.a;
import e.ac;
import e.ae;
import e.b;
import e.t;
import e.u;
import e.x;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

public final class j
  implements u
{
  private final x a;
  private final boolean b;
  private volatile e.a.b.g c;
  private Object d;
  private volatile boolean e;
  
  public j(x paramx, boolean paramBoolean)
  {
    this.a = paramx;
    this.b = paramBoolean;
  }
  
  private int a(ac paramac, int paramInt)
  {
    paramac = paramac.a("Retry-After");
    if (paramac == null) {
      return paramInt;
    }
    if (paramac.matches("\\d+")) {
      return Integer.valueOf(paramac).intValue();
    }
    return Integer.MAX_VALUE;
  }
  
  private a a(t paramt)
  {
    Object localObject2;
    Object localObject1;
    e.g localg;
    Object localObject3;
    if (paramt.c())
    {
      localObject2 = this.a.l();
      localObject1 = this.a.m();
      localg = this.a.n();
      localObject3 = localg;
    }
    else
    {
      localg = null;
      localObject1 = localg;
      localObject3 = localObject1;
      localObject2 = localg;
    }
    return new a(paramt.f(), paramt.g(), this.a.j(), this.a.k(), (SSLSocketFactory)localObject2, (HostnameVerifier)localObject1, (e.g)localObject3, this.a.p(), this.a.f(), this.a.v(), this.a.w(), this.a.g());
  }
  
  private aa a(ac paramac, ae paramae)
    throws IOException
  {
    if (paramac != null)
    {
      int i = paramac.b();
      String str = paramac.a().b();
      Proxy localProxy = null;
      switch (i)
      {
      default: 
        return null;
      case 503: 
        if ((paramac.i() != null) && (paramac.i().b() == 503)) {
          return null;
        }
        if (a(paramac, Integer.MAX_VALUE) == 0) {
          return paramac.a();
        }
        return null;
      case 408: 
        if (!this.a.t()) {
          return null;
        }
        if ((paramac.a().d() instanceof l)) {
          return null;
        }
        if ((paramac.i() != null) && (paramac.i().b() == 408)) {
          return null;
        }
        if (a(paramac, 0) > 0) {
          return null;
        }
        return paramac.a();
      case 407: 
        if (paramae != null) {
          localProxy = paramae.b();
        } else {
          localProxy = this.a.f();
        }
        if (localProxy.type() == Proxy.Type.HTTP) {
          return this.a.p().a(paramae, paramac);
        }
        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
      case 401: 
        return this.a.o().a(paramae, paramac);
      case 307: 
      case 308: 
        if ((!str.equals("GET")) && (!str.equals("HEAD"))) {
          return null;
        }
        break;
      }
      if (!this.a.s()) {
        return null;
      }
      paramae = paramac.a("Location");
      if (paramae == null) {
        return null;
      }
      t localt = paramac.a().a().c(paramae);
      if (localt == null) {
        return null;
      }
      if ((!localt.b().equals(paramac.a().a().b())) && (!this.a.r())) {
        return null;
      }
      aa.a locala = paramac.a().e();
      if (f.c(str))
      {
        boolean bool = f.d(str);
        if (f.e(str))
        {
          locala.a("GET", null);
        }
        else
        {
          paramae = localProxy;
          if (bool) {
            paramae = paramac.a().d();
          }
          locala.a(str, paramae);
        }
        if (!bool)
        {
          locala.b("Transfer-Encoding");
          locala.b("Content-Length");
          locala.b("Content-Type");
        }
      }
      if (!a(paramac, localt)) {
        locala.b("Authorization");
      }
      return locala.a(localt).a();
    }
    throw new IllegalStateException();
  }
  
  private boolean a(ac paramac, t paramt)
  {
    paramac = paramac.a().a();
    return (paramac.f().equals(paramt.f())) && (paramac.g() == paramt.g()) && (paramac.b().equals(paramt.b()));
  }
  
  private boolean a(IOException paramIOException, e.a.b.g paramg, boolean paramBoolean, aa paramaa)
  {
    paramg.a(paramIOException);
    if (!this.a.t()) {
      return false;
    }
    if ((paramBoolean) && ((paramaa.d() instanceof l))) {
      return false;
    }
    if (!a(paramIOException, paramBoolean)) {
      return false;
    }
    return paramg.g();
  }
  
  private boolean a(IOException paramIOException, boolean paramBoolean)
  {
    boolean bool1 = paramIOException instanceof ProtocolException;
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    if ((paramIOException instanceof InterruptedIOException))
    {
      bool1 = bool2;
      if ((paramIOException instanceof SocketTimeoutException))
      {
        bool1 = bool2;
        if (!paramBoolean) {
          bool1 = true;
        }
      }
      return bool1;
    }
    if (((paramIOException instanceof SSLHandshakeException)) && ((paramIOException.getCause() instanceof CertificateException))) {
      return false;
    }
    return !(paramIOException instanceof SSLPeerUnverifiedException);
  }
  
  /* Error */
  public ac a(e.u.a parama)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 258 1 0
    //   6: astore 6
    //   8: aload_1
    //   9: checkcast 260	e/a/c/g
    //   12: astore 7
    //   14: aload 7
    //   16: invokevirtual 264	e/a/c/g:h	()Le/e;
    //   19: astore 8
    //   21: aload 7
    //   23: invokevirtual 267	e/a/c/g:i	()Le/p;
    //   26: astore 9
    //   28: new 230	e/a/b/g
    //   31: dup
    //   32: aload_0
    //   33: getfield 22	e/a/c/j:a	Le/x;
    //   36: invokevirtual 271	e/x:q	()Le/j;
    //   39: aload_0
    //   40: aload 6
    //   42: invokevirtual 182	e/aa:a	()Le/t;
    //   45: invokespecial 273	e/a/c/j:a	(Le/t;)Le/a;
    //   48: aload 8
    //   50: aload 9
    //   52: aload_0
    //   53: getfield 275	e/a/c/j:d	Ljava/lang/Object;
    //   56: invokespecial 278	e/a/b/g:<init>	(Le/j;Le/a;Le/e;Le/p;Ljava/lang/Object;)V
    //   59: astore 4
    //   61: aload_0
    //   62: aload 4
    //   64: putfield 280	e/a/c/j:c	Le/a/b/g;
    //   67: aconst_null
    //   68: astore 5
    //   70: iconst_0
    //   71: istore_2
    //   72: aload 6
    //   74: astore_1
    //   75: aload_0
    //   76: getfield 282	e/a/c/j:e	Z
    //   79: ifne +371 -> 450
    //   82: aload 7
    //   84: aload_1
    //   85: aload 4
    //   87: aconst_null
    //   88: aconst_null
    //   89: invokevirtual 285	e/a/c/g:a	(Le/aa;Le/a/b/g;Le/a/c/c;Le/a/b/c;)Le/ac;
    //   92: astore 6
    //   94: aload 5
    //   96: ifnull +30 -> 126
    //   99: aload 6
    //   101: invokevirtual 288	e/ac:h	()Le/ac$a;
    //   104: aload 5
    //   106: invokevirtual 288	e/ac:h	()Le/ac$a;
    //   109: aconst_null
    //   110: invokevirtual 293	e/ac$a:a	(Le/ad;)Le/ac$a;
    //   113: invokevirtual 295	e/ac$a:a	()Le/ac;
    //   116: invokevirtual 298	e/ac$a:c	(Le/ac;)Le/ac$a;
    //   119: invokevirtual 295	e/ac$a:a	()Le/ac;
    //   122: astore_1
    //   123: goto +6 -> 129
    //   126: aload 6
    //   128: astore_1
    //   129: aload_0
    //   130: aload_1
    //   131: aload 4
    //   133: invokevirtual 301	e/a/b/g:b	()Le/ae;
    //   136: invokespecial 303	e/a/c/j:a	(Le/ac;Le/ae;)Le/aa;
    //   139: astore 6
    //   141: aload 6
    //   143: ifnonnull +10 -> 153
    //   146: aload 4
    //   148: invokevirtual 305	e/a/b/g:d	()V
    //   151: aload_1
    //   152: areturn
    //   153: aload_1
    //   154: invokevirtual 308	e/ac:g	()Le/ad;
    //   157: invokestatic 313	e/a/c:a	(Ljava/io/Closeable;)V
    //   160: iload_2
    //   161: iconst_1
    //   162: iadd
    //   163: istore_2
    //   164: iload_2
    //   165: bipush 20
    //   167: if_icmpgt +158 -> 325
    //   170: aload 6
    //   172: invokevirtual 133	e/aa:d	()Le/ab;
    //   175: instanceof 135
    //   178: ifne +127 -> 305
    //   181: aload_0
    //   182: aload_1
    //   183: aload 6
    //   185: invokevirtual 182	e/aa:a	()Le/t;
    //   188: invokespecial 217	e/a/c/j:a	(Le/ac;Le/t;)Z
    //   191: ifne +50 -> 241
    //   194: aload 4
    //   196: invokevirtual 305	e/a/b/g:d	()V
    //   199: new 230	e/a/b/g
    //   202: dup
    //   203: aload_0
    //   204: getfield 22	e/a/c/j:a	Le/x;
    //   207: invokevirtual 271	e/x:q	()Le/j;
    //   210: aload_0
    //   211: aload 6
    //   213: invokevirtual 182	e/aa:a	()Le/t;
    //   216: invokespecial 273	e/a/c/j:a	(Le/t;)Le/a;
    //   219: aload 8
    //   221: aload 9
    //   223: aload_0
    //   224: getfield 275	e/a/c/j:d	Ljava/lang/Object;
    //   227: invokespecial 278	e/a/b/g:<init>	(Le/j;Le/a;Le/e;Le/p;Ljava/lang/Object;)V
    //   230: astore 4
    //   232: aload_0
    //   233: aload 4
    //   235: putfield 280	e/a/c/j:c	Le/a/b/g;
    //   238: goto +11 -> 249
    //   241: aload 4
    //   243: invokevirtual 316	e/a/b/g:a	()Le/a/c/c;
    //   246: ifnonnull +12 -> 258
    //   249: aload_1
    //   250: astore 5
    //   252: aload 6
    //   254: astore_1
    //   255: goto -180 -> 75
    //   258: new 318	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 319	java/lang/StringBuilder:<init>	()V
    //   265: astore 4
    //   267: aload 4
    //   269: ldc_w 321
    //   272: invokevirtual 325	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload 4
    //   278: aload_1
    //   279: invokevirtual 328	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload 4
    //   285: ldc_w 330
    //   288: invokevirtual 325	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: new 225	java/lang/IllegalStateException
    //   295: dup
    //   296: aload 4
    //   298: invokevirtual 333	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokespecial 334	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   304: athrow
    //   305: aload 4
    //   307: invokevirtual 305	e/a/b/g:d	()V
    //   310: new 336	java/net/HttpRetryException
    //   313: dup
    //   314: ldc_w 338
    //   317: aload_1
    //   318: invokevirtual 114	e/ac:b	()I
    //   321: invokespecial 341	java/net/HttpRetryException:<init>	(Ljava/lang/String;I)V
    //   324: athrow
    //   325: aload 4
    //   327: invokevirtual 305	e/a/b/g:d	()V
    //   330: new 318	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 319	java/lang/StringBuilder:<init>	()V
    //   337: astore_1
    //   338: aload_1
    //   339: ldc_w 343
    //   342: invokevirtual 325	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload_1
    //   347: iload_2
    //   348: invokevirtual 346	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: new 158	java/net/ProtocolException
    //   355: dup
    //   356: aload_1
    //   357: invokevirtual 333	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokespecial 163	java/net/ProtocolException:<init>	(Ljava/lang/String;)V
    //   363: athrow
    //   364: astore_1
    //   365: aload 4
    //   367: invokevirtual 305	e/a/b/g:d	()V
    //   370: aload_1
    //   371: athrow
    //   372: astore_1
    //   373: goto +64 -> 437
    //   376: astore 6
    //   378: aload 6
    //   380: instanceof 348
    //   383: ifne +83 -> 466
    //   386: iconst_1
    //   387: istore_3
    //   388: goto +3 -> 391
    //   391: aload_0
    //   392: aload 6
    //   394: aload 4
    //   396: iload_3
    //   397: aload_1
    //   398: invokespecial 350	e/a/c/j:a	(Ljava/io/IOException;Le/a/b/g;ZLe/aa;)Z
    //   401: ifeq +6 -> 407
    //   404: goto -329 -> 75
    //   407: aload 6
    //   409: athrow
    //   410: astore 6
    //   412: aload_0
    //   413: aload 6
    //   415: invokevirtual 354	e/a/b/e:getLastConnectException	()Ljava/io/IOException;
    //   418: aload 4
    //   420: iconst_0
    //   421: aload_1
    //   422: invokespecial 350	e/a/c/j:a	(Ljava/io/IOException;Le/a/b/g;ZLe/aa;)Z
    //   425: ifeq +6 -> 431
    //   428: goto -353 -> 75
    //   431: aload 6
    //   433: invokevirtual 357	e/a/b/e:getFirstConnectException	()Ljava/io/IOException;
    //   436: athrow
    //   437: aload 4
    //   439: aconst_null
    //   440: invokevirtual 233	e/a/b/g:a	(Ljava/io/IOException;)V
    //   443: aload 4
    //   445: invokevirtual 305	e/a/b/g:d	()V
    //   448: aload_1
    //   449: athrow
    //   450: aload 4
    //   452: invokevirtual 305	e/a/b/g:d	()V
    //   455: new 112	java/io/IOException
    //   458: dup
    //   459: ldc_w 359
    //   462: invokespecial 360	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   465: athrow
    //   466: iconst_0
    //   467: istore_3
    //   468: goto -77 -> 391
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	471	0	this	j
    //   0	471	1	parama	e.u.a
    //   71	277	2	i	int
    //   387	81	3	bool	boolean
    //   59	392	4	localObject1	Object
    //   68	183	5	locala	e.u.a
    //   6	247	6	localObject2	Object
    //   376	32	6	localIOException	IOException
    //   410	22	6	locale	e.a.b.e
    //   12	71	7	localg	g
    //   19	201	8	locale1	e.e
    //   26	196	9	localp	e.p
    // Exception table:
    //   from	to	target	type
    //   129	141	364	java/io/IOException
    //   82	94	372	finally
    //   378	386	372	finally
    //   391	404	372	finally
    //   407	410	372	finally
    //   412	428	372	finally
    //   431	437	372	finally
    //   82	94	376	java/io/IOException
    //   82	94	410	e/a/b/e
  }
  
  public void a()
  {
    this.e = true;
    e.a.b.g localg = this.c;
    if (localg != null) {
      localg.f();
    }
  }
  
  public void a(Object paramObject)
  {
    this.d = paramObject;
  }
  
  public boolean b()
  {
    return this.e;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\c\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */