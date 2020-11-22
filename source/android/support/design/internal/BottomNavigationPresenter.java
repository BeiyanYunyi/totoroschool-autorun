package android.support.design.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.view.menu.MenuPresenter;
import android.support.v7.view.menu.MenuPresenter.Callback;
import android.support.v7.view.menu.MenuView;
import android.support.v7.view.menu.SubMenuBuilder;
import android.view.ViewGroup;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class BottomNavigationPresenter
  implements MenuPresenter
{
  private int id;
  private MenuBuilder menu;
  private BottomNavigationMenuView menuView;
  private boolean updateSuspended = false;
  
  public boolean collapseItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public boolean expandItemActionView(MenuBuilder paramMenuBuilder, MenuItemImpl paramMenuItemImpl)
  {
    return false;
  }
  
  public boolean flagActionItems()
  {
    return false;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public MenuView getMenuView(ViewGroup paramViewGroup)
  {
    return this.menuView;
  }
  
  public void initForMenu(Context paramContext, MenuBuilder paramMenuBuilder)
  {
    this.menu = paramMenuBuilder;
    this.menuView.initialize(this.menu);
  }
  
  public void onCloseMenu(MenuBuilder paramMenuBuilder, boolean paramBoolean) {}
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState)) {
      this.menuView.tryRestoreSelectedItemId(((SavedState)paramParcelable).selectedItemId);
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState();
    localSavedState.selectedItemId = this.menuView.getSelectedItemId();
    return localSavedState;
  }
  
  public boolean onSubMenuSelected(SubMenuBuilder paramSubMenuBuilder)
  {
    return false;
  }
  
  public void setBottomNavigationMenuView(BottomNavigationMenuView paramBottomNavigationMenuView)
  {
    this.menuView = paramBottomNavigationMenuView;
  }
  
  public void setCallback(MenuPresenter.Callback paramCallback) {}
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setUpdateSuspended(boolean paramBoolean)
  {
    this.updateSuspended = paramBoolean;
  }
  
  public void updateMenuView(boolean paramBoolean)
  {
    if (this.updateSuspended) {
      return;
    }
    if (paramBoolean)
    {
      this.menuView.buildMenuView();
      return;
    }
    this.menuView.updateMenuView();
  }
  
  static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public BottomNavigationPresenter.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new BottomNavigationPresenter.SavedState(paramAnonymousParcel);
      }
      
      public BottomNavigationPresenter.SavedState[] newArray(int paramAnonymousInt)
      {
        return new BottomNavigationPresenter.SavedState[paramAnonymousInt];
      }
    };
    int selectedItemId;
    
    SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.selectedItemId = paramParcel.readInt();
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(@NonNull Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.selectedItemId);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\internal\BottomNavigationPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */