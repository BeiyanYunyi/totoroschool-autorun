package android.support.design.internal;

import android.content.Context;
import android.support.annotation.RestrictTo;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.view.SubMenu;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class NavigationMenu
  extends MenuBuilder
{
  public NavigationMenu(Context paramContext)
  {
    super(paramContext);
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    paramCharSequence = (MenuItemImpl)addInternal(paramInt1, paramInt2, paramInt3, paramCharSequence);
    NavigationSubMenu localNavigationSubMenu = new NavigationSubMenu(getContext(), this, paramCharSequence);
    paramCharSequence.setSubMenu(localNavigationSubMenu);
    return localNavigationSubMenu;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\internal\NavigationMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */