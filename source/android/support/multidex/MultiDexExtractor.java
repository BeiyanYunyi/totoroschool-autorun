package android.support.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipFile;

final class MultiDexExtractor
{
  private static final int BUFFER_SIZE = 16384;
  private static final String DEX_PREFIX = "classes";
  private static final String DEX_SUFFIX = ".dex";
  private static final String EXTRACTED_NAME_EXT = ".classes";
  private static final String EXTRACTED_SUFFIX = ".zip";
  private static final String KEY_CRC = "crc";
  private static final String KEY_DEX_CRC = "dex.crc.";
  private static final String KEY_DEX_NUMBER = "dex.number";
  private static final String KEY_DEX_TIME = "dex.time.";
  private static final String KEY_TIME_STAMP = "timestamp";
  private static final String LOCK_FILENAME = "MultiDex.lock";
  private static final int MAX_EXTRACT_ATTEMPTS = 3;
  private static final long NO_VALUE = -1L;
  private static final String PREFS_FILE = "multidex.version";
  private static final String TAG = "MultiDex";
  
  private static void closeQuietly(Closeable paramCloseable)
  {
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      Log.w("MultiDex", "Failed to close resource", paramCloseable);
    }
  }
  
  /* Error */
  private static void extract(ZipFile paramZipFile, java.util.zip.ZipEntry paramZipEntry, File paramFile, String paramString)
    throws IOException, java.io.FileNotFoundException
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 87	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   5: astore_0
    //   6: new 89	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   13: astore 6
    //   15: aload 6
    //   17: ldc 92
    //   19: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 6
    //   25: aload_3
    //   26: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 6
    //   32: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: ldc 25
    //   37: aload_2
    //   38: invokevirtual 106	java/io/File:getParentFile	()Ljava/io/File;
    //   41: invokestatic 110	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    //   44: astore_3
    //   45: new 89	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   52: astore 6
    //   54: aload 6
    //   56: ldc 112
    //   58: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload 6
    //   64: aload_3
    //   65: invokevirtual 115	java/io/File:getPath	()Ljava/lang/String;
    //   68: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: ldc 55
    //   74: aload 6
    //   76: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 119	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   82: pop
    //   83: new 121	java/util/zip/ZipOutputStream
    //   86: dup
    //   87: new 123	java/io/BufferedOutputStream
    //   90: dup
    //   91: new 125	java/io/FileOutputStream
    //   94: dup
    //   95: aload_3
    //   96: invokespecial 128	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   99: invokespecial 131	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   102: invokespecial 132	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   105: astore 6
    //   107: new 134	java/util/zip/ZipEntry
    //   110: dup
    //   111: ldc -120
    //   113: invokespecial 139	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   116: astore 7
    //   118: aload 7
    //   120: aload_1
    //   121: invokevirtual 143	java/util/zip/ZipEntry:getTime	()J
    //   124: invokevirtual 147	java/util/zip/ZipEntry:setTime	(J)V
    //   127: aload 6
    //   129: aload 7
    //   131: invokevirtual 151	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   134: sipush 16384
    //   137: newarray <illegal type>
    //   139: astore_1
    //   140: aload_0
    //   141: aload_1
    //   142: invokevirtual 157	java/io/InputStream:read	([B)I
    //   145: istore 4
    //   147: iload 4
    //   149: iconst_m1
    //   150: if_icmpeq +22 -> 172
    //   153: aload 6
    //   155: aload_1
    //   156: iconst_0
    //   157: iload 4
    //   159: invokevirtual 161	java/util/zip/ZipOutputStream:write	([BII)V
    //   162: aload_0
    //   163: aload_1
    //   164: invokevirtual 157	java/io/InputStream:read	([B)I
    //   167: istore 4
    //   169: goto -22 -> 147
    //   172: aload 6
    //   174: invokevirtual 164	java/util/zip/ZipOutputStream:closeEntry	()V
    //   177: aload 6
    //   179: invokevirtual 165	java/util/zip/ZipOutputStream:close	()V
    //   182: aload_3
    //   183: invokevirtual 169	java/io/File:setReadOnly	()Z
    //   186: ifeq +118 -> 304
    //   189: new 89	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   196: astore_1
    //   197: aload_1
    //   198: ldc -85
    //   200: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload_1
    //   205: aload_2
    //   206: invokevirtual 115	java/io/File:getPath	()Ljava/lang/String;
    //   209: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: ldc 55
    //   215: aload_1
    //   216: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 119	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   222: pop
    //   223: aload_3
    //   224: aload_2
    //   225: invokevirtual 175	java/io/File:renameTo	(Ljava/io/File;)Z
    //   228: istore 5
    //   230: iload 5
    //   232: ifeq +13 -> 245
    //   235: aload_0
    //   236: invokestatic 177	android/support/multidex/MultiDexExtractor:closeQuietly	(Ljava/io/Closeable;)V
    //   239: aload_3
    //   240: invokevirtual 180	java/io/File:delete	()Z
    //   243: pop
    //   244: return
    //   245: new 89	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   252: astore_1
    //   253: aload_1
    //   254: ldc -74
    //   256: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload_1
    //   261: aload_3
    //   262: invokevirtual 185	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   265: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload_1
    //   270: ldc -69
    //   272: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload_1
    //   277: aload_2
    //   278: invokevirtual 185	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   281: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload_1
    //   286: ldc -67
    //   288: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: new 64	java/io/IOException
    //   295: dup
    //   296: aload_1
    //   297: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokespecial 190	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   303: athrow
    //   304: new 89	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   311: astore_1
    //   312: aload_1
    //   313: ldc -64
    //   315: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload_1
    //   320: aload_3
    //   321: invokevirtual 185	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   324: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload_1
    //   329: ldc -62
    //   331: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload_1
    //   336: aload_2
    //   337: invokevirtual 185	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   340: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload_1
    //   345: ldc -60
    //   347: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: new 64	java/io/IOException
    //   354: dup
    //   355: aload_1
    //   356: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: invokespecial 190	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   362: athrow
    //   363: astore_1
    //   364: aload 6
    //   366: invokevirtual 165	java/util/zip/ZipOutputStream:close	()V
    //   369: aload_1
    //   370: athrow
    //   371: astore_1
    //   372: aload_0
    //   373: invokestatic 177	android/support/multidex/MultiDexExtractor:closeQuietly	(Ljava/io/Closeable;)V
    //   376: aload_3
    //   377: invokevirtual 180	java/io/File:delete	()Z
    //   380: pop
    //   381: aload_1
    //   382: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	383	0	paramZipFile	ZipFile
    //   0	383	1	paramZipEntry	java.util.zip.ZipEntry
    //   0	383	2	paramFile	File
    //   0	383	3	paramString	String
    //   145	23	4	i	int
    //   228	3	5	bool	boolean
    //   13	352	6	localObject	Object
    //   116	14	7	localZipEntry	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   107	147	363	finally
    //   153	169	363	finally
    //   172	177	363	finally
    //   83	107	371	finally
    //   177	230	371	finally
    //   245	304	371	finally
    //   304	363	371	finally
    //   364	371	371	finally
  }
  
  private static SharedPreferences getMultiDexPreferences(Context paramContext)
  {
    int i;
    if (Build.VERSION.SDK_INT < 11) {
      i = 0;
    } else {
      i = 4;
    }
    return paramContext.getSharedPreferences("multidex.version", i);
  }
  
  private static long getTimeStamp(File paramFile)
  {
    long l2 = paramFile.lastModified();
    long l1 = l2;
    if (l2 == -1L) {
      l1 = l2 - 1L;
    }
    return l1;
  }
  
  private static long getZipCrc(File paramFile)
    throws IOException
  {
    long l2 = ZipUtil.getZipCrc(paramFile);
    long l1 = l2;
    if (l2 == -1L) {
      l1 = l2 - 1L;
    }
    return l1;
  }
  
  private static boolean isModified(Context paramContext, File paramFile, long paramLong, String paramString)
  {
    paramContext = getMultiDexPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("timestamp");
    if (paramContext.getLong(localStringBuilder.toString(), -1L) == getTimeStamp(paramFile))
    {
      paramFile = new StringBuilder();
      paramFile.append(paramString);
      paramFile.append("crc");
      if (paramContext.getLong(paramFile.toString(), -1L) == paramLong) {
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  static List<? extends File> load(Context paramContext, File paramFile1, File paramFile2, String paramString, boolean paramBoolean)
    throws IOException
  {
    // Byte code:
    //   0: new 89	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   7: astore 7
    //   9: aload 7
    //   11: ldc -20
    //   13: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 7
    //   19: aload_1
    //   20: invokevirtual 115	java/io/File:getPath	()Ljava/lang/String;
    //   23: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload 7
    //   29: ldc -18
    //   31: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 7
    //   37: iload 4
    //   39: invokevirtual 241	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload 7
    //   45: ldc -18
    //   47: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload 7
    //   53: aload_3
    //   54: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload 7
    //   60: ldc -13
    //   62: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: ldc 55
    //   68: aload 7
    //   70: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 119	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   76: pop
    //   77: aload_1
    //   78: invokestatic 244	android/support/multidex/MultiDexExtractor:getZipCrc	(Ljava/io/File;)J
    //   81: lstore 5
    //   83: new 102	java/io/File
    //   86: dup
    //   87: aload_2
    //   88: ldc 43
    //   90: invokespecial 247	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   93: astore 11
    //   95: new 249	java/io/RandomAccessFile
    //   98: dup
    //   99: aload 11
    //   101: ldc -5
    //   103: invokespecial 252	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   106: astore 10
    //   108: aload 10
    //   110: invokevirtual 256	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   113: astore 7
    //   115: new 89	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   122: astore 8
    //   124: aload 8
    //   126: ldc_w 258
    //   129: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload 8
    //   135: aload 11
    //   137: invokevirtual 115	java/io/File:getPath	()Ljava/lang/String;
    //   140: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: pop
    //   144: ldc 55
    //   146: aload 8
    //   148: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 119	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   154: pop
    //   155: aload 7
    //   157: invokevirtual 264	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   160: astore 8
    //   162: new 89	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   169: astore 9
    //   171: aload 9
    //   173: aload 11
    //   175: invokevirtual 115	java/io/File:getPath	()Ljava/lang/String;
    //   178: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload 9
    //   184: ldc_w 266
    //   187: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: ldc 55
    //   193: aload 9
    //   195: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokestatic 119	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   201: pop
    //   202: iload 4
    //   204: ifne +314 -> 518
    //   207: aload_0
    //   208: aload_1
    //   209: lload 5
    //   211: aload_3
    //   212: invokestatic 268	android/support/multidex/MultiDexExtractor:isModified	(Landroid/content/Context;Ljava/io/File;JLjava/lang/String;)Z
    //   215: istore 4
    //   217: iload 4
    //   219: ifne +54 -> 273
    //   222: aload_0
    //   223: aload_1
    //   224: aload_2
    //   225: aload_3
    //   226: invokestatic 272	android/support/multidex/MultiDexExtractor:loadExistingExtractions	(Landroid/content/Context;Ljava/io/File;Ljava/io/File;Ljava/lang/String;)Ljava/util/List;
    //   229: astore 9
    //   231: aload 9
    //   233: astore_0
    //   234: goto +71 -> 305
    //   237: astore 9
    //   239: ldc 55
    //   241: ldc_w 274
    //   244: aload 9
    //   246: invokestatic 77	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   249: pop
    //   250: aload_1
    //   251: aload_2
    //   252: invokestatic 278	android/support/multidex/MultiDexExtractor:performExtractions	(Ljava/io/File;Ljava/io/File;)Ljava/util/List;
    //   255: astore_2
    //   256: aload_0
    //   257: aload_3
    //   258: aload_1
    //   259: invokestatic 232	android/support/multidex/MultiDexExtractor:getTimeStamp	(Ljava/io/File;)J
    //   262: lload 5
    //   264: aload_2
    //   265: invokestatic 282	android/support/multidex/MultiDexExtractor:putStoredApkInfo	(Landroid/content/Context;Ljava/lang/String;JJLjava/util/List;)V
    //   268: aload_2
    //   269: astore_0
    //   270: goto -36 -> 234
    //   273: ldc 55
    //   275: ldc_w 284
    //   278: invokestatic 119	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   281: pop
    //   282: aload_1
    //   283: aload_2
    //   284: invokestatic 278	android/support/multidex/MultiDexExtractor:performExtractions	(Ljava/io/File;Ljava/io/File;)Ljava/util/List;
    //   287: astore_2
    //   288: aload_0
    //   289: aload_3
    //   290: aload_1
    //   291: invokestatic 232	android/support/multidex/MultiDexExtractor:getTimeStamp	(Ljava/io/File;)J
    //   294: lload 5
    //   296: aload_2
    //   297: invokestatic 282	android/support/multidex/MultiDexExtractor:putStoredApkInfo	(Landroid/content/Context;Ljava/lang/String;JJLjava/util/List;)V
    //   300: aload_2
    //   301: astore_0
    //   302: goto -68 -> 234
    //   305: aload 8
    //   307: ifnull +51 -> 358
    //   310: aload 8
    //   312: invokevirtual 289	java/nio/channels/FileLock:release	()V
    //   315: goto +43 -> 358
    //   318: astore_1
    //   319: new 89	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   326: astore_2
    //   327: aload_2
    //   328: ldc_w 291
    //   331: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: aload_2
    //   336: aload 11
    //   338: invokevirtual 115	java/io/File:getPath	()Ljava/lang/String;
    //   341: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: ldc 55
    //   347: aload_2
    //   348: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokestatic 294	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   354: pop
    //   355: goto +5 -> 360
    //   358: aconst_null
    //   359: astore_1
    //   360: aload 7
    //   362: ifnull +8 -> 370
    //   365: aload 7
    //   367: invokestatic 177	android/support/multidex/MultiDexExtractor:closeQuietly	(Ljava/io/Closeable;)V
    //   370: aload 10
    //   372: invokestatic 177	android/support/multidex/MultiDexExtractor:closeQuietly	(Ljava/io/Closeable;)V
    //   375: aload_1
    //   376: ifnonnull +50 -> 426
    //   379: new 89	java/lang/StringBuilder
    //   382: dup
    //   383: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   386: astore_1
    //   387: aload_1
    //   388: ldc_w 296
    //   391: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: pop
    //   395: aload_1
    //   396: aload_0
    //   397: invokeinterface 302 1 0
    //   402: invokevirtual 305	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload_1
    //   407: ldc_w 307
    //   410: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: pop
    //   414: ldc 55
    //   416: aload_1
    //   417: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   420: invokestatic 119	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   423: pop
    //   424: aload_0
    //   425: areturn
    //   426: aload_1
    //   427: athrow
    //   428: astore_0
    //   429: aload 7
    //   431: astore_2
    //   432: aload 8
    //   434: astore_1
    //   435: goto +17 -> 452
    //   438: astore_0
    //   439: aconst_null
    //   440: astore_1
    //   441: aload 7
    //   443: astore_2
    //   444: goto +8 -> 452
    //   447: astore_0
    //   448: aconst_null
    //   449: astore_2
    //   450: aload_2
    //   451: astore_1
    //   452: aload_1
    //   453: ifnull +46 -> 499
    //   456: aload_1
    //   457: invokevirtual 289	java/nio/channels/FileLock:release	()V
    //   460: goto +39 -> 499
    //   463: new 89	java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   470: astore_1
    //   471: aload_1
    //   472: ldc_w 291
    //   475: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: aload_1
    //   480: aload 11
    //   482: invokevirtual 115	java/io/File:getPath	()Ljava/lang/String;
    //   485: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: pop
    //   489: ldc 55
    //   491: aload_1
    //   492: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   495: invokestatic 294	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   498: pop
    //   499: aload_2
    //   500: ifnull +7 -> 507
    //   503: aload_2
    //   504: invokestatic 177	android/support/multidex/MultiDexExtractor:closeQuietly	(Ljava/io/Closeable;)V
    //   507: aload 10
    //   509: invokestatic 177	android/support/multidex/MultiDexExtractor:closeQuietly	(Ljava/io/Closeable;)V
    //   512: aload_0
    //   513: athrow
    //   514: astore_1
    //   515: goto -52 -> 463
    //   518: goto -245 -> 273
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	521	0	paramContext	Context
    //   0	521	1	paramFile1	File
    //   0	521	2	paramFile2	File
    //   0	521	3	paramString	String
    //   0	521	4	paramBoolean	boolean
    //   81	214	5	l	long
    //   7	435	7	localObject1	Object
    //   122	311	8	localObject2	Object
    //   169	63	9	localObject3	Object
    //   237	8	9	localIOException	IOException
    //   106	402	10	localRandomAccessFile	java.io.RandomAccessFile
    //   93	388	11	localFile	File
    // Exception table:
    //   from	to	target	type
    //   222	231	237	java/io/IOException
    //   310	315	318	java/io/IOException
    //   162	202	428	finally
    //   207	217	428	finally
    //   222	231	428	finally
    //   239	268	428	finally
    //   273	300	428	finally
    //   115	162	438	finally
    //   108	115	447	finally
    //   456	460	514	java/io/IOException
  }
  
  private static List<ExtractedDex> loadExistingExtractions(Context paramContext, File paramFile1, File paramFile2, String paramString)
    throws IOException
  {
    Log.i("MultiDex", "loading existing secondary dex files");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramFile1.getName());
    ((StringBuilder)localObject1).append(".classes");
    paramFile1 = ((StringBuilder)localObject1).toString();
    paramContext = getMultiDexPreferences(paramContext);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("dex.number");
    int j = paramContext.getInt(((StringBuilder)localObject1).toString(), 1);
    localObject1 = new ArrayList(j - 1);
    int i = 2;
    while (i <= j)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramFile1);
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(".zip");
      localObject2 = new ExtractedDex(paramFile2, ((StringBuilder)localObject2).toString());
      if (((ExtractedDex)localObject2).isFile())
      {
        ((ExtractedDex)localObject2).crc = getZipCrc((File)localObject2);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("dex.crc.");
        localStringBuilder.append(i);
        long l1 = paramContext.getLong(localStringBuilder.toString(), -1L);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("dex.time.");
        localStringBuilder.append(i);
        long l2 = paramContext.getLong(localStringBuilder.toString(), -1L);
        long l3 = ((ExtractedDex)localObject2).lastModified();
        if ((l2 == l3) && (l1 == ((ExtractedDex)localObject2).crc))
        {
          ((List)localObject1).add(localObject2);
          i += 1;
        }
        else
        {
          paramContext = new StringBuilder();
          paramContext.append("Invalid extracted dex: ");
          paramContext.append(localObject2);
          paramContext.append(" (key \"");
          paramContext.append(paramString);
          paramContext.append("\"), expected modification time: ");
          paramContext.append(l2);
          paramContext.append(", modification time: ");
          paramContext.append(l3);
          paramContext.append(", expected crc: ");
          paramContext.append(l1);
          paramContext.append(", file crc: ");
          paramContext.append(((ExtractedDex)localObject2).crc);
          throw new IOException(paramContext.toString());
        }
      }
      else
      {
        paramContext = new StringBuilder();
        paramContext.append("Missing extracted secondary dex file '");
        paramContext.append(((ExtractedDex)localObject2).getPath());
        paramContext.append("'");
        throw new IOException(paramContext.toString());
      }
    }
    return (List<ExtractedDex>)localObject1;
  }
  
  private static List<ExtractedDex> performExtractions(File paramFile1, File paramFile2)
    throws IOException
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(paramFile1.getName());
    localStringBuilder1.append(".classes");
    String str = localStringBuilder1.toString();
    prepareDexDir(paramFile2, str);
    ArrayList localArrayList = new ArrayList();
    ZipFile localZipFile = new ZipFile(paramFile1);
    int j = 2;
    for (;;)
    {
      try
      {
        paramFile1 = new StringBuilder();
        paramFile1.append("classes");
        paramFile1.append(2);
        paramFile1.append(".dex");
        paramFile1 = localZipFile.getEntry(paramFile1.toString());
        if (paramFile1 != null)
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append(str);
          localStringBuilder1.append(j);
          localStringBuilder1.append(".zip");
          ExtractedDex localExtractedDex = new ExtractedDex(paramFile2, localStringBuilder1.toString());
          localArrayList.add(localExtractedDex);
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("Extraction is needed for file ");
          localStringBuilder1.append(localExtractedDex);
          Log.i("MultiDex", localStringBuilder1.toString());
          int m = 0;
          int k = 0;
          if ((m < 3) && (k == 0))
          {
            int n = m + 1;
            extract(localZipFile, paramFile1, localExtractedDex, str);
            int i;
            try
            {
              localExtractedDex.crc = getZipCrc(localExtractedDex);
              i = 1;
            }
            catch (IOException localIOException)
            {
              localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("Failed to read crc from ");
              localStringBuilder2.append(localExtractedDex.getAbsolutePath());
              Log.w("MultiDex", localStringBuilder2.toString(), localIOException);
              i = 0;
            }
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("Extraction ");
            if (i != 0)
            {
              localObject = "succeeded";
              localStringBuilder2.append((String)localObject);
              localStringBuilder2.append(" - length ");
              localStringBuilder2.append(localExtractedDex.getAbsolutePath());
              localStringBuilder2.append(": ");
              localStringBuilder2.append(localExtractedDex.length());
              localStringBuilder2.append(" - crc: ");
              localStringBuilder2.append(localExtractedDex.crc);
              Log.i("MultiDex", localStringBuilder2.toString());
              m = n;
              k = i;
              if (i != 0) {
                continue;
              }
              localExtractedDex.delete();
              m = n;
              k = i;
              if (!localExtractedDex.exists()) {
                continue;
              }
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("Failed to delete corrupted secondary dex '");
              ((StringBuilder)localObject).append(localExtractedDex.getPath());
              ((StringBuilder)localObject).append("'");
              Log.w("MultiDex", ((StringBuilder)localObject).toString());
              m = n;
              k = i;
            }
          }
          else
          {
            if (k != 0)
            {
              j += 1;
              paramFile1 = new StringBuilder();
              paramFile1.append("classes");
              paramFile1.append(j);
              paramFile1.append(".dex");
              paramFile1 = localZipFile.getEntry(paramFile1.toString());
              continue;
            }
            paramFile1 = new StringBuilder();
            paramFile1.append("Could not create zip file ");
            paramFile1.append(localExtractedDex.getAbsolutePath());
            paramFile1.append(" for secondary dex (");
            paramFile1.append(j);
            paramFile1.append(")");
            throw new IOException(paramFile1.toString());
          }
        }
        else
        {
          try
          {
            localZipFile.close();
            return localArrayList;
          }
          catch (IOException paramFile1)
          {
            Log.w("MultiDex", "Failed to close resource", paramFile1);
            return localArrayList;
          }
        }
        Object localObject = "failed";
      }
      finally
      {
        try
        {
          localZipFile.close();
        }
        catch (IOException paramFile2)
        {
          Log.w("MultiDex", "Failed to close resource", paramFile2);
        }
      }
    }
  }
  
  private static void prepareDexDir(File paramFile, String paramString)
  {
    paramString = paramFile.listFiles(new FileFilter()
    {
      public boolean accept(File paramAnonymousFile)
      {
        paramAnonymousFile = paramAnonymousFile.getName();
        return (!paramAnonymousFile.startsWith(this.val$extractedFilePrefix)) && (!paramAnonymousFile.equals("MultiDex.lock"));
      }
    });
    if (paramString == null)
    {
      paramString = new StringBuilder();
      paramString.append("Failed to list secondary dex dir content (");
      paramString.append(paramFile.getPath());
      paramString.append(").");
      Log.w("MultiDex", paramString.toString());
      return;
    }
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      paramFile = paramString[i];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Trying to delete old file ");
      localStringBuilder.append(paramFile.getPath());
      localStringBuilder.append(" of size ");
      localStringBuilder.append(paramFile.length());
      Log.i("MultiDex", localStringBuilder.toString());
      if (!paramFile.delete())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to delete old file ");
        localStringBuilder.append(paramFile.getPath());
        Log.w("MultiDex", localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Deleted old file ");
        localStringBuilder.append(paramFile.getPath());
        Log.i("MultiDex", localStringBuilder.toString());
      }
      i += 1;
    }
  }
  
  private static void putStoredApkInfo(Context paramContext, String paramString, long paramLong1, long paramLong2, List<ExtractedDex> paramList)
  {
    paramContext = getMultiDexPreferences(paramContext).edit();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("timestamp");
    paramContext.putLong(((StringBuilder)localObject).toString(), paramLong1);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("crc");
    paramContext.putLong(((StringBuilder)localObject).toString(), paramLong2);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("dex.number");
    paramContext.putInt(((StringBuilder)localObject).toString(), paramList.size() + 1);
    paramList = paramList.iterator();
    int i = 2;
    while (paramList.hasNext())
    {
      localObject = (ExtractedDex)paramList.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("dex.crc.");
      localStringBuilder.append(i);
      paramContext.putLong(localStringBuilder.toString(), ((ExtractedDex)localObject).crc);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("dex.time.");
      localStringBuilder.append(i);
      paramContext.putLong(localStringBuilder.toString(), ((ExtractedDex)localObject).lastModified());
      i += 1;
    }
    paramContext.commit();
  }
  
  private static class ExtractedDex
    extends File
  {
    public long crc = -1L;
    
    public ExtractedDex(File paramFile, String paramString)
    {
      super(paramString);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\multidex\MultiDexExtractor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */