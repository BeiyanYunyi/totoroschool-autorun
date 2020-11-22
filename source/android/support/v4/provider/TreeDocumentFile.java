package android.support.v4.provider;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;

@RequiresApi(21)
class TreeDocumentFile
  extends DocumentFile
{
  private Context mContext;
  private Uri mUri;
  
  TreeDocumentFile(@Nullable DocumentFile paramDocumentFile, Context paramContext, Uri paramUri)
  {
    super(paramDocumentFile);
    this.mContext = paramContext;
    this.mUri = paramUri;
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
  
  @Nullable
  private static Uri createFile(Context paramContext, Uri paramUri, String paramString1, String paramString2)
  {
    try
    {
      paramContext = DocumentsContract.createDocument(paramContext.getContentResolver(), paramUri, paramString1, paramString2);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
    return null;
  }
  
  public boolean canRead()
  {
    return DocumentsContractApi19.canRead(this.mContext, this.mUri);
  }
  
  public boolean canWrite()
  {
    return DocumentsContractApi19.canWrite(this.mContext, this.mUri);
  }
  
  @Nullable
  public DocumentFile createDirectory(String paramString)
  {
    paramString = createFile(this.mContext, this.mUri, "vnd.android.document/directory", paramString);
    if (paramString != null) {
      return new TreeDocumentFile(this, this.mContext, paramString);
    }
    return null;
  }
  
  @Nullable
  public DocumentFile createFile(String paramString1, String paramString2)
  {
    paramString1 = createFile(this.mContext, this.mUri, paramString1, paramString2);
    if (paramString1 != null) {
      return new TreeDocumentFile(this, this.mContext, paramString1);
    }
    return null;
  }
  
  public boolean delete()
  {
    try
    {
      boolean bool = DocumentsContract.deleteDocument(this.mContext.getContentResolver(), this.mUri);
      return bool;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    return false;
  }
  
  public boolean exists()
  {
    return DocumentsContractApi19.exists(this.mContext, this.mUri);
  }
  
  @Nullable
  public String getName()
  {
    return DocumentsContractApi19.getName(this.mContext, this.mUri);
  }
  
  @Nullable
  public String getType()
  {
    return DocumentsContractApi19.getType(this.mContext, this.mUri);
  }
  
  public Uri getUri()
  {
    return this.mUri;
  }
  
  public boolean isDirectory()
  {
    return DocumentsContractApi19.isDirectory(this.mContext, this.mUri);
  }
  
  public boolean isFile()
  {
    return DocumentsContractApi19.isFile(this.mContext, this.mUri);
  }
  
  public boolean isVirtual()
  {
    return DocumentsContractApi19.isVirtual(this.mContext, this.mUri);
  }
  
  public long lastModified()
  {
    return DocumentsContractApi19.lastModified(this.mContext, this.mUri);
  }
  
  public long length()
  {
    return DocumentsContractApi19.length(this.mContext, this.mUri);
  }
  
  /* Error */
  public DocumentFile[] listFiles()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 19	android/support/v4/provider/TreeDocumentFile:mContext	Landroid/content/Context;
    //   4: invokevirtual 43	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   7: astore_3
    //   8: aload_0
    //   9: getfield 21	android/support/v4/provider/TreeDocumentFile:mUri	Landroid/net/Uri;
    //   12: aload_0
    //   13: getfield 21	android/support/v4/provider/TreeDocumentFile:mUri	Landroid/net/Uri;
    //   16: invokestatic 110	android/provider/DocumentsContract:getDocumentId	(Landroid/net/Uri;)Ljava/lang/String;
    //   19: invokestatic 114	android/provider/DocumentsContract:buildChildDocumentsUriUsingTree	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   22: astore 6
    //   24: new 116	java/util/ArrayList
    //   27: dup
    //   28: invokespecial 118	java/util/ArrayList:<init>	()V
    //   31: astore 5
    //   33: iconst_0
    //   34: istore_1
    //   35: aconst_null
    //   36: astore 4
    //   38: aconst_null
    //   39: astore_2
    //   40: aload_3
    //   41: aload 6
    //   43: iconst_1
    //   44: anewarray 120	java/lang/String
    //   47: dup
    //   48: iconst_0
    //   49: ldc 122
    //   51: aastore
    //   52: aconst_null
    //   53: aconst_null
    //   54: aconst_null
    //   55: invokevirtual 128	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   58: astore_3
    //   59: aload_3
    //   60: invokeinterface 133 1 0
    //   65: ifeq +28 -> 93
    //   68: aload_3
    //   69: iconst_0
    //   70: invokeinterface 137 2 0
    //   75: astore_2
    //   76: aload 5
    //   78: aload_0
    //   79: getfield 21	android/support/v4/provider/TreeDocumentFile:mUri	Landroid/net/Uri;
    //   82: aload_2
    //   83: invokestatic 140	android/provider/DocumentsContract:buildDocumentUriUsingTree	(Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
    //   86: invokevirtual 144	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   89: pop
    //   90: goto -31 -> 59
    //   93: aload_3
    //   94: invokestatic 146	android/support/v4/provider/TreeDocumentFile:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   97: goto +77 -> 174
    //   100: astore 4
    //   102: aload_3
    //   103: astore_2
    //   104: aload 4
    //   106: astore_3
    //   107: goto +123 -> 230
    //   110: astore 4
    //   112: goto +14 -> 126
    //   115: astore_3
    //   116: goto +114 -> 230
    //   119: astore_2
    //   120: aload 4
    //   122: astore_3
    //   123: aload_2
    //   124: astore 4
    //   126: aload_3
    //   127: astore_2
    //   128: new 148	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   135: astore 6
    //   137: aload_3
    //   138: astore_2
    //   139: aload 6
    //   141: ldc -105
    //   143: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload_3
    //   148: astore_2
    //   149: aload 6
    //   151: aload 4
    //   153: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_3
    //   158: astore_2
    //   159: ldc -96
    //   161: aload 6
    //   163: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 169	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   169: pop
    //   170: aload_3
    //   171: invokestatic 146	android/support/v4/provider/TreeDocumentFile:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   174: aload 5
    //   176: aload 5
    //   178: invokevirtual 173	java/util/ArrayList:size	()I
    //   181: anewarray 175	android/net/Uri
    //   184: invokevirtual 179	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   187: checkcast 181	[Landroid/net/Uri;
    //   190: astore_2
    //   191: aload_2
    //   192: arraylength
    //   193: anewarray 4	android/support/v4/provider/DocumentFile
    //   196: astore_3
    //   197: iload_1
    //   198: aload_2
    //   199: arraylength
    //   200: if_icmpge +28 -> 228
    //   203: aload_3
    //   204: iload_1
    //   205: new 2	android/support/v4/provider/TreeDocumentFile
    //   208: dup
    //   209: aload_0
    //   210: aload_0
    //   211: getfield 19	android/support/v4/provider/TreeDocumentFile:mContext	Landroid/content/Context;
    //   214: aload_2
    //   215: iload_1
    //   216: aaload
    //   217: invokespecial 68	android/support/v4/provider/TreeDocumentFile:<init>	(Landroid/support/v4/provider/DocumentFile;Landroid/content/Context;Landroid/net/Uri;)V
    //   220: aastore
    //   221: iload_1
    //   222: iconst_1
    //   223: iadd
    //   224: istore_1
    //   225: goto -28 -> 197
    //   228: aload_3
    //   229: areturn
    //   230: aload_2
    //   231: invokestatic 146	android/support/v4/provider/TreeDocumentFile:closeQuietly	(Ljava/lang/AutoCloseable;)V
    //   234: aload_3
    //   235: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	this	TreeDocumentFile
    //   34	191	1	i	int
    //   39	65	2	localObject1	Object
    //   119	5	2	localException1	Exception
    //   127	104	2	localObject2	Object
    //   7	100	3	localObject3	Object
    //   115	1	3	localObject4	Object
    //   122	113	3	localObject5	Object
    //   36	1	4	localObject6	Object
    //   100	5	4	localObject7	Object
    //   110	11	4	localException2	Exception
    //   124	28	4	localObject8	Object
    //   31	146	5	localArrayList	java.util.ArrayList
    //   22	140	6	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   59	90	100	finally
    //   59	90	110	java/lang/Exception
    //   40	59	115	finally
    //   128	137	115	finally
    //   139	147	115	finally
    //   149	157	115	finally
    //   159	170	115	finally
    //   40	59	119	java/lang/Exception
  }
  
  public boolean renameTo(String paramString)
  {
    try
    {
      paramString = DocumentsContract.renameDocument(this.mContext.getContentResolver(), this.mUri, paramString);
      if (paramString != null)
      {
        this.mUri = paramString;
        return true;
      }
      return false;
    }
    catch (Exception paramString) {}
    return false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\provider\TreeDocumentFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */