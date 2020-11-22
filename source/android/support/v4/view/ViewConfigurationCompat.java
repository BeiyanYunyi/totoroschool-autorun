package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;

public final class ViewConfigurationCompat
{
  private static final String TAG = "ViewConfigCompat";
  private static Method sGetScaledScrollFactorMethod;
  
  static
  {
    if (Build.VERSION.SDK_INT == 25) {}
    try
    {
      sGetScaledScrollFactorMethod = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
  }
  
  private static float getLegacyScrollFactor(ViewConfiguration paramViewConfiguration, Context paramContext)
  {
    if ((Build.VERSION.SDK_INT >= 25) && (sGetScaledScrollFactorMethod != null)) {}
    try
    {
      int i = ((Integer)sGetScaledScrollFactorMethod.invoke(paramViewConfiguration, new Object[0])).intValue();
      return i;
    }
    catch (Exception paramViewConfiguration)
    {
      for (;;) {}
    }
    Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
    paramViewConfiguration = new TypedValue();
    if (paramContext.getTheme().resolveAttribute(16842829, paramViewConfiguration, true)) {
      return paramViewConfiguration.getDimension(paramContext.getResources().getDisplayMetrics());
    }
    return 0.0F;
  }
  
  public static float getScaledHorizontalScrollFactor(@NonNull ViewConfiguration paramViewConfiguration, @NonNull Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramViewConfiguration.getScaledHorizontalScrollFactor();
    }
    return getLegacyScrollFactor(paramViewConfiguration, paramContext);
  }
  
  public static int getScaledHoverSlop(ViewConfiguration paramViewConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramViewConfiguration.getScaledHoverSlop();
    }
    return paramViewConfiguration.getScaledTouchSlop() / 2;
  }
  
  @Deprecated
  public static int getScaledPagingTouchSlop(ViewConfiguration paramViewConfiguration)
  {
    return paramViewConfiguration.getScaledPagingTouchSlop();
  }
  
  public static float getScaledVerticalScrollFactor(@NonNull ViewConfiguration paramViewConfiguration, @NonNull Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramViewConfiguration.getScaledVerticalScrollFactor();
    }
    return getLegacyScrollFactor(paramViewConfiguration, paramContext);
  }
  
  @Deprecated
  public static boolean hasPermanentMenuKey(ViewConfiguration paramViewConfiguration)
  {
    return paramViewConfiguration.hasPermanentMenuKey();
  }
  
  public static boolean shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration paramViewConfiguration, @NonNull Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramViewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
    }
    paramViewConfiguration = paramContext.getResources();
    int i = paramViewConfiguration.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
    return (i != 0) && (paramViewConfiguration.getBoolean(i));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\view\ViewConfigurationCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */