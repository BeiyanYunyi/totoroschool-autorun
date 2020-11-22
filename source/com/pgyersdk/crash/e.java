package com.pgyersdk.crash;

import com.pgyersdk.f.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class e
{
  private List<PgyerObserver> a = new ArrayList();
  
  public void attach(PgyerObserver paramPgyerObserver)
  {
    if (!this.a.contains(paramPgyerObserver))
    {
      this.a.add(paramPgyerObserver);
      return;
    }
    f.d("PgyerSDK", "This observer is already attached.");
  }
  
  public void detach(PgyerObserver paramPgyerObserver)
  {
    if (this.a.contains(paramPgyerObserver)) {
      this.a.remove(paramPgyerObserver);
    }
  }
  
  public void notifyObservers(Thread paramThread, Throwable paramThrowable)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((PgyerObserver)localIterator.next()).receivedCrash(paramThread, paramThrowable);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\crash\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */