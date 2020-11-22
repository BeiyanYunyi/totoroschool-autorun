package com.loc;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationClientOption.GeoLanguage;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class dd
{
  private StringBuilder a = new StringBuilder();
  private AMapLocationClientOption b = new AMapLocationClientOption();
  
  private void a(co paramco, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramString1))
    {
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" ");
    }
    if (!TextUtils.isEmpty(paramString2)) {
      if (this.b.getGeoLanguage() == AMapLocationClientOption.GeoLanguage.EN)
      {
        if (paramString2.equals(paramString1)) {}
      }
      else {
        while ((!paramString1.contains("市")) || (!paramString1.equals(paramString2)))
        {
          localStringBuilder.append(paramString2);
          localStringBuilder.append(" ");
          break;
        }
      }
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      localStringBuilder.append(paramString3);
      localStringBuilder.append(" ");
    }
    if (!TextUtils.isEmpty(paramString4))
    {
      localStringBuilder.append(paramString4);
      localStringBuilder.append(" ");
    }
    if (!TextUtils.isEmpty(paramString5))
    {
      localStringBuilder.append(paramString5);
      localStringBuilder.append(" ");
    }
    if (!TextUtils.isEmpty(paramString6))
    {
      if ((!TextUtils.isEmpty(paramString7)) && (this.b.getGeoLanguage() != AMapLocationClientOption.GeoLanguage.EN))
      {
        localStringBuilder.append("靠近");
        localStringBuilder.append(paramString6);
        localStringBuilder.append(" ");
        paramString1 = new StringBuilder("在");
        paramString1.append(paramString6);
        paramString1.append("附近");
      }
      else
      {
        paramString1 = new StringBuilder("Near ");
        paramString1.append(paramString6);
        localStringBuilder.append(paramString1.toString());
        paramString1 = new StringBuilder("Near ");
        paramString1.append(paramString6);
      }
      paramco.setDescription(paramString1.toString());
    }
    paramString1 = new Bundle();
    paramString1.putString("citycode", paramco.getCityCode());
    paramString1.putString("desc", localStringBuilder.toString());
    paramString1.putString("adcode", paramco.getAdCode());
    paramco.setExtras(paramString1);
    paramco.g(localStringBuilder.toString());
    paramString1 = paramco.getAdCode();
    if ((paramString1 != null) && (paramString1.trim().length() > 0) && (this.b.getGeoLanguage() != AMapLocationClientOption.GeoLanguage.EN)) {}
    for (paramString1 = localStringBuilder.toString().replace(" ", "");; paramString1 = localStringBuilder.toString())
    {
      paramco.setAddress(paramString1);
      return;
    }
  }
  
  private static String b(String paramString)
  {
    String str = paramString;
    if ("[]".equals(paramString)) {
      str = "";
    }
    return str;
  }
  
  /* Error */
  public final co a(co paramco, byte[] paramArrayOfByte, d paramd)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore 9
    //   3: aload_2
    //   4: ifnonnull +56 -> 60
    //   7: aload 9
    //   9: iconst_5
    //   10: invokevirtual 129	com/loc/co:setErrorCode	(I)V
    //   13: aload_3
    //   14: ldc -125
    //   16: invokevirtual 136	com/loc/d:e	(Ljava/lang/String;)V
    //   19: aload_0
    //   20: getfield 17	com/loc/dd:a	Ljava/lang/StringBuilder;
    //   23: ldc -118
    //   25: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload 9
    //   31: aload_0
    //   32: getfield 17	com/loc/dd:a	Ljava/lang/StringBuilder;
    //   35: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokevirtual 141	com/loc/co:setLocationDetail	(Ljava/lang/String;)V
    //   41: aload_0
    //   42: getfield 17	com/loc/dd:a	Ljava/lang/StringBuilder;
    //   45: iconst_0
    //   46: aload_0
    //   47: getfield 17	com/loc/dd:a	Ljava/lang/StringBuilder;
    //   50: invokevirtual 142	java/lang/StringBuilder:length	()I
    //   53: invokevirtual 146	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 9
    //   59: areturn
    //   60: aload_2
    //   61: invokestatic 152	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   64: astore 8
    //   66: aload 8
    //   68: invokevirtual 156	java/nio/ByteBuffer:get	()B
    //   71: ifne +36 -> 107
    //   74: aload 9
    //   76: aload 8
    //   78: invokevirtual 160	java/nio/ByteBuffer:getShort	()S
    //   81: invokestatic 164	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   84: invokevirtual 166	com/loc/co:b	(Ljava/lang/String;)V
    //   87: aload 8
    //   89: invokevirtual 170	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   92: pop
    //   93: aload 8
    //   95: ifnull +9 -> 104
    //   98: aload 8
    //   100: invokevirtual 170	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   103: pop
    //   104: aload 9
    //   106: areturn
    //   107: aload 8
    //   109: invokevirtual 173	java/nio/ByteBuffer:getInt	()I
    //   112: istore 6
    //   114: iload 6
    //   116: i2d
    //   117: dstore 4
    //   119: dload 4
    //   121: invokestatic 179	java/lang/Double:isNaN	(D)Z
    //   124: pop
    //   125: dload 4
    //   127: ldc2_w 180
    //   130: ddiv
    //   131: dstore 4
    //   133: aload 9
    //   135: dload 4
    //   137: invokestatic 186	com/loc/dn:a	(D)D
    //   140: invokevirtual 190	com/loc/co:setLongitude	(D)V
    //   143: aload 8
    //   145: invokevirtual 173	java/nio/ByteBuffer:getInt	()I
    //   148: istore 6
    //   150: iload 6
    //   152: i2d
    //   153: dstore 4
    //   155: dload 4
    //   157: invokestatic 179	java/lang/Double:isNaN	(D)Z
    //   160: pop
    //   161: dload 4
    //   163: ldc2_w 180
    //   166: ddiv
    //   167: dstore 4
    //   169: aload 9
    //   171: dload 4
    //   173: invokestatic 186	com/loc/dn:a	(D)D
    //   176: invokevirtual 193	com/loc/co:setLatitude	(D)V
    //   179: aload 9
    //   181: aload 8
    //   183: invokevirtual 160	java/nio/ByteBuffer:getShort	()S
    //   186: i2f
    //   187: invokevirtual 197	com/loc/co:setAccuracy	(F)V
    //   190: aload 9
    //   192: aload 8
    //   194: invokevirtual 156	java/nio/ByteBuffer:get	()B
    //   197: invokestatic 164	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   200: invokevirtual 200	com/loc/co:c	(Ljava/lang/String;)V
    //   203: aload 9
    //   205: aload 8
    //   207: invokevirtual 156	java/nio/ByteBuffer:get	()B
    //   210: invokestatic 164	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   213: invokevirtual 203	com/loc/co:d	(Ljava/lang/String;)V
    //   216: aload 8
    //   218: invokevirtual 156	java/nio/ByteBuffer:get	()B
    //   221: iconst_1
    //   222: if_icmpne +1065 -> 1287
    //   225: ldc 112
    //   227: astore_2
    //   228: ldc 112
    //   230: astore 11
    //   232: aload 8
    //   234: invokevirtual 156	java/nio/ByteBuffer:get	()B
    //   237: sipush 255
    //   240: iand
    //   241: newarray <illegal type>
    //   243: astore 10
    //   245: aload 8
    //   247: aload 10
    //   249: invokevirtual 205	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   252: pop
    //   253: aload 9
    //   255: new 48	java/lang/String
    //   258: dup
    //   259: aload 10
    //   261: ldc -49
    //   263: invokespecial 210	java/lang/String:<init>	([BLjava/lang/String;)V
    //   266: invokevirtual 213	com/loc/co:setCountry	(Ljava/lang/String;)V
    //   269: aload 8
    //   271: invokevirtual 156	java/nio/ByteBuffer:get	()B
    //   274: sipush 255
    //   277: iand
    //   278: newarray <illegal type>
    //   280: astore 10
    //   282: aload 8
    //   284: aload 10
    //   286: invokevirtual 205	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   289: pop
    //   290: new 48	java/lang/String
    //   293: dup
    //   294: aload 10
    //   296: ldc -49
    //   298: invokespecial 210	java/lang/String:<init>	([BLjava/lang/String;)V
    //   301: astore 10
    //   303: aload 9
    //   305: aload 10
    //   307: invokevirtual 216	com/loc/co:setProvince	(Ljava/lang/String;)V
    //   310: goto +9 -> 319
    //   313: aload 10
    //   315: astore_2
    //   316: aload_2
    //   317: astore 10
    //   319: aload 8
    //   321: invokevirtual 156	java/nio/ByteBuffer:get	()B
    //   324: sipush 255
    //   327: iand
    //   328: newarray <illegal type>
    //   330: astore_2
    //   331: aload 8
    //   333: aload_2
    //   334: invokevirtual 205	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   337: pop
    //   338: new 48	java/lang/String
    //   341: dup
    //   342: aload_2
    //   343: ldc -49
    //   345: invokespecial 210	java/lang/String:<init>	([BLjava/lang/String;)V
    //   348: astore_2
    //   349: aload 9
    //   351: aload_2
    //   352: invokevirtual 219	com/loc/co:setCity	(Ljava/lang/String;)V
    //   355: goto +3 -> 358
    //   358: aload 8
    //   360: invokevirtual 156	java/nio/ByteBuffer:get	()B
    //   363: sipush 255
    //   366: iand
    //   367: newarray <illegal type>
    //   369: astore 11
    //   371: aload 8
    //   373: aload 11
    //   375: invokevirtual 205	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   378: pop
    //   379: new 48	java/lang/String
    //   382: dup
    //   383: aload 11
    //   385: ldc -49
    //   387: invokespecial 210	java/lang/String:<init>	([BLjava/lang/String;)V
    //   390: astore 11
    //   392: aload 9
    //   394: aload 11
    //   396: invokevirtual 222	com/loc/co:setDistrict	(Ljava/lang/String;)V
    //   399: goto +7 -> 406
    //   402: ldc 112
    //   404: astore 11
    //   406: aload 8
    //   408: invokevirtual 156	java/nio/ByteBuffer:get	()B
    //   411: sipush 255
    //   414: iand
    //   415: newarray <illegal type>
    //   417: astore 12
    //   419: aload 8
    //   421: aload 12
    //   423: invokevirtual 205	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   426: pop
    //   427: new 48	java/lang/String
    //   430: dup
    //   431: aload 12
    //   433: ldc -49
    //   435: invokespecial 210	java/lang/String:<init>	([BLjava/lang/String;)V
    //   438: astore 12
    //   440: aload 9
    //   442: aload 12
    //   444: invokevirtual 225	com/loc/co:setStreet	(Ljava/lang/String;)V
    //   447: aload 9
    //   449: aload 12
    //   451: invokevirtual 228	com/loc/co:setRoad	(Ljava/lang/String;)V
    //   454: goto +7 -> 461
    //   457: ldc 112
    //   459: astore 12
    //   461: aload 8
    //   463: invokevirtual 156	java/nio/ByteBuffer:get	()B
    //   466: sipush 255
    //   469: iand
    //   470: newarray <illegal type>
    //   472: astore 13
    //   474: aload 8
    //   476: aload 13
    //   478: invokevirtual 205	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   481: pop
    //   482: new 48	java/lang/String
    //   485: dup
    //   486: aload 13
    //   488: ldc -49
    //   490: invokespecial 210	java/lang/String:<init>	([BLjava/lang/String;)V
    //   493: astore 13
    //   495: aload 9
    //   497: aload 13
    //   499: invokevirtual 231	com/loc/co:setNumber	(Ljava/lang/String;)V
    //   502: goto +7 -> 509
    //   505: ldc 112
    //   507: astore 13
    //   509: aload 8
    //   511: invokevirtual 156	java/nio/ByteBuffer:get	()B
    //   514: sipush 255
    //   517: iand
    //   518: newarray <illegal type>
    //   520: astore 14
    //   522: aload 8
    //   524: aload 14
    //   526: invokevirtual 205	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   529: pop
    //   530: new 48	java/lang/String
    //   533: dup
    //   534: aload 14
    //   536: ldc -49
    //   538: invokespecial 210	java/lang/String:<init>	([BLjava/lang/String;)V
    //   541: astore 14
    //   543: aload 9
    //   545: aload 14
    //   547: invokevirtual 234	com/loc/co:setPoiName	(Ljava/lang/String;)V
    //   550: goto +7 -> 557
    //   553: ldc 112
    //   555: astore 14
    //   557: aload 8
    //   559: invokevirtual 156	java/nio/ByteBuffer:get	()B
    //   562: sipush 255
    //   565: iand
    //   566: newarray <illegal type>
    //   568: astore 15
    //   570: aload 8
    //   572: aload 15
    //   574: invokevirtual 205	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   577: pop
    //   578: aload 9
    //   580: new 48	java/lang/String
    //   583: dup
    //   584: aload 15
    //   586: ldc -49
    //   588: invokespecial 210	java/lang/String:<init>	([BLjava/lang/String;)V
    //   591: invokevirtual 237	com/loc/co:setAoiName	(Ljava/lang/String;)V
    //   594: aload 8
    //   596: invokevirtual 156	java/nio/ByteBuffer:get	()B
    //   599: sipush 255
    //   602: iand
    //   603: newarray <illegal type>
    //   605: astore 15
    //   607: aload 8
    //   609: aload 15
    //   611: invokevirtual 205	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   614: pop
    //   615: new 48	java/lang/String
    //   618: dup
    //   619: aload 15
    //   621: ldc -49
    //   623: invokespecial 210	java/lang/String:<init>	([BLjava/lang/String;)V
    //   626: astore 15
    //   628: aload 9
    //   630: aload 15
    //   632: invokevirtual 240	com/loc/co:setAdCode	(Ljava/lang/String;)V
    //   635: goto +7 -> 642
    //   638: ldc 112
    //   640: astore 15
    //   642: aload 8
    //   644: invokevirtual 156	java/nio/ByteBuffer:get	()B
    //   647: sipush 255
    //   650: iand
    //   651: newarray <illegal type>
    //   653: astore 16
    //   655: aload 8
    //   657: aload 16
    //   659: invokevirtual 205	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   662: pop
    //   663: aload 9
    //   665: new 48	java/lang/String
    //   668: dup
    //   669: aload 16
    //   671: ldc -49
    //   673: invokespecial 210	java/lang/String:<init>	([BLjava/lang/String;)V
    //   676: invokevirtual 243	com/loc/co:setCityCode	(Ljava/lang/String;)V
    //   679: aload_0
    //   680: aload_1
    //   681: aload 10
    //   683: aload_2
    //   684: aload 11
    //   686: aload 12
    //   688: aload 13
    //   690: aload 14
    //   692: aload 15
    //   694: invokespecial 245	com/loc/dd:a	(Lcom/loc/co;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   697: goto +3 -> 700
    //   700: aload 8
    //   702: aload 8
    //   704: invokevirtual 156	java/nio/ByteBuffer:get	()B
    //   707: sipush 255
    //   710: iand
    //   711: newarray <illegal type>
    //   713: invokevirtual 205	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   716: pop
    //   717: aload 8
    //   719: invokevirtual 156	java/nio/ByteBuffer:get	()B
    //   722: iconst_1
    //   723: if_icmpne +21 -> 744
    //   726: aload 8
    //   728: invokevirtual 173	java/nio/ByteBuffer:getInt	()I
    //   731: pop
    //   732: aload 8
    //   734: invokevirtual 173	java/nio/ByteBuffer:getInt	()I
    //   737: pop
    //   738: aload 8
    //   740: invokevirtual 160	java/nio/ByteBuffer:getShort	()S
    //   743: pop
    //   744: aload 8
    //   746: invokevirtual 156	java/nio/ByteBuffer:get	()B
    //   749: iconst_1
    //   750: if_icmpne +71 -> 821
    //   753: aload 8
    //   755: invokevirtual 156	java/nio/ByteBuffer:get	()B
    //   758: sipush 255
    //   761: iand
    //   762: newarray <illegal type>
    //   764: astore_2
    //   765: aload 8
    //   767: aload_2
    //   768: invokevirtual 205	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   771: pop
    //   772: aload 9
    //   774: new 48	java/lang/String
    //   777: dup
    //   778: aload_2
    //   779: ldc -49
    //   781: invokespecial 210	java/lang/String:<init>	([BLjava/lang/String;)V
    //   784: invokevirtual 248	com/loc/co:setBuildingId	(Ljava/lang/String;)V
    //   787: aload 8
    //   789: invokevirtual 156	java/nio/ByteBuffer:get	()B
    //   792: sipush 255
    //   795: iand
    //   796: newarray <illegal type>
    //   798: astore_2
    //   799: aload 8
    //   801: aload_2
    //   802: invokevirtual 205	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   805: pop
    //   806: aload 9
    //   808: new 48	java/lang/String
    //   811: dup
    //   812: aload_2
    //   813: ldc -49
    //   815: invokespecial 210	java/lang/String:<init>	([BLjava/lang/String;)V
    //   818: invokevirtual 251	com/loc/co:setFloor	(Ljava/lang/String;)V
    //   821: aload 8
    //   823: invokevirtual 156	java/nio/ByteBuffer:get	()B
    //   826: iconst_1
    //   827: if_icmpne +21 -> 848
    //   830: aload 8
    //   832: invokevirtual 156	java/nio/ByteBuffer:get	()B
    //   835: pop
    //   836: aload 8
    //   838: invokevirtual 173	java/nio/ByteBuffer:getInt	()I
    //   841: pop
    //   842: aload 8
    //   844: invokevirtual 156	java/nio/ByteBuffer:get	()B
    //   847: pop
    //   848: aload 8
    //   850: invokevirtual 156	java/nio/ByteBuffer:get	()B
    //   853: iconst_1
    //   854: if_icmpne +13 -> 867
    //   857: aload 9
    //   859: aload 8
    //   861: invokevirtual 255	java/nio/ByteBuffer:getLong	()J
    //   864: invokevirtual 259	com/loc/co:setTime	(J)V
    //   867: aload 8
    //   869: invokevirtual 160	java/nio/ByteBuffer:getShort	()S
    //   872: istore 6
    //   874: iload 6
    //   876: ifle +39 -> 915
    //   879: iload 6
    //   881: newarray <illegal type>
    //   883: astore_2
    //   884: aload 8
    //   886: aload_2
    //   887: invokevirtual 205	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   890: pop
    //   891: aload_2
    //   892: arraylength
    //   893: ifle +22 -> 915
    //   896: aload 9
    //   898: new 48	java/lang/String
    //   901: dup
    //   902: aload_2
    //   903: iconst_0
    //   904: invokestatic 265	android/util/Base64:decode	([BI)[B
    //   907: ldc -49
    //   909: invokespecial 210	java/lang/String:<init>	([BLjava/lang/String;)V
    //   912: invokevirtual 267	com/loc/co:a	(Ljava/lang/String;)V
    //   915: aload 8
    //   917: invokevirtual 160	java/nio/ByteBuffer:getShort	()S
    //   920: istore 6
    //   922: iload 6
    //   924: ifle +13 -> 937
    //   927: aload 8
    //   929: iload 6
    //   931: newarray <illegal type>
    //   933: invokevirtual 205	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   936: pop
    //   937: ldc_w 269
    //   940: invokestatic 272	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   943: invokevirtual 276	java/lang/Double:doubleValue	()D
    //   946: ldc2_w 277
    //   949: dcmpl
    //   950: iflt +51 -> 1001
    //   953: aload 8
    //   955: invokevirtual 160	java/nio/ByteBuffer:getShort	()S
    //   958: istore 7
    //   960: ldc_w 280
    //   963: aload_1
    //   964: invokevirtual 282	com/loc/co:d	()Ljava/lang/String;
    //   967: invokevirtual 52	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   970: ifne +335 -> 1305
    //   973: iload 7
    //   975: iconst_m1
    //   976: if_icmpne +314 -> 1290
    //   979: iconst_0
    //   980: istore 6
    //   982: goto +3 -> 985
    //   985: aload 9
    //   987: iload 6
    //   989: invokevirtual 285	com/loc/co:setConScenario	(I)V
    //   992: goto +3 -> 995
    //   995: aload 8
    //   997: invokevirtual 156	java/nio/ByteBuffer:get	()B
    //   1000: pop
    //   1001: aload 9
    //   1003: astore_1
    //   1004: aload 8
    //   1006: ifnull +127 -> 1133
    //   1009: aload 8
    //   1011: invokevirtual 170	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1014: pop
    //   1015: aload 9
    //   1017: astore_1
    //   1018: goto +115 -> 1133
    //   1021: astore_1
    //   1022: aload 8
    //   1024: astore_2
    //   1025: goto +141 -> 1166
    //   1028: astore_2
    //   1029: aload 8
    //   1031: astore_1
    //   1032: new 74	com/loc/co
    //   1035: dup
    //   1036: ldc 112
    //   1038: invokespecial 286	com/loc/co:<init>	(Ljava/lang/String;)V
    //   1041: astore 8
    //   1043: aload 8
    //   1045: iconst_5
    //   1046: invokevirtual 129	com/loc/co:setErrorCode	(I)V
    //   1049: aload_3
    //   1050: ldc_w 288
    //   1053: invokevirtual 136	com/loc/d:e	(Ljava/lang/String;)V
    //   1056: aload_0
    //   1057: getfield 17	com/loc/dd:a	Ljava/lang/StringBuilder;
    //   1060: astore_3
    //   1061: new 14	java/lang/StringBuilder
    //   1064: dup
    //   1065: ldc_w 290
    //   1068: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1071: astore 9
    //   1073: aload 9
    //   1075: aload_2
    //   1076: invokevirtual 293	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1079: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1082: pop
    //   1083: aload 9
    //   1085: ldc_w 288
    //   1088: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1091: pop
    //   1092: aload_3
    //   1093: aload 9
    //   1095: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1098: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1101: pop
    //   1102: aconst_null
    //   1103: sipush 2054
    //   1106: invokestatic 298	com/loc/dk:a	(Ljava/lang/String;I)V
    //   1109: aload 8
    //   1111: aload_0
    //   1112: getfield 17	com/loc/dd:a	Ljava/lang/StringBuilder;
    //   1115: invokevirtual 72	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1118: invokevirtual 141	com/loc/co:setLocationDetail	(Ljava/lang/String;)V
    //   1121: aload_1
    //   1122: ifnull +8 -> 1130
    //   1125: aload_1
    //   1126: invokevirtual 170	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1129: pop
    //   1130: aload 8
    //   1132: astore_1
    //   1133: aload_0
    //   1134: getfield 17	com/loc/dd:a	Ljava/lang/StringBuilder;
    //   1137: invokevirtual 142	java/lang/StringBuilder:length	()I
    //   1140: ifle +19 -> 1159
    //   1143: aload_0
    //   1144: getfield 17	com/loc/dd:a	Ljava/lang/StringBuilder;
    //   1147: iconst_0
    //   1148: aload_0
    //   1149: getfield 17	com/loc/dd:a	Ljava/lang/StringBuilder;
    //   1152: invokevirtual 142	java/lang/StringBuilder:length	()I
    //   1155: invokevirtual 146	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   1158: pop
    //   1159: aload_1
    //   1160: areturn
    //   1161: astore_3
    //   1162: aload_1
    //   1163: astore_2
    //   1164: aload_3
    //   1165: astore_1
    //   1166: aload_2
    //   1167: ifnull +8 -> 1175
    //   1170: aload_2
    //   1171: invokevirtual 170	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   1174: pop
    //   1175: aload_1
    //   1176: athrow
    //   1177: astore 10
    //   1179: goto -910 -> 269
    //   1182: astore 10
    //   1184: goto -868 -> 316
    //   1187: astore_2
    //   1188: goto -875 -> 313
    //   1191: astore_2
    //   1192: aload 11
    //   1194: astore_2
    //   1195: goto -837 -> 358
    //   1198: astore 11
    //   1200: goto -842 -> 358
    //   1203: astore 11
    //   1205: goto -803 -> 402
    //   1208: astore 12
    //   1210: goto -804 -> 406
    //   1213: astore 12
    //   1215: goto -758 -> 457
    //   1218: astore 13
    //   1220: goto -759 -> 461
    //   1223: astore 13
    //   1225: goto -720 -> 505
    //   1228: astore 14
    //   1230: goto -721 -> 509
    //   1233: astore 14
    //   1235: goto -682 -> 553
    //   1238: astore 15
    //   1240: goto -683 -> 557
    //   1243: astore 15
    //   1245: goto -651 -> 594
    //   1248: astore 15
    //   1250: goto -612 -> 638
    //   1253: astore 16
    //   1255: goto -613 -> 642
    //   1258: astore 16
    //   1260: goto -581 -> 679
    //   1263: astore_2
    //   1264: goto -477 -> 787
    //   1267: astore_2
    //   1268: goto -447 -> 821
    //   1271: astore_2
    //   1272: goto -357 -> 915
    //   1275: astore_1
    //   1276: aconst_null
    //   1277: astore_2
    //   1278: goto -112 -> 1166
    //   1281: astore_2
    //   1282: aconst_null
    //   1283: astore_1
    //   1284: goto -252 -> 1032
    //   1287: goto -587 -> 700
    //   1290: iload 7
    //   1292: istore 6
    //   1294: iload 7
    //   1296: ifne -311 -> 985
    //   1299: iconst_m1
    //   1300: istore 6
    //   1302: goto -317 -> 985
    //   1305: iload 7
    //   1307: istore 6
    //   1309: iload 7
    //   1311: bipush 101
    //   1313: if_icmpne -328 -> 985
    //   1316: bipush 100
    //   1318: istore 6
    //   1320: goto -335 -> 985
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1323	0	this	dd
    //   0	1323	1	paramco	co
    //   0	1323	2	paramArrayOfByte	byte[]
    //   0	1323	3	paramd	d
    //   117	55	4	d	double
    //   112	1207	6	i	int
    //   958	356	7	j	int
    //   64	1067	8	localObject1	Object
    //   1	1093	9	localObject2	Object
    //   243	439	10	localObject3	Object
    //   1177	1	10	localThrowable1	Throwable
    //   1182	1	10	localThrowable2	Throwable
    //   230	963	11	localObject4	Object
    //   1198	1	11	localThrowable3	Throwable
    //   1203	1	11	localThrowable4	Throwable
    //   417	270	12	localObject5	Object
    //   1208	1	12	localThrowable5	Throwable
    //   1213	1	12	localThrowable6	Throwable
    //   472	217	13	localObject6	Object
    //   1218	1	13	localThrowable7	Throwable
    //   1223	1	13	localThrowable8	Throwable
    //   520	171	14	localObject7	Object
    //   1228	1	14	localThrowable9	Throwable
    //   1233	1	14	localThrowable10	Throwable
    //   568	125	15	localObject8	Object
    //   1238	1	15	localThrowable11	Throwable
    //   1243	1	15	localThrowable12	Throwable
    //   1248	1	15	localThrowable13	Throwable
    //   653	17	16	arrayOfByte	byte[]
    //   1253	1	16	localThrowable14	Throwable
    //   1258	1	16	localThrowable15	Throwable
    // Exception table:
    //   from	to	target	type
    //   66	93	1021	finally
    //   107	114	1021	finally
    //   133	150	1021	finally
    //   169	225	1021	finally
    //   232	253	1021	finally
    //   253	269	1021	finally
    //   269	290	1021	finally
    //   290	303	1021	finally
    //   303	310	1021	finally
    //   319	338	1021	finally
    //   338	349	1021	finally
    //   349	355	1021	finally
    //   358	379	1021	finally
    //   379	392	1021	finally
    //   392	399	1021	finally
    //   406	427	1021	finally
    //   427	440	1021	finally
    //   440	454	1021	finally
    //   461	482	1021	finally
    //   482	495	1021	finally
    //   495	502	1021	finally
    //   509	530	1021	finally
    //   530	543	1021	finally
    //   543	550	1021	finally
    //   557	578	1021	finally
    //   578	594	1021	finally
    //   594	615	1021	finally
    //   615	628	1021	finally
    //   628	635	1021	finally
    //   642	663	1021	finally
    //   663	679	1021	finally
    //   679	697	1021	finally
    //   700	744	1021	finally
    //   744	772	1021	finally
    //   772	787	1021	finally
    //   787	806	1021	finally
    //   806	821	1021	finally
    //   821	848	1021	finally
    //   848	867	1021	finally
    //   867	874	1021	finally
    //   879	891	1021	finally
    //   891	915	1021	finally
    //   915	922	1021	finally
    //   927	937	1021	finally
    //   937	973	1021	finally
    //   985	992	1021	finally
    //   995	1001	1021	finally
    //   66	93	1028	java/lang/Throwable
    //   107	114	1028	java/lang/Throwable
    //   133	150	1028	java/lang/Throwable
    //   169	225	1028	java/lang/Throwable
    //   232	253	1028	java/lang/Throwable
    //   269	290	1028	java/lang/Throwable
    //   319	338	1028	java/lang/Throwable
    //   358	379	1028	java/lang/Throwable
    //   406	427	1028	java/lang/Throwable
    //   461	482	1028	java/lang/Throwable
    //   509	530	1028	java/lang/Throwable
    //   557	578	1028	java/lang/Throwable
    //   594	615	1028	java/lang/Throwable
    //   642	663	1028	java/lang/Throwable
    //   679	697	1028	java/lang/Throwable
    //   700	744	1028	java/lang/Throwable
    //   744	772	1028	java/lang/Throwable
    //   787	806	1028	java/lang/Throwable
    //   821	848	1028	java/lang/Throwable
    //   848	867	1028	java/lang/Throwable
    //   867	874	1028	java/lang/Throwable
    //   879	891	1028	java/lang/Throwable
    //   915	922	1028	java/lang/Throwable
    //   927	937	1028	java/lang/Throwable
    //   937	973	1028	java/lang/Throwable
    //   985	992	1028	java/lang/Throwable
    //   995	1001	1028	java/lang/Throwable
    //   1032	1121	1161	finally
    //   253	269	1177	java/lang/Throwable
    //   290	303	1182	java/lang/Throwable
    //   303	310	1187	java/lang/Throwable
    //   338	349	1191	java/lang/Throwable
    //   349	355	1198	java/lang/Throwable
    //   379	392	1203	java/lang/Throwable
    //   392	399	1208	java/lang/Throwable
    //   427	440	1213	java/lang/Throwable
    //   440	454	1218	java/lang/Throwable
    //   482	495	1223	java/lang/Throwable
    //   495	502	1228	java/lang/Throwable
    //   530	543	1233	java/lang/Throwable
    //   543	550	1238	java/lang/Throwable
    //   578	594	1243	java/lang/Throwable
    //   615	628	1248	java/lang/Throwable
    //   628	635	1253	java/lang/Throwable
    //   663	679	1258	java/lang/Throwable
    //   772	787	1263	java/lang/Throwable
    //   806	821	1267	java/lang/Throwable
    //   891	915	1271	java/lang/Throwable
    //   7	57	1275	finally
    //   60	66	1275	finally
    //   7	57	1281	java/lang/Throwable
    //   60	66	1281	java/lang/Throwable
  }
  
  public final co a(String paramString)
  {
    for (;;)
    {
      try
      {
        co localco = new co("");
        Object localObject2 = new JSONObject(paramString).optJSONObject("regeocode");
        localObject1 = ((JSONObject)localObject2).optJSONObject("addressComponent");
        localco.setCountry(b(((JSONObject)localObject1).optString("country")));
        String str1 = b(((JSONObject)localObject1).optString("province"));
        localco.setProvince(str1);
        String str2 = b(((JSONObject)localObject1).optString("citycode"));
        localco.setCityCode(str2);
        paramString = ((JSONObject)localObject1).optString("city");
        if ((!str2.endsWith("010")) && (!str2.endsWith("021")) && (!str2.endsWith("022")) && (!str2.endsWith("023")))
        {
          paramString = b(paramString);
          localco.setCity(paramString);
        }
        else
        {
          if ((str1 == null) || (str1.length() <= 0)) {
            break label386;
          }
          localco.setCity(str1);
          paramString = str1;
        }
        if (!TextUtils.isEmpty(paramString)) {
          break label389;
        }
        localco.setCity(str1);
        paramString = str1;
        str2 = b(((JSONObject)localObject1).optString("district"));
        localco.setDistrict(str2);
        String str3 = b(((JSONObject)localObject1).optString("adcode"));
        localco.setAdCode(str3);
        localObject1 = ((JSONObject)localObject1).optJSONObject("streetNumber");
        String str4 = b(((JSONObject)localObject1).optString("street"));
        localco.setStreet(str4);
        localco.setRoad(str4);
        String str5 = b(((JSONObject)localObject1).optString("number"));
        localco.setNumber(str5);
        localObject1 = ((JSONObject)localObject2).optJSONArray("pois");
        if (((JSONArray)localObject1).length() <= 0) {
          break label392;
        }
        localObject1 = b(((JSONArray)localObject1).getJSONObject(0).optString("name"));
        localco.setPoiName((String)localObject1);
        localObject2 = ((JSONObject)localObject2).optJSONArray("aois");
        if (((JSONArray)localObject2).length() > 0) {
          localco.setAoiName(b(((JSONArray)localObject2).getJSONObject(0).optString("name")));
        }
        a(localco, str1, paramString, str2, str4, str5, (String)localObject1, str3);
        return localco;
      }
      catch (Throwable paramString)
      {
        return null;
      }
      label386:
      continue;
      label389:
      continue;
      label392:
      Object localObject1 = null;
    }
  }
  
  public final co a(String paramString, Context paramContext, bo parambo, d paramd)
  {
    co localco = new co("");
    localco.setErrorCode(7);
    StringBuffer localStringBuffer = new StringBuffer();
    for (;;)
    {
      try
      {
        localStringBuffer.append("#SHA1AndPackage#");
        localStringBuffer.append(l.e(paramContext));
        paramContext = (String)((List)parambo.b.get("gsid")).get(0);
        if (!TextUtils.isEmpty(paramContext))
        {
          localStringBuffer.append("#gsid#");
          localStringBuffer.append(paramContext);
        }
        paramContext = parambo.c;
        if (!TextUtils.isEmpty(paramContext))
        {
          localObject = new StringBuilder("#csid#");
          ((StringBuilder)localObject).append(paramContext);
          localStringBuffer.append(((StringBuilder)localObject).toString());
        }
      }
      catch (Throwable paramContext)
      {
        Object localObject;
        continue;
      }
      try
      {
        paramContext = new JSONObject(paramString);
        if ((!paramContext.has("status")) || (!paramContext.has("info")))
        {
          paramd.e("#0702");
          localObject = this.a;
          ((StringBuilder)localObject).append("json is error:");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(localStringBuffer);
          ((StringBuilder)localObject).append("#0702");
        }
        localObject = paramContext.getString("status");
        paramString = paramContext.getString("info");
        paramContext = paramContext.getString("infocode");
        if ("0".equals(localObject))
        {
          paramd.e("#0701");
          localObject = this.a;
          ((StringBuilder)localObject).append("auth fail:");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(localStringBuffer);
          ((StringBuilder)localObject).append("#0701");
          dk.a(parambo.d, paramContext, paramString);
        }
      }
      catch (Throwable paramString)
      {
        paramd.e("#0703");
        paramContext = this.a;
        paramContext.append("json exception error:");
        paramContext.append(paramString.getMessage());
        paramContext.append(localStringBuffer);
        paramContext.append("#0703");
        dg.a(paramString, "parser", "paseAuthFailurJson");
      }
    }
    localco.setLocationDetail(this.a.toString());
    if (this.a.length() > 0) {
      this.a.delete(0, this.a.length());
    }
    return localco;
  }
  
  public final void a(AMapLocationClientOption paramAMapLocationClientOption)
  {
    if (paramAMapLocationClientOption == null)
    {
      this.b = new AMapLocationClientOption();
      return;
    }
    this.b = paramAMapLocationClientOption;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\dd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */