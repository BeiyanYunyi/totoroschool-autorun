package android.support.v7.widget.helper;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.recyclerview.R.dimen;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ChildDrawingOrderCallback;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnChildAttachStateChangeListener;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

public class ItemTouchHelper
  extends RecyclerView.ItemDecoration
  implements RecyclerView.OnChildAttachStateChangeListener
{
  static final int ACTION_MODE_DRAG_MASK = 16711680;
  private static final int ACTION_MODE_IDLE_MASK = 255;
  static final int ACTION_MODE_SWIPE_MASK = 65280;
  public static final int ACTION_STATE_DRAG = 2;
  public static final int ACTION_STATE_IDLE = 0;
  public static final int ACTION_STATE_SWIPE = 1;
  private static final int ACTIVE_POINTER_ID_NONE = -1;
  public static final int ANIMATION_TYPE_DRAG = 8;
  public static final int ANIMATION_TYPE_SWIPE_CANCEL = 4;
  public static final int ANIMATION_TYPE_SWIPE_SUCCESS = 2;
  private static final boolean DEBUG = false;
  static final int DIRECTION_FLAG_COUNT = 8;
  public static final int DOWN = 2;
  public static final int END = 32;
  public static final int LEFT = 4;
  private static final int PIXELS_PER_SECOND = 1000;
  public static final int RIGHT = 8;
  public static final int START = 16;
  private static final String TAG = "ItemTouchHelper";
  public static final int UP = 1;
  private int mActionState = 0;
  int mActivePointerId = -1;
  @NonNull
  Callback mCallback;
  private RecyclerView.ChildDrawingOrderCallback mChildDrawingOrderCallback = null;
  private List<Integer> mDistances;
  private long mDragScrollStartTimeInMs;
  float mDx;
  float mDy;
  GestureDetectorCompat mGestureDetector;
  float mInitialTouchX;
  float mInitialTouchY;
  private ItemTouchHelperGestureListener mItemTouchHelperGestureListener;
  private float mMaxSwipeVelocity;
  private final RecyclerView.OnItemTouchListener mOnItemTouchListener = new RecyclerView.OnItemTouchListener()
  {
    public boolean onInterceptTouchEvent(@NonNull RecyclerView paramAnonymousRecyclerView, @NonNull MotionEvent paramAnonymousMotionEvent)
    {
      ItemTouchHelper.this.mGestureDetector.onTouchEvent(paramAnonymousMotionEvent);
      int i = paramAnonymousMotionEvent.getActionMasked();
      if (i == 0)
      {
        ItemTouchHelper.this.mActivePointerId = paramAnonymousMotionEvent.getPointerId(0);
        ItemTouchHelper.this.mInitialTouchX = paramAnonymousMotionEvent.getX();
        ItemTouchHelper.this.mInitialTouchY = paramAnonymousMotionEvent.getY();
        ItemTouchHelper.this.obtainVelocityTracker();
        if (ItemTouchHelper.this.mSelected == null)
        {
          paramAnonymousRecyclerView = ItemTouchHelper.this.findAnimation(paramAnonymousMotionEvent);
          if (paramAnonymousRecyclerView != null)
          {
            ItemTouchHelper localItemTouchHelper = ItemTouchHelper.this;
            localItemTouchHelper.mInitialTouchX -= paramAnonymousRecyclerView.mX;
            localItemTouchHelper = ItemTouchHelper.this;
            localItemTouchHelper.mInitialTouchY -= paramAnonymousRecyclerView.mY;
            ItemTouchHelper.this.endRecoverAnimation(paramAnonymousRecyclerView.mViewHolder, true);
            if (ItemTouchHelper.this.mPendingCleanup.remove(paramAnonymousRecyclerView.mViewHolder.itemView)) {
              ItemTouchHelper.this.mCallback.clearView(ItemTouchHelper.this.mRecyclerView, paramAnonymousRecyclerView.mViewHolder);
            }
            ItemTouchHelper.this.select(paramAnonymousRecyclerView.mViewHolder, paramAnonymousRecyclerView.mActionState);
            ItemTouchHelper.this.updateDxDy(paramAnonymousMotionEvent, ItemTouchHelper.this.mSelectedFlags, 0);
          }
        }
      }
      else if ((i != 3) && (i != 1))
      {
        if (ItemTouchHelper.this.mActivePointerId != -1)
        {
          int j = paramAnonymousMotionEvent.findPointerIndex(ItemTouchHelper.this.mActivePointerId);
          if (j >= 0) {
            ItemTouchHelper.this.checkSelectForSwipe(i, paramAnonymousMotionEvent, j);
          }
        }
      }
      else
      {
        ItemTouchHelper.this.mActivePointerId = -1;
        ItemTouchHelper.this.select(null, 0);
      }
      if (ItemTouchHelper.this.mVelocityTracker != null) {
        ItemTouchHelper.this.mVelocityTracker.addMovement(paramAnonymousMotionEvent);
      }
      return ItemTouchHelper.this.mSelected != null;
    }
    
    public void onRequestDisallowInterceptTouchEvent(boolean paramAnonymousBoolean)
    {
      if (!paramAnonymousBoolean) {
        return;
      }
      ItemTouchHelper.this.select(null, 0);
    }
    
    public void onTouchEvent(@NonNull RecyclerView paramAnonymousRecyclerView, @NonNull MotionEvent paramAnonymousMotionEvent)
    {
      ItemTouchHelper.this.mGestureDetector.onTouchEvent(paramAnonymousMotionEvent);
      if (ItemTouchHelper.this.mVelocityTracker != null) {
        ItemTouchHelper.this.mVelocityTracker.addMovement(paramAnonymousMotionEvent);
      }
      if (ItemTouchHelper.this.mActivePointerId == -1) {
        return;
      }
      int j = paramAnonymousMotionEvent.getActionMasked();
      int k = paramAnonymousMotionEvent.findPointerIndex(ItemTouchHelper.this.mActivePointerId);
      if (k >= 0) {
        ItemTouchHelper.this.checkSelectForSwipe(j, paramAnonymousMotionEvent, k);
      }
      paramAnonymousRecyclerView = ItemTouchHelper.this.mSelected;
      if (paramAnonymousRecyclerView == null) {
        return;
      }
      int i = 0;
      if (j != 6)
      {
        switch (j)
        {
        default: 
          return;
        case 3: 
          if (ItemTouchHelper.this.mVelocityTracker != null) {
            ItemTouchHelper.this.mVelocityTracker.clear();
          }
          break;
        case 2: 
          if (k < 0) {
            return;
          }
          ItemTouchHelper.this.updateDxDy(paramAnonymousMotionEvent, ItemTouchHelper.this.mSelectedFlags, k);
          ItemTouchHelper.this.moveIfNecessary(paramAnonymousRecyclerView);
          ItemTouchHelper.this.mRecyclerView.removeCallbacks(ItemTouchHelper.this.mScrollRunnable);
          ItemTouchHelper.this.mScrollRunnable.run();
          ItemTouchHelper.this.mRecyclerView.invalidate();
          return;
        }
        ItemTouchHelper.this.select(null, 0);
        ItemTouchHelper.this.mActivePointerId = -1;
        return;
      }
      j = paramAnonymousMotionEvent.getActionIndex();
      if (paramAnonymousMotionEvent.getPointerId(j) == ItemTouchHelper.this.mActivePointerId)
      {
        if (j == 0) {
          i = 1;
        }
        ItemTouchHelper.this.mActivePointerId = paramAnonymousMotionEvent.getPointerId(i);
        ItemTouchHelper.this.updateDxDy(paramAnonymousMotionEvent, ItemTouchHelper.this.mSelectedFlags, j);
      }
    }
  };
  View mOverdrawChild = null;
  int mOverdrawChildPosition = -1;
  final List<View> mPendingCleanup = new ArrayList();
  List<RecoverAnimation> mRecoverAnimations = new ArrayList();
  RecyclerView mRecyclerView;
  final Runnable mScrollRunnable = new Runnable()
  {
    public void run()
    {
      if ((ItemTouchHelper.this.mSelected != null) && (ItemTouchHelper.this.scrollIfNecessary()))
      {
        if (ItemTouchHelper.this.mSelected != null) {
          ItemTouchHelper.this.moveIfNecessary(ItemTouchHelper.this.mSelected);
        }
        ItemTouchHelper.this.mRecyclerView.removeCallbacks(ItemTouchHelper.this.mScrollRunnable);
        ViewCompat.postOnAnimation(ItemTouchHelper.this.mRecyclerView, this);
      }
    }
  };
  RecyclerView.ViewHolder mSelected = null;
  int mSelectedFlags;
  private float mSelectedStartX;
  private float mSelectedStartY;
  private int mSlop;
  private List<RecyclerView.ViewHolder> mSwapTargets;
  private float mSwipeEscapeVelocity;
  private final float[] mTmpPosition = new float[2];
  private Rect mTmpRect;
  VelocityTracker mVelocityTracker;
  
  public ItemTouchHelper(@NonNull Callback paramCallback)
  {
    this.mCallback = paramCallback;
  }
  
  private void addChildDrawingOrderCallback()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return;
    }
    if (this.mChildDrawingOrderCallback == null) {
      this.mChildDrawingOrderCallback = new RecyclerView.ChildDrawingOrderCallback()
      {
        public int onGetChildDrawingOrder(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          if (ItemTouchHelper.this.mOverdrawChild == null) {
            return paramAnonymousInt2;
          }
          int j = ItemTouchHelper.this.mOverdrawChildPosition;
          int i = j;
          if (j == -1)
          {
            i = ItemTouchHelper.this.mRecyclerView.indexOfChild(ItemTouchHelper.this.mOverdrawChild);
            ItemTouchHelper.this.mOverdrawChildPosition = i;
          }
          if (paramAnonymousInt2 == paramAnonymousInt1 - 1) {
            return i;
          }
          if (paramAnonymousInt2 < i) {
            return paramAnonymousInt2;
          }
          return paramAnonymousInt2 + 1;
        }
      };
    }
    this.mRecyclerView.setChildDrawingOrderCallback(this.mChildDrawingOrderCallback);
  }
  
  private int checkHorizontalSwipe(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramInt & 0xC) != 0)
    {
      float f1 = this.mDx;
      int j = 4;
      int i;
      if (f1 > 0.0F) {
        i = 8;
      } else {
        i = 4;
      }
      if ((this.mVelocityTracker != null) && (this.mActivePointerId > -1))
      {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
        f2 = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
        f1 = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
        if (f2 > 0.0F) {
          j = 8;
        }
        f2 = Math.abs(f2);
        if (((j & paramInt) != 0) && (i == j) && (f2 >= this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity)) && (f2 > Math.abs(f1))) {
          return j;
        }
      }
      f1 = this.mRecyclerView.getWidth();
      float f2 = this.mCallback.getSwipeThreshold(paramViewHolder);
      if (((paramInt & i) != 0) && (Math.abs(this.mDx) > f1 * f2)) {
        return i;
      }
    }
    return 0;
  }
  
  private int checkVerticalSwipe(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramInt & 0x3) != 0)
    {
      float f1 = this.mDy;
      int j = 1;
      int i;
      if (f1 > 0.0F) {
        i = 2;
      } else {
        i = 1;
      }
      if ((this.mVelocityTracker != null) && (this.mActivePointerId > -1))
      {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mCallback.getSwipeVelocityThreshold(this.mMaxSwipeVelocity));
        f1 = this.mVelocityTracker.getXVelocity(this.mActivePointerId);
        f2 = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
        if (f2 > 0.0F) {
          j = 2;
        }
        f2 = Math.abs(f2);
        if (((j & paramInt) != 0) && (j == i) && (f2 >= this.mCallback.getSwipeEscapeVelocity(this.mSwipeEscapeVelocity)) && (f2 > Math.abs(f1))) {
          return j;
        }
      }
      f1 = this.mRecyclerView.getHeight();
      float f2 = this.mCallback.getSwipeThreshold(paramViewHolder);
      if (((paramInt & i) != 0) && (Math.abs(this.mDy) > f1 * f2)) {
        return i;
      }
    }
    return 0;
  }
  
  private void destroyCallbacks()
  {
    this.mRecyclerView.removeItemDecoration(this);
    this.mRecyclerView.removeOnItemTouchListener(this.mOnItemTouchListener);
    this.mRecyclerView.removeOnChildAttachStateChangeListener(this);
    int i = this.mRecoverAnimations.size() - 1;
    while (i >= 0)
    {
      RecoverAnimation localRecoverAnimation = (RecoverAnimation)this.mRecoverAnimations.get(0);
      this.mCallback.clearView(this.mRecyclerView, localRecoverAnimation.mViewHolder);
      i -= 1;
    }
    this.mRecoverAnimations.clear();
    this.mOverdrawChild = null;
    this.mOverdrawChildPosition = -1;
    releaseVelocityTracker();
    stopGestureDetection();
  }
  
  private List<RecyclerView.ViewHolder> findSwapTargets(RecyclerView.ViewHolder paramViewHolder)
  {
    Object localObject = paramViewHolder;
    if (this.mSwapTargets == null)
    {
      this.mSwapTargets = new ArrayList();
      this.mDistances = new ArrayList();
    }
    else
    {
      this.mSwapTargets.clear();
      this.mDistances.clear();
    }
    int j = this.mCallback.getBoundingBoxMargin();
    int m = Math.round(this.mSelectedStartX + this.mDx) - j;
    int n = Math.round(this.mSelectedStartY + this.mDy) - j;
    int i = ((RecyclerView.ViewHolder)localObject).itemView.getWidth();
    j *= 2;
    int i1 = i + m + j;
    int i2 = ((RecyclerView.ViewHolder)localObject).itemView.getHeight() + n + j;
    int i3 = (m + i1) / 2;
    int i4 = (n + i2) / 2;
    localObject = this.mRecyclerView.getLayoutManager();
    int i5 = ((RecyclerView.LayoutManager)localObject).getChildCount();
    i = 0;
    while (i < i5)
    {
      View localView = ((RecyclerView.LayoutManager)localObject).getChildAt(i);
      if ((localView != paramViewHolder.itemView) && (localView.getBottom() >= n) && (localView.getTop() <= i2) && (localView.getRight() >= m) && (localView.getLeft() <= i1))
      {
        RecyclerView.ViewHolder localViewHolder = this.mRecyclerView.getChildViewHolder(localView);
        if (this.mCallback.canDropOver(this.mRecyclerView, this.mSelected, localViewHolder))
        {
          j = Math.abs(i3 - (localView.getLeft() + localView.getRight()) / 2);
          int k = Math.abs(i4 - (localView.getTop() + localView.getBottom()) / 2);
          int i6 = j * j + k * k;
          int i7 = this.mSwapTargets.size();
          j = 0;
          k = 0;
          while ((j < i7) && (i6 > ((Integer)this.mDistances.get(j)).intValue()))
          {
            k += 1;
            j += 1;
          }
          this.mSwapTargets.add(k, localViewHolder);
          this.mDistances.add(k, Integer.valueOf(i6));
        }
      }
      i += 1;
    }
    return this.mSwapTargets;
  }
  
  private RecyclerView.ViewHolder findSwipedView(MotionEvent paramMotionEvent)
  {
    RecyclerView.LayoutManager localLayoutManager = this.mRecyclerView.getLayoutManager();
    if (this.mActivePointerId == -1) {
      return null;
    }
    int i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
    float f3 = paramMotionEvent.getX(i);
    float f4 = this.mInitialTouchX;
    float f1 = paramMotionEvent.getY(i);
    float f2 = this.mInitialTouchY;
    f3 = Math.abs(f3 - f4);
    f1 = Math.abs(f1 - f2);
    if ((f3 < this.mSlop) && (f1 < this.mSlop)) {
      return null;
    }
    if ((f3 > f1) && (localLayoutManager.canScrollHorizontally())) {
      return null;
    }
    if ((f1 > f3) && (localLayoutManager.canScrollVertically())) {
      return null;
    }
    paramMotionEvent = findChildView(paramMotionEvent);
    if (paramMotionEvent == null) {
      return null;
    }
    return this.mRecyclerView.getChildViewHolder(paramMotionEvent);
  }
  
  private void getSelectedDxDy(float[] paramArrayOfFloat)
  {
    if ((this.mSelectedFlags & 0xC) != 0) {
      paramArrayOfFloat[0] = (this.mSelectedStartX + this.mDx - this.mSelected.itemView.getLeft());
    } else {
      paramArrayOfFloat[0] = this.mSelected.itemView.getTranslationX();
    }
    if ((this.mSelectedFlags & 0x3) != 0)
    {
      paramArrayOfFloat[1] = (this.mSelectedStartY + this.mDy - this.mSelected.itemView.getTop());
      return;
    }
    paramArrayOfFloat[1] = this.mSelected.itemView.getTranslationY();
  }
  
  private static boolean hitTest(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return (paramFloat1 >= paramFloat3) && (paramFloat1 <= paramFloat3 + paramView.getWidth()) && (paramFloat2 >= paramFloat4) && (paramFloat2 <= paramFloat4 + paramView.getHeight());
  }
  
  private void releaseVelocityTracker()
  {
    if (this.mVelocityTracker != null)
    {
      this.mVelocityTracker.recycle();
      this.mVelocityTracker = null;
    }
  }
  
  private void setupCallbacks()
  {
    this.mSlop = ViewConfiguration.get(this.mRecyclerView.getContext()).getScaledTouchSlop();
    this.mRecyclerView.addItemDecoration(this);
    this.mRecyclerView.addOnItemTouchListener(this.mOnItemTouchListener);
    this.mRecyclerView.addOnChildAttachStateChangeListener(this);
    startGestureDetection();
  }
  
  private void startGestureDetection()
  {
    this.mItemTouchHelperGestureListener = new ItemTouchHelperGestureListener();
    this.mGestureDetector = new GestureDetectorCompat(this.mRecyclerView.getContext(), this.mItemTouchHelperGestureListener);
  }
  
  private void stopGestureDetection()
  {
    if (this.mItemTouchHelperGestureListener != null)
    {
      this.mItemTouchHelperGestureListener.doNotReactToLongPress();
      this.mItemTouchHelperGestureListener = null;
    }
    if (this.mGestureDetector != null) {
      this.mGestureDetector = null;
    }
  }
  
  private int swipeIfNecessary(RecyclerView.ViewHolder paramViewHolder)
  {
    if (this.mActionState == 2) {
      return 0;
    }
    int j = this.mCallback.getMovementFlags(this.mRecyclerView, paramViewHolder);
    int i = (this.mCallback.convertToAbsoluteDirection(j, ViewCompat.getLayoutDirection(this.mRecyclerView)) & 0xFF00) >> 8;
    if (i == 0) {
      return 0;
    }
    j = (j & 0xFF00) >> 8;
    int k;
    if (Math.abs(this.mDx) > Math.abs(this.mDy))
    {
      k = checkHorizontalSwipe(paramViewHolder, i);
      if (k > 0)
      {
        if ((j & k) == 0) {
          return Callback.convertToRelativeDirection(k, ViewCompat.getLayoutDirection(this.mRecyclerView));
        }
        return k;
      }
      i = checkVerticalSwipe(paramViewHolder, i);
      if (i > 0) {
        return i;
      }
    }
    else
    {
      k = checkVerticalSwipe(paramViewHolder, i);
      if (k > 0) {
        return k;
      }
      i = checkHorizontalSwipe(paramViewHolder, i);
      if (i > 0)
      {
        if ((j & i) == 0) {
          return Callback.convertToRelativeDirection(i, ViewCompat.getLayoutDirection(this.mRecyclerView));
        }
        return i;
      }
    }
    return 0;
  }
  
  public void attachToRecyclerView(@Nullable RecyclerView paramRecyclerView)
  {
    if (this.mRecyclerView == paramRecyclerView) {
      return;
    }
    if (this.mRecyclerView != null) {
      destroyCallbacks();
    }
    this.mRecyclerView = paramRecyclerView;
    if (paramRecyclerView != null)
    {
      paramRecyclerView = paramRecyclerView.getResources();
      this.mSwipeEscapeVelocity = paramRecyclerView.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
      this.mMaxSwipeVelocity = paramRecyclerView.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
      setupCallbacks();
    }
  }
  
  void checkSelectForSwipe(int paramInt1, MotionEvent paramMotionEvent, int paramInt2)
  {
    if ((this.mSelected == null) && (paramInt1 == 2) && (this.mActionState != 2))
    {
      if (!this.mCallback.isItemViewSwipeEnabled()) {
        return;
      }
      if (this.mRecyclerView.getScrollState() == 1) {
        return;
      }
      RecyclerView.ViewHolder localViewHolder = findSwipedView(paramMotionEvent);
      if (localViewHolder == null) {
        return;
      }
      paramInt1 = (this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, localViewHolder) & 0xFF00) >> 8;
      if (paramInt1 == 0) {
        return;
      }
      float f1 = paramMotionEvent.getX(paramInt2);
      float f2 = paramMotionEvent.getY(paramInt2);
      f1 -= this.mInitialTouchX;
      f2 -= this.mInitialTouchY;
      float f3 = Math.abs(f1);
      float f4 = Math.abs(f2);
      if ((f3 < this.mSlop) && (f4 < this.mSlop)) {
        return;
      }
      if (f3 > f4)
      {
        if ((f1 < 0.0F) && ((paramInt1 & 0x4) == 0)) {
          return;
        }
        if ((f1 <= 0.0F) || ((paramInt1 & 0x8) != 0)) {}
      }
      else
      {
        if ((f2 < 0.0F) && ((paramInt1 & 0x1) == 0)) {
          return;
        }
        if ((f2 > 0.0F) && ((paramInt1 & 0x2) == 0)) {
          return;
        }
      }
      this.mDy = 0.0F;
      this.mDx = 0.0F;
      this.mActivePointerId = paramMotionEvent.getPointerId(0);
      select(localViewHolder, 1);
      return;
    }
  }
  
  void endRecoverAnimation(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    int i = this.mRecoverAnimations.size() - 1;
    while (i >= 0)
    {
      RecoverAnimation localRecoverAnimation = (RecoverAnimation)this.mRecoverAnimations.get(i);
      if (localRecoverAnimation.mViewHolder == paramViewHolder)
      {
        localRecoverAnimation.mOverridden |= paramBoolean;
        if (!localRecoverAnimation.mEnded) {
          localRecoverAnimation.cancel();
        }
        this.mRecoverAnimations.remove(i);
        return;
      }
      i -= 1;
    }
  }
  
  RecoverAnimation findAnimation(MotionEvent paramMotionEvent)
  {
    if (this.mRecoverAnimations.isEmpty()) {
      return null;
    }
    paramMotionEvent = findChildView(paramMotionEvent);
    int i = this.mRecoverAnimations.size() - 1;
    while (i >= 0)
    {
      RecoverAnimation localRecoverAnimation = (RecoverAnimation)this.mRecoverAnimations.get(i);
      if (localRecoverAnimation.mViewHolder.itemView == paramMotionEvent) {
        return localRecoverAnimation;
      }
      i -= 1;
    }
    return null;
  }
  
  View findChildView(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (this.mSelected != null)
    {
      paramMotionEvent = this.mSelected.itemView;
      if (hitTest(paramMotionEvent, f1, f2, this.mSelectedStartX + this.mDx, this.mSelectedStartY + this.mDy)) {
        return paramMotionEvent;
      }
    }
    int i = this.mRecoverAnimations.size() - 1;
    while (i >= 0)
    {
      paramMotionEvent = (RecoverAnimation)this.mRecoverAnimations.get(i);
      View localView = paramMotionEvent.mViewHolder.itemView;
      if (hitTest(localView, f1, f2, paramMotionEvent.mX, paramMotionEvent.mY)) {
        return localView;
      }
      i -= 1;
    }
    return this.mRecyclerView.findChildViewUnder(f1, f2);
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    paramRect.setEmpty();
  }
  
  boolean hasRunningRecoverAnim()
  {
    int j = this.mRecoverAnimations.size();
    int i = 0;
    while (i < j)
    {
      if (!((RecoverAnimation)this.mRecoverAnimations.get(i)).mEnded) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  void moveIfNecessary(RecyclerView.ViewHolder paramViewHolder)
  {
    if (this.mRecyclerView.isLayoutRequested()) {
      return;
    }
    if (this.mActionState != 2) {
      return;
    }
    float f = this.mCallback.getMoveThreshold(paramViewHolder);
    int i = (int)(this.mSelectedStartX + this.mDx);
    int j = (int)(this.mSelectedStartY + this.mDy);
    if ((Math.abs(j - paramViewHolder.itemView.getTop()) < paramViewHolder.itemView.getHeight() * f) && (Math.abs(i - paramViewHolder.itemView.getLeft()) < paramViewHolder.itemView.getWidth() * f)) {
      return;
    }
    Object localObject = findSwapTargets(paramViewHolder);
    if (((List)localObject).size() == 0) {
      return;
    }
    localObject = this.mCallback.chooseDropTarget(paramViewHolder, (List)localObject, i, j);
    if (localObject == null)
    {
      this.mSwapTargets.clear();
      this.mDistances.clear();
      return;
    }
    int k = ((RecyclerView.ViewHolder)localObject).getAdapterPosition();
    int m = paramViewHolder.getAdapterPosition();
    if (this.mCallback.onMove(this.mRecyclerView, paramViewHolder, (RecyclerView.ViewHolder)localObject)) {
      this.mCallback.onMoved(this.mRecyclerView, paramViewHolder, m, (RecyclerView.ViewHolder)localObject, k, i, j);
    }
  }
  
  void obtainVelocityTracker()
  {
    if (this.mVelocityTracker != null) {
      this.mVelocityTracker.recycle();
    }
    this.mVelocityTracker = VelocityTracker.obtain();
  }
  
  public void onChildViewAttachedToWindow(@NonNull View paramView) {}
  
  public void onChildViewDetachedFromWindow(@NonNull View paramView)
  {
    removeChildDrawingOrderCallbackIfNecessary(paramView);
    paramView = this.mRecyclerView.getChildViewHolder(paramView);
    if (paramView == null) {
      return;
    }
    if ((this.mSelected != null) && (paramView == this.mSelected))
    {
      select(null, 0);
      return;
    }
    endRecoverAnimation(paramView, false);
    if (this.mPendingCleanup.remove(paramView.itemView)) {
      this.mCallback.clearView(this.mRecyclerView, paramView);
    }
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    this.mOverdrawChildPosition = -1;
    float f1;
    float f2;
    if (this.mSelected != null)
    {
      getSelectedDxDy(this.mTmpPosition);
      f1 = this.mTmpPosition[0];
      f2 = this.mTmpPosition[1];
    }
    else
    {
      f1 = 0.0F;
      f2 = 0.0F;
    }
    this.mCallback.onDraw(paramCanvas, paramRecyclerView, this.mSelected, this.mRecoverAnimations, this.mActionState, f1, f2);
  }
  
  public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    float f1;
    float f2;
    if (this.mSelected != null)
    {
      getSelectedDxDy(this.mTmpPosition);
      f1 = this.mTmpPosition[0];
      f2 = this.mTmpPosition[1];
    }
    else
    {
      f1 = 0.0F;
      f2 = 0.0F;
    }
    this.mCallback.onDrawOver(paramCanvas, paramRecyclerView, this.mSelected, this.mRecoverAnimations, this.mActionState, f1, f2);
  }
  
  void postDispatchSwipe(final RecoverAnimation paramRecoverAnimation, final int paramInt)
  {
    this.mRecyclerView.post(new Runnable()
    {
      public void run()
      {
        if ((ItemTouchHelper.this.mRecyclerView != null) && (ItemTouchHelper.this.mRecyclerView.isAttachedToWindow()) && (!paramRecoverAnimation.mOverridden) && (paramRecoverAnimation.mViewHolder.getAdapterPosition() != -1))
        {
          RecyclerView.ItemAnimator localItemAnimator = ItemTouchHelper.this.mRecyclerView.getItemAnimator();
          if (((localItemAnimator == null) || (!localItemAnimator.isRunning(null))) && (!ItemTouchHelper.this.hasRunningRecoverAnim()))
          {
            ItemTouchHelper.this.mCallback.onSwiped(paramRecoverAnimation.mViewHolder, paramInt);
            return;
          }
          ItemTouchHelper.this.mRecyclerView.post(this);
        }
      }
    });
  }
  
  void removeChildDrawingOrderCallbackIfNecessary(View paramView)
  {
    if (paramView == this.mOverdrawChild)
    {
      this.mOverdrawChild = null;
      if (this.mChildDrawingOrderCallback != null) {
        this.mRecyclerView.setChildDrawingOrderCallback(null);
      }
    }
  }
  
  boolean scrollIfNecessary()
  {
    if (this.mSelected == null)
    {
      this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
      return false;
    }
    long l2 = System.currentTimeMillis();
    long l1;
    if (this.mDragScrollStartTimeInMs == Long.MIN_VALUE) {
      l1 = 0L;
    } else {
      l1 = l2 - this.mDragScrollStartTimeInMs;
    }
    RecyclerView.LayoutManager localLayoutManager = this.mRecyclerView.getLayoutManager();
    if (this.mTmpRect == null) {
      this.mTmpRect = new Rect();
    }
    localLayoutManager.calculateItemDecorationsForChild(this.mSelected.itemView, this.mTmpRect);
    if (localLayoutManager.canScrollHorizontally())
    {
      j = (int)(this.mSelectedStartX + this.mDx);
      i = j - this.mTmpRect.left - this.mRecyclerView.getPaddingLeft();
      if ((this.mDx < 0.0F) && (i < 0)) {
        break label198;
      }
      if (this.mDx > 0.0F)
      {
        i = j + this.mSelected.itemView.getWidth() + this.mTmpRect.right - (this.mRecyclerView.getWidth() - this.mRecyclerView.getPaddingRight());
        if (i > 0) {
          break label198;
        }
      }
    }
    int i = 0;
    label198:
    if (localLayoutManager.canScrollVertically())
    {
      k = (int)(this.mSelectedStartY + this.mDy);
      j = k - this.mTmpRect.top - this.mRecyclerView.getPaddingTop();
      if ((this.mDy < 0.0F) && (j < 0)) {
        break label306;
      }
      if (this.mDy > 0.0F)
      {
        j = k + this.mSelected.itemView.getHeight() + this.mTmpRect.bottom - (this.mRecyclerView.getHeight() - this.mRecyclerView.getPaddingBottom());
        if (j > 0) {
          break label306;
        }
      }
    }
    int j = 0;
    label306:
    int k = i;
    if (i != 0) {
      k = this.mCallback.interpolateOutOfBoundsScroll(this.mRecyclerView, this.mSelected.itemView.getWidth(), i, this.mRecyclerView.getWidth(), l1);
    }
    if (j != 0) {
      j = this.mCallback.interpolateOutOfBoundsScroll(this.mRecyclerView, this.mSelected.itemView.getHeight(), j, this.mRecyclerView.getHeight(), l1);
    }
    if ((k == 0) && (j == 0))
    {
      this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
      return false;
    }
    if (this.mDragScrollStartTimeInMs == Long.MIN_VALUE) {
      this.mDragScrollStartTimeInMs = l2;
    }
    this.mRecyclerView.scrollBy(k, j);
    return true;
  }
  
  void select(@Nullable RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder == this.mSelected) && (paramInt == this.mActionState)) {
      return;
    }
    this.mDragScrollStartTimeInMs = Long.MIN_VALUE;
    int k = this.mActionState;
    endRecoverAnimation(paramViewHolder, true);
    this.mActionState = paramInt;
    if (paramInt == 2) {
      if (paramViewHolder != null)
      {
        this.mOverdrawChild = paramViewHolder.itemView;
        addChildDrawingOrderCallback();
      }
      else
      {
        throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
      }
    }
    int i;
    if (this.mSelected != null)
    {
      final Object localObject = this.mSelected;
      if (((RecyclerView.ViewHolder)localObject).itemView.getParent() != null)
      {
        final int j;
        if (k == 2) {
          j = 0;
        } else {
          j = swipeIfNecessary((RecyclerView.ViewHolder)localObject);
        }
        releaseVelocityTracker();
        if ((j != 4) && (j != 8) && (j != 16) && (j != 32)) {
          switch (j)
          {
          }
        }
        float f2;
        for (float f1 = 0.0F;; f1 = Math.signum(this.mDx) * this.mRecyclerView.getWidth())
        {
          f2 = 0.0F;
          break;
          f2 = Math.signum(this.mDy) * this.mRecyclerView.getHeight();
          f1 = 0.0F;
          break;
        }
        if (k == 2) {
          i = 8;
        } else if (j > 0) {
          i = 2;
        } else {
          i = 4;
        }
        getSelectedDxDy(this.mTmpPosition);
        float f3 = this.mTmpPosition[0];
        float f4 = this.mTmpPosition[1];
        localObject = new RecoverAnimation((RecyclerView.ViewHolder)localObject, i, k, f3, f4, f1, f2)
        {
          public void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            super.onAnimationEnd(paramAnonymousAnimator);
            if (this.mOverridden) {
              return;
            }
            if (j <= 0)
            {
              ItemTouchHelper.this.mCallback.clearView(ItemTouchHelper.this.mRecyclerView, localObject);
            }
            else
            {
              ItemTouchHelper.this.mPendingCleanup.add(localObject.itemView);
              this.mIsPendingCleanup = true;
              if (j > 0) {
                ItemTouchHelper.this.postDispatchSwipe(this, j);
              }
            }
            if (ItemTouchHelper.this.mOverdrawChild == localObject.itemView) {
              ItemTouchHelper.this.removeChildDrawingOrderCallbackIfNecessary(localObject.itemView);
            }
          }
        };
        ((RecoverAnimation)localObject).setDuration(this.mCallback.getAnimationDuration(this.mRecyclerView, i, f1 - f3, f2 - f4));
        this.mRecoverAnimations.add(localObject);
        ((RecoverAnimation)localObject).start();
        i = 1;
      }
      else
      {
        removeChildDrawingOrderCallbackIfNecessary(((RecyclerView.ViewHolder)localObject).itemView);
        this.mCallback.clearView(this.mRecyclerView, (RecyclerView.ViewHolder)localObject);
        i = 0;
      }
      this.mSelected = null;
    }
    else
    {
      i = 0;
    }
    if (paramViewHolder != null)
    {
      this.mSelectedFlags = ((this.mCallback.getAbsoluteMovementFlags(this.mRecyclerView, paramViewHolder) & (1 << paramInt * 8 + 8) - 1) >> this.mActionState * 8);
      this.mSelectedStartX = paramViewHolder.itemView.getLeft();
      this.mSelectedStartY = paramViewHolder.itemView.getTop();
      this.mSelected = paramViewHolder;
      if (paramInt == 2) {
        this.mSelected.itemView.performHapticFeedback(0);
      }
    }
    boolean bool = false;
    paramViewHolder = this.mRecyclerView.getParent();
    if (paramViewHolder != null)
    {
      if (this.mSelected != null) {
        bool = true;
      }
      paramViewHolder.requestDisallowInterceptTouchEvent(bool);
    }
    if (i == 0) {
      this.mRecyclerView.getLayoutManager().requestSimpleAnimationsInNextLayout();
    }
    this.mCallback.onSelectedChanged(this.mSelected, this.mActionState);
    this.mRecyclerView.invalidate();
  }
  
  public void startDrag(@NonNull RecyclerView.ViewHolder paramViewHolder)
  {
    if (!this.mCallback.hasDragFlag(this.mRecyclerView, paramViewHolder))
    {
      Log.e("ItemTouchHelper", "Start drag has been called but dragging is not enabled");
      return;
    }
    if (paramViewHolder.itemView.getParent() != this.mRecyclerView)
    {
      Log.e("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
      return;
    }
    obtainVelocityTracker();
    this.mDy = 0.0F;
    this.mDx = 0.0F;
    select(paramViewHolder, 2);
  }
  
  public void startSwipe(@NonNull RecyclerView.ViewHolder paramViewHolder)
  {
    if (!this.mCallback.hasSwipeFlag(this.mRecyclerView, paramViewHolder))
    {
      Log.e("ItemTouchHelper", "Start swipe has been called but swiping is not enabled");
      return;
    }
    if (paramViewHolder.itemView.getParent() != this.mRecyclerView)
    {
      Log.e("ItemTouchHelper", "Start swipe has been called with a view holder which is not a child of the RecyclerView controlled by this ItemTouchHelper.");
      return;
    }
    obtainVelocityTracker();
    this.mDy = 0.0F;
    this.mDx = 0.0F;
    select(paramViewHolder, 1);
  }
  
  void updateDxDy(MotionEvent paramMotionEvent, int paramInt1, int paramInt2)
  {
    float f1 = paramMotionEvent.getX(paramInt2);
    float f2 = paramMotionEvent.getY(paramInt2);
    this.mDx = (f1 - this.mInitialTouchX);
    this.mDy = (f2 - this.mInitialTouchY);
    if ((paramInt1 & 0x4) == 0) {
      this.mDx = Math.max(0.0F, this.mDx);
    }
    if ((paramInt1 & 0x8) == 0) {
      this.mDx = Math.min(0.0F, this.mDx);
    }
    if ((paramInt1 & 0x1) == 0) {
      this.mDy = Math.max(0.0F, this.mDy);
    }
    if ((paramInt1 & 0x2) == 0) {
      this.mDy = Math.min(0.0F, this.mDy);
    }
  }
  
  public static abstract class Callback
  {
    private static final int ABS_HORIZONTAL_DIR_FLAGS = 789516;
    public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
    public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
    private static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 2000L;
    static final int RELATIVE_DIR_FLAGS = 3158064;
    private static final Interpolator sDragScrollInterpolator = new Interpolator()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        return paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat;
      }
    };
    private static final Interpolator sDragViewScrollCapInterpolator = new Interpolator()
    {
      public float getInterpolation(float paramAnonymousFloat)
      {
        paramAnonymousFloat -= 1.0F;
        return paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat + 1.0F;
      }
    };
    private int mCachedMaxScrollSpeed = -1;
    
    public static int convertToRelativeDirection(int paramInt1, int paramInt2)
    {
      int i = paramInt1 & 0xC0C0C;
      if (i == 0) {
        return paramInt1;
      }
      paramInt1 &= (i ^ 0xFFFFFFFF);
      if (paramInt2 == 0) {
        return paramInt1 | i << 2;
      }
      paramInt2 = i << 1;
      return paramInt1 | 0xFFF3F3F3 & paramInt2 | (paramInt2 & 0xC0C0C) << 2;
    }
    
    @NonNull
    public static ItemTouchUIUtil getDefaultUIUtil()
    {
      return ItemTouchUIUtilImpl.INSTANCE;
    }
    
    private int getMaxDragScroll(RecyclerView paramRecyclerView)
    {
      if (this.mCachedMaxScrollSpeed == -1) {
        this.mCachedMaxScrollSpeed = paramRecyclerView.getResources().getDimensionPixelSize(R.dimen.item_touch_helper_max_drag_scroll_per_frame);
      }
      return this.mCachedMaxScrollSpeed;
    }
    
    public static int makeFlag(int paramInt1, int paramInt2)
    {
      return paramInt2 << paramInt1 * 8;
    }
    
    public static int makeMovementFlags(int paramInt1, int paramInt2)
    {
      int i = makeFlag(0, paramInt2 | paramInt1);
      paramInt2 = makeFlag(1, paramInt2);
      return makeFlag(2, paramInt1) | paramInt2 | i;
    }
    
    public boolean canDropOver(@NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.ViewHolder paramViewHolder1, @NonNull RecyclerView.ViewHolder paramViewHolder2)
    {
      return true;
    }
    
    public RecyclerView.ViewHolder chooseDropTarget(@NonNull RecyclerView.ViewHolder paramViewHolder, @NonNull List<RecyclerView.ViewHolder> paramList, int paramInt1, int paramInt2)
    {
      int n = paramViewHolder.itemView.getWidth();
      int i1 = paramViewHolder.itemView.getHeight();
      int i2 = paramInt1 - paramViewHolder.itemView.getLeft();
      int i3 = paramInt2 - paramViewHolder.itemView.getTop();
      int i4 = paramList.size();
      Object localObject2 = null;
      int i = -1;
      int k = 0;
      while (k < i4)
      {
        RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)paramList.get(k);
        if (i2 > 0)
        {
          j = localViewHolder.itemView.getRight() - (paramInt1 + n);
          if ((j < 0) && (localViewHolder.itemView.getRight() > paramViewHolder.itemView.getRight()))
          {
            j = Math.abs(j);
            if (j > i)
            {
              localObject2 = localViewHolder;
              break label146;
            }
          }
        }
        int j = i;
        label146:
        Object localObject1 = localObject2;
        i = j;
        int m;
        if (i2 < 0)
        {
          m = localViewHolder.itemView.getLeft() - paramInt1;
          localObject1 = localObject2;
          i = j;
          if (m > 0)
          {
            localObject1 = localObject2;
            i = j;
            if (localViewHolder.itemView.getLeft() < paramViewHolder.itemView.getLeft())
            {
              m = Math.abs(m);
              localObject1 = localObject2;
              i = j;
              if (m > j)
              {
                i = m;
                localObject1 = localViewHolder;
              }
            }
          }
        }
        localObject2 = localObject1;
        j = i;
        if (i3 < 0)
        {
          m = localViewHolder.itemView.getTop() - paramInt2;
          localObject2 = localObject1;
          j = i;
          if (m > 0)
          {
            localObject2 = localObject1;
            j = i;
            if (localViewHolder.itemView.getTop() < paramViewHolder.itemView.getTop())
            {
              m = Math.abs(m);
              localObject2 = localObject1;
              j = i;
              if (m > i)
              {
                j = m;
                localObject2 = localViewHolder;
              }
            }
          }
        }
        if (i3 > 0)
        {
          i = localViewHolder.itemView.getBottom() - (paramInt2 + i1);
          if ((i < 0) && (localViewHolder.itemView.getBottom() > paramViewHolder.itemView.getBottom()))
          {
            i = Math.abs(i);
            if (i > j)
            {
              localObject2 = localViewHolder;
              break label404;
            }
          }
        }
        i = j;
        label404:
        k += 1;
      }
      return (RecyclerView.ViewHolder)localObject2;
    }
    
    public void clearView(@NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.ViewHolder paramViewHolder)
    {
      ItemTouchUIUtilImpl.INSTANCE.clearView(paramViewHolder.itemView);
    }
    
    public int convertToAbsoluteDirection(int paramInt1, int paramInt2)
    {
      int i = paramInt1 & 0x303030;
      if (i == 0) {
        return paramInt1;
      }
      paramInt1 &= (i ^ 0xFFFFFFFF);
      if (paramInt2 == 0) {
        return paramInt1 | i >> 2;
      }
      paramInt2 = i >> 1;
      return paramInt1 | 0xFFCFCFCF & paramInt2 | (paramInt2 & 0x303030) >> 2;
    }
    
    final int getAbsoluteMovementFlags(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
    {
      return convertToAbsoluteDirection(getMovementFlags(paramRecyclerView, paramViewHolder), ViewCompat.getLayoutDirection(paramRecyclerView));
    }
    
    public long getAnimationDuration(@NonNull RecyclerView paramRecyclerView, int paramInt, float paramFloat1, float paramFloat2)
    {
      paramRecyclerView = paramRecyclerView.getItemAnimator();
      if (paramRecyclerView == null)
      {
        if (paramInt == 8) {
          return 200L;
        }
        return 250L;
      }
      if (paramInt == 8) {
        return paramRecyclerView.getMoveDuration();
      }
      return paramRecyclerView.getRemoveDuration();
    }
    
    public int getBoundingBoxMargin()
    {
      return 0;
    }
    
    public float getMoveThreshold(@NonNull RecyclerView.ViewHolder paramViewHolder)
    {
      return 0.5F;
    }
    
    public abstract int getMovementFlags(@NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.ViewHolder paramViewHolder);
    
    public float getSwipeEscapeVelocity(float paramFloat)
    {
      return paramFloat;
    }
    
    public float getSwipeThreshold(@NonNull RecyclerView.ViewHolder paramViewHolder)
    {
      return 0.5F;
    }
    
    public float getSwipeVelocityThreshold(float paramFloat)
    {
      return paramFloat;
    }
    
    boolean hasDragFlag(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
    {
      return (getAbsoluteMovementFlags(paramRecyclerView, paramViewHolder) & 0xFF0000) != 0;
    }
    
    boolean hasSwipeFlag(RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder)
    {
      return (getAbsoluteMovementFlags(paramRecyclerView, paramViewHolder) & 0xFF00) != 0;
    }
    
    public int interpolateOutOfBoundsScroll(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3, long paramLong)
    {
      paramInt3 = getMaxDragScroll(paramRecyclerView);
      int i = Math.abs(paramInt2);
      int j = (int)Math.signum(paramInt2);
      float f2 = i;
      float f1 = 1.0F;
      f2 = Math.min(1.0F, f2 * 1.0F / paramInt1);
      paramInt1 = (int)(j * paramInt3 * sDragViewScrollCapInterpolator.getInterpolation(f2));
      if (paramLong <= 2000L) {
        f1 = (float)paramLong / 2000.0F;
      }
      paramInt1 = (int)(paramInt1 * sDragScrollInterpolator.getInterpolation(f1));
      if (paramInt1 == 0)
      {
        if (paramInt2 > 0) {
          return 1;
        }
        return -1;
      }
      return paramInt1;
    }
    
    public boolean isItemViewSwipeEnabled()
    {
      return true;
    }
    
    public boolean isLongPressDragEnabled()
    {
      return true;
    }
    
    public void onChildDraw(@NonNull Canvas paramCanvas, @NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.ViewHolder paramViewHolder, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
    {
      ItemTouchUIUtilImpl.INSTANCE.onDraw(paramCanvas, paramRecyclerView, paramViewHolder.itemView, paramFloat1, paramFloat2, paramInt, paramBoolean);
    }
    
    public void onChildDrawOver(@NonNull Canvas paramCanvas, @NonNull RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder, float paramFloat1, float paramFloat2, int paramInt, boolean paramBoolean)
    {
      ItemTouchUIUtilImpl.INSTANCE.onDrawOver(paramCanvas, paramRecyclerView, paramViewHolder.itemView, paramFloat1, paramFloat2, paramInt, paramBoolean);
    }
    
    void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder, List<ItemTouchHelper.RecoverAnimation> paramList, int paramInt, float paramFloat1, float paramFloat2)
    {
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        ItemTouchHelper.RecoverAnimation localRecoverAnimation = (ItemTouchHelper.RecoverAnimation)paramList.get(i);
        localRecoverAnimation.update();
        int k = paramCanvas.save();
        onChildDraw(paramCanvas, paramRecyclerView, localRecoverAnimation.mViewHolder, localRecoverAnimation.mX, localRecoverAnimation.mY, localRecoverAnimation.mActionState, false);
        paramCanvas.restoreToCount(k);
        i += 1;
      }
      if (paramViewHolder != null)
      {
        i = paramCanvas.save();
        onChildDraw(paramCanvas, paramRecyclerView, paramViewHolder, paramFloat1, paramFloat2, paramInt, true);
        paramCanvas.restoreToCount(i);
      }
    }
    
    void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.ViewHolder paramViewHolder, List<ItemTouchHelper.RecoverAnimation> paramList, int paramInt, float paramFloat1, float paramFloat2)
    {
      int k = paramList.size();
      int j = 0;
      int i = 0;
      while (i < k)
      {
        ItemTouchHelper.RecoverAnimation localRecoverAnimation = (ItemTouchHelper.RecoverAnimation)paramList.get(i);
        int m = paramCanvas.save();
        onChildDrawOver(paramCanvas, paramRecyclerView, localRecoverAnimation.mViewHolder, localRecoverAnimation.mX, localRecoverAnimation.mY, localRecoverAnimation.mActionState, false);
        paramCanvas.restoreToCount(m);
        i += 1;
      }
      if (paramViewHolder != null)
      {
        i = paramCanvas.save();
        onChildDrawOver(paramCanvas, paramRecyclerView, paramViewHolder, paramFloat1, paramFloat2, paramInt, true);
        paramCanvas.restoreToCount(i);
      }
      paramInt = k - 1;
      i = j;
      while (paramInt >= 0)
      {
        paramCanvas = (ItemTouchHelper.RecoverAnimation)paramList.get(paramInt);
        if ((paramCanvas.mEnded) && (!paramCanvas.mIsPendingCleanup)) {
          paramList.remove(paramInt);
        } else if (!paramCanvas.mEnded) {
          i = 1;
        }
        paramInt -= 1;
      }
      if (i != 0) {
        paramRecyclerView.invalidate();
      }
    }
    
    public abstract boolean onMove(@NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.ViewHolder paramViewHolder1, @NonNull RecyclerView.ViewHolder paramViewHolder2);
    
    public void onMoved(@NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.ViewHolder paramViewHolder1, int paramInt1, @NonNull RecyclerView.ViewHolder paramViewHolder2, int paramInt2, int paramInt3, int paramInt4)
    {
      RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.getLayoutManager();
      if ((localLayoutManager instanceof ItemTouchHelper.ViewDropHandler))
      {
        ((ItemTouchHelper.ViewDropHandler)localLayoutManager).prepareForDrop(paramViewHolder1.itemView, paramViewHolder2.itemView, paramInt3, paramInt4);
        return;
      }
      if (localLayoutManager.canScrollHorizontally())
      {
        if (localLayoutManager.getDecoratedLeft(paramViewHolder2.itemView) <= paramRecyclerView.getPaddingLeft()) {
          paramRecyclerView.scrollToPosition(paramInt2);
        }
        if (localLayoutManager.getDecoratedRight(paramViewHolder2.itemView) >= paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight()) {
          paramRecyclerView.scrollToPosition(paramInt2);
        }
      }
      if (localLayoutManager.canScrollVertically())
      {
        if (localLayoutManager.getDecoratedTop(paramViewHolder2.itemView) <= paramRecyclerView.getPaddingTop()) {
          paramRecyclerView.scrollToPosition(paramInt2);
        }
        if (localLayoutManager.getDecoratedBottom(paramViewHolder2.itemView) >= paramRecyclerView.getHeight() - paramRecyclerView.getPaddingBottom()) {
          paramRecyclerView.scrollToPosition(paramInt2);
        }
      }
    }
    
    public void onSelectedChanged(@Nullable RecyclerView.ViewHolder paramViewHolder, int paramInt)
    {
      if (paramViewHolder != null) {
        ItemTouchUIUtilImpl.INSTANCE.onSelected(paramViewHolder.itemView);
      }
    }
    
    public abstract void onSwiped(@NonNull RecyclerView.ViewHolder paramViewHolder, int paramInt);
  }
  
  private class ItemTouchHelperGestureListener
    extends GestureDetector.SimpleOnGestureListener
  {
    private boolean mShouldReactToLongPress = true;
    
    ItemTouchHelperGestureListener() {}
    
    void doNotReactToLongPress()
    {
      this.mShouldReactToLongPress = false;
    }
    
    public boolean onDown(MotionEvent paramMotionEvent)
    {
      return true;
    }
    
    public void onLongPress(MotionEvent paramMotionEvent)
    {
      if (!this.mShouldReactToLongPress) {
        return;
      }
      Object localObject = ItemTouchHelper.this.findChildView(paramMotionEvent);
      if (localObject != null)
      {
        localObject = ItemTouchHelper.this.mRecyclerView.getChildViewHolder((View)localObject);
        if (localObject != null)
        {
          if (!ItemTouchHelper.this.mCallback.hasDragFlag(ItemTouchHelper.this.mRecyclerView, (RecyclerView.ViewHolder)localObject)) {
            return;
          }
          if (paramMotionEvent.getPointerId(0) == ItemTouchHelper.this.mActivePointerId)
          {
            int i = paramMotionEvent.findPointerIndex(ItemTouchHelper.this.mActivePointerId);
            float f1 = paramMotionEvent.getX(i);
            float f2 = paramMotionEvent.getY(i);
            ItemTouchHelper.this.mInitialTouchX = f1;
            ItemTouchHelper.this.mInitialTouchY = f2;
            paramMotionEvent = ItemTouchHelper.this;
            ItemTouchHelper.this.mDy = 0.0F;
            paramMotionEvent.mDx = 0.0F;
            if (ItemTouchHelper.this.mCallback.isLongPressDragEnabled()) {
              ItemTouchHelper.this.select((RecyclerView.ViewHolder)localObject, 2);
            }
          }
        }
      }
    }
  }
  
  private static class RecoverAnimation
    implements Animator.AnimatorListener
  {
    final int mActionState;
    final int mAnimationType;
    boolean mEnded = false;
    private float mFraction;
    boolean mIsPendingCleanup;
    boolean mOverridden = false;
    final float mStartDx;
    final float mStartDy;
    final float mTargetX;
    final float mTargetY;
    private final ValueAnimator mValueAnimator;
    final RecyclerView.ViewHolder mViewHolder;
    float mX;
    float mY;
    
    RecoverAnimation(RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.mActionState = paramInt2;
      this.mAnimationType = paramInt1;
      this.mViewHolder = paramViewHolder;
      this.mStartDx = paramFloat1;
      this.mStartDy = paramFloat2;
      this.mTargetX = paramFloat3;
      this.mTargetY = paramFloat4;
      this.mValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          ItemTouchHelper.RecoverAnimation.this.setFraction(paramAnonymousValueAnimator.getAnimatedFraction());
        }
      });
      this.mValueAnimator.setTarget(paramViewHolder.itemView);
      this.mValueAnimator.addListener(this);
      setFraction(0.0F);
    }
    
    public void cancel()
    {
      this.mValueAnimator.cancel();
    }
    
    public void onAnimationCancel(Animator paramAnimator)
    {
      setFraction(1.0F);
    }
    
    public void onAnimationEnd(Animator paramAnimator)
    {
      if (!this.mEnded) {
        this.mViewHolder.setIsRecyclable(true);
      }
      this.mEnded = true;
    }
    
    public void onAnimationRepeat(Animator paramAnimator) {}
    
    public void onAnimationStart(Animator paramAnimator) {}
    
    public void setDuration(long paramLong)
    {
      this.mValueAnimator.setDuration(paramLong);
    }
    
    public void setFraction(float paramFloat)
    {
      this.mFraction = paramFloat;
    }
    
    public void start()
    {
      this.mViewHolder.setIsRecyclable(false);
      this.mValueAnimator.start();
    }
    
    public void update()
    {
      if (this.mStartDx == this.mTargetX) {
        this.mX = this.mViewHolder.itemView.getTranslationX();
      } else {
        this.mX = (this.mStartDx + this.mFraction * (this.mTargetX - this.mStartDx));
      }
      if (this.mStartDy == this.mTargetY)
      {
        this.mY = this.mViewHolder.itemView.getTranslationY();
        return;
      }
      this.mY = (this.mStartDy + this.mFraction * (this.mTargetY - this.mStartDy));
    }
  }
  
  public static abstract class SimpleCallback
    extends ItemTouchHelper.Callback
  {
    private int mDefaultDragDirs;
    private int mDefaultSwipeDirs;
    
    public SimpleCallback(int paramInt1, int paramInt2)
    {
      this.mDefaultSwipeDirs = paramInt2;
      this.mDefaultDragDirs = paramInt1;
    }
    
    public int getDragDirs(@NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.ViewHolder paramViewHolder)
    {
      return this.mDefaultDragDirs;
    }
    
    public int getMovementFlags(@NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.ViewHolder paramViewHolder)
    {
      return makeMovementFlags(getDragDirs(paramRecyclerView, paramViewHolder), getSwipeDirs(paramRecyclerView, paramViewHolder));
    }
    
    public int getSwipeDirs(@NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.ViewHolder paramViewHolder)
    {
      return this.mDefaultSwipeDirs;
    }
    
    public void setDefaultDragDirs(int paramInt)
    {
      this.mDefaultDragDirs = paramInt;
    }
    
    public void setDefaultSwipeDirs(int paramInt)
    {
      this.mDefaultSwipeDirs = paramInt;
    }
  }
  
  public static abstract interface ViewDropHandler
  {
    public abstract void prepareForDrop(@NonNull View paramView1, @NonNull View paramView2, int paramInt1, int paramInt2);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\widget\helper\ItemTouchHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */