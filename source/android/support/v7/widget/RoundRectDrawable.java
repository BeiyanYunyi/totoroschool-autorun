package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;

@RequiresApi(21)
class RoundRectDrawable
  extends Drawable
{
  private ColorStateList mBackground;
  private final RectF mBoundsF;
  private final Rect mBoundsI;
  private boolean mInsetForPadding = false;
  private boolean mInsetForRadius = true;
  private float mPadding;
  private final Paint mPaint;
  private float mRadius;
  private ColorStateList mTint;
  private PorterDuffColorFilter mTintFilter;
  private PorterDuff.Mode mTintMode = PorterDuff.Mode.SRC_IN;
  
  RoundRectDrawable(ColorStateList paramColorStateList, float paramFloat)
  {
    this.mRadius = paramFloat;
    this.mPaint = new Paint(5);
    setBackground(paramColorStateList);
    this.mBoundsF = new RectF();
    this.mBoundsI = new Rect();
  }
  
  private PorterDuffColorFilter createTintFilter(ColorStateList paramColorStateList, PorterDuff.Mode paramMode)
  {
    if ((paramColorStateList != null) && (paramMode != null)) {
      return new PorterDuffColorFilter(paramColorStateList.getColorForState(getState(), 0), paramMode);
    }
    return null;
  }
  
  private void setBackground(ColorStateList paramColorStateList)
  {
    ColorStateList localColorStateList = paramColorStateList;
    if (paramColorStateList == null) {
      localColorStateList = ColorStateList.valueOf(0);
    }
    this.mBackground = localColorStateList;
    this.mPaint.setColor(this.mBackground.getColorForState(getState(), this.mBackground.getDefaultColor()));
  }
  
  private void updateBounds(Rect paramRect)
  {
    Rect localRect = paramRect;
    if (paramRect == null) {
      localRect = getBounds();
    }
    this.mBoundsF.set(localRect.left, localRect.top, localRect.right, localRect.bottom);
    this.mBoundsI.set(localRect);
    if (this.mInsetForPadding)
    {
      float f1 = RoundRectDrawableWithShadow.calculateVerticalPadding(this.mPadding, this.mRadius, this.mInsetForRadius);
      float f2 = RoundRectDrawableWithShadow.calculateHorizontalPadding(this.mPadding, this.mRadius, this.mInsetForRadius);
      this.mBoundsI.inset((int)Math.ceil(f2), (int)Math.ceil(f1));
      this.mBoundsF.set(this.mBoundsI);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    Paint localPaint = this.mPaint;
    int i;
    if ((this.mTintFilter != null) && (localPaint.getColorFilter() == null))
    {
      localPaint.setColorFilter(this.mTintFilter);
      i = 1;
    }
    else
    {
      i = 0;
    }
    paramCanvas.drawRoundRect(this.mBoundsF, this.mRadius, this.mRadius, localPaint);
    if (i != 0) {
      localPaint.setColorFilter(null);
    }
  }
  
  public ColorStateList getColor()
  {
    return this.mBackground;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void getOutline(Outline paramOutline)
  {
    paramOutline.setRoundRect(this.mBoundsI, this.mRadius);
  }
  
  float getPadding()
  {
    return this.mPadding;
  }
  
  public float getRadius()
  {
    return this.mRadius;
  }
  
  public boolean isStateful()
  {
    return ((this.mTint != null) && (this.mTint.isStateful())) || ((this.mBackground != null) && (this.mBackground.isStateful())) || (super.isStateful());
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    updateBounds(paramRect);
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    int i = this.mBackground.getColorForState(paramArrayOfInt, this.mBackground.getDefaultColor());
    boolean bool;
    if (i != this.mPaint.getColor()) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {
      this.mPaint.setColor(i);
    }
    if ((this.mTint != null) && (this.mTintMode != null))
    {
      this.mTintFilter = createTintFilter(this.mTint, this.mTintMode);
      return true;
    }
    return bool;
  }
  
  public void setAlpha(int paramInt)
  {
    this.mPaint.setAlpha(paramInt);
  }
  
  public void setColor(@Nullable ColorStateList paramColorStateList)
  {
    setBackground(paramColorStateList);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
  }
  
  void setPadding(float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramFloat == this.mPadding) && (this.mInsetForPadding == paramBoolean1) && (this.mInsetForRadius == paramBoolean2)) {
      return;
    }
    this.mPadding = paramFloat;
    this.mInsetForPadding = paramBoolean1;
    this.mInsetForRadius = paramBoolean2;
    updateBounds(null);
    invalidateSelf();
  }
  
  void setRadius(float paramFloat)
  {
    if (paramFloat == this.mRadius) {
      return;
    }
    this.mRadius = paramFloat;
    updateBounds(null);
    invalidateSelf();
  }
  
  public void setTintList(ColorStateList paramColorStateList)
  {
    this.mTint = paramColorStateList;
    this.mTintFilter = createTintFilter(this.mTint, this.mTintMode);
    invalidateSelf();
  }
  
  public void setTintMode(PorterDuff.Mode paramMode)
  {
    this.mTintMode = paramMode;
    this.mTintFilter = createTintFilter(this.mTint, this.mTintMode);
    invalidateSelf();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\widget\RoundRectDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */