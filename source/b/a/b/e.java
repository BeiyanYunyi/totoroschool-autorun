package b.a.b;

final class e
  extends d<Runnable>
{
  private static final long serialVersionUID = -8219729196779211169L;
  
  e(Runnable paramRunnable)
  {
    super(paramRunnable);
  }
  
  protected void onDisposed(Runnable paramRunnable)
  {
    paramRunnable.run();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RunnableDisposable(disposed=");
    localStringBuilder.append(isDisposed());
    localStringBuilder.append(", ");
    localStringBuilder.append(get());
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */