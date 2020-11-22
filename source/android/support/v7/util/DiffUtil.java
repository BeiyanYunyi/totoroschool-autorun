package android.support.v7.util;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.v7.widget.RecyclerView.Adapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class DiffUtil
{
  private static final Comparator<Snake> SNAKE_COMPARATOR = new Comparator()
  {
    public int compare(DiffUtil.Snake paramAnonymousSnake1, DiffUtil.Snake paramAnonymousSnake2)
    {
      int j = paramAnonymousSnake1.x - paramAnonymousSnake2.x;
      int i = j;
      if (j == 0) {
        i = paramAnonymousSnake1.y - paramAnonymousSnake2.y;
      }
      return i;
    }
  };
  
  @NonNull
  public static DiffResult calculateDiff(@NonNull Callback paramCallback)
  {
    return calculateDiff(paramCallback, true);
  }
  
  @NonNull
  public static DiffResult calculateDiff(@NonNull Callback paramCallback, boolean paramBoolean)
  {
    int i = paramCallback.getOldListSize();
    int j = paramCallback.getNewListSize();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add(new Range(0, i, 0, j));
    i = Math.abs(i - j) + (i + j);
    j = i * 2;
    int[] arrayOfInt1 = new int[j];
    int[] arrayOfInt2 = new int[j];
    ArrayList localArrayList3 = new ArrayList();
    while (!localArrayList2.isEmpty())
    {
      Range localRange2 = (Range)localArrayList2.remove(localArrayList2.size() - 1);
      Snake localSnake = diffPartial(paramCallback, localRange2.oldListStart, localRange2.oldListEnd, localRange2.newListStart, localRange2.newListEnd, arrayOfInt1, arrayOfInt2, i);
      if (localSnake != null)
      {
        if (localSnake.size > 0) {
          localArrayList1.add(localSnake);
        }
        localSnake.x += localRange2.oldListStart;
        localSnake.y += localRange2.newListStart;
        Range localRange1;
        if (localArrayList3.isEmpty()) {
          localRange1 = new Range();
        } else {
          localRange1 = (Range)localArrayList3.remove(localArrayList3.size() - 1);
        }
        localRange1.oldListStart = localRange2.oldListStart;
        localRange1.newListStart = localRange2.newListStart;
        if (localSnake.reverse)
        {
          localRange1.oldListEnd = localSnake.x;
          localRange1.newListEnd = localSnake.y;
        }
        else if (localSnake.removal)
        {
          localRange1.oldListEnd = (localSnake.x - 1);
          localRange1.newListEnd = localSnake.y;
        }
        else
        {
          localRange1.oldListEnd = localSnake.x;
          localRange1.newListEnd = (localSnake.y - 1);
        }
        localArrayList2.add(localRange1);
        if (localSnake.reverse)
        {
          if (localSnake.removal)
          {
            localRange2.oldListStart = (localSnake.x + localSnake.size + 1);
            localRange2.newListStart = (localSnake.y + localSnake.size);
          }
          else
          {
            localRange2.oldListStart = (localSnake.x + localSnake.size);
            localRange2.newListStart = (localSnake.y + localSnake.size + 1);
          }
        }
        else
        {
          localRange2.oldListStart = (localSnake.x + localSnake.size);
          localRange2.newListStart = (localSnake.y + localSnake.size);
        }
        localArrayList2.add(localRange2);
      }
      else
      {
        localArrayList3.add(localRange2);
      }
    }
    Collections.sort(localArrayList1, SNAKE_COMPARATOR);
    return new DiffResult(paramCallback, localArrayList1, arrayOfInt1, arrayOfInt2, paramBoolean);
  }
  
  private static Snake diffPartial(Callback paramCallback, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt5)
  {
    paramInt2 -= paramInt1;
    paramInt4 -= paramInt3;
    if ((paramInt2 >= 1) && (paramInt4 >= 1))
    {
      int i3 = paramInt2 - paramInt4;
      int i = (paramInt2 + paramInt4 + 1) / 2;
      int j = paramInt5 - i - 1;
      int k = paramInt5 + i + 1;
      Arrays.fill(paramArrayOfInt1, j, k, 0);
      Arrays.fill(paramArrayOfInt2, j + i3, k + i3, paramInt2);
      if (i3 % 2 != 0) {
        k = 1;
      } else {
        k = 0;
      }
      int m = 0;
      while (m <= i)
      {
        int n = -m;
        int i1 = n;
        boolean bool;
        label202:
        int i2;
        while (i1 <= m)
        {
          if (i1 != n) {
            if (i1 != m)
            {
              j = paramInt5 + i1;
              if (paramArrayOfInt1[(j - 1)] < paramArrayOfInt1[(j + 1)]) {}
            }
            else
            {
              j = paramArrayOfInt1[(paramInt5 + i1 - 1)] + 1;
              bool = true;
              break label202;
            }
          }
          j = paramArrayOfInt1[(paramInt5 + i1 + 1)];
          bool = false;
          i2 = j - i1;
          while ((j < paramInt2) && (i2 < paramInt4) && (paramCallback.areItemsTheSame(paramInt1 + j, paramInt3 + i2)))
          {
            j += 1;
            i2 += 1;
          }
          i2 = paramInt5 + i1;
          paramArrayOfInt1[i2] = j;
          if ((k != 0) && (i1 >= i3 - m + 1) && (i1 <= i3 + m - 1) && (paramArrayOfInt1[i2] >= paramArrayOfInt2[i2]))
          {
            paramCallback = new Snake();
            paramCallback.x = paramArrayOfInt2[i2];
            paramCallback.y = (paramCallback.x - i1);
            paramCallback.size = (paramArrayOfInt1[i2] - paramArrayOfInt2[i2]);
            paramCallback.removal = bool;
            paramCallback.reverse = false;
            return paramCallback;
          }
          i1 += 2;
        }
        i1 = n;
        while (i1 <= m)
        {
          int i4 = i1 + i3;
          if (i4 != m + i3) {
            if (i4 != n + i3)
            {
              j = paramInt5 + i4;
              if (paramArrayOfInt2[(j - 1)] < paramArrayOfInt2[(j + 1)]) {}
            }
            else
            {
              j = paramArrayOfInt2[(paramInt5 + i4 + 1)] - 1;
              bool = true;
              break label473;
            }
          }
          j = paramArrayOfInt2[(paramInt5 + i4 - 1)];
          bool = false;
          label473:
          i2 = j - i4;
          while ((j > 0) && (i2 > 0) && (paramCallback.areItemsTheSame(paramInt1 + j - 1, paramInt3 + i2 - 1)))
          {
            j -= 1;
            i2 -= 1;
          }
          i2 = paramInt5 + i4;
          paramArrayOfInt2[i2] = j;
          if ((k == 0) && (i4 >= n) && (i4 <= m) && (paramArrayOfInt1[i2] >= paramArrayOfInt2[i2]))
          {
            paramCallback = new Snake();
            paramCallback.x = paramArrayOfInt2[i2];
            paramCallback.y = (paramCallback.x - i4);
            paramCallback.size = (paramArrayOfInt1[i2] - paramArrayOfInt2[i2]);
            paramCallback.removal = bool;
            paramCallback.reverse = true;
            return paramCallback;
          }
          i1 += 2;
        }
        m += 1;
      }
      throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
    }
    return null;
  }
  
  public static abstract class Callback
  {
    public abstract boolean areContentsTheSame(int paramInt1, int paramInt2);
    
    public abstract boolean areItemsTheSame(int paramInt1, int paramInt2);
    
    @Nullable
    public Object getChangePayload(int paramInt1, int paramInt2)
    {
      return null;
    }
    
    public abstract int getNewListSize();
    
    public abstract int getOldListSize();
  }
  
  public static class DiffResult
  {
    private static final int FLAG_CHANGED = 2;
    private static final int FLAG_IGNORE = 16;
    private static final int FLAG_MASK = 31;
    private static final int FLAG_MOVED_CHANGED = 4;
    private static final int FLAG_MOVED_NOT_CHANGED = 8;
    private static final int FLAG_NOT_CHANGED = 1;
    private static final int FLAG_OFFSET = 5;
    public static final int NO_POSITION = -1;
    private final DiffUtil.Callback mCallback;
    private final boolean mDetectMoves;
    private final int[] mNewItemStatuses;
    private final int mNewListSize;
    private final int[] mOldItemStatuses;
    private final int mOldListSize;
    private final List<DiffUtil.Snake> mSnakes;
    
    DiffResult(DiffUtil.Callback paramCallback, List<DiffUtil.Snake> paramList, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean)
    {
      this.mSnakes = paramList;
      this.mOldItemStatuses = paramArrayOfInt1;
      this.mNewItemStatuses = paramArrayOfInt2;
      Arrays.fill(this.mOldItemStatuses, 0);
      Arrays.fill(this.mNewItemStatuses, 0);
      this.mCallback = paramCallback;
      this.mOldListSize = paramCallback.getOldListSize();
      this.mNewListSize = paramCallback.getNewListSize();
      this.mDetectMoves = paramBoolean;
      addRootSnake();
      findMatchingItems();
    }
    
    private void addRootSnake()
    {
      DiffUtil.Snake localSnake;
      if (this.mSnakes.isEmpty()) {
        localSnake = null;
      } else {
        localSnake = (DiffUtil.Snake)this.mSnakes.get(0);
      }
      if ((localSnake == null) || (localSnake.x != 0) || (localSnake.y != 0))
      {
        localSnake = new DiffUtil.Snake();
        localSnake.x = 0;
        localSnake.y = 0;
        localSnake.removal = false;
        localSnake.size = 0;
        localSnake.reverse = false;
        this.mSnakes.add(0, localSnake);
      }
    }
    
    private void dispatchAdditions(List<DiffUtil.PostponedUpdate> paramList, ListUpdateCallback paramListUpdateCallback, int paramInt1, int paramInt2, int paramInt3)
    {
      if (!this.mDetectMoves)
      {
        paramListUpdateCallback.onInserted(paramInt1, paramInt2);
        return;
      }
      paramInt2 -= 1;
      while (paramInt2 >= 0)
      {
        Object localObject = this.mNewItemStatuses;
        int i = paramInt3 + paramInt2;
        int j = localObject[i] & 0x1F;
        if (j != 0)
        {
          if ((j != 4) && (j != 8))
          {
            if (j == 16)
            {
              paramList.add(new DiffUtil.PostponedUpdate(i, paramInt1, false));
            }
            else
            {
              paramList = new StringBuilder();
              paramList.append("unknown flag for pos ");
              paramList.append(i);
              paramList.append(" ");
              paramList.append(Long.toBinaryString(j));
              throw new IllegalStateException(paramList.toString());
            }
          }
          else
          {
            int k = this.mNewItemStatuses[i] >> 5;
            paramListUpdateCallback.onMoved(removePostponedUpdate(paramList, k, true).currentPos, paramInt1);
            if (j == 4) {
              paramListUpdateCallback.onChanged(paramInt1, 1, this.mCallback.getChangePayload(k, i));
            }
          }
        }
        else
        {
          paramListUpdateCallback.onInserted(paramInt1, 1);
          localObject = paramList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            DiffUtil.PostponedUpdate localPostponedUpdate = (DiffUtil.PostponedUpdate)((Iterator)localObject).next();
            localPostponedUpdate.currentPos += 1;
          }
        }
        paramInt2 -= 1;
      }
    }
    
    private void dispatchRemovals(List<DiffUtil.PostponedUpdate> paramList, ListUpdateCallback paramListUpdateCallback, int paramInt1, int paramInt2, int paramInt3)
    {
      if (!this.mDetectMoves)
      {
        paramListUpdateCallback.onRemoved(paramInt1, paramInt2);
        return;
      }
      paramInt2 -= 1;
      while (paramInt2 >= 0)
      {
        Object localObject = this.mOldItemStatuses;
        int i = paramInt3 + paramInt2;
        int j = localObject[i] & 0x1F;
        if (j != 0)
        {
          if ((j != 4) && (j != 8))
          {
            if (j == 16)
            {
              paramList.add(new DiffUtil.PostponedUpdate(i, paramInt1 + paramInt2, true));
            }
            else
            {
              paramList = new StringBuilder();
              paramList.append("unknown flag for pos ");
              paramList.append(i);
              paramList.append(" ");
              paramList.append(Long.toBinaryString(j));
              throw new IllegalStateException(paramList.toString());
            }
          }
          else
          {
            int k = this.mOldItemStatuses[i] >> 5;
            localObject = removePostponedUpdate(paramList, k, false);
            paramListUpdateCallback.onMoved(paramInt1 + paramInt2, ((DiffUtil.PostponedUpdate)localObject).currentPos - 1);
            if (j == 4) {
              paramListUpdateCallback.onChanged(((DiffUtil.PostponedUpdate)localObject).currentPos - 1, 1, this.mCallback.getChangePayload(i, k));
            }
          }
        }
        else
        {
          paramListUpdateCallback.onRemoved(paramInt1 + paramInt2, 1);
          localObject = paramList.iterator();
          while (((Iterator)localObject).hasNext())
          {
            DiffUtil.PostponedUpdate localPostponedUpdate = (DiffUtil.PostponedUpdate)((Iterator)localObject).next();
            localPostponedUpdate.currentPos -= 1;
          }
        }
        paramInt2 -= 1;
      }
    }
    
    private void findAddition(int paramInt1, int paramInt2, int paramInt3)
    {
      if (this.mOldItemStatuses[(paramInt1 - 1)] != 0) {
        return;
      }
      findMatchingItem(paramInt1, paramInt2, paramInt3, false);
    }
    
    private boolean findMatchingItem(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    {
      int i;
      int j;
      int k;
      if (paramBoolean)
      {
        i = paramInt2 - 1;
        paramInt2 = paramInt1;
        j = i;
      }
      else
      {
        k = paramInt1 - 1;
        j = k;
        i = paramInt2;
        paramInt2 = k;
      }
      while (paramInt3 >= 0)
      {
        Object localObject = (DiffUtil.Snake)this.mSnakes.get(paramInt3);
        int m = ((DiffUtil.Snake)localObject).x;
        int n = ((DiffUtil.Snake)localObject).size;
        int i1 = ((DiffUtil.Snake)localObject).y;
        int i2 = ((DiffUtil.Snake)localObject).size;
        k = 4;
        if (paramBoolean)
        {
          paramInt2 -= 1;
          while (paramInt2 >= m + n)
          {
            if (this.mCallback.areItemsTheSame(paramInt2, j))
            {
              if (this.mCallback.areContentsTheSame(paramInt2, j)) {
                k = 8;
              }
              this.mNewItemStatuses[j] = (paramInt2 << 5 | 0x10);
              this.mOldItemStatuses[paramInt2] = (j << 5 | k);
              return true;
            }
            paramInt2 -= 1;
          }
        }
        paramInt2 = i - 1;
        while (paramInt2 >= i1 + i2)
        {
          if (this.mCallback.areItemsTheSame(j, paramInt2))
          {
            if (this.mCallback.areContentsTheSame(j, paramInt2)) {
              k = 8;
            }
            localObject = this.mOldItemStatuses;
            paramInt1 -= 1;
            localObject[paramInt1] = (paramInt2 << 5 | 0x10);
            this.mNewItemStatuses[paramInt2] = (paramInt1 << 5 | k);
            return true;
          }
          paramInt2 -= 1;
        }
        paramInt2 = ((DiffUtil.Snake)localObject).x;
        i = ((DiffUtil.Snake)localObject).y;
        paramInt3 -= 1;
      }
      return false;
    }
    
    private void findMatchingItems()
    {
      int j = this.mOldListSize;
      int i = this.mNewListSize;
      int k = this.mSnakes.size() - 1;
      while (k >= 0)
      {
        DiffUtil.Snake localSnake = (DiffUtil.Snake)this.mSnakes.get(k);
        int i2 = localSnake.x;
        int i3 = localSnake.size;
        int n = localSnake.y;
        int i1 = localSnake.size;
        int m;
        if (this.mDetectMoves)
        {
          for (;;)
          {
            m = i;
            if (j <= i2 + i3) {
              break;
            }
            findAddition(j, i, k);
            j -= 1;
          }
          while (m > n + i1)
          {
            findRemoval(j, m, k);
            m -= 1;
          }
        }
        i = 0;
        while (i < localSnake.size)
        {
          m = localSnake.x + i;
          n = localSnake.y + i;
          if (this.mCallback.areContentsTheSame(m, n)) {
            j = 1;
          } else {
            j = 2;
          }
          this.mOldItemStatuses[m] = (n << 5 | j);
          this.mNewItemStatuses[n] = (m << 5 | j);
          i += 1;
        }
        j = localSnake.x;
        i = localSnake.y;
        k -= 1;
      }
    }
    
    private void findRemoval(int paramInt1, int paramInt2, int paramInt3)
    {
      if (this.mNewItemStatuses[(paramInt2 - 1)] != 0) {
        return;
      }
      findMatchingItem(paramInt1, paramInt2, paramInt3, true);
    }
    
    private static DiffUtil.PostponedUpdate removePostponedUpdate(List<DiffUtil.PostponedUpdate> paramList, int paramInt, boolean paramBoolean)
    {
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        DiffUtil.PostponedUpdate localPostponedUpdate1 = (DiffUtil.PostponedUpdate)paramList.get(i);
        if ((localPostponedUpdate1.posInOwnerList == paramInt) && (localPostponedUpdate1.removal == paramBoolean))
        {
          paramList.remove(i);
          while (i < paramList.size())
          {
            DiffUtil.PostponedUpdate localPostponedUpdate2 = (DiffUtil.PostponedUpdate)paramList.get(i);
            int j = localPostponedUpdate2.currentPos;
            if (paramBoolean) {
              paramInt = 1;
            } else {
              paramInt = -1;
            }
            localPostponedUpdate2.currentPos = (j + paramInt);
            i += 1;
          }
          return localPostponedUpdate1;
        }
        i -= 1;
      }
      return null;
    }
    
    public int convertNewPositionToOld(@IntRange(from=0L) int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < this.mNewItemStatuses.length))
      {
        paramInt = this.mNewItemStatuses[paramInt];
        if ((paramInt & 0x1F) == 0) {
          return -1;
        }
        return paramInt >> 5;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Index out of bounds - passed position = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", new list size = ");
      localStringBuilder.append(this.mNewItemStatuses.length);
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
    
    public int convertOldPositionToNew(@IntRange(from=0L) int paramInt)
    {
      if ((paramInt >= 0) && (paramInt < this.mOldItemStatuses.length))
      {
        paramInt = this.mOldItemStatuses[paramInt];
        if ((paramInt & 0x1F) == 0) {
          return -1;
        }
        return paramInt >> 5;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Index out of bounds - passed position = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", old list size = ");
      localStringBuilder.append(this.mOldItemStatuses.length);
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
    
    public void dispatchUpdatesTo(@NonNull ListUpdateCallback paramListUpdateCallback)
    {
      if ((paramListUpdateCallback instanceof BatchingListUpdateCallback)) {
        paramListUpdateCallback = (BatchingListUpdateCallback)paramListUpdateCallback;
      } else {
        paramListUpdateCallback = new BatchingListUpdateCallback(paramListUpdateCallback);
      }
      ArrayList localArrayList = new ArrayList();
      int j = this.mOldListSize;
      int k = this.mNewListSize;
      int i = this.mSnakes.size();
      i -= 1;
      while (i >= 0)
      {
        DiffUtil.Snake localSnake = (DiffUtil.Snake)this.mSnakes.get(i);
        int m = localSnake.size;
        int n = localSnake.x + m;
        int i1 = localSnake.y + m;
        if (n < j) {
          dispatchRemovals(localArrayList, paramListUpdateCallback, n, j - n, n);
        }
        if (i1 < k) {
          dispatchAdditions(localArrayList, paramListUpdateCallback, n, k - i1, i1);
        }
        j = m - 1;
        while (j >= 0)
        {
          if ((this.mOldItemStatuses[(localSnake.x + j)] & 0x1F) == 2) {
            paramListUpdateCallback.onChanged(localSnake.x + j, 1, this.mCallback.getChangePayload(localSnake.x + j, localSnake.y + j));
          }
          j -= 1;
        }
        j = localSnake.x;
        k = localSnake.y;
        i -= 1;
      }
      paramListUpdateCallback.dispatchLastEvent();
    }
    
    public void dispatchUpdatesTo(@NonNull RecyclerView.Adapter paramAdapter)
    {
      dispatchUpdatesTo(new AdapterListUpdateCallback(paramAdapter));
    }
    
    @VisibleForTesting
    List<DiffUtil.Snake> getSnakes()
    {
      return this.mSnakes;
    }
  }
  
  public static abstract class ItemCallback<T>
  {
    public abstract boolean areContentsTheSame(@NonNull T paramT1, @NonNull T paramT2);
    
    public abstract boolean areItemsTheSame(@NonNull T paramT1, @NonNull T paramT2);
    
    @Nullable
    public Object getChangePayload(@NonNull T paramT1, @NonNull T paramT2)
    {
      return null;
    }
  }
  
  private static class PostponedUpdate
  {
    int currentPos;
    int posInOwnerList;
    boolean removal;
    
    public PostponedUpdate(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      this.posInOwnerList = paramInt1;
      this.currentPos = paramInt2;
      this.removal = paramBoolean;
    }
  }
  
  static class Range
  {
    int newListEnd;
    int newListStart;
    int oldListEnd;
    int oldListStart;
    
    public Range() {}
    
    public Range(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.oldListStart = paramInt1;
      this.oldListEnd = paramInt2;
      this.newListStart = paramInt3;
      this.newListEnd = paramInt4;
    }
  }
  
  static class Snake
  {
    boolean removal;
    boolean reverse;
    int size;
    int x;
    int y;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v7\util\DiffUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */