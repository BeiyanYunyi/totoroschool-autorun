package c.a.b;

import c.f;

public class v
  extends f
{
  public static final a BIFF8_SUPPORTED;
  static final a CELL_NAME_NOT_FOUND = new a("Could not find named cell");
  static final a INCORRECT_ARGUMENTS;
  static final a LEXICAL_ERROR;
  static final a SHEET_REF_NOT_FOUND;
  static final a UNRECOGNIZED_FUNCTION;
  static final a UNRECOGNIZED_TOKEN = new a("Unrecognized token");
  
  static
  {
    UNRECOGNIZED_FUNCTION = new a("Unrecognized function");
    BIFF8_SUPPORTED = new a("Only biff8 formulas are supported");
    LEXICAL_ERROR = new a("Lexical error:  ");
    INCORRECT_ARGUMENTS = new a("Incorrect arguments supplied to function");
    SHEET_REF_NOT_FOUND = new a("Could not find sheet");
  }
  
  public v(a parama)
  {
    super(a.a(parama));
  }
  
  public v(a parama, int paramInt)
  {
    super(localStringBuilder.toString());
  }
  
  public v(a parama, String paramString)
  {
    super(localStringBuilder.toString());
  }
  
  private static class a
  {
    private String a;
    
    a(String paramString)
    {
      this.a = paramString;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\b\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */