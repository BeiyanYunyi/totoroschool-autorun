package com.loc;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;

public final class n
{
  public static String a()
  {
    String str2;
    try
    {
      str2 = String.valueOf(System.currentTimeMillis());
      String str1 = "1";
      try
      {
        if (!l.a()) {
          str1 = "0";
        }
        int i = str2.length();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str2.substring(0, i - 2));
        localStringBuilder.append(str1);
        localStringBuilder.append(str2.substring(i - 1));
        str1 = localStringBuilder.toString();
        return str1;
      }
      catch (Throwable localThrowable1) {}
      ag.a(localThrowable2, "CI", "TS");
    }
    catch (Throwable localThrowable2)
    {
      str2 = null;
    }
    return str2;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = l.e(paramContext);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext);
      localStringBuilder.append(":");
      localStringBuilder.append(paramString1.substring(0, paramString1.length() - 3));
      localStringBuilder.append(":");
      localStringBuilder.append(paramString2);
      paramContext = s.b(localStringBuilder.toString());
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      ag.a(paramContext, "CI", "Sco");
    }
    return null;
  }
  
  private static void a(ByteArrayOutputStream paramByteArrayOutputStream, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      byte b;
      if (paramString.getBytes().length > 255) {
        b = -1;
      } else {
        b = (byte)paramString.getBytes().length;
      }
      w.a(paramByteArrayOutputStream, b, w.a(paramString));
      return;
    }
    w.a(paramByteArrayOutputStream, (byte)0, new byte[0]);
  }
  
  public static byte[] a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      Object localObject1;
      try
      {
        a locala = new a((byte)0);
        locala.a = p.w(paramContext);
        locala.b = p.n(paramContext);
        Object localObject2 = p.i(paramContext);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        locala.c = ((String)localObject1);
        locala.d = l.c(paramContext);
        locala.e = Build.MODEL;
        locala.f = Build.MANUFACTURER;
        locala.g = Build.DEVICE;
        locala.h = l.b(paramContext);
        locala.i = l.d(paramContext);
        locala.j = String.valueOf(Build.VERSION.SDK_INT);
        locala.k = p.z(paramContext);
        locala.l = p.v(paramContext);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(p.s(paramContext));
        locala.m = ((StringBuilder)localObject1).toString();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(p.r(paramContext));
        locala.n = ((StringBuilder)localObject1).toString();
        locala.o = p.B(paramContext);
        locala.p = p.q(paramContext);
        if (paramBoolean1)
        {
          localObject1 = "";
          locala.q = ((String)localObject1);
        }
        else
        {
          localObject1 = p.m(paramContext);
          continue;
          locala.r = ((String)localObject1);
          continue;
          localObject1 = p.l(paramContext);
          continue;
          if (paramBoolean1)
          {
            locala.s = "";
            localObject1 = "";
            locala.t = ((String)localObject1);
          }
          else
          {
            localObject1 = p.o(paramContext);
            locala.s = localObject1[0];
            localObject1 = localObject1[1];
            continue;
          }
          locala.w = p.a();
          localObject1 = p.b(paramContext);
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label741;
          }
          locala.x = ((String)localObject1);
          localObject1 = new StringBuilder("aid=");
          ((StringBuilder)localObject1).append(p.k(paramContext));
          locala.y = ((StringBuilder)localObject1).toString();
          if (((paramBoolean2) && (x.e)) || (x.f))
          {
            localObject1 = p.h(paramContext);
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(locala.y);
              ((StringBuilder)localObject2).append("|oaid=");
              ((StringBuilder)localObject2).append((String)localObject1);
              locala.y = ((StringBuilder)localObject2).toString();
            }
          }
          localObject1 = p.a(paramContext, ",");
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(locala.y);
            ((StringBuilder)localObject2).append("|multiImeis=");
            ((StringBuilder)localObject2).append((String)localObject1);
            locala.y = ((StringBuilder)localObject2).toString();
          }
          localObject1 = p.y(paramContext);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(locala.y);
            ((StringBuilder)localObject2).append("|meid=");
            ((StringBuilder)localObject2).append((String)localObject1);
            locala.y = ((StringBuilder)localObject2).toString();
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(locala.y);
          ((StringBuilder)localObject1).append("|serial=");
          ((StringBuilder)localObject1).append(p.j(paramContext));
          locala.y = ((StringBuilder)localObject1).toString();
          localObject1 = p.a(paramContext);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(locala.y);
            ((StringBuilder)localObject2).append("|adiuExtras=");
            ((StringBuilder)localObject2).append((String)localObject1);
            locala.y = ((StringBuilder)localObject2).toString();
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(locala.y);
          ((StringBuilder)localObject1).append("|storage=");
          ((StringBuilder)localObject1).append(p.c());
          ((StringBuilder)localObject1).append("|ram=");
          ((StringBuilder)localObject1).append(p.A(paramContext));
          ((StringBuilder)localObject1).append("|arch=");
          ((StringBuilder)localObject1).append(p.d());
          locala.y = ((StringBuilder)localObject1).toString();
          paramContext = a(locala);
          return paramContext;
        }
      }
      catch (Throwable paramContext)
      {
        ag.a(paramContext, "CI", "gz");
        return null;
      }
      if (paramBoolean1)
      {
        localObject1 = "";
        continue;
        label741:
        localObject1 = "";
      }
    }
  }
  
  /* Error */
  private static byte[] a(a parama)
  {
    // Byte code:
    //   0: new 294	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 295	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: astore_1
    //   10: aload_2
    //   11: aload_0
    //   12: getfield 111	com/loc/n$a:a	Ljava/lang/String;
    //   15: invokestatic 297	com/loc/n:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   18: aload_2
    //   19: astore_1
    //   20: aload_2
    //   21: aload_0
    //   22: getfield 116	com/loc/n$a:b	Ljava/lang/String;
    //   25: invokestatic 297	com/loc/n:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   28: aload_2
    //   29: astore_1
    //   30: aload_2
    //   31: aload_0
    //   32: getfield 124	com/loc/n$a:c	Ljava/lang/String;
    //   35: invokestatic 297	com/loc/n:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   38: aload_2
    //   39: astore_1
    //   40: aload_2
    //   41: aload_0
    //   42: getfield 129	com/loc/n$a:d	Ljava/lang/String;
    //   45: invokestatic 297	com/loc/n:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   48: aload_2
    //   49: astore_1
    //   50: aload_2
    //   51: aload_0
    //   52: getfield 136	com/loc/n$a:e	Ljava/lang/String;
    //   55: invokestatic 297	com/loc/n:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   58: aload_2
    //   59: astore_1
    //   60: aload_2
    //   61: aload_0
    //   62: getfield 142	com/loc/n$a:f	Ljava/lang/String;
    //   65: invokestatic 297	com/loc/n:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   68: aload_2
    //   69: astore_1
    //   70: aload_2
    //   71: aload_0
    //   72: getfield 148	com/loc/n$a:g	Ljava/lang/String;
    //   75: invokestatic 297	com/loc/n:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   78: aload_2
    //   79: astore_1
    //   80: aload_2
    //   81: aload_0
    //   82: getfield 153	com/loc/n$a:h	Ljava/lang/String;
    //   85: invokestatic 297	com/loc/n:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   88: aload_2
    //   89: astore_1
    //   90: aload_2
    //   91: aload_0
    //   92: getfield 157	com/loc/n$a:i	Ljava/lang/String;
    //   95: invokestatic 297	com/loc/n:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   98: aload_2
    //   99: astore_1
    //   100: aload_2
    //   101: aload_0
    //   102: getfield 168	com/loc/n$a:j	Ljava/lang/String;
    //   105: invokestatic 297	com/loc/n:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   108: aload_2
    //   109: astore_1
    //   110: aload_2
    //   111: aload_0
    //   112: getfield 174	com/loc/n$a:k	Ljava/lang/String;
    //   115: invokestatic 297	com/loc/n:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   118: aload_2
    //   119: astore_1
    //   120: aload_2
    //   121: aload_0
    //   122: getfield 180	com/loc/n$a:l	Ljava/lang/String;
    //   125: invokestatic 297	com/loc/n:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   128: aload_2
    //   129: astore_1
    //   130: aload_2
    //   131: aload_0
    //   132: getfield 190	com/loc/n$a:m	Ljava/lang/String;
    //   135: invokestatic 297	com/loc/n:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   138: aload_2
    //   139: astore_1
    //   140: aload_2
    //   141: aload_0
    //   142: getfield 195	com/loc/n$a:n	Ljava/lang/String;
    //   145: invokestatic 297	com/loc/n:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   148: aload_2
    //   149: astore_1
    //   150: aload_2
    //   151: aload_0
    //   152: getfield 201	com/loc/n$a:o	Ljava/lang/String;
    //   155: invokestatic 297	com/loc/n:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   158: aload_2
    //   159: astore_1
    //   160: aload_2
    //   161: aload_0
    //   162: getfield 207	com/loc/n$a:p	Ljava/lang/String;
    //   165: invokestatic 297	com/loc/n:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   168: aload_2
    //   169: astore_1
    //   170: aload_2
    //   171: aload_0
    //   172: getfield 209	com/loc/n$a:q	Ljava/lang/String;
    //   175: invokestatic 297	com/loc/n:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   178: aload_2
    //   179: astore_1
    //   180: aload_2
    //   181: aload_0
    //   182: getfield 213	com/loc/n$a:r	Ljava/lang/String;
    //   185: invokestatic 297	com/loc/n:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   188: aload_2
    //   189: astore_1
    //   190: aload_2
    //   191: aload_0
    //   192: getfield 217	com/loc/n$a:s	Ljava/lang/String;
    //   195: invokestatic 297	com/loc/n:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   198: aload_2
    //   199: astore_1
    //   200: aload_2
    //   201: aload_0
    //   202: getfield 220	com/loc/n$a:t	Ljava/lang/String;
    //   205: invokestatic 297	com/loc/n:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   208: aload_2
    //   209: astore_1
    //   210: aload_2
    //   211: aload_0
    //   212: getfield 300	com/loc/n$a:u	Ljava/lang/String;
    //   215: invokestatic 297	com/loc/n:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   218: aload_2
    //   219: astore_1
    //   220: aload_2
    //   221: aload_0
    //   222: getfield 302	com/loc/n$a:v	Ljava/lang/String;
    //   225: invokestatic 297	com/loc/n:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   228: aload_2
    //   229: astore_1
    //   230: aload_2
    //   231: aload_0
    //   232: getfield 227	com/loc/n$a:w	Ljava/lang/String;
    //   235: invokestatic 297	com/loc/n:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   238: aload_2
    //   239: astore_1
    //   240: aload_2
    //   241: aload_0
    //   242: getfield 231	com/loc/n$a:x	Ljava/lang/String;
    //   245: invokestatic 297	com/loc/n:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   248: aload_2
    //   249: astore_1
    //   250: aload_2
    //   251: aload_0
    //   252: getfield 241	com/loc/n$a:y	Ljava/lang/String;
    //   255: invokestatic 297	com/loc/n:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   258: aload_2
    //   259: astore_1
    //   260: aload_2
    //   261: invokevirtual 305	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   264: invokestatic 308	com/loc/w:b	([B)[B
    //   267: astore_3
    //   268: aload_2
    //   269: astore_1
    //   270: invokestatic 311	com/loc/w:d	()Ljava/security/PublicKey;
    //   273: astore_0
    //   274: aload_2
    //   275: astore_1
    //   276: aload_3
    //   277: arraylength
    //   278: bipush 117
    //   280: if_icmple +80 -> 360
    //   283: aload_2
    //   284: astore_1
    //   285: bipush 117
    //   287: newarray <illegal type>
    //   289: astore 4
    //   291: aload_2
    //   292: astore_1
    //   293: aload_3
    //   294: iconst_0
    //   295: aload 4
    //   297: iconst_0
    //   298: bipush 117
    //   300: invokestatic 315	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   303: aload_2
    //   304: astore_1
    //   305: aload 4
    //   307: aload_0
    //   308: invokestatic 320	com/loc/q:a	([BLjava/security/Key;)[B
    //   311: astore 4
    //   313: aload_2
    //   314: astore_1
    //   315: aload_3
    //   316: arraylength
    //   317: sipush 128
    //   320: iadd
    //   321: bipush 117
    //   323: isub
    //   324: newarray <illegal type>
    //   326: astore_0
    //   327: aload_2
    //   328: astore_1
    //   329: aload 4
    //   331: iconst_0
    //   332: aload_0
    //   333: iconst_0
    //   334: sipush 128
    //   337: invokestatic 315	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   340: aload_2
    //   341: astore_1
    //   342: aload_3
    //   343: bipush 117
    //   345: aload_0
    //   346: sipush 128
    //   349: aload_3
    //   350: arraylength
    //   351: bipush 117
    //   353: isub
    //   354: invokestatic 315	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   357: goto +11 -> 368
    //   360: aload_2
    //   361: astore_1
    //   362: aload_3
    //   363: aload_0
    //   364: invokestatic 320	com/loc/q:a	([BLjava/security/Key;)[B
    //   367: astore_0
    //   368: aload_2
    //   369: invokevirtual 323	java/io/ByteArrayOutputStream:close	()V
    //   372: aload_0
    //   373: areturn
    //   374: astore_1
    //   375: aload_1
    //   376: invokevirtual 326	java/lang/Throwable:printStackTrace	()V
    //   379: aload_0
    //   380: areturn
    //   381: astore_1
    //   382: aload_2
    //   383: astore_0
    //   384: aload_1
    //   385: astore_2
    //   386: goto +12 -> 398
    //   389: astore_0
    //   390: aconst_null
    //   391: astore_1
    //   392: goto +35 -> 427
    //   395: astore_2
    //   396: aconst_null
    //   397: astore_0
    //   398: aload_0
    //   399: astore_1
    //   400: aload_2
    //   401: ldc 57
    //   403: ldc_w 328
    //   406: invokestatic 64	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   409: aload_0
    //   410: ifnull +14 -> 424
    //   413: aload_0
    //   414: invokevirtual 323	java/io/ByteArrayOutputStream:close	()V
    //   417: aconst_null
    //   418: areturn
    //   419: astore_0
    //   420: aload_0
    //   421: invokevirtual 326	java/lang/Throwable:printStackTrace	()V
    //   424: aconst_null
    //   425: areturn
    //   426: astore_0
    //   427: aload_1
    //   428: ifnull +15 -> 443
    //   431: aload_1
    //   432: invokevirtual 323	java/io/ByteArrayOutputStream:close	()V
    //   435: goto +8 -> 443
    //   438: astore_1
    //   439: aload_1
    //   440: invokevirtual 326	java/lang/Throwable:printStackTrace	()V
    //   443: aload_0
    //   444: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	445	0	parama	a
    //   9	353	1	localObject1	Object
    //   374	2	1	localThrowable1	Throwable
    //   381	4	1	localThrowable2	Throwable
    //   391	41	1	locala	a
    //   438	2	1	localThrowable3	Throwable
    //   7	379	2	localObject2	Object
    //   395	6	2	localThrowable4	Throwable
    //   267	96	3	arrayOfByte1	byte[]
    //   289	41	4	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   368	372	374	java/lang/Throwable
    //   10	18	381	java/lang/Throwable
    //   20	28	381	java/lang/Throwable
    //   30	38	381	java/lang/Throwable
    //   40	48	381	java/lang/Throwable
    //   50	58	381	java/lang/Throwable
    //   60	68	381	java/lang/Throwable
    //   70	78	381	java/lang/Throwable
    //   80	88	381	java/lang/Throwable
    //   90	98	381	java/lang/Throwable
    //   100	108	381	java/lang/Throwable
    //   110	118	381	java/lang/Throwable
    //   120	128	381	java/lang/Throwable
    //   130	138	381	java/lang/Throwable
    //   140	148	381	java/lang/Throwable
    //   150	158	381	java/lang/Throwable
    //   160	168	381	java/lang/Throwable
    //   170	178	381	java/lang/Throwable
    //   180	188	381	java/lang/Throwable
    //   190	198	381	java/lang/Throwable
    //   200	208	381	java/lang/Throwable
    //   210	218	381	java/lang/Throwable
    //   220	228	381	java/lang/Throwable
    //   230	238	381	java/lang/Throwable
    //   240	248	381	java/lang/Throwable
    //   250	258	381	java/lang/Throwable
    //   260	268	381	java/lang/Throwable
    //   270	274	381	java/lang/Throwable
    //   276	283	381	java/lang/Throwable
    //   285	291	381	java/lang/Throwable
    //   293	303	381	java/lang/Throwable
    //   305	313	381	java/lang/Throwable
    //   315	327	381	java/lang/Throwable
    //   329	340	381	java/lang/Throwable
    //   342	357	381	java/lang/Throwable
    //   362	368	381	java/lang/Throwable
    //   0	8	389	finally
    //   0	8	395	java/lang/Throwable
    //   413	417	419	java/lang/Throwable
    //   10	18	426	finally
    //   20	28	426	finally
    //   30	38	426	finally
    //   40	48	426	finally
    //   50	58	426	finally
    //   60	68	426	finally
    //   70	78	426	finally
    //   80	88	426	finally
    //   90	98	426	finally
    //   100	108	426	finally
    //   110	118	426	finally
    //   120	128	426	finally
    //   130	138	426	finally
    //   140	148	426	finally
    //   150	158	426	finally
    //   160	168	426	finally
    //   170	178	426	finally
    //   180	188	426	finally
    //   190	198	426	finally
    //   200	208	426	finally
    //   210	218	426	finally
    //   220	228	426	finally
    //   230	238	426	finally
    //   240	248	426	finally
    //   250	258	426	finally
    //   260	268	426	finally
    //   270	274	426	finally
    //   276	283	426	finally
    //   285	291	426	finally
    //   293	303	426	finally
    //   305	313	426	finally
    //   315	327	426	finally
    //   329	340	426	finally
    //   342	357	426	finally
    //   362	368	426	finally
    //   400	409	426	finally
    //   431	435	438	java/lang/Throwable
  }
  
  private static final class a
  {
    String a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;
    String h;
    String i;
    String j;
    String k;
    String l;
    String m;
    String n;
    String o;
    String p;
    String q;
    String r;
    String s;
    String t;
    String u;
    String v;
    String w;
    String x;
    String y;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */