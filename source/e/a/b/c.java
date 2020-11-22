package e.a.b;

import e.a.e.f;
import e.a.e.g.a;
import e.a.e.g.b;
import e.aa;
import e.aa.a;
import e.ac;
import e.ac.a;
import e.ae;
import e.j;
import e.p;
import e.r;
import e.u.a;
import e.x;
import e.y;
import f.s;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class c
  extends g.b
  implements e.i
{
  public boolean a;
  public int b;
  public int c = 1;
  public final List<Reference<g>> d = new ArrayList();
  public long e = Long.MAX_VALUE;
  private final j g;
  private final ae h;
  private Socket i;
  private Socket j;
  private r k;
  private y l;
  private e.a.e.g m;
  private f.e n;
  private f.d o;
  
  public c(j paramj, ae paramae)
  {
    this.g = paramj;
    this.h = paramae;
  }
  
  private aa a(int paramInt1, int paramInt2, aa paramaa, e.t paramt)
    throws IOException
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("CONNECT ");
    ((StringBuilder)localObject).append(e.a.c.a(paramt, true));
    ((StringBuilder)localObject).append(" HTTP/1.1");
    paramt = ((StringBuilder)localObject).toString();
    for (;;)
    {
      e.a.d.a locala = new e.a.d.a(null, null, this.n, this.o);
      this.n.timeout().a(paramInt1, TimeUnit.MILLISECONDS);
      this.o.timeout().a(paramInt2, TimeUnit.MILLISECONDS);
      locala.a(paramaa.c(), paramt);
      locala.b();
      localObject = locala.a(false).a(paramaa).a();
      long l2 = e.a.c.e.a((ac)localObject);
      long l1 = l2;
      if (l2 == -1L) {
        l1 = 0L;
      }
      paramaa = locala.b(l1);
      e.a.c.b(paramaa, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
      paramaa.close();
      int i1 = ((ac)localObject).b();
      if (i1 == 200) {
        break label293;
      }
      if (i1 != 407) {
        break label256;
      }
      paramaa = this.h.a().d().a(this.h, (ac)localObject);
      if (paramaa == null) {
        break;
      }
      if ("close".equalsIgnoreCase(((ac)localObject).a("Connection"))) {
        return paramaa;
      }
    }
    throw new IOException("Failed to authenticate with proxy");
    label256:
    paramaa = new StringBuilder();
    paramaa.append("Unexpected response code for CONNECT: ");
    paramaa.append(((ac)localObject).b());
    throw new IOException(paramaa.toString());
    label293:
    if ((this.n.b().e()) && (this.o.b().e())) {
      return null;
    }
    throw new IOException("TLS tunnel buffered too many bytes!");
  }
  
  private void a(int paramInt)
    throws IOException
  {
    this.j.setSoTimeout(0);
    this.m = new g.a(true).a(this.j, this.h.a().a().f(), this.n, this.o).a(this).a(paramInt).a();
    this.m.c();
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, e.e parame, p paramp)
    throws IOException
  {
    aa localaa = g();
    e.t localt = localaa.a();
    int i1 = 0;
    while (i1 < 21)
    {
      a(paramInt1, paramInt2, parame, paramp);
      localaa = a(paramInt2, paramInt3, localaa, localt);
      if (localaa == null) {
        return;
      }
      e.a.c.a(this.i);
      this.i = null;
      this.o = null;
      this.n = null;
      paramp.a(parame, this.h.c(), this.h.b(), null);
      i1 += 1;
    }
  }
  
  /* Error */
  private void a(int paramInt1, int paramInt2, e.e parame, p paramp)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	e/a/b/c:h	Le/ae;
    //   4: invokevirtual 260	e/ae:b	()Ljava/net/Proxy;
    //   7: astore 6
    //   9: aload_0
    //   10: getfield 53	e/a/b/c:h	Le/ae;
    //   13: invokevirtual 156	e/ae:a	()Le/a;
    //   16: astore 5
    //   18: aload 6
    //   20: invokevirtual 275	java/net/Proxy:type	()Ljava/net/Proxy$Type;
    //   23: getstatic 281	java/net/Proxy$Type:DIRECT	Ljava/net/Proxy$Type;
    //   26: if_acmpeq +31 -> 57
    //   29: aload 6
    //   31: invokevirtual 275	java/net/Proxy:type	()Ljava/net/Proxy$Type;
    //   34: getstatic 284	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   37: if_acmpne +6 -> 43
    //   40: goto +17 -> 57
    //   43: new 205	java/net/Socket
    //   46: dup
    //   47: aload 6
    //   49: invokespecial 287	java/net/Socket:<init>	(Ljava/net/Proxy;)V
    //   52: astore 5
    //   54: goto +13 -> 67
    //   57: aload 5
    //   59: invokevirtual 290	e/a:c	()Ljavax/net/SocketFactory;
    //   62: invokevirtual 296	javax/net/SocketFactory:createSocket	()Ljava/net/Socket;
    //   65: astore 5
    //   67: aload_0
    //   68: aload 5
    //   70: putfield 251	e/a/b/c:i	Ljava/net/Socket;
    //   73: aload 4
    //   75: aload_3
    //   76: aload_0
    //   77: getfield 53	e/a/b/c:h	Le/ae;
    //   80: invokevirtual 257	e/ae:c	()Ljava/net/InetSocketAddress;
    //   83: aload 6
    //   85: invokevirtual 299	e/p:a	(Le/e;Ljava/net/InetSocketAddress;Ljava/net/Proxy;)V
    //   88: aload_0
    //   89: getfield 251	e/a/b/c:i	Ljava/net/Socket;
    //   92: iload_2
    //   93: invokevirtual 208	java/net/Socket:setSoTimeout	(I)V
    //   96: invokestatic 304	e/a/g/f:c	()Le/a/g/f;
    //   99: aload_0
    //   100: getfield 251	e/a/b/c:i	Ljava/net/Socket;
    //   103: aload_0
    //   104: getfield 53	e/a/b/c:h	Le/ae;
    //   107: invokevirtual 257	e/ae:c	()Ljava/net/InetSocketAddress;
    //   110: iload_1
    //   111: invokevirtual 307	e/a/g/f:a	(Ljava/net/Socket;Ljava/net/InetSocketAddress;I)V
    //   114: aload_0
    //   115: aload_0
    //   116: getfield 251	e/a/b/c:i	Ljava/net/Socket;
    //   119: invokestatic 312	f/l:b	(Ljava/net/Socket;)Lf/s;
    //   122: invokestatic 315	f/l:a	(Lf/s;)Lf/e;
    //   125: putfield 81	e/a/b/c:n	Lf/e;
    //   128: aload_0
    //   129: aload_0
    //   130: getfield 251	e/a/b/c:i	Ljava/net/Socket;
    //   133: invokestatic 318	f/l:a	(Ljava/net/Socket;)Lf/r;
    //   136: invokestatic 321	f/l:a	(Lf/r;)Lf/d;
    //   139: putfield 83	e/a/b/c:o	Lf/d;
    //   142: return
    //   143: astore_3
    //   144: ldc_w 323
    //   147: aload_3
    //   148: invokevirtual 326	java/lang/NullPointerException:getMessage	()Ljava/lang/String;
    //   151: invokevirtual 330	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   154: ifne +4 -> 158
    //   157: return
    //   158: new 57	java/io/IOException
    //   161: dup
    //   162: aload_3
    //   163: invokespecial 333	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   166: athrow
    //   167: astore_3
    //   168: new 59	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   175: astore 4
    //   177: aload 4
    //   179: ldc_w 335
    //   182: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload 4
    //   188: aload_0
    //   189: getfield 53	e/a/b/c:h	Le/ae;
    //   192: invokevirtual 257	e/ae:c	()Ljava/net/InetSocketAddress;
    //   195: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: new 267	java/net/ConnectException
    //   202: dup
    //   203: aload 4
    //   205: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokespecial 339	java/net/ConnectException:<init>	(Ljava/lang/String;)V
    //   211: astore 4
    //   213: aload 4
    //   215: aload_3
    //   216: invokevirtual 343	java/net/ConnectException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   219: pop
    //   220: aload 4
    //   222: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	c
    //   0	223	1	paramInt1	int
    //   0	223	2	paramInt2	int
    //   0	223	3	parame	e.e
    //   0	223	4	paramp	p
    //   16	53	5	localObject	Object
    //   7	77	6	localProxy	Proxy
    // Exception table:
    //   from	to	target	type
    //   114	142	143	java/lang/NullPointerException
    //   96	114	167	java/net/ConnectException
  }
  
  /* Error */
  private void a(b paramb)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	e/a/b/c:h	Le/ae;
    //   4: invokevirtual 156	e/ae:a	()Le/a;
    //   7: astore 6
    //   9: aload 6
    //   11: invokevirtual 349	e/a:i	()Ljavax/net/ssl/SSLSocketFactory;
    //   14: astore_3
    //   15: aconst_null
    //   16: astore_2
    //   17: aconst_null
    //   18: astore 5
    //   20: aconst_null
    //   21: astore 4
    //   23: aload_3
    //   24: aload_0
    //   25: getfield 251	e/a/b/c:i	Ljava/net/Socket;
    //   28: aload 6
    //   30: invokevirtual 216	e/a:a	()Le/t;
    //   33: invokevirtual 221	e/t:f	()Ljava/lang/String;
    //   36: aload 6
    //   38: invokevirtual 216	e/a:a	()Le/t;
    //   41: invokevirtual 351	e/t:g	()I
    //   44: iconst_1
    //   45: invokevirtual 356	javax/net/ssl/SSLSocketFactory:createSocket	(Ljava/net/Socket;Ljava/lang/String;IZ)Ljava/net/Socket;
    //   48: checkcast 358	javax/net/ssl/SSLSocket
    //   51: astore_3
    //   52: aload_1
    //   53: aload_3
    //   54: invokevirtual 363	e/a/b/b:a	(Ljavax/net/ssl/SSLSocket;)Le/k;
    //   57: astore 5
    //   59: aload 5
    //   61: invokevirtual 367	e/k:d	()Z
    //   64: ifeq +23 -> 87
    //   67: invokestatic 304	e/a/g/f:c	()Le/a/g/f;
    //   70: aload_3
    //   71: aload 6
    //   73: invokevirtual 216	e/a:a	()Le/t;
    //   76: invokevirtual 221	e/t:f	()Ljava/lang/String;
    //   79: aload 6
    //   81: invokevirtual 370	e/a:e	()Ljava/util/List;
    //   84: invokevirtual 373	e/a/g/f:a	(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V
    //   87: aload_3
    //   88: invokevirtual 376	javax/net/ssl/SSLSocket:startHandshake	()V
    //   91: aload_3
    //   92: invokevirtual 380	javax/net/ssl/SSLSocket:getSession	()Ljavax/net/ssl/SSLSession;
    //   95: astore_1
    //   96: aload_1
    //   97: invokestatic 385	e/r:a	(Ljavax/net/ssl/SSLSession;)Le/r;
    //   100: astore_2
    //   101: aload 6
    //   103: invokevirtual 388	e/a:j	()Ljavax/net/ssl/HostnameVerifier;
    //   106: aload 6
    //   108: invokevirtual 216	e/a:a	()Le/t;
    //   111: invokevirtual 221	e/t:f	()Ljava/lang/String;
    //   114: aload_1
    //   115: invokeinterface 394 3 0
    //   120: ifeq +113 -> 233
    //   123: aload 6
    //   125: invokevirtual 397	e/a:k	()Le/g;
    //   128: aload 6
    //   130: invokevirtual 216	e/a:a	()Le/t;
    //   133: invokevirtual 221	e/t:f	()Ljava/lang/String;
    //   136: aload_2
    //   137: invokevirtual 399	e/r:b	()Ljava/util/List;
    //   140: invokevirtual 404	e/g:a	(Ljava/lang/String;Ljava/util/List;)V
    //   143: aload 4
    //   145: astore_1
    //   146: aload 5
    //   148: invokevirtual 367	e/k:d	()Z
    //   151: ifeq +11 -> 162
    //   154: invokestatic 304	e/a/g/f:c	()Le/a/g/f;
    //   157: aload_3
    //   158: invokevirtual 407	e/a/g/f:a	(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;
    //   161: astore_1
    //   162: aload_0
    //   163: aload_3
    //   164: putfield 203	e/a/b/c:j	Ljava/net/Socket;
    //   167: aload_0
    //   168: aload_0
    //   169: getfield 203	e/a/b/c:j	Ljava/net/Socket;
    //   172: invokestatic 312	f/l:b	(Ljava/net/Socket;)Lf/s;
    //   175: invokestatic 315	f/l:a	(Lf/s;)Lf/e;
    //   178: putfield 81	e/a/b/c:n	Lf/e;
    //   181: aload_0
    //   182: aload_0
    //   183: getfield 203	e/a/b/c:j	Ljava/net/Socket;
    //   186: invokestatic 318	f/l:a	(Ljava/net/Socket;)Lf/r;
    //   189: invokestatic 321	f/l:a	(Lf/r;)Lf/d;
    //   192: putfield 83	e/a/b/c:o	Lf/d;
    //   195: aload_0
    //   196: aload_2
    //   197: putfield 409	e/a/b/c:k	Le/r;
    //   200: aload_1
    //   201: ifnull +11 -> 212
    //   204: aload_1
    //   205: invokestatic 415	e/y:get	(Ljava/lang/String;)Le/y;
    //   208: astore_1
    //   209: goto +7 -> 216
    //   212: getstatic 418	e/y:HTTP_1_1	Le/y;
    //   215: astore_1
    //   216: aload_0
    //   217: aload_1
    //   218: putfield 420	e/a/b/c:l	Le/y;
    //   221: aload_3
    //   222: ifnull +10 -> 232
    //   225: invokestatic 304	e/a/g/f:c	()Le/a/g/f;
    //   228: aload_3
    //   229: invokevirtual 423	e/a/g/f:b	(Ljavax/net/ssl/SSLSocket;)V
    //   232: return
    //   233: aload_2
    //   234: invokevirtual 399	e/r:b	()Ljava/util/List;
    //   237: iconst_0
    //   238: invokeinterface 428 2 0
    //   243: checkcast 430	java/security/cert/X509Certificate
    //   246: astore_1
    //   247: new 59	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   254: astore_2
    //   255: aload_2
    //   256: ldc_w 432
    //   259: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload_2
    //   264: aload 6
    //   266: invokevirtual 216	e/a:a	()Le/t;
    //   269: invokevirtual 221	e/t:f	()Ljava/lang/String;
    //   272: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload_2
    //   277: ldc_w 434
    //   280: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload_2
    //   285: aload_1
    //   286: invokestatic 437	e/g:a	(Ljava/security/cert/Certificate;)Ljava/lang/String;
    //   289: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload_2
    //   294: ldc_w 439
    //   297: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload_2
    //   302: aload_1
    //   303: invokevirtual 443	java/security/cert/X509Certificate:getSubjectDN	()Ljava/security/Principal;
    //   306: invokeinterface 448 1 0
    //   311: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload_2
    //   316: ldc_w 450
    //   319: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload_2
    //   324: aload_1
    //   325: invokestatic 455	e/a/j/d:a	(Ljava/security/cert/X509Certificate;)Ljava/util/List;
    //   328: invokevirtual 338	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: new 457	javax/net/ssl/SSLPeerUnverifiedException
    //   335: dup
    //   336: aload_2
    //   337: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokespecial 458	javax/net/ssl/SSLPeerUnverifiedException:<init>	(Ljava/lang/String;)V
    //   343: athrow
    //   344: astore_1
    //   345: goto +45 -> 390
    //   348: astore_2
    //   349: aload_3
    //   350: astore_1
    //   351: aload_2
    //   352: astore_3
    //   353: goto +13 -> 366
    //   356: astore_1
    //   357: aload_2
    //   358: astore_3
    //   359: goto +31 -> 390
    //   362: astore_3
    //   363: aload 5
    //   365: astore_1
    //   366: aload_1
    //   367: astore_2
    //   368: aload_3
    //   369: invokestatic 461	e/a/c:a	(Ljava/lang/AssertionError;)Z
    //   372: ifeq +14 -> 386
    //   375: aload_1
    //   376: astore_2
    //   377: new 57	java/io/IOException
    //   380: dup
    //   381: aload_3
    //   382: invokespecial 333	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   385: athrow
    //   386: aload_1
    //   387: astore_2
    //   388: aload_3
    //   389: athrow
    //   390: aload_3
    //   391: ifnull +10 -> 401
    //   394: invokestatic 304	e/a/g/f:c	()Le/a/g/f;
    //   397: aload_3
    //   398: invokevirtual 423	e/a/g/f:b	(Ljavax/net/ssl/SSLSocket;)V
    //   401: aload_3
    //   402: invokestatic 254	e/a/c:a	(Ljava/net/Socket;)V
    //   405: aload_1
    //   406: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	407	0	this	c
    //   0	407	1	paramb	b
    //   16	321	2	localObject1	Object
    //   348	10	2	localAssertionError1	AssertionError
    //   367	21	2	localb	b
    //   14	345	3	localObject2	Object
    //   362	40	3	localAssertionError2	AssertionError
    //   21	123	4	localObject3	Object
    //   18	346	5	localk	e.k
    //   7	258	6	locala	e.a
    // Exception table:
    //   from	to	target	type
    //   52	87	344	finally
    //   87	143	344	finally
    //   146	162	344	finally
    //   162	200	344	finally
    //   204	209	344	finally
    //   212	216	344	finally
    //   216	221	344	finally
    //   233	344	344	finally
    //   52	87	348	java/lang/AssertionError
    //   87	143	348	java/lang/AssertionError
    //   146	162	348	java/lang/AssertionError
    //   162	200	348	java/lang/AssertionError
    //   204	209	348	java/lang/AssertionError
    //   212	216	348	java/lang/AssertionError
    //   216	221	348	java/lang/AssertionError
    //   233	344	348	java/lang/AssertionError
    //   23	52	356	finally
    //   368	375	356	finally
    //   377	386	356	finally
    //   388	390	356	finally
    //   23	52	362	java/lang/AssertionError
  }
  
  private void a(b paramb, int paramInt, e.e parame, p paramp)
    throws IOException
  {
    if (this.h.a().i() == null)
    {
      if (this.h.a().e().contains(y.H2_PRIOR_KNOWLEDGE))
      {
        this.j = this.i;
        this.l = y.H2_PRIOR_KNOWLEDGE;
        a(paramInt);
        return;
      }
      this.j = this.i;
      this.l = y.HTTP_1_1;
      return;
    }
    paramp.b(parame);
    a(paramb);
    paramp.a(parame, this.k);
    if (this.l == y.HTTP_2) {
      a(paramInt);
    }
  }
  
  private aa g()
    throws IOException
  {
    Object localObject1 = new aa.a().a(this.h.a().a()).a("CONNECT", null).a("Host", e.a.c.a(this.h.a().a(), true)).a("Proxy-Connection", "Keep-Alive").a("User-Agent", e.a.d.a()).a();
    Object localObject2 = new ac.a().a((aa)localObject1).a(y.HTTP_1_1).a(407).a("Preemptive Authenticate").a(e.a.c.c).a(-1L).b(-1L).a("Proxy-Authenticate", "OkHttp-Preemptive").a();
    localObject2 = this.h.a().d().a(this.h, (ac)localObject2);
    if (localObject2 != null) {
      localObject1 = localObject2;
    }
    return (aa)localObject1;
  }
  
  public e.a.c.c a(x paramx, u.a parama, g paramg)
    throws SocketException
  {
    if (this.m != null) {
      return new f(paramx, parama, paramg, this.m);
    }
    this.j.setSoTimeout(parama.d());
    this.n.timeout().a(parama.d(), TimeUnit.MILLISECONDS);
    this.o.timeout().a(parama.e(), TimeUnit.MILLISECONDS);
    return new e.a.d.a(paramx, paramg, this.n, this.o);
  }
  
  public y a()
  {
    return this.l;
  }
  
  /* Error */
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, e.e arg6, p paramp)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 420	e/a/b/c:l	Le/y;
    //   4: ifnonnull +491 -> 495
    //   7: aload_0
    //   8: getfield 53	e/a/b/c:h	Le/ae;
    //   11: invokevirtual 156	e/ae:a	()Le/a;
    //   14: invokevirtual 557	e/a:f	()Ljava/util/List;
    //   17: astore 8
    //   19: new 360	e/a/b/b
    //   22: dup
    //   23: aload 8
    //   25: invokespecial 560	e/a/b/b:<init>	(Ljava/util/List;)V
    //   28: astore 10
    //   30: aload_0
    //   31: getfield 53	e/a/b/c:h	Le/ae;
    //   34: invokevirtual 156	e/ae:a	()Le/a;
    //   37: invokevirtual 349	e/a:i	()Ljavax/net/ssl/SSLSocketFactory;
    //   40: ifnonnull +118 -> 158
    //   43: aload 8
    //   45: getstatic 563	e/k:d	Le/k;
    //   48: invokeinterface 468 2 0
    //   53: ifeq +87 -> 140
    //   56: aload_0
    //   57: getfield 53	e/a/b/c:h	Le/ae;
    //   60: invokevirtual 156	e/ae:a	()Le/a;
    //   63: invokevirtual 216	e/a:a	()Le/t;
    //   66: invokevirtual 221	e/t:f	()Ljava/lang/String;
    //   69: astore 8
    //   71: invokestatic 304	e/a/g/f:c	()Le/a/g/f;
    //   74: aload 8
    //   76: invokevirtual 565	e/a/g/f:b	(Ljava/lang/String;)Z
    //   79: ifeq +6 -> 85
    //   82: goto +97 -> 179
    //   85: new 59	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   92: astore 6
    //   94: aload 6
    //   96: ldc_w 567
    //   99: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 6
    //   105: aload 8
    //   107: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 6
    //   113: ldc_w 569
    //   116: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: new 571	e/a/b/e
    //   123: dup
    //   124: new 573	java/net/UnknownServiceException
    //   127: dup
    //   128: aload 6
    //   130: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokespecial 574	java/net/UnknownServiceException:<init>	(Ljava/lang/String;)V
    //   136: invokespecial 577	e/a/b/e:<init>	(Ljava/io/IOException;)V
    //   139: athrow
    //   140: new 571	e/a/b/e
    //   143: dup
    //   144: new 573	java/net/UnknownServiceException
    //   147: dup
    //   148: ldc_w 579
    //   151: invokespecial 574	java/net/UnknownServiceException:<init>	(Ljava/lang/String;)V
    //   154: invokespecial 577	e/a/b/e:<init>	(Ljava/io/IOException;)V
    //   157: athrow
    //   158: aload_0
    //   159: getfield 53	e/a/b/c:h	Le/ae;
    //   162: invokevirtual 156	e/ae:a	()Le/a;
    //   165: invokevirtual 370	e/a:e	()Ljava/util/List;
    //   168: getstatic 465	e/y:H2_PRIOR_KNOWLEDGE	Le/y;
    //   171: invokeinterface 468 2 0
    //   176: ifne +301 -> 477
    //   179: aconst_null
    //   180: astore 9
    //   182: aload_0
    //   183: getfield 53	e/a/b/c:h	Le/ae;
    //   186: invokevirtual 580	e/ae:d	()Z
    //   189: ifeq +31 -> 220
    //   192: aload_0
    //   193: iload_1
    //   194: iload_2
    //   195: iload_3
    //   196: aload 6
    //   198: aload 7
    //   200: invokespecial 582	e/a/b/c:a	(IIILe/e;Le/p;)V
    //   203: aload_0
    //   204: getfield 251	e/a/b/c:i	Ljava/net/Socket;
    //   207: astore 8
    //   209: aload 8
    //   211: ifnonnull +6 -> 217
    //   214: goto +53 -> 267
    //   217: goto +13 -> 230
    //   220: aload_0
    //   221: iload_1
    //   222: iload_2
    //   223: aload 6
    //   225: aload 7
    //   227: invokespecial 247	e/a/b/c:a	(IILe/e;Le/p;)V
    //   230: aload_0
    //   231: aload 10
    //   233: iload 4
    //   235: aload 6
    //   237: aload 7
    //   239: invokespecial 584	e/a/b/c:a	(Le/a/b/b;ILe/e;Le/p;)V
    //   242: aload 7
    //   244: aload 6
    //   246: aload_0
    //   247: getfield 53	e/a/b/c:h	Le/ae;
    //   250: invokevirtual 257	e/ae:c	()Ljava/net/InetSocketAddress;
    //   253: aload_0
    //   254: getfield 53	e/a/b/c:h	Le/ae;
    //   257: invokevirtual 260	e/ae:b	()Ljava/net/Proxy;
    //   260: aload_0
    //   261: getfield 420	e/a/b/c:l	Le/y;
    //   264: invokevirtual 265	e/p:a	(Le/e;Ljava/net/InetSocketAddress;Ljava/net/Proxy;Le/y;)V
    //   267: aload_0
    //   268: getfield 53	e/a/b/c:h	Le/ae;
    //   271: invokevirtual 580	e/ae:d	()Z
    //   274: ifeq +31 -> 305
    //   277: aload_0
    //   278: getfield 251	e/a/b/c:i	Ljava/net/Socket;
    //   281: ifnull +6 -> 287
    //   284: goto +21 -> 305
    //   287: new 571	e/a/b/e
    //   290: dup
    //   291: new 586	java/net/ProtocolException
    //   294: dup
    //   295: ldc_w 588
    //   298: invokespecial 589	java/net/ProtocolException:<init>	(Ljava/lang/String;)V
    //   301: invokespecial 577	e/a/b/e:<init>	(Ljava/io/IOException;)V
    //   304: athrow
    //   305: aload_0
    //   306: getfield 235	e/a/b/c:m	Le/a/e/g;
    //   309: ifnull +35 -> 344
    //   312: aload_0
    //   313: getfield 51	e/a/b/c:g	Le/j;
    //   316: astore 6
    //   318: aload 6
    //   320: monitorenter
    //   321: aload_0
    //   322: aload_0
    //   323: getfield 235	e/a/b/c:m	Le/a/e/g;
    //   326: invokevirtual 591	e/a/e/g:a	()I
    //   329: putfield 40	e/a/b/c:c	I
    //   332: aload 6
    //   334: monitorexit
    //   335: return
    //   336: astore 7
    //   338: aload 6
    //   340: monitorexit
    //   341: aload 7
    //   343: athrow
    //   344: return
    //   345: astore 8
    //   347: goto +10 -> 357
    //   350: astore 8
    //   352: goto +5 -> 357
    //   355: astore 8
    //   357: aload_0
    //   358: getfield 203	e/a/b/c:j	Ljava/net/Socket;
    //   361: invokestatic 254	e/a/c:a	(Ljava/net/Socket;)V
    //   364: aload_0
    //   365: getfield 251	e/a/b/c:i	Ljava/net/Socket;
    //   368: invokestatic 254	e/a/c:a	(Ljava/net/Socket;)V
    //   371: aload_0
    //   372: aconst_null
    //   373: putfield 203	e/a/b/c:j	Ljava/net/Socket;
    //   376: aload_0
    //   377: aconst_null
    //   378: putfield 251	e/a/b/c:i	Ljava/net/Socket;
    //   381: aload_0
    //   382: aconst_null
    //   383: putfield 81	e/a/b/c:n	Lf/e;
    //   386: aload_0
    //   387: aconst_null
    //   388: putfield 83	e/a/b/c:o	Lf/d;
    //   391: aload_0
    //   392: aconst_null
    //   393: putfield 409	e/a/b/c:k	Le/r;
    //   396: aload_0
    //   397: aconst_null
    //   398: putfield 420	e/a/b/c:l	Le/y;
    //   401: aload_0
    //   402: aconst_null
    //   403: putfield 235	e/a/b/c:m	Le/a/e/g;
    //   406: aload 7
    //   408: aload 6
    //   410: aload_0
    //   411: getfield 53	e/a/b/c:h	Le/ae;
    //   414: invokevirtual 257	e/ae:c	()Ljava/net/InetSocketAddress;
    //   417: aload_0
    //   418: getfield 53	e/a/b/c:h	Le/ae;
    //   421: invokevirtual 260	e/ae:b	()Ljava/net/Proxy;
    //   424: aconst_null
    //   425: aload 8
    //   427: invokevirtual 594	e/p:a	(Le/e;Ljava/net/InetSocketAddress;Ljava/net/Proxy;Le/y;Ljava/io/IOException;)V
    //   430: aload 9
    //   432: ifnonnull +17 -> 449
    //   435: new 571	e/a/b/e
    //   438: dup
    //   439: aload 8
    //   441: invokespecial 577	e/a/b/e:<init>	(Ljava/io/IOException;)V
    //   444: astore 9
    //   446: goto +10 -> 456
    //   449: aload 9
    //   451: aload 8
    //   453: invokevirtual 597	e/a/b/e:addConnectException	(Ljava/io/IOException;)V
    //   456: iload 5
    //   458: ifeq +16 -> 474
    //   461: aload 10
    //   463: aload 8
    //   465: invokevirtual 600	e/a/b/b:a	(Ljava/io/IOException;)Z
    //   468: ifeq +6 -> 474
    //   471: goto -289 -> 182
    //   474: aload 9
    //   476: athrow
    //   477: new 571	e/a/b/e
    //   480: dup
    //   481: new 573	java/net/UnknownServiceException
    //   484: dup
    //   485: ldc_w 602
    //   488: invokespecial 574	java/net/UnknownServiceException:<init>	(Ljava/lang/String;)V
    //   491: invokespecial 577	e/a/b/e:<init>	(Ljava/io/IOException;)V
    //   494: athrow
    //   495: new 604	java/lang/IllegalStateException
    //   498: dup
    //   499: ldc_w 606
    //   502: invokespecial 607	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   505: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	506	0	this	c
    //   0	506	1	paramInt1	int
    //   0	506	2	paramInt2	int
    //   0	506	3	paramInt3	int
    //   0	506	4	paramInt4	int
    //   0	506	5	paramBoolean	boolean
    //   0	506	7	paramp	p
    //   17	193	8	localObject	Object
    //   345	1	8	localIOException1	IOException
    //   350	1	8	localIOException2	IOException
    //   355	109	8	localIOException3	IOException
    //   180	295	9	locale	e
    //   28	434	10	localb	b
    // Exception table:
    //   from	to	target	type
    //   321	335	336	finally
    //   338	341	336	finally
    //   230	267	345	java/io/IOException
    //   220	230	350	java/io/IOException
    //   182	209	355	java/io/IOException
  }
  
  public void a(e.a.e.g paramg)
  {
    synchronized (this.g)
    {
      this.c = paramg.a();
      return;
    }
  }
  
  public void a(e.a.e.i parami)
    throws IOException
  {
    parami.a(e.a.e.b.REFUSED_STREAM);
  }
  
  public boolean a(e.a parama, @Nullable ae paramae)
  {
    if (this.d.size() < this.c)
    {
      if (this.a) {
        return false;
      }
      if (!e.a.a.a.a(this.h.a(), parama)) {
        return false;
      }
      if (parama.a().f().equals(b().a().a().f())) {
        return true;
      }
      if (this.m == null) {
        return false;
      }
      if (paramae == null) {
        return false;
      }
      if (paramae.b().type() != Proxy.Type.DIRECT) {
        return false;
      }
      if (this.h.b().type() != Proxy.Type.DIRECT) {
        return false;
      }
      if (!this.h.c().equals(paramae.c())) {
        return false;
      }
      if (paramae.a().j() != e.a.j.d.a) {
        return false;
      }
      if (!a(parama.a())) {
        return false;
      }
    }
    try
    {
      parama.k().a(parama.a().f(), e().b());
      return true;
    }
    catch (SSLPeerUnverifiedException parama) {}
    return false;
    return false;
  }
  
  public boolean a(e.t paramt)
  {
    if (paramt.g() != this.h.a().a().g()) {
      return false;
    }
    if (!paramt.f().equals(this.h.a().a().f())) {
      return (this.k != null) && (e.a.j.d.a.a(paramt.f(), (X509Certificate)this.k.b().get(0)));
    }
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if ((!this.j.isClosed()) && (!this.j.isInputShutdown()))
    {
      if (this.j.isOutputShutdown()) {
        return false;
      }
      if (this.m != null) {
        return this.m.d() ^ true;
      }
      if (!paramBoolean) {}
    }
    try
    {
      int i1 = this.j.getSoTimeout();
      try
      {
        this.j.setSoTimeout(1);
        paramBoolean = this.n.e();
        return !paramBoolean;
      }
      finally
      {
        this.j.setSoTimeout(i1);
      }
      return true;
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      return true;
    }
    catch (IOException localIOException) {}
    return false;
    return false;
  }
  
  public ae b()
  {
    return this.h;
  }
  
  public void c()
  {
    e.a.c.a(this.i);
  }
  
  public Socket d()
  {
    return this.j;
  }
  
  public r e()
  {
    return this.k;
  }
  
  public boolean f()
  {
    return this.m != null;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Connection{");
    localStringBuilder.append(this.h.a().a().f());
    localStringBuilder.append(":");
    localStringBuilder.append(this.h.a().a().g());
    localStringBuilder.append(", proxy=");
    localStringBuilder.append(this.h.b());
    localStringBuilder.append(" hostAddress=");
    localStringBuilder.append(this.h.c());
    localStringBuilder.append(" cipherSuite=");
    Object localObject;
    if (this.k != null) {
      localObject = this.k.a();
    } else {
      localObject = "none";
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append(" protocol=");
    localStringBuilder.append(this.l);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */