package com.totoro.school.utils;

import com.loonggg.lunarlib.LunarCalendar;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class c
{
  public static String a()
  {
    switch (Calendar.getInstance().get(7))
    {
    default: 
      return "";
    case 7: 
      return "星期六";
    case 6: 
      return "星期五";
    case 5: 
      return "星期四";
    case 4: 
      return "星期三";
    case 3: 
      return "星期二";
    case 2: 
      return "星期一";
    }
    return "星期日";
  }
  
  public static String a(String paramString)
  {
    return new SimpleDateFormat(paramString).format(new Date(System.currentTimeMillis()));
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 36	java/text/SimpleDateFormat
    //   3: dup
    //   4: ldc 60
    //   6: invokespecial 40	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   9: astore_3
    //   10: aload_3
    //   11: aload_3
    //   12: new 42	java/util/Date
    //   15: dup
    //   16: invokespecial 63	java/util/Date:<init>	()V
    //   19: invokevirtual 55	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   22: invokevirtual 67	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   25: astore_2
    //   26: aload_3
    //   27: aload_0
    //   28: invokevirtual 67	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   31: astore_0
    //   32: aload_3
    //   33: aload_1
    //   34: invokevirtual 67	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   37: astore_3
    //   38: aload_2
    //   39: astore_1
    //   40: aload_3
    //   41: astore_2
    //   42: goto +32 -> 74
    //   45: astore_3
    //   46: aload_2
    //   47: astore_1
    //   48: aload_3
    //   49: astore_2
    //   50: goto +18 -> 68
    //   53: astore_3
    //   54: aconst_null
    //   55: astore_0
    //   56: aload_2
    //   57: astore_1
    //   58: aload_3
    //   59: astore_2
    //   60: goto +8 -> 68
    //   63: astore_2
    //   64: aconst_null
    //   65: astore_0
    //   66: aload_0
    //   67: astore_1
    //   68: aload_2
    //   69: invokevirtual 70	java/lang/Exception:printStackTrace	()V
    //   72: aconst_null
    //   73: astore_2
    //   74: invokestatic 12	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   77: astore_3
    //   78: aload_3
    //   79: aload_1
    //   80: invokevirtual 74	java/util/Calendar:setTime	(Ljava/util/Date;)V
    //   83: invokestatic 12	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   86: astore_1
    //   87: aload_1
    //   88: aload_0
    //   89: invokevirtual 74	java/util/Calendar:setTime	(Ljava/util/Date;)V
    //   92: invokestatic 12	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   95: astore_0
    //   96: aload_0
    //   97: aload_2
    //   98: invokevirtual 74	java/util/Calendar:setTime	(Ljava/util/Date;)V
    //   101: aload_3
    //   102: aload_1
    //   103: invokevirtual 78	java/util/Calendar:after	(Ljava/lang/Object;)Z
    //   106: ifeq +13 -> 119
    //   109: aload_3
    //   110: aload_0
    //   111: invokevirtual 81	java/util/Calendar:before	(Ljava/lang/Object;)Z
    //   114: ifeq +5 -> 119
    //   117: iconst_1
    //   118: ireturn
    //   119: iconst_0
    //   120: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	paramString1	String
    //   0	121	1	paramString2	String
    //   25	35	2	localObject1	Object
    //   63	6	2	localException1	Exception
    //   73	25	2	localDate	Date
    //   9	32	3	localObject2	Object
    //   45	4	3	localException2	Exception
    //   53	6	3	localException3	Exception
    //   77	33	3	localCalendar	Calendar
    // Exception table:
    //   from	to	target	type
    //   32	38	45	java/lang/Exception
    //   26	32	53	java/lang/Exception
    //   10	26	63	java/lang/Exception
  }
  
  /* Error */
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: new 36	java/text/SimpleDateFormat
    //   3: dup
    //   4: ldc 86
    //   6: invokespecial 40	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   9: astore 10
    //   11: aload 10
    //   13: aload_0
    //   14: invokevirtual 67	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   17: astore_0
    //   18: aload 10
    //   20: aload_1
    //   21: invokevirtual 67	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   24: astore 9
    //   26: aload 10
    //   28: aload_2
    //   29: invokevirtual 67	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   32: astore_2
    //   33: goto +40 -> 73
    //   36: astore_2
    //   37: aload_0
    //   38: astore_1
    //   39: aload 9
    //   41: astore_0
    //   42: goto +20 -> 62
    //   45: astore_2
    //   46: aconst_null
    //   47: astore 9
    //   49: aload_0
    //   50: astore_1
    //   51: aload 9
    //   53: astore_0
    //   54: goto +8 -> 62
    //   57: astore_2
    //   58: aconst_null
    //   59: astore_1
    //   60: aload_1
    //   61: astore_0
    //   62: aload_2
    //   63: invokevirtual 87	java/text/ParseException:printStackTrace	()V
    //   66: aconst_null
    //   67: astore_2
    //   68: aload_0
    //   69: astore 9
    //   71: aload_1
    //   72: astore_0
    //   73: aload_0
    //   74: invokevirtual 90	java/util/Date:getTime	()J
    //   77: lstore_3
    //   78: aload 9
    //   80: invokevirtual 90	java/util/Date:getTime	()J
    //   83: lstore 5
    //   85: aload_2
    //   86: invokevirtual 90	java/util/Date:getTime	()J
    //   89: lstore 7
    //   91: lload_3
    //   92: lload 5
    //   94: lcmp
    //   95: iflt +12 -> 107
    //   98: lload_3
    //   99: lload 7
    //   101: lcmp
    //   102: ifgt +5 -> 107
    //   105: iconst_1
    //   106: ireturn
    //   107: iconst_0
    //   108: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	paramString1	String
    //   0	109	1	paramString2	String
    //   0	109	2	paramString3	String
    //   77	22	3	l1	long
    //   83	10	5	l2	long
    //   89	11	7	l3	long
    //   24	55	9	localObject	Object
    //   9	18	10	localSimpleDateFormat	SimpleDateFormat
    // Exception table:
    //   from	to	target	type
    //   26	33	36	java/text/ParseException
    //   18	26	45	java/text/ParseException
    //   11	18	57	java/text/ParseException
  }
  
  public static String b()
  {
    Calendar localCalendar = Calendar.getInstance();
    return LunarCalendar.getLunarMonthDay(localCalendar.get(1), localCalendar.get(2) + 1, localCalendar.get(5));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\utils\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */