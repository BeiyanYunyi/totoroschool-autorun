package com.totoro.school.view.calendar.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

final class c
{
  static int a(int paramInt1, int paramInt2)
  {
    int i;
    if ((paramInt2 != 1) && (paramInt2 != 3) && (paramInt2 != 5) && (paramInt2 != 7) && (paramInt2 != 8) && (paramInt2 != 10) && (paramInt2 != 12)) {
      i = 0;
    } else {
      i = 31;
    }
    if ((paramInt2 == 4) || (paramInt2 == 6) || (paramInt2 == 9) || (paramInt2 == 11)) {
      i = 30;
    }
    if (paramInt2 == 2)
    {
      if (a(paramInt1)) {
        return 29;
      }
      i = 28;
    }
    return i;
  }
  
  static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(paramInt1, paramInt2 - 1, 1);
    paramInt2 = localCalendar.get(7);
    if (paramInt3 == 1) {
      return paramInt2 - 1;
    }
    if (paramInt3 == 2)
    {
      if (paramInt2 == 1) {
        return 6;
      }
      return paramInt2 - paramInt3;
    }
    paramInt1 = paramInt2;
    if (paramInt2 == 7) {
      paramInt1 = 0;
    }
    return paramInt1;
  }
  
  static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt4 == 0) {
      return 6;
    }
    paramInt4 = b(paramInt1, paramInt2, paramInt3);
    return (a(paramInt1, paramInt2, paramInt3) + a(paramInt1, paramInt2) + paramInt4) / 7;
  }
  
  static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt5 == 0) {
      return paramInt3 * 6;
    }
    return b(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(paramInt1, paramInt2 - 1, paramInt3);
    long l1 = localCalendar.getTimeInMillis();
    paramInt1 = d(paramInt1, paramInt2, paramInt3, paramInt7);
    localCalendar.set(paramInt4, paramInt5 - 1, paramInt6);
    long l2 = localCalendar.getTimeInMillis();
    return (paramInt1 + e(paramInt4, paramInt5, paramInt6, paramInt7) + ((int)((l2 - l1) / 86400000L) + 1)) / 7;
  }
  
  static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  static int a(b paramb, int paramInt)
  {
    Calendar.getInstance().set(paramb.getYear(), paramb.getMonth() - 1, 1);
    paramInt = b(paramb, paramInt);
    return (paramb.getDay() + paramInt - 1) / 7 + 1;
  }
  
  static int a(b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(paramInt1, paramInt2 - 1, paramInt3);
    long l = localCalendar.getTimeInMillis();
    paramInt2 = d(paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = d(paramb.getYear(), paramb.getMonth(), paramb.getDay(), paramInt4);
    paramInt3 = paramb.getYear();
    paramInt4 = paramb.getMonth();
    if (paramInt1 == 0) {
      paramInt1 = paramb.getDay() + 1;
    } else {
      paramInt1 = paramb.getDay();
    }
    localCalendar.set(paramInt3, paramInt4 - 1, paramInt1);
    return (paramInt2 + (int)((localCalendar.getTimeInMillis() - l) / 86400000L)) / 7 + 1;
  }
  
  static int a(b paramb1, b paramb2)
  {
    if (paramb1 == null) {
      return Integer.MIN_VALUE;
    }
    if (paramb2 == null) {
      return Integer.MAX_VALUE;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(paramb1.getYear(), paramb1.getMonth() - 1, paramb1.getDay());
    long l = localCalendar.getTimeInMillis();
    localCalendar.set(paramb2.getYear(), paramb2.getMonth() - 1, paramb2.getDay());
    return (int)((l - localCalendar.getTimeInMillis()) / 86400000L);
  }
  
  @SuppressLint({"SimpleDateFormat"})
  static int a(String paramString, Date paramDate)
  {
    return Integer.parseInt(new SimpleDateFormat(paramString).format(paramDate));
  }
  
  static b a(int paramInt, d paramd)
  {
    b localb2 = new b();
    int i = paramd.D();
    boolean bool = true;
    localb2.setYear((i + paramInt - 1) / 12 + paramd.y());
    localb2.setMonth((paramInt + paramd.D() - 1) % 12 + 1);
    if (paramd.Y() != 0)
    {
      paramInt = a(localb2.getYear(), localb2.getMonth());
      localb1 = paramd.p;
      if ((localb1 != null) && (localb1.getDay() != 0))
      {
        if (paramInt >= localb1.getDay()) {
          paramInt = localb1.getDay();
        }
      }
      else {
        paramInt = 1;
      }
      localb2.setDay(paramInt);
    }
    else
    {
      localb2.setDay(1);
    }
    b localb1 = localb2;
    if (!a(localb2, paramd)) {
      if (d(localb2, paramd)) {
        localb1 = paramd.an();
      } else {
        localb1 = paramd.ao();
      }
    }
    if ((localb1.getYear() != paramd.ae().getYear()) || (localb1.getMonth() != paramd.ae().getMonth())) {
      bool = false;
    }
    localb1.setCurrentMonth(bool);
    localb1.setCurrentDay(localb1.equals(paramd.ae()));
    e.a(localb1);
    return localb1;
  }
  
  static List<b> a(int paramInt1, int paramInt2, b paramb, int paramInt3)
  {
    Object localObject = Calendar.getInstance();
    int i = paramInt2 - 1;
    ((Calendar)localObject).set(paramInt1, i, 1);
    int i2 = a(paramInt1, paramInt2, paramInt3);
    int i3 = a(paramInt1, paramInt2);
    localObject = new ArrayList();
    int k = 12;
    int n = 0;
    int m;
    int j;
    if (paramInt2 == 1)
    {
      i = paramInt1 - 1;
      if (i2 == 0) {
        paramInt3 = 0;
      } else {
        paramInt3 = a(i, 12);
      }
      m = paramInt3;
      i1 = paramInt2 + 1;
      j = paramInt1;
      paramInt3 = i;
      i = k;
      k = i1;
    }
    else if (paramInt2 == 12)
    {
      if (i2 == 0) {
        paramInt3 = 0;
      } else {
        paramInt3 = a(paramInt1, i);
      }
      j = paramInt1 + 1;
      m = paramInt3;
      k = 1;
      paramInt3 = paramInt1;
    }
    else
    {
      if (i2 == 0) {
        paramInt3 = 0;
      } else {
        paramInt3 = a(paramInt1, i);
      }
      j = paramInt1;
      m = paramInt3;
      k = paramInt2 + 1;
      paramInt3 = j;
    }
    int i1 = 1;
    while (n < 42)
    {
      b localb = new b();
      if (n < i2)
      {
        localb.setYear(paramInt3);
        localb.setMonth(i);
        localb.setDay(m - i2 + n + 1);
      }
      else if (n >= i3 + i2)
      {
        localb.setYear(j);
        localb.setMonth(k);
        localb.setDay(i1);
        i1 += 1;
      }
      else
      {
        localb.setYear(paramInt1);
        localb.setMonth(paramInt2);
        localb.setCurrentMonth(true);
        localb.setDay(n - i2 + 1);
      }
      if (localb.equals(paramb)) {
        localb.setCurrentDay(true);
      }
      e.a(localb);
      ((List)localObject).add(localb);
      n += 1;
    }
    return (List<b>)localObject;
  }
  
  static List<b> a(b paramb, d paramd, int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(paramb.getYear(), paramb.getMonth() - 1, paramb.getDay());
    long l = localCalendar.getTimeInMillis();
    int i = e(paramb.getYear(), paramb.getMonth(), paramb.getDay(), paramInt);
    paramb = new ArrayList();
    localCalendar.setTimeInMillis(l);
    b localb = new b();
    localb.setYear(localCalendar.get(1));
    localb.setMonth(localCalendar.get(2) + 1);
    localb.setDay(localCalendar.get(5));
    if (localb.equals(paramd.ae())) {
      localb.setCurrentDay(true);
    }
    e.a(localb);
    localb.setCurrentMonth(true);
    paramb.add(localb);
    paramInt = 1;
    while (paramInt <= i)
    {
      localCalendar.setTimeInMillis(paramInt * 86400000L + l);
      localb = new b();
      localb.setYear(localCalendar.get(1));
      localb.setMonth(localCalendar.get(2) + 1);
      localb.setDay(localCalendar.get(5));
      if (localb.equals(paramd.ae())) {
        localb.setCurrentDay(true);
      }
      e.a(localb);
      localb.setCurrentMonth(true);
      paramb.add(localb);
      paramInt += 1;
    }
    return paramb;
  }
  
  static boolean a(int paramInt)
  {
    return ((paramInt % 4 == 0) && (paramInt % 100 != 0)) || (paramInt % 400 == 0);
  }
  
  static boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    return (paramInt1 >= paramInt3) && (paramInt1 <= paramInt5) && ((paramInt1 != paramInt3) || (paramInt2 >= paramInt4)) && ((paramInt1 != paramInt5) || (paramInt2 <= paramInt6));
  }
  
  static boolean a(b paramb)
  {
    int i = b(paramb);
    return (i == 0) || (i == 6);
  }
  
  static boolean a(b paramb, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(paramInt1, paramInt2 - 1, paramInt3);
    long l1 = localCalendar.getTimeInMillis();
    localCalendar.set(paramInt4, paramInt5 - 1, paramInt6);
    long l2 = localCalendar.getTimeInMillis();
    localCalendar.set(paramb.getYear(), paramb.getMonth() - 1, paramb.getDay());
    long l3 = localCalendar.getTimeInMillis();
    return (l3 >= l1) && (l3 <= l2);
  }
  
  static boolean a(b paramb, d paramd)
  {
    return a(paramb, paramd.y(), paramd.D(), paramd.ai(), paramd.z(), paramd.E(), paramd.aj());
  }
  
  static int b(int paramInt1, int paramInt2, int paramInt3)
  {
    return c(paramInt1, paramInt2, a(paramInt1, paramInt2), paramInt3);
  }
  
  static int b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Calendar.getInstance().set(paramInt1, paramInt2 - 1, 1);
    int i = a(paramInt1, paramInt2, paramInt4);
    int j = a(paramInt1, paramInt2);
    return (i + j + c(paramInt1, paramInt2, j, paramInt4)) / 7 * paramInt3;
  }
  
  static int b(b paramb)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(paramb.getYear(), paramb.getMonth() - 1, paramb.getDay());
    return localCalendar.get(7) - 1;
  }
  
  static int b(b paramb, int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(paramb.getYear(), paramb.getMonth() - 1, 1);
    int i = localCalendar.get(7);
    if (paramInt == 1) {
      return i - 1;
    }
    if (paramInt == 2)
    {
      if (i == 1) {
        return 6;
      }
      return i - paramInt;
    }
    paramInt = i;
    if (i == 7) {
      paramInt = 0;
    }
    return paramInt;
  }
  
  static b b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(paramInt1, paramInt2 - 1, paramInt3);
    long l = localCalendar.getTimeInMillis();
    l = (paramInt4 - 1) * 7 * 86400000L + l;
    localCalendar.setTimeInMillis(l);
    localCalendar.setTimeInMillis(l - d(localCalendar.get(1), localCalendar.get(2) + 1, localCalendar.get(5), paramInt5) * 86400000L);
    b localb = new b();
    localb.setYear(localCalendar.get(1));
    localb.setMonth(localCalendar.get(2) + 1);
    localb.setDay(localCalendar.get(5));
    return localb;
  }
  
  static List<b> b(b paramb, d paramd)
  {
    long l1 = paramb.getTimeInMillis();
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).set(paramb.getYear(), paramb.getMonth() - 1, paramb.getDay());
    int j = ((Calendar)localObject).get(7);
    int i;
    if (paramd.X() == 1)
    {
      i = j - 1;
    }
    else if (paramd.X() == 2)
    {
      if (j == 1) {
        i = 6;
      } else {
        i = j - paramd.X();
      }
    }
    else
    {
      i = j;
      if (j == 7) {
        i = 0;
      }
    }
    long l2 = i;
    paramb = Calendar.getInstance();
    paramb.setTimeInMillis(l1 - l2 * 86400000L);
    localObject = new b();
    ((b)localObject).setYear(paramb.get(1));
    ((b)localObject).setMonth(paramb.get(2) + 1);
    ((b)localObject).setDay(paramb.get(5));
    return a((b)localObject, paramd, paramd.X());
  }
  
  private static int c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(paramInt1, paramInt2 - 1, paramInt3);
    paramInt1 = localCalendar.get(7);
    if (paramInt4 == 1) {
      return 7 - paramInt1;
    }
    if (paramInt4 == 2)
    {
      if (paramInt1 == 1) {
        return 0;
      }
      return 7 - paramInt1 + 1;
    }
    if (paramInt1 == 7) {
      return 6;
    }
    return 7 - paramInt1 - 1;
  }
  
  static int c(b paramb, int paramInt)
  {
    return d(paramb.getYear(), paramb.getMonth(), paramb.getDay(), paramInt);
  }
  
  static b c(b paramb, d paramd)
  {
    if ((a(paramd.ae(), paramd)) && (paramd.Y() != 2)) {
      return paramd.am();
    }
    if (a(paramb, paramd)) {
      return paramb;
    }
    if (paramd.an().isSameMonth(paramb)) {
      return paramd.an();
    }
    return paramd.ao();
  }
  
  private static int d(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(paramInt1, paramInt2 - 1, paramInt3);
    paramInt2 = localCalendar.get(7);
    if (paramInt4 == 1) {
      return paramInt2 - 1;
    }
    if (paramInt4 == 2)
    {
      if (paramInt2 == 1) {
        return 6;
      }
      return paramInt2 - paramInt4;
    }
    paramInt1 = paramInt2;
    if (paramInt2 == 7) {
      paramInt1 = 0;
    }
    return paramInt1;
  }
  
  private static boolean d(b paramb, d paramd)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(paramd.y(), paramd.D() - 1, paramd.ai());
    long l = localCalendar.getTimeInMillis();
    localCalendar.set(paramb.getYear(), paramb.getMonth() - 1, paramb.getDay());
    return localCalendar.getTimeInMillis() < l;
  }
  
  private static int e(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(paramInt1, paramInt2 - 1, paramInt3);
    paramInt1 = localCalendar.get(7);
    if (paramInt4 == 1) {
      return 7 - paramInt1;
    }
    if (paramInt4 == 2)
    {
      if (paramInt1 == 1) {
        return 0;
      }
      return 7 - paramInt1 + 1;
    }
    if (paramInt1 == 7) {
      return 6;
    }
    return 7 - paramInt1 - 1;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\calendar\base\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */