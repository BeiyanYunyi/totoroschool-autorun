package com.github.barteksc.pdfviewer.util;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.File;
import java.io.IOException;

public class FileUtils
{
  /* Error */
  public static void copy(java.io.InputStream paramInputStream, File paramFile)
    throws IOException
  {
    // Byte code:
    //   0: new 15	java/io/FileOutputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 18	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   8: astore_1
    //   9: sipush 1024
    //   12: newarray <illegal type>
    //   14: astore_3
    //   15: aload_0
    //   16: aload_3
    //   17: invokevirtual 24	java/io/InputStream:read	([B)I
    //   20: istore_2
    //   21: iload_2
    //   22: iconst_m1
    //   23: if_icmpeq +13 -> 36
    //   26: aload_1
    //   27: aload_3
    //   28: iconst_0
    //   29: iload_2
    //   30: invokevirtual 30	java/io/OutputStream:write	([BII)V
    //   33: goto -18 -> 15
    //   36: aload_0
    //   37: ifnull +17 -> 54
    //   40: aload_0
    //   41: invokevirtual 33	java/io/InputStream:close	()V
    //   44: goto +10 -> 54
    //   47: astore_0
    //   48: aload_1
    //   49: invokevirtual 34	java/io/OutputStream:close	()V
    //   52: aload_0
    //   53: athrow
    //   54: aload_1
    //   55: invokevirtual 34	java/io/OutputStream:close	()V
    //   58: return
    //   59: astore_3
    //   60: goto +6 -> 66
    //   63: astore_3
    //   64: aconst_null
    //   65: astore_1
    //   66: aload_0
    //   67: ifnull +21 -> 88
    //   70: aload_0
    //   71: invokevirtual 33	java/io/InputStream:close	()V
    //   74: goto +14 -> 88
    //   77: astore_0
    //   78: aload_1
    //   79: ifnull +7 -> 86
    //   82: aload_1
    //   83: invokevirtual 34	java/io/OutputStream:close	()V
    //   86: aload_0
    //   87: athrow
    //   88: aload_1
    //   89: ifnull +7 -> 96
    //   92: aload_1
    //   93: invokevirtual 34	java/io/OutputStream:close	()V
    //   96: aload_3
    //   97: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	paramInputStream	java.io.InputStream
    //   0	98	1	paramFile	File
    //   20	10	2	i	int
    //   14	14	3	arrayOfByte	byte[]
    //   59	1	3	localObject1	Object
    //   63	34	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   40	44	47	finally
    //   9	15	59	finally
    //   15	21	59	finally
    //   26	33	59	finally
    //   0	9	63	finally
    //   70	74	77	finally
  }
  
  public static File fileFromAsset(Context paramContext, String paramString)
    throws IOException
  {
    File localFile = paramContext.getCacheDir();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("-pdfview.pdf");
    localFile = new File(localFile, localStringBuilder.toString());
    if (paramString.contains("/")) {
      localFile.getParentFile().mkdirs();
    }
    copy(paramContext.getAssets().open(paramString), localFile);
    return localFile;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\github\barteksc\pdfviewer\util\FileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */