package com.autonavi.base.amap.mapcore;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.amap.api.mapcore.util.dx;
import com.amap.api.mapcore.util.fj;
import com.amap.api.mapcore.util.fv;
import com.amap.api.mapcore.util.gk;
import com.amap.api.mapcore.util.hi;
import com.amap.api.mapcore.util.hl;
import com.amap.api.mapcore.util.hn;
import com.amap.api.mapcore.util.hq;
import com.amap.api.mapcore.util.je;
import com.amap.api.mapcore.util.jf;
import com.autonavi.amap.mapcore.MsgProcessor;
import com.autonavi.base.ae.gmap.GLMapEngine.InitParam;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@SuppressLint({"NewApi"})
public class AeUtil
{
  private static final int BUFFER = 1024;
  public static final String CONFIGNAME = "GNaviConfig.xml";
  public static final boolean IS_AE = true;
  public static final String RESZIPNAME = "res.zip";
  public static final String ROOTPATH = "/amap/";
  public static final String ROOT_DATA_PATH_NAME = "data_v6";
  public static final String ROOT_DATA_PATH_OLD_NAME = "data";
  public static final String SO_FILENAME = "AMapSDK_MAP_v7_1_0";
  public static final String SO_FILENAME_NAVI = "AMapSDK_NAVI_v6_5_0";
  
  private static boolean checkEngineRes(File paramFile)
  {
    paramFile = paramFile.listFiles();
    return (paramFile != null) && (paramFile.length >= 2);
  }
  
  private static void decompress(File paramFile1, File paramFile2, ZipInputStream paramZipInputStream, long paramLong, ZipCompressProgressListener paramZipCompressProgressListener, UnZipFileBrake paramUnZipFileBrake)
    throws Exception
  {
    int k = 0;
    int i = 0;
    for (;;)
    {
      ZipEntry localZipEntry = paramZipInputStream.getNextEntry();
      j = k;
      if (localZipEntry == null) {
        break label168;
      }
      if ((paramUnZipFileBrake != null) && (paramUnZipFileBrake.mIsAborted))
      {
        paramZipInputStream.closeEntry();
        return;
      }
      Object localObject = localZipEntry.getName();
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (((String)localObject).contains("../"))) {
        break;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramFile2.getPath());
      localStringBuilder.append(File.separator);
      localStringBuilder.append((String)localObject);
      localObject = new File(localStringBuilder.toString());
      fileProber((File)localObject);
      if (localZipEntry.isDirectory()) {
        ((File)localObject).mkdirs();
      } else {
        i += decompressFile((File)localObject, paramZipInputStream, i, paramLong, paramZipCompressProgressListener, paramUnZipFileBrake);
      }
      paramZipInputStream.closeEntry();
    }
    int j = 1;
    label168:
    if ((j != 0) && (paramFile1 != null)) {}
    try
    {
      paramFile1.delete();
      return;
    }
    catch (Exception paramFile1) {}
  }
  
  public static void decompress(InputStream paramInputStream, String paramString)
    throws Exception
  {
    decompress(paramInputStream, paramString, 0L, null);
  }
  
  private static void decompress(InputStream paramInputStream, String paramString, long paramLong, ZipCompressProgressListener paramZipCompressProgressListener)
    throws Exception
  {
    paramInputStream = new CheckedInputStream(paramInputStream, new CRC32());
    ZipInputStream localZipInputStream = new ZipInputStream(paramInputStream);
    decompress(null, new File(paramString), localZipInputStream, paramLong, paramZipCompressProgressListener, null);
    localZipInputStream.close();
    paramInputStream.close();
  }
  
  private static int decompressFile(File paramFile, ZipInputStream paramZipInputStream, long paramLong1, long paramLong2, ZipCompressProgressListener paramZipCompressProgressListener, UnZipFileBrake paramUnZipFileBrake)
    throws Exception
  {
    paramFile = new BufferedOutputStream(new FileOutputStream(paramFile));
    byte[] arrayOfByte = new byte['Ѐ'];
    int i = 0;
    for (;;)
    {
      int j = paramZipInputStream.read(arrayOfByte, 0, 1024);
      if (j == -1) {
        break;
      }
      if ((paramUnZipFileBrake != null) && (paramUnZipFileBrake.mIsAborted))
      {
        paramFile.close();
        return i;
      }
      paramFile.write(arrayOfByte, 0, j);
      j = i + j;
      i = j;
      if (paramLong2 > 0L)
      {
        i = j;
        if (paramZipCompressProgressListener != null)
        {
          long l = (j + paramLong1) * 100L / paramLong2;
          if (paramUnZipFileBrake != null)
          {
            i = j;
            if (paramUnZipFileBrake.mIsAborted) {}
          }
          else
          {
            paramZipCompressProgressListener.onFinishProgress(l);
            i = j;
          }
        }
      }
    }
    paramFile.close();
    return i;
  }
  
  private static void fileProber(File paramFile)
  {
    paramFile = paramFile.getParentFile();
    if (!paramFile.exists())
    {
      fileProber(paramFile);
      paramFile.mkdir();
    }
  }
  
  public static GLMapEngine.InitParam initResource(final Context paramContext)
  {
    String str = FileUtil.getMapBaseStorage(paramContext);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append("data_v6");
    ((StringBuilder)localObject).append("/");
    localObject = ((StringBuilder)localObject).toString();
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    localFile = new File((String)localObject);
    if (!localFile.exists()) {
      localFile.mkdir();
    }
    if (Looper.myLooper() == Looper.getMainLooper()) {
      try
      {
        je.a(1).a(new jf()
        {
          public void runTask()
          {
            AeUtil.loadEngineRes(this.val$currentPath, paramContext);
          }
        });
      }
      catch (fj localfj)
      {
        localfj.printStackTrace();
      }
    } else {
      loadEngineRes(str, paramContext);
    }
    GLMapEngine.InitParam localInitParam = new GLMapEngine.InitParam();
    paramContext = FileUtil.readFileContentsFromAssets(paramContext, "ae/GNaviConfig.xml");
    localInitParam.mRootPath = str;
    if (paramContext != null) {
      try
      {
        localInitParam.mConfigContent = new String(paramContext, "utf-8");
        if (!localInitParam.mConfigContent.contains("data_v6")) {
          throw new Exception("GNaviConfig.xml 和数据目录data_v6不匹配");
        }
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    paramContext = new StringBuilder();
    paramContext.append((String)localObject);
    paramContext.append("/");
    paramContext.append("map/");
    localInitParam.mOfflineDataPath = paramContext.toString();
    localInitParam.mP3dCrossPath = ((String)localObject);
    return localInitParam;
  }
  
  /* Error */
  private static void loadEngineRes(String paramString, Context paramContext)
  {
    // Byte code:
    //   0: new 57	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: ldc_w 264
    //   8: invokespecial 267	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: astore_2
    //   12: aload_2
    //   13: invokevirtual 186	java/io/File:exists	()Z
    //   16: ifeq +10 -> 26
    //   19: aload_2
    //   20: invokevirtual 268	java/io/File:isDirectory	()Z
    //   23: ifne +8 -> 31
    //   26: aload_2
    //   27: invokevirtual 126	java/io/File:mkdirs	()Z
    //   30: pop
    //   31: aload_2
    //   32: invokestatic 270	com/autonavi/base/amap/mapcore/AeUtil:checkEngineRes	(Ljava/io/File;)Z
    //   35: ifne +123 -> 158
    //   38: aconst_null
    //   39: astore_3
    //   40: aconst_null
    //   41: astore 4
    //   43: aconst_null
    //   44: astore_0
    //   45: aload_1
    //   46: invokevirtual 276	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   49: ldc_w 278
    //   52: invokevirtual 284	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   55: astore_1
    //   56: aload_1
    //   57: aload_2
    //   58: invokevirtual 287	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   61: invokestatic 289	com/autonavi/base/amap/mapcore/AeUtil:decompress	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   64: aload_1
    //   65: ifnull +93 -> 158
    //   68: aload_1
    //   69: invokevirtual 292	java/io/InputStream:close	()V
    //   72: return
    //   73: astore_0
    //   74: aload_0
    //   75: invokevirtual 293	java/io/IOException:printStackTrace	()V
    //   78: return
    //   79: astore_0
    //   80: goto +60 -> 140
    //   83: astore_0
    //   84: aload_0
    //   85: astore_2
    //   86: goto +20 -> 106
    //   89: astore_0
    //   90: aload_0
    //   91: astore_2
    //   92: goto +33 -> 125
    //   95: astore_2
    //   96: aload_0
    //   97: astore_1
    //   98: aload_2
    //   99: astore_0
    //   100: goto +40 -> 140
    //   103: astore_2
    //   104: aload_3
    //   105: astore_1
    //   106: aload_1
    //   107: astore_0
    //   108: aload_2
    //   109: invokevirtual 294	java/lang/OutOfMemoryError:printStackTrace	()V
    //   112: aload_1
    //   113: ifnull +45 -> 158
    //   116: aload_1
    //   117: invokevirtual 292	java/io/InputStream:close	()V
    //   120: return
    //   121: astore_2
    //   122: aload 4
    //   124: astore_1
    //   125: aload_1
    //   126: astore_0
    //   127: aload_2
    //   128: invokevirtual 295	java/lang/Exception:printStackTrace	()V
    //   131: aload_1
    //   132: ifnull +26 -> 158
    //   135: aload_1
    //   136: invokevirtual 292	java/io/InputStream:close	()V
    //   139: return
    //   140: aload_1
    //   141: ifnull +15 -> 156
    //   144: aload_1
    //   145: invokevirtual 292	java/io/InputStream:close	()V
    //   148: goto +8 -> 156
    //   151: astore_1
    //   152: aload_1
    //   153: invokevirtual 293	java/io/IOException:printStackTrace	()V
    //   156: aload_0
    //   157: athrow
    //   158: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	paramString	String
    //   0	159	1	paramContext	Context
    //   11	81	2	localObject1	Object
    //   95	4	2	localObject2	Object
    //   103	6	2	localOutOfMemoryError	OutOfMemoryError
    //   121	7	2	localException	Exception
    //   39	66	3	localObject3	Object
    //   41	82	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   68	72	73	java/io/IOException
    //   116	120	73	java/io/IOException
    //   135	139	73	java/io/IOException
    //   56	64	79	finally
    //   56	64	83	java/lang/OutOfMemoryError
    //   56	64	89	java/lang/Exception
    //   45	56	95	finally
    //   108	112	95	finally
    //   127	131	95	finally
    //   45	56	103	java/lang/OutOfMemoryError
    //   45	56	121	java/lang/Exception
    //   144	148	151	java/io/IOException
  }
  
  public static void loadLib(Context paramContext)
  {
    try
    {
      Object localObject = hl.a(paramContext, dx.e());
      boolean bool = hq.a().a(paramContext, dx.e(), ((hl)localObject).d(), "AMapSDK_MAP_v7_1_0");
      hn.a().a(paramContext);
      if ((bool) || (hi.b(dx.e())) || (hi.a(dx.e()).a(paramContext)))
      {
        localObject = dx.e();
        if (localObject != null)
        {
          MsgProcessor.nativeInitInfo(paramContext, hi.a((fv)localObject).b(paramContext), ((fv)localObject).a(), ((fv)localObject).b(), ((fv)localObject).c(), ((fv)localObject).g());
          return;
        }
      }
    }
    catch (Throwable paramContext)
    {
      gk.c(paramContext, "AeUtil", "loadLib");
    }
  }
  
  /* Error */
  public static void readAssetsFileAndSave(String paramString1, String paramString2, Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 89	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aconst_null
    //   9: astore 4
    //   11: aconst_null
    //   12: astore 5
    //   14: aload_2
    //   15: invokevirtual 276	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   18: aload_0
    //   19: invokevirtual 284	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   22: astore_0
    //   23: new 57	java/io/File
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   31: astore_1
    //   32: aload_1
    //   33: invokevirtual 186	java/io/File:exists	()Z
    //   36: ifeq +8 -> 44
    //   39: aload_1
    //   40: invokevirtual 133	java/io/File:delete	()Z
    //   43: pop
    //   44: aload_1
    //   45: invokevirtual 373	java/io/File:createNewFile	()Z
    //   48: pop
    //   49: new 159	java/io/FileOutputStream
    //   52: dup
    //   53: aload_1
    //   54: invokespecial 161	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   57: astore_1
    //   58: sipush 1024
    //   61: newarray <illegal type>
    //   63: astore_2
    //   64: aload_0
    //   65: aload_2
    //   66: iconst_0
    //   67: sipush 1024
    //   70: invokevirtual 374	java/io/InputStream:read	([BII)I
    //   73: istore_3
    //   74: iload_3
    //   75: ifle +13 -> 88
    //   78: aload_1
    //   79: aload_2
    //   80: iconst_0
    //   81: iload_3
    //   82: invokevirtual 375	java/io/FileOutputStream:write	([BII)V
    //   85: goto -21 -> 64
    //   88: aload_0
    //   89: ifnull +15 -> 104
    //   92: aload_0
    //   93: invokevirtual 292	java/io/InputStream:close	()V
    //   96: goto +8 -> 104
    //   99: astore_0
    //   100: aload_0
    //   101: invokevirtual 293	java/io/IOException:printStackTrace	()V
    //   104: aload_1
    //   105: invokevirtual 376	java/io/FileOutputStream:close	()V
    //   108: return
    //   109: astore_0
    //   110: aload_0
    //   111: invokevirtual 293	java/io/IOException:printStackTrace	()V
    //   114: return
    //   115: astore 4
    //   117: aload_0
    //   118: astore_2
    //   119: aload 4
    //   121: astore_0
    //   122: goto +77 -> 199
    //   125: astore_2
    //   126: goto +37 -> 163
    //   129: astore 5
    //   131: aload 4
    //   133: astore_1
    //   134: aload_0
    //   135: astore_2
    //   136: aload 5
    //   138: astore_0
    //   139: goto +60 -> 199
    //   142: astore_2
    //   143: aconst_null
    //   144: astore_1
    //   145: goto +18 -> 163
    //   148: astore_0
    //   149: aconst_null
    //   150: astore_2
    //   151: aload 4
    //   153: astore_1
    //   154: goto +45 -> 199
    //   157: astore_2
    //   158: aconst_null
    //   159: astore_1
    //   160: aload 5
    //   162: astore_0
    //   163: aload_2
    //   164: invokevirtual 250	java/lang/Throwable:printStackTrace	()V
    //   167: aload_0
    //   168: ifnull +15 -> 183
    //   171: aload_0
    //   172: invokevirtual 292	java/io/InputStream:close	()V
    //   175: goto +8 -> 183
    //   178: astore_0
    //   179: aload_0
    //   180: invokevirtual 293	java/io/IOException:printStackTrace	()V
    //   183: aload_1
    //   184: ifnull +7 -> 191
    //   187: aload_1
    //   188: invokevirtual 376	java/io/FileOutputStream:close	()V
    //   191: return
    //   192: astore 4
    //   194: aload_0
    //   195: astore_2
    //   196: aload 4
    //   198: astore_0
    //   199: aload_2
    //   200: ifnull +15 -> 215
    //   203: aload_2
    //   204: invokevirtual 292	java/io/InputStream:close	()V
    //   207: goto +8 -> 215
    //   210: astore_2
    //   211: aload_2
    //   212: invokevirtual 293	java/io/IOException:printStackTrace	()V
    //   215: aload_1
    //   216: ifnull +15 -> 231
    //   219: aload_1
    //   220: invokevirtual 376	java/io/FileOutputStream:close	()V
    //   223: goto +8 -> 231
    //   226: astore_1
    //   227: aload_1
    //   228: invokevirtual 293	java/io/IOException:printStackTrace	()V
    //   231: aload_0
    //   232: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	paramString1	String
    //   0	233	1	paramString2	String
    //   0	233	2	paramContext	Context
    //   73	9	3	i	int
    //   9	1	4	localObject1	Object
    //   115	37	4	localObject2	Object
    //   192	5	4	localObject3	Object
    //   12	1	5	localObject4	Object
    //   129	32	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   92	96	99	java/io/IOException
    //   104	108	109	java/io/IOException
    //   187	191	109	java/io/IOException
    //   58	64	115	finally
    //   64	74	115	finally
    //   78	85	115	finally
    //   58	64	125	java/lang/Throwable
    //   64	74	125	java/lang/Throwable
    //   78	85	125	java/lang/Throwable
    //   23	44	129	finally
    //   44	58	129	finally
    //   23	44	142	java/lang/Throwable
    //   44	58	142	java/lang/Throwable
    //   14	23	148	finally
    //   14	23	157	java/lang/Throwable
    //   171	175	178	java/io/IOException
    //   163	167	192	finally
    //   203	207	210	java/io/IOException
    //   219	223	226	java/io/IOException
  }
  
  public static class UnZipFileBrake
  {
    public boolean mIsAborted = false;
  }
  
  public static abstract interface ZipCompressProgressListener
  {
    public abstract void onFinishProgress(long paramLong);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\mapcore\AeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */