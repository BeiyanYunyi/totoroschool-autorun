package com.loc;

import android.content.Context;
import android.text.TextUtils;

public final class bu
{
  private Context a;
  private String b;
  private String c;
  private String d;
  private String e;
  
  public bu(Context paramContext, String paramString1, String paramString2, String paramString3)
    throws k
  {
    if ((!TextUtils.isEmpty(paramString3)) && (paramString3.length() <= 256))
    {
      this.a = paramContext.getApplicationContext();
      this.c = paramString1;
      this.d = paramString2;
      this.b = paramString3;
      return;
    }
    throw new k("无效的参数 - IllegalArgumentException");
  }
  
  public final void a(String paramString)
    throws k
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.length() <= 65536))
    {
      this.e = paramString;
      return;
    }
    throw new k("无效的参数 - IllegalArgumentException");
  }
  
  /* Error */
  public final byte[] a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: new 59	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 60	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore 5
    //   15: aload 5
    //   17: aload_0
    //   18: getfield 40	com/loc/bu:c	Ljava/lang/String;
    //   21: invokestatic 65	com/loc/w:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   24: aload 5
    //   26: aload_0
    //   27: getfield 42	com/loc/bu:d	Ljava/lang/String;
    //   30: invokestatic 65	com/loc/w:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   33: aload 5
    //   35: aload_0
    //   36: getfield 44	com/loc/bu:b	Ljava/lang/String;
    //   39: invokestatic 65	com/loc/w:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   42: aload 5
    //   44: aload_0
    //   45: getfield 38	com/loc/bu:a	Landroid/content/Context;
    //   48: invokestatic 71	com/loc/p:s	(Landroid/content/Context;)I
    //   51: invokestatic 75	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   54: invokestatic 65	com/loc/w:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   57: invokestatic 81	java/lang/System:currentTimeMillis	()J
    //   60: ldc2_w 82
    //   63: ldiv
    //   64: lstore_2
    //   65: lload_2
    //   66: l2i
    //   67: istore_1
    //   68: goto +5 -> 73
    //   71: iconst_0
    //   72: istore_1
    //   73: aload 5
    //   75: iconst_4
    //   76: newarray <illegal type>
    //   78: dup
    //   79: iconst_0
    //   80: iload_1
    //   81: bipush 24
    //   83: ishr
    //   84: sipush 255
    //   87: iand
    //   88: i2b
    //   89: bastore
    //   90: dup
    //   91: iconst_1
    //   92: iload_1
    //   93: bipush 16
    //   95: ishr
    //   96: sipush 255
    //   99: iand
    //   100: i2b
    //   101: bastore
    //   102: dup
    //   103: iconst_2
    //   104: iload_1
    //   105: bipush 8
    //   107: ishr
    //   108: sipush 255
    //   111: iand
    //   112: i2b
    //   113: bastore
    //   114: dup
    //   115: iconst_3
    //   116: iload_1
    //   117: sipush 255
    //   120: iand
    //   121: i2b
    //   122: bastore
    //   123: invokevirtual 87	java/io/ByteArrayOutputStream:write	([B)V
    //   126: aload_0
    //   127: getfield 54	com/loc/bu:e	Ljava/lang/String;
    //   130: invokestatic 24	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   133: ifeq +24 -> 157
    //   136: iconst_2
    //   137: newarray <illegal type>
    //   139: astore 4
    //   141: aload 4
    //   143: dup
    //   144: iconst_0
    //   145: ldc 88
    //   147: bastore
    //   148: dup
    //   149: iconst_1
    //   150: ldc 88
    //   152: bastore
    //   153: pop
    //   154: goto +47 -> 201
    //   157: aload_0
    //   158: getfield 54	com/loc/bu:e	Ljava/lang/String;
    //   161: invokestatic 91	com/loc/w:a	(Ljava/lang/String;)[B
    //   164: astore 4
    //   166: aload 4
    //   168: ifnonnull +6 -> 174
    //   171: goto -35 -> 136
    //   174: aload 4
    //   176: arraylength
    //   177: istore_1
    //   178: iconst_2
    //   179: newarray <illegal type>
    //   181: dup
    //   182: iconst_0
    //   183: iload_1
    //   184: sipush 256
    //   187: idiv
    //   188: i2b
    //   189: bastore
    //   190: dup
    //   191: iconst_1
    //   192: iload_1
    //   193: sipush 256
    //   196: irem
    //   197: i2b
    //   198: bastore
    //   199: astore 4
    //   201: aload 5
    //   203: aload 4
    //   205: invokevirtual 87	java/io/ByteArrayOutputStream:write	([B)V
    //   208: aload 5
    //   210: aload_0
    //   211: getfield 54	com/loc/bu:e	Ljava/lang/String;
    //   214: invokestatic 91	com/loc/w:a	(Ljava/lang/String;)[B
    //   217: invokevirtual 87	java/io/ByteArrayOutputStream:write	([B)V
    //   220: aload 5
    //   222: invokevirtual 94	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   225: astore 4
    //   227: aload 5
    //   229: invokevirtual 97	java/io/ByteArrayOutputStream:close	()V
    //   232: aload 4
    //   234: areturn
    //   235: astore 5
    //   237: aload 5
    //   239: invokevirtual 100	java/lang/Throwable:printStackTrace	()V
    //   242: aload 4
    //   244: areturn
    //   245: astore 4
    //   247: goto +68 -> 315
    //   250: astore 6
    //   252: goto +26 -> 278
    //   255: astore 6
    //   257: aload 4
    //   259: astore 5
    //   261: aload 6
    //   263: astore 4
    //   265: goto +50 -> 315
    //   268: astore 4
    //   270: aload 6
    //   272: astore 5
    //   274: aload 4
    //   276: astore 6
    //   278: aload 5
    //   280: astore 4
    //   282: aload 6
    //   284: ldc 102
    //   286: ldc 104
    //   288: invokestatic 109	com/loc/aj:b	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   291: aload 5
    //   293: ifnull +18 -> 311
    //   296: aload 5
    //   298: invokevirtual 97	java/io/ByteArrayOutputStream:close	()V
    //   301: goto +10 -> 311
    //   304: astore 4
    //   306: aload 4
    //   308: invokevirtual 100	java/lang/Throwable:printStackTrace	()V
    //   311: iconst_0
    //   312: newarray <illegal type>
    //   314: areturn
    //   315: aload 5
    //   317: ifnull +18 -> 335
    //   320: aload 5
    //   322: invokevirtual 97	java/io/ByteArrayOutputStream:close	()V
    //   325: goto +10 -> 335
    //   328: astore 5
    //   330: aload 5
    //   332: invokevirtual 100	java/lang/Throwable:printStackTrace	()V
    //   335: aload 4
    //   337: athrow
    //   338: astore 4
    //   340: goto -269 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	this	bu
    //   67	130	1	i	int
    //   64	2	2	l	long
    //   4	239	4	arrayOfByte	byte[]
    //   245	13	4	localObject1	Object
    //   263	1	4	localObject2	Object
    //   268	7	4	localThrowable1	Throwable
    //   280	1	4	localObject3	Object
    //   304	32	4	localThrowable2	Throwable
    //   338	1	4	localThrowable3	Throwable
    //   13	215	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   235	3	5	localThrowable4	Throwable
    //   259	62	5	localObject4	Object
    //   328	3	5	localThrowable5	Throwable
    //   1	1	6	localObject5	Object
    //   250	1	6	localThrowable6	Throwable
    //   255	16	6	localObject6	Object
    //   276	7	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   227	232	235	java/lang/Throwable
    //   15	57	245	finally
    //   57	65	245	finally
    //   73	136	245	finally
    //   136	154	245	finally
    //   157	166	245	finally
    //   174	201	245	finally
    //   201	227	245	finally
    //   15	57	250	java/lang/Throwable
    //   73	136	250	java/lang/Throwable
    //   136	154	250	java/lang/Throwable
    //   157	166	250	java/lang/Throwable
    //   174	201	250	java/lang/Throwable
    //   201	227	250	java/lang/Throwable
    //   6	15	255	finally
    //   282	291	255	finally
    //   6	15	268	java/lang/Throwable
    //   296	301	304	java/lang/Throwable
    //   320	325	328	java/lang/Throwable
    //   57	65	338	java/lang/Throwable
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */