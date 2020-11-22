package android.support.v7.widget;

import android.content.Context;
import android.support.annotation.RestrictTo;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R.attr;
import android.support.v7.appcompat.R.id;
import android.support.v7.appcompat.R.layout;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.view.ActionMode;
import android.support.v7.view.menu.MenuBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class ActionBarContextView
  extends AbsActionBarView
{
  private static final String TAG = "ActionBarContextView";
  private View mClose;
  private int mCloseItemLayout;
  private View mCustomView;
  private CharSequence mSubtitle;
  private int mSubtitleStyleRes;
  private TextView mSubtitleView;
  private CharSequence mTitle;
  private LinearLayout mTitleLayout;
  private boolean mTitleOptional;
  private int mTitleStyleRes;
  private TextView mTitleView;
  
  public ActionBarContextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.actionModeStyle);
  }
  
  public ActionBarContextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.ActionMode, paramInt, 0);
    ViewCompat.setBackground(this, paramContext.getDrawable(R.styleable.ActionMode_background));
    this.mTitleStyleRes = paramContext.getResourceId(R.styleable.ActionMode_titleTextStyle, 0);
    this.mSubtitleStyleRes = paramContext.getResourceId(R.styleable.ActionMode_subtitleTextStyle, 0);
    this.mContentHeight = paramContext.getLayoutDimension(R.styleable.ActionMode_height, 0);
    this.mCloseItemLayout = paramContext.getResourceId(R.styleable.ActionMode_closeItemLayout, R.layout.abc_action_mode_close_item_material);
    paramContext.recycle();
  }
  
  private void initTitle()
  {
    if (this.mTitleLayout == null)
    {
      LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
      this.mTitleLayout = ((LinearLayout)getChildAt(getChildCount() - 1));
      this.mTitleView = ((TextView)this.mTitleLayout.findViewById(R.id.action_bar_title));
      this.mSubtitleView = ((TextView)this.mTitleLayout.findViewById(R.id.action_bar_subtitle));
      if (this.mTitleStyleRes != 0) {
        this.mTitleView.setTextAppearance(getContext(), this.mTitleStyleRes);
      }
      if (this.mSubtitleStyleRes != 0) {
        this.mSubtitleView.setTextAppearance(getContext(), this.mSubtitleStyleRes);
      }
    }
    this.mTitleView.setText(this.mTitle);
    this.mSubtitleView.setText(this.mSubtitle);
    boolean bool2 = TextUtils.isEmpty(this.mTitle);
    boolean bool1 = TextUtils.isEmpty(this.mSubtitle) ^ true;
    Object localObject = this.mSubtitleView;
    int j = 8;
    int i;
    if (bool1) {
      i = 0;
    } else {
      i = 8;
    }
    ((TextView)localObject).setVisibility(i);
    localObject = this.mTitleLayout;
    if (!(bool2 ^ true))
    {
      i = j;
      if (!bool1) {}
    }
    else
    {
      i = 0;
    }
    ((LinearLayout)localObject).setVisibility(i);
    if (this.mTitleLayout.getParent() == null) {
      addView(this.mTitleLayout);
    }
  }
  
  public void closeMode()
  {
    if (this.mClose == null)
    {
      killMode();
      return;
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewGroup.MarginLayoutParams(-1, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
  }
  
  public CharSequence getSubtitle()
  {
    return this.mSubtitle;
  }
  
  public CharSequence getTitle()
  {
    return this.mTitle;
  }
  
  public boolean hideOverflowMenu()
  {
    if (this.mActionMenuPresenter != null) {
      return this.mActionMenuPresenter.hideOverflowMenu();
    }
    return false;
  }
  
  public void initForMode(final ActionMode paramActionMode)
  {
    if (this.mClose == null)
    {
      this.mClose = LayoutInflater.from(getContext()).inflate(this.mCloseItemLayout, this, false);
      addView(this.mClose);
    }
    else if (this.mClose.getParent() == null)
    {
      addView(this.mClose);
    }
    this.mClose.findViewById(R.id.action_mode_close_button).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramActionMode.finish();
      }
    });
    paramActionMode = (MenuBuilder)paramActionMode.getMenu();
    if (this.mActionMenuPresenter != null) {
      this.mActionMenuPresenter.dismissPopupMenus();
    }
    this.mActionMenuPresenter = new ActionMenuPresenter(getContext());
    this.mActionMenuPresenter.setReserveOverflow(true);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-2, -1);
    paramActionMode.addMenuPresenter(this.mActionMenuPresenter, this.mPopupContext);
    this.mMenuView = ((ActionMenuView)this.mActionMenuPresenter.getMenuView(this));
    ViewCompat.setBackground(this.mMenuView, null);
    addView(this.mMenuView, localLayoutParams);
  }
  
  public boolean isOverflowMenuShowing()
  {
    if (this.mActionMenuPresenter != null) {
      return this.mActionMenuPresenter.isOverflowMenuShowing();
    }
    return false;
  }
  
  public boolean isTitleOptional()
  {
    return this.mTitleOptional;
  }
  
  public void killMode()
  {
    removeAllViews();
    this.mCustomView = null;
    this.mMenuView = null;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mActionMenuPresenter != null)
    {
      this.mActionMenuPresenter.hideOverflowMenu();
      this.mActionMenuPresenter.hideSubMenus();
    }
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 32)
    {
      paramAccessibilityEvent.setSource(this);
      paramAccessibilityEvent.setClassName(getClass().getName());
      paramAccessibilityEvent.setPackageName(getContext().getPackageName());
      paramAccessibilityEvent.setContentDescription(this.mTitle);
      return;
    }
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramBoolean = ViewUtils.isLayoutRtl(this);
    int i;
    if (paramBoolean) {
      i = paramInt3 - paramInt1 - getPaddingRight();
    } else {
      i = getPaddingLeft();
    }
    int j = getPaddingTop();
    int k = paramInt4 - paramInt2 - getPaddingTop() - getPaddingBottom();
    if ((this.mClose != null) && (this.mClose.getVisibility() != 8))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.mClose.getLayoutParams();
      if (paramBoolean) {
        paramInt2 = localMarginLayoutParams.rightMargin;
      } else {
        paramInt2 = localMarginLayoutParams.leftMargin;
      }
      if (paramBoolean) {
        paramInt4 = localMarginLayoutParams.leftMargin;
      } else {
        paramInt4 = localMarginLayoutParams.rightMargin;
      }
      paramInt2 = next(i, paramInt2, paramBoolean);
      paramInt2 = next(paramInt2 + positionChild(this.mClose, paramInt2, j, k, paramBoolean), paramInt4, paramBoolean);
    }
    else
    {
      paramInt2 = i;
    }
    paramInt4 = paramInt2;
    if (this.mTitleLayout != null)
    {
      paramInt4 = paramInt2;
      if (this.mCustomView == null)
      {
        paramInt4 = paramInt2;
        if (this.mTitleLayout.getVisibility() != 8) {
          paramInt4 = paramInt2 + positionChild(this.mTitleLayout, paramInt2, j, k, paramBoolean);
        }
      }
    }
    if (this.mCustomView != null) {
      positionChild(this.mCustomView, paramInt4, j, k, paramBoolean);
    }
    if (paramBoolean) {
      paramInt1 = getPaddingLeft();
    } else {
      paramInt1 = paramInt3 - paramInt1 - getPaddingRight();
    }
    if (this.mMenuView != null) {
      positionChild(this.mMenuView, paramInt1, j, k, paramBoolean ^ true);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    int k = 1073741824;
    if (i == 1073741824)
    {
      if (View.MeasureSpec.getMode(paramInt2) != 0)
      {
        int i1 = View.MeasureSpec.getSize(paramInt1);
        if (this.mContentHeight > 0) {
          i = this.mContentHeight;
        } else {
          i = View.MeasureSpec.getSize(paramInt2);
        }
        int i2 = getPaddingTop() + getPaddingBottom();
        paramInt1 = i1 - getPaddingLeft() - getPaddingRight();
        int n = i - i2;
        int j = View.MeasureSpec.makeMeasureSpec(n, Integer.MIN_VALUE);
        localObject = this.mClose;
        int m = 0;
        paramInt2 = paramInt1;
        if (localObject != null)
        {
          paramInt1 = measureChildView(this.mClose, paramInt1, j, 0);
          localObject = (ViewGroup.MarginLayoutParams)this.mClose.getLayoutParams();
          paramInt2 = paramInt1 - (((ViewGroup.MarginLayoutParams)localObject).leftMargin + ((ViewGroup.MarginLayoutParams)localObject).rightMargin);
        }
        paramInt1 = paramInt2;
        if (this.mMenuView != null)
        {
          paramInt1 = paramInt2;
          if (this.mMenuView.getParent() == this) {
            paramInt1 = measureChildView(this.mMenuView, paramInt2, j, 0);
          }
        }
        paramInt2 = paramInt1;
        if (this.mTitleLayout != null)
        {
          paramInt2 = paramInt1;
          if (this.mCustomView == null) {
            if (this.mTitleOptional)
            {
              paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 0);
              this.mTitleLayout.measure(paramInt2, j);
              int i3 = this.mTitleLayout.getMeasuredWidth();
              if (i3 <= paramInt1) {
                j = 1;
              } else {
                j = 0;
              }
              paramInt2 = paramInt1;
              if (j != 0) {
                paramInt2 = paramInt1 - i3;
              }
              localObject = this.mTitleLayout;
              if (j != 0) {
                paramInt1 = 0;
              } else {
                paramInt1 = 8;
              }
              ((LinearLayout)localObject).setVisibility(paramInt1);
            }
            else
            {
              paramInt2 = measureChildView(this.mTitleLayout, paramInt1, j, 0);
            }
          }
        }
        if (this.mCustomView != null)
        {
          localObject = this.mCustomView.getLayoutParams();
          if (((ViewGroup.LayoutParams)localObject).width != -2) {
            paramInt1 = 1073741824;
          } else {
            paramInt1 = Integer.MIN_VALUE;
          }
          j = paramInt2;
          if (((ViewGroup.LayoutParams)localObject).width >= 0) {
            j = Math.min(((ViewGroup.LayoutParams)localObject).width, paramInt2);
          }
          if (((ViewGroup.LayoutParams)localObject).height != -2) {
            paramInt2 = k;
          } else {
            paramInt2 = Integer.MIN_VALUE;
          }
          k = n;
          if (((ViewGroup.LayoutParams)localObject).height >= 0) {
            k = Math.min(((ViewGroup.LayoutParams)localObject).height, n);
          }
          this.mCustomView.measure(View.MeasureSpec.makeMeasureSpec(j, paramInt1), View.MeasureSpec.makeMeasureSpec(k, paramInt2));
        }
        if (this.mContentHeight <= 0)
        {
          k = getChildCount();
          paramInt2 = 0;
          paramInt1 = m;
          while (paramInt1 < k)
          {
            j = getChildAt(paramInt1).getMeasuredHeight() + i2;
            i = paramInt2;
            if (j > paramInt2) {
              i = j;
            }
            paramInt1 += 1;
            paramInt2 = i;
          }
          setMeasuredDimension(i1, paramInt2);
          return;
        }
        setMeasuredDimension(i1, i);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getClass().getSimpleName());
      ((StringBuilder)localObject).append(" can only be used ");
      ((StringBuilder)localObject).append("with android:layout_height=\"wrap_content\"");
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getClass().getSimpleName());
    ((StringBuilder)localObject).append(" can only be used ");
    ((StringBuilder)localObject).append("with android:layout_width=\"match_parent\" (or fill_parent)");
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public void setContentHeight(int paramInt)
  {
    this.mContentHeight = paramInt;
  }
  
  public void setCustomView(View paramView)
  {
    if (this.mCustomView != null) {
      removeView(this.mCustomView);
    }
    this.mCustomView = paramView;
    if ((paramView != null) && (this.mTitleLayout != null))
    {
      removeView(this.mTitleLayout);
      this.mTitleLayout = null;
    }
    if (paramView != null) {
      addView(paramView);
    }
    requestLayout();
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    this.mSubtitle = paramCharSequence;
    initTitle();
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.mTitle = paramCharSequence;
    initTitle();
  }
  
  public void setTitleOptional(boolean paramBoolean)
  {
    if (paramBoolean != this.mTitleOptional) {
      requestLayout();
    }
    this.mTitleOptional = paramBoolean;
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public boolean showOverflowMenu()
  {
    if (this.mActionMenuPresenter != null) {
      return this.mActionMenuPresenter.showOverflowMenu();
    }
    return false;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\widget\ActionBarContextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */