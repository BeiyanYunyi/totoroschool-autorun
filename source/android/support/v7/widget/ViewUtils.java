package android.support.v7.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.annotation.RestrictTo;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class ViewUtils
{
  private static final String TAG = "ViewUtils";
  private static Method sComputeFitSystemWindowsMethod;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 18) {}
    try
    {
      sComputeFitSystemWindowsMethod = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[] { Rect.class, Rect.class });
      if (sComputeFitSystemWindowsMethod.isAccessible()) {
        break label57;
      }
      sComputeFitSystemWindowsMethod.setAccessible(true);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label57:
      for (;;) {}
    }
    Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
  }
  
  public static void computeFitSystemWindows(View paramView, Rect paramRect1, Rect paramRect2)
  {
    if (sComputeFitSystemWindowsMethod != null) {
      try
      {
        sComputeFitSystemWindowsMethod.invoke(paramView, new Object[] { paramRect1, paramRect2 });
        return;
      }
      catch (Exception paramView)
      {
        Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", paramView);
      }
    }
  }
  
  public static boolean isLayoutRtl(View paramView)
  {
    return ViewCompat.getLayoutDirection(paramView) == 1;
  }
  
  public static void makeOptionalFitsSystemWindows(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    try
    {
      Method localMethod = paramView.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
      if (!localMethod.isAccessible()) {
        localMethod.setAccessible(true);
      }
      localMethod.invoke(paramView, new Object[0]);
      return;
    }
    catch (IllegalAccessException paramView)
    {
      Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", paramView);
      return;
    }
    catch (InvocationTargetException paramView)
    {
      Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", paramView);
      return;
      Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
      return;
    }
    catch (NoSuchMethodException paramView)
    {
      for (;;) {}
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\widget\ViewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */