package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.design.R.style;
import android.support.design.R.styleable;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class ScrimInsetsFrameLayout
  extends FrameLayout
{
  Drawable insetForeground;
  Rect insets;
  private Rect tempRect = new Rect();
  
  public ScrimInsetsFrameLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ScrimInsetsFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScrimInsetsFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = ThemeEnforcement.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.ScrimInsetsFrameLayout, paramInt, R.style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
    this.insetForeground = paramContext.getDrawable(R.styleable.ScrimInsetsFrameLayout_insetForeground);
    paramContext.recycle();
    setWillNotDraw(true);
    ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener()
    {
      public WindowInsetsCompat onApplyWindowInsets(View paramAnonymousView, WindowInsetsCompat paramAnonymousWindowInsetsCompat)
      {
        if (ScrimInsetsFrameLayout.this.insets == null) {
          ScrimInsetsFrameLayout.this.insets = new Rect();
        }
        ScrimInsetsFrameLayout.this.insets.set(paramAnonymousWindowInsetsCompat.getSystemWindowInsetLeft(), paramAnonymousWindowInsetsCompat.getSystemWindowInsetTop(), paramAnonymousWindowInsetsCompat.getSystemWindowInsetRight(), paramAnonymousWindowInsetsCompat.getSystemWindowInsetBottom());
        ScrimInsetsFrameLayout.this.onInsetsChanged(paramAnonymousWindowInsetsCompat);
        paramAnonymousView = ScrimInsetsFrameLayout.this;
        boolean bool;
        if ((paramAnonymousWindowInsetsCompat.hasSystemWindowInsets()) && (ScrimInsetsFrameLayout.this.insetForeground != null)) {
          bool = false;
        } else {
          bool = true;
        }
        paramAnonymousView.setWillNotDraw(bool);
        ViewCompat.postInvalidateOnAnimation(ScrimInsetsFrameLayout.this);
        return paramAnonymousWindowInsetsCompat.consumeSystemWindowInsets();
      }
    });
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i = getWidth();
    int j = getHeight();
    if ((this.insets != null) && (this.insetForeground != null))
    {
      int k = paramCanvas.save();
      paramCanvas.translate(getScrollX(), getScrollY());
      this.tempRect.set(0, 0, i, this.insets.top);
      this.insetForeground.setBounds(this.tempRect);
      this.insetForeground.draw(paramCanvas);
      this.tempRect.set(0, j - this.insets.bottom, i, j);
      this.insetForeground.setBounds(this.tempRect);
      this.insetForeground.draw(paramCanvas);
      this.tempRect.set(0, this.insets.top, this.insets.left, j - this.insets.bottom);
      this.insetForeground.setBounds(this.tempRect);
      this.insetForeground.draw(paramCanvas);
      this.tempRect.set(i - this.insets.right, this.insets.top, i, j - this.insets.bottom);
      this.insetForeground.setBounds(this.tempRect);
      this.insetForeground.draw(paramCanvas);
      paramCanvas.restoreToCount(k);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.insetForeground != null) {
      this.insetForeground.setCallback(this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.insetForeground != null) {
      this.insetForeground.setCallback(null);
    }
  }
  
  protected void onInsetsChanged(WindowInsetsCompat paramWindowInsetsCompat) {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\internal\ScrimInsetsFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */