package android.support.v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

public class AccessibilityDelegateCompat
{
  private static final View.AccessibilityDelegate DEFAULT_DELEGATE = new View.AccessibilityDelegate();
  private final View.AccessibilityDelegate mBridge = new AccessibilityDelegateAdapter(this);
  
  public boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return DEFAULT_DELEGATE.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView = DEFAULT_DELEGATE.getAccessibilityNodeProvider(paramView);
      if (paramView != null) {
        return new AccessibilityNodeProviderCompat(paramView);
      }
    }
    return null;
  }
  
  View.AccessibilityDelegate getBridge()
  {
    return this.mBridge;
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    DEFAULT_DELEGATE.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    DEFAULT_DELEGATE.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat.unwrap());
  }
  
  public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    DEFAULT_DELEGATE.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
  }
  
  public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    return DEFAULT_DELEGATE.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
  }
  
  public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return DEFAULT_DELEGATE.performAccessibilityAction(paramView, paramInt, paramBundle);
    }
    return false;
  }
  
  public void sendAccessibilityEvent(View paramView, int paramInt)
  {
    DEFAULT_DELEGATE.sendAccessibilityEvent(paramView, paramInt);
  }
  
  public void sendAccessibilityEventUnchecked(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    DEFAULT_DELEGATE.sendAccessibilityEventUnchecked(paramView, paramAccessibilityEvent);
  }
  
  private static final class AccessibilityDelegateAdapter
    extends View.AccessibilityDelegate
  {
    private final AccessibilityDelegateCompat mCompat;
    
    AccessibilityDelegateAdapter(AccessibilityDelegateCompat paramAccessibilityDelegateCompat)
    {
      this.mCompat = paramAccessibilityDelegateCompat;
    }
    
    public boolean dispatchPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      return this.mCompat.dispatchPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
    }
    
    @RequiresApi(16)
    public AccessibilityNodeProvider getAccessibilityNodeProvider(View paramView)
    {
      paramView = this.mCompat.getAccessibilityNodeProvider(paramView);
      if (paramView != null) {
        return (AccessibilityNodeProvider)paramView.getProvider();
      }
      return null;
    }
    
    public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      this.mCompat.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    }
    
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      this.mCompat.onInitializeAccessibilityNodeInfo(paramView, AccessibilityNodeInfoCompat.wrap(paramAccessibilityNodeInfo));
    }
    
    public void onPopulateAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      this.mCompat.onPopulateAccessibilityEvent(paramView, paramAccessibilityEvent);
    }
    
    public boolean onRequestSendAccessibilityEvent(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      return this.mCompat.onRequestSendAccessibilityEvent(paramViewGroup, paramView, paramAccessibilityEvent);
    }
    
    public boolean performAccessibilityAction(View paramView, int paramInt, Bundle paramBundle)
    {
      return this.mCompat.performAccessibilityAction(paramView, paramInt, paramBundle);
    }
    
    public void sendAccessibilityEvent(View paramView, int paramInt)
    {
      this.mCompat.sendAccessibilityEvent(paramView, paramInt);
    }
    
    public void sendAccessibilityEventUnchecked(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      this.mCompat.sendAccessibilityEventUnchecked(paramView, paramAccessibilityEvent);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\view\AccessibilityDelegateCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */