package android.arch.a.b;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map.Entry;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class a<K, V>
  extends b<K, V>
{
  private HashMap<K, b.c<K, V>> a = new HashMap();
  
  protected b.c<K, V> a(K paramK)
  {
    return (b.c)this.a.get(paramK);
  }
  
  public V a(@NonNull K paramK, @NonNull V paramV)
  {
    b.c localc = a(paramK);
    if (localc != null) {
      return (V)localc.b;
    }
    this.a.put(paramK, b(paramK, paramV));
    return null;
  }
  
  public V b(@NonNull K paramK)
  {
    Object localObject = super.b(paramK);
    this.a.remove(paramK);
    return (V)localObject;
  }
  
  public boolean c(K paramK)
  {
    return this.a.containsKey(paramK);
  }
  
  public Map.Entry<K, V> d(K paramK)
  {
    if (c(paramK)) {
      return ((b.c)this.a.get(paramK)).d;
    }
    return null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\arch\a\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */