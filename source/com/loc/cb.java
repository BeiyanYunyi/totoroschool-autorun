package com.loc;

import android.content.Context;

public final class cb
  extends cd
{
  public static int a = 13;
  public static int b = 6;
  private Context e;
  
  public cb(Context paramContext, cd paramcd)
  {
    super(paramcd);
    this.e = paramContext;
  }
  
  /* Error */
  private static byte[] a(Context paramContext)
  {
    // Byte code:
    //   0: new 26	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 28	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: new 30	java/lang/StringBuilder
    //   11: dup
    //   12: ldc 32
    //   14: invokespecial 35	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   17: astore_2
    //   18: aload_2
    //   19: getstatic 37	com/loc/cb:a	I
    //   22: invokevirtual 41	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload_2
    //   27: ldc 43
    //   29: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload_2
    //   34: getstatic 48	com/loc/cb:b	I
    //   37: invokevirtual 41	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_1
    //   42: aload_2
    //   43: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 57	com/loc/w:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   49: aload_1
    //   50: ldc 59
    //   52: invokestatic 57	com/loc/w:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   55: aload_1
    //   56: aload_0
    //   57: invokestatic 65	com/loc/p:w	(Landroid/content/Context;)Ljava/lang/String;
    //   60: invokestatic 57	com/loc/w:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   63: aload_1
    //   64: aload_0
    //   65: invokestatic 68	com/loc/p:n	(Landroid/content/Context;)Ljava/lang/String;
    //   68: invokestatic 57	com/loc/w:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   71: aload_1
    //   72: aload_0
    //   73: invokestatic 71	com/loc/p:i	(Landroid/content/Context;)Ljava/lang/String;
    //   76: invokestatic 57	com/loc/w:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   79: aload_1
    //   80: getstatic 77	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   83: invokestatic 57	com/loc/w:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   86: aload_1
    //   87: getstatic 80	android/os/Build:MODEL	Ljava/lang/String;
    //   90: invokestatic 57	com/loc/w:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   93: aload_1
    //   94: getstatic 83	android/os/Build:DEVICE	Ljava/lang/String;
    //   97: invokestatic 57	com/loc/w:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   100: aload_1
    //   101: aload_0
    //   102: invokestatic 86	com/loc/p:z	(Landroid/content/Context;)Ljava/lang/String;
    //   105: invokestatic 57	com/loc/w:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   108: aload_1
    //   109: aload_0
    //   110: invokestatic 91	com/loc/l:c	(Landroid/content/Context;)Ljava/lang/String;
    //   113: invokestatic 57	com/loc/w:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   116: aload_1
    //   117: aload_0
    //   118: invokestatic 94	com/loc/l:d	(Landroid/content/Context;)Ljava/lang/String;
    //   121: invokestatic 57	com/loc/w:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   124: aload_1
    //   125: aload_0
    //   126: invokestatic 97	com/loc/l:f	(Landroid/content/Context;)Ljava/lang/String;
    //   129: invokestatic 57	com/loc/w:a	(Ljava/io/ByteArrayOutputStream;Ljava/lang/String;)V
    //   132: aload_1
    //   133: iconst_1
    //   134: newarray <illegal type>
    //   136: dup
    //   137: iconst_0
    //   138: iconst_0
    //   139: bastore
    //   140: invokevirtual 101	java/io/ByteArrayOutputStream:write	([B)V
    //   143: aload_1
    //   144: invokevirtual 105	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   147: astore_0
    //   148: aload_1
    //   149: invokevirtual 108	java/io/ByteArrayOutputStream:close	()V
    //   152: aload_0
    //   153: areturn
    //   154: astore_1
    //   155: aload_1
    //   156: invokevirtual 111	java/lang/Throwable:printStackTrace	()V
    //   159: aload_0
    //   160: areturn
    //   161: astore_0
    //   162: goto +28 -> 190
    //   165: astore_0
    //   166: aload_0
    //   167: ldc 113
    //   169: ldc 115
    //   171: invokestatic 120	com/loc/aj:b	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   174: aload_1
    //   175: invokevirtual 108	java/io/ByteArrayOutputStream:close	()V
    //   178: goto +8 -> 186
    //   181: astore_0
    //   182: aload_0
    //   183: invokevirtual 111	java/lang/Throwable:printStackTrace	()V
    //   186: iconst_0
    //   187: newarray <illegal type>
    //   189: areturn
    //   190: aload_1
    //   191: invokevirtual 108	java/io/ByteArrayOutputStream:close	()V
    //   194: goto +8 -> 202
    //   197: astore_1
    //   198: aload_1
    //   199: invokevirtual 111	java/lang/Throwable:printStackTrace	()V
    //   202: aload_0
    //   203: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	paramContext	Context
    //   7	142	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   154	37	1	localThrowable1	Throwable
    //   197	2	1	localThrowable2	Throwable
    //   17	26	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   148	152	154	java/lang/Throwable
    //   8	148	161	finally
    //   166	174	161	finally
    //   8	148	165	java/lang/Throwable
    //   174	178	181	java/lang/Throwable
    //   190	194	197	java/lang/Throwable
  }
  
  protected final byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = a(this.e);
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + paramArrayOfByte.length];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, arrayOfByte1.length, paramArrayOfByte.length);
    return arrayOfByte2;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\cb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */