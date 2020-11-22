package android.support.v4.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.SparseArrayCompat;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewParentCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeProviderCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import java.util.ArrayList;
import java.util.List;

public abstract class ExploreByTouchHelper
  extends AccessibilityDelegateCompat
{
  private static final String DEFAULT_CLASS_NAME = "android.view.View";
  public static final int HOST_ID = -1;
  public static final int INVALID_ID = Integer.MIN_VALUE;
  private static final Rect INVALID_PARENT_BOUNDS = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
  private static final FocusStrategy.BoundsAdapter<AccessibilityNodeInfoCompat> NODE_ADAPTER = new FocusStrategy.BoundsAdapter()
  {
    public void obtainBounds(AccessibilityNodeInfoCompat paramAnonymousAccessibilityNodeInfoCompat, Rect paramAnonymousRect)
    {
      paramAnonymousAccessibilityNodeInfoCompat.getBoundsInParent(paramAnonymousRect);
    }
  };
  private static final FocusStrategy.CollectionAdapter<SparseArrayCompat<AccessibilityNodeInfoCompat>, AccessibilityNodeInfoCompat> SPARSE_VALUES_ADAPTER = new FocusStrategy.CollectionAdapter()
  {
    public AccessibilityNodeInfoCompat get(SparseArrayCompat<AccessibilityNodeInfoCompat> paramAnonymousSparseArrayCompat, int paramAnonymousInt)
    {
      return (AccessibilityNodeInfoCompat)paramAnonymousSparseArrayCompat.valueAt(paramAnonymousInt);
    }
    
    public int size(SparseArrayCompat<AccessibilityNodeInfoCompat> paramAnonymousSparseArrayCompat)
    {
      return paramAnonymousSparseArrayCompat.size();
    }
  };
  int mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
  private final View mHost;
  private int mHoveredVirtualViewId = Integer.MIN_VALUE;
  int mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
  private final AccessibilityManager mManager;
  private MyNodeProvider mNodeProvider;
  private final int[] mTempGlobalRect = new int[2];
  private final Rect mTempParentRect = new Rect();
  private final Rect mTempScreenRect = new Rect();
  private final Rect mTempVisibleRect = new Rect();
  
  public ExploreByTouchHelper(@NonNull View paramView)
  {
    if (paramView != null)
    {
      this.mHost = paramView;
      this.mManager = ((AccessibilityManager)paramView.getContext().getSystemService("accessibility"));
      paramView.setFocusable(true);
      if (ViewCompat.getImportantForAccessibility(paramView) == 0) {
        ViewCompat.setImportantForAccessibility(paramView, 1);
      }
      return;
    }
    throw new IllegalArgumentException("View may not be null");
  }
  
  private boolean clearAccessibilityFocus(int paramInt)
  {
    if (this.mAccessibilityFocusedVirtualViewId == paramInt)
    {
      this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
      this.mHost.invalidate();
      sendEventForVirtualView(paramInt, 65536);
      return true;
    }
    return false;
  }
  
  private boolean clickKeyboardFocusedVirtualView()
  {
    return (this.mKeyboardFocusedVirtualViewId != Integer.MIN_VALUE) && (onPerformActionForVirtualView(this.mKeyboardFocusedVirtualViewId, 16, null));
  }
  
  private AccessibilityEvent createEvent(int paramInt1, int paramInt2)
  {
    if (paramInt1 != -1) {
      return createEventForChild(paramInt1, paramInt2);
    }
    return createEventForHost(paramInt2);
  }
  
  private AccessibilityEvent createEventForChild(int paramInt1, int paramInt2)
  {
    AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(paramInt2);
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = obtainAccessibilityNodeInfo(paramInt1);
    localAccessibilityEvent.getText().add(localAccessibilityNodeInfoCompat.getText());
    localAccessibilityEvent.setContentDescription(localAccessibilityNodeInfoCompat.getContentDescription());
    localAccessibilityEvent.setScrollable(localAccessibilityNodeInfoCompat.isScrollable());
    localAccessibilityEvent.setPassword(localAccessibilityNodeInfoCompat.isPassword());
    localAccessibilityEvent.setEnabled(localAccessibilityNodeInfoCompat.isEnabled());
    localAccessibilityEvent.setChecked(localAccessibilityNodeInfoCompat.isChecked());
    onPopulateEventForVirtualView(paramInt1, localAccessibilityEvent);
    if ((localAccessibilityEvent.getText().isEmpty()) && (localAccessibilityEvent.getContentDescription() == null)) {
      throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }
    localAccessibilityEvent.setClassName(localAccessibilityNodeInfoCompat.getClassName());
    AccessibilityRecordCompat.setSource(localAccessibilityEvent, this.mHost, paramInt1);
    localAccessibilityEvent.setPackageName(this.mHost.getContext().getPackageName());
    return localAccessibilityEvent;
  }
  
  private AccessibilityEvent createEventForHost(int paramInt)
  {
    AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(paramInt);
    this.mHost.onInitializeAccessibilityEvent(localAccessibilityEvent);
    return localAccessibilityEvent;
  }
  
  @NonNull
  private AccessibilityNodeInfoCompat createNodeForChild(int paramInt)
  {
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat1 = AccessibilityNodeInfoCompat.obtain();
    localAccessibilityNodeInfoCompat1.setEnabled(true);
    localAccessibilityNodeInfoCompat1.setFocusable(true);
    localAccessibilityNodeInfoCompat1.setClassName("android.view.View");
    localAccessibilityNodeInfoCompat1.setBoundsInParent(INVALID_PARENT_BOUNDS);
    localAccessibilityNodeInfoCompat1.setBoundsInScreen(INVALID_PARENT_BOUNDS);
    localAccessibilityNodeInfoCompat1.setParent(this.mHost);
    onPopulateNodeForVirtualView(paramInt, localAccessibilityNodeInfoCompat1);
    if ((localAccessibilityNodeInfoCompat1.getText() == null) && (localAccessibilityNodeInfoCompat1.getContentDescription() == null)) {
      throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
    }
    localAccessibilityNodeInfoCompat1.getBoundsInParent(this.mTempParentRect);
    if (!this.mTempParentRect.equals(INVALID_PARENT_BOUNDS))
    {
      int i = localAccessibilityNodeInfoCompat1.getActions();
      if ((i & 0x40) == 0)
      {
        if ((i & 0x80) == 0)
        {
          localAccessibilityNodeInfoCompat1.setPackageName(this.mHost.getContext().getPackageName());
          localAccessibilityNodeInfoCompat1.setSource(this.mHost, paramInt);
          if (this.mAccessibilityFocusedVirtualViewId == paramInt)
          {
            localAccessibilityNodeInfoCompat1.setAccessibilityFocused(true);
            localAccessibilityNodeInfoCompat1.addAction(128);
          }
          else
          {
            localAccessibilityNodeInfoCompat1.setAccessibilityFocused(false);
            localAccessibilityNodeInfoCompat1.addAction(64);
          }
          boolean bool;
          if (this.mKeyboardFocusedVirtualViewId == paramInt) {
            bool = true;
          } else {
            bool = false;
          }
          if (bool) {
            localAccessibilityNodeInfoCompat1.addAction(2);
          } else if (localAccessibilityNodeInfoCompat1.isFocusable()) {
            localAccessibilityNodeInfoCompat1.addAction(1);
          }
          localAccessibilityNodeInfoCompat1.setFocused(bool);
          this.mHost.getLocationOnScreen(this.mTempGlobalRect);
          localAccessibilityNodeInfoCompat1.getBoundsInScreen(this.mTempScreenRect);
          if (this.mTempScreenRect.equals(INVALID_PARENT_BOUNDS))
          {
            localAccessibilityNodeInfoCompat1.getBoundsInParent(this.mTempScreenRect);
            if (localAccessibilityNodeInfoCompat1.mParentVirtualDescendantId != -1)
            {
              AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat2 = AccessibilityNodeInfoCompat.obtain();
              for (paramInt = localAccessibilityNodeInfoCompat1.mParentVirtualDescendantId; paramInt != -1; paramInt = localAccessibilityNodeInfoCompat2.mParentVirtualDescendantId)
              {
                localAccessibilityNodeInfoCompat2.setParent(this.mHost, -1);
                localAccessibilityNodeInfoCompat2.setBoundsInParent(INVALID_PARENT_BOUNDS);
                onPopulateNodeForVirtualView(paramInt, localAccessibilityNodeInfoCompat2);
                localAccessibilityNodeInfoCompat2.getBoundsInParent(this.mTempParentRect);
                this.mTempScreenRect.offset(this.mTempParentRect.left, this.mTempParentRect.top);
              }
              localAccessibilityNodeInfoCompat2.recycle();
            }
            this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
          }
          if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect))
          {
            this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
            if (this.mTempScreenRect.intersect(this.mTempVisibleRect))
            {
              localAccessibilityNodeInfoCompat1.setBoundsInScreen(this.mTempScreenRect);
              if (isVisibleToUser(this.mTempScreenRect)) {
                localAccessibilityNodeInfoCompat1.setVisibleToUser(true);
              }
            }
          }
          return localAccessibilityNodeInfoCompat1;
        }
        throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
      }
      throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
    }
    throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
  }
  
  @NonNull
  private AccessibilityNodeInfoCompat createNodeForHost()
  {
    AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = AccessibilityNodeInfoCompat.obtain(this.mHost);
    ViewCompat.onInitializeAccessibilityNodeInfo(this.mHost, localAccessibilityNodeInfoCompat);
    ArrayList localArrayList = new ArrayList();
    getVisibleVirtualViews(localArrayList);
    if ((localAccessibilityNodeInfoCompat.getChildCount() > 0) && (localArrayList.size() > 0)) {
      throw new RuntimeException("Views cannot have both real and virtual children");
    }
    int i = 0;
    int j = localArrayList.size();
    while (i < j)
    {
      localAccessibilityNodeInfoCompat.addChild(this.mHost, ((Integer)localArrayList.get(i)).intValue());
      i += 1;
    }
    return localAccessibilityNodeInfoCompat;
  }
  
  private SparseArrayCompat<AccessibilityNodeInfoCompat> getAllNodes()
  {
    ArrayList localArrayList = new ArrayList();
    getVisibleVirtualViews(localArrayList);
    SparseArrayCompat localSparseArrayCompat = new SparseArrayCompat();
    int i = 0;
    while (i < localArrayList.size())
    {
      localSparseArrayCompat.put(i, createNodeForChild(i));
      i += 1;
    }
    return localSparseArrayCompat;
  }
  
  private void getBoundsInParent(int paramInt, Rect paramRect)
  {
    obtainAccessibilityNodeInfo(paramInt).getBoundsInParent(paramRect);
  }
  
  private static Rect guessPreviouslyFocusedRect(@NonNull View paramView, int paramInt, @NonNull Rect paramRect)
  {
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    if (paramInt != 17)
    {
      if (paramInt != 33)
      {
        if (paramInt != 66)
        {
          if (paramInt == 130)
          {
            paramRect.set(0, -1, i, -1);
            return paramRect;
          }
          throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        paramRect.set(-1, 0, -1, j);
        return paramRect;
      }
      paramRect.set(0, j, i, j);
      return paramRect;
    }
    paramRect.set(i, 0, i, j);
    return paramRect;
  }
  
  private boolean isVisibleToUser(Rect paramRect)
  {
    boolean bool = false;
    if (paramRect != null)
    {
      if (paramRect.isEmpty()) {
        return false;
      }
      if (this.mHost.getWindowVisibility() != 0) {
        return false;
      }
      paramRect = this.mHost.getParent();
      while ((paramRect instanceof View))
      {
        paramRect = (View)paramRect;
        if (paramRect.getAlpha() > 0.0F)
        {
          if (paramRect.getVisibility() != 0) {
            return false;
          }
          paramRect = paramRect.getParent();
        }
        else
        {
          return false;
        }
      }
      if (paramRect != null) {
        bool = true;
      }
      return bool;
    }
    return false;
  }
  
  private static int keyToDirection(int paramInt)
  {
    switch (paramInt)
    {
    case 20: 
    default: 
      return 130;
    case 22: 
      return 66;
    case 21: 
      return 17;
    }
    return 33;
  }
  
  private boolean moveFocus(int paramInt, @Nullable Rect paramRect)
  {
    SparseArrayCompat localSparseArrayCompat = getAllNodes();
    int j = this.mKeyboardFocusedVirtualViewId;
    int i = Integer.MIN_VALUE;
    if (j == Integer.MIN_VALUE) {}
    for (AccessibilityNodeInfoCompat localAccessibilityNodeInfoCompat = null;; localAccessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat)localSparseArrayCompat.get(j)) {
      break;
    }
    if ((paramInt != 17) && (paramInt != 33) && (paramInt != 66) && (paramInt != 130))
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
      }
      boolean bool;
      if (ViewCompat.getLayoutDirection(this.mHost) == 1) {
        bool = true;
      } else {
        bool = false;
      }
      paramRect = (AccessibilityNodeInfoCompat)FocusStrategy.findNextFocusInRelativeDirection(localSparseArrayCompat, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, localAccessibilityNodeInfoCompat, paramInt, bool, false);
    }
    else
    {
      Rect localRect = new Rect();
      if (this.mKeyboardFocusedVirtualViewId != Integer.MIN_VALUE) {
        getBoundsInParent(this.mKeyboardFocusedVirtualViewId, localRect);
      } else if (paramRect != null) {
        localRect.set(paramRect);
      } else {
        guessPreviouslyFocusedRect(this.mHost, paramInt, localRect);
      }
      paramRect = (AccessibilityNodeInfoCompat)FocusStrategy.findNextFocusInAbsoluteDirection(localSparseArrayCompat, SPARSE_VALUES_ADAPTER, NODE_ADAPTER, localAccessibilityNodeInfoCompat, localRect, paramInt);
    }
    if (paramRect == null) {
      paramInt = i;
    } else {
      paramInt = localSparseArrayCompat.keyAt(localSparseArrayCompat.indexOfValue(paramRect));
    }
    return requestKeyboardFocusForVirtualView(paramInt);
  }
  
  private boolean performActionForChild(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (paramInt2 != 64)
    {
      if (paramInt2 != 128)
      {
        switch (paramInt2)
        {
        default: 
          return onPerformActionForVirtualView(paramInt1, paramInt2, paramBundle);
        case 2: 
          return clearKeyboardFocusForVirtualView(paramInt1);
        }
        return requestKeyboardFocusForVirtualView(paramInt1);
      }
      return clearAccessibilityFocus(paramInt1);
    }
    return requestAccessibilityFocus(paramInt1);
  }
  
  private boolean performActionForHost(int paramInt, Bundle paramBundle)
  {
    return ViewCompat.performAccessibilityAction(this.mHost, paramInt, paramBundle);
  }
  
  private boolean requestAccessibilityFocus(int paramInt)
  {
    if (this.mManager.isEnabled())
    {
      if (!this.mManager.isTouchExplorationEnabled()) {
        return false;
      }
      if (this.mAccessibilityFocusedVirtualViewId != paramInt)
      {
        if (this.mAccessibilityFocusedVirtualViewId != Integer.MIN_VALUE) {
          clearAccessibilityFocus(this.mAccessibilityFocusedVirtualViewId);
        }
        this.mAccessibilityFocusedVirtualViewId = paramInt;
        this.mHost.invalidate();
        sendEventForVirtualView(paramInt, 32768);
        return true;
      }
      return false;
    }
    return false;
  }
  
  private void updateHoveredVirtualView(int paramInt)
  {
    if (this.mHoveredVirtualViewId == paramInt) {
      return;
    }
    int i = this.mHoveredVirtualViewId;
    this.mHoveredVirtualViewId = paramInt;
    sendEventForVirtualView(paramInt, 128);
    sendEventForVirtualView(i, 256);
  }
  
  public final boolean clearKeyboardFocusForVirtualView(int paramInt)
  {
    if (this.mKeyboardFocusedVirtualViewId != paramInt) {
      return false;
    }
    this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
    onVirtualViewKeyboardFocusChanged(paramInt, false);
    sendEventForVirtualView(paramInt, 8);
    return true;
  }
  
  public final boolean dispatchHoverEvent(@NonNull MotionEvent paramMotionEvent)
  {
    boolean bool2 = this.mManager.isEnabled();
    boolean bool1 = false;
    if (bool2)
    {
      if (!this.mManager.isTouchExplorationEnabled()) {
        return false;
      }
      int i = paramMotionEvent.getAction();
      if (i != 7) {
        switch (i)
        {
        default: 
          return false;
        case 10: 
          if (this.mHoveredVirtualViewId != Integer.MIN_VALUE)
          {
            updateHoveredVirtualView(Integer.MIN_VALUE);
            return true;
          }
          return false;
        }
      }
      i = getVirtualViewAt(paramMotionEvent.getX(), paramMotionEvent.getY());
      updateHoveredVirtualView(i);
      if (i != Integer.MIN_VALUE) {
        bool1 = true;
      }
      return bool1;
    }
    return false;
  }
  
  public final boolean dispatchKeyEvent(@NonNull KeyEvent paramKeyEvent)
  {
    int j = paramKeyEvent.getAction();
    boolean bool2 = false;
    int i = 0;
    boolean bool1 = bool2;
    if (j != 1)
    {
      j = paramKeyEvent.getKeyCode();
      if (j != 61)
      {
        if (j != 66)
        {
          switch (j)
          {
          default: 
            return false;
          case 19: 
          case 20: 
          case 21: 
          case 22: 
            bool1 = bool2;
            if (!paramKeyEvent.hasNoModifiers()) {
              break;
            }
            j = keyToDirection(j);
            int k = paramKeyEvent.getRepeatCount();
            for (bool1 = false; (i < k + 1) && (moveFocus(j, null)); bool1 = true) {
              i += 1;
            }
            return bool1;
          }
        }
        else
        {
          bool1 = bool2;
          if (paramKeyEvent.hasNoModifiers())
          {
            bool1 = bool2;
            if (paramKeyEvent.getRepeatCount() == 0)
            {
              clickKeyboardFocusedVirtualView();
              return true;
            }
          }
        }
      }
      else
      {
        if (paramKeyEvent.hasNoModifiers()) {
          return moveFocus(2, null);
        }
        bool1 = bool2;
        if (paramKeyEvent.hasModifiers(1)) {
          bool1 = moveFocus(1, null);
        }
      }
    }
    return bool1;
  }
  
  public final int getAccessibilityFocusedVirtualViewId()
  {
    return this.mAccessibilityFocusedVirtualViewId;
  }
  
  public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View paramView)
  {
    if (this.mNodeProvider == null) {
      this.mNodeProvider = new MyNodeProvider();
    }
    return this.mNodeProvider;
  }
  
  @Deprecated
  public int getFocusedVirtualView()
  {
    return getAccessibilityFocusedVirtualViewId();
  }
  
  public final int getKeyboardFocusedVirtualViewId()
  {
    return this.mKeyboardFocusedVirtualViewId;
  }
  
  protected abstract int getVirtualViewAt(float paramFloat1, float paramFloat2);
  
  protected abstract void getVisibleVirtualViews(List<Integer> paramList);
  
  public final void invalidateRoot()
  {
    invalidateVirtualView(-1, 1);
  }
  
  public final void invalidateVirtualView(int paramInt)
  {
    invalidateVirtualView(paramInt, 0);
  }
  
  public final void invalidateVirtualView(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != Integer.MIN_VALUE) && (this.mManager.isEnabled()))
    {
      ViewParent localViewParent = this.mHost.getParent();
      if (localViewParent != null)
      {
        AccessibilityEvent localAccessibilityEvent = createEvent(paramInt1, 2048);
        AccessibilityEventCompat.setContentChangeTypes(localAccessibilityEvent, paramInt2);
        ViewParentCompat.requestSendAccessibilityEvent(localViewParent, this.mHost, localAccessibilityEvent);
      }
    }
  }
  
  @NonNull
  AccessibilityNodeInfoCompat obtainAccessibilityNodeInfo(int paramInt)
  {
    if (paramInt == -1) {
      return createNodeForHost();
    }
    return createNodeForChild(paramInt);
  }
  
  public final void onFocusChanged(boolean paramBoolean, int paramInt, @Nullable Rect paramRect)
  {
    if (this.mKeyboardFocusedVirtualViewId != Integer.MIN_VALUE) {
      clearKeyboardFocusForVirtualView(this.mKeyboardFocusedVirtualViewId);
    }
    if (paramBoolean) {
      moveFocus(paramInt, paramRect);
    }
  }
  
  public void onInitializeAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramView, paramAccessibilityEvent);
    onPopulateEventForHost(paramAccessibilityEvent);
  }
  
  public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfoCompat);
    onPopulateNodeForHost(paramAccessibilityNodeInfoCompat);
  }
  
  protected abstract boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, @Nullable Bundle paramBundle);
  
  protected void onPopulateEventForHost(@NonNull AccessibilityEvent paramAccessibilityEvent) {}
  
  protected void onPopulateEventForVirtualView(int paramInt, @NonNull AccessibilityEvent paramAccessibilityEvent) {}
  
  protected void onPopulateNodeForHost(@NonNull AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat) {}
  
  protected abstract void onPopulateNodeForVirtualView(int paramInt, @NonNull AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat);
  
  protected void onVirtualViewKeyboardFocusChanged(int paramInt, boolean paramBoolean) {}
  
  boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    if (paramInt1 != -1) {
      return performActionForChild(paramInt1, paramInt2, paramBundle);
    }
    return performActionForHost(paramInt2, paramBundle);
  }
  
  public final boolean requestKeyboardFocusForVirtualView(int paramInt)
  {
    if ((!this.mHost.isFocused()) && (!this.mHost.requestFocus())) {
      return false;
    }
    if (this.mKeyboardFocusedVirtualViewId == paramInt) {
      return false;
    }
    if (this.mKeyboardFocusedVirtualViewId != Integer.MIN_VALUE) {
      clearKeyboardFocusForVirtualView(this.mKeyboardFocusedVirtualViewId);
    }
    this.mKeyboardFocusedVirtualViewId = paramInt;
    onVirtualViewKeyboardFocusChanged(paramInt, true);
    sendEventForVirtualView(paramInt, 8);
    return true;
  }
  
  public final boolean sendEventForVirtualView(int paramInt1, int paramInt2)
  {
    if (paramInt1 != Integer.MIN_VALUE)
    {
      if (!this.mManager.isEnabled()) {
        return false;
      }
      ViewParent localViewParent = this.mHost.getParent();
      if (localViewParent == null) {
        return false;
      }
      AccessibilityEvent localAccessibilityEvent = createEvent(paramInt1, paramInt2);
      return ViewParentCompat.requestSendAccessibilityEvent(localViewParent, this.mHost, localAccessibilityEvent);
    }
    return false;
  }
  
  private class MyNodeProvider
    extends AccessibilityNodeProviderCompat
  {
    MyNodeProvider() {}
    
    public AccessibilityNodeInfoCompat createAccessibilityNodeInfo(int paramInt)
    {
      return AccessibilityNodeInfoCompat.obtain(ExploreByTouchHelper.this.obtainAccessibilityNodeInfo(paramInt));
    }
    
    public AccessibilityNodeInfoCompat findFocus(int paramInt)
    {
      if (paramInt == 2) {
        paramInt = ExploreByTouchHelper.this.mAccessibilityFocusedVirtualViewId;
      } else {
        paramInt = ExploreByTouchHelper.this.mKeyboardFocusedVirtualViewId;
      }
      if (paramInt == Integer.MIN_VALUE) {
        return null;
      }
      return createAccessibilityNodeInfo(paramInt);
    }
    
    public boolean performAction(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      return ExploreByTouchHelper.this.performAction(paramInt1, paramInt2, paramBundle);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\widget\ExploreByTouchHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */