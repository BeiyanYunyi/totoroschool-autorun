package com.pgyersdk.crash;

import android.os.AsyncTask;
import com.pgyersdk.PgyerProvider;
import com.pgyersdk.a.a;
import com.pgyersdk.f.c;
import com.pgyersdk.f.d;
import com.pgyersdk.f.l;
import com.pgyersdk.f.m;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Map;

public class f
  extends AsyncTask<Void, Void, Object>
{
  HttpURLConnection a;
  StringBuffer b;
  boolean c = false;
  
  public f() {}
  
  public f(StringBuffer paramStringBuffer, boolean paramBoolean)
  {
    this.b = paramStringBuffer;
    this.c = paramBoolean;
  }
  
  private void a()
  {
    if ((l.e()) && (m.b()))
    {
      Object localObject = new File(c.a().b(PgyerProvider.a));
      if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
      {
        localObject = ((File)localObject).listFiles();
        if (localObject == null) {
          return;
        }
        int i = 0;
        while (i < localObject.length)
        {
          StringBuffer localStringBuffer = new StringBuffer();
          try
          {
            m.a(localStringBuffer, localObject[i].getPath());
            String str = localObject[i].getName();
            if (str.contains("crash")) {
              a(localStringBuffer, localObject[i], false);
            } else {
              a(localStringBuffer, localObject[i], true);
            }
          }
          catch (IOException localIOException)
          {
            localIOException.printStackTrace();
          }
          i += 1;
        }
      }
    }
  }
  
  private Boolean b(StringBuffer paramStringBuffer, boolean paramBoolean)
    throws IOException
  {
    Map localMap = a.b();
    localMap.put("crashLog", paramStringBuffer.toString());
    if (paramBoolean) {
      paramStringBuffer = "2";
    } else {
      paramStringBuffer = "1";
    }
    localMap.put("isException", paramStringBuffer);
    this.a = new d("http://www.pgyer.com/apiv1/crash/add").a("POST").a(localMap, PgyerProvider.a, null, null).a();
    int i = this.a.getResponseCode();
    if ((i != 202) && (i != 200)) {
      paramBoolean = false;
    } else {
      paramBoolean = true;
    }
    return Boolean.valueOf(paramBoolean);
  }
  
  private void b()
  {
    HttpURLConnection localHttpURLConnection = this.a;
    if (localHttpURLConnection != null) {
      localHttpURLConnection.disconnect();
    }
  }
  
  protected Object a(Void... paramVarArgs)
  {
    if (this.c)
    {
      paramVarArgs = this.b;
      if (paramVarArgs != null)
      {
        a(paramVarArgs, true);
        a();
        break label33;
      }
    }
    a();
    label33:
    return null;
  }
  
  /* Error */
  public void a(StringBuffer paramStringBuffer, File paramFile, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: invokestatic 141	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   4: astore 4
    //   6: invokestatic 33	com/pgyersdk/f/m:b	()Z
    //   9: ifeq +13 -> 22
    //   12: aload_0
    //   13: aload_1
    //   14: iload_3
    //   15: invokespecial 154	com/pgyersdk/crash/f:b	(Ljava/lang/StringBuffer;Z)Ljava/lang/Boolean;
    //   18: astore_1
    //   19: goto +6 -> 25
    //   22: aload 4
    //   24: astore_1
    //   25: aload_0
    //   26: invokespecial 156	com/pgyersdk/crash/f:b	()V
    //   29: aload_1
    //   30: invokevirtual 159	java/lang/Boolean:booleanValue	()Z
    //   33: ifeq +42 -> 75
    //   36: goto +24 -> 60
    //   39: astore_1
    //   40: goto +43 -> 83
    //   43: astore_1
    //   44: aload_1
    //   45: invokevirtual 160	java/lang/Exception:printStackTrace	()V
    //   48: aload_0
    //   49: invokespecial 156	com/pgyersdk/crash/f:b	()V
    //   52: aload 4
    //   54: invokevirtual 159	java/lang/Boolean:booleanValue	()Z
    //   57: ifeq +18 -> 75
    //   60: invokestatic 40	com/pgyersdk/f/c:a	()Lcom/pgyersdk/f/c;
    //   63: aload_2
    //   64: invokevirtual 163	com/pgyersdk/f/c:a	(Ljava/io/File;)V
    //   67: ldc -91
    //   69: ldc -89
    //   71: invokestatic 172	com/pgyersdk/f/f:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: return
    //   75: ldc -91
    //   77: ldc -82
    //   79: invokestatic 172	com/pgyersdk/f/f:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   82: return
    //   83: aload_0
    //   84: invokespecial 156	com/pgyersdk/crash/f:b	()V
    //   87: aload 4
    //   89: invokevirtual 159	java/lang/Boolean:booleanValue	()Z
    //   92: ifeq +20 -> 112
    //   95: invokestatic 40	com/pgyersdk/f/c:a	()Lcom/pgyersdk/f/c;
    //   98: aload_2
    //   99: invokevirtual 163	com/pgyersdk/f/c:a	(Ljava/io/File;)V
    //   102: ldc -91
    //   104: ldc -89
    //   106: invokestatic 172	com/pgyersdk/f/f:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   109: goto +10 -> 119
    //   112: ldc -91
    //   114: ldc -82
    //   116: invokestatic 172	com/pgyersdk/f/f:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: aload_1
    //   120: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	this	f
    //   0	121	1	paramStringBuffer	StringBuffer
    //   0	121	2	paramFile	File
    //   0	121	3	paramBoolean	boolean
    //   4	84	4	localBoolean	Boolean
    // Exception table:
    //   from	to	target	type
    //   6	19	39	finally
    //   44	48	39	finally
    //   6	19	43	java/lang/Exception
  }
  
  /* Error */
  public void a(StringBuffer paramStringBuffer, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 33	com/pgyersdk/f/m:b	()Z
    //   3: ifne +17 -> 20
    //   6: invokestatic 29	com/pgyersdk/f/l:e	()Z
    //   9: ifeq +10 -> 19
    //   12: aload_1
    //   13: getstatic 179	com/pgyersdk/crash/PgyCrashManager$a:a	Lcom/pgyersdk/crash/PgyCrashManager$a;
    //   16: invokestatic 184	com/pgyersdk/crash/PgyCrashManager:a	(Ljava/lang/StringBuffer;Lcom/pgyersdk/crash/PgyCrashManager$a;)V
    //   19: return
    //   20: invokestatic 186	com/pgyersdk/f/l:a	()Z
    //   23: ifne +4 -> 27
    //   26: return
    //   27: iconst_0
    //   28: invokestatic 141	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   31: astore_3
    //   32: invokestatic 33	com/pgyersdk/f/m:b	()Z
    //   35: ifeq +17 -> 52
    //   38: aload_0
    //   39: aload_1
    //   40: iload_2
    //   41: invokespecial 154	com/pgyersdk/crash/f:b	(Ljava/lang/StringBuffer;Z)Ljava/lang/Boolean;
    //   44: astore 4
    //   46: aload 4
    //   48: astore_3
    //   49: goto +3 -> 52
    //   52: aload_0
    //   53: invokespecial 156	com/pgyersdk/crash/f:b	()V
    //   56: aload_3
    //   57: invokevirtual 159	java/lang/Boolean:booleanValue	()Z
    //   60: ifeq +37 -> 97
    //   63: goto +26 -> 89
    //   66: astore 4
    //   68: goto +44 -> 112
    //   71: astore 4
    //   73: aload 4
    //   75: invokevirtual 160	java/lang/Exception:printStackTrace	()V
    //   78: aload_0
    //   79: invokespecial 156	com/pgyersdk/crash/f:b	()V
    //   82: aload_3
    //   83: invokevirtual 159	java/lang/Boolean:booleanValue	()Z
    //   86: ifeq +11 -> 97
    //   89: ldc -91
    //   91: ldc -89
    //   93: invokestatic 172	com/pgyersdk/f/f:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: return
    //   97: aload_1
    //   98: getstatic 179	com/pgyersdk/crash/PgyCrashManager$a:a	Lcom/pgyersdk/crash/PgyCrashManager$a;
    //   101: invokestatic 184	com/pgyersdk/crash/PgyCrashManager:a	(Ljava/lang/StringBuffer;Lcom/pgyersdk/crash/PgyCrashManager$a;)V
    //   104: ldc -91
    //   106: ldc -82
    //   108: invokestatic 172	com/pgyersdk/f/f:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: return
    //   112: aload_0
    //   113: invokespecial 156	com/pgyersdk/crash/f:b	()V
    //   116: aload_3
    //   117: invokevirtual 159	java/lang/Boolean:booleanValue	()Z
    //   120: ifeq +13 -> 133
    //   123: ldc -91
    //   125: ldc -89
    //   127: invokestatic 172	com/pgyersdk/f/f:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: goto +17 -> 147
    //   133: aload_1
    //   134: getstatic 179	com/pgyersdk/crash/PgyCrashManager$a:a	Lcom/pgyersdk/crash/PgyCrashManager$a;
    //   137: invokestatic 184	com/pgyersdk/crash/PgyCrashManager:a	(Ljava/lang/StringBuffer;Lcom/pgyersdk/crash/PgyCrashManager$a;)V
    //   140: ldc -91
    //   142: ldc -82
    //   144: invokestatic 172	com/pgyersdk/f/f:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   147: aload 4
    //   149: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	f
    //   0	150	1	paramStringBuffer	StringBuffer
    //   0	150	2	paramBoolean	boolean
    //   31	86	3	localObject1	Object
    //   44	3	4	localBoolean	Boolean
    //   66	1	4	localObject2	Object
    //   71	77	4	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   32	46	66	finally
    //   73	78	66	finally
    //   32	46	71	java/lang/Exception
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\crash\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */