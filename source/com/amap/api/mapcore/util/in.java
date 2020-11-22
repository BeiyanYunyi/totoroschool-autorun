package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;

public class in
{
  private Context a;
  private String b;
  private String c;
  private String d;
  private String e;
  
  public in(Context paramContext, String paramString1, String paramString2, String paramString3)
    throws fj
  {
    if ((!TextUtils.isEmpty(paramString3)) && (paramString3.length() <= 256))
    {
      this.a = paramContext.getApplicationContext();
      this.c = paramString1;
      this.d = paramString2;
      this.b = paramString3;
      return;
    }
    throw new fj("无效的参数 - IllegalArgumentException");
  }
  
  public void a(String paramString)
    throws fj
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.length() <= 65536))
    {
      this.e = paramString;
      return;
    }
    throw new fj("无效的参数 - IllegalArgumentException");
  }
  
  /* Error */
  public byte[] a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aconst_null
    //   3: astore 6
    //   5: aconst_null
    //   6: astore 4
    //   8: new 59	java/io/ByteArrayOutputStream
    //   11: dup
    //   12: invokespecial 60	java/io/ByteArrayOutputStream:<init>	()V
    //   15: astore 5
    //   17: aload 5
    //   19: aload_0
    //   20: getfield 40	com/amap/api/mapcore/util/in:c	Ljava/lang/String;
    //   23: invokestatic 65	com/amap/api/mapcore/util/fw:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   26: aload 5
    //   28: aload_0
    //   29: getfield 42	com/amap/api/mapcore/util/in:d	Ljava/lang/String;
    //   32: invokestatic 65	com/amap/api/mapcore/util/fw:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   35: aload 5
    //   37: aload_0
    //   38: getfield 44	com/amap/api/mapcore/util/in:b	Ljava/lang/String;
    //   41: invokestatic 65	com/amap/api/mapcore/util/fw:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   44: aload 5
    //   46: aload_0
    //   47: getfield 38	com/amap/api/mapcore/util/in:a	Landroid/content/Context;
    //   50: invokestatic 71	com/amap/api/mapcore/util/fp:s	(Landroid/content/Context;)I
    //   53: invokestatic 75	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   56: invokestatic 65	com/amap/api/mapcore/util/fw:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   59: invokestatic 81	java/lang/System:currentTimeMillis	()J
    //   62: ldc2_w 82
    //   65: ldiv
    //   66: lstore_2
    //   67: lload_2
    //   68: l2i
    //   69: istore_1
    //   70: aload 5
    //   72: aload_0
    //   73: iload_1
    //   74: invokevirtual 86	com/amap/api/mapcore/util/in:a	(I)[B
    //   77: invokevirtual 90	java/io/ByteArrayOutputStream:write	([B)V
    //   80: aload 5
    //   82: aload_0
    //   83: aload_0
    //   84: getfield 54	com/amap/api/mapcore/util/in:e	Ljava/lang/String;
    //   87: invokevirtual 93	com/amap/api/mapcore/util/in:b	(Ljava/lang/String;)[B
    //   90: invokevirtual 90	java/io/ByteArrayOutputStream:write	([B)V
    //   93: aload 5
    //   95: aload_0
    //   96: getfield 54	com/amap/api/mapcore/util/in:e	Ljava/lang/String;
    //   99: invokestatic 95	com/amap/api/mapcore/util/fw:a	(Ljava/lang/String;)[B
    //   102: invokevirtual 90	java/io/ByteArrayOutputStream:write	([B)V
    //   105: aload 5
    //   107: invokevirtual 98	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   110: astore 4
    //   112: aload 5
    //   114: invokevirtual 101	java/io/ByteArrayOutputStream:close	()V
    //   117: aload 4
    //   119: areturn
    //   120: astore 5
    //   122: aload 5
    //   124: invokevirtual 104	java/lang/Throwable:printStackTrace	()V
    //   127: aload 4
    //   129: areturn
    //   130: astore 4
    //   132: goto +68 -> 200
    //   135: astore 6
    //   137: goto +26 -> 163
    //   140: astore 6
    //   142: aload 4
    //   144: astore 5
    //   146: aload 6
    //   148: astore 4
    //   150: goto +50 -> 200
    //   153: astore 4
    //   155: aload 6
    //   157: astore 5
    //   159: aload 4
    //   161: astore 6
    //   163: aload 5
    //   165: astore 4
    //   167: aload 6
    //   169: ldc 106
    //   171: ldc 108
    //   173: invokestatic 113	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   176: aload 5
    //   178: ifnull +18 -> 196
    //   181: aload 5
    //   183: invokevirtual 101	java/io/ByteArrayOutputStream:close	()V
    //   186: goto +10 -> 196
    //   189: astore 4
    //   191: aload 4
    //   193: invokevirtual 104	java/lang/Throwable:printStackTrace	()V
    //   196: iconst_0
    //   197: newarray <illegal type>
    //   199: areturn
    //   200: aload 5
    //   202: ifnull +18 -> 220
    //   205: aload 5
    //   207: invokevirtual 101	java/io/ByteArrayOutputStream:close	()V
    //   210: goto +10 -> 220
    //   213: astore 5
    //   215: aload 5
    //   217: invokevirtual 104	java/lang/Throwable:printStackTrace	()V
    //   220: aload 4
    //   222: athrow
    //   223: astore 4
    //   225: goto -155 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	this	in
    //   1	73	1	i	int
    //   66	2	2	l	long
    //   6	122	4	arrayOfByte	byte[]
    //   130	13	4	localObject1	Object
    //   148	1	4	localObject2	Object
    //   153	7	4	localThrowable1	Throwable
    //   165	1	4	localObject3	Object
    //   189	32	4	localThrowable2	Throwable
    //   223	1	4	localThrowable3	Throwable
    //   15	98	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   120	3	5	localThrowable4	Throwable
    //   144	62	5	localObject4	Object
    //   213	3	5	localThrowable5	Throwable
    //   3	1	6	localObject5	Object
    //   135	1	6	localThrowable6	Throwable
    //   140	16	6	localObject6	Object
    //   161	7	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   112	117	120	java/lang/Throwable
    //   17	59	130	finally
    //   59	67	130	finally
    //   70	112	130	finally
    //   17	59	135	java/lang/Throwable
    //   70	112	135	java/lang/Throwable
    //   8	17	140	finally
    //   167	176	140	finally
    //   8	17	153	java/lang/Throwable
    //   181	186	189	java/lang/Throwable
    //   205	210	213	java/lang/Throwable
    //   59	67	223	java/lang/Throwable
  }
  
  public byte[] a(int paramInt)
  {
    return new byte[] { (byte)(paramInt >> 24 & 0xFF), (byte)(paramInt >> 16 & 0xFF), (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt & 0xFF) };
  }
  
  public byte[] b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new byte[] { 0, 0 };
    }
    paramString = fw.a(this.e);
    if (paramString == null) {
      return new byte[] { 0, 0 };
    }
    int i = paramString.length;
    return new byte[] { (byte)(i / 256), (byte)(i % 256) };
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\in.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */