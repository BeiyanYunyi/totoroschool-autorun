package android.support.design.internal;

import android.content.Context;
import android.support.annotation.RestrictTo;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.view.MenuItem;
import android.view.SubMenu;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public final class BottomNavigationMenu
  extends MenuBuilder
{
  public static final int MAX_ITEM_COUNT = 5;
  
  public BottomNavigationMenu(Context paramContext)
  {
    super(paramContext);
  }
  
  protected MenuItem addInternal(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    if (size() + 1 <= 5)
    {
      stopDispatchingItemsChanged();
      paramCharSequence = super.addInternal(paramInt1, paramInt2, paramInt3, paramCharSequence);
      if ((paramCharSequence instanceof MenuItemImpl)) {
        ((MenuItemImpl)paramCharSequence).setExclusiveCheckable(true);
      }
      startDispatchingItemsChanged();
      return paramCharSequence;
    }
    throw new IllegalArgumentException("Maximum number of items supported by BottomNavigationView is 5. Limit can be checked with BottomNavigationView#getMaxItemCount()");
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException("BottomNavigationView does not support submenus");
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\internal\BottomNavigationMenu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */