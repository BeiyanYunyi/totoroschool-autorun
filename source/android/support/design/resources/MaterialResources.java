package android.support.design.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.StyleableRes;
import android.support.v7.content.res.AppCompatResources;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class MaterialResources
{
  @Nullable
  public static ColorStateList getColorStateList(Context paramContext, TypedArray paramTypedArray, @StyleableRes int paramInt)
  {
    if (paramTypedArray.hasValue(paramInt))
    {
      int i = paramTypedArray.getResourceId(paramInt, 0);
      if (i != 0)
      {
        paramContext = AppCompatResources.getColorStateList(paramContext, i);
        if (paramContext != null) {
          return paramContext;
        }
      }
    }
    return paramTypedArray.getColorStateList(paramInt);
  }
  
  @Nullable
  public static Drawable getDrawable(Context paramContext, TypedArray paramTypedArray, @StyleableRes int paramInt)
  {
    if (paramTypedArray.hasValue(paramInt))
    {
      int i = paramTypedArray.getResourceId(paramInt, 0);
      if (i != 0)
      {
        paramContext = AppCompatResources.getDrawable(paramContext, i);
        if (paramContext != null) {
          return paramContext;
        }
      }
    }
    return paramTypedArray.getDrawable(paramInt);
  }
  
  @StyleableRes
  static int getIndexWithValue(TypedArray paramTypedArray, @StyleableRes int paramInt1, @StyleableRes int paramInt2)
  {
    if (paramTypedArray.hasValue(paramInt1)) {
      return paramInt1;
    }
    return paramInt2;
  }
  
  @Nullable
  public static TextAppearance getTextAppearance(Context paramContext, TypedArray paramTypedArray, @StyleableRes int paramInt)
  {
    if (paramTypedArray.hasValue(paramInt))
    {
      paramInt = paramTypedArray.getResourceId(paramInt, 0);
      if (paramInt != 0) {
        return new TextAppearance(paramContext, paramInt);
      }
    }
    return null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\resources\MaterialResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */