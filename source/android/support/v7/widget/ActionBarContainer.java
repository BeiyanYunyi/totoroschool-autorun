package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class ActionBarContainer
  extends FrameLayout
{
  private View mActionBarView;
  Drawable mBackground;
  private View mContextView;
  private int mHeight;
  boolean mIsSplit;
  boolean mIsStacked;
  private boolean mIsTransitioning;
  Drawable mSplitBackground;
  Drawable mStackedBackground;
  private View mTabContainer;
  
  public ActionBarContainer(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ViewCompat.setBackground(this, new ActionBarBackgroundDrawable(this));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ActionBar);
    this.mBackground = paramContext.getDrawable(R.styleable.ActionBar_background);
    this.mStackedBackground = paramContext.getDrawable(R.styleable.ActionBar_backgroundStacked);
    this.mHeight = paramContext.getDimensionPixelSize(R.styleable.ActionBar_height, -1);
    if (getId() == R.id.split_action_bar)
    {
      this.mIsSplit = true;
      this.mSplitBackground = paramContext.getDrawable(R.styleable.ActionBar_backgroundSplit);
    }
    paramContext.recycle();
    boolean bool1 = this.mIsSplit;
    boolean bool2 = false;
    if (bool1)
    {
      bool1 = bool2;
      if (this.mSplitBackground != null) {}
    }
    else
    {
      do
      {
        bool1 = true;
        break;
        bool1 = bool2;
        if (this.mBackground != null) {
          break;
        }
        bool1 = bool2;
      } while (this.mStackedBackground == null);
    }
    setWillNotDraw(bool1);
  }
  
  private int getMeasuredHeightWithMargins(View paramView)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)paramView.getLayoutParams();
    return paramView.getMeasuredHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin;
  }
  
  private boolean isCollapsed(View paramView)
  {
    return (paramView == null) || (paramView.getVisibility() == 8) || (paramView.getMeasuredHeight() == 0);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if ((this.mBackground != null) && (this.mBackground.isStateful())) {
      this.mBackground.setState(getDrawableState());
    }
    if ((this.mStackedBackground != null) && (this.mStackedBackground.isStateful())) {
      this.mStackedBackground.setState(getDrawableState());
    }
    if ((this.mSplitBackground != null) && (this.mSplitBackground.isStateful())) {
      this.mSplitBackground.setState(getDrawableState());
    }
  }
  
  public View getTabContainer()
  {
    return this.mTabContainer;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if (this.mBackground != null) {
      this.mBackground.jumpToCurrentState();
    }
    if (this.mStackedBackground != null) {
      this.mStackedBackground.jumpToCurrentState();
    }
    if (this.mSplitBackground != null) {
      this.mSplitBackground.jumpToCurrentState();
    }
  }
  
  public void onFinishInflate()
  {
    super.onFinishInflate();
    this.mActionBarView = findViewById(R.id.action_bar);
    this.mContextView = findViewById(R.id.action_context_bar);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    super.onHoverEvent(paramMotionEvent);
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return (this.mIsTransitioning) || (super.onInterceptTouchEvent(paramMotionEvent));
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = this.mTabContainer;
    paramInt2 = 1;
    paramInt4 = 0;
    if ((localView != null) && (localView.getVisibility() != 8)) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      int i = getMeasuredHeight();
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
      localView.layout(paramInt1, i - localView.getMeasuredHeight() - localLayoutParams.bottomMargin, paramInt3, i - localLayoutParams.bottomMargin);
    }
    if (this.mIsSplit)
    {
      if (this.mSplitBackground != null)
      {
        this.mSplitBackground.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        paramInt1 = paramInt2;
      }
      else
      {
        paramInt1 = 0;
      }
    }
    else
    {
      paramInt1 = paramInt4;
      if (this.mBackground != null)
      {
        if (this.mActionBarView.getVisibility() == 0) {
          this.mBackground.setBounds(this.mActionBarView.getLeft(), this.mActionBarView.getTop(), this.mActionBarView.getRight(), this.mActionBarView.getBottom());
        } else if ((this.mContextView != null) && (this.mContextView.getVisibility() == 0)) {
          this.mBackground.setBounds(this.mContextView.getLeft(), this.mContextView.getTop(), this.mContextView.getRight(), this.mContextView.getBottom());
        } else {
          this.mBackground.setBounds(0, 0, 0, 0);
        }
        paramInt1 = 1;
      }
      this.mIsStacked = paramBoolean;
      if ((paramBoolean) && (this.mStackedBackground != null))
      {
        this.mStackedBackground.setBounds(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
        paramInt1 = paramInt2;
      }
    }
    if (paramInt1 != 0) {
      invalidate();
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (this.mActionBarView == null)
    {
      i = paramInt2;
      if (View.MeasureSpec.getMode(paramInt2) == Integer.MIN_VALUE)
      {
        i = paramInt2;
        if (this.mHeight >= 0) {
          i = View.MeasureSpec.makeMeasureSpec(Math.min(this.mHeight, View.MeasureSpec.getSize(paramInt2)), Integer.MIN_VALUE);
        }
      }
    }
    super.onMeasure(paramInt1, i);
    if (this.mActionBarView == null) {
      return;
    }
    paramInt2 = View.MeasureSpec.getMode(i);
    if ((this.mTabContainer != null) && (this.mTabContainer.getVisibility() != 8) && (paramInt2 != 1073741824))
    {
      if (!isCollapsed(this.mActionBarView)) {
        paramInt1 = getMeasuredHeightWithMargins(this.mActionBarView);
      } else if (!isCollapsed(this.mContextView)) {
        paramInt1 = getMeasuredHeightWithMargins(this.mContextView);
      } else {
        paramInt1 = 0;
      }
      if (paramInt2 == Integer.MIN_VALUE) {
        paramInt2 = View.MeasureSpec.getSize(i);
      } else {
        paramInt2 = Integer.MAX_VALUE;
      }
      setMeasuredDimension(getMeasuredWidth(), Math.min(paramInt1 + getMeasuredHeightWithMargins(this.mTabContainer), paramInt2));
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setPrimaryBackground(Drawable paramDrawable)
  {
    if (this.mBackground != null)
    {
      this.mBackground.setCallback(null);
      unscheduleDrawable(this.mBackground);
    }
    this.mBackground = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if (this.mActionBarView != null) {
        this.mBackground.setBounds(this.mActionBarView.getLeft(), this.mActionBarView.getTop(), this.mActionBarView.getRight(), this.mActionBarView.getBottom());
      }
    }
    boolean bool1 = this.mIsSplit;
    boolean bool2 = false;
    if (bool1)
    {
      bool1 = bool2;
      if (this.mSplitBackground != null) {}
    }
    else
    {
      do
      {
        bool1 = true;
        break;
        bool1 = bool2;
        if (this.mBackground != null) {
          break;
        }
        bool1 = bool2;
      } while (this.mStackedBackground == null);
    }
    setWillNotDraw(bool1);
    invalidate();
  }
  
  public void setSplitBackground(Drawable paramDrawable)
  {
    if (this.mSplitBackground != null)
    {
      this.mSplitBackground.setCallback(null);
      unscheduleDrawable(this.mSplitBackground);
    }
    this.mSplitBackground = paramDrawable;
    boolean bool2 = false;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if ((this.mIsSplit) && (this.mSplitBackground != null)) {
        this.mSplitBackground.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
      }
    }
    boolean bool1;
    if (this.mIsSplit)
    {
      bool1 = bool2;
      if (this.mSplitBackground != null) {}
    }
    else
    {
      do
      {
        bool1 = true;
        break;
        bool1 = bool2;
        if (this.mBackground != null) {
          break;
        }
        bool1 = bool2;
      } while (this.mStackedBackground == null);
    }
    setWillNotDraw(bool1);
    invalidate();
  }
  
  public void setStackedBackground(Drawable paramDrawable)
  {
    if (this.mStackedBackground != null)
    {
      this.mStackedBackground.setCallback(null);
      unscheduleDrawable(this.mStackedBackground);
    }
    this.mStackedBackground = paramDrawable;
    if (paramDrawable != null)
    {
      paramDrawable.setCallback(this);
      if ((this.mIsStacked) && (this.mStackedBackground != null)) {
        this.mStackedBackground.setBounds(this.mTabContainer.getLeft(), this.mTabContainer.getTop(), this.mTabContainer.getRight(), this.mTabContainer.getBottom());
      }
    }
    boolean bool1 = this.mIsSplit;
    boolean bool2 = false;
    if (bool1)
    {
      bool1 = bool2;
      if (this.mSplitBackground != null) {}
    }
    else
    {
      do
      {
        bool1 = true;
        break;
        bool1 = bool2;
        if (this.mBackground != null) {
          break;
        }
        bool1 = bool2;
      } while (this.mStackedBackground == null);
    }
    setWillNotDraw(bool1);
    invalidate();
  }
  
  public void setTabContainer(ScrollingTabContainerView paramScrollingTabContainerView)
  {
    if (this.mTabContainer != null) {
      removeView(this.mTabContainer);
    }
    this.mTabContainer = paramScrollingTabContainerView;
    if (paramScrollingTabContainerView != null)
    {
      addView(paramScrollingTabContainerView);
      ViewGroup.LayoutParams localLayoutParams = paramScrollingTabContainerView.getLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      paramScrollingTabContainerView.setAllowCollapse(false);
    }
  }
  
  public void setTransitioning(boolean paramBoolean)
  {
    this.mIsTransitioning = paramBoolean;
    int i;
    if (paramBoolean) {
      i = 393216;
    } else {
      i = 262144;
    }
    setDescendantFocusability(i);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (this.mBackground != null) {
      this.mBackground.setVisible(bool, false);
    }
    if (this.mStackedBackground != null) {
      this.mStackedBackground.setVisible(bool, false);
    }
    if (this.mSplitBackground != null) {
      this.mSplitBackground.setVisible(bool, false);
    }
  }
  
  public ActionMode startActionModeForChild(View paramView, ActionMode.Callback paramCallback)
  {
    return null;
  }
  
  public ActionMode startActionModeForChild(View paramView, ActionMode.Callback paramCallback, int paramInt)
  {
    if (paramInt != 0) {
      return super.startActionModeForChild(paramView, paramCallback, paramInt);
    }
    return null;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return ((paramDrawable == this.mBackground) && (!this.mIsSplit)) || ((paramDrawable == this.mStackedBackground) && (this.mIsStacked)) || ((paramDrawable == this.mSplitBackground) && (this.mIsSplit)) || (super.verifyDrawable(paramDrawable));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\widget\ActionBarContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */