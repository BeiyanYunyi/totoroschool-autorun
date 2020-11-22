package com.loc;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;

public final class dc
  extends bk
{
  Map<String, String> f = null;
  String g = "";
  byte[] h = null;
  byte[] i = null;
  boolean j = false;
  String k = null;
  Map<String, String> l = null;
  boolean m = false;
  private String n = "";
  
  public dc(Context paramContext, v paramv)
  {
    super(paramContext, paramv);
  }
  
  public final void a(String paramString)
  {
    this.g = paramString;
  }
  
  public final byte[] a_()
  {
    return this.h;
  }
  
  public final Map<String, String> b()
  {
    return this.f;
  }
  
  public final void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.n = paramString;
      return;
    }
    this.n = "";
  }
  
  /* Error */
  public final void b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: new 64	java/io/ByteArrayOutputStream
    //   8: dup
    //   9: invokespecial 67	java/io/ByteArrayOutputStream:<init>	()V
    //   12: astore_3
    //   13: aload_1
    //   14: ifnull +19 -> 33
    //   17: aload_3
    //   18: aload_1
    //   19: invokestatic 70	com/loc/dc:a	([B)[B
    //   22: invokevirtual 73	java/io/ByteArrayOutputStream:write	([B)V
    //   25: aload_3
    //   26: aload_1
    //   27: invokevirtual 73	java/io/ByteArrayOutputStream:write	([B)V
    //   30: goto +3 -> 33
    //   33: aload_0
    //   34: aload_3
    //   35: invokevirtual 76	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   38: putfield 34	com/loc/dc:i	[B
    //   41: aload_3
    //   42: invokevirtual 79	java/io/ByteArrayOutputStream:close	()V
    //   45: return
    //   46: astore_1
    //   47: aload_1
    //   48: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   51: return
    //   52: astore_1
    //   53: aload_2
    //   54: astore_3
    //   55: goto +28 -> 83
    //   58: astore_3
    //   59: aload 4
    //   61: astore_1
    //   62: aload_1
    //   63: astore_2
    //   64: aload_3
    //   65: invokevirtual 83	java/lang/Throwable:printStackTrace	()V
    //   68: aload_1
    //   69: ifnull +13 -> 82
    //   72: aload_1
    //   73: invokevirtual 79	java/io/ByteArrayOutputStream:close	()V
    //   76: return
    //   77: astore_1
    //   78: aload_1
    //   79: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   82: return
    //   83: aload_3
    //   84: ifnull +15 -> 99
    //   87: aload_3
    //   88: invokevirtual 79	java/io/ByteArrayOutputStream:close	()V
    //   91: goto +8 -> 99
    //   94: astore_2
    //   95: aload_2
    //   96: invokevirtual 82	java/io/IOException:printStackTrace	()V
    //   99: aload_1
    //   100: athrow
    //   101: astore_1
    //   102: goto -19 -> 83
    //   105: astore_2
    //   106: aload_3
    //   107: astore_1
    //   108: aload_2
    //   109: astore_3
    //   110: goto -48 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	dc
    //   0	113	1	paramArrayOfByte	byte[]
    //   4	60	2	arrayOfByte	byte[]
    //   94	2	2	localIOException	java.io.IOException
    //   105	4	2	localThrowable1	Throwable
    //   12	43	3	localObject1	Object
    //   58	49	3	localThrowable2	Throwable
    //   109	1	3	localThrowable3	Throwable
    //   1	59	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   41	45	46	java/io/IOException
    //   5	13	52	finally
    //   64	68	52	finally
    //   5	13	58	java/lang/Throwable
    //   72	76	77	java/io/IOException
    //   87	91	94	java/io/IOException
    //   17	30	101	finally
    //   33	41	101	finally
    //   17	30	105	java/lang/Throwable
    //   33	41	105	java/lang/Throwable
  }
  
  public final Map<String, String> b_()
  {
    return this.l;
  }
  
  public final String c()
  {
    return this.g;
  }
  
  public final byte[] e()
  {
    return this.i;
  }
  
  public final boolean g()
  {
    return this.j;
  }
  
  public final String h()
  {
    return this.k;
  }
  
  protected final boolean i()
  {
    return this.m;
  }
  
  protected final String j()
  {
    return this.n;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\dc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */