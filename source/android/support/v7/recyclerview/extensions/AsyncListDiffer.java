package android.support.v7.recyclerview.extensions;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.util.AdapterListUpdateCallback;
import android.support.v7.util.DiffUtil;
import android.support.v7.util.DiffUtil.Callback;
import android.support.v7.util.DiffUtil.DiffResult;
import android.support.v7.util.DiffUtil.ItemCallback;
import android.support.v7.util.ListUpdateCallback;
import android.support.v7.widget.RecyclerView.Adapter;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

public class AsyncListDiffer<T>
{
  private static final Executor sMainThreadExecutor = new MainThreadExecutor();
  final AsyncDifferConfig<T> mConfig;
  @Nullable
  private List<T> mList;
  final Executor mMainThreadExecutor;
  int mMaxScheduledGeneration;
  @NonNull
  private List<T> mReadOnlyList = Collections.emptyList();
  private final ListUpdateCallback mUpdateCallback;
  
  public AsyncListDiffer(@NonNull ListUpdateCallback paramListUpdateCallback, @NonNull AsyncDifferConfig<T> paramAsyncDifferConfig)
  {
    this.mUpdateCallback = paramListUpdateCallback;
    this.mConfig = paramAsyncDifferConfig;
    if (paramAsyncDifferConfig.getMainThreadExecutor() != null)
    {
      this.mMainThreadExecutor = paramAsyncDifferConfig.getMainThreadExecutor();
      return;
    }
    this.mMainThreadExecutor = sMainThreadExecutor;
  }
  
  public AsyncListDiffer(@NonNull RecyclerView.Adapter paramAdapter, @NonNull DiffUtil.ItemCallback<T> paramItemCallback)
  {
    this(new AdapterListUpdateCallback(paramAdapter), new AsyncDifferConfig.Builder(paramItemCallback).build());
  }
  
  @NonNull
  public List<T> getCurrentList()
  {
    return this.mReadOnlyList;
  }
  
  void latchList(@NonNull List<T> paramList, @NonNull DiffUtil.DiffResult paramDiffResult)
  {
    this.mList = paramList;
    this.mReadOnlyList = Collections.unmodifiableList(paramList);
    paramDiffResult.dispatchUpdatesTo(this.mUpdateCallback);
  }
  
  public void submitList(@Nullable final List<T> paramList)
  {
    final int i = this.mMaxScheduledGeneration + 1;
    this.mMaxScheduledGeneration = i;
    if (paramList == this.mList) {
      return;
    }
    if (paramList == null)
    {
      i = this.mList.size();
      this.mList = null;
      this.mReadOnlyList = Collections.emptyList();
      this.mUpdateCallback.onRemoved(0, i);
      return;
    }
    if (this.mList == null)
    {
      this.mList = paramList;
      this.mReadOnlyList = Collections.unmodifiableList(paramList);
      this.mUpdateCallback.onInserted(0, paramList.size());
      return;
    }
    final List localList = this.mList;
    this.mConfig.getBackgroundThreadExecutor().execute(new Runnable()
    {
      public void run()
      {
        final DiffUtil.DiffResult localDiffResult = DiffUtil.calculateDiff(new DiffUtil.Callback()
        {
          public boolean areContentsTheSame(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            Object localObject1 = AsyncListDiffer.1.this.val$oldList.get(paramAnonymous2Int1);
            Object localObject2 = AsyncListDiffer.1.this.val$newList.get(paramAnonymous2Int2);
            if ((localObject1 != null) && (localObject2 != null)) {
              return AsyncListDiffer.this.mConfig.getDiffCallback().areContentsTheSame(localObject1, localObject2);
            }
            if ((localObject1 == null) && (localObject2 == null)) {
              return true;
            }
            throw new AssertionError();
          }
          
          public boolean areItemsTheSame(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            Object localObject1 = AsyncListDiffer.1.this.val$oldList.get(paramAnonymous2Int1);
            Object localObject2 = AsyncListDiffer.1.this.val$newList.get(paramAnonymous2Int2);
            if ((localObject1 != null) && (localObject2 != null)) {
              return AsyncListDiffer.this.mConfig.getDiffCallback().areItemsTheSame(localObject1, localObject2);
            }
            return (localObject1 == null) && (localObject2 == null);
          }
          
          @Nullable
          public Object getChangePayload(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            Object localObject1 = AsyncListDiffer.1.this.val$oldList.get(paramAnonymous2Int1);
            Object localObject2 = AsyncListDiffer.1.this.val$newList.get(paramAnonymous2Int2);
            if ((localObject1 != null) && (localObject2 != null)) {
              return AsyncListDiffer.this.mConfig.getDiffCallback().getChangePayload(localObject1, localObject2);
            }
            throw new AssertionError();
          }
          
          public int getNewListSize()
          {
            return AsyncListDiffer.1.this.val$newList.size();
          }
          
          public int getOldListSize()
          {
            return AsyncListDiffer.1.this.val$oldList.size();
          }
        });
        AsyncListDiffer.this.mMainThreadExecutor.execute(new Runnable()
        {
          public void run()
          {
            if (AsyncListDiffer.this.mMaxScheduledGeneration == AsyncListDiffer.1.this.val$runGeneration) {
              AsyncListDiffer.this.latchList(AsyncListDiffer.1.this.val$newList, localDiffResult);
            }
          }
        });
      }
    });
  }
  
  private static class MainThreadExecutor
    implements Executor
  {
    final Handler mHandler = new Handler(Looper.getMainLooper());
    
    public void execute(@NonNull Runnable paramRunnable)
    {
      this.mHandler.post(paramRunnable);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\recyclerview\extensions\AsyncListDiffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */