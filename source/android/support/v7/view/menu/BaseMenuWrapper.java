package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.internal.view.SupportSubMenu;
import android.support.v4.util.ArrayMap;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

abstract class BaseMenuWrapper<T>
  extends BaseWrapper<T>
{
  final Context mContext;
  private Map<SupportMenuItem, MenuItem> mMenuItems;
  private Map<SupportSubMenu, SubMenu> mSubMenus;
  
  BaseMenuWrapper(Context paramContext, T paramT)
  {
    super(paramT);
    this.mContext = paramContext;
  }
  
  final MenuItem getMenuItemWrapper(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof SupportMenuItem))
    {
      SupportMenuItem localSupportMenuItem = (SupportMenuItem)paramMenuItem;
      if (this.mMenuItems == null) {
        this.mMenuItems = new ArrayMap();
      }
      MenuItem localMenuItem = (MenuItem)this.mMenuItems.get(paramMenuItem);
      paramMenuItem = localMenuItem;
      if (localMenuItem == null)
      {
        paramMenuItem = MenuWrapperFactory.wrapSupportMenuItem(this.mContext, localSupportMenuItem);
        this.mMenuItems.put(localSupportMenuItem, paramMenuItem);
      }
      return paramMenuItem;
    }
    return paramMenuItem;
  }
  
  final SubMenu getSubMenuWrapper(SubMenu paramSubMenu)
  {
    if ((paramSubMenu instanceof SupportSubMenu))
    {
      SupportSubMenu localSupportSubMenu = (SupportSubMenu)paramSubMenu;
      if (this.mSubMenus == null) {
        this.mSubMenus = new ArrayMap();
      }
      SubMenu localSubMenu = (SubMenu)this.mSubMenus.get(localSupportSubMenu);
      paramSubMenu = localSubMenu;
      if (localSubMenu == null)
      {
        paramSubMenu = MenuWrapperFactory.wrapSupportSubMenu(this.mContext, localSupportSubMenu);
        this.mSubMenus.put(localSupportSubMenu, paramSubMenu);
      }
      return paramSubMenu;
    }
    return paramSubMenu;
  }
  
  final void internalClear()
  {
    if (this.mMenuItems != null) {
      this.mMenuItems.clear();
    }
    if (this.mSubMenus != null) {
      this.mSubMenus.clear();
    }
  }
  
  final void internalRemoveGroup(int paramInt)
  {
    if (this.mMenuItems == null) {
      return;
    }
    Iterator localIterator = this.mMenuItems.keySet().iterator();
    while (localIterator.hasNext()) {
      if (paramInt == ((MenuItem)localIterator.next()).getGroupId()) {
        localIterator.remove();
      }
    }
  }
  
  final void internalRemoveItem(int paramInt)
  {
    if (this.mMenuItems == null) {
      return;
    }
    Iterator localIterator = this.mMenuItems.keySet().iterator();
    while (localIterator.hasNext()) {
      if (paramInt == ((MenuItem)localIterator.next()).getItemId()) {
        localIterator.remove();
      }
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\view\menu\BaseMenuWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */