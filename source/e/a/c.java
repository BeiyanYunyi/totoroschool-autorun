package e.a;

import e.ab;
import e.ad;
import e.s.a;
import e.t;
import f.e;
import f.f;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public final class c
{
  public static final byte[] a = new byte[0];
  public static final String[] b = new String[0];
  public static final ad c = ad.create(null, a);
  public static final ab d = ab.create(null, a);
  public static final Charset e;
  public static final Charset f;
  public static final TimeZone g;
  public static final Comparator<String> h;
  private static final f i = f.decodeHex("efbbbf");
  private static final f j = f.decodeHex("feff");
  private static final f k = f.decodeHex("fffe");
  private static final f l = f.decodeHex("0000ffff");
  private static final f m = f.decodeHex("ffff0000");
  private static final Charset n;
  private static final Charset o;
  private static final Charset p;
  private static final Charset q;
  private static final Method r;
  private static final Pattern s = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
  
  static
  {
    e = Charset.forName("UTF-8");
    f = Charset.forName("ISO-8859-1");
    n = Charset.forName("UTF-16BE");
    o = Charset.forName("UTF-16LE");
    p = Charset.forName("UTF-32BE");
    q = Charset.forName("UTF-32LE");
    g = TimeZone.getTimeZone("GMT");
    h = new Comparator()
    {
      public int a(String paramAnonymousString1, String paramAnonymousString2)
      {
        return paramAnonymousString1.compareTo(paramAnonymousString2);
      }
    };
    try
    {
      localMethod = Throwable.class.getDeclaredMethod("addSuppressed", new Class[] { Throwable.class });
    }
    catch (Exception localException)
    {
      Method localMethod;
      for (;;) {}
    }
    localMethod = null;
    r = localMethod;
  }
  
  public static int a(char paramChar)
  {
    if ((paramChar >= '0') && (paramChar <= '9')) {
      return paramChar - '0';
    }
    if ((paramChar >= 'a') && (paramChar <= 'f')) {
      return paramChar - 'a' + 10;
    }
    if ((paramChar >= 'A') && (paramChar <= 'F')) {
      return paramChar - 'A' + 10;
    }
    return -1;
  }
  
  public static int a(String paramString, int paramInt1, int paramInt2)
  {
    while (paramInt1 < paramInt2)
    {
      switch (paramString.charAt(paramInt1))
      {
      default: 
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return paramInt2;
  }
  
  public static int a(String paramString, int paramInt1, int paramInt2, char paramChar)
  {
    while (paramInt1 < paramInt2)
    {
      if (paramString.charAt(paramInt1) == paramChar) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return paramInt2;
  }
  
  public static int a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    while (paramInt1 < paramInt2)
    {
      if (paramString2.indexOf(paramString1.charAt(paramInt1)) != -1) {
        return paramInt1;
      }
      paramInt1 += 1;
    }
    return paramInt2;
  }
  
  public static int a(String paramString, long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong >= 0L)
    {
      if (paramTimeUnit != null)
      {
        long l1 = paramTimeUnit.toMillis(paramLong);
        if (l1 <= 2147483647L)
        {
          if ((l1 == 0L) && (paramLong > 0L))
          {
            paramTimeUnit = new StringBuilder();
            paramTimeUnit.append(paramString);
            paramTimeUnit.append(" too small.");
            throw new IllegalArgumentException(paramTimeUnit.toString());
          }
          return (int)l1;
        }
        paramTimeUnit = new StringBuilder();
        paramTimeUnit.append(paramString);
        paramTimeUnit.append(" too large.");
        throw new IllegalArgumentException(paramTimeUnit.toString());
      }
      throw new NullPointerException("unit == null");
    }
    paramTimeUnit = new StringBuilder();
    paramTimeUnit.append(paramString);
    paramTimeUnit.append(" < 0");
    throw new IllegalArgumentException(paramTimeUnit.toString());
  }
  
  public static int a(Comparator<String> paramComparator, String[] paramArrayOfString, String paramString)
  {
    int i2 = paramArrayOfString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      if (paramComparator.compare(paramArrayOfString[i1], paramString) == 0) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public static AssertionError a(String paramString, Exception paramException)
  {
    paramString = new AssertionError(paramString);
    try
    {
      paramString.initCause(paramException);
      return paramString;
    }
    catch (IllegalStateException paramException) {}
    return paramString;
  }
  
  public static String a(t paramt, boolean paramBoolean)
  {
    Object localObject1;
    if (paramt.f().contains(":"))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[");
      ((StringBuilder)localObject1).append(paramt.f());
      ((StringBuilder)localObject1).append("]");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject1 = paramt.f();
    }
    Object localObject2;
    if (!paramBoolean)
    {
      localObject2 = localObject1;
      if (paramt.g() == t.a(paramt.b())) {}
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append(paramt.g());
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    return (String)localObject2;
  }
  
  public static String a(String paramString)
  {
    if (paramString.contains(":"))
    {
      if ((paramString.startsWith("[")) && (paramString.endsWith("]"))) {
        localObject = d(paramString, 1, paramString.length() - 1);
      } else {
        localObject = d(paramString, 0, paramString.length());
      }
      if (localObject == null) {
        return null;
      }
      Object localObject = ((InetAddress)localObject).getAddress();
      if (localObject.length == 16) {
        return a((byte[])localObject);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Invalid IPv6 address: '");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("'");
      throw new AssertionError(((StringBuilder)localObject).toString());
    }
    try
    {
      paramString = IDN.toASCII(paramString).toLowerCase(Locale.US);
      if (paramString.isEmpty()) {
        return null;
      }
      boolean bool = d(paramString);
      if (bool) {
        return null;
      }
      return paramString;
    }
    catch (IllegalArgumentException paramString) {}
    return null;
  }
  
  public static String a(String paramString, Object... paramVarArgs)
  {
    return String.format(Locale.US, paramString, paramVarArgs);
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    int i7 = 0;
    int i1 = 0;
    int i3 = 0;
    int i4;
    int i5;
    for (int i2 = -1; i1 < paramArrayOfByte.length; i2 = i5)
    {
      i4 = i1;
      while ((i4 < 16) && (paramArrayOfByte[i4] == 0) && (paramArrayOfByte[(i4 + 1)] == 0)) {
        i4 += 2;
      }
      int i8 = i4 - i1;
      int i6 = i3;
      i5 = i2;
      if (i8 > i3)
      {
        i6 = i3;
        i5 = i2;
        if (i8 >= 4)
        {
          i6 = i8;
          i5 = i1;
        }
      }
      i1 = i4 + 2;
      i3 = i6;
    }
    f.c localc = new f.c();
    i1 = i7;
    while (i1 < paramArrayOfByte.length) {
      if (i1 == i2)
      {
        localc.b(58);
        i4 = i1 + i3;
        i1 = i4;
        if (i4 == 16)
        {
          localc.b(58);
          i1 = i4;
        }
      }
      else
      {
        if (i1 > 0) {
          localc.b(58);
        }
        localc.k((paramArrayOfByte[i1] & 0xFF) << 8 | paramArrayOfByte[(i1 + 1)] & 0xFF);
        i1 += 2;
      }
    }
    return localc.o();
  }
  
  public static Charset a(e parame, Charset paramCharset)
    throws IOException
  {
    if (parame.a(0L, i))
    {
      parame.i(i.size());
      return e;
    }
    if (parame.a(0L, j))
    {
      parame.i(j.size());
      return n;
    }
    if (parame.a(0L, k))
    {
      parame.i(k.size());
      return o;
    }
    if (parame.a(0L, l))
    {
      parame.i(l.size());
      return p;
    }
    if (parame.a(0L, m))
    {
      parame.i(m.size());
      return q;
    }
    return paramCharset;
  }
  
  public static <T> List<T> a(List<T> paramList)
  {
    return Collections.unmodifiableList(new ArrayList(paramList));
  }
  
  public static <T> List<T> a(T... paramVarArgs)
  {
    return Collections.unmodifiableList(Arrays.asList((Object[])paramVarArgs.clone()));
  }
  
  public static <K, V> Map<K, V> a(Map<K, V> paramMap)
  {
    if (paramMap.isEmpty()) {
      return Collections.emptyMap();
    }
    return Collections.unmodifiableMap(new LinkedHashMap(paramMap));
  }
  
  public static ThreadFactory a(String paramString, final boolean paramBoolean)
  {
    new ThreadFactory()
    {
      public Thread newThread(Runnable paramAnonymousRunnable)
      {
        paramAnonymousRunnable = new Thread(paramAnonymousRunnable, c.this);
        paramAnonymousRunnable.setDaemon(paramBoolean);
        return paramAnonymousRunnable;
      }
    };
  }
  
  public static X509TrustManager a()
  {
    try
    {
      Object localObject = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      ((TrustManagerFactory)localObject).init((KeyStore)null);
      localObject = ((TrustManagerFactory)localObject).getTrustManagers();
      if ((localObject.length == 1) && ((localObject[0] instanceof X509TrustManager))) {
        return (X509TrustManager)localObject[0];
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unexpected default trust managers:");
      localStringBuilder.append(Arrays.toString((Object[])localObject));
      throw new IllegalStateException(localStringBuilder.toString());
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      throw a("No System TLS", localGeneralSecurityException);
    }
  }
  
  public static void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (((paramLong2 | paramLong3) >= 0L) && (paramLong2 <= paramLong1) && (paramLong1 - paramLong2 >= paramLong3)) {
      return;
    }
    throw new ArrayIndexOutOfBoundsException();
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (RuntimeException paramCloseable)
    {
      throw paramCloseable;
      return;
    }
    catch (Exception paramCloseable) {}
  }
  
  public static void a(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    if (r != null) {}
    try
    {
      r.invoke(paramThrowable1, new Object[] { paramThrowable2 });
      return;
    }
    catch (InvocationTargetException|IllegalAccessException paramThrowable1) {}
  }
  
  public static void a(Socket paramSocket)
  {
    if (paramSocket != null) {}
    try
    {
      paramSocket.close();
      return;
    }
    catch (RuntimeException paramSocket)
    {
      throw paramSocket;
    }
    catch (AssertionError paramSocket)
    {
      if (a(paramSocket)) {
        return;
      }
      throw paramSocket;
      return;
    }
    catch (Exception paramSocket) {}
  }
  
  public static boolean a(f.s params, int paramInt, TimeUnit paramTimeUnit)
  {
    try
    {
      boolean bool = b(params, paramInt, paramTimeUnit);
      return bool;
    }
    catch (IOException params)
    {
      for (;;) {}
    }
    return false;
  }
  
  public static boolean a(AssertionError paramAssertionError)
  {
    return (paramAssertionError.getCause() != null) && (paramAssertionError.getMessage() != null) && (paramAssertionError.getMessage().contains("getsockname failed"));
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  private static boolean a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3)
  {
    int i2 = paramInt3;
    int i1 = paramInt1;
    while (i1 < paramInt2)
    {
      if (i2 == paramArrayOfByte.length) {
        return false;
      }
      paramInt1 = i1;
      if (i2 != paramInt3)
      {
        if (paramString.charAt(i1) != '.') {
          return false;
        }
        paramInt1 = i1 + 1;
      }
      i1 = paramInt1;
      int i3 = 0;
      while (i1 < paramInt2)
      {
        int i4 = paramString.charAt(i1);
        if ((i4 < 48) || (i4 > 57)) {
          break;
        }
        if ((i3 == 0) && (paramInt1 != i1)) {
          return false;
        }
        i3 = i3 * 10 + i4 - 48;
        if (i3 > 255) {
          return false;
        }
        i1 += 1;
      }
      if (i1 - paramInt1 == 0) {
        return false;
      }
      paramArrayOfByte[i2] = ((byte)i3);
      i2 += 1;
    }
    return i2 == paramInt3 + 4;
  }
  
  public static String[] a(Comparator<? super String> paramComparator, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    ArrayList localArrayList = new ArrayList();
    int i3 = paramArrayOfString1.length;
    int i1 = 0;
    while (i1 < i3)
    {
      String str = paramArrayOfString1[i1];
      int i4 = paramArrayOfString2.length;
      int i2 = 0;
      while (i2 < i4)
      {
        if (paramComparator.compare(str, paramArrayOfString2[i2]) == 0)
        {
          localArrayList.add(str);
          break;
        }
        i2 += 1;
      }
      i1 += 1;
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public static String[] a(String[] paramArrayOfString, String paramString)
  {
    String[] arrayOfString = new String[paramArrayOfString.length + 1];
    System.arraycopy(paramArrayOfString, 0, arrayOfString, 0, paramArrayOfString.length);
    arrayOfString[(arrayOfString.length - 1)] = paramString;
    return arrayOfString;
  }
  
  public static int b(String paramString)
  {
    int i2 = paramString.length();
    int i1 = 0;
    while (i1 < i2)
    {
      int i3 = paramString.charAt(i1);
      if (i3 > 31)
      {
        if (i3 >= 127) {
          return i1;
        }
        i1 += 1;
      }
      else
      {
        return i1;
      }
    }
    return -1;
  }
  
  public static int b(String paramString, int paramInt1, int paramInt2)
  {
    paramInt2 -= 1;
    while (paramInt2 >= paramInt1)
    {
      switch (paramString.charAt(paramInt2))
      {
      default: 
        return paramInt2 + 1;
      }
      paramInt2 -= 1;
    }
    return paramInt1;
  }
  
  public static e.s b(List<e.a.e.c> paramList)
  {
    s.a locala = new s.a();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      e.a.e.c localc = (e.a.e.c)paramList.next();
      a.a.a(locala, localc.g.utf8(), localc.h.utf8());
    }
    return locala.a();
  }
  
  /* Error */
  public static boolean b(f.s params, int paramInt, TimeUnit paramTimeUnit)
    throws IOException
  {
    // Byte code:
    //   0: invokestatic 523	java/lang/System:nanoTime	()J
    //   3: lstore 5
    //   5: aload_0
    //   6: invokeinterface 529 1 0
    //   11: invokevirtual 534	f/t:n_	()Z
    //   14: ifeq +19 -> 33
    //   17: aload_0
    //   18: invokeinterface 529 1 0
    //   23: invokevirtual 536	f/t:d	()J
    //   26: lload 5
    //   28: lsub
    //   29: lstore_3
    //   30: goto +7 -> 37
    //   33: ldc2_w 537
    //   36: lstore_3
    //   37: aload_0
    //   38: invokeinterface 529 1 0
    //   43: lload_3
    //   44: aload_2
    //   45: iload_1
    //   46: i2l
    //   47: invokevirtual 541	java/util/concurrent/TimeUnit:toNanos	(J)J
    //   50: invokestatic 547	java/lang/Math:min	(JJ)J
    //   53: lload 5
    //   55: ladd
    //   56: invokevirtual 550	f/t:a	(J)Lf/t;
    //   59: pop
    //   60: new 307	f/c
    //   63: dup
    //   64: invokespecial 308	f/c:<init>	()V
    //   67: astore_2
    //   68: aload_0
    //   69: aload_2
    //   70: ldc2_w 551
    //   73: invokeinterface 556 4 0
    //   78: ldc2_w 557
    //   81: lcmp
    //   82: ifeq +10 -> 92
    //   85: aload_2
    //   86: invokevirtual 560	f/c:s	()V
    //   89: goto -21 -> 68
    //   92: lload_3
    //   93: ldc2_w 537
    //   96: lcmp
    //   97: ifne +15 -> 112
    //   100: aload_0
    //   101: invokeinterface 529 1 0
    //   106: invokevirtual 562	f/t:f	()Lf/t;
    //   109: pop
    //   110: iconst_1
    //   111: ireturn
    //   112: aload_0
    //   113: invokeinterface 529 1 0
    //   118: lload 5
    //   120: lload_3
    //   121: ladd
    //   122: invokevirtual 550	f/t:a	(J)Lf/t;
    //   125: pop
    //   126: iconst_1
    //   127: ireturn
    //   128: astore_2
    //   129: lload_3
    //   130: ldc2_w 537
    //   133: lcmp
    //   134: ifne +16 -> 150
    //   137: aload_0
    //   138: invokeinterface 529 1 0
    //   143: invokevirtual 562	f/t:f	()Lf/t;
    //   146: pop
    //   147: goto +17 -> 164
    //   150: aload_0
    //   151: invokeinterface 529 1 0
    //   156: lload 5
    //   158: lload_3
    //   159: ladd
    //   160: invokevirtual 550	f/t:a	(J)Lf/t;
    //   163: pop
    //   164: aload_2
    //   165: athrow
    //   166: lload_3
    //   167: ldc2_w 537
    //   170: lcmp
    //   171: ifne +15 -> 186
    //   174: aload_0
    //   175: invokeinterface 529 1 0
    //   180: invokevirtual 562	f/t:f	()Lf/t;
    //   183: pop
    //   184: iconst_0
    //   185: ireturn
    //   186: aload_0
    //   187: invokeinterface 529 1 0
    //   192: lload 5
    //   194: lload_3
    //   195: ladd
    //   196: invokevirtual 550	f/t:a	(J)Lf/t;
    //   199: pop
    //   200: iconst_0
    //   201: ireturn
    //   202: astore_2
    //   203: goto -37 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	params	f.s
    //   0	206	1	paramInt	int
    //   0	206	2	paramTimeUnit	TimeUnit
    //   29	166	3	l1	long
    //   3	190	5	l2	long
    // Exception table:
    //   from	to	target	type
    //   60	68	128	finally
    //   68	89	128	finally
    //   60	68	202	java/io/InterruptedIOException
    //   68	89	202	java/io/InterruptedIOException
  }
  
  public static boolean b(Comparator<String> paramComparator, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if ((paramArrayOfString1 != null) && (paramArrayOfString2 != null) && (paramArrayOfString1.length != 0))
    {
      if (paramArrayOfString2.length == 0) {
        return false;
      }
      int i3 = paramArrayOfString1.length;
      int i1 = 0;
      while (i1 < i3)
      {
        String str = paramArrayOfString1[i1];
        int i4 = paramArrayOfString2.length;
        int i2 = 0;
        while (i2 < i4)
        {
          if (paramComparator.compare(str, paramArrayOfString2[i2]) == 0) {
            return true;
          }
          i2 += 1;
        }
        i1 += 1;
      }
      return false;
    }
    return false;
  }
  
  public static String c(String paramString, int paramInt1, int paramInt2)
  {
    paramInt1 = a(paramString, paramInt1, paramInt2);
    return paramString.substring(paramInt1, b(paramString, paramInt1, paramInt2));
  }
  
  public static boolean c(String paramString)
  {
    return s.matcher(paramString).matches();
  }
  
  @Nullable
  private static InetAddress d(String paramString, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[16];
    int i1 = 0;
    int i2 = -1;
    int i4 = -1;
    int i3;
    int i5;
    for (;;)
    {
      i3 = i1;
      i5 = i2;
      if (paramInt1 >= paramInt2) {
        break label287;
      }
      if (i1 == arrayOfByte.length) {
        return null;
      }
      i3 = paramInt1 + 2;
      if ((i3 <= paramInt2) && (paramString.regionMatches(paramInt1, "::", 0, 2)))
      {
        if (i2 != -1) {
          return null;
        }
        paramInt1 = i1 + 2;
        if (i3 == paramInt2)
        {
          i5 = paramInt1;
          i3 = paramInt1;
          break label287;
        }
        i2 = paramInt1;
        i1 = paramInt1;
        paramInt1 = i3;
      }
      else
      {
        i3 = paramInt1;
        if (i1 != 0) {
          if (paramString.regionMatches(paramInt1, ":", 0, 1))
          {
            i3 = paramInt1 + 1;
          }
          else
          {
            if (paramString.regionMatches(paramInt1, ".", 0, 1))
            {
              if (!a(paramString, i4, paramInt2, arrayOfByte, i1 - 2)) {
                return null;
              }
              i3 = i1 + 2;
              i5 = i2;
              break label287;
            }
            return null;
          }
        }
        paramInt1 = i3;
      }
      i3 = paramInt1;
      i4 = 0;
      while (i3 < paramInt2)
      {
        i5 = a(paramString.charAt(i3));
        if (i5 == -1) {
          break;
        }
        i4 = (i4 << 4) + i5;
        i3 += 1;
      }
      i5 = i3 - paramInt1;
      if (i5 == 0) {
        break;
      }
      if (i5 > 4) {
        return null;
      }
      i5 = i1 + 1;
      arrayOfByte[i1] = ((byte)(i4 >>> 8 & 0xFF));
      i1 = i5 + 1;
      arrayOfByte[i5] = ((byte)(i4 & 0xFF));
      i4 = paramInt1;
      paramInt1 = i3;
    }
    return null;
    label287:
    if (i3 != arrayOfByte.length)
    {
      if (i5 == -1) {
        return null;
      }
      paramInt1 = arrayOfByte.length;
      paramInt2 = i3 - i5;
      System.arraycopy(arrayOfByte, i5, arrayOfByte, paramInt1 - paramInt2, paramInt2);
      Arrays.fill(arrayOfByte, i5, arrayOfByte.length - i3 + i5, (byte)0);
    }
    try
    {
      paramString = InetAddress.getByAddress(arrayOfByte);
      return paramString;
    }
    catch (UnknownHostException paramString)
    {
      for (;;) {}
    }
    throw new AssertionError();
  }
  
  private static boolean d(String paramString)
  {
    int i1 = 0;
    while (i1 < paramString.length())
    {
      int i2 = paramString.charAt(i1);
      if (i2 > 31)
      {
        if (i2 >= 127) {
          return true;
        }
        if (" #%/:?@[\\]".indexOf(i2) != -1) {
          return true;
        }
        i1 += 1;
      }
      else
      {
        return true;
      }
    }
    return false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */