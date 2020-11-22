package android.arch.lifecycle;

class FullLifecycleObserverAdapter
  implements GenericLifecycleObserver
{
  private final FullLifecycleObserver a;
  
  FullLifecycleObserverAdapter(FullLifecycleObserver paramFullLifecycleObserver)
  {
    this.a = paramFullLifecycleObserver;
  }
  
  public void a(e parame, c.a parama)
  {
    switch (1.a[parama.ordinal()])
    {
    default: 
      return;
    case 7: 
      throw new IllegalArgumentException("ON_ANY must not been send by anybody");
    case 6: 
      this.a.f(parame);
      return;
    case 5: 
      this.a.e(parame);
      return;
    case 4: 
      this.a.d(parame);
      return;
    case 3: 
      this.a.c(parame);
      return;
    case 2: 
      this.a.b(parame);
      return;
    }
    this.a.a(parame);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\arch\lifecycle\FullLifecycleObserverAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */