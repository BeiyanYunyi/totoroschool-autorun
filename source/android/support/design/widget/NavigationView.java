package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.annotation.DimenRes;
import android.support.annotation.Dimension;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.StyleRes;
import android.support.design.R.style;
import android.support.design.R.styleable;
import android.support.design.internal.NavigationMenu;
import android.support.design.internal.NavigationMenuPresenter;
import android.support.design.internal.ScrimInsetsFrameLayout;
import android.support.design.internal.ThemeEnforcement;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;

public class NavigationView
  extends ScrimInsetsFrameLayout
{
  private static final int[] CHECKED_STATE_SET = { 16842912 };
  private static final int[] DISABLED_STATE_SET = { -16842910 };
  private static final int PRESENTER_NAVIGATION_VIEW_ID = 1;
  OnNavigationItemSelectedListener listener;
  private final int maxWidth;
  private final NavigationMenu menu;
  private MenuInflater menuInflater;
  private final NavigationMenuPresenter presenter = new NavigationMenuPresenter();
  
  public NavigationView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NavigationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, android.support.design.R.attr.navigationViewStyle);
  }
  
  public NavigationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.menu = new NavigationMenu(paramContext);
    TintTypedArray localTintTypedArray = ThemeEnforcement.obtainTintedStyledAttributes(paramContext, paramAttributeSet, R.styleable.NavigationView, paramInt, R.style.Widget_Design_NavigationView, new int[0]);
    ViewCompat.setBackground(this, localTintTypedArray.getDrawable(R.styleable.NavigationView_android_background));
    if (localTintTypedArray.hasValue(R.styleable.NavigationView_elevation)) {
      ViewCompat.setElevation(this, localTintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_elevation, 0));
    }
    ViewCompat.setFitsSystemWindows(this, localTintTypedArray.getBoolean(R.styleable.NavigationView_android_fitsSystemWindows, false));
    this.maxWidth = localTintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_android_maxWidth, 0);
    ColorStateList localColorStateList;
    if (localTintTypedArray.hasValue(R.styleable.NavigationView_itemIconTint)) {
      localColorStateList = localTintTypedArray.getColorStateList(R.styleable.NavigationView_itemIconTint);
    } else {
      localColorStateList = createDefaultColorStateList(16842808);
    }
    int i;
    if (localTintTypedArray.hasValue(R.styleable.NavigationView_itemTextAppearance))
    {
      i = localTintTypedArray.getResourceId(R.styleable.NavigationView_itemTextAppearance, 0);
      paramInt = 1;
    }
    else
    {
      paramInt = 0;
      i = 0;
    }
    paramAttributeSet = null;
    if (localTintTypedArray.hasValue(R.styleable.NavigationView_itemTextColor)) {
      paramAttributeSet = localTintTypedArray.getColorStateList(R.styleable.NavigationView_itemTextColor);
    }
    Object localObject = paramAttributeSet;
    if (paramInt == 0)
    {
      localObject = paramAttributeSet;
      if (paramAttributeSet == null) {
        localObject = createDefaultColorStateList(16842806);
      }
    }
    paramAttributeSet = localTintTypedArray.getDrawable(R.styleable.NavigationView_itemBackground);
    if (localTintTypedArray.hasValue(R.styleable.NavigationView_itemHorizontalPadding))
    {
      j = localTintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemHorizontalPadding, 0);
      this.presenter.setItemHorizontalPadding(j);
    }
    int j = localTintTypedArray.getDimensionPixelSize(R.styleable.NavigationView_itemIconPadding, 0);
    this.menu.setCallback(new MenuBuilder.Callback()
    {
      public boolean onMenuItemSelected(MenuBuilder paramAnonymousMenuBuilder, MenuItem paramAnonymousMenuItem)
      {
        return (NavigationView.this.listener != null) && (NavigationView.this.listener.onNavigationItemSelected(paramAnonymousMenuItem));
      }
      
      public void onMenuModeChange(MenuBuilder paramAnonymousMenuBuilder) {}
    });
    this.presenter.setId(1);
    this.presenter.initForMenu(paramContext, this.menu);
    this.presenter.setItemIconTintList(localColorStateList);
    if (paramInt != 0) {
      this.presenter.setItemTextAppearance(i);
    }
    this.presenter.setItemTextColor((ColorStateList)localObject);
    this.presenter.setItemBackground(paramAttributeSet);
    this.presenter.setItemIconPadding(j);
    this.menu.addMenuPresenter(this.presenter);
    addView((View)this.presenter.getMenuView(this));
    if (localTintTypedArray.hasValue(R.styleable.NavigationView_menu)) {
      inflateMenu(localTintTypedArray.getResourceId(R.styleable.NavigationView_menu, 0));
    }
    if (localTintTypedArray.hasValue(R.styleable.NavigationView_headerLayout)) {
      inflateHeaderView(localTintTypedArray.getResourceId(R.styleable.NavigationView_headerLayout, 0));
    }
    localTintTypedArray.recycle();
  }
  
  private ColorStateList createDefaultColorStateList(int paramInt)
  {
    Object localObject = new TypedValue();
    if (!getContext().getTheme().resolveAttribute(paramInt, (TypedValue)localObject, true)) {
      return null;
    }
    ColorStateList localColorStateList = AppCompatResources.getColorStateList(getContext(), ((TypedValue)localObject).resourceId);
    if (!getContext().getTheme().resolveAttribute(android.support.v7.appcompat.R.attr.colorPrimary, (TypedValue)localObject, true)) {
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
  
  private MenuInflater getMenuInflater()
  {
    if (this.menuInflater == null) {
      this.menuInflater = new SupportMenuInflater(getContext());
    }
    return this.menuInflater;
  }
  
  public void addHeaderView(@NonNull View paramView)
  {
    this.presenter.addHeaderView(paramView);
  }
  
  @Nullable
  public MenuItem getCheckedItem()
  {
    return this.presenter.getCheckedItem();
  }
  
  public int getHeaderCount()
  {
    return this.presenter.getHeaderCount();
  }
  
  public View getHeaderView(int paramInt)
  {
    return this.presenter.getHeaderView(paramInt);
  }
  
  @Nullable
  public Drawable getItemBackground()
  {
    return this.presenter.getItemBackground();
  }
  
  @Dimension
  public int getItemHorizontalPadding()
  {
    return this.presenter.getItemHorizontalPadding();
  }
  
  @Dimension
  public int getItemIconPadding()
  {
    return this.presenter.getItemIconPadding();
  }
  
  @Nullable
  public ColorStateList getItemIconTintList()
  {
    return this.presenter.getItemTintList();
  }
  
  @Nullable
  public ColorStateList getItemTextColor()
  {
    return this.presenter.getItemTextColor();
  }
  
  public Menu getMenu()
  {
    return this.menu;
  }
  
  public View inflateHeaderView(@LayoutRes int paramInt)
  {
    return this.presenter.inflateHeaderView(paramInt);
  }
  
  public void inflateMenu(int paramInt)
  {
    this.presenter.setUpdateSuspended(true);
    getMenuInflater().inflate(paramInt, this.menu);
    this.presenter.setUpdateSuspended(false);
    this.presenter.updateMenuView(false);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected void onInsetsChanged(WindowInsetsCompat paramWindowInsetsCompat)
  {
    this.presenter.dispatchApplyWindowInsets(paramWindowInsetsCompat);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt1);
    if (i != Integer.MIN_VALUE)
    {
      if (i == 0) {
        paramInt1 = View.MeasureSpec.makeMeasureSpec(this.maxWidth, 1073741824);
      }
    }
    else {
      paramInt1 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(paramInt1), this.maxWidth), 1073741824);
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.menu.restorePresenterStates(paramParcelable.menuState);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.menuState = new Bundle();
    this.menu.savePresenterStates(localSavedState.menuState);
    return localSavedState;
  }
  
  public void removeHeaderView(@NonNull View paramView)
  {
    this.presenter.removeHeaderView(paramView);
  }
  
  public void setCheckedItem(@IdRes int paramInt)
  {
    MenuItem localMenuItem = this.menu.findItem(paramInt);
    if (localMenuItem != null) {
      this.presenter.setCheckedItem((MenuItemImpl)localMenuItem);
    }
  }
  
  public void setCheckedItem(@NonNull MenuItem paramMenuItem)
  {
    paramMenuItem = this.menu.findItem(paramMenuItem.getItemId());
    if (paramMenuItem != null)
    {
      this.presenter.setCheckedItem((MenuItemImpl)paramMenuItem);
      return;
    }
    throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
  }
  
  public void setItemBackground(@Nullable Drawable paramDrawable)
  {
    this.presenter.setItemBackground(paramDrawable);
  }
  
  public void setItemBackgroundResource(@DrawableRes int paramInt)
  {
    setItemBackground(ContextCompat.getDrawable(getContext(), paramInt));
  }
  
  public void setItemHorizontalPadding(@Dimension int paramInt)
  {
    this.presenter.setItemHorizontalPadding(paramInt);
  }
  
  public void setItemHorizontalPaddingResource(@DimenRes int paramInt)
  {
    this.presenter.setItemHorizontalPadding(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setItemIconPadding(@Dimension int paramInt)
  {
    this.presenter.setItemIconPadding(paramInt);
  }
  
  public void setItemIconPaddingResource(int paramInt)
  {
    this.presenter.setItemIconPadding(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setItemIconTintList(@Nullable ColorStateList paramColorStateList)
  {
    this.presenter.setItemIconTintList(paramColorStateList);
  }
  
  public void setItemTextAppearance(@StyleRes int paramInt)
  {
    this.presenter.setItemTextAppearance(paramInt);
  }
  
  public void setItemTextColor(@Nullable ColorStateList paramColorStateList)
  {
    this.presenter.setItemTextColor(paramColorStateList);
  }
  
  public void setNavigationItemSelectedListener(@Nullable OnNavigationItemSelectedListener paramOnNavigationItemSelectedListener)
  {
    this.listener = paramOnNavigationItemSelectedListener;
  }
  
  public static abstract interface OnNavigationItemSelectedListener
  {
    public abstract boolean onNavigationItemSelected(@NonNull MenuItem paramMenuItem);
  }
  
  public static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
    {
      public NavigationView.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new NavigationView.SavedState(paramAnonymousParcel, null);
      }
      
      public NavigationView.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new NavigationView.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }
      
      public NavigationView.SavedState[] newArray(int paramAnonymousInt)
      {
        return new NavigationView.SavedState[paramAnonymousInt];
      }
    };
    public Bundle menuState;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.menuState = paramParcel.readBundle(paramClassLoader);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeBundle(this.menuState);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\widget\NavigationView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */