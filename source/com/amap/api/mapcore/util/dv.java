package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class dv
{
  private static boolean a = false;
  private static boolean b = false;
  private static boolean c = false;
  private static boolean d = false;
  private static boolean e = false;
  private static boolean f = false;
  private static boolean g = false;
  private static boolean h = false;
  private static boolean i = false;
  private static HashMap<String, Boolean> j = new HashMap();
  
  private static <T> String a(Map<String, T> paramMap)
  {
    try
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("{");
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("\"");
        localStringBuilder2.append((String)localEntry.getKey());
        localStringBuilder2.append("\":");
        localStringBuilder1.append(localStringBuilder2.toString());
        localStringBuilder1.append(localEntry.getValue());
        localStringBuilder1.append(",");
      }
      localStringBuilder1.deleteCharAt(localStringBuilder1.length() - 1);
      localStringBuilder1.append("}");
      paramMap = localStringBuilder1.toString();
      return paramMap;
    }
    catch (Throwable paramMap)
    {
      paramMap.printStackTrace();
    }
    return null;
  }
  
  private static String a(boolean paramBoolean)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("{\"Quest\":");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("}");
      localObject = ((StringBuilder)localObject).toString();
      return (String)localObject;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public static void a(Context paramContext)
  {
    if (c) {
      return;
    }
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("amap_3dmap_heatmap", Integer.valueOf(1));
      a(paramContext, "O009", a(localHashMap));
      c = true;
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static void a(Context paramContext, long paramLong)
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("amap_3dmap_rendertime", Long.valueOf(paramLong));
      localHashMap.put("amap_3dmap_render_background", Long.valueOf(0L));
      a(paramContext, "O005", a(localHashMap));
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  /* Error */
  public static void a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 27	com/amap/api/mapcore/util/dv:j	Ljava/util/HashMap;
    //   6: ifnull +96 -> 102
    //   9: aload_1
    //   10: invokestatic 147	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +6 -> 19
    //   16: goto +86 -> 102
    //   19: getstatic 27	com/amap/api/mapcore/util/dv:j	Ljava/util/HashMap;
    //   22: aload_1
    //   23: invokevirtual 151	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   26: ifeq +25 -> 51
    //   29: getstatic 27	com/amap/api/mapcore/util/dv:j	Ljava/util/HashMap;
    //   32: aload_1
    //   33: invokevirtual 155	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   36: checkcast 157	java/lang/Boolean
    //   39: invokevirtual 160	java/lang/Boolean:booleanValue	()Z
    //   42: istore_2
    //   43: iload_2
    //   44: ifeq +7 -> 51
    //   47: ldc 2
    //   49: monitorexit
    //   50: return
    //   51: new 22	java/util/HashMap
    //   54: dup
    //   55: invokespecial 25	java/util/HashMap:<init>	()V
    //   58: astore_3
    //   59: aload_3
    //   60: ldc -94
    //   62: aload_1
    //   63: invokevirtual 121	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   66: pop
    //   67: aload_0
    //   68: ldc -92
    //   70: aload_3
    //   71: invokestatic 125	com/amap/api/mapcore/util/dv:a	(Ljava/util/Map;)Ljava/lang/String;
    //   74: invokestatic 128	com/amap/api/mapcore/util/dv:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   77: getstatic 27	com/amap/api/mapcore/util/dv:j	Ljava/util/HashMap;
    //   80: aload_1
    //   81: invokevirtual 151	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   84: ifne +28 -> 112
    //   87: getstatic 27	com/amap/api/mapcore/util/dv:j	Ljava/util/HashMap;
    //   90: aload_1
    //   91: iconst_1
    //   92: invokestatic 167	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   95: invokevirtual 121	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   98: pop
    //   99: goto +13 -> 112
    //   102: ldc 2
    //   104: monitorexit
    //   105: return
    //   106: astore_0
    //   107: ldc 2
    //   109: monitorexit
    //   110: aload_0
    //   111: athrow
    //   112: ldc 2
    //   114: monitorexit
    //   115: return
    //   116: astore_0
    //   117: goto -5 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramContext	Context
    //   0	120	1	paramString	String
    //   42	2	2	bool	boolean
    //   58	13	3	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   3	16	106	finally
    //   19	43	106	finally
    //   51	99	106	finally
    //   3	16	116	java/lang/Throwable
    //   19	43	116	java/lang/Throwable
    //   51	99	116	java/lang/Throwable
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      return;
    }
    try
    {
      paramString1 = new in(paramContext, "3dmap", "7.1.0", paramString1);
      paramString1.a(paramString2);
      io.a(paramString1, paramContext);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    try
    {
      String str = a(paramBoolean);
      in localin = new in(paramContext, "3dmap", "7.1.0", "O001");
      localin.a(str);
      io.a(localin, paramContext);
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void b(Context paramContext)
  {
    if (d) {
      return;
    }
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("amap_3dmap_offlinemap", Integer.valueOf(1));
      a(paramContext, "O010", a(localHashMap));
      d = true;
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static void b(Context paramContext, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void c(Context paramContext)
  {
    if (e) {
      return;
    }
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("amap_3dmap_particleoverlay", Integer.valueOf(1));
      a(paramContext, "O011", a(localHashMap));
      e = true;
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static void c(Context paramContext, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void d(Context paramContext)
  {
    if (g) {
      return;
    }
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("amap_3dmap_bzmapreview", Integer.valueOf(1));
      a(paramContext, "O012", a(localHashMap));
      g = true;
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static void e(Context paramContext)
  {
    if (h) {
      return;
    }
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("amap_3dmap_wxmapreview", Integer.valueOf(1));
      a(paramContext, "O013", a(localHashMap));
      h = true;
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static void f(Context paramContext)
  {
    if (f) {
      return;
    }
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("amap_3dmap_renderfps", Integer.valueOf(1));
      a(paramContext, "O014", a(localHashMap));
      f = true;
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static void g(Context paramContext)
  {
    if (i) {
      return;
    }
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("amap_3dmap_buildingoverlay", Integer.valueOf(1));
      a(paramContext, "O015", a(localHashMap));
      i = true;
      return;
    }
    catch (Throwable paramContext) {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\dv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */