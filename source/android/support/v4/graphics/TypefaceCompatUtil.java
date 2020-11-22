package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.os.Process;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class TypefaceCompatUtil
{
  private static final String CACHE_FILE_PREFIX = ".font";
  private static final String TAG = "TypefaceCompatUtil";
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  @Nullable
  @RequiresApi(19)
  public static ByteBuffer copyToDirectBuffer(Context paramContext, Resources paramResources, int paramInt)
  {
    paramContext = getTempFile(paramContext);
    if (paramContext == null) {
      return null;
    }
    try
    {
      boolean bool = copyToFile(paramContext, paramResources, paramInt);
      if (!bool) {
        return null;
      }
      paramResources = mmap(paramContext);
      return paramResources;
    }
    finally
    {
      paramContext.delete();
    }
  }
  
  /* Error */
  public static boolean copyToFile(File paramFile, Resources paramResources, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: iload_2
    //   2: invokevirtual 59	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   5: astore_1
    //   6: aload_0
    //   7: aload_1
    //   8: invokestatic 62	android/support/v4/graphics/TypefaceCompatUtil:copyToFile	(Ljava/io/File;Ljava/io/InputStream;)Z
    //   11: istore_3
    //   12: aload_1
    //   13: invokestatic 64	android/support/v4/graphics/TypefaceCompatUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   16: iload_3
    //   17: ireturn
    //   18: astore_0
    //   19: goto +6 -> 25
    //   22: astore_0
    //   23: aconst_null
    //   24: astore_1
    //   25: aload_1
    //   26: invokestatic 64	android/support/v4/graphics/TypefaceCompatUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   29: aload_0
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	paramFile	File
    //   0	31	1	paramResources	Resources
    //   0	31	2	paramInt	int
    //   11	6	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	12	18	finally
    //   0	6	22	finally
  }
  
  /* Error */
  public static boolean copyToFile(File paramFile, java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: invokestatic 70	android/os/StrictMode:allowThreadDiskWrites	()Landroid/os/StrictMode$ThreadPolicy;
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore_3
    //   10: new 72	java/io/FileOutputStream
    //   13: dup
    //   14: aload_0
    //   15: iconst_0
    //   16: invokespecial 75	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   19: astore_0
    //   20: sipush 1024
    //   23: newarray <illegal type>
    //   25: astore_3
    //   26: aload_1
    //   27: aload_3
    //   28: invokevirtual 81	java/io/InputStream:read	([B)I
    //   31: istore_2
    //   32: iload_2
    //   33: iconst_m1
    //   34: if_icmpeq +13 -> 47
    //   37: aload_0
    //   38: aload_3
    //   39: iconst_0
    //   40: iload_2
    //   41: invokevirtual 85	java/io/FileOutputStream:write	([BII)V
    //   44: goto -18 -> 26
    //   47: aload_0
    //   48: invokestatic 64	android/support/v4/graphics/TypefaceCompatUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   51: aload 5
    //   53: invokestatic 89	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   56: iconst_1
    //   57: ireturn
    //   58: astore_1
    //   59: aload_0
    //   60: astore_3
    //   61: aload_1
    //   62: astore_0
    //   63: goto +72 -> 135
    //   66: astore_1
    //   67: goto +11 -> 78
    //   70: astore_0
    //   71: goto +64 -> 135
    //   74: astore_1
    //   75: aload 4
    //   77: astore_0
    //   78: aload_0
    //   79: astore_3
    //   80: new 91	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   87: astore 4
    //   89: aload_0
    //   90: astore_3
    //   91: aload 4
    //   93: ldc 94
    //   95: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload_0
    //   100: astore_3
    //   101: aload 4
    //   103: aload_1
    //   104: invokevirtual 102	java/io/IOException:getMessage	()Ljava/lang/String;
    //   107: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload_0
    //   112: astore_3
    //   113: ldc 15
    //   115: aload 4
    //   117: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 111	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   123: pop
    //   124: aload_0
    //   125: invokestatic 64	android/support/v4/graphics/TypefaceCompatUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   128: aload 5
    //   130: invokestatic 89	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   133: iconst_0
    //   134: ireturn
    //   135: aload_3
    //   136: invokestatic 64	android/support/v4/graphics/TypefaceCompatUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   139: aload 5
    //   141: invokestatic 89	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   144: aload_0
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramFile	File
    //   0	146	1	paramInputStream	java.io.InputStream
    //   31	10	2	i	int
    //   9	127	3	localObject	Object
    //   6	110	4	localStringBuilder	StringBuilder
    //   3	137	5	localThreadPolicy	android.os.StrictMode.ThreadPolicy
    // Exception table:
    //   from	to	target	type
    //   20	26	58	finally
    //   26	32	58	finally
    //   37	44	58	finally
    //   20	26	66	java/io/IOException
    //   26	32	66	java/io/IOException
    //   37	44	66	java/io/IOException
    //   10	20	70	finally
    //   80	89	70	finally
    //   91	99	70	finally
    //   101	111	70	finally
    //   113	124	70	finally
    //   10	20	74	java/io/IOException
  }
  
  @Nullable
  public static File getTempFile(Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(".font");
    ((StringBuilder)localObject).append(Process.myPid());
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(Process.myTid());
    ((StringBuilder)localObject).append("-");
    localObject = ((StringBuilder)localObject).toString();
    int i = 0;
    while (i < 100)
    {
      File localFile = paramContext.getCacheDir();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(i);
      localFile = new File(localFile, localStringBuilder.toString());
      try
      {
        boolean bool = localFile.createNewFile();
        if (bool) {
          return localFile;
        }
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
      i += 1;
    }
    return null;
  }
  
  /* Error */
  @Nullable
  @RequiresApi(19)
  public static ByteBuffer mmap(Context paramContext, android.os.CancellationSignal paramCancellationSignal, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 144	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore_0
    //   5: aload_0
    //   6: aload_2
    //   7: ldc -110
    //   9: aload_1
    //   10: invokevirtual 152	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnonnull +13 -> 28
    //   18: aload_2
    //   19: ifnull +7 -> 26
    //   22: aload_2
    //   23: invokevirtual 155	android/os/ParcelFileDescriptor:close	()V
    //   26: aconst_null
    //   27: areturn
    //   28: new 157	java/io/FileInputStream
    //   31: dup
    //   32: aload_2
    //   33: invokevirtual 161	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   36: invokespecial 164	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   39: astore 5
    //   41: aload 5
    //   43: invokevirtual 168	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   46: astore_0
    //   47: aload_0
    //   48: invokevirtual 174	java/nio/channels/FileChannel:size	()J
    //   51: lstore_3
    //   52: aload_0
    //   53: getstatic 180	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   56: lconst_0
    //   57: lload_3
    //   58: invokevirtual 184	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   61: astore_0
    //   62: aload 5
    //   64: invokevirtual 185	java/io/FileInputStream:close	()V
    //   67: aload_2
    //   68: ifnull +7 -> 75
    //   71: aload_2
    //   72: invokevirtual 155	android/os/ParcelFileDescriptor:close	()V
    //   75: aload_0
    //   76: areturn
    //   77: astore_1
    //   78: aconst_null
    //   79: astore_0
    //   80: goto +7 -> 87
    //   83: astore_0
    //   84: aload_0
    //   85: athrow
    //   86: astore_1
    //   87: aload_0
    //   88: ifnull +22 -> 110
    //   91: aload 5
    //   93: invokevirtual 185	java/io/FileInputStream:close	()V
    //   96: goto +19 -> 115
    //   99: astore 5
    //   101: aload_0
    //   102: aload 5
    //   104: invokevirtual 189	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   107: goto +8 -> 115
    //   110: aload 5
    //   112: invokevirtual 185	java/io/FileInputStream:close	()V
    //   115: aload_1
    //   116: athrow
    //   117: astore_0
    //   118: aconst_null
    //   119: astore_1
    //   120: goto +7 -> 127
    //   123: astore_1
    //   124: aload_1
    //   125: athrow
    //   126: astore_0
    //   127: aload_2
    //   128: ifnull +27 -> 155
    //   131: aload_1
    //   132: ifnull +19 -> 151
    //   135: aload_2
    //   136: invokevirtual 155	android/os/ParcelFileDescriptor:close	()V
    //   139: goto +16 -> 155
    //   142: astore_2
    //   143: aload_1
    //   144: aload_2
    //   145: invokevirtual 189	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   148: goto +7 -> 155
    //   151: aload_2
    //   152: invokevirtual 155	android/os/ParcelFileDescriptor:close	()V
    //   155: aload_0
    //   156: athrow
    //   157: astore_0
    //   158: aconst_null
    //   159: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	paramContext	Context
    //   0	160	1	paramCancellationSignal	android.os.CancellationSignal
    //   0	160	2	paramUri	android.net.Uri
    //   51	7	3	l	long
    //   39	53	5	localFileInputStream	java.io.FileInputStream
    //   99	12	5	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   41	62	77	finally
    //   41	62	83	java/lang/Throwable
    //   84	86	86	finally
    //   91	96	99	java/lang/Throwable
    //   28	41	117	finally
    //   62	67	117	finally
    //   91	96	117	finally
    //   101	107	117	finally
    //   110	115	117	finally
    //   115	117	117	finally
    //   28	41	123	java/lang/Throwable
    //   62	67	123	java/lang/Throwable
    //   101	107	123	java/lang/Throwable
    //   110	115	123	java/lang/Throwable
    //   115	117	123	java/lang/Throwable
    //   124	126	126	finally
    //   135	139	142	java/lang/Throwable
    //   5	14	157	java/io/IOException
    //   22	26	157	java/io/IOException
    //   71	75	157	java/io/IOException
    //   135	139	157	java/io/IOException
    //   143	148	157	java/io/IOException
    //   151	155	157	java/io/IOException
    //   155	157	157	java/io/IOException
  }
  
  /* Error */
  @Nullable
  @RequiresApi(19)
  private static ByteBuffer mmap(File paramFile)
  {
    // Byte code:
    //   0: new 157	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 192	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore 4
    //   10: aload 4
    //   12: invokevirtual 168	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   15: astore_0
    //   16: aload_0
    //   17: invokevirtual 174	java/nio/channels/FileChannel:size	()J
    //   20: lstore_1
    //   21: aload_0
    //   22: getstatic 180	java/nio/channels/FileChannel$MapMode:READ_ONLY	Ljava/nio/channels/FileChannel$MapMode;
    //   25: lconst_0
    //   26: lload_1
    //   27: invokevirtual 184	java/nio/channels/FileChannel:map	(Ljava/nio/channels/FileChannel$MapMode;JJ)Ljava/nio/MappedByteBuffer;
    //   30: astore_0
    //   31: aload 4
    //   33: invokevirtual 185	java/io/FileInputStream:close	()V
    //   36: aload_0
    //   37: areturn
    //   38: astore_3
    //   39: aconst_null
    //   40: astore_0
    //   41: goto +7 -> 48
    //   44: astore_0
    //   45: aload_0
    //   46: athrow
    //   47: astore_3
    //   48: aload_0
    //   49: ifnull +22 -> 71
    //   52: aload 4
    //   54: invokevirtual 185	java/io/FileInputStream:close	()V
    //   57: goto +19 -> 76
    //   60: astore 4
    //   62: aload_0
    //   63: aload 4
    //   65: invokevirtual 189	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   68: goto +8 -> 76
    //   71: aload 4
    //   73: invokevirtual 185	java/io/FileInputStream:close	()V
    //   76: aload_3
    //   77: athrow
    //   78: astore_0
    //   79: aconst_null
    //   80: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	paramFile	File
    //   20	7	1	l	long
    //   38	1	3	localObject1	Object
    //   47	30	3	localObject2	Object
    //   8	45	4	localFileInputStream	java.io.FileInputStream
    //   60	12	4	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   10	31	38	finally
    //   10	31	44	java/lang/Throwable
    //   45	47	47	finally
    //   52	57	60	java/lang/Throwable
    //   0	10	78	java/io/IOException
    //   31	36	78	java/io/IOException
    //   52	57	78	java/io/IOException
    //   62	68	78	java/io/IOException
    //   71	76	78	java/io/IOException
    //   76	78	78	java/io/IOException
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\graphics\TypefaceCompatUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */