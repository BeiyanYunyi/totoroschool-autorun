package android.arch.a.a;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class b
  extends c
{
  private final Object a = new Object();
  private ExecutorService b = Executors.newFixedThreadPool(2);
  @Nullable
  private volatile Handler c;
  
  public void a(Runnable paramRunnable)
  {
    this.b.execute(paramRunnable);
  }
  
  public void b(Runnable paramRunnable)
  {
    if (this.c == null) {
      synchronized (this.a)
      {
        if (this.c == null) {
          this.c = new Handler(Looper.getMainLooper());
        }
      }
    }
    this.c.post(paramRunnable);
  }
  
  public boolean b()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\android\arch\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */