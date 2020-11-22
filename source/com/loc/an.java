package com.loc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class an
{
  private static Map<Class<? extends am>, am> d = new HashMap();
  private aq a;
  private SQLiteDatabase b;
  private am c;
  
  public an(Context paramContext, am paramam)
  {
    try
    {
      this.a = new aq(paramContext.getApplicationContext(), paramam.a(), paramam);
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    this.c = paramam;
  }
  
  private static ContentValues a(Object paramObject, ao paramao)
  {
    ContentValues localContentValues = new ContentValues();
    paramao = a(paramObject.getClass(), paramao.b());
    int j = paramao.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = paramao[i];
      ((Field)localObject2).setAccessible(true);
      Object localObject1 = ((Field)localObject2).getAnnotation(ap.class);
      if (localObject1 != null)
      {
        localObject1 = (ap)localObject1;
        switch (((ap)localObject1).b())
        {
        default: 
          break;
        case 7: 
        case 6: 
        case 5: 
        case 4: 
        case 3: 
        case 2: 
        case 1: 
          try
          {
            localObject2 = (byte[])((Field)localObject2).get(paramObject);
            localContentValues.put(((ap)localObject1).a(), (byte[])localObject2);
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            long l;
            double d1;
            float f;
            int k;
            short s;
            localIllegalAccessException.printStackTrace();
          }
          localObject2 = (String)((Field)localObject2).get(paramObject);
          localContentValues.put(((ap)localObject1).a(), (String)localObject2);
          break;
          l = ((Field)localObject2).getLong(paramObject);
          localContentValues.put(((ap)localObject1).a(), Long.valueOf(l));
          break;
          d1 = ((Field)localObject2).getDouble(paramObject);
          localContentValues.put(((ap)localObject1).a(), Double.valueOf(d1));
          break;
          f = ((Field)localObject2).getFloat(paramObject);
          localContentValues.put(((ap)localObject1).a(), Float.valueOf(f));
          break;
          k = ((Field)localObject2).getInt(paramObject);
          localContentValues.put(((ap)localObject1).a(), Integer.valueOf(k));
          break;
          s = ((Field)localObject2).getShort(paramObject);
          localContentValues.put(((ap)localObject1).a(), Short.valueOf(s));
          break;
        }
      }
      i += 1;
    }
    return localContentValues;
  }
  
  private SQLiteDatabase a()
  {
    try
    {
      if ((this.b == null) || (this.b.isReadOnly()))
      {
        if (this.b != null) {
          this.b.close();
        }
        this.b = this.a.getWritableDatabase();
      }
    }
    catch (Throwable localThrowable)
    {
      ag.a(localThrowable, "dbs", "gwd");
    }
    return this.b;
  }
  
  private SQLiteDatabase a(boolean paramBoolean)
  {
    try
    {
      if (this.b == null) {
        this.b = this.a.getReadableDatabase();
      }
    }
    catch (Throwable localThrowable)
    {
      if (!paramBoolean) {
        ag.a(localThrowable, "dbs", "grd");
      } else {
        localThrowable.printStackTrace();
      }
    }
    return this.b;
  }
  
  public static am a(Class<? extends am> paramClass)
    throws IllegalAccessException, InstantiationException
  {
    try
    {
      if (d.get(paramClass) == null) {
        d.put(paramClass, paramClass.newInstance());
      }
      paramClass = (am)d.get(paramClass);
      return paramClass;
    }
    finally {}
  }
  
  private static <T> T a(Cursor paramCursor, Class<T> paramClass, ao paramao)
    throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException
  {
    paramao = a(paramClass, paramao.b());
    int i = 0;
    paramClass = paramClass.getDeclaredConstructor(new Class[0]);
    paramClass.setAccessible(true);
    Object localObject1 = paramClass.newInstance(new Object[0]);
    int j = paramao.length;
    while (i < j)
    {
      Object localObject2 = paramao[i];
      ((Field)localObject2).setAccessible(true);
      paramClass = ((Field)localObject2).getAnnotation(ap.class);
      if (paramClass != null)
      {
        paramClass = (ap)paramClass;
        int k = paramClass.b();
        int m = paramCursor.getColumnIndex(paramClass.a());
        switch (k)
        {
        default: 
          break;
        case 7: 
          paramClass = paramCursor.getBlob(m);
          break;
        case 6: 
          paramClass = paramCursor.getString(m);
          break;
        case 5: 
          paramClass = Long.valueOf(paramCursor.getLong(m));
          break;
        case 4: 
          paramClass = Double.valueOf(paramCursor.getDouble(m));
          break;
        case 3: 
          paramClass = Float.valueOf(paramCursor.getFloat(m));
          break;
        case 2: 
          paramClass = Integer.valueOf(paramCursor.getInt(m));
          break;
        case 1: 
          paramClass = Short.valueOf(paramCursor.getShort(m));
        }
        ((Field)localObject2).set(localObject1, paramClass);
      }
      i += 1;
    }
    return (T)localObject1;
  }
  
  private static <T> String a(ao paramao)
  {
    if (paramao == null) {
      return null;
    }
    return paramao.a();
  }
  
  public static String a(Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramMap.keySet().iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (i != 0)
      {
        localStringBuilder.append(str);
        localStringBuilder.append(" = '");
        localStringBuilder.append((String)paramMap.get(str));
        localStringBuilder.append("'");
        i = 0;
      }
      else
      {
        localStringBuilder.append(" and ");
        localStringBuilder.append(str);
        localStringBuilder.append(" = '");
        localStringBuilder.append((String)paramMap.get(str));
        localStringBuilder.append("'");
      }
    }
    return localStringBuilder.toString();
  }
  
  private static Field[] a(Class<?> paramClass, boolean paramBoolean)
  {
    if (paramClass == null) {
      return null;
    }
    if (paramBoolean) {
      return paramClass.getSuperclass().getDeclaredFields();
    }
    return paramClass.getDeclaredFields();
  }
  
  private static <T> ao b(Class<T> paramClass)
  {
    paramClass = paramClass.getAnnotation(ao.class);
    int i;
    if (paramClass != null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return null;
    }
    return (ao)paramClass;
  }
  
  /* Error */
  public final <T> List<T> a(String paramString, Class<T> paramClass, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 50	com/loc/an:c	Lcom/loc/am;
    //   4: astore 6
    //   6: aload 6
    //   8: monitorenter
    //   9: new 310	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 311	java/util/ArrayList:<init>	()V
    //   16: astore 7
    //   18: aload_2
    //   19: invokestatic 313	com/loc/an:b	(Ljava/lang/Class;)Lcom/loc/ao;
    //   22: astore 8
    //   24: aload 8
    //   26: invokestatic 315	com/loc/an:a	(Lcom/loc/ao;)Ljava/lang/String;
    //   29: astore 5
    //   31: aload_0
    //   32: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   35: ifnonnull +12 -> 47
    //   38: aload_0
    //   39: aload_0
    //   40: iload_3
    //   41: invokespecial 317	com/loc/an:a	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   44: putfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   47: aload_0
    //   48: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   51: ifnull +404 -> 455
    //   54: aload 5
    //   56: invokestatic 323	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   59: istore 4
    //   61: iload 4
    //   63: ifne +392 -> 455
    //   66: aload_1
    //   67: ifnonnull +6 -> 73
    //   70: goto +385 -> 455
    //   73: aload_0
    //   74: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   77: aload 5
    //   79: aconst_null
    //   80: aload_1
    //   81: aconst_null
    //   82: aconst_null
    //   83: aconst_null
    //   84: aconst_null
    //   85: invokevirtual 327	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   88: astore 5
    //   90: aload 5
    //   92: ifnonnull +102 -> 194
    //   95: aload 5
    //   97: astore_1
    //   98: aload_0
    //   99: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   102: invokevirtual 172	android/database/sqlite/SQLiteDatabase:close	()V
    //   105: aload 5
    //   107: astore_1
    //   108: aload_0
    //   109: aconst_null
    //   110: putfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   113: aload 5
    //   115: ifnull +27 -> 142
    //   118: aload 5
    //   120: invokeinterface 328 1 0
    //   125: goto +17 -> 142
    //   128: astore_1
    //   129: iload_3
    //   130: ifne +12 -> 142
    //   133: aload_1
    //   134: ldc -79
    //   136: ldc_w 330
    //   139: invokestatic 184	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   142: aload_0
    //   143: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   146: ifnull +32 -> 178
    //   149: aload_0
    //   150: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   153: invokevirtual 172	android/database/sqlite/SQLiteDatabase:close	()V
    //   156: aload_0
    //   157: aconst_null
    //   158: putfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   161: goto +17 -> 178
    //   164: astore_1
    //   165: iload_3
    //   166: ifne +12 -> 178
    //   169: aload_1
    //   170: ldc -79
    //   172: ldc_w 330
    //   175: invokestatic 184	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   178: aload 6
    //   180: monitorexit
    //   181: aload 7
    //   183: areturn
    //   184: astore_1
    //   185: aload 5
    //   187: astore_2
    //   188: aload_1
    //   189: astore 5
    //   191: goto +116 -> 307
    //   194: aload 5
    //   196: astore_1
    //   197: aload 5
    //   199: invokeinterface 333 1 0
    //   204: ifeq +25 -> 229
    //   207: aload 5
    //   209: astore_1
    //   210: aload 7
    //   212: aload 5
    //   214: aload_2
    //   215: aload 8
    //   217: invokestatic 335	com/loc/an:a	(Landroid/database/Cursor;Ljava/lang/Class;Lcom/loc/ao;)Ljava/lang/Object;
    //   220: invokeinterface 341 2 0
    //   225: pop
    //   226: goto -32 -> 194
    //   229: aload 5
    //   231: ifnull +27 -> 258
    //   234: aload 5
    //   236: invokeinterface 328 1 0
    //   241: goto +17 -> 258
    //   244: astore_1
    //   245: iload_3
    //   246: ifne +12 -> 258
    //   249: aload_1
    //   250: ldc -79
    //   252: ldc_w 330
    //   255: invokestatic 184	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   258: aload_0
    //   259: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   262: ifnull +187 -> 449
    //   265: aload_0
    //   266: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   269: invokevirtual 172	android/database/sqlite/SQLiteDatabase:close	()V
    //   272: aload_0
    //   273: aconst_null
    //   274: putfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   277: goto +172 -> 449
    //   280: astore_1
    //   281: iload_3
    //   282: ifne +167 -> 449
    //   285: aload_1
    //   286: ldc -79
    //   288: ldc_w 330
    //   291: invokestatic 184	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   294: goto +155 -> 449
    //   297: astore_2
    //   298: aconst_null
    //   299: astore_1
    //   300: goto +27 -> 327
    //   303: astore 5
    //   305: aconst_null
    //   306: astore_2
    //   307: iload_3
    //   308: ifne +84 -> 392
    //   311: aload_2
    //   312: astore_1
    //   313: aload 5
    //   315: ldc -79
    //   317: ldc_w 330
    //   320: invokestatic 184	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   323: goto +69 -> 392
    //   326: astore_2
    //   327: aload_1
    //   328: ifnull +26 -> 354
    //   331: aload_1
    //   332: invokeinterface 328 1 0
    //   337: goto +17 -> 354
    //   340: astore_1
    //   341: iload_3
    //   342: ifne +12 -> 354
    //   345: aload_1
    //   346: ldc -79
    //   348: ldc_w 330
    //   351: invokestatic 184	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   354: aload_0
    //   355: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   358: ifnull +32 -> 390
    //   361: aload_0
    //   362: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   365: invokevirtual 172	android/database/sqlite/SQLiteDatabase:close	()V
    //   368: aload_0
    //   369: aconst_null
    //   370: putfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   373: goto +17 -> 390
    //   376: astore_1
    //   377: iload_3
    //   378: ifne +12 -> 390
    //   381: aload_1
    //   382: ldc -79
    //   384: ldc_w 330
    //   387: invokestatic 184	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   390: aload_2
    //   391: athrow
    //   392: aload_2
    //   393: ifnull +26 -> 419
    //   396: aload_2
    //   397: invokeinterface 328 1 0
    //   402: goto +17 -> 419
    //   405: astore_1
    //   406: iload_3
    //   407: ifne +12 -> 419
    //   410: aload_1
    //   411: ldc -79
    //   413: ldc_w 330
    //   416: invokestatic 184	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   419: aload_0
    //   420: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   423: ifnull +26 -> 449
    //   426: aload_0
    //   427: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   430: invokevirtual 172	android/database/sqlite/SQLiteDatabase:close	()V
    //   433: aload_0
    //   434: aconst_null
    //   435: putfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   438: goto +11 -> 449
    //   441: astore_1
    //   442: iload_3
    //   443: ifne +6 -> 449
    //   446: goto -161 -> 285
    //   449: aload 6
    //   451: monitorexit
    //   452: aload 7
    //   454: areturn
    //   455: aload 6
    //   457: monitorexit
    //   458: aload 7
    //   460: areturn
    //   461: astore_1
    //   462: aload 6
    //   464: monitorexit
    //   465: aload_1
    //   466: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	467	0	this	an
    //   0	467	1	paramString	String
    //   0	467	2	paramClass	Class<T>
    //   0	467	3	paramBoolean	boolean
    //   59	3	4	bool	boolean
    //   29	206	5	localObject	Object
    //   303	11	5	localThrowable	Throwable
    //   4	459	6	localam	am
    //   16	443	7	localArrayList	java.util.ArrayList
    //   22	194	8	localao	ao
    // Exception table:
    //   from	to	target	type
    //   118	125	128	java/lang/Throwable
    //   142	161	164	java/lang/Throwable
    //   98	105	184	java/lang/Throwable
    //   108	113	184	java/lang/Throwable
    //   197	207	184	java/lang/Throwable
    //   210	226	184	java/lang/Throwable
    //   234	241	244	java/lang/Throwable
    //   258	277	280	java/lang/Throwable
    //   73	90	297	finally
    //   73	90	303	java/lang/Throwable
    //   98	105	326	finally
    //   108	113	326	finally
    //   197	207	326	finally
    //   210	226	326	finally
    //   313	323	326	finally
    //   331	337	340	java/lang/Throwable
    //   354	373	376	java/lang/Throwable
    //   396	402	405	java/lang/Throwable
    //   419	438	441	java/lang/Throwable
    //   9	47	461	finally
    //   47	61	461	finally
    //   118	125	461	finally
    //   133	142	461	finally
    //   142	161	461	finally
    //   169	178	461	finally
    //   178	181	461	finally
    //   234	241	461	finally
    //   249	258	461	finally
    //   258	277	461	finally
    //   285	294	461	finally
    //   331	337	461	finally
    //   345	354	461	finally
    //   354	373	461	finally
    //   381	390	461	finally
    //   390	392	461	finally
    //   396	402	461	finally
    //   410	419	461	finally
    //   419	438	461	finally
    //   449	452	461	finally
    //   455	458	461	finally
    //   462	465	461	finally
  }
  
  /* Error */
  public final <T> void a(T paramT)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 50	com/loc/an:c	Lcom/loc/am;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_0
    //   8: aload_0
    //   9: invokespecial 345	com/loc/an:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   12: putfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   15: aload_0
    //   16: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   19: ifnonnull +6 -> 25
    //   22: aload_2
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   29: astore_3
    //   30: aload_1
    //   31: invokevirtual 60	java/lang/Object:getClass	()Ljava/lang/Class;
    //   34: invokestatic 313	com/loc/an:b	(Ljava/lang/Class;)Lcom/loc/ao;
    //   37: astore 4
    //   39: aload 4
    //   41: invokestatic 315	com/loc/an:a	(Lcom/loc/ao;)Ljava/lang/String;
    //   44: astore 5
    //   46: aload 5
    //   48: invokestatic 323	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   51: ifne +28 -> 79
    //   54: aload_1
    //   55: ifnull +24 -> 79
    //   58: aload_3
    //   59: ifnonnull +6 -> 65
    //   62: goto +17 -> 79
    //   65: aload_3
    //   66: aload 5
    //   68: aconst_null
    //   69: aload_1
    //   70: aload 4
    //   72: invokestatic 347	com/loc/an:a	(Ljava/lang/Object;Lcom/loc/ao;)Landroid/content/ContentValues;
    //   75: invokevirtual 351	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   78: pop2
    //   79: aload_0
    //   80: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   83: ifnull +49 -> 132
    //   86: aload_0
    //   87: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   90: invokevirtual 172	android/database/sqlite/SQLiteDatabase:close	()V
    //   93: aload_0
    //   94: aconst_null
    //   95: putfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   98: goto +34 -> 132
    //   101: astore_1
    //   102: goto +33 -> 135
    //   105: astore_1
    //   106: aload_1
    //   107: ldc -79
    //   109: ldc_w 353
    //   112: invokestatic 184	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload_0
    //   116: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   119: ifnull +13 -> 132
    //   122: aload_0
    //   123: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   126: invokevirtual 172	android/database/sqlite/SQLiteDatabase:close	()V
    //   129: goto -36 -> 93
    //   132: aload_2
    //   133: monitorexit
    //   134: return
    //   135: aload_0
    //   136: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   139: ifnull +15 -> 154
    //   142: aload_0
    //   143: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   146: invokevirtual 172	android/database/sqlite/SQLiteDatabase:close	()V
    //   149: aload_0
    //   150: aconst_null
    //   151: putfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   154: aload_1
    //   155: athrow
    //   156: astore_1
    //   157: aload_2
    //   158: monitorexit
    //   159: aload_1
    //   160: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	this	an
    //   0	161	1	paramT	T
    //   4	154	2	localam	am
    //   29	37	3	localSQLiteDatabase	SQLiteDatabase
    //   37	34	4	localao	ao
    //   44	23	5	str	String
    // Exception table:
    //   from	to	target	type
    //   25	54	101	finally
    //   65	79	101	finally
    //   106	115	101	finally
    //   25	54	105	java/lang/Throwable
    //   65	79	105	java/lang/Throwable
    //   7	24	156	finally
    //   79	93	156	finally
    //   93	98	156	finally
    //   115	129	156	finally
    //   132	134	156	finally
    //   135	154	156	finally
    //   154	156	156	finally
    //   157	159	156	finally
  }
  
  public final void a(Object paramObject, String paramString)
  {
    synchronized (this.c)
    {
      if (a(paramString, paramObject.getClass(), false).size() == 0) {
        a(paramObject);
      } else {
        a(paramString, paramObject);
      }
      return;
    }
  }
  
  /* Error */
  public final <T> void a(String paramString, Class<T> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 50	com/loc/an:c	Lcom/loc/am;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_2
    //   8: invokestatic 313	com/loc/an:b	(Ljava/lang/Class;)Lcom/loc/ao;
    //   11: invokestatic 315	com/loc/an:a	(Lcom/loc/ao;)Ljava/lang/String;
    //   14: astore_2
    //   15: aload_2
    //   16: invokestatic 323	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifeq +6 -> 25
    //   22: aload_3
    //   23: monitorexit
    //   24: return
    //   25: aload_0
    //   26: aload_0
    //   27: invokespecial 345	com/loc/an:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   30: putfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   33: aload_0
    //   34: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   37: ifnonnull +6 -> 43
    //   40: aload_3
    //   41: monitorexit
    //   42: return
    //   43: aload_0
    //   44: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   47: aload_2
    //   48: aload_1
    //   49: aconst_null
    //   50: invokevirtual 370	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   53: pop
    //   54: aload_0
    //   55: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   58: ifnull +49 -> 107
    //   61: aload_0
    //   62: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   65: invokevirtual 172	android/database/sqlite/SQLiteDatabase:close	()V
    //   68: aload_0
    //   69: aconst_null
    //   70: putfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   73: goto +34 -> 107
    //   76: astore_1
    //   77: goto +33 -> 110
    //   80: astore_1
    //   81: aload_1
    //   82: ldc -79
    //   84: ldc_w 372
    //   87: invokestatic 184	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_0
    //   91: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   94: ifnull +13 -> 107
    //   97: aload_0
    //   98: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   101: invokevirtual 172	android/database/sqlite/SQLiteDatabase:close	()V
    //   104: goto -36 -> 68
    //   107: aload_3
    //   108: monitorexit
    //   109: return
    //   110: aload_0
    //   111: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   114: ifnull +15 -> 129
    //   117: aload_0
    //   118: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   121: invokevirtual 172	android/database/sqlite/SQLiteDatabase:close	()V
    //   124: aload_0
    //   125: aconst_null
    //   126: putfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   129: aload_1
    //   130: athrow
    //   131: astore_1
    //   132: aload_3
    //   133: monitorexit
    //   134: aload_1
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	an
    //   0	136	1	paramString	String
    //   0	136	2	paramClass	Class<T>
    //   4	129	3	localam	am
    // Exception table:
    //   from	to	target	type
    //   43	54	76	finally
    //   81	90	76	finally
    //   43	54	80	java/lang/Throwable
    //   7	24	131	finally
    //   25	42	131	finally
    //   54	68	131	finally
    //   68	73	131	finally
    //   90	104	131	finally
    //   107	109	131	finally
    //   110	129	131	finally
    //   129	131	131	finally
    //   132	134	131	finally
  }
  
  /* Error */
  public final <T> void a(String paramString, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 50	com/loc/an:c	Lcom/loc/am;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_2
    //   8: ifnonnull +6 -> 14
    //   11: aload_3
    //   12: monitorexit
    //   13: return
    //   14: aload_2
    //   15: invokevirtual 60	java/lang/Object:getClass	()Ljava/lang/Class;
    //   18: invokestatic 313	com/loc/an:b	(Ljava/lang/Class;)Lcom/loc/ao;
    //   21: astore 5
    //   23: aload 5
    //   25: invokestatic 315	com/loc/an:a	(Lcom/loc/ao;)Ljava/lang/String;
    //   28: astore 4
    //   30: aload 4
    //   32: invokestatic 323	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   35: ifeq +6 -> 41
    //   38: aload_3
    //   39: monitorexit
    //   40: return
    //   41: aload_2
    //   42: aload 5
    //   44: invokestatic 347	com/loc/an:a	(Ljava/lang/Object;Lcom/loc/ao;)Landroid/content/ContentValues;
    //   47: astore_2
    //   48: aload_0
    //   49: aload_0
    //   50: invokespecial 345	com/loc/an:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   53: putfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   56: aload_0
    //   57: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   60: ifnonnull +6 -> 66
    //   63: aload_3
    //   64: monitorexit
    //   65: return
    //   66: aload_0
    //   67: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   70: aload 4
    //   72: aload_2
    //   73: aload_1
    //   74: aconst_null
    //   75: invokevirtual 377	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   78: pop
    //   79: aload_0
    //   80: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   83: ifnull +49 -> 132
    //   86: aload_0
    //   87: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   90: invokevirtual 172	android/database/sqlite/SQLiteDatabase:close	()V
    //   93: aload_0
    //   94: aconst_null
    //   95: putfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   98: goto +34 -> 132
    //   101: astore_1
    //   102: goto +33 -> 135
    //   105: astore_1
    //   106: aload_1
    //   107: ldc -79
    //   109: ldc_w 379
    //   112: invokestatic 184	com/loc/ag:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload_0
    //   116: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   119: ifnull +13 -> 132
    //   122: aload_0
    //   123: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   126: invokevirtual 172	android/database/sqlite/SQLiteDatabase:close	()V
    //   129: goto -36 -> 93
    //   132: aload_3
    //   133: monitorexit
    //   134: return
    //   135: aload_0
    //   136: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   139: ifnull +15 -> 154
    //   142: aload_0
    //   143: getfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   146: invokevirtual 172	android/database/sqlite/SQLiteDatabase:close	()V
    //   149: aload_0
    //   150: aconst_null
    //   151: putfield 164	com/loc/an:b	Landroid/database/sqlite/SQLiteDatabase;
    //   154: aload_1
    //   155: athrow
    //   156: aload_3
    //   157: monitorexit
    //   158: aload_1
    //   159: athrow
    //   160: astore_1
    //   161: goto -5 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	an
    //   0	164	1	paramString	String
    //   0	164	2	paramObject	Object
    //   4	153	3	localam	am
    //   28	43	4	str	String
    //   21	22	5	localao	ao
    // Exception table:
    //   from	to	target	type
    //   66	79	101	finally
    //   106	115	101	finally
    //   66	79	105	java/lang/Throwable
    //   11	13	160	finally
    //   14	40	160	finally
    //   41	65	160	finally
    //   79	93	160	finally
    //   93	98	160	finally
    //   115	129	160	finally
    //   132	134	160	finally
    //   135	154	160	finally
    //   154	156	160	finally
    //   156	158	160	finally
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */