package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONArray;
import org.json.JSONObject;

public class ho
{
  private static fv a(String paramString, List<fv> paramList)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    int i = 0;
    while ((paramList != null) && (i < paramList.size()))
    {
      fv localfv = (fv)paramList.get(i);
      if (localfv != null)
      {
        String[] arrayOfString = localfv.g();
        int j = 0;
        while (j < arrayOfString.length)
        {
          if ((!TextUtils.isEmpty(arrayOfString[i])) && (paramString.contains(arrayOfString[j]))) {
            return localfv;
          }
          j += 1;
        }
      }
      i += 1;
    }
    return null;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return fs.b(paramString);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(fp.w(paramContext));
    localStringBuilder.append(paramString);
    return fs.b(localStringBuilder.toString());
  }
  
  public static Field a(Object paramObject, String paramString)
    throws NoSuchFieldException
  {
    for (Object localObject = paramObject.getClass(); localObject != null; localObject = ((Class)localObject).getSuperclass()) {
      try
      {
        Field localField = ((Class)localObject).getDeclaredField(paramString);
        if (!localField.isAccessible()) {
          localField.setAccessible(true);
        }
        return localField;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        for (;;) {}
      }
    }
    localObject = new StringBuilder("Field ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" not found in ");
    ((StringBuilder)localObject).append(paramObject.getClass());
    throw new NoSuchFieldException(((StringBuilder)localObject).toString());
  }
  
  public static Method a(Object paramObject, String paramString, Class<?>... paramVarArgs)
    throws NoSuchMethodException
  {
    for (Object localObject = paramObject.getClass(); localObject != null; localObject = ((Class)localObject).getSuperclass()) {
      try
      {
        Method localMethod = ((Class)localObject).getDeclaredMethod(paramString, paramVarArgs);
        if (!localMethod.isAccessible()) {
          localMethod.setAccessible(true);
        }
        return localMethod;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        for (;;) {}
      }
    }
    localObject = new StringBuilder("Method ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" with parameters ");
    ((StringBuilder)localObject).append(Arrays.asList(paramVarArgs));
    ((StringBuilder)localObject).append(" not found in ");
    ((StringBuilder)localObject).append(paramObject.getClass());
    throw new NoSuchMethodException(((StringBuilder)localObject).toString());
  }
  
  private static JSONObject a(Thread paramThread)
  {
    StackTraceElement[] arrayOfStackTraceElement;
    JSONObject localJSONObject;
    if ((paramThread != null) && (paramThread.getStackTrace() != null))
    {
      arrayOfStackTraceElement = paramThread.getStackTrace();
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("threadId", paramThread.getId());
      localJSONObject.put("threadName", paramThread.getName());
      localJSONObject.put("threadGroup", paramThread.getThreadGroup());
      paramThread = new StringBuffer();
      int j = arrayOfStackTraceElement.length;
      int i = 0;
      while (i < j)
      {
        paramThread.append(arrayOfStackTraceElement[i]);
        paramThread.append("<br />");
        i += 1;
      }
      localJSONObject.put("stacks", paramThread.toString());
      return localJSONObject;
    }
    catch (Throwable paramThread) {}
    return null;
    return localJSONObject;
  }
  
  private static void a(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      paramFile = paramFile.listFiles();
      if (paramFile == null) {
        return;
      }
      int i = 0;
      while (i < paramFile.length)
      {
        if (paramFile[i].isDirectory()) {
          a(paramFile[i]);
        } else {
          paramFile[i].delete();
        }
        i += 1;
      }
      return;
    }
    paramFile.delete();
  }
  
  public static void a(Object paramObject, String paramString, Object[] paramArrayOfObject)
    throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
    paramString = a(paramObject, paramString);
    Object[] arrayOfObject1 = (Object[])paramString.get(paramObject);
    Object[] arrayOfObject2 = (Object[])Array.newInstance(arrayOfObject1.getClass().getComponentType(), arrayOfObject1.length + paramArrayOfObject.length);
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject2, 0, paramArrayOfObject.length);
    System.arraycopy(arrayOfObject1, 0, arrayOfObject2, paramArrayOfObject.length, arrayOfObject1.length);
    paramString.set(paramObject, arrayOfObject2);
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
  }
  
  /* Error */
  public static void a(String paramString, jn paramjn)
  {
    // Byte code:
    //   0: new 180	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 225	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokestatic 229	com/amap/api/mapcore/util/ho:c	(Ljava/io/File;)Z
    //   11: ifne +4 -> 15
    //   14: return
    //   15: sipush 1024
    //   18: newarray <illegal type>
    //   20: astore 7
    //   22: aconst_null
    //   23: astore 4
    //   25: aconst_null
    //   26: astore 6
    //   28: new 231	java/io/FileInputStream
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 232	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   36: astore_0
    //   37: aload_0
    //   38: astore_3
    //   39: new 234	java/util/zip/ZipInputStream
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 237	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   47: astore 5
    //   49: aload 5
    //   51: invokevirtual 241	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   54: astore_3
    //   55: aload_3
    //   56: ifnull +112 -> 168
    //   59: aload_3
    //   60: invokevirtual 244	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   63: astore_3
    //   64: aload_3
    //   65: ifnull +229 -> 294
    //   68: aload_3
    //   69: ldc -10
    //   71: invokevirtual 250	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   74: ifeq +220 -> 294
    //   77: iconst_1
    //   78: istore_2
    //   79: goto +3 -> 82
    //   82: iload_2
    //   83: ifeq +71 -> 154
    //   86: new 180	java/io/File
    //   89: dup
    //   90: aload_1
    //   91: aload_3
    //   92: invokevirtual 254	com/amap/api/mapcore/util/jn:a	(Ljava/lang/String;)Ljava/lang/String;
    //   95: invokespecial 225	java/io/File:<init>	(Ljava/lang/String;)V
    //   98: astore_3
    //   99: aload_3
    //   100: invokestatic 256	com/amap/api/mapcore/util/ho:b	(Ljava/io/File;)V
    //   103: new 180	java/io/File
    //   106: dup
    //   107: aload_3
    //   108: invokevirtual 259	java/io/File:getParent	()Ljava/lang/String;
    //   111: invokespecial 225	java/io/File:<init>	(Ljava/lang/String;)V
    //   114: invokevirtual 262	java/io/File:mkdirs	()Z
    //   117: pop
    //   118: new 264	java/io/FileOutputStream
    //   121: dup
    //   122: aload_3
    //   123: invokespecial 266	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   126: astore_3
    //   127: aload 5
    //   129: aload 7
    //   131: invokevirtual 270	java/util/zip/ZipInputStream:read	([B)I
    //   134: istore_2
    //   135: iload_2
    //   136: ifle +14 -> 150
    //   139: aload_3
    //   140: aload 7
    //   142: iconst_0
    //   143: iload_2
    //   144: invokevirtual 274	java/io/FileOutputStream:write	([BII)V
    //   147: goto -20 -> 127
    //   150: aload_3
    //   151: invokevirtual 277	java/io/FileOutputStream:close	()V
    //   154: aload 5
    //   156: invokevirtual 280	java/util/zip/ZipInputStream:closeEntry	()V
    //   159: aload 5
    //   161: invokevirtual 241	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   164: astore_3
    //   165: goto -110 -> 55
    //   168: aload 5
    //   170: invokevirtual 280	java/util/zip/ZipInputStream:closeEntry	()V
    //   173: aload 5
    //   175: invokevirtual 281	java/util/zip/ZipInputStream:close	()V
    //   178: aload_0
    //   179: invokevirtual 282	java/io/FileInputStream:close	()V
    //   182: aload 5
    //   184: invokevirtual 280	java/util/zip/ZipInputStream:closeEntry	()V
    //   187: aload 5
    //   189: invokevirtual 281	java/util/zip/ZipInputStream:close	()V
    //   192: aload_0
    //   193: invokevirtual 282	java/io/FileInputStream:close	()V
    //   196: return
    //   197: astore 4
    //   199: aload 5
    //   201: astore_1
    //   202: goto +69 -> 271
    //   205: astore_3
    //   206: aload 5
    //   208: astore_1
    //   209: aload_3
    //   210: astore 5
    //   212: goto +27 -> 239
    //   215: astore 5
    //   217: aload 6
    //   219: astore_1
    //   220: goto +19 -> 239
    //   223: astore 4
    //   225: aconst_null
    //   226: astore_1
    //   227: aload_1
    //   228: astore_0
    //   229: goto +42 -> 271
    //   232: astore 5
    //   234: aconst_null
    //   235: astore_0
    //   236: aload 6
    //   238: astore_1
    //   239: aload_1
    //   240: astore 4
    //   242: aload_0
    //   243: astore_3
    //   244: aload 5
    //   246: invokevirtual 285	java/lang/Throwable:printStackTrace	()V
    //   249: aload_1
    //   250: invokevirtual 280	java/util/zip/ZipInputStream:closeEntry	()V
    //   253: aload_1
    //   254: invokevirtual 281	java/util/zip/ZipInputStream:close	()V
    //   257: aload_0
    //   258: invokevirtual 282	java/io/FileInputStream:close	()V
    //   261: return
    //   262: astore_0
    //   263: aload 4
    //   265: astore_1
    //   266: aload_0
    //   267: astore 4
    //   269: aload_3
    //   270: astore_0
    //   271: aload_1
    //   272: invokevirtual 280	java/util/zip/ZipInputStream:closeEntry	()V
    //   275: aload_1
    //   276: invokevirtual 281	java/util/zip/ZipInputStream:close	()V
    //   279: aload_0
    //   280: invokevirtual 282	java/io/FileInputStream:close	()V
    //   283: aload 4
    //   285: athrow
    //   286: astore_0
    //   287: return
    //   288: astore_0
    //   289: return
    //   290: astore_0
    //   291: goto -8 -> 283
    //   294: iconst_0
    //   295: istore_2
    //   296: goto -214 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	paramString	String
    //   0	299	1	paramjn	jn
    //   78	218	2	i	int
    //   38	127	3	localObject1	Object
    //   205	5	3	localThrowable1	Throwable
    //   243	27	3	str	String
    //   23	1	4	localObject2	Object
    //   197	1	4	localObject3	Object
    //   223	1	4	localObject4	Object
    //   240	44	4	localObject5	Object
    //   47	164	5	localObject6	Object
    //   215	1	5	localThrowable2	Throwable
    //   232	13	5	localThrowable3	Throwable
    //   26	211	6	localObject7	Object
    //   20	121	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   49	55	197	finally
    //   59	64	197	finally
    //   68	77	197	finally
    //   86	127	197	finally
    //   127	135	197	finally
    //   139	147	197	finally
    //   150	154	197	finally
    //   154	165	197	finally
    //   168	182	197	finally
    //   49	55	205	java/lang/Throwable
    //   59	64	205	java/lang/Throwable
    //   68	77	205	java/lang/Throwable
    //   86	127	205	java/lang/Throwable
    //   127	135	205	java/lang/Throwable
    //   139	147	205	java/lang/Throwable
    //   150	154	205	java/lang/Throwable
    //   154	165	205	java/lang/Throwable
    //   168	182	205	java/lang/Throwable
    //   39	49	215	java/lang/Throwable
    //   28	37	223	finally
    //   28	37	232	java/lang/Throwable
    //   39	49	262	finally
    //   244	249	262	finally
    //   182	196	286	java/lang/Throwable
    //   249	261	288	java/lang/Throwable
    //   271	283	290	java/lang/Throwable
  }
  
  public static void a(String paramString1, String paramString2)
  {
    b(paramString1, paramString2);
    c(paramString1);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (!c(new File(paramString1))) {
      return;
    }
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      try
      {
        FileInputStream localFileInputStream = new FileInputStream(paramString1);
        ZipInputStream localZipInputStream = new ZipInputStream(localFileInputStream);
        paramString1 = localZipInputStream.getNextEntry();
        if (paramString1 != null)
        {
          paramString1 = paramString1.getName();
          if ((paramString1 != null) && (paramString1.equalsIgnoreCase("so.png")))
          {
            i = 1;
            if ((i == 0) && (!jm.a(paramString1)) && (!jm.b(paramString1)))
            {
              localZipInputStream.closeEntry();
              paramString1 = localZipInputStream.getNextEntry();
              continue;
            }
            if (jm.a(paramString1))
            {
              paramString1 = paramString2;
            }
            else
            {
              if (!jm.b(paramString1)) {
                break label220;
              }
              paramString1 = paramString4;
            }
            g(paramString1);
            paramString1 = new FileOutputStream(paramString1);
            i = localZipInputStream.read(arrayOfByte);
            if (i > 0)
            {
              paramString1.write(arrayOfByte, 0, i);
              continue;
            }
            paramString1.close();
            localZipInputStream.closeEntry();
            paramString1 = localZipInputStream.getNextEntry();
          }
        }
        else
        {
          localZipInputStream.closeEntry();
          localZipInputStream.close();
          localFileInputStream.close();
          return;
        }
      }
      catch (IOException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      int i = 0;
      continue;
      label220:
      paramString1 = paramString3;
    }
  }
  
  public static void a(Throwable paramThrowable, String paramString)
  {
    gk.c(paramThrowable, "po", paramString);
  }
  
  private static void b(File paramFile)
    throws IOException
  {
    if ((paramFile.exists()) && (paramFile.isFile())) {
      return;
    }
    if (!paramFile.exists())
    {
      paramFile.createNewFile();
      return;
    }
    if ((paramFile.exists()) && (!paramFile.isFile()))
    {
      paramFile.delete();
      paramFile.createNewFile();
    }
  }
  
  public static void b(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return;
    }
    a(paramString);
  }
  
  /* Error */
  public static void b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 328	com/amap/api/mapcore/util/ho:e	(Ljava/lang/String;)Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: aconst_null
    //   9: astore 4
    //   11: aconst_null
    //   12: astore 5
    //   14: new 180	java/io/File
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 225	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: astore_0
    //   23: new 180	java/io/File
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 225	java/io/File:<init>	(Ljava/lang/String;)V
    //   31: astore_1
    //   32: aload_1
    //   33: invokevirtual 331	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   36: invokestatic 306	com/amap/api/mapcore/util/ho:g	(Ljava/lang/String;)V
    //   39: new 231	java/io/FileInputStream
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 332	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   47: astore_3
    //   48: new 264	java/io/FileOutputStream
    //   51: dup
    //   52: aload_1
    //   53: invokespecial 266	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   56: astore_1
    //   57: sipush 1024
    //   60: newarray <illegal type>
    //   62: astore_0
    //   63: aload_3
    //   64: aload_0
    //   65: invokevirtual 335	java/io/InputStream:read	([B)I
    //   68: istore_2
    //   69: iload_2
    //   70: ifle +13 -> 83
    //   73: aload_1
    //   74: aload_0
    //   75: iconst_0
    //   76: iload_2
    //   77: invokevirtual 338	java/io/OutputStream:write	([BII)V
    //   80: goto -17 -> 63
    //   83: aload_1
    //   84: invokevirtual 341	java/io/OutputStream:flush	()V
    //   87: aload_3
    //   88: invokevirtual 342	java/io/InputStream:close	()V
    //   91: aload_1
    //   92: invokevirtual 343	java/io/OutputStream:close	()V
    //   95: return
    //   96: astore_0
    //   97: aload_0
    //   98: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   101: return
    //   102: astore_0
    //   103: goto +11 -> 114
    //   106: aload_1
    //   107: astore_0
    //   108: goto +38 -> 146
    //   111: astore_0
    //   112: aconst_null
    //   113: astore_1
    //   114: goto +9 -> 123
    //   117: astore_0
    //   118: aconst_null
    //   119: astore_1
    //   120: aload 5
    //   122: astore_3
    //   123: aload_3
    //   124: invokevirtual 342	java/io/InputStream:close	()V
    //   127: aload_1
    //   128: invokevirtual 343	java/io/OutputStream:close	()V
    //   131: goto +8 -> 139
    //   134: astore_1
    //   135: aload_1
    //   136: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   139: aload_0
    //   140: athrow
    //   141: aconst_null
    //   142: astore_3
    //   143: aload 4
    //   145: astore_0
    //   146: aload_3
    //   147: invokevirtual 342	java/io/InputStream:close	()V
    //   150: aload_0
    //   151: invokevirtual 343	java/io/OutputStream:close	()V
    //   154: return
    //   155: astore_0
    //   156: aload_0
    //   157: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   160: return
    //   161: astore_0
    //   162: goto -21 -> 141
    //   165: astore_0
    //   166: aload 4
    //   168: astore_0
    //   169: goto -23 -> 146
    //   172: astore_0
    //   173: goto -67 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	paramString1	String
    //   0	176	1	paramString2	String
    //   68	9	2	i	int
    //   47	100	3	localObject1	Object
    //   9	158	4	localObject2	Object
    //   12	109	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   87	95	96	java/io/IOException
    //   57	63	102	finally
    //   63	69	102	finally
    //   73	80	102	finally
    //   83	87	102	finally
    //   48	57	111	finally
    //   14	48	117	finally
    //   123	131	134	java/io/IOException
    //   146	154	155	java/io/IOException
    //   14	48	161	java/lang/Throwable
    //   48	57	165	java/lang/Throwable
    //   57	63	172	java/lang/Throwable
    //   63	69	172	java/lang/Throwable
    //   73	80	172	java/lang/Throwable
    //   83	87	172	java/lang/Throwable
  }
  
  public static void c(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return;
    }
    paramString.delete();
  }
  
  /* Error */
  public static void c(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 328	com/amap/api/mapcore/util/ho:e	(Ljava/lang/String;)Z
    //   4: ifeq +167 -> 171
    //   7: aconst_null
    //   8: astore 5
    //   10: aconst_null
    //   11: astore 4
    //   13: new 180	java/io/File
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 225	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore_3
    //   22: new 180	java/io/File
    //   25: dup
    //   26: aload_1
    //   27: invokespecial 225	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: astore 6
    //   32: aload 6
    //   34: invokevirtual 331	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   37: invokestatic 306	com/amap/api/mapcore/util/ho:g	(Ljava/lang/String;)V
    //   40: new 231	java/io/FileInputStream
    //   43: dup
    //   44: aload_3
    //   45: invokespecial 332	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   48: astore_1
    //   49: aload_1
    //   50: bipush 32
    //   52: newarray <illegal type>
    //   54: invokevirtual 335	java/io/InputStream:read	([B)I
    //   57: pop
    //   58: new 264	java/io/FileOutputStream
    //   61: dup
    //   62: aload 6
    //   64: invokespecial 266	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   67: astore_3
    //   68: sipush 1024
    //   71: newarray <illegal type>
    //   73: astore 4
    //   75: aload_1
    //   76: aload 4
    //   78: invokevirtual 335	java/io/InputStream:read	([B)I
    //   81: istore_2
    //   82: iload_2
    //   83: ifle +14 -> 97
    //   86: aload_3
    //   87: aload 4
    //   89: iconst_0
    //   90: iload_2
    //   91: invokevirtual 338	java/io/OutputStream:write	([BII)V
    //   94: goto -19 -> 75
    //   97: aload_3
    //   98: invokevirtual 341	java/io/OutputStream:flush	()V
    //   101: aload_1
    //   102: invokevirtual 342	java/io/InputStream:close	()V
    //   105: aload_3
    //   106: invokevirtual 343	java/io/OutputStream:close	()V
    //   109: goto +62 -> 171
    //   112: astore_0
    //   113: goto +19 -> 132
    //   116: goto +39 -> 155
    //   119: astore_0
    //   120: aload 4
    //   122: astore_3
    //   123: goto +9 -> 132
    //   126: astore_0
    //   127: aconst_null
    //   128: astore_1
    //   129: aload 4
    //   131: astore_3
    //   132: aload_1
    //   133: invokevirtual 342	java/io/InputStream:close	()V
    //   136: aload_3
    //   137: invokevirtual 343	java/io/OutputStream:close	()V
    //   140: goto +8 -> 148
    //   143: astore_1
    //   144: aload_1
    //   145: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   148: aload_0
    //   149: athrow
    //   150: aconst_null
    //   151: astore_1
    //   152: aload 5
    //   154: astore_3
    //   155: aload_1
    //   156: invokevirtual 342	java/io/InputStream:close	()V
    //   159: aload_3
    //   160: invokevirtual 343	java/io/OutputStream:close	()V
    //   163: goto +8 -> 171
    //   166: astore_1
    //   167: aload_1
    //   168: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   171: aload_0
    //   172: invokestatic 290	com/amap/api/mapcore/util/ho:c	(Ljava/lang/String;)V
    //   175: return
    //   176: astore_1
    //   177: goto -27 -> 150
    //   180: astore_3
    //   181: aload 5
    //   183: astore_3
    //   184: goto -29 -> 155
    //   187: astore 4
    //   189: goto -73 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	paramString1	String
    //   0	192	1	paramString2	String
    //   81	10	2	i	int
    //   21	139	3	localObject1	Object
    //   180	1	3	localThrowable1	Throwable
    //   183	1	3	localObject2	Object
    //   11	119	4	arrayOfByte	byte[]
    //   187	1	4	localThrowable2	Throwable
    //   8	174	5	localObject3	Object
    //   30	33	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   68	75	112	finally
    //   75	82	112	finally
    //   86	94	112	finally
    //   97	101	112	finally
    //   49	68	119	finally
    //   13	49	126	finally
    //   132	140	143	java/io/IOException
    //   101	109	166	java/io/IOException
    //   155	163	166	java/io/IOException
    //   13	49	176	java/lang/Throwable
    //   49	68	180	java/lang/Throwable
    //   68	75	187	java/lang/Throwable
    //   75	82	187	java/lang/Throwable
    //   86	94	187	java/lang/Throwable
    //   97	101	187	java/lang/Throwable
  }
  
  private static boolean c(File paramFile)
  {
    return paramFile.exists();
  }
  
  public static void d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = new File(paramString);
    if ((!paramString.exists()) || (!paramString.isDirectory()))
    {
      if (!paramString.exists())
      {
        paramString.mkdirs();
        return;
      }
      if ((paramString.exists()) && (!paramString.isDirectory()))
      {
        paramString.delete();
        paramString.mkdirs();
      }
    }
  }
  
  public static boolean d(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      e(paramString2);
      return paramString1.equals(fs.a(paramString2));
    }
    return false;
  }
  
  public static boolean e(String paramString)
  {
    return c(new File(paramString));
  }
  
  private JSONArray f(String paramString)
  {
    String str1 = paramString;
    if (paramString == null) {
      str1 = "";
    }
    paramString = Thread.getAllStackTraces().keySet().iterator();
    JSONArray localJSONArray = new JSONArray();
    while (paramString.hasNext())
    {
      Thread localThread = (Thread)paramString.next();
      if ((localThread != null) && (!str1.equals(localThread.getName())))
      {
        int i = 0;
        while (i < 6)
        {
          String str2 = new String[] { "AMapPboRenderThread", "GLThread", "AMapGlRenderThread", "AMapThreadUtil", "GNaviMap", "main" }[i];
          String str3 = localThread.getName();
          int j;
          if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)) && ((str2.contains(str3)) || (str3.contains(str2)))) {
            j = 1;
          } else {
            j = 0;
          }
          if ((j != 0) && (a(localThread) != null)) {
            localJSONArray.put(a(localThread));
          }
          i += 1;
        }
      }
    }
    return localJSONArray;
  }
  
  private static void g(String paramString)
    throws IOException
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = new File(paramString);
    d(paramString.getParentFile().getAbsolutePath());
    b(paramString);
  }
  
  public final boolean a(Context paramContext, String paramString1, String paramString2, List<fv> paramList, boolean paramBoolean, fv paramfv)
  {
    if (paramString2 == null)
    {
      localObject1 = "";
    }
    else
    {
      localObject1 = Thread.getAllStackTraces().keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Thread)((Iterator)localObject1).next();
        if ((localObject2 != null) && (!TextUtils.isEmpty(((Thread)localObject2).getName())) && ((paramString2.contains(((Thread)localObject2).getName())) || (((Thread)localObject2).getName().contains(paramString2))))
        {
          localObject1 = ((Thread)localObject2).getStackTrace();
          if (localObject1 == null)
          {
            localObject1 = "";
            break label187;
          }
          localObject2 = new StringBuffer();
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            Object localObject3 = localObject1[i];
            ((StringBuffer)localObject2).append("at ");
            ((StringBuffer)localObject2).append(localObject3);
            ((StringBuffer)localObject2).append("<br />");
            i += 1;
          }
          localObject1 = ((StringBuffer)localObject2).toString();
          break label187;
        }
      }
      localObject1 = null;
    }
    label187:
    paramList = a((String)localObject1, paramList);
    if ((paramBoolean) && (paramList == null)) {
      return false;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append("<br />");
    ((StringBuilder)localObject2).append((String)localObject1);
    paramString1 = ((StringBuilder)localObject2).toString();
    Object localObject1 = f(paramString2);
    paramString2 = new JSONObject();
    try
    {
      paramString2.put("crashStack", paramString1);
      paramString2.put("backStacks", localObject1);
      paramString1 = paramString2.toString();
      if (TextUtils.isEmpty(paramString1)) {
        return false;
      }
      if ((!paramBoolean) && (paramList == null)) {}
      try
      {
        gk.b(paramContext, paramfv, paramString1, "NATIVE_APP_CRASH_CLS_NAME", "NATIVE_CRASH_MHD_NAME");
        return true;
      }
      catch (Throwable paramContext) {}
      gk.a(paramContext, paramList, paramString1, "NATIVE_CRASH_CLS_NAME", "NATIVE_CRASH_MHD_NAME");
      return true;
    }
    catch (Throwable paramString1)
    {
      for (;;) {}
    }
    return true;
  }
  
  static final class a
  {
    public static ho a = new ho();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\ho.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */