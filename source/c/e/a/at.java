package c.e.a;

import c.e.n;

public class at
  extends n
{
  static a cellReferenced;
  static a copyPropertySets = new a("Error encounted when copying additional property sets");
  static a formatInitialized = new a("Attempt to modify a referenced format");
  static a maxColumnsExceeded;
  static a maxRowsExceeded;
  
  static
  {
    cellReferenced = new a("Cell has already been added to a worksheet");
    maxRowsExceeded = new a("The maximum number of rows permitted on a worksheet been exceeded");
    maxColumnsExceeded = new a("The maximum number of columns permitted on a worksheet has been exceeded");
  }
  
  public at(a parama)
  {
    super(parama.a);
  }
  
  private static class a
  {
    public String a;
    
    a(String paramString)
    {
      this.a = paramString;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */