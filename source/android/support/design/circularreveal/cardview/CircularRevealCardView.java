package android.support.design.circularreveal.cardview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.design.circularreveal.CircularRevealHelper;
import android.support.design.circularreveal.CircularRevealWidget;
import android.support.design.circularreveal.CircularRevealWidget.RevealInfo;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;

public class CircularRevealCardView
  extends CardView
  implements CircularRevealWidget
{
  private final CircularRevealHelper helper = new CircularRevealHelper(this);
  
  public CircularRevealCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CircularRevealCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void actualDraw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public boolean actualIsOpaque()
  {
    return super.isOpaque();
  }
  
  public void buildCircularRevealCache()
  {
    this.helper.buildCircularRevealCache();
  }
  
  public void destroyCircularRevealCache()
  {
    this.helper.destroyCircularRevealCache();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.helper != null)
    {
      this.helper.draw(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  @Nullable
  public Drawable getCircularRevealOverlayDrawable()
  {
    return this.helper.getCircularRevealOverlayDrawable();
  }
  
  public int getCircularRevealScrimColor()
  {
    return this.helper.getCircularRevealScrimColor();
  }
  
  @Nullable
  public CircularRevealWidget.RevealInfo getRevealInfo()
  {
    return this.helper.getRevealInfo();
  }
  
  public boolean isOpaque()
  {
    if (this.helper != null) {
      return this.helper.isOpaque();
    }
    return super.isOpaque();
  }
  
  public void setCircularRevealOverlayDrawable(@Nullable Drawable paramDrawable)
  {
    this.helper.setCircularRevealOverlayDrawable(paramDrawable);
  }
  
  public void setCircularRevealScrimColor(@ColorInt int paramInt)
  {
    this.helper.setCircularRevealScrimColor(paramInt);
  }
  
  public void setRevealInfo(@Nullable CircularRevealWidget.RevealInfo paramRevealInfo)
  {
    this.helper.setRevealInfo(paramRevealInfo);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\circularreveal\cardview\CircularRevealCardView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */