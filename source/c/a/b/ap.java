package c.a.b;

import java.util.Stack;

abstract class ap
  extends as
{
  private as[] a = new as[0];
  
  protected void a(as paramas)
  {
    paramas.b(this);
    as[] arrayOfas = new as[this.a.length + 1];
    System.arraycopy(this.a, 0, arrayOfas, 0, this.a.length);
    arrayOfas[this.a.length] = paramas;
    this.a = arrayOfas;
  }
  
  public abstract void a(Stack paramStack);
  
  protected void e()
  {
    int i = 0;
    while (i < this.a.length)
    {
      this.a[i].i();
      i += 1;
    }
  }
  
  protected as[] f()
  {
    return this.a;
  }
  
  abstract int i_();
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\b\ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */