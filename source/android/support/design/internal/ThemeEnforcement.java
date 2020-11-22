package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.AttrRes;
import android.support.annotation.RestrictTo;
import android.support.annotation.StyleRes;
import android.support.annotation.StyleableRes;
import android.support.design.R.attr;
import android.support.design.R.styleable;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public final class ThemeEnforcement
{
  private static final int[] APPCOMPAT_CHECK_ATTRS = { R.attr.colorPrimary };
  private static final String APPCOMPAT_THEME_NAME = "Theme.AppCompat";
  private static final int[] MATERIAL_CHECK_ATTRS = { R.attr.colorSecondary };
  private static final String MATERIAL_THEME_NAME = "Theme.MaterialComponents";
  
  public static void checkAppCompatTheme(Context paramContext)
  {
    checkTheme(paramContext, APPCOMPAT_CHECK_ATTRS, "Theme.AppCompat");
  }
  
  private static void checkCompatibleTheme(Context paramContext, AttributeSet paramAttributeSet, @AttrRes int paramInt1, @StyleRes int paramInt2)
  {
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ThemeEnforcement, paramInt1, paramInt2);
    boolean bool = paramAttributeSet.getBoolean(R.styleable.ThemeEnforcement_enforceMaterialTheme, false);
    paramAttributeSet.recycle();
    if (bool) {
      checkMaterialTheme(paramContext);
    }
    checkAppCompatTheme(paramContext);
  }
  
  public static void checkMaterialTheme(Context paramContext)
  {
    checkTheme(paramContext, MATERIAL_CHECK_ATTRS, "Theme.MaterialComponents");
  }
  
  private static void checkTextAppearance(Context paramContext, AttributeSet paramAttributeSet, @StyleableRes int[] paramArrayOfInt1, @AttrRes int paramInt1, @StyleRes int paramInt2, @StyleableRes int... paramVarArgs)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ThemeEnforcement, paramInt1, paramInt2);
    if (!localTypedArray.getBoolean(R.styleable.ThemeEnforcement_enforceTextAppearance, false))
    {
      localTypedArray.recycle();
      return;
    }
    boolean bool;
    if ((paramVarArgs != null) && (paramVarArgs.length != 0)) {
      bool = isCustomTextAppearanceValid(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2, paramVarArgs);
    } else if (localTypedArray.getResourceId(R.styleable.ThemeEnforcement_android_textAppearance, -1) != -1) {
      bool = true;
    } else {
      bool = false;
    }
    localTypedArray.recycle();
    if (bool) {
      return;
    }
    throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
  }
  
  private static void checkTheme(Context paramContext, int[] paramArrayOfInt, String paramString)
  {
    if (isTheme(paramContext, paramArrayOfInt)) {
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("The style on this component requires your app theme to be ");
    paramContext.append(paramString);
    paramContext.append(" (or a descendant).");
    throw new IllegalArgumentException(paramContext.toString());
  }
  
  public static boolean isAppCompatTheme(Context paramContext)
  {
    return isTheme(paramContext, APPCOMPAT_CHECK_ATTRS);
  }
  
  private static boolean isCustomTextAppearanceValid(Context paramContext, AttributeSet paramAttributeSet, @StyleableRes int[] paramArrayOfInt1, @AttrRes int paramInt1, @StyleRes int paramInt2, @StyleableRes int... paramVarArgs)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2);
    paramInt2 = paramVarArgs.length;
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      if (paramContext.getResourceId(paramVarArgs[paramInt1], -1) == -1)
      {
        paramContext.recycle();
        return false;
      }
      paramInt1 += 1;
    }
    paramContext.recycle();
    return true;
  }
  
  public static boolean isMaterialTheme(Context paramContext)
  {
    return isTheme(paramContext, MATERIAL_CHECK_ATTRS);
  }
  
  private static boolean isTheme(Context paramContext, int[] paramArrayOfInt)
  {
    paramContext = paramContext.obtainStyledAttributes(paramArrayOfInt);
    boolean bool = paramContext.hasValue(0);
    paramContext.recycle();
    return bool;
  }
  
  public static TypedArray obtainStyledAttributes(Context paramContext, AttributeSet paramAttributeSet, @StyleableRes int[] paramArrayOfInt1, @AttrRes int paramInt1, @StyleRes int paramInt2, @StyleableRes int... paramVarArgs)
  {
    checkCompatibleTheme(paramContext, paramAttributeSet, paramInt1, paramInt2);
    checkTextAppearance(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2, paramVarArgs);
    return paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2);
  }
  
  public static TintTypedArray obtainTintedStyledAttributes(Context paramContext, AttributeSet paramAttributeSet, @StyleableRes int[] paramArrayOfInt1, @AttrRes int paramInt1, @StyleRes int paramInt2, @StyleableRes int... paramVarArgs)
  {
    checkCompatibleTheme(paramContext, paramAttributeSet, paramInt1, paramInt2);
    checkTextAppearance(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2, paramVarArgs);
    return TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\internal\ThemeEnforcement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */