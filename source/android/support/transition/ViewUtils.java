package android.support.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;

class ViewUtils
{
  static final Property<View, Rect> CLIP_BOUNDS = new Property(Rect.class, "clipBounds")
  {
    public Rect get(View paramAnonymousView)
    {
      return ViewCompat.getClipBounds(paramAnonymousView);
    }
    
    public void set(View paramAnonymousView, Rect paramAnonymousRect)
    {
      ViewCompat.setClipBounds(paramAnonymousView, paramAnonymousRect);
    }
  };
  private static final ViewUtilsBase IMPL;
  private static final String TAG = "ViewUtils";
  static final Property<View, Float> TRANSITION_ALPHA;
  private static final int VISIBILITY_MASK = 12;
  private static Field sViewFlagsField;
  private static boolean sViewFlagsFieldFetched;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 22) {
      IMPL = new ViewUtilsApi22();
    } else if (Build.VERSION.SDK_INT >= 21) {
      IMPL = new ViewUtilsApi21();
    } else if (Build.VERSION.SDK_INT >= 19) {
      IMPL = new ViewUtilsApi19();
    } else {
      IMPL = new ViewUtilsBase();
    }
    TRANSITION_ALPHA = new Property(Float.class, "translationAlpha")
    {
      public Float get(View paramAnonymousView)
      {
        return Float.valueOf(ViewUtils.getTransitionAlpha(paramAnonymousView));
      }
      
      public void set(View paramAnonymousView, Float paramAnonymousFloat)
      {
        ViewUtils.setTransitionAlpha(paramAnonymousView, paramAnonymousFloat.floatValue());
      }
    };
  }
  
  static void clearNonTransitionAlpha(@NonNull View paramView)
  {
    IMPL.clearNonTransitionAlpha(paramView);
  }
  
  private static void fetchViewFlagsField()
  {
    if (!sViewFlagsFieldFetched) {}
    try
    {
      sViewFlagsField = View.class.getDeclaredField("mViewFlags");
      sViewFlagsField.setAccessible(true);
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;) {}
    }
    Log.i("ViewUtils", "fetchViewFlagsField: ");
    sViewFlagsFieldFetched = true;
  }
  
  static ViewOverlayImpl getOverlay(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return new ViewOverlayApi18(paramView);
    }
    return ViewOverlayApi14.createFrom(paramView);
  }
  
  static float getTransitionAlpha(@NonNull View paramView)
  {
    return IMPL.getTransitionAlpha(paramView);
  }
  
  static WindowIdImpl getWindowId(@NonNull View paramView)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return new WindowIdApi18(paramView);
    }
    return new WindowIdApi14(paramView.getWindowToken());
  }
  
  static void saveNonTransitionAlpha(@NonNull View paramView)
  {
    IMPL.saveNonTransitionAlpha(paramView);
  }
  
  static void setAnimationMatrix(@NonNull View paramView, @Nullable Matrix paramMatrix)
  {
    IMPL.setAnimationMatrix(paramView, paramMatrix);
  }
  
  static void setLeftTopRightBottom(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    IMPL.setLeftTopRightBottom(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  static void setTransitionAlpha(@NonNull View paramView, float paramFloat)
  {
    IMPL.setTransitionAlpha(paramView, paramFloat);
  }
  
  static void setTransitionVisibility(@NonNull View paramView, int paramInt)
  {
    
    if (sViewFlagsField != null) {}
    try
    {
      int i = sViewFlagsField.getInt(paramView);
      sViewFlagsField.setInt(paramView, paramInt | i & 0xFFFFFFF3);
      return;
    }
    catch (IllegalAccessException paramView) {}
  }
  
  static void transformMatrixToGlobal(@NonNull View paramView, @NonNull Matrix paramMatrix)
  {
    IMPL.transformMatrixToGlobal(paramView, paramMatrix);
  }
  
  static void transformMatrixToLocal(@NonNull View paramView, @NonNull Matrix paramMatrix)
  {
    IMPL.transformMatrixToLocal(paramView, paramMatrix);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\transition\ViewUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */