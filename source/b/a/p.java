package b.a;

public abstract interface p<Downstream, Upstream>
{
  public abstract s<? super Upstream> a(s<? super Downstream> params)
    throws Exception;
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\b\a\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */