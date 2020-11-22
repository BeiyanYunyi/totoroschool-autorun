package com.totoro.school.view.calendar.base;

import android.content.Context;
import android.content.res.Resources;

public final class i
{
  private static String[] a;
  private static String[] b;
  
  public static void a(Context paramContext)
  {
    if (a != null) {
      return;
    }
    a = paramContext.getResources().getStringArray(2130903048);
    b = paramContext.getResources().getStringArray(2130903040);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\view\calendar\base\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */