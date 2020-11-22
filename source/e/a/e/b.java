package e.a.e;

public enum b
{
  public final int httpCode;
  
  static
  {
    INTERNAL_ERROR = new b("INTERNAL_ERROR", 2, 2);
    FLOW_CONTROL_ERROR = new b("FLOW_CONTROL_ERROR", 3, 3);
    REFUSED_STREAM = new b("REFUSED_STREAM", 4, 7);
    CANCEL = new b("CANCEL", 5, 8);
    COMPRESSION_ERROR = new b("COMPRESSION_ERROR", 6, 9);
    CONNECT_ERROR = new b("CONNECT_ERROR", 7, 10);
    ENHANCE_YOUR_CALM = new b("ENHANCE_YOUR_CALM", 8, 11);
    INADEQUATE_SECURITY = new b("INADEQUATE_SECURITY", 9, 12);
  }
  
  private b(int paramInt)
  {
    this.httpCode = paramInt;
  }
  
  public static b fromHttp2(int paramInt)
  {
    b[] arrayOfb = values();
    int j = arrayOfb.length;
    int i = 0;
    while (i < j)
    {
      b localb = arrayOfb[i];
      if (localb.httpCode == paramInt) {
        return localb;
      }
      i += 1;
    }
    return null;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */