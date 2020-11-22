package android.support.v7.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.annotation.WorkerThread;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;

public class AsyncListUtil<T>
{
  static final boolean DEBUG = false;
  static final String TAG = "AsyncListUtil";
  boolean mAllowScrollHints;
  private final ThreadUtil.BackgroundCallback<T> mBackgroundCallback = new ThreadUtil.BackgroundCallback()
  {
    private int mFirstRequiredTileStart;
    private int mGeneration;
    private int mItemCount;
    private int mLastRequiredTileStart;
    final SparseBooleanArray mLoadedTiles = new SparseBooleanArray();
    private TileList.Tile<T> mRecycledRoot;
    
    private TileList.Tile<T> acquireTile()
    {
      if (this.mRecycledRoot != null)
      {
        TileList.Tile localTile = this.mRecycledRoot;
        this.mRecycledRoot = this.mRecycledRoot.mNext;
        return localTile;
      }
      return new TileList.Tile(AsyncListUtil.this.mTClass, AsyncListUtil.this.mTileSize);
    }
    
    private void addTile(TileList.Tile<T> paramAnonymousTile)
    {
      this.mLoadedTiles.put(paramAnonymousTile.mStartPosition, true);
      AsyncListUtil.this.mMainThreadProxy.addTile(this.mGeneration, paramAnonymousTile);
    }
    
    private void flushTileCache(int paramAnonymousInt)
    {
      int i = AsyncListUtil.this.mDataCallback.getMaxCachedTiles();
      while (this.mLoadedTiles.size() >= i)
      {
        int j = this.mLoadedTiles.keyAt(0);
        int k = this.mLoadedTiles.keyAt(this.mLoadedTiles.size() - 1);
        int m = this.mFirstRequiredTileStart - j;
        int n = k - this.mLastRequiredTileStart;
        if ((m > 0) && ((m >= n) || (paramAnonymousInt == 2))) {
          removeTile(j);
        } else if ((n > 0) && ((m < n) || (paramAnonymousInt == 1))) {
          removeTile(k);
        } else {}
      }
    }
    
    private int getTileStart(int paramAnonymousInt)
    {
      return paramAnonymousInt - paramAnonymousInt % AsyncListUtil.this.mTileSize;
    }
    
    private boolean isTileLoaded(int paramAnonymousInt)
    {
      return this.mLoadedTiles.get(paramAnonymousInt);
    }
    
    private void log(String paramAnonymousString, Object... paramAnonymousVarArgs)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[BKGR] ");
      localStringBuilder.append(String.format(paramAnonymousString, paramAnonymousVarArgs));
      Log.d("AsyncListUtil", localStringBuilder.toString());
    }
    
    private void removeTile(int paramAnonymousInt)
    {
      this.mLoadedTiles.delete(paramAnonymousInt);
      AsyncListUtil.this.mMainThreadProxy.removeTile(this.mGeneration, paramAnonymousInt);
    }
    
    private void requestTiles(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, boolean paramAnonymousBoolean)
    {
      int i = paramAnonymousInt1;
      while (i <= paramAnonymousInt2)
      {
        int j;
        if (paramAnonymousBoolean) {
          j = paramAnonymousInt2 + paramAnonymousInt1 - i;
        } else {
          j = i;
        }
        AsyncListUtil.this.mBackgroundProxy.loadTile(j, paramAnonymousInt3);
        i += AsyncListUtil.this.mTileSize;
      }
    }
    
    public void loadTile(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (isTileLoaded(paramAnonymousInt1)) {
        return;
      }
      TileList.Tile localTile = acquireTile();
      localTile.mStartPosition = paramAnonymousInt1;
      localTile.mItemCount = Math.min(AsyncListUtil.this.mTileSize, this.mItemCount - localTile.mStartPosition);
      AsyncListUtil.this.mDataCallback.fillData(localTile.mItems, localTile.mStartPosition, localTile.mItemCount);
      flushTileCache(paramAnonymousInt2);
      addTile(localTile);
    }
    
    public void recycleTile(TileList.Tile<T> paramAnonymousTile)
    {
      AsyncListUtil.this.mDataCallback.recycleData(paramAnonymousTile.mItems, paramAnonymousTile.mItemCount);
      paramAnonymousTile.mNext = this.mRecycledRoot;
      this.mRecycledRoot = paramAnonymousTile;
    }
    
    public void refresh(int paramAnonymousInt)
    {
      this.mGeneration = paramAnonymousInt;
      this.mLoadedTiles.clear();
      this.mItemCount = AsyncListUtil.this.mDataCallback.refreshData();
      AsyncListUtil.this.mMainThreadProxy.updateItemCount(this.mGeneration, this.mItemCount);
    }
    
    public void updateRange(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5)
    {
      if (paramAnonymousInt1 > paramAnonymousInt2) {
        return;
      }
      paramAnonymousInt1 = getTileStart(paramAnonymousInt1);
      paramAnonymousInt2 = getTileStart(paramAnonymousInt2);
      this.mFirstRequiredTileStart = getTileStart(paramAnonymousInt3);
      this.mLastRequiredTileStart = getTileStart(paramAnonymousInt4);
      if (paramAnonymousInt5 == 1)
      {
        requestTiles(this.mFirstRequiredTileStart, paramAnonymousInt2, paramAnonymousInt5, true);
        requestTiles(paramAnonymousInt2 + AsyncListUtil.this.mTileSize, this.mLastRequiredTileStart, paramAnonymousInt5, false);
        return;
      }
      requestTiles(paramAnonymousInt1, this.mLastRequiredTileStart, paramAnonymousInt5, false);
      requestTiles(this.mFirstRequiredTileStart, paramAnonymousInt1 - AsyncListUtil.this.mTileSize, paramAnonymousInt5, true);
    }
  };
  final ThreadUtil.BackgroundCallback<T> mBackgroundProxy;
  final DataCallback<T> mDataCallback;
  int mDisplayedGeneration = 0;
  int mItemCount = 0;
  private final ThreadUtil.MainThreadCallback<T> mMainThreadCallback = new ThreadUtil.MainThreadCallback()
  {
    private boolean isRequestedGeneration(int paramAnonymousInt)
    {
      return paramAnonymousInt == AsyncListUtil.this.mRequestedGeneration;
    }
    
    private void recycleAllTiles()
    {
      int i = 0;
      while (i < AsyncListUtil.this.mTileList.size())
      {
        AsyncListUtil.this.mBackgroundProxy.recycleTile(AsyncListUtil.this.mTileList.getAtIndex(i));
        i += 1;
      }
      AsyncListUtil.this.mTileList.clear();
    }
    
    public void addTile(int paramAnonymousInt, TileList.Tile<T> paramAnonymousTile)
    {
      if (!isRequestedGeneration(paramAnonymousInt))
      {
        AsyncListUtil.this.mBackgroundProxy.recycleTile(paramAnonymousTile);
        return;
      }
      TileList.Tile localTile = AsyncListUtil.this.mTileList.addOrReplace(paramAnonymousTile);
      if (localTile != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("duplicate tile @");
        localStringBuilder.append(localTile.mStartPosition);
        Log.e("AsyncListUtil", localStringBuilder.toString());
        AsyncListUtil.this.mBackgroundProxy.recycleTile(localTile);
      }
      int i = paramAnonymousTile.mStartPosition;
      int j = paramAnonymousTile.mItemCount;
      paramAnonymousInt = 0;
      while (paramAnonymousInt < AsyncListUtil.this.mMissingPositions.size())
      {
        int k = AsyncListUtil.this.mMissingPositions.keyAt(paramAnonymousInt);
        if ((paramAnonymousTile.mStartPosition <= k) && (k < i + j))
        {
          AsyncListUtil.this.mMissingPositions.removeAt(paramAnonymousInt);
          AsyncListUtil.this.mViewCallback.onItemLoaded(k);
        }
        else
        {
          paramAnonymousInt += 1;
        }
      }
    }
    
    public void removeTile(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (!isRequestedGeneration(paramAnonymousInt1)) {
        return;
      }
      Object localObject = AsyncListUtil.this.mTileList.removeAtPos(paramAnonymousInt2);
      if (localObject == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("tile not found @");
        ((StringBuilder)localObject).append(paramAnonymousInt2);
        Log.e("AsyncListUtil", ((StringBuilder)localObject).toString());
        return;
      }
      AsyncListUtil.this.mBackgroundProxy.recycleTile((TileList.Tile)localObject);
    }
    
    public void updateItemCount(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (!isRequestedGeneration(paramAnonymousInt1)) {
        return;
      }
      AsyncListUtil.this.mItemCount = paramAnonymousInt2;
      AsyncListUtil.this.mViewCallback.onDataRefresh();
      AsyncListUtil.this.mDisplayedGeneration = AsyncListUtil.this.mRequestedGeneration;
      recycleAllTiles();
      AsyncListUtil.this.mAllowScrollHints = false;
      AsyncListUtil.this.updateRange();
    }
  };
  final ThreadUtil.MainThreadCallback<T> mMainThreadProxy;
  final SparseIntArray mMissingPositions = new SparseIntArray();
  final int[] mPrevRange = new int[2];
  int mRequestedGeneration = this.mDisplayedGeneration;
  private int mScrollHint = 0;
  final Class<T> mTClass;
  final TileList<T> mTileList;
  final int mTileSize;
  final int[] mTmpRange = new int[2];
  final int[] mTmpRangeExtended = new int[2];
  final ViewCallback mViewCallback;
  
  public AsyncListUtil(@NonNull Class<T> paramClass, int paramInt, @NonNull DataCallback<T> paramDataCallback, @NonNull ViewCallback paramViewCallback)
  {
    this.mTClass = paramClass;
    this.mTileSize = paramInt;
    this.mDataCallback = paramDataCallback;
    this.mViewCallback = paramViewCallback;
    this.mTileList = new TileList(this.mTileSize);
    paramClass = new MessageThreadUtil();
    this.mMainThreadProxy = paramClass.getMainThreadProxy(this.mMainThreadCallback);
    this.mBackgroundProxy = paramClass.getBackgroundProxy(this.mBackgroundCallback);
    refresh();
  }
  
  private boolean isRefreshPending()
  {
    return this.mRequestedGeneration != this.mDisplayedGeneration;
  }
  
  @Nullable
  public T getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.mItemCount))
    {
      localObject = this.mTileList.getItemAt(paramInt);
      if ((localObject == null) && (!isRefreshPending())) {
        this.mMissingPositions.put(paramInt, 0);
      }
      return (T)localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" is not within 0 and ");
    ((StringBuilder)localObject).append(this.mItemCount);
    throw new IndexOutOfBoundsException(((StringBuilder)localObject).toString());
  }
  
  public int getItemCount()
  {
    return this.mItemCount;
  }
  
  void log(String paramString, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MAIN] ");
    localStringBuilder.append(String.format(paramString, paramVarArgs));
    Log.d("AsyncListUtil", localStringBuilder.toString());
  }
  
  public void onRangeChanged()
  {
    if (isRefreshPending()) {
      return;
    }
    updateRange();
    this.mAllowScrollHints = true;
  }
  
  public void refresh()
  {
    this.mMissingPositions.clear();
    ThreadUtil.BackgroundCallback localBackgroundCallback = this.mBackgroundProxy;
    int i = this.mRequestedGeneration + 1;
    this.mRequestedGeneration = i;
    localBackgroundCallback.refresh(i);
  }
  
  void updateRange()
  {
    this.mViewCallback.getItemRangeInto(this.mTmpRange);
    if (this.mTmpRange[0] <= this.mTmpRange[1])
    {
      if (this.mTmpRange[0] < 0) {
        return;
      }
      if (this.mTmpRange[1] >= this.mItemCount) {
        return;
      }
      if (!this.mAllowScrollHints) {
        this.mScrollHint = 0;
      } else if ((this.mTmpRange[0] <= this.mPrevRange[1]) && (this.mPrevRange[0] <= this.mTmpRange[1]))
      {
        if (this.mTmpRange[0] < this.mPrevRange[0]) {
          this.mScrollHint = 1;
        } else if (this.mTmpRange[0] > this.mPrevRange[0]) {
          this.mScrollHint = 2;
        }
      }
      else {
        this.mScrollHint = 0;
      }
      this.mPrevRange[0] = this.mTmpRange[0];
      this.mPrevRange[1] = this.mTmpRange[1];
      this.mViewCallback.extendRangeInto(this.mTmpRange, this.mTmpRangeExtended, this.mScrollHint);
      this.mTmpRangeExtended[0] = Math.min(this.mTmpRange[0], Math.max(this.mTmpRangeExtended[0], 0));
      this.mTmpRangeExtended[1] = Math.max(this.mTmpRange[1], Math.min(this.mTmpRangeExtended[1], this.mItemCount - 1));
      this.mBackgroundProxy.updateRange(this.mTmpRange[0], this.mTmpRange[1], this.mTmpRangeExtended[0], this.mTmpRangeExtended[1], this.mScrollHint);
      return;
    }
  }
  
  public static abstract class DataCallback<T>
  {
    @WorkerThread
    public abstract void fillData(@NonNull T[] paramArrayOfT, int paramInt1, int paramInt2);
    
    @WorkerThread
    public int getMaxCachedTiles()
    {
      return 10;
    }
    
    @WorkerThread
    public void recycleData(@NonNull T[] paramArrayOfT, int paramInt) {}
    
    @WorkerThread
    public abstract int refreshData();
  }
  
  public static abstract class ViewCallback
  {
    public static final int HINT_SCROLL_ASC = 2;
    public static final int HINT_SCROLL_DESC = 1;
    public static final int HINT_SCROLL_NONE = 0;
    
    @UiThread
    public void extendRangeInto(@NonNull int[] paramArrayOfInt1, @NonNull int[] paramArrayOfInt2, int paramInt)
    {
      int i = paramArrayOfInt1[1] - paramArrayOfInt1[0] + 1;
      int j = i / 2;
      int m = paramArrayOfInt1[0];
      if (paramInt == 1) {
        k = i;
      } else {
        k = j;
      }
      paramArrayOfInt2[0] = (m - k);
      int k = paramArrayOfInt1[1];
      if (paramInt != 2) {
        i = j;
      }
      paramArrayOfInt2[1] = (k + i);
    }
    
    @UiThread
    public abstract void getItemRangeInto(@NonNull int[] paramArrayOfInt);
    
    @UiThread
    public abstract void onDataRefresh();
    
    @UiThread
    public abstract void onItemLoaded(int paramInt);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\util\AsyncListUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */