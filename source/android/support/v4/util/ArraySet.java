package android.support.v4.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class ArraySet<E>
  implements Collection<E>, Set<E>
{
  private static final int BASE_SIZE = 4;
  private static final int CACHE_SIZE = 10;
  private static final boolean DEBUG = false;
  private static final int[] INT = new int[0];
  private static final Object[] OBJECT = new Object[0];
  private static final String TAG = "ArraySet";
  @Nullable
  private static Object[] sBaseCache;
  private static int sBaseCacheSize;
  @Nullable
  private static Object[] sTwiceBaseCache;
  private static int sTwiceBaseCacheSize;
  Object[] mArray;
  private MapCollections<E, E> mCollections;
  private int[] mHashes;
  int mSize;
  
  public ArraySet()
  {
    this(0);
  }
  
  public ArraySet(int paramInt)
  {
    if (paramInt == 0)
    {
      this.mHashes = INT;
      this.mArray = OBJECT;
    }
    else
    {
      allocArrays(paramInt);
    }
    this.mSize = 0;
  }
  
  public ArraySet(@Nullable ArraySet<E> paramArraySet)
  {
    this();
    if (paramArraySet != null) {
      addAll(paramArraySet);
    }
  }
  
  public ArraySet(@Nullable Collection<E> paramCollection)
  {
    this();
    if (paramCollection != null) {
      addAll(paramCollection);
    }
  }
  
  private void allocArrays(int paramInt)
  {
    if (paramInt == 8) {
      try
      {
        if (sTwiceBaseCache != null)
        {
          Object[] arrayOfObject1 = sTwiceBaseCache;
          this.mArray = arrayOfObject1;
          sTwiceBaseCache = (Object[])arrayOfObject1[0];
          this.mHashes = ((int[])arrayOfObject1[1]);
          arrayOfObject1[1] = null;
          arrayOfObject1[0] = null;
          sTwiceBaseCacheSize -= 1;
          return;
        }
      }
      finally {}
    }
    if (paramInt == 4) {
      try
      {
        if (sBaseCache != null)
        {
          Object[] arrayOfObject2 = sBaseCache;
          this.mArray = arrayOfObject2;
          sBaseCache = (Object[])arrayOfObject2[0];
          this.mHashes = ((int[])arrayOfObject2[1]);
          arrayOfObject2[1] = null;
          arrayOfObject2[0] = null;
          sBaseCacheSize -= 1;
          return;
        }
      }
      finally {}
    }
    this.mHashes = new int[paramInt];
    this.mArray = new Object[paramInt];
  }
  
  private static void freeArrays(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramArrayOfInt.length == 8) {
      try
      {
        if (sTwiceBaseCacheSize < 10)
        {
          paramArrayOfObject[0] = sTwiceBaseCache;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt -= 1;
          break label114;
          sTwiceBaseCache = paramArrayOfObject;
          sTwiceBaseCacheSize += 1;
        }
        return;
      }
      finally {}
    }
    if (paramArrayOfInt.length == 4) {}
    for (;;)
    {
      try
      {
        if (sBaseCacheSize < 10)
        {
          paramArrayOfObject[0] = sBaseCache;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt -= 1;
          break label130;
          sBaseCache = paramArrayOfObject;
          sBaseCacheSize += 1;
        }
        return;
      }
      finally {}
      return;
      label114:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
      break;
      label130:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
    }
  }
  
  private MapCollections<E, E> getCollection()
  {
    if (this.mCollections == null) {
      this.mCollections = new MapCollections()
      {
        protected void colClear()
        {
          ArraySet.this.clear();
        }
        
        protected Object colGetEntry(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return ArraySet.this.mArray[paramAnonymousInt1];
        }
        
        protected Map<E, E> colGetMap()
        {
          throw new UnsupportedOperationException("not a map");
        }
        
        protected int colGetSize()
        {
          return ArraySet.this.mSize;
        }
        
        protected int colIndexOfKey(Object paramAnonymousObject)
        {
          return ArraySet.this.indexOf(paramAnonymousObject);
        }
        
        protected int colIndexOfValue(Object paramAnonymousObject)
        {
          return ArraySet.this.indexOf(paramAnonymousObject);
        }
        
        protected void colPut(E paramAnonymousE1, E paramAnonymousE2)
        {
          ArraySet.this.add(paramAnonymousE1);
        }
        
        protected void colRemoveAt(int paramAnonymousInt)
        {
          ArraySet.this.removeAt(paramAnonymousInt);
        }
        
        protected E colSetValue(int paramAnonymousInt, E paramAnonymousE)
        {
          throw new UnsupportedOperationException("not a map");
        }
      };
    }
    return this.mCollections;
  }
  
  private int indexOf(Object paramObject, int paramInt)
  {
    int j = this.mSize;
    if (j == 0) {
      return -1;
    }
    int k = ContainerHelpers.binarySearch(this.mHashes, j, paramInt);
    if (k < 0) {
      return k;
    }
    if (paramObject.equals(this.mArray[k])) {
      return k;
    }
    int i = k + 1;
    while ((i < j) && (this.mHashes[i] == paramInt))
    {
      if (paramObject.equals(this.mArray[i])) {
        return i;
      }
      i += 1;
    }
    j = k - 1;
    while ((j >= 0) && (this.mHashes[j] == paramInt))
    {
      if (paramObject.equals(this.mArray[j])) {
        return j;
      }
      j -= 1;
    }
    return i ^ 0xFFFFFFFF;
  }
  
  private int indexOfNull()
  {
    int j = this.mSize;
    if (j == 0) {
      return -1;
    }
    int k = ContainerHelpers.binarySearch(this.mHashes, j, 0);
    if (k < 0) {
      return k;
    }
    if (this.mArray[k] == null) {
      return k;
    }
    int i = k + 1;
    while ((i < j) && (this.mHashes[i] == 0))
    {
      if (this.mArray[i] == null) {
        return i;
      }
      i += 1;
    }
    j = k - 1;
    while ((j >= 0) && (this.mHashes[j] == 0))
    {
      if (this.mArray[j] == null) {
        return j;
      }
      j -= 1;
    }
    return i ^ 0xFFFFFFFF;
  }
  
  public boolean add(@Nullable E paramE)
  {
    int i;
    int j;
    if (paramE == null)
    {
      i = indexOfNull();
      j = 0;
    }
    else
    {
      j = paramE.hashCode();
      i = indexOf(paramE, j);
    }
    if (i >= 0) {
      return false;
    }
    int k = i ^ 0xFFFFFFFF;
    int[] arrayOfInt;
    Object localObject;
    if (this.mSize >= this.mHashes.length)
    {
      int m = this.mSize;
      i = 4;
      if (m >= 8)
      {
        i = this.mSize;
        i = (this.mSize >> 1) + i;
      }
      else if (this.mSize >= 4)
      {
        i = 8;
      }
      arrayOfInt = this.mHashes;
      localObject = this.mArray;
      allocArrays(i);
      if (this.mHashes.length > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.mHashes, 0, arrayOfInt.length);
        System.arraycopy(localObject, 0, this.mArray, 0, localObject.length);
      }
      freeArrays(arrayOfInt, (Object[])localObject, this.mSize);
    }
    if (k < this.mSize)
    {
      arrayOfInt = this.mHashes;
      localObject = this.mHashes;
      i = k + 1;
      System.arraycopy(arrayOfInt, k, localObject, i, this.mSize - k);
      System.arraycopy(this.mArray, k, this.mArray, i, this.mSize - k);
    }
    this.mHashes[k] = j;
    this.mArray[k] = paramE;
    this.mSize += 1;
    return true;
  }
  
  public void addAll(@NonNull ArraySet<? extends E> paramArraySet)
  {
    int j = paramArraySet.mSize;
    ensureCapacity(this.mSize + j);
    int k = this.mSize;
    int i = 0;
    if (k == 0)
    {
      if (j > 0)
      {
        System.arraycopy(paramArraySet.mHashes, 0, this.mHashes, 0, j);
        System.arraycopy(paramArraySet.mArray, 0, this.mArray, 0, j);
        this.mSize = j;
      }
    }
    else {
      while (i < j)
      {
        add(paramArraySet.valueAt(i));
        i += 1;
      }
    }
  }
  
  public boolean addAll(@NonNull Collection<? extends E> paramCollection)
  {
    ensureCapacity(this.mSize + paramCollection.size());
    paramCollection = paramCollection.iterator();
    boolean bool = false;
    while (paramCollection.hasNext()) {
      bool |= add(paramCollection.next());
    }
    return bool;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void append(E paramE)
  {
    int j = this.mSize;
    int i;
    if (paramE == null) {
      i = 0;
    } else {
      i = paramE.hashCode();
    }
    if (j < this.mHashes.length)
    {
      if ((j > 0) && (this.mHashes[(j - 1)] > i))
      {
        add(paramE);
        return;
      }
      this.mSize = (j + 1);
      this.mHashes[j] = i;
      this.mArray[j] = paramE;
      return;
    }
    throw new IllegalStateException("Array is full");
  }
  
  public void clear()
  {
    if (this.mSize != 0)
    {
      freeArrays(this.mHashes, this.mArray, this.mSize);
      this.mHashes = INT;
      this.mArray = OBJECT;
      this.mSize = 0;
    }
  }
  
  public boolean contains(@Nullable Object paramObject)
  {
    return indexOf(paramObject) >= 0;
  }
  
  public boolean containsAll(@NonNull Collection<?> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!contains(paramCollection.next())) {
        return false;
      }
    }
    return true;
  }
  
  public void ensureCapacity(int paramInt)
  {
    if (this.mHashes.length < paramInt)
    {
      int[] arrayOfInt = this.mHashes;
      Object[] arrayOfObject = this.mArray;
      allocArrays(paramInt);
      if (this.mSize > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.mHashes, 0, this.mSize);
        System.arraycopy(arrayOfObject, 0, this.mArray, 0, this.mSize);
      }
      freeArrays(arrayOfInt, arrayOfObject, this.mSize);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    int i;
    if ((paramObject instanceof Set))
    {
      paramObject = (Set)paramObject;
      if (size() != ((Set)paramObject).size()) {
        return false;
      }
      i = 0;
    }
    try
    {
      while (i < this.mSize)
      {
        boolean bool = ((Set)paramObject).contains(valueAt(i));
        if (!bool) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    catch (NullPointerException paramObject)
    {
      return false;
    }
    catch (ClassCastException paramObject) {}
    return false;
    return false;
  }
  
  public int hashCode()
  {
    int[] arrayOfInt = this.mHashes;
    int k = this.mSize;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += arrayOfInt[i];
      i += 1;
    }
    return j;
  }
  
  public int indexOf(@Nullable Object paramObject)
  {
    if (paramObject == null) {
      return indexOfNull();
    }
    return indexOf(paramObject, paramObject.hashCode());
  }
  
  public boolean isEmpty()
  {
    return this.mSize <= 0;
  }
  
  public Iterator<E> iterator()
  {
    return getCollection().getKeySet().iterator();
  }
  
  public boolean remove(@Nullable Object paramObject)
  {
    int i = indexOf(paramObject);
    if (i >= 0)
    {
      removeAt(i);
      return true;
    }
    return false;
  }
  
  public boolean removeAll(@NonNull ArraySet<? extends E> paramArraySet)
  {
    int j = paramArraySet.mSize;
    int k = this.mSize;
    boolean bool = false;
    int i = 0;
    while (i < j)
    {
      remove(paramArraySet.valueAt(i));
      i += 1;
    }
    if (k != this.mSize) {
      bool = true;
    }
    return bool;
  }
  
  public boolean removeAll(@NonNull Collection<?> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    boolean bool = false;
    while (paramCollection.hasNext()) {
      bool |= remove(paramCollection.next());
    }
    return bool;
  }
  
  public E removeAt(int paramInt)
  {
    Object localObject = this.mArray[paramInt];
    if (this.mSize <= 1)
    {
      freeArrays(this.mHashes, this.mArray, this.mSize);
      this.mHashes = INT;
      this.mArray = OBJECT;
      this.mSize = 0;
      return (E)localObject;
    }
    int j = this.mHashes.length;
    int i = 8;
    int[] arrayOfInt;
    if ((j > 8) && (this.mSize < this.mHashes.length / 3))
    {
      if (this.mSize > 8)
      {
        i = this.mSize;
        i = (this.mSize >> 1) + i;
      }
      arrayOfInt = this.mHashes;
      Object[] arrayOfObject = this.mArray;
      allocArrays(i);
      this.mSize -= 1;
      if (paramInt > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.mHashes, 0, paramInt);
        System.arraycopy(arrayOfObject, 0, this.mArray, 0, paramInt);
      }
      if (paramInt < this.mSize)
      {
        i = paramInt + 1;
        System.arraycopy(arrayOfInt, i, this.mHashes, paramInt, this.mSize - paramInt);
        System.arraycopy(arrayOfObject, i, this.mArray, paramInt, this.mSize - paramInt);
        return (E)localObject;
      }
    }
    else
    {
      this.mSize -= 1;
      if (paramInt < this.mSize)
      {
        arrayOfInt = this.mHashes;
        i = paramInt + 1;
        System.arraycopy(arrayOfInt, i, this.mHashes, paramInt, this.mSize - paramInt);
        System.arraycopy(this.mArray, i, this.mArray, paramInt, this.mSize - paramInt);
      }
      this.mArray[this.mSize] = null;
    }
    return (E)localObject;
  }
  
  public boolean retainAll(@NonNull Collection<?> paramCollection)
  {
    int i = this.mSize - 1;
    boolean bool = false;
    while (i >= 0)
    {
      if (!paramCollection.contains(this.mArray[i]))
      {
        removeAt(i);
        bool = true;
      }
      i -= 1;
    }
    return bool;
  }
  
  public int size()
  {
    return this.mSize;
  }
  
  @NonNull
  public Object[] toArray()
  {
    Object[] arrayOfObject = new Object[this.mSize];
    System.arraycopy(this.mArray, 0, arrayOfObject, 0, this.mSize);
    return arrayOfObject;
  }
  
  @NonNull
  public <T> T[] toArray(@NonNull T[] paramArrayOfT)
  {
    Object localObject = paramArrayOfT;
    if (paramArrayOfT.length < this.mSize) {
      localObject = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), this.mSize);
    }
    System.arraycopy(this.mArray, 0, localObject, 0, this.mSize);
    if (localObject.length > this.mSize) {
      localObject[this.mSize] = null;
    }
    return (T[])localObject;
  }
  
  public String toString()
  {
    if (isEmpty()) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(this.mSize * 14);
    localStringBuilder.append('{');
    int i = 0;
    while (i < this.mSize)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      Object localObject = valueAt(i);
      if (localObject != this) {
        localStringBuilder.append(localObject);
      } else {
        localStringBuilder.append("(this Set)");
      }
      i += 1;
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  @Nullable
  public E valueAt(int paramInt)
  {
    return (E)this.mArray[paramInt];
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\util\ArraySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */