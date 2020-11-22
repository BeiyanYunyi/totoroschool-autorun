package com.pgyersdk.f;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class i
{
  private static final char[] a = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
  private boolean b;
  private boolean c;
  private ByteArrayOutputStream d;
  private String e;
  
  public i()
  {
    int i = 0;
    this.c = false;
    this.b = false;
    this.d = new ByteArrayOutputStream();
    StringBuffer localStringBuffer = new StringBuffer();
    Random localRandom = new Random();
    while (i < 30)
    {
      char[] arrayOfChar = a;
      localStringBuffer.append(arrayOfChar[localRandom.nextInt(arrayOfChar.length)]);
      i += 1;
    }
    this.e = localStringBuffer.toString();
  }
  
  public String a()
  {
    return this.e;
  }
  
  public void a(String paramString1, String paramString2)
    throws IOException
  {
    d();
    ByteArrayOutputStream localByteArrayOutputStream = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Content-Disposition: form-data; name=\"");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("\"\r\n");
    localByteArrayOutputStream.write(localStringBuilder.toString().getBytes());
    this.d.write("Content-Type: text/plain; charset=UTF-8\r\n".getBytes());
    this.d.write("Content-Transfer-Encoding: 8bit\r\n\r\n".getBytes());
    if (paramString2 != null) {
      this.d.write(paramString2.getBytes());
    } else {
      this.d.write("".getBytes());
    }
    paramString1 = this.d;
    paramString2 = new StringBuilder();
    paramString2.append("\r\n--");
    paramString2.append(this.e);
    paramString2.append("\r\n");
    paramString1.write(paramString2.toString().getBytes());
  }
  
  /* Error */
  public void a(String paramString1, String paramString2, InputStream paramInputStream, String paramString3, boolean paramBoolean)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 63	com/pgyersdk/f/i:d	()V
    //   4: new 65	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   11: astore 7
    //   13: aload 7
    //   15: ldc 96
    //   17: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload 7
    //   23: aload 4
    //   25: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload 7
    //   31: ldc 92
    //   33: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 7
    //   39: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: astore 4
    //   44: aload_0
    //   45: getfield 38	com/pgyersdk/f/i:d	Ljava/io/ByteArrayOutputStream;
    //   48: astore 7
    //   50: new 65	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   57: astore 8
    //   59: aload 8
    //   61: ldc 68
    //   63: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload 8
    //   69: aload_1
    //   70: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload 8
    //   76: ldc 98
    //   78: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 8
    //   84: aload_2
    //   85: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload 8
    //   91: ldc 73
    //   93: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload 7
    //   99: aload 8
    //   101: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokevirtual 78	java/lang/String:getBytes	()[B
    //   107: invokevirtual 82	java/io/ByteArrayOutputStream:write	([B)V
    //   110: aload_0
    //   111: getfield 38	com/pgyersdk/f/i:d	Ljava/io/ByteArrayOutputStream;
    //   114: aload 4
    //   116: invokevirtual 78	java/lang/String:getBytes	()[B
    //   119: invokevirtual 82	java/io/ByteArrayOutputStream:write	([B)V
    //   122: aload_0
    //   123: getfield 38	com/pgyersdk/f/i:d	Ljava/io/ByteArrayOutputStream;
    //   126: astore_1
    //   127: aload_1
    //   128: ldc 100
    //   130: invokevirtual 78	java/lang/String:getBytes	()[B
    //   133: invokevirtual 82	java/io/ByteArrayOutputStream:write	([B)V
    //   136: sipush 4096
    //   139: newarray <illegal type>
    //   141: astore_1
    //   142: aload_3
    //   143: aload_1
    //   144: invokevirtual 106	java/io/InputStream:read	([B)I
    //   147: istore 6
    //   149: iload 6
    //   151: iconst_m1
    //   152: if_icmpeq +17 -> 169
    //   155: aload_0
    //   156: getfield 38	com/pgyersdk/f/i:d	Ljava/io/ByteArrayOutputStream;
    //   159: aload_1
    //   160: iconst_0
    //   161: iload 6
    //   163: invokevirtual 109	java/io/ByteArrayOutputStream:write	([BII)V
    //   166: goto -24 -> 142
    //   169: aload_0
    //   170: getfield 38	com/pgyersdk/f/i:d	Ljava/io/ByteArrayOutputStream;
    //   173: invokevirtual 112	java/io/ByteArrayOutputStream:flush	()V
    //   176: iload 5
    //   178: ifeq +10 -> 188
    //   181: aload_0
    //   182: invokevirtual 114	com/pgyersdk/f/i:e	()V
    //   185: goto +50 -> 235
    //   188: aload_0
    //   189: getfield 38	com/pgyersdk/f/i:d	Ljava/io/ByteArrayOutputStream;
    //   192: astore_1
    //   193: new 65	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   200: astore_2
    //   201: aload_2
    //   202: ldc 90
    //   204: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload_2
    //   209: aload_0
    //   210: getfield 58	com/pgyersdk/f/i:e	Ljava/lang/String;
    //   213: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload_2
    //   218: ldc 92
    //   220: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload_1
    //   225: aload_2
    //   226: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokevirtual 78	java/lang/String:getBytes	()[B
    //   232: invokevirtual 82	java/io/ByteArrayOutputStream:write	([B)V
    //   235: aload_3
    //   236: invokevirtual 117	java/io/InputStream:close	()V
    //   239: return
    //   240: astore_1
    //   241: aload_1
    //   242: invokevirtual 120	java/io/IOException:printStackTrace	()V
    //   245: return
    //   246: astore_1
    //   247: aload_3
    //   248: invokevirtual 117	java/io/InputStream:close	()V
    //   251: goto +8 -> 259
    //   254: astore_2
    //   255: aload_2
    //   256: invokevirtual 120	java/io/IOException:printStackTrace	()V
    //   259: aload_1
    //   260: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	this	i
    //   0	261	1	paramString1	String
    //   0	261	2	paramString2	String
    //   0	261	3	paramInputStream	InputStream
    //   0	261	4	paramString3	String
    //   0	261	5	paramBoolean	boolean
    //   147	15	6	i	int
    //   11	87	7	localObject	Object
    //   57	43	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   235	239	240	java/io/IOException
    //   4	13	246	finally
    //   13	29	246	finally
    //   29	59	246	finally
    //   59	74	246	finally
    //   74	89	246	finally
    //   89	127	246	finally
    //   127	142	246	finally
    //   142	149	246	finally
    //   155	166	246	finally
    //   169	176	246	finally
    //   181	185	246	finally
    //   188	201	246	finally
    //   201	217	246	finally
    //   217	235	246	finally
    //   247	251	254	java/io/IOException
  }
  
  public void a(String paramString1, String paramString2, InputStream paramInputStream, boolean paramBoolean)
    throws IOException
  {
    a(paramString1, paramString2, paramInputStream, "application/octet-stream", paramBoolean);
  }
  
  public long b()
  {
    e();
    return this.d.toByteArray().length;
  }
  
  public ByteArrayOutputStream c()
  {
    e();
    return this.d;
  }
  
  public void d()
    throws IOException
  {
    if (!this.c)
    {
      ByteArrayOutputStream localByteArrayOutputStream = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--");
      localStringBuilder.append(this.e);
      localStringBuilder.append("\r\n");
      localByteArrayOutputStream.write(localStringBuilder.toString().getBytes());
    }
    this.c = true;
  }
  
  public void e()
  {
    if (this.b) {
      return;
    }
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("\r\n--");
      localStringBuilder.append(this.e);
      localStringBuilder.append("--\r\n");
      localByteArrayOutputStream.write(localStringBuilder.toString().getBytes());
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    this.b = true;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\f\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */