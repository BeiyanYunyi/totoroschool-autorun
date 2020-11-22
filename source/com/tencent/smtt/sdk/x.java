package com.tencent.smtt.sdk;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.k;
import java.io.File;

public class x
{
  public static final String a = CookieManager.LOGTAG;
  static File b;
  
  public static File a(Context paramContext)
  {
    if ((b == null) && (paramContext != null)) {
      b = new File(paramContext.getDir("webview", 0), "Cookies");
    }
    if (b == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("/data/data/");
      localStringBuilder.append(paramContext.getPackageName());
      localStringBuilder.append(File.separator);
      localStringBuilder.append("app_webview");
      localStringBuilder.append(File.separator);
      localStringBuilder.append("Cookies");
      b = new File(localStringBuilder.toString());
    }
    return b;
  }
  
  private static String a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select * from ");
    ((StringBuilder)localObject).append(paramString);
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(((StringBuilder)localObject).toString(), null);
    int i = paramSQLiteDatabase.getCount();
    int j = paramSQLiteDatabase.getColumnCount();
    paramString = new StringBuilder();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("raws:");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append(",columns:");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append("\n");
    paramString.append(((StringBuilder)localObject).toString());
    if ((i > 0) && (paramSQLiteDatabase.moveToFirst())) {
      do
      {
        paramString.append("\n");
        i = 0;
        while (i < j)
        {
          try
          {
            localObject = paramSQLiteDatabase.getString(i);
            paramString.append((String)localObject);
            paramString.append(",");
          }
          catch (Exception localException)
          {
            for (;;) {}
          }
          i += 1;
        }
        paramString.append("\n");
      } while (paramSQLiteDatabase.moveToNext());
    } else {
      return paramString.toString();
    }
  }
  
  /* Error */
  public static java.util.ArrayList<String> a(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 109	java/util/ArrayList
    //   9: dup
    //   10: invokespecial 110	java/util/ArrayList:<init>	()V
    //   13: astore_3
    //   14: aload_0
    //   15: ldc 112
    //   17: aconst_null
    //   18: invokevirtual 73	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   21: astore_2
    //   22: aload_2
    //   23: invokeinterface 95 1 0
    //   28: ifeq +45 -> 73
    //   31: aload_2
    //   32: iconst_1
    //   33: invokeinterface 99 2 0
    //   38: astore 4
    //   40: aload_2
    //   41: iconst_4
    //   42: invokeinterface 99 2 0
    //   47: pop
    //   48: aload_3
    //   49: aload 4
    //   51: invokevirtual 116	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   54: pop
    //   55: aload_0
    //   56: aload 4
    //   58: invokestatic 118	com/tencent/smtt/sdk/x:a	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Ljava/lang/String;
    //   61: pop
    //   62: aload_2
    //   63: invokeinterface 104 1 0
    //   68: istore_1
    //   69: iload_1
    //   70: ifne -39 -> 31
    //   73: aload_2
    //   74: ifnull +9 -> 83
    //   77: aload_2
    //   78: invokeinterface 121 1 0
    //   83: aload_0
    //   84: ifnull +85 -> 169
    //   87: aload_0
    //   88: invokevirtual 124	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   91: ifeq +78 -> 169
    //   94: goto +71 -> 165
    //   97: astore_3
    //   98: aload_2
    //   99: astore 4
    //   101: goto +12 -> 113
    //   104: goto +40 -> 144
    //   107: astore_2
    //   108: aconst_null
    //   109: astore 4
    //   111: aload_2
    //   112: astore_3
    //   113: aload 4
    //   115: ifnull +10 -> 125
    //   118: aload 4
    //   120: invokeinterface 121 1 0
    //   125: aload_0
    //   126: ifnull +14 -> 140
    //   129: aload_0
    //   130: invokevirtual 124	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   133: ifeq +7 -> 140
    //   136: aload_0
    //   137: invokevirtual 125	android/database/sqlite/SQLiteDatabase:close	()V
    //   140: aload_3
    //   141: athrow
    //   142: aconst_null
    //   143: astore_2
    //   144: aload_2
    //   145: ifnull +9 -> 154
    //   148: aload_2
    //   149: invokeinterface 121 1 0
    //   154: aload_0
    //   155: ifnull +14 -> 169
    //   158: aload_0
    //   159: invokevirtual 124	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   162: ifeq +7 -> 169
    //   165: aload_0
    //   166: invokevirtual 125	android/database/sqlite/SQLiteDatabase:close	()V
    //   169: aload_3
    //   170: areturn
    //   171: astore_2
    //   172: goto -30 -> 142
    //   175: astore 4
    //   177: goto -73 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	paramSQLiteDatabase	SQLiteDatabase
    //   68	2	1	bool	boolean
    //   21	78	2	localCursor	Cursor
    //   107	5	2	localObject1	Object
    //   143	6	2	localObject2	Object
    //   171	1	2	localThrowable1	Throwable
    //   13	36	3	localArrayList	java.util.ArrayList
    //   97	1	3	localObject3	Object
    //   112	58	3	localObject4	Object
    //   38	81	4	localObject5	Object
    //   175	1	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   22	31	97	finally
    //   31	69	97	finally
    //   14	22	107	finally
    //   14	22	171	java/lang/Throwable
    //   22	31	175	java/lang/Throwable
    //   31	69	175	java/lang/Throwable
  }
  
  /* Error */
  public static void a(Context paramContext, CookieManager.a parama, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: getstatic 133	com/tencent/smtt/sdk/CookieManager$a:b	Lcom/tencent/smtt/sdk/CookieManager$a;
    //   9: if_acmpne +11 -> 20
    //   12: aload_2
    //   13: invokestatic 139	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   16: ifeq +4 -> 20
    //   19: return
    //   20: aload_2
    //   21: ldc 101
    //   23: invokevirtual 145	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   26: astore 13
    //   28: aload 13
    //   30: ifnull +588 -> 618
    //   33: aload 13
    //   35: arraylength
    //   36: iconst_1
    //   37: if_icmpge +4 -> 41
    //   40: return
    //   41: aload_0
    //   42: invokestatic 149	com/tencent/smtt/sdk/x:c	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   45: astore 11
    //   47: aload 11
    //   49: ifnonnull +4 -> 53
    //   52: return
    //   53: new 151	java/util/HashMap
    //   56: dup
    //   57: invokespecial 152	java/util/HashMap:<init>	()V
    //   60: astore 12
    //   62: aconst_null
    //   63: astore 10
    //   65: aconst_null
    //   66: astore_2
    //   67: aload 11
    //   69: ldc -102
    //   71: aconst_null
    //   72: invokevirtual 73	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   75: astore 9
    //   77: aload 9
    //   79: invokeinterface 79 1 0
    //   84: ifle +224 -> 308
    //   87: aload 9
    //   89: invokeinterface 95 1 0
    //   94: ifeq +214 -> 308
    //   97: aload 9
    //   99: aload 9
    //   101: ldc -100
    //   103: invokeinterface 160 2 0
    //   108: invokeinterface 99 2 0
    //   113: astore_2
    //   114: aload_1
    //   115: getstatic 133	com/tencent/smtt/sdk/CookieManager$a:b	Lcom/tencent/smtt/sdk/CookieManager$a;
    //   118: if_acmpne +43 -> 161
    //   121: aload 13
    //   123: arraylength
    //   124: istore 8
    //   126: iconst_0
    //   127: istore 7
    //   129: iconst_0
    //   130: istore 5
    //   132: iload 7
    //   134: istore 6
    //   136: iload 5
    //   138: iload 8
    //   140: if_icmpge +488 -> 628
    //   143: aload_2
    //   144: aload 13
    //   146: iload 5
    //   148: aaload
    //   149: invokevirtual 163	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   152: ifeq +467 -> 619
    //   155: iconst_1
    //   156: istore 6
    //   158: goto +470 -> 628
    //   161: new 39	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   168: astore 10
    //   170: aload 10
    //   172: aload 9
    //   174: aload 9
    //   176: ldc -91
    //   178: invokeinterface 160 2 0
    //   183: invokeinterface 99 2 0
    //   188: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload 10
    //   194: ldc -89
    //   196: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload 10
    //   202: aload 9
    //   204: aload 9
    //   206: ldc -87
    //   208: invokeinterface 160 2 0
    //   213: invokeinterface 99 2 0
    //   218: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload 10
    //   224: ldc -89
    //   226: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: pop
    //   230: aload 10
    //   232: aload 9
    //   234: aload 9
    //   236: ldc -85
    //   238: invokeinterface 160 2 0
    //   243: invokeinterface 175 2 0
    //   248: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload 10
    //   254: ldc -89
    //   256: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload 10
    //   262: aload 9
    //   264: aload 9
    //   266: ldc -79
    //   268: invokeinterface 160 2 0
    //   273: invokeinterface 175 2 0
    //   278: invokevirtual 87	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload 12
    //   284: aload_2
    //   285: aload 10
    //   287: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokevirtual 181	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   293: pop
    //   294: aload 9
    //   296: invokeinterface 104 1 0
    //   301: istore 4
    //   303: iload 4
    //   305: ifne -208 -> 97
    //   308: aload 9
    //   310: ifnull +10 -> 320
    //   313: aload 9
    //   315: invokeinterface 121 1 0
    //   320: aload 11
    //   322: ifnull +125 -> 447
    //   325: aload 11
    //   327: invokevirtual 124	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   330: ifeq +117 -> 447
    //   333: aload 11
    //   335: invokevirtual 125	android/database/sqlite/SQLiteDatabase:close	()V
    //   338: goto +109 -> 447
    //   341: astore_0
    //   342: goto +244 -> 586
    //   345: astore_2
    //   346: aload 9
    //   348: astore_1
    //   349: aload_2
    //   350: astore 9
    //   352: goto +15 -> 367
    //   355: astore_0
    //   356: aload_2
    //   357: astore 9
    //   359: goto +227 -> 586
    //   362: astore 9
    //   364: aload 10
    //   366: astore_1
    //   367: aload_1
    //   368: astore_2
    //   369: getstatic 17	com/tencent/smtt/sdk/x:a	Ljava/lang/String;
    //   372: astore 10
    //   374: aload_1
    //   375: astore_2
    //   376: new 39	java/lang/StringBuilder
    //   379: dup
    //   380: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   383: astore 13
    //   385: aload_1
    //   386: astore_2
    //   387: aload 13
    //   389: ldc -73
    //   391: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: pop
    //   395: aload_1
    //   396: astore_2
    //   397: aload 13
    //   399: aload 9
    //   401: invokevirtual 184	java/lang/Throwable:toString	()Ljava/lang/String;
    //   404: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: aload_1
    //   409: astore_2
    //   410: aload 10
    //   412: aload 13
    //   414: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokestatic 190	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   420: pop
    //   421: aload_1
    //   422: ifnull +9 -> 431
    //   425: aload_1
    //   426: invokeinterface 121 1 0
    //   431: aload 11
    //   433: ifnull +14 -> 447
    //   436: aload 11
    //   438: invokevirtual 124	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   441: ifeq +6 -> 447
    //   444: goto -111 -> 333
    //   447: aload 12
    //   449: invokevirtual 192	java/util/HashMap:isEmpty	()Z
    //   452: ifeq +4 -> 456
    //   455: return
    //   456: aload_0
    //   457: invokestatic 195	com/tencent/smtt/sdk/x:b	(Landroid/content/Context;)Z
    //   460: pop
    //   461: aload 12
    //   463: invokevirtual 199	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   466: invokeinterface 205 1 0
    //   471: astore_1
    //   472: aload_1
    //   473: invokeinterface 210 1 0
    //   478: ifeq +50 -> 528
    //   481: aload_1
    //   482: invokeinterface 214 1 0
    //   487: checkcast 216	java/util/Map$Entry
    //   490: astore 9
    //   492: aload 9
    //   494: invokeinterface 219 1 0
    //   499: checkcast 141	java/lang/String
    //   502: astore_2
    //   503: aload 9
    //   505: invokeinterface 222 1 0
    //   510: checkcast 141	java/lang/String
    //   513: astore 9
    //   515: invokestatic 226	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   518: aload_2
    //   519: aload 9
    //   521: iconst_1
    //   522: invokevirtual 230	com/tencent/smtt/sdk/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   525: goto -53 -> 472
    //   528: getstatic 236	android/os/Build$VERSION:SDK_INT	I
    //   531: bipush 21
    //   533: if_icmplt +12 -> 545
    //   536: invokestatic 226	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   539: invokevirtual 239	com/tencent/smtt/sdk/CookieManager:flush	()V
    //   542: goto +9 -> 551
    //   545: invokestatic 244	com/tencent/smtt/sdk/CookieSyncManager:getInstance	()Lcom/tencent/smtt/sdk/CookieSyncManager;
    //   548: invokevirtual 247	com/tencent/smtt/sdk/CookieSyncManager:sync	()V
    //   551: iload_3
    //   552: ifeq +33 -> 585
    //   555: aload_0
    //   556: invokestatic 149	com/tencent/smtt/sdk/x:c	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   559: invokestatic 249	com/tencent/smtt/sdk/x:a	(Landroid/database/sqlite/SQLiteDatabase;)Ljava/util/ArrayList;
    //   562: pop
    //   563: aload_0
    //   564: invokestatic 253	com/tencent/smtt/sdk/x:d	(Landroid/content/Context;)I
    //   567: istore 5
    //   569: iload 5
    //   571: iconst_m1
    //   572: if_icmpeq +13 -> 585
    //   575: invokestatic 226	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   578: pop
    //   579: aload_0
    //   580: iload 5
    //   582: invokestatic 257	com/tencent/smtt/sdk/CookieManager:setROMCookieDBVersion	(Landroid/content/Context;I)V
    //   585: return
    //   586: aload 9
    //   588: ifnull +10 -> 598
    //   591: aload 9
    //   593: invokeinterface 121 1 0
    //   598: aload 11
    //   600: ifnull +16 -> 616
    //   603: aload 11
    //   605: invokevirtual 124	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   608: ifeq +8 -> 616
    //   611: aload 11
    //   613: invokevirtual 125	android/database/sqlite/SQLiteDatabase:close	()V
    //   616: aload_0
    //   617: athrow
    //   618: return
    //   619: iload 5
    //   621: iconst_1
    //   622: iadd
    //   623: istore 5
    //   625: goto -493 -> 132
    //   628: iload 6
    //   630: ifne -469 -> 161
    //   633: goto -339 -> 294
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	636	0	paramContext	Context
    //   0	636	1	parama	CookieManager.a
    //   0	636	2	paramString	String
    //   0	636	3	paramBoolean1	boolean
    //   0	636	4	paramBoolean2	boolean
    //   130	494	5	i	int
    //   134	495	6	j	int
    //   127	6	7	k	int
    //   124	17	8	m	int
    //   75	283	9	localObject1	Object
    //   362	38	9	localThrowable	Throwable
    //   490	102	9	localObject2	Object
    //   63	348	10	localObject3	Object
    //   45	567	11	localSQLiteDatabase	SQLiteDatabase
    //   60	402	12	localHashMap	java.util.HashMap
    //   26	387	13	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   77	97	341	finally
    //   97	126	341	finally
    //   143	155	341	finally
    //   161	294	341	finally
    //   294	303	341	finally
    //   77	97	345	java/lang/Throwable
    //   97	126	345	java/lang/Throwable
    //   143	155	345	java/lang/Throwable
    //   161	294	345	java/lang/Throwable
    //   294	303	345	java/lang/Throwable
    //   67	77	355	finally
    //   369	374	355	finally
    //   376	385	355	finally
    //   387	395	355	finally
    //   397	408	355	finally
    //   410	421	355	finally
    //   67	77	362	java/lang/Throwable
  }
  
  public static boolean b(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    k.a(a(paramContext), false);
    return true;
  }
  
  public static SQLiteDatabase c(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    paramContext = a(paramContext);
    if (paramContext == null) {
      return null;
    }
    try
    {
      paramContext = SQLiteDatabase.openDatabase(paramContext.getAbsolutePath(), null, 0);
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
    paramContext = null;
    if (paramContext == null) {
      TbsLog.i(a, "dbPath is not exist!");
    }
    return paramContext;
  }
  
  /* Error */
  public static int d(Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 285	java/lang/System:currentTimeMillis	()J
    //   3: pop2
    //   4: iconst_0
    //   5: istore_3
    //   6: iconst_0
    //   7: istore 4
    //   9: iconst_0
    //   10: istore_2
    //   11: aload_0
    //   12: invokestatic 149	com/tencent/smtt/sdk/x:c	(Landroid/content/Context;)Landroid/database/sqlite/SQLiteDatabase;
    //   15: astore_0
    //   16: aload_0
    //   17: ifnonnull +20 -> 37
    //   20: aload_0
    //   21: ifnull +14 -> 35
    //   24: aload_0
    //   25: invokevirtual 124	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   28: ifeq +7 -> 35
    //   31: aload_0
    //   32: invokevirtual 125	android/database/sqlite/SQLiteDatabase:close	()V
    //   35: iconst_m1
    //   36: ireturn
    //   37: aload_0
    //   38: ldc_w 287
    //   41: aconst_null
    //   42: invokevirtual 73	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   45: astore 8
    //   47: aload 8
    //   49: invokeinterface 79 1 0
    //   54: istore 5
    //   56: aload 8
    //   58: invokeinterface 82 1 0
    //   63: pop
    //   64: iload_2
    //   65: istore_1
    //   66: iload 5
    //   68: ifle +63 -> 131
    //   71: iload_2
    //   72: istore_1
    //   73: aload 8
    //   75: invokeinterface 95 1 0
    //   80: ifeq +51 -> 131
    //   83: aload 8
    //   85: iconst_0
    //   86: invokeinterface 99 2 0
    //   91: ldc_w 289
    //   94: invokevirtual 163	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   97: ifeq +18 -> 115
    //   100: aload 8
    //   102: iconst_1
    //   103: invokeinterface 99 2 0
    //   108: invokestatic 294	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   111: istore_1
    //   112: goto +19 -> 131
    //   115: aload 8
    //   117: invokeinterface 104 1 0
    //   122: istore 6
    //   124: iload 6
    //   126: ifne -43 -> 83
    //   129: iload_2
    //   130: istore_1
    //   131: aload 8
    //   133: ifnull +10 -> 143
    //   136: aload 8
    //   138: invokeinterface 121 1 0
    //   143: iload_1
    //   144: istore_2
    //   145: aload_0
    //   146: ifnull +120 -> 266
    //   149: iload_1
    //   150: istore_2
    //   151: aload_0
    //   152: invokevirtual 124	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   155: ifeq +111 -> 266
    //   158: aload_0
    //   159: invokevirtual 125	android/database/sqlite/SQLiteDatabase:close	()V
    //   162: iload_1
    //   163: ireturn
    //   164: astore 7
    //   166: goto +31 -> 197
    //   169: aload 8
    //   171: astore 7
    //   173: goto +59 -> 232
    //   176: astore 7
    //   178: aconst_null
    //   179: astore 8
    //   181: goto +16 -> 197
    //   184: aconst_null
    //   185: astore 7
    //   187: goto +45 -> 232
    //   190: astore 7
    //   192: aconst_null
    //   193: astore_0
    //   194: aload_0
    //   195: astore 8
    //   197: aload 8
    //   199: ifnull +10 -> 209
    //   202: aload 8
    //   204: invokeinterface 121 1 0
    //   209: aload_0
    //   210: ifnull +14 -> 224
    //   213: aload_0
    //   214: invokevirtual 124	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   217: ifeq +7 -> 224
    //   220: aload_0
    //   221: invokevirtual 125	android/database/sqlite/SQLiteDatabase:close	()V
    //   224: aload 7
    //   226: athrow
    //   227: aconst_null
    //   228: astore_0
    //   229: aload_0
    //   230: astore 7
    //   232: aload 7
    //   234: ifnull +10 -> 244
    //   237: aload 7
    //   239: invokeinterface 121 1 0
    //   244: iload 4
    //   246: istore_2
    //   247: aload_0
    //   248: ifnull +18 -> 266
    //   251: iload 4
    //   253: istore_2
    //   254: aload_0
    //   255: invokevirtual 124	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   258: ifeq +8 -> 266
    //   261: iload_3
    //   262: istore_1
    //   263: goto -105 -> 158
    //   266: iload_2
    //   267: ireturn
    //   268: astore_0
    //   269: goto -42 -> 227
    //   272: astore 7
    //   274: goto -90 -> 184
    //   277: astore 7
    //   279: goto -110 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	paramContext	Context
    //   65	198	1	i	int
    //   10	257	2	j	int
    //   5	257	3	k	int
    //   7	245	4	m	int
    //   54	13	5	n	int
    //   122	3	6	bool	boolean
    //   164	1	7	localObject1	Object
    //   171	1	7	localObject2	Object
    //   176	1	7	localObject3	Object
    //   185	1	7	localObject4	Object
    //   190	35	7	localObject5	Object
    //   230	8	7	localContext	Context
    //   272	1	7	localThrowable1	Throwable
    //   277	1	7	localThrowable2	Throwable
    //   45	158	8	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   47	64	164	finally
    //   73	83	164	finally
    //   83	112	164	finally
    //   115	124	164	finally
    //   37	47	176	finally
    //   11	16	190	finally
    //   11	16	268	java/lang/Throwable
    //   37	47	272	java/lang/Throwable
    //   47	64	277	java/lang/Throwable
    //   73	83	277	java/lang/Throwable
    //   83	112	277	java/lang/Throwable
    //   115	124	277	java/lang/Throwable
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */