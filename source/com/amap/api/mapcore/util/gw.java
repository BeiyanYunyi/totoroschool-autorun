package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import dalvik.system.DexFile;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class gw
{
  static String a(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getFilesDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("pngex");
    return localStringBuilder.toString();
  }
  
  static String a(Context paramContext, go paramgo, fv paramfv)
  {
    List localList = paramgo.b(gz.b(paramfv.a(), "copy"), gz.class);
    if (localList != null)
    {
      if (localList.size() == 0) {
        return null;
      }
      hd.a(localList);
      int i = 0;
      while (i < localList.size())
      {
        Object localObject = (gz)localList.get(i);
        if (hd.a(paramContext, paramgo, ((gz)localObject).a(), paramfv)) {
          try
          {
            a(paramContext, paramgo, paramfv, a(paramContext, ((gz)localObject).a()), ((gz)localObject).e());
            localObject = ((gz)localObject).e();
            return (String)localObject;
          }
          catch (Throwable localThrowable)
          {
            hd.a(localThrowable, "FileManager", "loadAvailableD");
          }
        } else {
          c(paramContext, paramgo, localThrowable.a());
        }
        i += 1;
      }
      return null;
    }
    return null;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramContext));
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  static String a(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = fp.w(paramContext);
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(paramString1);
    localStringBuilder2.append(paramString2);
    localStringBuilder2.append(paramContext);
    localStringBuilder1.append(fs.b(localStringBuilder2.toString()));
    localStringBuilder1.append(".jar");
    return localStringBuilder1.toString();
  }
  
  static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(".o");
    return localStringBuilder.toString();
  }
  
  static void a(Context paramContext, fv paramfv)
  {
    try
    {
      hb.a locala = hb.b().a(paramfv);
      if ((locala != null) && (locala.a)) {
        try
        {
          locala.wait();
        }
        finally {}
      }
      locala.b = true;
      Object localObject1 = b(paramContext, paramfv.a(), paramfv.b());
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return;
      }
      File localFile = new File((String)localObject1);
      Object localObject2 = localFile.getParentFile();
      if (!localFile.exists())
      {
        if ((localObject2 != null) && (((File)localObject2).exists())) {
          c(paramContext, paramfv.a(), paramfv.b());
        }
      }
      else
      {
        localObject2 = a(paramContext, a(localFile.getName()));
        localObject1 = DexFile.loadDex((String)localObject1, (String)localObject2, 0);
        if (localObject1 != null)
        {
          ((DexFile)localObject1).close();
          a(paramContext, localFile, (String)localObject2, paramfv);
        }
        locala.b = false;
        return;
      }
    }
    catch (Throwable paramContext)
    {
      hd.a(paramContext, "BaseLoader", "getInstanceByThread()");
      return;
    }
  }
  
  /* Error */
  static void a(Context paramContext, go paramgo, fv paramfv, String paramString1, String paramString2)
    throws Throwable
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 8
    //   6: aload_2
    //   7: invokevirtual 49	com/amap/api/mapcore/util/fv:a	()Ljava/lang/String;
    //   10: astore 10
    //   12: invokestatic 124	com/amap/api/mapcore/util/hb:b	()Lcom/amap/api/mapcore/util/hb;
    //   15: aload_2
    //   16: invokevirtual 127	com/amap/api/mapcore/util/hb:a	(Lcom/amap/api/mapcore/util/fv;)Lcom/amap/api/mapcore/util/hb$a;
    //   19: astore 7
    //   21: aload 7
    //   23: ifnull +31 -> 54
    //   26: aload 7
    //   28: getfield 132	com/amap/api/mapcore/util/hb$a:a	Z
    //   31: ifeq +23 -> 54
    //   34: aload 7
    //   36: monitorenter
    //   37: aload 7
    //   39: invokevirtual 135	java/lang/Object:wait	()V
    //   42: aload 7
    //   44: monitorexit
    //   45: goto +9 -> 54
    //   48: astore_0
    //   49: aload 7
    //   51: monitorexit
    //   52: aload_0
    //   53: athrow
    //   54: aload 7
    //   56: iconst_1
    //   57: putfield 137	com/amap/api/mapcore/util/hb$a:b	Z
    //   60: aload_0
    //   61: aload 10
    //   63: aload_2
    //   64: invokevirtual 139	com/amap/api/mapcore/util/fv:b	()Ljava/lang/String;
    //   67: invokestatic 183	com/amap/api/mapcore/util/gw:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   70: astore 11
    //   72: aload_0
    //   73: aload_1
    //   74: aload 11
    //   76: invokestatic 185	com/amap/api/mapcore/util/gw:a	(Landroid/content/Context;Lcom/amap/api/mapcore/util/go;Ljava/lang/String;)V
    //   79: new 187	java/io/FileInputStream
    //   82: dup
    //   83: new 24	java/io/File
    //   86: dup
    //   87: aload_3
    //   88: invokespecial 150	java/io/File:<init>	(Ljava/lang/String;)V
    //   91: invokespecial 190	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   94: astore_3
    //   95: aload_3
    //   96: bipush 32
    //   98: newarray <illegal type>
    //   100: invokevirtual 196	java/io/InputStream:read	([B)I
    //   103: pop
    //   104: new 24	java/io/File
    //   107: dup
    //   108: aload_0
    //   109: aload 10
    //   111: aload_2
    //   112: invokevirtual 139	com/amap/api/mapcore/util/fv:b	()Ljava/lang/String;
    //   115: invokestatic 141	com/amap/api/mapcore/util/gw:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   118: invokespecial 150	java/io/File:<init>	(Ljava/lang/String;)V
    //   121: astore_0
    //   122: new 198	java/io/RandomAccessFile
    //   125: dup
    //   126: aload_0
    //   127: ldc -56
    //   129: invokespecial 203	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   132: astore 8
    //   134: sipush 1024
    //   137: newarray <illegal type>
    //   139: astore 9
    //   141: iconst_0
    //   142: istore 5
    //   144: aload_3
    //   145: aload 9
    //   147: invokevirtual 196	java/io/InputStream:read	([B)I
    //   150: istore 6
    //   152: iload 6
    //   154: ifle +64 -> 218
    //   157: iload 6
    //   159: sipush 1024
    //   162: if_icmpne +21 -> 183
    //   165: aload 8
    //   167: iload 5
    //   169: i2l
    //   170: invokevirtual 207	java/io/RandomAccessFile:seek	(J)V
    //   173: aload 8
    //   175: aload 9
    //   177: invokevirtual 211	java/io/RandomAccessFile:write	([B)V
    //   180: goto +244 -> 424
    //   183: iload 6
    //   185: newarray <illegal type>
    //   187: astore 12
    //   189: aload 9
    //   191: iconst_0
    //   192: aload 12
    //   194: iconst_0
    //   195: iload 6
    //   197: invokestatic 217	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   200: aload 8
    //   202: iload 5
    //   204: i2l
    //   205: invokevirtual 207	java/io/RandomAccessFile:seek	(J)V
    //   208: aload 8
    //   210: aload 12
    //   212: invokevirtual 211	java/io/RandomAccessFile:write	([B)V
    //   215: goto +209 -> 424
    //   218: new 219	com/amap/api/mapcore/util/gz$a
    //   221: dup
    //   222: aload 11
    //   224: aload_0
    //   225: invokevirtual 28	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   228: invokestatic 220	com/amap/api/mapcore/util/fs:a	(Ljava/lang/String;)Ljava/lang/String;
    //   231: aload 10
    //   233: aload_2
    //   234: invokevirtual 139	com/amap/api/mapcore/util/fv:b	()Ljava/lang/String;
    //   237: aload 4
    //   239: invokespecial 223	com/amap/api/mapcore/util/gz$a:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   242: ldc -31
    //   244: invokevirtual 228	com/amap/api/mapcore/util/gz$a:a	(Ljava/lang/String;)Lcom/amap/api/mapcore/util/gz$a;
    //   247: invokevirtual 231	com/amap/api/mapcore/util/gz$a:a	()Lcom/amap/api/mapcore/util/gz;
    //   250: astore_0
    //   251: aload_1
    //   252: aload_0
    //   253: aload_0
    //   254: invokevirtual 78	com/amap/api/mapcore/util/gz:a	()Ljava/lang/String;
    //   257: invokestatic 232	com/amap/api/mapcore/util/gz:b	(Ljava/lang/String;)Ljava/lang/String;
    //   260: invokestatic 235	com/amap/api/mapcore/util/gw$a:a	(Lcom/amap/api/mapcore/util/go;Lcom/amap/api/mapcore/util/gz;Ljava/lang/String;)V
    //   263: aload_3
    //   264: invokestatic 238	com/amap/api/mapcore/util/hd:a	(Ljava/io/Closeable;)V
    //   267: goto +8 -> 275
    //   270: astore_0
    //   271: aload_0
    //   272: invokevirtual 241	java/lang/Throwable:printStackTrace	()V
    //   275: aload 8
    //   277: invokestatic 238	com/amap/api/mapcore/util/hd:a	(Ljava/io/Closeable;)V
    //   280: goto +8 -> 288
    //   283: astore_0
    //   284: aload_0
    //   285: invokevirtual 241	java/lang/Throwable:printStackTrace	()V
    //   288: aload 7
    //   290: ifnull +9 -> 299
    //   293: aload 7
    //   295: iconst_0
    //   296: putfield 137	com/amap/api/mapcore/util/hb$a:b	Z
    //   299: return
    //   300: astore_0
    //   301: aload_3
    //   302: astore_1
    //   303: aload 8
    //   305: astore_2
    //   306: goto +57 -> 363
    //   309: astore_2
    //   310: aload 8
    //   312: astore_0
    //   313: goto +15 -> 328
    //   316: astore_0
    //   317: aload 9
    //   319: astore_2
    //   320: aload_3
    //   321: astore_1
    //   322: goto +41 -> 363
    //   325: astore_2
    //   326: aconst_null
    //   327: astore_0
    //   328: aload_3
    //   329: astore_1
    //   330: goto +26 -> 356
    //   333: astore_0
    //   334: aconst_null
    //   335: astore 7
    //   337: aload 7
    //   339: astore_1
    //   340: aload 9
    //   342: astore_2
    //   343: goto +20 -> 363
    //   346: astore_2
    //   347: aconst_null
    //   348: astore 7
    //   350: aload 7
    //   352: astore_0
    //   353: aload 8
    //   355: astore_1
    //   356: aload_2
    //   357: athrow
    //   358: astore_3
    //   359: aload_0
    //   360: astore_2
    //   361: aload_3
    //   362: astore_0
    //   363: aload_1
    //   364: invokestatic 238	com/amap/api/mapcore/util/hd:a	(Ljava/io/Closeable;)V
    //   367: goto +8 -> 375
    //   370: astore_1
    //   371: aload_1
    //   372: invokevirtual 241	java/lang/Throwable:printStackTrace	()V
    //   375: aload_2
    //   376: invokestatic 238	com/amap/api/mapcore/util/hd:a	(Ljava/io/Closeable;)V
    //   379: goto +8 -> 387
    //   382: astore_1
    //   383: aload_1
    //   384: invokevirtual 241	java/lang/Throwable:printStackTrace	()V
    //   387: aload 7
    //   389: ifnull +9 -> 398
    //   392: aload 7
    //   394: iconst_0
    //   395: putfield 137	com/amap/api/mapcore/util/hb$a:b	Z
    //   398: aload_0
    //   399: athrow
    //   400: astore_0
    //   401: return
    //   402: astore_1
    //   403: goto -5 -> 398
    //   406: astore_0
    //   407: aconst_null
    //   408: astore_1
    //   409: aload 9
    //   411: astore_2
    //   412: goto -49 -> 363
    //   415: astore_2
    //   416: aconst_null
    //   417: astore_0
    //   418: aload 8
    //   420: astore_1
    //   421: goto -65 -> 356
    //   424: iload 5
    //   426: iload 6
    //   428: iadd
    //   429: istore 5
    //   431: goto -287 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	434	0	paramContext	Context
    //   0	434	1	paramgo	go
    //   0	434	2	paramfv	fv
    //   0	434	3	paramString1	String
    //   0	434	4	paramString2	String
    //   142	288	5	i	int
    //   150	279	6	j	int
    //   19	374	7	locala	hb.a
    //   4	415	8	localRandomAccessFile	java.io.RandomAccessFile
    //   1	409	9	arrayOfByte1	byte[]
    //   10	222	10	str1	String
    //   70	153	11	str2	String
    //   187	24	12	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   37	45	48	finally
    //   49	52	48	finally
    //   263	267	270	java/lang/Throwable
    //   275	280	283	java/lang/Throwable
    //   134	141	300	finally
    //   144	152	300	finally
    //   165	180	300	finally
    //   183	215	300	finally
    //   218	263	300	finally
    //   134	141	309	java/lang/Throwable
    //   144	152	309	java/lang/Throwable
    //   165	180	309	java/lang/Throwable
    //   183	215	309	java/lang/Throwable
    //   218	263	309	java/lang/Throwable
    //   95	134	316	finally
    //   95	134	325	java/lang/Throwable
    //   6	21	333	finally
    //   6	21	346	java/lang/Throwable
    //   356	358	358	finally
    //   363	367	370	java/lang/Throwable
    //   375	379	382	java/lang/Throwable
    //   293	299	400	java/lang/Throwable
    //   392	398	402	java/lang/Throwable
    //   26	37	406	finally
    //   52	54	406	finally
    //   54	95	406	finally
    //   26	37	415	java/lang/Throwable
    //   52	54	415	java/lang/Throwable
    //   54	95	415	java/lang/Throwable
  }
  
  static void a(Context paramContext, go paramgo, String paramString)
  {
    c(paramContext, paramgo, a(paramString));
    c(paramContext, paramgo, paramString);
  }
  
  static void a(Context paramContext, File paramFile, fv paramfv)
  {
    File localFile = paramFile.getParentFile();
    if ((!paramFile.exists()) && (localFile != null) && (localFile.exists())) {
      c(paramContext, paramfv.a(), paramfv.b());
    }
  }
  
  private static void a(Context paramContext, File paramFile, String paramString, fv paramfv)
  {
    go localgo = new go(paramContext, gy.a());
    paramContext = a.a(localgo, paramFile.getName());
    if (paramContext != null) {
      paramContext = paramContext.e();
    } else {
      paramContext = null;
    }
    paramFile = new File(paramString);
    if ((!TextUtils.isEmpty(paramContext)) && (paramFile.exists()))
    {
      paramString = fs.a(paramString);
      paramFile = paramFile.getName();
      a.a(localgo, new gz.a(paramFile, paramString, paramfv.a(), paramfv.b(), paramContext).a("useod").a(), gz.b(paramFile));
    }
  }
  
  static void a(go paramgo, Context paramContext, String paramString)
  {
    Object localObject1 = a.a(paramgo, paramString, "used");
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (gz)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((gz)localObject2).c().equals(paramString)))
        {
          a(paramContext, paramgo, ((gz)localObject2).a());
          localObject2 = paramgo.b(gz.a(paramString, ((gz)localObject2).e()), gz.class);
          if ((localObject2 != null) && (((List)localObject2).size() > 0))
          {
            localObject2 = (gz)((List)localObject2).get(0);
            ((gz)localObject2).c("errorstatus");
            a.a(paramgo, (gz)localObject2, gz.b(((gz)localObject2).a()));
            localObject2 = new File(a(paramContext, ((gz)localObject2).a()));
            if (((File)localObject2).exists()) {
              ((File)localObject2).delete();
            }
          }
        }
      }
    }
  }
  
  static String b(Context paramContext, String paramString1, String paramString2)
  {
    return a(paramContext, a(paramContext, paramString1, paramString2));
  }
  
  static void b(Context paramContext, String paramString)
  {
    go localgo = new go(paramContext, gy.a());
    paramString = a.a(localgo, paramString, "copy");
    hd.a(paramString);
    if (paramString != null)
    {
      int j = paramString.size();
      int i = 1;
      if (j > 1)
      {
        j = paramString.size();
        while (i < j)
        {
          c(paramContext, localgo, ((gz)paramString.get(i)).a());
          i += 1;
        }
      }
    }
  }
  
  private static void c(Context paramContext, go paramgo, String paramString)
  {
    paramContext = new File(a(paramContext, paramString));
    if (paramContext.exists()) {
      paramContext.delete();
    }
    paramgo.a(gz.b(paramString), gz.class);
  }
  
  static void c(Context paramContext, final String paramString1, final String paramString2)
  {
    try
    {
      hb.b().a().submit(new Runnable()
      {
        public void run()
        {
          try
          {
            go localgo = new go(this.a, gy.a());
            Object localObject1 = localgo.b(gz.a(paramString1), gz.class);
            if ((localObject1 != null) && (((List)localObject1).size() > 0))
            {
              localObject1 = ((List)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                Object localObject2 = (gz)((Iterator)localObject1).next();
                String str = ((gz)localObject2).d();
                if (!paramString2.equalsIgnoreCase(str))
                {
                  localObject2 = ((gz)localObject2).a();
                  gw.b(this.a, localgo, (String)localObject2);
                }
              }
            }
            return;
          }
          catch (Throwable localThrowable)
          {
            hd.a(localThrowable, "FileManager", "clearUnSuitableV");
          }
        }
      });
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static class a
  {
    static gz a(go paramgo, String paramString)
    {
      paramgo = paramgo.b(gz.b(paramString), gz.class);
      if ((paramgo != null) && (paramgo.size() > 0)) {
        return (gz)paramgo.get(0);
      }
      return null;
    }
    
    public static List<gz> a(go paramgo, String paramString1, String paramString2)
    {
      return paramgo.b(gz.b(paramString1, paramString2), gz.class);
    }
    
    public static void a(go paramgo, gz paramgz, String paramString)
    {
      paramgo.a(paramgz, paramString);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\gw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */