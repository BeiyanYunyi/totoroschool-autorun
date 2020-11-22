package android.support.v7.widget;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;

class ViewInfoStore
{
  private static final boolean DEBUG = false;
  @VisibleForTesting
  final ArrayMap<RecyclerView.ViewHolder, InfoRecord> mLayoutHolderMap = new ArrayMap();
  @VisibleForTesting
  final LongSparseArray<RecyclerView.ViewHolder> mOldChangedHolders = new LongSparseArray();
  
  private RecyclerView.ItemAnimator.ItemHolderInfo popFromLayoutStep(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int i = this.mLayoutHolderMap.indexOfKey(paramViewHolder);
    if (i < 0) {
      return null;
    }
    InfoRecord localInfoRecord = (InfoRecord)this.mLayoutHolderMap.valueAt(i);
    if ((localInfoRecord != null) && ((localInfoRecord.flags & paramInt) != 0))
    {
      localInfoRecord.flags &= (paramInt ^ 0xFFFFFFFF);
      if (paramInt == 4)
      {
        paramViewHolder = localInfoRecord.preInfo;
      }
      else
      {
        if (paramInt != 8) {
          break label110;
        }
        paramViewHolder = localInfoRecord.postInfo;
      }
      if ((localInfoRecord.flags & 0xC) == 0)
      {
        this.mLayoutHolderMap.removeAt(i);
        InfoRecord.recycle(localInfoRecord);
      }
      return paramViewHolder;
      label110:
      throw new IllegalArgumentException("Must provide flag PRE or POST");
    }
    return null;
  }
  
  void addToAppearedInPreLayoutHolders(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo)
  {
    InfoRecord localInfoRecord2 = (InfoRecord)this.mLayoutHolderMap.get(paramViewHolder);
    InfoRecord localInfoRecord1 = localInfoRecord2;
    if (localInfoRecord2 == null)
    {
      localInfoRecord1 = InfoRecord.obtain();
      this.mLayoutHolderMap.put(paramViewHolder, localInfoRecord1);
    }
    localInfoRecord1.flags |= 0x2;
    localInfoRecord1.preInfo = paramItemHolderInfo;
  }
  
  void addToDisappearedInLayout(RecyclerView.ViewHolder paramViewHolder)
  {
    InfoRecord localInfoRecord2 = (InfoRecord)this.mLayoutHolderMap.get(paramViewHolder);
    InfoRecord localInfoRecord1 = localInfoRecord2;
    if (localInfoRecord2 == null)
    {
      localInfoRecord1 = InfoRecord.obtain();
      this.mLayoutHolderMap.put(paramViewHolder, localInfoRecord1);
    }
    localInfoRecord1.flags |= 0x1;
  }
  
  void addToOldChangeHolders(long paramLong, RecyclerView.ViewHolder paramViewHolder)
  {
    this.mOldChangedHolders.put(paramLong, paramViewHolder);
  }
  
  void addToPostLayout(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo)
  {
    InfoRecord localInfoRecord2 = (InfoRecord)this.mLayoutHolderMap.get(paramViewHolder);
    InfoRecord localInfoRecord1 = localInfoRecord2;
    if (localInfoRecord2 == null)
    {
      localInfoRecord1 = InfoRecord.obtain();
      this.mLayoutHolderMap.put(paramViewHolder, localInfoRecord1);
    }
    localInfoRecord1.postInfo = paramItemHolderInfo;
    localInfoRecord1.flags |= 0x8;
  }
  
  void addToPreLayout(RecyclerView.ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo)
  {
    InfoRecord localInfoRecord2 = (InfoRecord)this.mLayoutHolderMap.get(paramViewHolder);
    InfoRecord localInfoRecord1 = localInfoRecord2;
    if (localInfoRecord2 == null)
    {
      localInfoRecord1 = InfoRecord.obtain();
      this.mLayoutHolderMap.put(paramViewHolder, localInfoRecord1);
    }
    localInfoRecord1.preInfo = paramItemHolderInfo;
    localInfoRecord1.flags |= 0x4;
  }
  
  void clear()
  {
    this.mLayoutHolderMap.clear();
    this.mOldChangedHolders.clear();
  }
  
  RecyclerView.ViewHolder getFromOldChangeHolders(long paramLong)
  {
    return (RecyclerView.ViewHolder)this.mOldChangedHolders.get(paramLong);
  }
  
  boolean isDisappearing(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (InfoRecord)this.mLayoutHolderMap.get(paramViewHolder);
    return (paramViewHolder != null) && ((paramViewHolder.flags & 0x1) != 0);
  }
  
  boolean isInPreLayout(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (InfoRecord)this.mLayoutHolderMap.get(paramViewHolder);
    return (paramViewHolder != null) && ((paramViewHolder.flags & 0x4) != 0);
  }
  
  void onDetach() {}
  
  public void onViewDetached(RecyclerView.ViewHolder paramViewHolder)
  {
    removeFromDisappearedInLayout(paramViewHolder);
  }
  
  @Nullable
  RecyclerView.ItemAnimator.ItemHolderInfo popFromPostLayout(RecyclerView.ViewHolder paramViewHolder)
  {
    return popFromLayoutStep(paramViewHolder, 8);
  }
  
  @Nullable
  RecyclerView.ItemAnimator.ItemHolderInfo popFromPreLayout(RecyclerView.ViewHolder paramViewHolder)
  {
    return popFromLayoutStep(paramViewHolder, 4);
  }
  
  void process(ProcessCallback paramProcessCallback)
  {
    int i = this.mLayoutHolderMap.size() - 1;
    while (i >= 0)
    {
      RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)this.mLayoutHolderMap.keyAt(i);
      InfoRecord localInfoRecord = (InfoRecord)this.mLayoutHolderMap.removeAt(i);
      if ((localInfoRecord.flags & 0x3) == 3) {
        paramProcessCallback.unused(localViewHolder);
      } else if ((localInfoRecord.flags & 0x1) != 0)
      {
        if (localInfoRecord.preInfo == null) {
          paramProcessCallback.unused(localViewHolder);
        } else {
          paramProcessCallback.processDisappeared(localViewHolder, localInfoRecord.preInfo, localInfoRecord.postInfo);
        }
      }
      else if ((localInfoRecord.flags & 0xE) == 14) {
        paramProcessCallback.processAppeared(localViewHolder, localInfoRecord.preInfo, localInfoRecord.postInfo);
      } else if ((localInfoRecord.flags & 0xC) == 12) {
        paramProcessCallback.processPersistent(localViewHolder, localInfoRecord.preInfo, localInfoRecord.postInfo);
      } else if ((localInfoRecord.flags & 0x4) != 0) {
        paramProcessCallback.processDisappeared(localViewHolder, localInfoRecord.preInfo, null);
      } else if ((localInfoRecord.flags & 0x8) != 0) {
        paramProcessCallback.processAppeared(localViewHolder, localInfoRecord.preInfo, localInfoRecord.postInfo);
      } else {
        int j = localInfoRecord.flags;
      }
      InfoRecord.recycle(localInfoRecord);
      i -= 1;
    }
  }
  
  void removeFromDisappearedInLayout(RecyclerView.ViewHolder paramViewHolder)
  {
    paramViewHolder = (InfoRecord)this.mLayoutHolderMap.get(paramViewHolder);
    if (paramViewHolder == null) {
      return;
    }
    paramViewHolder.flags &= 0xFFFFFFFE;
  }
  
  void removeViewHolder(RecyclerView.ViewHolder paramViewHolder)
  {
    int i = this.mOldChangedHolders.size() - 1;
    while (i >= 0)
    {
      if (paramViewHolder == this.mOldChangedHolders.valueAt(i))
      {
        this.mOldChangedHolders.removeAt(i);
        break;
      }
      i -= 1;
    }
    paramViewHolder = (InfoRecord)this.mLayoutHolderMap.remove(paramViewHolder);
    if (paramViewHolder != null) {
      InfoRecord.recycle(paramViewHolder);
    }
  }
  
  static class InfoRecord
  {
    static final int FLAG_APPEAR = 2;
    static final int FLAG_APPEAR_AND_DISAPPEAR = 3;
    static final int FLAG_APPEAR_PRE_AND_POST = 14;
    static final int FLAG_DISAPPEARED = 1;
    static final int FLAG_POST = 8;
    static final int FLAG_PRE = 4;
    static final int FLAG_PRE_AND_POST = 12;
    static Pools.Pool<InfoRecord> sPool = new Pools.SimplePool(20);
    int flags;
    @Nullable
    RecyclerView.ItemAnimator.ItemHolderInfo postInfo;
    @Nullable
    RecyclerView.ItemAnimator.ItemHolderInfo preInfo;
    
    static void drainCache()
    {
      while (sPool.acquire() != null) {}
    }
    
    static InfoRecord obtain()
    {
      InfoRecord localInfoRecord2 = (InfoRecord)sPool.acquire();
      InfoRecord localInfoRecord1 = localInfoRecord2;
      if (localInfoRecord2 == null) {
        localInfoRecord1 = new InfoRecord();
      }
      return localInfoRecord1;
    }
    
    static void recycle(InfoRecord paramInfoRecord)
    {
      paramInfoRecord.flags = 0;
      paramInfoRecord.preInfo = null;
      paramInfoRecord.postInfo = null;
      sPool.release(paramInfoRecord);
    }
  }
  
  static abstract interface ProcessCallback
  {
    public abstract void processAppeared(RecyclerView.ViewHolder paramViewHolder, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2);
    
    public abstract void processDisappeared(RecyclerView.ViewHolder paramViewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, @Nullable RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2);
    
    public abstract void processPersistent(RecyclerView.ViewHolder paramViewHolder, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo1, @NonNull RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo2);
    
    public abstract void unused(RecyclerView.ViewHolder paramViewHolder);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\widget\ViewInfoStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */