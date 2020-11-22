package b.a.e.d;

public final class f<T>
  extends d<T>
{
  public void onError(Throwable paramThrowable)
  {
    this.a = null;
    this.b = paramThrowable;
    countDown();
  }
  
  public void onNext(T paramT)
  {
    this.a = paramT;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\e\d\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */