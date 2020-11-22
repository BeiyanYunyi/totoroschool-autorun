package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.VisibleForTesting;
import android.support.design.R.attr;
import android.support.design.R.style;
import android.support.design.R.styleable;
import android.support.design.internal.ThemeEnforcement;
import android.support.v4.math.MathUtils;
import android.support.v4.util.ObjectsCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@CoordinatorLayout.DefaultBehavior(Behavior.class)
public class AppBarLayout
  extends LinearLayout
{
  private static final int INVALID_SCROLL_RANGE = -1;
  static final int PENDING_ACTION_ANIMATE_ENABLED = 4;
  static final int PENDING_ACTION_COLLAPSED = 2;
  static final int PENDING_ACTION_EXPANDED = 1;
  static final int PENDING_ACTION_FORCE = 8;
  static final int PENDING_ACTION_NONE = 0;
  private int downPreScrollRange = -1;
  private int downScrollRange = -1;
  private boolean haveChildWithInterpolator;
  private WindowInsetsCompat lastInsets;
  private boolean liftOnScroll;
  private boolean liftable;
  private boolean liftableOverride;
  private boolean lifted;
  private List<BaseOnOffsetChangedListener> listeners;
  private int pendingAction = 0;
  private int[] tmpStatesArray;
  private int totalScrollRange = -1;
  
  public AppBarLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(1);
    if (Build.VERSION.SDK_INT >= 21)
    {
      ViewUtilsLollipop.setBoundsViewOutlineProvider(this);
      ViewUtilsLollipop.setStateListAnimatorFromAttrs(this, paramAttributeSet, 0, R.style.Widget_Design_AppBarLayout);
    }
    paramContext = ThemeEnforcement.obtainStyledAttributes(paramContext, paramAttributeSet, R.styleable.AppBarLayout, 0, R.style.Widget_Design_AppBarLayout, new int[0]);
    ViewCompat.setBackground(this, paramContext.getDrawable(R.styleable.AppBarLayout_android_background));
    if (paramContext.hasValue(R.styleable.AppBarLayout_expanded)) {
      setExpanded(paramContext.getBoolean(R.styleable.AppBarLayout_expanded, false), false, false);
    }
    if ((Build.VERSION.SDK_INT >= 21) && (paramContext.hasValue(R.styleable.AppBarLayout_elevation))) {
      ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, paramContext.getDimensionPixelSize(R.styleable.AppBarLayout_elevation, 0));
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      if (paramContext.hasValue(R.styleable.AppBarLayout_android_keyboardNavigationCluster)) {
        setKeyboardNavigationCluster(paramContext.getBoolean(R.styleable.AppBarLayout_android_keyboardNavigationCluster, false));
      }
      if (paramContext.hasValue(R.styleable.AppBarLayout_android_touchscreenBlocksFocus)) {
        setTouchscreenBlocksFocus(paramContext.getBoolean(R.styleable.AppBarLayout_android_touchscreenBlocksFocus, false));
      }
    }
    this.liftOnScroll = paramContext.getBoolean(R.styleable.AppBarLayout_liftOnScroll, false);
    paramContext.recycle();
    ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener()
    {
      public WindowInsetsCompat onApplyWindowInsets(View paramAnonymousView, WindowInsetsCompat paramAnonymousWindowInsetsCompat)
      {
        return AppBarLayout.this.onWindowInsetChanged(paramAnonymousWindowInsetsCompat);
      }
    });
  }
  
  private boolean hasCollapsibleChild()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      if (((LayoutParams)getChildAt(i).getLayoutParams()).isCollapsible()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private void invalidateScrollRanges()
  {
    this.totalScrollRange = -1;
    this.downPreScrollRange = -1;
    this.downScrollRange = -1;
  }
  
  private void setExpanded(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i;
    if (paramBoolean1) {
      i = 1;
    } else {
      i = 2;
    }
    int k = 0;
    int j;
    if (paramBoolean2) {
      j = 4;
    } else {
      j = 0;
    }
    if (paramBoolean3) {
      k = 8;
    }
    this.pendingAction = (i | j | k);
    requestLayout();
  }
  
  private boolean setLiftableState(boolean paramBoolean)
  {
    if (this.liftable != paramBoolean)
    {
      this.liftable = paramBoolean;
      refreshDrawableState();
      return true;
    }
    return false;
  }
  
  public void addOnOffsetChangedListener(BaseOnOffsetChangedListener paramBaseOnOffsetChangedListener)
  {
    if (this.listeners == null) {
      this.listeners = new ArrayList();
    }
    if ((paramBaseOnOffsetChangedListener != null) && (!this.listeners.contains(paramBaseOnOffsetChangedListener))) {
      this.listeners.add(paramBaseOnOffsetChangedListener);
    }
  }
  
  public void addOnOffsetChangedListener(OnOffsetChangedListener paramOnOffsetChangedListener)
  {
    addOnOffsetChangedListener(paramOnOffsetChangedListener);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  void dispatchOffsetUpdates(int paramInt)
  {
    if (this.listeners != null)
    {
      int i = 0;
      int j = this.listeners.size();
      while (i < j)
      {
        BaseOnOffsetChangedListener localBaseOnOffsetChangedListener = (BaseOnOffsetChangedListener)this.listeners.get(i);
        if (localBaseOnOffsetChangedListener != null) {
          localBaseOnOffsetChangedListener.onOffsetChanged(this, paramInt);
        }
        i += 1;
      }
    }
  }
  
  protected LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams(-1, -2);
  }
  
  public LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((Build.VERSION.SDK_INT >= 19) && ((paramLayoutParams instanceof LinearLayout.LayoutParams))) {
      return new LayoutParams((LinearLayout.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  int getDownNestedPreScrollRange()
  {
    if (this.downPreScrollRange != -1) {
      return this.downPreScrollRange;
    }
    int j = getChildCount() - 1;
    for (int k = 0; j >= 0; k = i)
    {
      View localView = getChildAt(j);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      i = localView.getMeasuredHeight();
      int m = localLayoutParams.scrollFlags;
      if ((m & 0x5) == 5)
      {
        k += localLayoutParams.topMargin + localLayoutParams.bottomMargin;
        if ((m & 0x8) != 0) {
          i = k + ViewCompat.getMinimumHeight(localView);
        } else if ((m & 0x2) != 0) {
          i = k + (i - ViewCompat.getMinimumHeight(localView));
        } else {
          i = k + (i - getTopInset());
        }
      }
      else
      {
        i = k;
        if (k > 0) {
          break;
        }
      }
      j -= 1;
    }
    int i = Math.max(0, k);
    this.downPreScrollRange = i;
    return i;
  }
  
  int getDownNestedScrollRange()
  {
    if (this.downScrollRange != -1) {
      return this.downScrollRange;
    }
    int m = getChildCount();
    int j = 0;
    int i = 0;
    int k;
    for (;;)
    {
      k = i;
      if (j >= m) {
        break;
      }
      View localView = getChildAt(j);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      int i1 = localView.getMeasuredHeight();
      int i2 = localLayoutParams.topMargin;
      int i3 = localLayoutParams.bottomMargin;
      int n = localLayoutParams.scrollFlags;
      k = i;
      if ((n & 0x1) == 0) {
        break;
      }
      i += i1 + (i2 + i3);
      if ((n & 0x2) != 0)
      {
        k = i - (ViewCompat.getMinimumHeight(localView) + getTopInset());
        break;
      }
      j += 1;
    }
    i = Math.max(0, k);
    this.downScrollRange = i;
    return i;
  }
  
  public final int getMinimumHeightForVisibleOverlappingContent()
  {
    int j = getTopInset();
    int i = ViewCompat.getMinimumHeight(this);
    if (i != 0) {
      return i * 2 + j;
    }
    i = getChildCount();
    if (i >= 1) {
      i = ViewCompat.getMinimumHeight(getChildAt(i - 1));
    } else {
      i = 0;
    }
    if (i != 0) {
      return i * 2 + j;
    }
    return getHeight() / 3;
  }
  
  int getPendingAction()
  {
    return this.pendingAction;
  }
  
  @Deprecated
  public float getTargetElevation()
  {
    return 0.0F;
  }
  
  @VisibleForTesting
  final int getTopInset()
  {
    if (this.lastInsets != null) {
      return this.lastInsets.getSystemWindowInsetTop();
    }
    return 0;
  }
  
  public final int getTotalScrollRange()
  {
    if (this.totalScrollRange != -1) {
      return this.totalScrollRange;
    }
    int m = getChildCount();
    int j = 0;
    int i = 0;
    int k;
    for (;;)
    {
      k = i;
      if (j >= m) {
        break;
      }
      View localView = getChildAt(j);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      int i1 = localView.getMeasuredHeight();
      int n = localLayoutParams.scrollFlags;
      k = i;
      if ((n & 0x1) == 0) {
        break;
      }
      i += i1 + localLayoutParams.topMargin + localLayoutParams.bottomMargin;
      if ((n & 0x2) != 0)
      {
        k = i - ViewCompat.getMinimumHeight(localView);
        break;
      }
      j += 1;
    }
    i = Math.max(0, k - getTopInset());
    this.totalScrollRange = i;
    return i;
  }
  
  int getUpNestedPreScrollRange()
  {
    return getTotalScrollRange();
  }
  
  boolean hasChildWithInterpolator()
  {
    return this.haveChildWithInterpolator;
  }
  
  boolean hasScrollableChildren()
  {
    return getTotalScrollRange() != 0;
  }
  
  public boolean isLiftOnScroll()
  {
    return this.liftOnScroll;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    if (this.tmpStatesArray == null) {
      this.tmpStatesArray = new int[4];
    }
    int[] arrayOfInt1 = this.tmpStatesArray;
    int[] arrayOfInt2 = super.onCreateDrawableState(paramInt + arrayOfInt1.length);
    if (this.liftable) {
      paramInt = R.attr.state_liftable;
    } else {
      paramInt = -R.attr.state_liftable;
    }
    arrayOfInt1[0] = paramInt;
    if ((this.liftable) && (this.lifted)) {
      paramInt = R.attr.state_lifted;
    } else {
      paramInt = -R.attr.state_lifted;
    }
    arrayOfInt1[1] = paramInt;
    if (this.liftable) {
      paramInt = R.attr.state_collapsible;
    } else {
      paramInt = -R.attr.state_collapsible;
    }
    arrayOfInt1[2] = paramInt;
    if ((this.liftable) && (this.lifted)) {
      paramInt = R.attr.state_collapsed;
    } else {
      paramInt = -R.attr.state_collapsed;
    }
    arrayOfInt1[3] = paramInt;
    return mergeDrawableStates(arrayOfInt2, arrayOfInt1);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    invalidateScrollRanges();
    paramBoolean = false;
    this.haveChildWithInterpolator = false;
    paramInt2 = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      if (((LayoutParams)getChildAt(paramInt1).getLayoutParams()).getScrollInterpolator() != null)
      {
        this.haveChildWithInterpolator = true;
        break;
      }
      paramInt1 += 1;
    }
    if (!this.liftableOverride)
    {
      if ((this.liftOnScroll) || (hasCollapsibleChild())) {
        paramBoolean = true;
      }
      setLiftableState(paramBoolean);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    invalidateScrollRanges();
  }
  
  WindowInsetsCompat onWindowInsetChanged(WindowInsetsCompat paramWindowInsetsCompat)
  {
    WindowInsetsCompat localWindowInsetsCompat;
    if (ViewCompat.getFitsSystemWindows(this)) {
      localWindowInsetsCompat = paramWindowInsetsCompat;
    } else {
      localWindowInsetsCompat = null;
    }
    if (!ObjectsCompat.equals(this.lastInsets, localWindowInsetsCompat))
    {
      this.lastInsets = localWindowInsetsCompat;
      invalidateScrollRanges();
    }
    return paramWindowInsetsCompat;
  }
  
  public void removeOnOffsetChangedListener(BaseOnOffsetChangedListener paramBaseOnOffsetChangedListener)
  {
    if ((this.listeners != null) && (paramBaseOnOffsetChangedListener != null)) {
      this.listeners.remove(paramBaseOnOffsetChangedListener);
    }
  }
  
  public void removeOnOffsetChangedListener(OnOffsetChangedListener paramOnOffsetChangedListener)
  {
    removeOnOffsetChangedListener(paramOnOffsetChangedListener);
  }
  
  void resetPendingAction()
  {
    this.pendingAction = 0;
  }
  
  public void setExpanded(boolean paramBoolean)
  {
    setExpanded(paramBoolean, ViewCompat.isLaidOut(this));
  }
  
  public void setExpanded(boolean paramBoolean1, boolean paramBoolean2)
  {
    setExpanded(paramBoolean1, paramBoolean2, true);
  }
  
  public void setLiftOnScroll(boolean paramBoolean)
  {
    this.liftOnScroll = paramBoolean;
  }
  
  public boolean setLiftable(boolean paramBoolean)
  {
    this.liftableOverride = true;
    return setLiftableState(paramBoolean);
  }
  
  public boolean setLifted(boolean paramBoolean)
  {
    return setLiftedState(paramBoolean);
  }
  
  boolean setLiftedState(boolean paramBoolean)
  {
    if (this.lifted != paramBoolean)
    {
      this.lifted = paramBoolean;
      refreshDrawableState();
      return true;
    }
    return false;
  }
  
  public void setOrientation(int paramInt)
  {
    if (paramInt == 1)
    {
      super.setOrientation(paramInt);
      return;
    }
    throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
  }
  
  @Deprecated
  public void setTargetElevation(float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, paramFloat);
    }
  }
  
  protected static class BaseBehavior<T extends AppBarLayout>
    extends HeaderBehavior<T>
  {
    private static final int INVALID_POSITION = -1;
    private static final int MAX_OFFSET_ANIMATION_DURATION = 600;
    private WeakReference<View> lastNestedScrollingChildRef;
    private int lastStartedType;
    private ValueAnimator offsetAnimator;
    private int offsetDelta;
    private int offsetToChildIndexOnLayout = -1;
    private boolean offsetToChildIndexOnLayoutIsMinHeight;
    private float offsetToChildIndexOnLayoutPerc;
    private BaseDragCallback onDragCallback;
    
    public BaseBehavior() {}
    
    public BaseBehavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    private void animateOffsetTo(CoordinatorLayout paramCoordinatorLayout, T paramT, int paramInt, float paramFloat)
    {
      int i = Math.abs(getTopBottomOffsetForScrollingSibling() - paramInt);
      paramFloat = Math.abs(paramFloat);
      if (paramFloat > 0.0F) {
        i = Math.round(i / paramFloat * 1000.0F) * 3;
      } else {
        i = (int)((i / paramT.getHeight() + 1.0F) * 150.0F);
      }
      animateOffsetWithDuration(paramCoordinatorLayout, paramT, paramInt, i);
    }
    
    private void animateOffsetWithDuration(final CoordinatorLayout paramCoordinatorLayout, final T paramT, int paramInt1, int paramInt2)
    {
      int i = getTopBottomOffsetForScrollingSibling();
      if (i == paramInt1)
      {
        if ((this.offsetAnimator != null) && (this.offsetAnimator.isRunning())) {
          this.offsetAnimator.cancel();
        }
        return;
      }
      if (this.offsetAnimator == null)
      {
        this.offsetAnimator = new ValueAnimator();
        this.offsetAnimator.setInterpolator(android.support.design.animation.AnimationUtils.DECELERATE_INTERPOLATOR);
        this.offsetAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppBarLayout.BaseBehavior.this.setHeaderTopBottomOffset(paramCoordinatorLayout, paramT, ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue());
          }
        });
      }
      else
      {
        this.offsetAnimator.cancel();
      }
      this.offsetAnimator.setDuration(Math.min(paramInt2, 600));
      this.offsetAnimator.setIntValues(new int[] { i, paramInt1 });
      this.offsetAnimator.start();
    }
    
    private boolean canScrollChildren(CoordinatorLayout paramCoordinatorLayout, T paramT, View paramView)
    {
      return (paramT.hasScrollableChildren()) && (paramCoordinatorLayout.getHeight() - paramView.getHeight() <= paramT.getHeight());
    }
    
    private static boolean checkFlag(int paramInt1, int paramInt2)
    {
      return (paramInt1 & paramInt2) == paramInt2;
    }
    
    @Nullable
    private View findFirstScrollingChild(CoordinatorLayout paramCoordinatorLayout)
    {
      int j = paramCoordinatorLayout.getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = paramCoordinatorLayout.getChildAt(i);
        if ((localView instanceof NestedScrollingChild)) {
          return localView;
        }
        i += 1;
      }
      return null;
    }
    
    private static View getAppBarChildOnOffset(AppBarLayout paramAppBarLayout, int paramInt)
    {
      int i = Math.abs(paramInt);
      int j = paramAppBarLayout.getChildCount();
      paramInt = 0;
      while (paramInt < j)
      {
        View localView = paramAppBarLayout.getChildAt(paramInt);
        if ((i >= localView.getTop()) && (i <= localView.getBottom())) {
          return localView;
        }
        paramInt += 1;
      }
      return null;
    }
    
    private int getChildIndexOnOffset(T paramT, int paramInt)
    {
      int i1 = paramT.getChildCount();
      int i = 0;
      while (i < i1)
      {
        Object localObject = paramT.getChildAt(i);
        int n = ((View)localObject).getTop();
        int m = ((View)localObject).getBottom();
        localObject = (AppBarLayout.LayoutParams)((View)localObject).getLayoutParams();
        int k = n;
        int j = m;
        if (checkFlag(((AppBarLayout.LayoutParams)localObject).getScrollFlags(), 32))
        {
          k = n - ((AppBarLayout.LayoutParams)localObject).topMargin;
          j = m + ((AppBarLayout.LayoutParams)localObject).bottomMargin;
        }
        m = -paramInt;
        if ((k <= m) && (j >= m)) {
          return i;
        }
        i += 1;
      }
      return -1;
    }
    
    private int interpolateOffset(T paramT, int paramInt)
    {
      int k = Math.abs(paramInt);
      int m = paramT.getChildCount();
      int j = 0;
      int i = 0;
      while (i < m)
      {
        View localView = paramT.getChildAt(i);
        AppBarLayout.LayoutParams localLayoutParams = (AppBarLayout.LayoutParams)localView.getLayoutParams();
        Interpolator localInterpolator = localLayoutParams.getScrollInterpolator();
        if ((k >= localView.getTop()) && (k <= localView.getBottom()))
        {
          if (localInterpolator == null) {
            break;
          }
          m = localLayoutParams.getScrollFlags();
          i = j;
          if ((m & 0x1) != 0)
          {
            j = 0 + (localView.getHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin);
            i = j;
            if ((m & 0x2) != 0) {
              i = j - ViewCompat.getMinimumHeight(localView);
            }
          }
          j = i;
          if (ViewCompat.getFitsSystemWindows(localView)) {
            j = i - paramT.getTopInset();
          }
          if (j <= 0) {
            break;
          }
          i = localView.getTop();
          float f = j;
          i = Math.round(f * localInterpolator.getInterpolation((k - i) / f));
          return Integer.signum(paramInt) * (localView.getTop() + i);
        }
        i += 1;
      }
      return paramInt;
    }
    
    private boolean shouldJumpElevationState(CoordinatorLayout paramCoordinatorLayout, T paramT)
    {
      paramCoordinatorLayout = paramCoordinatorLayout.getDependents(paramT);
      int j = paramCoordinatorLayout.size();
      boolean bool = false;
      int i = 0;
      while (i < j)
      {
        paramT = ((CoordinatorLayout.LayoutParams)((View)paramCoordinatorLayout.get(i)).getLayoutParams()).getBehavior();
        if ((paramT instanceof AppBarLayout.ScrollingViewBehavior))
        {
          if (((AppBarLayout.ScrollingViewBehavior)paramT).getOverlayTop() != 0) {
            bool = true;
          }
          return bool;
        }
        i += 1;
      }
      return false;
    }
    
    private void snapToChildIfNeeded(CoordinatorLayout paramCoordinatorLayout, T paramT)
    {
      int n = getTopBottomOffsetForScrollingSibling();
      int k = getChildIndexOnOffset(paramT, n);
      if (k >= 0)
      {
        View localView = paramT.getChildAt(k);
        AppBarLayout.LayoutParams localLayoutParams = (AppBarLayout.LayoutParams)localView.getLayoutParams();
        int i1 = localLayoutParams.getScrollFlags();
        if ((i1 & 0x11) == 17)
        {
          int m = -localView.getTop();
          int i = -localView.getBottom();
          int j = i;
          if (k == paramT.getChildCount() - 1) {
            j = i + paramT.getTopInset();
          }
          if (checkFlag(i1, 2))
          {
            i = j + ViewCompat.getMinimumHeight(localView);
            k = m;
          }
          else
          {
            k = m;
            i = j;
            if (checkFlag(i1, 5))
            {
              i = ViewCompat.getMinimumHeight(localView) + j;
              if (n < i)
              {
                k = i;
                i = j;
              }
              else
              {
                k = m;
              }
            }
          }
          m = k;
          j = i;
          if (checkFlag(i1, 32))
          {
            m = k + localLayoutParams.topMargin;
            j = i - localLayoutParams.bottomMargin;
          }
          i = m;
          if (n < (j + m) / 2) {
            i = j;
          }
          animateOffsetTo(paramCoordinatorLayout, paramT, MathUtils.clamp(i, -paramT.getTotalScrollRange(), 0), 0.0F);
        }
      }
    }
    
    private void stopNestedScrollIfNeeded(int paramInt1, T paramT, View paramView, int paramInt2)
    {
      if (paramInt2 == 1)
      {
        paramInt2 = getTopBottomOffsetForScrollingSibling();
        if (((paramInt1 < 0) && (paramInt2 == 0)) || ((paramInt1 > 0) && (paramInt2 == -paramT.getDownNestedScrollRange()))) {
          ViewCompat.stopNestedScroll(paramView, 1);
        }
      }
    }
    
    private void updateAppBarLayoutDrawableState(CoordinatorLayout paramCoordinatorLayout, T paramT, int paramInt1, int paramInt2, boolean paramBoolean)
    {
      View localView = getAppBarChildOnOffset(paramT, paramInt1);
      if (localView != null)
      {
        int i = ((AppBarLayout.LayoutParams)localView.getLayoutParams()).getScrollFlags();
        if ((i & 0x1) != 0)
        {
          int j = ViewCompat.getMinimumHeight(localView);
          if ((paramInt2 > 0) && ((i & 0xC) != 0))
          {
            if (-paramInt1 < localView.getBottom() - j - paramT.getTopInset()) {}
          }
          else {
            while (((i & 0x2) != 0) && (-paramInt1 >= localView.getBottom() - j - paramT.getTopInset()))
            {
              bool1 = true;
              break;
            }
          }
        }
        boolean bool1 = false;
        boolean bool2 = bool1;
        if (paramT.isLiftOnScroll())
        {
          localView = findFirstScrollingChild(paramCoordinatorLayout);
          bool2 = bool1;
          if (localView != null) {
            if (localView.getScrollY() > 0) {
              bool2 = true;
            } else {
              bool2 = false;
            }
          }
        }
        bool1 = paramT.setLiftedState(bool2);
        if ((Build.VERSION.SDK_INT >= 11) && ((paramBoolean) || ((bool1) && (shouldJumpElevationState(paramCoordinatorLayout, paramT))))) {
          paramT.jumpDrawablesToCurrentState();
        }
      }
    }
    
    boolean canDragView(T paramT)
    {
      if (this.onDragCallback != null) {
        return this.onDragCallback.canDrag(paramT);
      }
      if (this.lastNestedScrollingChildRef != null)
      {
        paramT = (View)this.lastNestedScrollingChildRef.get();
        return (paramT != null) && (paramT.isShown()) && (!paramT.canScrollVertically(-1));
      }
      return true;
    }
    
    int getMaxDragOffset(T paramT)
    {
      return -paramT.getDownNestedScrollRange();
    }
    
    int getScrollRangeForDragFling(T paramT)
    {
      return paramT.getTotalScrollRange();
    }
    
    int getTopBottomOffsetForScrollingSibling()
    {
      return getTopAndBottomOffset() + this.offsetDelta;
    }
    
    @VisibleForTesting
    boolean isOffsetAnimatorRunning()
    {
      return (this.offsetAnimator != null) && (this.offsetAnimator.isRunning());
    }
    
    void onFlingFinished(CoordinatorLayout paramCoordinatorLayout, T paramT)
    {
      snapToChildIfNeeded(paramCoordinatorLayout, paramT);
    }
    
    public boolean onLayoutChild(CoordinatorLayout paramCoordinatorLayout, T paramT, int paramInt)
    {
      boolean bool = super.onLayoutChild(paramCoordinatorLayout, paramT, paramInt);
      int i = paramT.getPendingAction();
      if ((this.offsetToChildIndexOnLayout >= 0) && ((i & 0x8) == 0))
      {
        View localView = paramT.getChildAt(this.offsetToChildIndexOnLayout);
        paramInt = -localView.getBottom();
        if (this.offsetToChildIndexOnLayoutIsMinHeight) {
          paramInt += ViewCompat.getMinimumHeight(localView) + paramT.getTopInset();
        } else {
          paramInt += Math.round(localView.getHeight() * this.offsetToChildIndexOnLayoutPerc);
        }
        setHeaderTopBottomOffset(paramCoordinatorLayout, paramT, paramInt);
      }
      else if (i != 0)
      {
        if ((i & 0x4) != 0) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
        if ((i & 0x2) != 0)
        {
          i = -paramT.getUpNestedPreScrollRange();
          if (paramInt != 0) {
            animateOffsetTo(paramCoordinatorLayout, paramT, i, 0.0F);
          } else {
            setHeaderTopBottomOffset(paramCoordinatorLayout, paramT, i);
          }
        }
        else if ((i & 0x1) != 0)
        {
          if (paramInt != 0) {
            animateOffsetTo(paramCoordinatorLayout, paramT, 0, 0.0F);
          } else {
            setHeaderTopBottomOffset(paramCoordinatorLayout, paramT, 0);
          }
        }
      }
      paramT.resetPendingAction();
      this.offsetToChildIndexOnLayout = -1;
      setTopAndBottomOffset(MathUtils.clamp(getTopAndBottomOffset(), -paramT.getTotalScrollRange(), 0));
      updateAppBarLayoutDrawableState(paramCoordinatorLayout, paramT, getTopAndBottomOffset(), 0, true);
      paramT.dispatchOffsetUpdates(getTopAndBottomOffset());
      return bool;
    }
    
    public boolean onMeasureChild(CoordinatorLayout paramCoordinatorLayout, T paramT, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (((CoordinatorLayout.LayoutParams)paramT.getLayoutParams()).height == -2)
      {
        paramCoordinatorLayout.onMeasureChild(paramT, paramInt1, paramInt2, View.MeasureSpec.makeMeasureSpec(0, 0), paramInt4);
        return true;
      }
      return super.onMeasureChild(paramCoordinatorLayout, paramT, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    public void onNestedPreScroll(CoordinatorLayout paramCoordinatorLayout, T paramT, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
    {
      if (paramInt2 != 0)
      {
        int i;
        if (paramInt2 < 0)
        {
          i = -paramT.getTotalScrollRange();
          int j = paramT.getDownNestedPreScrollRange();
          paramInt1 = i;
          i = j + i;
        }
        else
        {
          paramInt1 = -paramT.getUpNestedPreScrollRange();
          i = 0;
        }
        if (paramInt1 != i)
        {
          paramArrayOfInt[1] = scroll(paramCoordinatorLayout, paramT, paramInt2, paramInt1, i);
          stopNestedScrollIfNeeded(paramInt2, paramT, paramView, paramInt3);
        }
      }
    }
    
    public void onNestedScroll(CoordinatorLayout paramCoordinatorLayout, T paramT, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      if (paramInt4 < 0)
      {
        scroll(paramCoordinatorLayout, paramT, paramInt4, -paramT.getDownNestedScrollRange(), 0);
        stopNestedScrollIfNeeded(paramInt4, paramT, paramView, paramInt5);
      }
      if (paramT.isLiftOnScroll())
      {
        boolean bool;
        if (paramView.getScrollY() > 0) {
          bool = true;
        } else {
          bool = false;
        }
        paramT.setLiftedState(bool);
      }
    }
    
    public void onRestoreInstanceState(CoordinatorLayout paramCoordinatorLayout, T paramT, Parcelable paramParcelable)
    {
      if ((paramParcelable instanceof SavedState))
      {
        paramParcelable = (SavedState)paramParcelable;
        super.onRestoreInstanceState(paramCoordinatorLayout, paramT, paramParcelable.getSuperState());
        this.offsetToChildIndexOnLayout = paramParcelable.firstVisibleChildIndex;
        this.offsetToChildIndexOnLayoutPerc = paramParcelable.firstVisibleChildPercentageShown;
        this.offsetToChildIndexOnLayoutIsMinHeight = paramParcelable.firstVisibleChildAtMinimumHeight;
        return;
      }
      super.onRestoreInstanceState(paramCoordinatorLayout, paramT, paramParcelable);
      this.offsetToChildIndexOnLayout = -1;
    }
    
    public Parcelable onSaveInstanceState(CoordinatorLayout paramCoordinatorLayout, T paramT)
    {
      Object localObject = super.onSaveInstanceState(paramCoordinatorLayout, paramT);
      int j = getTopAndBottomOffset();
      int k = paramT.getChildCount();
      boolean bool = false;
      int i = 0;
      while (i < k)
      {
        paramCoordinatorLayout = paramT.getChildAt(i);
        int m = paramCoordinatorLayout.getBottom() + j;
        if ((paramCoordinatorLayout.getTop() + j <= 0) && (m >= 0))
        {
          localObject = new SavedState((Parcelable)localObject);
          ((SavedState)localObject).firstVisibleChildIndex = i;
          if (m == ViewCompat.getMinimumHeight(paramCoordinatorLayout) + paramT.getTopInset()) {
            bool = true;
          }
          ((SavedState)localObject).firstVisibleChildAtMinimumHeight = bool;
          ((SavedState)localObject).firstVisibleChildPercentageShown = (m / paramCoordinatorLayout.getHeight());
          return (Parcelable)localObject;
        }
        i += 1;
      }
      return (Parcelable)localObject;
    }
    
    public boolean onStartNestedScroll(CoordinatorLayout paramCoordinatorLayout, T paramT, View paramView1, View paramView2, int paramInt1, int paramInt2)
    {
      boolean bool;
      if (((paramInt1 & 0x2) != 0) && ((paramT.isLiftOnScroll()) || (canScrollChildren(paramCoordinatorLayout, paramT, paramView1)))) {
        bool = true;
      } else {
        bool = false;
      }
      if ((bool) && (this.offsetAnimator != null)) {
        this.offsetAnimator.cancel();
      }
      this.lastNestedScrollingChildRef = null;
      this.lastStartedType = paramInt2;
      return bool;
    }
    
    public void onStopNestedScroll(CoordinatorLayout paramCoordinatorLayout, T paramT, View paramView, int paramInt)
    {
      if ((this.lastStartedType == 0) || (paramInt == 1)) {
        snapToChildIfNeeded(paramCoordinatorLayout, paramT);
      }
      this.lastNestedScrollingChildRef = new WeakReference(paramView);
    }
    
    public void setDragCallback(@Nullable BaseDragCallback paramBaseDragCallback)
    {
      this.onDragCallback = paramBaseDragCallback;
    }
    
    int setHeaderTopBottomOffset(CoordinatorLayout paramCoordinatorLayout, T paramT, int paramInt1, int paramInt2, int paramInt3)
    {
      int i = getTopBottomOffsetForScrollingSibling();
      if ((paramInt2 != 0) && (i >= paramInt2) && (i <= paramInt3))
      {
        paramInt2 = MathUtils.clamp(paramInt1, paramInt2, paramInt3);
        if (i != paramInt2)
        {
          if (paramT.hasChildWithInterpolator()) {
            paramInt1 = interpolateOffset(paramT, paramInt2);
          } else {
            paramInt1 = paramInt2;
          }
          boolean bool = setTopAndBottomOffset(paramInt1);
          this.offsetDelta = (paramInt2 - paramInt1);
          if ((!bool) && (paramT.hasChildWithInterpolator())) {
            paramCoordinatorLayout.dispatchDependentViewsChanged(paramT);
          }
          paramT.dispatchOffsetUpdates(getTopAndBottomOffset());
          if (paramInt2 < i) {
            paramInt1 = -1;
          } else {
            paramInt1 = 1;
          }
          updateAppBarLayoutDrawableState(paramCoordinatorLayout, paramT, paramInt2, paramInt1, false);
          return i - paramInt2;
        }
      }
      else
      {
        this.offsetDelta = 0;
      }
      return 0;
    }
    
    public static abstract class BaseDragCallback<T extends AppBarLayout>
    {
      public abstract boolean canDrag(@NonNull T paramT);
    }
    
    protected static class SavedState
      extends AbsSavedState
    {
      public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
      {
        public AppBarLayout.BaseBehavior.SavedState createFromParcel(Parcel paramAnonymousParcel)
        {
          return new AppBarLayout.BaseBehavior.SavedState(paramAnonymousParcel, null);
        }
        
        public AppBarLayout.BaseBehavior.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
        {
          return new AppBarLayout.BaseBehavior.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
        }
        
        public AppBarLayout.BaseBehavior.SavedState[] newArray(int paramAnonymousInt)
        {
          return new AppBarLayout.BaseBehavior.SavedState[paramAnonymousInt];
        }
      };
      boolean firstVisibleChildAtMinimumHeight;
      int firstVisibleChildIndex;
      float firstVisibleChildPercentageShown;
      
      public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
      {
        super(paramClassLoader);
        this.firstVisibleChildIndex = paramParcel.readInt();
        this.firstVisibleChildPercentageShown = paramParcel.readFloat();
        boolean bool;
        if (paramParcel.readByte() != 0) {
          bool = true;
        } else {
          bool = false;
        }
        this.firstVisibleChildAtMinimumHeight = bool;
      }
      
      public SavedState(Parcelable paramParcelable)
      {
        super();
      }
      
      public void writeToParcel(Parcel paramParcel, int paramInt)
      {
        super.writeToParcel(paramParcel, paramInt);
        paramParcel.writeInt(this.firstVisibleChildIndex);
        paramParcel.writeFloat(this.firstVisibleChildPercentageShown);
        paramParcel.writeByte((byte)this.firstVisibleChildAtMinimumHeight);
      }
    }
  }
  
  public static abstract interface BaseOnOffsetChangedListener<T extends AppBarLayout>
  {
    public abstract void onOffsetChanged(T paramT, int paramInt);
  }
  
  public static class Behavior
    extends AppBarLayout.BaseBehavior<AppBarLayout>
  {
    public Behavior() {}
    
    public Behavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public static abstract class DragCallback
      extends AppBarLayout.BaseBehavior.BaseDragCallback<AppBarLayout>
    {}
  }
  
  public static class LayoutParams
    extends LinearLayout.LayoutParams
  {
    static final int COLLAPSIBLE_FLAGS = 10;
    static final int FLAG_QUICK_RETURN = 5;
    static final int FLAG_SNAP = 17;
    public static final int SCROLL_FLAG_ENTER_ALWAYS = 4;
    public static final int SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED = 8;
    public static final int SCROLL_FLAG_EXIT_UNTIL_COLLAPSED = 2;
    public static final int SCROLL_FLAG_SCROLL = 1;
    public static final int SCROLL_FLAG_SNAP = 16;
    public static final int SCROLL_FLAG_SNAP_MARGINS = 32;
    int scrollFlags = 1;
    Interpolator scrollInterpolator;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(int paramInt1, int paramInt2, float paramFloat)
    {
      super(paramInt2, paramFloat);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.AppBarLayout_Layout);
      this.scrollFlags = paramAttributeSet.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
      if (paramAttributeSet.hasValue(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator)) {
        this.scrollInterpolator = android.view.animation.AnimationUtils.loadInterpolator(paramContext, paramAttributeSet.getResourceId(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
      }
      paramAttributeSet.recycle();
    }
    
    @RequiresApi(19)
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.scrollFlags = paramLayoutParams.scrollFlags;
      this.scrollInterpolator = paramLayoutParams.scrollInterpolator;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    @RequiresApi(19)
    public LayoutParams(LinearLayout.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public int getScrollFlags()
    {
      return this.scrollFlags;
    }
    
    public Interpolator getScrollInterpolator()
    {
      return this.scrollInterpolator;
    }
    
    boolean isCollapsible()
    {
      return ((this.scrollFlags & 0x1) == 1) && ((this.scrollFlags & 0xA) != 0);
    }
    
    public void setScrollFlags(int paramInt)
    {
      this.scrollFlags = paramInt;
    }
    
    public void setScrollInterpolator(Interpolator paramInterpolator)
    {
      this.scrollInterpolator = paramInterpolator;
    }
    
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static @interface ScrollFlags {}
  }
  
  public static abstract interface OnOffsetChangedListener
    extends AppBarLayout.BaseOnOffsetChangedListener<AppBarLayout>
  {
    public abstract void onOffsetChanged(AppBarLayout paramAppBarLayout, int paramInt);
  }
  
  public static class ScrollingViewBehavior
    extends HeaderScrollingViewBehavior
  {
    public ScrollingViewBehavior() {}
    
    public ScrollingViewBehavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ScrollingViewBehavior_Layout);
      setOverlayTop(paramContext.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
      paramContext.recycle();
    }
    
    private static int getAppBarLayoutOffset(AppBarLayout paramAppBarLayout)
    {
      paramAppBarLayout = ((CoordinatorLayout.LayoutParams)paramAppBarLayout.getLayoutParams()).getBehavior();
      if ((paramAppBarLayout instanceof AppBarLayout.BaseBehavior)) {
        return ((AppBarLayout.BaseBehavior)paramAppBarLayout).getTopBottomOffsetForScrollingSibling();
      }
      return 0;
    }
    
    private void offsetChildAsNeeded(View paramView1, View paramView2)
    {
      Object localObject = ((CoordinatorLayout.LayoutParams)paramView2.getLayoutParams()).getBehavior();
      if ((localObject instanceof AppBarLayout.BaseBehavior))
      {
        localObject = (AppBarLayout.BaseBehavior)localObject;
        ViewCompat.offsetTopAndBottom(paramView1, paramView2.getBottom() - paramView1.getTop() + ((AppBarLayout.BaseBehavior)localObject).offsetDelta + getVerticalLayoutGap() - getOverlapPixelsForOffset(paramView2));
      }
    }
    
    private void updateLiftedStateIfNeeded(View paramView1, View paramView2)
    {
      if ((paramView2 instanceof AppBarLayout))
      {
        paramView2 = (AppBarLayout)paramView2;
        if (paramView2.isLiftOnScroll())
        {
          boolean bool;
          if (paramView1.getScrollY() > 0) {
            bool = true;
          } else {
            bool = false;
          }
          paramView2.setLiftedState(bool);
        }
      }
    }
    
    AppBarLayout findFirstDependency(List<View> paramList)
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        View localView = (View)paramList.get(i);
        if ((localView instanceof AppBarLayout)) {
          return (AppBarLayout)localView;
        }
        i += 1;
      }
      return null;
    }
    
    float getOverlapRatioForOffset(View paramView)
    {
      if ((paramView instanceof AppBarLayout))
      {
        paramView = (AppBarLayout)paramView;
        int j = paramView.getTotalScrollRange();
        int k = paramView.getDownNestedPreScrollRange();
        int i = getAppBarLayoutOffset(paramView);
        if ((k != 0) && (j + i <= k)) {
          return 0.0F;
        }
        j -= k;
        if (j != 0) {
          return i / j + 1.0F;
        }
      }
      return 0.0F;
    }
    
    int getScrollRange(View paramView)
    {
      if ((paramView instanceof AppBarLayout)) {
        return ((AppBarLayout)paramView).getTotalScrollRange();
      }
      return super.getScrollRange(paramView);
    }
    
    public boolean layoutDependsOn(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
    {
      return paramView2 instanceof AppBarLayout;
    }
    
    public boolean onDependentViewChanged(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
    {
      offsetChildAsNeeded(paramView1, paramView2);
      updateLiftedStateIfNeeded(paramView1, paramView2);
      return false;
    }
    
    public boolean onRequestChildRectangleOnScreen(CoordinatorLayout paramCoordinatorLayout, View paramView, Rect paramRect, boolean paramBoolean)
    {
      AppBarLayout localAppBarLayout = findFirstDependency(paramCoordinatorLayout.getDependencies(paramView));
      if (localAppBarLayout != null)
      {
        paramRect.offset(paramView.getLeft(), paramView.getTop());
        paramView = this.tempRect1;
        paramView.set(0, 0, paramCoordinatorLayout.getWidth(), paramCoordinatorLayout.getHeight());
        if (!paramView.contains(paramRect))
        {
          localAppBarLayout.setExpanded(false, paramBoolean ^ true);
          return true;
        }
      }
      return false;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\widget\AppBarLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */