package com.totoro.school.view.calendar.base;

import java.io.Serializable;

final class g
  implements Serializable
{
  private int count;
  private int diff;
  private int month;
  private int year;
  
  int getCount()
  {
    return this.count;
  }
  
  int getDiff()
  {
    return this.diff;
  }
  
  int getMonth()
  {
    return this.month;
  }
  
  int getYear()
  {
    return this.year;
  }
  
  void setCount(int paramInt)
  {
    this.count = paramInt;
  }
  
  void setDiff(int paramInt)
  {
    this.diff = paramInt;
  }
  
  void setMonth(int paramInt)
  {
    this.month = paramInt;
  }
  
  void setYear(int paramInt)
  {
    this.year = paramInt;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\calendar\base\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */