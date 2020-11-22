package android.support.v7.view.menu;

import android.support.annotation.RestrictTo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class MenuAdapter
  extends BaseAdapter
{
  MenuBuilder mAdapterMenu;
  private int mExpandedIndex = -1;
  private boolean mForceShowIcon;
  private final LayoutInflater mInflater;
  private final int mItemLayoutRes;
  private final boolean mOverflowOnly;
  
  public MenuAdapter(MenuBuilder paramMenuBuilder, LayoutInflater paramLayoutInflater, boolean paramBoolean, int paramInt)
  {
    this.mOverflowOnly = paramBoolean;
    this.mInflater = paramLayoutInflater;
    this.mAdapterMenu = paramMenuBuilder;
    this.mItemLayoutRes = paramInt;
    findExpandedIndex();
  }
  
  void findExpandedIndex()
  {
    MenuItemImpl localMenuItemImpl = this.mAdapterMenu.getExpandedItem();
    if (localMenuItemImpl != null)
    {
      ArrayList localArrayList = this.mAdapterMenu.getNonActionItems();
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        if ((MenuItemImpl)localArrayList.get(i) == localMenuItemImpl)
        {
          this.mExpandedIndex = i;
          return;
        }
        i += 1;
      }
    }
    this.mExpandedIndex = -1;
  }
  
  public MenuBuilder getAdapterMenu()
  {
    return this.mAdapterMenu;
  }
  
  public int getCount()
  {
    ArrayList localArrayList;
    if (this.mOverflowOnly) {
      localArrayList = this.mAdapterMenu.getNonActionItems();
    } else {
      localArrayList = this.mAdapterMenu.getVisibleItems();
    }
    if (this.mExpandedIndex < 0) {
      return localArrayList.size();
    }
    return localArrayList.size() - 1;
  }
  
  public boolean getForceShowIcon()
  {
    return this.mForceShowIcon;
  }
  
  public MenuItemImpl getItem(int paramInt)
  {
    ArrayList localArrayList;
    if (this.mOverflowOnly) {
      localArrayList = this.mAdapterMenu.getNonActionItems();
    } else {
      localArrayList = this.mAdapterMenu.getVisibleItems();
    }
    int i = paramInt;
    if (this.mExpandedIndex >= 0)
    {
      i = paramInt;
      if (paramInt >= this.mExpandedIndex) {
        i = paramInt + 1;
      }
    }
    return (MenuItemImpl)localArrayList.get(i);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = this.mInflater.inflate(this.mItemLayoutRes, paramViewGroup, false);
    }
    int j = getItem(paramInt).getGroupId();
    int i = paramInt - 1;
    if (i >= 0) {
      i = getItem(i).getGroupId();
    } else {
      i = j;
    }
    paramView = (ListMenuItemView)localView;
    boolean bool;
    if ((this.mAdapterMenu.isGroupDividerEnabled()) && (j != i)) {
      bool = true;
    } else {
      bool = false;
    }
    paramView.setGroupDividerEnabled(bool);
    paramViewGroup = (MenuView.ItemView)localView;
    if (this.mForceShowIcon) {
      paramView.setForceShowIcon(true);
    }
    paramViewGroup.initialize(getItem(paramInt), 0);
    return localView;
  }
  
  public void notifyDataSetChanged()
  {
    findExpandedIndex();
    super.notifyDataSetChanged();
  }
  
  public void setForceShowIcon(boolean paramBoolean)
  {
    this.mForceShowIcon = paramBoolean;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\view\menu\MenuAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */