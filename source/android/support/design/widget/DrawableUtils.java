package android.support.design.widget;

import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.support.annotation.RestrictTo;
import android.util.Log;
import java.lang.reflect.Method;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class DrawableUtils
{
  private static final String LOG_TAG = "DrawableUtils";
  private static Method setConstantStateMethod;
  private static boolean setConstantStateMethodFetched;
  
  public static boolean setContainerConstantState(DrawableContainer paramDrawableContainer, Drawable.ConstantState paramConstantState)
  {
    return setContainerConstantStateV9(paramDrawableContainer, paramConstantState);
  }
  
  private static boolean setContainerConstantStateV9(DrawableContainer paramDrawableContainer, Drawable.ConstantState paramConstantState)
  {
    if (!setConstantStateMethodFetched) {}
    try
    {
      setConstantStateMethod = DrawableContainer.class.getDeclaredMethod("setConstantState", new Class[] { DrawableContainer.DrawableContainerState.class });
      setConstantStateMethod.setAccessible(true);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
    Log.e("DrawableUtils", "Could not fetch setConstantState(). Oh well.");
    setConstantStateMethodFetched = true;
    if (setConstantStateMethod != null) {}
    try
    {
      setConstantStateMethod.invoke(paramDrawableContainer, new Object[] { paramConstantState });
      return true;
    }
    catch (Exception paramDrawableContainer)
    {
      for (;;) {}
    }
    Log.e("DrawableUtils", "Could not invoke setConstantState(). Oh well.");
    return false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\widget\DrawableUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */