package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.support.annotation.Dimension;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.StyleRes;
import android.support.design.R.dimen;
import android.support.transition.AutoTransition;
import android.support.transition.TransitionManager;
import android.support.transition.TransitionSet;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SynchronizedPool;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.appcompat.R.attr;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import java.util.ArrayList;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class BottomNavigationMenuView
  extends ViewGroup
  implements MenuView
{
  private static final long ACTIVE_ANIMATION_DURATION_MS = 115L;
  private static final int[] CHECKED_STATE_SET = { 16842912 };
  private static final int[] DISABLED_STATE_SET = { -16842910 };
  private final int activeItemMaxWidth;
  private final int activeItemMinWidth;
  private BottomNavigationItemView[] buttons;
  private final int inactiveItemMaxWidth;
  private final int inactiveItemMinWidth;
  private Drawable itemBackground;
  private int itemBackgroundRes;
  private final int itemHeight;
  private boolean itemHorizontalTranslationEnabled;
  @Dimension
  private int itemIconSize;
  private ColorStateList itemIconTint;
  private final Pools.Pool<BottomNavigationItemView> itemPool = new Pools.SynchronizedPool(5);
  @StyleRes
  private int itemTextAppearanceActive;
  @StyleRes
  private int itemTextAppearanceInactive;
  private final ColorStateList itemTextColorDefault;
  private ColorStateList itemTextColorFromUser;
  private int labelVisibilityMode;
  private MenuBuilder menu;
  private final View.OnClickListener onClickListener;
  private BottomNavigationPresenter presenter;
  private int selectedItemId = 0;
  private int selectedItemPosition = 0;
  private final TransitionSet set;
  private int[] tempChildWidths;
  
  public BottomNavigationMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BottomNavigationMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = getResources();
    this.inactiveItemMaxWidth = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
    this.inactiveItemMinWidth = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
    this.activeItemMaxWidth = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
    this.activeItemMinWidth = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
    this.itemHeight = paramContext.getDimensionPixelSize(R.dimen.design_bottom_navigation_height);
    this.itemTextColorDefault = createDefaultColorStateList(16842808);
    this.set = new AutoTransition();
    this.set.setOrdering(0);
    this.set.setDuration(115L);
    this.set.setInterpolator(new FastOutSlowInInterpolator());
    this.set.addTransition(new TextScale());
    this.onClickListener = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramAnonymousView = ((BottomNavigationItemView)paramAnonymousView).getItemData();
        if (!BottomNavigationMenuView.this.menu.performItemAction(paramAnonymousView, BottomNavigationMenuView.this.presenter, 0)) {
          paramAnonymousView.setChecked(true);
        }
      }
    };
    this.tempChildWidths = new int[5];
  }
  
  private BottomNavigationItemView getNewItem()
  {
    BottomNavigationItemView localBottomNavigationItemView2 = (BottomNavigationItemView)this.itemPool.acquire();
    BottomNavigationItemView localBottomNavigationItemView1 = localBottomNavigationItemView2;
    if (localBottomNavigationItemView2 == null) {
      localBottomNavigationItemView1 = new BottomNavigationItemView(getContext());
    }
    return localBottomNavigationItemView1;
  }
  
  private boolean isShifting(int paramInt1, int paramInt2)
  {
    if (paramInt1 == -1)
    {
      if (paramInt2 <= 3) {}
    }
    else {
      while (paramInt1 == 0) {
        return true;
      }
    }
    return false;
  }
  
  public void buildMenuView()
  {
    removeAllViews();
    Object localObject1;
    if (this.buttons != null)
    {
      localObject1 = this.buttons;
      int j = localObject1.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (localObject2 != null) {
          this.itemPool.release(localObject2);
        }
        i += 1;
      }
    }
    if (this.menu.size() == 0)
    {
      this.selectedItemId = 0;
      this.selectedItemPosition = 0;
      this.buttons = null;
      return;
    }
    this.buttons = new BottomNavigationItemView[this.menu.size()];
    boolean bool = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
    int i = 0;
    while (i < this.menu.size())
    {
      this.presenter.setUpdateSuspended(true);
      this.menu.getItem(i).setCheckable(true);
      this.presenter.setUpdateSuspended(false);
      localObject1 = getNewItem();
      this.buttons[i] = localObject1;
      ((BottomNavigationItemView)localObject1).setIconTintList(this.itemIconTint);
      ((BottomNavigationItemView)localObject1).setIconSize(this.itemIconSize);
      ((BottomNavigationItemView)localObject1).setTextColor(this.itemTextColorDefault);
      ((BottomNavigationItemView)localObject1).setTextAppearanceInactive(this.itemTextAppearanceInactive);
      ((BottomNavigationItemView)localObject1).setTextAppearanceActive(this.itemTextAppearanceActive);
      ((BottomNavigationItemView)localObject1).setTextColor(this.itemTextColorFromUser);
      if (this.itemBackground != null) {
        ((BottomNavigationItemView)localObject1).setItemBackground(this.itemBackground);
      } else {
        ((BottomNavigationItemView)localObject1).setItemBackground(this.itemBackgroundRes);
      }
      ((BottomNavigationItemView)localObject1).setShifting(bool);
      ((BottomNavigationItemView)localObject1).setLabelVisibilityMode(this.labelVisibilityMode);
      ((BottomNavigationItemView)localObject1).initialize((MenuItemImpl)this.menu.getItem(i), 0);
      ((BottomNavigationItemView)localObject1).setItemPosition(i);
      ((BottomNavigationItemView)localObject1).setOnClickListener(this.onClickListener);
      addView((View)localObject1);
      i += 1;
    }
    this.selectedItemPosition = Math.min(this.menu.size() - 1, this.selectedItemPosition);
    this.menu.getItem(this.selectedItemPosition).setChecked(true);
  }
  
  public ColorStateList createDefaultColorStateList(int paramInt)
  {
    Object localObject = new TypedValue();
    if (!getContext().getTheme().resolveAttribute(paramInt, (TypedValue)localObject, true)) {
      return null;
    }
    ColorStateList localColorStateList = AppCompatResources.getColorStateList(getContext(), ((TypedValue)localObject).resourceId);
    if (!getContext().getTheme().resolveAttribute(R.attr.colorPrimary, (TypedValue)localObject, true)) {
      return null;
    }
    paramInt = ((TypedValue)localObject).data;
    int i = localColorStateList.getDefaultColor();
    localObject = DISABLED_STATE_SET;
    int[] arrayOfInt1 = CHECKED_STATE_SET;
    int[] arrayOfInt2 = EMPTY_STATE_SET;
    int j = localColorStateList.getColorForState(DISABLED_STATE_SET, i);
    return new ColorStateList(new int[][] { localObject, arrayOfInt1, arrayOfInt2 }, new int[] { j, paramInt, i });
  }
  
  @Nullable
  public ColorStateList getIconTintList()
  {
    return this.itemIconTint;
  }
  
  @Nullable
  public Drawable getItemBackground()
  {
    if ((this.buttons != null) && (this.buttons.length > 0)) {
      return this.buttons[0].getBackground();
    }
    return this.itemBackground;
  }
  
  @Deprecated
  public int getItemBackgroundRes()
  {
    return this.itemBackgroundRes;
  }
  
  @Dimension
  public int getItemIconSize()
  {
    return this.itemIconSize;
  }
  
  @StyleRes
  public int getItemTextAppearanceActive()
  {
    return this.itemTextAppearanceActive;
  }
  
  @StyleRes
  public int getItemTextAppearanceInactive()
  {
    return this.itemTextAppearanceInactive;
  }
  
  public ColorStateList getItemTextColor()
  {
    return this.itemTextColorFromUser;
  }
  
  public int getLabelVisibilityMode()
  {
    return this.labelVisibilityMode;
  }
  
  public int getSelectedItemId()
  {
    return this.selectedItemId;
  }
  
  public int getWindowAnimations()
  {
    return 0;
  }
  
  public void initialize(MenuBuilder paramMenuBuilder)
  {
    this.menu = paramMenuBuilder;
  }
  
  public boolean isItemHorizontalTranslationEnabled()
  {
    return this.itemHorizontalTranslationEnabled;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getChildCount();
    int j = paramInt4 - paramInt2;
    paramInt2 = 0;
    paramInt4 = 0;
    while (paramInt2 < i)
    {
      View localView = getChildAt(paramInt2);
      if (localView.getVisibility() != 8)
      {
        if (ViewCompat.getLayoutDirection(this) == 1)
        {
          int k = paramInt3 - paramInt1 - paramInt4;
          localView.layout(k - localView.getMeasuredWidth(), 0, k, j);
        }
        else
        {
          localView.layout(paramInt4, 0, localView.getMeasuredWidth() + paramInt4, j);
        }
        paramInt4 += localView.getMeasuredWidth();
      }
      paramInt2 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = View.MeasureSpec.getSize(paramInt1);
    int i = this.menu.getVisibleItems().size();
    int m = getChildCount();
    int n = View.MeasureSpec.makeMeasureSpec(this.itemHeight, 1073741824);
    Object localObject;
    int j;
    if ((isShifting(this.labelVisibilityMode, i)) && (this.itemHorizontalTranslationEnabled))
    {
      localObject = getChildAt(this.selectedItemPosition);
      paramInt2 = this.activeItemMinWidth;
      paramInt1 = paramInt2;
      if (((View)localObject).getVisibility() != 8)
      {
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(this.activeItemMaxWidth, Integer.MIN_VALUE), n);
        paramInt1 = Math.max(paramInt2, ((View)localObject).getMeasuredWidth());
      }
      if (((View)localObject).getVisibility() != 8) {
        paramInt2 = 1;
      } else {
        paramInt2 = 0;
      }
      paramInt2 = i - paramInt2;
      j = Math.min(k - this.inactiveItemMinWidth * paramInt2, Math.min(paramInt1, this.activeItemMaxWidth));
      i = k - j;
      if (paramInt2 == 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = paramInt2;
      }
      k = Math.min(i / paramInt1, this.inactiveItemMaxWidth);
      paramInt2 = i - paramInt2 * k;
      paramInt1 = 0;
    }
    while (paramInt1 < m)
    {
      if (getChildAt(paramInt1).getVisibility() != 8)
      {
        localObject = this.tempChildWidths;
        if (paramInt1 == this.selectedItemPosition) {
          i = j;
        } else {
          i = k;
        }
        localObject[paramInt1] = i;
        i = paramInt2;
        if (paramInt2 > 0)
        {
          localObject = this.tempChildWidths;
          localObject[paramInt1] += 1;
          i = paramInt2 - 1;
        }
      }
      else
      {
        this.tempChildWidths[paramInt1] = 0;
        i = paramInt2;
      }
      paramInt1 += 1;
      paramInt2 = i;
      continue;
      if (i == 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = i;
      }
      j = Math.min(k / paramInt1, this.activeItemMaxWidth);
      paramInt2 = k - i * j;
      paramInt1 = 0;
      while (paramInt1 < m)
      {
        if (getChildAt(paramInt1).getVisibility() != 8)
        {
          this.tempChildWidths[paramInt1] = j;
          i = paramInt2;
          if (paramInt2 > 0)
          {
            localObject = this.tempChildWidths;
            localObject[paramInt1] += 1;
            i = paramInt2 - 1;
          }
        }
        else
        {
          this.tempChildWidths[paramInt1] = 0;
          i = paramInt2;
        }
        paramInt1 += 1;
        paramInt2 = i;
      }
    }
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt1 < m)
    {
      localObject = getChildAt(paramInt1);
      if (((View)localObject).getVisibility() != 8)
      {
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(this.tempChildWidths[paramInt1], 1073741824), n);
        ((View)localObject).getLayoutParams().width = ((View)localObject).getMeasuredWidth();
        paramInt2 += ((View)localObject).getMeasuredWidth();
      }
      paramInt1 += 1;
    }
    setMeasuredDimension(View.resolveSizeAndState(paramInt2, View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824), 0), View.resolveSizeAndState(this.itemHeight, n, 0));
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    this.itemIconTint = paramColorStateList;
    if (this.buttons != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.buttons;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setIconTintList(paramColorStateList);
        i += 1;
      }
    }
  }
  
  public void setItemBackground(@Nullable Drawable paramDrawable)
  {
    this.itemBackground = paramDrawable;
    if (this.buttons != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.buttons;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setItemBackground(paramDrawable);
        i += 1;
      }
    }
  }
  
  public void setItemBackgroundRes(int paramInt)
  {
    this.itemBackgroundRes = paramInt;
    if (this.buttons != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.buttons;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setItemBackground(paramInt);
        i += 1;
      }
    }
  }
  
  public void setItemHorizontalTranslationEnabled(boolean paramBoolean)
  {
    this.itemHorizontalTranslationEnabled = paramBoolean;
  }
  
  public void setItemIconSize(@Dimension int paramInt)
  {
    this.itemIconSize = paramInt;
    if (this.buttons != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.buttons;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setIconSize(paramInt);
        i += 1;
      }
    }
  }
  
  public void setItemTextAppearanceActive(@StyleRes int paramInt)
  {
    this.itemTextAppearanceActive = paramInt;
    if (this.buttons != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.buttons;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        BottomNavigationItemView localBottomNavigationItemView = arrayOfBottomNavigationItemView[i];
        localBottomNavigationItemView.setTextAppearanceActive(paramInt);
        if (this.itemTextColorFromUser != null) {
          localBottomNavigationItemView.setTextColor(this.itemTextColorFromUser);
        }
        i += 1;
      }
    }
  }
  
  public void setItemTextAppearanceInactive(@StyleRes int paramInt)
  {
    this.itemTextAppearanceInactive = paramInt;
    if (this.buttons != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.buttons;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        BottomNavigationItemView localBottomNavigationItemView = arrayOfBottomNavigationItemView[i];
        localBottomNavigationItemView.setTextAppearanceInactive(paramInt);
        if (this.itemTextColorFromUser != null) {
          localBottomNavigationItemView.setTextColor(this.itemTextColorFromUser);
        }
        i += 1;
      }
    }
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    this.itemTextColorFromUser = paramColorStateList;
    if (this.buttons != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.buttons;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setTextColor(paramColorStateList);
        i += 1;
      }
    }
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    this.labelVisibilityMode = paramInt;
  }
  
  public void setPresenter(BottomNavigationPresenter paramBottomNavigationPresenter)
  {
    this.presenter = paramBottomNavigationPresenter;
  }
  
  void tryRestoreSelectedItemId(int paramInt)
  {
    int j = this.menu.size();
    int i = 0;
    while (i < j)
    {
      MenuItem localMenuItem = this.menu.getItem(i);
      if (paramInt == localMenuItem.getItemId())
      {
        this.selectedItemId = paramInt;
        this.selectedItemPosition = i;
        localMenuItem.setChecked(true);
        return;
      }
      i += 1;
    }
  }
  
  public void updateMenuView()
  {
    if (this.menu != null)
    {
      if (this.buttons == null) {
        return;
      }
      int j = this.menu.size();
      if (j != this.buttons.length)
      {
        buildMenuView();
        return;
      }
      int k = this.selectedItemId;
      int i = 0;
      while (i < j)
      {
        MenuItem localMenuItem = this.menu.getItem(i);
        if (localMenuItem.isChecked())
        {
          this.selectedItemId = localMenuItem.getItemId();
          this.selectedItemPosition = i;
        }
        i += 1;
      }
      if (k != this.selectedItemId) {
        TransitionManager.beginDelayedTransition(this, this.set);
      }
      boolean bool = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
      i = 0;
      while (i < j)
      {
        this.presenter.setUpdateSuspended(true);
        this.buttons[i].setLabelVisibilityMode(this.labelVisibilityMode);
        this.buttons[i].setShifting(bool);
        this.buttons[i].initialize((MenuItemImpl)this.menu.getItem(i), 0);
        this.presenter.setUpdateSuspended(false);
        i += 1;
      }
      return;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\internal\BottomNavigationMenuView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */