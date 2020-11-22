package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.StyleRes;
import android.support.design.R.dimen;
import android.support.design.R.layout;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.SubMenuBuilder;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationMenuPresenter
  implements MenuPresenter
{
  private static final String STATE_ADAPTER = "android:menu:adapter";
  private static final String STATE_HEADER = "android:menu:header";
  private static final String STATE_HIERARCHY = "android:menu:list";
  NavigationMenuAdapter adapter;
  private MenuPresenter.Callback callback;
  LinearLayout headerLayout;
  ColorStateList iconTintList;
  private int id;
  Drawable itemBackground;
  int itemHorizontalPadding;
  int itemIconPadding;
  LayoutInflater layoutInflater;
  MenuBuilder menu;
  private NavigationMenuView menuView;
  final View.OnClickListener onClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      paramAnonymousView = (NavigationMenuItemView)paramAnonymousView;
      NavigationMenuPresenter.this.setUpdateSuspended(true);
      paramAnonymousView = paramAnonymousView.getItemData();
      boolean bool = NavigationMenuPresenter.this.menu.performItemAction(paramAnonymousView, NavigationMenuPresenter.this, 0);
      if ((paramAnonymousView != null) && (paramAnonymousView.isCheckable()) && (bool)) {
        NavigationMenuPresenter.this.adapter.setCheckedItem(paramAnonymousView);
      }
      NavigationMenuPresenter.this.setUpdateSuspended(false);
      NavigationMenuPresenter.this.updateMenuView(false);
    }
  };
  int paddingSeparator;
  private int paddingTopDefault;
  int textAppearance;
  boolean textAppearanceSet;
  ColorStateList textColor;
  
  public void addHeaderView(@NonNull View paramView)
  {
    this.headerLayout.addView(paramView);
    this.menuView.setPadding(0, 0, 0, this.menuView.getPaddingBottom());
  }
  
  public boolean collapseItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public void dispatchApplyWindowInsets(WindowInsetsCompat paramWindowInsetsCompat)
  {
    int i = paramWindowInsetsCompat.getSystemWindowInsetTop();
    if (this.paddingTopDefault != i)
    {
      this.paddingTopDefault = i;
      if (this.headerLayout.getChildCount() == 0) {
        this.menuView.setPadding(0, this.paddingTopDefault, 0, this.menuView.getPaddingBottom());
      }
    }
    ViewCompat.dispatchApplyWindowInsets(this.headerLayout, paramWindowInsetsCompat);
  }
  
  public boolean expandItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public boolean flagActionItems()
  {
    return false;
  }
  
  @Nullable
  public MenuItemImpl getCheckedItem()
  {
    return this.adapter.getCheckedItem();
  }
  
  public int getHeaderCount()
  {
    return this.headerLayout.getChildCount();
  }
  
  public View getHeaderView(int paramInt)
  {
    return this.headerLayout.getChildAt(paramInt);
  }
  
  public int getId()
  {
    return this.id;
  }
  
  @Nullable
  public Drawable getItemBackground()
  {
    return this.itemBackground;
  }
  
  public int getItemHorizontalPadding()
  {
    return this.itemHorizontalPadding;
  }
  
  public int getItemIconPadding()
  {
    return this.itemIconPadding;
  }
  
  @Nullable
  public ColorStateList getItemTextColor()
  {
    return this.textColor;
  }
  
  @Nullable
  public ColorStateList getItemTintList()
  {
    return this.iconTintList;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup)
  {
    if (this.menuView == null)
    {
      this.menuView = ((NavigationMenuView)this.layoutInflater.inflate(R.layout.design_navigation_menu, paramViewGroup, false));
      if (this.adapter == null) {
        this.adapter = new NavigationMenuAdapter();
      }
      this.headerLayout = ((LinearLayout)this.layoutInflater.inflate(R.layout.design_navigation_item_header, this.menuView, false));
      this.menuView.setAdapter(this.adapter);
    }
    return this.menuView;
  }
  
  public View inflateHeaderView(@LayoutRes int paramInt)
  {
    View localView = this.layoutInflater.inflate(paramInt, this.headerLayout, false);
    addHeaderView(localView);
    return localView;
  }
  
  public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder)
  {
    this.layoutInflater = LayoutInflater.from(paramContext);
    this.menu = paramMenuBuilder;
    this.paddingSeparator = paramContext.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean)
  {
    if (this.callback != null) {
      this.callback.onCloseMenu(paramMenuBuilder, paramBoolean);
    }
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      paramParcelable = (Bundle)paramParcelable;
      Object localObject = paramParcelable.getSparseParcelableArray("android:menu:list");
      if (localObject != null) {
        this.menuView.restoreHierarchyState((SparseArray)localObject);
      }
      localObject = paramParcelable.getBundle("android:menu:adapter");
      if (localObject != null) {
        this.adapter.restoreInstanceState((Bundle)localObject);
      }
      paramParcelable = paramParcelable.getSparseParcelableArray("android:menu:header");
      if (paramParcelable != null) {
        this.headerLayout.restoreHierarchyState(paramParcelable);
      }
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    SparseArray localSparseArray;
    if (this.menuView != null)
    {
      localSparseArray = new SparseArray();
      this.menuView.saveHierarchyState(localSparseArray);
      localBundle.putSparseParcelableArray("android:menu:list", localSparseArray);
    }
    if (this.adapter != null) {
      localBundle.putBundle("android:menu:adapter", this.adapter.createInstanceState());
    }
    if (this.headerLayout != null)
    {
      localSparseArray = new SparseArray();
      this.headerLayout.saveHierarchyState(localSparseArray);
      localBundle.putSparseParcelableArray("android:menu:header", localSparseArray);
    }
    return localBundle;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    return false;
  }
  
  public void removeHeaderView(@NonNull View paramView)
  {
    this.headerLayout.removeView(paramView);
    if (this.headerLayout.getChildCount() == 0) {
      this.menuView.setPadding(0, this.paddingTopDefault, 0, this.menuView.getPaddingBottom());
    }
  }
  
  public void setCallback(MenuPresenter.Callback paramCallback)
  {
    this.callback = paramCallback;
  }
  
  public void setCheckedItem(@NonNull MenuItemImpl paramMenuItemImpl)
  {
    this.adapter.setCheckedItem(paramMenuItemImpl);
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setItemBackground(@Nullable Drawable paramDrawable)
  {
    this.itemBackground = paramDrawable;
    updateMenuView(false);
  }
  
  public void setItemHorizontalPadding(int paramInt)
  {
    this.itemHorizontalPadding = paramInt;
    updateMenuView(false);
  }
  
  public void setItemIconPadding(int paramInt)
  {
    this.itemIconPadding = paramInt;
    updateMenuView(false);
  }
  
  public void setItemIconTintList(@Nullable ColorStateList paramColorStateList)
  {
    this.iconTintList = paramColorStateList;
    updateMenuView(false);
  }
  
  public void setItemTextAppearance(@StyleRes int paramInt)
  {
    this.textAppearance = paramInt;
    this.textAppearanceSet = true;
    updateMenuView(false);
  }
  
  public void setItemTextColor(@Nullable ColorStateList paramColorStateList)
  {
    this.textColor = paramColorStateList;
    updateMenuView(false);
  }
  
  public void setUpdateSuspended(boolean paramBoolean)
  {
    if (this.adapter != null) {
      this.adapter.setUpdateSuspended(paramBoolean);
    }
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    if (this.adapter != null) {
      this.adapter.update();
    }
  }
  
  private static class HeaderViewHolder
    extends NavigationMenuPresenter.ViewHolder
  {
    public HeaderViewHolder(View paramView)
    {
      super();
    }
  }
  
  private class NavigationMenuAdapter
    extends RecyclerView.Adapter<NavigationMenuPresenter.ViewHolder>
  {
    private static final String STATE_ACTION_VIEWS = "android:menu:action_views";
    private static final String STATE_CHECKED_ITEM = "android:menu:checked";
    private static final int VIEW_TYPE_HEADER = 3;
    private static final int VIEW_TYPE_NORMAL = 0;
    private static final int VIEW_TYPE_SEPARATOR = 2;
    private static final int VIEW_TYPE_SUBHEADER = 1;
    private MenuItemImpl checkedItem;
    private final ArrayList<NavigationMenuPresenter.NavigationMenuItem> items = new ArrayList();
    private boolean updateSuspended;
    
    NavigationMenuAdapter()
    {
      prepareMenuItems();
    }
    
    private void appendTransparentIconIfMissing(int paramInt1, int paramInt2)
    {
      while (paramInt1 < paramInt2)
      {
        ((NavigationMenuPresenter.NavigationMenuTextItem)this.items.get(paramInt1)).needsEmptyIcon = true;
        paramInt1 += 1;
      }
    }
    
    private void prepareMenuItems()
    {
      if (this.updateSuspended) {
        return;
      }
      this.updateSuspended = true;
      this.items.clear();
      this.items.add(new NavigationMenuPresenter.NavigationMenuHeaderItem());
      int i2 = NavigationMenuPresenter.this.menu.getVisibleItems().size();
      int m = 0;
      int n = -1;
      boolean bool2 = false;
      int k;
      for (int i = 0; m < i2; i = k)
      {
        Object localObject = (MenuItemImpl)NavigationMenuPresenter.this.menu.getVisibleItems().get(m);
        if (((MenuItemImpl)localObject).isChecked()) {
          setCheckedItem((MenuItemImpl)localObject);
        }
        if (((MenuItemImpl)localObject).isCheckable()) {
          ((MenuItemImpl)localObject).setExclusiveCheckable(false);
        }
        int i1;
        boolean bool1;
        int j;
        if (((MenuItemImpl)localObject).hasSubMenu())
        {
          SubMenu localSubMenu = ((MenuItemImpl)localObject).getSubMenu();
          i1 = n;
          bool1 = bool2;
          k = i;
          if (localSubMenu.hasVisibleItems())
          {
            if (m != 0) {
              this.items.add(new NavigationMenuPresenter.NavigationMenuSeparatorItem(NavigationMenuPresenter.this.paddingSeparator, 0));
            }
            this.items.add(new NavigationMenuPresenter.NavigationMenuTextItem((MenuItemImpl)localObject));
            int i3 = this.items.size();
            int i4 = localSubMenu.size();
            i1 = 0;
            for (j = 0; i1 < i4; j = k)
            {
              MenuItemImpl localMenuItemImpl = (MenuItemImpl)localSubMenu.getItem(i1);
              k = j;
              if (localMenuItemImpl.isVisible())
              {
                k = j;
                if (j == 0)
                {
                  k = j;
                  if (localMenuItemImpl.getIcon() != null) {
                    k = 1;
                  }
                }
                if (localMenuItemImpl.isCheckable()) {
                  localMenuItemImpl.setExclusiveCheckable(false);
                }
                if (((MenuItemImpl)localObject).isChecked()) {
                  setCheckedItem((MenuItemImpl)localObject);
                }
                this.items.add(new NavigationMenuPresenter.NavigationMenuTextItem(localMenuItemImpl));
              }
              i1 += 1;
            }
            i1 = n;
            bool1 = bool2;
            k = i;
            if (j != 0)
            {
              appendTransparentIconIfMissing(i3, this.items.size());
              i1 = n;
              bool1 = bool2;
              k = i;
            }
          }
        }
        else
        {
          i1 = ((MenuItemImpl)localObject).getGroupId();
          if (i1 != n)
          {
            i = this.items.size();
            if (((MenuItemImpl)localObject).getIcon() != null) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            j = i;
            if (m != 0)
            {
              j = i + 1;
              this.items.add(new NavigationMenuPresenter.NavigationMenuSeparatorItem(NavigationMenuPresenter.this.paddingSeparator, NavigationMenuPresenter.this.paddingSeparator));
            }
          }
          else
          {
            bool1 = bool2;
            j = i;
            if (!bool2)
            {
              bool1 = bool2;
              j = i;
              if (((MenuItemImpl)localObject).getIcon() != null)
              {
                appendTransparentIconIfMissing(i, this.items.size());
                bool1 = true;
                j = i;
              }
            }
          }
          localObject = new NavigationMenuPresenter.NavigationMenuTextItem((MenuItemImpl)localObject);
          ((NavigationMenuPresenter.NavigationMenuTextItem)localObject).needsEmptyIcon = bool1;
          this.items.add(localObject);
          k = j;
        }
        m += 1;
        n = i1;
        bool2 = bool1;
      }
      this.updateSuspended = false;
    }
    
    public Bundle createInstanceState()
    {
      Bundle localBundle = new Bundle();
      if (this.checkedItem != null) {
        localBundle.putInt("android:menu:checked", this.checkedItem.getItemId());
      }
      SparseArray localSparseArray = new SparseArray();
      int i = 0;
      int j = this.items.size();
      while (i < j)
      {
        Object localObject = (NavigationMenuPresenter.NavigationMenuItem)this.items.get(i);
        if ((localObject instanceof NavigationMenuPresenter.NavigationMenuTextItem))
        {
          MenuItemImpl localMenuItemImpl = ((NavigationMenuPresenter.NavigationMenuTextItem)localObject).getMenuItem();
          if (localMenuItemImpl != null) {
            localObject = localMenuItemImpl.getActionView();
          } else {
            localObject = null;
          }
          if (localObject != null)
          {
            ParcelableSparseArray localParcelableSparseArray = new ParcelableSparseArray();
            ((View)localObject).saveHierarchyState(localParcelableSparseArray);
            localSparseArray.put(localMenuItemImpl.getItemId(), localParcelableSparseArray);
          }
        }
        i += 1;
      }
      localBundle.putSparseParcelableArray("android:menu:action_views", localSparseArray);
      return localBundle;
    }
    
    public MenuItemImpl getCheckedItem()
    {
      return this.checkedItem;
    }
    
    public int getItemCount()
    {
      return this.items.size();
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public int getItemViewType(int paramInt)
    {
      NavigationMenuPresenter.NavigationMenuItem localNavigationMenuItem = (NavigationMenuPresenter.NavigationMenuItem)this.items.get(paramInt);
      if ((localNavigationMenuItem instanceof NavigationMenuPresenter.NavigationMenuSeparatorItem)) {
        return 2;
      }
      if ((localNavigationMenuItem instanceof NavigationMenuPresenter.NavigationMenuHeaderItem)) {
        return 3;
      }
      if ((localNavigationMenuItem instanceof NavigationMenuPresenter.NavigationMenuTextItem))
      {
        if (((NavigationMenuPresenter.NavigationMenuTextItem)localNavigationMenuItem).getMenuItem().hasSubMenu()) {
          return 1;
        }
        return 0;
      }
      throw new RuntimeException("Unknown item type.");
    }
    
    public void onBindViewHolder(NavigationMenuPresenter.ViewHolder paramViewHolder, int paramInt)
    {
      switch (getItemViewType(paramInt))
      {
      default: 
        return;
      case 2: 
        localObject = (NavigationMenuPresenter.NavigationMenuSeparatorItem)this.items.get(paramInt);
        paramViewHolder.itemView.setPadding(0, ((NavigationMenuPresenter.NavigationMenuSeparatorItem)localObject).getPaddingTop(), 0, ((NavigationMenuPresenter.NavigationMenuSeparatorItem)localObject).getPaddingBottom());
        return;
      case 1: 
        ((TextView)paramViewHolder.itemView).setText(((NavigationMenuPresenter.NavigationMenuTextItem)this.items.get(paramInt)).getMenuItem().getTitle());
        return;
      }
      Object localObject = (NavigationMenuItemView)paramViewHolder.itemView;
      ((NavigationMenuItemView)localObject).setIconTintList(NavigationMenuPresenter.this.iconTintList);
      if (NavigationMenuPresenter.this.textAppearanceSet) {
        ((NavigationMenuItemView)localObject).setTextAppearance(NavigationMenuPresenter.this.textAppearance);
      }
      if (NavigationMenuPresenter.this.textColor != null) {
        ((NavigationMenuItemView)localObject).setTextColor(NavigationMenuPresenter.this.textColor);
      }
      if (NavigationMenuPresenter.this.itemBackground != null) {
        paramViewHolder = NavigationMenuPresenter.this.itemBackground.getConstantState().newDrawable();
      } else {
        paramViewHolder = null;
      }
      ViewCompat.setBackground((View)localObject, paramViewHolder);
      paramViewHolder = (NavigationMenuPresenter.NavigationMenuTextItem)this.items.get(paramInt);
      ((NavigationMenuItemView)localObject).setNeedsEmptyIcon(paramViewHolder.needsEmptyIcon);
      ((NavigationMenuItemView)localObject).setHorizontalPadding(NavigationMenuPresenter.this.itemHorizontalPadding);
      ((NavigationMenuItemView)localObject).setIconPadding(NavigationMenuPresenter.this.itemIconPadding);
      ((NavigationMenuItemView)localObject).initialize(paramViewHolder.getMenuItem(), 0);
    }
    
    public NavigationMenuPresenter.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return null;
      case 3: 
        return new NavigationMenuPresenter.HeaderViewHolder(NavigationMenuPresenter.this.headerLayout);
      case 2: 
        return new NavigationMenuPresenter.SeparatorViewHolder(NavigationMenuPresenter.this.layoutInflater, paramViewGroup);
      case 1: 
        return new NavigationMenuPresenter.SubheaderViewHolder(NavigationMenuPresenter.this.layoutInflater, paramViewGroup);
      }
      return new NavigationMenuPresenter.NormalViewHolder(NavigationMenuPresenter.this.layoutInflater, paramViewGroup, NavigationMenuPresenter.this.onClickListener);
    }
    
    public void onViewRecycled(NavigationMenuPresenter.ViewHolder paramViewHolder)
    {
      if ((paramViewHolder instanceof NavigationMenuPresenter.NormalViewHolder)) {
        ((NavigationMenuItemView)paramViewHolder.itemView).recycle();
      }
    }
    
    public void restoreInstanceState(Bundle paramBundle)
    {
      int j = 0;
      int k = paramBundle.getInt("android:menu:checked", 0);
      int i;
      Object localObject1;
      if (k != 0)
      {
        this.updateSuspended = true;
        int m = this.items.size();
        i = 0;
        while (i < m)
        {
          localObject1 = (NavigationMenuPresenter.NavigationMenuItem)this.items.get(i);
          if ((localObject1 instanceof NavigationMenuPresenter.NavigationMenuTextItem))
          {
            localObject1 = ((NavigationMenuPresenter.NavigationMenuTextItem)localObject1).getMenuItem();
            if ((localObject1 != null) && (((MenuItemImpl)localObject1).getItemId() == k))
            {
              setCheckedItem((MenuItemImpl)localObject1);
              break;
            }
          }
          i += 1;
        }
        this.updateSuspended = false;
        prepareMenuItems();
      }
      paramBundle = paramBundle.getSparseParcelableArray("android:menu:action_views");
      if (paramBundle != null)
      {
        k = this.items.size();
        i = j;
        while (i < k)
        {
          localObject1 = (NavigationMenuPresenter.NavigationMenuItem)this.items.get(i);
          if ((localObject1 instanceof NavigationMenuPresenter.NavigationMenuTextItem))
          {
            Object localObject2 = ((NavigationMenuPresenter.NavigationMenuTextItem)localObject1).getMenuItem();
            if (localObject2 != null)
            {
              localObject1 = ((MenuItemImpl)localObject2).getActionView();
              if (localObject1 != null)
              {
                localObject2 = (ParcelableSparseArray)paramBundle.get(((MenuItemImpl)localObject2).getItemId());
                if (localObject2 != null) {
                  ((View)localObject1).restoreHierarchyState((SparseArray)localObject2);
                }
              }
            }
          }
          i += 1;
        }
      }
    }
    
    public void setCheckedItem(MenuItemImpl paramMenuItemImpl)
    {
      if (this.checkedItem != paramMenuItemImpl)
      {
        if (!paramMenuItemImpl.isCheckable()) {
          return;
        }
        if (this.checkedItem != null) {
          this.checkedItem.setChecked(false);
        }
        this.checkedItem = paramMenuItemImpl;
        paramMenuItemImpl.setChecked(true);
        return;
      }
    }
    
    public void setUpdateSuspended(boolean paramBoolean)
    {
      this.updateSuspended = paramBoolean;
    }
    
    public void update()
    {
      prepareMenuItems();
      notifyDataSetChanged();
    }
  }
  
  private static class NavigationMenuHeaderItem
    implements NavigationMenuPresenter.NavigationMenuItem
  {}
  
  private static abstract interface NavigationMenuItem {}
  
  private static class NavigationMenuSeparatorItem
    implements NavigationMenuPresenter.NavigationMenuItem
  {
    private final int paddingBottom;
    private final int paddingTop;
    
    public NavigationMenuSeparatorItem(int paramInt1, int paramInt2)
    {
      this.paddingTop = paramInt1;
      this.paddingBottom = paramInt2;
    }
    
    public int getPaddingBottom()
    {
      return this.paddingBottom;
    }
    
    public int getPaddingTop()
    {
      return this.paddingTop;
    }
  }
  
  private static class NavigationMenuTextItem
    implements NavigationMenuPresenter.NavigationMenuItem
  {
    private final MenuItemImpl menuItem;
    boolean needsEmptyIcon;
    
    NavigationMenuTextItem(MenuItemImpl paramMenuItemImpl)
    {
      this.menuItem = paramMenuItemImpl;
    }
    
    public MenuItemImpl getMenuItem()
    {
      return this.menuItem;
    }
  }
  
  private static class NormalViewHolder
    extends NavigationMenuPresenter.ViewHolder
  {
    public NormalViewHolder(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, View.OnClickListener paramOnClickListener)
    {
      super();
      this.itemView.setOnClickListener(paramOnClickListener);
    }
  }
  
  private static class SeparatorViewHolder
    extends NavigationMenuPresenter.ViewHolder
  {
    public SeparatorViewHolder(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  private static class SubheaderViewHolder
    extends NavigationMenuPresenter.ViewHolder
  {
    public SubheaderViewHolder(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
    {
      super();
    }
  }
  
  private static abstract class ViewHolder
    extends RecyclerView.ViewHolder
  {
    public ViewHolder(View paramView)
    {
      super();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\internal\NavigationMenuPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */