package com.amap.api.mapcore.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class go
{
  private static Map<Class<? extends gn>, gn> d = new HashMap();
  private gr a;
  private SQLiteDatabase b;
  private gn c;
  
  public go(Context paramContext, gn paramgn)
  {
    try
    {
      this.a = new gr(paramContext.getApplicationContext(), paramgn.b(), null, paramgn.c(), paramgn);
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    this.c = paramgn;
  }
  
  private ContentValues a(Object paramObject, gp paramgp)
  {
    ContentValues localContentValues = new ContentValues();
    paramgp = a(paramObject.getClass(), paramgp.b());
    int j = paramgp.length;
    int i = 0;
    while (i < j)
    {
      Field localField = paramgp[i];
      localField.setAccessible(true);
      a(paramObject, localField, localContentValues);
      i += 1;
    }
    return localContentValues;
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
        gg.a(localThrowable, "dbs", "grd");
      } else {
        localThrowable.printStackTrace();
      }
    }
    return this.b;
  }
  
  public static gn a(Class<? extends gn> paramClass)
    throws IllegalAccessException, InstantiationException
  {
    try
    {
      if (d.get(paramClass) == null) {
        d.put(paramClass, paramClass.newInstance());
      }
      paramClass = (gn)d.get(paramClass);
      return paramClass;
    }
    finally {}
  }
  
  private <T> T a(Cursor paramCursor, Class<T> paramClass, gp paramgp)
    throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException
  {
    paramgp = a(paramClass, paramgp.b());
    int i = 0;
    paramClass = paramClass.getDeclaredConstructor(new Class[0]);
    paramClass.setAccessible(true);
    paramClass = paramClass.newInstance(new Object[0]);
    int j = paramgp.length;
    while (i < j)
    {
      Object localObject1 = paramgp[i];
      ((Field)localObject1).setAccessible(true);
      Object localObject2 = ((Field)localObject1).getAnnotation(gq.class);
      if (localObject2 != null)
      {
        localObject2 = (gq)localObject2;
        int k = ((gq)localObject2).b();
        int m = paramCursor.getColumnIndex(((gq)localObject2).a());
        switch (k)
        {
        default: 
          break;
        case 7: 
          ((Field)localObject1).set(paramClass, paramCursor.getBlob(m));
          break;
        case 6: 
          ((Field)localObject1).set(paramClass, paramCursor.getString(m));
          break;
        case 5: 
          ((Field)localObject1).set(paramClass, Long.valueOf(paramCursor.getLong(m)));
          break;
        case 4: 
          ((Field)localObject1).set(paramClass, Double.valueOf(paramCursor.getDouble(m)));
          break;
        case 3: 
          ((Field)localObject1).set(paramClass, Float.valueOf(paramCursor.getFloat(m)));
          break;
        case 2: 
          ((Field)localObject1).set(paramClass, Integer.valueOf(paramCursor.getInt(m)));
          break;
        case 1: 
          ((Field)localObject1).set(paramClass, Short.valueOf(paramCursor.getShort(m)));
        }
      }
      i += 1;
    }
    return paramClass;
  }
  
  private <T> String a(gp paramgp)
  {
    if (paramgp == null) {
      return null;
    }
    return paramgp.a();
  }
  
  public static String a(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 1;
    Iterator localIterator = paramMap.keySet().iterator();
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
  
  private <T> void a(SQLiteDatabase paramSQLiteDatabase, T paramT)
  {
    gp localgp = b(paramT.getClass());
    String str = a(localgp);
    if (TextUtils.isEmpty(str)) {
      return;
    }
    if (paramT != null)
    {
      if (paramSQLiteDatabase == null) {
        return;
      }
      paramT = a(paramT, localgp);
      if (paramT == null) {
        return;
      }
      paramSQLiteDatabase.insert(str, null, paramT);
      return;
    }
  }
  
  private void a(Object paramObject, Field paramField, ContentValues paramContentValues)
  {
    Object localObject = paramField.getAnnotation(gq.class);
    if (localObject == null) {
      return;
    }
    localObject = (gq)localObject;
    switch (((gq)localObject).b())
    {
    default: 
      return;
    }
    try
    {
      paramObject = (byte[])paramField.get(paramObject);
      paramContentValues.put(((gq)localObject).a(), (byte[])paramObject);
      return;
    }
    catch (IllegalAccessException paramObject)
    {
      long l;
      double d1;
      float f;
      int i;
      short s;
      ((IllegalAccessException)paramObject).printStackTrace();
    }
    paramObject = (String)paramField.get(paramObject);
    paramContentValues.put(((gq)localObject).a(), (String)paramObject);
    return;
    l = paramField.getLong(paramObject);
    paramContentValues.put(((gq)localObject).a(), Long.valueOf(l));
    return;
    d1 = paramField.getDouble(paramObject);
    paramContentValues.put(((gq)localObject).a(), Double.valueOf(d1));
    return;
    f = paramField.getFloat(paramObject);
    paramContentValues.put(((gq)localObject).a(), Float.valueOf(f));
    return;
    i = paramField.getInt(paramObject);
    paramContentValues.put(((gq)localObject).a(), Integer.valueOf(i));
    return;
    s = paramField.getShort(paramObject);
    paramContentValues.put(((gq)localObject).a(), Short.valueOf(s));
    return;
  }
  
  private boolean a(Annotation paramAnnotation)
  {
    return paramAnnotation != null;
  }
  
  private Field[] a(Class<?> paramClass, boolean paramBoolean)
  {
    if (paramClass == null) {
      return null;
    }
    if (paramBoolean) {
      return paramClass.getSuperclass().getDeclaredFields();
    }
    return paramClass.getDeclaredFields();
  }
  
  private SQLiteDatabase b(boolean paramBoolean)
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
      gg.a(localThrowable, "dbs", "gwd");
    }
    return this.b;
  }
  
  private <T> gp b(Class<T> paramClass)
  {
    paramClass = paramClass.getAnnotation(gp.class);
    if (!a(paramClass)) {
      return null;
    }
    return (gp)paramClass;
  }
  
  /* Error */
  public <T> List<T> a(String paramString, Class<T> paramClass, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	com/amap/api/mapcore/util/go:c	Lcom/amap/api/mapcore/util/gn;
    //   4: astore 6
    //   6: aload 6
    //   8: monitorenter
    //   9: new 339	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 340	java/util/ArrayList:<init>	()V
    //   16: astore 7
    //   18: aload_0
    //   19: aload_2
    //   20: invokespecial 255	com/amap/api/mapcore/util/go:b	(Ljava/lang/Class;)Lcom/amap/api/mapcore/util/gp;
    //   23: astore 8
    //   25: aload_0
    //   26: aload 8
    //   28: invokespecial 257	com/amap/api/mapcore/util/go:a	(Lcom/amap/api/mapcore/util/gp;)Ljava/lang/String;
    //   31: astore 5
    //   33: aload_0
    //   34: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   37: ifnonnull +12 -> 49
    //   40: aload_0
    //   41: aload_0
    //   42: iload_3
    //   43: invokespecial 342	com/amap/api/mapcore/util/go:a	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   46: putfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   49: aload_0
    //   50: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   53: ifnull +405 -> 458
    //   56: aload 5
    //   58: invokestatic 263	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   61: istore 4
    //   63: iload 4
    //   65: ifne +393 -> 458
    //   68: aload_1
    //   69: ifnonnull +6 -> 75
    //   72: goto +386 -> 458
    //   75: aload_0
    //   76: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   79: aload 5
    //   81: aconst_null
    //   82: aload_1
    //   83: aconst_null
    //   84: aconst_null
    //   85: aconst_null
    //   86: aconst_null
    //   87: invokevirtual 346	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   90: astore 5
    //   92: aload 5
    //   94: ifnonnull +102 -> 196
    //   97: aload 5
    //   99: astore_1
    //   100: aload_0
    //   101: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   104: invokevirtual 327	android/database/sqlite/SQLiteDatabase:close	()V
    //   107: aload 5
    //   109: astore_1
    //   110: aload_0
    //   111: aconst_null
    //   112: putfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   115: aload 5
    //   117: ifnull +27 -> 144
    //   120: aload 5
    //   122: invokeinterface 347 1 0
    //   127: goto +17 -> 144
    //   130: astore_1
    //   131: iload_3
    //   132: ifne +12 -> 144
    //   135: aload_1
    //   136: ldc 87
    //   138: ldc_w 349
    //   141: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   144: aload_0
    //   145: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   148: ifnull +32 -> 180
    //   151: aload_0
    //   152: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   155: invokevirtual 327	android/database/sqlite/SQLiteDatabase:close	()V
    //   158: aload_0
    //   159: aconst_null
    //   160: putfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   163: goto +17 -> 180
    //   166: astore_1
    //   167: iload_3
    //   168: ifne +12 -> 180
    //   171: aload_1
    //   172: ldc 87
    //   174: ldc_w 349
    //   177: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   180: aload 6
    //   182: monitorexit
    //   183: aload 7
    //   185: areturn
    //   186: astore_1
    //   187: aload 5
    //   189: astore_2
    //   190: aload_1
    //   191: astore 5
    //   193: goto +117 -> 310
    //   196: aload 5
    //   198: astore_1
    //   199: aload 5
    //   201: invokeinterface 352 1 0
    //   206: ifeq +26 -> 232
    //   209: aload 5
    //   211: astore_1
    //   212: aload 7
    //   214: aload_0
    //   215: aload 5
    //   217: aload_2
    //   218: aload 8
    //   220: invokespecial 354	com/amap/api/mapcore/util/go:a	(Landroid/database/Cursor;Ljava/lang/Class;Lcom/amap/api/mapcore/util/gp;)Ljava/lang/Object;
    //   223: invokeinterface 360 2 0
    //   228: pop
    //   229: goto -33 -> 196
    //   232: aload 5
    //   234: ifnull +27 -> 261
    //   237: aload 5
    //   239: invokeinterface 347 1 0
    //   244: goto +17 -> 261
    //   247: astore_1
    //   248: iload_3
    //   249: ifne +12 -> 261
    //   252: aload_1
    //   253: ldc 87
    //   255: ldc_w 349
    //   258: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   261: aload_0
    //   262: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   265: ifnull +187 -> 452
    //   268: aload_0
    //   269: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   272: invokevirtual 327	android/database/sqlite/SQLiteDatabase:close	()V
    //   275: aload_0
    //   276: aconst_null
    //   277: putfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   280: goto +172 -> 452
    //   283: astore_1
    //   284: iload_3
    //   285: ifne +167 -> 452
    //   288: aload_1
    //   289: ldc 87
    //   291: ldc_w 349
    //   294: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   297: goto +155 -> 452
    //   300: astore_2
    //   301: aconst_null
    //   302: astore_1
    //   303: goto +27 -> 330
    //   306: astore 5
    //   308: aconst_null
    //   309: astore_2
    //   310: iload_3
    //   311: ifne +84 -> 395
    //   314: aload_2
    //   315: astore_1
    //   316: aload 5
    //   318: ldc 87
    //   320: ldc_w 349
    //   323: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   326: goto +69 -> 395
    //   329: astore_2
    //   330: aload_1
    //   331: ifnull +26 -> 357
    //   334: aload_1
    //   335: invokeinterface 347 1 0
    //   340: goto +17 -> 357
    //   343: astore_1
    //   344: iload_3
    //   345: ifne +12 -> 357
    //   348: aload_1
    //   349: ldc 87
    //   351: ldc_w 349
    //   354: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   357: aload_0
    //   358: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   361: ifnull +32 -> 393
    //   364: aload_0
    //   365: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   368: invokevirtual 327	android/database/sqlite/SQLiteDatabase:close	()V
    //   371: aload_0
    //   372: aconst_null
    //   373: putfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   376: goto +17 -> 393
    //   379: astore_1
    //   380: iload_3
    //   381: ifne +12 -> 393
    //   384: aload_1
    //   385: ldc 87
    //   387: ldc_w 349
    //   390: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   393: aload_2
    //   394: athrow
    //   395: aload_2
    //   396: ifnull +26 -> 422
    //   399: aload_2
    //   400: invokeinterface 347 1 0
    //   405: goto +17 -> 422
    //   408: astore_1
    //   409: iload_3
    //   410: ifne +12 -> 422
    //   413: aload_1
    //   414: ldc 87
    //   416: ldc_w 349
    //   419: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   422: aload_0
    //   423: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   426: ifnull +26 -> 452
    //   429: aload_0
    //   430: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   433: invokevirtual 327	android/database/sqlite/SQLiteDatabase:close	()V
    //   436: aload_0
    //   437: aconst_null
    //   438: putfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   441: goto +11 -> 452
    //   444: astore_1
    //   445: iload_3
    //   446: ifne +6 -> 452
    //   449: goto -161 -> 288
    //   452: aload 6
    //   454: monitorexit
    //   455: aload 7
    //   457: areturn
    //   458: aload 6
    //   460: monitorexit
    //   461: aload 7
    //   463: areturn
    //   464: astore_1
    //   465: aload 6
    //   467: monitorexit
    //   468: aload_1
    //   469: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	470	0	this	go
    //   0	470	1	paramString	String
    //   0	470	2	paramClass	Class<T>
    //   0	470	3	paramBoolean	boolean
    //   61	3	4	bool	boolean
    //   31	207	5	localObject	Object
    //   306	11	5	localThrowable	Throwable
    //   4	462	6	localgn	gn
    //   16	446	7	localArrayList	java.util.ArrayList
    //   23	196	8	localgp	gp
    // Exception table:
    //   from	to	target	type
    //   120	127	130	java/lang/Throwable
    //   144	163	166	java/lang/Throwable
    //   100	107	186	java/lang/Throwable
    //   110	115	186	java/lang/Throwable
    //   199	209	186	java/lang/Throwable
    //   212	229	186	java/lang/Throwable
    //   237	244	247	java/lang/Throwable
    //   261	280	283	java/lang/Throwable
    //   75	92	300	finally
    //   75	92	306	java/lang/Throwable
    //   100	107	329	finally
    //   110	115	329	finally
    //   199	209	329	finally
    //   212	229	329	finally
    //   316	326	329	finally
    //   334	340	343	java/lang/Throwable
    //   357	376	379	java/lang/Throwable
    //   399	405	408	java/lang/Throwable
    //   422	441	444	java/lang/Throwable
    //   9	49	464	finally
    //   49	63	464	finally
    //   120	127	464	finally
    //   135	144	464	finally
    //   144	163	464	finally
    //   171	180	464	finally
    //   180	183	464	finally
    //   237	244	464	finally
    //   252	261	464	finally
    //   261	280	464	finally
    //   288	297	464	finally
    //   334	340	464	finally
    //   348	357	464	finally
    //   357	376	464	finally
    //   384	393	464	finally
    //   393	395	464	finally
    //   399	405	464	finally
    //   413	422	464	finally
    //   422	441	464	finally
    //   452	455	464	finally
    //   458	461	464	finally
    //   465	468	464	finally
  }
  
  public <T> void a(T paramT)
  {
    a(paramT, false);
  }
  
  public void a(Object paramObject, String paramString)
  {
    synchronized (this.c)
    {
      List localList = b(paramString, paramObject.getClass());
      if ((localList != null) && (localList.size() != 0)) {
        a(paramString, paramObject);
      } else {
        a(paramObject);
      }
      return;
    }
  }
  
  /* Error */
  public <T> void a(T paramT, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	com/amap/api/mapcore/util/go:c	Lcom/amap/api/mapcore/util/gn;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_0
    //   8: aload_0
    //   9: iload_2
    //   10: invokespecial 380	com/amap/api/mapcore/util/go:b	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   13: putfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   16: aload_0
    //   17: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   20: ifnonnull +6 -> 26
    //   23: aload_3
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: aload_0
    //   28: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   31: aload_1
    //   32: invokespecial 382	com/amap/api/mapcore/util/go:a	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/Object;)V
    //   35: aload_0
    //   36: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   39: ifnull +49 -> 88
    //   42: aload_0
    //   43: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   46: invokevirtual 327	android/database/sqlite/SQLiteDatabase:close	()V
    //   49: aload_0
    //   50: aconst_null
    //   51: putfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   54: goto +34 -> 88
    //   57: astore_1
    //   58: goto +33 -> 91
    //   61: astore_1
    //   62: aload_1
    //   63: ldc 87
    //   65: ldc_w 384
    //   68: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   71: aload_0
    //   72: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   75: ifnull +13 -> 88
    //   78: aload_0
    //   79: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   82: invokevirtual 327	android/database/sqlite/SQLiteDatabase:close	()V
    //   85: goto -36 -> 49
    //   88: aload_3
    //   89: monitorexit
    //   90: return
    //   91: aload_0
    //   92: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   95: ifnull +15 -> 110
    //   98: aload_0
    //   99: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   102: invokevirtual 327	android/database/sqlite/SQLiteDatabase:close	()V
    //   105: aload_0
    //   106: aconst_null
    //   107: putfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   110: aload_1
    //   111: athrow
    //   112: astore_1
    //   113: aload_3
    //   114: monitorexit
    //   115: aload_1
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	go
    //   0	117	1	paramT	T
    //   0	117	2	paramBoolean	boolean
    //   4	110	3	localgn	gn
    // Exception table:
    //   from	to	target	type
    //   26	35	57	finally
    //   62	71	57	finally
    //   26	35	61	java/lang/Throwable
    //   7	25	112	finally
    //   35	49	112	finally
    //   49	54	112	finally
    //   71	85	112	finally
    //   88	90	112	finally
    //   91	110	112	finally
    //   110	112	112	finally
    //   113	115	112	finally
  }
  
  /* Error */
  public <T> void a(String paramString, Class<T> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	com/amap/api/mapcore/util/go:c	Lcom/amap/api/mapcore/util/gn;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_0
    //   8: aload_0
    //   9: aload_2
    //   10: invokespecial 255	com/amap/api/mapcore/util/go:b	(Ljava/lang/Class;)Lcom/amap/api/mapcore/util/gp;
    //   13: invokespecial 257	com/amap/api/mapcore/util/go:a	(Lcom/amap/api/mapcore/util/gp;)Ljava/lang/String;
    //   16: astore_2
    //   17: aload_2
    //   18: invokestatic 263	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: ifeq +6 -> 27
    //   24: aload_3
    //   25: monitorexit
    //   26: return
    //   27: aload_0
    //   28: aload_0
    //   29: iconst_0
    //   30: invokespecial 380	com/amap/api/mapcore/util/go:b	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   33: putfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   36: aload_0
    //   37: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   40: ifnonnull +6 -> 46
    //   43: aload_3
    //   44: monitorexit
    //   45: return
    //   46: aload_0
    //   47: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   50: aload_2
    //   51: aload_1
    //   52: aconst_null
    //   53: invokevirtual 390	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   56: pop
    //   57: aload_0
    //   58: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   61: ifnull +49 -> 110
    //   64: aload_0
    //   65: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   68: invokevirtual 327	android/database/sqlite/SQLiteDatabase:close	()V
    //   71: aload_0
    //   72: aconst_null
    //   73: putfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   76: goto +34 -> 110
    //   79: astore_1
    //   80: goto +33 -> 113
    //   83: astore_1
    //   84: aload_1
    //   85: ldc 87
    //   87: ldc_w 392
    //   90: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   93: aload_0
    //   94: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   97: ifnull +13 -> 110
    //   100: aload_0
    //   101: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   104: invokevirtual 327	android/database/sqlite/SQLiteDatabase:close	()V
    //   107: goto -36 -> 71
    //   110: aload_3
    //   111: monitorexit
    //   112: return
    //   113: aload_0
    //   114: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   117: ifnull +15 -> 132
    //   120: aload_0
    //   121: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   124: invokevirtual 327	android/database/sqlite/SQLiteDatabase:close	()V
    //   127: aload_0
    //   128: aconst_null
    //   129: putfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   132: aload_1
    //   133: athrow
    //   134: astore_1
    //   135: aload_3
    //   136: monitorexit
    //   137: aload_1
    //   138: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	go
    //   0	139	1	paramString	String
    //   0	139	2	paramClass	Class<T>
    //   4	132	3	localgn	gn
    // Exception table:
    //   from	to	target	type
    //   46	57	79	finally
    //   84	93	79	finally
    //   46	57	83	java/lang/Throwable
    //   7	26	134	finally
    //   27	45	134	finally
    //   57	71	134	finally
    //   71	76	134	finally
    //   93	107	134	finally
    //   110	112	134	finally
    //   113	132	134	finally
    //   132	134	134	finally
    //   135	137	134	finally
  }
  
  public <T> void a(String paramString, Object paramObject)
  {
    a(paramString, paramObject, false);
  }
  
  /* Error */
  public <T> void a(String paramString, Object paramObject, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	com/amap/api/mapcore/util/go:c	Lcom/amap/api/mapcore/util/gn;
    //   4: astore 4
    //   6: aload 4
    //   8: monitorenter
    //   9: aload_2
    //   10: ifnonnull +7 -> 17
    //   13: aload 4
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: aload_2
    //   19: invokevirtual 61	java/lang/Object:getClass	()Ljava/lang/Class;
    //   22: invokespecial 255	com/amap/api/mapcore/util/go:b	(Ljava/lang/Class;)Lcom/amap/api/mapcore/util/gp;
    //   25: astore 6
    //   27: aload_0
    //   28: aload 6
    //   30: invokespecial 257	com/amap/api/mapcore/util/go:a	(Lcom/amap/api/mapcore/util/gp;)Ljava/lang/String;
    //   33: astore 5
    //   35: aload 5
    //   37: invokestatic 263	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   40: ifeq +7 -> 47
    //   43: aload 4
    //   45: monitorexit
    //   46: return
    //   47: aload_0
    //   48: aload_2
    //   49: aload 6
    //   51: invokespecial 265	com/amap/api/mapcore/util/go:a	(Ljava/lang/Object;Lcom/amap/api/mapcore/util/gp;)Landroid/content/ContentValues;
    //   54: astore_2
    //   55: aload_2
    //   56: ifnonnull +7 -> 63
    //   59: aload 4
    //   61: monitorexit
    //   62: return
    //   63: aload_0
    //   64: aload_0
    //   65: iload_3
    //   66: invokespecial 380	com/amap/api/mapcore/util/go:b	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   69: putfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   72: aload_0
    //   73: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   76: ifnonnull +7 -> 83
    //   79: aload 4
    //   81: monitorexit
    //   82: return
    //   83: aload_0
    //   84: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   87: aload 5
    //   89: aload_2
    //   90: aload_1
    //   91: aconst_null
    //   92: invokevirtual 401	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   95: pop
    //   96: aload_0
    //   97: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   100: ifnull +60 -> 160
    //   103: aload_0
    //   104: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   107: invokevirtual 327	android/database/sqlite/SQLiteDatabase:close	()V
    //   110: aload_0
    //   111: aconst_null
    //   112: putfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   115: goto +45 -> 160
    //   118: astore_1
    //   119: goto +45 -> 164
    //   122: astore_1
    //   123: iload_3
    //   124: ifne +15 -> 139
    //   127: aload_1
    //   128: ldc 87
    //   130: ldc_w 403
    //   133: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   136: goto +7 -> 143
    //   139: aload_1
    //   140: invokevirtual 51	java/lang/Throwable:printStackTrace	()V
    //   143: aload_0
    //   144: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   147: ifnull +13 -> 160
    //   150: aload_0
    //   151: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   154: invokevirtual 327	android/database/sqlite/SQLiteDatabase:close	()V
    //   157: goto -47 -> 110
    //   160: aload 4
    //   162: monitorexit
    //   163: return
    //   164: aload_0
    //   165: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   168: ifnull +15 -> 183
    //   171: aload_0
    //   172: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   175: invokevirtual 327	android/database/sqlite/SQLiteDatabase:close	()V
    //   178: aload_0
    //   179: aconst_null
    //   180: putfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   183: aload_1
    //   184: athrow
    //   185: aload 4
    //   187: monitorexit
    //   188: aload_1
    //   189: athrow
    //   190: astore_1
    //   191: goto -6 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	go
    //   0	194	1	paramString	String
    //   0	194	2	paramObject	Object
    //   0	194	3	paramBoolean	boolean
    //   4	182	4	localgn	gn
    //   33	55	5	str	String
    //   25	25	6	localgp	gp
    // Exception table:
    //   from	to	target	type
    //   83	96	118	finally
    //   127	136	118	finally
    //   139	143	118	finally
    //   83	96	122	java/lang/Throwable
    //   13	16	190	finally
    //   17	46	190	finally
    //   47	55	190	finally
    //   59	62	190	finally
    //   63	82	190	finally
    //   96	110	190	finally
    //   110	115	190	finally
    //   143	157	190	finally
    //   160	163	190	finally
    //   164	183	190	finally
    //   183	185	190	finally
    //   185	188	190	finally
  }
  
  /* Error */
  public <T> void a(List<T> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	com/amap/api/mapcore/util/go:c	Lcom/amap/api/mapcore/util/gn;
    //   4: astore_2
    //   5: aload_2
    //   6: monitorenter
    //   7: aload_1
    //   8: ifnull +264 -> 272
    //   11: aload_1
    //   12: invokeinterface 373 1 0
    //   17: ifne +6 -> 23
    //   20: goto +252 -> 272
    //   23: aload_0
    //   24: aload_0
    //   25: iconst_0
    //   26: invokespecial 380	com/amap/api/mapcore/util/go:b	(Z)Landroid/database/sqlite/SQLiteDatabase;
    //   29: putfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   32: aload_0
    //   33: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   36: ifnonnull +6 -> 42
    //   39: aload_2
    //   40: monitorexit
    //   41: return
    //   42: aload_0
    //   43: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   46: invokevirtual 408	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   49: aload_1
    //   50: invokeinterface 409 1 0
    //   55: astore_1
    //   56: aload_1
    //   57: invokeinterface 232 1 0
    //   62: ifeq +22 -> 84
    //   65: aload_1
    //   66: invokeinterface 235 1 0
    //   71: astore_3
    //   72: aload_0
    //   73: aload_0
    //   74: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   77: aload_3
    //   78: invokespecial 382	com/amap/api/mapcore/util/go:a	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/Object;)V
    //   81: goto -25 -> 56
    //   84: aload_0
    //   85: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   88: invokevirtual 412	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   91: aload_0
    //   92: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   95: invokevirtual 415	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   98: ifeq +23 -> 121
    //   101: aload_0
    //   102: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   105: invokevirtual 418	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   108: goto +13 -> 121
    //   111: astore_1
    //   112: aload_1
    //   113: ldc 87
    //   115: ldc_w 420
    //   118: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   121: aload_0
    //   122: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   125: invokevirtual 327	android/database/sqlite/SQLiteDatabase:close	()V
    //   128: aload_0
    //   129: aconst_null
    //   130: putfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   133: goto +79 -> 212
    //   136: astore_1
    //   137: aload_1
    //   138: ldc 87
    //   140: ldc_w 420
    //   143: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   146: goto +66 -> 212
    //   149: astore_1
    //   150: goto +65 -> 215
    //   153: astore_1
    //   154: aload_1
    //   155: ldc 87
    //   157: ldc_w 420
    //   160: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   163: aload_0
    //   164: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   167: invokevirtual 415	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   170: ifeq +23 -> 193
    //   173: aload_0
    //   174: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   177: invokevirtual 418	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   180: goto +13 -> 193
    //   183: astore_1
    //   184: aload_1
    //   185: ldc 87
    //   187: ldc_w 420
    //   190: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   193: aload_0
    //   194: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   197: invokevirtual 327	android/database/sqlite/SQLiteDatabase:close	()V
    //   200: aload_0
    //   201: aconst_null
    //   202: putfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   205: goto +7 -> 212
    //   208: astore_1
    //   209: goto -72 -> 137
    //   212: aload_2
    //   213: monitorexit
    //   214: return
    //   215: aload_0
    //   216: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   219: invokevirtual 415	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   222: ifeq +23 -> 245
    //   225: aload_0
    //   226: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   229: invokevirtual 418	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   232: goto +13 -> 245
    //   235: astore_3
    //   236: aload_3
    //   237: ldc 87
    //   239: ldc_w 420
    //   242: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   245: aload_0
    //   246: getfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   249: invokevirtual 327	android/database/sqlite/SQLiteDatabase:close	()V
    //   252: aload_0
    //   253: aconst_null
    //   254: putfield 81	com/amap/api/mapcore/util/go:b	Landroid/database/sqlite/SQLiteDatabase;
    //   257: goto +13 -> 270
    //   260: astore_3
    //   261: aload_3
    //   262: ldc 87
    //   264: ldc_w 420
    //   267: invokestatic 94	com/amap/api/mapcore/util/gg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   270: aload_1
    //   271: athrow
    //   272: aload_2
    //   273: monitorexit
    //   274: return
    //   275: aload_2
    //   276: monitorexit
    //   277: aload_1
    //   278: athrow
    //   279: astore_1
    //   280: goto -5 -> 275
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	this	go
    //   0	283	1	paramList	List<T>
    //   4	272	2	localgn	gn
    //   71	7	3	localObject	Object
    //   235	2	3	localThrowable1	Throwable
    //   260	2	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   91	108	111	java/lang/Throwable
    //   121	133	136	java/lang/Throwable
    //   42	56	149	finally
    //   56	81	149	finally
    //   84	91	149	finally
    //   154	163	149	finally
    //   42	56	153	java/lang/Throwable
    //   56	81	153	java/lang/Throwable
    //   84	91	153	java/lang/Throwable
    //   163	180	183	java/lang/Throwable
    //   193	205	208	java/lang/Throwable
    //   215	232	235	java/lang/Throwable
    //   245	257	260	java/lang/Throwable
    //   11	20	279	finally
    //   23	41	279	finally
    //   91	108	279	finally
    //   112	121	279	finally
    //   121	133	279	finally
    //   137	146	279	finally
    //   163	180	279	finally
    //   184	193	279	finally
    //   193	205	279	finally
    //   212	214	279	finally
    //   215	232	279	finally
    //   236	245	279	finally
    //   245	257	279	finally
    //   261	270	279	finally
    //   270	272	279	finally
    //   272	274	279	finally
    //   275	277	279	finally
  }
  
  public <T> List<T> b(String paramString, Class<T> paramClass)
  {
    return a(paramString, paramClass, false);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\go.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */