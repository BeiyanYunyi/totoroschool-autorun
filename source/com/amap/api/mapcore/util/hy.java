package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public abstract class hy
  extends ic
{
  protected Context d;
  protected fv e;
  
  public hy(Context paramContext, fv paramfv)
  {
    if (paramContext != null) {
      this.d = paramContext.getApplicationContext();
    }
    this.e = paramfv;
  }
  
  /* Error */
  private byte[] a()
  {
    // Byte code:
    //   0: new 30	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 31	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: ldc 33
    //   11: invokestatic 38	com/amap/api/mapcore/util/fw:a	(Ljava/lang/String;)[B
    //   14: invokevirtual 42	java/io/ByteArrayOutputStream:write	([B)V
    //   17: aload_1
    //   18: iconst_1
    //   19: newarray <illegal type>
    //   21: dup
    //   22: iconst_0
    //   23: iconst_1
    //   24: bastore
    //   25: invokevirtual 42	java/io/ByteArrayOutputStream:write	([B)V
    //   28: aload_1
    //   29: iconst_1
    //   30: newarray <illegal type>
    //   32: dup
    //   33: iconst_0
    //   34: iconst_0
    //   35: bastore
    //   36: invokevirtual 42	java/io/ByteArrayOutputStream:write	([B)V
    //   39: aload_1
    //   40: invokevirtual 45	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   43: astore_2
    //   44: aload_1
    //   45: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   48: aload_2
    //   49: areturn
    //   50: astore_1
    //   51: aload_1
    //   52: ldc 50
    //   54: ldc 52
    //   56: invokestatic 57	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload_2
    //   60: areturn
    //   61: astore_2
    //   62: goto +30 -> 92
    //   65: astore_2
    //   66: aload_2
    //   67: ldc 50
    //   69: ldc 52
    //   71: invokestatic 57	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload_1
    //   75: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   78: goto +12 -> 90
    //   81: astore_1
    //   82: aload_1
    //   83: ldc 50
    //   85: ldc 52
    //   87: invokestatic 57	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   90: aconst_null
    //   91: areturn
    //   92: aload_1
    //   93: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   96: goto +12 -> 108
    //   99: astore_1
    //   100: aload_1
    //   101: ldc 50
    //   103: ldc 52
    //   105: invokestatic 57	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   108: aload_2
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	this	hy
    //   7	38	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   50	25	1	localThrowable1	Throwable
    //   81	12	1	localThrowable2	Throwable
    //   99	2	1	localThrowable3	Throwable
    //   43	17	2	arrayOfByte	byte[]
    //   61	1	2	localObject	Object
    //   65	44	2	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   44	48	50	java/lang/Throwable
    //   8	44	61	finally
    //   66	74	61	finally
    //   8	44	65	java/lang/Throwable
    //   74	78	81	java/lang/Throwable
    //   92	96	99	java/lang/Throwable
  }
  
  /* Error */
  private byte[] k()
  {
    // Byte code:
    //   0: new 30	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 31	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: invokevirtual 60	com/amap/api/mapcore/util/hy:d	()[B
    //   12: astore_2
    //   13: aload_2
    //   14: ifnull +58 -> 72
    //   17: aload_2
    //   18: arraylength
    //   19: ifne +6 -> 25
    //   22: goto +50 -> 72
    //   25: aload_1
    //   26: iconst_1
    //   27: newarray <illegal type>
    //   29: dup
    //   30: iconst_0
    //   31: iconst_1
    //   32: bastore
    //   33: invokevirtual 42	java/io/ByteArrayOutputStream:write	([B)V
    //   36: aload_1
    //   37: aload_0
    //   38: aload_2
    //   39: invokevirtual 63	com/amap/api/mapcore/util/hy:a	([B)[B
    //   42: invokevirtual 42	java/io/ByteArrayOutputStream:write	([B)V
    //   45: aload_1
    //   46: aload_2
    //   47: invokevirtual 42	java/io/ByteArrayOutputStream:write	([B)V
    //   50: aload_1
    //   51: invokevirtual 45	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   54: astore_2
    //   55: aload_1
    //   56: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   59: aload_2
    //   60: areturn
    //   61: astore_1
    //   62: aload_1
    //   63: ldc 50
    //   65: ldc 65
    //   67: invokestatic 57	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   70: aload_2
    //   71: areturn
    //   72: aload_1
    //   73: iconst_1
    //   74: newarray <illegal type>
    //   76: dup
    //   77: iconst_0
    //   78: iconst_0
    //   79: bastore
    //   80: invokevirtual 42	java/io/ByteArrayOutputStream:write	([B)V
    //   83: aload_1
    //   84: invokevirtual 45	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   87: astore_2
    //   88: aload_1
    //   89: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   92: aload_2
    //   93: areturn
    //   94: astore_1
    //   95: aload_1
    //   96: ldc 50
    //   98: ldc 65
    //   100: invokestatic 57	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload_2
    //   104: areturn
    //   105: astore_2
    //   106: goto +36 -> 142
    //   109: astore_2
    //   110: aload_2
    //   111: ldc 50
    //   113: ldc 65
    //   115: invokestatic 57	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   118: aload_1
    //   119: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   122: goto +12 -> 134
    //   125: astore_1
    //   126: aload_1
    //   127: ldc 50
    //   129: ldc 65
    //   131: invokestatic 57	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   134: iconst_1
    //   135: newarray <illegal type>
    //   137: dup
    //   138: iconst_0
    //   139: iconst_0
    //   140: bastore
    //   141: areturn
    //   142: aload_1
    //   143: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   146: goto +12 -> 158
    //   149: astore_1
    //   150: aload_1
    //   151: ldc 50
    //   153: ldc 65
    //   155: invokestatic 57	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   158: aload_2
    //   159: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	this	hy
    //   7	49	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   61	28	1	localThrowable1	Throwable
    //   94	25	1	localThrowable2	Throwable
    //   125	18	1	localThrowable3	Throwable
    //   149	2	1	localThrowable4	Throwable
    //   12	92	2	arrayOfByte	byte[]
    //   105	1	2	localObject	Object
    //   109	50	2	localThrowable5	Throwable
    // Exception table:
    //   from	to	target	type
    //   55	59	61	java/lang/Throwable
    //   88	92	94	java/lang/Throwable
    //   8	13	105	finally
    //   17	22	105	finally
    //   25	55	105	finally
    //   72	88	105	finally
    //   110	118	105	finally
    //   8	13	109	java/lang/Throwable
    //   17	22	109	java/lang/Throwable
    //   25	55	109	java/lang/Throwable
    //   72	88	109	java/lang/Throwable
    //   118	122	125	java/lang/Throwable
    //   142	146	149	java/lang/Throwable
  }
  
  /* Error */
  private byte[] l()
  {
    // Byte code:
    //   0: new 30	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 31	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: invokevirtual 68	com/amap/api/mapcore/util/hy:e	()[B
    //   12: astore_2
    //   13: aload_2
    //   14: ifnull +67 -> 81
    //   17: aload_2
    //   18: arraylength
    //   19: ifne +6 -> 25
    //   22: goto +59 -> 81
    //   25: aload_1
    //   26: iconst_1
    //   27: newarray <illegal type>
    //   29: dup
    //   30: iconst_0
    //   31: iconst_1
    //   32: bastore
    //   33: invokevirtual 42	java/io/ByteArrayOutputStream:write	([B)V
    //   36: aload_0
    //   37: getfield 21	com/amap/api/mapcore/util/hy:d	Landroid/content/Context;
    //   40: aload_2
    //   41: invokestatic 73	com/amap/api/mapcore/util/fn:a	(Landroid/content/Context;[B)[B
    //   44: astore_2
    //   45: aload_1
    //   46: aload_0
    //   47: aload_2
    //   48: invokevirtual 63	com/amap/api/mapcore/util/hy:a	([B)[B
    //   51: invokevirtual 42	java/io/ByteArrayOutputStream:write	([B)V
    //   54: aload_1
    //   55: aload_2
    //   56: invokevirtual 42	java/io/ByteArrayOutputStream:write	([B)V
    //   59: aload_1
    //   60: invokevirtual 45	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   63: astore_2
    //   64: aload_1
    //   65: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   68: aload_2
    //   69: areturn
    //   70: astore_1
    //   71: aload_1
    //   72: ldc 50
    //   74: ldc 75
    //   76: invokestatic 57	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload_2
    //   80: areturn
    //   81: aload_1
    //   82: iconst_1
    //   83: newarray <illegal type>
    //   85: dup
    //   86: iconst_0
    //   87: iconst_0
    //   88: bastore
    //   89: invokevirtual 42	java/io/ByteArrayOutputStream:write	([B)V
    //   92: aload_1
    //   93: invokevirtual 45	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   96: astore_2
    //   97: aload_1
    //   98: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   101: aload_2
    //   102: areturn
    //   103: astore_1
    //   104: aload_1
    //   105: ldc 50
    //   107: ldc 75
    //   109: invokestatic 57	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   112: aload_2
    //   113: areturn
    //   114: astore_2
    //   115: goto +36 -> 151
    //   118: astore_2
    //   119: aload_2
    //   120: ldc 50
    //   122: ldc 75
    //   124: invokestatic 57	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   127: aload_1
    //   128: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   131: goto +12 -> 143
    //   134: astore_1
    //   135: aload_1
    //   136: ldc 50
    //   138: ldc 75
    //   140: invokestatic 57	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   143: iconst_1
    //   144: newarray <illegal type>
    //   146: dup
    //   147: iconst_0
    //   148: iconst_0
    //   149: bastore
    //   150: areturn
    //   151: aload_1
    //   152: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   155: goto +12 -> 167
    //   158: astore_1
    //   159: aload_1
    //   160: ldc 50
    //   162: ldc 75
    //   164: invokestatic 57	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   167: aload_2
    //   168: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	this	hy
    //   7	58	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   70	28	1	localThrowable1	Throwable
    //   103	25	1	localThrowable2	Throwable
    //   134	18	1	localThrowable3	Throwable
    //   158	2	1	localThrowable4	Throwable
    //   12	101	2	arrayOfByte	byte[]
    //   114	1	2	localObject	Object
    //   118	50	2	localThrowable5	Throwable
    // Exception table:
    //   from	to	target	type
    //   64	68	70	java/lang/Throwable
    //   97	101	103	java/lang/Throwable
    //   8	13	114	finally
    //   17	22	114	finally
    //   25	64	114	finally
    //   81	97	114	finally
    //   119	127	114	finally
    //   8	13	118	java/lang/Throwable
    //   17	22	118	java/lang/Throwable
    //   25	64	118	java/lang/Throwable
    //   81	97	118	java/lang/Throwable
    //   127	131	134	java/lang/Throwable
    //   151	155	158	java/lang/Throwable
  }
  
  private boolean m()
  {
    return (this.e != null) && ("navi".equals(this.e.a()));
  }
  
  protected byte[] a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    return new byte[] { (byte)(i / 256), (byte)(i % 256) };
  }
  
  public abstract byte[] d();
  
  public abstract byte[] e();
  
  protected String f()
  {
    return "2.1";
  }
  
  public boolean g()
  {
    return true;
  }
  
  /* Error */
  public final byte[] getEntityBytes()
  {
    // Byte code:
    //   0: new 30	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 31	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: aload_0
    //   10: invokespecial 97	com/amap/api/mapcore/util/hy:a	()[B
    //   13: invokevirtual 42	java/io/ByteArrayOutputStream:write	([B)V
    //   16: aload_1
    //   17: aload_0
    //   18: invokevirtual 100	com/amap/api/mapcore/util/hy:h	()[B
    //   21: invokevirtual 42	java/io/ByteArrayOutputStream:write	([B)V
    //   24: aload_1
    //   25: aload_0
    //   26: invokespecial 102	com/amap/api/mapcore/util/hy:k	()[B
    //   29: invokevirtual 42	java/io/ByteArrayOutputStream:write	([B)V
    //   32: aload_1
    //   33: aload_0
    //   34: invokespecial 104	com/amap/api/mapcore/util/hy:l	()[B
    //   37: invokevirtual 42	java/io/ByteArrayOutputStream:write	([B)V
    //   40: aload_1
    //   41: invokevirtual 45	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   44: astore_2
    //   45: aload_1
    //   46: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   49: aload_2
    //   50: areturn
    //   51: astore_1
    //   52: aload_1
    //   53: ldc 50
    //   55: ldc 106
    //   57: invokestatic 57	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   60: aload_2
    //   61: areturn
    //   62: astore_2
    //   63: goto +30 -> 93
    //   66: astore_2
    //   67: aload_2
    //   68: ldc 50
    //   70: ldc 106
    //   72: invokestatic 57	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   75: aload_1
    //   76: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   79: goto +12 -> 91
    //   82: astore_1
    //   83: aload_1
    //   84: ldc 50
    //   86: ldc 106
    //   88: invokestatic 57	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   91: aconst_null
    //   92: areturn
    //   93: aload_1
    //   94: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   97: goto +12 -> 109
    //   100: astore_1
    //   101: aload_1
    //   102: ldc 50
    //   104: ldc 106
    //   106: invokestatic 57	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   109: aload_2
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	hy
    //   7	39	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   51	25	1	localThrowable1	Throwable
    //   82	12	1	localThrowable2	Throwable
    //   100	2	1	localThrowable3	Throwable
    //   44	17	2	arrayOfByte	byte[]
    //   62	1	2	localObject	Object
    //   66	44	2	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   45	49	51	java/lang/Throwable
    //   8	45	62	finally
    //   67	75	62	finally
    //   8	45	66	java/lang/Throwable
    //   75	79	82	java/lang/Throwable
    //   93	97	100	java/lang/Throwable
  }
  
  public Map<String, String> getParams()
  {
    String str1 = fk.f(this.d);
    String str2 = fn.a();
    Object localObject1 = this.d;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("key=");
    ((StringBuilder)localObject2).append(str1);
    localObject1 = fn.a((Context)localObject1, str2, ((StringBuilder)localObject2).toString());
    localObject2 = new HashMap();
    ((Map)localObject2).put("ts", str2);
    ((Map)localObject2).put("key", str1);
    ((Map)localObject2).put("scode", localObject1);
    return (Map<String, String>)localObject2;
  }
  
  /* Error */
  public byte[] h()
  {
    // Byte code:
    //   0: new 30	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 31	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: iconst_1
    //   10: newarray <illegal type>
    //   12: dup
    //   13: iconst_0
    //   14: iconst_3
    //   15: bastore
    //   16: invokevirtual 42	java/io/ByteArrayOutputStream:write	([B)V
    //   19: aload_0
    //   20: invokevirtual 148	com/amap/api/mapcore/util/hy:g	()Z
    //   23: ifeq +36 -> 59
    //   26: aload_0
    //   27: getfield 21	com/amap/api/mapcore/util/hy:d	Landroid/content/Context;
    //   30: aload_0
    //   31: invokevirtual 151	com/amap/api/mapcore/util/hy:j	()Z
    //   34: aload_0
    //   35: invokespecial 153	com/amap/api/mapcore/util/hy:m	()Z
    //   38: invokestatic 156	com/amap/api/mapcore/util/fn:a	(Landroid/content/Context;ZZ)[B
    //   41: astore_2
    //   42: aload_1
    //   43: aload_0
    //   44: aload_2
    //   45: invokevirtual 63	com/amap/api/mapcore/util/hy:a	([B)[B
    //   48: invokevirtual 42	java/io/ByteArrayOutputStream:write	([B)V
    //   51: aload_1
    //   52: aload_2
    //   53: invokevirtual 42	java/io/ByteArrayOutputStream:write	([B)V
    //   56: goto +20 -> 76
    //   59: aload_1
    //   60: iconst_2
    //   61: newarray <illegal type>
    //   63: dup
    //   64: iconst_0
    //   65: ldc -99
    //   67: bastore
    //   68: dup
    //   69: iconst_1
    //   70: ldc -99
    //   72: bastore
    //   73: invokevirtual 42	java/io/ByteArrayOutputStream:write	([B)V
    //   76: aload_0
    //   77: invokevirtual 159	com/amap/api/mapcore/util/hy:f	()Ljava/lang/String;
    //   80: invokestatic 38	com/amap/api/mapcore/util/fw:a	(Ljava/lang/String;)[B
    //   83: astore_2
    //   84: aload_2
    //   85: ifnull +25 -> 110
    //   88: aload_2
    //   89: arraylength
    //   90: ifle +20 -> 110
    //   93: aload_1
    //   94: aload_0
    //   95: aload_2
    //   96: invokevirtual 63	com/amap/api/mapcore/util/hy:a	([B)[B
    //   99: invokevirtual 42	java/io/ByteArrayOutputStream:write	([B)V
    //   102: aload_1
    //   103: aload_2
    //   104: invokevirtual 42	java/io/ByteArrayOutputStream:write	([B)V
    //   107: goto +20 -> 127
    //   110: aload_1
    //   111: iconst_2
    //   112: newarray <illegal type>
    //   114: dup
    //   115: iconst_0
    //   116: ldc -99
    //   118: bastore
    //   119: dup
    //   120: iconst_1
    //   121: ldc -99
    //   123: bastore
    //   124: invokevirtual 42	java/io/ByteArrayOutputStream:write	([B)V
    //   127: aload_0
    //   128: invokevirtual 162	com/amap/api/mapcore/util/hy:i	()Ljava/lang/String;
    //   131: invokestatic 38	com/amap/api/mapcore/util/fw:a	(Ljava/lang/String;)[B
    //   134: astore_2
    //   135: aload_2
    //   136: ifnull +25 -> 161
    //   139: aload_2
    //   140: arraylength
    //   141: ifle +20 -> 161
    //   144: aload_1
    //   145: aload_0
    //   146: aload_2
    //   147: invokevirtual 63	com/amap/api/mapcore/util/hy:a	([B)[B
    //   150: invokevirtual 42	java/io/ByteArrayOutputStream:write	([B)V
    //   153: aload_1
    //   154: aload_2
    //   155: invokevirtual 42	java/io/ByteArrayOutputStream:write	([B)V
    //   158: goto +20 -> 178
    //   161: aload_1
    //   162: iconst_2
    //   163: newarray <illegal type>
    //   165: dup
    //   166: iconst_0
    //   167: ldc -99
    //   169: bastore
    //   170: dup
    //   171: iconst_1
    //   172: ldc -99
    //   174: bastore
    //   175: invokevirtual 42	java/io/ByteArrayOutputStream:write	([B)V
    //   178: aload_1
    //   179: invokevirtual 45	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   182: astore_2
    //   183: aload_1
    //   184: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   187: aload_2
    //   188: areturn
    //   189: astore_1
    //   190: aload_1
    //   191: ldc 50
    //   193: ldc 75
    //   195: invokestatic 57	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   198: aload_2
    //   199: areturn
    //   200: astore_2
    //   201: goto +36 -> 237
    //   204: astore_2
    //   205: aload_2
    //   206: ldc 50
    //   208: ldc -92
    //   210: invokestatic 57	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   213: aload_1
    //   214: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   217: goto +12 -> 229
    //   220: astore_1
    //   221: aload_1
    //   222: ldc 50
    //   224: ldc 75
    //   226: invokestatic 57	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   229: iconst_1
    //   230: newarray <illegal type>
    //   232: dup
    //   233: iconst_0
    //   234: iconst_0
    //   235: bastore
    //   236: areturn
    //   237: aload_1
    //   238: invokevirtual 48	java/io/ByteArrayOutputStream:close	()V
    //   241: goto +12 -> 253
    //   244: astore_1
    //   245: aload_1
    //   246: ldc 50
    //   248: ldc 75
    //   250: invokestatic 57	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   253: aload_2
    //   254: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	this	hy
    //   7	177	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   189	25	1	localThrowable1	Throwable
    //   220	18	1	localThrowable2	Throwable
    //   244	2	1	localThrowable3	Throwable
    //   41	158	2	arrayOfByte	byte[]
    //   200	1	2	localObject	Object
    //   204	50	2	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   183	187	189	java/lang/Throwable
    //   8	56	200	finally
    //   59	76	200	finally
    //   76	84	200	finally
    //   88	107	200	finally
    //   110	127	200	finally
    //   127	135	200	finally
    //   139	158	200	finally
    //   161	178	200	finally
    //   178	183	200	finally
    //   205	213	200	finally
    //   8	56	204	java/lang/Throwable
    //   59	76	204	java/lang/Throwable
    //   76	84	204	java/lang/Throwable
    //   88	107	204	java/lang/Throwable
    //   110	127	204	java/lang/Throwable
    //   127	135	204	java/lang/Throwable
    //   139	158	204	java/lang/Throwable
    //   161	178	204	java/lang/Throwable
    //   178	183	204	java/lang/Throwable
    //   213	217	220	java/lang/Throwable
    //   237	241	244	java/lang/Throwable
  }
  
  public String i()
  {
    return String.format("platform=Android&sdkversion=%s&product=%s", new Object[] { this.e.c(), this.e.a() });
  }
  
  protected boolean j()
  {
    return false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\hy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */