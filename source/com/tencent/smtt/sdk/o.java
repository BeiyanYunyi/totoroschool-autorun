package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

class o
{
  static boolean a = false;
  private static o d;
  private static int g = 0;
  private static int h = 0;
  private static int i = 3;
  private static String k;
  private bh b = null;
  private bh c = null;
  private boolean e = false;
  private boolean f = false;
  private File j = null;
  
  public static o a(boolean paramBoolean)
  {
    if ((d == null) && (paramBoolean)) {
      try
      {
        if (d == null) {
          d = new o();
        }
      }
      finally {}
    }
    return d;
  }
  
  static void a(int paramInt)
  {
    g = paramInt;
  }
  
  private void b(int paramInt)
  {
    Properties localProperties = new Properties();
    localProperties.setProperty(k, String.valueOf(paramInt));
    try
    {
      localProperties.store(new FileOutputStream(new File(this.j, "count.prop")), null);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      localFileNotFoundException.printStackTrace();
    }
  }
  
  public static int e()
  {
    return g;
  }
  
  /* Error */
  private int j()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_3
    //   6: astore_2
    //   7: new 69	java/io/File
    //   10: dup
    //   11: aload_0
    //   12: getfield 39	com/tencent/smtt/sdk/o:j	Ljava/io/File;
    //   15: ldc 71
    //   17: invokespecial 74	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   20: astore 4
    //   22: aload_3
    //   23: astore_2
    //   24: aload 4
    //   26: invokevirtual 92	java/io/File:exists	()Z
    //   29: ifne +5 -> 34
    //   32: iconst_0
    //   33: ireturn
    //   34: aload_3
    //   35: astore_2
    //   36: new 94	java/io/BufferedInputStream
    //   39: dup
    //   40: new 96	java/io/FileInputStream
    //   43: dup
    //   44: aload 4
    //   46: invokespecial 97	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   49: invokespecial 100	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   52: astore_3
    //   53: new 52	java/util/Properties
    //   56: dup
    //   57: invokespecial 53	java/util/Properties:<init>	()V
    //   60: astore_2
    //   61: aload_2
    //   62: aload_3
    //   63: invokevirtual 103	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   66: aload_2
    //   67: getstatic 55	com/tencent/smtt/sdk/o:k	Ljava/lang/String;
    //   70: ldc 105
    //   72: invokevirtual 109	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   75: invokestatic 114	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   78: invokevirtual 117	java/lang/Integer:intValue	()I
    //   81: istore_1
    //   82: aload_3
    //   83: invokevirtual 120	java/io/BufferedInputStream:close	()V
    //   86: iload_1
    //   87: ireturn
    //   88: astore_2
    //   89: aload_2
    //   90: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   93: iload_1
    //   94: ireturn
    //   95: astore 4
    //   97: aload_3
    //   98: astore_2
    //   99: aload 4
    //   101: astore_3
    //   102: goto +43 -> 145
    //   105: astore_2
    //   106: aload_2
    //   107: astore 4
    //   109: goto +12 -> 121
    //   112: astore_3
    //   113: goto +32 -> 145
    //   116: astore 4
    //   118: aload 5
    //   120: astore_3
    //   121: aload_3
    //   122: astore_2
    //   123: aload 4
    //   125: invokevirtual 121	java/lang/Exception:printStackTrace	()V
    //   128: aload_3
    //   129: ifnull +14 -> 143
    //   132: aload_3
    //   133: invokevirtual 120	java/io/BufferedInputStream:close	()V
    //   136: iconst_0
    //   137: ireturn
    //   138: astore_2
    //   139: aload_2
    //   140: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   143: iconst_0
    //   144: ireturn
    //   145: aload_2
    //   146: ifnull +15 -> 161
    //   149: aload_2
    //   150: invokevirtual 120	java/io/BufferedInputStream:close	()V
    //   153: goto +8 -> 161
    //   156: astore_2
    //   157: aload_2
    //   158: invokevirtual 84	java/io/IOException:printStackTrace	()V
    //   161: aload_3
    //   162: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	o
    //   81	13	1	m	int
    //   6	61	2	localObject1	Object
    //   88	2	2	localIOException1	IOException
    //   98	1	2	localObject2	Object
    //   105	2	2	localException1	Exception
    //   122	1	2	localObject3	Object
    //   138	12	2	localIOException2	IOException
    //   156	2	2	localIOException3	IOException
    //   4	98	3	localObject4	Object
    //   112	1	3	localObject5	Object
    //   120	42	3	localObject6	Object
    //   20	25	4	localFile	File
    //   95	5	4	localObject7	Object
    //   107	1	4	localException2	Exception
    //   116	8	4	localException3	Exception
    //   1	118	5	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   82	86	88	java/io/IOException
    //   53	82	95	finally
    //   53	82	105	java/lang/Exception
    //   7	22	112	finally
    //   24	32	112	finally
    //   36	53	112	finally
    //   123	128	112	finally
    //   7	22	116	java/lang/Exception
    //   24	32	116	java/lang/Exception
    //   36	53	116	java/lang/Exception
    //   132	136	138	java/io/IOException
    //   149	153	156	java/io/IOException
  }
  
  public void a()
  {
    this.c = null;
  }
  
  public void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        if (this.c == null)
        {
          if (g == 25436) {
            break label165;
          }
          if (g != 25437) {
            break label159;
          }
          break label165;
          if (m == 0) {
            break label171;
          }
          localContext = paramContext.getApplicationContext();
          File localFile = am.a().r(paramContext);
          Object localObject = new File(localFile, "tbs_sdk_extension_dex.jar");
          QbSdk.initForinitAndNotLoadSo(paramContext);
          QbSdk.loadTBSSDKExtension(paramContext, ((File)localObject).getParent());
          if (!QbSdk.getJarFilesAndLibraryPath(paramContext))
          {
            TbsLog.i("SDKEngine", "initAndNotLoadSo error getJarFilesAndLibraryPath return false");
            return;
          }
          localObject = localFile.getAbsolutePath();
          String[] arrayOfString = QbSdk.getDexLoaderFileList(paramContext, localContext, localFile.getAbsolutePath());
          try
          {
            this.c = new bh(paramContext, localContext, localFile.getAbsolutePath(), (String)localObject, arrayOfString, QbSdk.d, null);
          }
          catch (Exception paramContext)
          {
            paramContext.printStackTrace();
          }
        }
        return;
      }
      finally {}
      label159:
      int m = 0;
      continue;
      label165:
      m = 1;
      continue;
      label171:
      Context localContext = paramContext;
    }
  }
  
  void a(String paramString)
  {
    k = paramString;
  }
  
  public bh b()
  {
    if (this.e) {
      return this.b;
    }
    return null;
  }
  
  public void b(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1;
    boolean bool2;
    label139:
    try
    {
      TbsLog.addLog(999, null, new Object[0]);
      TbsLog.initIfNeed(paramContext);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("init -- context: ");
      ((StringBuilder)localObject1).append(paramContext);
      ((StringBuilder)localObject1).append(", isPreIniting: ");
      ((StringBuilder)localObject1).append(paramBoolean2);
      TbsLog.i("SDKEngine", ((StringBuilder)localObject1).toString());
      h += 1;
      TbsCoreLoadStat.getInstance().a();
      localObject1 = am.a();
      if (h != 1) {
        break label812;
      }
      bool1 = true;
      ((am)localObject1).c(paramContext, bool1);
      am.a().l(paramContext);
      TbsShareManager.forceToLoadX5ForThirdApp(paramContext, true);
      bool2 = QbSdk.a(paramContext, paramBoolean1, paramBoolean2);
      if (Build.VERSION.SDK_INT < 7) {
        break label818;
      }
      paramBoolean2 = true;
    }
    finally {}
    boolean bool1 = paramBoolean1;
    if (paramBoolean1)
    {
      long l = System.currentTimeMillis();
      bool1 = am.a().d(paramContext, e());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("isTbsCoreLegal: ");
      ((StringBuilder)localObject1).append(bool1);
      ((StringBuilder)localObject1).append("; cost: ");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - l);
      TbsLog.i("SDKEngine", ((StringBuilder)localObject1).toString());
    }
    if (bool1)
    {
      paramBoolean1 = this.e;
      if (paramBoolean1) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        if (TbsShareManager.isThirdPartyApp(paramContext))
        {
          TbsLog.addLog(995, null, new Object[0]);
          if (TbsShareManager.j(paramContext))
          {
            localObject3 = new File(TbsShareManager.c(paramContext));
            localObject5 = am.a().r(paramContext);
            localObject1 = TbsShareManager.e(paramContext);
            localObject4 = localObject5;
            if (localObject5 == null)
            {
              this.e = false;
              QbSdk.a(paramContext, "SDKEngine::useSystemWebView by error_tbs_core_dexopt_dir null!");
            }
          }
          else
          {
            this.e = false;
            QbSdk.a(paramContext, "SDKEngine::useSystemWebView by error_host_unavailable");
          }
        }
        else
        {
          TbsLog.addLog(996, null, new Object[0]);
          localObject3 = am.a().r(paramContext);
          if (g == 25436) {
            break label845;
          }
          if (g != 25437) {
            break label839;
          }
          break label845;
          if (m == 0) {
            break label851;
          }
          localObject1 = paramContext.getApplicationContext();
          if (localObject3 == null)
          {
            this.e = false;
            QbSdk.a(paramContext, "SDKEngine::useSystemWebView by tbs_core_share_dir null!");
            return;
          }
          localObject4 = localObject3;
        }
        localObject5 = QbSdk.getDexLoaderFileList(paramContext, (Context)localObject1, ((File)localObject3).getAbsolutePath());
        m = 0;
        if (m < localObject5.length)
        {
          m += 1;
          continue;
        }
        if (TbsShareManager.getHostCorePathAppDefined() != null) {
          localObject4 = TbsShareManager.getHostCorePathAppDefined();
        } else {
          localObject4 = ((File)localObject4).getAbsolutePath();
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject5;
        Object localObject4;
        StringBuilder localStringBuilder;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("useSystemWebView by exception: ");
        ((StringBuilder)localObject3).append(localThrowable);
        TbsLog.e("SDKEngine", ((StringBuilder)localObject3).toString());
        TbsCoreLoadStat.getInstance().a(paramContext, 327, localThrowable);
        this.e = false;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("SDKEngine::useSystemWebView by exception: ");
        ((StringBuilder)localObject3).append(localThrowable);
        QbSdk.a(paramContext, ((StringBuilder)localObject3).toString());
        break label791;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("SDKEngine init optDir is ");
      localStringBuilder.append((String)localObject4);
      TbsLog.i("SDKEngine", localStringBuilder.toString());
      if (this.c != null)
      {
        this.b = this.c;
        this.b.a(paramContext, (Context)localObject1, ((File)localObject3).getAbsolutePath(), (String)localObject4, (String[])localObject5, QbSdk.d);
      }
      else
      {
        this.b = new bh(paramContext, (Context)localObject1, ((File)localObject3).getAbsolutePath(), (String)localObject4, (String[])localObject5, QbSdk.d);
      }
      this.e = true;
      break label791;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("can_load_x5=");
      ((StringBuilder)localObject2).append(bool2);
      ((StringBuilder)localObject2).append("; is_compatible=");
      ((StringBuilder)localObject2).append(paramBoolean2);
      localObject2 = ((StringBuilder)localObject2).toString();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("SDKEngine.init canLoadTbs=false; failure: ");
      ((StringBuilder)localObject3).append((String)localObject2);
      TbsLog.e("SDKEngine", ((StringBuilder)localObject3).toString());
      if ((!QbSdk.a) || (!this.e))
      {
        this.e = false;
        TbsCoreLoadStat.getInstance().a(paramContext, 405, new Throwable((String)localObject2));
      }
      label791:
      this.j = am.t(paramContext);
      this.f = true;
      return;
      label812:
      bool1 = false;
      break;
      label818:
      paramBoolean2 = false;
      if ((bool2) && (paramBoolean2))
      {
        paramBoolean1 = true;
        break label139;
      }
      paramBoolean1 = false;
      break label139;
      label839:
      int m = 0;
      continue;
      label845:
      m = 1;
      continue;
      label851:
      localObject2 = paramContext;
    }
  }
  
  boolean b(boolean paramBoolean)
  {
    a = paramBoolean;
    return paramBoolean;
  }
  
  public boolean c()
  {
    return this.e;
  }
  
  bh d()
  {
    return this.b;
  }
  
  public String f()
  {
    if ((this.b != null) && (!QbSdk.a)) {
      return this.b.a();
    }
    return "system webview get nothing...";
  }
  
  boolean g()
  {
    if (a)
    {
      if (k == null) {
        return false;
      }
      int m = j();
      if (m == 0)
      {
        b(1);
      }
      else
      {
        m += 1;
        if (m <= i) {
          b(m);
        } else {
          return false;
        }
      }
    }
    return a;
  }
  
  boolean h()
  {
    return this.f;
  }
  
  public boolean i()
  {
    return QbSdk.useSoftWare();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */