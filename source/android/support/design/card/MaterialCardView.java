package android.support.design.card;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.ColorInt;
import android.support.annotation.Dimension;
import android.support.design.R.attr;
import android.support.design.R.style;
import android.support.design.R.styleable;
import android.support.design.internal.ThemeEnforcement;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;

public class MaterialCardView
  extends CardView
{
  private final MaterialCardViewHelper cardViewHelper;
  
  public MaterialCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MaterialCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.materialCardViewStyle);
  }
  
  public MaterialCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = ThemeEnforcement.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.MaterialCardView, paramInt, R.style.Widget_MaterialComponents_CardView, new int[0]);
    this.cardViewHelper = new MaterialCardViewHelper(this);
    this.cardViewHelper.loadFromAttributes(paramContext);
    paramContext.recycle();
  }
  
  @ColorInt
  public int getStrokeColor()
  {
    return this.cardViewHelper.getStrokeColor();
  }
  
  @Dimension
  public int getStrokeWidth()
  {
    return this.cardViewHelper.getStrokeWidth();
  }
  
  public void setRadius(float paramFloat)
  {
    super.setRadius(paramFloat);
    this.cardViewHelper.updateForeground();
  }
  
  public void setStrokeColor(@ColorInt int paramInt)
  {
    this.cardViewHelper.setStrokeColor(paramInt);
  }
  
  public void setStrokeWidth(@Dimension int paramInt)
  {
    this.cardViewHelper.setStrokeWidth(paramInt);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\card\MaterialCardView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */