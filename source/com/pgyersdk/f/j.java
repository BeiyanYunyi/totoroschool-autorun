package com.pgyersdk.f;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;

public class j
{
  /* Error */
  public static String a(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 10	java/io/BufferedReader
    //   3: dup
    //   4: new 12	java/io/InputStreamReader
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 16	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   12: sipush 1024
    //   15: invokespecial 19	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   18: astore_2
    //   19: new 21	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   26: astore_1
    //   27: aload_2
    //   28: invokevirtual 28	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   31: astore_3
    //   32: aload_3
    //   33: ifnull +40 -> 73
    //   36: new 21	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   43: astore 4
    //   45: aload 4
    //   47: aload_3
    //   48: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload 4
    //   54: ldc 34
    //   56: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload_1
    //   61: aload 4
    //   63: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: goto -43 -> 27
    //   73: aload_0
    //   74: invokevirtual 42	java/io/InputStream:close	()V
    //   77: goto +27 -> 104
    //   80: astore_0
    //   81: goto +19 -> 100
    //   84: astore_1
    //   85: goto +24 -> 109
    //   88: astore_2
    //   89: aload_2
    //   90: invokevirtual 45	java/io/IOException:printStackTrace	()V
    //   93: aload_0
    //   94: invokevirtual 42	java/io/InputStream:close	()V
    //   97: goto +7 -> 104
    //   100: aload_0
    //   101: invokevirtual 45	java/io/IOException:printStackTrace	()V
    //   104: aload_1
    //   105: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: areturn
    //   109: aload_0
    //   110: invokevirtual 42	java/io/InputStream:close	()V
    //   113: goto +8 -> 121
    //   116: astore_0
    //   117: aload_0
    //   118: invokevirtual 45	java/io/IOException:printStackTrace	()V
    //   121: aload_1
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	paramInputStream	java.io.InputStream
    //   26	35	1	localStringBuilder1	StringBuilder
    //   84	38	1	localObject	Object
    //   18	10	2	localBufferedReader	java.io.BufferedReader
    //   88	2	2	localIOException	IOException
    //   31	17	3	str	String
    //   43	19	4	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   73	77	80	java/io/IOException
    //   93	97	80	java/io/IOException
    //   27	32	84	finally
    //   36	52	84	finally
    //   52	70	84	finally
    //   89	93	84	finally
    //   27	32	88	java/io/IOException
    //   36	52	88	java/io/IOException
    //   52	70	88	java/io/IOException
    //   109	113	116	java/io/IOException
  }
  
  public static String a(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    paramHttpURLConnection = new BufferedInputStream(paramHttpURLConnection.getInputStream());
    String str = a(paramHttpURLConnection);
    paramHttpURLConnection.close();
    return str;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\f\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */