package android.support.v4.provider;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;

@RequiresApi(19)
class DocumentsContractApi19
{
  private static final int FLAG_VIRTUAL_DOCUMENT = 512;
  private static final String TAG = "DocumentFile";
  
  public static boolean canRead(Context paramContext, Uri paramUri)
  {
    if (paramContext.checkCallingOrSelfUriPermission(paramUri, 1) != 0) {
      return false;
    }
    return !TextUtils.isEmpty(getRawType(paramContext, paramUri));
  }
  
  public static boolean canWrite(Context paramContext, Uri paramUri)
  {
    if (paramContext.checkCallingOrSelfUriPermission(paramUri, 2) != 0) {
      return false;
    }
    String str = getRawType(paramContext, paramUri);
    int i = queryForInt(paramContext, paramUri, "flags", 0);
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    if ((i & 0x4) != 0) {
      return true;
    }
    if (("vnd.android.document/directory".equals(str)) && ((i & 0x8) != 0)) {
      return true;
    }
    return (!TextUtils.isEmpty(str)) && ((i & 0x2) != 0);
  }
  
  private static void closeQuietly(@Nullable AutoCloseable paramAutoCloseable)
  {
    if (paramAutoCloseable != null) {}
    try
    {
      paramAutoCloseable.close();
      return;
    }
    catch (RuntimeException paramAutoCloseable)
    {
      throw paramAutoCloseable;
      return;
    }
    catch (Exception paramAutoCloseable) {}
  }
  
  /* Error */
  public static boolean exists(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 70	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore 5
    //   6: iconst_0
    //   7: istore_3
    //   8: aconst_null
    //   9: astore 4
    //   11: aconst_null
    //   12: astore_0
    //   13: aload 5
    //   15: aload_1
    //   16: iconst_1
    //   17: anewarray 48	java/lang/String
    //   20: dup
    //   21: iconst_0
    //   22: ldc 72
    //   24: aastore
    //   25: aconst_null
    //   26: aconst_null
    //   27: aconst_null
    //   28: invokevirtual 78	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   31: astore_1
    //   32: aload_1
    //   33: invokeinterface 84 1 0
    //   38: istore_2
    //   39: iload_2
    //   40: ifle +5 -> 45
    //   43: iconst_1
    //   44: istore_3
    //   45: aload_1
    //   46: invokestatic 86	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   49: iload_3
    //   50: ireturn
    //   51: astore 4
    //   53: aload_1
    //   54: astore_0
    //   55: aload 4
    //   57: astore_1
    //   58: goto +69 -> 127
    //   61: astore 4
    //   63: goto +14 -> 77
    //   66: astore_1
    //   67: goto +60 -> 127
    //   70: astore_0
    //   71: aload 4
    //   73: astore_1
    //   74: aload_0
    //   75: astore 4
    //   77: aload_1
    //   78: astore_0
    //   79: new 88	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   86: astore 5
    //   88: aload_1
    //   89: astore_0
    //   90: aload 5
    //   92: ldc 91
    //   94: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload_1
    //   99: astore_0
    //   100: aload 5
    //   102: aload 4
    //   104: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload_1
    //   109: astore_0
    //   110: ldc 14
    //   112: aload 5
    //   114: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 108	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   120: pop
    //   121: aload_1
    //   122: invokestatic 86	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   125: iconst_0
    //   126: ireturn
    //   127: aload_0
    //   128: invokestatic 86	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   131: aload_1
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	paramContext	Context
    //   0	133	1	paramUri	Uri
    //   38	2	2	i	int
    //   7	43	3	bool	boolean
    //   9	1	4	localObject1	Object
    //   51	5	4	localObject2	Object
    //   61	11	4	localException	Exception
    //   75	28	4	localContext	Context
    //   4	109	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   32	39	51	finally
    //   32	39	61	java/lang/Exception
    //   13	32	66	finally
    //   79	88	66	finally
    //   90	98	66	finally
    //   100	108	66	finally
    //   110	121	66	finally
    //   13	32	70	java/lang/Exception
  }
  
  public static long getFlags(Context paramContext, Uri paramUri)
  {
    return queryForLong(paramContext, paramUri, "flags", 0L);
  }
  
  @Nullable
  public static String getName(Context paramContext, Uri paramUri)
  {
    return queryForString(paramContext, paramUri, "_display_name", null);
  }
  
  @Nullable
  private static String getRawType(Context paramContext, Uri paramUri)
  {
    return queryForString(paramContext, paramUri, "mime_type", null);
  }
  
  @Nullable
  public static String getType(Context paramContext, Uri paramUri)
  {
    paramContext = getRawType(paramContext, paramUri);
    if ("vnd.android.document/directory".equals(paramContext)) {
      return null;
    }
    return paramContext;
  }
  
  public static boolean isDirectory(Context paramContext, Uri paramUri)
  {
    return "vnd.android.document/directory".equals(getRawType(paramContext, paramUri));
  }
  
  public static boolean isFile(Context paramContext, Uri paramUri)
  {
    paramContext = getRawType(paramContext, paramUri);
    return (!"vnd.android.document/directory".equals(paramContext)) && (!TextUtils.isEmpty(paramContext));
  }
  
  public static boolean isVirtual(Context paramContext, Uri paramUri)
  {
    boolean bool2 = DocumentsContract.isDocumentUri(paramContext, paramUri);
    boolean bool1 = false;
    if (!bool2) {
      return false;
    }
    if ((getFlags(paramContext, paramUri) & 0x200) != 0L) {
      bool1 = true;
    }
    return bool1;
  }
  
  public static long lastModified(Context paramContext, Uri paramUri)
  {
    return queryForLong(paramContext, paramUri, "last_modified", 0L);
  }
  
  public static long length(Context paramContext, Uri paramUri)
  {
    return queryForLong(paramContext, paramUri, "_size", 0L);
  }
  
  private static int queryForInt(Context paramContext, Uri paramUri, String paramString, int paramInt)
  {
    return (int)queryForLong(paramContext, paramUri, paramString, paramInt);
  }
  
  /* Error */
  private static long queryForLong(Context paramContext, Uri paramUri, String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 70	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore_0
    //   11: aload 8
    //   13: aload_1
    //   14: iconst_1
    //   15: anewarray 48	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: aload_2
    //   21: aastore
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: invokevirtual 78	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   28: astore_1
    //   29: aload_1
    //   30: invokeinterface 147 1 0
    //   35: ifeq +29 -> 64
    //   38: aload_1
    //   39: iconst_0
    //   40: invokeinterface 151 2 0
    //   45: ifne +19 -> 64
    //   48: aload_1
    //   49: iconst_0
    //   50: invokeinterface 155 2 0
    //   55: lstore 5
    //   57: aload_1
    //   58: invokestatic 86	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   61: lload 5
    //   63: lreturn
    //   64: aload_1
    //   65: invokestatic 86	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   68: lload_3
    //   69: lreturn
    //   70: astore_2
    //   71: aload_1
    //   72: astore_0
    //   73: aload_2
    //   74: astore_1
    //   75: goto +64 -> 139
    //   78: astore_2
    //   79: goto +11 -> 90
    //   82: astore_1
    //   83: goto +56 -> 139
    //   86: astore_2
    //   87: aload 7
    //   89: astore_1
    //   90: aload_1
    //   91: astore_0
    //   92: new 88	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   99: astore 7
    //   101: aload_1
    //   102: astore_0
    //   103: aload 7
    //   105: ldc 91
    //   107: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload_1
    //   112: astore_0
    //   113: aload 7
    //   115: aload_2
    //   116: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload_1
    //   121: astore_0
    //   122: ldc 14
    //   124: aload 7
    //   126: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 108	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   132: pop
    //   133: aload_1
    //   134: invokestatic 86	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   137: lload_3
    //   138: lreturn
    //   139: aload_0
    //   140: invokestatic 86	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   143: aload_1
    //   144: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	paramContext	Context
    //   0	145	1	paramUri	Uri
    //   0	145	2	paramString	String
    //   0	145	3	paramLong	long
    //   55	7	5	l	long
    //   7	118	7	localStringBuilder	StringBuilder
    //   4	8	8	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   29	57	70	finally
    //   29	57	78	java/lang/Exception
    //   11	29	82	finally
    //   92	101	82	finally
    //   103	111	82	finally
    //   113	120	82	finally
    //   122	133	82	finally
    //   11	29	86	java/lang/Exception
  }
  
  /* Error */
  @Nullable
  private static String queryForString(Context paramContext, Uri paramUri, String paramString1, @Nullable String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 70	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_0
    //   11: aload 5
    //   13: aload_1
    //   14: iconst_1
    //   15: anewarray 48	java/lang/String
    //   18: dup
    //   19: iconst_0
    //   20: aload_2
    //   21: aastore
    //   22: aconst_null
    //   23: aconst_null
    //   24: aconst_null
    //   25: invokevirtual 78	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   28: astore_1
    //   29: aload_1
    //   30: invokeinterface 147 1 0
    //   35: ifeq +27 -> 62
    //   38: aload_1
    //   39: iconst_0
    //   40: invokeinterface 151 2 0
    //   45: ifne +17 -> 62
    //   48: aload_1
    //   49: iconst_0
    //   50: invokeinterface 159 2 0
    //   55: astore_0
    //   56: aload_1
    //   57: invokestatic 86	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   60: aload_0
    //   61: areturn
    //   62: aload_1
    //   63: invokestatic 86	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   66: aload_3
    //   67: areturn
    //   68: astore_2
    //   69: aload_1
    //   70: astore_0
    //   71: aload_2
    //   72: astore_1
    //   73: goto +64 -> 137
    //   76: astore_2
    //   77: goto +11 -> 88
    //   80: astore_1
    //   81: goto +56 -> 137
    //   84: astore_2
    //   85: aload 4
    //   87: astore_1
    //   88: aload_1
    //   89: astore_0
    //   90: new 88	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   97: astore 4
    //   99: aload_1
    //   100: astore_0
    //   101: aload 4
    //   103: ldc 91
    //   105: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload_1
    //   110: astore_0
    //   111: aload 4
    //   113: aload_2
    //   114: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload_1
    //   119: astore_0
    //   120: ldc 14
    //   122: aload 4
    //   124: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 108	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   130: pop
    //   131: aload_1
    //   132: invokestatic 86	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   135: aload_3
    //   136: areturn
    //   137: aload_0
    //   138: invokestatic 86	android/support/v4/provider/DocumentsContractApi19:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   141: aload_1
    //   142: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramContext	Context
    //   0	143	1	paramUri	Uri
    //   0	143	2	paramString1	String
    //   0	143	3	paramString2	String
    //   7	116	4	localStringBuilder	StringBuilder
    //   4	8	5	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   29	56	68	finally
    //   29	56	76	java/lang/Exception
    //   11	29	80	finally
    //   90	99	80	finally
    //   101	109	80	finally
    //   111	118	80	finally
    //   120	131	80	finally
    //   11	29	84	java/lang/Exception
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\provider\DocumentsContractApi19.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */