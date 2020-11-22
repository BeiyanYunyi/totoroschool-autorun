package com.loc;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationClientOption.GeoLanguage;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public final class cw
{
  Hashtable<String, ArrayList<a>> a = new Hashtable();
  boolean b = true;
  long c = 0L;
  String d = null;
  cr e = null;
  boolean f = true;
  boolean g = true;
  String h = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);
  private long i = 0L;
  private boolean j = false;
  private String k = "2.0.201501131131".replace(".", "");
  private String l = null;
  private String m = null;
  private long n = 0L;
  
  private co a(String paramString, StringBuilder paramStringBuilder)
  {
    for (;;)
    {
      try
      {
        if (paramString.contains("cgiwifi"))
        {
          paramStringBuilder = a(paramStringBuilder, paramString);
        }
        else
        {
          if (paramString.contains("wifi")) {
            continue;
          }
          if ((!paramString.contains("cgi")) || (!this.a.containsKey(paramString)) || (((ArrayList)this.a.get(paramString)).size() <= 0)) {
            break label199;
          }
          paramStringBuilder = (a)((ArrayList)this.a.get(paramString)).get(0);
        }
        if ((paramStringBuilder != null) && (dn.a(paramStringBuilder.a())))
        {
          co localco = paramStringBuilder.a();
          localco.e("mem");
          localco.h(paramStringBuilder.b());
          if (df.b(localco.getTime()))
          {
            if (dn.a(localco)) {
              this.c = 0L;
            }
            localco.setLocationType(4);
            return localco;
          }
          if ((this.a != null) && (this.a.containsKey(paramString)))
          {
            ((ArrayList)this.a.get(paramString)).remove(paramStringBuilder);
            return null;
          }
        }
      }
      catch (Throwable paramString)
      {
        dg.a(paramString, "Cache", "get1");
      }
      return null;
      label199:
      paramStringBuilder = null;
    }
  }
  
  private a a(StringBuilder paramStringBuilder, String paramString)
  {
    if ((!this.a.isEmpty()) && (!TextUtils.isEmpty(paramStringBuilder)))
    {
      if (!this.a.containsKey(paramString)) {
        return null;
      }
      Hashtable localHashtable1 = new Hashtable();
      Hashtable localHashtable2 = new Hashtable();
      Hashtable localHashtable3 = new Hashtable();
      ArrayList localArrayList = (ArrayList)this.a.get(paramString);
      int i1 = localArrayList.size() - 1;
      while (i1 >= 0)
      {
        a locala = (a)localArrayList.get(i1);
        if (!TextUtils.isEmpty(locala.b()))
        {
          paramString = locala.b();
          if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(paramStringBuilder)) && (paramString.contains(",access")) && (paramStringBuilder.indexOf(",access") != -1))
          {
            paramString = paramString.split(",access");
            if (paramString[0].contains("#")) {
              paramString = paramString[0].substring(paramString[0].lastIndexOf("#") + 1);
            } else {
              paramString = paramString[0];
            }
            if (!TextUtils.isEmpty(paramString))
            {
              localObject1 = paramStringBuilder.toString();
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(paramString);
              ((StringBuilder)localObject2).append(",access");
              bool = ((String)localObject1).contains(((StringBuilder)localObject2).toString());
              break label255;
            }
          }
          boolean bool = false;
          label255:
          int i2;
          if (bool)
          {
            if (dn.a(locala.b(), paramStringBuilder.toString())) {
              break label570;
            }
            i2 = 1;
          }
          else
          {
            i2 = 0;
          }
          a(locala.b(), localHashtable1);
          a(paramStringBuilder.toString(), localHashtable2);
          localHashtable3.clear();
          paramString = localHashtable1.keySet().iterator();
          while (paramString.hasNext()) {
            localHashtable3.put((String)paramString.next(), "");
          }
          paramString = localHashtable2.keySet().iterator();
          while (paramString.hasNext()) {
            localHashtable3.put((String)paramString.next(), "");
          }
          paramString = localHashtable3.keySet();
          Object localObject1 = new double[paramString.size()];
          Object localObject2 = new double[paramString.size()];
          Iterator localIterator = paramString.iterator();
          int i3 = 0;
          while ((localIterator != null) && (localIterator.hasNext()))
          {
            String str = (String)localIterator.next();
            bool = localHashtable1.containsKey(str);
            double d2 = 0.0D;
            if (bool) {
              d1 = 1.0D;
            } else {
              d1 = 0.0D;
            }
            localObject1[i3] = d1;
            double d1 = d2;
            if (localHashtable2.containsKey(str)) {
              d1 = 1.0D;
            }
            localObject2[i3] = d1;
            i3 += 1;
          }
          paramString.clear();
          paramString = a((double[])localObject1, (double[])localObject2);
          if ((paramString[0] >= 0.800000011920929D) || (paramString[1] >= 0.618D) || ((i2 != 0) && (paramString[0] >= 0.618D)))
          {
            label570:
            paramStringBuilder = locala;
            break label587;
          }
        }
        i1 -= 1;
      }
      paramStringBuilder = null;
      label587:
      localHashtable1.clear();
      localHashtable2.clear();
      localHashtable3.clear();
      return paramStringBuilder;
    }
    return null;
  }
  
  private String a(String paramString, StringBuilder paramStringBuilder, Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        if (this.l == null) {
          this.l = cv.a("MD5", l.c(paramContext));
        }
        paramContext = paramString;
        if (paramString.contains("&")) {
          paramContext = paramString.substring(0, paramString.indexOf("&"));
        }
        paramString = paramContext.substring(paramContext.lastIndexOf("#") + 1);
        if (paramString.equals("cgi"))
        {
          paramStringBuilder = "cgi";
          paramString = paramContext.substring(0, paramContext.length() - 12);
          localJSONObject.put(paramStringBuilder, paramString);
        }
        else if ((!TextUtils.isEmpty(paramStringBuilder)) && (paramStringBuilder.indexOf(",access") != -1))
        {
          int i1 = paramString.length();
          localJSONObject.put("cgi", paramContext.substring(0, paramContext.length() - (i1 + 9)));
          paramString = paramStringBuilder.toString().split(",access");
          if (!paramString[0].contains("#")) {
            break label232;
          }
          paramString = paramString[0].substring(paramString[0].lastIndexOf("#") + 1);
          paramStringBuilder = "mmac";
          continue;
        }
        paramString = cv.b(localJSONObject.toString().getBytes("UTF-8"), this.l);
        paramString = q.b(paramString);
        return paramString;
      }
      catch (Throwable|UnsupportedEncodingException paramString)
      {
        return null;
      }
      label232:
      paramString = paramString[0];
    }
  }
  
  /* Error */
  private void a(Context paramContext, String paramString)
    throws java.lang.Exception
  {
    // Byte code:
    //   0: invokestatic 295	com/loc/df:m	()Z
    //   3: ifne +4 -> 7
    //   6: return
    //   7: aload_1
    //   8: ifnonnull +4 -> 12
    //   11: return
    //   12: aconst_null
    //   13: astore 10
    //   15: aconst_null
    //   16: astore 11
    //   18: aload_1
    //   19: ldc_w 297
    //   22: iconst_0
    //   23: aconst_null
    //   24: invokevirtual 303	android/content/Context:openOrCreateDatabase	(Ljava/lang/String;ILandroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/sqlite/SQLiteDatabase;
    //   27: astore 7
    //   29: aload 10
    //   31: astore 9
    //   33: aload 7
    //   35: astore 8
    //   37: aload 7
    //   39: ldc_w 305
    //   42: invokestatic 308	com/loc/dn:a	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Z
    //   45: ifne +38 -> 83
    //   48: aload 7
    //   50: ifnull +1198 -> 1248
    //   53: aload 10
    //   55: astore 9
    //   57: aload 7
    //   59: astore 8
    //   61: aload 7
    //   63: invokevirtual 313	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   66: ifeq +1182 -> 1248
    //   69: aload 10
    //   71: astore 9
    //   73: aload 7
    //   75: astore 8
    //   77: aload 7
    //   79: invokevirtual 316	android/database/sqlite/SQLiteDatabase:close	()V
    //   82: return
    //   83: aload 10
    //   85: astore 9
    //   87: aload 7
    //   89: astore 8
    //   91: new 174	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   98: astore 12
    //   100: aload 10
    //   102: astore 9
    //   104: aload 7
    //   106: astore 8
    //   108: aload 12
    //   110: ldc_w 318
    //   113: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload 10
    //   119: astore 9
    //   121: aload 7
    //   123: astore 8
    //   125: aload 12
    //   127: ldc_w 305
    //   130: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload 10
    //   136: astore 9
    //   138: aload 7
    //   140: astore 8
    //   142: aload 12
    //   144: aload_0
    //   145: getfield 53	com/loc/cw:k	Ljava/lang/String;
    //   148: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload 10
    //   154: astore 9
    //   156: aload 7
    //   158: astore 8
    //   160: invokestatic 320	com/loc/dn:a	()J
    //   163: lstore_3
    //   164: aload 10
    //   166: astore 9
    //   168: aload 7
    //   170: astore 8
    //   172: invokestatic 322	com/loc/df:l	()J
    //   175: lstore 5
    //   177: aload 10
    //   179: astore 9
    //   181: aload 7
    //   183: astore 8
    //   185: aload 12
    //   187: ldc_w 324
    //   190: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload 10
    //   196: astore 9
    //   198: aload 7
    //   200: astore 8
    //   202: aload 12
    //   204: lload_3
    //   205: lload 5
    //   207: lsub
    //   208: invokevirtual 327	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload_2
    //   213: ifnull +88 -> 301
    //   216: aload 10
    //   218: astore 9
    //   220: aload 7
    //   222: astore 8
    //   224: aload 12
    //   226: ldc_w 329
    //   229: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload 10
    //   235: astore 9
    //   237: aload 7
    //   239: astore 8
    //   241: new 174	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   248: astore 13
    //   250: aload 10
    //   252: astore 9
    //   254: aload 7
    //   256: astore 8
    //   258: aload 13
    //   260: aload_2
    //   261: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload 10
    //   267: astore 9
    //   269: aload 7
    //   271: astore 8
    //   273: aload 13
    //   275: ldc_w 331
    //   278: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload 10
    //   284: astore 9
    //   286: aload 7
    //   288: astore 8
    //   290: aload 12
    //   292: aload 13
    //   294: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload 10
    //   303: astore 9
    //   305: aload 7
    //   307: astore 8
    //   309: aload 12
    //   311: ldc_w 333
    //   314: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload 10
    //   320: astore 9
    //   322: aload 7
    //   324: astore 8
    //   326: aload 7
    //   328: aload 12
    //   330: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: aconst_null
    //   334: invokevirtual 337	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   337: astore 10
    //   339: new 174	java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   346: astore 13
    //   348: aload_0
    //   349: getfield 55	com/loc/cw:l	Ljava/lang/String;
    //   352: ifnonnull +16 -> 368
    //   355: aload_0
    //   356: ldc -8
    //   358: aload_1
    //   359: invokestatic 253	com/loc/l:c	(Landroid/content/Context;)Ljava/lang/String;
    //   362: invokestatic 258	com/loc/cv:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   365: putfield 55	com/loc/cw:l	Ljava/lang/String;
    //   368: aload 10
    //   370: ifnull +726 -> 1096
    //   373: aload 10
    //   375: invokeinterface 342 1 0
    //   380: ifeq +716 -> 1096
    //   383: aload 10
    //   385: iconst_0
    //   386: invokeinterface 345 2 0
    //   391: ldc_w 347
    //   394: invokevirtual 351	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   397: ifeq +161 -> 558
    //   400: new 245	org/json/JSONObject
    //   403: dup
    //   404: aload 10
    //   406: iconst_0
    //   407: invokeinterface 345 2 0
    //   412: invokespecial 353	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   415: astore 9
    //   417: aload 13
    //   419: iconst_0
    //   420: aload 13
    //   422: invokevirtual 354	java/lang/StringBuilder:length	()I
    //   425: invokevirtual 358	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload 10
    //   431: iconst_1
    //   432: invokeinterface 345 2 0
    //   437: invokestatic 170	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   440: ifne +22 -> 462
    //   443: aload 10
    //   445: iconst_1
    //   446: invokeinterface 345 2 0
    //   451: astore_2
    //   452: aload 13
    //   454: aload_2
    //   455: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: goto +42 -> 501
    //   462: aload 9
    //   464: ldc_w 275
    //   467: invokestatic 361	com/loc/dn:a	(Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   470: ifeq +31 -> 501
    //   473: aload 13
    //   475: ldc -72
    //   477: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: pop
    //   481: aload 13
    //   483: aload 9
    //   485: ldc_w 275
    //   488: invokevirtual 364	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   491: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: pop
    //   495: ldc -84
    //   497: astore_2
    //   498: goto -46 -> 452
    //   501: new 245	org/json/JSONObject
    //   504: dup
    //   505: aload 10
    //   507: iconst_2
    //   508: invokeinterface 345 2 0
    //   513: invokespecial 353	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   516: astore 11
    //   518: aload 9
    //   520: astore_2
    //   521: aload 11
    //   523: astore 8
    //   525: aload 11
    //   527: ldc_w 366
    //   530: invokestatic 361	com/loc/dn:a	(Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   533: ifeq +226 -> 759
    //   536: aload 11
    //   538: ldc_w 366
    //   541: ldc_w 368
    //   544: invokevirtual 273	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   547: pop
    //   548: aload 9
    //   550: astore_2
    //   551: aload 11
    //   553: astore 8
    //   555: goto +204 -> 759
    //   558: new 245	org/json/JSONObject
    //   561: dup
    //   562: new 47	java/lang/String
    //   565: dup
    //   566: aload 10
    //   568: iconst_0
    //   569: invokeinterface 345 2 0
    //   574: invokestatic 370	com/loc/q:b	(Ljava/lang/String;)[B
    //   577: aload_0
    //   578: getfield 55	com/loc/cw:l	Ljava/lang/String;
    //   581: invokestatic 372	com/loc/cv:c	([BLjava/lang/String;)[B
    //   584: ldc_w 278
    //   587: invokespecial 375	java/lang/String:<init>	([BLjava/lang/String;)V
    //   590: invokespecial 353	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   593: astore_2
    //   594: aload 13
    //   596: iconst_0
    //   597: aload 13
    //   599: invokevirtual 354	java/lang/StringBuilder:length	()I
    //   602: invokevirtual 358	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   605: pop
    //   606: aload 10
    //   608: iconst_1
    //   609: invokeinterface 345 2 0
    //   614: invokestatic 170	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   617: ifne +40 -> 657
    //   620: aload 13
    //   622: new 47	java/lang/String
    //   625: dup
    //   626: aload 10
    //   628: iconst_1
    //   629: invokeinterface 345 2 0
    //   634: invokestatic 370	com/loc/q:b	(Ljava/lang/String;)[B
    //   637: aload_0
    //   638: getfield 55	com/loc/cw:l	Ljava/lang/String;
    //   641: invokestatic 372	com/loc/cv:c	([BLjava/lang/String;)[B
    //   644: ldc_w 278
    //   647: invokespecial 375	java/lang/String:<init>	([BLjava/lang/String;)V
    //   650: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: pop
    //   654: goto +42 -> 696
    //   657: aload_2
    //   658: ldc_w 275
    //   661: invokestatic 361	com/loc/dn:a	(Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   664: ifeq +32 -> 696
    //   667: aload 13
    //   669: ldc -72
    //   671: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: pop
    //   675: aload 13
    //   677: aload_2
    //   678: ldc_w 275
    //   681: invokevirtual 364	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   684: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: pop
    //   688: aload 13
    //   690: ldc -84
    //   692: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: pop
    //   696: new 245	org/json/JSONObject
    //   699: dup
    //   700: new 47	java/lang/String
    //   703: dup
    //   704: aload 10
    //   706: iconst_2
    //   707: invokeinterface 345 2 0
    //   712: invokestatic 370	com/loc/q:b	(Ljava/lang/String;)[B
    //   715: aload_0
    //   716: getfield 55	com/loc/cw:l	Ljava/lang/String;
    //   719: invokestatic 372	com/loc/cv:c	([BLjava/lang/String;)[B
    //   722: ldc_w 278
    //   725: invokespecial 375	java/lang/String:<init>	([BLjava/lang/String;)V
    //   728: invokespecial 353	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   731: astore 8
    //   733: aload 8
    //   735: ldc_w 366
    //   738: invokestatic 361	com/loc/dn:a	(Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   741: ifeq +508 -> 1249
    //   744: aload 8
    //   746: ldc_w 366
    //   749: ldc_w 368
    //   752: invokevirtual 273	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   755: pop
    //   756: goto +493 -> 1249
    //   759: new 129	com/loc/co
    //   762: dup
    //   763: ldc 45
    //   765: invokespecial 376	com/loc/co:<init>	(Ljava/lang/String;)V
    //   768: astore 9
    //   770: aload 9
    //   772: aload 8
    //   774: invokevirtual 379	com/loc/co:b	(Lorg/json/JSONObject;)V
    //   777: aload_2
    //   778: ldc_w 275
    //   781: invokestatic 361	com/loc/dn:a	(Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   784: ifeq +150 -> 934
    //   787: aload_2
    //   788: ldc 100
    //   790: invokestatic 361	com/loc/dn:a	(Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   793: ifeq +141 -> 934
    //   796: new 174	java/lang/StringBuilder
    //   799: dup
    //   800: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   803: astore 8
    //   805: aload 8
    //   807: aload_2
    //   808: ldc 100
    //   810: invokevirtual 364	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   813: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: pop
    //   817: aload 8
    //   819: ldc -72
    //   821: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: pop
    //   825: aload 8
    //   827: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   830: astore 8
    //   832: new 174	java/lang/StringBuilder
    //   835: dup
    //   836: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   839: astore 11
    //   841: aload 11
    //   843: aload 8
    //   845: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: pop
    //   849: aload 11
    //   851: ldc_w 381
    //   854: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: pop
    //   858: aload 11
    //   860: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   863: astore 8
    //   865: aload_2
    //   866: ldc 100
    //   868: invokevirtual 364	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   871: ldc -72
    //   873: invokevirtual 93	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   876: ifeq +33 -> 909
    //   879: new 174	java/lang/StringBuilder
    //   882: dup
    //   883: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   886: astore_2
    //   887: aload_2
    //   888: aload 8
    //   890: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   893: pop
    //   894: aload_2
    //   895: ldc 89
    //   897: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   900: pop
    //   901: aload_2
    //   902: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   905: astore_2
    //   906: goto +145 -> 1051
    //   909: new 174	java/lang/StringBuilder
    //   912: dup
    //   913: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   916: astore_2
    //   917: aload_2
    //   918: aload 8
    //   920: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   923: pop
    //   924: aload_2
    //   925: ldc 98
    //   927: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   930: pop
    //   931: goto -30 -> 901
    //   934: aload_2
    //   935: ldc 100
    //   937: invokestatic 361	com/loc/dn:a	(Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   940: ifeq +122 -> 1062
    //   943: new 174	java/lang/StringBuilder
    //   946: dup
    //   947: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   950: astore 8
    //   952: aload 8
    //   954: aload_2
    //   955: ldc 100
    //   957: invokevirtual 364	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   960: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   963: pop
    //   964: aload 8
    //   966: ldc -72
    //   968: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   971: pop
    //   972: aload 8
    //   974: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   977: astore 8
    //   979: new 174	java/lang/StringBuilder
    //   982: dup
    //   983: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   986: astore 11
    //   988: aload 11
    //   990: aload 8
    //   992: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   995: pop
    //   996: aload 11
    //   998: ldc_w 381
    //   1001: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1004: pop
    //   1005: aload 11
    //   1007: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1010: astore 8
    //   1012: aload_2
    //   1013: ldc 100
    //   1015: invokevirtual 364	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1018: ldc -72
    //   1020: invokevirtual 93	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1023: ifeq +39 -> 1062
    //   1026: new 174	java/lang/StringBuilder
    //   1029: dup
    //   1030: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   1033: astore_2
    //   1034: aload_2
    //   1035: aload 8
    //   1037: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1040: pop
    //   1041: aload_2
    //   1042: ldc 100
    //   1044: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1047: pop
    //   1048: goto -147 -> 901
    //   1051: aload_0
    //   1052: aload_2
    //   1053: aload 13
    //   1055: aload 9
    //   1057: aload_1
    //   1058: iconst_0
    //   1059: invokevirtual 384	com/loc/cw:a	(Ljava/lang/String;Ljava/lang/StringBuilder;Lcom/loc/co;Landroid/content/Context;Z)V
    //   1062: aload 10
    //   1064: invokeinterface 387 1 0
    //   1069: ifne -686 -> 383
    //   1072: aload 13
    //   1074: iconst_0
    //   1075: aload 13
    //   1077: invokevirtual 354	java/lang/StringBuilder:length	()I
    //   1080: invokevirtual 358	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   1083: pop
    //   1084: aload 12
    //   1086: iconst_0
    //   1087: aload 12
    //   1089: invokevirtual 354	java/lang/StringBuilder:length	()I
    //   1092: invokevirtual 358	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   1095: pop
    //   1096: aload 10
    //   1098: ifnull +10 -> 1108
    //   1101: aload 10
    //   1103: invokeinterface 388 1 0
    //   1108: aload 7
    //   1110: ifnull +16 -> 1126
    //   1113: aload 7
    //   1115: invokevirtual 313	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   1118: ifeq +8 -> 1126
    //   1121: aload 7
    //   1123: invokevirtual 316	android/database/sqlite/SQLiteDatabase:close	()V
    //   1126: return
    //   1127: astore_1
    //   1128: aload 10
    //   1130: astore_2
    //   1131: goto +87 -> 1218
    //   1134: astore_2
    //   1135: aload 10
    //   1137: astore_1
    //   1138: goto +26 -> 1164
    //   1141: astore_2
    //   1142: aload 11
    //   1144: astore_1
    //   1145: goto +19 -> 1164
    //   1148: astore_1
    //   1149: aconst_null
    //   1150: astore_2
    //   1151: aload_2
    //   1152: astore 7
    //   1154: goto +64 -> 1218
    //   1157: astore_2
    //   1158: aconst_null
    //   1159: astore 7
    //   1161: aload 11
    //   1163: astore_1
    //   1164: aload_1
    //   1165: astore 9
    //   1167: aload 7
    //   1169: astore 8
    //   1171: aload_2
    //   1172: ldc_w 390
    //   1175: ldc_w 392
    //   1178: invokestatic 162	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   1181: aload_1
    //   1182: ifnull +9 -> 1191
    //   1185: aload_1
    //   1186: invokeinterface 388 1 0
    //   1191: aload 7
    //   1193: ifnull +16 -> 1209
    //   1196: aload 7
    //   1198: invokevirtual 313	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   1201: ifeq +8 -> 1209
    //   1204: aload 7
    //   1206: invokevirtual 316	android/database/sqlite/SQLiteDatabase:close	()V
    //   1209: return
    //   1210: astore_1
    //   1211: aload 9
    //   1213: astore_2
    //   1214: aload 8
    //   1216: astore 7
    //   1218: aload_2
    //   1219: ifnull +9 -> 1228
    //   1222: aload_2
    //   1223: invokeinterface 388 1 0
    //   1228: aload 7
    //   1230: ifnull +16 -> 1246
    //   1233: aload 7
    //   1235: invokevirtual 313	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   1238: ifeq +8 -> 1246
    //   1241: aload 7
    //   1243: invokevirtual 316	android/database/sqlite/SQLiteDatabase:close	()V
    //   1246: aload_1
    //   1247: athrow
    //   1248: return
    //   1249: goto -490 -> 759
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1252	0	this	cw
    //   0	1252	1	paramContext	Context
    //   0	1252	2	paramString	String
    //   163	42	3	l1	long
    //   175	31	5	l2	long
    //   27	1215	7	localObject1	Object
    //   35	1180	8	localObject2	Object
    //   31	1181	9	localObject3	Object
    //   13	1123	10	localCursor	android.database.Cursor
    //   16	1146	11	localObject4	Object
    //   98	990	12	localStringBuilder1	StringBuilder
    //   248	828	13	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   339	368	1127	finally
    //   373	383	1127	finally
    //   383	452	1127	finally
    //   452	459	1127	finally
    //   462	495	1127	finally
    //   501	518	1127	finally
    //   525	548	1127	finally
    //   558	654	1127	finally
    //   657	696	1127	finally
    //   696	756	1127	finally
    //   759	901	1127	finally
    //   901	906	1127	finally
    //   909	931	1127	finally
    //   934	1048	1127	finally
    //   1051	1062	1127	finally
    //   1062	1096	1127	finally
    //   339	368	1134	java/lang/Throwable
    //   373	383	1134	java/lang/Throwable
    //   383	452	1134	java/lang/Throwable
    //   452	459	1134	java/lang/Throwable
    //   462	495	1134	java/lang/Throwable
    //   501	518	1134	java/lang/Throwable
    //   525	548	1134	java/lang/Throwable
    //   558	654	1134	java/lang/Throwable
    //   657	696	1134	java/lang/Throwable
    //   696	756	1134	java/lang/Throwable
    //   759	901	1134	java/lang/Throwable
    //   901	906	1134	java/lang/Throwable
    //   909	931	1134	java/lang/Throwable
    //   934	1048	1134	java/lang/Throwable
    //   1051	1062	1134	java/lang/Throwable
    //   1062	1096	1134	java/lang/Throwable
    //   37	48	1141	java/lang/Throwable
    //   61	69	1141	java/lang/Throwable
    //   77	82	1141	java/lang/Throwable
    //   91	100	1141	java/lang/Throwable
    //   108	117	1141	java/lang/Throwable
    //   125	134	1141	java/lang/Throwable
    //   142	152	1141	java/lang/Throwable
    //   160	164	1141	java/lang/Throwable
    //   172	177	1141	java/lang/Throwable
    //   185	194	1141	java/lang/Throwable
    //   202	212	1141	java/lang/Throwable
    //   224	233	1141	java/lang/Throwable
    //   241	250	1141	java/lang/Throwable
    //   258	265	1141	java/lang/Throwable
    //   273	282	1141	java/lang/Throwable
    //   290	301	1141	java/lang/Throwable
    //   309	318	1141	java/lang/Throwable
    //   326	339	1141	java/lang/Throwable
    //   18	29	1148	finally
    //   18	29	1157	java/lang/Throwable
    //   37	48	1210	finally
    //   61	69	1210	finally
    //   77	82	1210	finally
    //   91	100	1210	finally
    //   108	117	1210	finally
    //   125	134	1210	finally
    //   142	152	1210	finally
    //   160	164	1210	finally
    //   172	177	1210	finally
    //   185	194	1210	finally
    //   202	212	1210	finally
    //   224	233	1210	finally
    //   241	250	1210	finally
    //   258	265	1210	finally
    //   273	282	1210	finally
    //   290	301	1210	finally
    //   309	318	1210	finally
    //   326	339	1210	finally
    //   1171	1181	1210	finally
  }
  
  /* Error */
  private void a(String paramString, com.amap.api.location.AMapLocation paramAMapLocation, StringBuilder paramStringBuilder, Context paramContext)
    throws java.lang.Exception
  {
    // Byte code:
    //   0: aload 4
    //   2: ifnonnull +4 -> 6
    //   5: return
    //   6: aload_0
    //   7: getfield 55	com/loc/cw:l	Ljava/lang/String;
    //   10: ifnonnull +17 -> 27
    //   13: aload_0
    //   14: ldc -8
    //   16: aload 4
    //   18: invokestatic 253	com/loc/l:c	(Landroid/content/Context;)Ljava/lang/String;
    //   21: invokestatic 258	com/loc/cv:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   24: putfield 55	com/loc/cw:l	Ljava/lang/String;
    //   27: aload_0
    //   28: aload_1
    //   29: aload_3
    //   30: aload 4
    //   32: invokespecial 396	com/loc/cw:a	(Ljava/lang/String;Ljava/lang/StringBuilder;Landroid/content/Context;)Ljava/lang/String;
    //   35: astore 8
    //   37: new 174	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 195	java/lang/StringBuilder:<init>	()V
    //   44: astore 7
    //   46: aconst_null
    //   47: astore 6
    //   49: aconst_null
    //   50: astore_1
    //   51: aload 4
    //   53: ldc_w 297
    //   56: iconst_0
    //   57: aconst_null
    //   58: invokevirtual 303	android/content/Context:openOrCreateDatabase	(Ljava/lang/String;ILandroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/sqlite/SQLiteDatabase;
    //   61: astore 4
    //   63: aload 7
    //   65: ldc_w 398
    //   68: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 7
    //   74: aload_0
    //   75: getfield 53	com/loc/cw:k	Ljava/lang/String;
    //   78: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 7
    //   84: ldc_w 400
    //   87: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload 4
    //   93: aload 7
    //   95: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokevirtual 403	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   101: aload 7
    //   103: iconst_0
    //   104: aload 7
    //   106: invokevirtual 354	java/lang/StringBuilder:length	()I
    //   109: invokevirtual 358	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload 7
    //   115: ldc_w 405
    //   118: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload 7
    //   124: ldc_w 305
    //   127: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload 7
    //   133: aload_0
    //   134: getfield 53	com/loc/cw:k	Ljava/lang/String;
    //   137: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload 7
    //   143: ldc_w 407
    //   146: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: iconst_4
    //   151: anewarray 4	java/lang/Object
    //   154: astore_1
    //   155: aload_1
    //   156: iconst_0
    //   157: aload 8
    //   159: aastore
    //   160: aload_3
    //   161: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: ldc_w 278
    //   167: invokevirtual 282	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   170: aload_0
    //   171: getfield 55	com/loc/cw:l	Ljava/lang/String;
    //   174: invokestatic 285	com/loc/cv:b	([BLjava/lang/String;)[B
    //   177: astore_3
    //   178: iconst_1
    //   179: istore 5
    //   181: aload_1
    //   182: iconst_1
    //   183: aload_3
    //   184: aastore
    //   185: aload_1
    //   186: iconst_2
    //   187: aload_2
    //   188: invokevirtual 412	com/amap/api/location/AMapLocation:toStr	()Ljava/lang/String;
    //   191: ldc_w 278
    //   194: invokevirtual 282	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   197: aload_0
    //   198: getfield 55	com/loc/cw:l	Ljava/lang/String;
    //   201: invokestatic 285	com/loc/cv:b	([BLjava/lang/String;)[B
    //   204: aastore
    //   205: aload_1
    //   206: iconst_3
    //   207: aload_2
    //   208: invokevirtual 413	com/amap/api/location/AMapLocation:getTime	()J
    //   211: invokestatic 418	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   214: aastore
    //   215: iload 5
    //   217: iconst_3
    //   218: if_icmpge +29 -> 247
    //   221: aload_1
    //   222: iload 5
    //   224: aload_1
    //   225: iload 5
    //   227: aaload
    //   228: checkcast 420	[B
    //   231: checkcast 420	[B
    //   234: invokestatic 290	com/loc/q:b	([B)Ljava/lang/String;
    //   237: aastore
    //   238: iload 5
    //   240: iconst_1
    //   241: iadd
    //   242: istore 5
    //   244: goto -29 -> 215
    //   247: aload 4
    //   249: aload 7
    //   251: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: aload_1
    //   255: invokevirtual 423	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   258: aload 7
    //   260: iconst_0
    //   261: aload 7
    //   263: invokevirtual 354	java/lang/StringBuilder:length	()I
    //   266: invokevirtual 358	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: aload 7
    //   272: iconst_0
    //   273: aload 7
    //   275: invokevirtual 354	java/lang/StringBuilder:length	()I
    //   278: invokevirtual 358	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload 4
    //   284: ifnull +16 -> 300
    //   287: aload 4
    //   289: invokevirtual 313	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   292: ifeq +8 -> 300
    //   295: aload 4
    //   297: invokevirtual 316	android/database/sqlite/SQLiteDatabase:close	()V
    //   300: return
    //   301: astore_1
    //   302: aload 4
    //   304: astore_2
    //   305: goto +62 -> 367
    //   308: astore_3
    //   309: aload 4
    //   311: astore_2
    //   312: goto +15 -> 327
    //   315: astore_3
    //   316: aload_1
    //   317: astore_2
    //   318: aload_3
    //   319: astore_1
    //   320: goto +47 -> 367
    //   323: astore_3
    //   324: aload 6
    //   326: astore_2
    //   327: aload_2
    //   328: astore_1
    //   329: aload_3
    //   330: ldc_w 390
    //   333: ldc_w 425
    //   336: invokestatic 162	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   339: aload 7
    //   341: iconst_0
    //   342: aload 7
    //   344: invokevirtual 354	java/lang/StringBuilder:length	()I
    //   347: invokevirtual 358	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload_2
    //   352: ifnull +14 -> 366
    //   355: aload_2
    //   356: invokevirtual 313	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   359: ifeq +7 -> 366
    //   362: aload_2
    //   363: invokevirtual 316	android/database/sqlite/SQLiteDatabase:close	()V
    //   366: return
    //   367: aload 7
    //   369: iconst_0
    //   370: aload 7
    //   372: invokevirtual 354	java/lang/StringBuilder:length	()I
    //   375: invokevirtual 358	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload_2
    //   380: ifnull +14 -> 394
    //   383: aload_2
    //   384: invokevirtual 313	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   387: ifeq +7 -> 394
    //   390: aload_2
    //   391: invokevirtual 316	android/database/sqlite/SQLiteDatabase:close	()V
    //   394: aload_1
    //   395: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	396	0	this	cw
    //   0	396	1	paramString	String
    //   0	396	2	paramAMapLocation	com.amap.api.location.AMapLocation
    //   0	396	3	paramStringBuilder	StringBuilder
    //   0	396	4	paramContext	Context
    //   179	64	5	i1	int
    //   47	278	6	localObject	Object
    //   44	327	7	localStringBuilder	StringBuilder
    //   35	123	8	str	String
    // Exception table:
    //   from	to	target	type
    //   63	155	301	finally
    //   160	178	301	finally
    //   185	215	301	finally
    //   221	238	301	finally
    //   247	270	301	finally
    //   63	155	308	java/lang/Throwable
    //   160	178	308	java/lang/Throwable
    //   185	215	308	java/lang/Throwable
    //   221	238	308	java/lang/Throwable
    //   247	270	308	java/lang/Throwable
    //   51	63	315	finally
    //   329	339	315	finally
    //   51	63	323	java/lang/Throwable
  }
  
  private static void a(String paramString, Hashtable<String, String> paramHashtable)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramHashtable.clear();
    paramString = paramString.split("#");
    int i2 = paramString.length;
    int i1 = 0;
    while (i1 < i2)
    {
      CharSequence localCharSequence = paramString[i1];
      if ((!TextUtils.isEmpty(localCharSequence)) && (!localCharSequence.contains("|"))) {
        paramHashtable.put(localCharSequence, "");
      }
      i1 += 1;
    }
  }
  
  private static double[] a(double[] paramArrayOfDouble1, double[] paramArrayOfDouble2)
  {
    double[] arrayOfDouble = new double[3];
    int i6 = 0;
    double d3 = 0.0D;
    double d1 = d3;
    double d2 = d1;
    int i2 = 0;
    int i3 = 0;
    for (int i4 = 0; i2 < paramArrayOfDouble1.length; i4 = i1)
    {
      d3 += paramArrayOfDouble1[i2] * paramArrayOfDouble1[i2];
      d1 += paramArrayOfDouble2[i2] * paramArrayOfDouble2[i2];
      d2 += paramArrayOfDouble1[i2] * paramArrayOfDouble2[i2];
      int i5 = i3;
      i1 = i4;
      if (paramArrayOfDouble2[i2] == 1.0D)
      {
        i4 += 1;
        i5 = i3;
        i1 = i4;
        if (paramArrayOfDouble1[i2] == 1.0D)
        {
          i5 = i3 + 1;
          i1 = i4;
        }
      }
      i2 += 1;
      i3 = i5;
    }
    arrayOfDouble[0] = (d2 / (Math.sqrt(d3) * Math.sqrt(d1)));
    d1 = i3;
    Double.isNaN(d1);
    d2 = i4;
    Double.isNaN(d2);
    arrayOfDouble[1] = (d1 * 1.0D / d2);
    arrayOfDouble[2] = d1;
    int i1 = i6;
    while (i1 < 2)
    {
      if (arrayOfDouble[i1] > 1.0D) {
        arrayOfDouble[i1] = 1.0D;
      }
      i1 += 1;
    }
    return arrayOfDouble;
  }
  
  private boolean b()
  {
    long l1 = dn.b();
    long l2 = this.i;
    long l3 = this.i;
    boolean bool = false;
    if (l3 == 0L) {
      return false;
    }
    if ((this.a.size() > 360) || (l1 - l2 > 36000000L)) {
      bool = true;
    }
    return bool;
  }
  
  private void c()
  {
    this.i = 0L;
    if (!this.a.isEmpty()) {
      this.a.clear();
    }
    this.j = false;
  }
  
  public final co a(Context paramContext, String paramString, StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (!df.m()) {
      return null;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("&");
    ((StringBuilder)localObject).append(this.f);
    ((StringBuilder)localObject).append("&");
    ((StringBuilder)localObject).append(this.g);
    ((StringBuilder)localObject).append("&");
    ((StringBuilder)localObject).append(this.h);
    paramString = ((StringBuilder)localObject).toString();
    if ((!paramString.contains("gps")) && (df.m()))
    {
      if (paramStringBuilder == null) {
        return null;
      }
      if (b())
      {
        c();
        return null;
      }
      if ((!paramBoolean) || (this.j)) {}
    }
    try
    {
      localObject = a(paramString, paramStringBuilder, paramContext);
      c();
      a(paramContext, (String)localObject);
    }
    catch (Throwable paramContext)
    {
      for (;;) {}
    }
    if (this.a.isEmpty()) {
      return null;
    }
    return a(paramString, paramStringBuilder);
    return null;
  }
  
  public final co a(cs paramcs, boolean paramBoolean1, co paramco, cu paramcu, StringBuilder paramStringBuilder, String paramString, Context paramContext, boolean paramBoolean2)
  {
    boolean bool = this.b;
    int i3 = 0;
    if ((bool) && ((df.m()) || (paramBoolean2))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 == 0) {}
    while ((paramco != null) && ((!df.b(paramco.getTime())) || (paramBoolean2)))
    {
      i1 = 0;
      break;
    }
    int i1 = 1;
    if (i1 == 0) {
      return null;
    }
    try
    {
      paramcs = paramcs.c();
      if ((paramcs == null) && (this.e == null)) {
        break label447;
      }
      if (this.e == null) {
        break label453;
      }
      if (this.e.equals(paramcs)) {
        break label447;
      }
    }
    catch (Throwable paramcs)
    {
      for (;;)
      {
        long l1;
        label352:
        continue;
        label447:
        int i2 = 0;
        continue;
        label453:
        i2 = 1;
        continue;
        i1 = 0;
        continue;
        label465:
        i2 = 0;
        if (!bool)
        {
          paramBoolean2 = bool;
          if (i2 != 0)
          {
            continue;
            label485:
            paramBoolean2 = false;
          }
        }
      }
      label491:
      return null;
    }
    if (paramco != null)
    {
      i1 = paramcu.c().size();
      if ((paramco.getAccuracy() > 299.0F) && (i1 > 5))
      {
        i1 = 1;
        if ((paramco == null) || (this.d == null) || (i1 != 0) || (i2 != 0)) {
          break label485;
        }
        bool = dn.a(this.d, paramStringBuilder.toString());
        if (this.c == 0L) {
          break label465;
        }
        l1 = dn.b();
        try
        {
          if (l1 - this.c >= 3000L) {
            break label465;
          }
          i2 = 1;
        }
        catch (Throwable paramcs)
        {
          break label491;
        }
        paramBoolean2 = bool;
        if (dn.a(paramco))
        {
          paramco.e("mem");
          paramco.setLocationType(2);
          return paramco;
        }
        if (!paramBoolean2) {
          this.c = dn.b();
        } else {
          this.c = 0L;
        }
        if ((this.m != null) && (!paramString.equals(this.m))) {
          if (dn.a() - this.n < 3000L)
          {
            paramcs = this.m;
            break label352;
          }
        }
        for (this.n = dn.a();; this.n = dn.a())
        {
          this.m = paramString;
          break label493;
          if (this.m != null) {
            break;
          }
        }
        this.n = dn.a();
        break label493;
        if ((i1 != 0) || (paramBoolean1)) {
          break label499;
        }
        paramcs = a(paramContext, paramcs, paramStringBuilder, false);
      }
    }
    for (;;)
    {
      i2 = i3;
      if (!paramBoolean1)
      {
        paramBoolean2 = dn.a(paramcs);
        i2 = i3;
        if (!paramBoolean2) {
          i2 = 1;
        }
      }
      if ((i2 == 0) && (i1 == 0)) {
        if (paramBoolean1) {
          return null;
        }
      }
      try
      {
        this.c = 0L;
        paramcs.setLocationType(4);
        return paramcs;
      }
      catch (Throwable paramcs)
      {
        return null;
      }
      return null;
      return null;
      label493:
      paramcs = paramString;
      break;
      label499:
      paramcs = null;
    }
  }
  
  public final void a()
  {
    this.c = 0L;
    this.d = null;
  }
  
  public final void a(Context paramContext)
  {
    if (this.j) {
      return;
    }
    try
    {
      c();
      a(paramContext, null);
    }
    catch (Throwable paramContext)
    {
      dg.a(paramContext, "Cache", "loadDB");
    }
    this.j = true;
  }
  
  public final void a(AMapLocationClientOption paramAMapLocationClientOption)
  {
    this.g = paramAMapLocationClientOption.isNeedAddress();
    this.f = paramAMapLocationClientOption.isOffset();
    this.b = paramAMapLocationClientOption.isLocationCacheEnable();
    this.h = String.valueOf(paramAMapLocationClientOption.getGeoLanguage());
  }
  
  public final void a(cr paramcr)
  {
    this.e = paramcr;
  }
  
  public final void a(String paramString)
  {
    this.d = paramString;
  }
  
  public final void a(String paramString, StringBuilder paramStringBuilder, co paramco, Context paramContext, boolean paramBoolean)
  {
    boolean bool;
    int i1;
    int i2;
    try
    {
      if (!dn.a(paramco)) {
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("&");
      ((StringBuilder)localObject1).append(paramco.isOffset());
      ((StringBuilder)localObject1).append("&");
      ((StringBuilder)localObject1).append(paramco.i());
      ((StringBuilder)localObject1).append("&");
      ((StringBuilder)localObject1).append(paramco.j());
      localObject1 = ((StringBuilder)localObject1).toString();
      bool = TextUtils.isEmpty((CharSequence)localObject1);
      i1 = 0;
      if ((bool) || (!dn.a(paramco)) || (((String)localObject1).startsWith("#"))) {
        break label599;
      }
      bool = ((String)localObject1).contains("network");
    }
    catch (Throwable paramString)
    {
      Object localObject1;
      int i4;
      label277:
      label426:
      dg.a(paramString, "Cache", "add");
      return;
    }
    if ((!paramco.e().equals("mem")) && (!paramco.e().equals("file")))
    {
      if (paramco.e().equals("wifioff")) {
        return;
      }
      if ("-3".equals(paramco.d())) {
        return;
      }
      if (b()) {
        c();
      }
      paramString = paramco.f();
      if (dn.a(paramString, "offpct"))
      {
        paramString.remove("offpct");
        paramco.a(paramString);
      }
      if (((String)localObject1).contains("wifi"))
      {
        if (TextUtils.isEmpty(paramStringBuilder)) {
          return;
        }
        if (paramco.getAccuracy() >= 300.0F)
        {
          paramString = paramStringBuilder.toString().split("#");
          i4 = paramString.length;
          i2 = 0;
          if (i1 >= i4) {
            break label621;
          }
          i3 = i2;
          if (!paramString[i1].contains(",")) {
            break label608;
          }
          i3 = i2 + 1;
          break label608;
        }
        if (paramco.getAccuracy() <= 3.0F) {
          return;
        }
      }
    }
    label599:
    label608:
    label621:
    while (i2 < 8)
    {
      int i3;
      if ((((String)localObject1).contains("cgiwifi")) && (!TextUtils.isEmpty(paramco.g())))
      {
        paramString = ((String)localObject1).replace("cgiwifi", "cgi");
        localObject2 = paramco.h();
        if (dn.a((co)localObject2))
        {
          a(paramString, new StringBuilder(), (co)localObject2, paramContext, true);
          break label426;
          if (((String)localObject1).contains("cgi"))
          {
            if ((paramStringBuilder != null) && (paramStringBuilder.indexOf(",") != -1)) {
              return;
            }
            if ("4".equals(paramco.d())) {
              return;
            }
          }
        }
      }
      paramString = a((String)localObject1, paramStringBuilder);
      if ((dn.a(paramString)) && (paramString.toStr().equals(paramco.toStr(3)))) {
        return;
      }
      this.i = dn.b();
      Object localObject2 = new a();
      ((a)localObject2).a(paramco);
      if (TextUtils.isEmpty(paramStringBuilder)) {
        paramString = null;
      } else {
        paramString = paramStringBuilder.toString();
      }
      ((a)localObject2).a(paramString);
      if (this.a.containsKey(localObject1))
      {
        ((ArrayList)this.a.get(localObject1)).add(localObject2);
      }
      else
      {
        paramString = new ArrayList();
        paramString.add(localObject2);
        this.a.put(localObject1, paramString);
      }
      if (paramBoolean) {
        try
        {
          a((String)localObject1, paramco, paramStringBuilder, paramContext);
          return;
        }
        catch (Throwable paramString)
        {
          dg.a(paramString, "Cache", "add");
        }
      }
      return;
      bool = false;
      if (bool) {
        break;
      }
      return;
      i1 += 1;
      i2 = i3;
      break label277;
    }
  }
  
  /* Error */
  public final void b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 456	com/loc/cw:c	()V
    //   4: aload_1
    //   5: ifnull +250 -> 255
    //   8: aload_1
    //   9: ldc_w 297
    //   12: iconst_0
    //   13: aconst_null
    //   14: invokevirtual 303	android/content/Context:openOrCreateDatabase	(Ljava/lang/String;ILandroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/sqlite/SQLiteDatabase;
    //   17: astore_1
    //   18: aload_1
    //   19: astore 4
    //   21: aload_1
    //   22: ldc_w 305
    //   25: invokestatic 308	com/loc/dn:a	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;)Z
    //   28: ifne +27 -> 55
    //   31: aload_1
    //   32: ifnull +223 -> 255
    //   35: aload_1
    //   36: astore 4
    //   38: aload_1
    //   39: invokevirtual 313	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   42: ifeq +213 -> 255
    //   45: aload_1
    //   46: astore 4
    //   48: aload_1
    //   49: invokevirtual 316	android/database/sqlite/SQLiteDatabase:close	()V
    //   52: goto +203 -> 255
    //   55: aload_1
    //   56: astore 4
    //   58: invokestatic 320	com/loc/dn:a	()J
    //   61: lstore_2
    //   62: aload_1
    //   63: astore 4
    //   65: new 174	java/lang/StringBuilder
    //   68: dup
    //   69: ldc_w 305
    //   72: invokespecial 557	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   75: astore 5
    //   77: aload_1
    //   78: astore 4
    //   80: aload 5
    //   82: aload_0
    //   83: getfield 53	com/loc/cw:k	Ljava/lang/String;
    //   86: invokevirtual 199	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_1
    //   91: astore 4
    //   93: aload_1
    //   94: aload 5
    //   96: invokevirtual 194	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: ldc_w 559
    //   102: iconst_1
    //   103: anewarray 47	java/lang/String
    //   106: dup
    //   107: iconst_0
    //   108: lload_2
    //   109: ldc2_w 560
    //   112: lsub
    //   113: invokestatic 564	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   116: aastore
    //   117: invokevirtual 567	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   120: pop
    //   121: goto +52 -> 173
    //   124: astore 5
    //   126: aload_1
    //   127: astore 4
    //   129: aload 5
    //   131: ldc_w 390
    //   134: ldc_w 569
    //   137: invokestatic 162	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   140: aload_1
    //   141: astore 4
    //   143: aload 5
    //   145: invokevirtual 572	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   148: astore 5
    //   150: aload_1
    //   151: astore 4
    //   153: aload 5
    //   155: invokestatic 170	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   158: ifne +15 -> 173
    //   161: aload_1
    //   162: astore 4
    //   164: aload 5
    //   166: ldc_w 574
    //   169: invokevirtual 93	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   172: pop
    //   173: aload_1
    //   174: ifnull +81 -> 255
    //   177: aload_1
    //   178: invokevirtual 313	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   181: ifeq +74 -> 255
    //   184: aload_1
    //   185: invokevirtual 316	android/database/sqlite/SQLiteDatabase:close	()V
    //   188: goto +67 -> 255
    //   191: astore 5
    //   193: goto +14 -> 207
    //   196: astore_1
    //   197: aconst_null
    //   198: astore 4
    //   200: goto +35 -> 235
    //   203: astore 5
    //   205: aconst_null
    //   206: astore_1
    //   207: aload_1
    //   208: astore 4
    //   210: aload 5
    //   212: ldc_w 390
    //   215: ldc_w 576
    //   218: invokestatic 162	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   221: aload_1
    //   222: ifnull +33 -> 255
    //   225: aload_1
    //   226: invokevirtual 313	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   229: ifeq +26 -> 255
    //   232: goto -48 -> 184
    //   235: aload 4
    //   237: ifnull +16 -> 253
    //   240: aload 4
    //   242: invokevirtual 313	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   245: ifeq +8 -> 253
    //   248: aload 4
    //   250: invokevirtual 316	android/database/sqlite/SQLiteDatabase:close	()V
    //   253: aload_1
    //   254: athrow
    //   255: aload_0
    //   256: iconst_0
    //   257: putfield 39	com/loc/cw:j	Z
    //   260: aload_0
    //   261: aconst_null
    //   262: putfield 61	com/loc/cw:d	Ljava/lang/String;
    //   265: aload_0
    //   266: lconst_0
    //   267: putfield 67	com/loc/cw:n	J
    //   270: return
    //   271: astore_1
    //   272: aload_1
    //   273: ldc -101
    //   275: ldc_w 578
    //   278: invokestatic 162	com/loc/dg:a	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   281: return
    //   282: astore_1
    //   283: goto -48 -> 235
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	this	cw
    //   0	286	1	paramContext	Context
    //   61	48	2	l1	long
    //   19	230	4	localContext	Context
    //   75	20	5	localStringBuilder	StringBuilder
    //   124	20	5	localThrowable1	Throwable
    //   148	17	5	str	String
    //   191	1	5	localThrowable2	Throwable
    //   203	8	5	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   65	77	124	java/lang/Throwable
    //   80	90	124	java/lang/Throwable
    //   93	121	124	java/lang/Throwable
    //   21	31	191	java/lang/Throwable
    //   38	45	191	java/lang/Throwable
    //   48	52	191	java/lang/Throwable
    //   58	62	191	java/lang/Throwable
    //   129	140	191	java/lang/Throwable
    //   143	150	191	java/lang/Throwable
    //   153	161	191	java/lang/Throwable
    //   164	173	191	java/lang/Throwable
    //   8	18	196	finally
    //   8	18	203	java/lang/Throwable
    //   0	4	271	java/lang/Throwable
    //   177	184	271	java/lang/Throwable
    //   184	188	271	java/lang/Throwable
    //   225	232	271	java/lang/Throwable
    //   240	253	271	java/lang/Throwable
    //   253	255	271	java/lang/Throwable
    //   255	270	271	java/lang/Throwable
    //   21	31	282	finally
    //   38	45	282	finally
    //   48	52	282	finally
    //   58	62	282	finally
    //   65	77	282	finally
    //   80	90	282	finally
    //   93	121	282	finally
    //   129	140	282	finally
    //   143	150	282	finally
    //   153	161	282	finally
    //   164	173	282	finally
    //   210	221	282	finally
  }
  
  static final class a
  {
    private co a = null;
    private String b = null;
    
    public final co a()
    {
      return this.a;
    }
    
    public final void a(co paramco)
    {
      this.a = paramco;
    }
    
    public final void a(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {}
      for (paramString = null;; paramString = paramString.replace("##", "#"))
      {
        this.b = paramString;
        return;
      }
    }
    
    public final String b()
    {
      return this.b;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\cw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */