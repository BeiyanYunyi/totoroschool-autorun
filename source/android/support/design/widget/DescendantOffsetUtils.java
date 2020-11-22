package android.support.design.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.RestrictTo;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class DescendantOffsetUtils
{
  private static final ThreadLocal<Matrix> matrix = new ThreadLocal();
  private static final ThreadLocal<RectF> rectF = new ThreadLocal();
  
  public static void getDescendantRect(ViewGroup paramViewGroup, View paramView, Rect paramRect)
  {
    paramRect.set(0, 0, paramView.getWidth(), paramView.getHeight());
    offsetDescendantRect(paramViewGroup, paramView, paramRect);
  }
  
  private static void offsetDescendantMatrix(ViewParent paramViewParent, View paramView, Matrix paramMatrix)
  {
    Object localObject = paramView.getParent();
    if (((localObject instanceof View)) && (localObject != paramViewParent))
    {
      localObject = (View)localObject;
      offsetDescendantMatrix(paramViewParent, (View)localObject, paramMatrix);
      paramMatrix.preTranslate(-((View)localObject).getScrollX(), -((View)localObject).getScrollY());
    }
    paramMatrix.preTranslate(paramView.getLeft(), paramView.getTop());
    if (!paramView.getMatrix().isIdentity()) {
      paramMatrix.preConcat(paramView.getMatrix());
    }
  }
  
  public static void offsetDescendantRect(ViewGroup paramViewGroup, View paramView, Rect paramRect)
  {
    Matrix localMatrix = (Matrix)matrix.get();
    if (localMatrix == null)
    {
      localMatrix = new Matrix();
      matrix.set(localMatrix);
    }
    else
    {
      localMatrix.reset();
    }
    offsetDescendantMatrix(paramViewGroup, paramView, localMatrix);
    paramView = (RectF)rectF.get();
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = new RectF();
      rectF.set(paramViewGroup);
    }
    paramViewGroup.set(paramRect);
    localMatrix.mapRect(paramViewGroup);
    paramRect.set((int)(paramViewGroup.left + 0.5F), (int)(paramViewGroup.top + 0.5F), (int)(paramViewGroup.right + 0.5F), (int)(paramViewGroup.bottom + 0.5F));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\widget\DescendantOffsetUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */