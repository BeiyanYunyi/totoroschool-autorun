package android.support.design.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.design.R.styleable;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.Gravity;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class ForegroundLinearLayout
  extends LinearLayoutCompat
{
  private Drawable foreground;
  boolean foregroundBoundsChanged = false;
  private int foregroundGravity = 119;
  protected boolean mForegroundInPadding = true;
  private final Rect overlayBounds = new Rect();
  private final Rect selfBounds = new Rect();
  
  public ForegroundLinearLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ForegroundLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ForegroundLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = ThemeEnforcement.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.ForegroundLinearLayout, paramInt, 0, new int[0]);
    this.foregroundGravity = paramContext.getInt(R.styleable.ForegroundLinearLayout_android_foregroundGravity, this.foregroundGravity);
    paramAttributeSet = paramContext.getDrawable(R.styleable.ForegroundLinearLayout_android_foreground);
    if (paramAttributeSet != null) {
      setForeground(paramAttributeSet);
    }
    this.mForegroundInPadding = paramContext.getBoolean(R.styleable.ForegroundLinearLayout_foregroundInsidePadding, true);
    paramContext.recycle();
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.foreground != null)
    {
      Drawable localDrawable = this.foreground;
      if (this.foregroundBoundsChanged)
      {
        this.foregroundBoundsChanged = false;
        Rect localRect1 = this.selfBounds;
        Rect localRect2 = this.overlayBounds;
        int i = getRight() - getLeft();
        int j = getBottom() - getTop();
        if (this.mForegroundInPadding) {
          localRect1.set(0, 0, i, j);
        } else {
          localRect1.set(getPaddingLeft(), getPaddingTop(), i - getPaddingRight(), j - getPaddingBottom());
        }
        Gravity.apply(this.foregroundGravity, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight(), localRect1, localRect2);
        localDrawable.setBounds(localRect2);
      }
      localDrawable.draw(paramCanvas);
    }
  }
  
  @TargetApi(21)
  @RequiresApi(21)
  public void drawableHotspotChanged(float paramFloat1, float paramFloat2)
  {
    super.drawableHotspotChanged(paramFloat1, paramFloat2);
    if (this.foreground != null) {
      this.foreground.setHotspot(paramFloat1, paramFloat2);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if ((this.foreground != null) && (this.foreground.isStateful())) {
      this.foreground.setState(getDrawableState());
    }
  }
  
  public Drawable getForeground()
  {
    return this.foreground;
  }
  
  public int getForegroundGravity()
  {
    return this.foregroundGravity;
  }
  
  @RequiresApi(11)
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if (this.foreground != null) {
      this.foreground.jumpToCurrentState();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.foregroundBoundsChanged = (paramBoolean | this.foregroundBoundsChanged);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.foregroundBoundsChanged = true;
  }
  
  public void setForeground(Drawable paramDrawable)
  {
    if (this.foreground != paramDrawable)
    {
      if (this.foreground != null)
      {
        this.foreground.setCallback(null);
        unscheduleDrawable(this.foreground);
      }
      this.foreground = paramDrawable;
      if (paramDrawable != null)
      {
        setWillNotDraw(false);
        paramDrawable.setCallback(this);
        if (paramDrawable.isStateful()) {
          paramDrawable.setState(getDrawableState());
        }
        if (this.foregroundGravity == 119) {
          paramDrawable.getPadding(new Rect());
        }
      }
      else
      {
        setWillNotDraw(true);
      }
      requestLayout();
      invalidate();
    }
  }
  
  public void setForegroundGravity(int paramInt)
  {
    if (this.foregroundGravity != paramInt)
    {
      int i = paramInt;
      if ((0x800007 & paramInt) == 0) {
        i = paramInt | 0x800003;
      }
      paramInt = i;
      if ((i & 0x70) == 0) {
        paramInt = i | 0x30;
      }
      this.foregroundGravity = paramInt;
      if ((this.foregroundGravity == 119) && (this.foreground != null))
      {
        Rect localRect = new Rect();
        this.foreground.getPadding(localRect);
      }
      requestLayout();
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.foreground);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\internal\ForegroundLinearLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */