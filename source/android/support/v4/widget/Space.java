package android.support.v4.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;

@Deprecated
public class Space
  extends View
{
  @Deprecated
  public Space(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  @Deprecated
  public Space(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  @Deprecated
  public Space(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (getVisibility() == 0) {
      setVisibility(4);
    }
  }
  
  private static int getDefaultSize2(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt2);
    if (i != Integer.MIN_VALUE)
    {
      paramInt2 = paramInt1;
      if (i != 0)
      {
        if (i != 1073741824) {
          return paramInt1;
        }
        return j;
      }
    }
    else
    {
      paramInt2 = Math.min(paramInt1, j);
    }
    return paramInt2;
  }
  
  @Deprecated
  @SuppressLint({"MissingSuperCall"})
  public void draw(Canvas paramCanvas) {}
  
  @Deprecated
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize2(getSuggestedMinimumWidth(), paramInt1), getDefaultSize2(getSuggestedMinimumHeight(), paramInt2));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\widget\Space.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */