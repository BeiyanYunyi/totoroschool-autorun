package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.annotation.DimenRes;
import android.support.annotation.Dimension;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.design.R.attr;
import android.support.design.R.color;
import android.support.design.R.dimen;
import android.support.design.R.style;
import android.support.design.R.styleable;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.internal.BottomNavigationPresenter;
import android.support.design.internal.ThemeEnforcement;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v7.view.SupportMenuInflater;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuBuilder.Callback;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class BottomNavigationView
  extends FrameLayout
{
  private static final int MENU_PRESENTER_ID = 1;
  private final MenuBuilder menu;
  private MenuInflater menuInflater;
  private final BottomNavigationMenuView menuView;
  private final BottomNavigationPresenter presenter = new BottomNavigationPresenter();
  private OnNavigationItemReselectedListener reselectedListener;
  private OnNavigationItemSelectedListener selectedListener;
  
  public BottomNavigationView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BottomNavigationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.bottomNavigationStyle);
  }
  
  public BottomNavigationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.menu = new BottomNavigationMenu(paramContext);
    this.menuView = new BottomNavigationMenuView(paramContext);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    this.menuView.setLayoutParams(localLayoutParams);
    this.presenter.setBottomNavigationMenuView(this.menuView);
    this.presenter.setId(1);
    this.menuView.setPresenter(this.presenter);
    this.menu.addMenuPresenter(this.presenter);
    this.presenter.initForMenu(getContext(), this.menu);
    paramAttributeSet = ThemeEnforcement.obtainTintedStyledAttributes(paramContext, paramAttributeSet, R.styleable.BottomNavigationView, paramInt, R.style.Widget_Design_BottomNavigationView, new int[] { R.styleable.BottomNavigationView_itemTextAppearanceInactive, R.styleable.BottomNavigationView_itemTextAppearanceActive });
    if (paramAttributeSet.hasValue(R.styleable.BottomNavigationView_itemIconTint)) {
      this.menuView.setIconTintList(paramAttributeSet.getColorStateList(R.styleable.BottomNavigationView_itemIconTint));
    } else {
      this.menuView.setIconTintList(this.menuView.createDefaultColorStateList(16842808));
    }
    setItemIconSize(paramAttributeSet.getDimensionPixelSize(R.styleable.BottomNavigationView_itemIconSize, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_icon_size)));
    if (paramAttributeSet.hasValue(R.styleable.BottomNavigationView_itemTextAppearanceInactive)) {
      setItemTextAppearanceInactive(paramAttributeSet.getResourceId(R.styleable.BottomNavigationView_itemTextAppearanceInactive, 0));
    }
    if (paramAttributeSet.hasValue(R.styleable.BottomNavigationView_itemTextAppearanceActive)) {
      setItemTextAppearanceActive(paramAttributeSet.getResourceId(R.styleable.BottomNavigationView_itemTextAppearanceActive, 0));
    }
    if (paramAttributeSet.hasValue(R.styleable.BottomNavigationView_itemTextColor)) {
      setItemTextColor(paramAttributeSet.getColorStateList(R.styleable.BottomNavigationView_itemTextColor));
    }
    if (paramAttributeSet.hasValue(R.styleable.BottomNavigationView_elevation)) {
      ViewCompat.setElevation(this, paramAttributeSet.getDimensionPixelSize(R.styleable.BottomNavigationView_elevation, 0));
    }
    setLabelVisibilityMode(paramAttributeSet.getInteger(R.styleable.BottomNavigationView_labelVisibilityMode, -1));
    setItemHorizontalTranslationEnabled(paramAttributeSet.getBoolean(R.styleable.BottomNavigationView_itemHorizontalTranslationEnabled, true));
    paramInt = paramAttributeSet.getResourceId(R.styleable.BottomNavigationView_itemBackground, 0);
    this.menuView.setItemBackgroundRes(paramInt);
    if (paramAttributeSet.hasValue(R.styleable.BottomNavigationView_menu)) {
      inflateMenu(paramAttributeSet.getResourceId(R.styleable.BottomNavigationView_menu, 0));
    }
    paramAttributeSet.recycle();
    addView(this.menuView, localLayoutParams);
    if (Build.VERSION.SDK_INT < 21) {
      addCompatibilityTopDivider(paramContext);
    }
    this.menu.setCallback(new MenuBuilder.Callback()
    {
      public boolean onMenuItemSelected(MenuBuilder paramAnonymousMenuBuilder, MenuItem paramAnonymousMenuItem)
      {
        if ((BottomNavigationView.this.reselectedListener != null) && (paramAnonymousMenuItem.getItemId() == BottomNavigationView.this.getSelectedItemId()))
        {
          BottomNavigationView.this.reselectedListener.onNavigationItemReselected(paramAnonymousMenuItem);
          return true;
        }
        return (BottomNavigationView.this.selectedListener != null) && (!BottomNavigationView.this.selectedListener.onNavigationItemSelected(paramAnonymousMenuItem));
      }
      
      public void onMenuModeChange(MenuBuilder paramAnonymousMenuBuilder) {}
    });
  }
  
  private void addCompatibilityTopDivider(Context paramContext)
  {
    View localView = new View(paramContext);
    localView.setBackgroundColor(ContextCompat.getColor(paramContext, R.color.design_bottom_navigation_shadow_color));
    localView.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.design_bottom_navigation_shadow_height)));
    addView(localView);
  }
  
  private MenuInflater getMenuInflater()
  {
    if (this.menuInflater == null) {
      this.menuInflater = new SupportMenuInflater(getContext());
    }
    return this.menuInflater;
  }
  
  @Nullable
  public Drawable getItemBackground()
  {
    return this.menuView.getItemBackground();
  }
  
  @Deprecated
  @DrawableRes
  public int getItemBackgroundResource()
  {
    return this.menuView.getItemBackgroundRes();
  }
  
  @Dimension
  public int getItemIconSize()
  {
    return this.menuView.getItemIconSize();
  }
  
  @Nullable
  public ColorStateList getItemIconTintList()
  {
    return this.menuView.getIconTintList();
  }
  
  @StyleRes
  public int getItemTextAppearanceActive()
  {
    return this.menuView.getItemTextAppearanceActive();
  }
  
  @StyleRes
  public int getItemTextAppearanceInactive()
  {
    return this.menuView.getItemTextAppearanceInactive();
  }
  
  @Nullable
  public ColorStateList getItemTextColor()
  {
    return this.menuView.getItemTextColor();
  }
  
  public int getLabelVisibilityMode()
  {
    return this.menuView.getLabelVisibilityMode();
  }
  
  public int getMaxItemCount()
  {
    return 5;
  }
  
  @NonNull
  public Menu getMenu()
  {
    return this.menu;
  }
  
  @IdRes
  public int getSelectedItemId()
  {
    return this.menuView.getSelectedItemId();
  }
  
  public void inflateMenu(int paramInt)
  {
    this.presenter.setUpdateSuspended(true);
    getMenuInflater().inflate(paramInt, this.menu);
    this.presenter.setUpdateSuspended(false);
    this.presenter.updateMenuView(true);
  }
  
  public boolean isItemHorizontalTranslationEnabled()
  {
    return this.menuView.isItemHorizontalTranslationEnabled();
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
    this.menu.restorePresenterStates(paramParcelable.menuPresenterState);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.menuPresenterState = new Bundle();
    this.menu.savePresenterStates(localSavedState.menuPresenterState);
    return localSavedState;
  }
  
  public void setItemBackground(@Nullable Drawable paramDrawable)
  {
    this.menuView.setItemBackground(paramDrawable);
  }
  
  public void setItemBackgroundResource(@DrawableRes int paramInt)
  {
    this.menuView.setItemBackgroundRes(paramInt);
  }
  
  public void setItemHorizontalTranslationEnabled(boolean paramBoolean)
  {
    if (this.menuView.isItemHorizontalTranslationEnabled() != paramBoolean)
    {
      this.menuView.setItemHorizontalTranslationEnabled(paramBoolean);
      this.presenter.updateMenuView(false);
    }
  }
  
  public void setItemIconSize(@Dimension int paramInt)
  {
    this.menuView.setItemIconSize(paramInt);
  }
  
  public void setItemIconSizeRes(@DimenRes int paramInt)
  {
    setItemIconSize(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setItemIconTintList(@Nullable ColorStateList paramColorStateList)
  {
    this.menuView.setIconTintList(paramColorStateList);
  }
  
  public void setItemTextAppearanceActive(@StyleRes int paramInt)
  {
    this.menuView.setItemTextAppearanceActive(paramInt);
  }
  
  public void setItemTextAppearanceInactive(@StyleRes int paramInt)
  {
    this.menuView.setItemTextAppearanceInactive(paramInt);
  }
  
  public void setItemTextColor(@Nullable ColorStateList paramColorStateList)
  {
    this.menuView.setItemTextColor(paramColorStateList);
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    if (this.menuView.getLabelVisibilityMode() != paramInt)
    {
      this.menuView.setLabelVisibilityMode(paramInt);
      this.presenter.updateMenuView(false);
    }
  }
  
  public void setOnNavigationItemReselectedListener(@Nullable OnNavigationItemReselectedListener paramOnNavigationItemReselectedListener)
  {
    this.reselectedListener = paramOnNavigationItemReselectedListener;
  }
  
  public void setOnNavigationItemSelectedListener(@Nullable OnNavigationItemSelectedListener paramOnNavigationItemSelectedListener)
  {
    this.selectedListener = paramOnNavigationItemSelectedListener;
  }
  
  public void setSelectedItemId(@IdRes int paramInt)
  {
    MenuItem localMenuItem = this.menu.findItem(paramInt);
    if ((localMenuItem != null) && (!this.menu.performItemAction(localMenuItem, this.presenter, 0))) {
      localMenuItem.setChecked(true);
    }
  }
  
  public static abstract interface OnNavigationItemReselectedListener
  {
    public abstract void onNavigationItemReselected(@NonNull MenuItem paramMenuItem);
  }
  
  public static abstract interface OnNavigationItemSelectedListener
  {
    public abstract boolean onNavigationItemSelected(@NonNull MenuItem paramMenuItem);
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
    {
      public BottomNavigationView.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new BottomNavigationView.SavedState(paramAnonymousParcel, null);
      }
      
      public BottomNavigationView.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new BottomNavigationView.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }
      
      public BottomNavigationView.SavedState[] newArray(int paramAnonymousInt)
      {
        return new BottomNavigationView.SavedState[paramAnonymousInt];
      }
    };
    Bundle menuPresenterState;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      readFromParcel(paramParcel, paramClassLoader);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    private void readFromParcel(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      this.menuPresenterState = paramParcel.readBundle(paramClassLoader);
    }
    
    public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeBundle(this.menuPresenterState);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\widget\BottomNavigationView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */