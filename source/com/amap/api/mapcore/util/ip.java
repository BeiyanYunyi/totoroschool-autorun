package com.amap.api.mapcore.util;

import android.content.Context;
import java.lang.ref.WeakReference;

public class ip
{
  public static ih a(WeakReference<ih> paramWeakReference)
  {
    Object localObject;
    if (paramWeakReference != null)
    {
      localObject = paramWeakReference;
      if (paramWeakReference.get() != null) {}
    }
    else
    {
      localObject = new WeakReference(new ih());
    }
    return (ih)((WeakReference)localObject).get();
  }
  
  public static String a()
  {
    return fw.a(System.currentTimeMillis());
  }
  
  public static String a(Context paramContext, fv paramfv)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      String str = fp.g(paramContext);
      localStringBuilder.append("\"sim\":\"");
      localStringBuilder.append(str);
      localStringBuilder.append("\",\"sdkversion\":\"");
      localStringBuilder.append(paramfv.c());
      localStringBuilder.append("\",\"product\":\"");
      localStringBuilder.append(paramfv.a());
      localStringBuilder.append("\",\"ed\":\"");
      localStringBuilder.append(paramfv.e());
      localStringBuilder.append("\",\"nt\":\"");
      localStringBuilder.append(fp.e(paramContext));
      localStringBuilder.append("\",\"np\":\"");
      localStringBuilder.append(fp.c(paramContext));
      localStringBuilder.append("\",\"mnc\":\"");
      localStringBuilder.append(fp.d(paramContext));
      localStringBuilder.append("\",\"ant\":\"");
      localStringBuilder.append(fp.f(paramContext));
      localStringBuilder.append("\"");
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    paramString1 = new StringBuffer();
    paramString1.append(paramString2);
    paramString1.append(",");
    paramString1.append("\"timestamp\":\"");
    paramString1.append(paramString3);
    paramString1.append("\",\"et\":\"");
    paramString1.append(paramInt);
    paramString1.append("\",\"classname\":\"");
    paramString1.append(paramString4);
    paramString1.append("\",");
    paramString1.append("\"detail\":\"");
    paramString1.append(paramString5);
    paramString1.append("\"");
    return paramString1.toString();
  }
  
  public static void a(Context paramContext, ih paramih, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    paramih.a = gh.c(paramContext, paramString1);
    paramih.d = paramInt1;
    paramih.b = paramInt2;
    paramih.c = paramString2;
  }
  
  /* Error */
  static byte[] a(hs paramhs, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: newarray <illegal type>
    //   3: astore 6
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore 4
    //   11: aconst_null
    //   12: astore 8
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 147	com/amap/api/mapcore/util/hs:a	(Ljava/lang/String;)Lcom/amap/api/mapcore/util/hs$b;
    //   19: astore_3
    //   20: aload_3
    //   21: ifnonnull +22 -> 43
    //   24: aload_3
    //   25: ifnull +15 -> 40
    //   28: aload_3
    //   29: invokevirtual 152	com/amap/api/mapcore/util/hs$b:close	()V
    //   32: aload 6
    //   34: areturn
    //   35: astore_0
    //   36: aload_0
    //   37: invokevirtual 97	java/lang/Throwable:printStackTrace	()V
    //   40: aload 6
    //   42: areturn
    //   43: aload 5
    //   45: astore 4
    //   47: aload_3
    //   48: astore 5
    //   50: aload_3
    //   51: iconst_0
    //   52: invokevirtual 155	com/amap/api/mapcore/util/hs$b:a	(I)Ljava/io/InputStream;
    //   55: astore 7
    //   57: aload 7
    //   59: ifnonnull +40 -> 99
    //   62: aload 7
    //   64: ifnull +16 -> 80
    //   67: aload 7
    //   69: invokevirtual 158	java/io/InputStream:close	()V
    //   72: goto +8 -> 80
    //   75: astore_0
    //   76: aload_0
    //   77: invokevirtual 97	java/lang/Throwable:printStackTrace	()V
    //   80: aload_3
    //   81: ifnull +15 -> 96
    //   84: aload_3
    //   85: invokevirtual 152	com/amap/api/mapcore/util/hs$b:close	()V
    //   88: aload 6
    //   90: areturn
    //   91: astore_0
    //   92: aload_0
    //   93: invokevirtual 97	java/lang/Throwable:printStackTrace	()V
    //   96: aload 6
    //   98: areturn
    //   99: aload 7
    //   101: invokevirtual 162	java/io/InputStream:available	()I
    //   104: newarray <illegal type>
    //   106: astore 4
    //   108: aload 7
    //   110: aload 4
    //   112: invokevirtual 166	java/io/InputStream:read	([B)I
    //   115: pop
    //   116: iload_2
    //   117: ifeq +9 -> 126
    //   120: aload_0
    //   121: aload_1
    //   122: invokevirtual 169	com/amap/api/mapcore/util/hs:c	(Ljava/lang/String;)Z
    //   125: pop
    //   126: aload 7
    //   128: ifnull +16 -> 144
    //   131: aload 7
    //   133: invokevirtual 158	java/io/InputStream:close	()V
    //   136: goto +8 -> 144
    //   139: astore_0
    //   140: aload_0
    //   141: invokevirtual 97	java/lang/Throwable:printStackTrace	()V
    //   144: aload_3
    //   145: ifnull +15 -> 160
    //   148: aload_3
    //   149: invokevirtual 152	com/amap/api/mapcore/util/hs$b:close	()V
    //   152: aload 4
    //   154: areturn
    //   155: astore_0
    //   156: aload_0
    //   157: invokevirtual 97	java/lang/Throwable:printStackTrace	()V
    //   160: aload 4
    //   162: areturn
    //   163: astore_1
    //   164: aload 4
    //   166: astore_0
    //   167: goto +15 -> 182
    //   170: astore_0
    //   171: aload 7
    //   173: astore 4
    //   175: goto +88 -> 263
    //   178: astore_1
    //   179: aload 6
    //   181: astore_0
    //   182: aload_0
    //   183: astore 6
    //   185: aload 7
    //   187: astore_0
    //   188: goto +22 -> 210
    //   191: astore_1
    //   192: aload 8
    //   194: astore_0
    //   195: goto +15 -> 210
    //   198: astore_0
    //   199: aconst_null
    //   200: astore_3
    //   201: goto +62 -> 263
    //   204: astore_1
    //   205: aconst_null
    //   206: astore_3
    //   207: aload 8
    //   209: astore_0
    //   210: aload_0
    //   211: astore 4
    //   213: aload_3
    //   214: astore 5
    //   216: aload_1
    //   217: ldc -85
    //   219: ldc -83
    //   221: invokestatic 178	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   224: aload_0
    //   225: ifnull +15 -> 240
    //   228: aload_0
    //   229: invokevirtual 158	java/io/InputStream:close	()V
    //   232: goto +8 -> 240
    //   235: astore_0
    //   236: aload_0
    //   237: invokevirtual 97	java/lang/Throwable:printStackTrace	()V
    //   240: aload_3
    //   241: ifnull +15 -> 256
    //   244: aload_3
    //   245: invokevirtual 152	com/amap/api/mapcore/util/hs$b:close	()V
    //   248: aload 6
    //   250: areturn
    //   251: astore_0
    //   252: aload_0
    //   253: invokevirtual 97	java/lang/Throwable:printStackTrace	()V
    //   256: aload 6
    //   258: areturn
    //   259: astore_0
    //   260: aload 5
    //   262: astore_3
    //   263: aload 4
    //   265: ifnull +16 -> 281
    //   268: aload 4
    //   270: invokevirtual 158	java/io/InputStream:close	()V
    //   273: goto +8 -> 281
    //   276: astore_1
    //   277: aload_1
    //   278: invokevirtual 97	java/lang/Throwable:printStackTrace	()V
    //   281: aload_3
    //   282: ifnull +15 -> 297
    //   285: aload_3
    //   286: invokevirtual 152	com/amap/api/mapcore/util/hs$b:close	()V
    //   289: goto +8 -> 297
    //   292: astore_1
    //   293: aload_1
    //   294: invokevirtual 97	java/lang/Throwable:printStackTrace	()V
    //   297: aload_0
    //   298: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	paramhs	hs
    //   0	299	1	paramString	String
    //   0	299	2	paramBoolean	boolean
    //   19	267	3	localObject1	Object
    //   9	260	4	localObject2	Object
    //   6	255	5	localObject3	Object
    //   3	254	6	localObject4	Object
    //   55	131	7	localInputStream	java.io.InputStream
    //   12	196	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   28	32	35	java/lang/Throwable
    //   67	72	75	java/lang/Throwable
    //   84	88	91	java/lang/Throwable
    //   131	136	139	java/lang/Throwable
    //   148	152	155	java/lang/Throwable
    //   108	116	163	java/lang/Throwable
    //   120	126	163	java/lang/Throwable
    //   99	108	170	finally
    //   108	116	170	finally
    //   120	126	170	finally
    //   99	108	178	java/lang/Throwable
    //   50	57	191	java/lang/Throwable
    //   14	20	198	finally
    //   14	20	204	java/lang/Throwable
    //   228	232	235	java/lang/Throwable
    //   244	248	251	java/lang/Throwable
    //   50	57	259	finally
    //   216	224	259	finally
    //   268	273	276	java/lang/Throwable
    //   285	289	292	java/lang/Throwable
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */