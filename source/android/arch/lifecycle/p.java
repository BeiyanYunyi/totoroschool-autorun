package android.arch.lifecycle;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class p
{
  private final HashMap<String, n> a = new HashMap();
  
  final n a(String paramString)
  {
    return (n)this.a.get(paramString);
  }
  
  public final void a()
  {
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((n)localIterator.next()).onCleared();
    }
    this.a.clear();
  }
  
  final void a(String paramString, n paramn)
  {
    paramString = (n)this.a.put(paramString, paramn);
    if (paramString != null) {
      paramString.onCleared();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\arch\lifecycle\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */