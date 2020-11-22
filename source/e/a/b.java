package e.a;

public abstract class b
  implements Runnable
{
  protected final String c;
  
  public b(String paramString, Object... paramVarArgs)
  {
    this.c = c.a(paramString, paramVarArgs);
  }
  
  protected abstract void c();
  
  public final void run()
  {
    String str = Thread.currentThread().getName();
    Thread.currentThread().setName(this.c);
    try
    {
      c();
      return;
    }
    finally
    {
      Thread.currentThread().setName(str);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */