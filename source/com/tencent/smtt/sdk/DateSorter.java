package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.interfaces.IX5DateSorter;

public class DateSorter
{
  public static int DAY_COUNT = 5;
  private android.webkit.DateSorter a;
  private IX5DateSorter b;
  
  static
  {
    a();
  }
  
  public DateSorter(Context paramContext)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b()))
    {
      this.b = localbt.c().h(paramContext);
      return;
    }
    this.a = new android.webkit.DateSorter(paramContext);
  }
  
  private static boolean a()
  {
    bt localbt = bt.a();
    return (localbt != null) && (localbt.b());
  }
  
  public long getBoundary(int paramInt)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b())) {
      return this.b.getBoundary(paramInt);
    }
    return this.a.getBoundary(paramInt);
  }
  
  public int getIndex(long paramLong)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b())) {
      return this.b.getIndex(paramLong);
    }
    return this.a.getIndex(paramLong);
  }
  
  public String getLabel(int paramInt)
  {
    bt localbt = bt.a();
    if ((localbt != null) && (localbt.b())) {
      return this.b.getLabel(paramInt);
    }
    return this.a.getLabel(paramInt);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\DateSorter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */