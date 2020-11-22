package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.VisibleForTesting;
import android.support.design.R.dimen;
import android.support.design.R.styleable;
import android.support.v4.math.MathUtils;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class BottomSheetBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  private static final float HIDE_FRICTION = 0.1F;
  private static final float HIDE_THRESHOLD = 0.5F;
  public static final int PEEK_HEIGHT_AUTO = -1;
  public static final int STATE_COLLAPSED = 4;
  public static final int STATE_DRAGGING = 1;
  public static final int STATE_EXPANDED = 3;
  public static final int STATE_HALF_EXPANDED = 6;
  public static final int STATE_HIDDEN = 5;
  public static final int STATE_SETTLING = 2;
  int activePointerId;
  private BottomSheetCallback callback;
  int collapsedOffset;
  private final ViewDragHelper.Callback dragCallback = new ViewDragHelper.Callback()
  {
    public int clampViewPositionHorizontal(@NonNull View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      return paramAnonymousView.getLeft();
    }
    
    public int clampViewPositionVertical(@NonNull View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      int i = BottomSheetBehavior.this.getExpandedOffset();
      if (BottomSheetBehavior.this.hideable) {
        paramAnonymousInt2 = BottomSheetBehavior.this.parentHeight;
      } else {
        paramAnonymousInt2 = BottomSheetBehavior.this.collapsedOffset;
      }
      return MathUtils.clamp(paramAnonymousInt1, i, paramAnonymousInt2);
    }
    
    public int getViewVerticalDragRange(@NonNull View paramAnonymousView)
    {
      if (BottomSheetBehavior.this.hideable) {
        return BottomSheetBehavior.this.parentHeight;
      }
      return BottomSheetBehavior.this.collapsedOffset;
    }
    
    public void onViewDragStateChanged(int paramAnonymousInt)
    {
      if (paramAnonymousInt == 1) {
        BottomSheetBehavior.this.setStateInternal(1);
      }
    }
    
    public void onViewPositionChanged(@NonNull View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
    {
      BottomSheetBehavior.this.dispatchOnSlide(paramAnonymousInt2);
    }
    
    public void onViewReleased(@NonNull View paramAnonymousView, float paramAnonymousFloat1, float paramAnonymousFloat2)
    {
      int j = 4;
      if (paramAnonymousFloat2 < 0.0F) {
        if (BottomSheetBehavior.this.fitToContents) {
          i = BottomSheetBehavior.this.fitToContentsOffset;
        }
      }
      for (;;)
      {
        j = 3;
        break label333;
        if (paramAnonymousView.getTop() > BottomSheetBehavior.this.halfExpandedOffset)
        {
          i = BottomSheetBehavior.this.halfExpandedOffset;
          j = 6;
          break label333;
        }
        label64:
        i = 0;
        continue;
        if ((BottomSheetBehavior.this.hideable) && (BottomSheetBehavior.this.shouldHide(paramAnonymousView, paramAnonymousFloat2)) && ((paramAnonymousView.getTop() > BottomSheetBehavior.this.collapsedOffset) || (Math.abs(paramAnonymousFloat1) < Math.abs(paramAnonymousFloat2))))
        {
          i = BottomSheetBehavior.this.parentHeight;
          j = 5;
          break label333;
        }
        if ((paramAnonymousFloat2 != 0.0F) && (Math.abs(paramAnonymousFloat1) <= Math.abs(paramAnonymousFloat2)))
        {
          i = BottomSheetBehavior.this.collapsedOffset;
          break label333;
        }
        i = paramAnonymousView.getTop();
        if (!BottomSheetBehavior.this.fitToContents) {
          break label235;
        }
        if (Math.abs(i - BottomSheetBehavior.this.fitToContentsOffset) >= Math.abs(i - BottomSheetBehavior.this.collapsedOffset)) {
          break;
        }
        i = BottomSheetBehavior.this.fitToContentsOffset;
      }
      for (int i = BottomSheetBehavior.this.collapsedOffset;; i = BottomSheetBehavior.this.collapsedOffset)
      {
        break label333;
        label235:
        if (i < BottomSheetBehavior.this.halfExpandedOffset)
        {
          if (i < Math.abs(i - BottomSheetBehavior.this.collapsedOffset)) {
            break label64;
          }
          i = BottomSheetBehavior.this.halfExpandedOffset;
          break;
        }
        if (Math.abs(i - BottomSheetBehavior.this.halfExpandedOffset) < Math.abs(i - BottomSheetBehavior.this.collapsedOffset))
        {
          i = BottomSheetBehavior.this.halfExpandedOffset;
          break;
        }
      }
      label333:
      if (BottomSheetBehavior.this.viewDragHelper.settleCapturedViewAt(paramAnonymousView.getLeft(), i))
      {
        BottomSheetBehavior.this.setStateInternal(2);
        ViewCompat.postOnAnimation(paramAnonymousView, new BottomSheetBehavior.SettleRunnable(BottomSheetBehavior.this, paramAnonymousView, j));
        return;
      }
      BottomSheetBehavior.this.setStateInternal(j);
    }
    
    public boolean tryCaptureView(@NonNull View paramAnonymousView, int paramAnonymousInt)
    {
      if (BottomSheetBehavior.this.state == 1) {
        return false;
      }
      if (BottomSheetBehavior.this.touchingScrollingChild) {
        return false;
      }
      if ((BottomSheetBehavior.this.state == 3) && (BottomSheetBehavior.this.activePointerId == paramAnonymousInt))
      {
        View localView = (View)BottomSheetBehavior.this.nestedScrollingChildRef.get();
        if ((localView != null) && (localView.canScrollVertically(-1))) {
          return false;
        }
      }
      return (BottomSheetBehavior.this.viewRef != null) && (BottomSheetBehavior.this.viewRef.get() == paramAnonymousView);
    }
  };
  private boolean fitToContents = true;
  int fitToContentsOffset;
  int halfExpandedOffset;
  boolean hideable;
  private boolean ignoreEvents;
  private Map<View, Integer> importantForAccessibilityMap;
  private int initialY;
  private int lastNestedScrollDy;
  private int lastPeekHeight;
  private float maximumVelocity;
  private boolean nestedScrolled;
  WeakReference<View> nestedScrollingChildRef;
  int parentHeight;
  private int peekHeight;
  private boolean peekHeightAuto;
  private int peekHeightMin;
  private boolean skipCollapsed;
  int state = 4;
  boolean touchingScrollingChild;
  private VelocityTracker velocityTracker;
  ViewDragHelper viewDragHelper;
  WeakReference<V> viewRef;
  
  public BottomSheetBehavior() {}
  
  public BottomSheetBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.BottomSheetBehavior_Layout);
    TypedValue localTypedValue = paramAttributeSet.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
    if ((localTypedValue != null) && (localTypedValue.data == -1)) {
      setPeekHeight(localTypedValue.data);
    } else {
      setPeekHeight(paramAttributeSet.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
    }
    setHideable(paramAttributeSet.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
    setFitToContents(paramAttributeSet.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
    setSkipCollapsed(paramAttributeSet.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
    paramAttributeSet.recycle();
    this.maximumVelocity = ViewConfiguration.get(paramContext).getScaledMaximumFlingVelocity();
  }
  
  private void calculateCollapsedOffset()
  {
    if (this.fitToContents)
    {
      this.collapsedOffset = Math.max(this.parentHeight - this.lastPeekHeight, this.fitToContentsOffset);
      return;
    }
    this.collapsedOffset = (this.parentHeight - this.lastPeekHeight);
  }
  
  public static <V extends View> BottomSheetBehavior<V> from(V paramV)
  {
    paramV = paramV.getLayoutParams();
    if ((paramV instanceof CoordinatorLayout.LayoutParams))
    {
      paramV = ((CoordinatorLayout.LayoutParams)paramV).getBehavior();
      if ((paramV instanceof BottomSheetBehavior)) {
        return (BottomSheetBehavior)paramV;
      }
      throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }
    throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
  }
  
  private int getExpandedOffset()
  {
    if (this.fitToContents) {
      return this.fitToContentsOffset;
    }
    return 0;
  }
  
  private float getYVelocity()
  {
    if (this.velocityTracker == null) {
      return 0.0F;
    }
    this.velocityTracker.computeCurrentVelocity(1000, this.maximumVelocity);
    return this.velocityTracker.getYVelocity(this.activePointerId);
  }
  
  private void reset()
  {
    this.activePointerId = -1;
    if (this.velocityTracker != null)
    {
      this.velocityTracker.recycle();
      this.velocityTracker = null;
    }
  }
  
  private void updateImportantForAccessibility(boolean paramBoolean)
  {
    if (this.viewRef == null) {
      return;
    }
    Object localObject = ((View)this.viewRef.get()).getParent();
    if (!(localObject instanceof CoordinatorLayout)) {
      return;
    }
    localObject = (CoordinatorLayout)localObject;
    int j = ((CoordinatorLayout)localObject).getChildCount();
    if ((Build.VERSION.SDK_INT >= 16) && (paramBoolean)) {
      if (this.importantForAccessibilityMap == null) {
        this.importantForAccessibilityMap = new HashMap(j);
      } else {
        return;
      }
    }
    int i = 0;
    while (i < j)
    {
      View localView = ((CoordinatorLayout)localObject).getChildAt(i);
      if (localView != this.viewRef.get()) {
        if (!paramBoolean)
        {
          if ((this.importantForAccessibilityMap != null) && (this.importantForAccessibilityMap.containsKey(localView))) {
            ViewCompat.setImportantForAccessibility(localView, ((Integer)this.importantForAccessibilityMap.get(localView)).intValue());
          }
        }
        else
        {
          if (Build.VERSION.SDK_INT >= 16) {
            this.importantForAccessibilityMap.put(localView, Integer.valueOf(localView.getImportantForAccessibility()));
          }
          ViewCompat.setImportantForAccessibility(localView, 4);
        }
      }
      i += 1;
    }
    if (!paramBoolean) {
      this.importantForAccessibilityMap = null;
    }
  }
  
  void dispatchOnSlide(int paramInt)
  {
    View localView = (View)this.viewRef.get();
    if ((localView != null) && (this.callback != null))
    {
      if (paramInt > this.collapsedOffset)
      {
        this.callback.onSlide(localView, (this.collapsedOffset - paramInt) / (this.parentHeight - this.collapsedOffset));
        return;
      }
      this.callback.onSlide(localView, (this.collapsedOffset - paramInt) / (this.collapsedOffset - getExpandedOffset()));
    }
  }
  
  @VisibleForTesting
  View findScrollingChild(View paramView)
  {
    if (ViewCompat.isNestedScrollingEnabled(paramView)) {
      return paramView;
    }
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      int j = paramView.getChildCount();
      while (i < j)
      {
        View localView = findScrollingChild(paramView.getChildAt(i));
        if (localView != null) {
          return localView;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public final int getPeekHeight()
  {
    if (this.peekHeightAuto) {
      return -1;
    }
    return this.peekHeight;
  }
  
  @VisibleForTesting
  int getPeekHeightMin()
  {
    return this.peekHeightMin;
  }
  
  public boolean getSkipCollapsed()
  {
    return this.skipCollapsed;
  }
  
  public final int getState()
  {
    return this.state;
  }
  
  public boolean isFitToContents()
  {
    return this.fitToContents;
  }
  
  public boolean isHideable()
  {
    return this.hideable;
  }
  
  public boolean onInterceptTouchEvent(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    boolean bool1 = paramV.isShown();
    boolean bool2 = false;
    if (!bool1)
    {
      this.ignoreEvents = true;
      return false;
    }
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      reset();
    }
    if (this.velocityTracker == null) {
      this.velocityTracker = VelocityTracker.obtain();
    }
    this.velocityTracker.addMovement(paramMotionEvent);
    Object localObject = null;
    if (i != 3)
    {
      switch (i)
      {
      default: 
        break;
      case 0: 
        int j = (int)paramMotionEvent.getX();
        this.initialY = ((int)paramMotionEvent.getY());
        View localView;
        if (this.nestedScrollingChildRef != null) {
          localView = (View)this.nestedScrollingChildRef.get();
        } else {
          localView = null;
        }
        if ((localView != null) && (paramCoordinatorLayout.isPointInChildBounds(localView, j, this.initialY)))
        {
          this.activePointerId = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
          this.touchingScrollingChild = true;
        }
        if ((this.activePointerId == -1) && (!paramCoordinatorLayout.isPointInChildBounds(paramV, j, this.initialY))) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        this.ignoreEvents = bool1;
        break;
      }
    }
    else
    {
      this.touchingScrollingChild = false;
      this.activePointerId = -1;
      if (this.ignoreEvents)
      {
        this.ignoreEvents = false;
        return false;
      }
    }
    if ((!this.ignoreEvents) && (this.viewDragHelper != null) && (this.viewDragHelper.shouldInterceptTouchEvent(paramMotionEvent))) {
      return true;
    }
    paramV = (V)localObject;
    if (this.nestedScrollingChildRef != null) {
      paramV = (View)this.nestedScrollingChildRef.get();
    }
    bool1 = bool2;
    if (i == 2)
    {
      bool1 = bool2;
      if (paramV != null)
      {
        bool1 = bool2;
        if (!this.ignoreEvents)
        {
          bool1 = bool2;
          if (this.state != 1)
          {
            bool1 = bool2;
            if (!paramCoordinatorLayout.isPointInChildBounds(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
            {
              bool1 = bool2;
              if (this.viewDragHelper != null)
              {
                bool1 = bool2;
                if (Math.abs(this.initialY - paramMotionEvent.getY()) > this.viewDragHelper.getTouchSlop()) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    if ((ViewCompat.getFitsSystemWindows(paramCoordinatorLayout)) && (!ViewCompat.getFitsSystemWindows(paramV))) {
      paramV.setFitsSystemWindows(true);
    }
    int i = paramV.getTop();
    paramCoordinatorLayout.onLayoutChild(paramV, paramInt);
    this.parentHeight = paramCoordinatorLayout.getHeight();
    if (this.peekHeightAuto)
    {
      if (this.peekHeightMin == 0) {
        this.peekHeightMin = paramCoordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
      }
      this.lastPeekHeight = Math.max(this.peekHeightMin, this.parentHeight - paramCoordinatorLayout.getWidth() * 9 / 16);
    }
    else
    {
      this.lastPeekHeight = this.peekHeight;
    }
    this.fitToContentsOffset = Math.max(0, this.parentHeight - paramV.getHeight());
    this.halfExpandedOffset = (this.parentHeight / 2);
    calculateCollapsedOffset();
    if (this.state == 3) {
      ViewCompat.offsetTopAndBottom(paramV, getExpandedOffset());
    } else if (this.state == 6) {
      ViewCompat.offsetTopAndBottom(paramV, this.halfExpandedOffset);
    } else if ((this.hideable) && (this.state == 5)) {
      ViewCompat.offsetTopAndBottom(paramV, this.parentHeight);
    } else if (this.state == 4) {
      ViewCompat.offsetTopAndBottom(paramV, this.collapsedOffset);
    } else if ((this.state == 1) || (this.state == 2)) {
      ViewCompat.offsetTopAndBottom(paramV, i - paramV.getTop());
    }
    if (this.viewDragHelper == null) {
      this.viewDragHelper = ViewDragHelper.create(paramCoordinatorLayout, this.dragCallback);
    }
    this.viewRef = new WeakReference(paramV);
    this.nestedScrollingChildRef = new WeakReference(findScrollingChild(paramV));
    return true;
  }
  
  public boolean onNestedPreFling(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull View paramView, float paramFloat1, float paramFloat2)
  {
    return (paramView == this.nestedScrollingChildRef.get()) && ((this.state != 3) || (super.onNestedPreFling(paramCoordinatorLayout, paramV, paramView, paramFloat1, paramFloat2)));
  }
  
  public void onNestedPreScroll(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull View paramView, int paramInt1, int paramInt2, @NonNull int[] paramArrayOfInt, int paramInt3)
  {
    if (paramInt3 == 1) {
      return;
    }
    if (paramView != (View)this.nestedScrollingChildRef.get()) {
      return;
    }
    paramInt1 = paramV.getTop();
    paramInt3 = paramInt1 - paramInt2;
    if (paramInt2 > 0)
    {
      if (paramInt3 < getExpandedOffset())
      {
        paramArrayOfInt[1] = (paramInt1 - getExpandedOffset());
        ViewCompat.offsetTopAndBottom(paramV, -paramArrayOfInt[1]);
        setStateInternal(3);
      }
      else
      {
        paramArrayOfInt[1] = paramInt2;
        ViewCompat.offsetTopAndBottom(paramV, -paramInt2);
        setStateInternal(1);
      }
    }
    else if ((paramInt2 < 0) && (!paramView.canScrollVertically(-1))) {
      if ((paramInt3 > this.collapsedOffset) && (!this.hideable))
      {
        paramArrayOfInt[1] = (paramInt1 - this.collapsedOffset);
        ViewCompat.offsetTopAndBottom(paramV, -paramArrayOfInt[1]);
        setStateInternal(4);
      }
      else
      {
        paramArrayOfInt[1] = paramInt2;
        ViewCompat.offsetTopAndBottom(paramV, -paramInt2);
        setStateInternal(1);
      }
    }
    dispatchOnSlide(paramV.getTop());
    this.lastNestedScrollDy = paramInt2;
    this.nestedScrolled = true;
  }
  
  public void onRestoreInstanceState(CoordinatorLayout paramCoordinatorLayout, V paramV, Parcelable paramParcelable)
  {
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramCoordinatorLayout, paramV, paramParcelable.getSuperState());
    if ((paramParcelable.state != 1) && (paramParcelable.state != 2))
    {
      this.state = paramParcelable.state;
      return;
    }
    this.state = 4;
  }
  
  public Parcelable onSaveInstanceState(CoordinatorLayout paramCoordinatorLayout, V paramV)
  {
    return new SavedState(super.onSaveInstanceState(paramCoordinatorLayout, paramV), this.state);
  }
  
  public boolean onStartNestedScroll(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull View paramView1, @NonNull View paramView2, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    this.lastNestedScrollDy = 0;
    this.nestedScrolled = false;
    if ((paramInt1 & 0x2) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public void onStopNestedScroll(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull View paramView, int paramInt)
  {
    paramInt = paramV.getTop();
    int j = getExpandedOffset();
    int i = 3;
    if (paramInt == j)
    {
      setStateInternal(3);
      return;
    }
    if (paramView == this.nestedScrollingChildRef.get())
    {
      if (!this.nestedScrolled) {
        return;
      }
      if (this.lastNestedScrollDy > 0)
      {
        paramInt = getExpandedOffset();
      }
      else if ((this.hideable) && (shouldHide(paramV, getYVelocity())))
      {
        paramInt = this.parentHeight;
        i = 5;
      }
      else
      {
        if (this.lastNestedScrollDy == 0)
        {
          paramInt = paramV.getTop();
          if (this.fitToContents)
          {
            if (Math.abs(paramInt - this.fitToContentsOffset) < Math.abs(paramInt - this.collapsedOffset))
            {
              paramInt = this.fitToContentsOffset;
              break label248;
            }
            paramInt = this.collapsedOffset;
          }
          else
          {
            if (paramInt < this.halfExpandedOffset) {
              if (paramInt < Math.abs(paramInt - this.collapsedOffset))
              {
                paramInt = 0;
                break label248;
              }
            }
            for (paramInt = this.halfExpandedOffset;; paramInt = this.halfExpandedOffset)
            {
              i = 6;
              break label248;
              if (Math.abs(paramInt - this.halfExpandedOffset) >= Math.abs(paramInt - this.collapsedOffset)) {
                break;
              }
            }
            paramInt = this.collapsedOffset;
          }
        }
        else
        {
          paramInt = this.collapsedOffset;
        }
        i = 4;
      }
      label248:
      if (this.viewDragHelper.smoothSlideViewTo(paramV, paramV.getLeft(), paramInt))
      {
        setStateInternal(2);
        ViewCompat.postOnAnimation(paramV, new SettleRunnable(paramV, i));
      }
      else
      {
        setStateInternal(i);
      }
      this.nestedScrolled = false;
      return;
    }
  }
  
  public boolean onTouchEvent(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    if (!paramV.isShown()) {
      return false;
    }
    int i = paramMotionEvent.getActionMasked();
    if ((this.state == 1) && (i == 0)) {
      return true;
    }
    if (this.viewDragHelper != null) {
      this.viewDragHelper.processTouchEvent(paramMotionEvent);
    }
    if (i == 0) {
      reset();
    }
    if (this.velocityTracker == null) {
      this.velocityTracker = VelocityTracker.obtain();
    }
    this.velocityTracker.addMovement(paramMotionEvent);
    if ((i == 2) && (!this.ignoreEvents) && (Math.abs(this.initialY - paramMotionEvent.getY()) > this.viewDragHelper.getTouchSlop())) {
      this.viewDragHelper.captureChildView(paramV, paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex()));
    }
    return this.ignoreEvents ^ true;
  }
  
  public void setBottomSheetCallback(BottomSheetCallback paramBottomSheetCallback)
  {
    this.callback = paramBottomSheetCallback;
  }
  
  public void setFitToContents(boolean paramBoolean)
  {
    if (this.fitToContents == paramBoolean) {
      return;
    }
    this.fitToContents = paramBoolean;
    if (this.viewRef != null) {
      calculateCollapsedOffset();
    }
    int i;
    if ((this.fitToContents) && (this.state == 6)) {
      i = 3;
    } else {
      i = this.state;
    }
    setStateInternal(i);
  }
  
  public void setHideable(boolean paramBoolean)
  {
    this.hideable = paramBoolean;
  }
  
  public final void setPeekHeight(int paramInt)
  {
    int i = 1;
    if (paramInt == -1)
    {
      if (!this.peekHeightAuto)
      {
        this.peekHeightAuto = true;
        paramInt = i;
        break label73;
      }
    }
    else {
      if ((this.peekHeightAuto) || (this.peekHeight != paramInt)) {
        break label47;
      }
    }
    paramInt = 0;
    break label73;
    label47:
    this.peekHeightAuto = false;
    this.peekHeight = Math.max(0, paramInt);
    this.collapsedOffset = (this.parentHeight - paramInt);
    paramInt = i;
    label73:
    if ((paramInt != 0) && (this.state == 4) && (this.viewRef != null))
    {
      View localView = (View)this.viewRef.get();
      if (localView != null) {
        localView.requestLayout();
      }
    }
  }
  
  public void setSkipCollapsed(boolean paramBoolean)
  {
    this.skipCollapsed = paramBoolean;
  }
  
  public final void setState(final int paramInt)
  {
    if (paramInt == this.state) {
      return;
    }
    if (this.viewRef == null)
    {
      if ((paramInt == 4) || (paramInt == 3) || (paramInt == 6) || ((this.hideable) && (paramInt == 5))) {
        this.state = paramInt;
      }
      return;
    }
    final View localView = (View)this.viewRef.get();
    if (localView == null) {
      return;
    }
    ViewParent localViewParent = localView.getParent();
    if ((localViewParent != null) && (localViewParent.isLayoutRequested()) && (ViewCompat.isAttachedToWindow(localView)))
    {
      localView.post(new Runnable()
      {
        public void run()
        {
          BottomSheetBehavior.this.startSettlingAnimation(localView, paramInt);
        }
      });
      return;
    }
    startSettlingAnimation(localView, paramInt);
  }
  
  void setStateInternal(int paramInt)
  {
    if (this.state == paramInt) {
      return;
    }
    this.state = paramInt;
    if ((paramInt != 6) && (paramInt != 3))
    {
      if ((paramInt == 5) || (paramInt == 4)) {
        updateImportantForAccessibility(false);
      }
    }
    else {
      updateImportantForAccessibility(true);
    }
    View localView = (View)this.viewRef.get();
    if ((localView != null) && (this.callback != null)) {
      this.callback.onStateChanged(localView, paramInt);
    }
  }
  
  boolean shouldHide(View paramView, float paramFloat)
  {
    if (this.skipCollapsed) {
      return true;
    }
    if (paramView.getTop() < this.collapsedOffset) {
      return false;
    }
    return Math.abs(paramView.getTop() + paramFloat * 0.1F - this.collapsedOffset) / this.peekHeight > 0.5F;
  }
  
  void startSettlingAnimation(View paramView, int paramInt)
  {
    int i;
    if (paramInt == 4)
    {
      i = this.collapsedOffset;
    }
    else if (paramInt == 6)
    {
      i = this.halfExpandedOffset;
      if ((this.fitToContents) && (i <= this.fitToContentsOffset))
      {
        i = this.fitToContentsOffset;
        paramInt = 3;
      }
    }
    else if (paramInt == 3)
    {
      i = getExpandedOffset();
    }
    else
    {
      if ((!this.hideable) || (paramInt != 5)) {
        break label124;
      }
      i = this.parentHeight;
    }
    if (this.viewDragHelper.smoothSlideViewTo(paramView, paramView.getLeft(), i))
    {
      setStateInternal(2);
      ViewCompat.postOnAnimation(paramView, new SettleRunnable(paramView, paramInt));
      return;
    }
    setStateInternal(paramInt);
    return;
    label124:
    paramView = new StringBuilder();
    paramView.append("Illegal state argument: ");
    paramView.append(paramInt);
    throw new IllegalArgumentException(paramView.toString());
  }
  
  public static abstract class BottomSheetCallback
  {
    public abstract void onSlide(@NonNull View paramView, float paramFloat);
    
    public abstract void onStateChanged(@NonNull View paramView, int paramInt);
  }
  
  protected static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
    {
      public BottomSheetBehavior.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new BottomSheetBehavior.SavedState(paramAnonymousParcel, null);
      }
      
      public BottomSheetBehavior.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new BottomSheetBehavior.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }
      
      public BottomSheetBehavior.SavedState[] newArray(int paramAnonymousInt)
      {
        return new BottomSheetBehavior.SavedState[paramAnonymousInt];
      }
    };
    final int state;
    
    public SavedState(Parcel paramParcel)
    {
      this(paramParcel, null);
    }
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.state = paramParcel.readInt();
    }
    
    public SavedState(Parcelable paramParcelable, int paramInt)
    {
      super();
      this.state = paramInt;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.state);
    }
  }
  
  private class SettleRunnable
    implements Runnable
  {
    private final int targetState;
    private final View view;
    
    SettleRunnable(View paramView, int paramInt)
    {
      this.view = paramView;
      this.targetState = paramInt;
    }
    
    public void run()
    {
      if ((BottomSheetBehavior.this.viewDragHelper != null) && (BottomSheetBehavior.this.viewDragHelper.continueSettling(true)))
      {
        ViewCompat.postOnAnimation(this.view, this);
        return;
      }
      BottomSheetBehavior.this.setStateInternal(this.targetState);
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface State {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\widget\BottomSheetBehavior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */