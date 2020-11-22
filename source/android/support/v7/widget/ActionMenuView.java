package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.StyleRes;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.view.menu.MenuBuilder.ItemInvoker;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.view.menu.MenuView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView
  extends LinearLayoutCompat
  implements MenuBuilder.ItemInvoker, MenuView
{
  static final int GENERATED_ITEM_PADDING = 4;
  static final int MIN_CELL_SIZE = 56;
  private static final String TAG = "ActionMenuView";
  private MenuPresenter.Callback mActionMenuPresenterCallback;
  private boolean mFormatItems;
  private int mFormatItemsWidth;
  private int mGeneratedItemPadding;
  private MenuBuilder mMenu;
  MenuBuilder.Callback mMenuBuilderCallback;
  private int mMinCellSize;
  OnMenuItemClickListener mOnMenuItemClickListener;
  private Context mPopupContext;
  private int mPopupTheme;
  private ActionMenuPresenter mPresenter;
  private boolean mReserveOverflow;
  
  public ActionMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ActionMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setBaselineAligned(false);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.mMinCellSize = ((int)(56.0F * f));
    this.mGeneratedItemPadding = ((int)(f * 4.0F));
    this.mPopupContext = paramContext;
    this.mPopupTheme = 0;
  }
  
  static int measureChildForCells(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int j = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt3) - paramInt4, View.MeasureSpec.getMode(paramInt3));
    ActionMenuItemView localActionMenuItemView;
    if ((paramView instanceof ActionMenuItemView)) {
      localActionMenuItemView = (ActionMenuItemView)paramView;
    } else {
      localActionMenuItemView = null;
    }
    boolean bool = true;
    if ((localActionMenuItemView != null) && (localActionMenuItemView.hasText())) {
      paramInt3 = 1;
    } else {
      paramInt3 = 0;
    }
    paramInt4 = 2;
    if ((paramInt2 > 0) && ((paramInt3 == 0) || (paramInt2 >= 2)))
    {
      paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt2 * paramInt1, Integer.MIN_VALUE), j);
      int k = paramView.getMeasuredWidth();
      int i = k / paramInt1;
      paramInt2 = i;
      if (k % paramInt1 != 0) {
        paramInt2 = i + 1;
      }
      if ((paramInt3 != 0) && (paramInt2 < 2)) {
        paramInt2 = paramInt4;
      }
    }
    else
    {
      paramInt2 = 0;
    }
    if ((localLayoutParams.isOverflowButton) || (paramInt3 == 0)) {
      bool = false;
    }
    localLayoutParams.expandable = bool;
    localLayoutParams.cellsUsed = paramInt2;
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 * paramInt2, 1073741824), j);
    return paramInt2;
  }
  
  private void onMeasureExactFormat(int paramInt1, int paramInt2)
  {
    int i11 = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt2);
    int i = getPaddingLeft();
    int j = getPaddingRight();
    int i5 = getPaddingTop() + getPaddingBottom();
    int i1 = getChildMeasureSpec(paramInt2, i5, -2);
    int i2 = paramInt1 - (i + j);
    paramInt1 = i2 / this.mMinCellSize;
    paramInt2 = this.mMinCellSize;
    if (paramInt1 == 0)
    {
      setMeasuredDimension(i2, 0);
      return;
    }
    int i12 = this.mMinCellSize + i2 % paramInt2 / paramInt1;
    int i7 = getChildCount();
    int n = 0;
    int m = 0;
    i = 0;
    int i4 = 0;
    int i3 = 0;
    j = 0;
    long l1 = 0L;
    paramInt2 = k;
    Object localObject;
    LayoutParams localLayoutParams;
    while (n < i7)
    {
      localObject = getChildAt(n);
      if (((View)localObject).getVisibility() != 8)
      {
        boolean bool = localObject instanceof ActionMenuItemView;
        i4 += 1;
        if (bool) {
          ((View)localObject).setPadding(this.mGeneratedItemPadding, 0, this.mGeneratedItemPadding, 0);
        }
        localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
        localLayoutParams.expanded = false;
        localLayoutParams.extraPixels = 0;
        localLayoutParams.cellsUsed = 0;
        localLayoutParams.expandable = false;
        localLayoutParams.leftMargin = 0;
        localLayoutParams.rightMargin = 0;
        if ((bool) && (((ActionMenuItemView)localObject).hasText())) {
          bool = true;
        } else {
          bool = false;
        }
        localLayoutParams.preventEdgeOffset = bool;
        if (localLayoutParams.isOverflowButton) {
          k = 1;
        } else {
          k = paramInt1;
        }
        i6 = measureChildForCells((View)localObject, i12, k, i1, i5);
        i3 = Math.max(i3, i6);
        k = j;
        if (localLayoutParams.expandable) {
          k = j + 1;
        }
        if (localLayoutParams.isOverflowButton) {
          i = 1;
        }
        paramInt1 -= i6;
        m = Math.max(m, ((View)localObject).getMeasuredHeight());
        if (i6 == 1) {
          l1 |= 1 << n;
        }
        j = k;
      }
      n += 1;
    }
    if ((i != 0) && (i4 == 2)) {
      i5 = 1;
    } else {
      i5 = 0;
    }
    int i8 = 0;
    int i6 = paramInt1;
    k = i7;
    n = i1;
    paramInt1 = i8;
    long l3;
    long l2;
    if ((j > 0) && (i6 > 0))
    {
      i8 = 0;
      int i9 = 0;
      i7 = Integer.MAX_VALUE;
      for (l3 = 0L; i8 < k; l3 = l2)
      {
        localObject = (LayoutParams)getChildAt(i8).getLayoutParams();
        int i10;
        if (!((LayoutParams)localObject).expandable)
        {
          i1 = i9;
          i10 = i7;
          l2 = l3;
        }
        else if (((LayoutParams)localObject).cellsUsed < i7)
        {
          i10 = ((LayoutParams)localObject).cellsUsed;
          l2 = 1L << i8;
          i1 = 1;
        }
        else
        {
          i1 = i9;
          i10 = i7;
          l2 = l3;
          if (((LayoutParams)localObject).cellsUsed == i7)
          {
            l2 = l3 | 1L << i8;
            i1 = i9 + 1;
            i10 = i7;
          }
        }
        i8 += 1;
        i9 = i1;
        i7 = i10;
      }
      l1 |= l3;
      if (i9 > i6) {}
    }
    else
    {
      for (;;)
      {
        paramInt1 = 0;
        while (paramInt1 < k)
        {
          localObject = getChildAt(paramInt1);
          localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
          long l4 = 1 << paramInt1;
          if ((l3 & l4) == 0L)
          {
            i1 = i6;
            l2 = l1;
            if (localLayoutParams.cellsUsed == i7 + 1)
            {
              l2 = l1 | l4;
              i1 = i6;
            }
          }
          else
          {
            if ((i5 != 0) && (localLayoutParams.preventEdgeOffset) && (i6 == 1)) {
              ((View)localObject).setPadding(this.mGeneratedItemPadding + i12, 0, this.mGeneratedItemPadding, 0);
            }
            localLayoutParams.cellsUsed += 1;
            localLayoutParams.expanded = true;
            i1 = i6 - 1;
            l2 = l1;
          }
          paramInt1 += 1;
          i6 = i1;
          l1 = l2;
        }
        paramInt1 = 1;
        break;
      }
    }
    if ((i == 0) && (i4 == 1)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i6 > 0) && (l1 != 0L) && ((i6 < i4 - 1) || (i != 0) || (i3 > 1)))
    {
      float f2 = Long.bitCount(l1);
      if (i == 0)
      {
        float f1;
        if ((l1 & 1L) != 0L)
        {
          f1 = f2;
          if (!((LayoutParams)getChildAt(0).getLayoutParams()).preventEdgeOffset) {
            f1 = f2 - 0.5F;
          }
        }
        else
        {
          f1 = f2;
        }
        i = k - 1;
        f2 = f1;
        if ((l1 & 1 << i) != 0L)
        {
          f2 = f1;
          if (!((LayoutParams)getChildAt(i).getLayoutParams()).preventEdgeOffset) {
            f2 = f1 - 0.5F;
          }
        }
      }
      if (f2 > 0.0F) {
        i = (int)(i6 * i12 / f2);
      } else {
        i = 0;
      }
      i3 = k;
      j = 0;
      while (j < i3)
      {
        if ((l1 & 1 << j) == 0L)
        {
          i1 = paramInt1;
        }
        else
        {
          localObject = getChildAt(j);
          localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
          if ((localObject instanceof ActionMenuItemView))
          {
            localLayoutParams.extraPixels = i;
            localLayoutParams.expanded = true;
            if ((j == 0) && (!localLayoutParams.preventEdgeOffset)) {
              localLayoutParams.leftMargin = (-i / 2);
            }
          }
          for (;;)
          {
            i1 = 1;
            break label1125;
            if (!localLayoutParams.isOverflowButton) {
              break;
            }
            localLayoutParams.extraPixels = i;
            localLayoutParams.expanded = true;
            localLayoutParams.rightMargin = (-i / 2);
          }
          if (j != 0) {
            localLayoutParams.leftMargin = (i / 2);
          }
          i1 = paramInt1;
          if (j != i3 - 1)
          {
            localLayoutParams.rightMargin = (i / 2);
            i1 = paramInt1;
          }
        }
        label1125:
        j += 1;
        paramInt1 = i1;
      }
    }
    i = 0;
    if (paramInt1 != 0)
    {
      paramInt1 = i;
      while (paramInt1 < k)
      {
        localObject = getChildAt(paramInt1);
        localLayoutParams = (LayoutParams)((View)localObject).getLayoutParams();
        if (localLayoutParams.expanded) {
          ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(localLayoutParams.cellsUsed * i12 + localLayoutParams.extraPixels, 1073741824), n);
        }
        paramInt1 += 1;
      }
    }
    if (i11 != 1073741824) {
      paramInt2 = m;
    }
    setMeasuredDimension(i2, paramInt2);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (paramLayoutParams != null) && ((paramLayoutParams instanceof LayoutParams));
  }
  
  public void dismissPopupMenus()
  {
    if (this.mPresenter != null) {
      this.mPresenter.dismissPopupMenus();
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return false;
  }
  
  protected LayoutParams generateDefaultLayoutParams()
  {
    LayoutParams localLayoutParams = new LayoutParams(-2, -2);
    localLayoutParams.gravity = 16;
    return localLayoutParams;
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams != null)
    {
      if ((paramLayoutParams instanceof LayoutParams)) {
        paramLayoutParams = new LayoutParams((LayoutParams)paramLayoutParams);
      } else {
        paramLayoutParams = new LayoutParams(paramLayoutParams);
      }
      if (paramLayoutParams.gravity <= 0) {
        paramLayoutParams.gravity = 16;
      }
      return paramLayoutParams;
    }
    return generateDefaultLayoutParams();
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public LayoutParams generateOverflowButtonLayoutParams()
  {
    LayoutParams localLayoutParams = generateDefaultLayoutParams();
    localLayoutParams.isOverflowButton = true;
    return localLayoutParams;
  }
  
  public Menu getMenu()
  {
    if (this.mMenu == null)
    {
      Object localObject = getContext();
      this.mMenu = new MenuBuilder((Context)localObject);
      this.mMenu.setCallback(new MenuBuilderCallback());
      this.mPresenter = new ActionMenuPresenter((Context)localObject);
      this.mPresenter.setReserveOverflow(true);
      ActionMenuPresenter localActionMenuPresenter = this.mPresenter;
      if (this.mActionMenuPresenterCallback != null) {
        localObject = this.mActionMenuPresenterCallback;
      } else {
        localObject = new ActionMenuPresenterCallback();
      }
      localActionMenuPresenter.setCallback((MenuPresenter.Callback)localObject);
      this.mMenu.addMenuPresenter(this.mPresenter, this.mPopupContext);
      this.mPresenter.setMenuView(this);
    }
    return this.mMenu;
  }
  
  @Nullable
  public Drawable getOverflowIcon()
  {
    getMenu();
    return this.mPresenter.getOverflowIcon();
  }
  
  public int getPopupTheme()
  {
    return this.mPopupTheme;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public int getWindowAnimations()
  {
    return 0;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected boolean hasSupportDividerBeforeChildAt(int paramInt)
  {
    boolean bool2 = false;
    if (paramInt == 0) {
      return false;
    }
    View localView1 = getChildAt(paramInt - 1);
    View localView2 = getChildAt(paramInt);
    boolean bool1 = bool2;
    if (paramInt < getChildCount())
    {
      bool1 = bool2;
      if ((localView1 instanceof ActionMenuChildView)) {
        bool1 = false | ((ActionMenuChildView)localView1).needsDividerAfter();
      }
    }
    bool2 = bool1;
    if (paramInt > 0)
    {
      bool2 = bool1;
      if ((localView2 instanceof ActionMenuChildView)) {
        bool2 = bool1 | ((ActionMenuChildView)localView2).needsDividerBefore();
      }
    }
    return bool2;
  }
  
  public boolean hideOverflowMenu()
  {
    return (this.mPresenter != null) && (this.mPresenter.hideOverflowMenu());
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void initialize(MenuBuilder paramMenuBuilder)
  {
    this.mMenu = paramMenuBuilder;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public boolean invokeItem(MenuItemImpl paramMenuItemImpl)
  {
    return this.mMenu.performItemAction(paramMenuItemImpl, 0);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public boolean isOverflowMenuShowPending()
  {
    return (this.mPresenter != null) && (this.mPresenter.isOverflowMenuShowPending());
  }
  
  public boolean isOverflowMenuShowing()
  {
    return (this.mPresenter != null) && (this.mPresenter.isOverflowMenuShowing());
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public boolean isOverflowReserved()
  {
    return this.mReserveOverflow;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.mPresenter != null)
    {
      this.mPresenter.updateMenuView(false);
      if (this.mPresenter.isOverflowMenuShowing())
      {
        this.mPresenter.hideOverflowMenu();
        this.mPresenter.showOverflowMenu();
      }
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    dismissPopupMenus();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.mFormatItems)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    int m = getChildCount();
    int k = (paramInt4 - paramInt2) / 2;
    int n = getDividerWidth();
    int i1 = paramInt3 - paramInt1;
    paramInt1 = getPaddingRight();
    paramInt2 = getPaddingLeft();
    paramBoolean = ViewUtils.isLayoutRtl(this);
    paramInt1 = i1 - paramInt1 - paramInt2;
    paramInt2 = 0;
    paramInt4 = 0;
    paramInt3 = 0;
    View localView;
    LayoutParams localLayoutParams;
    int j;
    while (paramInt2 < m)
    {
      localView = getChildAt(paramInt2);
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.isOverflowButton)
        {
          i = localView.getMeasuredWidth();
          paramInt4 = i;
          if (hasSupportDividerBeforeChildAt(paramInt2)) {
            paramInt4 = i + n;
          }
          int i2 = localView.getMeasuredHeight();
          if (paramBoolean)
          {
            j = getPaddingLeft() + localLayoutParams.leftMargin;
            i = j + paramInt4;
          }
          else
          {
            i = getWidth() - getPaddingRight() - localLayoutParams.rightMargin;
            j = i - paramInt4;
          }
          int i3 = k - i2 / 2;
          localView.layout(j, i3, i, i2 + i3);
          paramInt1 -= paramInt4;
          paramInt4 = 1;
        }
        else
        {
          paramInt1 -= localView.getMeasuredWidth() + localLayoutParams.leftMargin + localLayoutParams.rightMargin;
          hasSupportDividerBeforeChildAt(paramInt2);
          paramInt3 += 1;
        }
      }
      paramInt2 += 1;
    }
    if ((m == 1) && (paramInt4 == 0))
    {
      localView = getChildAt(0);
      paramInt1 = localView.getMeasuredWidth();
      paramInt2 = localView.getMeasuredHeight();
      paramInt3 = i1 / 2 - paramInt1 / 2;
      paramInt4 = k - paramInt2 / 2;
      localView.layout(paramInt3, paramInt4, paramInt1 + paramInt3, paramInt2 + paramInt4);
      return;
    }
    paramInt2 = paramInt3 - (paramInt4 ^ 0x1);
    if (paramInt2 > 0) {
      paramInt1 /= paramInt2;
    } else {
      paramInt1 = 0;
    }
    paramInt4 = 0;
    paramInt3 = 0;
    int i = Math.max(0, paramInt1);
    if (paramBoolean)
    {
      paramInt2 = getWidth() - getPaddingRight();
      paramInt1 = paramInt3;
      while (paramInt1 < m)
      {
        localView = getChildAt(paramInt1);
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        paramInt3 = paramInt2;
        if (localView.getVisibility() != 8) {
          if (localLayoutParams.isOverflowButton)
          {
            paramInt3 = paramInt2;
          }
          else
          {
            paramInt2 -= localLayoutParams.rightMargin;
            paramInt3 = localView.getMeasuredWidth();
            paramInt4 = localView.getMeasuredHeight();
            j = k - paramInt4 / 2;
            localView.layout(paramInt2 - paramInt3, j, paramInt2, paramInt4 + j);
            paramInt3 = paramInt2 - (paramInt3 + localLayoutParams.leftMargin + i);
          }
        }
        paramInt1 += 1;
        paramInt2 = paramInt3;
      }
    }
    paramInt2 = getPaddingLeft();
    paramInt1 = paramInt4;
    while (paramInt1 < m)
    {
      localView = getChildAt(paramInt1);
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      paramInt3 = paramInt2;
      if (localView.getVisibility() != 8) {
        if (localLayoutParams.isOverflowButton)
        {
          paramInt3 = paramInt2;
        }
        else
        {
          paramInt2 += localLayoutParams.leftMargin;
          paramInt3 = localView.getMeasuredWidth();
          paramInt4 = localView.getMeasuredHeight();
          j = k - paramInt4 / 2;
          localView.layout(paramInt2, j, paramInt2 + paramInt3, paramInt4 + j);
          paramInt3 = paramInt2 + (paramInt3 + localLayoutParams.rightMargin + i);
        }
      }
      paramInt1 += 1;
      paramInt2 = paramInt3;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    boolean bool2 = this.mFormatItems;
    boolean bool1;
    if (View.MeasureSpec.getMode(paramInt1) == 1073741824) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.mFormatItems = bool1;
    if (bool2 != this.mFormatItems) {
      this.mFormatItemsWidth = 0;
    }
    int i = View.MeasureSpec.getSize(paramInt1);
    if ((this.mFormatItems) && (this.mMenu != null) && (i != this.mFormatItemsWidth))
    {
      this.mFormatItemsWidth = i;
      this.mMenu.onItemsChanged(true);
    }
    int j = getChildCount();
    if ((this.mFormatItems) && (j > 0))
    {
      onMeasureExactFormat(paramInt1, paramInt2);
      return;
    }
    i = 0;
    while (i < j)
    {
      LayoutParams localLayoutParams = (LayoutParams)getChildAt(i).getLayoutParams();
      localLayoutParams.rightMargin = 0;
      localLayoutParams.leftMargin = 0;
      i += 1;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public MenuBuilder peekMenu()
  {
    return this.mMenu;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void setExpandedActionViewsExclusive(boolean paramBoolean)
  {
    this.mPresenter.setExpandedActionViewsExclusive(paramBoolean);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void setMenuCallbacks(MenuPresenter.Callback paramCallback, MenuBuilder.Callback paramCallback1)
  {
    this.mActionMenuPresenterCallback = paramCallback;
    this.mMenuBuilderCallback = paramCallback1;
  }
  
  public void setOnMenuItemClickListener(OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.mOnMenuItemClickListener = paramOnMenuItemClickListener;
  }
  
  public void setOverflowIcon(@Nullable Drawable paramDrawable)
  {
    getMenu();
    this.mPresenter.setOverflowIcon(paramDrawable);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void setOverflowReserved(boolean paramBoolean)
  {
    this.mReserveOverflow = paramBoolean;
  }
  
  public void setPopupTheme(@StyleRes int paramInt)
  {
    if (this.mPopupTheme != paramInt)
    {
      this.mPopupTheme = paramInt;
      if (paramInt == 0)
      {
        this.mPopupContext = getContext();
        return;
      }
      this.mPopupContext = new ContextThemeWrapper(getContext(), paramInt);
    }
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void setPresenter(ActionMenuPresenter paramActionMenuPresenter)
  {
    this.mPresenter = paramActionMenuPresenter;
    this.mPresenter.setMenuView(this);
  }
  
  public boolean showOverflowMenu()
  {
    return (this.mPresenter != null) && (this.mPresenter.showOverflowMenu());
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static abstract interface ActionMenuChildView
  {
    public abstract boolean needsDividerAfter();
    
    public abstract boolean needsDividerBefore();
  }
  
  private static class ActionMenuPresenterCallback
    implements MenuPresenter.Callback
  {
    public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {}
    
    public boolean onOpenSubMenu(MenuBuilder paramMenuBuilder)
    {
      return false;
    }
  }
  
  public static class LayoutParams
    extends LinearLayoutCompat.LayoutParams
  {
    @ViewDebug.ExportedProperty
    public int cellsUsed;
    @ViewDebug.ExportedProperty
    public boolean expandable;
    boolean expanded;
    @ViewDebug.ExportedProperty
    public int extraPixels;
    @ViewDebug.ExportedProperty
    public boolean isOverflowButton;
    @ViewDebug.ExportedProperty
    public boolean preventEdgeOffset;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      this.isOverflowButton = false;
    }
    
    LayoutParams(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      super(paramInt2);
      this.isOverflowButton = paramBoolean;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.isOverflowButton = paramLayoutParams.isOverflowButton;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
  }
  
  private class MenuBuilderCallback
    implements MenuBuilder.Callback
  {
    MenuBuilderCallback() {}
    
    public boolean onMenuItemSelected(MenuBuilder paramMenuBuilder, MenuItem paramMenuItem)
    {
      return (ActionMenuView.this.mOnMenuItemClickListener != null) && (ActionMenuView.this.mOnMenuItemClickListener.onMenuItemClick(paramMenuItem));
    }
    
    public void onMenuModeChange(MenuBuilder paramMenuBuilder)
    {
      if (ActionMenuView.this.mMenuBuilderCallback != null) {
        ActionMenuView.this.mMenuBuilderCallback.onMenuModeChange(paramMenuBuilder);
      }
    }
  }
  
  public static abstract interface OnMenuItemClickListener
  {
    public abstract boolean onMenuItemClick(MenuItem paramMenuItem);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\widget\ActionMenuView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */