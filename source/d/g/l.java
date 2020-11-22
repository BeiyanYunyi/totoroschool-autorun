package d.g;

public enum l
  implements d
{
  private final int mask;
  private final int value;
  
  static
  {
    l locall1 = new l("IGNORE_CASE", 0, 2, 0, 2, null);
    IGNORE_CASE = locall1;
    l locall2 = new l("MULTILINE", 1, 8, 0, 2, null);
    MULTILINE = locall2;
    l locall3 = new l("LITERAL", 2, 16, 0, 2, null);
    LITERAL = locall3;
    l locall4 = new l("UNIX_LINES", 3, 1, 0, 2, null);
    UNIX_LINES = locall4;
    l locall5 = new l("COMMENTS", 4, 4, 0, 2, null);
    COMMENTS = locall5;
    l locall6 = new l("DOT_MATCHES_ALL", 5, 32, 0, 2, null);
    DOT_MATCHES_ALL = locall6;
    l locall7 = new l("CANON_EQ", 6, 128, 0, 2, null);
    CANON_EQ = locall7;
    a = new l[] { locall1, locall2, locall3, locall4, locall5, locall6, locall7 };
  }
  
  private l(int paramInt1, int paramInt2)
  {
    this.value = paramInt1;
    this.mask = paramInt2;
  }
  
  public int getMask()
  {
    return this.mask;
  }
  
  public int getValue()
  {
    return this.value;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\d\g\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */