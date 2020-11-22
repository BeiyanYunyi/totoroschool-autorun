package com.totoro.school.view.calendar.base;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public final class b
  implements Serializable, Comparable<b>
{
  private static final long serialVersionUID = 141315161718191143L;
  private int day;
  private String gregorianFestival;
  private boolean isCurrentDay;
  private boolean isCurrentMonth;
  private boolean isLeapYear;
  private boolean isWeekend;
  private int leapMonth;
  private String lunar;
  private b lunarCalendar;
  private int month;
  private String scheme;
  private int schemeColor;
  private List<a> schemes;
  private String solarTerm;
  private String traditionFestival;
  private int week;
  private int year;
  
  public void addScheme(int paramInt1, int paramInt2, String paramString)
  {
    if (this.schemes == null) {
      this.schemes = new ArrayList();
    }
    this.schemes.add(new a(paramInt1, paramInt2, paramString));
  }
  
  public void addScheme(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (this.schemes == null) {
      this.schemes = new ArrayList();
    }
    this.schemes.add(new a(paramInt1, paramInt2, paramString1, paramString2));
  }
  
  public void addScheme(int paramInt, String paramString)
  {
    if (this.schemes == null) {
      this.schemes = new ArrayList();
    }
    this.schemes.add(new a(paramInt, paramString));
  }
  
  public void addScheme(int paramInt, String paramString1, String paramString2)
  {
    if (this.schemes == null) {
      this.schemes = new ArrayList();
    }
    this.schemes.add(new a(paramInt, paramString1, paramString2));
  }
  
  public void addScheme(a parama)
  {
    if (this.schemes == null) {
      this.schemes = new ArrayList();
    }
    this.schemes.add(parama);
  }
  
  final void clearScheme()
  {
    setScheme("");
    setSchemeColor(0);
    setSchemes(null);
  }
  
  public int compareTo(b paramb)
  {
    if (paramb == null) {
      return 1;
    }
    return toString().compareTo(paramb.toString());
  }
  
  public final int differ(b paramb)
  {
    return c.a(this, paramb);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof b)))
    {
      b localb = (b)paramObject;
      if ((localb.getYear() == this.year) && (localb.getMonth() == this.month) && (localb.getDay() == this.day)) {
        return true;
      }
    }
    return super.equals(paramObject);
  }
  
  public int getDay()
  {
    return this.day;
  }
  
  public String getGregorianFestival()
  {
    return this.gregorianFestival;
  }
  
  public int getLeapMonth()
  {
    return this.leapMonth;
  }
  
  public String getLunar()
  {
    return this.lunar;
  }
  
  public b getLunarCalendar()
  {
    return this.lunarCalendar;
  }
  
  public int getMonth()
  {
    return this.month;
  }
  
  public String getScheme()
  {
    return this.scheme;
  }
  
  public int getSchemeColor()
  {
    return this.schemeColor;
  }
  
  public List<a> getSchemes()
  {
    return this.schemes;
  }
  
  public String getSolarTerm()
  {
    return this.solarTerm;
  }
  
  public long getTimeInMillis()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, this.year);
    localCalendar.set(2, this.month - 1);
    localCalendar.set(5, this.day);
    return localCalendar.getTimeInMillis();
  }
  
  public String getTraditionFestival()
  {
    return this.traditionFestival;
  }
  
  public int getWeek()
  {
    return this.week;
  }
  
  public int getYear()
  {
    return this.year;
  }
  
  public boolean hasScheme()
  {
    if ((this.schemes != null) && (this.schemes.size() != 0)) {
      return true;
    }
    return !TextUtils.isEmpty(this.scheme);
  }
  
  public boolean isAvailable()
  {
    int i = this.year;
    int i2 = 0;
    if (i > 0) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (this.month > 0) {
      j = 1;
    } else {
      j = 0;
    }
    int k;
    if (this.day > 0) {
      k = 1;
    } else {
      k = 0;
    }
    int m;
    if (this.day <= 31) {
      m = 1;
    } else {
      m = 0;
    }
    int n;
    if (this.month <= 12) {
      n = 1;
    } else {
      n = 0;
    }
    int i1;
    if (this.year >= 1900) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (this.year <= 2099) {
      i2 = 1;
    }
    return i & j & k & m & n & i1 & i2;
  }
  
  public boolean isCurrentDay()
  {
    return this.isCurrentDay;
  }
  
  public boolean isCurrentMonth()
  {
    return this.isCurrentMonth;
  }
  
  public boolean isLeapYear()
  {
    return this.isLeapYear;
  }
  
  public boolean isSameMonth(b paramb)
  {
    return (this.year == paramb.getYear()) && (this.month == paramb.getMonth());
  }
  
  public boolean isWeekend()
  {
    return this.isWeekend;
  }
  
  final void mergeScheme(b paramb, String paramString)
  {
    if (paramb == null) {
      return;
    }
    if (!TextUtils.isEmpty(paramb.getScheme())) {
      paramString = paramb.getScheme();
    }
    setScheme(paramString);
    setSchemeColor(paramb.getSchemeColor());
    setSchemes(paramb.getSchemes());
  }
  
  public void setCurrentDay(boolean paramBoolean)
  {
    this.isCurrentDay = paramBoolean;
  }
  
  public void setCurrentMonth(boolean paramBoolean)
  {
    this.isCurrentMonth = paramBoolean;
  }
  
  public void setDay(int paramInt)
  {
    this.day = paramInt;
  }
  
  public void setGregorianFestival(String paramString)
  {
    this.gregorianFestival = paramString;
  }
  
  public void setLeapMonth(int paramInt)
  {
    this.leapMonth = paramInt;
  }
  
  public void setLeapYear(boolean paramBoolean)
  {
    this.isLeapYear = paramBoolean;
  }
  
  public void setLunar(String paramString)
  {
    this.lunar = paramString;
  }
  
  public void setLunarCalendar(b paramb)
  {
    this.lunarCalendar = paramb;
  }
  
  public void setMonth(int paramInt)
  {
    this.month = paramInt;
  }
  
  public void setScheme(String paramString)
  {
    this.scheme = paramString;
  }
  
  public void setSchemeColor(int paramInt)
  {
    this.schemeColor = paramInt;
  }
  
  public void setSchemes(List<a> paramList)
  {
    this.schemes = paramList;
  }
  
  public void setSolarTerm(String paramString)
  {
    this.solarTerm = paramString;
  }
  
  public void setTraditionFestival(String paramString)
  {
    this.traditionFestival = paramString;
  }
  
  public void setWeek(int paramInt)
  {
    this.week = paramInt;
  }
  
  public void setWeekend(boolean paramBoolean)
  {
    this.isWeekend = paramBoolean;
  }
  
  public void setYear(int paramInt)
  {
    this.year = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.year);
    localStringBuilder.append("");
    Object localObject;
    if (this.month < 10)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("0");
      ((StringBuilder)localObject).append(this.month);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = Integer.valueOf(this.month);
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append("");
    if (this.day < 10)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("0");
      ((StringBuilder)localObject).append(this.day);
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = Integer.valueOf(this.day);
    }
    localStringBuilder.append(localObject);
    return localStringBuilder.toString();
  }
  
  public static final class a
    implements Serializable
  {
    private Object obj;
    private String other;
    private String scheme;
    private int shcemeColor;
    private int type;
    
    public a() {}
    
    public a(int paramInt1, int paramInt2, String paramString)
    {
      this.type = paramInt1;
      this.shcemeColor = paramInt2;
      this.scheme = paramString;
    }
    
    public a(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      this.type = paramInt1;
      this.shcemeColor = paramInt2;
      this.scheme = paramString1;
      this.other = paramString2;
    }
    
    public a(int paramInt, String paramString)
    {
      this.shcemeColor = paramInt;
      this.scheme = paramString;
    }
    
    public a(int paramInt, String paramString1, String paramString2)
    {
      this.shcemeColor = paramInt;
      this.scheme = paramString1;
      this.other = paramString2;
    }
    
    public Object getObj()
    {
      return this.obj;
    }
    
    public String getOther()
    {
      return this.other;
    }
    
    public String getScheme()
    {
      return this.scheme;
    }
    
    public int getShcemeColor()
    {
      return this.shcemeColor;
    }
    
    public int getType()
    {
      return this.type;
    }
    
    public void setObj(Object paramObject)
    {
      this.obj = paramObject;
    }
    
    public void setOther(String paramString)
    {
      this.other = paramString;
    }
    
    public void setScheme(String paramString)
    {
      this.scheme = paramString;
    }
    
    public void setShcemeColor(int paramInt)
    {
      this.shcemeColor = paramInt;
    }
    
    public void setType(int paramInt)
    {
      this.type = paramInt;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\calendar\base\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */