package com.loc;

public final class bl
{
  private bm a;
  private bn b;
  
  public bl(bn parambn)
  {
    this(parambn, (byte)0);
  }
  
  private bl(bn parambn, byte paramByte)
  {
    this(parambn, '\000');
  }
  
  private bl(bn parambn, char paramChar)
  {
    this.b = parambn;
    if (parambn.e == null) {
      parambn = null;
    } else {
      parambn = parambn.e;
    }
    this.a = new bm(this.b.c, this.b.d, parambn, false);
    this.a.b();
    this.a.a();
  }
  
  public final void a(a parama)
  {
    this.a.a(this.b.c(), this.b.k(), this.b.j(), this.b.b(), this.b.b_(), this.b.d(), parama);
  }
  
  public static abstract interface a
  {
    public abstract void a(byte[] paramArrayOfByte, long paramLong);
    
    public abstract void b();
    
    public abstract void c();
    
    public abstract void d();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */