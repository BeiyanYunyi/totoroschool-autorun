package c.a;

class h
  extends aq
{
  private int a;
  private int b;
  
  public h(int paramInt1, int paramInt2)
  {
    super(an.aI);
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public byte[] a()
  {
    byte[] arrayOfByte = new byte[4];
    ag.a(this.a, arrayOfByte, 0);
    arrayOfByte[1] = ((byte)(arrayOfByte[1] | 0x80));
    arrayOfByte[2] = ((byte)this.b);
    arrayOfByte[3] = -1;
    return arrayOfByte;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */