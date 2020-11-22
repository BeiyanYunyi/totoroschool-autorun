package android.support.design.ripple;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.graphics.ColorUtils;
import android.util.StateSet;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class RippleUtils
{
  private static final int[] FOCUSED_STATE_SET;
  private static final int[] HOVERED_FOCUSED_STATE_SET;
  private static final int[] HOVERED_STATE_SET;
  private static final int[] PRESSED_STATE_SET;
  private static final int[] SELECTED_FOCUSED_STATE_SET = { 16842913, 16842908 };
  private static final int[] SELECTED_HOVERED_FOCUSED_STATE_SET;
  private static final int[] SELECTED_HOVERED_STATE_SET = { 16842913, 16843623 };
  private static final int[] SELECTED_PRESSED_STATE_SET;
  private static final int[] SELECTED_STATE_SET = { 16842913 };
  public static final boolean USE_FRAMEWORK_RIPPLE;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    } else {
      bool = false;
    }
    USE_FRAMEWORK_RIPPLE = bool;
    PRESSED_STATE_SET = new int[] { 16842919 };
    HOVERED_FOCUSED_STATE_SET = new int[] { 16843623, 16842908 };
    FOCUSED_STATE_SET = new int[] { 16842908 };
    HOVERED_STATE_SET = new int[] { 16843623 };
    SELECTED_PRESSED_STATE_SET = new int[] { 16842913, 16842919 };
    SELECTED_HOVERED_FOCUSED_STATE_SET = new int[] { 16842913, 16843623, 16842908 };
  }
  
  @NonNull
  public static ColorStateList convertToRippleDrawableColor(@Nullable ColorStateList paramColorStateList)
  {
    if (USE_FRAMEWORK_RIPPLE)
    {
      arrayOfInt1 = SELECTED_STATE_SET;
      i = getColorForState(paramColorStateList, SELECTED_PRESSED_STATE_SET);
      arrayOfInt2 = StateSet.NOTHING;
      j = getColorForState(paramColorStateList, PRESSED_STATE_SET);
      return new ColorStateList(new int[][] { arrayOfInt1, arrayOfInt2 }, new int[] { i, j });
    }
    int[] arrayOfInt1 = SELECTED_PRESSED_STATE_SET;
    int i = getColorForState(paramColorStateList, SELECTED_PRESSED_STATE_SET);
    int[] arrayOfInt2 = SELECTED_HOVERED_FOCUSED_STATE_SET;
    int j = getColorForState(paramColorStateList, SELECTED_HOVERED_FOCUSED_STATE_SET);
    int[] arrayOfInt3 = SELECTED_FOCUSED_STATE_SET;
    int k = getColorForState(paramColorStateList, SELECTED_FOCUSED_STATE_SET);
    int[] arrayOfInt4 = SELECTED_HOVERED_STATE_SET;
    int m = getColorForState(paramColorStateList, SELECTED_HOVERED_STATE_SET);
    int[] arrayOfInt5 = SELECTED_STATE_SET;
    int[] arrayOfInt6 = PRESSED_STATE_SET;
    int n = getColorForState(paramColorStateList, PRESSED_STATE_SET);
    int[] arrayOfInt7 = HOVERED_FOCUSED_STATE_SET;
    int i1 = getColorForState(paramColorStateList, HOVERED_FOCUSED_STATE_SET);
    int[] arrayOfInt8 = FOCUSED_STATE_SET;
    int i2 = getColorForState(paramColorStateList, FOCUSED_STATE_SET);
    int[] arrayOfInt9 = HOVERED_STATE_SET;
    int i3 = getColorForState(paramColorStateList, HOVERED_STATE_SET);
    return new ColorStateList(new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, arrayOfInt6, arrayOfInt7, arrayOfInt8, arrayOfInt9, StateSet.NOTHING }, new int[] { i, j, k, m, 0, n, i1, i2, i3, 0 });
  }
  
  @TargetApi(21)
  @ColorInt
  private static int doubleAlpha(@ColorInt int paramInt)
  {
    return ColorUtils.setAlphaComponent(paramInt, Math.min(Color.alpha(paramInt) * 2, 255));
  }
  
  @ColorInt
  private static int getColorForState(@Nullable ColorStateList paramColorStateList, int[] paramArrayOfInt)
  {
    int i;
    if (paramColorStateList != null) {
      i = paramColorStateList.getColorForState(paramArrayOfInt, paramColorStateList.getDefaultColor());
    } else {
      i = 0;
    }
    int j = i;
    if (USE_FRAMEWORK_RIPPLE) {
      j = doubleAlpha(i);
    }
    return j;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\ripple\RippleUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */