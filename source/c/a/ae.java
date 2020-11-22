package c.a;

import c.b.c;

public abstract class ae
{
  private static c a = c.a(ae.class);
  private a b = a();
  private a c = a();
  private a d = a();
  
  protected abstract a a();
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (!this.b.a())
    {
      localStringBuffer.append("&L");
      localStringBuffer.append(this.b.b());
    }
    if (!this.d.a())
    {
      localStringBuffer.append("&C");
      localStringBuffer.append(this.d.b());
    }
    if (!this.c.a())
    {
      localStringBuffer.append("&R");
      localStringBuffer.append(this.c.b());
    }
    return localStringBuffer.toString();
  }
  
  protected static class a
  {
    private StringBuffer a = new StringBuffer();
    
    protected boolean a()
    {
      return (this.a == null) || (this.a.length() == 0);
    }
    
    protected String b()
    {
      if (this.a != null) {
        return this.a.toString();
      }
      return "";
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */