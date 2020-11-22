package android.support.design.internal;

import android.content.Context;
import android.support.annotation.RestrictTo;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.SubMenuBuilder;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationSubMenu
  extends SubMenuBuilder
{
  public NavigationSubMenu(Context paramContext, NavigationMenu paramNavigationMenu, MenuItemImpl paramMenuItemImpl)
  {
    super(paramContext, paramNavigationMenu, paramMenuItemImpl);
  }
  
  public void onItemsChanged(boolean paramBoolean)
  {
    super.onItemsChanged(paramBoolean);
    ((MenuBuilder)getParentMenu()).onItemsChanged(paramBoolean);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\internal\NavigationSubMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */