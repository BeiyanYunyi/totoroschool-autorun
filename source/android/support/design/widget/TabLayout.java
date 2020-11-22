package android.support.design.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.annotation.BoolRes;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.Dimension;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.StringRes;
import android.support.design.R.attr;
import android.support.design.R.dimen;
import android.support.design.R.layout;
import android.support.design.R.style;
import android.support.design.animation.AnimationUtils;
import android.support.design.internal.ThemeEnforcement;
import android.support.design.internal.ViewUtils;
import android.support.design.resources.MaterialResources;
import android.support.design.ripple.RippleUtils;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;
import android.support.v4.util.Pools.SynchronizedPool;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.DecorView;
import android.support.v4.view.ViewPager.OnAdapterChangeListener;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.widget.TooltipCompat;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@ViewPager.DecorView
public class TabLayout
  extends HorizontalScrollView
{
  private static final int ANIMATION_DURATION = 300;
  @Dimension(unit=0)
  static final int DEFAULT_GAP_TEXT_ICON = 8;
  @Dimension(unit=0)
  private static final int DEFAULT_HEIGHT = 48;
  @Dimension(unit=0)
  private static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;
  @Dimension(unit=0)
  static final int FIXED_WRAP_GUTTER_MIN = 16;
  public static final int GRAVITY_CENTER = 1;
  public static final int GRAVITY_FILL = 0;
  public static final int INDICATOR_GRAVITY_BOTTOM = 0;
  public static final int INDICATOR_GRAVITY_CENTER = 1;
  public static final int INDICATOR_GRAVITY_STRETCH = 3;
  public static final int INDICATOR_GRAVITY_TOP = 2;
  private static final int INVALID_WIDTH = -1;
  @Dimension(unit=0)
  private static final int MIN_INDICATOR_WIDTH = 24;
  public static final int MODE_FIXED = 1;
  public static final int MODE_SCROLLABLE = 0;
  @Dimension(unit=0)
  private static final int TAB_MIN_WIDTH_MARGIN = 56;
  private static final Pools.Pool<Tab> tabPool = new Pools.SynchronizedPool(16);
  private AdapterChangeListener adapterChangeListener;
  private int contentInsetStart;
  private BaseOnTabSelectedListener currentVpSelectedListener;
  boolean inlineLabel;
  int mode;
  private TabLayoutOnPageChangeListener pageChangeListener;
  private PagerAdapter pagerAdapter;
  private DataSetObserver pagerAdapterObserver;
  private final int requestedTabMaxWidth;
  private final int requestedTabMinWidth;
  private ValueAnimator scrollAnimator;
  private final int scrollableTabMinWidth;
  private BaseOnTabSelectedListener selectedListener;
  private final ArrayList<BaseOnTabSelectedListener> selectedListeners = new ArrayList();
  private Tab selectedTab;
  private boolean setupViewPagerImplicitly;
  private final SlidingTabIndicator slidingTabIndicator;
  final int tabBackgroundResId;
  int tabGravity;
  ColorStateList tabIconTint;
  PorterDuff.Mode tabIconTintMode;
  int tabIndicatorAnimationDuration;
  boolean tabIndicatorFullWidth;
  int tabIndicatorGravity;
  int tabMaxWidth = Integer.MAX_VALUE;
  int tabPaddingBottom;
  int tabPaddingEnd;
  int tabPaddingStart;
  int tabPaddingTop;
  ColorStateList tabRippleColorStateList;
  @Nullable
  Drawable tabSelectedIndicator;
  int tabTextAppearance;
  ColorStateList tabTextColors;
  float tabTextMultiLineSize;
  float tabTextSize;
  private final RectF tabViewContentBounds = new RectF();
  private final Pools.Pool<TabView> tabViewPool = new Pools.SimplePool(12);
  private final ArrayList<Tab> tabs = new ArrayList();
  boolean unboundedRipple;
  ViewPager viewPager;
  
  public TabLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.tabStyle);
  }
  
  public TabLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setHorizontalScrollBarEnabled(false);
    this.slidingTabIndicator = new SlidingTabIndicator(paramContext);
    super.addView(this.slidingTabIndicator, 0, new FrameLayout.LayoutParams(-2, -1));
    TypedArray localTypedArray = ThemeEnforcement.obtainStyledAttributes(paramContext, paramAttributeSet, android.support.design.R.styleable.TabLayout, paramInt, R.style.Widget_Design_TabLayout, new int[] { android.support.design.R.styleable.TabLayout_tabTextAppearance });
    this.slidingTabIndicator.setSelectedIndicatorHeight(localTypedArray.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabIndicatorHeight, -1));
    this.slidingTabIndicator.setSelectedIndicatorColor(localTypedArray.getColor(android.support.design.R.styleable.TabLayout_tabIndicatorColor, 0));
    setSelectedTabIndicator(MaterialResources.getDrawable(paramContext, localTypedArray, android.support.design.R.styleable.TabLayout_tabIndicator));
    setSelectedTabIndicatorGravity(localTypedArray.getInt(android.support.design.R.styleable.TabLayout_tabIndicatorGravity, 0));
    setTabIndicatorFullWidth(localTypedArray.getBoolean(android.support.design.R.styleable.TabLayout_tabIndicatorFullWidth, true));
    paramInt = localTypedArray.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabPadding, 0);
    this.tabPaddingBottom = paramInt;
    this.tabPaddingEnd = paramInt;
    this.tabPaddingTop = paramInt;
    this.tabPaddingStart = paramInt;
    this.tabPaddingStart = localTypedArray.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabPaddingStart, this.tabPaddingStart);
    this.tabPaddingTop = localTypedArray.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabPaddingTop, this.tabPaddingTop);
    this.tabPaddingEnd = localTypedArray.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabPaddingEnd, this.tabPaddingEnd);
    this.tabPaddingBottom = localTypedArray.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabPaddingBottom, this.tabPaddingBottom);
    this.tabTextAppearance = localTypedArray.getResourceId(android.support.design.R.styleable.TabLayout_tabTextAppearance, R.style.TextAppearance_Design_Tab);
    paramAttributeSet = paramContext.obtainStyledAttributes(this.tabTextAppearance, android.support.v7.appcompat.R.styleable.TextAppearance);
    try
    {
      this.tabTextSize = paramAttributeSet.getDimensionPixelSize(android.support.v7.appcompat.R.styleable.TextAppearance_android_textSize, 0);
      this.tabTextColors = MaterialResources.getColorStateList(paramContext, paramAttributeSet, android.support.v7.appcompat.R.styleable.TextAppearance_android_textColor);
      paramAttributeSet.recycle();
      if (localTypedArray.hasValue(android.support.design.R.styleable.TabLayout_tabTextColor)) {
        this.tabTextColors = MaterialResources.getColorStateList(paramContext, localTypedArray, android.support.design.R.styleable.TabLayout_tabTextColor);
      }
      if (localTypedArray.hasValue(android.support.design.R.styleable.TabLayout_tabSelectedTextColor))
      {
        paramInt = localTypedArray.getColor(android.support.design.R.styleable.TabLayout_tabSelectedTextColor, 0);
        this.tabTextColors = createColorStateList(this.tabTextColors.getDefaultColor(), paramInt);
      }
      this.tabIconTint = MaterialResources.getColorStateList(paramContext, localTypedArray, android.support.design.R.styleable.TabLayout_tabIconTint);
      this.tabIconTintMode = ViewUtils.parseTintMode(localTypedArray.getInt(android.support.design.R.styleable.TabLayout_tabIconTintMode, -1), null);
      this.tabRippleColorStateList = MaterialResources.getColorStateList(paramContext, localTypedArray, android.support.design.R.styleable.TabLayout_tabRippleColor);
      this.tabIndicatorAnimationDuration = localTypedArray.getInt(android.support.design.R.styleable.TabLayout_tabIndicatorAnimationDuration, 300);
      this.requestedTabMinWidth = localTypedArray.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabMinWidth, -1);
      this.requestedTabMaxWidth = localTypedArray.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabMaxWidth, -1);
      this.tabBackgroundResId = localTypedArray.getResourceId(android.support.design.R.styleable.TabLayout_tabBackground, 0);
      this.contentInsetStart = localTypedArray.getDimensionPixelSize(android.support.design.R.styleable.TabLayout_tabContentStart, 0);
      this.mode = localTypedArray.getInt(android.support.design.R.styleable.TabLayout_tabMode, 1);
      this.tabGravity = localTypedArray.getInt(android.support.design.R.styleable.TabLayout_tabGravity, 0);
      this.inlineLabel = localTypedArray.getBoolean(android.support.design.R.styleable.TabLayout_tabInlineLabel, false);
      this.unboundedRipple = localTypedArray.getBoolean(android.support.design.R.styleable.TabLayout_tabUnboundedRipple, false);
      localTypedArray.recycle();
      paramContext = getResources();
      this.tabTextMultiLineSize = paramContext.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
      this.scrollableTabMinWidth = paramContext.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
      applyModeAndGravity();
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  private void addTabFromItemView(@NonNull TabItem paramTabItem)
  {
    Tab localTab = newTab();
    if (paramTabItem.text != null) {
      localTab.setText(paramTabItem.text);
    }
    if (paramTabItem.icon != null) {
      localTab.setIcon(paramTabItem.icon);
    }
    if (paramTabItem.customLayout != 0) {
      localTab.setCustomView(paramTabItem.customLayout);
    }
    if (!TextUtils.isEmpty(paramTabItem.getContentDescription())) {
      localTab.setContentDescription(paramTabItem.getContentDescription());
    }
    addTab(localTab);
  }
  
  private void addTabView(Tab paramTab)
  {
    TabView localTabView = paramTab.view;
    this.slidingTabIndicator.addView(localTabView, paramTab.getPosition(), createLayoutParamsForTabs());
  }
  
  private void addViewInternal(View paramView)
  {
    if ((paramView instanceof TabItem))
    {
      addTabFromItemView((TabItem)paramView);
      return;
    }
    throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
  }
  
  private void animateToTab(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    if ((getWindowToken() != null) && (ViewCompat.isLaidOut(this)) && (!this.slidingTabIndicator.childrenNeedLayout()))
    {
      int i = getScrollX();
      int j = calculateScrollXForTab(paramInt, 0.0F);
      if (i != j)
      {
        ensureScrollAnimator();
        this.scrollAnimator.setIntValues(new int[] { i, j });
        this.scrollAnimator.start();
      }
      this.slidingTabIndicator.animateIndicatorToPosition(paramInt, this.tabIndicatorAnimationDuration);
      return;
    }
    setScrollPosition(paramInt, 0.0F, true);
  }
  
  private void applyModeAndGravity()
  {
    int i;
    if (this.mode == 0) {
      i = Math.max(0, this.contentInsetStart - this.tabPaddingStart);
    } else {
      i = 0;
    }
    ViewCompat.setPaddingRelative(this.slidingTabIndicator, i, 0, 0, 0);
    switch (this.mode)
    {
    default: 
      break;
    case 1: 
      this.slidingTabIndicator.setGravity(1);
      break;
    case 0: 
      this.slidingTabIndicator.setGravity(8388611);
    }
    updateTabViews(true);
  }
  
  private int calculateScrollXForTab(int paramInt, float paramFloat)
  {
    int j = this.mode;
    int i = 0;
    if (j == 0)
    {
      View localView2 = this.slidingTabIndicator.getChildAt(paramInt);
      paramInt += 1;
      View localView1;
      if (paramInt < this.slidingTabIndicator.getChildCount()) {
        localView1 = this.slidingTabIndicator.getChildAt(paramInt);
      } else {
        localView1 = null;
      }
      if (localView2 != null) {
        paramInt = localView2.getWidth();
      } else {
        paramInt = 0;
      }
      if (localView1 != null) {
        i = localView1.getWidth();
      }
      j = localView2.getLeft() + paramInt / 2 - getWidth() / 2;
      paramInt = (int)((paramInt + i) * 0.5F * paramFloat);
      if (ViewCompat.getLayoutDirection(this) == 0) {
        return j + paramInt;
      }
      return j - paramInt;
    }
    return 0;
  }
  
  private void configureTab(Tab paramTab, int paramInt)
  {
    paramTab.setPosition(paramInt);
    this.tabs.add(paramInt, paramTab);
    int i = this.tabs.size();
    for (;;)
    {
      paramInt += 1;
      if (paramInt >= i) {
        break;
      }
      ((Tab)this.tabs.get(paramInt)).setPosition(paramInt);
    }
  }
  
  private static ColorStateList createColorStateList(int paramInt1, int paramInt2)
  {
    return new ColorStateList(new int[][] { SELECTED_STATE_SET, EMPTY_STATE_SET }, new int[] { paramInt2, paramInt1 });
  }
  
  private LinearLayout.LayoutParams createLayoutParamsForTabs()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    updateTabViewLayoutParams(localLayoutParams);
    return localLayoutParams;
  }
  
  private TabView createTabView(@NonNull Tab paramTab)
  {
    TabView localTabView1;
    if (this.tabViewPool != null) {
      localTabView1 = (TabView)this.tabViewPool.acquire();
    } else {
      localTabView1 = null;
    }
    TabView localTabView2 = localTabView1;
    if (localTabView1 == null) {
      localTabView2 = new TabView(getContext());
    }
    localTabView2.setTab(paramTab);
    localTabView2.setFocusable(true);
    localTabView2.setMinimumWidth(getTabMinWidth());
    if (TextUtils.isEmpty(paramTab.contentDesc))
    {
      localTabView2.setContentDescription(paramTab.text);
      return localTabView2;
    }
    localTabView2.setContentDescription(paramTab.contentDesc);
    return localTabView2;
  }
  
  private void dispatchTabReselected(@NonNull Tab paramTab)
  {
    int i = this.selectedListeners.size() - 1;
    while (i >= 0)
    {
      ((BaseOnTabSelectedListener)this.selectedListeners.get(i)).onTabReselected(paramTab);
      i -= 1;
    }
  }
  
  private void dispatchTabSelected(@NonNull Tab paramTab)
  {
    int i = this.selectedListeners.size() - 1;
    while (i >= 0)
    {
      ((BaseOnTabSelectedListener)this.selectedListeners.get(i)).onTabSelected(paramTab);
      i -= 1;
    }
  }
  
  private void dispatchTabUnselected(@NonNull Tab paramTab)
  {
    int i = this.selectedListeners.size() - 1;
    while (i >= 0)
    {
      ((BaseOnTabSelectedListener)this.selectedListeners.get(i)).onTabUnselected(paramTab);
      i -= 1;
    }
  }
  
  private void ensureScrollAnimator()
  {
    if (this.scrollAnimator == null)
    {
      this.scrollAnimator = new ValueAnimator();
      this.scrollAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
      this.scrollAnimator.setDuration(this.tabIndicatorAnimationDuration);
      this.scrollAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          TabLayout.this.scrollTo(((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue(), 0);
        }
      });
    }
  }
  
  @Dimension(unit=0)
  private int getDefaultHeight()
  {
    int m = this.tabs.size();
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      Tab localTab = (Tab)this.tabs.get(i);
      if ((localTab != null) && (localTab.getIcon() != null) && (!TextUtils.isEmpty(localTab.getText())))
      {
        j = 1;
        break;
      }
      i += 1;
    }
    if ((j != 0) && (!this.inlineLabel)) {
      return 72;
    }
    return 48;
  }
  
  private int getTabMinWidth()
  {
    if (this.requestedTabMinWidth != -1) {
      return this.requestedTabMinWidth;
    }
    if (this.mode == 0) {
      return this.scrollableTabMinWidth;
    }
    return 0;
  }
  
  private int getTabScrollRange()
  {
    return Math.max(0, this.slidingTabIndicator.getWidth() - getWidth() - getPaddingLeft() - getPaddingRight());
  }
  
  private void removeTabViewAt(int paramInt)
  {
    TabView localTabView = (TabView)this.slidingTabIndicator.getChildAt(paramInt);
    this.slidingTabIndicator.removeViewAt(paramInt);
    if (localTabView != null)
    {
      localTabView.reset();
      this.tabViewPool.release(localTabView);
    }
    requestLayout();
  }
  
  private void setSelectedTabView(int paramInt)
  {
    int j = this.slidingTabIndicator.getChildCount();
    if (paramInt < j)
    {
      int i = 0;
      while (i < j)
      {
        View localView = this.slidingTabIndicator.getChildAt(i);
        boolean bool2 = true;
        boolean bool1;
        if (i == paramInt) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        localView.setSelected(bool1);
        if (i == paramInt) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
        localView.setActivated(bool1);
        i += 1;
      }
    }
  }
  
  private void setupWithViewPager(@Nullable ViewPager paramViewPager, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.viewPager != null)
    {
      if (this.pageChangeListener != null) {
        this.viewPager.removeOnPageChangeListener(this.pageChangeListener);
      }
      if (this.adapterChangeListener != null) {
        this.viewPager.removeOnAdapterChangeListener(this.adapterChangeListener);
      }
    }
    if (this.currentVpSelectedListener != null)
    {
      removeOnTabSelectedListener(this.currentVpSelectedListener);
      this.currentVpSelectedListener = null;
    }
    if (paramViewPager != null)
    {
      this.viewPager = paramViewPager;
      if (this.pageChangeListener == null) {
        this.pageChangeListener = new TabLayoutOnPageChangeListener(this);
      }
      this.pageChangeListener.reset();
      paramViewPager.addOnPageChangeListener(this.pageChangeListener);
      this.currentVpSelectedListener = new ViewPagerOnTabSelectedListener(paramViewPager);
      addOnTabSelectedListener(this.currentVpSelectedListener);
      PagerAdapter localPagerAdapter = paramViewPager.getAdapter();
      if (localPagerAdapter != null) {
        setPagerAdapter(localPagerAdapter, paramBoolean1);
      }
      if (this.adapterChangeListener == null) {
        this.adapterChangeListener = new AdapterChangeListener();
      }
      this.adapterChangeListener.setAutoRefresh(paramBoolean1);
      paramViewPager.addOnAdapterChangeListener(this.adapterChangeListener);
      setScrollPosition(paramViewPager.getCurrentItem(), 0.0F, true);
    }
    else
    {
      this.viewPager = null;
      setPagerAdapter(null, false);
    }
    this.setupViewPagerImplicitly = paramBoolean2;
  }
  
  private void updateAllTabs()
  {
    int j = this.tabs.size();
    int i = 0;
    while (i < j)
    {
      ((Tab)this.tabs.get(i)).updateView();
      i += 1;
    }
  }
  
  private void updateTabViewLayoutParams(LinearLayout.LayoutParams paramLayoutParams)
  {
    if ((this.mode == 1) && (this.tabGravity == 0))
    {
      paramLayoutParams.width = 0;
      paramLayoutParams.weight = 1.0F;
      return;
    }
    paramLayoutParams.width = -2;
    paramLayoutParams.weight = 0.0F;
  }
  
  public void addOnTabSelectedListener(@NonNull BaseOnTabSelectedListener paramBaseOnTabSelectedListener)
  {
    if (!this.selectedListeners.contains(paramBaseOnTabSelectedListener)) {
      this.selectedListeners.add(paramBaseOnTabSelectedListener);
    }
  }
  
  public void addTab(@NonNull Tab paramTab)
  {
    addTab(paramTab, this.tabs.isEmpty());
  }
  
  public void addTab(@NonNull Tab paramTab, int paramInt)
  {
    addTab(paramTab, paramInt, this.tabs.isEmpty());
  }
  
  public void addTab(@NonNull Tab paramTab, int paramInt, boolean paramBoolean)
  {
    if (paramTab.parent == this)
    {
      configureTab(paramTab, paramInt);
      addTabView(paramTab);
      if (paramBoolean) {
        paramTab.select();
      }
      return;
    }
    throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
  }
  
  public void addTab(@NonNull Tab paramTab, boolean paramBoolean)
  {
    addTab(paramTab, this.tabs.size(), paramBoolean);
  }
  
  public void addView(View paramView)
  {
    addViewInternal(paramView);
  }
  
  public void addView(View paramView, int paramInt)
  {
    addViewInternal(paramView);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    addViewInternal(paramView);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    addViewInternal(paramView);
  }
  
  public void clearOnTabSelectedListeners()
  {
    this.selectedListeners.clear();
  }
  
  protected Tab createTabFromPool()
  {
    Tab localTab2 = (Tab)tabPool.acquire();
    Tab localTab1 = localTab2;
    if (localTab2 == null) {
      localTab1 = new Tab();
    }
    return localTab1;
  }
  
  @Dimension(unit=1)
  int dpToPx(@Dimension(unit=0) int paramInt)
  {
    return Math.round(getResources().getDisplayMetrics().density * paramInt);
  }
  
  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return generateDefaultLayoutParams();
  }
  
  public int getSelectedTabPosition()
  {
    if (this.selectedTab != null) {
      return this.selectedTab.getPosition();
    }
    return -1;
  }
  
  @Nullable
  public Tab getTabAt(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getTabCount())) {
      return (Tab)this.tabs.get(paramInt);
    }
    return null;
  }
  
  public int getTabCount()
  {
    return this.tabs.size();
  }
  
  public int getTabGravity()
  {
    return this.tabGravity;
  }
  
  @Nullable
  public ColorStateList getTabIconTint()
  {
    return this.tabIconTint;
  }
  
  public int getTabIndicatorGravity()
  {
    return this.tabIndicatorGravity;
  }
  
  int getTabMaxWidth()
  {
    return this.tabMaxWidth;
  }
  
  public int getTabMode()
  {
    return this.mode;
  }
  
  @Nullable
  public ColorStateList getTabRippleColor()
  {
    return this.tabRippleColorStateList;
  }
  
  @Nullable
  public Drawable getTabSelectedIndicator()
  {
    return this.tabSelectedIndicator;
  }
  
  @Nullable
  public ColorStateList getTabTextColors()
  {
    return this.tabTextColors;
  }
  
  public boolean hasUnboundedRipple()
  {
    return this.unboundedRipple;
  }
  
  public boolean isInlineLabel()
  {
    return this.inlineLabel;
  }
  
  public boolean isTabIndicatorFullWidth()
  {
    return this.tabIndicatorFullWidth;
  }
  
  @NonNull
  public Tab newTab()
  {
    Tab localTab = createTabFromPool();
    localTab.parent = this;
    localTab.view = createTabView(localTab);
    return localTab;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.viewPager == null)
    {
      ViewParent localViewParent = getParent();
      if ((localViewParent instanceof ViewPager)) {
        setupWithViewPager((ViewPager)localViewParent, true, true);
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.setupViewPagerImplicitly)
    {
      setupWithViewPager(null);
      this.setupViewPagerImplicitly = false;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = 0;
    while (i < this.slidingTabIndicator.getChildCount())
    {
      View localView = this.slidingTabIndicator.getChildAt(i);
      if ((localView instanceof TabView)) {
        ((TabView)localView).drawBackground(paramCanvas);
      }
      i += 1;
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = dpToPx(getDefaultHeight()) + getPaddingTop() + getPaddingBottom();
    int j = View.MeasureSpec.getMode(paramInt2);
    if (j != Integer.MIN_VALUE)
    {
      if (j == 0) {
        paramInt2 = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
      }
    }
    else {
      paramInt2 = View.MeasureSpec.makeMeasureSpec(Math.min(i, View.MeasureSpec.getSize(paramInt2)), 1073741824);
    }
    i = View.MeasureSpec.getSize(paramInt1);
    if (View.MeasureSpec.getMode(paramInt1) != 0)
    {
      if (this.requestedTabMaxWidth > 0) {
        i = this.requestedTabMaxWidth;
      } else {
        i -= dpToPx(56);
      }
      this.tabMaxWidth = i;
    }
    super.onMeasure(paramInt1, paramInt2);
    if (getChildCount() == 1)
    {
      paramInt1 = 0;
      View localView = getChildAt(0);
      switch (this.mode)
      {
      default: 
        break;
      case 1: 
        if (localView.getMeasuredWidth() == getMeasuredWidth()) {
          break;
        }
      case 0: 
        do
        {
          paramInt1 = 1;
          break;
        } while (localView.getMeasuredWidth() < getMeasuredWidth());
      }
      if (paramInt1 != 0)
      {
        paramInt1 = getChildMeasureSpec(paramInt2, getPaddingTop() + getPaddingBottom(), localView.getLayoutParams().height);
        localView.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), paramInt1);
      }
    }
  }
  
  void populateFromPagerAdapter()
  {
    removeAllTabs();
    if (this.pagerAdapter != null)
    {
      int j = this.pagerAdapter.getCount();
      int i = 0;
      while (i < j)
      {
        addTab(newTab().setText(this.pagerAdapter.getPageTitle(i)), false);
        i += 1;
      }
      if ((this.viewPager != null) && (j > 0))
      {
        i = this.viewPager.getCurrentItem();
        if ((i != getSelectedTabPosition()) && (i < getTabCount())) {
          selectTab(getTabAt(i));
        }
      }
    }
  }
  
  protected boolean releaseFromTabPool(Tab paramTab)
  {
    return tabPool.release(paramTab);
  }
  
  public void removeAllTabs()
  {
    int i = this.slidingTabIndicator.getChildCount() - 1;
    while (i >= 0)
    {
      removeTabViewAt(i);
      i -= 1;
    }
    Iterator localIterator = this.tabs.iterator();
    while (localIterator.hasNext())
    {
      Tab localTab = (Tab)localIterator.next();
      localIterator.remove();
      localTab.reset();
      releaseFromTabPool(localTab);
    }
    this.selectedTab = null;
  }
  
  public void removeOnTabSelectedListener(@NonNull BaseOnTabSelectedListener paramBaseOnTabSelectedListener)
  {
    this.selectedListeners.remove(paramBaseOnTabSelectedListener);
  }
  
  public void removeTab(Tab paramTab)
  {
    if (paramTab.parent == this)
    {
      removeTabAt(paramTab.getPosition());
      return;
    }
    throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
  }
  
  public void removeTabAt(int paramInt)
  {
    int i;
    if (this.selectedTab != null) {
      i = this.selectedTab.getPosition();
    } else {
      i = 0;
    }
    removeTabViewAt(paramInt);
    Tab localTab = (Tab)this.tabs.remove(paramInt);
    if (localTab != null)
    {
      localTab.reset();
      releaseFromTabPool(localTab);
    }
    int k = this.tabs.size();
    int j = paramInt;
    while (j < k)
    {
      ((Tab)this.tabs.get(j)).setPosition(j);
      j += 1;
    }
    if (i == paramInt)
    {
      if (this.tabs.isEmpty()) {
        localTab = null;
      } else {
        localTab = (Tab)this.tabs.get(Math.max(0, paramInt - 1));
      }
      selectTab(localTab);
    }
  }
  
  void selectTab(Tab paramTab)
  {
    selectTab(paramTab, true);
  }
  
  void selectTab(Tab paramTab, boolean paramBoolean)
  {
    Tab localTab = this.selectedTab;
    if (localTab == paramTab)
    {
      if (localTab != null)
      {
        dispatchTabReselected(paramTab);
        animateToTab(paramTab.getPosition());
      }
    }
    else
    {
      int i;
      if (paramTab != null) {
        i = paramTab.getPosition();
      } else {
        i = -1;
      }
      if (paramBoolean)
      {
        if (((localTab == null) || (localTab.getPosition() == -1)) && (i != -1)) {
          setScrollPosition(i, 0.0F, true);
        } else {
          animateToTab(i);
        }
        if (i != -1) {
          setSelectedTabView(i);
        }
      }
      this.selectedTab = paramTab;
      if (localTab != null) {
        dispatchTabUnselected(localTab);
      }
      if (paramTab != null) {
        dispatchTabSelected(paramTab);
      }
    }
  }
  
  public void setInlineLabel(boolean paramBoolean)
  {
    if (this.inlineLabel != paramBoolean)
    {
      this.inlineLabel = paramBoolean;
      int i = 0;
      while (i < this.slidingTabIndicator.getChildCount())
      {
        View localView = this.slidingTabIndicator.getChildAt(i);
        if ((localView instanceof TabView)) {
          ((TabView)localView).updateOrientation();
        }
        i += 1;
      }
      applyModeAndGravity();
    }
  }
  
  public void setInlineLabelResource(@BoolRes int paramInt)
  {
    setInlineLabel(getResources().getBoolean(paramInt));
  }
  
  @Deprecated
  public void setOnTabSelectedListener(@Nullable BaseOnTabSelectedListener paramBaseOnTabSelectedListener)
  {
    if (this.selectedListener != null) {
      removeOnTabSelectedListener(this.selectedListener);
    }
    this.selectedListener = paramBaseOnTabSelectedListener;
    if (paramBaseOnTabSelectedListener != null) {
      addOnTabSelectedListener(paramBaseOnTabSelectedListener);
    }
  }
  
  void setPagerAdapter(@Nullable PagerAdapter paramPagerAdapter, boolean paramBoolean)
  {
    if ((this.pagerAdapter != null) && (this.pagerAdapterObserver != null)) {
      this.pagerAdapter.unregisterDataSetObserver(this.pagerAdapterObserver);
    }
    this.pagerAdapter = paramPagerAdapter;
    if ((paramBoolean) && (paramPagerAdapter != null))
    {
      if (this.pagerAdapterObserver == null) {
        this.pagerAdapterObserver = new PagerAdapterObserver();
      }
      paramPagerAdapter.registerDataSetObserver(this.pagerAdapterObserver);
    }
    populateFromPagerAdapter();
  }
  
  void setScrollAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    ensureScrollAnimator();
    this.scrollAnimator.addListener(paramAnimatorListener);
  }
  
  public void setScrollPosition(int paramInt, float paramFloat, boolean paramBoolean)
  {
    setScrollPosition(paramInt, paramFloat, paramBoolean, true);
  }
  
  void setScrollPosition(int paramInt, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = Math.round(paramInt + paramFloat);
    if (i >= 0)
    {
      if (i >= this.slidingTabIndicator.getChildCount()) {
        return;
      }
      if (paramBoolean2) {
        this.slidingTabIndicator.setIndicatorPositionFromTabPosition(paramInt, paramFloat);
      }
      if ((this.scrollAnimator != null) && (this.scrollAnimator.isRunning())) {
        this.scrollAnimator.cancel();
      }
      scrollTo(calculateScrollXForTab(paramInt, paramFloat), 0);
      if (paramBoolean1) {
        setSelectedTabView(i);
      }
      return;
    }
  }
  
  public void setSelectedTabIndicator(@DrawableRes int paramInt)
  {
    if (paramInt != 0)
    {
      setSelectedTabIndicator(AppCompatResources.getDrawable(getContext(), paramInt));
      return;
    }
    setSelectedTabIndicator(null);
  }
  
  public void setSelectedTabIndicator(@Nullable Drawable paramDrawable)
  {
    if (this.tabSelectedIndicator != paramDrawable)
    {
      this.tabSelectedIndicator = paramDrawable;
      ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
    }
  }
  
  public void setSelectedTabIndicatorColor(@ColorInt int paramInt)
  {
    this.slidingTabIndicator.setSelectedIndicatorColor(paramInt);
  }
  
  public void setSelectedTabIndicatorGravity(int paramInt)
  {
    if (this.tabIndicatorGravity != paramInt)
    {
      this.tabIndicatorGravity = paramInt;
      ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
    }
  }
  
  @Deprecated
  public void setSelectedTabIndicatorHeight(int paramInt)
  {
    this.slidingTabIndicator.setSelectedIndicatorHeight(paramInt);
  }
  
  public void setTabGravity(int paramInt)
  {
    if (this.tabGravity != paramInt)
    {
      this.tabGravity = paramInt;
      applyModeAndGravity();
    }
  }
  
  public void setTabIconTint(@Nullable ColorStateList paramColorStateList)
  {
    if (this.tabIconTint != paramColorStateList)
    {
      this.tabIconTint = paramColorStateList;
      updateAllTabs();
    }
  }
  
  public void setTabIconTintResource(@ColorRes int paramInt)
  {
    setTabIconTint(AppCompatResources.getColorStateList(getContext(), paramInt));
  }
  
  public void setTabIndicatorFullWidth(boolean paramBoolean)
  {
    this.tabIndicatorFullWidth = paramBoolean;
    ViewCompat.postInvalidateOnAnimation(this.slidingTabIndicator);
  }
  
  public void setTabMode(int paramInt)
  {
    if (paramInt != this.mode)
    {
      this.mode = paramInt;
      applyModeAndGravity();
    }
  }
  
  public void setTabRippleColor(@Nullable ColorStateList paramColorStateList)
  {
    if (this.tabRippleColorStateList != paramColorStateList)
    {
      this.tabRippleColorStateList = paramColorStateList;
      int i = 0;
      while (i < this.slidingTabIndicator.getChildCount())
      {
        paramColorStateList = this.slidingTabIndicator.getChildAt(i);
        if ((paramColorStateList instanceof TabView)) {
          ((TabView)paramColorStateList).updateBackgroundDrawable(getContext());
        }
        i += 1;
      }
    }
  }
  
  public void setTabRippleColorResource(@ColorRes int paramInt)
  {
    setTabRippleColor(AppCompatResources.getColorStateList(getContext(), paramInt));
  }
  
  public void setTabTextColors(int paramInt1, int paramInt2)
  {
    setTabTextColors(createColorStateList(paramInt1, paramInt2));
  }
  
  public void setTabTextColors(@Nullable ColorStateList paramColorStateList)
  {
    if (this.tabTextColors != paramColorStateList)
    {
      this.tabTextColors = paramColorStateList;
      updateAllTabs();
    }
  }
  
  @Deprecated
  public void setTabsFromPagerAdapter(@Nullable PagerAdapter paramPagerAdapter)
  {
    setPagerAdapter(paramPagerAdapter, false);
  }
  
  public void setUnboundedRipple(boolean paramBoolean)
  {
    if (this.unboundedRipple != paramBoolean)
    {
      this.unboundedRipple = paramBoolean;
      int i = 0;
      while (i < this.slidingTabIndicator.getChildCount())
      {
        View localView = this.slidingTabIndicator.getChildAt(i);
        if ((localView instanceof TabView)) {
          ((TabView)localView).updateBackgroundDrawable(getContext());
        }
        i += 1;
      }
    }
  }
  
  public void setUnboundedRippleResource(@BoolRes int paramInt)
  {
    setUnboundedRipple(getResources().getBoolean(paramInt));
  }
  
  public void setupWithViewPager(@Nullable ViewPager paramViewPager)
  {
    setupWithViewPager(paramViewPager, true);
  }
  
  public void setupWithViewPager(@Nullable ViewPager paramViewPager, boolean paramBoolean)
  {
    setupWithViewPager(paramViewPager, paramBoolean, false);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return getTabScrollRange() > 0;
  }
  
  void updateTabViews(boolean paramBoolean)
  {
    int i = 0;
    while (i < this.slidingTabIndicator.getChildCount())
    {
      View localView = this.slidingTabIndicator.getChildAt(i);
      localView.setMinimumWidth(getTabMinWidth());
      updateTabViewLayoutParams((LinearLayout.LayoutParams)localView.getLayoutParams());
      if (paramBoolean) {
        localView.requestLayout();
      }
      i += 1;
    }
  }
  
  private class AdapterChangeListener
    implements ViewPager.OnAdapterChangeListener
  {
    private boolean autoRefresh;
    
    AdapterChangeListener() {}
    
    public void onAdapterChanged(@NonNull ViewPager paramViewPager, @Nullable PagerAdapter paramPagerAdapter1, @Nullable PagerAdapter paramPagerAdapter2)
    {
      if (TabLayout.this.viewPager == paramViewPager) {
        TabLayout.this.setPagerAdapter(paramPagerAdapter2, this.autoRefresh);
      }
    }
    
    void setAutoRefresh(boolean paramBoolean)
    {
      this.autoRefresh = paramBoolean;
    }
  }
  
  public static abstract interface BaseOnTabSelectedListener<T extends TabLayout.Tab>
  {
    public abstract void onTabReselected(T paramT);
    
    public abstract void onTabSelected(T paramT);
    
    public abstract void onTabUnselected(T paramT);
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface Mode {}
  
  public static abstract interface OnTabSelectedListener
    extends TabLayout.BaseOnTabSelectedListener<TabLayout.Tab>
  {}
  
  private class PagerAdapterObserver
    extends DataSetObserver
  {
    PagerAdapterObserver() {}
    
    public void onChanged()
    {
      TabLayout.this.populateFromPagerAdapter();
    }
    
    public void onInvalidated()
    {
      TabLayout.this.populateFromPagerAdapter();
    }
  }
  
  private class SlidingTabIndicator
    extends LinearLayout
  {
    private final GradientDrawable defaultSelectionIndicator;
    private ValueAnimator indicatorAnimator;
    private int indicatorLeft = -1;
    private int indicatorRight = -1;
    private int layoutDirection = -1;
    private int selectedIndicatorHeight;
    private final Paint selectedIndicatorPaint;
    int selectedPosition = -1;
    float selectionOffset;
    
    SlidingTabIndicator(Context paramContext)
    {
      super();
      setWillNotDraw(false);
      this.selectedIndicatorPaint = new Paint();
      this.defaultSelectionIndicator = new GradientDrawable();
    }
    
    private void calculateTabViewContentBounds(TabLayout.TabView paramTabView, RectF paramRectF)
    {
      int j = TabLayout.TabView.access$500(paramTabView);
      int i = j;
      if (j < TabLayout.this.dpToPx(24)) {
        i = TabLayout.this.dpToPx(24);
      }
      j = (paramTabView.getLeft() + paramTabView.getRight()) / 2;
      i /= 2;
      paramRectF.set(j - i, 0.0F, j + i, 0.0F);
    }
    
    private void updateIndicatorPosition()
    {
      View localView = getChildAt(this.selectedPosition);
      int k;
      int m;
      if ((localView != null) && (localView.getWidth() > 0))
      {
        k = localView.getLeft();
        m = localView.getRight();
        int j = k;
        int i = m;
        if (!TabLayout.this.tabIndicatorFullWidth)
        {
          j = k;
          i = m;
          if ((localView instanceof TabLayout.TabView))
          {
            calculateTabViewContentBounds((TabLayout.TabView)localView, TabLayout.this.tabViewContentBounds);
            j = (int)TabLayout.this.tabViewContentBounds.left;
            i = (int)TabLayout.this.tabViewContentBounds.right;
          }
        }
        k = j;
        m = i;
        if (this.selectionOffset > 0.0F)
        {
          k = j;
          m = i;
          if (this.selectedPosition < getChildCount() - 1)
          {
            localView = getChildAt(this.selectedPosition + 1);
            int n = localView.getLeft();
            int i1 = localView.getRight();
            m = n;
            k = i1;
            if (!TabLayout.this.tabIndicatorFullWidth)
            {
              m = n;
              k = i1;
              if ((localView instanceof TabLayout.TabView))
              {
                calculateTabViewContentBounds((TabLayout.TabView)localView, TabLayout.this.tabViewContentBounds);
                m = (int)TabLayout.this.tabViewContentBounds.left;
                k = (int)TabLayout.this.tabViewContentBounds.right;
              }
            }
            j = (int)(this.selectionOffset * m + (1.0F - this.selectionOffset) * j);
            m = (int)(this.selectionOffset * k + (1.0F - this.selectionOffset) * i);
            k = j;
          }
        }
      }
      else
      {
        k = -1;
        m = -1;
      }
      setIndicatorPosition(k, m);
    }
    
    void animateIndicatorToPosition(final int paramInt1, int paramInt2)
    {
      if ((this.indicatorAnimator != null) && (this.indicatorAnimator.isRunning())) {
        this.indicatorAnimator.cancel();
      }
      Object localObject = getChildAt(paramInt1);
      if (localObject == null)
      {
        updateIndicatorPosition();
        return;
      }
      final int k = ((View)localObject).getLeft();
      final int m = ((View)localObject).getRight();
      final int j = k;
      final int i = m;
      if (!TabLayout.this.tabIndicatorFullWidth)
      {
        j = k;
        i = m;
        if ((localObject instanceof TabLayout.TabView))
        {
          calculateTabViewContentBounds((TabLayout.TabView)localObject, TabLayout.this.tabViewContentBounds);
          j = (int)TabLayout.this.tabViewContentBounds.left;
          i = (int)TabLayout.this.tabViewContentBounds.right;
        }
      }
      k = this.indicatorLeft;
      m = this.indicatorRight;
      if ((k != j) || (m != i))
      {
        localObject = new ValueAnimator();
        this.indicatorAnimator = ((ValueAnimator)localObject);
        ((ValueAnimator)localObject).setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
        ((ValueAnimator)localObject).setDuration(paramInt2);
        ((ValueAnimator)localObject).setFloatValues(new float[] { 0.0F, 1.0F });
        ((ValueAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            float f = paramAnonymousValueAnimator.getAnimatedFraction();
            TabLayout.SlidingTabIndicator.this.setIndicatorPosition(AnimationUtils.lerp(k, j, f), AnimationUtils.lerp(m, i, f));
          }
        });
        ((ValueAnimator)localObject).addListener(new AnimatorListenerAdapter()
        {
          public void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            TabLayout.SlidingTabIndicator.this.selectedPosition = paramInt1;
            TabLayout.SlidingTabIndicator.this.selectionOffset = 0.0F;
          }
        });
        ((ValueAnimator)localObject).start();
      }
    }
    
    boolean childrenNeedLayout()
    {
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        if (getChildAt(i).getWidth() <= 0) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    
    public void draw(Canvas paramCanvas)
    {
      Object localObject = TabLayout.this.tabSelectedIndicator;
      int m = 0;
      int j;
      if (localObject != null) {
        j = TabLayout.this.tabSelectedIndicator.getIntrinsicHeight();
      } else {
        j = 0;
      }
      if (this.selectedIndicatorHeight >= 0) {
        j = this.selectedIndicatorHeight;
      }
      int i = j;
      int k = m;
      switch (TabLayout.this.tabIndicatorGravity)
      {
      default: 
        i = 0;
        k = m;
        break;
      case 3: 
        i = getHeight();
        k = m;
        break;
      case 1: 
        k = (getHeight() - j) / 2;
        i = (getHeight() + j) / 2;
        break;
      case 0: 
        k = getHeight() - j;
        i = getHeight();
      }
      if ((this.indicatorLeft >= 0) && (this.indicatorRight > this.indicatorLeft))
      {
        if (TabLayout.this.tabSelectedIndicator != null) {
          localObject = TabLayout.this.tabSelectedIndicator;
        } else {
          localObject = this.defaultSelectionIndicator;
        }
        localObject = DrawableCompat.wrap((Drawable)localObject);
        ((Drawable)localObject).setBounds(this.indicatorLeft, k, this.indicatorRight, i);
        if (this.selectedIndicatorPaint != null) {
          if (Build.VERSION.SDK_INT == 21) {
            ((Drawable)localObject).setColorFilter(this.selectedIndicatorPaint.getColor(), PorterDuff.Mode.SRC_IN);
          } else {
            DrawableCompat.setTint((Drawable)localObject, this.selectedIndicatorPaint.getColor());
          }
        }
        ((Drawable)localObject).draw(paramCanvas);
      }
      super.draw(paramCanvas);
    }
    
    float getIndicatorPosition()
    {
      return this.selectedPosition + this.selectionOffset;
    }
    
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if ((this.indicatorAnimator != null) && (this.indicatorAnimator.isRunning()))
      {
        this.indicatorAnimator.cancel();
        long l = this.indicatorAnimator.getDuration();
        animateIndicatorToPosition(this.selectedPosition, Math.round((1.0F - this.indicatorAnimator.getAnimatedFraction()) * (float)l));
        return;
      }
      updateIndicatorPosition();
    }
    
    protected void onMeasure(int paramInt1, int paramInt2)
    {
      super.onMeasure(paramInt1, paramInt2);
      if (View.MeasureSpec.getMode(paramInt1) != 1073741824) {
        return;
      }
      int i = TabLayout.this.mode;
      int n = 1;
      if ((i == 1) && (TabLayout.this.tabGravity == 1))
      {
        int i1 = getChildCount();
        int m = 0;
        i = 0;
        Object localObject;
        int k;
        for (int j = 0; i < i1; j = k)
        {
          localObject = getChildAt(i);
          k = j;
          if (((View)localObject).getVisibility() == 0) {
            k = Math.max(j, ((View)localObject).getMeasuredWidth());
          }
          i += 1;
        }
        if (j <= 0) {
          return;
        }
        i = TabLayout.this.dpToPx(16);
        if (j * i1 <= getMeasuredWidth() - i * 2)
        {
          i = 0;
          k = m;
          while (k < i1)
          {
            localObject = (LinearLayout.LayoutParams)getChildAt(k).getLayoutParams();
            if ((((LinearLayout.LayoutParams)localObject).width != j) || (((LinearLayout.LayoutParams)localObject).weight != 0.0F))
            {
              ((LinearLayout.LayoutParams)localObject).width = j;
              ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
              i = 1;
            }
            k += 1;
          }
        }
        else
        {
          TabLayout.this.tabGravity = 0;
          TabLayout.this.updateTabViews(false);
          i = n;
        }
        if (i != 0) {
          super.onMeasure(paramInt1, paramInt2);
        }
      }
    }
    
    public void onRtlPropertiesChanged(int paramInt)
    {
      super.onRtlPropertiesChanged(paramInt);
      if ((Build.VERSION.SDK_INT < 23) && (this.layoutDirection != paramInt))
      {
        requestLayout();
        this.layoutDirection = paramInt;
      }
    }
    
    void setIndicatorPosition(int paramInt1, int paramInt2)
    {
      if ((paramInt1 != this.indicatorLeft) || (paramInt2 != this.indicatorRight))
      {
        this.indicatorLeft = paramInt1;
        this.indicatorRight = paramInt2;
        ViewCompat.postInvalidateOnAnimation(this);
      }
    }
    
    void setIndicatorPositionFromTabPosition(int paramInt, float paramFloat)
    {
      if ((this.indicatorAnimator != null) && (this.indicatorAnimator.isRunning())) {
        this.indicatorAnimator.cancel();
      }
      this.selectedPosition = paramInt;
      this.selectionOffset = paramFloat;
      updateIndicatorPosition();
    }
    
    void setSelectedIndicatorColor(int paramInt)
    {
      if (this.selectedIndicatorPaint.getColor() != paramInt)
      {
        this.selectedIndicatorPaint.setColor(paramInt);
        ViewCompat.postInvalidateOnAnimation(this);
      }
    }
    
    void setSelectedIndicatorHeight(int paramInt)
    {
      if (this.selectedIndicatorHeight != paramInt)
      {
        this.selectedIndicatorHeight = paramInt;
        ViewCompat.postInvalidateOnAnimation(this);
      }
    }
  }
  
  public static class Tab
  {
    public static final int INVALID_POSITION = -1;
    private CharSequence contentDesc;
    private View customView;
    private Drawable icon;
    public TabLayout parent;
    private int position = -1;
    private Object tag;
    private CharSequence text;
    public TabLayout.TabView view;
    
    @Nullable
    public CharSequence getContentDescription()
    {
      if (this.view == null) {
        return null;
      }
      return this.view.getContentDescription();
    }
    
    @Nullable
    public View getCustomView()
    {
      return this.customView;
    }
    
    @Nullable
    public Drawable getIcon()
    {
      return this.icon;
    }
    
    public int getPosition()
    {
      return this.position;
    }
    
    @Nullable
    public Object getTag()
    {
      return this.tag;
    }
    
    @Nullable
    public CharSequence getText()
    {
      return this.text;
    }
    
    public boolean isSelected()
    {
      if (this.parent != null) {
        return this.parent.getSelectedTabPosition() == this.position;
      }
      throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
    
    void reset()
    {
      this.parent = null;
      this.view = null;
      this.tag = null;
      this.icon = null;
      this.text = null;
      this.contentDesc = null;
      this.position = -1;
      this.customView = null;
    }
    
    public void select()
    {
      if (this.parent != null)
      {
        this.parent.selectTab(this);
        return;
      }
      throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
    
    @NonNull
    public Tab setContentDescription(@StringRes int paramInt)
    {
      if (this.parent != null) {
        return setContentDescription(this.parent.getResources().getText(paramInt));
      }
      throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
    
    @NonNull
    public Tab setContentDescription(@Nullable CharSequence paramCharSequence)
    {
      this.contentDesc = paramCharSequence;
      updateView();
      return this;
    }
    
    @NonNull
    public Tab setCustomView(@LayoutRes int paramInt)
    {
      return setCustomView(LayoutInflater.from(this.view.getContext()).inflate(paramInt, this.view, false));
    }
    
    @NonNull
    public Tab setCustomView(@Nullable View paramView)
    {
      this.customView = paramView;
      updateView();
      return this;
    }
    
    @NonNull
    public Tab setIcon(@DrawableRes int paramInt)
    {
      if (this.parent != null) {
        return setIcon(AppCompatResources.getDrawable(this.parent.getContext(), paramInt));
      }
      throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
    
    @NonNull
    public Tab setIcon(@Nullable Drawable paramDrawable)
    {
      this.icon = paramDrawable;
      updateView();
      return this;
    }
    
    void setPosition(int paramInt)
    {
      this.position = paramInt;
    }
    
    @NonNull
    public Tab setTag(@Nullable Object paramObject)
    {
      this.tag = paramObject;
      return this;
    }
    
    @NonNull
    public Tab setText(@StringRes int paramInt)
    {
      if (this.parent != null) {
        return setText(this.parent.getResources().getText(paramInt));
      }
      throw new IllegalArgumentException("Tab not attached to a TabLayout");
    }
    
    @NonNull
    public Tab setText(@Nullable CharSequence paramCharSequence)
    {
      if ((TextUtils.isEmpty(this.contentDesc)) && (!TextUtils.isEmpty(paramCharSequence))) {
        this.view.setContentDescription(paramCharSequence);
      }
      this.text = paramCharSequence;
      updateView();
      return this;
    }
    
    void updateView()
    {
      if (this.view != null) {
        this.view.update();
      }
    }
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface TabGravity {}
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface TabIndicatorGravity {}
  
  public static class TabLayoutOnPageChangeListener
    implements ViewPager.OnPageChangeListener
  {
    private int previousScrollState;
    private int scrollState;
    private final WeakReference<TabLayout> tabLayoutRef;
    
    public TabLayoutOnPageChangeListener(TabLayout paramTabLayout)
    {
      this.tabLayoutRef = new WeakReference(paramTabLayout);
    }
    
    public void onPageScrollStateChanged(int paramInt)
    {
      this.previousScrollState = this.scrollState;
      this.scrollState = paramInt;
    }
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      TabLayout localTabLayout = (TabLayout)this.tabLayoutRef.get();
      if (localTabLayout != null)
      {
        paramInt2 = this.scrollState;
        boolean bool2 = false;
        boolean bool1;
        if ((paramInt2 == 2) && (this.previousScrollState != 1)) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        if ((this.scrollState != 2) || (this.previousScrollState != 0)) {
          bool2 = true;
        }
        localTabLayout.setScrollPosition(paramInt1, paramFloat, bool1, bool2);
      }
    }
    
    public void onPageSelected(int paramInt)
    {
      TabLayout localTabLayout = (TabLayout)this.tabLayoutRef.get();
      if ((localTabLayout != null) && (localTabLayout.getSelectedTabPosition() != paramInt) && (paramInt < localTabLayout.getTabCount()))
      {
        boolean bool;
        if ((this.scrollState != 0) && ((this.scrollState != 2) || (this.previousScrollState != 0))) {
          bool = false;
        } else {
          bool = true;
        }
        localTabLayout.selectTab(localTabLayout.getTabAt(paramInt), bool);
      }
    }
    
    void reset()
    {
      this.scrollState = 0;
      this.previousScrollState = 0;
    }
  }
  
  class TabView
    extends LinearLayout
  {
    @Nullable
    private Drawable baseBackgroundDrawable;
    private ImageView customIconView;
    private TextView customTextView;
    private View customView;
    private int defaultMaxLines = 2;
    private ImageView iconView;
    private TabLayout.Tab tab;
    private TextView textView;
    
    public TabView(Context paramContext)
    {
      super();
      updateBackgroundDrawable(paramContext);
      ViewCompat.setPaddingRelative(this, TabLayout.this.tabPaddingStart, TabLayout.this.tabPaddingTop, TabLayout.this.tabPaddingEnd, TabLayout.this.tabPaddingBottom);
      setGravity(17);
      setOrientation(TabLayout.this.inlineLabel ^ true);
      setClickable(true);
      ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
    }
    
    private float approximateLineWidth(Layout paramLayout, int paramInt, float paramFloat)
    {
      return paramLayout.getLineWidth(paramInt) * (paramFloat / paramLayout.getPaint().getTextSize());
    }
    
    private void drawBackground(Canvas paramCanvas)
    {
      if (this.baseBackgroundDrawable != null)
      {
        this.baseBackgroundDrawable.setBounds(getLeft(), getTop(), getRight(), getBottom());
        this.baseBackgroundDrawable.draw(paramCanvas);
      }
    }
    
    private int getContentWidth()
    {
      View[] arrayOfView = new View[3];
      Object localObject = this.textView;
      int k = 0;
      arrayOfView[0] = localObject;
      arrayOfView[1] = this.iconView;
      arrayOfView[2] = this.customView;
      int i3 = arrayOfView.length;
      int m = 0;
      int i = 0;
      int n;
      for (int j = 0; k < i3; j = n)
      {
        localObject = arrayOfView[k];
        int i2 = m;
        int i1 = i;
        n = j;
        if (localObject != null)
        {
          i2 = m;
          i1 = i;
          n = j;
          if (((View)localObject).getVisibility() == 0)
          {
            if (j != 0) {
              i = Math.min(i, ((View)localObject).getLeft());
            } else {
              i = ((View)localObject).getLeft();
            }
            if (j != 0) {
              j = Math.max(m, ((View)localObject).getRight());
            } else {
              j = ((View)localObject).getRight();
            }
            n = 1;
            i1 = i;
            i2 = j;
          }
        }
        k += 1;
        m = i2;
        i = i1;
      }
      return m - i;
    }
    
    private void updateBackgroundDrawable(Context paramContext)
    {
      if (TabLayout.this.tabBackgroundResId != 0)
      {
        this.baseBackgroundDrawable = AppCompatResources.getDrawable(paramContext, TabLayout.this.tabBackgroundResId);
        if ((this.baseBackgroundDrawable != null) && (this.baseBackgroundDrawable.isStateful())) {
          this.baseBackgroundDrawable.setState(getDrawableState());
        }
      }
      else
      {
        this.baseBackgroundDrawable = null;
      }
      GradientDrawable localGradientDrawable = new GradientDrawable();
      ((GradientDrawable)localGradientDrawable).setColor(0);
      paramContext = localGradientDrawable;
      if (TabLayout.this.tabRippleColorStateList != null)
      {
        paramContext = new GradientDrawable();
        paramContext.setCornerRadius(1.0E-5F);
        paramContext.setColor(-1);
        ColorStateList localColorStateList = RippleUtils.convertToRippleDrawableColor(TabLayout.this.tabRippleColorStateList);
        if (Build.VERSION.SDK_INT >= 21)
        {
          if (TabLayout.this.unboundedRipple) {
            localGradientDrawable = null;
          }
          if (TabLayout.this.unboundedRipple) {
            paramContext = null;
          }
          paramContext = new RippleDrawable(localColorStateList, localGradientDrawable, paramContext);
        }
        else
        {
          paramContext = DrawableCompat.wrap(paramContext);
          DrawableCompat.setTintList(paramContext, localColorStateList);
          paramContext = new LayerDrawable(new Drawable[] { localGradientDrawable, paramContext });
        }
      }
      ViewCompat.setBackground(this, paramContext);
      TabLayout.this.invalidate();
    }
    
    private void updateTextAndIcon(@Nullable TextView paramTextView, @Nullable ImageView paramImageView)
    {
      Drawable localDrawable;
      if ((this.tab != null) && (this.tab.getIcon() != null)) {
        localDrawable = DrawableCompat.wrap(this.tab.getIcon()).mutate();
      } else {
        localDrawable = null;
      }
      CharSequence localCharSequence;
      if (this.tab != null) {
        localCharSequence = this.tab.getText();
      } else {
        localCharSequence = null;
      }
      if (paramImageView != null) {
        if (localDrawable != null)
        {
          paramImageView.setImageDrawable(localDrawable);
          paramImageView.setVisibility(0);
          setVisibility(0);
        }
        else
        {
          paramImageView.setVisibility(8);
          paramImageView.setImageDrawable(null);
        }
      }
      boolean bool = TextUtils.isEmpty(localCharSequence) ^ true;
      if (paramTextView != null) {
        if (bool)
        {
          paramTextView.setText(localCharSequence);
          paramTextView.setVisibility(0);
          setVisibility(0);
        }
        else
        {
          paramTextView.setVisibility(8);
          paramTextView.setText(null);
        }
      }
      if (paramImageView != null)
      {
        paramTextView = (ViewGroup.MarginLayoutParams)paramImageView.getLayoutParams();
        int i;
        if ((bool) && (paramImageView.getVisibility() == 0)) {
          i = TabLayout.this.dpToPx(8);
        } else {
          i = 0;
        }
        if (TabLayout.this.inlineLabel)
        {
          if (i != MarginLayoutParamsCompat.getMarginEnd(paramTextView))
          {
            MarginLayoutParamsCompat.setMarginEnd(paramTextView, i);
            paramTextView.bottomMargin = 0;
            paramImageView.setLayoutParams(paramTextView);
            paramImageView.requestLayout();
          }
        }
        else if (i != paramTextView.bottomMargin)
        {
          paramTextView.bottomMargin = i;
          MarginLayoutParamsCompat.setMarginEnd(paramTextView, 0);
          paramImageView.setLayoutParams(paramTextView);
          paramImageView.requestLayout();
        }
      }
      if (this.tab != null) {
        paramTextView = this.tab.contentDesc;
      } else {
        paramTextView = null;
      }
      if (bool) {
        paramTextView = null;
      }
      TooltipCompat.setTooltipText(this, paramTextView);
    }
    
    protected void drawableStateChanged()
    {
      super.drawableStateChanged();
      int[] arrayOfInt = getDrawableState();
      Drawable localDrawable = this.baseBackgroundDrawable;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (localDrawable != null)
      {
        bool1 = bool2;
        if (this.baseBackgroundDrawable.isStateful()) {
          bool1 = false | this.baseBackgroundDrawable.setState(arrayOfInt);
        }
      }
      if (bool1)
      {
        invalidate();
        TabLayout.this.invalidate();
      }
    }
    
    public TabLayout.Tab getTab()
    {
      return this.tab;
    }
    
    public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(ActionBar.Tab.class.getName());
    }
    
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
      paramAccessibilityNodeInfo.setClassName(ActionBar.Tab.class.getName());
    }
    
    public void onMeasure(int paramInt1, int paramInt2)
    {
      int j = View.MeasureSpec.getSize(paramInt1);
      int k = View.MeasureSpec.getMode(paramInt1);
      int m = TabLayout.this.getTabMaxWidth();
      int i = paramInt1;
      if (m > 0) {
        if (k != 0)
        {
          i = paramInt1;
          if (j <= m) {}
        }
        else
        {
          i = View.MeasureSpec.makeMeasureSpec(TabLayout.this.tabMaxWidth, Integer.MIN_VALUE);
        }
      }
      super.onMeasure(i, paramInt2);
      if (this.textView != null)
      {
        float f2 = TabLayout.this.tabTextSize;
        j = this.defaultMaxLines;
        Object localObject = this.iconView;
        k = 1;
        float f1;
        if ((localObject != null) && (this.iconView.getVisibility() == 0))
        {
          paramInt1 = 1;
          f1 = f2;
        }
        else
        {
          f1 = f2;
          paramInt1 = j;
          if (this.textView != null)
          {
            f1 = f2;
            paramInt1 = j;
            if (this.textView.getLineCount() > 1)
            {
              f1 = TabLayout.this.tabTextMultiLineSize;
              paramInt1 = j;
            }
          }
        }
        f2 = this.textView.getTextSize();
        m = this.textView.getLineCount();
        j = TextViewCompat.getMaxLines(this.textView);
        if ((f1 != f2) || ((j >= 0) && (paramInt1 != j)))
        {
          j = k;
          if (TabLayout.this.mode == 1)
          {
            j = k;
            if (f1 > f2)
            {
              j = k;
              if (m == 1)
              {
                localObject = this.textView.getLayout();
                if (localObject != null)
                {
                  j = k;
                  if (approximateLineWidth((Layout)localObject, 0, f1) <= getMeasuredWidth() - getPaddingLeft() - getPaddingRight()) {}
                }
                else
                {
                  j = 0;
                }
              }
            }
          }
          if (j != 0)
          {
            this.textView.setTextSize(0, f1);
            this.textView.setMaxLines(paramInt1);
            super.onMeasure(i, paramInt2);
          }
        }
      }
    }
    
    public boolean performClick()
    {
      boolean bool = super.performClick();
      if (this.tab != null)
      {
        if (!bool) {
          playSoundEffect(0);
        }
        this.tab.select();
        return true;
      }
      return bool;
    }
    
    void reset()
    {
      setTab(null);
      setSelected(false);
    }
    
    public void setSelected(boolean paramBoolean)
    {
      int i;
      if (isSelected() != paramBoolean) {
        i = 1;
      } else {
        i = 0;
      }
      super.setSelected(paramBoolean);
      if ((i != 0) && (paramBoolean) && (Build.VERSION.SDK_INT < 16)) {
        sendAccessibilityEvent(4);
      }
      if (this.textView != null) {
        this.textView.setSelected(paramBoolean);
      }
      if (this.iconView != null) {
        this.iconView.setSelected(paramBoolean);
      }
      if (this.customView != null) {
        this.customView.setSelected(paramBoolean);
      }
    }
    
    void setTab(@Nullable TabLayout.Tab paramTab)
    {
      if (paramTab != this.tab)
      {
        this.tab = paramTab;
        update();
      }
    }
    
    final void update()
    {
      TabLayout.Tab localTab = this.tab;
      Object localObject2 = null;
      if (localTab != null) {
        localObject1 = localTab.getCustomView();
      } else {
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        ViewParent localViewParent = ((View)localObject1).getParent();
        if (localViewParent != this)
        {
          if (localViewParent != null) {
            ((ViewGroup)localViewParent).removeView((View)localObject1);
          }
          addView((View)localObject1);
        }
        this.customView = ((View)localObject1);
        if (this.textView != null) {
          this.textView.setVisibility(8);
        }
        if (this.iconView != null)
        {
          this.iconView.setVisibility(8);
          this.iconView.setImageDrawable(null);
        }
        this.customTextView = ((TextView)((View)localObject1).findViewById(16908308));
        if (this.customTextView != null) {
          this.defaultMaxLines = TextViewCompat.getMaxLines(this.customTextView);
        }
        this.customIconView = ((ImageView)((View)localObject1).findViewById(16908294));
      }
      else
      {
        if (this.customView != null)
        {
          removeView(this.customView);
          this.customView = null;
        }
        this.customTextView = null;
        this.customIconView = null;
      }
      Object localObject1 = this.customView;
      boolean bool2 = false;
      if (localObject1 == null)
      {
        if (this.iconView == null)
        {
          localObject1 = (ImageView)LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_icon, this, false);
          addView((View)localObject1, 0);
          this.iconView = ((ImageView)localObject1);
        }
        localObject1 = localObject2;
        if (localTab != null)
        {
          localObject1 = localObject2;
          if (localTab.getIcon() != null) {
            localObject1 = DrawableCompat.wrap(localTab.getIcon()).mutate();
          }
        }
        if (localObject1 != null)
        {
          DrawableCompat.setTintList((Drawable)localObject1, TabLayout.this.tabIconTint);
          if (TabLayout.this.tabIconTintMode != null) {
            DrawableCompat.setTintMode((Drawable)localObject1, TabLayout.this.tabIconTintMode);
          }
        }
        if (this.textView == null)
        {
          localObject1 = (TextView)LayoutInflater.from(getContext()).inflate(R.layout.design_layout_tab_text, this, false);
          addView((View)localObject1);
          this.textView = ((TextView)localObject1);
          this.defaultMaxLines = TextViewCompat.getMaxLines(this.textView);
        }
        TextViewCompat.setTextAppearance(this.textView, TabLayout.this.tabTextAppearance);
        if (TabLayout.this.tabTextColors != null) {
          this.textView.setTextColor(TabLayout.this.tabTextColors);
        }
        updateTextAndIcon(this.textView, this.iconView);
      }
      else if ((this.customTextView != null) || (this.customIconView != null))
      {
        updateTextAndIcon(this.customTextView, this.customIconView);
      }
      if ((localTab != null) && (!TextUtils.isEmpty(localTab.contentDesc))) {
        setContentDescription(localTab.contentDesc);
      }
      boolean bool1 = bool2;
      if (localTab != null)
      {
        bool1 = bool2;
        if (localTab.isSelected()) {
          bool1 = true;
        }
      }
      setSelected(bool1);
    }
    
    final void updateOrientation()
    {
      setOrientation(TabLayout.this.inlineLabel ^ true);
      if ((this.customTextView == null) && (this.customIconView == null))
      {
        updateTextAndIcon(this.textView, this.iconView);
        return;
      }
      updateTextAndIcon(this.customTextView, this.customIconView);
    }
  }
  
  public static class ViewPagerOnTabSelectedListener
    implements TabLayout.OnTabSelectedListener
  {
    private final ViewPager viewPager;
    
    public ViewPagerOnTabSelectedListener(ViewPager paramViewPager)
    {
      this.viewPager = paramViewPager;
    }
    
    public void onTabReselected(TabLayout.Tab paramTab) {}
    
    public void onTabSelected(TabLayout.Tab paramTab)
    {
      this.viewPager.setCurrentItem(paramTab.getPosition());
    }
    
    public void onTabUnselected(TabLayout.Tab paramTab) {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\design\widget\TabLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */