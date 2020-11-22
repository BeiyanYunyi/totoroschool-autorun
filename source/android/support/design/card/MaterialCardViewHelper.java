package android.support.design.card;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorInt;
import android.support.annotation.Dimension;
import android.support.annotation.RestrictTo;
import android.support.design.R.styleable;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
class MaterialCardViewHelper
{
  private static final int DEFAULT_STROKE_VALUE = -1;
  private final MaterialCardView materialCardView;
  private int strokeColor;
  private int strokeWidth;
  
  public MaterialCardViewHelper(MaterialCardView paramMaterialCardView)
  {
    this.materialCardView = paramMaterialCardView;
  }
  
  private void adjustContentPadding()
  {
    int i = this.materialCardView.getContentPaddingLeft();
    int j = this.strokeWidth;
    int k = this.materialCardView.getContentPaddingTop();
    int m = this.strokeWidth;
    int n = this.materialCardView.getContentPaddingRight();
    int i1 = this.strokeWidth;
    int i2 = this.materialCardView.getContentPaddingBottom();
    int i3 = this.strokeWidth;
    this.materialCardView.setContentPadding(i + j, k + m, n + i1, i2 + i3);
  }
  
  private Drawable createForegroundDrawable()
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(this.materialCardView.getRadius());
    if (this.strokeColor != -1) {
      localGradientDrawable.setStroke(this.strokeWidth, this.strokeColor);
    }
    return localGradientDrawable;
  }
  
  @ColorInt
  int getStrokeColor()
  {
    return this.strokeColor;
  }
  
  @Dimension
  int getStrokeWidth()
  {
    return this.strokeWidth;
  }
  
  public void loadFromAttributes(TypedArray paramTypedArray)
  {
    this.strokeColor = paramTypedArray.getColor(R.styleable.MaterialCardView_strokeColor, -1);
    this.strokeWidth = paramTypedArray.getDimensionPixelSize(R.styleable.MaterialCardView_strokeWidth, 0);
    updateForeground();
    adjustContentPadding();
  }
  
  void setStrokeColor(@ColorInt int paramInt)
  {
    this.strokeColor = paramInt;
    updateForeground();
  }
  
  void setStrokeWidth(@Dimension int paramInt)
  {
    this.strokeWidth = paramInt;
    updateForeground();
    adjustContentPadding();
  }
  
  void updateForeground()
  {
    this.materialCardView.setForeground(createForegroundDrawable());
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\card\MaterialCardViewHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */