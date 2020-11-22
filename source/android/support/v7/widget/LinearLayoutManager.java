package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.v7.widget.helper.ItemTouchHelper.ViewDropHandler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager
  extends RecyclerView.LayoutManager
  implements RecyclerView.SmoothScroller.ScrollVectorProvider, ItemTouchHelper.ViewDropHandler
{
  static final boolean DEBUG = false;
  public static final int HORIZONTAL = 0;
  public static final int INVALID_OFFSET = Integer.MIN_VALUE;
  private static final float MAX_SCROLL_FACTOR = 0.33333334F;
  private static final String TAG = "LinearLayoutManager";
  public static final int VERTICAL = 1;
  final AnchorInfo mAnchorInfo = new AnchorInfo();
  private int mInitialPrefetchItemCount = 2;
  private boolean mLastStackFromEnd;
  private final LayoutChunkResult mLayoutChunkResult = new LayoutChunkResult();
  private LayoutState mLayoutState;
  int mOrientation = 1;
  OrientationHelper mOrientationHelper;
  SavedState mPendingSavedState = null;
  int mPendingScrollPosition = -1;
  int mPendingScrollPositionOffset = Integer.MIN_VALUE;
  private boolean mRecycleChildrenOnDetach;
  private boolean mReverseLayout = false;
  boolean mShouldReverseLayout = false;
  private boolean mSmoothScrollbarEnabled = true;
  private boolean mStackFromEnd = false;
  
  public LinearLayoutManager(Context paramContext)
  {
    this(paramContext, 1, false);
  }
  
  public LinearLayoutManager(Context paramContext, int paramInt, boolean paramBoolean)
  {
    setOrientation(paramInt);
    setReverseLayout(paramBoolean);
  }
  
  public LinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    paramContext = getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setOrientation(paramContext.orientation);
    setReverseLayout(paramContext.reverseLayout);
    setStackFromEnd(paramContext.stackFromEnd);
  }
  
  private int computeScrollExtent(RecyclerView.State paramState)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    ensureLayoutState();
    return ScrollbarHelper.computeScrollExtent(paramState, this.mOrientationHelper, findFirstVisibleChildClosestToStart(this.mSmoothScrollbarEnabled ^ true, true), findFirstVisibleChildClosestToEnd(this.mSmoothScrollbarEnabled ^ true, true), this, this.mSmoothScrollbarEnabled);
  }
  
  private int computeScrollOffset(RecyclerView.State paramState)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    ensureLayoutState();
    return ScrollbarHelper.computeScrollOffset(paramState, this.mOrientationHelper, findFirstVisibleChildClosestToStart(this.mSmoothScrollbarEnabled ^ true, true), findFirstVisibleChildClosestToEnd(this.mSmoothScrollbarEnabled ^ true, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
  }
  
  private int computeScrollRange(RecyclerView.State paramState)
  {
    if (getChildCount() == 0) {
      return 0;
    }
    ensureLayoutState();
    return ScrollbarHelper.computeScrollRange(paramState, this.mOrientationHelper, findFirstVisibleChildClosestToStart(this.mSmoothScrollbarEnabled ^ true, true), findFirstVisibleChildClosestToEnd(this.mSmoothScrollbarEnabled ^ true, true), this, this.mSmoothScrollbarEnabled);
  }
  
  private View findFirstPartiallyOrCompletelyInvisibleChild(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
  }
  
  private View findFirstReferenceChild(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return findReferenceChild(paramRecycler, paramState, 0, getChildCount(), paramState.getItemCount());
  }
  
  private View findFirstVisibleChildClosestToEnd(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mShouldReverseLayout) {
      return findOneVisibleChild(0, getChildCount(), paramBoolean1, paramBoolean2);
    }
    return findOneVisibleChild(getChildCount() - 1, -1, paramBoolean1, paramBoolean2);
  }
  
  private View findFirstVisibleChildClosestToStart(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mShouldReverseLayout) {
      return findOneVisibleChild(getChildCount() - 1, -1, paramBoolean1, paramBoolean2);
    }
    return findOneVisibleChild(0, getChildCount(), paramBoolean1, paramBoolean2);
  }
  
  private View findLastPartiallyOrCompletelyInvisibleChild(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
  }
  
  private View findLastReferenceChild(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    return findReferenceChild(paramRecycler, paramState, getChildCount() - 1, -1, paramState.getItemCount());
  }
  
  private View findPartiallyOrCompletelyInvisibleChildClosestToEnd(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mShouldReverseLayout) {
      return findFirstPartiallyOrCompletelyInvisibleChild(paramRecycler, paramState);
    }
    return findLastPartiallyOrCompletelyInvisibleChild(paramRecycler, paramState);
  }
  
  private View findPartiallyOrCompletelyInvisibleChildClosestToStart(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mShouldReverseLayout) {
      return findLastPartiallyOrCompletelyInvisibleChild(paramRecycler, paramState);
    }
    return findFirstPartiallyOrCompletelyInvisibleChild(paramRecycler, paramState);
  }
  
  private View findReferenceChildClosestToEnd(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mShouldReverseLayout) {
      return findFirstReferenceChild(paramRecycler, paramState);
    }
    return findLastReferenceChild(paramRecycler, paramState);
  }
  
  private View findReferenceChildClosestToStart(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mShouldReverseLayout) {
      return findLastReferenceChild(paramRecycler, paramState);
    }
    return findFirstReferenceChild(paramRecycler, paramState);
  }
  
  private int fixLayoutEndGap(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean)
  {
    int i = this.mOrientationHelper.getEndAfterPadding() - paramInt;
    if (i > 0)
    {
      i = -scrollBy(-i, paramRecycler, paramState);
      if (paramBoolean)
      {
        paramInt = this.mOrientationHelper.getEndAfterPadding() - (paramInt + i);
        if (paramInt > 0)
        {
          this.mOrientationHelper.offsetChildren(paramInt);
          return paramInt + i;
        }
      }
      return i;
    }
    return 0;
  }
  
  private int fixLayoutStartGap(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, boolean paramBoolean)
  {
    int i = paramInt - this.mOrientationHelper.getStartAfterPadding();
    if (i > 0)
    {
      i = -scrollBy(i, paramRecycler, paramState);
      if (paramBoolean)
      {
        paramInt = paramInt + i - this.mOrientationHelper.getStartAfterPadding();
        if (paramInt > 0)
        {
          this.mOrientationHelper.offsetChildren(-paramInt);
          return i - paramInt;
        }
      }
      return i;
    }
    return 0;
  }
  
  private View getChildClosestToEnd()
  {
    int i;
    if (this.mShouldReverseLayout) {
      i = 0;
    } else {
      i = getChildCount() - 1;
    }
    return getChildAt(i);
  }
  
  private View getChildClosestToStart()
  {
    int i;
    if (this.mShouldReverseLayout) {
      i = getChildCount() - 1;
    } else {
      i = 0;
    }
    return getChildAt(i);
  }
  
  private void layoutForPredictiveAnimations(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2)
  {
    if ((paramState.willRunPredictiveAnimations()) && (getChildCount() != 0) && (!paramState.isPreLayout()))
    {
      if (!supportsPredictiveItemAnimations()) {
        return;
      }
      List localList = paramRecycler.getScrapList();
      int n = localList.size();
      int i1 = getPosition(getChildAt(0));
      int i = 0;
      int k = 0;
      int j = 0;
      while (i < n)
      {
        RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)localList.get(i);
        if (!localViewHolder.isRemoved())
        {
          int i2 = localViewHolder.getLayoutPosition();
          int m = 1;
          int i3;
          if (i2 < i1) {
            i3 = 1;
          } else {
            i3 = 0;
          }
          if (i3 != this.mShouldReverseLayout) {
            m = -1;
          }
          if (m == -1) {
            k += this.mOrientationHelper.getDecoratedMeasurement(localViewHolder.itemView);
          } else {
            j += this.mOrientationHelper.getDecoratedMeasurement(localViewHolder.itemView);
          }
        }
        i += 1;
      }
      this.mLayoutState.mScrapList = localList;
      if (k > 0)
      {
        updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), paramInt1);
        this.mLayoutState.mExtra = k;
        this.mLayoutState.mAvailable = 0;
        this.mLayoutState.assignPositionFromScrapList();
        fill(paramRecycler, this.mLayoutState, paramState, false);
      }
      if (j > 0)
      {
        updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), paramInt2);
        this.mLayoutState.mExtra = j;
        this.mLayoutState.mAvailable = 0;
        this.mLayoutState.assignPositionFromScrapList();
        fill(paramRecycler, this.mLayoutState, paramState, false);
      }
      this.mLayoutState.mScrapList = null;
      return;
    }
  }
  
  private void logChildren()
  {
    Log.d("LinearLayoutManager", "internal representation of views on the screen");
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("item ");
      localStringBuilder.append(getPosition(localView));
      localStringBuilder.append(", coord:");
      localStringBuilder.append(this.mOrientationHelper.getDecoratedStart(localView));
      Log.d("LinearLayoutManager", localStringBuilder.toString());
      i += 1;
    }
    Log.d("LinearLayoutManager", "==============");
  }
  
  private void recycleByLayoutState(RecyclerView.Recycler paramRecycler, LayoutState paramLayoutState)
  {
    if (paramLayoutState.mRecycle)
    {
      if (paramLayoutState.mInfinite) {
        return;
      }
      if (paramLayoutState.mLayoutDirection == -1)
      {
        recycleViewsFromEnd(paramRecycler, paramLayoutState.mScrollingOffset);
        return;
      }
      recycleViewsFromStart(paramRecycler, paramLayoutState.mScrollingOffset);
      return;
    }
  }
  
  private void recycleChildren(RecyclerView.Recycler paramRecycler, int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    int i = paramInt1;
    if (paramInt2 > paramInt1)
    {
      paramInt2 -= 1;
      while (paramInt2 >= paramInt1)
      {
        removeAndRecycleViewAt(paramInt2, paramRecycler);
        paramInt2 -= 1;
      }
    }
    while (i > paramInt2)
    {
      removeAndRecycleViewAt(i, paramRecycler);
      i -= 1;
    }
  }
  
  private void recycleViewsFromEnd(RecyclerView.Recycler paramRecycler, int paramInt)
  {
    int i = getChildCount();
    if (paramInt < 0) {
      return;
    }
    int j = this.mOrientationHelper.getEnd() - paramInt;
    View localView;
    if (this.mShouldReverseLayout)
    {
      paramInt = 0;
      for (;;)
      {
        if (paramInt >= i) {
          return;
        }
        localView = getChildAt(paramInt);
        if ((this.mOrientationHelper.getDecoratedStart(localView) < j) || (this.mOrientationHelper.getTransformedStartWithDecoration(localView) < j)) {
          break;
        }
        paramInt += 1;
      }
      recycleChildren(paramRecycler, 0, paramInt);
      return;
    }
    i -= 1;
    paramInt = i;
    while (paramInt >= 0)
    {
      localView = getChildAt(paramInt);
      if ((this.mOrientationHelper.getDecoratedStart(localView) >= j) && (this.mOrientationHelper.getTransformedStartWithDecoration(localView) >= j))
      {
        paramInt -= 1;
      }
      else
      {
        recycleChildren(paramRecycler, i, paramInt);
        return;
      }
    }
  }
  
  private void recycleViewsFromStart(RecyclerView.Recycler paramRecycler, int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    int j = getChildCount();
    View localView;
    if (this.mShouldReverseLayout)
    {
      j -= 1;
      i = j;
      for (;;)
      {
        if (i < 0) {
          return;
        }
        localView = getChildAt(i);
        if ((this.mOrientationHelper.getDecoratedEnd(localView) > paramInt) || (this.mOrientationHelper.getTransformedEndWithDecoration(localView) > paramInt)) {
          break;
        }
        i -= 1;
      }
      recycleChildren(paramRecycler, j, i);
      return;
    }
    int i = 0;
    while (i < j)
    {
      localView = getChildAt(i);
      if ((this.mOrientationHelper.getDecoratedEnd(localView) <= paramInt) && (this.mOrientationHelper.getTransformedEndWithDecoration(localView) <= paramInt))
      {
        i += 1;
      }
      else
      {
        recycleChildren(paramRecycler, 0, i);
        return;
      }
    }
  }
  
  private void resolveShouldLayoutReverse()
  {
    if ((this.mOrientation != 1) && (isLayoutRTL()))
    {
      this.mShouldReverseLayout = (this.mReverseLayout ^ true);
      return;
    }
    this.mShouldReverseLayout = this.mReverseLayout;
  }
  
  private boolean updateAnchorFromChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, AnchorInfo paramAnchorInfo)
  {
    int j = getChildCount();
    int i = 0;
    if (j == 0) {
      return false;
    }
    View localView = getFocusedChild();
    if ((localView != null) && (paramAnchorInfo.isViewValidAsAnchor(localView, paramState)))
    {
      paramAnchorInfo.assignFromViewAndKeepVisibleRect(localView, getPosition(localView));
      return true;
    }
    if (this.mLastStackFromEnd != this.mStackFromEnd) {
      return false;
    }
    if (paramAnchorInfo.mLayoutFromEnd) {
      paramRecycler = findReferenceChildClosestToEnd(paramRecycler, paramState);
    } else {
      paramRecycler = findReferenceChildClosestToStart(paramRecycler, paramState);
    }
    if (paramRecycler != null)
    {
      paramAnchorInfo.assignFromView(paramRecycler, getPosition(paramRecycler));
      if ((!paramState.isPreLayout()) && (supportsPredictiveItemAnimations()))
      {
        if ((this.mOrientationHelper.getDecoratedStart(paramRecycler) >= this.mOrientationHelper.getEndAfterPadding()) || (this.mOrientationHelper.getDecoratedEnd(paramRecycler) < this.mOrientationHelper.getStartAfterPadding())) {
          i = 1;
        }
        if (i != 0)
        {
          if (paramAnchorInfo.mLayoutFromEnd) {
            i = this.mOrientationHelper.getEndAfterPadding();
          } else {
            i = this.mOrientationHelper.getStartAfterPadding();
          }
          paramAnchorInfo.mCoordinate = i;
        }
      }
      return true;
    }
    return false;
  }
  
  private boolean updateAnchorFromPendingData(RecyclerView.State paramState, AnchorInfo paramAnchorInfo)
  {
    boolean bool1 = paramState.isPreLayout();
    boolean bool2 = false;
    if (!bool1)
    {
      if (this.mPendingScrollPosition == -1) {
        return false;
      }
      if ((this.mPendingScrollPosition >= 0) && (this.mPendingScrollPosition < paramState.getItemCount()))
      {
        paramAnchorInfo.mPosition = this.mPendingScrollPosition;
        if ((this.mPendingSavedState != null) && (this.mPendingSavedState.hasValidAnchor()))
        {
          paramAnchorInfo.mLayoutFromEnd = this.mPendingSavedState.mAnchorLayoutFromEnd;
          if (paramAnchorInfo.mLayoutFromEnd)
          {
            paramAnchorInfo.mCoordinate = (this.mOrientationHelper.getEndAfterPadding() - this.mPendingSavedState.mAnchorOffset);
            return true;
          }
          paramAnchorInfo.mCoordinate = (this.mOrientationHelper.getStartAfterPadding() + this.mPendingSavedState.mAnchorOffset);
          return true;
        }
        if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE)
        {
          paramState = findViewByPosition(this.mPendingScrollPosition);
          int i;
          if (paramState != null)
          {
            if (this.mOrientationHelper.getDecoratedMeasurement(paramState) > this.mOrientationHelper.getTotalSpace())
            {
              paramAnchorInfo.assignCoordinateFromPadding();
              return true;
            }
            if (this.mOrientationHelper.getDecoratedStart(paramState) - this.mOrientationHelper.getStartAfterPadding() < 0)
            {
              paramAnchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding();
              paramAnchorInfo.mLayoutFromEnd = false;
              return true;
            }
            if (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(paramState) < 0)
            {
              paramAnchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding();
              paramAnchorInfo.mLayoutFromEnd = true;
              return true;
            }
            if (paramAnchorInfo.mLayoutFromEnd) {
              i = this.mOrientationHelper.getDecoratedEnd(paramState) + this.mOrientationHelper.getTotalSpaceChange();
            } else {
              i = this.mOrientationHelper.getDecoratedStart(paramState);
            }
            paramAnchorInfo.mCoordinate = i;
            return true;
          }
          if (getChildCount() > 0)
          {
            i = getPosition(getChildAt(0));
            if (this.mPendingScrollPosition < i) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            if (bool1 == this.mShouldReverseLayout) {
              bool2 = true;
            }
            paramAnchorInfo.mLayoutFromEnd = bool2;
          }
          paramAnchorInfo.assignCoordinateFromPadding();
          return true;
        }
        paramAnchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
        if (this.mShouldReverseLayout)
        {
          paramAnchorInfo.mCoordinate = (this.mOrientationHelper.getEndAfterPadding() - this.mPendingScrollPositionOffset);
          return true;
        }
        paramAnchorInfo.mCoordinate = (this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset);
        return true;
      }
      this.mPendingScrollPosition = -1;
      this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
      return false;
    }
    return false;
  }
  
  private void updateAnchorInfoForLayout(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, AnchorInfo paramAnchorInfo)
  {
    if (updateAnchorFromPendingData(paramState, paramAnchorInfo)) {
      return;
    }
    if (updateAnchorFromChildren(paramRecycler, paramState, paramAnchorInfo)) {
      return;
    }
    paramAnchorInfo.assignCoordinateFromPadding();
    int i;
    if (this.mStackFromEnd) {
      i = paramState.getItemCount() - 1;
    } else {
      i = 0;
    }
    paramAnchorInfo.mPosition = i;
  }
  
  private void updateLayoutState(int paramInt1, int paramInt2, boolean paramBoolean, RecyclerView.State paramState)
  {
    this.mLayoutState.mInfinite = resolveIsInfinite();
    this.mLayoutState.mExtra = getExtraLayoutSpace(paramState);
    this.mLayoutState.mLayoutDirection = paramInt1;
    int i = -1;
    LayoutState localLayoutState;
    if (paramInt1 == 1)
    {
      paramState = this.mLayoutState;
      paramState.mExtra += this.mOrientationHelper.getEndPadding();
      paramState = getChildClosestToEnd();
      localLayoutState = this.mLayoutState;
      if (!this.mShouldReverseLayout) {
        i = 1;
      }
      localLayoutState.mItemDirection = i;
      this.mLayoutState.mCurrentPosition = (getPosition(paramState) + this.mLayoutState.mItemDirection);
      this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedEnd(paramState);
      paramInt1 = this.mOrientationHelper.getDecoratedEnd(paramState) - this.mOrientationHelper.getEndAfterPadding();
    }
    else
    {
      paramState = getChildClosestToStart();
      localLayoutState = this.mLayoutState;
      localLayoutState.mExtra += this.mOrientationHelper.getStartAfterPadding();
      localLayoutState = this.mLayoutState;
      if (this.mShouldReverseLayout) {
        i = 1;
      }
      localLayoutState.mItemDirection = i;
      this.mLayoutState.mCurrentPosition = (getPosition(paramState) + this.mLayoutState.mItemDirection);
      this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedStart(paramState);
      paramInt1 = -this.mOrientationHelper.getDecoratedStart(paramState) + this.mOrientationHelper.getStartAfterPadding();
    }
    this.mLayoutState.mAvailable = paramInt2;
    if (paramBoolean)
    {
      paramState = this.mLayoutState;
      paramState.mAvailable -= paramInt1;
    }
    this.mLayoutState.mScrollingOffset = paramInt1;
  }
  
  private void updateLayoutStateToFillEnd(int paramInt1, int paramInt2)
  {
    this.mLayoutState.mAvailable = (this.mOrientationHelper.getEndAfterPadding() - paramInt2);
    LayoutState localLayoutState = this.mLayoutState;
    int i;
    if (this.mShouldReverseLayout) {
      i = -1;
    } else {
      i = 1;
    }
    localLayoutState.mItemDirection = i;
    this.mLayoutState.mCurrentPosition = paramInt1;
    this.mLayoutState.mLayoutDirection = 1;
    this.mLayoutState.mOffset = paramInt2;
    this.mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
  }
  
  private void updateLayoutStateToFillEnd(AnchorInfo paramAnchorInfo)
  {
    updateLayoutStateToFillEnd(paramAnchorInfo.mPosition, paramAnchorInfo.mCoordinate);
  }
  
  private void updateLayoutStateToFillStart(int paramInt1, int paramInt2)
  {
    this.mLayoutState.mAvailable = (paramInt2 - this.mOrientationHelper.getStartAfterPadding());
    this.mLayoutState.mCurrentPosition = paramInt1;
    LayoutState localLayoutState = this.mLayoutState;
    if (this.mShouldReverseLayout) {
      paramInt1 = 1;
    } else {
      paramInt1 = -1;
    }
    localLayoutState.mItemDirection = paramInt1;
    this.mLayoutState.mLayoutDirection = -1;
    this.mLayoutState.mOffset = paramInt2;
    this.mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
  }
  
  private void updateLayoutStateToFillStart(AnchorInfo paramAnchorInfo)
  {
    updateLayoutStateToFillStart(paramAnchorInfo.mPosition, paramAnchorInfo.mCoordinate);
  }
  
  public void assertNotInLayoutOrScroll(String paramString)
  {
    if (this.mPendingSavedState == null) {
      super.assertNotInLayoutOrScroll(paramString);
    }
  }
  
  public boolean canScrollHorizontally()
  {
    return this.mOrientation == 0;
  }
  
  public boolean canScrollVertically()
  {
    return this.mOrientation == 1;
  }
  
  public void collectAdjacentPrefetchPositions(int paramInt1, int paramInt2, RecyclerView.State paramState, RecyclerView.LayoutManager.LayoutPrefetchRegistry paramLayoutPrefetchRegistry)
  {
    if (this.mOrientation != 0) {
      paramInt1 = paramInt2;
    }
    if (getChildCount() != 0)
    {
      if (paramInt1 == 0) {
        return;
      }
      ensureLayoutState();
      if (paramInt1 > 0) {
        paramInt2 = 1;
      } else {
        paramInt2 = -1;
      }
      updateLayoutState(paramInt2, Math.abs(paramInt1), true, paramState);
      collectPrefetchPositionsForLayoutState(paramState, this.mLayoutState, paramLayoutPrefetchRegistry);
      return;
    }
  }
  
  public void collectInitialPrefetchPositions(int paramInt, RecyclerView.LayoutManager.LayoutPrefetchRegistry paramLayoutPrefetchRegistry)
  {
    SavedState localSavedState = this.mPendingSavedState;
    int j = -1;
    boolean bool;
    if ((localSavedState != null) && (this.mPendingSavedState.hasValidAnchor()))
    {
      bool = this.mPendingSavedState.mAnchorLayoutFromEnd;
      i = this.mPendingSavedState.mAnchorPosition;
    }
    else
    {
      resolveShouldLayoutReverse();
      bool = this.mShouldReverseLayout;
      if (this.mPendingScrollPosition == -1)
      {
        if (bool) {
          i = paramInt - 1;
        } else {
          i = 0;
        }
      }
      else {
        i = this.mPendingScrollPosition;
      }
    }
    if (!bool) {
      j = 1;
    }
    int m = 0;
    int k = i;
    int i = m;
    while ((i < this.mInitialPrefetchItemCount) && (k >= 0) && (k < paramInt))
    {
      paramLayoutPrefetchRegistry.addPosition(k, 0);
      k += j;
      i += 1;
    }
  }
  
  void collectPrefetchPositionsForLayoutState(RecyclerView.State paramState, LayoutState paramLayoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry paramLayoutPrefetchRegistry)
  {
    int i = paramLayoutState.mCurrentPosition;
    if ((i >= 0) && (i < paramState.getItemCount())) {
      paramLayoutPrefetchRegistry.addPosition(i, Math.max(0, paramLayoutState.mScrollingOffset));
    }
  }
  
  public int computeHorizontalScrollExtent(RecyclerView.State paramState)
  {
    return computeScrollExtent(paramState);
  }
  
  public int computeHorizontalScrollOffset(RecyclerView.State paramState)
  {
    return computeScrollOffset(paramState);
  }
  
  public int computeHorizontalScrollRange(RecyclerView.State paramState)
  {
    return computeScrollRange(paramState);
  }
  
  public PointF computeScrollVectorForPosition(int paramInt)
  {
    if (getChildCount() == 0) {
      return null;
    }
    int k = 0;
    int j = getPosition(getChildAt(0));
    int i = 1;
    if (paramInt < j) {
      k = 1;
    }
    paramInt = i;
    if (k != this.mShouldReverseLayout) {
      paramInt = -1;
    }
    if (this.mOrientation == 0) {
      return new PointF(paramInt, 0.0F);
    }
    return new PointF(0.0F, paramInt);
  }
  
  public int computeVerticalScrollExtent(RecyclerView.State paramState)
  {
    return computeScrollExtent(paramState);
  }
  
  public int computeVerticalScrollOffset(RecyclerView.State paramState)
  {
    return computeScrollOffset(paramState);
  }
  
  public int computeVerticalScrollRange(RecyclerView.State paramState)
  {
    return computeScrollRange(paramState);
  }
  
  int convertFocusDirectionToLayoutDirection(int paramInt)
  {
    int i = Integer.MIN_VALUE;
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
              return Integer.MIN_VALUE;
            case 2: 
              if (this.mOrientation == 1) {
                return 1;
              }
              if (isLayoutRTL()) {
                return -1;
              }
              return 1;
            }
            if (this.mOrientation == 1) {
              return -1;
            }
            if (isLayoutRTL()) {
              return 1;
            }
            return -1;
          }
          if (this.mOrientation == 1) {
            i = 1;
          }
          return i;
        }
        if (this.mOrientation == 0) {
          i = 1;
        }
        return i;
      }
      if (this.mOrientation == 1) {
        return -1;
      }
      return Integer.MIN_VALUE;
    }
    if (this.mOrientation == 0) {
      return -1;
    }
    return Integer.MIN_VALUE;
  }
  
  LayoutState createLayoutState()
  {
    return new LayoutState();
  }
  
  void ensureLayoutState()
  {
    if (this.mLayoutState == null) {
      this.mLayoutState = createLayoutState();
    }
  }
  
  int fill(RecyclerView.Recycler paramRecycler, LayoutState paramLayoutState, RecyclerView.State paramState, boolean paramBoolean)
  {
    int k = paramLayoutState.mAvailable;
    if (paramLayoutState.mScrollingOffset != Integer.MIN_VALUE)
    {
      if (paramLayoutState.mAvailable < 0) {
        paramLayoutState.mScrollingOffset += paramLayoutState.mAvailable;
      }
      recycleByLayoutState(paramRecycler, paramLayoutState);
    }
    int i = paramLayoutState.mAvailable + paramLayoutState.mExtra;
    LayoutChunkResult localLayoutChunkResult = this.mLayoutChunkResult;
    do
    {
      int j;
      do
      {
        if (((!paramLayoutState.mInfinite) && (i <= 0)) || (!paramLayoutState.hasMore(paramState))) {
          break;
        }
        localLayoutChunkResult.resetInternal();
        layoutChunk(paramRecycler, paramState, paramLayoutState, localLayoutChunkResult);
        if (localLayoutChunkResult.mFinished) {
          break;
        }
        paramLayoutState.mOffset += localLayoutChunkResult.mConsumed * paramLayoutState.mLayoutDirection;
        if ((localLayoutChunkResult.mIgnoreConsumed) && (this.mLayoutState.mScrapList == null))
        {
          j = i;
          if (paramState.isPreLayout()) {}
        }
        else
        {
          paramLayoutState.mAvailable -= localLayoutChunkResult.mConsumed;
          j = i - localLayoutChunkResult.mConsumed;
        }
        if (paramLayoutState.mScrollingOffset != Integer.MIN_VALUE)
        {
          paramLayoutState.mScrollingOffset += localLayoutChunkResult.mConsumed;
          if (paramLayoutState.mAvailable < 0) {
            paramLayoutState.mScrollingOffset += paramLayoutState.mAvailable;
          }
          recycleByLayoutState(paramRecycler, paramLayoutState);
        }
        i = j;
      } while (!paramBoolean);
      i = j;
    } while (!localLayoutChunkResult.mFocusable);
    return k - paramLayoutState.mAvailable;
  }
  
  public int findFirstCompletelyVisibleItemPosition()
  {
    View localView = findOneVisibleChild(0, getChildCount(), true, false);
    if (localView == null) {
      return -1;
    }
    return getPosition(localView);
  }
  
  public int findFirstVisibleItemPosition()
  {
    View localView = findOneVisibleChild(0, getChildCount(), false, true);
    if (localView == null) {
      return -1;
    }
    return getPosition(localView);
  }
  
  public int findLastCompletelyVisibleItemPosition()
  {
    View localView = findOneVisibleChild(getChildCount() - 1, -1, true, false);
    if (localView == null) {
      return -1;
    }
    return getPosition(localView);
  }
  
  public int findLastVisibleItemPosition()
  {
    View localView = findOneVisibleChild(getChildCount() - 1, -1, false, true);
    if (localView == null) {
      return -1;
    }
    return getPosition(localView);
  }
  
  View findOnePartiallyOrCompletelyInvisibleChild(int paramInt1, int paramInt2)
  {
    ensureLayoutState();
    int i;
    if (paramInt2 > paramInt1) {
      i = 1;
    } else if (paramInt2 < paramInt1) {
      i = -1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return getChildAt(paramInt1);
    }
    int j;
    if (this.mOrientationHelper.getDecoratedStart(getChildAt(paramInt1)) < this.mOrientationHelper.getStartAfterPadding())
    {
      i = 16644;
      j = 16388;
    }
    else
    {
      i = 4161;
      j = 4097;
    }
    if (this.mOrientation == 0) {
      return this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(paramInt1, paramInt2, i, j);
    }
    return this.mVerticalBoundCheck.findOneViewWithinBoundFlags(paramInt1, paramInt2, i, j);
  }
  
  View findOneVisibleChild(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    ensureLayoutState();
    int j = 320;
    int i;
    if (paramBoolean1) {
      i = 24579;
    } else {
      i = 320;
    }
    if (!paramBoolean2) {
      j = 0;
    }
    if (this.mOrientation == 0) {
      return this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(paramInt1, paramInt2, i, j);
    }
    return this.mVerticalBoundCheck.findOneViewWithinBoundFlags(paramInt1, paramInt2, i, j);
  }
  
  View findReferenceChild(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2, int paramInt3)
  {
    ensureLayoutState();
    int j = this.mOrientationHelper.getStartAfterPadding();
    int k = this.mOrientationHelper.getEndAfterPadding();
    int i;
    if (paramInt2 > paramInt1) {
      i = 1;
    } else {
      i = -1;
    }
    paramState = null;
    Object localObject2;
    for (paramRecycler = null; paramInt1 != paramInt2; paramRecycler = (RecyclerView.Recycler)localObject2)
    {
      View localView = getChildAt(paramInt1);
      int m = getPosition(localView);
      Object localObject1 = paramState;
      localObject2 = paramRecycler;
      if (m >= 0)
      {
        localObject1 = paramState;
        localObject2 = paramRecycler;
        if (m < paramInt3) {
          if (((RecyclerView.LayoutParams)localView.getLayoutParams()).isItemRemoved())
          {
            localObject1 = paramState;
            localObject2 = paramRecycler;
            if (paramRecycler == null)
            {
              localObject2 = localView;
              localObject1 = paramState;
            }
          }
          else
          {
            if ((this.mOrientationHelper.getDecoratedStart(localView) < k) && (this.mOrientationHelper.getDecoratedEnd(localView) >= j)) {
              return localView;
            }
            localObject1 = paramState;
            localObject2 = paramRecycler;
            if (paramState == null)
            {
              localObject1 = localView;
              localObject2 = paramRecycler;
            }
          }
        }
      }
      paramInt1 += i;
      paramState = (RecyclerView.State)localObject1;
    }
    if (paramState != null) {
      return paramState;
    }
    return paramRecycler;
  }
  
  public View findViewByPosition(int paramInt)
  {
    int i = getChildCount();
    if (i == 0) {
      return null;
    }
    int j = paramInt - getPosition(getChildAt(0));
    if ((j >= 0) && (j < i))
    {
      View localView = getChildAt(j);
      if (getPosition(localView) == paramInt) {
        return localView;
      }
    }
    return super.findViewByPosition(paramInt);
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    return new RecyclerView.LayoutParams(-2, -2);
  }
  
  protected int getExtraLayoutSpace(RecyclerView.State paramState)
  {
    if (paramState.hasTargetScrollPosition()) {
      return this.mOrientationHelper.getTotalSpace();
    }
    return 0;
  }
  
  public int getInitialPrefetchItemCount()
  {
    return this.mInitialPrefetchItemCount;
  }
  
  public int getOrientation()
  {
    return this.mOrientation;
  }
  
  public boolean getRecycleChildrenOnDetach()
  {
    return this.mRecycleChildrenOnDetach;
  }
  
  public boolean getReverseLayout()
  {
    return this.mReverseLayout;
  }
  
  public boolean getStackFromEnd()
  {
    return this.mStackFromEnd;
  }
  
  public boolean isAutoMeasureEnabled()
  {
    return true;
  }
  
  protected boolean isLayoutRTL()
  {
    return getLayoutDirection() == 1;
  }
  
  public boolean isSmoothScrollbarEnabled()
  {
    return this.mSmoothScrollbarEnabled;
  }
  
  void layoutChunk(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LayoutState paramLayoutState, LayoutChunkResult paramLayoutChunkResult)
  {
    paramRecycler = paramLayoutState.next(paramRecycler);
    if (paramRecycler == null)
    {
      paramLayoutChunkResult.mFinished = true;
      return;
    }
    paramState = (RecyclerView.LayoutParams)paramRecycler.getLayoutParams();
    boolean bool2;
    boolean bool1;
    if (paramLayoutState.mScrapList == null)
    {
      bool2 = this.mShouldReverseLayout;
      if (paramLayoutState.mLayoutDirection == -1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (bool2 == bool1) {
        addView(paramRecycler);
      } else {
        addView(paramRecycler, 0);
      }
    }
    else
    {
      bool2 = this.mShouldReverseLayout;
      if (paramLayoutState.mLayoutDirection == -1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (bool2 == bool1) {
        addDisappearingView(paramRecycler);
      } else {
        addDisappearingView(paramRecycler, 0);
      }
    }
    measureChildWithMargins(paramRecycler, 0, 0);
    paramLayoutChunkResult.mConsumed = this.mOrientationHelper.getDecoratedMeasurement(paramRecycler);
    int i;
    int m;
    int k;
    int n;
    int j;
    if (this.mOrientation == 1)
    {
      if (isLayoutRTL())
      {
        i = getWidth() - getPaddingRight();
        m = i - this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler);
      }
      else
      {
        m = getPaddingLeft();
        i = this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler) + m;
      }
      if (paramLayoutState.mLayoutDirection == -1)
      {
        k = paramLayoutState.mOffset;
        n = paramLayoutState.mOffset - paramLayoutChunkResult.mConsumed;
        j = i;
        i = n;
      }
      else
      {
        n = paramLayoutState.mOffset;
        k = paramLayoutState.mOffset + paramLayoutChunkResult.mConsumed;
        j = i;
        i = n;
      }
    }
    else
    {
      j = getPaddingTop();
      i = this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler) + j;
      int i1;
      if (paramLayoutState.mLayoutDirection == -1)
      {
        k = paramLayoutState.mOffset;
        m = paramLayoutState.mOffset;
        i1 = paramLayoutChunkResult.mConsumed;
        n = i;
        m -= i1;
        i = j;
        j = k;
        k = n;
      }
      else
      {
        n = paramLayoutState.mOffset;
        i1 = paramLayoutState.mOffset + paramLayoutChunkResult.mConsumed;
        m = j;
        k = i;
        j = i1;
        i = m;
        m = n;
      }
    }
    layoutDecoratedWithMargins(paramRecycler, m, i, j, k);
    if ((paramState.isItemRemoved()) || (paramState.isItemChanged())) {
      paramLayoutChunkResult.mIgnoreConsumed = true;
    }
    paramLayoutChunkResult.mFocusable = paramRecycler.hasFocusable();
  }
  
  void onAnchorReady(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, AnchorInfo paramAnchorInfo, int paramInt) {}
  
  public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.Recycler paramRecycler)
  {
    super.onDetachedFromWindow(paramRecyclerView, paramRecycler);
    if (this.mRecycleChildrenOnDetach)
    {
      removeAndRecycleAllViews(paramRecycler);
      paramRecycler.clear();
    }
  }
  
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    resolveShouldLayoutReverse();
    if (getChildCount() == 0) {
      return null;
    }
    paramInt = convertFocusDirectionToLayoutDirection(paramInt);
    if (paramInt == Integer.MIN_VALUE) {
      return null;
    }
    ensureLayoutState();
    ensureLayoutState();
    updateLayoutState(paramInt, (int)(this.mOrientationHelper.getTotalSpace() * 0.33333334F), false, paramState);
    this.mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
    this.mLayoutState.mRecycle = false;
    fill(paramRecycler, this.mLayoutState, paramState, true);
    if (paramInt == -1) {
      paramView = findPartiallyOrCompletelyInvisibleChildClosestToStart(paramRecycler, paramState);
    } else {
      paramView = findPartiallyOrCompletelyInvisibleChildClosestToEnd(paramRecycler, paramState);
    }
    if (paramInt == -1) {
      paramRecycler = getChildClosestToStart();
    } else {
      paramRecycler = getChildClosestToEnd();
    }
    if (paramRecycler.hasFocusable())
    {
      if (paramView == null) {
        return null;
      }
      return paramRecycler;
    }
    return paramView;
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if (getChildCount() > 0)
    {
      paramAccessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
      paramAccessibilityEvent.setToIndex(findLastVisibleItemPosition());
    }
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    Object localObject = this.mPendingSavedState;
    int k = -1;
    if (((localObject != null) || (this.mPendingScrollPosition != -1)) && (paramState.getItemCount() == 0))
    {
      removeAndRecycleAllViews(paramRecycler);
      return;
    }
    if ((this.mPendingSavedState != null) && (this.mPendingSavedState.hasValidAnchor())) {
      this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
    }
    ensureLayoutState();
    this.mLayoutState.mRecycle = false;
    resolveShouldLayoutReverse();
    localObject = getFocusedChild();
    if ((this.mAnchorInfo.mValid) && (this.mPendingScrollPosition == -1) && (this.mPendingSavedState == null))
    {
      if ((localObject != null) && ((this.mOrientationHelper.getDecoratedStart((View)localObject) >= this.mOrientationHelper.getEndAfterPadding()) || (this.mOrientationHelper.getDecoratedEnd((View)localObject) <= this.mOrientationHelper.getStartAfterPadding()))) {
        this.mAnchorInfo.assignFromViewAndKeepVisibleRect((View)localObject, getPosition((View)localObject));
      }
    }
    else
    {
      this.mAnchorInfo.reset();
      this.mAnchorInfo.mLayoutFromEnd = (this.mShouldReverseLayout ^ this.mStackFromEnd);
      updateAnchorInfoForLayout(paramRecycler, paramState, this.mAnchorInfo);
      this.mAnchorInfo.mValid = true;
    }
    int j = getExtraLayoutSpace(paramState);
    if (this.mLayoutState.mLastScrollDelta >= 0)
    {
      i = j;
      j = 0;
    }
    else
    {
      i = 0;
    }
    int m = j + this.mOrientationHelper.getStartAfterPadding();
    int n = i + this.mOrientationHelper.getEndPadding();
    int i = m;
    j = n;
    if (paramState.isPreLayout())
    {
      i = m;
      j = n;
      if (this.mPendingScrollPosition != -1)
      {
        i = m;
        j = n;
        if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE)
        {
          localObject = findViewByPosition(this.mPendingScrollPosition);
          i = m;
          j = n;
          if (localObject != null)
          {
            if (this.mShouldReverseLayout)
            {
              i = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd((View)localObject) - this.mPendingScrollPositionOffset;
            }
            else
            {
              i = this.mOrientationHelper.getDecoratedStart((View)localObject);
              j = this.mOrientationHelper.getStartAfterPadding();
              i = this.mPendingScrollPositionOffset - (i - j);
            }
            if (i > 0)
            {
              i = m + i;
              j = n;
            }
            else
            {
              j = n - i;
              i = m;
            }
          }
        }
      }
    }
    if (this.mAnchorInfo.mLayoutFromEnd)
    {
      if (!this.mShouldReverseLayout) {}
    }
    else {
      while (!this.mShouldReverseLayout)
      {
        k = 1;
        break;
      }
    }
    onAnchorReady(paramRecycler, paramState, this.mAnchorInfo, k);
    detachAndScrapAttachedViews(paramRecycler);
    this.mLayoutState.mInfinite = resolveIsInfinite();
    this.mLayoutState.mIsPreLayout = paramState.isPreLayout();
    if (this.mAnchorInfo.mLayoutFromEnd)
    {
      updateLayoutStateToFillStart(this.mAnchorInfo);
      this.mLayoutState.mExtra = i;
      fill(paramRecycler, this.mLayoutState, paramState, false);
      k = this.mLayoutState.mOffset;
      n = this.mLayoutState.mCurrentPosition;
      i = j;
      if (this.mLayoutState.mAvailable > 0) {
        i = j + this.mLayoutState.mAvailable;
      }
      updateLayoutStateToFillEnd(this.mAnchorInfo);
      this.mLayoutState.mExtra = i;
      localObject = this.mLayoutState;
      ((LayoutState)localObject).mCurrentPosition += this.mLayoutState.mItemDirection;
      fill(paramRecycler, this.mLayoutState, paramState, false);
      m = this.mLayoutState.mOffset;
      j = k;
      i = m;
      if (this.mLayoutState.mAvailable > 0)
      {
        i = this.mLayoutState.mAvailable;
        updateLayoutStateToFillStart(n, k);
        this.mLayoutState.mExtra = i;
        fill(paramRecycler, this.mLayoutState, paramState, false);
        j = this.mLayoutState.mOffset;
        i = m;
      }
    }
    else
    {
      updateLayoutStateToFillEnd(this.mAnchorInfo);
      this.mLayoutState.mExtra = j;
      fill(paramRecycler, this.mLayoutState, paramState, false);
      k = this.mLayoutState.mOffset;
      n = this.mLayoutState.mCurrentPosition;
      j = i;
      if (this.mLayoutState.mAvailable > 0) {
        j = i + this.mLayoutState.mAvailable;
      }
      updateLayoutStateToFillStart(this.mAnchorInfo);
      this.mLayoutState.mExtra = j;
      localObject = this.mLayoutState;
      ((LayoutState)localObject).mCurrentPosition += this.mLayoutState.mItemDirection;
      fill(paramRecycler, this.mLayoutState, paramState, false);
      m = this.mLayoutState.mOffset;
      j = m;
      i = k;
      if (this.mLayoutState.mAvailable > 0)
      {
        i = this.mLayoutState.mAvailable;
        updateLayoutStateToFillEnd(n, k);
        this.mLayoutState.mExtra = i;
        fill(paramRecycler, this.mLayoutState, paramState, false);
        i = this.mLayoutState.mOffset;
        j = m;
      }
    }
    k = j;
    m = i;
    if (getChildCount() > 0) {
      if ((this.mShouldReverseLayout ^ this.mStackFromEnd))
      {
        m = fixLayoutEndGap(i, paramRecycler, paramState, true);
        k = j + m;
        j = fixLayoutStartGap(k, paramRecycler, paramState, false);
        k += j;
        m = i + m + j;
      }
      else
      {
        k = fixLayoutStartGap(j, paramRecycler, paramState, true);
        i += k;
        m = fixLayoutEndGap(i, paramRecycler, paramState, false);
        k = j + k + m;
        m = i + m;
      }
    }
    layoutForPredictiveAnimations(paramRecycler, paramState, k, m);
    if (!paramState.isPreLayout()) {
      this.mOrientationHelper.onLayoutComplete();
    } else {
      this.mAnchorInfo.reset();
    }
    this.mLastStackFromEnd = this.mStackFromEnd;
  }
  
  public void onLayoutCompleted(RecyclerView.State paramState)
  {
    super.onLayoutCompleted(paramState);
    this.mPendingSavedState = null;
    this.mPendingScrollPosition = -1;
    this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
    this.mAnchorInfo.reset();
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof SavedState))
    {
      this.mPendingSavedState = ((SavedState)paramParcelable);
      requestLayout();
    }
  }
  
  public Parcelable onSaveInstanceState()
  {
    if (this.mPendingSavedState != null) {
      return new SavedState(this.mPendingSavedState);
    }
    SavedState localSavedState = new SavedState();
    if (getChildCount() > 0)
    {
      ensureLayoutState();
      boolean bool = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
      localSavedState.mAnchorLayoutFromEnd = bool;
      if (bool)
      {
        localView = getChildClosestToEnd();
        localSavedState.mAnchorOffset = (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(localView));
        localSavedState.mAnchorPosition = getPosition(localView);
        return localSavedState;
      }
      View localView = getChildClosestToStart();
      localSavedState.mAnchorPosition = getPosition(localView);
      localSavedState.mAnchorOffset = (this.mOrientationHelper.getDecoratedStart(localView) - this.mOrientationHelper.getStartAfterPadding());
      return localSavedState;
    }
    localSavedState.invalidateAnchor();
    return localSavedState;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void prepareForDrop(@NonNull View paramView1, @NonNull View paramView2, int paramInt1, int paramInt2)
  {
    assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
    ensureLayoutState();
    resolveShouldLayoutReverse();
    paramInt1 = getPosition(paramView1);
    paramInt2 = getPosition(paramView2);
    if (paramInt1 < paramInt2) {
      paramInt1 = 1;
    } else {
      paramInt1 = -1;
    }
    if (this.mShouldReverseLayout)
    {
      if (paramInt1 == 1)
      {
        scrollToPositionWithOffset(paramInt2, this.mOrientationHelper.getEndAfterPadding() - (this.mOrientationHelper.getDecoratedStart(paramView2) + this.mOrientationHelper.getDecoratedMeasurement(paramView1)));
        return;
      }
      scrollToPositionWithOffset(paramInt2, this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(paramView2));
      return;
    }
    if (paramInt1 == -1)
    {
      scrollToPositionWithOffset(paramInt2, this.mOrientationHelper.getDecoratedStart(paramView2));
      return;
    }
    scrollToPositionWithOffset(paramInt2, this.mOrientationHelper.getDecoratedEnd(paramView2) - this.mOrientationHelper.getDecoratedMeasurement(paramView1));
  }
  
  boolean resolveIsInfinite()
  {
    return (this.mOrientationHelper.getMode() == 0) && (this.mOrientationHelper.getEnd() == 0);
  }
  
  int scrollBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (getChildCount() != 0)
    {
      if (paramInt == 0) {
        return 0;
      }
      this.mLayoutState.mRecycle = true;
      ensureLayoutState();
      int i;
      if (paramInt > 0) {
        i = 1;
      } else {
        i = -1;
      }
      int j = Math.abs(paramInt);
      updateLayoutState(i, j, true, paramState);
      int k = this.mLayoutState.mScrollingOffset + fill(paramRecycler, this.mLayoutState, paramState, false);
      if (k < 0) {
        return 0;
      }
      if (j > k) {
        paramInt = i * k;
      }
      this.mOrientationHelper.offsetChildren(-paramInt);
      this.mLayoutState.mLastScrollDelta = paramInt;
      return paramInt;
    }
    return 0;
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mOrientation == 1) {
      return 0;
    }
    return scrollBy(paramInt, paramRecycler, paramState);
  }
  
  public void scrollToPosition(int paramInt)
  {
    this.mPendingScrollPosition = paramInt;
    this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
    if (this.mPendingSavedState != null) {
      this.mPendingSavedState.invalidateAnchor();
    }
    requestLayout();
  }
  
  public void scrollToPositionWithOffset(int paramInt1, int paramInt2)
  {
    this.mPendingScrollPosition = paramInt1;
    this.mPendingScrollPositionOffset = paramInt2;
    if (this.mPendingSavedState != null) {
      this.mPendingSavedState.invalidateAnchor();
    }
    requestLayout();
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mOrientation == 0) {
      return 0;
    }
    return scrollBy(paramInt, paramRecycler, paramState);
  }
  
  public void setInitialPrefetchItemCount(int paramInt)
  {
    this.mInitialPrefetchItemCount = paramInt;
  }
  
  public void setOrientation(int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("invalid orientation:");
      localStringBuilder.append(paramInt);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    assertNotInLayoutOrScroll(null);
    if ((paramInt != this.mOrientation) || (this.mOrientationHelper == null))
    {
      this.mOrientationHelper = OrientationHelper.createOrientationHelper(this, paramInt);
      this.mAnchorInfo.mOrientationHelper = this.mOrientationHelper;
      this.mOrientation = paramInt;
      requestLayout();
    }
  }
  
  public void setRecycleChildrenOnDetach(boolean paramBoolean)
  {
    this.mRecycleChildrenOnDetach = paramBoolean;
  }
  
  public void setReverseLayout(boolean paramBoolean)
  {
    assertNotInLayoutOrScroll(null);
    if (paramBoolean == this.mReverseLayout) {
      return;
    }
    this.mReverseLayout = paramBoolean;
    requestLayout();
  }
  
  public void setSmoothScrollbarEnabled(boolean paramBoolean)
  {
    this.mSmoothScrollbarEnabled = paramBoolean;
  }
  
  public void setStackFromEnd(boolean paramBoolean)
  {
    assertNotInLayoutOrScroll(null);
    if (this.mStackFromEnd == paramBoolean) {
      return;
    }
    this.mStackFromEnd = paramBoolean;
    requestLayout();
  }
  
  boolean shouldMeasureTwice()
  {
    return (getHeightMode() != 1073741824) && (getWidthMode() != 1073741824) && (hasFlexibleChildInBothOrientations());
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.State paramState, int paramInt)
  {
    paramRecyclerView = new LinearSmoothScroller(paramRecyclerView.getContext());
    paramRecyclerView.setTargetPosition(paramInt);
    startSmoothScroll(paramRecyclerView);
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    return (this.mPendingSavedState == null) && (this.mLastStackFromEnd == this.mStackFromEnd);
  }
  
  void validateChildOrder()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("validating child count ");
    ((StringBuilder)localObject).append(getChildCount());
    Log.d("LinearLayoutManager", ((StringBuilder)localObject).toString());
    if (getChildCount() < 1) {
      return;
    }
    boolean bool2 = false;
    boolean bool1 = false;
    int j = getPosition(getChildAt(0));
    int k = this.mOrientationHelper.getDecoratedStart(getChildAt(0));
    int m;
    int n;
    if (this.mShouldReverseLayout)
    {
      i = 1;
      for (;;)
      {
        if (i >= getChildCount()) {
          return;
        }
        localObject = getChildAt(i);
        m = getPosition((View)localObject);
        n = this.mOrientationHelper.getDecoratedStart((View)localObject);
        if (m < j)
        {
          logChildren();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("detected invalid position. loc invalid? ");
          if (n < k) {
            bool1 = true;
          }
          ((StringBuilder)localObject).append(bool1);
          throw new RuntimeException(((StringBuilder)localObject).toString());
        }
        if (n > k) {
          break;
        }
        i += 1;
      }
      logChildren();
      throw new RuntimeException("detected invalid location");
    }
    int i = 1;
    while (i < getChildCount())
    {
      localObject = getChildAt(i);
      m = getPosition((View)localObject);
      n = this.mOrientationHelper.getDecoratedStart((View)localObject);
      if (m < j)
      {
        logChildren();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("detected invalid position. loc invalid? ");
        bool1 = bool2;
        if (n < k) {
          bool1 = true;
        }
        ((StringBuilder)localObject).append(bool1);
        throw new RuntimeException(((StringBuilder)localObject).toString());
      }
      if (n >= k)
      {
        i += 1;
      }
      else
      {
        logChildren();
        throw new RuntimeException("detected invalid location");
      }
    }
  }
  
  static class AnchorInfo
  {
    int mCoordinate;
    boolean mLayoutFromEnd;
    OrientationHelper mOrientationHelper;
    int mPosition;
    boolean mValid;
    
    AnchorInfo()
    {
      reset();
    }
    
    void assignCoordinateFromPadding()
    {
      int i;
      if (this.mLayoutFromEnd) {
        i = this.mOrientationHelper.getEndAfterPadding();
      } else {
        i = this.mOrientationHelper.getStartAfterPadding();
      }
      this.mCoordinate = i;
    }
    
    public void assignFromView(View paramView, int paramInt)
    {
      if (this.mLayoutFromEnd) {
        this.mCoordinate = (this.mOrientationHelper.getDecoratedEnd(paramView) + this.mOrientationHelper.getTotalSpaceChange());
      } else {
        this.mCoordinate = this.mOrientationHelper.getDecoratedStart(paramView);
      }
      this.mPosition = paramInt;
    }
    
    public void assignFromViewAndKeepVisibleRect(View paramView, int paramInt)
    {
      int i = this.mOrientationHelper.getTotalSpaceChange();
      if (i >= 0)
      {
        assignFromView(paramView, paramInt);
        return;
      }
      this.mPosition = paramInt;
      int j;
      int k;
      if (this.mLayoutFromEnd)
      {
        paramInt = this.mOrientationHelper.getEndAfterPadding() - i - this.mOrientationHelper.getDecoratedEnd(paramView);
        this.mCoordinate = (this.mOrientationHelper.getEndAfterPadding() - paramInt);
        if (paramInt > 0)
        {
          i = this.mOrientationHelper.getDecoratedMeasurement(paramView);
          j = this.mCoordinate;
          k = this.mOrientationHelper.getStartAfterPadding();
          i = j - i - (k + Math.min(this.mOrientationHelper.getDecoratedStart(paramView) - k, 0));
          if (i < 0) {
            this.mCoordinate += Math.min(paramInt, -i);
          }
        }
      }
      else
      {
        j = this.mOrientationHelper.getDecoratedStart(paramView);
        paramInt = j - this.mOrientationHelper.getStartAfterPadding();
        this.mCoordinate = j;
        if (paramInt > 0)
        {
          k = this.mOrientationHelper.getDecoratedMeasurement(paramView);
          int m = this.mOrientationHelper.getEndAfterPadding();
          int n = this.mOrientationHelper.getDecoratedEnd(paramView);
          i = this.mOrientationHelper.getEndAfterPadding() - Math.min(0, m - i - n) - (j + k);
          if (i < 0) {
            this.mCoordinate -= Math.min(paramInt, -i);
          }
        }
      }
    }
    
    boolean isViewValidAsAnchor(View paramView, RecyclerView.State paramState)
    {
      paramView = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      return (!paramView.isItemRemoved()) && (paramView.getViewLayoutPosition() >= 0) && (paramView.getViewLayoutPosition() < paramState.getItemCount());
    }
    
    void reset()
    {
      this.mPosition = -1;
      this.mCoordinate = Integer.MIN_VALUE;
      this.mLayoutFromEnd = false;
      this.mValid = false;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AnchorInfo{mPosition=");
      localStringBuilder.append(this.mPosition);
      localStringBuilder.append(", mCoordinate=");
      localStringBuilder.append(this.mCoordinate);
      localStringBuilder.append(", mLayoutFromEnd=");
      localStringBuilder.append(this.mLayoutFromEnd);
      localStringBuilder.append(", mValid=");
      localStringBuilder.append(this.mValid);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
  
  protected static class LayoutChunkResult
  {
    public int mConsumed;
    public boolean mFinished;
    public boolean mFocusable;
    public boolean mIgnoreConsumed;
    
    void resetInternal()
    {
      this.mConsumed = 0;
      this.mFinished = false;
      this.mIgnoreConsumed = false;
      this.mFocusable = false;
    }
  }
  
  static class LayoutState
  {
    static final int INVALID_LAYOUT = Integer.MIN_VALUE;
    static final int ITEM_DIRECTION_HEAD = -1;
    static final int ITEM_DIRECTION_TAIL = 1;
    static final int LAYOUT_END = 1;
    static final int LAYOUT_START = -1;
    static final int SCROLLING_OFFSET_NaN = Integer.MIN_VALUE;
    static final String TAG = "LLM#LayoutState";
    int mAvailable;
    int mCurrentPosition;
    int mExtra = 0;
    boolean mInfinite;
    boolean mIsPreLayout = false;
    int mItemDirection;
    int mLastScrollDelta;
    int mLayoutDirection;
    int mOffset;
    boolean mRecycle = true;
    List<RecyclerView.ViewHolder> mScrapList = null;
    int mScrollingOffset;
    
    private View nextViewFromScrapList()
    {
      int j = this.mScrapList.size();
      int i = 0;
      while (i < j)
      {
        View localView = ((RecyclerView.ViewHolder)this.mScrapList.get(i)).itemView;
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
        if ((!localLayoutParams.isItemRemoved()) && (this.mCurrentPosition == localLayoutParams.getViewLayoutPosition()))
        {
          assignPositionFromScrapList(localView);
          return localView;
        }
        i += 1;
      }
      return null;
    }
    
    public void assignPositionFromScrapList()
    {
      assignPositionFromScrapList(null);
    }
    
    public void assignPositionFromScrapList(View paramView)
    {
      paramView = nextViewInLimitedList(paramView);
      if (paramView == null)
      {
        this.mCurrentPosition = -1;
        return;
      }
      this.mCurrentPosition = ((RecyclerView.LayoutParams)paramView.getLayoutParams()).getViewLayoutPosition();
    }
    
    boolean hasMore(RecyclerView.State paramState)
    {
      return (this.mCurrentPosition >= 0) && (this.mCurrentPosition < paramState.getItemCount());
    }
    
    void log()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("avail:");
      localStringBuilder.append(this.mAvailable);
      localStringBuilder.append(", ind:");
      localStringBuilder.append(this.mCurrentPosition);
      localStringBuilder.append(", dir:");
      localStringBuilder.append(this.mItemDirection);
      localStringBuilder.append(", offset:");
      localStringBuilder.append(this.mOffset);
      localStringBuilder.append(", layoutDir:");
      localStringBuilder.append(this.mLayoutDirection);
      Log.d("LLM#LayoutState", localStringBuilder.toString());
    }
    
    View next(RecyclerView.Recycler paramRecycler)
    {
      if (this.mScrapList != null) {
        return nextViewFromScrapList();
      }
      paramRecycler = paramRecycler.getViewForPosition(this.mCurrentPosition);
      this.mCurrentPosition += this.mItemDirection;
      return paramRecycler;
    }
    
    public View nextViewInLimitedList(View paramView)
    {
      int n = this.mScrapList.size();
      Object localObject1 = null;
      int j = Integer.MAX_VALUE;
      int i = 0;
      while (i < n)
      {
        View localView = ((RecyclerView.ViewHolder)this.mScrapList.get(i)).itemView;
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
        Object localObject2 = localObject1;
        int k = j;
        if (localView != paramView) {
          if (localLayoutParams.isItemRemoved())
          {
            localObject2 = localObject1;
            k = j;
          }
          else
          {
            int m = (localLayoutParams.getViewLayoutPosition() - this.mCurrentPosition) * this.mItemDirection;
            if (m < 0)
            {
              localObject2 = localObject1;
              k = j;
            }
            else
            {
              localObject2 = localObject1;
              k = j;
              if (m < j)
              {
                if (m == 0) {
                  return localView;
                }
                localObject2 = localView;
                k = m;
              }
            }
          }
        }
        i += 1;
        localObject1 = localObject2;
        j = k;
      }
      return (View)localObject1;
    }
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static class SavedState
    implements Parcelable
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public LinearLayoutManager.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new LinearLayoutManager.SavedState(paramAnonymousParcel);
      }
      
      public LinearLayoutManager.SavedState[] newArray(int paramAnonymousInt)
      {
        return new LinearLayoutManager.SavedState[paramAnonymousInt];
      }
    };
    boolean mAnchorLayoutFromEnd;
    int mAnchorOffset;
    int mAnchorPosition;
    
    public SavedState() {}
    
    SavedState(Parcel paramParcel)
    {
      this.mAnchorPosition = paramParcel.readInt();
      this.mAnchorOffset = paramParcel.readInt();
      int i = paramParcel.readInt();
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      this.mAnchorLayoutFromEnd = bool;
    }
    
    public SavedState(SavedState paramSavedState)
    {
      this.mAnchorPosition = paramSavedState.mAnchorPosition;
      this.mAnchorOffset = paramSavedState.mAnchorOffset;
      this.mAnchorLayoutFromEnd = paramSavedState.mAnchorLayoutFromEnd;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    boolean hasValidAnchor()
    {
      return this.mAnchorPosition >= 0;
    }
    
    void invalidateAnchor()
    {
      this.mAnchorPosition = -1;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\widget\LinearLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */