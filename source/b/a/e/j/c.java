package b.a.e.j;

import java.util.concurrent.atomic.AtomicReference;

public final class c
  extends AtomicReference<Throwable>
{
  private static final long serialVersionUID = 3949248817947090603L;
  
  public boolean addThrowable(Throwable paramThrowable)
  {
    return j.a(this, paramThrowable);
  }
  
  public boolean isTerminated()
  {
    return get() == j.a;
  }
  
  public Throwable terminate()
  {
    return j.a(this);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\j\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */