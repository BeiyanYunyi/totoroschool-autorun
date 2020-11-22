package c.b.a;

import c.b.c;
import java.io.PrintStream;

public class b
  extends c
{
  private boolean a = false;
  
  public void a(Object paramObject)
  {
    System.err.print("Error: ");
    System.err.println(paramObject);
  }
  
  public void a(Object paramObject, Throwable paramThrowable)
  {
    if (!this.a)
    {
      System.err.print("Warning:  ");
      System.err.println(paramObject);
      paramThrowable.printStackTrace();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  protected c b(Class paramClass)
  {
    return this;
  }
  
  public void b(Object paramObject)
  {
    if (!this.a)
    {
      System.err.print("Warning:  ");
      System.err.println(paramObject);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\b\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */