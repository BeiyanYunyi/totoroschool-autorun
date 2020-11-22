package com.tencent.smtt.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.zip.ZipEntry;

@SuppressLint({"NewApi"})
public class k
{
  public static String a;
  public static final a b = new m();
  private static final int c = "lib/".length();
  private static RandomAccessFile d;
  
  static
  {
    a = null;
    d = null;
  }
  
  public static File a(Context paramContext, boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      paramContext = d(paramContext);
    } else {
      paramContext = c(paramContext);
    }
    if (paramContext == null) {
      return null;
    }
    paramContext = new File(paramContext);
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    if (!paramContext.canWrite()) {
      return null;
    }
    paramContext = new File(paramContext, paramString);
    if (!paramContext.exists()) {
      try
      {
        paramContext.createNewFile();
        return paramContext;
      }
      catch (IOException paramContext)
      {
        paramContext.printStackTrace();
        return null;
      }
    }
    return paramContext;
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramContext.getApplicationInfo().packageName, paramInt, true);
  }
  
  private static String a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return "";
    }
    Object localObject = paramContext.getApplicationContext();
    if (localObject != null) {
      paramContext = (Context)localObject;
    }
    try
    {
      localObject = paramContext.getExternalFilesDir(paramString).getAbsolutePath();
      return (String)localObject;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(Environment.getExternalStorageDirectory());
        localStringBuilder.append(File.separator);
        localStringBuilder.append("Android");
        localStringBuilder.append(File.separator);
        localStringBuilder.append("data");
        localStringBuilder.append(File.separator);
        localStringBuilder.append(paramContext.getApplicationInfo().packageName);
        localStringBuilder.append(File.separator);
        localStringBuilder.append("files");
        localStringBuilder.append(File.separator);
        localStringBuilder.append(paramString);
        paramContext = localStringBuilder.toString();
        return paramContext;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return "";
  }
  
  public static String a(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramContext == null) {
      return "";
    }
    Object localObject1 = "";
    try
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(Environment.getExternalStorageDirectory());
      ((StringBuilder)localObject2).append(File.separator);
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    switch (paramInt)
    {
    default: 
      return "";
    case 6: 
      if (a != null) {
        return a;
      }
      a = a(paramContext, "tbslog");
      return a;
    case 5: 
      if (((String)localObject1).equals("")) {
        return (String)localObject1;
      }
      paramContext = new StringBuilder();
      paramContext.append((String)localObject1);
      paramContext.append("tencent");
      paramContext.append(File.separator);
      paramContext.append("tbs");
      paramContext.append(File.separator);
      paramContext.append(paramString);
      return paramContext.toString();
    case 4: 
      if (((String)localObject1).equals("")) {
        return a(paramContext, "backup");
      }
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append("tencent");
      ((StringBuilder)localObject3).append(File.separator);
      ((StringBuilder)localObject3).append("tbs");
      ((StringBuilder)localObject3).append(File.separator);
      ((StringBuilder)localObject3).append("backup");
      ((StringBuilder)localObject3).append(File.separator);
      ((StringBuilder)localObject3).append(paramString);
      localObject1 = ((StringBuilder)localObject3).toString();
      paramString = (String)localObject1;
      if (paramBoolean)
      {
        localObject3 = new File((String)localObject1);
        if (((File)localObject3).exists())
        {
          paramString = (String)localObject1;
          if (((File)localObject3).canWrite()) {}
        }
        else if (!((File)localObject3).exists())
        {
          ((File)localObject3).mkdirs();
          paramString = (String)localObject1;
          if (!((File)localObject3).canWrite()) {
            return a(paramContext, "backup");
          }
        }
        else
        {
          paramString = a(paramContext, "backup");
        }
      }
      return paramString;
    case 3: 
      if (((String)localObject1).equals("")) {
        return (String)localObject1;
      }
      paramContext = new StringBuilder();
      paramContext.append((String)localObject1);
      paramContext.append("tencent");
      paramContext.append(File.separator);
      paramContext.append("tbs");
      paramContext.append(File.separator);
      paramContext.append("backup");
      paramContext.append(File.separator);
      paramContext.append(paramString);
      return paramContext.toString();
    case 2: 
      if (((String)localObject1).equals("")) {
        return (String)localObject1;
      }
      paramContext = new StringBuilder();
      paramContext.append((String)localObject1);
      paramContext.append("tbs");
      paramContext.append(File.separator);
      paramContext.append("backup");
      paramContext.append(File.separator);
      paramContext.append(paramString);
      return paramContext.toString();
    }
    if (((String)localObject1).equals("")) {
      return (String)localObject1;
    }
    paramContext = new StringBuilder();
    paramContext.append((String)localObject1);
    paramContext.append("tencent");
    paramContext.append(File.separator);
    paramContext.append("tbs");
    paramContext.append(File.separator);
    paramContext.append(paramString);
    return paramContext.toString();
  }
  
  public static FileLock a(Context paramContext, FileOutputStream paramFileOutputStream)
  {
    if (paramFileOutputStream == null) {
      return null;
    }
    try
    {
      paramContext = paramFileOutputStream.getChannel().tryLock();
      boolean bool = paramContext.isValid();
      if (bool) {
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (OverlappingFileLockException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static void a(Context paramContext, FileLock paramFileLock)
  {
    try
    {
      paramContext = paramFileLock.channel();
      if (paramContext != null)
      {
        boolean bool = paramContext.isOpen();
        if (bool) {
          try
          {
            paramFileLock.release();
          }
          catch (IOException paramContext)
          {
            paramContext.printStackTrace();
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public static void a(File paramFile, boolean paramBoolean)
  {
    if (paramFile != null)
    {
      if (!paramFile.exists()) {
        return;
      }
      if (paramFile.isFile())
      {
        paramFile.delete();
        return;
      }
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile == null) {
        return;
      }
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        a(arrayOfFile[i], paramBoolean);
        i += 1;
      }
      if (!paramBoolean) {
        paramFile.delete();
      }
    }
  }
  
  public static void a(File paramFile, boolean paramBoolean, String paramString)
  {
    if (paramFile != null)
    {
      if (!paramFile.exists()) {
        return;
      }
      if (paramFile.isFile())
      {
        paramFile.delete();
        return;
      }
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile == null) {
        return;
      }
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        File localFile = arrayOfFile[i];
        if (!localFile.getName().equals(paramString)) {
          a(localFile, paramBoolean);
        }
        i += 1;
      }
      if (!paramBoolean) {
        paramFile.delete();
      }
    }
  }
  
  public static void a(FileLock paramFileLock, FileOutputStream paramFileOutputStream)
  {
    if (paramFileLock != null) {
      try
      {
        FileChannel localFileChannel = paramFileLock.channel();
        if ((localFileChannel != null) && (localFileChannel.isOpen())) {
          paramFileLock.release();
        }
      }
      catch (Exception paramFileLock)
      {
        paramFileLock.printStackTrace();
      }
    }
    if (paramFileOutputStream != null) {
      try
      {
        paramFileOutputStream.close();
        return;
      }
      catch (Exception paramFileLock)
      {
        paramFileLock.printStackTrace();
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 23) {
      return true;
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (paramContext.getApplicationContext().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(File paramFile)
  {
    if (paramFile == null) {
      return false;
    }
    if ((paramFile.exists()) && (paramFile.isDirectory())) {
      return true;
    }
    b(paramFile);
    return paramFile.mkdirs();
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    return a(paramFile1.getPath(), paramFile2.getPath());
  }
  
  public static boolean a(File paramFile1, File paramFile2, FileFilter paramFileFilter)
  {
    return a(paramFile1, paramFile2, paramFileFilter, b);
  }
  
  public static boolean a(File paramFile1, File paramFile2, FileFilter paramFileFilter, a parama)
  {
    if (paramFile1 != null)
    {
      if (paramFile2 == null) {
        return false;
      }
      if (!paramFile1.exists()) {
        return false;
      }
      if (paramFile1.isFile()) {
        return b(paramFile1, paramFile2, paramFileFilter, parama);
      }
      paramFile1 = paramFile1.listFiles(paramFileFilter);
      if (paramFile1 == null) {
        return false;
      }
      int j = paramFile1.length;
      int i = 0;
      boolean bool = true;
      while (i < j)
      {
        parama = paramFile1[i];
        if (!a(parama, new File(paramFile2, parama.getName()), paramFileFilter)) {
          bool = false;
        }
        i += 1;
      }
      return bool;
    }
    return false;
  }
  
  /* Error */
  private static boolean a(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    // Byte code:
    //   0: new 53	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 249	java/io/File:length	()J
    //   13: lload_1
    //   14: lcmp
    //   15: ifeq +59 -> 74
    //   18: new 112	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   25: astore 8
    //   27: aload 8
    //   29: ldc -5
    //   31: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 8
    //   37: aload_0
    //   38: invokevirtual 249	java/io/File:length	()J
    //   41: invokevirtual 254	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload 8
    //   47: ldc_w 256
    //   50: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 8
    //   56: lload_1
    //   57: invokevirtual 254	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: ldc_w 258
    //   64: aload 8
    //   66: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 264	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: iconst_1
    //   73: ireturn
    //   74: new 266	java/io/FileInputStream
    //   77: dup
    //   78: aload_0
    //   79: invokespecial 268	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   82: astore 8
    //   84: new 270	java/util/zip/CRC32
    //   87: dup
    //   88: invokespecial 271	java/util/zip/CRC32:<init>	()V
    //   91: astore 9
    //   93: sipush 8192
    //   96: newarray <illegal type>
    //   98: astore 10
    //   100: aload 8
    //   102: aload 10
    //   104: invokevirtual 275	java/io/FileInputStream:read	([B)I
    //   107: istore 7
    //   109: iload 7
    //   111: ifle +16 -> 127
    //   114: aload 9
    //   116: aload 10
    //   118: iconst_0
    //   119: iload 7
    //   121: invokevirtual 279	java/util/zip/CRC32:update	([BII)V
    //   124: goto -24 -> 100
    //   127: aload 9
    //   129: invokevirtual 282	java/util/zip/CRC32:getValue	()J
    //   132: lstore_1
    //   133: new 112	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   140: astore 9
    //   142: aload 9
    //   144: ldc 97
    //   146: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload 9
    //   152: aload_0
    //   153: invokevirtual 201	java/io/File:getName	()Ljava/lang/String;
    //   156: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload 9
    //   162: ldc_w 284
    //   165: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload 9
    //   171: lload_1
    //   172: invokevirtual 254	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload 9
    //   178: ldc_w 286
    //   181: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload 9
    //   187: lload 5
    //   189: invokevirtual 254	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: ldc_w 258
    //   196: aload 9
    //   198: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 289	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   204: lload_1
    //   205: lload 5
    //   207: lcmp
    //   208: ifeq +10 -> 218
    //   211: aload 8
    //   213: invokevirtual 290	java/io/FileInputStream:close	()V
    //   216: iconst_1
    //   217: ireturn
    //   218: aload 8
    //   220: invokevirtual 290	java/io/FileInputStream:close	()V
    //   223: iconst_0
    //   224: ireturn
    //   225: astore_0
    //   226: goto +7 -> 233
    //   229: astore_0
    //   230: aconst_null
    //   231: astore 8
    //   233: aload 8
    //   235: ifnull +8 -> 243
    //   238: aload 8
    //   240: invokevirtual 290	java/io/FileInputStream:close	()V
    //   243: aload_0
    //   244: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	paramString	String
    //   0	245	1	paramLong1	long
    //   0	245	3	paramLong2	long
    //   0	245	5	paramLong3	long
    //   107	13	7	i	int
    //   25	214	8	localObject1	Object
    //   91	106	9	localObject2	Object
    //   98	19	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   84	100	225	finally
    //   100	109	225	finally
    //   114	124	225	finally
    //   127	204	225	finally
    //   74	84	229	finally
  }
  
  @SuppressLint({"InlinedApi"})
  public static boolean a(String paramString1, String paramString2)
  {
    String str2 = Build.CPU_ABI;
    String str1;
    if (Build.VERSION.SDK_INT >= 8) {
      str1 = Build.CPU_ABI2;
    } else {
      str1 = null;
    }
    return a(paramString1, paramString2, str2, str1, q.a("ro.product.cpu.upgradeabi", "armeabi"));
  }
  
  /* Error */
  private static boolean a(String paramString1, String paramString2, String paramString3, String paramString4, b paramb)
  {
    // Byte code:
    //   0: new 315	java/util/zip/ZipFile
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 316	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 320	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   13: astore 10
    //   15: iconst_0
    //   16: istore 6
    //   18: iconst_0
    //   19: istore 5
    //   21: aload 10
    //   23: invokeinterface 325 1 0
    //   28: ifeq +346 -> 374
    //   31: aload 10
    //   33: invokeinterface 329 1 0
    //   38: checkcast 331	java/util/zip/ZipEntry
    //   41: astore 11
    //   43: aload 11
    //   45: invokevirtual 332	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   48: astore 13
    //   50: aload 13
    //   52: ifnonnull +6 -> 58
    //   55: goto -34 -> 21
    //   58: aload 13
    //   60: ldc_w 334
    //   63: invokevirtual 338	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   66: ifeq +6 -> 72
    //   69: goto -48 -> 21
    //   72: aload 13
    //   74: ldc 23
    //   76: invokevirtual 342	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   79: ifne +17 -> 96
    //   82: aload 13
    //   84: ldc_w 344
    //   87: invokevirtual 342	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   90: ifne +6 -> 96
    //   93: goto -72 -> 21
    //   96: aload 13
    //   98: aload 13
    //   100: bipush 47
    //   102: invokevirtual 348	java/lang/String:lastIndexOf	(I)I
    //   105: invokevirtual 352	java/lang/String:substring	(I)Ljava/lang/String;
    //   108: astore 12
    //   110: iload 6
    //   112: istore 7
    //   114: iload 5
    //   116: istore 8
    //   118: aload 12
    //   120: ldc_w 354
    //   123: invokevirtual 357	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   126: ifeq +158 -> 284
    //   129: aload 13
    //   131: getstatic 31	com/tencent/smtt/utils/k:c	I
    //   134: aload_1
    //   135: iconst_0
    //   136: aload_1
    //   137: invokevirtual 29	java/lang/String:length	()I
    //   140: invokevirtual 361	java/lang/String:regionMatches	(ILjava/lang/String;II)Z
    //   143: ifeq +31 -> 174
    //   146: aload 13
    //   148: getstatic 31	com/tencent/smtt/utils/k:c	I
    //   151: aload_1
    //   152: invokevirtual 29	java/lang/String:length	()I
    //   155: iadd
    //   156: invokevirtual 365	java/lang/String:charAt	(I)C
    //   159: bipush 47
    //   161: if_icmpne +13 -> 174
    //   164: iconst_1
    //   165: istore 7
    //   167: iload 5
    //   169: istore 8
    //   171: goto +113 -> 284
    //   174: aload_2
    //   175: ifnull +49 -> 224
    //   178: aload 13
    //   180: getstatic 31	com/tencent/smtt/utils/k:c	I
    //   183: aload_2
    //   184: iconst_0
    //   185: aload_2
    //   186: invokevirtual 29	java/lang/String:length	()I
    //   189: invokevirtual 361	java/lang/String:regionMatches	(ILjava/lang/String;II)Z
    //   192: ifeq +32 -> 224
    //   195: aload 13
    //   197: getstatic 31	com/tencent/smtt/utils/k:c	I
    //   200: aload_2
    //   201: invokevirtual 29	java/lang/String:length	()I
    //   204: iadd
    //   205: invokevirtual 365	java/lang/String:charAt	(I)C
    //   208: bipush 47
    //   210: if_icmpne +14 -> 224
    //   213: iload 6
    //   215: ifeq +182 -> 397
    //   218: iconst_1
    //   219: istore 5
    //   221: goto -200 -> 21
    //   224: aload_3
    //   225: ifnull -204 -> 21
    //   228: aload 13
    //   230: getstatic 31	com/tencent/smtt/utils/k:c	I
    //   233: aload_3
    //   234: iconst_0
    //   235: aload_3
    //   236: invokevirtual 29	java/lang/String:length	()I
    //   239: invokevirtual 361	java/lang/String:regionMatches	(ILjava/lang/String;II)Z
    //   242: ifeq -221 -> 21
    //   245: aload 13
    //   247: getstatic 31	com/tencent/smtt/utils/k:c	I
    //   250: aload_3
    //   251: invokevirtual 29	java/lang/String:length	()I
    //   254: iadd
    //   255: invokevirtual 365	java/lang/String:charAt	(I)C
    //   258: bipush 47
    //   260: if_icmpne -239 -> 21
    //   263: iload 6
    //   265: ifne -244 -> 21
    //   268: iload 6
    //   270: istore 7
    //   272: iload 5
    //   274: istore 8
    //   276: iload 5
    //   278: ifeq +6 -> 284
    //   281: goto -260 -> 21
    //   284: aload_0
    //   285: aload 11
    //   287: invokevirtual 369	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   290: astore 13
    //   292: aload 4
    //   294: aload 13
    //   296: aload 11
    //   298: aload 12
    //   300: iconst_1
    //   301: invokevirtual 352	java/lang/String:substring	(I)Ljava/lang/String;
    //   304: invokeinterface 372 4 0
    //   309: istore 9
    //   311: iload 9
    //   313: ifne +19 -> 332
    //   316: aload 13
    //   318: ifnull +8 -> 326
    //   321: aload 13
    //   323: invokevirtual 375	java/io/InputStream:close	()V
    //   326: aload_0
    //   327: invokevirtual 376	java/util/zip/ZipFile:close	()V
    //   330: iconst_0
    //   331: ireturn
    //   332: iload 7
    //   334: istore 6
    //   336: iload 8
    //   338: istore 5
    //   340: aload 13
    //   342: ifnull -321 -> 21
    //   345: aload 13
    //   347: invokevirtual 375	java/io/InputStream:close	()V
    //   350: iload 7
    //   352: istore 6
    //   354: iload 8
    //   356: istore 5
    //   358: goto -337 -> 21
    //   361: astore_1
    //   362: aload 13
    //   364: ifnull +8 -> 372
    //   367: aload 13
    //   369: invokevirtual 375	java/io/InputStream:close	()V
    //   372: aload_1
    //   373: athrow
    //   374: aload_0
    //   375: invokevirtual 376	java/util/zip/ZipFile:close	()V
    //   378: iconst_1
    //   379: ireturn
    //   380: astore_1
    //   381: goto +6 -> 387
    //   384: astore_1
    //   385: aconst_null
    //   386: astore_0
    //   387: aload_0
    //   388: ifnull +7 -> 395
    //   391: aload_0
    //   392: invokevirtual 376	java/util/zip/ZipFile:close	()V
    //   395: aload_1
    //   396: athrow
    //   397: iconst_1
    //   398: istore 8
    //   400: iload 6
    //   402: istore 7
    //   404: goto -120 -> 284
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	407	0	paramString1	String
    //   0	407	1	paramString2	String
    //   0	407	2	paramString3	String
    //   0	407	3	paramString4	String
    //   0	407	4	paramb	b
    //   19	338	5	i	int
    //   16	385	6	j	int
    //   112	291	7	k	int
    //   116	283	8	m	int
    //   309	3	9	bool	boolean
    //   13	19	10	localEnumeration	java.util.Enumeration
    //   41	256	11	localZipEntry	ZipEntry
    //   108	191	12	str	String
    //   48	320	13	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   292	311	361	finally
    //   9	15	380	finally
    //   21	50	380	finally
    //   58	69	380	finally
    //   72	93	380	finally
    //   96	110	380	finally
    //   118	164	380	finally
    //   178	213	380	finally
    //   228	263	380	finally
    //   284	292	380	finally
    //   321	326	380	finally
    //   345	350	380	finally
    //   367	372	380	finally
    //   372	374	380	finally
    //   0	9	384	finally
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return a(paramString1, paramString3, paramString4, paramString5, new l(paramString2));
  }
  
  public static FileOutputStream b(Context paramContext, boolean paramBoolean, String paramString)
  {
    paramContext = a(paramContext, paramBoolean, paramString);
    if (paramContext != null) {
      try
      {
        paramContext = new FileOutputStream(paramContext);
        return paramContext;
      }
      catch (FileNotFoundException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return null;
  }
  
  public static void b(File paramFile)
  {
    a(paramFile, false);
  }
  
  public static boolean b(Context paramContext)
  {
    long l = y.a();
    boolean bool;
    if (l >= TbsDownloadConfig.getInstance(paramContext).getDownloadMinFreeSpace()) {
      bool = true;
    } else {
      bool = false;
    }
    if (!bool)
    {
      paramContext = new StringBuilder();
      paramContext.append("[TbsApkDwonloader.hasEnoughFreeSpace] freeSpace too small,  freeSpace = ");
      paramContext.append(l);
      TbsLog.e("TbsDownload", paramContext.toString());
    }
    return bool;
  }
  
  public static boolean b(File paramFile1, File paramFile2)
  {
    return a(paramFile1, paramFile2, null);
  }
  
  /* Error */
  private static boolean b(File paramFile1, File paramFile2, FileFilter paramFileFilter, a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +222 -> 223
    //   4: aload_1
    //   5: ifnonnull +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: aload_2
    //   11: ifnull +15 -> 26
    //   14: aload_2
    //   15: aload_0
    //   16: invokeinterface 410 2 0
    //   21: ifne +5 -> 26
    //   24: iconst_0
    //   25: ireturn
    //   26: aconst_null
    //   27: astore_2
    //   28: aload_0
    //   29: invokevirtual 60	java/io/File:exists	()Z
    //   32: ifeq +168 -> 200
    //   35: aload_0
    //   36: invokevirtual 188	java/io/File:isFile	()Z
    //   39: ifne +5 -> 44
    //   42: iconst_0
    //   43: ireturn
    //   44: aload_1
    //   45: invokevirtual 60	java/io/File:exists	()Z
    //   48: ifeq +24 -> 72
    //   51: aload_3
    //   52: ifnull +16 -> 68
    //   55: aload_3
    //   56: aload_0
    //   57: aload_1
    //   58: invokeinterface 412 3 0
    //   63: ifeq +5 -> 68
    //   66: iconst_1
    //   67: ireturn
    //   68: aload_1
    //   69: invokestatic 224	com/tencent/smtt/utils/k:b	(Ljava/io/File;)V
    //   72: aload_1
    //   73: invokevirtual 415	java/io/File:getParentFile	()Ljava/io/File;
    //   76: astore_3
    //   77: aload_3
    //   78: invokevirtual 188	java/io/File:isFile	()Z
    //   81: ifeq +7 -> 88
    //   84: aload_3
    //   85: invokestatic 224	com/tencent/smtt/utils/k:b	(Ljava/io/File;)V
    //   88: aload_3
    //   89: invokevirtual 60	java/io/File:exists	()Z
    //   92: ifne +12 -> 104
    //   95: aload_3
    //   96: invokevirtual 63	java/io/File:mkdirs	()Z
    //   99: ifne +5 -> 104
    //   102: iconst_0
    //   103: ireturn
    //   104: new 266	java/io/FileInputStream
    //   107: dup
    //   108: aload_0
    //   109: invokespecial 268	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   112: invokevirtual 416	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   115: astore_3
    //   116: new 158	java/io/FileOutputStream
    //   119: dup
    //   120: aload_1
    //   121: invokespecial 387	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   124: invokevirtual 162	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   127: astore_0
    //   128: aload_3
    //   129: invokevirtual 419	java/nio/channels/FileChannel:size	()J
    //   132: lstore 4
    //   134: aload_0
    //   135: aload_3
    //   136: lconst_0
    //   137: lload 4
    //   139: invokevirtual 423	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   142: lload 4
    //   144: lcmp
    //   145: ifeq +25 -> 170
    //   148: aload_1
    //   149: invokestatic 224	com/tencent/smtt/utils/k:b	(Ljava/io/File;)V
    //   152: aload_3
    //   153: ifnull +7 -> 160
    //   156: aload_3
    //   157: invokevirtual 424	java/nio/channels/FileChannel:close	()V
    //   160: aload_0
    //   161: ifnull +7 -> 168
    //   164: aload_0
    //   165: invokevirtual 424	java/nio/channels/FileChannel:close	()V
    //   168: iconst_0
    //   169: ireturn
    //   170: aload_3
    //   171: ifnull +7 -> 178
    //   174: aload_3
    //   175: invokevirtual 424	java/nio/channels/FileChannel:close	()V
    //   178: aload_0
    //   179: ifnull +7 -> 186
    //   182: aload_0
    //   183: invokevirtual 424	java/nio/channels/FileChannel:close	()V
    //   186: iconst_1
    //   187: ireturn
    //   188: astore_1
    //   189: goto +6 -> 195
    //   192: astore_1
    //   193: aconst_null
    //   194: astore_0
    //   195: aload_3
    //   196: astore_2
    //   197: goto +8 -> 205
    //   200: iconst_0
    //   201: ireturn
    //   202: astore_1
    //   203: aconst_null
    //   204: astore_0
    //   205: aload_2
    //   206: ifnull +7 -> 213
    //   209: aload_2
    //   210: invokevirtual 424	java/nio/channels/FileChannel:close	()V
    //   213: aload_0
    //   214: ifnull +7 -> 221
    //   217: aload_0
    //   218: invokevirtual 424	java/nio/channels/FileChannel:close	()V
    //   221: aload_1
    //   222: athrow
    //   223: iconst_0
    //   224: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	paramFile1	File
    //   0	225	1	paramFile2	File
    //   0	225	2	paramFileFilter	FileFilter
    //   0	225	3	parama	a
    //   132	11	4	l	long
    // Exception table:
    //   from	to	target	type
    //   128	152	188	finally
    //   116	128	192	finally
    //   28	42	202	finally
    //   44	51	202	finally
    //   55	66	202	finally
    //   68	72	202	finally
    //   72	88	202	finally
    //   88	102	202	finally
    //   104	116	202	finally
  }
  
  /* Error */
  @SuppressLint({"NewApi"})
  private static boolean b(InputStream paramInputStream, ZipEntry paramZipEntry, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 53	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokestatic 426	com/tencent/smtt/utils/k:a	(Ljava/io/File;)Z
    //   11: pop
    //   12: new 112	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   19: astore 5
    //   21: aload 5
    //   23: aload_2
    //   24: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload 5
    //   30: getstatic 126	java/io/File:separator	Ljava/lang/String;
    //   33: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 5
    //   39: aload_3
    //   40: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload 5
    //   46: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: astore 7
    //   51: new 53	java/io/File
    //   54: dup
    //   55: aload 7
    //   57: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
    //   60: astore 6
    //   62: aconst_null
    //   63: astore 5
    //   65: aconst_null
    //   66: astore_2
    //   67: new 158	java/io/FileOutputStream
    //   70: dup
    //   71: aload 6
    //   73: invokespecial 387	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   76: astore_3
    //   77: sipush 8192
    //   80: newarray <illegal type>
    //   82: astore_2
    //   83: aload_0
    //   84: aload_2
    //   85: invokevirtual 427	java/io/InputStream:read	([B)I
    //   88: istore 4
    //   90: iload 4
    //   92: ifle +14 -> 106
    //   95: aload_3
    //   96: aload_2
    //   97: iconst_0
    //   98: iload 4
    //   100: invokevirtual 430	java/io/FileOutputStream:write	([BII)V
    //   103: goto -20 -> 83
    //   106: aload_3
    //   107: invokevirtual 205	java/io/FileOutputStream:close	()V
    //   110: aload 7
    //   112: aload_1
    //   113: invokevirtual 433	java/util/zip/ZipEntry:getSize	()J
    //   116: aload_1
    //   117: invokevirtual 436	java/util/zip/ZipEntry:getTime	()J
    //   120: aload_1
    //   121: invokevirtual 439	java/util/zip/ZipEntry:getCrc	()J
    //   124: invokestatic 441	com/tencent/smtt/utils/k:a	(Ljava/lang/String;JJJ)Z
    //   127: ifeq +38 -> 165
    //   130: new 112	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   137: astore_0
    //   138: aload_0
    //   139: ldc_w 443
    //   142: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload_0
    //   147: aload 7
    //   149: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: ldc_w 258
    //   156: aload_0
    //   157: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 264	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: iconst_0
    //   164: ireturn
    //   165: aload 6
    //   167: aload_1
    //   168: invokevirtual 436	java/util/zip/ZipEntry:getTime	()J
    //   171: invokevirtual 447	java/io/File:setLastModified	(J)Z
    //   174: ifne +36 -> 210
    //   177: new 112	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   184: astore_0
    //   185: aload_0
    //   186: ldc_w 449
    //   189: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload_0
    //   194: aload 6
    //   196: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: ldc_w 258
    //   203: aload_0
    //   204: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 264	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: iconst_1
    //   211: ireturn
    //   212: astore_0
    //   213: aload_3
    //   214: astore_2
    //   215: goto +68 -> 283
    //   218: astore_1
    //   219: aload_3
    //   220: astore_0
    //   221: goto +11 -> 232
    //   224: astore_0
    //   225: goto +58 -> 283
    //   228: astore_1
    //   229: aload 5
    //   231: astore_0
    //   232: aload_0
    //   233: astore_2
    //   234: aload 6
    //   236: invokestatic 224	com/tencent/smtt/utils/k:b	(Ljava/io/File;)V
    //   239: aload_0
    //   240: astore_2
    //   241: new 112	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   248: astore_3
    //   249: aload_0
    //   250: astore_2
    //   251: aload_3
    //   252: ldc_w 451
    //   255: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload_0
    //   260: astore_2
    //   261: aload_3
    //   262: aload 6
    //   264: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: aload_0
    //   269: astore_2
    //   270: new 46	java/io/IOException
    //   273: dup
    //   274: aload_3
    //   275: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: aload_1
    //   279: invokespecial 454	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   282: athrow
    //   283: aload_2
    //   284: ifnull +7 -> 291
    //   287: aload_2
    //   288: invokevirtual 205	java/io/FileOutputStream:close	()V
    //   291: aload_0
    //   292: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	paramInputStream	InputStream
    //   0	293	1	paramZipEntry	ZipEntry
    //   0	293	2	paramString1	String
    //   0	293	3	paramString2	String
    //   88	11	4	i	int
    //   19	211	5	localStringBuilder	StringBuilder
    //   60	203	6	localFile	File
    //   49	99	7	str	String
    // Exception table:
    //   from	to	target	type
    //   77	83	212	finally
    //   83	90	212	finally
    //   95	103	212	finally
    //   77	83	218	java/io/IOException
    //   83	90	218	java/io/IOException
    //   95	103	218	java/io/IOException
    //   67	77	224	finally
    //   234	239	224	finally
    //   241	249	224	finally
    //   251	259	224	finally
    //   261	268	224	finally
    //   270	283	224	finally
    //   67	77	228	java/io/IOException
  }
  
  public static String c(Context paramContext)
  {
    paramContext = new StringBuilder();
    paramContext.append(Environment.getExternalStorageDirectory());
    paramContext.append(File.separator);
    paramContext.append("tbs");
    paramContext.append(File.separator);
    paramContext.append("file_locks");
    return paramContext.toString();
  }
  
  public static boolean c(File paramFile)
  {
    return (paramFile != null) && (paramFile.exists()) && (paramFile.isFile()) && (paramFile.length() > 0L);
  }
  
  public static FileOutputStream d(File paramFile)
  {
    Object localObject;
    if (paramFile.exists())
    {
      if (!paramFile.isDirectory())
      {
        if (!paramFile.canWrite())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("File '");
          ((StringBuilder)localObject).append(paramFile);
          ((StringBuilder)localObject).append("' cannot be written to");
          throw new IOException(((StringBuilder)localObject).toString());
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("File '");
        ((StringBuilder)localObject).append(paramFile);
        ((StringBuilder)localObject).append("' exists but is a directory");
        throw new IOException(((StringBuilder)localObject).toString());
      }
    }
    else
    {
      localObject = paramFile.getParentFile();
      if ((localObject != null) && (!((File)localObject).exists()) && (!((File)localObject).mkdirs()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("File '");
        ((StringBuilder)localObject).append(paramFile);
        ((StringBuilder)localObject).append("' could not be created");
        throw new IOException(((StringBuilder)localObject).toString());
      }
    }
    return new FileOutputStream(paramFile);
  }
  
  static String d(Context paramContext)
  {
    paramContext = new File(paramContext.getDir("tbs", 0), "core_private");
    if ((!paramContext.isDirectory()) && (!paramContext.mkdir())) {
      return null;
    }
    return paramContext.getAbsolutePath();
  }
  
  public static FileLock e(Context paramContext)
  {
    TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #1");
    try
    {
      bool = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
    }
    catch (Throwable localThrowable)
    {
      boolean bool;
      Object localObject1;
      Object localObject2;
      for (;;) {}
    }
    bool = true;
    localObject1 = null;
    if (!bool)
    {
      localObject2 = b(paramContext, true, "tbs_rename_lock");
      if (localObject2 == null) {
        paramContext = "init -- failed to get rename fileLock#1!";
      }
      for (;;)
      {
        TbsLog.i("FileHelper", paramContext);
        break;
        localObject1 = a(paramContext, (FileOutputStream)localObject2);
        if (localObject1 == null) {
          paramContext = "init -- failed to get rename fileLock#2!";
        } else {
          paramContext = "init -- get rename fileLock success!";
        }
      }
      paramContext = new StringBuilder();
      paramContext.append("getTbsCoreLoadFileLock #2 renameFileLock is ");
      paramContext.append(localObject1);
      TbsLog.i("FileHelper", paramContext.toString());
      return (FileLock)localObject1;
    }
    TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #3");
    paramContext = a(paramContext, true, "tbs_rename_lock");
    try
    {
      d = new RandomAccessFile(paramContext.getAbsolutePath(), "r");
      paramContext = d.getChannel().tryLock(0L, Long.MAX_VALUE, true);
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      paramContext = null;
    }
    if (paramContext == null) {
      localObject1 = new StringBuilder();
    }
    for (localObject2 = "getTbsCoreLoadFileLock -- failed: ";; localObject2 = "getTbsCoreLoadFileLock -- success: ")
    {
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("tbs_rename_lock");
      TbsLog.i("FileHelper", ((StringBuilder)localObject1).toString());
      return paramContext;
      localObject1 = new StringBuilder();
    }
  }
  
  public static FileLock f(Context paramContext)
  {
    paramContext = a(paramContext, true, "tbs_rename_lock");
    try
    {
      d = new RandomAccessFile(paramContext.getAbsolutePath(), "rw");
      paramContext = d.getChannel().tryLock(0L, Long.MAX_VALUE, false);
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
      paramContext = null;
    }
    StringBuilder localStringBuilder;
    if (paramContext == null) {
      localStringBuilder = new StringBuilder();
    }
    for (String str = "getTbsCoreRenameFileLock -- failed: ";; str = "getTbsCoreRenameFileLock -- success: ")
    {
      localStringBuilder.append(str);
      localStringBuilder.append("tbs_rename_lock");
      TbsLog.i("FileHelper", localStringBuilder.toString());
      return paramContext;
      localStringBuilder = new StringBuilder();
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean a(File paramFile1, File paramFile2);
  }
  
  public static abstract interface b
  {
    public abstract boolean a(InputStream paramInputStream, ZipEntry paramZipEntry, String paramString);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\utils\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */