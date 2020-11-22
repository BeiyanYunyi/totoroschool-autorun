package com.amap.api.mapcore.util;

import android.content.Context;

public class iu
  extends iw
{
  public static int a = 13;
  public static int b = 6;
  private Context e;
  
  public iu(Context paramContext, iw paramiw)
  {
    super(paramiw);
    this.e = paramContext;
  }
  
  /* Error */
  private byte[] a(Context paramContext)
  {
    // Byte code:
    //   0: new 26	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 28	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_2
    //   8: new 30	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   15: astore_3
    //   16: aload_3
    //   17: ldc 33
    //   19: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload_3
    //   24: getstatic 39	com/amap/api/mapcore/util/iu:a	I
    //   27: invokevirtual 42	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload_3
    //   32: ldc 44
    //   34: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_3
    //   39: getstatic 46	com/amap/api/mapcore/util/iu:b	I
    //   42: invokevirtual 42	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_2
    //   47: aload_3
    //   48: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 55	com/amap/api/mapcore/util/fw:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   54: aload_2
    //   55: ldc 57
    //   57: invokestatic 55	com/amap/api/mapcore/util/fw:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   60: aload_2
    //   61: aload_1
    //   62: invokestatic 63	com/amap/api/mapcore/util/fp:w	(Landroid/content/Context;)Ljava/lang/String;
    //   65: invokestatic 55	com/amap/api/mapcore/util/fw:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   68: aload_2
    //   69: aload_1
    //   70: invokestatic 66	com/amap/api/mapcore/util/fp:n	(Landroid/content/Context;)Ljava/lang/String;
    //   73: invokestatic 55	com/amap/api/mapcore/util/fw:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   76: aload_2
    //   77: aload_1
    //   78: invokestatic 69	com/amap/api/mapcore/util/fp:i	(Landroid/content/Context;)Ljava/lang/String;
    //   81: invokestatic 55	com/amap/api/mapcore/util/fw:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   84: aload_2
    //   85: getstatic 75	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   88: invokestatic 55	com/amap/api/mapcore/util/fw:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   91: aload_2
    //   92: getstatic 78	android/os/Build:MODEL	Ljava/lang/String;
    //   95: invokestatic 55	com/amap/api/mapcore/util/fw:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   98: aload_2
    //   99: getstatic 81	android/os/Build:DEVICE	Ljava/lang/String;
    //   102: invokestatic 55	com/amap/api/mapcore/util/fw:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   105: aload_2
    //   106: aload_1
    //   107: invokestatic 84	com/amap/api/mapcore/util/fp:y	(Landroid/content/Context;)Ljava/lang/String;
    //   110: invokestatic 55	com/amap/api/mapcore/util/fw:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   113: aload_2
    //   114: aload_1
    //   115: invokestatic 89	com/amap/api/mapcore/util/fk:c	(Landroid/content/Context;)Ljava/lang/String;
    //   118: invokestatic 55	com/amap/api/mapcore/util/fw:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   121: aload_2
    //   122: aload_1
    //   123: invokestatic 92	com/amap/api/mapcore/util/fk:d	(Landroid/content/Context;)Ljava/lang/String;
    //   126: invokestatic 55	com/amap/api/mapcore/util/fw:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   129: aload_2
    //   130: aload_1
    //   131: invokestatic 95	com/amap/api/mapcore/util/fk:f	(Landroid/content/Context;)Ljava/lang/String;
    //   134: invokestatic 55	com/amap/api/mapcore/util/fw:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   137: aload_2
    //   138: iconst_1
    //   139: newarray <illegal type>
    //   141: dup
    //   142: iconst_0
    //   143: iconst_0
    //   144: bastore
    //   145: invokevirtual 99	java/io/ByteArrayOutputStream:write	([B)V
    //   148: aload_2
    //   149: invokevirtual 103	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   152: astore_1
    //   153: aload_2
    //   154: invokevirtual 106	java/io/ByteArrayOutputStream:close	()V
    //   157: aload_1
    //   158: areturn
    //   159: astore_2
    //   160: aload_2
    //   161: invokevirtual 109	java/lang/Throwable:printStackTrace	()V
    //   164: aload_1
    //   165: areturn
    //   166: astore_1
    //   167: goto +28 -> 195
    //   170: astore_1
    //   171: aload_1
    //   172: ldc 111
    //   174: ldc 113
    //   176: invokestatic 118	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   179: aload_2
    //   180: invokevirtual 106	java/io/ByteArrayOutputStream:close	()V
    //   183: goto +8 -> 191
    //   186: astore_1
    //   187: aload_1
    //   188: invokevirtual 109	java/lang/Throwable:printStackTrace	()V
    //   191: iconst_0
    //   192: newarray <illegal type>
    //   194: areturn
    //   195: aload_2
    //   196: invokevirtual 106	java/io/ByteArrayOutputStream:close	()V
    //   199: goto +8 -> 207
    //   202: astore_2
    //   203: aload_2
    //   204: invokevirtual 109	java/lang/Throwable:printStackTrace	()V
    //   207: aload_1
    //   208: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	this	iu
    //   0	209	1	paramContext	Context
    //   7	147	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   159	37	2	localThrowable1	Throwable
    //   202	2	2	localThrowable2	Throwable
    //   15	33	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   153	157	159	java/lang/Throwable
    //   8	153	166	finally
    //   171	179	166	finally
    //   8	153	170	java/lang/Throwable
    //   179	183	186	java/lang/Throwable
    //   195	199	202	java/lang/Throwable
  }
  
  protected byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = a(this.e);
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + paramArrayOfByte.length];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, arrayOfByte1.length, paramArrayOfByte.length);
    return arrayOfByte2;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\iu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */