package com.amap.api.mapcore.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.util.DisplayMetrics;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class es
{
  public static int a = -1;
  private static AssetManager b;
  private static Resources c;
  private static Resources d;
  private static boolean e = true;
  private static Context f;
  private static String g = "amap_resource";
  private static String h = "1_0_0";
  private static String i = ".png";
  private static String j = ".jar";
  private static String k;
  private static String l;
  private static String m;
  private static String n;
  private static Resources.Theme o;
  private static Resources.Theme p;
  private static Field q;
  private static Field r;
  private static Activity s;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(g);
    localStringBuilder.append(h);
    localStringBuilder.append(j);
    k = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(g);
    localStringBuilder.append(h);
    localStringBuilder.append(i);
    l = localStringBuilder.toString();
    m = "";
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(m);
    localStringBuilder.append(k);
    n = localStringBuilder.toString();
    o = null;
    p = null;
    q = null;
    r = null;
    s = null;
  }
  
  private static AssetManager a(String paramString)
  {
    try
    {
      Class localClass = Class.forName("android.content.res.AssetManager");
      Object localObject = (AssetManager)localClass.getConstructor((Class[])null).newInstance((Object[])null);
      try
      {
        localClass.getDeclaredMethod("addAssetPath", new Class[] { String.class }).invoke(localObject, new Object[] { paramString });
        return (AssetManager)localObject;
      }
      catch (Throwable localThrowable2)
      {
        paramString = (String)localObject;
        localObject = localThrowable2;
      }
      gk.c(localThrowable1, "ResourcesUtil", "getAssetManager(String apkPath)");
    }
    catch (Throwable localThrowable1)
    {
      paramString = null;
    }
    return paramString;
  }
  
  public static Resources a()
  {
    if (c == null) {
      return f.getResources();
    }
    return c;
  }
  
  private static Resources a(Context paramContext, AssetManager paramAssetManager)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplayMetrics.setToDefaults();
    return new Resources(paramAssetManager, localDisplayMetrics, paramContext.getResources().getConfiguration());
  }
  
  /* Error */
  public static android.view.View a(Context paramContext, int paramInt, android.view.ViewGroup paramViewGroup)
  {
    // Byte code:
    //   0: invokestatic 170	com/amap/api/mapcore/util/es:a	()Landroid/content/res/Resources;
    //   3: iload_1
    //   4: invokevirtual 174	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
    //   7: astore_3
    //   8: getstatic 176	com/amap/api/mapcore/util/es:e	Z
    //   11: ifne +13 -> 24
    //   14: aload_0
    //   15: invokestatic 182	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   18: aload_3
    //   19: aload_2
    //   20: invokevirtual 186	android/view/LayoutInflater:inflate	(Lorg/xmlpull/v1/XmlPullParser;Landroid/view/ViewGroup;)Landroid/view/View;
    //   23: areturn
    //   24: getstatic 89	com/amap/api/mapcore/util/es:a	I
    //   27: iconst_m1
    //   28: if_icmpne +8 -> 36
    //   31: iconst_0
    //   32: istore_1
    //   33: goto +7 -> 40
    //   36: getstatic 89	com/amap/api/mapcore/util/es:a	I
    //   39: istore_1
    //   40: new 188	com/amap/api/mapcore/util/er
    //   43: dup
    //   44: aload_0
    //   45: iload_1
    //   46: ldc 2
    //   48: invokevirtual 192	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   51: invokespecial 195	com/amap/api/mapcore/util/er:<init>	(Landroid/content/Context;ILjava/lang/ClassLoader;)V
    //   54: invokestatic 182	android/view/LayoutInflater:from	(Landroid/content/Context;)Landroid/view/LayoutInflater;
    //   57: aload_3
    //   58: aload_2
    //   59: invokevirtual 186	android/view/LayoutInflater:inflate	(Lorg/xmlpull/v1/XmlPullParser;Landroid/view/ViewGroup;)Landroid/view/View;
    //   62: astore_0
    //   63: aload_3
    //   64: invokeinterface 200 1 0
    //   69: aload_0
    //   70: areturn
    //   71: astore_0
    //   72: goto +24 -> 96
    //   75: astore_0
    //   76: aload_0
    //   77: invokevirtual 203	java/lang/Throwable:printStackTrace	()V
    //   80: aload_0
    //   81: ldc -122
    //   83: ldc -51
    //   85: invokestatic 141	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload_3
    //   89: invokeinterface 200 1 0
    //   94: aconst_null
    //   95: areturn
    //   96: aload_3
    //   97: invokeinterface 200 1 0
    //   102: aload_0
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	paramContext	Context
    //   0	104	1	paramInt	int
    //   0	104	2	paramViewGroup	android.view.ViewGroup
    //   7	90	3	localXmlResourceParser	android.content.res.XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   24	31	71	finally
    //   36	40	71	finally
    //   40	63	71	finally
    //   76	88	71	finally
    //   24	31	75	java/lang/Throwable
    //   36	40	75	java/lang/Throwable
    //   40	63	75	java/lang/Throwable
  }
  
  private static OutputStream a(InputStream paramInputStream)
    throws IOException
  {
    FileOutputStream localFileOutputStream = new FileOutputStream(new File(m, k));
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      int i1 = paramInputStream.read(arrayOfByte);
      if (i1 <= 0) {
        break;
      }
      localFileOutputStream.write(arrayOfByte, 0, i1);
    }
    return localFileOutputStream;
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      f = paramContext;
      Object localObject = b(f);
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((File)localObject).getAbsolutePath());
        localStringBuilder.append("/");
        m = localStringBuilder.toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(m);
      ((StringBuilder)localObject).append(k);
      n = ((StringBuilder)localObject).toString();
      if (!e) {
        return true;
      }
      if (!c(paramContext)) {
        return false;
      }
      b = a(n);
      c = a(paramContext, b);
      return true;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return true;
  }
  
  /* Error */
  private static File b(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_1
    //   5: aload_0
    //   6: ifnonnull +14 -> 20
    //   9: aload_0
    //   10: ifnull +8 -> 18
    //   13: aload_0
    //   14: invokevirtual 254	android/content/Context:getFilesDir	()Ljava/io/File;
    //   17: pop
    //   18: aconst_null
    //   19: areturn
    //   20: aload_1
    //   21: astore_2
    //   22: invokestatic 259	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   25: ldc_w 261
    //   28: invokevirtual 265	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   31: ifeq +49 -> 80
    //   34: aload_1
    //   35: astore_2
    //   36: invokestatic 268	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual 272	java/io/File:canWrite	()Z
    //   44: ifne +13 -> 57
    //   47: aload_0
    //   48: invokevirtual 254	android/content/Context:getFilesDir	()Ljava/io/File;
    //   51: astore_2
    //   52: aload_2
    //   53: astore_1
    //   54: goto +33 -> 87
    //   57: aload_0
    //   58: ldc_w 274
    //   61: invokevirtual 278	android/content/Context:getExternalFilesDir	(Ljava/lang/String;)Ljava/io/File;
    //   64: astore_2
    //   65: aload_2
    //   66: astore_1
    //   67: goto +20 -> 87
    //   70: astore_2
    //   71: goto +68 -> 139
    //   74: astore_2
    //   75: aload_2
    //   76: astore_3
    //   77: goto +37 -> 114
    //   80: aload_1
    //   81: astore_2
    //   82: aload_0
    //   83: invokevirtual 254	android/content/Context:getFilesDir	()Ljava/io/File;
    //   86: astore_1
    //   87: aload_1
    //   88: ifnonnull +12 -> 100
    //   91: aload_0
    //   92: ifnull +8 -> 100
    //   95: aload_0
    //   96: invokevirtual 254	android/content/Context:getFilesDir	()Ljava/io/File;
    //   99: pop
    //   100: aload_1
    //   101: areturn
    //   102: astore_3
    //   103: aload_2
    //   104: astore_1
    //   105: aload_3
    //   106: astore_2
    //   107: goto +32 -> 139
    //   110: astore_3
    //   111: aload 4
    //   113: astore_1
    //   114: aload_1
    //   115: astore_2
    //   116: aload_3
    //   117: invokevirtual 279	java/lang/Exception:printStackTrace	()V
    //   120: aload_1
    //   121: astore_2
    //   122: aload_1
    //   123: ifnonnull +14 -> 137
    //   126: aload_1
    //   127: astore_2
    //   128: aload_0
    //   129: ifnull +8 -> 137
    //   132: aload_0
    //   133: invokevirtual 254	android/content/Context:getFilesDir	()Ljava/io/File;
    //   136: astore_2
    //   137: aload_2
    //   138: areturn
    //   139: aload_1
    //   140: ifnonnull +12 -> 152
    //   143: aload_0
    //   144: ifnull +8 -> 152
    //   147: aload_0
    //   148: invokevirtual 254	android/content/Context:getFilesDir	()Ljava/io/File;
    //   151: pop
    //   152: aload_2
    //   153: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	paramContext	Context
    //   4	136	1	localObject1	Object
    //   21	45	2	localObject2	Object
    //   70	1	2	localObject3	Object
    //   74	2	2	localException1	Exception
    //   81	72	2	localObject4	Object
    //   76	1	3	localException2	Exception
    //   102	4	3	localObject5	Object
    //   110	7	3	localException3	Exception
    //   1	111	4	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   40	52	70	finally
    //   57	65	70	finally
    //   40	52	74	java/lang/Exception
    //   57	65	74	java/lang/Exception
    //   22	34	102	finally
    //   36	40	102	finally
    //   82	87	102	finally
    //   116	120	102	finally
    //   22	34	110	java/lang/Exception
    //   36	40	110	java/lang/Exception
    //   82	87	110	java/lang/Exception
  }
  
  private static boolean b(InputStream paramInputStream)
    throws IOException
  {
    File localFile = new File(n);
    long l1 = localFile.length();
    int i1 = paramInputStream.available();
    if ((localFile.exists()) && (l1 == i1))
    {
      paramInputStream.close();
      return true;
    }
    return false;
  }
  
  /* Error */
  private static boolean c(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 298	com/amap/api/mapcore/util/es:d	(Landroid/content/Context;)V
    //   4: aconst_null
    //   5: astore 4
    //   7: aconst_null
    //   8: astore_2
    //   9: aload_0
    //   10: invokevirtual 151	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   13: invokevirtual 302	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   16: getstatic 71	com/amap/api/mapcore/util/es:l	Ljava/lang/String;
    //   19: invokevirtual 306	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   22: astore_0
    //   23: aload_0
    //   24: invokestatic 308	com/amap/api/mapcore/util/es:b	(Ljava/io/InputStream;)Z
    //   27: istore_1
    //   28: iload_1
    //   29: ifeq +29 -> 58
    //   32: aload_0
    //   33: ifnull +23 -> 56
    //   36: aload_0
    //   37: invokevirtual 295	java/io/InputStream:close	()V
    //   40: iconst_1
    //   41: ireturn
    //   42: astore_0
    //   43: aload_0
    //   44: invokevirtual 309	java/io/IOException:printStackTrace	()V
    //   47: aload_0
    //   48: ldc -122
    //   50: ldc_w 311
    //   53: invokestatic 141	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   56: iconst_1
    //   57: ireturn
    //   58: invokestatic 313	com/amap/api/mapcore/util/es:e	()V
    //   61: aload_0
    //   62: invokestatic 315	com/amap/api/mapcore/util/es:a	(Ljava/io/InputStream;)Ljava/io/OutputStream;
    //   65: astore_2
    //   66: aload_0
    //   67: ifnull +10 -> 77
    //   70: aload_0
    //   71: invokevirtual 295	java/io/InputStream:close	()V
    //   74: goto +3 -> 77
    //   77: aload_2
    //   78: ifnull +22 -> 100
    //   81: aload_2
    //   82: invokevirtual 316	java/io/OutputStream:close	()V
    //   85: iconst_1
    //   86: ireturn
    //   87: aload_0
    //   88: invokevirtual 309	java/io/IOException:printStackTrace	()V
    //   91: aload_0
    //   92: ldc -122
    //   94: ldc_w 311
    //   97: invokestatic 141	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   100: iconst_1
    //   101: ireturn
    //   102: astore_3
    //   103: aload_0
    //   104: astore_2
    //   105: goto +58 -> 163
    //   108: astore_3
    //   109: goto +11 -> 120
    //   112: astore_3
    //   113: goto +50 -> 163
    //   116: astore_3
    //   117: aload 4
    //   119: astore_0
    //   120: aload_0
    //   121: astore_2
    //   122: aload_3
    //   123: invokevirtual 203	java/lang/Throwable:printStackTrace	()V
    //   126: aload_0
    //   127: astore_2
    //   128: aload_3
    //   129: ldc -122
    //   131: ldc_w 311
    //   134: invokestatic 141	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   137: aload_0
    //   138: ifnull +23 -> 161
    //   141: aload_0
    //   142: invokevirtual 295	java/io/InputStream:close	()V
    //   145: iconst_0
    //   146: ireturn
    //   147: astore_0
    //   148: aload_0
    //   149: invokevirtual 309	java/io/IOException:printStackTrace	()V
    //   152: aload_0
    //   153: ldc -122
    //   155: ldc_w 311
    //   158: invokestatic 141	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   161: iconst_0
    //   162: ireturn
    //   163: aload_2
    //   164: ifnull +24 -> 188
    //   167: aload_2
    //   168: invokevirtual 295	java/io/InputStream:close	()V
    //   171: goto +17 -> 188
    //   174: astore_0
    //   175: aload_0
    //   176: invokevirtual 309	java/io/IOException:printStackTrace	()V
    //   179: aload_0
    //   180: ldc -122
    //   182: ldc_w 311
    //   185: invokestatic 141	com/amap/api/mapcore/util/gk:c	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   188: aload_3
    //   189: athrow
    //   190: astore_0
    //   191: goto -104 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	paramContext	Context
    //   27	2	1	bool	boolean
    //   8	160	2	localObject1	Object
    //   102	1	3	localObject2	Object
    //   108	1	3	localThrowable1	Throwable
    //   112	1	3	localObject3	Object
    //   116	73	3	localThrowable2	Throwable
    //   5	113	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   36	40	42	java/io/IOException
    //   23	28	102	finally
    //   58	66	102	finally
    //   23	28	108	java/lang/Throwable
    //   58	66	108	java/lang/Throwable
    //   9	23	112	finally
    //   122	126	112	finally
    //   128	137	112	finally
    //   9	23	116	java/lang/Throwable
    //   141	145	147	java/io/IOException
    //   167	171	174	java/io/IOException
    //   70	74	190	java/io/IOException
    //   81	85	190	java/io/IOException
  }
  
  private static void d(Context paramContext)
  {
    m = paramContext.getFilesDir().getAbsolutePath();
    paramContext = new StringBuilder();
    paramContext.append(m);
    paramContext.append("/");
    paramContext.append(k);
    n = paramContext.toString();
  }
  
  private static void e()
  {
    File[] arrayOfFile = new File(m).listFiles(new a());
    if ((arrayOfFile != null) && (arrayOfFile.length > 0))
    {
      int i2 = arrayOfFile.length;
      int i1 = 0;
      while (i1 < i2)
      {
        arrayOfFile[i1].delete();
        i1 += 1;
      }
    }
  }
  
  static class a
    implements FilenameFilter
  {
    public boolean accept(File paramFile, String paramString)
    {
      paramFile = new StringBuilder();
      paramFile.append(es.b());
      paramFile.append(es.c());
      paramFile = paramFile.toString();
      return (paramString.startsWith(es.d())) && (!paramString.endsWith(paramFile));
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\es.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */