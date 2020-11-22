package android.support.transition;

import android.graphics.Matrix;
import android.support.annotation.NonNull;
import android.view.View;

class ViewUtilsBase
{
  private float[] mMatrixValues;
  
  public void clearNonTransitionAlpha(@NonNull View paramView)
  {
    if (paramView.getVisibility() == 0) {
      paramView.setTag(R.id.save_non_transition_alpha, null);
    }
  }
  
  public float getTransitionAlpha(@NonNull View paramView)
  {
    Float localFloat = (Float)paramView.getTag(R.id.save_non_transition_alpha);
    if (localFloat != null) {
      return paramView.getAlpha() / localFloat.floatValue();
    }
    return paramView.getAlpha();
  }
  
  public void saveNonTransitionAlpha(@NonNull View paramView)
  {
    if (paramView.getTag(R.id.save_non_transition_alpha) == null) {
      paramView.setTag(R.id.save_non_transition_alpha, Float.valueOf(paramView.getAlpha()));
    }
  }
  
  public void setAnimationMatrix(@NonNull View paramView, Matrix paramMatrix)
  {
    if ((paramMatrix != null) && (!paramMatrix.isIdentity()))
    {
      float[] arrayOfFloat2 = this.mMatrixValues;
      float[] arrayOfFloat1 = arrayOfFloat2;
      if (arrayOfFloat2 == null)
      {
        arrayOfFloat1 = new float[9];
        this.mMatrixValues = arrayOfFloat1;
      }
      paramMatrix.getValues(arrayOfFloat1);
      float f1 = arrayOfFloat1[3];
      float f2 = (float)Math.sqrt(1.0F - f1 * f1);
      int i;
      if (arrayOfFloat1[0] < 0.0F) {
        i = -1;
      } else {
        i = 1;
      }
      float f3 = f2 * i;
      f1 = (float)Math.toDegrees(Math.atan2(f1, f3));
      f2 = arrayOfFloat1[0] / f3;
      f3 = arrayOfFloat1[4] / f3;
      float f4 = arrayOfFloat1[2];
      float f5 = arrayOfFloat1[5];
      paramView.setPivotX(0.0F);
      paramView.setPivotY(0.0F);
      paramView.setTranslationX(f4);
      paramView.setTranslationY(f5);
      paramView.setRotation(f1);
      paramView.setScaleX(f2);
      paramView.setScaleY(f3);
      return;
    }
    paramView.setPivotX(paramView.getWidth() / 2);
    paramView.setPivotY(paramView.getHeight() / 2);
    paramView.setTranslationX(0.0F);
    paramView.setTranslationY(0.0F);
    paramView.setScaleX(1.0F);
    paramView.setScaleY(1.0F);
    paramView.setRotation(0.0F);
  }
  
  public void setLeftTopRightBottom(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramView.setLeft(paramInt1);
    paramView.setTop(paramInt2);
    paramView.setRight(paramInt3);
    paramView.setBottom(paramInt4);
  }
  
  public void setTransitionAlpha(@NonNull View paramView, float paramFloat)
  {
    Float localFloat = (Float)paramView.getTag(R.id.save_non_transition_alpha);
    if (localFloat != null)
    {
      paramView.setAlpha(localFloat.floatValue() * paramFloat);
      return;
    }
    paramView.setAlpha(paramFloat);
  }
  
  public void transformMatrixToGlobal(@NonNull View paramView, @NonNull Matrix paramMatrix)
  {
    Object localObject = paramView.getParent();
    if ((localObject instanceof View))
    {
      localObject = (View)localObject;
      transformMatrixToGlobal((View)localObject, paramMatrix);
      paramMatrix.preTranslate(-((View)localObject).getScrollX(), -((View)localObject).getScrollY());
    }
    paramMatrix.preTranslate(paramView.getLeft(), paramView.getTop());
    paramView = paramView.getMatrix();
    if (!paramView.isIdentity()) {
      paramMatrix.preConcat(paramView);
    }
  }
  
  public void transformMatrixToLocal(@NonNull View paramView, @NonNull Matrix paramMatrix)
  {
    Object localObject = paramView.getParent();
    if ((localObject instanceof View))
    {
      localObject = (View)localObject;
      transformMatrixToLocal((View)localObject, paramMatrix);
      paramMatrix.postTranslate(((View)localObject).getScrollX(), ((View)localObject).getScrollY());
    }
    paramMatrix.postTranslate(paramView.getLeft(), paramView.getTop());
    paramView = paramView.getMatrix();
    if (!paramView.isIdentity())
    {
      localObject = new Matrix();
      if (paramView.invert((Matrix)localObject)) {
        paramMatrix.postConcat((Matrix)localObject);
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\transition\ViewUtilsBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */