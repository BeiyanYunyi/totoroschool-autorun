package d.e;

public enum g
{
  static
  {
    g localg1 = new g("PUBLIC", 0);
    PUBLIC = localg1;
    g localg2 = new g("PROTECTED", 1);
    PROTECTED = localg2;
    g localg3 = new g("INTERNAL", 2);
    INTERNAL = localg3;
    g localg4 = new g("PRIVATE", 3);
    PRIVATE = localg4;
    a = new g[] { localg1, localg2, localg3, localg4 };
  }
  
  private g() {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\d\e\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */