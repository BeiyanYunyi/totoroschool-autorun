package android.support.transition;

import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiresApi(21)
class ViewUtilsApi21
  extends ViewUtilsApi19
{
  private static final String TAG = "ViewUtilsApi21";
  private static Method sSetAnimationMatrixMethod;
  private static boolean sSetAnimationMatrixMethodFetched;
  private static Method sTransformMatrixToGlobalMethod;
  private static boolean sTransformMatrixToGlobalMethodFetched;
  private static Method sTransformMatrixToLocalMethod;
  private static boolean sTransformMatrixToLocalMethodFetched;
  
  private void fetchSetAnimationMatrix()
  {
    if (!sSetAnimationMatrixMethodFetched)
    {
      try
      {
        sSetAnimationMatrixMethod = View.class.getDeclaredMethod("setAnimationMatrix", new Class[] { Matrix.class });
        sSetAnimationMatrixMethod.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Log.i("ViewUtilsApi21", "Failed to retrieve setAnimationMatrix method", localNoSuchMethodException);
      }
      sSetAnimationMatrixMethodFetched = true;
    }
  }
  
  private void fetchTransformMatrixToGlobalMethod()
  {
    if (!sTransformMatrixToGlobalMethodFetched)
    {
      try
      {
        sTransformMatrixToGlobalMethod = View.class.getDeclaredMethod("transformMatrixToGlobal", new Class[] { Matrix.class });
        sTransformMatrixToGlobalMethod.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToGlobal method", localNoSuchMethodException);
      }
      sTransformMatrixToGlobalMethodFetched = true;
    }
  }
  
  private void fetchTransformMatrixToLocalMethod()
  {
    if (!sTransformMatrixToLocalMethodFetched)
    {
      try
      {
        sTransformMatrixToLocalMethod = View.class.getDeclaredMethod("transformMatrixToLocal", new Class[] { Matrix.class });
        sTransformMatrixToLocalMethod.setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToLocal method", localNoSuchMethodException);
      }
      sTransformMatrixToLocalMethodFetched = true;
    }
  }
  
  public void setAnimationMatrix(@NonNull View paramView, Matrix paramMatrix)
  {
    fetchSetAnimationMatrix();
    if (sSetAnimationMatrixMethod != null) {}
    try
    {
      sSetAnimationMatrixMethod.invoke(paramView, new Object[] { paramMatrix });
      return;
    }
    catch (IllegalAccessException paramView)
    {
      throw new RuntimeException(paramView.getCause());
      return;
    }
    catch (InvocationTargetException paramView) {}
  }
  
  public void transformMatrixToGlobal(@NonNull View paramView, @NonNull Matrix paramMatrix)
  {
    fetchTransformMatrixToGlobalMethod();
    if (sTransformMatrixToGlobalMethod != null) {}
    try
    {
      sTransformMatrixToGlobalMethod.invoke(paramView, new Object[] { paramMatrix });
      return;
    }
    catch (InvocationTargetException paramView)
    {
      throw new RuntimeException(paramView.getCause());
      return;
    }
    catch (IllegalAccessException paramView) {}
  }
  
  public void transformMatrixToLocal(@NonNull View paramView, @NonNull Matrix paramMatrix)
  {
    fetchTransformMatrixToLocalMethod();
    if (sTransformMatrixToLocalMethod != null) {}
    try
    {
      sTransformMatrixToLocalMethod.invoke(paramView, new Object[] { paramMatrix });
      return;
    }
    catch (InvocationTargetException paramView)
    {
      throw new RuntimeException(paramView.getCause());
      return;
    }
    catch (IllegalAccessException paramView) {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\transition\ViewUtilsApi21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */