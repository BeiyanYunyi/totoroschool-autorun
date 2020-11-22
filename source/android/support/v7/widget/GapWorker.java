package android.support.v7.widget;

import android.support.annotation.Nullable;
import android.support.v4.os.TraceCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

final class GapWorker
  implements Runnable
{
  static final ThreadLocal<GapWorker> sGapWorker = new ThreadLocal();
  static Comparator<Task> sTaskComparator = new Comparator()
  {
    public int compare(GapWorker.Task paramAnonymousTask1, GapWorker.Task paramAnonymousTask2)
    {
      RecyclerView localRecyclerView = paramAnonymousTask1.view;
      int k = 1;
      if (localRecyclerView == null) {
        i = 1;
      } else {
        i = 0;
      }
      int j;
      if (paramAnonymousTask2.view == null) {
        j = 1;
      } else {
        j = 0;
      }
      if (i != j)
      {
        if (paramAnonymousTask1.view == null) {
          return 1;
        }
        return -1;
      }
      if (paramAnonymousTask1.immediate != paramAnonymousTask2.immediate)
      {
        i = k;
        if (paramAnonymousTask1.immediate) {
          i = -1;
        }
        return i;
      }
      int i = paramAnonymousTask2.viewVelocity - paramAnonymousTask1.viewVelocity;
      if (i != 0) {
        return i;
      }
      i = paramAnonymousTask1.distanceToItem - paramAnonymousTask2.distanceToItem;
      if (i != 0) {
        return i;
      }
      return 0;
    }
  };
  long mFrameIntervalNs;
  long mPostTimeNs;
  ArrayList<RecyclerView> mRecyclerViews = new ArrayList();
  private ArrayList<Task> mTasks = new ArrayList();
  
  private void buildTaskList()
  {
    int m = this.mRecyclerViews.size();
    int i = 0;
    Object localObject;
    int k;
    for (int j = 0; i < m; j = k)
    {
      localObject = (RecyclerView)this.mRecyclerViews.get(i);
      k = j;
      if (((RecyclerView)localObject).getWindowVisibility() == 0)
      {
        ((RecyclerView)localObject).mPrefetchRegistry.collectPrefetchPositionsFromView((RecyclerView)localObject, false);
        k = j + ((RecyclerView)localObject).mPrefetchRegistry.mCount;
      }
      i += 1;
    }
    this.mTasks.ensureCapacity(j);
    j = 0;
    i = 0;
    while (j < m)
    {
      RecyclerView localRecyclerView = (RecyclerView)this.mRecyclerViews.get(j);
      if (localRecyclerView.getWindowVisibility() == 0)
      {
        LayoutPrefetchRegistryImpl localLayoutPrefetchRegistryImpl = localRecyclerView.mPrefetchRegistry;
        int n = Math.abs(localLayoutPrefetchRegistryImpl.mPrefetchDx) + Math.abs(localLayoutPrefetchRegistryImpl.mPrefetchDy);
        k = 0;
        while (k < localLayoutPrefetchRegistryImpl.mCount * 2)
        {
          if (i >= this.mTasks.size())
          {
            localObject = new Task();
            this.mTasks.add(localObject);
          }
          else
          {
            localObject = (Task)this.mTasks.get(i);
          }
          int i1 = localLayoutPrefetchRegistryImpl.mPrefetchArray[(k + 1)];
          boolean bool;
          if (i1 <= n) {
            bool = true;
          } else {
            bool = false;
          }
          ((Task)localObject).immediate = bool;
          ((Task)localObject).viewVelocity = n;
          ((Task)localObject).distanceToItem = i1;
          ((Task)localObject).view = localRecyclerView;
          ((Task)localObject).position = localLayoutPrefetchRegistryImpl.mPrefetchArray[k];
          i += 1;
          k += 2;
        }
      }
      j += 1;
    }
    Collections.sort(this.mTasks, sTaskComparator);
  }
  
  private void flushTaskWithDeadline(Task paramTask, long paramLong)
  {
    long l;
    if (paramTask.immediate) {
      l = Long.MAX_VALUE;
    } else {
      l = paramLong;
    }
    paramTask = prefetchPositionWithDeadline(paramTask.view, paramTask.position, l);
    if ((paramTask != null) && (paramTask.mNestedRecyclerView != null) && (paramTask.isBound()) && (!paramTask.isInvalid())) {
      prefetchInnerRecyclerViewWithDeadline((RecyclerView)paramTask.mNestedRecyclerView.get(), paramLong);
    }
  }
  
  private void flushTasksWithDeadline(long paramLong)
  {
    int i = 0;
    while (i < this.mTasks.size())
    {
      Task localTask = (Task)this.mTasks.get(i);
      if (localTask.view == null) {
        return;
      }
      flushTaskWithDeadline(localTask, paramLong);
      localTask.clear();
      i += 1;
    }
  }
  
  static boolean isPrefetchPositionAttached(RecyclerView paramRecyclerView, int paramInt)
  {
    int j = paramRecyclerView.mChildHelper.getUnfilteredChildCount();
    int i = 0;
    while (i < j)
    {
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramRecyclerView.mChildHelper.getUnfilteredChildAt(i));
      if ((localViewHolder.mPosition == paramInt) && (!localViewHolder.isInvalid())) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private void prefetchInnerRecyclerViewWithDeadline(@Nullable RecyclerView paramRecyclerView, long paramLong)
  {
    if (paramRecyclerView == null) {
      return;
    }
    if ((paramRecyclerView.mDataSetHasChangedAfterLayout) && (paramRecyclerView.mChildHelper.getUnfilteredChildCount() != 0)) {
      paramRecyclerView.removeAndRecycleViews();
    }
    LayoutPrefetchRegistryImpl localLayoutPrefetchRegistryImpl = paramRecyclerView.mPrefetchRegistry;
    localLayoutPrefetchRegistryImpl.collectPrefetchPositionsFromView(paramRecyclerView, true);
    if (localLayoutPrefetchRegistryImpl.mCount != 0) {
      try
      {
        TraceCompat.beginSection("RV Nested Prefetch");
        paramRecyclerView.mState.prepareForNestedPrefetch(paramRecyclerView.mAdapter);
        int i = 0;
        while (i < localLayoutPrefetchRegistryImpl.mCount * 2)
        {
          prefetchPositionWithDeadline(paramRecyclerView, localLayoutPrefetchRegistryImpl.mPrefetchArray[i], paramLong);
          i += 2;
        }
        return;
      }
      finally
      {
        TraceCompat.endSection();
      }
    }
  }
  
  private RecyclerView.ViewHolder prefetchPositionWithDeadline(RecyclerView paramRecyclerView, int paramInt, long paramLong)
  {
    if (isPrefetchPositionAttached(paramRecyclerView, paramInt)) {
      return null;
    }
    RecyclerView.Recycler localRecycler = paramRecyclerView.mRecycler;
    try
    {
      paramRecyclerView.onEnterLayoutOrScroll();
      RecyclerView.ViewHolder localViewHolder = localRecycler.tryGetViewHolderForPositionByDeadline(paramInt, false, paramLong);
      if (localViewHolder != null) {
        if ((localViewHolder.isBound()) && (!localViewHolder.isInvalid())) {
          localRecycler.recycleView(localViewHolder.itemView);
        } else {
          localRecycler.addViewHolderToRecycledViewPool(localViewHolder, false);
        }
      }
      return localViewHolder;
    }
    finally
    {
      paramRecyclerView.onExitLayoutOrScroll(false);
    }
  }
  
  public void add(RecyclerView paramRecyclerView)
  {
    this.mRecyclerViews.add(paramRecyclerView);
  }
  
  void postFromTraversal(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((paramRecyclerView.isAttachedToWindow()) && (this.mPostTimeNs == 0L))
    {
      this.mPostTimeNs = paramRecyclerView.getNanoTime();
      paramRecyclerView.post(this);
    }
    paramRecyclerView.mPrefetchRegistry.setPrefetchVector(paramInt1, paramInt2);
  }
  
  void prefetch(long paramLong)
  {
    buildTaskList();
    flushTasksWithDeadline(paramLong);
  }
  
  public void remove(RecyclerView paramRecyclerView)
  {
    this.mRecyclerViews.remove(paramRecyclerView);
  }
  
  public void run()
  {
    try
    {
      TraceCompat.beginSection("RV Prefetch");
      boolean bool = this.mRecyclerViews.isEmpty();
      if (bool) {
        return;
      }
      int j = this.mRecyclerViews.size();
      int i = 0;
      long l2;
      for (long l1 = 0L; i < j; l1 = l2)
      {
        RecyclerView localRecyclerView = (RecyclerView)this.mRecyclerViews.get(i);
        l2 = l1;
        if (localRecyclerView.getWindowVisibility() == 0) {
          l2 = Math.max(localRecyclerView.getDrawingTime(), l1);
        }
        i += 1;
      }
      if (l1 == 0L) {
        return;
      }
      prefetch(TimeUnit.MILLISECONDS.toNanos(l1) + this.mFrameIntervalNs);
      return;
    }
    finally
    {
      this.mPostTimeNs = 0L;
      TraceCompat.endSection();
    }
  }
  
  static class LayoutPrefetchRegistryImpl
    implements RecyclerView.LayoutManager.LayoutPrefetchRegistry
  {
    int mCount;
    int[] mPrefetchArray;
    int mPrefetchDx;
    int mPrefetchDy;
    
    public void addPosition(int paramInt1, int paramInt2)
    {
      if (paramInt1 >= 0)
      {
        if (paramInt2 >= 0)
        {
          int i = this.mCount * 2;
          if (this.mPrefetchArray == null)
          {
            this.mPrefetchArray = new int[4];
            Arrays.fill(this.mPrefetchArray, -1);
          }
          else if (i >= this.mPrefetchArray.length)
          {
            int[] arrayOfInt = this.mPrefetchArray;
            this.mPrefetchArray = new int[i * 2];
            System.arraycopy(arrayOfInt, 0, this.mPrefetchArray, 0, arrayOfInt.length);
          }
          this.mPrefetchArray[i] = paramInt1;
          this.mPrefetchArray[(i + 1)] = paramInt2;
          this.mCount += 1;
          return;
        }
        throw new IllegalArgumentException("Pixel distance must be non-negative");
      }
      throw new IllegalArgumentException("Layout positions must be non-negative");
    }
    
    void clearPrefetchPositions()
    {
      if (this.mPrefetchArray != null) {
        Arrays.fill(this.mPrefetchArray, -1);
      }
      this.mCount = 0;
    }
    
    void collectPrefetchPositionsFromView(RecyclerView paramRecyclerView, boolean paramBoolean)
    {
      this.mCount = 0;
      if (this.mPrefetchArray != null) {
        Arrays.fill(this.mPrefetchArray, -1);
      }
      RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.mLayout;
      if ((paramRecyclerView.mAdapter != null) && (localLayoutManager != null) && (localLayoutManager.isItemPrefetchEnabled()))
      {
        if (paramBoolean)
        {
          if (!paramRecyclerView.mAdapterHelper.hasPendingUpdates()) {
            localLayoutManager.collectInitialPrefetchPositions(paramRecyclerView.mAdapter.getItemCount(), this);
          }
        }
        else if (!paramRecyclerView.hasPendingAdapterUpdates()) {
          localLayoutManager.collectAdjacentPrefetchPositions(this.mPrefetchDx, this.mPrefetchDy, paramRecyclerView.mState, this);
        }
        if (this.mCount > localLayoutManager.mPrefetchMaxCountObserved)
        {
          localLayoutManager.mPrefetchMaxCountObserved = this.mCount;
          localLayoutManager.mPrefetchMaxObservedInInitialPrefetch = paramBoolean;
          paramRecyclerView.mRecycler.updateViewCacheSize();
        }
      }
    }
    
    boolean lastPrefetchIncludedPosition(int paramInt)
    {
      if (this.mPrefetchArray != null)
      {
        int j = this.mCount;
        int i = 0;
        while (i < j * 2)
        {
          if (this.mPrefetchArray[i] == paramInt) {
            return true;
          }
          i += 2;
        }
      }
      return false;
    }
    
    void setPrefetchVector(int paramInt1, int paramInt2)
    {
      this.mPrefetchDx = paramInt1;
      this.mPrefetchDy = paramInt2;
    }
  }
  
  static class Task
  {
    public int distanceToItem;
    public boolean immediate;
    public int position;
    public RecyclerView view;
    public int viewVelocity;
    
    public void clear()
    {
      this.immediate = false;
      this.viewVelocity = 0;
      this.distanceToItem = 0;
      this.view = null;
      this.position = 0;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\widget\GapWorker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */