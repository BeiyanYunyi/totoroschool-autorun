package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ScaleGestureDetector;

public final class ScaleGestureDetectorCompat
{
  public static boolean isQuickScaleEnabled(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramScaleGestureDetector.isQuickScaleEnabled();
    }
    return false;
  }
  
  @Deprecated
  public static boolean isQuickScaleEnabled(Object paramObject)
  {
    return isQuickScaleEnabled((ScaleGestureDetector)paramObject);
  }
  
  public static void setQuickScaleEnabled(ScaleGestureDetector paramScaleGestureDetector, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      paramScaleGestureDetector.setQuickScaleEnabled(paramBoolean);
    }
  }
  
  @Deprecated
  public static void setQuickScaleEnabled(Object paramObject, boolean paramBoolean)
  {
    setQuickScaleEnabled((ScaleGestureDetector)paramObject, paramBoolean);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\view\ScaleGestureDetectorCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */