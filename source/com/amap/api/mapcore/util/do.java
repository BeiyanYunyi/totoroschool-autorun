package com.amap.api.mapcore.util;

public class do
{
  private static boolean a = false;
  private static boolean b = false;
  private static boolean c = false;
  private boolean d = false;
  private int e = 0;
  private int f = 20;
  
  public static void a(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  public static boolean a()
  {
    return a;
  }
  
  public static void b(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  public static boolean b()
  {
    return b;
  }
  
  public static void c(boolean paramBoolean)
  {
    c = paramBoolean;
  }
  
  public static boolean c()
  {
    return c;
  }
  
  /* Error */
  public boolean a(android.graphics.Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +154 -> 155
    //   4: aload_1
    //   5: invokevirtual 42	android/graphics/Bitmap:getWidth	()I
    //   8: istore 7
    //   10: aload_1
    //   11: invokevirtual 45	android/graphics/Bitmap:getHeight	()I
    //   14: istore 8
    //   16: iload 7
    //   18: i2f
    //   19: ldc 46
    //   21: fdiv
    //   22: f2i
    //   23: istore_2
    //   24: iconst_m1
    //   25: istore_3
    //   26: iload_2
    //   27: i2f
    //   28: iload 7
    //   30: iconst_3
    //   31: imul
    //   32: i2f
    //   33: ldc 46
    //   35: fdiv
    //   36: fcmpg
    //   37: ifge +118 -> 155
    //   40: iload 8
    //   42: i2f
    //   43: ldc 46
    //   45: fdiv
    //   46: f2i
    //   47: istore 4
    //   49: iload 4
    //   51: i2f
    //   52: iload 8
    //   54: iconst_3
    //   55: imul
    //   56: i2f
    //   57: ldc 46
    //   59: fdiv
    //   60: fcmpg
    //   61: ifge +64 -> 125
    //   64: aload_1
    //   65: iload_2
    //   66: iload 4
    //   68: invokevirtual 50	android/graphics/Bitmap:getPixel	(II)I
    //   71: istore 6
    //   73: iload_3
    //   74: istore 5
    //   76: iload_3
    //   77: iconst_m1
    //   78: if_icmpne +7 -> 85
    //   81: iload 6
    //   83: istore 5
    //   85: iload 6
    //   87: iload 5
    //   89: if_icmpeq +10 -> 99
    //   92: aload_0
    //   93: iconst_1
    //   94: putfield 21	com/amap/api/mapcore/util/do:d	Z
    //   97: iconst_0
    //   98: ireturn
    //   99: iload 6
    //   101: ldc 51
    //   103: if_icmpeq +10 -> 113
    //   106: aload_0
    //   107: iconst_1
    //   108: putfield 21	com/amap/api/mapcore/util/do:d	Z
    //   111: iconst_0
    //   112: ireturn
    //   113: iload 4
    //   115: iconst_1
    //   116: iadd
    //   117: istore 4
    //   119: iload 5
    //   121: istore_3
    //   122: goto -73 -> 49
    //   125: iload_2
    //   126: iconst_1
    //   127: iadd
    //   128: istore_2
    //   129: goto -103 -> 26
    //   132: astore_1
    //   133: goto +15 -> 148
    //   136: astore_1
    //   137: aload_1
    //   138: ldc 53
    //   140: ldc 55
    //   142: invokestatic 60	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   145: goto +10 -> 155
    //   148: aload_0
    //   149: iconst_1
    //   150: putfield 21	com/amap/api/mapcore/util/do:d	Z
    //   153: aload_1
    //   154: athrow
    //   155: aload_0
    //   156: iconst_1
    //   157: putfield 21	com/amap/api/mapcore/util/do:d	Z
    //   160: iconst_1
    //   161: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	this	do
    //   0	162	1	paramBitmap	android.graphics.Bitmap
    //   23	106	2	i	int
    //   25	97	3	j	int
    //   47	71	4	k	int
    //   74	46	5	m	int
    //   71	33	6	n	int
    //   8	24	7	i1	int
    //   14	42	8	i2	int
    // Exception table:
    //   from	to	target	type
    //   4	24	132	finally
    //   26	49	132	finally
    //   49	73	132	finally
    //   137	145	132	finally
    //   4	24	136	java/lang/Throwable
    //   26	49	136	java/lang/Throwable
    //   49	73	136	java/lang/Throwable
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  public void e()
  {
    this.e += 1;
  }
  
  public boolean f()
  {
    return this.e >= this.f;
  }
  
  public void g()
  {
    gk.c(new Exception("BlackScreen"), "PureScreenCheckTool", "uploadInfo");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\do.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */