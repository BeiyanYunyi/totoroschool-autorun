package android.support.v4.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ArrayMap<K, V>
  extends SimpleArrayMap<K, V>
  implements Map<K, V>
{
  @Nullable
  MapCollections<K, V> mCollections;
  
  public ArrayMap() {}
  
  public ArrayMap(int paramInt)
  {
    super(paramInt);
  }
  
  public ArrayMap(SimpleArrayMap paramSimpleArrayMap)
  {
    super(paramSimpleArrayMap);
  }
  
  private MapCollections<K, V> getCollection()
  {
    if (this.mCollections == null) {
      this.mCollections = new MapCollections()
      {
        protected void colClear()
        {
          ArrayMap.this.clear();
        }
        
        protected Object colGetEntry(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return ArrayMap.this.mArray[((paramAnonymousInt1 << 1) + paramAnonymousInt2)];
        }
        
        protected Map<K, V> colGetMap()
        {
          return ArrayMap.this;
        }
        
        protected int colGetSize()
        {
          return ArrayMap.this.mSize;
        }
        
        protected int colIndexOfKey(Object paramAnonymousObject)
        {
          return ArrayMap.this.indexOfKey(paramAnonymousObject);
        }
        
        protected int colIndexOfValue(Object paramAnonymousObject)
        {
          return ArrayMap.this.indexOfValue(paramAnonymousObject);
        }
        
        protected void colPut(K paramAnonymousK, V paramAnonymousV)
        {
          ArrayMap.this.put(paramAnonymousK, paramAnonymousV);
        }
        
        protected void colRemoveAt(int paramAnonymousInt)
        {
          ArrayMap.this.removeAt(paramAnonymousInt);
        }
        
        protected V colSetValue(int paramAnonymousInt, V paramAnonymousV)
        {
          return (V)ArrayMap.this.setValueAt(paramAnonymousInt, paramAnonymousV);
        }
      };
    }
    return this.mCollections;
  }
  
  public boolean containsAll(@NonNull Collection<?> paramCollection)
  {
    return MapCollections.containsAllHelper(this, paramCollection);
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    return getCollection().getEntrySet();
  }
  
  public Set<K> keySet()
  {
    return getCollection().getKeySet();
  }
  
  public void putAll(Map<? extends K, ? extends V> paramMap)
  {
    ensureCapacity(this.mSize + paramMap.size());
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      put(localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public boolean removeAll(@NonNull Collection<?> paramCollection)
  {
    return MapCollections.removeAllHelper(this, paramCollection);
  }
  
  public boolean retainAll(@NonNull Collection<?> paramCollection)
  {
    return MapCollections.retainAllHelper(this, paramCollection);
  }
  
  public Collection<V> values()
  {
    return getCollection().getValues();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\support\v4\util\ArrayMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */