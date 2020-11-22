package android.support.v4.widget;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;
import android.support.v4.util.SimpleArrayMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public final class DirectedAcyclicGraph<T>
{
  private final SimpleArrayMap<T, ArrayList<T>> mGraph = new SimpleArrayMap();
  private final Pools.Pool<ArrayList<T>> mListPool = new Pools.SimplePool(10);
  private final ArrayList<T> mSortResult = new ArrayList();
  private final HashSet<T> mSortTmpMarked = new HashSet();
  
  private void dfs(T paramT, ArrayList<T> paramArrayList, HashSet<T> paramHashSet)
  {
    if (paramArrayList.contains(paramT)) {
      return;
    }
    if (!paramHashSet.contains(paramT))
    {
      paramHashSet.add(paramT);
      ArrayList localArrayList = (ArrayList)this.mGraph.get(paramT);
      if (localArrayList != null)
      {
        int i = 0;
        int j = localArrayList.size();
        while (i < j)
        {
          dfs(localArrayList.get(i), paramArrayList, paramHashSet);
          i += 1;
        }
      }
      paramHashSet.remove(paramT);
      paramArrayList.add(paramT);
      return;
    }
    throw new RuntimeException("This graph contains cyclic dependencies");
  }
  
  @NonNull
  private ArrayList<T> getEmptyList()
  {
    ArrayList localArrayList2 = (ArrayList)this.mListPool.acquire();
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null) {
      localArrayList1 = new ArrayList();
    }
    return localArrayList1;
  }
  
  private void poolList(@NonNull ArrayList<T> paramArrayList)
  {
    paramArrayList.clear();
    this.mListPool.release(paramArrayList);
  }
  
  public void addEdge(@NonNull T paramT1, @NonNull T paramT2)
  {
    if ((this.mGraph.containsKey(paramT1)) && (this.mGraph.containsKey(paramT2)))
    {
      ArrayList localArrayList2 = (ArrayList)this.mGraph.get(paramT1);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = getEmptyList();
        this.mGraph.put(paramT1, localArrayList1);
      }
      localArrayList1.add(paramT2);
      return;
    }
    throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
  }
  
  public void addNode(@NonNull T paramT)
  {
    if (!this.mGraph.containsKey(paramT)) {
      this.mGraph.put(paramT, null);
    }
  }
  
  public void clear()
  {
    int j = this.mGraph.size();
    int i = 0;
    while (i < j)
    {
      ArrayList localArrayList = (ArrayList)this.mGraph.valueAt(i);
      if (localArrayList != null) {
        poolList(localArrayList);
      }
      i += 1;
    }
    this.mGraph.clear();
  }
  
  public boolean contains(@NonNull T paramT)
  {
    return this.mGraph.containsKey(paramT);
  }
  
  @Nullable
  public List getIncomingEdges(@NonNull T paramT)
  {
    return (List)this.mGraph.get(paramT);
  }
  
  @Nullable
  public List<T> getOutgoingEdges(@NonNull T paramT)
  {
    int j = this.mGraph.size();
    Object localObject1 = null;
    int i = 0;
    while (i < j)
    {
      ArrayList localArrayList = (ArrayList)this.mGraph.valueAt(i);
      Object localObject2 = localObject1;
      if (localArrayList != null)
      {
        localObject2 = localObject1;
        if (localArrayList.contains(paramT))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList();
          }
          ((ArrayList)localObject2).add(this.mGraph.keyAt(i));
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    return (List<T>)localObject1;
  }
  
  @NonNull
  public ArrayList<T> getSortedList()
  {
    this.mSortResult.clear();
    this.mSortTmpMarked.clear();
    int j = this.mGraph.size();
    int i = 0;
    while (i < j)
    {
      dfs(this.mGraph.keyAt(i), this.mSortResult, this.mSortTmpMarked);
      i += 1;
    }
    return this.mSortResult;
  }
  
  public boolean hasOutgoingEdges(@NonNull T paramT)
  {
    int j = this.mGraph.size();
    int i = 0;
    while (i < j)
    {
      ArrayList localArrayList = (ArrayList)this.mGraph.valueAt(i);
      if ((localArrayList != null) && (localArrayList.contains(paramT))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  int size()
  {
    return this.mGraph.size();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\widget\DirectedAcyclicGraph.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */