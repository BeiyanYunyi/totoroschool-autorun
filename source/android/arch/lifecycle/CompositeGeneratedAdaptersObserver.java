package android.arch.lifecycle;

import android.support.annotation.RestrictTo;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class CompositeGeneratedAdaptersObserver
  implements GenericLifecycleObserver
{
  private final b[] a;
  
  CompositeGeneratedAdaptersObserver(b[] paramArrayOfb)
  {
    this.a = paramArrayOfb;
  }
  
  public void a(e parame, c.a parama)
  {
    i locali = new i();
    b[] arrayOfb = this.a;
    int k = arrayOfb.length;
    int j = 0;
    int i = 0;
    while (i < k)
    {
      arrayOfb[i].a(parame, parama, false, locali);
      i += 1;
    }
    arrayOfb = this.a;
    k = arrayOfb.length;
    i = j;
    while (i < k)
    {
      arrayOfb[i].a(parame, parama, true, locali);
      i += 1;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\arch\lifecycle\CompositeGeneratedAdaptersObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */