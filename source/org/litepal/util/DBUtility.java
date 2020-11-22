package org.litepal.util;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.sqlcipher.database.SQLiteDatabase;

public class DBUtility
{
  private static final String KEYWORDS_COLUMN_SUFFIX = "_lpcolumn";
  private static final String REG_COLLECTION = "\\s+(not\\s+)?(in)\\s*\\(";
  private static final String REG_FUZZY = "\\s+(not\\s+)?(like|between)\\s+";
  private static final String REG_OPERATOR = "\\s*(=|!=|<>|<|>)";
  private static final String SQLITE_KEYWORDS = ",abort,add,after,all,alter,and,as,asc,autoincrement,before,begin,between,by,cascade,check,collate,column,commit,conflict,constraint,create,cross,database,deferrable,deferred,delete,desc,distinct,drop,each,end,escape,except,exclusive,exists,foreign,from,glob,group,having,in,index,inner,insert,intersect,into,is,isnull,join,like,limit,match,natural,not,notnull,null,of,offset,on,or,order,outer,plan,pragma,primary,query,raise,references,regexp,reindex,release,rename,replace,restrict,right,rollback,row,savepoint,select,set,table,temp,temporary,then,to,transaction,trigger,union,unique,update,using,vacuum,values,view,virtual,when,where,";
  private static final String TAG = "DBUtility";
  
  public static String convertOrderByClauseToValidName(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.trim().toLowerCase(Locale.US);
      if (paramString.contains(","))
      {
        paramString = paramString.split(",");
        StringBuilder localStringBuilder = new StringBuilder();
        int k = paramString.length;
        int i = 0;
        for (int j = 0; i < k; j = 1)
        {
          String str = paramString[i];
          if (j != 0) {
            localStringBuilder.append(",");
          }
          localStringBuilder.append(convertOrderByItem(str));
          i += 1;
        }
        return localStringBuilder.toString();
      }
      return convertOrderByItem(paramString);
    }
    return null;
  }
  
  private static String convertOrderByItem(String paramString)
  {
    String str;
    if (paramString.endsWith("asc"))
    {
      str = paramString.replace("asc", "").trim();
      paramString = " asc";
    }
    else if (paramString.endsWith("desc"))
    {
      str = paramString.replace("desc", "").trim();
      paramString = " desc";
    }
    else
    {
      localObject = "";
      str = paramString;
      paramString = (String)localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(convertToValidColumnName(str));
    ((StringBuilder)localObject).append(paramString);
    return ((StringBuilder)localObject).toString();
  }
  
  public static String[] convertSelectClauseToValidNames(String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      String[] arrayOfString = new String[paramArrayOfString.length];
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        arrayOfString[i] = convertToValidColumnName(paramArrayOfString[i]);
        i += 1;
      }
      return arrayOfString;
    }
    return null;
  }
  
  public static String convertToValidColumnName(String paramString)
  {
    if (isFieldNameConflictWithSQLiteKeywords(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("_lpcolumn");
      return localStringBuilder.toString();
    }
    return paramString;
  }
  
  public static String convertWhereClauseToColumnName(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        Object localObject = new StringBuffer();
        Matcher localMatcher = Pattern.compile("(\\w+\\s*(=|!=|<>|<|>)|\\w+\\s+(not\\s+)?(like|between)\\s+|\\w+\\s+(not\\s+)?(in)\\s*\\()").matcher(paramString);
        while (localMatcher.find())
        {
          String str1 = localMatcher.group();
          String str2 = str1.replaceAll("(\\s*(=|!=|<>|<|>)|\\s+(not\\s+)?(like|between)\\s+|\\s+(not\\s+)?(in)\\s*\\()", "");
          str1 = str1.replace(str2, "");
          str2 = convertToValidColumnName(str2);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str2);
          localStringBuilder.append(str1);
          localMatcher.appendReplacement((StringBuffer)localObject, localStringBuilder.toString());
        }
        localMatcher.appendTail((StringBuffer)localObject);
        localObject = ((StringBuffer)localObject).toString();
        return (String)localObject;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return paramString;
  }
  
  /* Error */
  public static List<String> findAllTableNames(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: new 149	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 150	java/util/ArrayList:<init>	()V
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_3
    //   11: aconst_null
    //   12: astore_2
    //   13: aload_0
    //   14: ldc -104
    //   16: iconst_1
    //   17: anewarray 38	java/lang/String
    //   20: dup
    //   21: iconst_0
    //   22: ldc -102
    //   24: aastore
    //   25: invokevirtual 160	net/sqlcipher/database/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Lnet/sqlcipher/Cursor;
    //   28: astore_0
    //   29: aload_0
    //   30: invokeinterface 165 1 0
    //   35: ifeq +49 -> 84
    //   38: aload_0
    //   39: aload_0
    //   40: ldc -89
    //   42: invokeinterface 171 2 0
    //   47: invokeinterface 175 2 0
    //   52: astore_2
    //   53: aload 4
    //   55: aload_2
    //   56: invokeinterface 180 2 0
    //   61: ifne +12 -> 73
    //   64: aload 4
    //   66: aload_2
    //   67: invokeinterface 183 2 0
    //   72: pop
    //   73: aload_0
    //   74: invokeinterface 186 1 0
    //   79: istore_1
    //   80: iload_1
    //   81: ifne -43 -> 38
    //   84: aload_0
    //   85: ifnull +9 -> 94
    //   88: aload_0
    //   89: invokeinterface 189 1 0
    //   94: aload 4
    //   96: areturn
    //   97: astore_3
    //   98: aload_0
    //   99: astore_2
    //   100: aload_3
    //   101: astore_0
    //   102: goto +36 -> 138
    //   105: astore_3
    //   106: goto +12 -> 118
    //   109: astore_0
    //   110: goto +28 -> 138
    //   113: astore_2
    //   114: aload_3
    //   115: astore_0
    //   116: aload_2
    //   117: astore_3
    //   118: aload_0
    //   119: astore_2
    //   120: aload_3
    //   121: invokevirtual 145	java/lang/Exception:printStackTrace	()V
    //   124: aload_0
    //   125: astore_2
    //   126: new 191	org/litepal/exceptions/DatabaseGenerateException
    //   129: dup
    //   130: aload_3
    //   131: invokevirtual 194	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   134: invokespecial 197	org/litepal/exceptions/DatabaseGenerateException:<init>	(Ljava/lang/String;)V
    //   137: athrow
    //   138: aload_2
    //   139: ifnull +9 -> 148
    //   142: aload_2
    //   143: invokeinterface 189 1 0
    //   148: aload_0
    //   149: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	paramSQLiteDatabase	SQLiteDatabase
    //   79	2	1	bool	boolean
    //   12	88	2	localObject1	Object
    //   113	4	2	localException1	Exception
    //   119	24	2	localSQLiteDatabase	SQLiteDatabase
    //   10	1	3	localObject2	Object
    //   97	4	3	localObject3	Object
    //   105	10	3	localException2	Exception
    //   117	14	3	localObject4	Object
    //   7	88	4	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   29	38	97	finally
    //   38	73	97	finally
    //   73	80	97	finally
    //   29	38	105	java/lang/Exception
    //   38	73	105	java/lang/Exception
    //   73	80	105	java/lang/Exception
    //   13	29	109	finally
    //   120	124	109	finally
    //   126	138	109	finally
    //   13	29	113	java/lang/Exception
  }
  
  /* Error */
  public static org.litepal.tablemanager.model.TableModel findPragmaTableInfo(String paramString, SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokestatic 205	org/litepal/util/DBUtility:isTableExists	(Ljava/lang/String;Lnet/sqlcipher/database/SQLiteDatabase;)Z
    //   5: ifeq +316 -> 321
    //   8: aload_0
    //   9: aload_1
    //   10: invokestatic 209	org/litepal/util/DBUtility:findUniqueColumns	(Ljava/lang/String;Lnet/sqlcipher/database/SQLiteDatabase;)Ljava/util/List;
    //   13: astore 5
    //   15: new 211	org/litepal/tablemanager/model/TableModel
    //   18: dup
    //   19: invokespecial 212	org/litepal/tablemanager/model/TableModel:<init>	()V
    //   22: astore 7
    //   24: aload 7
    //   26: aload_0
    //   27: invokevirtual 215	org/litepal/tablemanager/model/TableModel:setTableName	(Ljava/lang/String;)V
    //   30: new 63	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   37: astore 6
    //   39: aload 6
    //   41: ldc -39
    //   43: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 6
    //   49: aload_0
    //   50: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 6
    //   56: ldc -37
    //   58: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload 6
    //   64: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: astore 8
    //   69: aconst_null
    //   70: astore 6
    //   72: aconst_null
    //   73: astore_0
    //   74: aload_1
    //   75: aload 8
    //   77: aconst_null
    //   78: invokevirtual 160	net/sqlcipher/database/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Lnet/sqlcipher/Cursor;
    //   81: astore_1
    //   82: aload_1
    //   83: invokeinterface 165 1 0
    //   88: ifeq +162 -> 250
    //   91: new 221	org/litepal/tablemanager/model/ColumnModel
    //   94: dup
    //   95: invokespecial 222	org/litepal/tablemanager/model/ColumnModel:<init>	()V
    //   98: astore 6
    //   100: aload_1
    //   101: aload_1
    //   102: ldc -32
    //   104: invokeinterface 171 2 0
    //   109: invokeinterface 175 2 0
    //   114: astore_0
    //   115: aload_1
    //   116: aload_1
    //   117: ldc -30
    //   119: invokeinterface 171 2 0
    //   124: invokeinterface 175 2 0
    //   129: astore 8
    //   131: aload_1
    //   132: aload_1
    //   133: ldc -28
    //   135: invokeinterface 171 2 0
    //   140: invokeinterface 232 2 0
    //   145: istore_2
    //   146: iconst_1
    //   147: istore_3
    //   148: iload_2
    //   149: iconst_1
    //   150: if_icmpeq +205 -> 355
    //   153: goto +3 -> 156
    //   156: aload 5
    //   158: aload_0
    //   159: invokeinterface 180 2 0
    //   164: istore 4
    //   166: aload_1
    //   167: aload_1
    //   168: ldc -22
    //   170: invokeinterface 171 2 0
    //   175: invokeinterface 175 2 0
    //   180: astore 9
    //   182: aload 6
    //   184: aload_0
    //   185: invokevirtual 237	org/litepal/tablemanager/model/ColumnModel:setColumnName	(Ljava/lang/String;)V
    //   188: aload 6
    //   190: aload 8
    //   192: invokevirtual 240	org/litepal/tablemanager/model/ColumnModel:setColumnType	(Ljava/lang/String;)V
    //   195: aload 6
    //   197: iload_3
    //   198: invokevirtual 244	org/litepal/tablemanager/model/ColumnModel:setNullable	(Z)V
    //   201: aload 6
    //   203: iload 4
    //   205: invokevirtual 247	org/litepal/tablemanager/model/ColumnModel:setUnique	(Z)V
    //   208: aload 9
    //   210: ifnull +150 -> 360
    //   213: aload 9
    //   215: ldc -7
    //   217: ldc 82
    //   219: invokevirtual 86	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   222: astore_0
    //   223: goto +3 -> 226
    //   226: aload 6
    //   228: aload_0
    //   229: invokevirtual 252	org/litepal/tablemanager/model/ColumnModel:setDefaultValue	(Ljava/lang/String;)V
    //   232: aload 7
    //   234: aload 6
    //   236: invokevirtual 256	org/litepal/tablemanager/model/TableModel:addColumnModel	(Lorg/litepal/tablemanager/model/ColumnModel;)V
    //   239: aload_1
    //   240: invokeinterface 186 1 0
    //   245: istore_3
    //   246: iload_3
    //   247: ifne -156 -> 91
    //   250: aload_1
    //   251: ifnull +9 -> 260
    //   254: aload_1
    //   255: invokeinterface 189 1 0
    //   260: aload 7
    //   262: areturn
    //   263: astore_0
    //   264: goto +45 -> 309
    //   267: astore 5
    //   269: goto +18 -> 287
    //   272: astore 5
    //   274: aload_0
    //   275: astore_1
    //   276: aload 5
    //   278: astore_0
    //   279: goto +30 -> 309
    //   282: astore 5
    //   284: aload 6
    //   286: astore_1
    //   287: aload_1
    //   288: astore_0
    //   289: aload 5
    //   291: invokevirtual 145	java/lang/Exception:printStackTrace	()V
    //   294: aload_1
    //   295: astore_0
    //   296: new 191	org/litepal/exceptions/DatabaseGenerateException
    //   299: dup
    //   300: aload 5
    //   302: invokevirtual 194	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   305: invokespecial 197	org/litepal/exceptions/DatabaseGenerateException:<init>	(Ljava/lang/String;)V
    //   308: athrow
    //   309: aload_1
    //   310: ifnull +9 -> 319
    //   313: aload_1
    //   314: invokeinterface 189 1 0
    //   319: aload_0
    //   320: athrow
    //   321: new 63	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   328: astore_1
    //   329: aload_1
    //   330: ldc_w 258
    //   333: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: aload_1
    //   338: aload_0
    //   339: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: new 191	org/litepal/exceptions/DatabaseGenerateException
    //   346: dup
    //   347: aload_1
    //   348: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokespecial 197	org/litepal/exceptions/DatabaseGenerateException:<init>	(Ljava/lang/String;)V
    //   354: athrow
    //   355: iconst_0
    //   356: istore_3
    //   357: goto -201 -> 156
    //   360: ldc 82
    //   362: astore_0
    //   363: goto -137 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	366	0	paramString	String
    //   0	366	1	paramSQLiteDatabase	SQLiteDatabase
    //   145	6	2	i	int
    //   147	210	3	bool1	boolean
    //   164	40	4	bool2	boolean
    //   13	144	5	localList	List
    //   267	1	5	localException1	Exception
    //   272	5	5	localObject1	Object
    //   282	19	5	localException2	Exception
    //   37	248	6	localObject2	Object
    //   22	239	7	localTableModel	org.litepal.tablemanager.model.TableModel
    //   67	124	8	str1	String
    //   180	34	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   82	91	263	finally
    //   91	146	263	finally
    //   156	208	263	finally
    //   213	223	263	finally
    //   226	246	263	finally
    //   82	91	267	java/lang/Exception
    //   91	146	267	java/lang/Exception
    //   156	208	267	java/lang/Exception
    //   213	223	267	java/lang/Exception
    //   226	246	267	java/lang/Exception
    //   74	82	272	finally
    //   289	294	272	finally
    //   296	309	272	finally
    //   74	82	282	java/lang/Exception
  }
  
  /* Error */
  public static List<String> findUniqueColumns(String paramString, SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: new 149	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 150	java/util/ArrayList:<init>	()V
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 5
    //   12: aconst_null
    //   13: astore_3
    //   14: new 63	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   21: astore 4
    //   23: aload 4
    //   25: ldc_w 260
    //   28: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload 4
    //   34: aload_0
    //   35: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload 4
    //   41: ldc -37
    //   43: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload_1
    //   48: aload 4
    //   50: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: aconst_null
    //   54: invokevirtual 160	net/sqlcipher/database/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Lnet/sqlcipher/Cursor;
    //   57: astore 4
    //   59: aload 4
    //   61: invokeinterface 165 1 0
    //   66: istore_2
    //   67: aload_3
    //   68: astore_0
    //   69: iload_2
    //   70: ifeq +213 -> 283
    //   73: aconst_null
    //   74: astore_3
    //   75: aload_3
    //   76: astore_0
    //   77: aload_3
    //   78: astore 5
    //   80: aload_3
    //   81: astore 6
    //   83: aload 4
    //   85: aload 4
    //   87: ldc_w 262
    //   90: invokeinterface 171 2 0
    //   95: invokeinterface 232 2 0
    //   100: iconst_1
    //   101: if_icmpne +145 -> 246
    //   104: aload_3
    //   105: astore 5
    //   107: aload_3
    //   108: astore 6
    //   110: aload 4
    //   112: aload 4
    //   114: ldc -32
    //   116: invokeinterface 171 2 0
    //   121: invokeinterface 175 2 0
    //   126: astore_0
    //   127: aload_3
    //   128: astore 5
    //   130: aload_3
    //   131: astore 6
    //   133: new 63	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   140: astore 8
    //   142: aload_3
    //   143: astore 5
    //   145: aload_3
    //   146: astore 6
    //   148: aload 8
    //   150: ldc_w 264
    //   153: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_3
    //   158: astore 5
    //   160: aload_3
    //   161: astore 6
    //   163: aload 8
    //   165: aload_0
    //   166: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload_3
    //   171: astore 5
    //   173: aload_3
    //   174: astore 6
    //   176: aload 8
    //   178: ldc -37
    //   180: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload_3
    //   185: astore 5
    //   187: aload_3
    //   188: astore 6
    //   190: aload_1
    //   191: aload 8
    //   193: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: aconst_null
    //   197: invokevirtual 160	net/sqlcipher/database/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Lnet/sqlcipher/Cursor;
    //   200: astore_0
    //   201: aload_0
    //   202: invokeinterface 165 1 0
    //   207: ifeq +25 -> 232
    //   210: aload 7
    //   212: aload_0
    //   213: aload_0
    //   214: ldc -32
    //   216: invokeinterface 171 2 0
    //   221: invokeinterface 175 2 0
    //   226: invokeinterface 183 2 0
    //   231: pop
    //   232: goto +14 -> 246
    //   235: astore_1
    //   236: goto +125 -> 361
    //   239: astore_3
    //   240: aload 4
    //   242: astore_1
    //   243: goto +96 -> 339
    //   246: aload_0
    //   247: astore 5
    //   249: aload_0
    //   250: astore 6
    //   252: aload 4
    //   254: invokeinterface 186 1 0
    //   259: istore_2
    //   260: aload_0
    //   261: astore_3
    //   262: iload_2
    //   263: ifne -188 -> 75
    //   266: goto +17 -> 283
    //   269: astore_1
    //   270: aload 5
    //   272: astore_0
    //   273: goto +88 -> 361
    //   276: astore_3
    //   277: aload 6
    //   279: astore_0
    //   280: goto +37 -> 317
    //   283: aload 4
    //   285: ifnull +10 -> 295
    //   288: aload 4
    //   290: invokeinterface 189 1 0
    //   295: aload_0
    //   296: ifnull +9 -> 305
    //   299: aload_0
    //   300: invokeinterface 189 1 0
    //   305: aload 7
    //   307: areturn
    //   308: astore_1
    //   309: aconst_null
    //   310: astore_0
    //   311: goto +50 -> 361
    //   314: astore_3
    //   315: aconst_null
    //   316: astore_0
    //   317: aload 4
    //   319: astore_1
    //   320: goto +19 -> 339
    //   323: astore_1
    //   324: aconst_null
    //   325: astore 4
    //   327: aload 4
    //   329: astore_0
    //   330: goto +31 -> 361
    //   333: astore_3
    //   334: aconst_null
    //   335: astore_0
    //   336: aload 5
    //   338: astore_1
    //   339: aload_3
    //   340: invokevirtual 145	java/lang/Exception:printStackTrace	()V
    //   343: new 191	org/litepal/exceptions/DatabaseGenerateException
    //   346: dup
    //   347: aload_3
    //   348: invokevirtual 194	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   351: invokespecial 197	org/litepal/exceptions/DatabaseGenerateException:<init>	(Ljava/lang/String;)V
    //   354: athrow
    //   355: astore_3
    //   356: aload_1
    //   357: astore 4
    //   359: aload_3
    //   360: astore_1
    //   361: aload 4
    //   363: ifnull +10 -> 373
    //   366: aload 4
    //   368: invokeinterface 189 1 0
    //   373: aload_0
    //   374: ifnull +9 -> 383
    //   377: aload_0
    //   378: invokeinterface 189 1 0
    //   383: aload_1
    //   384: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	385	0	paramString	String
    //   0	385	1	paramSQLiteDatabase	SQLiteDatabase
    //   66	197	2	bool	boolean
    //   13	175	3	localObject1	Object
    //   239	1	3	localException1	Exception
    //   261	1	3	str	String
    //   276	1	3	localException2	Exception
    //   314	1	3	localException3	Exception
    //   333	15	3	localException4	Exception
    //   355	5	3	localObject2	Object
    //   21	346	4	localObject3	Object
    //   10	327	5	localObject4	Object
    //   81	197	6	localObject5	Object
    //   7	299	7	localArrayList	ArrayList
    //   140	52	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   201	232	235	finally
    //   201	232	239	java/lang/Exception
    //   83	104	269	finally
    //   110	127	269	finally
    //   133	142	269	finally
    //   148	157	269	finally
    //   163	170	269	finally
    //   176	184	269	finally
    //   190	201	269	finally
    //   252	260	269	finally
    //   83	104	276	java/lang/Exception
    //   110	127	276	java/lang/Exception
    //   133	142	276	java/lang/Exception
    //   148	157	276	java/lang/Exception
    //   163	170	276	java/lang/Exception
    //   176	184	276	java/lang/Exception
    //   190	201	276	java/lang/Exception
    //   252	260	276	java/lang/Exception
    //   59	67	308	finally
    //   59	67	314	java/lang/Exception
    //   14	59	323	finally
    //   14	59	333	java/lang/Exception
    //   339	355	355	finally
  }
  
  public static String getGenericTableName(String paramString1, String paramString2)
  {
    paramString1 = getTableNameByClassName(paramString1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    return BaseUtility.changeCase(localStringBuilder.toString());
  }
  
  public static String getGenericValueIdColumnName(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getTableNameByClassName(paramString));
    localStringBuilder.append("_id");
    return BaseUtility.changeCase(localStringBuilder.toString());
  }
  
  public static String getIntermediateTableName(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (paramString1.toLowerCase(Locale.US).compareTo(paramString2.toLowerCase(Locale.US)) <= 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append("_");
        localStringBuilder.append(paramString2);
        return localStringBuilder.toString();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString1);
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static String getM2MSelfRefColumnName(Field paramField)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramField.getName());
    localStringBuilder.append("_id");
    return BaseUtility.changeCase(localStringBuilder.toString());
  }
  
  public static String getTableNameByClassName(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if ('.' == paramString.charAt(paramString.length() - 1)) {
        return null;
      }
      return paramString.substring(paramString.lastIndexOf(".") + 1);
    }
    return null;
  }
  
  public static String getTableNameByForeignColumn(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.toLowerCase(Locale.US).endsWith("_id")) {
        return paramString.substring(0, paramString.length() - "_id".length());
      }
      return null;
    }
    return null;
  }
  
  public static List<String> getTableNameListByClassNameList(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(getTableNameByClassName((String)paramList.next()));
      }
    }
    return localArrayList;
  }
  
  /* Error */
  public static boolean isColumnExists(String paramString1, String paramString2, SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore_3
    //   5: iconst_0
    //   6: istore 5
    //   8: iconst_0
    //   9: istore 4
    //   11: iload_3
    //   12: ifne +213 -> 225
    //   15: aload_1
    //   16: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifeq +5 -> 24
    //   22: iconst_0
    //   23: ireturn
    //   24: aconst_null
    //   25: astore 7
    //   27: aconst_null
    //   28: astore 8
    //   30: aload 8
    //   32: astore 6
    //   34: new 63	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   41: astore 9
    //   43: aload 8
    //   45: astore 6
    //   47: aload 9
    //   49: ldc -39
    //   51: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 8
    //   57: astore 6
    //   59: aload 9
    //   61: aload_1
    //   62: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload 8
    //   68: astore 6
    //   70: aload 9
    //   72: ldc -37
    //   74: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload 8
    //   80: astore 6
    //   82: aload_2
    //   83: aload 9
    //   85: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: aconst_null
    //   89: invokevirtual 160	net/sqlcipher/database/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Lnet/sqlcipher/Cursor;
    //   92: astore_1
    //   93: iload 4
    //   95: istore_3
    //   96: aload_1
    //   97: invokeinterface 165 1 0
    //   102: ifeq +43 -> 145
    //   105: aload_0
    //   106: aload_1
    //   107: aload_1
    //   108: ldc -32
    //   110: invokeinterface 171 2 0
    //   115: invokeinterface 175 2 0
    //   120: invokevirtual 333	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   123: ifeq +8 -> 131
    //   126: iconst_1
    //   127: istore_3
    //   128: goto +17 -> 145
    //   131: aload_1
    //   132: invokeinterface 186 1 0
    //   137: istore_3
    //   138: iload_3
    //   139: ifne -34 -> 105
    //   142: iload 4
    //   144: istore_3
    //   145: iload_3
    //   146: istore 4
    //   148: aload_1
    //   149: ifnull +59 -> 208
    //   152: aload_1
    //   153: invokeinterface 189 1 0
    //   158: iload_3
    //   159: ireturn
    //   160: astore_0
    //   161: aload_1
    //   162: astore 6
    //   164: goto +47 -> 211
    //   167: astore_2
    //   168: aload_1
    //   169: astore_0
    //   170: aload_2
    //   171: astore_1
    //   172: goto +11 -> 183
    //   175: astore_0
    //   176: goto +35 -> 211
    //   179: astore_1
    //   180: aload 7
    //   182: astore_0
    //   183: aload_0
    //   184: astore 6
    //   186: aload_1
    //   187: invokevirtual 145	java/lang/Exception:printStackTrace	()V
    //   190: iload 5
    //   192: istore 4
    //   194: aload_0
    //   195: ifnull +13 -> 208
    //   198: aload_0
    //   199: invokeinterface 189 1 0
    //   204: iload 5
    //   206: istore 4
    //   208: iload 4
    //   210: ireturn
    //   211: aload 6
    //   213: ifnull +10 -> 223
    //   216: aload 6
    //   218: invokeinterface 189 1 0
    //   223: aload_0
    //   224: athrow
    //   225: iconst_0
    //   226: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	paramString1	String
    //   0	227	1	paramString2	String
    //   0	227	2	paramSQLiteDatabase	SQLiteDatabase
    //   4	155	3	bool1	boolean
    //   9	200	4	bool2	boolean
    //   6	199	5	bool3	boolean
    //   32	185	6	localObject1	Object
    //   25	156	7	localObject2	Object
    //   28	51	8	localObject3	Object
    //   41	43	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   96	105	160	finally
    //   105	126	160	finally
    //   131	138	160	finally
    //   96	105	167	java/lang/Exception
    //   105	126	167	java/lang/Exception
    //   131	138	167	java/lang/Exception
    //   34	43	175	finally
    //   47	55	175	finally
    //   59	66	175	finally
    //   70	78	175	finally
    //   82	93	175	finally
    //   186	190	175	finally
    //   34	43	179	java/lang/Exception
    //   47	55	179	java/lang/Exception
    //   59	66	179	java/lang/Exception
    //   70	78	179	java/lang/Exception
    //   82	93	179	java/lang/Exception
  }
  
  public static boolean isFieldNameConflictWithSQLiteKeywords(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(",");
      localStringBuilder.append(paramString.toLowerCase(Locale.US));
      localStringBuilder.append(",");
      if (",abort,add,after,all,alter,and,as,asc,autoincrement,before,begin,between,by,cascade,check,collate,column,commit,conflict,constraint,create,cross,database,deferrable,deferred,delete,desc,distinct,drop,each,end,escape,except,exclusive,exists,foreign,from,glob,group,having,in,index,inner,insert,intersect,into,is,isnull,join,like,limit,match,natural,not,notnull,null,of,offset,on,or,order,outer,plan,pragma,primary,query,raise,references,regexp,reindex,release,rename,replace,restrict,right,rollback,row,savepoint,select,set,table,temp,temporary,then,to,transaction,trigger,union,unique,update,using,vacuum,values,view,virtual,when,where,".contains(localStringBuilder.toString())) {
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  public static boolean isGenericTable(String paramString, SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +176 -> 180
    //   7: aload_0
    //   8: ldc_w 336
    //   11: invokevirtual 339	java/lang/String:matches	(Ljava/lang/String;)Z
    //   14: ifeq +166 -> 180
    //   17: aconst_null
    //   18: astore 5
    //   20: aconst_null
    //   21: astore 4
    //   23: aload_1
    //   24: ldc_w 341
    //   27: aconst_null
    //   28: aconst_null
    //   29: aconst_null
    //   30: aconst_null
    //   31: aconst_null
    //   32: aconst_null
    //   33: invokevirtual 345	net/sqlcipher/database/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lnet/sqlcipher/Cursor;
    //   36: astore_1
    //   37: aload_1
    //   38: invokeinterface 165 1 0
    //   43: ifeq +67 -> 110
    //   46: aload_0
    //   47: aload_1
    //   48: aload_1
    //   49: ldc -32
    //   51: invokeinterface 171 2 0
    //   56: invokeinterface 175 2 0
    //   61: invokevirtual 333	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   64: ifeq +35 -> 99
    //   67: aload_1
    //   68: aload_1
    //   69: ldc -30
    //   71: invokeinterface 171 2 0
    //   76: invokeinterface 232 2 0
    //   81: istore_2
    //   82: iload_2
    //   83: iconst_2
    //   84: if_icmpne +26 -> 110
    //   87: aload_1
    //   88: ifnull +9 -> 97
    //   91: aload_1
    //   92: invokeinterface 189 1 0
    //   97: iconst_1
    //   98: ireturn
    //   99: aload_1
    //   100: invokeinterface 186 1 0
    //   105: istore_3
    //   106: iload_3
    //   107: ifne -61 -> 46
    //   110: aload_1
    //   111: ifnull +69 -> 180
    //   114: aload_1
    //   115: invokeinterface 189 1 0
    //   120: goto +60 -> 180
    //   123: astore_0
    //   124: goto +44 -> 168
    //   127: astore 4
    //   129: aload_1
    //   130: astore_0
    //   131: aload 4
    //   133: astore_1
    //   134: goto +14 -> 148
    //   137: astore_0
    //   138: aload 4
    //   140: astore_1
    //   141: goto +27 -> 168
    //   144: astore_1
    //   145: aload 5
    //   147: astore_0
    //   148: aload_0
    //   149: astore 4
    //   151: aload_1
    //   152: invokevirtual 145	java/lang/Exception:printStackTrace	()V
    //   155: aload_0
    //   156: ifnull +24 -> 180
    //   159: aload_0
    //   160: invokeinterface 189 1 0
    //   165: goto +15 -> 180
    //   168: aload_1
    //   169: ifnull +9 -> 178
    //   172: aload_1
    //   173: invokeinterface 189 1 0
    //   178: aload_0
    //   179: athrow
    //   180: iconst_0
    //   181: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	paramString	String
    //   0	182	1	paramSQLiteDatabase	SQLiteDatabase
    //   81	4	2	i	int
    //   105	2	3	bool	boolean
    //   21	1	4	localObject1	Object
    //   127	12	4	localException	Exception
    //   149	1	4	str	String
    //   18	128	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   37	46	123	finally
    //   46	82	123	finally
    //   99	106	123	finally
    //   37	46	127	java/lang/Exception
    //   46	82	127	java/lang/Exception
    //   99	106	127	java/lang/Exception
    //   23	37	137	finally
    //   151	155	137	finally
    //   23	37	144	java/lang/Exception
  }
  
  /* Error */
  public static boolean isIntermediateTable(String paramString, SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 36	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +176 -> 180
    //   7: aload_0
    //   8: ldc_w 336
    //   11: invokevirtual 339	java/lang/String:matches	(Ljava/lang/String;)Z
    //   14: ifeq +166 -> 180
    //   17: aconst_null
    //   18: astore 5
    //   20: aconst_null
    //   21: astore 4
    //   23: aload_1
    //   24: ldc_w 341
    //   27: aconst_null
    //   28: aconst_null
    //   29: aconst_null
    //   30: aconst_null
    //   31: aconst_null
    //   32: aconst_null
    //   33: invokevirtual 345	net/sqlcipher/database/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lnet/sqlcipher/Cursor;
    //   36: astore_1
    //   37: aload_1
    //   38: invokeinterface 165 1 0
    //   43: ifeq +67 -> 110
    //   46: aload_0
    //   47: aload_1
    //   48: aload_1
    //   49: ldc -32
    //   51: invokeinterface 171 2 0
    //   56: invokeinterface 175 2 0
    //   61: invokevirtual 333	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   64: ifeq +35 -> 99
    //   67: aload_1
    //   68: aload_1
    //   69: ldc -30
    //   71: invokeinterface 171 2 0
    //   76: invokeinterface 232 2 0
    //   81: istore_2
    //   82: iload_2
    //   83: iconst_1
    //   84: if_icmpne +26 -> 110
    //   87: aload_1
    //   88: ifnull +9 -> 97
    //   91: aload_1
    //   92: invokeinterface 189 1 0
    //   97: iconst_1
    //   98: ireturn
    //   99: aload_1
    //   100: invokeinterface 186 1 0
    //   105: istore_3
    //   106: iload_3
    //   107: ifne -61 -> 46
    //   110: aload_1
    //   111: ifnull +69 -> 180
    //   114: aload_1
    //   115: invokeinterface 189 1 0
    //   120: goto +60 -> 180
    //   123: astore_0
    //   124: goto +44 -> 168
    //   127: astore 4
    //   129: aload_1
    //   130: astore_0
    //   131: aload 4
    //   133: astore_1
    //   134: goto +14 -> 148
    //   137: astore_0
    //   138: aload 4
    //   140: astore_1
    //   141: goto +27 -> 168
    //   144: astore_1
    //   145: aload 5
    //   147: astore_0
    //   148: aload_0
    //   149: astore 4
    //   151: aload_1
    //   152: invokevirtual 145	java/lang/Exception:printStackTrace	()V
    //   155: aload_0
    //   156: ifnull +24 -> 180
    //   159: aload_0
    //   160: invokeinterface 189 1 0
    //   165: goto +15 -> 180
    //   168: aload_1
    //   169: ifnull +9 -> 178
    //   172: aload_1
    //   173: invokeinterface 189 1 0
    //   178: aload_0
    //   179: athrow
    //   180: iconst_0
    //   181: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	paramString	String
    //   0	182	1	paramSQLiteDatabase	SQLiteDatabase
    //   81	4	2	i	int
    //   105	2	3	bool	boolean
    //   21	1	4	localObject1	Object
    //   127	12	4	localException	Exception
    //   149	1	4	str	String
    //   18	128	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   37	46	123	finally
    //   46	82	123	finally
    //   99	106	123	finally
    //   37	46	127	java/lang/Exception
    //   46	82	127	java/lang/Exception
    //   99	106	127	java/lang/Exception
    //   23	37	137	finally
    //   151	155	137	finally
    //   23	37	144	java/lang/Exception
  }
  
  public static boolean isTableExists(String paramString, SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      boolean bool = BaseUtility.containsIgnoreCases(findAllTableNames(paramSQLiteDatabase), paramString);
      return bool;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\org\litepal\util\DBUtility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */