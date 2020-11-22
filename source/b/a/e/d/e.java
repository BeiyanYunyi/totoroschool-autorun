package b.a.e.d;

import b.a.b.b;

public final class e<T>
  extends d<T>
{
  public void onError(Throwable paramThrowable)
  {
    if (this.a == null) {
      this.b = paramThrowable;
    }
    countDown();
  }
  
  public void onNext(T paramT)
  {
    if (this.a == null)
    {
      this.a = paramT;
      this.c.dispose();
      countDown();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\d\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */