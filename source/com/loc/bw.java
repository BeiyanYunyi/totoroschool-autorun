package com.loc;

import android.content.Context;
import java.lang.ref.WeakReference;

public final class bw
{
  public static bp a(WeakReference<bp> paramWeakReference)
  {
    Object localObject;
    if (paramWeakReference != null)
    {
      localObject = paramWeakReference;
      if (paramWeakReference.get() != null) {}
    }
    else
    {
      localObject = new WeakReference(new bp());
    }
    return (bp)((WeakReference)localObject).get();
  }
  
  public static String a(Context paramContext, v paramv)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      String str = p.g(paramContext);
      localStringBuilder.append("\"sim\":\"");
      localStringBuilder.append(str);
      localStringBuilder.append("\",\"sdkversion\":\"");
      localStringBuilder.append(paramv.c());
      localStringBuilder.append("\",\"product\":\"");
      localStringBuilder.append(paramv.a());
      localStringBuilder.append("\",\"ed\":\"");
      localStringBuilder.append(paramv.d());
      localStringBuilder.append("\",\"nt\":\"");
      localStringBuilder.append(p.e(paramContext));
      localStringBuilder.append("\",\"np\":\"");
      localStringBuilder.append(p.c(paramContext));
      localStringBuilder.append("\",\"mnc\":\"");
      localStringBuilder.append(p.d(paramContext));
      localStringBuilder.append("\",\"ant\":\"");
      localStringBuilder.append(p.f(paramContext));
      localStringBuilder.append("\"");
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return localStringBuilder.toString();
  }
  
  public static void a(Context paramContext, bp parambp, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    parambp.a = ah.c(paramContext, paramString1);
    parambp.d = paramInt1;
    parambp.b = paramInt2;
    parambp.c = paramString2;
  }
  
  /* Error */
  static byte[] a(bf parambf, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: newarray <illegal type>
    //   3: astore 5
    //   5: aload_0
    //   6: aload_1
    //   7: invokevirtual 113	com/loc/bf:a	(Ljava/lang/String;)Lcom/loc/bf$b;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnonnull +22 -> 34
    //   15: aload_1
    //   16: ifnull +15 -> 31
    //   19: aload_1
    //   20: invokevirtual 118	com/loc/bf$b:close	()V
    //   23: aload 5
    //   25: areturn
    //   26: astore_0
    //   27: aload_0
    //   28: invokevirtual 86	java/lang/Throwable:printStackTrace	()V
    //   31: aload 5
    //   33: areturn
    //   34: aload_1
    //   35: invokevirtual 121	com/loc/bf$b:a	()Ljava/io/InputStream;
    //   38: astore 6
    //   40: aload 6
    //   42: ifnonnull +40 -> 82
    //   45: aload 6
    //   47: ifnull +16 -> 63
    //   50: aload 6
    //   52: invokevirtual 124	java/io/InputStream:close	()V
    //   55: goto +8 -> 63
    //   58: astore_0
    //   59: aload_0
    //   60: invokevirtual 86	java/lang/Throwable:printStackTrace	()V
    //   63: aload_1
    //   64: ifnull +15 -> 79
    //   67: aload_1
    //   68: invokevirtual 118	com/loc/bf$b:close	()V
    //   71: aload 5
    //   73: areturn
    //   74: astore_0
    //   75: aload_0
    //   76: invokevirtual 86	java/lang/Throwable:printStackTrace	()V
    //   79: aload 5
    //   81: areturn
    //   82: aload_1
    //   83: astore_2
    //   84: aload 6
    //   86: astore 4
    //   88: aload 6
    //   90: invokevirtual 128	java/io/InputStream:available	()I
    //   93: newarray <illegal type>
    //   95: astore_3
    //   96: aload_1
    //   97: astore_2
    //   98: aload 6
    //   100: astore 4
    //   102: aload 6
    //   104: aload_3
    //   105: invokevirtual 132	java/io/InputStream:read	([B)I
    //   108: pop
    //   109: aload 6
    //   111: ifnull +16 -> 127
    //   114: aload 6
    //   116: invokevirtual 124	java/io/InputStream:close	()V
    //   119: goto +8 -> 127
    //   122: astore_0
    //   123: aload_0
    //   124: invokevirtual 86	java/lang/Throwable:printStackTrace	()V
    //   127: aload_1
    //   128: ifnull +14 -> 142
    //   131: aload_1
    //   132: invokevirtual 118	com/loc/bf$b:close	()V
    //   135: aload_3
    //   136: areturn
    //   137: astore_0
    //   138: aload_0
    //   139: invokevirtual 86	java/lang/Throwable:printStackTrace	()V
    //   142: aload_3
    //   143: areturn
    //   144: astore_0
    //   145: aload_3
    //   146: astore 5
    //   148: aload_1
    //   149: astore_3
    //   150: aload 6
    //   152: astore_1
    //   153: goto +43 -> 196
    //   156: astore_0
    //   157: aload_1
    //   158: astore_3
    //   159: aload 6
    //   161: astore_1
    //   162: goto +34 -> 196
    //   165: astore_0
    //   166: aconst_null
    //   167: astore 4
    //   169: goto +78 -> 247
    //   172: astore_0
    //   173: aconst_null
    //   174: astore_2
    //   175: aload_1
    //   176: astore_3
    //   177: aload_2
    //   178: astore_1
    //   179: goto +17 -> 196
    //   182: astore_0
    //   183: aconst_null
    //   184: astore_1
    //   185: aload_1
    //   186: astore 4
    //   188: goto +59 -> 247
    //   191: astore_0
    //   192: aconst_null
    //   193: astore_1
    //   194: aload_1
    //   195: astore_3
    //   196: aload_3
    //   197: astore_2
    //   198: aload_1
    //   199: astore 4
    //   201: aload_0
    //   202: ldc -122
    //   204: ldc -120
    //   206: invokestatic 141	com/loc/aj:b	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   209: aload_1
    //   210: ifnull +15 -> 225
    //   213: aload_1
    //   214: invokevirtual 124	java/io/InputStream:close	()V
    //   217: goto +8 -> 225
    //   220: astore_0
    //   221: aload_0
    //   222: invokevirtual 86	java/lang/Throwable:printStackTrace	()V
    //   225: aload_3
    //   226: ifnull +15 -> 241
    //   229: aload_3
    //   230: invokevirtual 118	com/loc/bf$b:close	()V
    //   233: aload 5
    //   235: areturn
    //   236: astore_0
    //   237: aload_0
    //   238: invokevirtual 86	java/lang/Throwable:printStackTrace	()V
    //   241: aload 5
    //   243: areturn
    //   244: astore_0
    //   245: aload_2
    //   246: astore_1
    //   247: aload 4
    //   249: ifnull +16 -> 265
    //   252: aload 4
    //   254: invokevirtual 124	java/io/InputStream:close	()V
    //   257: goto +8 -> 265
    //   260: astore_2
    //   261: aload_2
    //   262: invokevirtual 86	java/lang/Throwable:printStackTrace	()V
    //   265: aload_1
    //   266: ifnull +15 -> 281
    //   269: aload_1
    //   270: invokevirtual 118	com/loc/bf$b:close	()V
    //   273: goto +8 -> 281
    //   276: astore_1
    //   277: aload_1
    //   278: invokevirtual 86	java/lang/Throwable:printStackTrace	()V
    //   281: aload_0
    //   282: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	parambf	bf
    //   0	283	1	paramString	String
    //   83	163	2	localObject1	Object
    //   260	2	2	localThrowable	Throwable
    //   95	135	3	localObject2	Object
    //   86	167	4	localObject3	Object
    //   3	239	5	localObject4	Object
    //   38	122	6	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   19	23	26	java/lang/Throwable
    //   50	55	58	java/lang/Throwable
    //   67	71	74	java/lang/Throwable
    //   114	119	122	java/lang/Throwable
    //   131	135	137	java/lang/Throwable
    //   102	109	144	java/lang/Throwable
    //   88	96	156	java/lang/Throwable
    //   34	40	165	finally
    //   34	40	172	java/lang/Throwable
    //   5	11	182	finally
    //   5	11	191	java/lang/Throwable
    //   213	217	220	java/lang/Throwable
    //   229	233	236	java/lang/Throwable
    //   88	96	244	finally
    //   102	109	244	finally
    //   201	209	244	finally
    //   252	257	260	java/lang/Throwable
    //   269	273	276	java/lang/Throwable
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\bw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */