package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

public class GridLayoutManager
  extends LinearLayoutManager
{
  private static final boolean DEBUG = false;
  public static final int DEFAULT_SPAN_COUNT = -1;
  private static final String TAG = "GridLayoutManager";
  int[] mCachedBorders;
  final Rect mDecorInsets = new Rect();
  boolean mPendingSpanCountChange = false;
  final SparseIntArray mPreLayoutSpanIndexCache = new SparseIntArray();
  final SparseIntArray mPreLayoutSpanSizeCache = new SparseIntArray();
  View[] mSet;
  int mSpanCount = -1;
  SpanSizeLookup mSpanSizeLookup = new DefaultSpanSizeLookup();
  
  public GridLayoutManager(Context paramContext, int paramInt)
  {
    super(paramContext);
    setSpanCount(paramInt);
  }
  
  public GridLayoutManager(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramContext, paramInt2, paramBoolean);
    setSpanCount(paramInt1);
  }
  
  public GridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setSpanCount(getProperties(paramContext, paramAttributeSet, paramInt1, paramInt2).spanCount);
  }
  
  private void assignSpans(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    paramInt2 = -1;
    int j = 0;
    int i;
    if (paramBoolean)
    {
      paramInt2 = paramInt1;
      paramInt1 = 0;
      i = 1;
    }
    else
    {
      paramInt1 -= 1;
      i = -1;
    }
    while (paramInt1 != paramInt2)
    {
      View localView = this.mSet[paramInt1];
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      localLayoutParams.mSpanSize = getSpanSize(paramRecycler, paramState, getPosition(localView));
      localLayoutParams.mSpanIndex = j;
      j += localLayoutParams.mSpanSize;
      paramInt1 += i;
    }
  }
  
  private void cachePreLayoutSpanMapping()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      LayoutParams localLayoutParams = (LayoutParams)getChildAt(i).getLayoutParams();
      int k = localLayoutParams.getViewLayoutPosition();
      this.mPreLayoutSpanSizeCache.put(k, localLayoutParams.getSpanSize());
      this.mPreLayoutSpanIndexCache.put(k, localLayoutParams.getSpanIndex());
      i += 1;
    }
  }
  
  private void calculateItemBorders(int paramInt)
  {
    this.mCachedBorders = calculateItemBorders(this.mCachedBorders, this.mSpanCount, paramInt);
  }
  
  static int[] calculateItemBorders(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int j = 1;
    int[] arrayOfInt;
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length == paramInt1 + 1))
    {
      arrayOfInt = paramArrayOfInt;
      if (paramArrayOfInt[(paramArrayOfInt.length - 1)] == paramInt2) {}
    }
    else
    {
      arrayOfInt = new int[paramInt1 + 1];
    }
    int k = 0;
    arrayOfInt[0] = 0;
    int m = paramInt2 / paramInt1;
    int n = paramInt2 % paramInt1;
    int i = 0;
    paramInt2 = k;
    while (j <= paramInt1)
    {
      paramInt2 += n;
      if ((paramInt2 > 0) && (paramInt1 - paramInt2 < n))
      {
        k = m + 1;
        paramInt2 -= paramInt1;
      }
      else
      {
        k = m;
      }
      i += k;
      arrayOfInt[j] = i;
      j += 1;
    }
    return arrayOfInt;
  }
  
  private void clearPreLayoutSpanMappingCache()
  {
    this.mPreLayoutSpanSizeCache.clear();
    this.mPreLayoutSpanIndexCache.clear();
  }
  
  private void ensureAnchorIsInCorrectSpan(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LinearLayoutManager.AnchorInfo paramAnchorInfo, int paramInt)
  {
    if (paramInt == 1) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    int i = getSpanIndex(paramRecycler, paramState, paramAnchorInfo.mPosition);
    if (paramInt != 0) {
      while ((i > 0) && (paramAnchorInfo.mPosition > 0))
      {
        paramAnchorInfo.mPosition -= 1;
        i = getSpanIndex(paramRecycler, paramState, paramAnchorInfo.mPosition);
      }
    }
    int m = paramState.getItemCount();
    paramInt = paramAnchorInfo.mPosition;
    while (paramInt < m - 1)
    {
      int k = paramInt + 1;
      int j = getSpanIndex(paramRecycler, paramState, k);
      if (j <= i) {
        break;
      }
      paramInt = k;
      i = j;
    }
    paramAnchorInfo.mPosition = paramInt;
  }
  
  private void ensureViewSet()
  {
    if ((this.mSet == null) || (this.mSet.length != this.mSpanCount)) {
      this.mSet = new View[this.mSpanCount];
    }
  }
  
  private int getSpanGroupIndex(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt)
  {
    if (!paramState.isPreLayout()) {
      return this.mSpanSizeLookup.getSpanGroupIndex(paramInt, this.mSpanCount);
    }
    int i = paramRecycler.convertPreLayoutPositionToPostLayout(paramInt);
    if (i == -1)
    {
      paramRecycler = new StringBuilder();
      paramRecycler.append("Cannot find span size for pre layout position. ");
      paramRecycler.append(paramInt);
      Log.w("GridLayoutManager", paramRecycler.toString());
      return 0;
    }
    return this.mSpanSizeLookup.getSpanGroupIndex(i, this.mSpanCount);
  }
  
  private int getSpanIndex(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt)
  {
    if (!paramState.isPreLayout()) {
      return this.mSpanSizeLookup.getCachedSpanIndex(paramInt, this.mSpanCount);
    }
    int i = this.mPreLayoutSpanIndexCache.get(paramInt, -1);
    if (i != -1) {
      return i;
    }
    i = paramRecycler.convertPreLayoutPositionToPostLayout(paramInt);
    if (i == -1)
    {
      paramRecycler = new StringBuilder();
      paramRecycler.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
      paramRecycler.append(paramInt);
      Log.w("GridLayoutManager", paramRecycler.toString());
      return 0;
    }
    return this.mSpanSizeLookup.getCachedSpanIndex(i, this.mSpanCount);
  }
  
  private int getSpanSize(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt)
  {
    if (!paramState.isPreLayout()) {
      return this.mSpanSizeLookup.getSpanSize(paramInt);
    }
    int i = this.mPreLayoutSpanSizeCache.get(paramInt, -1);
    if (i != -1) {
      return i;
    }
    i = paramRecycler.convertPreLayoutPositionToPostLayout(paramInt);
    if (i == -1)
    {
      paramRecycler = new StringBuilder();
      paramRecycler.append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
      paramRecycler.append(paramInt);
      Log.w("GridLayoutManager", paramRecycler.toString());
      return 1;
    }
    return this.mSpanSizeLookup.getSpanSize(i);
  }
  
  private void guessMeasurement(float paramFloat, int paramInt)
  {
    calculateItemBorders(Math.max(Math.round(paramFloat * this.mSpanCount), paramInt));
  }
  
  private void measureChild(View paramView, int paramInt, boolean paramBoolean)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    Rect localRect = localLayoutParams.mDecorInsets;
    int j = localRect.top + localRect.bottom + localLayoutParams.topMargin + localLayoutParams.bottomMargin;
    int i = localRect.left + localRect.right + localLayoutParams.leftMargin + localLayoutParams.rightMargin;
    int k = getSpaceForSpanRange(localLayoutParams.mSpanIndex, localLayoutParams.mSpanSize);
    if (this.mOrientation == 1)
    {
      i = getChildMeasureSpec(k, paramInt, i, localLayoutParams.width, false);
      paramInt = getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getHeightMode(), j, localLayoutParams.height, true);
    }
    else
    {
      paramInt = getChildMeasureSpec(k, paramInt, j, localLayoutParams.height, false);
      i = getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getWidthMode(), i, localLayoutParams.width, true);
    }
    measureChildWithDecorationsAndMargin(paramView, i, paramInt, paramBoolean);
  }
  
  private void measureChildWithDecorationsAndMargin(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
    if (paramBoolean) {
      paramBoolean = shouldReMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams);
    } else {
      paramBoolean = shouldMeasureChild(paramView, paramInt1, paramInt2, localLayoutParams);
    }
    if (paramBoolean) {
      paramView.measure(paramInt1, paramInt2);
    }
  }
  
  private void updateMeasurements()
  {
    int i;
    if (getOrientation() == 1) {
      i = getWidth() - getPaddingRight() - getPaddingLeft();
    } else {
      i = getHeight() - getPaddingBottom() - getPaddingTop();
    }
    calculateItemBorders(i);
  }
  
  public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  void collectPrefetchPositionsForLayoutState(RecyclerView.State paramState, LinearLayoutManager.LayoutState paramLayoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry paramLayoutPrefetchRegistry)
  {
    int j = this.mSpanCount;
    int i = 0;
    while ((i < this.mSpanCount) && (paramLayoutState.hasMore(paramState)) && (j > 0))
    {
      int k = paramLayoutState.mCurrentPosition;
      paramLayoutPrefetchRegistry.addPosition(k, Math.max(0, paramLayoutState.mScrollingOffset));
      j -= this.mSpanSizeLookup.getSpanSize(k);
      paramLayoutState.mCurrentPosition += paramLayoutState.mItemDirection;
      i += 1;
    }
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
    Object localObject2 = null;
    Object localObject4;
    for (Object localObject1 = null; paramInt1 != paramInt2; localObject1 = localObject4)
    {
      View localView = getChildAt(paramInt1);
      int m = getPosition(localView);
      Object localObject3 = localObject2;
      localObject4 = localObject1;
      if (m >= 0)
      {
        localObject3 = localObject2;
        localObject4 = localObject1;
        if (m < paramInt3) {
          if (getSpanIndex(paramRecycler, paramState, m) != 0)
          {
            localObject3 = localObject2;
            localObject4 = localObject1;
          }
          else if (((RecyclerView.LayoutParams)localView.getLayoutParams()).isItemRemoved())
          {
            localObject3 = localObject2;
            localObject4 = localObject1;
            if (localObject1 == null)
            {
              localObject4 = localView;
              localObject3 = localObject2;
            }
          }
          else
          {
            if ((this.mOrientationHelper.getDecoratedStart(localView) < k) && (this.mOrientationHelper.getDecoratedEnd(localView) >= j)) {
              return localView;
            }
            localObject3 = localObject2;
            localObject4 = localObject1;
            if (localObject2 == null)
            {
              localObject3 = localView;
              localObject4 = localObject1;
            }
          }
        }
      }
      paramInt1 += i;
      localObject2 = localObject3;
    }
    if (localObject2 != null) {
      return (View)localObject2;
    }
    return (View)localObject1;
  }
  
  public RecyclerView.LayoutParams generateDefaultLayoutParams()
  {
    if (this.mOrientation == 0) {
      return new LayoutParams(-2, -1);
    }
    return new LayoutParams(-1, -2);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    return new LayoutParams(paramContext, paramAttributeSet);
  }
  
  public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getColumnCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mOrientation == 1) {
      return this.mSpanCount;
    }
    if (paramState.getItemCount() < 1) {
      return 0;
    }
    return getSpanGroupIndex(paramRecycler, paramState, paramState.getItemCount() - 1) + 1;
  }
  
  public int getRowCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (this.mOrientation == 0) {
      return this.mSpanCount;
    }
    if (paramState.getItemCount() < 1) {
      return 0;
    }
    return getSpanGroupIndex(paramRecycler, paramState, paramState.getItemCount() - 1) + 1;
  }
  
  int getSpaceForSpanRange(int paramInt1, int paramInt2)
  {
    if ((this.mOrientation == 1) && (isLayoutRTL())) {
      return this.mCachedBorders[(this.mSpanCount - paramInt1)] - this.mCachedBorders[(this.mSpanCount - paramInt1 - paramInt2)];
    }
    return this.mCachedBorders[(paramInt2 + paramInt1)] - this.mCachedBorders[paramInt1];
  }
  
  public int getSpanCount()
  {
    return this.mSpanCount;
  }
  
  public SpanSizeLookup getSpanSizeLookup()
  {
    return this.mSpanSizeLookup;
  }
  
  void layoutChunk(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LinearLayoutManager.LayoutState paramLayoutState, LinearLayoutManager.LayoutChunkResult paramLayoutChunkResult)
  {
    int i3 = this.mOrientationHelper.getModeInOther();
    int k;
    if (i3 != 1073741824) {
      k = 1;
    } else {
      k = 0;
    }
    int m;
    if (getChildCount() > 0) {
      m = this.mCachedBorders[this.mSpanCount];
    } else {
      m = 0;
    }
    if (k != 0) {
      updateMeasurements();
    }
    boolean bool;
    if (paramLayoutState.mItemDirection == 1) {
      bool = true;
    } else {
      bool = false;
    }
    int i = this.mSpanCount;
    if (!bool) {
      i = getSpanIndex(paramRecycler, paramState, paramLayoutState.mCurrentPosition) + getSpanSize(paramRecycler, paramState, paramLayoutState.mCurrentPosition);
    }
    int j = 0;
    int n = 0;
    int i2;
    Object localObject;
    while ((n < this.mSpanCount) && (paramLayoutState.hasMore(paramState)) && (i > 0))
    {
      i2 = paramLayoutState.mCurrentPosition;
      i1 = getSpanSize(paramRecycler, paramState, i2);
      if (i1 <= this.mSpanCount)
      {
        i -= i1;
        if (i >= 0)
        {
          localObject = paramLayoutState.next(paramRecycler);
          if (localObject != null)
          {
            j += i1;
            this.mSet[n] = localObject;
            n += 1;
          }
        }
      }
      else
      {
        paramRecycler = new StringBuilder();
        paramRecycler.append("Item at position ");
        paramRecycler.append(i2);
        paramRecycler.append(" requires ");
        paramRecycler.append(i1);
        paramRecycler.append(" spans but GridLayoutManager has only ");
        paramRecycler.append(this.mSpanCount);
        paramRecycler.append(" spans.");
        throw new IllegalArgumentException(paramRecycler.toString());
      }
    }
    if (n == 0)
    {
      paramLayoutChunkResult.mFinished = true;
      return;
    }
    float f1 = 0.0F;
    assignSpans(paramRecycler, paramState, n, j, bool);
    j = 0;
    i = 0;
    while (j < n)
    {
      paramRecycler = this.mSet[j];
      if (paramLayoutState.mScrapList == null)
      {
        if (bool) {
          addView(paramRecycler);
        } else {
          addView(paramRecycler, 0);
        }
      }
      else if (bool) {
        addDisappearingView(paramRecycler);
      } else {
        addDisappearingView(paramRecycler, 0);
      }
      calculateItemDecorationsForChild(paramRecycler, this.mDecorInsets);
      measureChild(paramRecycler, i3, false);
      i2 = this.mOrientationHelper.getDecoratedMeasurement(paramRecycler);
      i1 = i;
      if (i2 > i) {
        i1 = i2;
      }
      paramState = (LayoutParams)paramRecycler.getLayoutParams();
      float f3 = this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler) * 1.0F / paramState.mSpanSize;
      float f2 = f1;
      if (f3 > f1) {
        f2 = f3;
      }
      j += 1;
      i = i1;
      f1 = f2;
    }
    j = i;
    if (k != 0)
    {
      guessMeasurement(f1, m);
      k = 0;
      for (i = 0;; i = j)
      {
        j = i;
        if (k >= n) {
          break;
        }
        paramRecycler = this.mSet[k];
        measureChild(paramRecycler, 1073741824, true);
        m = this.mOrientationHelper.getDecoratedMeasurement(paramRecycler);
        j = i;
        if (m > i) {
          j = m;
        }
        k += 1;
      }
    }
    i = 0;
    while (i < n)
    {
      paramRecycler = this.mSet[i];
      if (this.mOrientationHelper.getDecoratedMeasurement(paramRecycler) != j)
      {
        paramState = (LayoutParams)paramRecycler.getLayoutParams();
        localObject = paramState.mDecorInsets;
        m = ((Rect)localObject).top + ((Rect)localObject).bottom + paramState.topMargin + paramState.bottomMargin;
        k = ((Rect)localObject).left + ((Rect)localObject).right + paramState.leftMargin + paramState.rightMargin;
        i1 = getSpaceForSpanRange(paramState.mSpanIndex, paramState.mSpanSize);
        if (this.mOrientation == 1)
        {
          k = getChildMeasureSpec(i1, 1073741824, k, paramState.width, false);
          m = View.MeasureSpec.makeMeasureSpec(j - m, 1073741824);
        }
        else
        {
          k = View.MeasureSpec.makeMeasureSpec(j - k, 1073741824);
          m = getChildMeasureSpec(i1, 1073741824, m, paramState.height, false);
        }
        measureChildWithDecorationsAndMargin(paramRecycler, k, m, true);
      }
      i += 1;
    }
    int i1 = 0;
    paramLayoutChunkResult.mConsumed = j;
    if (this.mOrientation == 1)
    {
      if (paramLayoutState.mLayoutDirection == -1)
      {
        k = paramLayoutState.mOffset;
        i = k;
        k -= j;
        j = i;
        i = k;
      }
      for (;;)
      {
        k = 0;
        m = 0;
        break;
        k = paramLayoutState.mOffset;
        i = k;
        j += k;
      }
    }
    if (paramLayoutState.mLayoutDirection == -1)
    {
      k = paramLayoutState.mOffset;
      i = 0;
      i2 = 0;
      m = k;
      k -= j;
      j = i2;
    }
    else
    {
      k = paramLayoutState.mOffset;
      m = j + k;
      i = 0;
      j = 0;
    }
    while (i1 < n)
    {
      paramRecycler = this.mSet[i1];
      paramState = (LayoutParams)paramRecycler.getLayoutParams();
      if (this.mOrientation == 1)
      {
        if (isLayoutRTL())
        {
          m = getPaddingLeft() + this.mCachedBorders[(this.mSpanCount - paramState.mSpanIndex)];
          i2 = this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler);
          k = m;
          m -= i2;
          break label1071;
        }
        k = getPaddingLeft() + this.mCachedBorders[paramState.mSpanIndex];
        m = this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler) + k;
      }
      else
      {
        i = getPaddingTop() + this.mCachedBorders[paramState.mSpanIndex];
        j = this.mOrientationHelper.getDecoratedMeasurementInOther(paramRecycler) + i;
      }
      i2 = k;
      k = m;
      m = i2;
      label1071:
      layoutDecoratedWithMargins(paramRecycler, m, i, k, j);
      if ((paramState.isItemRemoved()) || (paramState.isItemChanged())) {
        paramLayoutChunkResult.mIgnoreConsumed = true;
      }
      paramLayoutChunkResult.mFocusable |= paramRecycler.hasFocusable();
      i2 = i1 + 1;
      i1 = k;
      k = m;
      m = i1;
      i1 = i2;
    }
    Arrays.fill(this.mSet, null);
  }
  
  void onAnchorReady(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, LinearLayoutManager.AnchorInfo paramAnchorInfo, int paramInt)
  {
    super.onAnchorReady(paramRecycler, paramState, paramAnchorInfo, paramInt);
    updateMeasurements();
    if ((paramState.getItemCount() > 0) && (!paramState.isPreLayout())) {
      ensureAnchorIsInCorrectSpan(paramRecycler, paramState, paramAnchorInfo, paramInt);
    }
    ensureViewSet();
  }
  
  public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    View localView = findContainingItemView(paramView);
    Object localObject1 = null;
    if (localView == null) {
      return null;
    }
    Object localObject2 = (LayoutParams)localView.getLayoutParams();
    int i5 = ((LayoutParams)localObject2).mSpanIndex;
    int i6 = ((LayoutParams)localObject2).mSpanIndex + ((LayoutParams)localObject2).mSpanSize;
    if (super.onFocusSearchFailed(paramView, paramInt, paramRecycler, paramState) == null) {
      return null;
    }
    int i11;
    if (convertFocusDirectionToLayoutDirection(paramInt) == 1) {
      i11 = 1;
    } else {
      i11 = 0;
    }
    if (i11 != this.mShouldReverseLayout) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    int k;
    int m;
    if (paramInt != 0)
    {
      k = getChildCount() - 1;
      i = -1;
      m = -1;
    }
    else
    {
      i = getChildCount();
      k = 0;
      m = 1;
    }
    int n;
    if ((this.mOrientation == 1) && (isLayoutRTL())) {
      n = 1;
    } else {
      n = 0;
    }
    int i7 = getSpanGroupIndex(paramRecycler, paramState, k);
    paramView = null;
    int i3 = -1;
    int i2 = 0;
    paramInt = 0;
    int j = -1;
    int i1 = i;
    int i = i3;
    while (k != i1)
    {
      i3 = getSpanGroupIndex(paramRecycler, paramState, k);
      localObject2 = getChildAt(k);
      if (localObject2 == localView) {
        break;
      }
      if ((((View)localObject2).hasFocusable()) && (i3 != i7))
      {
        if (localObject1 != null) {
          break;
        }
      }
      else
      {
        LayoutParams localLayoutParams = (LayoutParams)((View)localObject2).getLayoutParams();
        int i8 = localLayoutParams.mSpanIndex;
        int i9 = localLayoutParams.mSpanIndex + localLayoutParams.mSpanSize;
        if ((((View)localObject2).hasFocusable()) && (i8 == i5) && (i9 == i6)) {
          return (View)localObject2;
        }
        if (((((View)localObject2).hasFocusable()) && (localObject1 == null)) || ((!((View)localObject2).hasFocusable()) && (paramView == null))) {}
        do
        {
          int i10;
          int i4;
          do
          {
            for (;;)
            {
              i3 = 1;
              break label466;
              i3 = Math.max(i8, i5);
              i10 = Math.min(i9, i6) - i3;
              if (!((View)localObject2).hasFocusable()) {
                break;
              }
              if (i10 <= i2)
              {
                if (i10 != i2) {
                  break label463;
                }
                if (i8 > i) {
                  i3 = 1;
                } else {
                  i3 = 0;
                }
                if (n != i3) {
                  break label463;
                }
              }
            }
            if (localObject1 != null) {
              break;
            }
            i3 = 0;
            if (!isViewPartiallyVisible((View)localObject2, false, true)) {
              break;
            }
            i4 = paramInt;
          } while (i10 > i4);
          if (i10 != i4) {
            break;
          }
          if (i8 > j) {
            i3 = 1;
          }
        } while (n == i3);
        label463:
        i3 = 0;
        label466:
        if (i3 != 0) {
          if (((View)localObject2).hasFocusable())
          {
            i = localLayoutParams.mSpanIndex;
            i2 = Math.min(i9, i6) - Math.max(i8, i5);
            localObject1 = localObject2;
          }
          else
          {
            j = localLayoutParams.mSpanIndex;
            paramInt = Math.min(i9, i6);
            i3 = Math.max(i8, i5);
            paramView = (View)localObject2;
            paramInt -= i3;
          }
        }
      }
      k += m;
    }
    if (localObject1 != null) {
      return (View)localObject1;
    }
    return paramView;
  }
  
  public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (!(localLayoutParams instanceof LayoutParams))
    {
      super.onInitializeAccessibilityNodeInfoForItem(paramView, paramAccessibilityNodeInfoCompat);
      return;
    }
    paramView = (LayoutParams)localLayoutParams;
    int i = getSpanGroupIndex(paramRecycler, paramState, paramView.getViewLayoutPosition());
    boolean bool;
    if (this.mOrientation == 0)
    {
      j = paramView.getSpanIndex();
      k = paramView.getSpanSize();
      if ((this.mSpanCount > 1) && (paramView.getSpanSize() == this.mSpanCount)) {
        bool = true;
      } else {
        bool = false;
      }
      paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(j, k, i, 1, bool, false));
      return;
    }
    int j = paramView.getSpanIndex();
    int k = paramView.getSpanSize();
    if ((this.mSpanCount > 1) && (paramView.getSpanSize() == this.mSpanCount)) {
      bool = true;
    } else {
      bool = false;
    }
    paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(i, 1, j, k, bool, false));
  }
  
  public void onItemsAdded(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    this.mSpanSizeLookup.invalidateSpanIndexCache();
  }
  
  public void onItemsChanged(RecyclerView paramRecyclerView)
  {
    this.mSpanSizeLookup.invalidateSpanIndexCache();
  }
  
  public void onItemsMoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mSpanSizeLookup.invalidateSpanIndexCache();
  }
  
  public void onItemsRemoved(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    this.mSpanSizeLookup.invalidateSpanIndexCache();
  }
  
  public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2, Object paramObject)
  {
    this.mSpanSizeLookup.invalidateSpanIndexCache();
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (paramState.isPreLayout()) {
      cachePreLayoutSpanMapping();
    }
    super.onLayoutChildren(paramRecycler, paramState);
    clearPreLayoutSpanMappingCache();
  }
  
  public void onLayoutCompleted(RecyclerView.State paramState)
  {
    super.onLayoutCompleted(paramState);
    this.mPendingSpanCountChange = false;
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    updateMeasurements();
    ensureViewSet();
    return super.scrollHorizontallyBy(paramInt, paramRecycler, paramState);
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    updateMeasurements();
    ensureViewSet();
    return super.scrollVerticallyBy(paramInt, paramRecycler, paramState);
  }
  
  public void setMeasuredDimension(Rect paramRect, int paramInt1, int paramInt2)
  {
    if (this.mCachedBorders == null) {
      super.setMeasuredDimension(paramRect, paramInt1, paramInt2);
    }
    int i = getPaddingLeft() + getPaddingRight();
    int j = getPaddingTop() + getPaddingBottom();
    if (this.mOrientation == 1)
    {
      paramInt2 = chooseSize(paramInt2, paramRect.height() + j, getMinimumHeight());
      i = chooseSize(paramInt1, this.mCachedBorders[(this.mCachedBorders.length - 1)] + i, getMinimumWidth());
      paramInt1 = paramInt2;
      paramInt2 = i;
    }
    else
    {
      paramInt1 = chooseSize(paramInt1, paramRect.width() + i, getMinimumWidth());
      i = chooseSize(paramInt2, this.mCachedBorders[(this.mCachedBorders.length - 1)] + j, getMinimumHeight());
      paramInt2 = paramInt1;
      paramInt1 = i;
    }
    setMeasuredDimension(paramInt2, paramInt1);
  }
  
  public void setSpanCount(int paramInt)
  {
    if (paramInt == this.mSpanCount) {
      return;
    }
    this.mPendingSpanCountChange = true;
    if (paramInt >= 1)
    {
      this.mSpanCount = paramInt;
      this.mSpanSizeLookup.invalidateSpanIndexCache();
      requestLayout();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Span count should be at least 1. Provided ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void setSpanSizeLookup(SpanSizeLookup paramSpanSizeLookup)
  {
    this.mSpanSizeLookup = paramSpanSizeLookup;
  }
  
  public void setStackFromEnd(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      super.setStackFromEnd(false);
      return;
    }
    throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
  }
  
  public boolean supportsPredictiveItemAnimations()
  {
    return (this.mPendingSavedState == null) && (!this.mPendingSpanCountChange);
  }
  
  public static final class DefaultSpanSizeLookup
    extends GridLayoutManager.SpanSizeLookup
  {
    public int getSpanIndex(int paramInt1, int paramInt2)
    {
      return paramInt1 % paramInt2;
    }
    
    public int getSpanSize(int paramInt)
    {
      return 1;
    }
  }
  
  public static class LayoutParams
    extends RecyclerView.LayoutParams
  {
    public static final int INVALID_SPAN_ID = -1;
    int mSpanIndex = -1;
    int mSpanSize = 0;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(RecyclerView.LayoutParams paramLayoutParams)
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
    
    public int getSpanIndex()
    {
      return this.mSpanIndex;
    }
    
    public int getSpanSize()
    {
      return this.mSpanSize;
    }
  }
  
  public static abstract class SpanSizeLookup
  {
    private boolean mCacheSpanIndices = false;
    final SparseIntArray mSpanIndexCache = new SparseIntArray();
    
    int findReferenceIndexFromCache(int paramInt)
    {
      int j = this.mSpanIndexCache.size() - 1;
      int i = 0;
      while (i <= j)
      {
        int k = i + j >>> 1;
        if (this.mSpanIndexCache.keyAt(k) < paramInt) {
          i = k + 1;
        } else {
          j = k - 1;
        }
      }
      paramInt = i - 1;
      if ((paramInt >= 0) && (paramInt < this.mSpanIndexCache.size())) {
        return this.mSpanIndexCache.keyAt(paramInt);
      }
      return -1;
    }
    
    int getCachedSpanIndex(int paramInt1, int paramInt2)
    {
      if (!this.mCacheSpanIndices) {
        return getSpanIndex(paramInt1, paramInt2);
      }
      int i = this.mSpanIndexCache.get(paramInt1, -1);
      if (i != -1) {
        return i;
      }
      paramInt2 = getSpanIndex(paramInt1, paramInt2);
      this.mSpanIndexCache.put(paramInt1, paramInt2);
      return paramInt2;
    }
    
    public int getSpanGroupIndex(int paramInt1, int paramInt2)
    {
      int i2 = getSpanSize(paramInt1);
      int m = 0;
      int i = 0;
      int k;
      for (int j = 0; m < paramInt1; j = k)
      {
        int n = getSpanSize(m);
        int i1 = i + n;
        if (i1 == paramInt2)
        {
          k = j + 1;
          i = 0;
        }
        else
        {
          i = i1;
          k = j;
          if (i1 > paramInt2)
          {
            k = j + 1;
            i = n;
          }
        }
        m += 1;
      }
      paramInt1 = j;
      if (i + i2 > paramInt2) {
        paramInt1 = j + 1;
      }
      return paramInt1;
    }
    
    public int getSpanIndex(int paramInt1, int paramInt2)
    {
      int n = getSpanSize(paramInt1);
      if (n == paramInt2) {
        return 0;
      }
      if ((this.mCacheSpanIndices) && (this.mSpanIndexCache.size() > 0))
      {
        j = findReferenceIndexFromCache(paramInt1);
        if (j >= 0)
        {
          i = this.mSpanIndexCache.get(j) + getSpanSize(j);
          j += 1;
          break label75;
        }
      }
      int j = 0;
      int i = 0;
      label75:
      while (j < paramInt1)
      {
        int k = getSpanSize(j);
        int m = i + k;
        if (m == paramInt2)
        {
          i = 0;
        }
        else
        {
          i = m;
          if (m > paramInt2) {
            i = k;
          }
        }
        j += 1;
      }
      if (n + i <= paramInt2) {
        return i;
      }
      return 0;
    }
    
    public abstract int getSpanSize(int paramInt);
    
    public void invalidateSpanIndexCache()
    {
      this.mSpanIndexCache.clear();
    }
    
    public boolean isSpanIndexCacheEnabled()
    {
      return this.mCacheSpanIndices;
    }
    
    public void setSpanIndexCacheEnabled(boolean paramBoolean)
    {
      this.mCacheSpanIndices = paramBoolean;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\widget\GridLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */