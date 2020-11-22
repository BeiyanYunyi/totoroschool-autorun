package com.autonavi.base.amap.mapcore;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import com.amap.api.mapcore.util.gk;
import com.amap.api.maps.MapsInitializer;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class FileUtil
{
  private static final String TAG = "FileUtil";
  private static final char UNIX_SEPARATOR = '/';
  private static final char WINDOWS_SEPARATOR = '\\';
  
  public static boolean checkCanWrite(File paramFile)
  {
    if (paramFile == null) {
      return false;
    }
    if (!paramFile.canWrite()) {
      return false;
    }
    paramFile = new File(paramFile, "amap.tmp");
    try
    {
      paramFile.createNewFile();
      if (!paramFile.exists()) {
        return false;
      }
      try
      {
        paramFile.delete();
        return true;
      }
      catch (Exception paramFile)
      {
        paramFile.printStackTrace();
        return false;
      }
      return false;
    }
    catch (IOException paramFile)
    {
      paramFile.printStackTrace();
    }
  }
  
  public static void copy(Context paramContext, String paramString, File paramFile)
    throws Exception
  {
    paramFile.delete();
    paramString = paramContext.getAssets().open(paramString);
    paramContext = new byte[paramString.available()];
    paramString.read(paramContext);
    paramString.close();
    paramString = new FileOutputStream(paramFile);
    paramString.write(paramContext);
    paramString.close();
  }
  
  public static void createNoMediaFileIfNotExist(String paramString) {}
  
  public static boolean deleteFile(File paramFile)
  {
    if (paramFile != null)
    {
      if (!paramFile.exists()) {
        return false;
      }
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        if (arrayOfFile != null)
        {
          int i = 0;
          while (i < arrayOfFile.length)
          {
            if (arrayOfFile[i].isFile())
            {
              if (!arrayOfFile[i].delete()) {
                return false;
              }
            }
            else
            {
              if (!deleteFile(arrayOfFile[i])) {
                return false;
              }
              arrayOfFile[i].delete();
            }
            i += 1;
          }
        }
      }
      paramFile.delete();
      return true;
    }
    return false;
  }
  
  public static String getExternalStroragePath(Context paramContext)
  {
    int j = Build.VERSION.SDK_INT;
    if (j >= 12)
    {
      for (;;)
      {
        try
        {
          StorageManager localStorageManager = (StorageManager)paramContext.getSystemService("storage");
          localObject1 = StorageManager.class.getMethod("getVolumeList", new Class[0]);
          Method localMethod1 = StorageManager.class.getMethod("getVolumeState", new Class[] { String.class });
          Object[] arrayOfObject = (Object[])((Method)localObject1).invoke(localStorageManager, new Object[0]);
          int k = arrayOfObject.length;
          localObject2 = "";
          localObject1 = "";
          i = 0;
          if (i < k)
          {
            Object localObject5 = arrayOfObject[i];
            localObject4 = localObject5.getClass().getMethod("getPath", new Class[0]);
            Method localMethod2 = localObject5.getClass().getMethod("isRemovable", new Class[0]);
            localObject3 = (String)((Method)localObject4).invoke(localObject5, new Object[0]);
            localObject4 = (String)localMethod1.invoke(localStorageManager, new Object[] { ((Method)localObject4).invoke(localObject5, new Object[0]) });
            localObject5 = (Boolean)localMethod2.invoke(localObject5, new Object[0]);
            if ((TextUtils.isEmpty((CharSequence)localObject3)) || (!((String)localObject3).toLowerCase().contains("private")))
            {
              if (!((Boolean)localObject5).booleanValue()) {
                continue;
              }
              if ((localObject3 != null) && (localObject4 != null))
              {
                bool = ((String)localObject4).equals("mounted");
                if (bool) {
                  if (j > 18) {}
                }
              }
            }
          }
        }
        catch (Throwable paramContext)
        {
          Object localObject1;
          Object localObject2;
          int i;
          Object localObject4;
          Object localObject3;
          boolean bool;
          continue;
        }
        try
        {
          paramContext = paramContext.getExternalFilesDirs(null);
          if (paramContext != null)
          {
            if (paramContext.length > 1)
            {
              paramContext = paramContext[1].getAbsolutePath();
              continue;
            }
          }
          else {
            paramContext = null;
          }
        }
        catch (Exception paramContext)
        {
          continue;
        }
        paramContext = (Context)localObject3;
        continue;
        continue;
        localObject2 = localObject4;
        localObject1 = localObject3;
        i += 1;
      }
      paramContext = null;
      if (j <= 18)
      {
        if ((paramContext == null) && (localObject1 != null) && (localObject2 != null) && (((String)localObject2).equals("mounted"))) {
          return (String)localObject1;
        }
      }
      else
      {
        localObject3 = paramContext;
        if (localObject1 != null)
        {
          localObject3 = paramContext;
          if (localObject2 != null)
          {
            bool = ((String)localObject2).equals("mounted");
            localObject3 = paramContext;
            if (bool) {
              localObject3 = localObject1;
            }
          }
        }
        return (String)localObject3;
      }
    }
    else
    {
      if (Environment.getExternalStorageState().equals("mounted")) {
        return Environment.getExternalStorageDirectory().toString();
      }
      return null;
    }
    return paramContext;
  }
  
  public static String getMapBaseStorage(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    int i = Build.VERSION.SDK_INT;
    Object localObject1 = "map_base_path";
    if (i > 18) {
      localObject1 = "map_base_path_v44";
    }
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("base_path", 0);
    if ((MapsInitializer.sdcardDir != null) && (MapsInitializer.sdcardDir.trim().length() > 0))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(MapsInitializer.sdcardDir);
      ((StringBuilder)localObject2).append(File.separatorChar);
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    else
    {
      localObject2 = localSharedPreferences.getString((String)localObject1, "");
    }
    File localFile;
    if ((localObject2 != null) && (((String)localObject2).length() > 2))
    {
      localFile = new File((String)localObject2);
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      if (localFile.isDirectory())
      {
        if (checkCanWrite(localFile)) {
          return (String)localObject2;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramContext.getCacheDir().toString());
        ((StringBuilder)localObject2).append("/amap/");
        localObject2 = ((StringBuilder)localObject2).toString();
        if ((localObject2 != null) && (((String)localObject2).length() > 2))
        {
          localFile = new File((String)localObject2);
          if (!localFile.exists()) {
            localFile.mkdir();
          }
          if (localFile.isDirectory()) {
            return (String)localObject2;
          }
        }
      }
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(getExternalStroragePath(paramContext));
    ((StringBuilder)localObject2).append("/amap/");
    localObject2 = ((StringBuilder)localObject2).toString();
    if ((localObject2 != null) && (((String)localObject2).length() > 2))
    {
      localFile = new File((String)localObject2);
      if (!localFile.exists()) {
        localFile.mkdir();
      }
      if ((localFile.isDirectory()) && (localFile.canWrite()))
      {
        paramContext = localSharedPreferences.edit();
        paramContext.putString((String)localObject1, (String)localObject2);
        paramContext.commit();
        createNoMediaFileIfNotExist((String)localObject2);
        return (String)localObject2;
      }
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramContext.getCacheDir().toString());
    ((StringBuilder)localObject1).append("/amap/");
    paramContext = ((StringBuilder)localObject1).toString();
    if ((paramContext != null) && (paramContext.length() > 2))
    {
      localObject1 = new File(paramContext);
      if (!((File)localObject1).exists()) {
        ((File)localObject1).mkdir();
      }
      if (((File)localObject1).isDirectory()) {
        return paramContext;
      }
    }
    return paramContext;
  }
  
  public static String getName(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return paramString.substring(indexOfLastSeparator(paramString) + 1);
  }
  
  public static int indexOfLastSeparator(String paramString)
  {
    if (paramString == null) {
      return -1;
    }
    return Math.max(paramString.lastIndexOf('/'), paramString.lastIndexOf('\\'));
  }
  
  public static byte[] readFileContents(String paramString)
  {
    try
    {
      paramString = new File(paramString);
      if (!paramString.exists()) {
        return null;
      }
      paramString = new FileInputStream(paramString);
      byte[] arrayOfByte = new byte['Ѐ'];
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      for (;;)
      {
        int i = paramString.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      localByteArrayOutputStream.close();
      paramString.close();
      paramString = localByteArrayOutputStream.toByteArray();
      return paramString;
    }
    catch (Throwable paramString)
    {
      gk.c(paramString, "FileUtil", "readFileContents");
    }
    return null;
  }
  
  public static byte[] readFileContentsFromAssets(Context paramContext, String paramString)
  {
    paramContext = paramContext.getAssets();
    try
    {
      paramContext = paramContext.open(paramString);
      int j = paramContext.available();
      if (j == 0) {
        return null;
      }
      paramString = new byte[j];
      int i = 0;
      while (i < j) {
        i += paramContext.read(paramString, i, j - i);
      }
      paramContext.close();
      return paramString;
    }
    catch (IOException paramContext)
    {
      return null;
    }
    catch (OutOfMemoryError paramContext) {}
    return null;
  }
  
  public static void saveFile(String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      String str = Environment.getExternalStorageDirectory().getAbsolutePath();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("/");
      localStringBuilder.append(paramString2);
      paramString2 = new File(localStringBuilder.toString());
      if (!paramString2.exists())
      {
        new File(paramString2.getParent()).mkdirs();
        paramString2.createNewFile();
      }
      paramString2 = new FileOutputStream(paramString2, paramBoolean);
      paramString2.write(paramString1.getBytes("utf-8"));
      paramString2.close();
      return;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (FileNotFoundException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  /* Error */
  public static void writeDatasToFile(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 342	java/util/concurrent/locks/ReentrantReadWriteLock
    //   3: dup
    //   4: invokespecial 343	java/util/concurrent/locks/ReentrantReadWriteLock:<init>	()V
    //   7: invokevirtual 347	java/util/concurrent/locks/ReentrantReadWriteLock:writeLock	()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
    //   10: astore_2
    //   11: aload_2
    //   12: invokevirtual 352	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:lock	()V
    //   15: aload_1
    //   16: ifnull +82 -> 98
    //   19: aload_1
    //   20: arraylength
    //   21: ifne +6 -> 27
    //   24: goto +74 -> 98
    //   27: new 26	java/io/File
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 238	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore_0
    //   36: aload_0
    //   37: invokevirtual 41	java/io/File:exists	()Z
    //   40: ifeq +8 -> 48
    //   43: aload_0
    //   44: invokevirtual 44	java/io/File:delete	()Z
    //   47: pop
    //   48: aload_0
    //   49: invokevirtual 38	java/io/File:createNewFile	()Z
    //   52: pop
    //   53: new 77	java/io/FileOutputStream
    //   56: dup
    //   57: aload_0
    //   58: invokespecial 80	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   61: astore_0
    //   62: aload_0
    //   63: aload_1
    //   64: invokevirtual 355	java/io/OutputStream:write	([B)V
    //   67: aload_0
    //   68: invokevirtual 358	java/io/OutputStream:flush	()V
    //   71: aload_0
    //   72: invokevirtual 359	java/io/OutputStream:close	()V
    //   75: aload_2
    //   76: invokevirtual 362	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   79: return
    //   80: astore_0
    //   81: goto +11 -> 92
    //   84: astore_0
    //   85: aload_0
    //   86: invokevirtual 47	java/lang/Exception:printStackTrace	()V
    //   89: goto -14 -> 75
    //   92: aload_2
    //   93: invokevirtual 362	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   96: aload_0
    //   97: athrow
    //   98: aload_2
    //   99: invokevirtual 362	java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock:unlock	()V
    //   102: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	paramString	String
    //   0	103	1	paramArrayOfByte	byte[]
    //   10	89	2	localWriteLock	java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock
    // Exception table:
    //   from	to	target	type
    //   19	24	80	finally
    //   27	48	80	finally
    //   48	75	80	finally
    //   85	89	80	finally
    //   19	24	84	java/lang/Exception
    //   27	48	84	java/lang/Exception
    //   48	75	84	java/lang/Exception
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\mapcore\FileUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */