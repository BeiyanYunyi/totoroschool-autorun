package com.pgyersdk.b.c;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import com.pgyersdk.b.a.d;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class a
{
  private static Object a(String paramString, Object paramObject)
  {
    try
    {
      paramString = paramObject.getClass().getDeclaredField(paramString);
      paramString.setAccessible(true);
      paramString = paramString.get(paramObject);
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new d(paramString);
    }
  }
  
  public static List<b> a(Activity paramActivity)
  {
    ArrayList localArrayList = new ArrayList();
    if (Build.VERSION.SDK_INT >= 17) {
      paramActivity = a("mGlobal", paramActivity.getWindowManager());
    } else {
      paramActivity = a("mWindowManager", paramActivity.getWindowManager());
    }
    Object localObject2 = a("mRoots", paramActivity);
    Object localObject1 = a("mParams", paramActivity);
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramActivity = ((List)localObject2).toArray();
      localObject1 = (List)localObject1;
      localObject1 = (WindowManager.LayoutParams[])((List)localObject1).toArray(new WindowManager.LayoutParams[((List)localObject1).size()]);
    }
    else
    {
      paramActivity = (Object[])localObject2;
      localObject1 = (WindowManager.LayoutParams[])localObject1;
    }
    int i = 0;
    while (i < paramActivity.length)
    {
      localObject2 = (View)a("mView", paramActivity[i]);
      if (((View)localObject2).getVisibility() == 0) {
        localArrayList.add(new b((View)localObject2, localObject1[i]));
      }
      i += 1;
    }
    return localArrayList;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\b\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */