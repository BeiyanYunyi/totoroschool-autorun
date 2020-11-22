package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.smtt.sdk.TbsExtensionFunctionManager;
import java.io.File;

public class a
{
  public static int a(Context paramContext, File paramFile)
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 23) {
      bool = TbsExtensionFunctionManager.getInstance().canUseFunction(paramContext, "disable_get_apk_version_switch.txt") ^ true;
    } else {
      bool = false;
    }
    return a(paramContext, paramFile, bool);
  }
  
  public static int a(Context paramContext, File paramFile, boolean paramBoolean)
  {
    if (paramFile != null) {}
    for (;;)
    {
      try
      {
        if (!paramFile.exists()) {
          break label64;
        }
        if (((Build.VERSION.SDK_INT != 23) && (Build.VERSION.SDK_INT != 25)) || (!Build.MANUFACTURER.toLowerCase().contains("mi"))) {
          break label108;
        }
        i = 1;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      int i = b(paramFile);
      if (i > 0) {
        return i;
      }
      label64:
      label108:
      do
      {
        if ((paramFile != null) && (paramFile.exists())) {
          try
          {
            paramContext = paramContext.getPackageManager().getPackageArchiveInfo(paramFile.getAbsolutePath(), 1);
            if (paramContext != null)
            {
              i = paramContext.versionCode;
              return i;
            }
          }
          catch (Throwable paramContext)
          {
            paramContext.printStackTrace();
            return -1;
          }
        }
        return 0;
        i = 0;
        if (paramBoolean) {
          break;
        }
      } while (i == 0);
    }
  }
  
  /* Error */
  public static String a(File paramFile)
  {
    // Byte code:
    //   0: bipush 16
    //   2: newarray <illegal type>
    //   4: astore 6
    //   6: aload 6
    //   8: dup
    //   9: iconst_0
    //   10: ldc 88
    //   12: castore
    //   13: dup
    //   14: iconst_1
    //   15: ldc 89
    //   17: castore
    //   18: dup
    //   19: iconst_2
    //   20: ldc 90
    //   22: castore
    //   23: dup
    //   24: iconst_3
    //   25: ldc 91
    //   27: castore
    //   28: dup
    //   29: iconst_4
    //   30: ldc 92
    //   32: castore
    //   33: dup
    //   34: iconst_5
    //   35: ldc 93
    //   37: castore
    //   38: dup
    //   39: bipush 6
    //   41: ldc 94
    //   43: castore
    //   44: dup
    //   45: bipush 7
    //   47: ldc 95
    //   49: castore
    //   50: dup
    //   51: bipush 8
    //   53: ldc 96
    //   55: castore
    //   56: dup
    //   57: bipush 9
    //   59: ldc 97
    //   61: castore
    //   62: dup
    //   63: bipush 10
    //   65: ldc 98
    //   67: castore
    //   68: dup
    //   69: bipush 11
    //   71: ldc 99
    //   73: castore
    //   74: dup
    //   75: bipush 12
    //   77: ldc 100
    //   79: castore
    //   80: dup
    //   81: bipush 13
    //   83: ldc 101
    //   85: castore
    //   86: dup
    //   87: bipush 14
    //   89: ldc 102
    //   91: castore
    //   92: dup
    //   93: bipush 15
    //   95: ldc 103
    //   97: castore
    //   98: pop
    //   99: bipush 32
    //   101: newarray <illegal type>
    //   103: astore 7
    //   105: ldc 105
    //   107: invokestatic 110	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   110: astore 8
    //   112: new 112	java/io/FileInputStream
    //   115: dup
    //   116: aload_0
    //   117: invokespecial 116	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   120: astore 5
    //   122: aload 5
    //   124: astore_0
    //   125: sipush 8192
    //   128: newarray <illegal type>
    //   130: astore 9
    //   132: aload 5
    //   134: astore_0
    //   135: aload 5
    //   137: aload 9
    //   139: invokevirtual 120	java/io/FileInputStream:read	([B)I
    //   142: istore_1
    //   143: iconst_0
    //   144: istore_2
    //   145: iload_1
    //   146: iconst_m1
    //   147: if_icmpeq +18 -> 165
    //   150: aload 5
    //   152: astore_0
    //   153: aload 8
    //   155: aload 9
    //   157: iconst_0
    //   158: iload_1
    //   159: invokevirtual 124	java/security/MessageDigest:update	([BII)V
    //   162: goto -30 -> 132
    //   165: aload 5
    //   167: astore_0
    //   168: aload 8
    //   170: invokevirtual 128	java/security/MessageDigest:digest	()[B
    //   173: astore 8
    //   175: iconst_0
    //   176: istore_1
    //   177: goto +98 -> 275
    //   180: aload 5
    //   182: astore_0
    //   183: new 44	java/lang/String
    //   186: dup
    //   187: aload 7
    //   189: invokespecial 131	java/lang/String:<init>	([C)V
    //   192: astore 6
    //   194: aload 5
    //   196: invokevirtual 134	java/io/FileInputStream:close	()V
    //   199: aload 6
    //   201: areturn
    //   202: astore_0
    //   203: aload_0
    //   204: invokevirtual 135	java/io/IOException:printStackTrace	()V
    //   207: aload 6
    //   209: areturn
    //   210: astore 6
    //   212: goto +15 -> 227
    //   215: astore 5
    //   217: aconst_null
    //   218: astore_0
    //   219: goto +37 -> 256
    //   222: astore 6
    //   224: aconst_null
    //   225: astore 5
    //   227: aload 5
    //   229: astore_0
    //   230: aload 6
    //   232: invokevirtual 136	java/lang/Exception:printStackTrace	()V
    //   235: aload 5
    //   237: ifnull +15 -> 252
    //   240: aload 5
    //   242: invokevirtual 134	java/io/FileInputStream:close	()V
    //   245: aconst_null
    //   246: areturn
    //   247: astore_0
    //   248: aload_0
    //   249: invokevirtual 135	java/io/IOException:printStackTrace	()V
    //   252: aconst_null
    //   253: areturn
    //   254: astore 5
    //   256: aload_0
    //   257: ifnull +15 -> 272
    //   260: aload_0
    //   261: invokevirtual 134	java/io/FileInputStream:close	()V
    //   264: goto +8 -> 272
    //   267: astore_0
    //   268: aload_0
    //   269: invokevirtual 135	java/io/IOException:printStackTrace	()V
    //   272: aload 5
    //   274: athrow
    //   275: iload_2
    //   276: bipush 16
    //   278: if_icmpge -98 -> 180
    //   281: aload 8
    //   283: iload_2
    //   284: baload
    //   285: istore_3
    //   286: iload_1
    //   287: iconst_1
    //   288: iadd
    //   289: istore 4
    //   291: aload 7
    //   293: iload_1
    //   294: aload 6
    //   296: iload_3
    //   297: iconst_4
    //   298: iushr
    //   299: bipush 15
    //   301: iand
    //   302: caload
    //   303: castore
    //   304: iload 4
    //   306: iconst_1
    //   307: iadd
    //   308: istore_1
    //   309: aload 7
    //   311: iload 4
    //   313: aload 6
    //   315: iload_3
    //   316: bipush 15
    //   318: iand
    //   319: caload
    //   320: castore
    //   321: iload_2
    //   322: iconst_1
    //   323: iadd
    //   324: istore_2
    //   325: goto -50 -> 275
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	328	0	paramFile	File
    //   142	167	1	i	int
    //   144	181	2	j	int
    //   285	34	3	k	int
    //   289	23	4	m	int
    //   120	75	5	localFileInputStream	java.io.FileInputStream
    //   215	1	5	localObject1	Object
    //   225	16	5	localObject2	Object
    //   254	19	5	localObject3	Object
    //   4	204	6	localObject4	Object
    //   210	1	6	localException1	Exception
    //   222	92	6	localException2	Exception
    //   103	207	7	arrayOfChar	char[]
    //   110	172	8	localObject5	Object
    //   130	26	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   194	199	202	java/io/IOException
    //   125	132	210	java/lang/Exception
    //   135	143	210	java/lang/Exception
    //   153	162	210	java/lang/Exception
    //   168	175	210	java/lang/Exception
    //   183	194	210	java/lang/Exception
    //   105	122	215	finally
    //   105	122	222	java/lang/Exception
    //   240	245	247	java/io/IOException
    //   125	132	254	finally
    //   135	143	254	finally
    //   153	162	254	finally
    //   168	175	254	finally
    //   183	194	254	finally
    //   230	235	254	finally
    //   260	264	267	java/io/IOException
  }
  
  public static boolean a(Context paramContext, File paramFile, long paramLong, int paramInt)
  {
    if (paramFile != null)
    {
      if (!paramFile.exists()) {
        return false;
      }
      if ((paramLong > 0L) && (paramLong != paramFile.length())) {
        return false;
      }
    }
    try
    {
      if (paramInt != a(paramContext, paramFile)) {
        return false;
      }
      boolean bool = "3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(b.a(paramContext, paramFile));
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
    return false;
  }
  
  /* Error */
  public static int b(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aconst_null
    //   5: astore 6
    //   7: new 156	java/util/jar/JarFile
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 157	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   15: astore_0
    //   16: aload_3
    //   17: astore_2
    //   18: aload_0
    //   19: astore_3
    //   20: new 159	java/io/BufferedReader
    //   23: dup
    //   24: new 161	java/io/InputStreamReader
    //   27: dup
    //   28: aload_0
    //   29: aload_0
    //   30: ldc -93
    //   32: invokevirtual 167	java/util/jar/JarFile:getJarEntry	(Ljava/lang/String;)Ljava/util/jar/JarEntry;
    //   35: invokevirtual 171	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   38: invokespecial 174	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   41: invokespecial 177	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   44: astore 4
    //   46: aload 4
    //   48: invokevirtual 180	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   51: astore_2
    //   52: aload_2
    //   53: ifnull +50 -> 103
    //   56: aload_2
    //   57: ldc -74
    //   59: invokevirtual 54	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   62: ifeq -16 -> 46
    //   65: aload_2
    //   66: ldc -72
    //   68: invokevirtual 188	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   71: astore_2
    //   72: aload_2
    //   73: ifnull -27 -> 46
    //   76: aload_2
    //   77: arraylength
    //   78: iconst_2
    //   79: if_icmpne -33 -> 46
    //   82: aload_2
    //   83: iconst_1
    //   84: aaload
    //   85: invokevirtual 191	java/lang/String:trim	()Ljava/lang/String;
    //   88: invokestatic 197	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   91: istore_1
    //   92: aload 4
    //   94: invokevirtual 198	java/io/BufferedReader:close	()V
    //   97: aload_0
    //   98: invokevirtual 199	java/util/jar/JarFile:close	()V
    //   101: iload_1
    //   102: ireturn
    //   103: aload 4
    //   105: invokevirtual 198	java/io/BufferedReader:close	()V
    //   108: aload_0
    //   109: invokevirtual 199	java/util/jar/JarFile:close	()V
    //   112: goto +69 -> 181
    //   115: astore_3
    //   116: aload 4
    //   118: astore_2
    //   119: aload_3
    //   120: astore 4
    //   122: goto +65 -> 187
    //   125: astore 5
    //   127: goto +27 -> 154
    //   130: astore 5
    //   132: aload 6
    //   134: astore 4
    //   136: goto +18 -> 154
    //   139: astore 4
    //   141: aconst_null
    //   142: astore_0
    //   143: goto +44 -> 187
    //   146: astore 5
    //   148: aconst_null
    //   149: astore_0
    //   150: aload 6
    //   152: astore 4
    //   154: aload 4
    //   156: astore_2
    //   157: aload_0
    //   158: astore_3
    //   159: aload 5
    //   161: invokevirtual 136	java/lang/Exception:printStackTrace	()V
    //   164: aload 4
    //   166: ifnull +8 -> 174
    //   169: aload 4
    //   171: invokevirtual 198	java/io/BufferedReader:close	()V
    //   174: aload_0
    //   175: ifnull +6 -> 181
    //   178: goto -70 -> 108
    //   181: iconst_m1
    //   182: ireturn
    //   183: astore 4
    //   185: aload_3
    //   186: astore_0
    //   187: aload_2
    //   188: ifnull +7 -> 195
    //   191: aload_2
    //   192: invokevirtual 198	java/io/BufferedReader:close	()V
    //   195: aload_0
    //   196: ifnull +7 -> 203
    //   199: aload_0
    //   200: invokevirtual 199	java/util/jar/JarFile:close	()V
    //   203: aload 4
    //   205: athrow
    //   206: astore_0
    //   207: iload_1
    //   208: ireturn
    //   209: astore_0
    //   210: goto -29 -> 181
    //   213: astore_0
    //   214: goto -11 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	paramFile	File
    //   91	117	1	i	int
    //   3	189	2	localObject1	Object
    //   1	19	3	localFile1	File
    //   115	5	3	localObject2	Object
    //   158	28	3	localFile2	File
    //   44	91	4	localObject3	Object
    //   139	1	4	localObject4	Object
    //   152	18	4	localObject5	Object
    //   183	21	4	localObject6	Object
    //   125	1	5	localException1	Exception
    //   130	1	5	localException2	Exception
    //   146	14	5	localException3	Exception
    //   5	146	6	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   46	52	115	finally
    //   56	72	115	finally
    //   76	92	115	finally
    //   46	52	125	java/lang/Exception
    //   56	72	125	java/lang/Exception
    //   76	92	125	java/lang/Exception
    //   20	46	130	java/lang/Exception
    //   7	16	139	finally
    //   7	16	146	java/lang/Exception
    //   20	46	183	finally
    //   159	164	183	finally
    //   92	101	206	java/lang/Exception
    //   103	108	209	java/lang/Exception
    //   108	112	209	java/lang/Exception
    //   169	174	209	java/lang/Exception
    //   191	195	213	java/lang/Exception
    //   199	203	213	java/lang/Exception
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\utils\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */