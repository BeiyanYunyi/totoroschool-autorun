package android.arch.lifecycle;

import android.arch.a.a.a;
import android.arch.a.b.b;
import android.arch.a.b.b.d;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Iterator;
import java.util.Map.Entry;

public abstract class LiveData<T>
{
  private static final Object NOT_SET = new Object();
  static final int START_VERSION = -1;
  private int mActiveCount = 0;
  private volatile Object mData = NOT_SET;
  private final Object mDataLock = new Object();
  private boolean mDispatchInvalidated;
  private boolean mDispatchingValue;
  private b<k<T>, LiveData<T>.b> mObservers = new b();
  private volatile Object mPendingData = NOT_SET;
  private final Runnable mPostValueRunnable = new Runnable()
  {
    public void run()
    {
      synchronized (LiveData.this.mDataLock)
      {
        Object localObject2 = LiveData.this.mPendingData;
        LiveData.access$102(LiveData.this, LiveData.NOT_SET);
        LiveData.this.setValue(localObject2);
        return;
      }
    }
  };
  private int mVersion = -1;
  
  private static void assertMainThread(String paramString)
  {
    if (a.a().b()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot invoke ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" on a background");
    localStringBuilder.append(" thread");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  private void considerNotify(LiveData<T>.b paramLiveData)
  {
    if (!paramLiveData.d) {
      return;
    }
    if (!paramLiveData.a())
    {
      paramLiveData.a(false);
      return;
    }
    if (paramLiveData.e >= this.mVersion) {
      return;
    }
    paramLiveData.e = this.mVersion;
    paramLiveData.c.onChanged(this.mData);
  }
  
  private void dispatchingValue(@Nullable LiveData<T>.b paramLiveData)
  {
    if (this.mDispatchingValue)
    {
      this.mDispatchInvalidated = true;
      return;
    }
    this.mDispatchingValue = true;
    do
    {
      this.mDispatchInvalidated = false;
      LiveData<T>.b localLiveData;
      if (paramLiveData != null)
      {
        considerNotify(paramLiveData);
        localLiveData = null;
      }
      else
      {
        b.d locald = this.mObservers.c();
        do
        {
          localLiveData = paramLiveData;
          if (!locald.hasNext()) {
            break;
          }
          considerNotify((b)((Map.Entry)locald.next()).getValue());
        } while (!this.mDispatchInvalidated);
        localLiveData = paramLiveData;
      }
      paramLiveData = localLiveData;
    } while (this.mDispatchInvalidated);
    this.mDispatchingValue = false;
  }
  
  @Nullable
  public T getValue()
  {
    Object localObject = this.mData;
    if (localObject != NOT_SET) {
      return (T)localObject;
    }
    return null;
  }
  
  int getVersion()
  {
    return this.mVersion;
  }
  
  public boolean hasActiveObservers()
  {
    return this.mActiveCount > 0;
  }
  
  public boolean hasObservers()
  {
    return this.mObservers.a() > 0;
  }
  
  @MainThread
  public void observe(@NonNull e parame, @NonNull k<T> paramk)
  {
    if (parame.getLifecycle().a() == c.b.DESTROYED) {
      return;
    }
    LifecycleBoundObserver localLifecycleBoundObserver = new LifecycleBoundObserver(parame, paramk);
    paramk = (b)this.mObservers.a(paramk, localLifecycleBoundObserver);
    if ((paramk != null) && (!paramk.a(parame))) {
      throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }
    if (paramk != null) {
      return;
    }
    parame.getLifecycle().a(localLifecycleBoundObserver);
  }
  
  @MainThread
  public void observeForever(@NonNull k<T> paramk)
  {
    a locala = new a(paramk);
    paramk = (b)this.mObservers.a(paramk, locala);
    if ((paramk != null) && ((paramk instanceof LifecycleBoundObserver))) {
      throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
    }
    if (paramk != null) {
      return;
    }
    locala.a(true);
  }
  
  protected void onActive() {}
  
  protected void onInactive() {}
  
  protected void postValue(T paramT)
  {
    for (;;)
    {
      synchronized (this.mDataLock)
      {
        if (this.mPendingData == NOT_SET)
        {
          i = 1;
          this.mPendingData = paramT;
          if (i == 0) {
            return;
          }
          a.a().b(this.mPostValueRunnable);
          return;
        }
      }
      int i = 0;
    }
  }
  
  @MainThread
  public void removeObserver(@NonNull k<T> paramk)
  {
    assertMainThread("removeObserver");
    paramk = (b)this.mObservers.b(paramk);
    if (paramk == null) {
      return;
    }
    paramk.b();
    paramk.a(false);
  }
  
  @MainThread
  public void removeObservers(@NonNull e parame)
  {
    assertMainThread("removeObservers");
    Iterator localIterator = this.mObservers.iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((b)localEntry.getValue()).a(parame)) {
        removeObserver((k)localEntry.getKey());
      }
    }
  }
  
  @MainThread
  protected void setValue(T paramT)
  {
    assertMainThread("setValue");
    this.mVersion += 1;
    this.mData = paramT;
    dispatchingValue(null);
  }
  
  class LifecycleBoundObserver
    extends LiveData<T>.b
    implements GenericLifecycleObserver
  {
    @NonNull
    final e a;
    
    LifecycleBoundObserver(@NonNull k<T> paramk)
    {
      super(localk);
      this.a = paramk;
    }
    
    public void a(e parame, c.a parama)
    {
      if (this.a.getLifecycle().a() == c.b.DESTROYED)
      {
        LiveData.this.removeObserver(this.c);
        return;
      }
      a(a());
    }
    
    boolean a()
    {
      return this.a.getLifecycle().a().isAtLeast(c.b.STARTED);
    }
    
    boolean a(e parame)
    {
      return this.a == parame;
    }
    
    void b()
    {
      this.a.getLifecycle().b(this);
    }
  }
  
  private class a
    extends LiveData<T>.b
  {
    a()
    {
      super(localk);
    }
    
    boolean a()
    {
      return true;
    }
  }
  
  private abstract class b
  {
    final k<T> c;
    boolean d;
    int e = -1;
    
    b()
    {
      k localk;
      this.c = localk;
    }
    
    void a(boolean paramBoolean)
    {
      if (paramBoolean == this.d) {
        return;
      }
      this.d = paramBoolean;
      int i = LiveData.this.mActiveCount;
      int j = 1;
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      LiveData localLiveData = LiveData.this;
      int k = localLiveData.mActiveCount;
      if (!this.d) {
        j = -1;
      }
      LiveData.access$302(localLiveData, k + j);
      if ((i != 0) && (this.d)) {
        LiveData.this.onActive();
      }
      if ((LiveData.this.mActiveCount == 0) && (!this.d)) {
        LiveData.this.onInactive();
      }
      if (this.d) {
        LiveData.this.dispatchingValue(this);
      }
    }
    
    abstract boolean a();
    
    boolean a(e parame)
    {
      return false;
    }
    
    void b() {}
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\arch\lifecycle\LiveData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */