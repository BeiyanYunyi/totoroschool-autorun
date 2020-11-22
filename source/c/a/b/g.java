package c.a.b;

class g
  extends ao
{
  private boolean a;
  
  public g() {}
  
  public g(String paramString)
  {
    this.a = Boolean.valueOf(paramString).booleanValue();
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool;
    if (paramArrayOfByte[paramInt] == 1) {
      bool = true;
    } else {
      bool = false;
    }
    this.a = bool;
    return 1;
  }
  
  public void a(StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append(new Boolean(this.a).toString());
  }
  
  byte[] c()
  {
    int i = bh.g.a();
    int j = 0;
    if (this.a == true) {
      j = 1;
    }
    return new byte[] { i, (byte)j };
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */