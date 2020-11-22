package android.support.transition;

import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiresApi(18)
class ViewGroupUtilsApi18
{
  private static final String TAG = "ViewUtilsApi18";
  private static Method sSuppressLayoutMethod;
  private static boolean sSuppressLayoutMethodFetched;
  
  private static void fetchSuppressLayoutMethod()
  {
    if (!sSuppressLayoutMethodFetched)
    {
      try
      {
        sSuppressLayoutMethod = ViewGroup.class.getDeclaredMethod("suppressLayout", new Class[] { Boolean.TYPE });
        sSuppressLayoutMethod.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Log.i("ViewUtilsApi18", "Failed to retrieve suppressLayout method", localNoSuchMethodException);
      }
      sSuppressLayoutMethodFetched = true;
    }
  }
  
  static void suppressLayout(@NonNull ViewGroup paramViewGroup, boolean paramBoolean)
  {
    
    if (sSuppressLayoutMethod != null) {
      try
      {
        sSuppressLayoutMethod.invoke(paramViewGroup, new Object[] { Boolean.valueOf(paramBoolean) });
        return;
      }
      catch (InvocationTargetException paramViewGroup)
      {
        Log.i("ViewUtilsApi18", "Error invoking suppressLayout method", paramViewGroup);
        return;
      }
      catch (IllegalAccessException paramViewGroup)
      {
        Log.i("ViewUtilsApi18", "Failed to invoke suppressLayout method", paramViewGroup);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\transition\ViewGroupUtilsApi18.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */