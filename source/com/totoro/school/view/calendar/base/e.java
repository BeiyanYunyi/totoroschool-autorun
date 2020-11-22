package com.totoro.school.view.calendar.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public final class e
{
  private static String[] b = null;
  private static String[] c = null;
  private static String[] d = null;
  private static String[] e = null;
  @SuppressLint({"UseSparseArrays"})
  private static final Map<Integer, String[]> f = new HashMap();
  private static String[] g = null;
  @SuppressLint({"UseSparseArrays"})
  private static final Map<Integer, String[]> h = new HashMap();
  private static final int[] i = { 19416, 19168, 42352, 21717, 53856, 55632, 91476, 22176, 39632, 21970, 19168, 42422, 42192, 53840, 119381, 46400, 54944, 44450, 38320, 84343, 18800, 42160, 46261, 27216, 27968, 109396, 11104, 38256, 21234, 18800, 25958, 54432, 59984, 28309, 23248, 11104, 100067, 37600, 116951, 51536, 54432, 120998, 46416, 22176, 107956, 9680, 37584, 53938, 43344, 46423, 27808, 46416, 86869, 19872, 42416, 83315, 21168, 43432, 59728, 27296, 44710, 43856, 19296, 43748, 42352, 21088, 62051, 55632, 23383, 22176, 38608, 19925, 19152, 42192, 54484, 53840, 54616, 46400, 46752, 103846, 38320, 18864, 43380, 42160, 45690, 27216, 27968, 44870, 43872, 38256, 19189, 18800, 25776, 29859, 59984, 27480, 21952, 43872, 38613, 37600, 51552, 55636, 54432, 55888, 30034, 22176, 43959, 9680, 37584, 51893, 43344, 46240, 47780, 44368, 21977, 19360, 42416, 86390, 21168, 43312, 31060, 27296, 44368, 23378, 19296, 42726, 42208, 53856, 60005, 54576, 23200, 30371, 38608, 19195, 19152, 42192, 118966, 53840, 54560, 56645, 46496, 22224, 21938, 18864, 42359, 42160, 43600, 111189, 27936, 44448, 84835, 37744, 18936, 18800, 25776, 92326, 59984, 27424, 108228, 43744, 41696, 53987, 51552, 54615, 54432, 55888, 23893, 22176, 42704, 21972, 21200, 43448, 43344, 46240, 46758, 44368, 21920, 43940, 42416, 21168, 45683, 26928, 29495, 27296, 44368, 84821, 19296, 42352, 21732, 53600, 59752, 54560, 55968, 92838, 22224, 19168, 43476, 41680, 53584, 62034, 54560 };
  
  public static int a(int paramInt1, int paramInt2)
  {
    if ((i[(paramInt1 - 1900)] & 65536 >> paramInt2) == 0) {
      return 29;
    }
    return 30;
  }
  
  private static String a(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = 0;
    if ((paramInt2 == 12) && (paramInt3 == a(paramInt1, paramInt2))) {
      return c[0];
    }
    String str1 = d(paramInt2, paramInt3);
    String[] arrayOfString = c;
    paramInt2 = arrayOfString.length;
    paramInt1 = j;
    while (paramInt1 < paramInt2)
    {
      String str2 = arrayOfString[paramInt1];
      if (str2.contains(str1)) {
        return str2.replace(str1, "");
      }
      paramInt1 += 1;
    }
    return "";
  }
  
  static void a(Context paramContext)
  {
    if (b != null) {
      return;
    }
    i.a(paramContext);
    h.a(paramContext);
    b = paramContext.getResources().getStringArray(2130903041);
    c = paramContext.getResources().getStringArray(2130903047);
    d = paramContext.getResources().getStringArray(2130903042);
    e = paramContext.getResources().getStringArray(2130903046);
    g = paramContext.getResources().getStringArray(2130903044);
  }
  
  public static void a(b paramb)
  {
    int j = paramb.getYear();
    int k = paramb.getMonth();
    int m = paramb.getDay();
    paramb.setWeekend(c.a(paramb));
    paramb.setWeek(c.b(paramb));
    b localb = new b();
    paramb.setLunarCalendar(localb);
    Object localObject = f.a(j, k, m);
    localb.setYear(localObject[0]);
    localb.setMonth(localObject[1]);
    localb.setDay(localObject[2]);
    paramb.setLeapYear(c.a(j));
    if (localObject[3] == 1)
    {
      paramb.setLeapMonth(localObject[1]);
      localb.setLeapMonth(localObject[1]);
    }
    String str2 = c(j, k, m);
    String str1 = c(k, m);
    String str3 = a(localObject[0], localObject[1], localObject[2]);
    String str4 = b(localObject[1], localObject[2], localObject[3]);
    localObject = str1;
    if (TextUtils.isEmpty(str1)) {
      localObject = d(j, k, m);
    }
    paramb.setSolarTerm(str2);
    paramb.setGregorianFestival((String)localObject);
    paramb.setTraditionFestival(str3);
    localb.setTraditionFestival(str3);
    localb.setSolarTerm(str2);
    if (!TextUtils.isEmpty(str2)) {
      paramb.setLunar(str2);
    } else if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramb.setLunar((String)localObject);
    } else if (!TextUtils.isEmpty(str3)) {
      paramb.setLunar(str3);
    } else {
      paramb.setLunar(str4);
    }
    localb.setLunar(str4);
  }
  
  private static String[] a(int paramInt)
  {
    String[] arrayOfString = new String[3];
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).set(paramInt, 4, 1);
    int j = 7 - ((Calendar)localObject).get(7) + 1;
    StringBuilder localStringBuilder;
    if (j == 7)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(e(paramInt, 5, j + 1));
      localStringBuilder.append(e[0]);
      arrayOfString[0] = localStringBuilder.toString();
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(e(paramInt, 5, j + 7 + 1));
      localStringBuilder.append(e[0]);
      arrayOfString[0] = localStringBuilder.toString();
    }
    ((Calendar)localObject).set(paramInt, 5, 1);
    j = 7 - ((Calendar)localObject).get(7) + 1;
    if (j == 7)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(e(paramInt, 6, j + 7 + 1));
      localStringBuilder.append(e[1]);
      arrayOfString[1] = localStringBuilder.toString();
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(e(paramInt, 6, j + 7 + 7 + 1));
      localStringBuilder.append(e[1]);
      arrayOfString[1] = localStringBuilder.toString();
    }
    ((Calendar)localObject).set(paramInt, 10, 1);
    j = 7 - ((Calendar)localObject).get(7) + 1;
    if (j <= 2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(e(paramInt, 11, j + 21 + 5));
      ((StringBuilder)localObject).append(e[2]);
      arrayOfString[2] = ((StringBuilder)localObject).toString();
      return arrayOfString;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(e(paramInt, 11, j + 14 + 5));
    ((StringBuilder)localObject).append(e[2]);
    arrayOfString[2] = ((StringBuilder)localObject).toString();
    return arrayOfString;
  }
  
  private static String b(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("闰");
      localStringBuilder.append(b[(paramInt1 - 1)]);
      return localStringBuilder.toString();
    }
    return b[(paramInt1 - 1)];
  }
  
  private static String b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt2 == 1) {
      return b(paramInt1, paramInt3);
    }
    return d[(paramInt2 - 1)];
  }
  
  private static String c(int paramInt1, int paramInt2)
  {
    String str1 = d(paramInt1, paramInt2);
    String[] arrayOfString = g;
    paramInt2 = arrayOfString.length;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      String str2 = arrayOfString[paramInt1];
      if (str2.contains(str1)) {
        return str2.replace(str1, "");
      }
      paramInt1 += 1;
    }
    return "";
  }
  
  private static String c(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!h.containsKey(Integer.valueOf(paramInt1))) {
      h.put(Integer.valueOf(paramInt1), h.a(paramInt1));
    }
    String[] arrayOfString = (String[])h.get(Integer.valueOf(paramInt1));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(d(paramInt2, paramInt3));
    localObject = ((StringBuilder)localObject).toString();
    if ((!a) && (arrayOfString == null)) {
      throw new AssertionError();
    }
    paramInt2 = arrayOfString.length;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      String str = arrayOfString[paramInt1];
      if (str.contains((CharSequence)localObject)) {
        return str.replace((CharSequence)localObject, "");
      }
      paramInt1 += 1;
    }
    return "";
  }
  
  private static String d(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject;
    if (paramInt1 >= 10)
    {
      localObject = String.valueOf(paramInt1);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("0");
      ((StringBuilder)localObject).append(paramInt1);
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append((String)localObject);
    if (paramInt2 >= 10)
    {
      localObject = Integer.valueOf(paramInt2);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("0");
      ((StringBuilder)localObject).append(paramInt2);
      localObject = ((StringBuilder)localObject).toString();
    }
    localStringBuilder.append(localObject);
    return localStringBuilder.toString();
  }
  
  private static String d(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!f.containsKey(Integer.valueOf(paramInt1))) {
      f.put(Integer.valueOf(paramInt1), a(paramInt1));
    }
    String[] arrayOfString = (String[])f.get(Integer.valueOf(paramInt1));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(d(paramInt2, paramInt3));
    localObject = ((StringBuilder)localObject).toString();
    if ((!a) && (arrayOfString == null)) {
      throw new AssertionError();
    }
    paramInt2 = arrayOfString.length;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      String str = arrayOfString[paramInt1];
      if (str.contains((CharSequence)localObject)) {
        return str.replace((CharSequence)localObject, "");
      }
      paramInt1 += 1;
    }
    return "";
  }
  
  private static String e(int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(d(paramInt2, paramInt3));
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\calendar\base\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */