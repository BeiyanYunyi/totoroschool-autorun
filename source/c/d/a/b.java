package c.d.a;

import c.f;

public class b
  extends f
{
  static final a corruptFileFormat = new a("The file format is corrupt");
  static final a excelFileNotFound;
  static final a excelFileTooBig;
  static final a expectedGlobals;
  static final a passwordProtected;
  static final a streamNotFound;
  static final a unrecognizedBiffVersion = new a("Unrecognized biff version");
  static final a unrecognizedOLEFile;
  
  static
  {
    expectedGlobals = new a("Expected globals");
    excelFileTooBig = new a("Not all of the excel file could be read");
    excelFileNotFound = new a("The input file was not found");
    unrecognizedOLEFile = new a("Unable to recognize OLE stream");
    streamNotFound = new a("Compound file does not contain the specified stream");
    passwordProtected = new a("The workbook is password protected");
  }
  
  public b(a parama)
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


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\d\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */