package android.support.v7.widget;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public class RecyclerViewAccessibilityDelegate
  extends AccessibilityDelegateCompat
{
  final AccessibilityDelegateCompat mItemDelegate;
  final RecyclerView mRecyclerView;
  
  public RecyclerViewAccessibilityDelegate(@NonNull RecyclerView paramRecyclerView)
  {
    this.mRecyclerView = paramRecyclerView;
    this.mItemDelegate = new ItemDelegate(this);
  }
  
  @NonNull
  public AccessibilityDelegateCompat getItemDelegate()
  {
    return this.mItemDelegate;
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(RecyclerView.class.getName());
    if (((paramView instanceof RecyclerView)) && (!shouldIgnore()))
    {
      paramView = (RecyclerView)paramView;
      if (paramView.getLayoutManager() != null) {
        paramView.getLayoutManager().onInitializeAccessibilityEvent(paramAccessibilityEvent);
      }
    }
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    paramAccessibilityNodeInfoCompat.setClassName(RecyclerView.class.getName());
    if ((!shouldIgnore()) && (this.mRecyclerView.getLayoutManager() != null)) {
      this.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfoCompat);
    }
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
      return true;
    }
    if ((!shouldIgnore()) && (this.mRecyclerView.getLayoutManager() != null)) {
      return this.mRecyclerView.getLayoutManager().performAccessibilityAction(paramInt, paramBundle);
    }
    return false;
  }
  
  boolean shouldIgnore()
  {
    return this.mRecyclerView.hasPendingAdapterUpdates();
  }
  
  public static class ItemDelegate
    extends AccessibilityDelegateCompat
  {
    final RecyclerViewAccessibilityDelegate mRecyclerViewDelegate;
    
    public ItemDelegate(@NonNull RecyclerViewAccessibilityDelegate paramRecyclerViewAccessibilityDelegate)
    {
      this.mRecyclerViewDelegate = paramRecyclerViewAccessibilityDelegate;
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
      if ((!this.mRecyclerViewDelegate.shouldIgnore()) && (this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager() != null)) {
        this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(paramView, paramAccessibilityNodeInfoCompat);
      }
    }
    
    public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      if (super.performAccessibilityAction(paramView, paramInt, paramBundle)) {
        return true;
      }
      if ((!this.mRecyclerViewDelegate.shouldIgnore()) && (this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager() != null)) {
        return this.mRecyclerViewDelegate.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(paramView, paramInt, paramBundle);
      }
      return false;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\widget\RecyclerViewAccessibilityDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */