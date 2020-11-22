package android.support.transition;

import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiresApi(19)
class ViewUtilsApi19
  extends ViewUtilsBase
{
  private static final String TAG = "ViewUtilsApi19";
  private static Method sGetTransitionAlphaMethod;
  private static boolean sGetTransitionAlphaMethodFetched;
  private static Method sSetTransitionAlphaMethod;
  private static boolean sSetTransitionAlphaMethodFetched;
  
  private void fetchGetTransitionAlphaMethod()
  {
    if (!sGetTransitionAlphaMethodFetched)
    {
      try
      {
        sGetTransitionAlphaMethod = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
        sGetTransitionAlphaMethod.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Log.i("ViewUtilsApi19", "Failed to retrieve getTransitionAlpha method", localNoSuchMethodException);
      }
      sGetTransitionAlphaMethodFetched = true;
    }
  }
  
  private void fetchSetTransitionAlphaMethod()
  {
    if (!sSetTransitionAlphaMethodFetched)
    {
      try
      {
        sSetTransitionAlphaMethod = View.class.getDeclaredMethod("setTransitionAlpha", new Class[] { Float.TYPE });
        sSetTransitionAlphaMethod.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Log.i("ViewUtilsApi19", "Failed to retrieve setTransitionAlpha method", localNoSuchMethodException);
      }
      sSetTransitionAlphaMethodFetched = true;
    }
  }
  
  public void clearNonTransitionAlpha(@NonNull View paramView) {}
  
  public float getTransitionAlpha(@NonNull View paramView)
  {
    fetchGetTransitionAlphaMethod();
    if (sGetTransitionAlphaMethod != null) {}
    try
    {
      float f = ((Float)sGetTransitionAlphaMethod.invoke(paramView, new Object[0])).floatValue();
      return f;
    }
    catch (InvocationTargetException paramView)
    {
      throw new RuntimeException(paramView.getCause());
      return super.getTransitionAlpha(paramView);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;) {}
    }
  }
  
  public void saveNonTransitionAlpha(@NonNull View paramView) {}
  
  public void setTransitionAlpha(@NonNull View paramView, float paramFloat)
  {
    fetchSetTransitionAlphaMethod();
    if (sSetTransitionAlphaMethod != null) {}
    try
    {
      sSetTransitionAlphaMethod.invoke(paramView, new Object[] { Float.valueOf(paramFloat) });
      return;
    }
    catch (InvocationTargetException paramView)
    {
      throw new RuntimeException(paramView.getCause());
      paramView.setAlpha(paramFloat);
      return;
    }
    catch (IllegalAccessException paramView) {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\transition\ViewUtilsApi19.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */