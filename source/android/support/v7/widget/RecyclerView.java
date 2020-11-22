package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Px;
import android.support.annotation.RestrictTo;
import android.support.annotation.VisibleForTesting;
import android.support.v4.os.TraceCompat;
import android.support.v4.util.Preconditions;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingChild2;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.ScrollingView;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.support.v7.recyclerview.R.dimen;
import android.support.v7.recyclerview.R.styleable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerView
  extends ViewGroup
  implements NestedScrollingChild2, ScrollingView
{
  static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC;
  static final boolean ALLOW_THREAD_GAP_WORK;
  private static final int[] CLIP_TO_PADDING_ATTR;
  static final boolean DEBUG = false;
  static final int DEFAULT_ORIENTATION = 1;
  static final boolean DISPATCH_TEMP_DETACH = false;
  private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION;
  static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
  static final long FOREVER_NS = Long.MAX_VALUE;
  public static final int HORIZONTAL = 0;
  private static final boolean IGNORE_DETACHED_FOCUSED_CHILD;
  private static final int INVALID_POINTER = -1;
  public static final int INVALID_TYPE = -1;
  private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = { Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE };
  static final int MAX_SCROLL_DURATION = 2000;
  private static final int[] NESTED_SCROLLING_ATTRS = { 16843830 };
  public static final long NO_ID = -1L;
  public static final int NO_POSITION = -1;
  static final boolean POST_UPDATES_ON_ANIMATION;
  public static final int SCROLL_STATE_DRAGGING = 1;
  public static final int SCROLL_STATE_IDLE = 0;
  public static final int SCROLL_STATE_SETTLING = 2;
  static final String TAG = "RecyclerView";
  public static final int TOUCH_SLOP_DEFAULT = 0;
  public static final int TOUCH_SLOP_PAGING = 1;
  static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
  static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
  private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
  static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
  private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
  private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
  static final String TRACE_PREFETCH_TAG = "RV Prefetch";
  static final String TRACE_SCROLL_TAG = "RV Scroll";
  static final boolean VERBOSE_TRACING = false;
  public static final int VERTICAL = 1;
  static final Interpolator sQuinticInterpolator = new Interpolator()
  {
    public float getInterpolation(float paramAnonymousFloat)
    {
      paramAnonymousFloat -= 1.0F;
      return paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat + 1.0F;
    }
  };
  RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
  private final AccessibilityManager mAccessibilityManager;
  private OnItemTouchListener mActiveOnItemTouchListener;
  Adapter mAdapter;
  AdapterHelper mAdapterHelper;
  boolean mAdapterUpdateDuringMeasure;
  private EdgeEffect mBottomGlow;
  private ChildDrawingOrderCallback mChildDrawingOrderCallback;
  ChildHelper mChildHelper;
  boolean mClipToPadding;
  boolean mDataSetHasChangedAfterLayout = false;
  boolean mDispatchItemsChangedEvent = false;
  private int mDispatchScrollCounter = 0;
  private int mEatenAccessibilityChangeFlags;
  @NonNull
  private EdgeEffectFactory mEdgeEffectFactory = new EdgeEffectFactory();
  boolean mEnableFastScroller;
  @VisibleForTesting
  boolean mFirstLayoutComplete;
  GapWorker mGapWorker;
  boolean mHasFixedSize;
  private boolean mIgnoreMotionEventTillDown;
  private int mInitialTouchX;
  private int mInitialTouchY;
  private int mInterceptRequestLayoutDepth = 0;
  boolean mIsAttached;
  ItemAnimator mItemAnimator = new DefaultItemAnimator();
  private RecyclerView.ItemAnimator.ItemAnimatorListener mItemAnimatorListener;
  private Runnable mItemAnimatorRunner;
  final ArrayList<ItemDecoration> mItemDecorations = new ArrayList();
  boolean mItemsAddedOrRemoved;
  boolean mItemsChanged;
  private int mLastTouchX;
  private int mLastTouchY;
  @VisibleForTesting
  LayoutManager mLayout;
  boolean mLayoutFrozen;
  private int mLayoutOrScrollCounter = 0;
  boolean mLayoutWasDefered;
  private EdgeEffect mLeftGlow;
  private final int mMaxFlingVelocity;
  private final int mMinFlingVelocity;
  private final int[] mMinMaxLayoutPositions;
  private final int[] mNestedOffsets;
  private final RecyclerViewDataObserver mObserver = new RecyclerViewDataObserver();
  private List<OnChildAttachStateChangeListener> mOnChildAttachStateListeners;
  private OnFlingListener mOnFlingListener;
  private final ArrayList<OnItemTouchListener> mOnItemTouchListeners = new ArrayList();
  @VisibleForTesting
  final List<ViewHolder> mPendingAccessibilityImportanceChange;
  private SavedState mPendingSavedState;
  boolean mPostedAnimatorRunner;
  GapWorker.LayoutPrefetchRegistryImpl mPrefetchRegistry;
  private boolean mPreserveFocusAfterLayout;
  final Recycler mRecycler = new Recycler();
  RecyclerListener mRecyclerListener;
  private EdgeEffect mRightGlow;
  private float mScaledHorizontalScrollFactor = Float.MIN_VALUE;
  private float mScaledVerticalScrollFactor = Float.MIN_VALUE;
  final int[] mScrollConsumed;
  private OnScrollListener mScrollListener;
  private List<OnScrollListener> mScrollListeners;
  private final int[] mScrollOffset;
  private int mScrollPointerId = -1;
  private int mScrollState = 0;
  final int[] mScrollStepConsumed;
  private NestedScrollingChildHelper mScrollingChildHelper;
  final State mState;
  final Rect mTempRect = new Rect();
  private final Rect mTempRect2 = new Rect();
  final RectF mTempRectF = new RectF();
  private EdgeEffect mTopGlow;
  private int mTouchSlop;
  final Runnable mUpdateChildViewsRunnable = new Runnable()
  {
    public void run()
    {
      if (RecyclerView.this.mFirstLayoutComplete)
      {
        if (RecyclerView.this.isLayoutRequested()) {
          return;
        }
        if (!RecyclerView.this.mIsAttached)
        {
          RecyclerView.this.requestLayout();
          return;
        }
        if (RecyclerView.this.mLayoutFrozen)
        {
          RecyclerView.this.mLayoutWasDefered = true;
          return;
        }
        RecyclerView.this.consumePendingUpdateOperations();
        return;
      }
    }
  };
  private VelocityTracker mVelocityTracker;
  final ViewFlinger mViewFlinger;
  private final ViewInfoStore.ProcessCallback mViewInfoProcessCallback;
  final ViewInfoStore mViewInfoStore = new ViewInfoStore();
  
  static
  {
    CLIP_TO_PADDING_ATTR = new int[] { 16842987 };
    boolean bool;
    if ((Build.VERSION.SDK_INT != 18) && (Build.VERSION.SDK_INT != 19) && (Build.VERSION.SDK_INT != 20)) {
      bool = false;
    } else {
      bool = true;
    }
    FORCE_INVALIDATE_DISPLAY_LIST = bool;
    if (Build.VERSION.SDK_INT >= 23) {
      bool = true;
    } else {
      bool = false;
    }
    ALLOW_SIZE_IN_UNSPECIFIED_SPEC = bool;
    if (Build.VERSION.SDK_INT >= 16) {
      bool = true;
    } else {
      bool = false;
    }
    POST_UPDATES_ON_ANIMATION = bool;
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    } else {
      bool = false;
    }
    ALLOW_THREAD_GAP_WORK = bool;
    if (Build.VERSION.SDK_INT <= 15) {
      bool = true;
    } else {
      bool = false;
    }
    FORCE_ABS_FOCUS_SEARCH_DIRECTION = bool;
    if (Build.VERSION.SDK_INT <= 15) {
      bool = true;
    } else {
      bool = false;
    }
    IGNORE_DETACHED_FOCUSED_CHILD = bool;
  }
  
  public RecyclerView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RecyclerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RecyclerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    boolean bool2 = true;
    this.mPreserveFocusAfterLayout = true;
    this.mViewFlinger = new ViewFlinger();
    if (ALLOW_THREAD_GAP_WORK) {
      localObject = new GapWorker.LayoutPrefetchRegistryImpl();
    } else {
      localObject = null;
    }
    this.mPrefetchRegistry = ((GapWorker.LayoutPrefetchRegistryImpl)localObject);
    this.mState = new State();
    this.mItemsAddedOrRemoved = false;
    this.mItemsChanged = false;
    this.mItemAnimatorListener = new ItemAnimatorRestoreListener();
    this.mPostedAnimatorRunner = false;
    this.mMinMaxLayoutPositions = new int[2];
    this.mScrollOffset = new int[2];
    this.mScrollConsumed = new int[2];
    this.mNestedOffsets = new int[2];
    this.mScrollStepConsumed = new int[2];
    this.mPendingAccessibilityImportanceChange = new ArrayList();
    this.mItemAnimatorRunner = new Runnable()
    {
      public void run()
      {
        if (RecyclerView.this.mItemAnimator != null) {
          RecyclerView.this.mItemAnimator.runPendingAnimations();
        }
        RecyclerView.this.mPostedAnimatorRunner = false;
      }
    };
    this.mViewInfoProcessCallback = new ViewInfoStore.ProcessCallback()
    {
      public void processAppeared(RecyclerView.ViewHolder paramAnonymousViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramAnonymousItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo paramAnonymousItemHolderInfo2)
      {
        RecyclerView.this.animateAppearance(paramAnonymousViewHolder, paramAnonymousItemHolderInfo1, paramAnonymousItemHolderInfo2);
      }
      
      public void processDisappeared(RecyclerView.ViewHolder paramAnonymousViewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramAnonymousItemHolderInfo1, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo paramAnonymousItemHolderInfo2)
      {
        RecyclerView.this.mRecycler.unscrapView(paramAnonymousViewHolder);
        RecyclerView.this.animateDisappearance(paramAnonymousViewHolder, paramAnonymousItemHolderInfo1, paramAnonymousItemHolderInfo2);
      }
      
      public void processPersistent(RecyclerView.ViewHolder paramAnonymousViewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramAnonymousItemHolderInfo1, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramAnonymousItemHolderInfo2)
      {
        paramAnonymousViewHolder.setIsRecyclable(false);
        if (RecyclerView.this.mDataSetHasChangedAfterLayout)
        {
          if (RecyclerView.this.mItemAnimator.animateChange(paramAnonymousViewHolder, paramAnonymousViewHolder, paramAnonymousItemHolderInfo1, paramAnonymousItemHolderInfo2)) {
            RecyclerView.this.postAnimationRunner();
          }
        }
        else if (RecyclerView.this.mItemAnimator.animatePersistence(paramAnonymousViewHolder, paramAnonymousItemHolderInfo1, paramAnonymousItemHolderInfo2)) {
          RecyclerView.this.postAnimationRunner();
        }
      }
      
      public void unused(RecyclerView.ViewHolder paramAnonymousViewHolder)
      {
        RecyclerView.this.mLayout.removeAndRecycleView(paramAnonymousViewHolder.itemView, RecyclerView.this.mRecycler);
      }
    };
    if (paramAttributeSet != null)
    {
      localObject = paramContext.obtainStyledAttributes(paramAttributeSet, CLIP_TO_PADDING_ATTR, paramInt, 0);
      this.mClipToPadding = ((TypedArray)localObject).getBoolean(0, true);
      ((TypedArray)localObject).recycle();
    }
    else
    {
      this.mClipToPadding = true;
    }
    setScrollContainer(true);
    setFocusableInTouchMode(true);
    Object localObject = ViewConfiguration.get(paramContext);
    this.mTouchSlop = ((ViewConfiguration)localObject).getScaledTouchSlop();
    this.mScaledHorizontalScrollFactor = ViewConfigurationCompat.getScaledHorizontalScrollFactor((ViewConfiguration)localObject, paramContext);
    this.mScaledVerticalScrollFactor = ViewConfigurationCompat.getScaledVerticalScrollFactor((ViewConfiguration)localObject, paramContext);
    this.mMinFlingVelocity = ((ViewConfiguration)localObject).getScaledMinimumFlingVelocity();
    this.mMaxFlingVelocity = ((ViewConfiguration)localObject).getScaledMaximumFlingVelocity();
    boolean bool1;
    if (getOverScrollMode() == 2) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    setWillNotDraw(bool1);
    this.mItemAnimator.setListener(this.mItemAnimatorListener);
    initAdapterManager();
    initChildrenHelper();
    initAutofill();
    if (ViewCompat.getImportantForAccessibility(this) == 0) {
      ViewCompat.setImportantForAccessibility(this, 1);
    }
    this.mAccessibilityManager = ((AccessibilityManager)getContext().getSystemService("accessibility"));
    setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
    if (paramAttributeSet != null)
    {
      localObject = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RecyclerView, paramInt, 0);
      String str = ((TypedArray)localObject).getString(R.styleable.RecyclerView_layoutManager);
      if (((TypedArray)localObject).getInt(R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
        setDescendantFocusability(262144);
      }
      this.mEnableFastScroller = ((TypedArray)localObject).getBoolean(R.styleable.RecyclerView_fastScrollEnabled, false);
      if (this.mEnableFastScroller) {
        initFastScroller((StateListDrawable)((TypedArray)localObject).getDrawable(R.styleable.RecyclerView_fastScrollVerticalThumbDrawable), ((TypedArray)localObject).getDrawable(R.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable)((TypedArray)localObject).getDrawable(R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), ((TypedArray)localObject).getDrawable(R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
      }
      ((TypedArray)localObject).recycle();
      createLayoutManager(paramContext, str, paramAttributeSet, paramInt, 0);
      bool1 = bool2;
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, NESTED_SCROLLING_ATTRS, paramInt, 0);
        bool1 = paramContext.getBoolean(0, true);
        paramContext.recycle();
      }
    }
    else
    {
      setDescendantFocusability(262144);
      bool1 = bool2;
    }
    setNestedScrollingEnabled(bool1);
  }
  
  private void addAnimatingView(ViewHolder paramViewHolder)
  {
    View localView = paramViewHolder.itemView;
    int i;
    if (localView.getParent() == this) {
      i = 1;
    } else {
      i = 0;
    }
    this.mRecycler.unscrapView(getChildViewHolder(localView));
    if (paramViewHolder.isTmpDetached())
    {
      this.mChildHelper.attachViewToParent(localView, -1, localView.getLayoutParams(), true);
      return;
    }
    if (i == 0)
    {
      this.mChildHelper.addView(localView, true);
      return;
    }
    this.mChildHelper.hide(localView);
  }
  
  private void animateChange(@NonNull ViewHolder paramViewHolder1, @NonNull ViewHolder paramViewHolder2, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramViewHolder1.setIsRecyclable(false);
    if (paramBoolean1) {
      addAnimatingView(paramViewHolder1);
    }
    if (paramViewHolder1 != paramViewHolder2)
    {
      if (paramBoolean2) {
        addAnimatingView(paramViewHolder2);
      }
      paramViewHolder1.mShadowedHolder = paramViewHolder2;
      addAnimatingView(paramViewHolder1);
      this.mRecycler.unscrapView(paramViewHolder1);
      paramViewHolder2.setIsRecyclable(false);
      paramViewHolder2.mShadowingHolder = paramViewHolder1;
    }
    if (this.mItemAnimator.animateChange(paramViewHolder1, paramViewHolder2, paramItemHolderInfo1, paramItemHolderInfo2)) {
      postAnimationRunner();
    }
  }
  
  private void cancelTouch()
  {
    resetTouch();
    setScrollState(0);
  }
  
  static void clearNestedRecyclerViewIfNotNested(@NonNull ViewHolder paramViewHolder)
  {
    if (paramViewHolder.mNestedRecyclerView != null)
    {
      Object localObject = (View)paramViewHolder.mNestedRecyclerView.get();
      while (localObject != null)
      {
        if (localObject == paramViewHolder.itemView) {
          return;
        }
        localObject = ((View)localObject).getParent();
        if ((localObject instanceof View)) {
          localObject = (View)localObject;
        } else {
          localObject = null;
        }
      }
      paramViewHolder.mNestedRecyclerView = null;
    }
  }
  
  private void createLayoutManager(Context paramContext, String paramString, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    if (paramString != null)
    {
      paramString = paramString.trim();
      if (!paramString.isEmpty())
      {
        String str = getFullClassName(paramContext, paramString);
        try
        {
          if (isInEditMode()) {
            paramString = getClass().getClassLoader();
          } else {
            paramString = paramContext.getClassLoader();
          }
          Class localClass = paramString.loadClass(str).asSubclass(LayoutManager.class);
          Object localObject = null;
          try
          {
            paramString = localClass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
            paramContext = new Object[] { paramContext, paramAttributeSet, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) };
          }
          catch (NoSuchMethodException paramContext) {}
          try
          {
            paramString = localClass.getConstructor(new Class[0]);
            paramContext = (Context)localObject;
            paramString.setAccessible(true);
            setLayoutManager((LayoutManager)paramString.newInstance(paramContext));
            return;
          }
          catch (NoSuchMethodException paramString)
          {
            paramString.initCause(paramContext);
            paramContext = new StringBuilder();
            paramContext.append(paramAttributeSet.getPositionDescription());
            paramContext.append(": Error creating LayoutManager ");
            paramContext.append(str);
            throw new IllegalStateException(paramContext.toString(), paramString);
          }
          return;
        }
        catch (ClassCastException paramContext)
        {
          paramString = new StringBuilder();
          paramString.append(paramAttributeSet.getPositionDescription());
          paramString.append(": Class is not a LayoutManager ");
          paramString.append(str);
          throw new IllegalStateException(paramString.toString(), paramContext);
        }
        catch (IllegalAccessException paramContext)
        {
          paramString = new StringBuilder();
          paramString.append(paramAttributeSet.getPositionDescription());
          paramString.append(": Cannot access non-public constructor ");
          paramString.append(str);
          throw new IllegalStateException(paramString.toString(), paramContext);
        }
        catch (InstantiationException paramContext)
        {
          paramString = new StringBuilder();
          paramString.append(paramAttributeSet.getPositionDescription());
          paramString.append(": Could not instantiate the LayoutManager: ");
          paramString.append(str);
          throw new IllegalStateException(paramString.toString(), paramContext);
        }
        catch (InvocationTargetException paramContext)
        {
          paramString = new StringBuilder();
          paramString.append(paramAttributeSet.getPositionDescription());
          paramString.append(": Could not instantiate the LayoutManager: ");
          paramString.append(str);
          throw new IllegalStateException(paramString.toString(), paramContext);
        }
        catch (ClassNotFoundException paramContext)
        {
          paramString = new StringBuilder();
          paramString.append(paramAttributeSet.getPositionDescription());
          paramString.append(": Unable to find LayoutManager ");
          paramString.append(str);
          throw new IllegalStateException(paramString.toString(), paramContext);
        }
      }
    }
  }
  
  private boolean didChildRangeChange(int paramInt1, int paramInt2)
  {
    findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
    int[] arrayOfInt = this.mMinMaxLayoutPositions;
    boolean bool = false;
    if ((arrayOfInt[0] != paramInt1) || (this.mMinMaxLayoutPositions[1] != paramInt2)) {
      bool = true;
    }
    return bool;
  }
  
  private void dispatchContentChangedIfNecessary()
  {
    int i = this.mEatenAccessibilityChangeFlags;
    this.mEatenAccessibilityChangeFlags = 0;
    if ((i != 0) && (isAccessibilityEnabled()))
    {
      AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain();
      localAccessibilityEvent.setEventType(2048);
      AccessibilityEventCompat.setContentChangeTypes(localAccessibilityEvent, i);
      sendAccessibilityEventUnchecked(localAccessibilityEvent);
    }
  }
  
  private void dispatchLayoutStep1()
  {
    Object localObject = this.mState;
    boolean bool = true;
    ((State)localObject).assertLayoutStep(1);
    fillRemainingScrollValues(this.mState);
    this.mState.mIsMeasuring = false;
    startInterceptRequestLayout();
    this.mViewInfoStore.clear();
    onEnterLayoutOrScroll();
    processAdapterUpdatesAndSetAnimationFlags();
    saveFocusInfo();
    localObject = this.mState;
    if ((!this.mState.mRunSimpleAnimations) || (!this.mItemsChanged)) {
      bool = false;
    }
    ((State)localObject).mTrackOldChangeHolders = bool;
    this.mItemsChanged = false;
    this.mItemsAddedOrRemoved = false;
    this.mState.mInPreLayout = this.mState.mRunPredictiveAnimations;
    this.mState.mItemCount = this.mAdapter.getItemCount();
    findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
    int j;
    int i;
    RecyclerView.ItemAnimator.ItemHolderInfo localItemHolderInfo;
    if (this.mState.mRunSimpleAnimations)
    {
      j = this.mChildHelper.getChildCount();
      i = 0;
      while (i < j)
      {
        localObject = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
        if ((!((ViewHolder)localObject).shouldIgnore()) && ((!((ViewHolder)localObject).isInvalid()) || (this.mAdapter.hasStableIds())))
        {
          localItemHolderInfo = this.mItemAnimator.recordPreLayoutInformation(this.mState, (ViewHolder)localObject, ItemAnimator.buildAdapterChangeFlagsForAnimations((ViewHolder)localObject), ((ViewHolder)localObject).getUnmodifiedPayloads());
          this.mViewInfoStore.addToPreLayout((ViewHolder)localObject, localItemHolderInfo);
          if ((this.mState.mTrackOldChangeHolders) && (((ViewHolder)localObject).isUpdated()) && (!((ViewHolder)localObject).isRemoved()) && (!((ViewHolder)localObject).shouldIgnore()) && (!((ViewHolder)localObject).isInvalid()))
          {
            long l = getChangedHolderKey((ViewHolder)localObject);
            this.mViewInfoStore.addToOldChangeHolders(l, (ViewHolder)localObject);
          }
        }
        i += 1;
      }
    }
    if (this.mState.mRunPredictiveAnimations)
    {
      saveOldPositions();
      bool = this.mState.mStructureChanged;
      this.mState.mStructureChanged = false;
      this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
      this.mState.mStructureChanged = bool;
      i = 0;
      while (i < this.mChildHelper.getChildCount())
      {
        localObject = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
        if ((!((ViewHolder)localObject).shouldIgnore()) && (!this.mViewInfoStore.isInPreLayout((ViewHolder)localObject)))
        {
          int k = ItemAnimator.buildAdapterChangeFlagsForAnimations((ViewHolder)localObject);
          bool = ((ViewHolder)localObject).hasAnyOfTheFlags(8192);
          j = k;
          if (!bool) {
            j = k | 0x1000;
          }
          localItemHolderInfo = this.mItemAnimator.recordPreLayoutInformation(this.mState, (ViewHolder)localObject, j, ((ViewHolder)localObject).getUnmodifiedPayloads());
          if (bool) {
            recordAnimationInfoIfBouncedHiddenView((ViewHolder)localObject, localItemHolderInfo);
          } else {
            this.mViewInfoStore.addToAppearedInPreLayoutHolders((ViewHolder)localObject, localItemHolderInfo);
          }
        }
        i += 1;
      }
      clearOldPositions();
    }
    else
    {
      clearOldPositions();
    }
    onExitLayoutOrScroll();
    stopInterceptRequestLayout(false);
    this.mState.mLayoutStep = 2;
  }
  
  private void dispatchLayoutStep2()
  {
    startInterceptRequestLayout();
    onEnterLayoutOrScroll();
    this.mState.assertLayoutStep(6);
    this.mAdapterHelper.consumeUpdatesInOnePass();
    this.mState.mItemCount = this.mAdapter.getItemCount();
    this.mState.mDeletedInvisibleItemCountSincePreviousLayout = 0;
    this.mState.mInPreLayout = false;
    this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
    this.mState.mStructureChanged = false;
    this.mPendingSavedState = null;
    State localState = this.mState;
    boolean bool;
    if ((this.mState.mRunSimpleAnimations) && (this.mItemAnimator != null)) {
      bool = true;
    } else {
      bool = false;
    }
    localState.mRunSimpleAnimations = bool;
    this.mState.mLayoutStep = 4;
    onExitLayoutOrScroll();
    stopInterceptRequestLayout(false);
  }
  
  private void dispatchLayoutStep3()
  {
    this.mState.assertLayoutStep(4);
    startInterceptRequestLayout();
    onEnterLayoutOrScroll();
    this.mState.mLayoutStep = 1;
    if (this.mState.mRunSimpleAnimations)
    {
      int i = this.mChildHelper.getChildCount() - 1;
      while (i >= 0)
      {
        ViewHolder localViewHolder1 = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
        if (!localViewHolder1.shouldIgnore())
        {
          long l = getChangedHolderKey(localViewHolder1);
          RecyclerView.ItemAnimator.ItemHolderInfo localItemHolderInfo2 = this.mItemAnimator.recordPostLayoutInformation(this.mState, localViewHolder1);
          ViewHolder localViewHolder2 = this.mViewInfoStore.getFromOldChangeHolders(l);
          if ((localViewHolder2 != null) && (!localViewHolder2.shouldIgnore()))
          {
            boolean bool1 = this.mViewInfoStore.isDisappearing(localViewHolder2);
            boolean bool2 = this.mViewInfoStore.isDisappearing(localViewHolder1);
            if ((bool1) && (localViewHolder2 == localViewHolder1))
            {
              this.mViewInfoStore.addToPostLayout(localViewHolder1, localItemHolderInfo2);
            }
            else
            {
              RecyclerView.ItemAnimator.ItemHolderInfo localItemHolderInfo1 = this.mViewInfoStore.popFromPreLayout(localViewHolder2);
              this.mViewInfoStore.addToPostLayout(localViewHolder1, localItemHolderInfo2);
              localItemHolderInfo2 = this.mViewInfoStore.popFromPostLayout(localViewHolder1);
              if (localItemHolderInfo1 == null) {
                handleMissingPreInfoForChangeError(l, localViewHolder1, localViewHolder2);
              } else {
                animateChange(localViewHolder2, localViewHolder1, localItemHolderInfo1, localItemHolderInfo2, bool1, bool2);
              }
            }
          }
          else
          {
            this.mViewInfoStore.addToPostLayout(localViewHolder1, localItemHolderInfo2);
          }
        }
        i -= 1;
      }
      this.mViewInfoStore.process(this.mViewInfoProcessCallback);
    }
    this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
    this.mState.mPreviousLayoutItemCount = this.mState.mItemCount;
    this.mDataSetHasChangedAfterLayout = false;
    this.mDispatchItemsChangedEvent = false;
    this.mState.mRunSimpleAnimations = false;
    this.mState.mRunPredictiveAnimations = false;
    this.mLayout.mRequestedSimpleAnimations = false;
    if (this.mRecycler.mChangedScrap != null) {
      this.mRecycler.mChangedScrap.clear();
    }
    if (this.mLayout.mPrefetchMaxObservedInInitialPrefetch)
    {
      this.mLayout.mPrefetchMaxCountObserved = 0;
      this.mLayout.mPrefetchMaxObservedInInitialPrefetch = false;
      this.mRecycler.updateViewCacheSize();
    }
    this.mLayout.onLayoutCompleted(this.mState);
    onExitLayoutOrScroll();
    stopInterceptRequestLayout(false);
    this.mViewInfoStore.clear();
    if (didChildRangeChange(this.mMinMaxLayoutPositions[0], this.mMinMaxLayoutPositions[1])) {
      dispatchOnScrolled(0, 0);
    }
    recoverFocusFromState();
    resetFocusInfo();
  }
  
  private boolean dispatchOnItemTouch(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (this.mActiveOnItemTouchListener != null) {
      if (i == 0)
      {
        this.mActiveOnItemTouchListener = null;
      }
      else
      {
        this.mActiveOnItemTouchListener.onTouchEvent(this, paramMotionEvent);
        if ((i == 3) || (i == 1)) {
          this.mActiveOnItemTouchListener = null;
        }
        return true;
      }
    }
    if (i != 0)
    {
      int j = this.mOnItemTouchListeners.size();
      i = 0;
      while (i < j)
      {
        OnItemTouchListener localOnItemTouchListener = (OnItemTouchListener)this.mOnItemTouchListeners.get(i);
        if (localOnItemTouchListener.onInterceptTouchEvent(this, paramMotionEvent))
        {
          this.mActiveOnItemTouchListener = localOnItemTouchListener;
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  private boolean dispatchOnItemTouchIntercept(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getAction();
    if ((j == 3) || (j == 0)) {
      this.mActiveOnItemTouchListener = null;
    }
    int k = this.mOnItemTouchListeners.size();
    int i = 0;
    while (i < k)
    {
      OnItemTouchListener localOnItemTouchListener = (OnItemTouchListener)this.mOnItemTouchListeners.get(i);
      if ((localOnItemTouchListener.onInterceptTouchEvent(this, paramMotionEvent)) && (j != 3))
      {
        this.mActiveOnItemTouchListener = localOnItemTouchListener;
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private void findMinMaxChildLayoutPositions(int[] paramArrayOfInt)
  {
    int i2 = this.mChildHelper.getChildCount();
    if (i2 == 0)
    {
      paramArrayOfInt[0] = -1;
      paramArrayOfInt[1] = -1;
      return;
    }
    int m = 0;
    int j = Integer.MAX_VALUE;
    int i1;
    for (int k = Integer.MIN_VALUE; m < i2; k = i1)
    {
      ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getChildAt(m));
      if (localViewHolder.shouldIgnore())
      {
        i1 = k;
      }
      else
      {
        int n = localViewHolder.getLayoutPosition();
        int i = j;
        if (n < j) {
          i = n;
        }
        j = i;
        i1 = k;
        if (n > k)
        {
          i1 = n;
          j = i;
        }
      }
      m += 1;
    }
    paramArrayOfInt[0] = j;
    paramArrayOfInt[1] = k;
  }
  
  @Nullable
  static RecyclerView findNestedRecyclerView(@NonNull View paramView)
  {
    if (!(paramView instanceof ViewGroup)) {
      return null;
    }
    if ((paramView instanceof RecyclerView)) {
      return (RecyclerView)paramView;
    }
    paramView = (ViewGroup)paramView;
    int j = paramView.getChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerView localRecyclerView = findNestedRecyclerView(paramView.getChildAt(i));
      if (localRecyclerView != null) {
        return localRecyclerView;
      }
      i += 1;
    }
    return null;
  }
  
  @Nullable
  private View findNextViewToFocus()
  {
    if (this.mState.mFocusedItemPosition != -1) {
      i = this.mState.mFocusedItemPosition;
    } else {
      i = 0;
    }
    int k = this.mState.getItemCount();
    int j = i;
    ViewHolder localViewHolder;
    while (j < k)
    {
      localViewHolder = findViewHolderForAdapterPosition(j);
      if (localViewHolder == null) {
        break;
      }
      if (localViewHolder.itemView.hasFocusable()) {
        return localViewHolder.itemView;
      }
      j += 1;
    }
    int i = Math.min(k, i) - 1;
    while (i >= 0)
    {
      localViewHolder = findViewHolderForAdapterPosition(i);
      if (localViewHolder == null) {
        return null;
      }
      if (localViewHolder.itemView.hasFocusable()) {
        return localViewHolder.itemView;
      }
      i -= 1;
    }
    return null;
  }
  
  static ViewHolder getChildViewHolderInt(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    return ((LayoutParams)paramView.getLayoutParams()).mViewHolder;
  }
  
  static void getDecoratedBoundsWithMarginsInt(View paramView, Rect paramRect)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    Rect localRect = localLayoutParams.mDecorInsets;
    paramRect.set(paramView.getLeft() - localRect.left - localLayoutParams.leftMargin, paramView.getTop() - localRect.top - localLayoutParams.topMargin, paramView.getRight() + localRect.right + localLayoutParams.rightMargin, paramView.getBottom() + localRect.bottom + localLayoutParams.bottomMargin);
  }
  
  private int getDeepestFocusedViewWithId(View paramView)
  {
    int i = paramView.getId();
    while ((!paramView.isFocused()) && ((paramView instanceof ViewGroup)) && (paramView.hasFocus()))
    {
      View localView = ((ViewGroup)paramView).getFocusedChild();
      paramView = localView;
      if (localView.getId() != -1)
      {
        i = localView.getId();
        paramView = localView;
      }
    }
    return i;
  }
  
  private String getFullClassName(Context paramContext, String paramString)
  {
    if (paramString.charAt(0) == '.')
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getPackageName());
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    if (paramString.contains(".")) {
      return paramString;
    }
    paramContext = new StringBuilder();
    paramContext.append(RecyclerView.class.getPackage().getName());
    paramContext.append('.');
    paramContext.append(paramString);
    return paramContext.toString();
  }
  
  private NestedScrollingChildHelper getScrollingChildHelper()
  {
    if (this.mScrollingChildHelper == null) {
      this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
    }
    return this.mScrollingChildHelper;
  }
  
  private void handleMissingPreInfoForChangeError(long paramLong, ViewHolder paramViewHolder1, ViewHolder paramViewHolder2)
  {
    int j = this.mChildHelper.getChildCount();
    int i = 0;
    while (i < j)
    {
      localObject = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
      if ((localObject != paramViewHolder1) && (getChangedHolderKey((ViewHolder)localObject) == paramLong))
      {
        if ((this.mAdapter != null) && (this.mAdapter.hasStableIds()))
        {
          paramViewHolder2 = new StringBuilder();
          paramViewHolder2.append("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
          paramViewHolder2.append(localObject);
          paramViewHolder2.append(" \n View Holder 2:");
          paramViewHolder2.append(paramViewHolder1);
          paramViewHolder2.append(exceptionLabel());
          throw new IllegalStateException(paramViewHolder2.toString());
        }
        paramViewHolder2 = new StringBuilder();
        paramViewHolder2.append("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
        paramViewHolder2.append(localObject);
        paramViewHolder2.append(" \n View Holder 2:");
        paramViewHolder2.append(paramViewHolder1);
        paramViewHolder2.append(exceptionLabel());
        throw new IllegalStateException(paramViewHolder2.toString());
      }
      i += 1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Problem while matching changed view holders with the newones. The pre-layout information for the change holder ");
    ((StringBuilder)localObject).append(paramViewHolder2);
    ((StringBuilder)localObject).append(" cannot be found but it is necessary for ");
    ((StringBuilder)localObject).append(paramViewHolder1);
    ((StringBuilder)localObject).append(exceptionLabel());
    Log.e("RecyclerView", ((StringBuilder)localObject).toString());
  }
  
  private boolean hasUpdatedView()
  {
    int j = this.mChildHelper.getChildCount();
    int i = 0;
    while (i < j)
    {
      ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getChildAt(i));
      if ((localViewHolder != null) && (!localViewHolder.shouldIgnore()) && (localViewHolder.isUpdated())) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  @SuppressLint({"InlinedApi"})
  private void initAutofill()
  {
    if (ViewCompat.getImportantForAutofill(this) == 0) {
      ViewCompat.setImportantForAutofill(this, 8);
    }
  }
  
  private void initChildrenHelper()
  {
    this.mChildHelper = new ChildHelper(new ChildHelper.Callback()
    {
      public void addView(View paramAnonymousView, int paramAnonymousInt)
      {
        RecyclerView.this.addView(paramAnonymousView, paramAnonymousInt);
        RecyclerView.this.dispatchChildAttached(paramAnonymousView);
      }
      
      public void attachViewToParent(View paramAnonymousView, int paramAnonymousInt, ViewGroup.LayoutParams paramAnonymousLayoutParams)
      {
        RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramAnonymousView);
        if (localViewHolder != null)
        {
          if ((!localViewHolder.isTmpDetached()) && (!localViewHolder.shouldIgnore()))
          {
            paramAnonymousView = new StringBuilder();
            paramAnonymousView.append("Called attach on a child which is not detached: ");
            paramAnonymousView.append(localViewHolder);
            paramAnonymousView.append(RecyclerView.this.exceptionLabel());
            throw new IllegalArgumentException(paramAnonymousView.toString());
          }
          localViewHolder.clearTmpDetachFlag();
        }
        RecyclerView.this.attachViewToParent(paramAnonymousView, paramAnonymousInt, paramAnonymousLayoutParams);
      }
      
      public void detachViewFromParent(int paramAnonymousInt)
      {
        Object localObject = getChildAt(paramAnonymousInt);
        if (localObject != null)
        {
          localObject = RecyclerView.getChildViewHolderInt((View)localObject);
          if (localObject != null)
          {
            if ((((RecyclerView.ViewHolder)localObject).isTmpDetached()) && (!((RecyclerView.ViewHolder)localObject).shouldIgnore()))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("called detach on an already detached child ");
              localStringBuilder.append(localObject);
              localStringBuilder.append(RecyclerView.this.exceptionLabel());
              throw new IllegalArgumentException(localStringBuilder.toString());
            }
            ((RecyclerView.ViewHolder)localObject).addFlags(256);
          }
        }
        RecyclerView.this.detachViewFromParent(paramAnonymousInt);
      }
      
      public View getChildAt(int paramAnonymousInt)
      {
        return RecyclerView.this.getChildAt(paramAnonymousInt);
      }
      
      public int getChildCount()
      {
        return RecyclerView.this.getChildCount();
      }
      
      public RecyclerView.ViewHolder getChildViewHolder(View paramAnonymousView)
      {
        return RecyclerView.getChildViewHolderInt(paramAnonymousView);
      }
      
      public int indexOfChild(View paramAnonymousView)
      {
        return RecyclerView.this.indexOfChild(paramAnonymousView);
      }
      
      public void onEnteredHiddenState(View paramAnonymousView)
      {
        paramAnonymousView = RecyclerView.getChildViewHolderInt(paramAnonymousView);
        if (paramAnonymousView != null) {
          paramAnonymousView.onEnteredHiddenState(RecyclerView.this);
        }
      }
      
      public void onLeftHiddenState(View paramAnonymousView)
      {
        paramAnonymousView = RecyclerView.getChildViewHolderInt(paramAnonymousView);
        if (paramAnonymousView != null) {
          paramAnonymousView.onLeftHiddenState(RecyclerView.this);
        }
      }
      
      public void removeAllViews()
      {
        int j = getChildCount();
        int i = 0;
        while (i < j)
        {
          View localView = getChildAt(i);
          RecyclerView.this.dispatchChildDetached(localView);
          localView.clearAnimation();
          i += 1;
        }
        RecyclerView.this.removeAllViews();
      }
      
      public void removeViewAt(int paramAnonymousInt)
      {
        View localView = RecyclerView.this.getChildAt(paramAnonymousInt);
        if (localView != null)
        {
          RecyclerView.this.dispatchChildDetached(localView);
          localView.clearAnimation();
        }
        RecyclerView.this.removeViewAt(paramAnonymousInt);
      }
    });
  }
  
  private boolean isPreferredNextFocus(View paramView1, View paramView2, int paramInt)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool2 = false;
    if (paramView2 != null)
    {
      if (paramView2 == this) {
        return false;
      }
      if (findContainingItemView(paramView2) == null) {
        return false;
      }
      if (paramView1 == null) {
        return true;
      }
      if (findContainingItemView(paramView1) == null) {
        return true;
      }
      this.mTempRect.set(0, 0, paramView1.getWidth(), paramView1.getHeight());
      this.mTempRect2.set(0, 0, paramView2.getWidth(), paramView2.getHeight());
      offsetDescendantRectToMyCoords(paramView1, this.mTempRect);
      offsetDescendantRectToMyCoords(paramView2, this.mTempRect2);
      int i = this.mLayout.getLayoutDirection();
      int j = -1;
      int k;
      if (i == 1) {
        k = -1;
      } else {
        k = 1;
      }
      if (((this.mTempRect.left < this.mTempRect2.left) || (this.mTempRect.right <= this.mTempRect2.left)) && (this.mTempRect.right < this.mTempRect2.right)) {
        i = 1;
      } else if (((this.mTempRect.right > this.mTempRect2.right) || (this.mTempRect.left >= this.mTempRect2.right)) && (this.mTempRect.left > this.mTempRect2.left)) {
        i = -1;
      } else {
        i = 0;
      }
      if (((this.mTempRect.top < this.mTempRect2.top) || (this.mTempRect.bottom <= this.mTempRect2.top)) && (this.mTempRect.bottom < this.mTempRect2.bottom)) {
        j = 1;
      } else if (((this.mTempRect.bottom <= this.mTempRect2.bottom) && (this.mTempRect.top < this.mTempRect2.bottom)) || (this.mTempRect.top <= this.mTempRect2.top)) {
        j = 0;
      }
      if (paramInt != 17)
      {
        if (paramInt != 33)
        {
          if (paramInt != 66)
          {
            if (paramInt != 130)
            {
              switch (paramInt)
              {
              default: 
                paramView1 = new StringBuilder();
                paramView1.append("Invalid direction: ");
                paramView1.append(paramInt);
                paramView1.append(exceptionLabel());
                throw new IllegalArgumentException(paramView1.toString());
              case 2: 
                if (j <= 0)
                {
                  bool1 = bool2;
                  if (j == 0)
                  {
                    bool1 = bool2;
                    if (i * k < 0) {}
                  }
                }
                else
                {
                  bool1 = true;
                }
                return bool1;
              }
              if (j >= 0)
              {
                bool1 = bool3;
                if (j == 0)
                {
                  bool1 = bool3;
                  if (i * k > 0) {}
                }
              }
              else
              {
                bool1 = true;
              }
              return bool1;
            }
            if (j > 0) {
              bool1 = true;
            }
            return bool1;
          }
          bool1 = bool4;
          if (i > 0) {
            bool1 = true;
          }
          return bool1;
        }
        bool1 = bool5;
        if (j < 0) {
          bool1 = true;
        }
        return bool1;
      }
      bool1 = bool6;
      if (i < 0) {
        bool1 = true;
      }
      return bool1;
    }
    return false;
  }
  
  private void onPointerUp(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i) == this.mScrollPointerId)
    {
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      this.mScrollPointerId = paramMotionEvent.getPointerId(i);
      int j = (int)(paramMotionEvent.getX(i) + 0.5F);
      this.mLastTouchX = j;
      this.mInitialTouchX = j;
      i = (int)(paramMotionEvent.getY(i) + 0.5F);
      this.mLastTouchY = i;
      this.mInitialTouchY = i;
    }
  }
  
  private boolean predictiveItemAnimationsEnabled()
  {
    return (this.mItemAnimator != null) && (this.mLayout.supportsPredictiveItemAnimations());
  }
  
  private void processAdapterUpdatesAndSetAnimationFlags()
  {
    if (this.mDataSetHasChangedAfterLayout)
    {
      this.mAdapterHelper.reset();
      if (this.mDispatchItemsChangedEvent) {
        this.mLayout.onItemsChanged(this);
      }
    }
    if (predictiveItemAnimationsEnabled()) {
      this.mAdapterHelper.preProcess();
    } else {
      this.mAdapterHelper.consumeUpdatesInOnePass();
    }
    boolean bool1 = this.mItemsAddedOrRemoved;
    boolean bool2 = false;
    int i;
    if ((!bool1) && (!this.mItemsChanged)) {
      i = 0;
    } else {
      i = 1;
    }
    State localState = this.mState;
    if ((this.mFirstLayoutComplete) && (this.mItemAnimator != null) && ((this.mDataSetHasChangedAfterLayout) || (i != 0) || (this.mLayout.mRequestedSimpleAnimations)) && ((!this.mDataSetHasChangedAfterLayout) || (this.mAdapter.hasStableIds()))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localState.mRunSimpleAnimations = bool1;
    localState = this.mState;
    bool1 = bool2;
    if (this.mState.mRunSimpleAnimations)
    {
      bool1 = bool2;
      if (i != 0)
      {
        bool1 = bool2;
        if (!this.mDataSetHasChangedAfterLayout)
        {
          bool1 = bool2;
          if (predictiveItemAnimationsEnabled()) {
            bool1 = true;
          }
        }
      }
    }
    localState.mRunPredictiveAnimations = bool1;
  }
  
  private void pullGlows(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int j = 1;
    if (paramFloat2 < 0.0F)
    {
      ensureLeftGlow();
      EdgeEffectCompat.onPull(this.mLeftGlow, -paramFloat2 / getWidth(), 1.0F - paramFloat3 / getHeight());
    }
    for (;;)
    {
      i = 1;
      break label80;
      if (paramFloat2 <= 0.0F) {
        break;
      }
      ensureRightGlow();
      EdgeEffectCompat.onPull(this.mRightGlow, paramFloat2 / getWidth(), paramFloat3 / getHeight());
    }
    int i = 0;
    label80:
    if (paramFloat4 < 0.0F)
    {
      ensureTopGlow();
      EdgeEffectCompat.onPull(this.mTopGlow, -paramFloat4 / getHeight(), paramFloat1 / getWidth());
      i = j;
    }
    else if (paramFloat4 > 0.0F)
    {
      ensureBottomGlow();
      EdgeEffectCompat.onPull(this.mBottomGlow, paramFloat4 / getHeight(), 1.0F - paramFloat1 / getWidth());
      i = j;
    }
    if ((i != 0) || (paramFloat2 != 0.0F) || (paramFloat4 != 0.0F)) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  private void recoverFocusFromState()
  {
    if ((this.mPreserveFocusAfterLayout) && (this.mAdapter != null) && (hasFocus()) && (getDescendantFocusability() != 393216))
    {
      if ((getDescendantFocusability() == 131072) && (isFocused())) {
        return;
      }
      Object localObject;
      if (!isFocused())
      {
        localObject = getFocusedChild();
        if ((IGNORE_DETACHED_FOCUSED_CHILD) && ((((View)localObject).getParent() == null) || (!((View)localObject).hasFocus())))
        {
          if (this.mChildHelper.getChildCount() == 0) {
            requestFocus();
          }
        }
        else if (!this.mChildHelper.isHidden((View)localObject)) {
          return;
        }
      }
      long l = this.mState.mFocusedItemId;
      View localView = null;
      if ((l != -1L) && (this.mAdapter.hasStableIds())) {
        localObject = findViewHolderForItemId(this.mState.mFocusedItemId);
      } else {
        localObject = null;
      }
      if ((localObject != null) && (!this.mChildHelper.isHidden(((ViewHolder)localObject).itemView)) && (((ViewHolder)localObject).itemView.hasFocusable()))
      {
        localObject = ((ViewHolder)localObject).itemView;
      }
      else
      {
        localObject = localView;
        if (this.mChildHelper.getChildCount() > 0) {
          localObject = findNextViewToFocus();
        }
      }
      if (localObject != null)
      {
        if (this.mState.mFocusedSubChildId != -1L)
        {
          localView = ((View)localObject).findViewById(this.mState.mFocusedSubChildId);
          if ((localView != null) && (localView.isFocusable())) {
            localObject = localView;
          }
        }
        ((View)localObject).requestFocus();
      }
      return;
    }
  }
  
  private void releaseGlows()
  {
    if (this.mLeftGlow != null)
    {
      this.mLeftGlow.onRelease();
      bool2 = this.mLeftGlow.isFinished();
    }
    else
    {
      bool2 = false;
    }
    boolean bool1 = bool2;
    if (this.mTopGlow != null)
    {
      this.mTopGlow.onRelease();
      bool1 = bool2 | this.mTopGlow.isFinished();
    }
    boolean bool2 = bool1;
    if (this.mRightGlow != null)
    {
      this.mRightGlow.onRelease();
      bool2 = bool1 | this.mRightGlow.isFinished();
    }
    bool1 = bool2;
    if (this.mBottomGlow != null)
    {
      this.mBottomGlow.onRelease();
      bool1 = bool2 | this.mBottomGlow.isFinished();
    }
    if (bool1) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  private void requestChildOnScreen(@NonNull View paramView1, @Nullable View paramView2)
  {
    if (paramView2 != null) {
      localObject = paramView2;
    } else {
      localObject = paramView1;
    }
    this.mTempRect.set(0, 0, ((View)localObject).getWidth(), ((View)localObject).getHeight());
    Object localObject = ((View)localObject).getLayoutParams();
    if ((localObject instanceof LayoutParams))
    {
      localObject = (LayoutParams)localObject;
      if (!((LayoutParams)localObject).mInsetsDirty)
      {
        localObject = ((LayoutParams)localObject).mDecorInsets;
        localRect = this.mTempRect;
        localRect.left -= ((Rect)localObject).left;
        localRect = this.mTempRect;
        localRect.right += ((Rect)localObject).right;
        localRect = this.mTempRect;
        localRect.top -= ((Rect)localObject).top;
        localRect = this.mTempRect;
        localRect.bottom += ((Rect)localObject).bottom;
      }
    }
    if (paramView2 != null)
    {
      offsetDescendantRectToMyCoords(paramView2, this.mTempRect);
      offsetRectIntoDescendantCoords(paramView1, this.mTempRect);
    }
    localObject = this.mLayout;
    Rect localRect = this.mTempRect;
    boolean bool2 = this.mFirstLayoutComplete;
    boolean bool1;
    if (paramView2 == null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((LayoutManager)localObject).requestChildRectangleOnScreen(this, paramView1, localRect, bool2 ^ true, bool1);
  }
  
  private void resetFocusInfo()
  {
    this.mState.mFocusedItemId = -1L;
    this.mState.mFocusedItemPosition = -1;
    this.mState.mFocusedSubChildId = -1;
  }
  
  private void resetTouch()
  {
    if (this.mVelocityTracker != null) {
      this.mVelocityTracker.clear();
    }
    stopNestedScroll(0);
    releaseGlows();
  }
  
  private void saveFocusInfo()
  {
    boolean bool = this.mPreserveFocusAfterLayout;
    State localState = null;
    Object localObject;
    if ((bool) && (hasFocus()) && (this.mAdapter != null)) {
      localObject = getFocusedChild();
    } else {
      localObject = null;
    }
    if (localObject == null) {
      localObject = localState;
    } else {
      localObject = findContainingViewHolder((View)localObject);
    }
    if (localObject == null)
    {
      resetFocusInfo();
      return;
    }
    localState = this.mState;
    long l;
    if (this.mAdapter.hasStableIds()) {
      l = ((ViewHolder)localObject).getItemId();
    } else {
      l = -1L;
    }
    localState.mFocusedItemId = l;
    localState = this.mState;
    int i;
    if (this.mDataSetHasChangedAfterLayout) {
      i = -1;
    } else if (((ViewHolder)localObject).isRemoved()) {
      i = ((ViewHolder)localObject).mOldPosition;
    } else {
      i = ((ViewHolder)localObject).getAdapterPosition();
    }
    localState.mFocusedItemPosition = i;
    this.mState.mFocusedSubChildId = getDeepestFocusedViewWithId(((ViewHolder)localObject).itemView);
  }
  
  private void setAdapterInternal(@Nullable Adapter paramAdapter, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mAdapter != null)
    {
      this.mAdapter.unregisterAdapterDataObserver(this.mObserver);
      this.mAdapter.onDetachedFromRecyclerView(this);
    }
    if ((!paramBoolean1) || (paramBoolean2)) {
      removeAndRecycleViews();
    }
    this.mAdapterHelper.reset();
    Adapter localAdapter = this.mAdapter;
    this.mAdapter = paramAdapter;
    if (paramAdapter != null)
    {
      paramAdapter.registerAdapterDataObserver(this.mObserver);
      paramAdapter.onAttachedToRecyclerView(this);
    }
    if (this.mLayout != null) {
      this.mLayout.onAdapterChanged(localAdapter, this.mAdapter);
    }
    this.mRecycler.onAdapterChanged(localAdapter, this.mAdapter, paramBoolean1);
    this.mState.mStructureChanged = true;
  }
  
  private void stopScrollersInternal()
  {
    this.mViewFlinger.stop();
    if (this.mLayout != null) {
      this.mLayout.stopSmoothScroller();
    }
  }
  
  void absorbGlows(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
    {
      ensureLeftGlow();
      this.mLeftGlow.onAbsorb(-paramInt1);
    }
    else if (paramInt1 > 0)
    {
      ensureRightGlow();
      this.mRightGlow.onAbsorb(paramInt1);
    }
    if (paramInt2 < 0)
    {
      ensureTopGlow();
      this.mTopGlow.onAbsorb(-paramInt2);
    }
    else if (paramInt2 > 0)
    {
      ensureBottomGlow();
      this.mBottomGlow.onAbsorb(paramInt2);
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    if ((this.mLayout == null) || (!this.mLayout.onAddFocusables(this, paramArrayList, paramInt1, paramInt2))) {
      super.addFocusables(paramArrayList, paramInt1, paramInt2);
    }
  }
  
  public void addItemDecoration(@NonNull ItemDecoration paramItemDecoration)
  {
    addItemDecoration(paramItemDecoration, -1);
  }
  
  public void addItemDecoration(@NonNull ItemDecoration paramItemDecoration, int paramInt)
  {
    if (this.mLayout != null) {
      this.mLayout.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
    }
    if (this.mItemDecorations.isEmpty()) {
      setWillNotDraw(false);
    }
    if (paramInt < 0) {
      this.mItemDecorations.add(paramItemDecoration);
    } else {
      this.mItemDecorations.add(paramInt, paramItemDecoration);
    }
    markItemDecorInsetsDirty();
    requestLayout();
  }
  
  public void addOnChildAttachStateChangeListener(@NonNull OnChildAttachStateChangeListener paramOnChildAttachStateChangeListener)
  {
    if (this.mOnChildAttachStateListeners == null) {
      this.mOnChildAttachStateListeners = new ArrayList();
    }
    this.mOnChildAttachStateListeners.add(paramOnChildAttachStateChangeListener);
  }
  
  public void addOnItemTouchListener(@NonNull OnItemTouchListener paramOnItemTouchListener)
  {
    this.mOnItemTouchListeners.add(paramOnItemTouchListener);
  }
  
  public void addOnScrollListener(@NonNull OnScrollListener paramOnScrollListener)
  {
    if (this.mScrollListeners == null) {
      this.mScrollListeners = new ArrayList();
    }
    this.mScrollListeners.add(paramOnScrollListener);
  }
  
  void animateAppearance(@NonNull ViewHolder paramViewHolder, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2)
  {
    paramViewHolder.setIsRecyclable(false);
    if (this.mItemAnimator.animateAppearance(paramViewHolder, paramItemHolderInfo1, paramItemHolderInfo2)) {
      postAnimationRunner();
    }
  }
  
  void animateDisappearance(@NonNull ViewHolder paramViewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2)
  {
    addAnimatingView(paramViewHolder);
    paramViewHolder.setIsRecyclable(false);
    if (this.mItemAnimator.animateDisappearance(paramViewHolder, paramItemHolderInfo1, paramItemHolderInfo2)) {
      postAnimationRunner();
    }
  }
  
  void assertInLayoutOrScroll(String paramString)
  {
    if (!isComputingLayout())
    {
      if (paramString == null)
      {
        paramString = new StringBuilder();
        paramString.append("Cannot call this method unless RecyclerView is computing a layout or scrolling");
        paramString.append(exceptionLabel());
        throw new IllegalStateException(paramString.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(exceptionLabel());
      throw new IllegalStateException(localStringBuilder.toString());
    }
  }
  
  void assertNotInLayoutOrScroll(String paramString)
  {
    if (isComputingLayout())
    {
      if (paramString == null)
      {
        paramString = new StringBuilder();
        paramString.append("Cannot call this method while RecyclerView is computing a layout or scrolling");
        paramString.append(exceptionLabel());
        throw new IllegalStateException(paramString.toString());
      }
      throw new IllegalStateException(paramString);
    }
    if (this.mDispatchScrollCounter > 0)
    {
      paramString = new StringBuilder();
      paramString.append("");
      paramString.append(exceptionLabel());
      Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(paramString.toString()));
    }
  }
  
  boolean canReuseUpdatedViewHolder(ViewHolder paramViewHolder)
  {
    return (this.mItemAnimator == null) || (this.mItemAnimator.canReuseUpdatedViewHolder(paramViewHolder, paramViewHolder.getUnmodifiedPayloads()));
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (this.mLayout.checkLayoutParams((LayoutParams)paramLayoutParams));
  }
  
  void clearOldPositions()
  {
    int j = this.mChildHelper.getUnfilteredChildCount();
    int i = 0;
    while (i < j)
    {
      ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
      if (!localViewHolder.shouldIgnore()) {
        localViewHolder.clearOldPosition();
      }
      i += 1;
    }
    this.mRecycler.clearOldPositions();
  }
  
  public void clearOnChildAttachStateChangeListeners()
  {
    if (this.mOnChildAttachStateListeners != null) {
      this.mOnChildAttachStateListeners.clear();
    }
  }
  
  public void clearOnScrollListeners()
  {
    if (this.mScrollListeners != null) {
      this.mScrollListeners.clear();
    }
  }
  
  public int computeHorizontalScrollExtent()
  {
    LayoutManager localLayoutManager = this.mLayout;
    int i = 0;
    if (localLayoutManager == null) {
      return 0;
    }
    if (this.mLayout.canScrollHorizontally()) {
      i = this.mLayout.computeHorizontalScrollExtent(this.mState);
    }
    return i;
  }
  
  public int computeHorizontalScrollOffset()
  {
    LayoutManager localLayoutManager = this.mLayout;
    int i = 0;
    if (localLayoutManager == null) {
      return 0;
    }
    if (this.mLayout.canScrollHorizontally()) {
      i = this.mLayout.computeHorizontalScrollOffset(this.mState);
    }
    return i;
  }
  
  public int computeHorizontalScrollRange()
  {
    LayoutManager localLayoutManager = this.mLayout;
    int i = 0;
    if (localLayoutManager == null) {
      return 0;
    }
    if (this.mLayout.canScrollHorizontally()) {
      i = this.mLayout.computeHorizontalScrollRange(this.mState);
    }
    return i;
  }
  
  public int computeVerticalScrollExtent()
  {
    LayoutManager localLayoutManager = this.mLayout;
    int i = 0;
    if (localLayoutManager == null) {
      return 0;
    }
    if (this.mLayout.canScrollVertically()) {
      i = this.mLayout.computeVerticalScrollExtent(this.mState);
    }
    return i;
  }
  
  public int computeVerticalScrollOffset()
  {
    LayoutManager localLayoutManager = this.mLayout;
    int i = 0;
    if (localLayoutManager == null) {
      return 0;
    }
    if (this.mLayout.canScrollVertically()) {
      i = this.mLayout.computeVerticalScrollOffset(this.mState);
    }
    return i;
  }
  
  public int computeVerticalScrollRange()
  {
    LayoutManager localLayoutManager = this.mLayout;
    int i = 0;
    if (localLayoutManager == null) {
      return 0;
    }
    if (this.mLayout.canScrollVertically()) {
      i = this.mLayout.computeVerticalScrollRange(this.mState);
    }
    return i;
  }
  
  void considerReleasingGlowsOnScroll(int paramInt1, int paramInt2)
  {
    if ((this.mLeftGlow != null) && (!this.mLeftGlow.isFinished()) && (paramInt1 > 0))
    {
      this.mLeftGlow.onRelease();
      bool2 = this.mLeftGlow.isFinished();
    }
    else
    {
      bool2 = false;
    }
    boolean bool1 = bool2;
    if (this.mRightGlow != null)
    {
      bool1 = bool2;
      if (!this.mRightGlow.isFinished())
      {
        bool1 = bool2;
        if (paramInt1 < 0)
        {
          this.mRightGlow.onRelease();
          bool1 = bool2 | this.mRightGlow.isFinished();
        }
      }
    }
    boolean bool2 = bool1;
    if (this.mTopGlow != null)
    {
      bool2 = bool1;
      if (!this.mTopGlow.isFinished())
      {
        bool2 = bool1;
        if (paramInt2 > 0)
        {
          this.mTopGlow.onRelease();
          bool2 = bool1 | this.mTopGlow.isFinished();
        }
      }
    }
    bool1 = bool2;
    if (this.mBottomGlow != null)
    {
      bool1 = bool2;
      if (!this.mBottomGlow.isFinished())
      {
        bool1 = bool2;
        if (paramInt2 < 0)
        {
          this.mBottomGlow.onRelease();
          bool1 = bool2 | this.mBottomGlow.isFinished();
        }
      }
    }
    if (bool1) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  void consumePendingUpdateOperations()
  {
    if ((this.mFirstLayoutComplete) && (!this.mDataSetHasChangedAfterLayout))
    {
      if (!this.mAdapterHelper.hasPendingUpdates()) {
        return;
      }
      if ((this.mAdapterHelper.hasAnyUpdateTypes(4)) && (!this.mAdapterHelper.hasAnyUpdateTypes(11)))
      {
        TraceCompat.beginSection("RV PartialInvalidate");
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mAdapterHelper.preProcess();
        if (!this.mLayoutWasDefered) {
          if (hasUpdatedView()) {
            dispatchLayout();
          } else {
            this.mAdapterHelper.consumePostponedUpdates();
          }
        }
        stopInterceptRequestLayout(true);
        onExitLayoutOrScroll();
        TraceCompat.endSection();
        return;
      }
      if (this.mAdapterHelper.hasPendingUpdates())
      {
        TraceCompat.beginSection("RV FullInvalidate");
        dispatchLayout();
        TraceCompat.endSection();
      }
      return;
    }
    TraceCompat.beginSection("RV FullInvalidate");
    dispatchLayout();
    TraceCompat.endSection();
  }
  
  void defaultOnMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(LayoutManager.chooseSize(paramInt1, getPaddingLeft() + getPaddingRight(), ViewCompat.getMinimumWidth(this)), LayoutManager.chooseSize(paramInt2, getPaddingTop() + getPaddingBottom(), ViewCompat.getMinimumHeight(this)));
  }
  
  void dispatchChildAttached(View paramView)
  {
    ViewHolder localViewHolder = getChildViewHolderInt(paramView);
    onChildAttachedToWindow(paramView);
    if ((this.mAdapter != null) && (localViewHolder != null)) {
      this.mAdapter.onViewAttachedToWindow(localViewHolder);
    }
    if (this.mOnChildAttachStateListeners != null)
    {
      int i = this.mOnChildAttachStateListeners.size() - 1;
      while (i >= 0)
      {
        ((OnChildAttachStateChangeListener)this.mOnChildAttachStateListeners.get(i)).onChildViewAttachedToWindow(paramView);
        i -= 1;
      }
    }
  }
  
  void dispatchChildDetached(View paramView)
  {
    ViewHolder localViewHolder = getChildViewHolderInt(paramView);
    onChildDetachedFromWindow(paramView);
    if ((this.mAdapter != null) && (localViewHolder != null)) {
      this.mAdapter.onViewDetachedFromWindow(localViewHolder);
    }
    if (this.mOnChildAttachStateListeners != null)
    {
      int i = this.mOnChildAttachStateListeners.size() - 1;
      while (i >= 0)
      {
        ((OnChildAttachStateChangeListener)this.mOnChildAttachStateListeners.get(i)).onChildViewDetachedFromWindow(paramView);
        i -= 1;
      }
    }
  }
  
  void dispatchLayout()
  {
    if (this.mAdapter == null)
    {
      Log.e("RecyclerView", "No adapter attached; skipping layout");
      return;
    }
    if (this.mLayout == null)
    {
      Log.e("RecyclerView", "No layout manager attached; skipping layout");
      return;
    }
    this.mState.mIsMeasuring = false;
    if (this.mState.mLayoutStep == 1)
    {
      dispatchLayoutStep1();
      this.mLayout.setExactMeasureSpecsFrom(this);
      dispatchLayoutStep2();
    }
    else if ((!this.mAdapterHelper.hasUpdates()) && (this.mLayout.getWidth() == getWidth()) && (this.mLayout.getHeight() == getHeight()))
    {
      this.mLayout.setExactMeasureSpecsFrom(this);
    }
    else
    {
      this.mLayout.setExactMeasureSpecsFrom(this);
      dispatchLayoutStep2();
    }
    dispatchLayoutStep3();
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return getScrollingChildHelper().dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return getScrollingChildHelper().dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return getScrollingChildHelper().dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt3)
  {
    return getScrollingChildHelper().dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2, paramInt3);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return getScrollingChildHelper().dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt, int paramInt5)
  {
    return getScrollingChildHelper().dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt, paramInt5);
  }
  
  void dispatchOnScrollStateChanged(int paramInt)
  {
    if (this.mLayout != null) {
      this.mLayout.onScrollStateChanged(paramInt);
    }
    onScrollStateChanged(paramInt);
    if (this.mScrollListener != null) {
      this.mScrollListener.onScrollStateChanged(this, paramInt);
    }
    if (this.mScrollListeners != null)
    {
      int i = this.mScrollListeners.size() - 1;
      while (i >= 0)
      {
        ((OnScrollListener)this.mScrollListeners.get(i)).onScrollStateChanged(this, paramInt);
        i -= 1;
      }
    }
  }
  
  void dispatchOnScrolled(int paramInt1, int paramInt2)
  {
    this.mDispatchScrollCounter += 1;
    int i = getScrollX();
    int j = getScrollY();
    onScrollChanged(i, j, i, j);
    onScrolled(paramInt1, paramInt2);
    if (this.mScrollListener != null) {
      this.mScrollListener.onScrolled(this, paramInt1, paramInt2);
    }
    if (this.mScrollListeners != null)
    {
      i = this.mScrollListeners.size() - 1;
      while (i >= 0)
      {
        ((OnScrollListener)this.mScrollListeners.get(i)).onScrolled(this, paramInt1, paramInt2);
        i -= 1;
      }
    }
    this.mDispatchScrollCounter -= 1;
  }
  
  void dispatchPendingImportantForAccessibilityChanges()
  {
    int i = this.mPendingAccessibilityImportanceChange.size() - 1;
    while (i >= 0)
    {
      ViewHolder localViewHolder = (ViewHolder)this.mPendingAccessibilityImportanceChange.get(i);
      if ((localViewHolder.itemView.getParent() == this) && (!localViewHolder.shouldIgnore()))
      {
        int j = localViewHolder.mPendingAccessibilityState;
        if (j != -1)
        {
          ViewCompat.setImportantForAccessibility(localViewHolder.itemView, j);
          localViewHolder.mPendingAccessibilityState = -1;
        }
      }
      i -= 1;
    }
    this.mPendingAccessibilityImportanceChange.clear();
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchThawSelfOnly(paramSparseArray);
  }
  
  protected void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchFreezeSelfOnly(paramSparseArray);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int j = this.mItemDecorations.size();
    int k = 0;
    int i = 0;
    while (i < j)
    {
      ((ItemDecoration)this.mItemDecorations.get(i)).onDrawOver(paramCanvas, this, this.mState);
      i += 1;
    }
    int m;
    if ((this.mLeftGlow != null) && (!this.mLeftGlow.isFinished()))
    {
      m = paramCanvas.save();
      if (this.mClipToPadding) {
        i = getPaddingBottom();
      } else {
        i = 0;
      }
      paramCanvas.rotate(270.0F);
      paramCanvas.translate(-getHeight() + i, 0.0F);
      if ((this.mLeftGlow != null) && (this.mLeftGlow.draw(paramCanvas))) {
        j = 1;
      } else {
        j = 0;
      }
      paramCanvas.restoreToCount(m);
    }
    else
    {
      j = 0;
    }
    i = j;
    if (this.mTopGlow != null)
    {
      i = j;
      if (!this.mTopGlow.isFinished())
      {
        m = paramCanvas.save();
        if (this.mClipToPadding) {
          paramCanvas.translate(getPaddingLeft(), getPaddingTop());
        }
        if ((this.mTopGlow != null) && (this.mTopGlow.draw(paramCanvas))) {
          i = 1;
        } else {
          i = 0;
        }
        i = j | i;
        paramCanvas.restoreToCount(m);
      }
    }
    j = i;
    if (this.mRightGlow != null)
    {
      j = i;
      if (!this.mRightGlow.isFinished())
      {
        m = paramCanvas.save();
        int n = getWidth();
        if (this.mClipToPadding) {
          j = getPaddingTop();
        } else {
          j = 0;
        }
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(-j, -n);
        if ((this.mRightGlow != null) && (this.mRightGlow.draw(paramCanvas))) {
          j = 1;
        } else {
          j = 0;
        }
        j = i | j;
        paramCanvas.restoreToCount(m);
      }
    }
    if ((this.mBottomGlow != null) && (!this.mBottomGlow.isFinished()))
    {
      m = paramCanvas.save();
      paramCanvas.rotate(180.0F);
      if (this.mClipToPadding) {
        paramCanvas.translate(-getWidth() + getPaddingRight(), -getHeight() + getPaddingBottom());
      } else {
        paramCanvas.translate(-getWidth(), -getHeight());
      }
      i = k;
      if (this.mBottomGlow != null)
      {
        i = k;
        if (this.mBottomGlow.draw(paramCanvas)) {
          i = 1;
        }
      }
      i |= j;
      paramCanvas.restoreToCount(m);
    }
    else
    {
      i = j;
    }
    j = i;
    if (i == 0)
    {
      j = i;
      if (this.mItemAnimator != null)
      {
        j = i;
        if (this.mItemDecorations.size() > 0)
        {
          j = i;
          if (this.mItemAnimator.isRunning()) {
            j = 1;
          }
        }
      }
    }
    if (j != 0) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  void ensureBottomGlow()
  {
    if (this.mBottomGlow != null) {
      return;
    }
    this.mBottomGlow = this.mEdgeEffectFactory.createEdgeEffect(this, 3);
    if (this.mClipToPadding)
    {
      this.mBottomGlow.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    this.mBottomGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
  }
  
  void ensureLeftGlow()
  {
    if (this.mLeftGlow != null) {
      return;
    }
    this.mLeftGlow = this.mEdgeEffectFactory.createEdgeEffect(this, 0);
    if (this.mClipToPadding)
    {
      this.mLeftGlow.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    this.mLeftGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
  }
  
  void ensureRightGlow()
  {
    if (this.mRightGlow != null) {
      return;
    }
    this.mRightGlow = this.mEdgeEffectFactory.createEdgeEffect(this, 2);
    if (this.mClipToPadding)
    {
      this.mRightGlow.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    this.mRightGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
  }
  
  void ensureTopGlow()
  {
    if (this.mTopGlow != null) {
      return;
    }
    this.mTopGlow = this.mEdgeEffectFactory.createEdgeEffect(this, 1);
    if (this.mClipToPadding)
    {
      this.mTopGlow.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    this.mTopGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
  }
  
  String exceptionLabel()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" ");
    localStringBuilder.append(super.toString());
    localStringBuilder.append(", adapter:");
    localStringBuilder.append(this.mAdapter);
    localStringBuilder.append(", layout:");
    localStringBuilder.append(this.mLayout);
    localStringBuilder.append(", context:");
    localStringBuilder.append(getContext());
    return localStringBuilder.toString();
  }
  
  final void fillRemainingScrollValues(State paramState)
  {
    if (getScrollState() == 2)
    {
      OverScroller localOverScroller = this.mViewFlinger.mScroller;
      paramState.mRemainingScrollHorizontal = (localOverScroller.getFinalX() - localOverScroller.getCurrX());
      paramState.mRemainingScrollVertical = (localOverScroller.getFinalY() - localOverScroller.getCurrY());
      return;
    }
    paramState.mRemainingScrollHorizontal = 0;
    paramState.mRemainingScrollVertical = 0;
  }
  
  @Nullable
  public View findChildViewUnder(float paramFloat1, float paramFloat2)
  {
    int i = this.mChildHelper.getChildCount() - 1;
    while (i >= 0)
    {
      View localView = this.mChildHelper.getChildAt(i);
      float f1 = localView.getTranslationX();
      float f2 = localView.getTranslationY();
      if ((paramFloat1 >= localView.getLeft() + f1) && (paramFloat1 <= localView.getRight() + f1) && (paramFloat2 >= localView.getTop() + f2) && (paramFloat2 <= localView.getBottom() + f2)) {
        return localView;
      }
      i -= 1;
    }
    return null;
  }
  
  @Nullable
  public View findContainingItemView(@NonNull View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    View localView = paramView;
    for (paramView = localViewParent; (paramView != null) && (paramView != this) && ((paramView instanceof View)); paramView = localView.getParent()) {
      localView = (View)paramView;
    }
    if (paramView == this) {
      return localView;
    }
    return null;
  }
  
  @Nullable
  public ViewHolder findContainingViewHolder(@NonNull View paramView)
  {
    paramView = findContainingItemView(paramView);
    if (paramView == null) {
      return null;
    }
    return getChildViewHolder(paramView);
  }
  
  @Nullable
  public ViewHolder findViewHolderForAdapterPosition(int paramInt)
  {
    boolean bool = this.mDataSetHasChangedAfterLayout;
    Object localObject1 = null;
    if (bool) {
      return null;
    }
    int j = this.mChildHelper.getUnfilteredChildCount();
    int i = 0;
    while (i < j)
    {
      ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
      Object localObject2 = localObject1;
      if (localViewHolder != null)
      {
        localObject2 = localObject1;
        if (!localViewHolder.isRemoved())
        {
          localObject2 = localObject1;
          if (getAdapterPositionFor(localViewHolder) == paramInt) {
            if (this.mChildHelper.isHidden(localViewHolder.itemView)) {
              localObject2 = localViewHolder;
            } else {
              return localViewHolder;
            }
          }
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    return (ViewHolder)localObject1;
  }
  
  public ViewHolder findViewHolderForItemId(long paramLong)
  {
    Object localObject2 = this.mAdapter;
    Object localObject1 = null;
    if (localObject2 != null)
    {
      if (!this.mAdapter.hasStableIds()) {
        return null;
      }
      int j = this.mChildHelper.getUnfilteredChildCount();
      int i = 0;
      while (i < j)
      {
        ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
        localObject2 = localObject1;
        if (localViewHolder != null)
        {
          localObject2 = localObject1;
          if (!localViewHolder.isRemoved())
          {
            localObject2 = localObject1;
            if (localViewHolder.getItemId() == paramLong) {
              if (this.mChildHelper.isHidden(localViewHolder.itemView)) {
                localObject2 = localViewHolder;
              } else {
                return localViewHolder;
              }
            }
          }
        }
        i += 1;
        localObject1 = localObject2;
      }
      return (ViewHolder)localObject1;
    }
    return null;
  }
  
  @Nullable
  public ViewHolder findViewHolderForLayoutPosition(int paramInt)
  {
    return findViewHolderForPosition(paramInt, false);
  }
  
  @Deprecated
  @Nullable
  public ViewHolder findViewHolderForPosition(int paramInt)
  {
    return findViewHolderForPosition(paramInt, false);
  }
  
  @Nullable
  ViewHolder findViewHolderForPosition(int paramInt, boolean paramBoolean)
  {
    int j = this.mChildHelper.getUnfilteredChildCount();
    Object localObject1 = null;
    int i = 0;
    while (i < j)
    {
      ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
      Object localObject2 = localObject1;
      if (localViewHolder != null)
      {
        localObject2 = localObject1;
        if (!localViewHolder.isRemoved())
        {
          if (paramBoolean)
          {
            if (localViewHolder.mPosition != paramInt)
            {
              localObject2 = localObject1;
              break label115;
            }
          }
          else if (localViewHolder.getLayoutPosition() != paramInt)
          {
            localObject2 = localObject1;
            break label115;
          }
          if (this.mChildHelper.isHidden(localViewHolder.itemView)) {
            localObject2 = localViewHolder;
          } else {
            return localViewHolder;
          }
        }
      }
      label115:
      i += 1;
      localObject1 = localObject2;
    }
    return (ViewHolder)localObject1;
  }
  
  public boolean fling(int paramInt1, int paramInt2)
  {
    LayoutManager localLayoutManager = this.mLayout;
    int k = 0;
    if (localLayoutManager == null)
    {
      Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return false;
    }
    if (this.mLayoutFrozen) {
      return false;
    }
    boolean bool2 = this.mLayout.canScrollHorizontally();
    boolean bool3 = this.mLayout.canScrollVertically();
    int i;
    if (bool2)
    {
      i = paramInt1;
      if (Math.abs(paramInt1) >= this.mMinFlingVelocity) {}
    }
    else
    {
      i = 0;
    }
    int j;
    if (bool3)
    {
      j = paramInt2;
      if (Math.abs(paramInt2) >= this.mMinFlingVelocity) {}
    }
    else
    {
      j = 0;
    }
    if ((i == 0) && (j == 0)) {
      return false;
    }
    float f1 = i;
    float f2 = j;
    if (!dispatchNestedPreFling(f1, f2))
    {
      boolean bool1;
      if ((!bool2) && (!bool3)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      dispatchNestedFling(f1, f2, bool1);
      if ((this.mOnFlingListener != null) && (this.mOnFlingListener.onFling(i, j))) {
        return true;
      }
      if (bool1)
      {
        paramInt1 = k;
        if (bool2) {
          paramInt1 = 1;
        }
        paramInt2 = paramInt1;
        if (bool3) {
          paramInt2 = paramInt1 | 0x2;
        }
        startNestedScroll(paramInt2, 1);
        paramInt1 = Math.max(-this.mMaxFlingVelocity, Math.min(i, this.mMaxFlingVelocity));
        paramInt2 = Math.max(-this.mMaxFlingVelocity, Math.min(j, this.mMaxFlingVelocity));
        this.mViewFlinger.fling(paramInt1, paramInt2);
        return true;
      }
    }
    return false;
  }
  
  public View focusSearch(View paramView, int paramInt)
  {
    Object localObject = this.mLayout.onInterceptFocusSearch(paramView, paramInt);
    if (localObject != null) {
      return (View)localObject;
    }
    int i;
    if ((this.mAdapter != null) && (this.mLayout != null) && (!isComputingLayout()) && (!this.mLayoutFrozen)) {
      i = 1;
    } else {
      i = 0;
    }
    localObject = FocusFinder.getInstance();
    if ((i != 0) && ((paramInt == 2) || (paramInt == 1)))
    {
      int j;
      if (this.mLayout.canScrollVertically())
      {
        if (paramInt == 2) {
          j = 130;
        } else {
          j = 33;
        }
        if (((FocusFinder)localObject).findNextFocus(this, paramView, j) == null) {
          k = 1;
        } else {
          k = 0;
        }
        i = k;
        if (FORCE_ABS_FOCUS_SEARCH_DIRECTION)
        {
          paramInt = j;
          i = k;
        }
      }
      else
      {
        i = 0;
      }
      int m = i;
      int k = paramInt;
      if (i == 0)
      {
        m = i;
        k = paramInt;
        if (this.mLayout.canScrollHorizontally())
        {
          if (this.mLayout.getLayoutDirection() == 1) {
            i = 1;
          } else {
            i = 0;
          }
          if (paramInt == 2) {
            j = 1;
          } else {
            j = 0;
          }
          if ((i ^ j) != 0) {
            i = 66;
          } else {
            i = 17;
          }
          if (((FocusFinder)localObject).findNextFocus(this, paramView, i) == null) {
            j = 1;
          } else {
            j = 0;
          }
          m = j;
          k = paramInt;
          if (FORCE_ABS_FOCUS_SEARCH_DIRECTION)
          {
            k = i;
            m = j;
          }
        }
      }
      if (m != 0)
      {
        consumePendingUpdateOperations();
        if (findContainingItemView(paramView) == null) {
          return null;
        }
        startInterceptRequestLayout();
        this.mLayout.onFocusSearchFailed(paramView, k, this.mRecycler, this.mState);
        stopInterceptRequestLayout(false);
      }
      localObject = ((FocusFinder)localObject).findNextFocus(this, paramView, k);
      paramInt = k;
    }
    else
    {
      localObject = ((FocusFinder)localObject).findNextFocus(this, paramView, paramInt);
      if ((localObject == null) && (i != 0))
      {
        consumePendingUpdateOperations();
        if (findContainingItemView(paramView) == null) {
          return null;
        }
        startInterceptRequestLayout();
        localObject = this.mLayout.onFocusSearchFailed(paramView, paramInt, this.mRecycler, this.mState);
        stopInterceptRequestLayout(false);
      }
    }
    if ((localObject != null) && (!((View)localObject).hasFocusable()))
    {
      if (getFocusedChild() == null) {
        return super.focusSearch(paramView, paramInt);
      }
      requestChildOnScreen((View)localObject, null);
      return paramView;
    }
    if (isPreferredNextFocus(paramView, (View)localObject, paramInt)) {
      return (View)localObject;
    }
    return super.focusSearch(paramView, paramInt);
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    if (this.mLayout != null) {
      return this.mLayout.generateDefaultLayoutParams();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecyclerView has no LayoutManager");
    localStringBuilder.append(exceptionLabel());
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    if (this.mLayout != null) {
      return this.mLayout.generateLayoutParams(getContext(), paramAttributeSet);
    }
    paramAttributeSet = new StringBuilder();
    paramAttributeSet.append("RecyclerView has no LayoutManager");
    paramAttributeSet.append(exceptionLabel());
    throw new IllegalStateException(paramAttributeSet.toString());
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.mLayout != null) {
      return this.mLayout.generateLayoutParams(paramLayoutParams);
    }
    paramLayoutParams = new StringBuilder();
    paramLayoutParams.append("RecyclerView has no LayoutManager");
    paramLayoutParams.append(exceptionLabel());
    throw new IllegalStateException(paramLayoutParams.toString());
  }
  
  @Nullable
  public Adapter getAdapter()
  {
    return this.mAdapter;
  }
  
  int getAdapterPositionFor(ViewHolder paramViewHolder)
  {
    if ((!paramViewHolder.hasAnyOfTheFlags(524)) && (paramViewHolder.isBound())) {
      return this.mAdapterHelper.applyPendingUpdatesToPosition(paramViewHolder.mPosition);
    }
    return -1;
  }
  
  public int getBaseline()
  {
    if (this.mLayout != null) {
      return this.mLayout.getBaseline();
    }
    return super.getBaseline();
  }
  
  long getChangedHolderKey(ViewHolder paramViewHolder)
  {
    if (this.mAdapter.hasStableIds()) {
      return paramViewHolder.getItemId();
    }
    return paramViewHolder.mPosition;
  }
  
  public int getChildAdapterPosition(@NonNull View paramView)
  {
    paramView = getChildViewHolderInt(paramView);
    if (paramView != null) {
      return paramView.getAdapterPosition();
    }
    return -1;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.mChildDrawingOrderCallback == null) {
      return super.getChildDrawingOrder(paramInt1, paramInt2);
    }
    return this.mChildDrawingOrderCallback.onGetChildDrawingOrder(paramInt1, paramInt2);
  }
  
  public long getChildItemId(@NonNull View paramView)
  {
    Adapter localAdapter = this.mAdapter;
    long l = -1L;
    if (localAdapter != null)
    {
      if (!this.mAdapter.hasStableIds()) {
        return -1L;
      }
      paramView = getChildViewHolderInt(paramView);
      if (paramView != null) {
        l = paramView.getItemId();
      }
      return l;
    }
    return -1L;
  }
  
  public int getChildLayoutPosition(@NonNull View paramView)
  {
    paramView = getChildViewHolderInt(paramView);
    if (paramView != null) {
      return paramView.getLayoutPosition();
    }
    return -1;
  }
  
  @Deprecated
  public int getChildPosition(@NonNull View paramView)
  {
    return getChildAdapterPosition(paramView);
  }
  
  public ViewHolder getChildViewHolder(@NonNull View paramView)
  {
    Object localObject = paramView.getParent();
    if ((localObject != null) && (localObject != this))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("View ");
      ((StringBuilder)localObject).append(paramView);
      ((StringBuilder)localObject).append(" is not a direct child of ");
      ((StringBuilder)localObject).append(this);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    return getChildViewHolderInt(paramView);
  }
  
  public boolean getClipToPadding()
  {
    return this.mClipToPadding;
  }
  
  @Nullable
  public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate()
  {
    return this.mAccessibilityDelegate;
  }
  
  public void getDecoratedBoundsWithMargins(@NonNull View paramView, @NonNull Rect paramRect)
  {
    getDecoratedBoundsWithMarginsInt(paramView, paramRect);
  }
  
  @NonNull
  public EdgeEffectFactory getEdgeEffectFactory()
  {
    return this.mEdgeEffectFactory;
  }
  
  @Nullable
  public ItemAnimator getItemAnimator()
  {
    return this.mItemAnimator;
  }
  
  Rect getItemDecorInsetsForChild(View paramView)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (!localLayoutParams.mInsetsDirty) {
      return localLayoutParams.mDecorInsets;
    }
    if ((this.mState.isPreLayout()) && ((localLayoutParams.isItemChanged()) || (localLayoutParams.isViewInvalid()))) {
      return localLayoutParams.mDecorInsets;
    }
    Rect localRect = localLayoutParams.mDecorInsets;
    localRect.set(0, 0, 0, 0);
    int j = this.mItemDecorations.size();
    int i = 0;
    while (i < j)
    {
      this.mTempRect.set(0, 0, 0, 0);
      ((ItemDecoration)this.mItemDecorations.get(i)).getItemOffsets(this.mTempRect, paramView, this, this.mState);
      localRect.left += this.mTempRect.left;
      localRect.top += this.mTempRect.top;
      localRect.right += this.mTempRect.right;
      localRect.bottom += this.mTempRect.bottom;
      i += 1;
    }
    localLayoutParams.mInsetsDirty = false;
    return localRect;
  }
  
  @NonNull
  public ItemDecoration getItemDecorationAt(int paramInt)
  {
    int i = getItemDecorationCount();
    if ((paramInt >= 0) && (paramInt < i)) {
      return (ItemDecoration)this.mItemDecorations.get(paramInt);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" is an invalid index for size ");
    localStringBuilder.append(i);
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public int getItemDecorationCount()
  {
    return this.mItemDecorations.size();
  }
  
  @Nullable
  public LayoutManager getLayoutManager()
  {
    return this.mLayout;
  }
  
  public int getMaxFlingVelocity()
  {
    return this.mMaxFlingVelocity;
  }
  
  public int getMinFlingVelocity()
  {
    return this.mMinFlingVelocity;
  }
  
  long getNanoTime()
  {
    if (ALLOW_THREAD_GAP_WORK) {
      return System.nanoTime();
    }
    return 0L;
  }
  
  @Nullable
  public OnFlingListener getOnFlingListener()
  {
    return this.mOnFlingListener;
  }
  
  public boolean getPreserveFocusAfterLayout()
  {
    return this.mPreserveFocusAfterLayout;
  }
  
  @NonNull
  public RecycledViewPool getRecycledViewPool()
  {
    return this.mRecycler.getRecycledViewPool();
  }
  
  public int getScrollState()
  {
    return this.mScrollState;
  }
  
  public boolean hasFixedSize()
  {
    return this.mHasFixedSize;
  }
  
  public boolean hasNestedScrollingParent()
  {
    return getScrollingChildHelper().hasNestedScrollingParent();
  }
  
  public boolean hasNestedScrollingParent(int paramInt)
  {
    return getScrollingChildHelper().hasNestedScrollingParent(paramInt);
  }
  
  public boolean hasPendingAdapterUpdates()
  {
    return (!this.mFirstLayoutComplete) || (this.mDataSetHasChangedAfterLayout) || (this.mAdapterHelper.hasPendingUpdates());
  }
  
  void initAdapterManager()
  {
    this.mAdapterHelper = new AdapterHelper(new AdapterHelper.Callback()
    {
      void dispatchUpdate(AdapterHelper.UpdateOp paramAnonymousUpdateOp)
      {
        int i = paramAnonymousUpdateOp.cmd;
        if (i != 4)
        {
          if (i != 8)
          {
            switch (i)
            {
            default: 
              return;
            case 2: 
              RecyclerView.this.mLayout.onItemsRemoved(RecyclerView.this, paramAnonymousUpdateOp.positionStart, paramAnonymousUpdateOp.itemCount);
              return;
            }
            RecyclerView.this.mLayout.onItemsAdded(RecyclerView.this, paramAnonymousUpdateOp.positionStart, paramAnonymousUpdateOp.itemCount);
            return;
          }
          RecyclerView.this.mLayout.onItemsMoved(RecyclerView.this, paramAnonymousUpdateOp.positionStart, paramAnonymousUpdateOp.itemCount, 1);
          return;
        }
        RecyclerView.this.mLayout.onItemsUpdated(RecyclerView.this, paramAnonymousUpdateOp.positionStart, paramAnonymousUpdateOp.itemCount, paramAnonymousUpdateOp.payload);
      }
      
      public RecyclerView.ViewHolder findViewHolder(int paramAnonymousInt)
      {
        RecyclerView.ViewHolder localViewHolder = RecyclerView.this.findViewHolderForPosition(paramAnonymousInt, true);
        if (localViewHolder == null) {
          return null;
        }
        if (RecyclerView.this.mChildHelper.isHidden(localViewHolder.itemView)) {
          return null;
        }
        return localViewHolder;
      }
      
      public void markViewHoldersUpdated(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        RecyclerView.this.viewRangeUpdate(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
        RecyclerView.this.mItemsChanged = true;
      }
      
      public void offsetPositionsForAdd(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        RecyclerView.this.offsetPositionRecordsForInsert(paramAnonymousInt1, paramAnonymousInt2);
        RecyclerView.this.mItemsAddedOrRemoved = true;
      }
      
      public void offsetPositionsForMove(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        RecyclerView.this.offsetPositionRecordsForMove(paramAnonymousInt1, paramAnonymousInt2);
        RecyclerView.this.mItemsAddedOrRemoved = true;
      }
      
      public void offsetPositionsForRemovingInvisible(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        RecyclerView.this.offsetPositionRecordsForRemove(paramAnonymousInt1, paramAnonymousInt2, true);
        RecyclerView.this.mItemsAddedOrRemoved = true;
        RecyclerView.State localState = RecyclerView.this.mState;
        localState.mDeletedInvisibleItemCountSincePreviousLayout += paramAnonymousInt2;
      }
      
      public void offsetPositionsForRemovingLaidOutOrNewView(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        RecyclerView.this.offsetPositionRecordsForRemove(paramAnonymousInt1, paramAnonymousInt2, false);
        RecyclerView.this.mItemsAddedOrRemoved = true;
      }
      
      public void onDispatchFirstPass(AdapterHelper.UpdateOp paramAnonymousUpdateOp)
      {
        dispatchUpdate(paramAnonymousUpdateOp);
      }
      
      public void onDispatchSecondPass(AdapterHelper.UpdateOp paramAnonymousUpdateOp)
      {
        dispatchUpdate(paramAnonymousUpdateOp);
      }
    });
  }
  
  @VisibleForTesting
  void initFastScroller(StateListDrawable paramStateListDrawable1, Drawable paramDrawable1, StateListDrawable paramStateListDrawable2, Drawable paramDrawable2)
  {
    if ((paramStateListDrawable1 != null) && (paramDrawable1 != null) && (paramStateListDrawable2 != null) && (paramDrawable2 != null))
    {
      Resources localResources = getContext().getResources();
      new FastScroller(this, paramStateListDrawable1, paramDrawable1, paramStateListDrawable2, paramDrawable2, localResources.getDimensionPixelSize(R.dimen.fastscroll_default_thickness), localResources.getDimensionPixelSize(R.dimen.fastscroll_minimum_range), localResources.getDimensionPixelOffset(R.dimen.fastscroll_margin));
      return;
    }
    paramStateListDrawable1 = new StringBuilder();
    paramStateListDrawable1.append("Trying to set fast scroller without both required drawables.");
    paramStateListDrawable1.append(exceptionLabel());
    throw new IllegalArgumentException(paramStateListDrawable1.toString());
  }
  
  void invalidateGlows()
  {
    this.mBottomGlow = null;
    this.mTopGlow = null;
    this.mRightGlow = null;
    this.mLeftGlow = null;
  }
  
  public void invalidateItemDecorations()
  {
    if (this.mItemDecorations.size() == 0) {
      return;
    }
    if (this.mLayout != null) {
      this.mLayout.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
    }
    markItemDecorInsetsDirty();
    requestLayout();
  }
  
  boolean isAccessibilityEnabled()
  {
    return (this.mAccessibilityManager != null) && (this.mAccessibilityManager.isEnabled());
  }
  
  public boolean isAnimating()
  {
    return (this.mItemAnimator != null) && (this.mItemAnimator.isRunning());
  }
  
  public boolean isAttachedToWindow()
  {
    return this.mIsAttached;
  }
  
  public boolean isComputingLayout()
  {
    return this.mLayoutOrScrollCounter > 0;
  }
  
  public boolean isLayoutFrozen()
  {
    return this.mLayoutFrozen;
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return getScrollingChildHelper().isNestedScrollingEnabled();
  }
  
  void jumpToPositionForSmoothScroller(int paramInt)
  {
    if (this.mLayout == null) {
      return;
    }
    this.mLayout.scrollToPosition(paramInt);
    awakenScrollBars();
  }
  
  void markItemDecorInsetsDirty()
  {
    int j = this.mChildHelper.getUnfilteredChildCount();
    int i = 0;
    while (i < j)
    {
      ((LayoutParams)this.mChildHelper.getUnfilteredChildAt(i).getLayoutParams()).mInsetsDirty = true;
      i += 1;
    }
    this.mRecycler.markItemDecorInsetsDirty();
  }
  
  void markKnownViewsInvalid()
  {
    int j = this.mChildHelper.getUnfilteredChildCount();
    int i = 0;
    while (i < j)
    {
      ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
      if ((localViewHolder != null) && (!localViewHolder.shouldIgnore())) {
        localViewHolder.addFlags(6);
      }
      i += 1;
    }
    markItemDecorInsetsDirty();
    this.mRecycler.markKnownViewsInvalid();
  }
  
  public void offsetChildrenHorizontal(@Px int paramInt)
  {
    int j = this.mChildHelper.getChildCount();
    int i = 0;
    while (i < j)
    {
      this.mChildHelper.getChildAt(i).offsetLeftAndRight(paramInt);
      i += 1;
    }
  }
  
  public void offsetChildrenVertical(@Px int paramInt)
  {
    int j = this.mChildHelper.getChildCount();
    int i = 0;
    while (i < j)
    {
      this.mChildHelper.getChildAt(i).offsetTopAndBottom(paramInt);
      i += 1;
    }
  }
  
  void offsetPositionRecordsForInsert(int paramInt1, int paramInt2)
  {
    int j = this.mChildHelper.getUnfilteredChildCount();
    int i = 0;
    while (i < j)
    {
      ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
      if ((localViewHolder != null) && (!localViewHolder.shouldIgnore()) && (localViewHolder.mPosition >= paramInt1))
      {
        localViewHolder.offsetPosition(paramInt2, false);
        this.mState.mStructureChanged = true;
      }
      i += 1;
    }
    this.mRecycler.offsetPositionRecordsForInsert(paramInt1, paramInt2);
    requestLayout();
  }
  
  void offsetPositionRecordsForMove(int paramInt1, int paramInt2)
  {
    int n = this.mChildHelper.getUnfilteredChildCount();
    int i;
    int j;
    int k;
    if (paramInt1 < paramInt2)
    {
      i = paramInt1;
      j = paramInt2;
      k = -1;
    }
    else
    {
      j = paramInt1;
      i = paramInt2;
      k = 1;
    }
    int m = 0;
    while (m < n)
    {
      ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(m));
      if ((localViewHolder != null) && (localViewHolder.mPosition >= i) && (localViewHolder.mPosition <= j))
      {
        if (localViewHolder.mPosition == paramInt1) {
          localViewHolder.offsetPosition(paramInt2 - paramInt1, false);
        } else {
          localViewHolder.offsetPosition(k, false);
        }
        this.mState.mStructureChanged = true;
      }
      m += 1;
    }
    this.mRecycler.offsetPositionRecordsForMove(paramInt1, paramInt2);
    requestLayout();
  }
  
  void offsetPositionRecordsForRemove(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = this.mChildHelper.getUnfilteredChildCount();
    int i = 0;
    while (i < j)
    {
      ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
      if ((localViewHolder != null) && (!localViewHolder.shouldIgnore())) {
        if (localViewHolder.mPosition >= paramInt1 + paramInt2)
        {
          localViewHolder.offsetPosition(-paramInt2, paramBoolean);
          this.mState.mStructureChanged = true;
        }
        else if (localViewHolder.mPosition >= paramInt1)
        {
          localViewHolder.flagRemovedAndOffsetPosition(paramInt1 - 1, -paramInt2, paramBoolean);
          this.mState.mStructureChanged = true;
        }
      }
      i += 1;
    }
    this.mRecycler.offsetPositionRecordsForRemove(paramInt1, paramInt2, paramBoolean);
    requestLayout();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.mLayoutOrScrollCounter = 0;
    boolean bool = true;
    this.mIsAttached = true;
    if ((!this.mFirstLayoutComplete) || (isLayoutRequested())) {
      bool = false;
    }
    this.mFirstLayoutComplete = bool;
    if (this.mLayout != null) {
      this.mLayout.dispatchAttachedToWindow(this);
    }
    this.mPostedAnimatorRunner = false;
    if (ALLOW_THREAD_GAP_WORK)
    {
      this.mGapWorker = ((GapWorker)GapWorker.sGapWorker.get());
      if (this.mGapWorker == null)
      {
        this.mGapWorker = new GapWorker();
        Display localDisplay = ViewCompat.getDisplay(this);
        float f;
        if ((!isInEditMode()) && (localDisplay != null))
        {
          f = localDisplay.getRefreshRate();
          if (f >= 30.0F) {}
        }
        else
        {
          f = 60.0F;
        }
        this.mGapWorker.mFrameIntervalNs = ((1.0E9F / f));
        GapWorker.sGapWorker.set(this.mGapWorker);
      }
      this.mGapWorker.add(this);
    }
  }
  
  public void onChildAttachedToWindow(@NonNull View paramView) {}
  
  public void onChildDetachedFromWindow(@NonNull View paramView) {}
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.mItemAnimator != null) {
      this.mItemAnimator.endAnimations();
    }
    stopScroll();
    this.mIsAttached = false;
    if (this.mLayout != null) {
      this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
    }
    this.mPendingAccessibilityImportanceChange.clear();
    removeCallbacks(this.mItemAnimatorRunner);
    this.mViewInfoStore.onDetach();
    if ((ALLOW_THREAD_GAP_WORK) && (this.mGapWorker != null))
    {
      this.mGapWorker.remove(this);
      this.mGapWorker = null;
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = this.mItemDecorations.size();
    int i = 0;
    while (i < j)
    {
      ((ItemDecoration)this.mItemDecorations.get(i)).onDraw(paramCanvas, this, this.mState);
      i += 1;
    }
  }
  
  void onEnterLayoutOrScroll()
  {
    this.mLayoutOrScrollCounter += 1;
  }
  
  void onExitLayoutOrScroll()
  {
    onExitLayoutOrScroll(true);
  }
  
  void onExitLayoutOrScroll(boolean paramBoolean)
  {
    this.mLayoutOrScrollCounter -= 1;
    if (this.mLayoutOrScrollCounter < 1)
    {
      this.mLayoutOrScrollCounter = 0;
      if (paramBoolean)
      {
        dispatchContentChangedIfNecessary();
        dispatchPendingImportantForAccessibilityChanges();
      }
    }
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if (this.mLayout == null) {
      return false;
    }
    if (this.mLayoutFrozen) {
      return false;
    }
    if (paramMotionEvent.getAction() == 8)
    {
      float f1;
      if ((paramMotionEvent.getSource() & 0x2) != 0)
      {
        if (this.mLayout.canScrollVertically()) {
          f2 = -paramMotionEvent.getAxisValue(9);
        } else {
          f2 = 0.0F;
        }
        f1 = f2;
        if (this.mLayout.canScrollHorizontally())
        {
          float f3 = paramMotionEvent.getAxisValue(10);
          f1 = f2;
          f2 = f3;
          break label140;
        }
      }
      else
      {
        if ((paramMotionEvent.getSource() & 0x400000) != 0)
        {
          f2 = paramMotionEvent.getAxisValue(26);
          if (this.mLayout.canScrollVertically())
          {
            f1 = -f2;
            break label138;
          }
          if (this.mLayout.canScrollHorizontally())
          {
            f1 = 0.0F;
            break label140;
          }
        }
        f1 = 0.0F;
      }
      label138:
      float f2 = 0.0F;
      label140:
      if ((f1 != 0.0F) || (f2 != 0.0F)) {
        scrollByInternal((int)(f2 * this.mScaledHorizontalScrollFactor), (int)(f1 * this.mScaledVerticalScrollFactor), paramMotionEvent);
      }
    }
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = this.mLayoutFrozen;
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (dispatchOnItemTouchIntercept(paramMotionEvent))
    {
      cancelTouch();
      return true;
    }
    if (this.mLayout == null) {
      return false;
    }
    bool2 = this.mLayout.canScrollHorizontally();
    boolean bool3 = this.mLayout.canScrollVertically();
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    int j = paramMotionEvent.getActionMasked();
    int i = paramMotionEvent.getActionIndex();
    switch (j)
    {
    case 4: 
    default: 
      break;
    case 6: 
      onPointerUp(paramMotionEvent);
      break;
    case 5: 
      this.mScrollPointerId = paramMotionEvent.getPointerId(i);
      j = (int)(paramMotionEvent.getX(i) + 0.5F);
      this.mLastTouchX = j;
      this.mInitialTouchX = j;
      i = (int)(paramMotionEvent.getY(i) + 0.5F);
      this.mLastTouchY = i;
      this.mInitialTouchY = i;
      break;
    case 3: 
      cancelTouch();
      break;
    case 2: 
      j = paramMotionEvent.findPointerIndex(this.mScrollPointerId);
      if (j < 0)
      {
        paramMotionEvent = new StringBuilder();
        paramMotionEvent.append("Error processing scroll; pointer index for id ");
        paramMotionEvent.append(this.mScrollPointerId);
        paramMotionEvent.append(" not found. Did any MotionEvents get skipped?");
        Log.e("RecyclerView", paramMotionEvent.toString());
        return false;
      }
      i = (int)(paramMotionEvent.getX(j) + 0.5F);
      int k = (int)(paramMotionEvent.getY(j) + 0.5F);
      if (this.mScrollState != 1)
      {
        j = this.mInitialTouchX;
        int m = this.mInitialTouchY;
        if ((bool2) && (Math.abs(i - j) > this.mTouchSlop))
        {
          this.mLastTouchX = i;
          i = 1;
        }
        else
        {
          i = 0;
        }
        j = i;
        if (bool3)
        {
          j = i;
          if (Math.abs(k - m) > this.mTouchSlop)
          {
            this.mLastTouchY = k;
            j = 1;
          }
        }
        if (j != 0) {
          setScrollState(1);
        }
      }
      break;
    case 1: 
      this.mVelocityTracker.clear();
      stopNestedScroll(0);
      break;
    case 0: 
      if (this.mIgnoreMotionEventTillDown) {
        this.mIgnoreMotionEventTillDown = false;
      }
      this.mScrollPointerId = paramMotionEvent.getPointerId(0);
      i = (int)(paramMotionEvent.getX() + 0.5F);
      this.mLastTouchX = i;
      this.mInitialTouchX = i;
      i = (int)(paramMotionEvent.getY() + 0.5F);
      this.mLastTouchY = i;
      this.mInitialTouchY = i;
      if (this.mScrollState == 2)
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        setScrollState(1);
      }
      paramMotionEvent = this.mNestedOffsets;
      this.mNestedOffsets[1] = 0;
      paramMotionEvent[0] = 0;
      if (bool2) {
        i = 1;
      } else {
        i = 0;
      }
      j = i;
      if (bool3) {
        j = i | 0x2;
      }
      startNestedScroll(j, 0);
    }
    if (this.mScrollState == 1) {
      bool1 = true;
    }
    return bool1;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    TraceCompat.beginSection("RV OnLayout");
    dispatchLayout();
    TraceCompat.endSection();
    this.mFirstLayoutComplete = true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.mLayout == null)
    {
      defaultOnMeasure(paramInt1, paramInt2);
      return;
    }
    boolean bool = this.mLayout.isAutoMeasureEnabled();
    int j = 0;
    if (bool)
    {
      int k = View.MeasureSpec.getMode(paramInt1);
      int m = View.MeasureSpec.getMode(paramInt2);
      this.mLayout.onMeasure(this.mRecycler, this.mState, paramInt1, paramInt2);
      int i = j;
      if (k == 1073741824)
      {
        i = j;
        if (m == 1073741824) {
          i = 1;
        }
      }
      if (i == 0)
      {
        if (this.mAdapter == null) {
          return;
        }
        if (this.mState.mLayoutStep == 1) {
          dispatchLayoutStep1();
        }
        this.mLayout.setMeasureSpecs(paramInt1, paramInt2);
        this.mState.mIsMeasuring = true;
        dispatchLayoutStep2();
        this.mLayout.setMeasuredDimensionFromChildren(paramInt1, paramInt2);
        if (!this.mLayout.shouldMeasureTwice()) {
          return;
        }
        this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        this.mState.mIsMeasuring = true;
        dispatchLayoutStep2();
        this.mLayout.setMeasuredDimensionFromChildren(paramInt1, paramInt2);
      }
    }
    else
    {
      if (this.mHasFixedSize)
      {
        this.mLayout.onMeasure(this.mRecycler, this.mState, paramInt1, paramInt2);
        return;
      }
      if (this.mAdapterUpdateDuringMeasure)
      {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        onExitLayoutOrScroll();
        if (this.mState.mRunPredictiveAnimations)
        {
          this.mState.mInPreLayout = true;
        }
        else
        {
          this.mAdapterHelper.consumeUpdatesInOnePass();
          this.mState.mInPreLayout = false;
        }
        this.mAdapterUpdateDuringMeasure = false;
        stopInterceptRequestLayout(false);
      }
      else if (this.mState.mRunPredictiveAnimations)
      {
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
        return;
      }
      if (this.mAdapter != null) {
        this.mState.mItemCount = this.mAdapter.getItemCount();
      } else {
        this.mState.mItemCount = 0;
      }
      startInterceptRequestLayout();
      this.mLayout.onMeasure(this.mRecycler, this.mState, paramInt1, paramInt2);
      stopInterceptRequestLayout(false);
      this.mState.mInPreLayout = false;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    if (isComputingLayout()) {
      return false;
    }
    return super.onRequestFocusInDescendants(paramInt, paramRect);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    this.mPendingSavedState = ((SavedState)paramParcelable);
    super.onRestoreInstanceState(this.mPendingSavedState.getSuperState());
    if ((this.mLayout != null) && (this.mPendingSavedState.mLayoutState != null)) {
      this.mLayout.onRestoreInstanceState(this.mPendingSavedState.mLayoutState);
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if (this.mPendingSavedState != null)
    {
      localSavedState.copyFrom(this.mPendingSavedState);
      return localSavedState;
    }
    if (this.mLayout != null)
    {
      localSavedState.mLayoutState = this.mLayout.onSaveInstanceState();
      return localSavedState;
    }
    localSavedState.mLayoutState = null;
    return localSavedState;
  }
  
  public void onScrollStateChanged(int paramInt) {}
  
  public void onScrolled(@Px int paramInt1, @Px int paramInt2) {}
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
      invalidateGlows();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = this.mLayoutFrozen;
    int i2 = 0;
    if (!bool1)
    {
      if (this.mIgnoreMotionEventTillDown) {
        return false;
      }
      if (dispatchOnItemTouch(paramMotionEvent))
      {
        cancelTouch();
        return true;
      }
      if (this.mLayout == null) {
        return false;
      }
      bool1 = this.mLayout.canScrollHorizontally();
      boolean bool2 = this.mLayout.canScrollVertically();
      if (this.mVelocityTracker == null) {
        this.mVelocityTracker = VelocityTracker.obtain();
      }
      MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
      int j = paramMotionEvent.getActionMasked();
      int i = paramMotionEvent.getActionIndex();
      if (j == 0)
      {
        int[] arrayOfInt = this.mNestedOffsets;
        this.mNestedOffsets[1] = 0;
        arrayOfInt[0] = 0;
      }
      localMotionEvent.offsetLocation(this.mNestedOffsets[0], this.mNestedOffsets[1]);
      switch (j)
      {
      case 4: 
      default: 
        i = i2;
        break;
      case 6: 
        onPointerUp(paramMotionEvent);
        i = i2;
        break;
      case 5: 
        this.mScrollPointerId = paramMotionEvent.getPointerId(i);
        j = (int)(paramMotionEvent.getX(i) + 0.5F);
        this.mLastTouchX = j;
        this.mInitialTouchX = j;
        i = (int)(paramMotionEvent.getY(i) + 0.5F);
        this.mLastTouchY = i;
        this.mInitialTouchY = i;
        i = i2;
        break;
      case 3: 
        cancelTouch();
        i = i2;
        break;
      case 2: 
        i = paramMotionEvent.findPointerIndex(this.mScrollPointerId);
        if (i < 0)
        {
          paramMotionEvent = new StringBuilder();
          paramMotionEvent.append("Error processing scroll; pointer index for id ");
          paramMotionEvent.append(this.mScrollPointerId);
          paramMotionEvent.append(" not found. Did any MotionEvents get skipped?");
          Log.e("RecyclerView", paramMotionEvent.toString());
          return false;
        }
        int i3 = (int)(paramMotionEvent.getX(i) + 0.5F);
        int i4 = (int)(paramMotionEvent.getY(i) + 0.5F);
        int m = this.mLastTouchX - i3;
        int k = this.mLastTouchY - i4;
        j = m;
        i = k;
        if (dispatchNestedPreScroll(m, k, this.mScrollConsumed, this.mScrollOffset, 0))
        {
          j = m - this.mScrollConsumed[0];
          i = k - this.mScrollConsumed[1];
          localMotionEvent.offsetLocation(this.mScrollOffset[0], this.mScrollOffset[1]);
          paramMotionEvent = this.mNestedOffsets;
          paramMotionEvent[0] += this.mScrollOffset[0];
          paramMotionEvent = this.mNestedOffsets;
          paramMotionEvent[1] += this.mScrollOffset[1];
        }
        k = j;
        m = i;
        if (this.mScrollState != 1)
        {
          if ((bool1) && (Math.abs(j) > this.mTouchSlop))
          {
            if (j > 0) {
              j -= this.mTouchSlop;
            } else {
              j += this.mTouchSlop;
            }
            k = 1;
          }
          else
          {
            k = 0;
          }
          int i1 = k;
          int n = i;
          if (bool2)
          {
            i1 = k;
            n = i;
            if (Math.abs(i) > this.mTouchSlop)
            {
              if (i > 0) {
                n = i - this.mTouchSlop;
              } else {
                n = i + this.mTouchSlop;
              }
              i1 = 1;
            }
          }
          k = j;
          m = n;
          if (i1 != 0)
          {
            setScrollState(1);
            m = n;
            k = j;
          }
        }
        i = i2;
        if (this.mScrollState == 1)
        {
          this.mLastTouchX = (i3 - this.mScrollOffset[0]);
          this.mLastTouchY = (i4 - this.mScrollOffset[1]);
          if (bool1) {
            i = k;
          } else {
            i = 0;
          }
          if (bool2) {
            j = m;
          } else {
            j = 0;
          }
          if (scrollByInternal(i, j, localMotionEvent)) {
            getParent().requestDisallowInterceptTouchEvent(true);
          }
          i = i2;
          if (this.mGapWorker != null) {
            if (k == 0)
            {
              i = i2;
              if (m == 0) {
                break;
              }
            }
            else
            {
              this.mGapWorker.postFromTraversal(this, k, m);
              i = i2;
            }
          }
        }
        break;
      case 1: 
        this.mVelocityTracker.addMovement(localMotionEvent);
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
        float f1;
        if (bool1) {
          f1 = -this.mVelocityTracker.getXVelocity(this.mScrollPointerId);
        } else {
          f1 = 0.0F;
        }
        float f2;
        if (bool2) {
          f2 = -this.mVelocityTracker.getYVelocity(this.mScrollPointerId);
        } else {
          f2 = 0.0F;
        }
        if (((f1 == 0.0F) && (f2 == 0.0F)) || (!fling((int)f1, (int)f2))) {
          setScrollState(0);
        }
        resetTouch();
        i = 1;
        break;
      case 0: 
        this.mScrollPointerId = paramMotionEvent.getPointerId(0);
        i = (int)(paramMotionEvent.getX() + 0.5F);
        this.mLastTouchX = i;
        this.mInitialTouchX = i;
        i = (int)(paramMotionEvent.getY() + 0.5F);
        this.mLastTouchY = i;
        this.mInitialTouchY = i;
        if (bool1) {
          i = 1;
        } else {
          i = 0;
        }
        j = i;
        if (bool2) {
          j = i | 0x2;
        }
        startNestedScroll(j, 0);
        i = i2;
      }
      if (i == 0) {
        this.mVelocityTracker.addMovement(localMotionEvent);
      }
      localMotionEvent.recycle();
      return true;
    }
    return false;
  }
  
  void postAnimationRunner()
  {
    if ((!this.mPostedAnimatorRunner) && (this.mIsAttached))
    {
      ViewCompat.postOnAnimation(this, this.mItemAnimatorRunner);
      this.mPostedAnimatorRunner = true;
    }
  }
  
  void processDataSetCompletelyChanged(boolean paramBoolean)
  {
    this.mDispatchItemsChangedEvent = (paramBoolean | this.mDispatchItemsChangedEvent);
    this.mDataSetHasChangedAfterLayout = true;
    markKnownViewsInvalid();
  }
  
  void recordAnimationInfoIfBouncedHiddenView(ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo)
  {
    paramViewHolder.setFlags(0, 8192);
    if ((this.mState.mTrackOldChangeHolders) && (paramViewHolder.isUpdated()) && (!paramViewHolder.isRemoved()) && (!paramViewHolder.shouldIgnore()))
    {
      long l = getChangedHolderKey(paramViewHolder);
      this.mViewInfoStore.addToOldChangeHolders(l, paramViewHolder);
    }
    this.mViewInfoStore.addToPreLayout(paramViewHolder, paramItemHolderInfo);
  }
  
  void removeAndRecycleViews()
  {
    if (this.mItemAnimator != null) {
      this.mItemAnimator.endAnimations();
    }
    if (this.mLayout != null)
    {
      this.mLayout.removeAndRecycleAllViews(this.mRecycler);
      this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
    }
    this.mRecycler.clear();
  }
  
  boolean removeAnimatingView(View paramView)
  {
    startInterceptRequestLayout();
    boolean bool = this.mChildHelper.removeViewIfHidden(paramView);
    if (bool)
    {
      paramView = getChildViewHolderInt(paramView);
      this.mRecycler.unscrapView(paramView);
      this.mRecycler.recycleViewHolderInternal(paramView);
    }
    stopInterceptRequestLayout(bool ^ true);
    return bool;
  }
  
  protected void removeDetachedView(View paramView, boolean paramBoolean)
  {
    ViewHolder localViewHolder = getChildViewHolderInt(paramView);
    if (localViewHolder != null) {
      if (localViewHolder.isTmpDetached())
      {
        localViewHolder.clearTmpDetachFlag();
      }
      else if (!localViewHolder.shouldIgnore())
      {
        paramView = new StringBuilder();
        paramView.append("Called removeDetachedView with a view which is not flagged as tmp detached.");
        paramView.append(localViewHolder);
        paramView.append(exceptionLabel());
        throw new IllegalArgumentException(paramView.toString());
      }
    }
    paramView.clearAnimation();
    dispatchChildDetached(paramView);
    super.removeDetachedView(paramView, paramBoolean);
  }
  
  public void removeItemDecoration(@NonNull ItemDecoration paramItemDecoration)
  {
    if (this.mLayout != null) {
      this.mLayout.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
    }
    this.mItemDecorations.remove(paramItemDecoration);
    if (this.mItemDecorations.isEmpty())
    {
      boolean bool;
      if (getOverScrollMode() == 2) {
        bool = true;
      } else {
        bool = false;
      }
      setWillNotDraw(bool);
    }
    markItemDecorInsetsDirty();
    requestLayout();
  }
  
  public void removeItemDecorationAt(int paramInt)
  {
    int i = getItemDecorationCount();
    if ((paramInt >= 0) && (paramInt < i))
    {
      removeItemDecoration(getItemDecorationAt(paramInt));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" is an invalid index for size ");
    localStringBuilder.append(i);
    throw new IndexOutOfBoundsException(localStringBuilder.toString());
  }
  
  public void removeOnChildAttachStateChangeListener(@NonNull OnChildAttachStateChangeListener paramOnChildAttachStateChangeListener)
  {
    if (this.mOnChildAttachStateListeners == null) {
      return;
    }
    this.mOnChildAttachStateListeners.remove(paramOnChildAttachStateChangeListener);
  }
  
  public void removeOnItemTouchListener(@NonNull OnItemTouchListener paramOnItemTouchListener)
  {
    this.mOnItemTouchListeners.remove(paramOnItemTouchListener);
    if (this.mActiveOnItemTouchListener == paramOnItemTouchListener) {
      this.mActiveOnItemTouchListener = null;
    }
  }
  
  public void removeOnScrollListener(@NonNull OnScrollListener paramOnScrollListener)
  {
    if (this.mScrollListeners != null) {
      this.mScrollListeners.remove(paramOnScrollListener);
    }
  }
  
  void repositionShadowingViews()
  {
    int j = this.mChildHelper.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.mChildHelper.getChildAt(i);
      Object localObject = getChildViewHolder(localView);
      if ((localObject != null) && (((ViewHolder)localObject).mShadowingHolder != null))
      {
        localObject = ((ViewHolder)localObject).mShadowingHolder.itemView;
        int k = localView.getLeft();
        int m = localView.getTop();
        if ((k != ((View)localObject).getLeft()) || (m != ((View)localObject).getTop())) {
          ((View)localObject).layout(k, m, ((View)localObject).getWidth() + k, ((View)localObject).getHeight() + m);
        }
      }
      i += 1;
    }
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    if ((!this.mLayout.onRequestChildFocus(this, this.mState, paramView1, paramView2)) && (paramView2 != null)) {
      requestChildOnScreen(paramView1, paramView2);
    }
    super.requestChildFocus(paramView1, paramView2);
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    return this.mLayout.requestChildRectangleOnScreen(this, paramView, paramRect, paramBoolean);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    int j = this.mOnItemTouchListeners.size();
    int i = 0;
    while (i < j)
    {
      ((OnItemTouchListener)this.mOnItemTouchListeners.get(i)).onRequestDisallowInterceptTouchEvent(paramBoolean);
      i += 1;
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    if ((this.mInterceptRequestLayoutDepth == 0) && (!this.mLayoutFrozen))
    {
      super.requestLayout();
      return;
    }
    this.mLayoutWasDefered = true;
  }
  
  void saveOldPositions()
  {
    int j = this.mChildHelper.getUnfilteredChildCount();
    int i = 0;
    while (i < j)
    {
      ViewHolder localViewHolder = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(i));
      if (!localViewHolder.shouldIgnore()) {
        localViewHolder.saveOldPosition();
      }
      i += 1;
    }
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    if (this.mLayout == null)
    {
      Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    if (this.mLayoutFrozen) {
      return;
    }
    boolean bool1 = this.mLayout.canScrollHorizontally();
    boolean bool2 = this.mLayout.canScrollVertically();
    if ((bool1) || (bool2))
    {
      if (!bool1) {
        paramInt1 = 0;
      }
      if (!bool2) {
        paramInt2 = 0;
      }
      scrollByInternal(paramInt1, paramInt2, null);
    }
  }
  
  boolean scrollByInternal(int paramInt1, int paramInt2, MotionEvent paramMotionEvent)
  {
    consumePendingUpdateOperations();
    Adapter localAdapter = this.mAdapter;
    boolean bool = false;
    int m;
    int k;
    int j;
    int i;
    if (localAdapter != null)
    {
      scrollStep(paramInt1, paramInt2, this.mScrollStepConsumed);
      m = this.mScrollStepConsumed[0];
      k = this.mScrollStepConsumed[1];
      j = m;
      i = k;
      m = paramInt1 - m;
      k = paramInt2 - k;
    }
    else
    {
      k = 0;
      j = 0;
      i = 0;
      m = 0;
    }
    if (!this.mItemDecorations.isEmpty()) {
      invalidate();
    }
    if (dispatchNestedScroll(j, i, m, k, this.mScrollOffset, 0))
    {
      this.mLastTouchX -= this.mScrollOffset[0];
      this.mLastTouchY -= this.mScrollOffset[1];
      if (paramMotionEvent != null) {
        paramMotionEvent.offsetLocation(this.mScrollOffset[0], this.mScrollOffset[1]);
      }
      paramMotionEvent = this.mNestedOffsets;
      paramMotionEvent[0] += this.mScrollOffset[0];
      paramMotionEvent = this.mNestedOffsets;
      paramMotionEvent[1] += this.mScrollOffset[1];
    }
    else if (getOverScrollMode() != 2)
    {
      if ((paramMotionEvent != null) && (!MotionEventCompat.isFromSource(paramMotionEvent, 8194))) {
        pullGlows(paramMotionEvent.getX(), m, paramMotionEvent.getY(), k);
      }
      considerReleasingGlowsOnScroll(paramInt1, paramInt2);
    }
    if ((j != 0) || (i != 0)) {
      dispatchOnScrolled(j, i);
    }
    if (!awakenScrollBars()) {
      invalidate();
    }
    if ((j != 0) || (i != 0)) {
      bool = true;
    }
    return bool;
  }
  
  void scrollStep(int paramInt1, int paramInt2, @Nullable int[] paramArrayOfInt)
  {
    startInterceptRequestLayout();
    onEnterLayoutOrScroll();
    TraceCompat.beginSection("RV Scroll");
    fillRemainingScrollValues(this.mState);
    if (paramInt1 != 0) {
      paramInt1 = this.mLayout.scrollHorizontallyBy(paramInt1, this.mRecycler, this.mState);
    } else {
      paramInt1 = 0;
    }
    if (paramInt2 != 0) {
      paramInt2 = this.mLayout.scrollVerticallyBy(paramInt2, this.mRecycler, this.mState);
    } else {
      paramInt2 = 0;
    }
    TraceCompat.endSection();
    repositionShadowingViews();
    onExitLayoutOrScroll();
    stopInterceptRequestLayout(false);
    if (paramArrayOfInt != null)
    {
      paramArrayOfInt[0] = paramInt1;
      paramArrayOfInt[1] = paramInt2;
    }
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
  }
  
  public void scrollToPosition(int paramInt)
  {
    if (this.mLayoutFrozen) {
      return;
    }
    stopScroll();
    if (this.mLayout == null)
    {
      Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    this.mLayout.scrollToPosition(paramInt);
    awakenScrollBars();
  }
  
  public void sendAccessibilityEventUnchecked(AccessibilityEvent paramAccessibilityEvent)
  {
    if (shouldDeferAccessibilityEvent(paramAccessibilityEvent)) {
      return;
    }
    super.sendAccessibilityEventUnchecked(paramAccessibilityEvent);
  }
  
  public void setAccessibilityDelegateCompat(@Nullable RecyclerViewAccessibilityDelegate paramRecyclerViewAccessibilityDelegate)
  {
    this.mAccessibilityDelegate = paramRecyclerViewAccessibilityDelegate;
    ViewCompat.setAccessibilityDelegate(this, this.mAccessibilityDelegate);
  }
  
  public void setAdapter(@Nullable Adapter paramAdapter)
  {
    setLayoutFrozen(false);
    setAdapterInternal(paramAdapter, false, true);
    processDataSetCompletelyChanged(false);
    requestLayout();
  }
  
  public void setChildDrawingOrderCallback(@Nullable ChildDrawingOrderCallback paramChildDrawingOrderCallback)
  {
    if (paramChildDrawingOrderCallback == this.mChildDrawingOrderCallback) {
      return;
    }
    this.mChildDrawingOrderCallback = paramChildDrawingOrderCallback;
    boolean bool;
    if (this.mChildDrawingOrderCallback != null) {
      bool = true;
    } else {
      bool = false;
    }
    setChildrenDrawingOrderEnabled(bool);
  }
  
  @VisibleForTesting
  boolean setChildImportantForAccessibilityInternal(ViewHolder paramViewHolder, int paramInt)
  {
    if (isComputingLayout())
    {
      paramViewHolder.mPendingAccessibilityState = paramInt;
      this.mPendingAccessibilityImportanceChange.add(paramViewHolder);
      return false;
    }
    ViewCompat.setImportantForAccessibility(paramViewHolder.itemView, paramInt);
    return true;
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    if (paramBoolean != this.mClipToPadding) {
      invalidateGlows();
    }
    this.mClipToPadding = paramBoolean;
    super.setClipToPadding(paramBoolean);
    if (this.mFirstLayoutComplete) {
      requestLayout();
    }
  }
  
  public void setEdgeEffectFactory(@NonNull EdgeEffectFactory paramEdgeEffectFactory)
  {
    Preconditions.checkNotNull(paramEdgeEffectFactory);
    this.mEdgeEffectFactory = paramEdgeEffectFactory;
    invalidateGlows();
  }
  
  public void setHasFixedSize(boolean paramBoolean)
  {
    this.mHasFixedSize = paramBoolean;
  }
  
  public void setItemAnimator(@Nullable ItemAnimator paramItemAnimator)
  {
    if (this.mItemAnimator != null)
    {
      this.mItemAnimator.endAnimations();
      this.mItemAnimator.setListener(null);
    }
    this.mItemAnimator = paramItemAnimator;
    if (this.mItemAnimator != null) {
      this.mItemAnimator.setListener(this.mItemAnimatorListener);
    }
  }
  
  public void setItemViewCacheSize(int paramInt)
  {
    this.mRecycler.setViewCacheSize(paramInt);
  }
  
  public void setLayoutFrozen(boolean paramBoolean)
  {
    if (paramBoolean != this.mLayoutFrozen)
    {
      assertNotInLayoutOrScroll("Do not setLayoutFrozen in layout or scroll");
      if (!paramBoolean)
      {
        this.mLayoutFrozen = false;
        if ((this.mLayoutWasDefered) && (this.mLayout != null) && (this.mAdapter != null)) {
          requestLayout();
        }
        this.mLayoutWasDefered = false;
        return;
      }
      long l = SystemClock.uptimeMillis();
      onTouchEvent(MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0));
      this.mLayoutFrozen = true;
      this.mIgnoreMotionEventTillDown = true;
      stopScroll();
    }
  }
  
  public void setLayoutManager(@Nullable LayoutManager paramLayoutManager)
  {
    if (paramLayoutManager == this.mLayout) {
      return;
    }
    stopScroll();
    if (this.mLayout != null)
    {
      if (this.mItemAnimator != null) {
        this.mItemAnimator.endAnimations();
      }
      this.mLayout.removeAndRecycleAllViews(this.mRecycler);
      this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
      this.mRecycler.clear();
      if (this.mIsAttached) {
        this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
      }
      this.mLayout.setRecyclerView(null);
      this.mLayout = null;
    }
    else
    {
      this.mRecycler.clear();
    }
    this.mChildHelper.removeAllViewsUnfiltered();
    this.mLayout = paramLayoutManager;
    if (paramLayoutManager != null) {
      if (paramLayoutManager.mRecyclerView == null)
      {
        this.mLayout.setRecyclerView(this);
        if (this.mIsAttached) {
          this.mLayout.dispatchAttachedToWindow(this);
        }
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("LayoutManager ");
        localStringBuilder.append(paramLayoutManager);
        localStringBuilder.append(" is already attached to a RecyclerView:");
        localStringBuilder.append(paramLayoutManager.mRecyclerView.exceptionLabel());
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
    }
    this.mRecycler.updateViewCacheSize();
    requestLayout();
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    getScrollingChildHelper().setNestedScrollingEnabled(paramBoolean);
  }
  
  public void setOnFlingListener(@Nullable OnFlingListener paramOnFlingListener)
  {
    this.mOnFlingListener = paramOnFlingListener;
  }
  
  @Deprecated
  public void setOnScrollListener(@Nullable OnScrollListener paramOnScrollListener)
  {
    this.mScrollListener = paramOnScrollListener;
  }
  
  public void setPreserveFocusAfterLayout(boolean paramBoolean)
  {
    this.mPreserveFocusAfterLayout = paramBoolean;
  }
  
  public void setRecycledViewPool(@Nullable RecycledViewPool paramRecycledViewPool)
  {
    this.mRecycler.setRecycledViewPool(paramRecycledViewPool);
  }
  
  public void setRecyclerListener(@Nullable RecyclerListener paramRecyclerListener)
  {
    this.mRecyclerListener = paramRecyclerListener;
  }
  
  void setScrollState(int paramInt)
  {
    if (paramInt == this.mScrollState) {
      return;
    }
    this.mScrollState = paramInt;
    if (paramInt != 2) {
      stopScrollersInternal();
    }
    dispatchOnScrollStateChanged(paramInt);
  }
  
  public void setScrollingTouchSlop(int paramInt)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    switch (paramInt)
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setScrollingTouchSlop(): bad argument constant ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("; using default value");
      Log.w("RecyclerView", localStringBuilder.toString());
      break;
    case 1: 
      this.mTouchSlop = localViewConfiguration.getScaledPagingTouchSlop();
      return;
    }
    this.mTouchSlop = localViewConfiguration.getScaledTouchSlop();
  }
  
  public void setViewCacheExtension(@Nullable ViewCacheExtension paramViewCacheExtension)
  {
    this.mRecycler.setViewCacheExtension(paramViewCacheExtension);
  }
  
  boolean shouldDeferAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (isComputingLayout())
    {
      int i;
      if (paramAccessibilityEvent != null) {
        i = AccessibilityEventCompat.getContentChangeTypes(paramAccessibilityEvent);
      } else {
        i = 0;
      }
      int j = i;
      if (i == 0) {
        j = 0;
      }
      this.mEatenAccessibilityChangeFlags = (j | this.mEatenAccessibilityChangeFlags);
      return true;
    }
    return false;
  }
  
  public void smoothScrollBy(@Px int paramInt1, @Px int paramInt2)
  {
    smoothScrollBy(paramInt1, paramInt2, null);
  }
  
  public void smoothScrollBy(@Px int paramInt1, @Px int paramInt2, @Nullable Interpolator paramInterpolator)
  {
    if (this.mLayout == null)
    {
      Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    if (this.mLayoutFrozen) {
      return;
    }
    if (!this.mLayout.canScrollHorizontally()) {
      paramInt1 = 0;
    }
    if (!this.mLayout.canScrollVertically()) {
      paramInt2 = 0;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      this.mViewFlinger.smoothScrollBy(paramInt1, paramInt2, paramInterpolator);
    }
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    if (this.mLayoutFrozen) {
      return;
    }
    if (this.mLayout == null)
    {
      Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    this.mLayout.smoothScrollToPosition(this, this.mState, paramInt);
  }
  
  void startInterceptRequestLayout()
  {
    this.mInterceptRequestLayoutDepth += 1;
    if ((this.mInterceptRequestLayoutDepth == 1) && (!this.mLayoutFrozen)) {
      this.mLayoutWasDefered = false;
    }
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return getScrollingChildHelper().startNestedScroll(paramInt);
  }
  
  public boolean startNestedScroll(int paramInt1, int paramInt2)
  {
    return getScrollingChildHelper().startNestedScroll(paramInt1, paramInt2);
  }
  
  void stopInterceptRequestLayout(boolean paramBoolean)
  {
    if (this.mInterceptRequestLayoutDepth < 1) {
      this.mInterceptRequestLayoutDepth = 1;
    }
    if ((!paramBoolean) && (!this.mLayoutFrozen)) {
      this.mLayoutWasDefered = false;
    }
    if (this.mInterceptRequestLayoutDepth == 1)
    {
      if ((paramBoolean) && (this.mLayoutWasDefered) && (!this.mLayoutFrozen) && (this.mLayout != null) && (this.mAdapter != null)) {
        dispatchLayout();
      }
      if (!this.mLayoutFrozen) {
        this.mLayoutWasDefered = false;
      }
    }
    this.mInterceptRequestLayoutDepth -= 1;
  }
  
  public void stopNestedScroll()
  {
    getScrollingChildHelper().stopNestedScroll();
  }
  
  public void stopNestedScroll(int paramInt)
  {
    getScrollingChildHelper().stopNestedScroll(paramInt);
  }
  
  public void stopScroll()
  {
    setScrollState(0);
    stopScrollersInternal();
  }
  
  public void swapAdapter(@Nullable Adapter paramAdapter, boolean paramBoolean)
  {
    setLayoutFrozen(false);
    setAdapterInternal(paramAdapter, true, paramBoolean);
    processDataSetCompletelyChanged(true);
    requestLayout();
  }
  
  void viewRangeUpdate(int paramInt1, int paramInt2, Object paramObject)
  {
    int j = this.mChildHelper.getUnfilteredChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.mChildHelper.getUnfilteredChildAt(i);
      ViewHolder localViewHolder = getChildViewHolderInt(localView);
      if ((localViewHolder != null) && (!localViewHolder.shouldIgnore()) && (localViewHolder.mPosition >= paramInt1) && (localViewHolder.mPosition < paramInt1 + paramInt2))
      {
        localViewHolder.addFlags(2);
        localViewHolder.addChangePayload(paramObject);
        ((LayoutParams)localView.getLayoutParams()).mInsetsDirty = true;
      }
      i += 1;
    }
    this.mRecycler.viewRangeUpdate(paramInt1, paramInt2);
  }
  
  public static abstract class Adapter<VH extends RecyclerView.ViewHolder>
  {
    private boolean mHasStableIds = false;
    private final RecyclerView.AdapterDataObservable mObservable = new RecyclerView.AdapterDataObservable();
    
    public final void bindViewHolder(@NonNull VH paramVH, int paramInt)
    {
      paramVH.mPosition = paramInt;
      if (hasStableIds()) {
        paramVH.mItemId = getItemId(paramInt);
      }
      paramVH.setFlags(1, 519);
      TraceCompat.beginSection("RV OnBindView");
      onBindViewHolder(paramVH, paramInt, paramVH.getUnmodifiedPayloads());
      paramVH.clearPayload();
      paramVH = paramVH.itemView.getLayoutParams();
      if ((paramVH instanceof RecyclerView.LayoutParams)) {
        ((RecyclerView.LayoutParams)paramVH).mInsetsDirty = true;
      }
      TraceCompat.endSection();
    }
    
    @NonNull
    public final VH createViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt)
    {
      try
      {
        TraceCompat.beginSection("RV CreateView");
        paramViewGroup = onCreateViewHolder(paramViewGroup, paramInt);
        if (paramViewGroup.itemView.getParent() == null)
        {
          paramViewGroup.mItemViewType = paramInt;
          return paramViewGroup;
        }
        throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
      }
      finally
      {
        TraceCompat.endSection();
      }
    }
    
    public abstract int getItemCount();
    
    public long getItemId(int paramInt)
    {
      return -1L;
    }
    
    public int getItemViewType(int paramInt)
    {
      return 0;
    }
    
    public final boolean hasObservers()
    {
      return this.mObservable.hasObservers();
    }
    
    public final boolean hasStableIds()
    {
      return this.mHasStableIds;
    }
    
    public final void notifyDataSetChanged()
    {
      this.mObservable.notifyChanged();
    }
    
    public final void notifyItemChanged(int paramInt)
    {
      this.mObservable.notifyItemRangeChanged(paramInt, 1);
    }
    
    public final void notifyItemChanged(int paramInt, @Nullable Object paramObject)
    {
      this.mObservable.notifyItemRangeChanged(paramInt, 1, paramObject);
    }
    
    public final void notifyItemInserted(int paramInt)
    {
      this.mObservable.notifyItemRangeInserted(paramInt, 1);
    }
    
    public final void notifyItemMoved(int paramInt1, int paramInt2)
    {
      this.mObservable.notifyItemMoved(paramInt1, paramInt2);
    }
    
    public final void notifyItemRangeChanged(int paramInt1, int paramInt2)
    {
      this.mObservable.notifyItemRangeChanged(paramInt1, paramInt2);
    }
    
    public final void notifyItemRangeChanged(int paramInt1, int paramInt2, @Nullable Object paramObject)
    {
      this.mObservable.notifyItemRangeChanged(paramInt1, paramInt2, paramObject);
    }
    
    public final void notifyItemRangeInserted(int paramInt1, int paramInt2)
    {
      this.mObservable.notifyItemRangeInserted(paramInt1, paramInt2);
    }
    
    public final void notifyItemRangeRemoved(int paramInt1, int paramInt2)
    {
      this.mObservable.notifyItemRangeRemoved(paramInt1, paramInt2);
    }
    
    public final void notifyItemRemoved(int paramInt)
    {
      this.mObservable.notifyItemRangeRemoved(paramInt, 1);
    }
    
    public void onAttachedToRecyclerView(@NonNull RecyclerView paramRecyclerView) {}
    
    public abstract void onBindViewHolder(@NonNull VH paramVH, int paramInt);
    
    public void onBindViewHolder(@NonNull VH paramVH, int paramInt, @NonNull List<Object> paramList)
    {
      onBindViewHolder(paramVH, paramInt);
    }
    
    @NonNull
    public abstract VH onCreateViewHolder(@NonNull ViewGroup paramViewGroup, int paramInt);
    
    public void onDetachedFromRecyclerView(@NonNull RecyclerView paramRecyclerView) {}
    
    public boolean onFailedToRecycleView(@NonNull VH paramVH)
    {
      return false;
    }
    
    public void onViewAttachedToWindow(@NonNull VH paramVH) {}
    
    public void onViewDetachedFromWindow(@NonNull VH paramVH) {}
    
    public void onViewRecycled(@NonNull VH paramVH) {}
    
    public void registerAdapterDataObserver(@NonNull RecyclerView.AdapterDataObserver paramAdapterDataObserver)
    {
      this.mObservable.registerObserver(paramAdapterDataObserver);
    }
    
    public void setHasStableIds(boolean paramBoolean)
    {
      if (!hasObservers())
      {
        this.mHasStableIds = paramBoolean;
        return;
      }
      throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
    }
    
    public void unregisterAdapterDataObserver(@NonNull RecyclerView.AdapterDataObserver paramAdapterDataObserver)
    {
      this.mObservable.unregisterObserver(paramAdapterDataObserver);
    }
  }
  
  static class AdapterDataObservable
    extends Observable<RecyclerView.AdapterDataObserver>
  {
    public boolean hasObservers()
    {
      return this.mObservers.isEmpty() ^ true;
    }
    
    public void notifyChanged()
    {
      int i = this.mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onChanged();
        i -= 1;
      }
    }
    
    public void notifyItemMoved(int paramInt1, int paramInt2)
    {
      int i = this.mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onItemRangeMoved(paramInt1, paramInt2, 1);
        i -= 1;
      }
    }
    
    public void notifyItemRangeChanged(int paramInt1, int paramInt2)
    {
      notifyItemRangeChanged(paramInt1, paramInt2, null);
    }
    
    public void notifyItemRangeChanged(int paramInt1, int paramInt2, @Nullable Object paramObject)
    {
      int i = this.mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onItemRangeChanged(paramInt1, paramInt2, paramObject);
        i -= 1;
      }
    }
    
    public void notifyItemRangeInserted(int paramInt1, int paramInt2)
    {
      int i = this.mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onItemRangeInserted(paramInt1, paramInt2);
        i -= 1;
      }
    }
    
    public void notifyItemRangeRemoved(int paramInt1, int paramInt2)
    {
      int i = this.mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.AdapterDataObserver)this.mObservers.get(i)).onItemRangeRemoved(paramInt1, paramInt2);
        i -= 1;
      }
    }
  }
  
  public static abstract class AdapterDataObserver
  {
    public void onChanged() {}
    
    public void onItemRangeChanged(int paramInt1, int paramInt2) {}
    
    public void onItemRangeChanged(int paramInt1, int paramInt2, @Nullable Object paramObject)
    {
      onItemRangeChanged(paramInt1, paramInt2);
    }
    
    public void onItemRangeInserted(int paramInt1, int paramInt2) {}
    
    public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onItemRangeRemoved(int paramInt1, int paramInt2) {}
  }
  
  public static abstract interface ChildDrawingOrderCallback
  {
    public abstract int onGetChildDrawingOrder(int paramInt1, int paramInt2);
  }
  
  public static class EdgeEffectFactory
  {
    public static final int DIRECTION_BOTTOM = 3;
    public static final int DIRECTION_LEFT = 0;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_TOP = 1;
    
    @NonNull
    protected EdgeEffect createEdgeEffect(@NonNull RecyclerView paramRecyclerView, int paramInt)
    {
      return new EdgeEffect(paramRecyclerView.getContext());
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public static @interface EdgeDirection {}
  }
  
  public static abstract class ItemAnimator
  {
    public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
    public static final int FLAG_CHANGED = 2;
    public static final int FLAG_INVALIDATED = 4;
    public static final int FLAG_MOVED = 2048;
    public static final int FLAG_REMOVED = 8;
    private long mAddDuration = 120L;
    private long mChangeDuration = 250L;
    private ArrayList<ItemAnimatorFinishedListener> mFinishedListeners = new ArrayList();
    private ItemAnimatorListener mListener = null;
    private long mMoveDuration = 250L;
    private long mRemoveDuration = 120L;
    
    static int buildAdapterChangeFlagsForAnimations(RecyclerView.ViewHolder paramViewHolder)
    {
      int j = paramViewHolder.mFlags & 0xE;
      if (paramViewHolder.isInvalid()) {
        return 4;
      }
      int i = j;
      if ((j & 0x4) == 0)
      {
        int k = paramViewHolder.getOldPosition();
        int m = paramViewHolder.getAdapterPosition();
        i = j;
        if (k != -1)
        {
          i = j;
          if (m != -1)
          {
            i = j;
            if (k != m) {
              i = j | 0x800;
            }
          }
        }
      }
      return i;
    }
    
    public abstract boolean animateAppearance(@NonNull RecyclerView.ViewHolder paramViewHolder, @Nullable ItemHolderInfo paramItemHolderInfo1, @NonNull ItemHolderInfo paramItemHolderInfo2);
    
    public abstract boolean animateChange(@NonNull RecyclerView.ViewHolder paramViewHolder1, @NonNull RecyclerView.ViewHolder paramViewHolder2, @NonNull ItemHolderInfo paramItemHolderInfo1, @NonNull ItemHolderInfo paramItemHolderInfo2);
    
    public abstract boolean animateDisappearance(@NonNull RecyclerView.ViewHolder paramViewHolder, @NonNull ItemHolderInfo paramItemHolderInfo1, @Nullable ItemHolderInfo paramItemHolderInfo2);
    
    public abstract boolean animatePersistence(@NonNull RecyclerView.ViewHolder paramViewHolder, @NonNull ItemHolderInfo paramItemHolderInfo1, @NonNull ItemHolderInfo paramItemHolderInfo2);
    
    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder)
    {
      return true;
    }
    
    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder paramViewHolder, @NonNull List<Object> paramList)
    {
      return canReuseUpdatedViewHolder(paramViewHolder);
    }
    
    public final void dispatchAnimationFinished(@NonNull RecyclerView.ViewHolder paramViewHolder)
    {
      onAnimationFinished(paramViewHolder);
      if (this.mListener != null) {
        this.mListener.onAnimationFinished(paramViewHolder);
      }
    }
    
    public final void dispatchAnimationStarted(@NonNull RecyclerView.ViewHolder paramViewHolder)
    {
      onAnimationStarted(paramViewHolder);
    }
    
    public final void dispatchAnimationsFinished()
    {
      int j = this.mFinishedListeners.size();
      int i = 0;
      while (i < j)
      {
        ((ItemAnimatorFinishedListener)this.mFinishedListeners.get(i)).onAnimationsFinished();
        i += 1;
      }
      this.mFinishedListeners.clear();
    }
    
    public abstract void endAnimation(@NonNull RecyclerView.ViewHolder paramViewHolder);
    
    public abstract void endAnimations();
    
    public long getAddDuration()
    {
      return this.mAddDuration;
    }
    
    public long getChangeDuration()
    {
      return this.mChangeDuration;
    }
    
    public long getMoveDuration()
    {
      return this.mMoveDuration;
    }
    
    public long getRemoveDuration()
    {
      return this.mRemoveDuration;
    }
    
    public abstract boolean isRunning();
    
    public final boolean isRunning(@Nullable ItemAnimatorFinishedListener paramItemAnimatorFinishedListener)
    {
      boolean bool = isRunning();
      if (paramItemAnimatorFinishedListener != null)
      {
        if (!bool)
        {
          paramItemAnimatorFinishedListener.onAnimationsFinished();
          return bool;
        }
        this.mFinishedListeners.add(paramItemAnimatorFinishedListener);
      }
      return bool;
    }
    
    @NonNull
    public ItemHolderInfo obtainHolderInfo()
    {
      return new ItemHolderInfo();
    }
    
    public void onAnimationFinished(@NonNull RecyclerView.ViewHolder paramViewHolder) {}
    
    public void onAnimationStarted(@NonNull RecyclerView.ViewHolder paramViewHolder) {}
    
    @NonNull
    public ItemHolderInfo recordPostLayoutInformation(@NonNull RecyclerView.State paramState, @NonNull RecyclerView.ViewHolder paramViewHolder)
    {
      return obtainHolderInfo().setFrom(paramViewHolder);
    }
    
    @NonNull
    public ItemHolderInfo recordPreLayoutInformation(@NonNull RecyclerView.State paramState, @NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt, @NonNull List<Object> paramList)
    {
      return obtainHolderInfo().setFrom(paramViewHolder);
    }
    
    public abstract void runPendingAnimations();
    
    public void setAddDuration(long paramLong)
    {
      this.mAddDuration = paramLong;
    }
    
    public void setChangeDuration(long paramLong)
    {
      this.mChangeDuration = paramLong;
    }
    
    void setListener(ItemAnimatorListener paramItemAnimatorListener)
    {
      this.mListener = paramItemAnimatorListener;
    }
    
    public void setMoveDuration(long paramLong)
    {
      this.mMoveDuration = paramLong;
    }
    
    public void setRemoveDuration(long paramLong)
    {
      this.mRemoveDuration = paramLong;
    }
    
    @Retention(RetentionPolicy.SOURCE)
    public static @interface AdapterChanges {}
    
    public static abstract interface ItemAnimatorFinishedListener
    {
      public abstract void onAnimationsFinished();
    }
    
    static abstract interface ItemAnimatorListener
    {
      public abstract void onAnimationFinished(@NonNull RecyclerView.ViewHolder paramViewHolder);
    }
    
    public static class ItemHolderInfo
    {
      public int bottom;
      public int changeFlags;
      public int left;
      public int right;
      public int top;
      
      @NonNull
      public ItemHolderInfo setFrom(@NonNull RecyclerView.ViewHolder paramViewHolder)
      {
        return setFrom(paramViewHolder, 0);
      }
      
      @NonNull
      public ItemHolderInfo setFrom(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt)
      {
        paramViewHolder = paramViewHolder.itemView;
        this.left = paramViewHolder.getLeft();
        this.top = paramViewHolder.getTop();
        this.right = paramViewHolder.getRight();
        this.bottom = paramViewHolder.getBottom();
        return this;
      }
    }
  }
  
  private class ItemAnimatorRestoreListener
    implements RecyclerView.ItemAnimator.ItemAnimatorListener
  {
    ItemAnimatorRestoreListener() {}
    
    public void onAnimationFinished(RecyclerView.ViewHolder paramViewHolder)
    {
      paramViewHolder.setIsRecyclable(true);
      if ((paramViewHolder.mShadowedHolder != null) && (paramViewHolder.mShadowingHolder == null)) {
        paramViewHolder.mShadowedHolder = null;
      }
      paramViewHolder.mShadowingHolder = null;
      if ((!paramViewHolder.shouldBeKeptAsChild()) && (!RecyclerView.this.removeAnimatingView(paramViewHolder.itemView)) && (paramViewHolder.isTmpDetached())) {
        RecyclerView.this.removeDetachedView(paramViewHolder.itemView, false);
      }
    }
  }
  
  public static abstract class ItemDecoration
  {
    @Deprecated
    public void getItemOffsets(@NonNull Rect paramRect, int paramInt, @NonNull RecyclerView paramRecyclerView)
    {
      paramRect.set(0, 0, 0, 0);
    }
    
    public void getItemOffsets(@NonNull Rect paramRect, @NonNull View paramView, @NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.State paramState)
    {
      getItemOffsets(paramRect, ((RecyclerView.LayoutParams)paramView.getLayoutParams()).getViewLayoutPosition(), paramRecyclerView);
    }
    
    @Deprecated
    public void onDraw(@NonNull Canvas paramCanvas, @NonNull RecyclerView paramRecyclerView) {}
    
    public void onDraw(@NonNull Canvas paramCanvas, @NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.State paramState)
    {
      onDraw(paramCanvas, paramRecyclerView);
    }
    
    @Deprecated
    public void onDrawOver(@NonNull Canvas paramCanvas, @NonNull RecyclerView paramRecyclerView) {}
    
    public void onDrawOver(@NonNull Canvas paramCanvas, @NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.State paramState)
    {
      onDrawOver(paramCanvas, paramRecyclerView);
    }
  }
  
  public static abstract class LayoutManager
  {
    boolean mAutoMeasure = false;
    ChildHelper mChildHelper;
    private int mHeight;
    private int mHeightMode;
    ViewBoundsCheck mHorizontalBoundCheck = new ViewBoundsCheck(this.mHorizontalBoundCheckCallback);
    private final ViewBoundsCheck.Callback mHorizontalBoundCheckCallback = new ViewBoundsCheck.Callback()
    {
      public View getChildAt(int paramAnonymousInt)
      {
        return RecyclerView.LayoutManager.this.getChildAt(paramAnonymousInt);
      }
      
      public int getChildCount()
      {
        return RecyclerView.LayoutManager.this.getChildCount();
      }
      
      public int getChildEnd(View paramAnonymousView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        return RecyclerView.LayoutManager.this.getDecoratedRight(paramAnonymousView) + localLayoutParams.rightMargin;
      }
      
      public int getChildStart(View paramAnonymousView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        return RecyclerView.LayoutManager.this.getDecoratedLeft(paramAnonymousView) - localLayoutParams.leftMargin;
      }
      
      public View getParent()
      {
        return RecyclerView.LayoutManager.this.mRecyclerView;
      }
      
      public int getParentEnd()
      {
        return RecyclerView.LayoutManager.this.getWidth() - RecyclerView.LayoutManager.this.getPaddingRight();
      }
      
      public int getParentStart()
      {
        return RecyclerView.LayoutManager.this.getPaddingLeft();
      }
    };
    boolean mIsAttachedToWindow = false;
    private boolean mItemPrefetchEnabled = true;
    private boolean mMeasurementCacheEnabled = true;
    int mPrefetchMaxCountObserved;
    boolean mPrefetchMaxObservedInInitialPrefetch;
    RecyclerView mRecyclerView;
    boolean mRequestedSimpleAnimations = false;
    @Nullable
    RecyclerView.SmoothScroller mSmoothScroller;
    ViewBoundsCheck mVerticalBoundCheck = new ViewBoundsCheck(this.mVerticalBoundCheckCallback);
    private final ViewBoundsCheck.Callback mVerticalBoundCheckCallback = new ViewBoundsCheck.Callback()
    {
      public View getChildAt(int paramAnonymousInt)
      {
        return RecyclerView.LayoutManager.this.getChildAt(paramAnonymousInt);
      }
      
      public int getChildCount()
      {
        return RecyclerView.LayoutManager.this.getChildCount();
      }
      
      public int getChildEnd(View paramAnonymousView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        return RecyclerView.LayoutManager.this.getDecoratedBottom(paramAnonymousView) + localLayoutParams.bottomMargin;
      }
      
      public int getChildStart(View paramAnonymousView)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramAnonymousView.getLayoutParams();
        return RecyclerView.LayoutManager.this.getDecoratedTop(paramAnonymousView) - localLayoutParams.topMargin;
      }
      
      public View getParent()
      {
        return RecyclerView.LayoutManager.this.mRecyclerView;
      }
      
      public int getParentEnd()
      {
        return RecyclerView.LayoutManager.this.getHeight() - RecyclerView.LayoutManager.this.getPaddingBottom();
      }
      
      public int getParentStart()
      {
        return RecyclerView.LayoutManager.this.getPaddingTop();
      }
    };
    private int mWidth;
    private int mWidthMode;
    
    private void addViewInt(View paramView, int paramInt, boolean paramBoolean)
    {
      Object localObject = RecyclerView.getChildViewHolderInt(paramView);
      if ((!paramBoolean) && (!((RecyclerView.ViewHolder)localObject).isRemoved())) {
        this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout((RecyclerView.ViewHolder)localObject);
      } else {
        this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout((RecyclerView.ViewHolder)localObject);
      }
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      if ((!((RecyclerView.ViewHolder)localObject).wasReturnedFromScrap()) && (!((RecyclerView.ViewHolder)localObject).isScrap()))
      {
        if (paramView.getParent() == this.mRecyclerView)
        {
          int j = this.mChildHelper.indexOfChild(paramView);
          int i = paramInt;
          if (paramInt == -1) {
            i = this.mChildHelper.getChildCount();
          }
          if (j != -1)
          {
            if (j != i) {
              this.mRecyclerView.mLayout.moveView(j, i);
            }
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
            ((StringBuilder)localObject).append(this.mRecyclerView.indexOfChild(paramView));
            ((StringBuilder)localObject).append(this.mRecyclerView.exceptionLabel());
            throw new IllegalStateException(((StringBuilder)localObject).toString());
          }
        }
        else
        {
          this.mChildHelper.addView(paramView, paramInt, false);
          localLayoutParams.mInsetsDirty = true;
          if ((this.mSmoothScroller != null) && (this.mSmoothScroller.isRunning())) {
            this.mSmoothScroller.onChildAttachedToWindow(paramView);
          }
        }
      }
      else
      {
        if (((RecyclerView.ViewHolder)localObject).isScrap()) {
          ((RecyclerView.ViewHolder)localObject).unScrap();
        } else {
          ((RecyclerView.ViewHolder)localObject).clearReturnedFromScrapFlag();
        }
        this.mChildHelper.attachViewToParent(paramView, paramInt, paramView.getLayoutParams(), false);
      }
      if (localLayoutParams.mPendingInvalidate)
      {
        ((RecyclerView.ViewHolder)localObject).itemView.invalidate();
        localLayoutParams.mPendingInvalidate = false;
      }
    }
    
    public static int chooseSize(int paramInt1, int paramInt2, int paramInt3)
    {
      int i = View.MeasureSpec.getMode(paramInt1);
      paramInt1 = View.MeasureSpec.getSize(paramInt1);
      if (i != Integer.MIN_VALUE)
      {
        if (i != 1073741824) {
          return Math.max(paramInt2, paramInt3);
        }
        return paramInt1;
      }
      return Math.min(paramInt1, Math.max(paramInt2, paramInt3));
    }
    
    private void detachViewInternal(int paramInt, @NonNull View paramView)
    {
      this.mChildHelper.detachViewFromParent(paramInt);
    }
    
    public static int getChildMeasureSpec(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
    {
      int j = 0;
      int i = Math.max(0, paramInt1 - paramInt3);
      if (paramBoolean) {
        if (paramInt4 < 0) {}
      }
      while (paramInt4 >= 0)
      {
        paramInt3 = paramInt4;
        paramInt1 = 1073741824;
        break label125;
        if (paramInt4 != -1) {
          break;
        }
        if ((paramInt2 != Integer.MIN_VALUE) && ((paramInt2 == 0) || (paramInt2 != 1073741824)))
        {
          paramInt2 = 0;
          paramInt1 = 0;
        }
        else
        {
          paramInt1 = i;
        }
        paramInt3 = paramInt1;
        paramInt1 = paramInt2;
        break label125;
      }
      if (paramInt4 == -1)
      {
        paramInt1 = paramInt2;
        paramInt3 = i;
      }
      else if (paramInt4 == -2)
      {
        if (paramInt2 != Integer.MIN_VALUE)
        {
          paramInt3 = i;
          paramInt1 = j;
          if (paramInt2 != 1073741824) {}
        }
        else
        {
          paramInt1 = Integer.MIN_VALUE;
          paramInt3 = i;
        }
      }
      else
      {
        paramInt3 = 0;
        paramInt1 = j;
      }
      label125:
      return View.MeasureSpec.makeMeasureSpec(paramInt3, paramInt1);
    }
    
    @Deprecated
    public static int getChildMeasureSpec(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    {
      int i = 0;
      paramInt1 = Math.max(0, paramInt1 - paramInt2);
      if (paramBoolean) {
        if (paramInt3 >= 0)
        {
          paramInt1 = paramInt3;
          label21:
          paramInt2 = 1073741824;
          break label59;
        }
      }
      do
      {
        paramInt1 = 0;
        paramInt2 = i;
        break label59;
        if (paramInt3 >= 0) {
          break;
        }
        if (paramInt3 == -1) {
          break label21;
        }
      } while (paramInt3 != -2);
      paramInt2 = Integer.MIN_VALUE;
      label59:
      return View.MeasureSpec.makeMeasureSpec(paramInt1, paramInt2);
    }
    
    private int[] getChildRectangleOnScreenScrollAmount(RecyclerView paramRecyclerView, View paramView, Rect paramRect, boolean paramBoolean)
    {
      int i = getPaddingLeft();
      int j = getPaddingTop();
      int k = getWidth();
      int i5 = getPaddingRight();
      int n = getHeight();
      int i1 = getPaddingBottom();
      int i6 = paramView.getLeft() + paramRect.left - paramView.getScrollX();
      int i2 = paramView.getTop() + paramRect.top - paramView.getScrollY();
      int i7 = paramRect.width();
      int i3 = paramRect.height();
      int i4 = i6 - i;
      i = Math.min(0, i4);
      int m = i2 - j;
      j = Math.min(0, m);
      i5 = i7 + i6 - (k - i5);
      k = Math.max(0, i5);
      n = Math.max(0, i3 + i2 - (n - i1));
      if (getLayoutDirection() == 1)
      {
        if (k != 0) {
          i = k;
        } else {
          i = Math.max(i, i5);
        }
      }
      else if (i == 0) {
        for (;;)
        {
          i = Math.min(i4, k);
        }
      }
      if (j == 0) {
        j = Math.min(m, n);
      }
      return new int[] { i, j };
    }
    
    public static Properties getProperties(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
    {
      Properties localProperties = new Properties();
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RecyclerView, paramInt1, paramInt2);
      localProperties.orientation = paramContext.getInt(R.styleable.RecyclerView_android_orientation, 1);
      localProperties.spanCount = paramContext.getInt(R.styleable.RecyclerView_spanCount, 1);
      localProperties.reverseLayout = paramContext.getBoolean(R.styleable.RecyclerView_reverseLayout, false);
      localProperties.stackFromEnd = paramContext.getBoolean(R.styleable.RecyclerView_stackFromEnd, false);
      paramContext.recycle();
      return localProperties;
    }
    
    private boolean isFocusedChildVisibleAfterScrolling(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      paramRecyclerView = paramRecyclerView.getFocusedChild();
      if (paramRecyclerView == null) {
        return false;
      }
      int i = getPaddingLeft();
      int j = getPaddingTop();
      int k = getWidth();
      int m = getPaddingRight();
      int n = getHeight();
      int i1 = getPaddingBottom();
      Rect localRect = this.mRecyclerView.mTempRect;
      getDecoratedBoundsWithMargins(paramRecyclerView, localRect);
      if ((localRect.left - paramInt1 < k - m) && (localRect.right - paramInt1 > i) && (localRect.top - paramInt2 < n - i1)) {
        return localRect.bottom - paramInt2 > j;
      }
      return false;
    }
    
    private static boolean isMeasurementUpToDate(int paramInt1, int paramInt2, int paramInt3)
    {
      int i = View.MeasureSpec.getMode(paramInt2);
      paramInt2 = View.MeasureSpec.getSize(paramInt2);
      boolean bool2 = false;
      boolean bool1 = false;
      if ((paramInt3 > 0) && (paramInt1 != paramInt3)) {
        return false;
      }
      if (i != Integer.MIN_VALUE)
      {
        if (i != 0)
        {
          if (i != 1073741824) {
            return false;
          }
          if (paramInt2 == paramInt1) {
            bool1 = true;
          }
          return bool1;
        }
        return true;
      }
      bool1 = bool2;
      if (paramInt2 >= paramInt1) {
        bool1 = true;
      }
      return bool1;
    }
    
    private void scrapOrRecycleView(RecyclerView.Recycler paramRecycler, int paramInt, View paramView)
    {
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
      if (localViewHolder.shouldIgnore()) {
        return;
      }
      if ((localViewHolder.isInvalid()) && (!localViewHolder.isRemoved()) && (!this.mRecyclerView.mAdapter.hasStableIds()))
      {
        removeViewAt(paramInt);
        paramRecycler.recycleViewHolderInternal(localViewHolder);
        return;
      }
      detachViewAt(paramInt);
      paramRecycler.scrapView(paramView);
      this.mRecyclerView.mViewInfoStore.onViewDetached(localViewHolder);
    }
    
    public void addDisappearingView(View paramView)
    {
      addDisappearingView(paramView, -1);
    }
    
    public void addDisappearingView(View paramView, int paramInt)
    {
      addViewInt(paramView, paramInt, true);
    }
    
    public void addView(View paramView)
    {
      addView(paramView, -1);
    }
    
    public void addView(View paramView, int paramInt)
    {
      addViewInt(paramView, paramInt, false);
    }
    
    public void assertInLayoutOrScroll(String paramString)
    {
      if (this.mRecyclerView != null) {
        this.mRecyclerView.assertInLayoutOrScroll(paramString);
      }
    }
    
    public void assertNotInLayoutOrScroll(String paramString)
    {
      if (this.mRecyclerView != null) {
        this.mRecyclerView.assertNotInLayoutOrScroll(paramString);
      }
    }
    
    public void attachView(@NonNull View paramView)
    {
      attachView(paramView, -1);
    }
    
    public void attachView(@NonNull View paramView, int paramInt)
    {
      attachView(paramView, paramInt, (RecyclerView.LayoutParams)paramView.getLayoutParams());
    }
    
    public void attachView(@NonNull View paramView, int paramInt, RecyclerView.LayoutParams paramLayoutParams)
    {
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
      if (localViewHolder.isRemoved()) {
        this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(localViewHolder);
      } else {
        this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(localViewHolder);
      }
      this.mChildHelper.attachViewToParent(paramView, paramInt, paramLayoutParams, localViewHolder.isRemoved());
    }
    
    public void calculateItemDecorationsForChild(@NonNull View paramView, @NonNull Rect paramRect)
    {
      if (this.mRecyclerView == null)
      {
        paramRect.set(0, 0, 0, 0);
        return;
      }
      paramRect.set(this.mRecyclerView.getItemDecorInsetsForChild(paramView));
    }
    
    public boolean canScrollHorizontally()
    {
      return false;
    }
    
    public boolean canScrollVertically()
    {
      return false;
    }
    
    public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
    {
      return paramLayoutParams != null;
    }
    
    public void collectAdjacentPrefetchPositions(int paramInt1, int paramInt2, RecyclerView.State paramState, LayoutPrefetchRegistry paramLayoutPrefetchRegistry) {}
    
    public void collectInitialPrefetchPositions(int paramInt, LayoutPrefetchRegistry paramLayoutPrefetchRegistry) {}
    
    public int computeHorizontalScrollExtent(@NonNull RecyclerView.State paramState)
    {
      return 0;
    }
    
    public int computeHorizontalScrollOffset(@NonNull RecyclerView.State paramState)
    {
      return 0;
    }
    
    public int computeHorizontalScrollRange(@NonNull RecyclerView.State paramState)
    {
      return 0;
    }
    
    public int computeVerticalScrollExtent(@NonNull RecyclerView.State paramState)
    {
      return 0;
    }
    
    public int computeVerticalScrollOffset(@NonNull RecyclerView.State paramState)
    {
      return 0;
    }
    
    public int computeVerticalScrollRange(@NonNull RecyclerView.State paramState)
    {
      return 0;
    }
    
    public void detachAndScrapAttachedViews(@NonNull RecyclerView.Recycler paramRecycler)
    {
      int i = getChildCount() - 1;
      while (i >= 0)
      {
        scrapOrRecycleView(paramRecycler, i, getChildAt(i));
        i -= 1;
      }
    }
    
    public void detachAndScrapView(@NonNull View paramView, @NonNull RecyclerView.Recycler paramRecycler)
    {
      scrapOrRecycleView(paramRecycler, this.mChildHelper.indexOfChild(paramView), paramView);
    }
    
    public void detachAndScrapViewAt(int paramInt, @NonNull RecyclerView.Recycler paramRecycler)
    {
      scrapOrRecycleView(paramRecycler, paramInt, getChildAt(paramInt));
    }
    
    public void detachView(@NonNull View paramView)
    {
      int i = this.mChildHelper.indexOfChild(paramView);
      if (i >= 0) {
        detachViewInternal(i, paramView);
      }
    }
    
    public void detachViewAt(int paramInt)
    {
      detachViewInternal(paramInt, getChildAt(paramInt));
    }
    
    void dispatchAttachedToWindow(RecyclerView paramRecyclerView)
    {
      this.mIsAttachedToWindow = true;
      onAttachedToWindow(paramRecyclerView);
    }
    
    void dispatchDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.Recycler paramRecycler)
    {
      this.mIsAttachedToWindow = false;
      onDetachedFromWindow(paramRecyclerView, paramRecycler);
    }
    
    public void endAnimation(View paramView)
    {
      if (this.mRecyclerView.mItemAnimator != null) {
        this.mRecyclerView.mItemAnimator.endAnimation(RecyclerView.getChildViewHolderInt(paramView));
      }
    }
    
    @Nullable
    public View findContainingItemView(@NonNull View paramView)
    {
      if (this.mRecyclerView == null) {
        return null;
      }
      paramView = this.mRecyclerView.findContainingItemView(paramView);
      if (paramView == null) {
        return null;
      }
      if (this.mChildHelper.isHidden(paramView)) {
        return null;
      }
      return paramView;
    }
    
    @Nullable
    public View findViewByPosition(int paramInt)
    {
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = getChildAt(i);
        RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(localView);
        if ((localViewHolder != null) && (localViewHolder.getLayoutPosition() == paramInt) && (!localViewHolder.shouldIgnore()) && ((this.mRecyclerView.mState.isPreLayout()) || (!localViewHolder.isRemoved()))) {
          return localView;
        }
        i += 1;
      }
      return null;
    }
    
    public abstract RecyclerView.LayoutParams generateDefaultLayoutParams();
    
    public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      return new RecyclerView.LayoutParams(paramContext, paramAttributeSet);
    }
    
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      if ((paramLayoutParams instanceof RecyclerView.LayoutParams)) {
        return new RecyclerView.LayoutParams((RecyclerView.LayoutParams)paramLayoutParams);
      }
      if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
        return new RecyclerView.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
      }
      return new RecyclerView.LayoutParams(paramLayoutParams);
    }
    
    public int getBaseline()
    {
      return -1;
    }
    
    public int getBottomDecorationHeight(@NonNull View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets.bottom;
    }
    
    @Nullable
    public View getChildAt(int paramInt)
    {
      if (this.mChildHelper != null) {
        return this.mChildHelper.getChildAt(paramInt);
      }
      return null;
    }
    
    public int getChildCount()
    {
      if (this.mChildHelper != null) {
        return this.mChildHelper.getChildCount();
      }
      return 0;
    }
    
    public boolean getClipToPadding()
    {
      return (this.mRecyclerView != null) && (this.mRecyclerView.mClipToPadding);
    }
    
    public int getColumnCountForAccessibility(@NonNull RecyclerView.Recycler paramRecycler, @NonNull RecyclerView.State paramState)
    {
      paramRecycler = this.mRecyclerView;
      int i = 1;
      if (paramRecycler != null)
      {
        if (this.mRecyclerView.mAdapter == null) {
          return 1;
        }
        if (canScrollHorizontally()) {
          i = this.mRecyclerView.mAdapter.getItemCount();
        }
        return i;
      }
      return 1;
    }
    
    public int getDecoratedBottom(@NonNull View paramView)
    {
      return paramView.getBottom() + getBottomDecorationHeight(paramView);
    }
    
    public void getDecoratedBoundsWithMargins(@NonNull View paramView, @NonNull Rect paramRect)
    {
      RecyclerView.getDecoratedBoundsWithMarginsInt(paramView, paramRect);
    }
    
    public int getDecoratedLeft(@NonNull View paramView)
    {
      return paramView.getLeft() - getLeftDecorationWidth(paramView);
    }
    
    public int getDecoratedMeasuredHeight(@NonNull View paramView)
    {
      Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets;
      return paramView.getMeasuredHeight() + localRect.top + localRect.bottom;
    }
    
    public int getDecoratedMeasuredWidth(@NonNull View paramView)
    {
      Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets;
      return paramView.getMeasuredWidth() + localRect.left + localRect.right;
    }
    
    public int getDecoratedRight(@NonNull View paramView)
    {
      return paramView.getRight() + getRightDecorationWidth(paramView);
    }
    
    public int getDecoratedTop(@NonNull View paramView)
    {
      return paramView.getTop() - getTopDecorationHeight(paramView);
    }
    
    @Nullable
    public View getFocusedChild()
    {
      if (this.mRecyclerView == null) {
        return null;
      }
      View localView = this.mRecyclerView.getFocusedChild();
      if (localView != null)
      {
        if (this.mChildHelper.isHidden(localView)) {
          return null;
        }
        return localView;
      }
      return null;
    }
    
    @Px
    public int getHeight()
    {
      return this.mHeight;
    }
    
    public int getHeightMode()
    {
      return this.mHeightMode;
    }
    
    public int getItemCount()
    {
      RecyclerView.Adapter localAdapter;
      if (this.mRecyclerView != null) {
        localAdapter = this.mRecyclerView.getAdapter();
      } else {
        localAdapter = null;
      }
      if (localAdapter != null) {
        return localAdapter.getItemCount();
      }
      return 0;
    }
    
    public int getItemViewType(@NonNull View paramView)
    {
      return RecyclerView.getChildViewHolderInt(paramView).getItemViewType();
    }
    
    public int getLayoutDirection()
    {
      return ViewCompat.getLayoutDirection(this.mRecyclerView);
    }
    
    public int getLeftDecorationWidth(@NonNull View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets.left;
    }
    
    @Px
    public int getMinimumHeight()
    {
      return ViewCompat.getMinimumHeight(this.mRecyclerView);
    }
    
    @Px
    public int getMinimumWidth()
    {
      return ViewCompat.getMinimumWidth(this.mRecyclerView);
    }
    
    @Px
    public int getPaddingBottom()
    {
      if (this.mRecyclerView != null) {
        return this.mRecyclerView.getPaddingBottom();
      }
      return 0;
    }
    
    @Px
    public int getPaddingEnd()
    {
      if (this.mRecyclerView != null) {
        return ViewCompat.getPaddingEnd(this.mRecyclerView);
      }
      return 0;
    }
    
    @Px
    public int getPaddingLeft()
    {
      if (this.mRecyclerView != null) {
        return this.mRecyclerView.getPaddingLeft();
      }
      return 0;
    }
    
    @Px
    public int getPaddingRight()
    {
      if (this.mRecyclerView != null) {
        return this.mRecyclerView.getPaddingRight();
      }
      return 0;
    }
    
    @Px
    public int getPaddingStart()
    {
      if (this.mRecyclerView != null) {
        return ViewCompat.getPaddingStart(this.mRecyclerView);
      }
      return 0;
    }
    
    @Px
    public int getPaddingTop()
    {
      if (this.mRecyclerView != null) {
        return this.mRecyclerView.getPaddingTop();
      }
      return 0;
    }
    
    public int getPosition(@NonNull View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).getViewLayoutPosition();
    }
    
    public int getRightDecorationWidth(@NonNull View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets.right;
    }
    
    public int getRowCountForAccessibility(@NonNull RecyclerView.Recycler paramRecycler, @NonNull RecyclerView.State paramState)
    {
      paramRecycler = this.mRecyclerView;
      int i = 1;
      if (paramRecycler != null)
      {
        if (this.mRecyclerView.mAdapter == null) {
          return 1;
        }
        if (canScrollVertically()) {
          i = this.mRecyclerView.mAdapter.getItemCount();
        }
        return i;
      }
      return 1;
    }
    
    public int getSelectionModeForAccessibility(@NonNull RecyclerView.Recycler paramRecycler, @NonNull RecyclerView.State paramState)
    {
      return 0;
    }
    
    public int getTopDecorationHeight(@NonNull View paramView)
    {
      return ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets.top;
    }
    
    public void getTransformedBoundingBox(@NonNull View paramView, boolean paramBoolean, @NonNull Rect paramRect)
    {
      Object localObject;
      if (paramBoolean)
      {
        localObject = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets;
        paramRect.set(-((Rect)localObject).left, -((Rect)localObject).top, paramView.getWidth() + ((Rect)localObject).right, paramView.getHeight() + ((Rect)localObject).bottom);
      }
      else
      {
        paramRect.set(0, 0, paramView.getWidth(), paramView.getHeight());
      }
      if (this.mRecyclerView != null)
      {
        localObject = paramView.getMatrix();
        if ((localObject != null) && (!((Matrix)localObject).isIdentity()))
        {
          RectF localRectF = this.mRecyclerView.mTempRectF;
          localRectF.set(paramRect);
          ((Matrix)localObject).mapRect(localRectF);
          paramRect.set((int)Math.floor(localRectF.left), (int)Math.floor(localRectF.top), (int)Math.ceil(localRectF.right), (int)Math.ceil(localRectF.bottom));
        }
      }
      paramRect.offset(paramView.getLeft(), paramView.getTop());
    }
    
    @Px
    public int getWidth()
    {
      return this.mWidth;
    }
    
    public int getWidthMode()
    {
      return this.mWidthMode;
    }
    
    boolean hasFlexibleChildInBothOrientations()
    {
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        ViewGroup.LayoutParams localLayoutParams = getChildAt(i).getLayoutParams();
        if ((localLayoutParams.width < 0) && (localLayoutParams.height < 0)) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    
    public boolean hasFocus()
    {
      return (this.mRecyclerView != null) && (this.mRecyclerView.hasFocus());
    }
    
    public void ignoreView(@NonNull View paramView)
    {
      if ((paramView.getParent() == this.mRecyclerView) && (this.mRecyclerView.indexOfChild(paramView) != -1))
      {
        paramView = RecyclerView.getChildViewHolderInt(paramView);
        paramView.addFlags(128);
        this.mRecyclerView.mViewInfoStore.removeViewHolder(paramView);
        return;
      }
      paramView = new StringBuilder();
      paramView.append("View should be fully attached to be ignored");
      paramView.append(this.mRecyclerView.exceptionLabel());
      throw new IllegalArgumentException(paramView.toString());
    }
    
    public boolean isAttachedToWindow()
    {
      return this.mIsAttachedToWindow;
    }
    
    public boolean isAutoMeasureEnabled()
    {
      return this.mAutoMeasure;
    }
    
    public boolean isFocused()
    {
      return (this.mRecyclerView != null) && (this.mRecyclerView.isFocused());
    }
    
    public final boolean isItemPrefetchEnabled()
    {
      return this.mItemPrefetchEnabled;
    }
    
    public boolean isLayoutHierarchical(@NonNull RecyclerView.Recycler paramRecycler, @NonNull RecyclerView.State paramState)
    {
      return false;
    }
    
    public boolean isMeasurementCacheEnabled()
    {
      return this.mMeasurementCacheEnabled;
    }
    
    public boolean isSmoothScrolling()
    {
      return (this.mSmoothScroller != null) && (this.mSmoothScroller.isRunning());
    }
    
    public boolean isViewPartiallyVisible(@NonNull View paramView, boolean paramBoolean1, boolean paramBoolean2)
    {
      if ((this.mHorizontalBoundCheck.isViewWithinBoundFlags(paramView, 24579)) && (this.mVerticalBoundCheck.isViewWithinBoundFlags(paramView, 24579))) {
        paramBoolean2 = true;
      } else {
        paramBoolean2 = false;
      }
      if (paramBoolean1) {
        return paramBoolean2;
      }
      return paramBoolean2 ^ true;
    }
    
    public void layoutDecorated(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      Rect localRect = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).mDecorInsets;
      paramView.layout(paramInt1 + localRect.left, paramInt2 + localRect.top, paramInt3 - localRect.right, paramInt4 - localRect.bottom);
    }
    
    public void layoutDecoratedWithMargins(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      Rect localRect = localLayoutParams.mDecorInsets;
      paramView.layout(paramInt1 + localRect.left + localLayoutParams.leftMargin, paramInt2 + localRect.top + localLayoutParams.topMargin, paramInt3 - localRect.right - localLayoutParams.rightMargin, paramInt4 - localRect.bottom - localLayoutParams.bottomMargin);
    }
    
    public void measureChild(@NonNull View paramView, int paramInt1, int paramInt2)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      Rect localRect = this.mRecyclerView.getItemDecorInsetsForChild(paramView);
      int k = localRect.left;
      int m = localRect.right;
      int i = localRect.top;
      int j = localRect.bottom;
      paramInt1 = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + (paramInt1 + (k + m)), localLayoutParams.width, canScrollHorizontally());
      paramInt2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + (paramInt2 + (i + j)), localLayoutParams.height, canScrollVertically());
      if (shouldMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams)) {
        paramView.measure(paramInt1, paramInt2);
      }
    }
    
    public void measureChildWithMargins(@NonNull View paramView, int paramInt1, int paramInt2)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      Rect localRect = this.mRecyclerView.getItemDecorInsetsForChild(paramView);
      int k = localRect.left;
      int m = localRect.right;
      int i = localRect.top;
      int j = localRect.bottom;
      paramInt1 = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + localLayoutParams.leftMargin + localLayoutParams.rightMargin + (paramInt1 + (k + m)), localLayoutParams.width, canScrollHorizontally());
      paramInt2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + localLayoutParams.topMargin + localLayoutParams.bottomMargin + (paramInt2 + (i + j)), localLayoutParams.height, canScrollVertically());
      if (shouldMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams)) {
        paramView.measure(paramInt1, paramInt2);
      }
    }
    
    public void moveView(int paramInt1, int paramInt2)
    {
      Object localObject = getChildAt(paramInt1);
      if (localObject != null)
      {
        detachViewAt(paramInt1);
        attachView((View)localObject, paramInt2);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Cannot move a child from non-existing index:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(this.mRecyclerView.toString());
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    
    public void offsetChildrenHorizontal(@Px int paramInt)
    {
      if (this.mRecyclerView != null) {
        this.mRecyclerView.offsetChildrenHorizontal(paramInt);
      }
    }
    
    public void offsetChildrenVertical(@Px int paramInt)
    {
      if (this.mRecyclerView != null) {
        this.mRecyclerView.offsetChildrenVertical(paramInt);
      }
    }
    
    public void onAdapterChanged(@Nullable RecyclerView.Adapter paramAdapter1, @Nullable RecyclerView.Adapter paramAdapter2) {}
    
    public boolean onAddFocusables(@NonNull RecyclerView paramRecyclerView, @NonNull ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
    {
      return false;
    }
    
    @CallSuper
    public void onAttachedToWindow(RecyclerView paramRecyclerView) {}
    
    @Deprecated
    public void onDetachedFromWindow(RecyclerView paramRecyclerView) {}
    
    @CallSuper
    public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.Recycler paramRecycler)
    {
      onDetachedFromWindow(paramRecyclerView);
    }
    
    @Nullable
    public View onFocusSearchFailed(@NonNull View paramView, int paramInt, @NonNull RecyclerView.Recycler paramRecycler, @NonNull RecyclerView.State paramState)
    {
      return null;
    }
    
    public void onInitializeAccessibilityEvent(@NonNull RecyclerView.Recycler paramRecycler, @NonNull RecyclerView.State paramState, @NonNull AccessibilityEvent paramAccessibilityEvent)
    {
      if (this.mRecyclerView != null)
      {
        if (paramAccessibilityEvent == null) {
          return;
        }
        paramRecycler = this.mRecyclerView;
        boolean bool2 = true;
        boolean bool1 = bool2;
        if (!paramRecycler.canScrollVertically(1))
        {
          bool1 = bool2;
          if (!this.mRecyclerView.canScrollVertically(-1))
          {
            bool1 = bool2;
            if (!this.mRecyclerView.canScrollHorizontally(-1)) {
              if (this.mRecyclerView.canScrollHorizontally(1)) {
                bool1 = bool2;
              } else {
                bool1 = false;
              }
            }
          }
        }
        paramAccessibilityEvent.setScrollable(bool1);
        if (this.mRecyclerView.mAdapter != null) {
          paramAccessibilityEvent.setItemCount(this.mRecyclerView.mAdapter.getItemCount());
        }
        return;
      }
    }
    
    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent paramAccessibilityEvent)
    {
      onInitializeAccessibilityEvent(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, paramAccessibilityEvent);
    }
    
    void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      onInitializeAccessibilityNodeInfo(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, paramAccessibilityNodeInfoCompat);
    }
    
    public void onInitializeAccessibilityNodeInfo(@NonNull RecyclerView.Recycler paramRecycler, @NonNull RecyclerView.State paramState, @NonNull AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      if ((this.mRecyclerView.canScrollVertically(-1)) || (this.mRecyclerView.canScrollHorizontally(-1)))
      {
        paramAccessibilityNodeInfoCompat.addAction(8192);
        paramAccessibilityNodeInfoCompat.setScrollable(true);
      }
      if ((this.mRecyclerView.canScrollVertically(1)) || (this.mRecyclerView.canScrollHorizontally(1)))
      {
        paramAccessibilityNodeInfoCompat.addAction(4096);
        paramAccessibilityNodeInfoCompat.setScrollable(true);
      }
      paramAccessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(paramRecycler, paramState), getColumnCountForAccessibility(paramRecycler, paramState), isLayoutHierarchical(paramRecycler, paramState), getSelectionModeForAccessibility(paramRecycler, paramState)));
    }
    
    public void onInitializeAccessibilityNodeInfoForItem(@NonNull RecyclerView.Recycler paramRecycler, @NonNull RecyclerView.State paramState, @NonNull View paramView, @NonNull AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      int i;
      if (canScrollVertically()) {
        i = getPosition(paramView);
      } else {
        i = 0;
      }
      int j;
      if (canScrollHorizontally()) {
        j = getPosition(paramView);
      } else {
        j = 0;
      }
      paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(i, 1, j, 1, false, false));
    }
    
    void onInitializeAccessibilityNodeInfoForItem(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
      if ((localViewHolder != null) && (!localViewHolder.isRemoved()) && (!this.mChildHelper.isHidden(localViewHolder.itemView))) {
        onInitializeAccessibilityNodeInfoForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, paramView, paramAccessibilityNodeInfoCompat);
      }
    }
    
    @Nullable
    public View onInterceptFocusSearch(@NonNull View paramView, int paramInt)
    {
      return null;
    }
    
    public void onItemsAdded(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
    
    public void onItemsChanged(@NonNull RecyclerView paramRecyclerView) {}
    
    public void onItemsMoved(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onItemsRemoved(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
    
    public void onItemsUpdated(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
    
    public void onItemsUpdated(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2, @Nullable Object paramObject)
    {
      onItemsUpdated(paramRecyclerView, paramInt1, paramInt2);
    }
    
    public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
    {
      Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
    }
    
    public void onLayoutCompleted(RecyclerView.State paramState) {}
    
    public void onMeasure(@NonNull RecyclerView.Recycler paramRecycler, @NonNull RecyclerView.State paramState, int paramInt1, int paramInt2)
    {
      this.mRecyclerView.defaultOnMeasure(paramInt1, paramInt2);
    }
    
    public boolean onRequestChildFocus(@NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.State paramState, @NonNull View paramView1, @Nullable View paramView2)
    {
      return onRequestChildFocus(paramRecyclerView, paramView1, paramView2);
    }
    
    @Deprecated
    public boolean onRequestChildFocus(@NonNull RecyclerView paramRecyclerView, @NonNull View paramView1, @Nullable View paramView2)
    {
      return (isSmoothScrolling()) || (paramRecyclerView.isComputingLayout());
    }
    
    public void onRestoreInstanceState(Parcelable paramParcelable) {}
    
    @Nullable
    public Parcelable onSaveInstanceState()
    {
      return null;
    }
    
    public void onScrollStateChanged(int paramInt) {}
    
    void onSmoothScrollerStopped(RecyclerView.SmoothScroller paramSmoothScroller)
    {
      if (this.mSmoothScroller == paramSmoothScroller) {
        this.mSmoothScroller = null;
      }
    }
    
    boolean performAccessibilityAction(int paramInt, @Nullable Bundle paramBundle)
    {
      return performAccessibilityAction(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, paramInt, paramBundle);
    }
    
    public boolean performAccessibilityAction(@NonNull RecyclerView.Recycler paramRecycler, @NonNull RecyclerView.State paramState, int paramInt, @Nullable Bundle paramBundle)
    {
      if (this.mRecyclerView == null) {
        return false;
      }
      if (paramInt != 4096) {
        if (paramInt != 8192) {
          paramInt = 0;
        }
      }
      int i;
      do
      {
        do
        {
          j = 0;
          break;
          if (this.mRecyclerView.canScrollVertically(-1)) {
            i = -(getHeight() - getPaddingTop() - getPaddingBottom());
          } else {
            i = 0;
          }
          paramInt = i;
        } while (!this.mRecyclerView.canScrollHorizontally(-1));
        j = -(getWidth() - getPaddingLeft() - getPaddingRight());
        paramInt = i;
        break;
        if (this.mRecyclerView.canScrollVertically(1)) {
          i = getHeight() - getPaddingTop() - getPaddingBottom();
        } else {
          i = 0;
        }
        paramInt = i;
      } while (!this.mRecyclerView.canScrollHorizontally(1));
      int j = getWidth() - getPaddingLeft() - getPaddingRight();
      paramInt = i;
      if ((paramInt == 0) && (j == 0)) {
        return false;
      }
      this.mRecyclerView.smoothScrollBy(j, paramInt);
      return true;
    }
    
    public boolean performAccessibilityActionForItem(@NonNull RecyclerView.Recycler paramRecycler, @NonNull RecyclerView.State paramState, @NonNull View paramView, int paramInt, @Nullable Bundle paramBundle)
    {
      return false;
    }
    
    boolean performAccessibilityActionForItem(@NonNull View paramView, int paramInt, @Nullable Bundle paramBundle)
    {
      return performAccessibilityActionForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, paramView, paramInt, paramBundle);
    }
    
    public void postOnAnimation(Runnable paramRunnable)
    {
      if (this.mRecyclerView != null) {
        ViewCompat.postOnAnimation(this.mRecyclerView, paramRunnable);
      }
    }
    
    public void removeAllViews()
    {
      int i = getChildCount() - 1;
      while (i >= 0)
      {
        this.mChildHelper.removeViewAt(i);
        i -= 1;
      }
    }
    
    public void removeAndRecycleAllViews(@NonNull RecyclerView.Recycler paramRecycler)
    {
      int i = getChildCount() - 1;
      while (i >= 0)
      {
        if (!RecyclerView.getChildViewHolderInt(getChildAt(i)).shouldIgnore()) {
          removeAndRecycleViewAt(i, paramRecycler);
        }
        i -= 1;
      }
    }
    
    void removeAndRecycleScrapInt(RecyclerView.Recycler paramRecycler)
    {
      int j = paramRecycler.getScrapCount();
      int i = j - 1;
      while (i >= 0)
      {
        View localView = paramRecycler.getScrapViewAt(i);
        RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(localView);
        if (!localViewHolder.shouldIgnore())
        {
          localViewHolder.setIsRecyclable(false);
          if (localViewHolder.isTmpDetached()) {
            this.mRecyclerView.removeDetachedView(localView, false);
          }
          if (this.mRecyclerView.mItemAnimator != null) {
            this.mRecyclerView.mItemAnimator.endAnimation(localViewHolder);
          }
          localViewHolder.setIsRecyclable(true);
          paramRecycler.quickRecycleScrapView(localView);
        }
        i -= 1;
      }
      paramRecycler.clearScrap();
      if (j > 0) {
        this.mRecyclerView.invalidate();
      }
    }
    
    public void removeAndRecycleView(@NonNull View paramView, @NonNull RecyclerView.Recycler paramRecycler)
    {
      removeView(paramView);
      paramRecycler.recycleView(paramView);
    }
    
    public void removeAndRecycleViewAt(int paramInt, @NonNull RecyclerView.Recycler paramRecycler)
    {
      View localView = getChildAt(paramInt);
      removeViewAt(paramInt);
      paramRecycler.recycleView(localView);
    }
    
    public boolean removeCallbacks(Runnable paramRunnable)
    {
      if (this.mRecyclerView != null) {
        return this.mRecyclerView.removeCallbacks(paramRunnable);
      }
      return false;
    }
    
    public void removeDetachedView(@NonNull View paramView)
    {
      this.mRecyclerView.removeDetachedView(paramView, false);
    }
    
    public void removeView(View paramView)
    {
      this.mChildHelper.removeView(paramView);
    }
    
    public void removeViewAt(int paramInt)
    {
      if (getChildAt(paramInt) != null) {
        this.mChildHelper.removeViewAt(paramInt);
      }
    }
    
    public boolean requestChildRectangleOnScreen(@NonNull RecyclerView paramRecyclerView, @NonNull View paramView, @NonNull Rect paramRect, boolean paramBoolean)
    {
      return requestChildRectangleOnScreen(paramRecyclerView, paramView, paramRect, paramBoolean, false);
    }
    
    public boolean requestChildRectangleOnScreen(@NonNull RecyclerView paramRecyclerView, @NonNull View paramView, @NonNull Rect paramRect, boolean paramBoolean1, boolean paramBoolean2)
    {
      paramView = getChildRectangleOnScreenScrollAmount(paramRecyclerView, paramView, paramRect, paramBoolean1);
      int i = paramView[0];
      int j = paramView[1];
      if (((paramBoolean2) && (!isFocusedChildVisibleAfterScrolling(paramRecyclerView, i, j))) || ((i == 0) && (j == 0))) {
        return false;
      }
      if (paramBoolean1)
      {
        paramRecyclerView.scrollBy(i, j);
        return true;
      }
      paramRecyclerView.smoothScrollBy(i, j);
      return true;
    }
    
    public void requestLayout()
    {
      if (this.mRecyclerView != null) {
        this.mRecyclerView.requestLayout();
      }
    }
    
    public void requestSimpleAnimationsInNextLayout()
    {
      this.mRequestedSimpleAnimations = true;
    }
    
    public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
    {
      return 0;
    }
    
    public void scrollToPosition(int paramInt) {}
    
    public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
    {
      return 0;
    }
    
    @Deprecated
    public void setAutoMeasureEnabled(boolean paramBoolean)
    {
      this.mAutoMeasure = paramBoolean;
    }
    
    void setExactMeasureSpecsFrom(RecyclerView paramRecyclerView)
    {
      setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getHeight(), 1073741824));
    }
    
    public final void setItemPrefetchEnabled(boolean paramBoolean)
    {
      if (paramBoolean != this.mItemPrefetchEnabled)
      {
        this.mItemPrefetchEnabled = paramBoolean;
        this.mPrefetchMaxCountObserved = 0;
        if (this.mRecyclerView != null) {
          this.mRecyclerView.mRecycler.updateViewCacheSize();
        }
      }
    }
    
    void setMeasureSpecs(int paramInt1, int paramInt2)
    {
      this.mWidth = View.MeasureSpec.getSize(paramInt1);
      this.mWidthMode = View.MeasureSpec.getMode(paramInt1);
      if ((this.mWidthMode == 0) && (!RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC)) {
        this.mWidth = 0;
      }
      this.mHeight = View.MeasureSpec.getSize(paramInt2);
      this.mHeightMode = View.MeasureSpec.getMode(paramInt2);
      if ((this.mHeightMode == 0) && (!RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC)) {
        this.mHeight = 0;
      }
    }
    
    public void setMeasuredDimension(int paramInt1, int paramInt2)
    {
      this.mRecyclerView.setMeasuredDimension(paramInt1, paramInt2);
    }
    
    public void setMeasuredDimension(Rect paramRect, int paramInt1, int paramInt2)
    {
      int i = paramRect.width();
      int j = getPaddingLeft();
      int k = getPaddingRight();
      int m = paramRect.height();
      int n = getPaddingTop();
      int i1 = getPaddingBottom();
      setMeasuredDimension(chooseSize(paramInt1, i + j + k, getMinimumWidth()), chooseSize(paramInt2, m + n + i1, getMinimumHeight()));
    }
    
    void setMeasuredDimensionFromChildren(int paramInt1, int paramInt2)
    {
      int i4 = getChildCount();
      if (i4 == 0)
      {
        this.mRecyclerView.defaultOnMeasure(paramInt1, paramInt2);
        return;
      }
      int j = 0;
      int i2 = Integer.MAX_VALUE;
      int m = Integer.MAX_VALUE;
      int n = Integer.MIN_VALUE;
      int i3;
      for (int i = Integer.MIN_VALUE; j < i4; i = i3)
      {
        View localView = getChildAt(j);
        Rect localRect = this.mRecyclerView.mTempRect;
        getDecoratedBoundsWithMargins(localView, localRect);
        int k = i2;
        if (localRect.left < i2) {
          k = localRect.left;
        }
        int i1 = n;
        if (localRect.right > n) {
          i1 = localRect.right;
        }
        n = m;
        if (localRect.top < m) {
          n = localRect.top;
        }
        i3 = i;
        if (localRect.bottom > i) {
          i3 = localRect.bottom;
        }
        j += 1;
        m = n;
        i2 = k;
        n = i1;
      }
      this.mRecyclerView.mTempRect.set(i2, m, n, i);
      setMeasuredDimension(this.mRecyclerView.mTempRect, paramInt1, paramInt2);
    }
    
    public void setMeasurementCacheEnabled(boolean paramBoolean)
    {
      this.mMeasurementCacheEnabled = paramBoolean;
    }
    
    void setRecyclerView(RecyclerView paramRecyclerView)
    {
      if (paramRecyclerView == null)
      {
        this.mRecyclerView = null;
        this.mChildHelper = null;
        this.mWidth = 0;
        this.mHeight = 0;
      }
      else
      {
        this.mRecyclerView = paramRecyclerView;
        this.mChildHelper = paramRecyclerView.mChildHelper;
        this.mWidth = paramRecyclerView.getWidth();
        this.mHeight = paramRecyclerView.getHeight();
      }
      this.mWidthMode = 1073741824;
      this.mHeightMode = 1073741824;
    }
    
    boolean shouldMeasureChild(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
    {
      return (paramView.isLayoutRequested()) || (!this.mMeasurementCacheEnabled) || (!isMeasurementUpToDate(paramView.getWidth(), paramInt1, paramLayoutParams.width)) || (!isMeasurementUpToDate(paramView.getHeight(), paramInt2, paramLayoutParams.height));
    }
    
    boolean shouldMeasureTwice()
    {
      return false;
    }
    
    boolean shouldReMeasureChild(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
    {
      return (!this.mMeasurementCacheEnabled) || (!isMeasurementUpToDate(paramView.getMeasuredWidth(), paramInt1, paramLayoutParams.width)) || (!isMeasurementUpToDate(paramView.getMeasuredHeight(), paramInt2, paramLayoutParams.height));
    }
    
    public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.State paramState, int paramInt)
    {
      Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
    }
    
    public void startSmoothScroll(RecyclerView.SmoothScroller paramSmoothScroller)
    {
      if ((this.mSmoothScroller != null) && (paramSmoothScroller != this.mSmoothScroller) && (this.mSmoothScroller.isRunning())) {
        this.mSmoothScroller.stop();
      }
      this.mSmoothScroller = paramSmoothScroller;
      this.mSmoothScroller.start(this.mRecyclerView, this);
    }
    
    public void stopIgnoringView(@NonNull View paramView)
    {
      paramView = RecyclerView.getChildViewHolderInt(paramView);
      paramView.stopIgnoring();
      paramView.resetInternal();
      paramView.addFlags(4);
    }
    
    void stopSmoothScroller()
    {
      if (this.mSmoothScroller != null) {
        this.mSmoothScroller.stop();
      }
    }
    
    public boolean supportsPredictiveItemAnimations()
    {
      return false;
    }
    
    public static abstract interface LayoutPrefetchRegistry
    {
      public abstract void addPosition(int paramInt1, int paramInt2);
    }
    
    public static class Properties
    {
      public int orientation;
      public boolean reverseLayout;
      public int spanCount;
      public boolean stackFromEnd;
    }
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    final Rect mDecorInsets = new Rect();
    boolean mInsetsDirty = true;
    boolean mPendingInvalidate = false;
    RecyclerView.ViewHolder mViewHolder;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
    
    public int getViewAdapterPosition()
    {
      return this.mViewHolder.getAdapterPosition();
    }
    
    public int getViewLayoutPosition()
    {
      return this.mViewHolder.getLayoutPosition();
    }
    
    @Deprecated
    public int getViewPosition()
    {
      return this.mViewHolder.getPosition();
    }
    
    public boolean isItemChanged()
    {
      return this.mViewHolder.isUpdated();
    }
    
    public boolean isItemRemoved()
    {
      return this.mViewHolder.isRemoved();
    }
    
    public boolean isViewInvalid()
    {
      return this.mViewHolder.isInvalid();
    }
    
    public boolean viewNeedsUpdate()
    {
      return this.mViewHolder.needsUpdate();
    }
  }
  
  public static abstract interface OnChildAttachStateChangeListener
  {
    public abstract void onChildViewAttachedToWindow(@NonNull View paramView);
    
    public abstract void onChildViewDetachedFromWindow(@NonNull View paramView);
  }
  
  public static abstract class OnFlingListener
  {
    public abstract boolean onFling(int paramInt1, int paramInt2);
  }
  
  public static abstract interface OnItemTouchListener
  {
    public abstract boolean onInterceptTouchEvent(@NonNull RecyclerView paramRecyclerView, @NonNull MotionEvent paramMotionEvent);
    
    public abstract void onRequestDisallowInterceptTouchEvent(boolean paramBoolean);
    
    public abstract void onTouchEvent(@NonNull RecyclerView paramRecyclerView, @NonNull MotionEvent paramMotionEvent);
  }
  
  public static abstract class OnScrollListener
  {
    public void onScrollStateChanged(@NonNull RecyclerView paramRecyclerView, int paramInt) {}
    
    public void onScrolled(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
  }
  
  @Retention(RetentionPolicy.SOURCE)
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static @interface Orientation {}
  
  public static class RecycledViewPool
  {
    private static final int DEFAULT_MAX_SCRAP = 5;
    private int mAttachCount = 0;
    SparseArray<ScrapData> mScrap = new SparseArray();
    
    private ScrapData getScrapDataForType(int paramInt)
    {
      ScrapData localScrapData2 = (ScrapData)this.mScrap.get(paramInt);
      ScrapData localScrapData1 = localScrapData2;
      if (localScrapData2 == null)
      {
        localScrapData1 = new ScrapData();
        this.mScrap.put(paramInt, localScrapData1);
      }
      return localScrapData1;
    }
    
    void attach()
    {
      this.mAttachCount += 1;
    }
    
    public void clear()
    {
      int i = 0;
      while (i < this.mScrap.size())
      {
        ((ScrapData)this.mScrap.valueAt(i)).mScrapHeap.clear();
        i += 1;
      }
    }
    
    void detach()
    {
      this.mAttachCount -= 1;
    }
    
    void factorInBindTime(int paramInt, long paramLong)
    {
      ScrapData localScrapData = getScrapDataForType(paramInt);
      localScrapData.mBindRunningAverageNs = runningAverage(localScrapData.mBindRunningAverageNs, paramLong);
    }
    
    void factorInCreateTime(int paramInt, long paramLong)
    {
      ScrapData localScrapData = getScrapDataForType(paramInt);
      localScrapData.mCreateRunningAverageNs = runningAverage(localScrapData.mCreateRunningAverageNs, paramLong);
    }
    
    @Nullable
    public RecyclerView.ViewHolder getRecycledView(int paramInt)
    {
      Object localObject = (ScrapData)this.mScrap.get(paramInt);
      if ((localObject != null) && (!((ScrapData)localObject).mScrapHeap.isEmpty()))
      {
        localObject = ((ScrapData)localObject).mScrapHeap;
        return (RecyclerView.ViewHolder)((ArrayList)localObject).remove(((ArrayList)localObject).size() - 1);
      }
      return null;
    }
    
    public int getRecycledViewCount(int paramInt)
    {
      return getScrapDataForType(paramInt).mScrapHeap.size();
    }
    
    void onAdapterChanged(RecyclerView.Adapter paramAdapter1, RecyclerView.Adapter paramAdapter2, boolean paramBoolean)
    {
      if (paramAdapter1 != null) {
        detach();
      }
      if ((!paramBoolean) && (this.mAttachCount == 0)) {
        clear();
      }
      if (paramAdapter2 != null) {
        attach();
      }
    }
    
    public void putRecycledView(RecyclerView.ViewHolder paramViewHolder)
    {
      int i = paramViewHolder.getItemViewType();
      ArrayList localArrayList = getScrapDataForType(i).mScrapHeap;
      if (((ScrapData)this.mScrap.get(i)).mMaxScrap <= localArrayList.size()) {
        return;
      }
      paramViewHolder.resetInternal();
      localArrayList.add(paramViewHolder);
    }
    
    long runningAverage(long paramLong1, long paramLong2)
    {
      if (paramLong1 == 0L) {
        return paramLong2;
      }
      return paramLong1 / 4L * 3L + paramLong2 / 4L;
    }
    
    public void setMaxRecycledViews(int paramInt1, int paramInt2)
    {
      Object localObject = getScrapDataForType(paramInt1);
      ((ScrapData)localObject).mMaxScrap = paramInt2;
      localObject = ((ScrapData)localObject).mScrapHeap;
      while (((ArrayList)localObject).size() > paramInt2) {
        ((ArrayList)localObject).remove(((ArrayList)localObject).size() - 1);
      }
    }
    
    int size()
    {
      int i = 0;
      int k;
      for (int j = 0; i < this.mScrap.size(); j = k)
      {
        ArrayList localArrayList = ((ScrapData)this.mScrap.valueAt(i)).mScrapHeap;
        k = j;
        if (localArrayList != null) {
          k = j + localArrayList.size();
        }
        i += 1;
      }
      return j;
    }
    
    boolean willBindInTime(int paramInt, long paramLong1, long paramLong2)
    {
      long l = getScrapDataForType(paramInt).mBindRunningAverageNs;
      return (l == 0L) || (paramLong1 + l < paramLong2);
    }
    
    boolean willCreateInTime(int paramInt, long paramLong1, long paramLong2)
    {
      long l = getScrapDataForType(paramInt).mCreateRunningAverageNs;
      return (l == 0L) || (paramLong1 + l < paramLong2);
    }
    
    static class ScrapData
    {
      long mBindRunningAverageNs = 0L;
      long mCreateRunningAverageNs = 0L;
      int mMaxScrap = 5;
      final ArrayList<RecyclerView.ViewHolder> mScrapHeap = new ArrayList();
    }
  }
  
  public final class Recycler
  {
    static final int DEFAULT_CACHE_SIZE = 2;
    final ArrayList<RecyclerView.ViewHolder> mAttachedScrap = new ArrayList();
    final ArrayList<RecyclerView.ViewHolder> mCachedViews = new ArrayList();
    ArrayList<RecyclerView.ViewHolder> mChangedScrap = null;
    RecyclerView.RecycledViewPool mRecyclerPool;
    private int mRequestedCacheMax = 2;
    private final List<RecyclerView.ViewHolder> mUnmodifiableAttachedScrap = Collections.unmodifiableList(this.mAttachedScrap);
    private RecyclerView.ViewCacheExtension mViewCacheExtension;
    int mViewCacheMax = 2;
    
    public Recycler() {}
    
    private void attachAccessibilityDelegateOnBind(RecyclerView.ViewHolder paramViewHolder)
    {
      if (RecyclerView.this.isAccessibilityEnabled())
      {
        View localView = paramViewHolder.itemView;
        if (ViewCompat.getImportantForAccessibility(localView) == 0) {
          ViewCompat.setImportantForAccessibility(localView, 1);
        }
        if (!ViewCompat.hasAccessibilityDelegate(localView))
        {
          paramViewHolder.addFlags(16384);
          ViewCompat.setAccessibilityDelegate(localView, RecyclerView.this.mAccessibilityDelegate.getItemDelegate());
        }
      }
    }
    
    private void invalidateDisplayListInt(RecyclerView.ViewHolder paramViewHolder)
    {
      if ((paramViewHolder.itemView instanceof ViewGroup)) {
        invalidateDisplayListInt((ViewGroup)paramViewHolder.itemView, false);
      }
    }
    
    private void invalidateDisplayListInt(ViewGroup paramViewGroup, boolean paramBoolean)
    {
      int i = paramViewGroup.getChildCount() - 1;
      while (i >= 0)
      {
        View localView = paramViewGroup.getChildAt(i);
        if ((localView instanceof ViewGroup)) {
          invalidateDisplayListInt((ViewGroup)localView, true);
        }
        i -= 1;
      }
      if (!paramBoolean) {
        return;
      }
      if (paramViewGroup.getVisibility() == 4)
      {
        paramViewGroup.setVisibility(0);
        paramViewGroup.setVisibility(4);
        return;
      }
      i = paramViewGroup.getVisibility();
      paramViewGroup.setVisibility(4);
      paramViewGroup.setVisibility(i);
    }
    
    private boolean tryBindViewHolderByDeadline(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, long paramLong)
    {
      paramViewHolder.mOwnerRecyclerView = RecyclerView.this;
      int i = paramViewHolder.getItemViewType();
      long l = RecyclerView.this.getNanoTime();
      if ((paramLong != Long.MAX_VALUE) && (!this.mRecyclerPool.willBindInTime(i, l, paramLong))) {
        return false;
      }
      RecyclerView.this.mAdapter.bindViewHolder(paramViewHolder, paramInt1);
      paramLong = RecyclerView.this.getNanoTime();
      this.mRecyclerPool.factorInBindTime(paramViewHolder.getItemViewType(), paramLong - l);
      attachAccessibilityDelegateOnBind(paramViewHolder);
      if (RecyclerView.this.mState.isPreLayout()) {
        paramViewHolder.mPreLayoutPosition = paramInt2;
      }
      return true;
    }
    
    void addViewHolderToRecycledViewPool(@NonNull RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
    {
      RecyclerView.clearNestedRecyclerViewIfNotNested(paramViewHolder);
      if (paramViewHolder.hasAnyOfTheFlags(16384))
      {
        paramViewHolder.setFlags(0, 16384);
        ViewCompat.setAccessibilityDelegate(paramViewHolder.itemView, null);
      }
      if (paramBoolean) {
        dispatchViewRecycled(paramViewHolder);
      }
      paramViewHolder.mOwnerRecyclerView = null;
      getRecycledViewPool().putRecycledView(paramViewHolder);
    }
    
    public void bindViewToPosition(@NonNull View paramView, int paramInt)
    {
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
      if (localViewHolder != null)
      {
        int i = RecyclerView.this.mAdapterHelper.findPositionOffset(paramInt);
        if ((i >= 0) && (i < RecyclerView.this.mAdapter.getItemCount()))
        {
          tryBindViewHolderByDeadline(localViewHolder, i, paramInt, Long.MAX_VALUE);
          paramView = localViewHolder.itemView.getLayoutParams();
          if (paramView == null)
          {
            paramView = (RecyclerView.LayoutParams)RecyclerView.this.generateDefaultLayoutParams();
            localViewHolder.itemView.setLayoutParams(paramView);
          }
          else if (!RecyclerView.this.checkLayoutParams(paramView))
          {
            paramView = (RecyclerView.LayoutParams)RecyclerView.this.generateLayoutParams(paramView);
            localViewHolder.itemView.setLayoutParams(paramView);
          }
          else
          {
            paramView = (RecyclerView.LayoutParams)paramView;
          }
          boolean bool = true;
          paramView.mInsetsDirty = true;
          paramView.mViewHolder = localViewHolder;
          if (localViewHolder.itemView.getParent() != null) {
            bool = false;
          }
          paramView.mPendingInvalidate = bool;
          return;
        }
        paramView = new StringBuilder();
        paramView.append("Inconsistency detected. Invalid item position ");
        paramView.append(paramInt);
        paramView.append("(offset:");
        paramView.append(i);
        paramView.append(").");
        paramView.append("state:");
        paramView.append(RecyclerView.this.mState.getItemCount());
        paramView.append(RecyclerView.this.exceptionLabel());
        throw new IndexOutOfBoundsException(paramView.toString());
      }
      paramView = new StringBuilder();
      paramView.append("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter");
      paramView.append(RecyclerView.this.exceptionLabel());
      throw new IllegalArgumentException(paramView.toString());
    }
    
    public void clear()
    {
      this.mAttachedScrap.clear();
      recycleAndClearCachedViews();
    }
    
    void clearOldPositions()
    {
      int k = this.mCachedViews.size();
      int j = 0;
      int i = 0;
      while (i < k)
      {
        ((RecyclerView.ViewHolder)this.mCachedViews.get(i)).clearOldPosition();
        i += 1;
      }
      k = this.mAttachedScrap.size();
      i = 0;
      while (i < k)
      {
        ((RecyclerView.ViewHolder)this.mAttachedScrap.get(i)).clearOldPosition();
        i += 1;
      }
      if (this.mChangedScrap != null)
      {
        k = this.mChangedScrap.size();
        i = j;
        while (i < k)
        {
          ((RecyclerView.ViewHolder)this.mChangedScrap.get(i)).clearOldPosition();
          i += 1;
        }
      }
    }
    
    void clearScrap()
    {
      this.mAttachedScrap.clear();
      if (this.mChangedScrap != null) {
        this.mChangedScrap.clear();
      }
    }
    
    public int convertPreLayoutPositionToPostLayout(int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < RecyclerView.this.mState.getItemCount()))
      {
        if (!RecyclerView.this.mState.isPreLayout()) {
          return paramInt;
        }
        return RecyclerView.this.mAdapterHelper.findPositionOffset(paramInt);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("invalid position ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(". State ");
      localStringBuilder.append("item count is ");
      localStringBuilder.append(RecyclerView.this.mState.getItemCount());
      localStringBuilder.append(RecyclerView.this.exceptionLabel());
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
    
    void dispatchViewRecycled(@NonNull RecyclerView.ViewHolder paramViewHolder)
    {
      if (RecyclerView.this.mRecyclerListener != null) {
        RecyclerView.this.mRecyclerListener.onViewRecycled(paramViewHolder);
      }
      if (RecyclerView.this.mAdapter != null) {
        RecyclerView.this.mAdapter.onViewRecycled(paramViewHolder);
      }
      if (RecyclerView.this.mState != null) {
        RecyclerView.this.mViewInfoStore.removeViewHolder(paramViewHolder);
      }
    }
    
    RecyclerView.ViewHolder getChangedScrapViewForPosition(int paramInt)
    {
      if (this.mChangedScrap != null)
      {
        int k = this.mChangedScrap.size();
        if (k == 0) {
          return null;
        }
        int j = 0;
        int i = 0;
        RecyclerView.ViewHolder localViewHolder;
        while (i < k)
        {
          localViewHolder = (RecyclerView.ViewHolder)this.mChangedScrap.get(i);
          if ((!localViewHolder.wasReturnedFromScrap()) && (localViewHolder.getLayoutPosition() == paramInt))
          {
            localViewHolder.addFlags(32);
            return localViewHolder;
          }
          i += 1;
        }
        if (RecyclerView.this.mAdapter.hasStableIds())
        {
          paramInt = RecyclerView.this.mAdapterHelper.findPositionOffset(paramInt);
          if ((paramInt > 0) && (paramInt < RecyclerView.this.mAdapter.getItemCount()))
          {
            long l = RecyclerView.this.mAdapter.getItemId(paramInt);
            paramInt = j;
            while (paramInt < k)
            {
              localViewHolder = (RecyclerView.ViewHolder)this.mChangedScrap.get(paramInt);
              if ((!localViewHolder.wasReturnedFromScrap()) && (localViewHolder.getItemId() == l))
              {
                localViewHolder.addFlags(32);
                return localViewHolder;
              }
              paramInt += 1;
            }
          }
        }
        return null;
      }
      return null;
    }
    
    RecyclerView.RecycledViewPool getRecycledViewPool()
    {
      if (this.mRecyclerPool == null) {
        this.mRecyclerPool = new RecyclerView.RecycledViewPool();
      }
      return this.mRecyclerPool;
    }
    
    int getScrapCount()
    {
      return this.mAttachedScrap.size();
    }
    
    @NonNull
    public List<RecyclerView.ViewHolder> getScrapList()
    {
      return this.mUnmodifiableAttachedScrap;
    }
    
    RecyclerView.ViewHolder getScrapOrCachedViewForId(long paramLong, int paramInt, boolean paramBoolean)
    {
      int i = this.mAttachedScrap.size() - 1;
      RecyclerView.ViewHolder localViewHolder;
      while (i >= 0)
      {
        localViewHolder = (RecyclerView.ViewHolder)this.mAttachedScrap.get(i);
        if ((localViewHolder.getItemId() == paramLong) && (!localViewHolder.wasReturnedFromScrap()))
        {
          if (paramInt == localViewHolder.getItemViewType())
          {
            localViewHolder.addFlags(32);
            if ((localViewHolder.isRemoved()) && (!RecyclerView.this.mState.isPreLayout())) {
              localViewHolder.setFlags(2, 14);
            }
            return localViewHolder;
          }
          if (!paramBoolean)
          {
            this.mAttachedScrap.remove(i);
            RecyclerView.this.removeDetachedView(localViewHolder.itemView, false);
            quickRecycleScrapView(localViewHolder.itemView);
          }
        }
        i -= 1;
      }
      i = this.mCachedViews.size() - 1;
      while (i >= 0)
      {
        localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(i);
        if (localViewHolder.getItemId() == paramLong)
        {
          if (paramInt == localViewHolder.getItemViewType())
          {
            if (!paramBoolean) {
              this.mCachedViews.remove(i);
            }
            return localViewHolder;
          }
          if (!paramBoolean)
          {
            recycleCachedViewAt(i);
            return null;
          }
        }
        i -= 1;
      }
      return null;
    }
    
    RecyclerView.ViewHolder getScrapOrHiddenOrCachedHolderForPosition(int paramInt, boolean paramBoolean)
    {
      int k = this.mAttachedScrap.size();
      int j = 0;
      int i = 0;
      RecyclerView.ViewHolder localViewHolder;
      while (i < k)
      {
        localViewHolder = (RecyclerView.ViewHolder)this.mAttachedScrap.get(i);
        if ((!localViewHolder.wasReturnedFromScrap()) && (localViewHolder.getLayoutPosition() == paramInt) && (!localViewHolder.isInvalid()) && ((RecyclerView.this.mState.mInPreLayout) || (!localViewHolder.isRemoved())))
        {
          localViewHolder.addFlags(32);
          return localViewHolder;
        }
        i += 1;
      }
      if (!paramBoolean)
      {
        Object localObject = RecyclerView.this.mChildHelper.findHiddenNonRemovedView(paramInt);
        if (localObject != null)
        {
          localViewHolder = RecyclerView.getChildViewHolderInt((View)localObject);
          RecyclerView.this.mChildHelper.unhide((View)localObject);
          paramInt = RecyclerView.this.mChildHelper.indexOfChild((View)localObject);
          if (paramInt != -1)
          {
            RecyclerView.this.mChildHelper.detachViewFromParent(paramInt);
            scrapView((View)localObject);
            localViewHolder.addFlags(8224);
            return localViewHolder;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("layout index should not be -1 after unhiding a view:");
          ((StringBuilder)localObject).append(localViewHolder);
          ((StringBuilder)localObject).append(RecyclerView.this.exceptionLabel());
          throw new IllegalStateException(((StringBuilder)localObject).toString());
        }
      }
      k = this.mCachedViews.size();
      i = j;
      while (i < k)
      {
        localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(i);
        if ((!localViewHolder.isInvalid()) && (localViewHolder.getLayoutPosition() == paramInt))
        {
          if (!paramBoolean) {
            this.mCachedViews.remove(i);
          }
          return localViewHolder;
        }
        i += 1;
      }
      return null;
    }
    
    View getScrapViewAt(int paramInt)
    {
      return ((RecyclerView.ViewHolder)this.mAttachedScrap.get(paramInt)).itemView;
    }
    
    @NonNull
    public View getViewForPosition(int paramInt)
    {
      return getViewForPosition(paramInt, false);
    }
    
    View getViewForPosition(int paramInt, boolean paramBoolean)
    {
      return tryGetViewHolderForPositionByDeadline(paramInt, paramBoolean, Long.MAX_VALUE).itemView;
    }
    
    void markItemDecorInsetsDirty()
    {
      int j = this.mCachedViews.size();
      int i = 0;
      while (i < j)
      {
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)((RecyclerView.ViewHolder)this.mCachedViews.get(i)).itemView.getLayoutParams();
        if (localLayoutParams != null) {
          localLayoutParams.mInsetsDirty = true;
        }
        i += 1;
      }
    }
    
    void markKnownViewsInvalid()
    {
      int j = this.mCachedViews.size();
      int i = 0;
      while (i < j)
      {
        RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(i);
        if (localViewHolder != null)
        {
          localViewHolder.addFlags(6);
          localViewHolder.addChangePayload(null);
        }
        i += 1;
      }
      if ((RecyclerView.this.mAdapter == null) || (!RecyclerView.this.mAdapter.hasStableIds())) {
        recycleAndClearCachedViews();
      }
    }
    
    void offsetPositionRecordsForInsert(int paramInt1, int paramInt2)
    {
      int j = this.mCachedViews.size();
      int i = 0;
      while (i < j)
      {
        RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(i);
        if ((localViewHolder != null) && (localViewHolder.mPosition >= paramInt1)) {
          localViewHolder.offsetPosition(paramInt2, true);
        }
        i += 1;
      }
    }
    
    void offsetPositionRecordsForMove(int paramInt1, int paramInt2)
    {
      int i;
      int j;
      int k;
      if (paramInt1 < paramInt2)
      {
        i = paramInt1;
        j = paramInt2;
        k = -1;
      }
      else
      {
        j = paramInt1;
        i = paramInt2;
        k = 1;
      }
      int n = this.mCachedViews.size();
      int m = 0;
      while (m < n)
      {
        RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(m);
        if ((localViewHolder != null) && (localViewHolder.mPosition >= i) && (localViewHolder.mPosition <= j)) {
          if (localViewHolder.mPosition == paramInt1) {
            localViewHolder.offsetPosition(paramInt2 - paramInt1, false);
          } else {
            localViewHolder.offsetPosition(k, false);
          }
        }
        m += 1;
      }
    }
    
    void offsetPositionRecordsForRemove(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      int i = this.mCachedViews.size() - 1;
      while (i >= 0)
      {
        RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(i);
        if (localViewHolder != null) {
          if (localViewHolder.mPosition >= paramInt1 + paramInt2)
          {
            localViewHolder.offsetPosition(-paramInt2, paramBoolean);
          }
          else if (localViewHolder.mPosition >= paramInt1)
          {
            localViewHolder.addFlags(8);
            recycleCachedViewAt(i);
          }
        }
        i -= 1;
      }
    }
    
    void onAdapterChanged(RecyclerView.Adapter paramAdapter1, RecyclerView.Adapter paramAdapter2, boolean paramBoolean)
    {
      clear();
      getRecycledViewPool().onAdapterChanged(paramAdapter1, paramAdapter2, paramBoolean);
    }
    
    void quickRecycleScrapView(View paramView)
    {
      paramView = RecyclerView.getChildViewHolderInt(paramView);
      paramView.mScrapContainer = null;
      paramView.mInChangeScrap = false;
      paramView.clearReturnedFromScrapFlag();
      recycleViewHolderInternal(paramView);
    }
    
    void recycleAndClearCachedViews()
    {
      int i = this.mCachedViews.size() - 1;
      while (i >= 0)
      {
        recycleCachedViewAt(i);
        i -= 1;
      }
      this.mCachedViews.clear();
      if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
        RecyclerView.this.mPrefetchRegistry.clearPrefetchPositions();
      }
    }
    
    void recycleCachedViewAt(int paramInt)
    {
      addViewHolderToRecycledViewPool((RecyclerView.ViewHolder)this.mCachedViews.get(paramInt), true);
      this.mCachedViews.remove(paramInt);
    }
    
    public void recycleView(@NonNull View paramView)
    {
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
      if (localViewHolder.isTmpDetached()) {
        RecyclerView.this.removeDetachedView(paramView, false);
      }
      if (localViewHolder.isScrap()) {
        localViewHolder.unScrap();
      } else if (localViewHolder.wasReturnedFromScrap()) {
        localViewHolder.clearReturnedFromScrapFlag();
      }
      recycleViewHolderInternal(localViewHolder);
    }
    
    void recycleViewHolderInternal(RecyclerView.ViewHolder paramViewHolder)
    {
      boolean bool2 = paramViewHolder.isScrap();
      boolean bool1 = false;
      int k = 0;
      if ((!bool2) && (paramViewHolder.itemView.getParent() == null))
      {
        if (!paramViewHolder.isTmpDetached())
        {
          if (!paramViewHolder.shouldIgnore())
          {
            bool1 = paramViewHolder.doesTransientStatePreventRecycling();
            int i;
            if ((RecyclerView.this.mAdapter != null) && (bool1) && (RecyclerView.this.mAdapter.onFailedToRecycleView(paramViewHolder))) {
              i = 1;
            } else {
              i = 0;
            }
            int j;
            if ((i == 0) && (!paramViewHolder.isRecyclable()))
            {
              i = 0;
              j = k;
              k = i;
            }
            else
            {
              if ((this.mViewCacheMax > 0) && (!paramViewHolder.hasAnyOfTheFlags(526)))
              {
                j = this.mCachedViews.size();
                i = j;
                if (j >= this.mViewCacheMax)
                {
                  i = j;
                  if (j > 0)
                  {
                    recycleCachedViewAt(0);
                    i = j - 1;
                  }
                }
                j = i;
                if (RecyclerView.ALLOW_THREAD_GAP_WORK)
                {
                  j = i;
                  if (i > 0)
                  {
                    j = i;
                    if (!RecyclerView.this.mPrefetchRegistry.lastPrefetchIncludedPosition(paramViewHolder.mPosition))
                    {
                      i -= 1;
                      while (i >= 0)
                      {
                        j = ((RecyclerView.ViewHolder)this.mCachedViews.get(i)).mPosition;
                        if (!RecyclerView.this.mPrefetchRegistry.lastPrefetchIncludedPosition(j)) {
                          break;
                        }
                        i -= 1;
                      }
                      j = i + 1;
                    }
                  }
                }
                this.mCachedViews.add(j, paramViewHolder);
                i = 1;
              }
              else
              {
                i = 0;
              }
              j = k;
              k = i;
              if (i == 0)
              {
                addViewHolderToRecycledViewPool(paramViewHolder, true);
                j = 1;
                k = i;
              }
            }
            RecyclerView.this.mViewInfoStore.removeViewHolder(paramViewHolder);
            if ((k == 0) && (j == 0) && (bool1)) {
              paramViewHolder.mOwnerRecyclerView = null;
            }
            return;
          }
          paramViewHolder = new StringBuilder();
          paramViewHolder.append("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
          paramViewHolder.append(RecyclerView.this.exceptionLabel());
          throw new IllegalArgumentException(paramViewHolder.toString());
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
        localStringBuilder.append(paramViewHolder);
        localStringBuilder.append(RecyclerView.this.exceptionLabel());
        throw new IllegalArgumentException(localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Scrapped or attached views may not be recycled. isScrap:");
      localStringBuilder.append(paramViewHolder.isScrap());
      localStringBuilder.append(" isAttached:");
      if (paramViewHolder.itemView.getParent() != null) {
        bool1 = true;
      }
      localStringBuilder.append(bool1);
      localStringBuilder.append(RecyclerView.this.exceptionLabel());
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    
    void recycleViewInternal(View paramView)
    {
      recycleViewHolderInternal(RecyclerView.getChildViewHolderInt(paramView));
    }
    
    void scrapView(View paramView)
    {
      paramView = RecyclerView.getChildViewHolderInt(paramView);
      if ((!paramView.hasAnyOfTheFlags(12)) && (paramView.isUpdated()) && (!RecyclerView.this.canReuseUpdatedViewHolder(paramView)))
      {
        if (this.mChangedScrap == null) {
          this.mChangedScrap = new ArrayList();
        }
        paramView.setScrapContainer(this, true);
        this.mChangedScrap.add(paramView);
        return;
      }
      if ((paramView.isInvalid()) && (!paramView.isRemoved()) && (!RecyclerView.this.mAdapter.hasStableIds()))
      {
        paramView = new StringBuilder();
        paramView.append("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
        paramView.append(RecyclerView.this.exceptionLabel());
        throw new IllegalArgumentException(paramView.toString());
      }
      paramView.setScrapContainer(this, false);
      this.mAttachedScrap.add(paramView);
    }
    
    void setRecycledViewPool(RecyclerView.RecycledViewPool paramRecycledViewPool)
    {
      if (this.mRecyclerPool != null) {
        this.mRecyclerPool.detach();
      }
      this.mRecyclerPool = paramRecycledViewPool;
      if ((this.mRecyclerPool != null) && (RecyclerView.this.getAdapter() != null)) {
        this.mRecyclerPool.attach();
      }
    }
    
    void setViewCacheExtension(RecyclerView.ViewCacheExtension paramViewCacheExtension)
    {
      this.mViewCacheExtension = paramViewCacheExtension;
    }
    
    public void setViewCacheSize(int paramInt)
    {
      this.mRequestedCacheMax = paramInt;
      updateViewCacheSize();
    }
    
    @Nullable
    RecyclerView.ViewHolder tryGetViewHolderForPositionByDeadline(int paramInt, boolean paramBoolean, long paramLong)
    {
      if ((paramInt >= 0) && (paramInt < RecyclerView.this.mState.getItemCount()))
      {
        boolean bool2 = RecyclerView.this.mState.isPreLayout();
        boolean bool1 = true;
        if (bool2)
        {
          localObject2 = getChangedScrapViewForPosition(paramInt);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            j = 1;
            break label70;
          }
        }
        else
        {
          localObject1 = null;
        }
        int j = 0;
        Object localObject2 = localObject1;
        label70:
        localObject1 = localObject2;
        int i = j;
        if (localObject2 == null)
        {
          localObject2 = getScrapOrHiddenOrCachedHolderForPosition(paramInt, paramBoolean);
          localObject1 = localObject2;
          i = j;
          if (localObject2 != null) {
            if (!validateViewHolderForOffsetPosition((RecyclerView.ViewHolder)localObject2))
            {
              if (!paramBoolean)
              {
                ((RecyclerView.ViewHolder)localObject2).addFlags(4);
                if (((RecyclerView.ViewHolder)localObject2).isScrap())
                {
                  RecyclerView.this.removeDetachedView(((RecyclerView.ViewHolder)localObject2).itemView, false);
                  ((RecyclerView.ViewHolder)localObject2).unScrap();
                }
                else if (((RecyclerView.ViewHolder)localObject2).wasReturnedFromScrap())
                {
                  ((RecyclerView.ViewHolder)localObject2).clearReturnedFromScrapFlag();
                }
                recycleViewHolderInternal((RecyclerView.ViewHolder)localObject2);
              }
              localObject1 = null;
              i = j;
            }
            else
            {
              i = 1;
              localObject1 = localObject2;
            }
          }
        }
        localObject2 = localObject1;
        int k = i;
        if (localObject1 == null)
        {
          k = RecyclerView.this.mAdapterHelper.findPositionOffset(paramInt);
          if ((k >= 0) && (k < RecyclerView.this.mAdapter.getItemCount()))
          {
            int m = RecyclerView.this.mAdapter.getItemViewType(k);
            j = i;
            if (RecyclerView.this.mAdapter.hasStableIds())
            {
              localObject2 = getScrapOrCachedViewForId(RecyclerView.this.mAdapter.getItemId(k), m, paramBoolean);
              localObject1 = localObject2;
              j = i;
              if (localObject2 != null)
              {
                ((RecyclerView.ViewHolder)localObject2).mPosition = k;
                j = 1;
                localObject1 = localObject2;
              }
            }
            localObject2 = localObject1;
            if (localObject1 == null)
            {
              localObject2 = localObject1;
              if (this.mViewCacheExtension != null)
              {
                View localView = this.mViewCacheExtension.getViewForPositionAndType(this, paramInt, m);
                localObject2 = localObject1;
                if (localView != null)
                {
                  localObject2 = RecyclerView.this.getChildViewHolder(localView);
                  if (localObject2 != null)
                  {
                    if (((RecyclerView.ViewHolder)localObject2).shouldIgnore())
                    {
                      localObject1 = new StringBuilder();
                      ((StringBuilder)localObject1).append("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                      ((StringBuilder)localObject1).append(RecyclerView.this.exceptionLabel());
                      throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
                    }
                  }
                  else
                  {
                    localObject1 = new StringBuilder();
                    ((StringBuilder)localObject1).append("getViewForPositionAndType returned a view which does not have a ViewHolder");
                    ((StringBuilder)localObject1).append(RecyclerView.this.exceptionLabel());
                    throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
                  }
                }
              }
            }
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject2 = getRecycledViewPool().getRecycledView(m);
              localObject1 = localObject2;
              if (localObject2 != null)
              {
                ((RecyclerView.ViewHolder)localObject2).resetInternal();
                localObject1 = localObject2;
                if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST)
                {
                  invalidateDisplayListInt((RecyclerView.ViewHolder)localObject2);
                  localObject1 = localObject2;
                }
              }
            }
            localObject2 = localObject1;
            k = j;
            if (localObject1 == null)
            {
              long l1 = RecyclerView.this.getNanoTime();
              if ((paramLong != Long.MAX_VALUE) && (!this.mRecyclerPool.willCreateInTime(m, l1, paramLong))) {
                return null;
              }
              localObject2 = RecyclerView.this.mAdapter.createViewHolder(RecyclerView.this, m);
              if (RecyclerView.ALLOW_THREAD_GAP_WORK)
              {
                localObject1 = RecyclerView.findNestedRecyclerView(((RecyclerView.ViewHolder)localObject2).itemView);
                if (localObject1 != null) {
                  ((RecyclerView.ViewHolder)localObject2).mNestedRecyclerView = new WeakReference(localObject1);
                }
              }
              long l2 = RecyclerView.this.getNanoTime();
              this.mRecyclerPool.factorInCreateTime(m, l2 - l1);
              break label756;
            }
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Inconsistency detected. Invalid item position ");
            ((StringBuilder)localObject1).append(paramInt);
            ((StringBuilder)localObject1).append("(offset:");
            ((StringBuilder)localObject1).append(k);
            ((StringBuilder)localObject1).append(").");
            ((StringBuilder)localObject1).append("state:");
            ((StringBuilder)localObject1).append(RecyclerView.this.mState.getItemCount());
            ((StringBuilder)localObject1).append(RecyclerView.this.exceptionLabel());
            throw new IndexOutOfBoundsException(((StringBuilder)localObject1).toString());
          }
        }
        j = k;
        label756:
        if ((j != 0) && (!RecyclerView.this.mState.isPreLayout()) && (((RecyclerView.ViewHolder)localObject2).hasAnyOfTheFlags(8192)))
        {
          ((RecyclerView.ViewHolder)localObject2).setFlags(0, 8192);
          if (RecyclerView.this.mState.mRunSimpleAnimations)
          {
            i = RecyclerView.ItemAnimator.buildAdapterChangeFlagsForAnimations((RecyclerView.ViewHolder)localObject2);
            localObject1 = RecyclerView.this.mItemAnimator.recordPreLayoutInformation(RecyclerView.this.mState, (RecyclerView.ViewHolder)localObject2, i | 0x1000, ((RecyclerView.ViewHolder)localObject2).getUnmodifiedPayloads());
            RecyclerView.this.recordAnimationInfoIfBouncedHiddenView((RecyclerView.ViewHolder)localObject2, (RecyclerView.ItemAnimator.ItemHolderInfo)localObject1);
          }
        }
        if ((RecyclerView.this.mState.isPreLayout()) && (((RecyclerView.ViewHolder)localObject2).isBound())) {
          ((RecyclerView.ViewHolder)localObject2).mPreLayoutPosition = paramInt;
        } else {
          if ((!((RecyclerView.ViewHolder)localObject2).isBound()) || (((RecyclerView.ViewHolder)localObject2).needsUpdate()) || (((RecyclerView.ViewHolder)localObject2).isInvalid())) {
            break label919;
          }
        }
        paramBoolean = false;
        break label939;
        label919:
        paramBoolean = tryBindViewHolderByDeadline((RecyclerView.ViewHolder)localObject2, RecyclerView.this.mAdapterHelper.findPositionOffset(paramInt), paramInt, paramLong);
        label939:
        localObject1 = ((RecyclerView.ViewHolder)localObject2).itemView.getLayoutParams();
        if (localObject1 == null)
        {
          localObject1 = (RecyclerView.LayoutParams)RecyclerView.this.generateDefaultLayoutParams();
          ((RecyclerView.ViewHolder)localObject2).itemView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        else if (!RecyclerView.this.checkLayoutParams((ViewGroup.LayoutParams)localObject1))
        {
          localObject1 = (RecyclerView.LayoutParams)RecyclerView.this.generateLayoutParams((ViewGroup.LayoutParams)localObject1);
          ((RecyclerView.ViewHolder)localObject2).itemView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        else
        {
          localObject1 = (RecyclerView.LayoutParams)localObject1;
        }
        ((RecyclerView.LayoutParams)localObject1).mViewHolder = ((RecyclerView.ViewHolder)localObject2);
        if ((j != 0) && (paramBoolean)) {
          paramBoolean = bool1;
        } else {
          paramBoolean = false;
        }
        ((RecyclerView.LayoutParams)localObject1).mPendingInvalidate = paramBoolean;
        return (RecyclerView.ViewHolder)localObject2;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Invalid item position ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("(");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("). Item count:");
      ((StringBuilder)localObject1).append(RecyclerView.this.mState.getItemCount());
      ((StringBuilder)localObject1).append(RecyclerView.this.exceptionLabel());
      throw new IndexOutOfBoundsException(((StringBuilder)localObject1).toString());
    }
    
    void unscrapView(RecyclerView.ViewHolder paramViewHolder)
    {
      if (paramViewHolder.mInChangeScrap) {
        this.mChangedScrap.remove(paramViewHolder);
      } else {
        this.mAttachedScrap.remove(paramViewHolder);
      }
      paramViewHolder.mScrapContainer = null;
      paramViewHolder.mInChangeScrap = false;
      paramViewHolder.clearReturnedFromScrapFlag();
    }
    
    void updateViewCacheSize()
    {
      if (RecyclerView.this.mLayout != null) {
        i = RecyclerView.this.mLayout.mPrefetchMaxCountObserved;
      } else {
        i = 0;
      }
      this.mViewCacheMax = (this.mRequestedCacheMax + i);
      int i = this.mCachedViews.size() - 1;
      while ((i >= 0) && (this.mCachedViews.size() > this.mViewCacheMax))
      {
        recycleCachedViewAt(i);
        i -= 1;
      }
    }
    
    boolean validateViewHolderForOffsetPosition(RecyclerView.ViewHolder paramViewHolder)
    {
      if (paramViewHolder.isRemoved()) {
        return RecyclerView.this.mState.isPreLayout();
      }
      if ((paramViewHolder.mPosition >= 0) && (paramViewHolder.mPosition < RecyclerView.this.mAdapter.getItemCount()))
      {
        boolean bool2 = RecyclerView.this.mState.isPreLayout();
        boolean bool1 = false;
        if ((!bool2) && (RecyclerView.this.mAdapter.getItemViewType(paramViewHolder.mPosition) != paramViewHolder.getItemViewType())) {
          return false;
        }
        if (RecyclerView.this.mAdapter.hasStableIds())
        {
          if (paramViewHolder.getItemId() == RecyclerView.this.mAdapter.getItemId(paramViewHolder.mPosition)) {
            bool1 = true;
          }
          return bool1;
        }
        return true;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Inconsistency detected. Invalid view holder adapter position");
      localStringBuilder.append(paramViewHolder);
      localStringBuilder.append(RecyclerView.this.exceptionLabel());
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
    
    void viewRangeUpdate(int paramInt1, int paramInt2)
    {
      int i = this.mCachedViews.size() - 1;
      while (i >= 0)
      {
        RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)this.mCachedViews.get(i);
        if (localViewHolder != null)
        {
          int j = localViewHolder.mPosition;
          if ((j >= paramInt1) && (j < paramInt2 + paramInt1))
          {
            localViewHolder.addFlags(2);
            recycleCachedViewAt(i);
          }
        }
        i -= 1;
      }
    }
  }
  
  public static abstract interface RecyclerListener
  {
    public abstract void onViewRecycled(@NonNull RecyclerView.ViewHolder paramViewHolder);
  }
  
  private class RecyclerViewDataObserver
    extends RecyclerView.AdapterDataObserver
  {
    RecyclerViewDataObserver() {}
    
    public void onChanged()
    {
      RecyclerView.this.assertNotInLayoutOrScroll(null);
      RecyclerView.this.mState.mStructureChanged = true;
      RecyclerView.this.processDataSetCompletelyChanged(true);
      if (!RecyclerView.this.mAdapterHelper.hasPendingUpdates()) {
        RecyclerView.this.requestLayout();
      }
    }
    
    public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      RecyclerView.this.assertNotInLayoutOrScroll(null);
      if (RecyclerView.this.mAdapterHelper.onItemRangeChanged(paramInt1, paramInt2, paramObject)) {
        triggerUpdateProcessor();
      }
    }
    
    public void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      RecyclerView.this.assertNotInLayoutOrScroll(null);
      if (RecyclerView.this.mAdapterHelper.onItemRangeInserted(paramInt1, paramInt2)) {
        triggerUpdateProcessor();
      }
    }
    
    public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
    {
      RecyclerView.this.assertNotInLayoutOrScroll(null);
      if (RecyclerView.this.mAdapterHelper.onItemRangeMoved(paramInt1, paramInt2, paramInt3)) {
        triggerUpdateProcessor();
      }
    }
    
    public void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      RecyclerView.this.assertNotInLayoutOrScroll(null);
      if (RecyclerView.this.mAdapterHelper.onItemRangeRemoved(paramInt1, paramInt2)) {
        triggerUpdateProcessor();
      }
    }
    
    void triggerUpdateProcessor()
    {
      if ((RecyclerView.POST_UPDATES_ON_ANIMATION) && (RecyclerView.this.mHasFixedSize) && (RecyclerView.this.mIsAttached))
      {
        ViewCompat.postOnAnimation(RecyclerView.this, RecyclerView.this.mUpdateChildViewsRunnable);
        return;
      }
      RecyclerView.this.mAdapterUpdateDuringMeasure = true;
      RecyclerView.this.requestLayout();
    }
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator()
    {
      public RecyclerView.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new RecyclerView.SavedState(paramAnonymousParcel, null);
      }
      
      public RecyclerView.SavedState createFromParcel(Parcel paramAnonymousParcel, ClassLoader paramAnonymousClassLoader)
      {
        return new RecyclerView.SavedState(paramAnonymousParcel, paramAnonymousClassLoader);
      }
      
      public RecyclerView.SavedState[] newArray(int paramAnonymousInt)
      {
        return new RecyclerView.SavedState[paramAnonymousInt];
      }
    };
    Parcelable mLayoutState;
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      if (paramClassLoader == null) {
        paramClassLoader = RecyclerView.LayoutManager.class.getClassLoader();
      }
      this.mLayoutState = paramParcel.readParcelable(paramClassLoader);
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    void copyFrom(SavedState paramSavedState)
    {
      this.mLayoutState = paramSavedState.mLayoutState;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeParcelable(this.mLayoutState, 0);
    }
  }
  
  public static class SimpleOnItemTouchListener
    implements RecyclerView.OnItemTouchListener
  {
    public boolean onInterceptTouchEvent(@NonNull RecyclerView paramRecyclerView, @NonNull MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public void onRequestDisallowInterceptTouchEvent(boolean paramBoolean) {}
    
    public void onTouchEvent(@NonNull RecyclerView paramRecyclerView, @NonNull MotionEvent paramMotionEvent) {}
  }
  
  public static abstract class SmoothScroller
  {
    private RecyclerView.LayoutManager mLayoutManager;
    private boolean mPendingInitialRun;
    private RecyclerView mRecyclerView;
    private final Action mRecyclingAction = new Action(0, 0);
    private boolean mRunning;
    private boolean mStarted;
    private int mTargetPosition = -1;
    private View mTargetView;
    
    @Nullable
    public PointF computeScrollVectorForPosition(int paramInt)
    {
      Object localObject = getLayoutManager();
      if ((localObject instanceof ScrollVectorProvider)) {
        return ((ScrollVectorProvider)localObject).computeScrollVectorForPosition(paramInt);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("You should override computeScrollVectorForPosition when the LayoutManager does not implement ");
      ((StringBuilder)localObject).append(ScrollVectorProvider.class.getCanonicalName());
      Log.w("RecyclerView", ((StringBuilder)localObject).toString());
      return null;
    }
    
    public View findViewByPosition(int paramInt)
    {
      return this.mRecyclerView.mLayout.findViewByPosition(paramInt);
    }
    
    public int getChildCount()
    {
      return this.mRecyclerView.mLayout.getChildCount();
    }
    
    public int getChildPosition(View paramView)
    {
      return this.mRecyclerView.getChildLayoutPosition(paramView);
    }
    
    @Nullable
    public RecyclerView.LayoutManager getLayoutManager()
    {
      return this.mLayoutManager;
    }
    
    public int getTargetPosition()
    {
      return this.mTargetPosition;
    }
    
    @Deprecated
    public void instantScrollToPosition(int paramInt)
    {
      this.mRecyclerView.scrollToPosition(paramInt);
    }
    
    public boolean isPendingInitialRun()
    {
      return this.mPendingInitialRun;
    }
    
    public boolean isRunning()
    {
      return this.mRunning;
    }
    
    protected void normalize(@NonNull PointF paramPointF)
    {
      float f = (float)Math.sqrt(paramPointF.x * paramPointF.x + paramPointF.y * paramPointF.y);
      paramPointF.x /= f;
      paramPointF.y /= f;
    }
    
    void onAnimation(int paramInt1, int paramInt2)
    {
      RecyclerView localRecyclerView = this.mRecyclerView;
      if ((!this.mRunning) || (this.mTargetPosition == -1) || (localRecyclerView == null)) {
        stop();
      }
      if ((this.mPendingInitialRun) && (this.mTargetView == null) && (this.mLayoutManager != null))
      {
        PointF localPointF = computeScrollVectorForPosition(this.mTargetPosition);
        if ((localPointF != null) && ((localPointF.x != 0.0F) || (localPointF.y != 0.0F))) {
          localRecyclerView.scrollStep((int)Math.signum(localPointF.x), (int)Math.signum(localPointF.y), null);
        }
      }
      this.mPendingInitialRun = false;
      if (this.mTargetView != null) {
        if (getChildPosition(this.mTargetView) == this.mTargetPosition)
        {
          onTargetFound(this.mTargetView, localRecyclerView.mState, this.mRecyclingAction);
          this.mRecyclingAction.runIfNecessary(localRecyclerView);
          stop();
        }
        else
        {
          Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
          this.mTargetView = null;
        }
      }
      if (this.mRunning)
      {
        onSeekTargetStep(paramInt1, paramInt2, localRecyclerView.mState, this.mRecyclingAction);
        boolean bool = this.mRecyclingAction.hasJumpTarget();
        this.mRecyclingAction.runIfNecessary(localRecyclerView);
        if (bool)
        {
          if (this.mRunning)
          {
            this.mPendingInitialRun = true;
            localRecyclerView.mViewFlinger.postOnAnimation();
            return;
          }
          stop();
        }
      }
    }
    
    protected void onChildAttachedToWindow(View paramView)
    {
      if (getChildPosition(paramView) == getTargetPosition()) {
        this.mTargetView = paramView;
      }
    }
    
    protected abstract void onSeekTargetStep(@Px int paramInt1, @Px int paramInt2, @NonNull RecyclerView.State paramState, @NonNull Action paramAction);
    
    protected abstract void onStart();
    
    protected abstract void onStop();
    
    protected abstract void onTargetFound(@NonNull View paramView, @NonNull RecyclerView.State paramState, @NonNull Action paramAction);
    
    public void setTargetPosition(int paramInt)
    {
      this.mTargetPosition = paramInt;
    }
    
    void start(RecyclerView paramRecyclerView, RecyclerView.LayoutManager paramLayoutManager)
    {
      if (this.mStarted)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("An instance of ");
        localStringBuilder.append(getClass().getSimpleName());
        localStringBuilder.append(" was started ");
        localStringBuilder.append("more than once. Each instance of");
        localStringBuilder.append(getClass().getSimpleName());
        localStringBuilder.append(" ");
        localStringBuilder.append("is intended to only be used once. You should create a new instance for ");
        localStringBuilder.append("each use.");
        Log.w("RecyclerView", localStringBuilder.toString());
      }
      this.mRecyclerView = paramRecyclerView;
      this.mLayoutManager = paramLayoutManager;
      if (this.mTargetPosition != -1)
      {
        this.mRecyclerView.mState.mTargetPosition = this.mTargetPosition;
        this.mRunning = true;
        this.mPendingInitialRun = true;
        this.mTargetView = findViewByPosition(getTargetPosition());
        onStart();
        this.mRecyclerView.mViewFlinger.postOnAnimation();
        this.mStarted = true;
        return;
      }
      throw new IllegalArgumentException("Invalid target position");
    }
    
    protected final void stop()
    {
      if (!this.mRunning) {
        return;
      }
      this.mRunning = false;
      onStop();
      this.mRecyclerView.mState.mTargetPosition = -1;
      this.mTargetView = null;
      this.mTargetPosition = -1;
      this.mPendingInitialRun = false;
      this.mLayoutManager.onSmoothScrollerStopped(this);
      this.mLayoutManager = null;
      this.mRecyclerView = null;
    }
    
    public static class Action
    {
      public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
      private boolean mChanged = false;
      private int mConsecutiveUpdates = 0;
      private int mDuration;
      private int mDx;
      private int mDy;
      private Interpolator mInterpolator;
      private int mJumpToPosition = -1;
      
      public Action(@Px int paramInt1, @Px int paramInt2)
      {
        this(paramInt1, paramInt2, Integer.MIN_VALUE, null);
      }
      
      public Action(@Px int paramInt1, @Px int paramInt2, int paramInt3)
      {
        this(paramInt1, paramInt2, paramInt3, null);
      }
      
      public Action(@Px int paramInt1, @Px int paramInt2, int paramInt3, @Nullable Interpolator paramInterpolator)
      {
        this.mDx = paramInt1;
        this.mDy = paramInt2;
        this.mDuration = paramInt3;
        this.mInterpolator = paramInterpolator;
      }
      
      private void validate()
      {
        if ((this.mInterpolator != null) && (this.mDuration < 1)) {
          throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
        }
        if (this.mDuration >= 1) {
          return;
        }
        throw new IllegalStateException("Scroll duration must be a positive number");
      }
      
      public int getDuration()
      {
        return this.mDuration;
      }
      
      @Px
      public int getDx()
      {
        return this.mDx;
      }
      
      @Px
      public int getDy()
      {
        return this.mDy;
      }
      
      @Nullable
      public Interpolator getInterpolator()
      {
        return this.mInterpolator;
      }
      
      boolean hasJumpTarget()
      {
        return this.mJumpToPosition >= 0;
      }
      
      public void jumpTo(int paramInt)
      {
        this.mJumpToPosition = paramInt;
      }
      
      void runIfNecessary(RecyclerView paramRecyclerView)
      {
        if (this.mJumpToPosition >= 0)
        {
          int i = this.mJumpToPosition;
          this.mJumpToPosition = -1;
          paramRecyclerView.jumpToPositionForSmoothScroller(i);
          this.mChanged = false;
          return;
        }
        if (this.mChanged)
        {
          validate();
          if (this.mInterpolator == null)
          {
            if (this.mDuration == Integer.MIN_VALUE) {
              paramRecyclerView.mViewFlinger.smoothScrollBy(this.mDx, this.mDy);
            } else {
              paramRecyclerView.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, this.mDuration);
            }
          }
          else {
            paramRecyclerView.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, this.mDuration, this.mInterpolator);
          }
          this.mConsecutiveUpdates += 1;
          if (this.mConsecutiveUpdates > 10) {
            Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
          }
          this.mChanged = false;
          return;
        }
        this.mConsecutiveUpdates = 0;
      }
      
      public void setDuration(int paramInt)
      {
        this.mChanged = true;
        this.mDuration = paramInt;
      }
      
      public void setDx(@Px int paramInt)
      {
        this.mChanged = true;
        this.mDx = paramInt;
      }
      
      public void setDy(@Px int paramInt)
      {
        this.mChanged = true;
        this.mDy = paramInt;
      }
      
      public void setInterpolator(@Nullable Interpolator paramInterpolator)
      {
        this.mChanged = true;
        this.mInterpolator = paramInterpolator;
      }
      
      public void update(@Px int paramInt1, @Px int paramInt2, int paramInt3, @Nullable Interpolator paramInterpolator)
      {
        this.mDx = paramInt1;
        this.mDy = paramInt2;
        this.mDuration = paramInt3;
        this.mInterpolator = paramInterpolator;
        this.mChanged = true;
      }
    }
    
    public static abstract interface ScrollVectorProvider
    {
      @Nullable
      public abstract PointF computeScrollVectorForPosition(int paramInt);
    }
  }
  
  public static class State
  {
    static final int STEP_ANIMATIONS = 4;
    static final int STEP_LAYOUT = 2;
    static final int STEP_START = 1;
    private SparseArray<Object> mData;
    int mDeletedInvisibleItemCountSincePreviousLayout = 0;
    long mFocusedItemId;
    int mFocusedItemPosition;
    int mFocusedSubChildId;
    boolean mInPreLayout = false;
    boolean mIsMeasuring = false;
    int mItemCount = 0;
    int mLayoutStep = 1;
    int mPreviousLayoutItemCount = 0;
    int mRemainingScrollHorizontal;
    int mRemainingScrollVertical;
    boolean mRunPredictiveAnimations = false;
    boolean mRunSimpleAnimations = false;
    boolean mStructureChanged = false;
    int mTargetPosition = -1;
    boolean mTrackOldChangeHolders = false;
    
    void assertLayoutStep(int paramInt)
    {
      if ((this.mLayoutStep & paramInt) != 0) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Layout state should be one of ");
      localStringBuilder.append(Integer.toBinaryString(paramInt));
      localStringBuilder.append(" but it is ");
      localStringBuilder.append(Integer.toBinaryString(this.mLayoutStep));
      throw new IllegalStateException(localStringBuilder.toString());
    }
    
    public boolean didStructureChange()
    {
      return this.mStructureChanged;
    }
    
    public <T> T get(int paramInt)
    {
      if (this.mData == null) {
        return null;
      }
      return (T)this.mData.get(paramInt);
    }
    
    public int getItemCount()
    {
      if (this.mInPreLayout) {
        return this.mPreviousLayoutItemCount - this.mDeletedInvisibleItemCountSincePreviousLayout;
      }
      return this.mItemCount;
    }
    
    public int getRemainingScrollHorizontal()
    {
      return this.mRemainingScrollHorizontal;
    }
    
    public int getRemainingScrollVertical()
    {
      return this.mRemainingScrollVertical;
    }
    
    public int getTargetScrollPosition()
    {
      return this.mTargetPosition;
    }
    
    public boolean hasTargetScrollPosition()
    {
      return this.mTargetPosition != -1;
    }
    
    public boolean isMeasuring()
    {
      return this.mIsMeasuring;
    }
    
    public boolean isPreLayout()
    {
      return this.mInPreLayout;
    }
    
    void prepareForNestedPrefetch(RecyclerView.Adapter paramAdapter)
    {
      this.mLayoutStep = 1;
      this.mItemCount = paramAdapter.getItemCount();
      this.mInPreLayout = false;
      this.mTrackOldChangeHolders = false;
      this.mIsMeasuring = false;
    }
    
    public void put(int paramInt, Object paramObject)
    {
      if (this.mData == null) {
        this.mData = new SparseArray();
      }
      this.mData.put(paramInt, paramObject);
    }
    
    public void remove(int paramInt)
    {
      if (this.mData == null) {
        return;
      }
      this.mData.remove(paramInt);
    }
    
    State reset()
    {
      this.mTargetPosition = -1;
      if (this.mData != null) {
        this.mData.clear();
      }
      this.mItemCount = 0;
      this.mStructureChanged = false;
      this.mIsMeasuring = false;
      return this;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("State{mTargetPosition=");
      localStringBuilder.append(this.mTargetPosition);
      localStringBuilder.append(", mData=");
      localStringBuilder.append(this.mData);
      localStringBuilder.append(", mItemCount=");
      localStringBuilder.append(this.mItemCount);
      localStringBuilder.append(", mIsMeasuring=");
      localStringBuilder.append(this.mIsMeasuring);
      localStringBuilder.append(", mPreviousLayoutItemCount=");
      localStringBuilder.append(this.mPreviousLayoutItemCount);
      localStringBuilder.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
      localStringBuilder.append(this.mDeletedInvisibleItemCountSincePreviousLayout);
      localStringBuilder.append(", mStructureChanged=");
      localStringBuilder.append(this.mStructureChanged);
      localStringBuilder.append(", mInPreLayout=");
      localStringBuilder.append(this.mInPreLayout);
      localStringBuilder.append(", mRunSimpleAnimations=");
      localStringBuilder.append(this.mRunSimpleAnimations);
      localStringBuilder.append(", mRunPredictiveAnimations=");
      localStringBuilder.append(this.mRunPredictiveAnimations);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
    
    public boolean willRunPredictiveAnimations()
    {
      return this.mRunPredictiveAnimations;
    }
    
    public boolean willRunSimpleAnimations()
    {
      return this.mRunSimpleAnimations;
    }
  }
  
  public static abstract class ViewCacheExtension
  {
    @Nullable
    public abstract View getViewForPositionAndType(@NonNull RecyclerView.Recycler paramRecycler, int paramInt1, int paramInt2);
  }
  
  class ViewFlinger
    implements Runnable
  {
    private boolean mEatRunOnAnimationRequest = false;
    Interpolator mInterpolator = RecyclerView.sQuinticInterpolator;
    private int mLastFlingX;
    private int mLastFlingY;
    private boolean mReSchedulePostAnimationCallback = false;
    OverScroller mScroller = new OverScroller(RecyclerView.this.getContext(), RecyclerView.sQuinticInterpolator);
    
    ViewFlinger() {}
    
    private int computeScrollDuration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      int j = Math.abs(paramInt1);
      int k = Math.abs(paramInt2);
      int i;
      if (j > k) {
        i = 1;
      } else {
        i = 0;
      }
      paramInt3 = (int)Math.sqrt(paramInt3 * paramInt3 + paramInt4 * paramInt4);
      paramInt2 = (int)Math.sqrt(paramInt1 * paramInt1 + paramInt2 * paramInt2);
      if (i != 0) {
        paramInt1 = RecyclerView.this.getWidth();
      } else {
        paramInt1 = RecyclerView.this.getHeight();
      }
      paramInt4 = paramInt1 / 2;
      float f2 = paramInt2;
      float f1 = paramInt1;
      float f3 = Math.min(1.0F, f2 * 1.0F / f1);
      f2 = paramInt4;
      f3 = distanceInfluenceForSnapDuration(f3);
      if (paramInt3 > 0)
      {
        paramInt1 = Math.round(Math.abs((f2 + f3 * f2) / paramInt3) * 1000.0F) * 4;
      }
      else
      {
        if (i != 0) {
          paramInt1 = j;
        } else {
          paramInt1 = k;
        }
        paramInt1 = (int)((paramInt1 / f1 + 1.0F) * 300.0F);
      }
      return Math.min(paramInt1, 2000);
    }
    
    private void disableRunOnAnimationRequests()
    {
      this.mReSchedulePostAnimationCallback = false;
      this.mEatRunOnAnimationRequest = true;
    }
    
    private float distanceInfluenceForSnapDuration(float paramFloat)
    {
      return (float)Math.sin((paramFloat - 0.5F) * 0.47123894F);
    }
    
    private void enableRunOnAnimationRequests()
    {
      this.mEatRunOnAnimationRequest = false;
      if (this.mReSchedulePostAnimationCallback) {
        postOnAnimation();
      }
    }
    
    public void fling(int paramInt1, int paramInt2)
    {
      RecyclerView.this.setScrollState(2);
      this.mLastFlingY = 0;
      this.mLastFlingX = 0;
      this.mScroller.fling(0, 0, paramInt1, paramInt2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
      postOnAnimation();
    }
    
    void postOnAnimation()
    {
      if (this.mEatRunOnAnimationRequest)
      {
        this.mReSchedulePostAnimationCallback = true;
        return;
      }
      RecyclerView.this.removeCallbacks(this);
      ViewCompat.postOnAnimation(RecyclerView.this, this);
    }
    
    public void run()
    {
      if (RecyclerView.this.mLayout == null)
      {
        stop();
        return;
      }
      disableRunOnAnimationRequests();
      RecyclerView.this.consumePendingUpdateOperations();
      OverScroller localOverScroller = this.mScroller;
      RecyclerView.SmoothScroller localSmoothScroller = RecyclerView.this.mLayout.mSmoothScroller;
      if (localOverScroller.computeScrollOffset())
      {
        int[] arrayOfInt = RecyclerView.this.mScrollConsumed;
        int i6 = localOverScroller.getCurrX();
        int i7 = localOverScroller.getCurrY();
        int j = i6 - this.mLastFlingX;
        int i = i7 - this.mLastFlingY;
        this.mLastFlingX = i6;
        this.mLastFlingY = i7;
        int m = j;
        int k = i;
        if (RecyclerView.this.dispatchNestedPreScroll(j, i, arrayOfInt, null, 1))
        {
          m = j - arrayOfInt[0];
          k = i - arrayOfInt[1];
        }
        int n;
        int i3;
        int i2;
        int i1;
        if (RecyclerView.this.mAdapter != null)
        {
          RecyclerView.this.scrollStep(m, k, RecyclerView.this.mScrollStepConsumed);
          i = RecyclerView.this.mScrollStepConsumed[0];
          j = RecyclerView.this.mScrollStepConsumed[1];
          int i4 = m - i;
          int i5 = k - j;
          n = i;
          i3 = j;
          i2 = i4;
          i1 = i5;
          if (localSmoothScroller != null)
          {
            n = i;
            i3 = j;
            i2 = i4;
            i1 = i5;
            if (!localSmoothScroller.isPendingInitialRun())
            {
              n = i;
              i3 = j;
              i2 = i4;
              i1 = i5;
              if (localSmoothScroller.isRunning())
              {
                n = RecyclerView.this.mState.getItemCount();
                if (n == 0)
                {
                  localSmoothScroller.stop();
                  n = i;
                  i3 = j;
                  i2 = i4;
                  i1 = i5;
                }
                else if (localSmoothScroller.getTargetPosition() >= n)
                {
                  localSmoothScroller.setTargetPosition(n - 1);
                  localSmoothScroller.onAnimation(m - i4, k - i5);
                  n = i;
                  i3 = j;
                  i2 = i4;
                  i1 = i5;
                }
                else
                {
                  localSmoothScroller.onAnimation(m - i4, k - i5);
                  n = i;
                  i3 = j;
                  i2 = i4;
                  i1 = i5;
                }
              }
            }
          }
        }
        else
        {
          n = 0;
          i3 = 0;
          i2 = 0;
          i1 = 0;
        }
        if (!RecyclerView.this.mItemDecorations.isEmpty()) {
          RecyclerView.this.invalidate();
        }
        if (RecyclerView.this.getOverScrollMode() != 2) {
          RecyclerView.this.considerReleasingGlowsOnScroll(m, k);
        }
        if ((!RecyclerView.this.dispatchNestedScroll(n, i3, i2, i1, null, 1)) && ((i2 != 0) || (i1 != 0)))
        {
          j = (int)localOverScroller.getCurrVelocity();
          if (i2 != i6)
          {
            if (i2 < 0)
            {
              i = -j;
              break label500;
            }
            if (i2 > 0)
            {
              i = j;
              break label500;
            }
          }
          i = 0;
          label500:
          if (i1 != i7)
          {
            if (i1 < 0) {
              j = -j;
            } else if (i1 > 0) {}
          }
          else {
            j = 0;
          }
          if (RecyclerView.this.getOverScrollMode() != 2) {
            RecyclerView.this.absorbGlows(i, j);
          }
          if (((i != 0) || (i2 == i6) || (localOverScroller.getFinalX() == 0)) && ((j != 0) || (i1 == i7) || (localOverScroller.getFinalY() == 0))) {
            localOverScroller.abortAnimation();
          }
        }
        if ((n != 0) || (i3 != 0)) {
          RecyclerView.this.dispatchOnScrolled(n, i3);
        }
        if (!RecyclerView.this.awakenScrollBars()) {
          RecyclerView.this.invalidate();
        }
        if ((k != 0) && (RecyclerView.this.mLayout.canScrollVertically()) && (i3 == k)) {
          i = 1;
        } else {
          i = 0;
        }
        if ((m != 0) && (RecyclerView.this.mLayout.canScrollHorizontally()) && (n == m)) {
          j = 1;
        } else {
          j = 0;
        }
        if (((m != 0) || (k != 0)) && (j == 0) && (i == 0)) {
          i = 0;
        } else {
          i = 1;
        }
        if ((!localOverScroller.isFinished()) && ((i != 0) || (RecyclerView.this.hasNestedScrollingParent(1))))
        {
          postOnAnimation();
          if (RecyclerView.this.mGapWorker != null) {
            RecyclerView.this.mGapWorker.postFromTraversal(RecyclerView.this, m, k);
          }
        }
        else
        {
          RecyclerView.this.setScrollState(0);
          if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
            RecyclerView.this.mPrefetchRegistry.clearPrefetchPositions();
          }
          RecyclerView.this.stopNestedScroll(1);
        }
      }
      if (localSmoothScroller != null)
      {
        if (localSmoothScroller.isPendingInitialRun()) {
          localSmoothScroller.onAnimation(0, 0);
        }
        if (!this.mReSchedulePostAnimationCallback) {
          localSmoothScroller.stop();
        }
      }
      enableRunOnAnimationRequests();
    }
    
    public void smoothScrollBy(int paramInt1, int paramInt2)
    {
      smoothScrollBy(paramInt1, paramInt2, 0, 0);
    }
    
    public void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3)
    {
      smoothScrollBy(paramInt1, paramInt2, paramInt3, RecyclerView.sQuinticInterpolator);
    }
    
    public void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      smoothScrollBy(paramInt1, paramInt2, computeScrollDuration(paramInt1, paramInt2, paramInt3, paramInt4));
    }
    
    public void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
    {
      if (this.mInterpolator != paramInterpolator)
      {
        this.mInterpolator = paramInterpolator;
        this.mScroller = new OverScroller(RecyclerView.this.getContext(), paramInterpolator);
      }
      RecyclerView.this.setScrollState(2);
      this.mLastFlingY = 0;
      this.mLastFlingX = 0;
      this.mScroller.startScroll(0, 0, paramInt1, paramInt2, paramInt3);
      if (Build.VERSION.SDK_INT < 23) {
        this.mScroller.computeScrollOffset();
      }
      postOnAnimation();
    }
    
    public void smoothScrollBy(int paramInt1, int paramInt2, Interpolator paramInterpolator)
    {
      int i = computeScrollDuration(paramInt1, paramInt2, 0, 0);
      Interpolator localInterpolator = paramInterpolator;
      if (paramInterpolator == null) {
        localInterpolator = RecyclerView.sQuinticInterpolator;
      }
      smoothScrollBy(paramInt1, paramInt2, i, localInterpolator);
    }
    
    public void stop()
    {
      RecyclerView.this.removeCallbacks(this);
      this.mScroller.abortAnimation();
    }
  }
  
  public static abstract class ViewHolder
  {
    static final int FLAG_ADAPTER_FULLUPDATE = 1024;
    static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
    static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
    static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
    static final int FLAG_BOUND = 1;
    static final int FLAG_IGNORE = 128;
    static final int FLAG_INVALID = 4;
    static final int FLAG_MOVED = 2048;
    static final int FLAG_NOT_RECYCLABLE = 16;
    static final int FLAG_REMOVED = 8;
    static final int FLAG_RETURNED_FROM_SCRAP = 32;
    static final int FLAG_SET_A11Y_ITEM_DELEGATE = 16384;
    static final int FLAG_TMP_DETACHED = 256;
    static final int FLAG_UPDATE = 2;
    private static final List<Object> FULLUPDATE_PAYLOADS = ;
    static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
    @NonNull
    public final View itemView;
    int mFlags;
    boolean mInChangeScrap = false;
    private int mIsRecyclableCount = 0;
    long mItemId = -1L;
    int mItemViewType = -1;
    WeakReference<RecyclerView> mNestedRecyclerView;
    int mOldPosition = -1;
    RecyclerView mOwnerRecyclerView;
    List<Object> mPayloads = null;
    @VisibleForTesting
    int mPendingAccessibilityState = -1;
    int mPosition = -1;
    int mPreLayoutPosition = -1;
    RecyclerView.Recycler mScrapContainer = null;
    ViewHolder mShadowedHolder = null;
    ViewHolder mShadowingHolder = null;
    List<Object> mUnmodifiedPayloads = null;
    private int mWasImportantForAccessibilityBeforeHidden = 0;
    
    public ViewHolder(@NonNull View paramView)
    {
      if (paramView != null)
      {
        this.itemView = paramView;
        return;
      }
      throw new IllegalArgumentException("itemView may not be null");
    }
    
    private void createPayloadsIfNeeded()
    {
      if (this.mPayloads == null)
      {
        this.mPayloads = new ArrayList();
        this.mUnmodifiedPayloads = Collections.unmodifiableList(this.mPayloads);
      }
    }
    
    void addChangePayload(Object paramObject)
    {
      if (paramObject == null)
      {
        addFlags(1024);
        return;
      }
      if ((0x400 & this.mFlags) == 0)
      {
        createPayloadsIfNeeded();
        this.mPayloads.add(paramObject);
      }
    }
    
    void addFlags(int paramInt)
    {
      this.mFlags = (paramInt | this.mFlags);
    }
    
    void clearOldPosition()
    {
      this.mOldPosition = -1;
      this.mPreLayoutPosition = -1;
    }
    
    void clearPayload()
    {
      if (this.mPayloads != null) {
        this.mPayloads.clear();
      }
      this.mFlags &= 0xFBFF;
    }
    
    void clearReturnedFromScrapFlag()
    {
      this.mFlags &= 0xFFFFFFDF;
    }
    
    void clearTmpDetachFlag()
    {
      this.mFlags &= 0xFEFF;
    }
    
    boolean doesTransientStatePreventRecycling()
    {
      return ((this.mFlags & 0x10) == 0) && (ViewCompat.hasTransientState(this.itemView));
    }
    
    void flagRemovedAndOffsetPosition(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      addFlags(8);
      offsetPosition(paramInt2, paramBoolean);
      this.mPosition = paramInt1;
    }
    
    public final int getAdapterPosition()
    {
      if (this.mOwnerRecyclerView == null) {
        return -1;
      }
      return this.mOwnerRecyclerView.getAdapterPositionFor(this);
    }
    
    public final long getItemId()
    {
      return this.mItemId;
    }
    
    public final int getItemViewType()
    {
      return this.mItemViewType;
    }
    
    public final int getLayoutPosition()
    {
      if (this.mPreLayoutPosition == -1) {
        return this.mPosition;
      }
      return this.mPreLayoutPosition;
    }
    
    public final int getOldPosition()
    {
      return this.mOldPosition;
    }
    
    @Deprecated
    public final int getPosition()
    {
      if (this.mPreLayoutPosition == -1) {
        return this.mPosition;
      }
      return this.mPreLayoutPosition;
    }
    
    List<Object> getUnmodifiedPayloads()
    {
      if ((this.mFlags & 0x400) == 0)
      {
        if ((this.mPayloads != null) && (this.mPayloads.size() != 0)) {
          return this.mUnmodifiedPayloads;
        }
        return FULLUPDATE_PAYLOADS;
      }
      return FULLUPDATE_PAYLOADS;
    }
    
    boolean hasAnyOfTheFlags(int paramInt)
    {
      return (paramInt & this.mFlags) != 0;
    }
    
    boolean isAdapterPositionUnknown()
    {
      return ((this.mFlags & 0x200) != 0) || (isInvalid());
    }
    
    boolean isBound()
    {
      return (this.mFlags & 0x1) != 0;
    }
    
    boolean isInvalid()
    {
      return (this.mFlags & 0x4) != 0;
    }
    
    public final boolean isRecyclable()
    {
      return ((this.mFlags & 0x10) == 0) && (!ViewCompat.hasTransientState(this.itemView));
    }
    
    boolean isRemoved()
    {
      return (this.mFlags & 0x8) != 0;
    }
    
    boolean isScrap()
    {
      return this.mScrapContainer != null;
    }
    
    boolean isTmpDetached()
    {
      return (this.mFlags & 0x100) != 0;
    }
    
    boolean isUpdated()
    {
      return (this.mFlags & 0x2) != 0;
    }
    
    boolean needsUpdate()
    {
      return (this.mFlags & 0x2) != 0;
    }
    
    void offsetPosition(int paramInt, boolean paramBoolean)
    {
      if (this.mOldPosition == -1) {
        this.mOldPosition = this.mPosition;
      }
      if (this.mPreLayoutPosition == -1) {
        this.mPreLayoutPosition = this.mPosition;
      }
      if (paramBoolean) {
        this.mPreLayoutPosition += paramInt;
      }
      this.mPosition += paramInt;
      if (this.itemView.getLayoutParams() != null) {
        ((RecyclerView.LayoutParams)this.itemView.getLayoutParams()).mInsetsDirty = true;
      }
    }
    
    void onEnteredHiddenState(RecyclerView paramRecyclerView)
    {
      if (this.mPendingAccessibilityState != -1) {
        this.mWasImportantForAccessibilityBeforeHidden = this.mPendingAccessibilityState;
      } else {
        this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.getImportantForAccessibility(this.itemView);
      }
      paramRecyclerView.setChildImportantForAccessibilityInternal(this, 4);
    }
    
    void onLeftHiddenState(RecyclerView paramRecyclerView)
    {
      paramRecyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
      this.mWasImportantForAccessibilityBeforeHidden = 0;
    }
    
    void resetInternal()
    {
      this.mFlags = 0;
      this.mPosition = -1;
      this.mOldPosition = -1;
      this.mItemId = -1L;
      this.mPreLayoutPosition = -1;
      this.mIsRecyclableCount = 0;
      this.mShadowedHolder = null;
      this.mShadowingHolder = null;
      clearPayload();
      this.mWasImportantForAccessibilityBeforeHidden = 0;
      this.mPendingAccessibilityState = -1;
      RecyclerView.clearNestedRecyclerViewIfNotNested(this);
    }
    
    void saveOldPosition()
    {
      if (this.mOldPosition == -1) {
        this.mOldPosition = this.mPosition;
      }
    }
    
    void setFlags(int paramInt1, int paramInt2)
    {
      this.mFlags = (paramInt1 & paramInt2 | this.mFlags & (paramInt2 ^ 0xFFFFFFFF));
    }
    
    public final void setIsRecyclable(boolean paramBoolean)
    {
      int i;
      if (paramBoolean) {
        i = this.mIsRecyclableCount - 1;
      } else {
        i = this.mIsRecyclableCount + 1;
      }
      this.mIsRecyclableCount = i;
      if (this.mIsRecyclableCount < 0)
      {
        this.mIsRecyclableCount = 0;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ");
        localStringBuilder.append(this);
        Log.e("View", localStringBuilder.toString());
        return;
      }
      if ((!paramBoolean) && (this.mIsRecyclableCount == 1))
      {
        this.mFlags |= 0x10;
        return;
      }
      if ((paramBoolean) && (this.mIsRecyclableCount == 0)) {
        this.mFlags &= 0xFFFFFFEF;
      }
    }
    
    void setScrapContainer(RecyclerView.Recycler paramRecycler, boolean paramBoolean)
    {
      this.mScrapContainer = paramRecycler;
      this.mInChangeScrap = paramBoolean;
    }
    
    boolean shouldBeKeptAsChild()
    {
      return (this.mFlags & 0x10) != 0;
    }
    
    boolean shouldIgnore()
    {
      return (this.mFlags & 0x80) != 0;
    }
    
    void stopIgnoring()
    {
      this.mFlags &= 0xFF7F;
    }
    
    public String toString()
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ViewHolder{");
      ((StringBuilder)localObject).append(Integer.toHexString(hashCode()));
      ((StringBuilder)localObject).append(" position=");
      ((StringBuilder)localObject).append(this.mPosition);
      ((StringBuilder)localObject).append(" id=");
      ((StringBuilder)localObject).append(this.mItemId);
      ((StringBuilder)localObject).append(", oldPos=");
      ((StringBuilder)localObject).append(this.mOldPosition);
      ((StringBuilder)localObject).append(", pLpos:");
      ((StringBuilder)localObject).append(this.mPreLayoutPosition);
      StringBuilder localStringBuilder = new StringBuilder(((StringBuilder)localObject).toString());
      if (isScrap())
      {
        localStringBuilder.append(" scrap ");
        if (this.mInChangeScrap) {
          localObject = "[changeScrap]";
        } else {
          localObject = "[attachedScrap]";
        }
        localStringBuilder.append((String)localObject);
      }
      if (isInvalid()) {
        localStringBuilder.append(" invalid");
      }
      if (!isBound()) {
        localStringBuilder.append(" unbound");
      }
      if (needsUpdate()) {
        localStringBuilder.append(" update");
      }
      if (isRemoved()) {
        localStringBuilder.append(" removed");
      }
      if (shouldIgnore()) {
        localStringBuilder.append(" ignored");
      }
      if (isTmpDetached()) {
        localStringBuilder.append(" tmpDetached");
      }
      if (!isRecyclable())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" not recyclable(");
        ((StringBuilder)localObject).append(this.mIsRecyclableCount);
        ((StringBuilder)localObject).append(")");
        localStringBuilder.append(((StringBuilder)localObject).toString());
      }
      if (isAdapterPositionUnknown()) {
        localStringBuilder.append(" undefined adapter position");
      }
      if (this.itemView.getParent() == null) {
        localStringBuilder.append(" no parent");
      }
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    
    void unScrap()
    {
      this.mScrapContainer.unscrapView(this);
    }
    
    boolean wasReturnedFromScrap()
    {
      return (this.mFlags & 0x20) != 0;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\widget\RecyclerView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */