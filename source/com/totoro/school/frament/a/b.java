package com.totoro.school.frament.a;

import android.support.v4.app.Fragment;
import com.totoro.school.frament.sport.MorningFragment;
import com.totoro.school.frament.sport.SunshineRunFragment;
import java.util.HashMap;
import java.util.Map;

public class b
{
  private static Map<Integer, Fragment> a = new HashMap();
  
  public static Fragment a(int paramInt)
  {
    Object localObject1 = (Fragment)a.get(Integer.valueOf(paramInt));
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      switch (paramInt)
      {
      default: 
        break;
      case 1: 
        localObject1 = new MorningFragment();
        break;
      case 0: 
        localObject1 = new SunshineRunFragment();
      }
      a.put(Integer.valueOf(paramInt), localObject1);
      localObject2 = localObject1;
    }
    return (Fragment)localObject2;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\frament\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */