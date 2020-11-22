package com.autonavi.base.amap.mapcore.tools;

import android.content.Context;
import java.io.Closeable;
import java.io.File;

public class GLFileUtil
{
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception paramCloseable) {}
  }
  
  /* Error */
  public static void copy(Context paramContext, String paramString, File paramFile)
    throws Exception
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 26	java/io/File:delete	()Z
    //   4: pop
    //   5: aload_0
    //   6: invokevirtual 32	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   9: aload_1
    //   10: invokevirtual 38	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   13: astore_0
    //   14: aload_0
    //   15: invokevirtual 44	java/io/InputStream:available	()I
    //   18: newarray <illegal type>
    //   20: astore_1
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 48	java/io/InputStream:read	([B)I
    //   26: pop
    //   27: aload_0
    //   28: invokestatic 50	com/autonavi/base/amap/mapcore/tools/GLFileUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   31: new 52	java/io/FileOutputStream
    //   34: dup
    //   35: aload_2
    //   36: invokespecial 55	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   39: astore_0
    //   40: aload_0
    //   41: aload_1
    //   42: invokevirtual 59	java/io/FileOutputStream:write	([B)V
    //   45: aload_0
    //   46: invokestatic 50	com/autonavi/base/amap/mapcore/tools/GLFileUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   49: return
    //   50: astore_1
    //   51: aload_0
    //   52: invokestatic 50	com/autonavi/base/amap/mapcore/tools/GLFileUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   55: aload_1
    //   56: athrow
    //   57: astore_1
    //   58: aload_0
    //   59: invokestatic 50	com/autonavi/base/amap/mapcore/tools/GLFileUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	paramContext	Context
    //   0	64	1	paramString	String
    //   0	64	2	paramFile	File
    // Exception table:
    //   from	to	target	type
    //   40	45	50	finally
    //   21	27	57	finally
  }
  
  public static void deleteFile(File paramFile)
  {
    if (paramFile == null) {
      return;
    }
    File[] arrayOfFile = paramFile.listFiles();
    if ((paramFile.isDirectory()) && (arrayOfFile != null))
    {
      int i = 0;
      int j = arrayOfFile.length;
      while (i < j)
      {
        deleteFile(arrayOfFile[i]);
        i += 1;
      }
    }
    paramFile.delete();
  }
  
  public static File getCacheDir(Context paramContext)
  {
    Object localObject2 = paramContext.getCacheDir();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramContext.getDir("cache", 0);
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("/data/data/");
      ((StringBuilder)localObject1).append(paramContext.getPackageName());
      ((StringBuilder)localObject1).append("/app_cache");
      localObject2 = new File(((StringBuilder)localObject1).toString());
    }
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    return (File)localObject2;
  }
  
  public static File getFilesDir(Context paramContext)
  {
    Object localObject2 = paramContext.getFilesDir();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramContext.getDir("files", 0);
    }
    localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("/data/data/");
      ((StringBuilder)localObject1).append(paramContext.getPackageName());
      ((StringBuilder)localObject1).append("/app_files");
      localObject2 = new File(((StringBuilder)localObject1).toString());
    }
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    return (File)localObject2;
  }
  
  /* Error */
  public static byte[] readFileContents(String paramString)
  {
    // Byte code:
    //   0: new 22	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 102	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 105	java/io/File:exists	()Z
    //   13: istore_2
    //   14: iload_2
    //   15: ifne +9 -> 24
    //   18: aconst_null
    //   19: invokestatic 50	com/autonavi/base/amap/mapcore/tools/GLFileUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   22: aconst_null
    //   23: areturn
    //   24: new 119	java/io/FileInputStream
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 120	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   32: astore_0
    //   33: sipush 1024
    //   36: newarray <illegal type>
    //   38: astore_3
    //   39: new 122	java/io/ByteArrayOutputStream
    //   42: dup
    //   43: invokespecial 123	java/io/ByteArrayOutputStream:<init>	()V
    //   46: astore 4
    //   48: aload_0
    //   49: aload_3
    //   50: invokevirtual 124	java/io/FileInputStream:read	([B)I
    //   53: istore_1
    //   54: iload_1
    //   55: iconst_m1
    //   56: if_icmpeq +14 -> 70
    //   59: aload 4
    //   61: aload_3
    //   62: iconst_0
    //   63: iload_1
    //   64: invokevirtual 127	java/io/ByteArrayOutputStream:write	([BII)V
    //   67: goto -19 -> 48
    //   70: aload 4
    //   72: invokevirtual 128	java/io/ByteArrayOutputStream:close	()V
    //   75: aload 4
    //   77: invokevirtual 132	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   80: astore_3
    //   81: aload_0
    //   82: invokestatic 50	com/autonavi/base/amap/mapcore/tools/GLFileUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   85: aload_3
    //   86: areturn
    //   87: astore_3
    //   88: aload_0
    //   89: astore 4
    //   91: goto +9 -> 100
    //   94: astore_0
    //   95: aconst_null
    //   96: astore 4
    //   98: aload_0
    //   99: astore_3
    //   100: aload 4
    //   102: invokestatic 50	com/autonavi/base/amap/mapcore/tools/GLFileUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   105: aload_3
    //   106: athrow
    //   107: aconst_null
    //   108: astore_0
    //   109: aload_0
    //   110: invokestatic 50	com/autonavi/base/amap/mapcore/tools/GLFileUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   113: aconst_null
    //   114: areturn
    //   115: astore_0
    //   116: goto -9 -> 107
    //   119: astore_3
    //   120: goto -11 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	paramString	String
    //   53	11	1	i	int
    //   13	2	2	bool	boolean
    //   38	48	3	arrayOfByte	byte[]
    //   87	1	3	localObject1	Object
    //   99	7	3	str	String
    //   119	1	3	localException	Exception
    //   46	55	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   33	48	87	finally
    //   48	54	87	finally
    //   59	67	87	finally
    //   70	81	87	finally
    //   0	14	94	finally
    //   24	33	94	finally
    //   0	14	115	java/lang/Exception
    //   24	33	115	java/lang/Exception
    //   33	48	119	java/lang/Exception
    //   48	54	119	java/lang/Exception
    //   59	67	119	java/lang/Exception
    //   70	81	119	java/lang/Exception
  }
  
  /* Error */
  public static void writeDatasToFile(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 136	java/util/concurrent/locks/ReentrantReadWriteLock
    //   3: dup
    //   4: invokespecial 137	java/util/concurrent/locks/ReentrantReadWriteLock:<init>	()V
    //   7: invokevirtual 141	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   10: astore 4
    //   12: aload 4
    //   14: invokevirtual 146	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   17: aconst_null
    //   18: astore_3
    //   19: aconst_null
    //   20: astore_2
    //   21: aload_1
    //   22: ifnull +116 -> 138
    //   25: aload_1
    //   26: arraylength
    //   27: ifne +6 -> 33
    //   30: goto +108 -> 138
    //   33: new 22	java/io/File
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 102	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: astore_0
    //   42: aload_0
    //   43: invokevirtual 149	java/io/File:getParentFile	()Ljava/io/File;
    //   46: astore 5
    //   48: aload 5
    //   50: invokevirtual 105	java/io/File:exists	()Z
    //   53: ifne +9 -> 62
    //   56: aload 5
    //   58: invokevirtual 108	java/io/File:mkdirs	()Z
    //   61: pop
    //   62: aload_0
    //   63: invokevirtual 105	java/io/File:exists	()Z
    //   66: ifeq +8 -> 74
    //   69: aload_0
    //   70: invokevirtual 26	java/io/File:delete	()Z
    //   73: pop
    //   74: aload_0
    //   75: invokevirtual 152	java/io/File:createNewFile	()Z
    //   78: pop
    //   79: new 52	java/io/FileOutputStream
    //   82: dup
    //   83: aload_0
    //   84: invokespecial 55	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   87: astore_0
    //   88: aload_0
    //   89: aload_1
    //   90: invokevirtual 155	java/io/OutputStream:write	([B)V
    //   93: aload_0
    //   94: invokevirtual 158	java/io/OutputStream:flush	()V
    //   97: aload 4
    //   99: invokevirtual 161	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   102: aload_0
    //   103: invokestatic 50	com/autonavi/base/amap/mapcore/tools/GLFileUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   106: return
    //   107: astore_1
    //   108: goto +9 -> 117
    //   111: goto +17 -> 128
    //   114: astore_1
    //   115: aload_2
    //   116: astore_0
    //   117: aload 4
    //   119: invokevirtual 161	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   122: aload_0
    //   123: invokestatic 50	com/autonavi/base/amap/mapcore/tools/GLFileUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   126: aload_1
    //   127: athrow
    //   128: aload 4
    //   130: invokevirtual 161	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   133: aload_0
    //   134: invokestatic 50	com/autonavi/base/amap/mapcore/tools/GLFileUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   137: return
    //   138: aload 4
    //   140: invokevirtual 161	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   143: aconst_null
    //   144: invokestatic 50	com/autonavi/base/amap/mapcore/tools/GLFileUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   147: return
    //   148: astore_0
    //   149: aload_3
    //   150: astore_0
    //   151: goto -23 -> 128
    //   154: astore_1
    //   155: goto -44 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	paramString	String
    //   0	158	1	paramArrayOfByte	byte[]
    //   20	96	2	localObject1	Object
    //   18	132	3	localObject2	Object
    //   10	129	4	localWriteLock	java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock
    //   46	11	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   88	97	107	finally
    //   25	30	114	finally
    //   33	62	114	finally
    //   62	74	114	finally
    //   74	88	114	finally
    //   25	30	148	java/lang/Exception
    //   33	62	148	java/lang/Exception
    //   62	74	148	java/lang/Exception
    //   74	88	148	java/lang/Exception
    //   88	97	154	java/lang/Exception
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\mapcore\tools\GLFileUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */