package butterknife.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.support.annotation.AttrRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.UiThread;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.TypedValue;
import android.view.View;
import java.lang.reflect.Array;
import java.util.List;

public final class Utils
{
  private static final TypedValue VALUE = new TypedValue();
  
  private Utils()
  {
    throw new AssertionError("No instances.");
  }
  
  @SafeVarargs
  public static <T> T[] arrayOf(T... paramVarArgs)
  {
    return filterNull(paramVarArgs);
  }
  
  public static <T> T castParam(Object paramObject, String paramString1, int paramInt1, String paramString2, int paramInt2, Class<T> paramClass)
  {
    try
    {
      paramObject = paramClass.cast(paramObject);
      return (T)paramObject;
    }
    catch (ClassCastException paramObject)
    {
      paramClass = new StringBuilder();
      paramClass.append("Parameter #");
      paramClass.append(paramInt1 + 1);
      paramClass.append(" of method '");
      paramClass.append(paramString1);
      paramClass.append("' was of the wrong type for parameter #");
      paramClass.append(paramInt2 + 1);
      paramClass.append(" of method '");
      paramClass.append(paramString2);
      paramClass.append("'. See cause for more info.");
      throw new IllegalStateException(paramClass.toString(), (Throwable)paramObject);
    }
  }
  
  public static <T> T castView(View paramView, @IdRes int paramInt, String paramString, Class<T> paramClass)
  {
    try
    {
      paramClass = paramClass.cast(paramView);
      return paramClass;
    }
    catch (ClassCastException paramClass)
    {
      paramView = getResourceEntryName(paramView, paramInt);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("View '");
      localStringBuilder.append(paramView);
      localStringBuilder.append("' with ID ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" for ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" was of the wrong type. See cause for more info.");
      throw new IllegalStateException(localStringBuilder.toString(), paramClass);
    }
  }
  
  private static <T> T[] filterNull(T[] paramArrayOfT)
  {
    int m = paramArrayOfT.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      localObject = paramArrayOfT[i];
      k = j;
      if (localObject != null)
      {
        paramArrayOfT[j] = localObject;
        k = j + 1;
      }
      i += 1;
    }
    if (j == m) {
      return paramArrayOfT;
    }
    Object localObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), j);
    System.arraycopy(paramArrayOfT, 0, localObject, 0, j);
    return (T[])localObject;
  }
  
  public static <T> T findOptionalViewAsType(View paramView, @IdRes int paramInt, String paramString, Class<T> paramClass)
  {
    return (T)castView(paramView.findViewById(paramInt), paramInt, paramString, paramClass);
  }
  
  public static View findRequiredView(View paramView, @IdRes int paramInt, String paramString)
  {
    Object localObject = paramView.findViewById(paramInt);
    if (localObject != null) {
      return (View)localObject;
    }
    paramView = getResourceEntryName(paramView, paramInt);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Required view '");
    ((StringBuilder)localObject).append(paramView);
    ((StringBuilder)localObject).append("' with ID ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" for ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" was not found. If this view is optional add '@Nullable' (fields) or '@Optional' (methods) annotation.");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public static <T> T findRequiredViewAsType(View paramView, @IdRes int paramInt, String paramString, Class<T> paramClass)
  {
    return (T)castView(findRequiredView(paramView, paramInt, paramString), paramInt, paramString, paramClass);
  }
  
  @UiThread
  public static float getFloat(Context paramContext, @DimenRes int paramInt)
  {
    TypedValue localTypedValue = VALUE;
    paramContext.getResources().getValue(paramInt, localTypedValue, true);
    if (localTypedValue.type == 4) {
      return localTypedValue.getFloat();
    }
    paramContext = new StringBuilder();
    paramContext.append("Resource ID #0x");
    paramContext.append(Integer.toHexString(paramInt));
    paramContext.append(" type #0x");
    paramContext.append(Integer.toHexString(localTypedValue.type));
    paramContext.append(" is not valid");
    throw new Resources.NotFoundException(paramContext.toString());
  }
  
  private static String getResourceEntryName(View paramView, @IdRes int paramInt)
  {
    if (paramView.isInEditMode()) {
      return "<unavailable while editing>";
    }
    return paramView.getContext().getResources().getResourceEntryName(paramInt);
  }
  
  @UiThread
  public static Drawable getTintedDrawable(Context paramContext, @DrawableRes int paramInt1, @AttrRes int paramInt2)
  {
    if (paramContext.getTheme().resolveAttribute(paramInt2, VALUE, true))
    {
      localObject = DrawableCompat.wrap(ContextCompat.getDrawable(paramContext, paramInt1).mutate());
      DrawableCompat.setTint((Drawable)localObject, ContextCompat.getColor(paramContext, VALUE.resourceId));
      return (Drawable)localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Required tint color attribute with name ");
    ((StringBuilder)localObject).append(paramContext.getResources().getResourceEntryName(paramInt2));
    ((StringBuilder)localObject).append(" and attribute ID ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" was not found.");
    throw new Resources.NotFoundException(((StringBuilder)localObject).toString());
  }
  
  @SafeVarargs
  public static <T> List<T> listOf(T... paramVarArgs)
  {
    return new ImmutableList(filterNull(paramVarArgs));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\butterknife\internal\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */