package com.pgyersdk.update;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import com.pgyersdk.PgyerProvider;
import com.pgyersdk.f.c;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class b
  extends AsyncTask<Void, Integer, Long>
{
  public static String a;
  private DownloadFileListener b;
  private String c;
  private String d;
  
  b(String paramString, DownloadFileListener paramDownloadFileListener)
  {
    a = paramString;
    this.b = paramDownloadFileListener;
  }
  
  private File a()
  {
    File localFile = new File(c.a().c(PgyerProvider.a));
    this.d = localFile.getAbsolutePath();
    try
    {
      localFile = File.createTempFile("apk-", ".apk", localFile);
      try
      {
        this.c = localFile.getName();
        return localFile;
      }
      catch (IOException localIOException1) {}
      localIOException2.printStackTrace();
    }
    catch (IOException localIOException2)
    {
      localFile = null;
    }
    return localFile;
  }
  
  private HttpURLConnection a(URL paramURL, int paramInt)
    throws IOException
  {
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)paramURL.openConnection();
    a(localHttpURLConnection);
    int i = localHttpURLConnection.getResponseCode();
    if ((i == 301) || (i == 302) || (i == 303))
    {
      if (paramInt == 0) {
        return localHttpURLConnection;
      }
      URL localURL = new URL(localHttpURLConnection.getHeaderField("Location"));
      if (!paramURL.getProtocol().equals(localURL.getProtocol()))
      {
        localHttpURLConnection.disconnect();
        return a(localURL, paramInt - 1);
      }
    }
    return localHttpURLConnection;
  }
  
  @SuppressLint({"ObsoleteSdkInt"})
  private void a(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection.addRequestProperty("User-Agent", "Pgyer/Android");
    paramHttpURLConnection.setInstanceFollowRedirects(true);
    if (Build.VERSION.SDK_INT <= 9) {
      paramHttpURLConnection.setRequestProperty("connection", "close");
    }
  }
  
  /* Error */
  protected Long a(Void... paramVarArgs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: aload_0
    //   3: new 67	java/net/URL
    //   6: dup
    //   7: getstatic 18	com/pgyersdk/update/b:a	Ljava/lang/String;
    //   10: invokespecial 87	java/net/URL:<init>	(Ljava/lang/String;)V
    //   13: bipush 6
    //   15: invokespecial 101	com/pgyersdk/update/b:a	(Ljava/net/URL;I)Ljava/net/HttpURLConnection;
    //   18: astore 6
    //   20: aload 6
    //   22: astore_1
    //   23: aload 6
    //   25: invokevirtual 137	java/net/HttpURLConnection:connect	()V
    //   28: aload 6
    //   30: astore_1
    //   31: aload 6
    //   33: invokevirtual 140	java/net/HttpURLConnection:getContentLength	()I
    //   36: istore_2
    //   37: aload 6
    //   39: astore_1
    //   40: aload_0
    //   41: invokespecial 142	com/pgyersdk/update/b:a	()Ljava/io/File;
    //   44: astore 8
    //   46: aload 6
    //   48: astore_1
    //   49: new 144	java/io/BufferedInputStream
    //   52: dup
    //   53: aload 6
    //   55: invokevirtual 148	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   58: invokespecial 151	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   61: astore 7
    //   63: aload 6
    //   65: astore_1
    //   66: new 153	java/io/FileOutputStream
    //   69: dup
    //   70: aload 8
    //   72: invokespecial 156	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   75: astore 8
    //   77: aload 6
    //   79: astore_1
    //   80: sipush 1024
    //   83: newarray <illegal type>
    //   85: astore 9
    //   87: lconst_0
    //   88: lstore 4
    //   90: aload 6
    //   92: astore_1
    //   93: aload 7
    //   95: aload 9
    //   97: invokevirtual 162	java/io/FilterInputStream:read	([B)I
    //   100: istore_3
    //   101: iload_3
    //   102: iconst_m1
    //   103: if_icmpeq +54 -> 157
    //   106: lload 4
    //   108: iload_3
    //   109: i2l
    //   110: ladd
    //   111: lstore 4
    //   113: aload 6
    //   115: astore_1
    //   116: aload_0
    //   117: iconst_1
    //   118: anewarray 164	java/lang/Integer
    //   121: dup
    //   122: iconst_0
    //   123: lload 4
    //   125: l2f
    //   126: ldc -91
    //   128: fmul
    //   129: iload_2
    //   130: i2f
    //   131: fdiv
    //   132: invokestatic 171	java/lang/Math:round	(F)I
    //   135: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   138: aastore
    //   139: invokevirtual 179	android/os/AsyncTask:publishProgress	([Ljava/lang/Object;)V
    //   142: aload 6
    //   144: astore_1
    //   145: aload 8
    //   147: aload 9
    //   149: iconst_0
    //   150: iload_3
    //   151: invokevirtual 183	java/io/FileOutputStream:write	([BII)V
    //   154: goto -64 -> 90
    //   157: aload 6
    //   159: astore_1
    //   160: aload 8
    //   162: invokevirtual 188	java/io/OutputStream:flush	()V
    //   165: aload 6
    //   167: astore_1
    //   168: aload 8
    //   170: invokevirtual 190	java/io/FileOutputStream:close	()V
    //   173: aload 6
    //   175: astore_1
    //   176: aload 7
    //   178: invokevirtual 191	java/io/BufferedInputStream:close	()V
    //   181: aload 6
    //   183: ifnull +8 -> 191
    //   186: aload 6
    //   188: invokevirtual 99	java/net/HttpURLConnection:disconnect	()V
    //   191: lload 4
    //   193: invokestatic 196	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   196: areturn
    //   197: astore 7
    //   199: goto +13 -> 212
    //   202: astore 6
    //   204: goto +33 -> 237
    //   207: astore 7
    //   209: aconst_null
    //   210: astore 6
    //   212: aload 6
    //   214: astore_1
    //   215: aload 7
    //   217: invokevirtual 197	java/lang/Exception:printStackTrace	()V
    //   220: aload 6
    //   222: ifnull +8 -> 230
    //   225: aload 6
    //   227: invokevirtual 99	java/net/HttpURLConnection:disconnect	()V
    //   230: lconst_0
    //   231: invokestatic 196	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   234: areturn
    //   235: astore 6
    //   237: aload_1
    //   238: ifnull +7 -> 245
    //   241: aload_1
    //   242: invokevirtual 99	java/net/HttpURLConnection:disconnect	()V
    //   245: aload 6
    //   247: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	this	b
    //   0	248	1	paramVarArgs	Void[]
    //   36	94	2	i	int
    //   100	51	3	j	int
    //   88	104	4	l	long
    //   18	169	6	localHttpURLConnection	HttpURLConnection
    //   202	1	6	localObject1	Object
    //   210	16	6	localObject2	Object
    //   235	11	6	localObject3	Object
    //   61	116	7	localBufferedInputStream	java.io.BufferedInputStream
    //   197	1	7	localException1	Exception
    //   207	9	7	localException2	Exception
    //   44	125	8	localObject4	Object
    //   85	63	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   23	28	197	java/lang/Exception
    //   31	37	197	java/lang/Exception
    //   40	46	197	java/lang/Exception
    //   49	63	197	java/lang/Exception
    //   66	77	197	java/lang/Exception
    //   80	87	197	java/lang/Exception
    //   93	101	197	java/lang/Exception
    //   116	142	197	java/lang/Exception
    //   145	154	197	java/lang/Exception
    //   160	165	197	java/lang/Exception
    //   168	173	197	java/lang/Exception
    //   176	181	197	java/lang/Exception
    //   2	20	202	finally
    //   2	20	207	java/lang/Exception
    //   23	28	235	finally
    //   31	37	235	finally
    //   40	46	235	finally
    //   49	63	235	finally
    //   66	77	235	finally
    //   80	87	235	finally
    //   93	101	235	finally
    //   116	142	235	finally
    //   145	154	235	finally
    //   160	165	235	finally
    //   168	173	235	finally
    //   176	181	235	finally
    //   215	220	235	finally
  }
  
  protected void a(Long paramLong)
  {
    if (paramLong.longValue() > 0L)
    {
      paramLong = this.b;
      if (paramLong != null) {
        paramLong.downloadSuccessful(new File(this.d, this.c));
      }
    }
    else
    {
      paramLong = this.b;
      if (paramLong != null) {
        paramLong.downloadFailed();
      }
    }
  }
  
  protected void a(Integer... paramVarArgs)
  {
    DownloadFileListener localDownloadFileListener = this.b;
    if (localDownloadFileListener != null) {
      localDownloadFileListener.onProgressUpdate(paramVarArgs);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\update\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */