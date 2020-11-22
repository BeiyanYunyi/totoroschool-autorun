package c.a;

public class i
{
  private int a;
  private byte[] b;
  private int c;
  
  public i()
  {
    this(1024);
  }
  
  public i(int paramInt)
  {
    this.a = paramInt;
    this.b = new byte['Ѐ'];
    this.c = 0;
  }
  
  private void a(int paramInt)
  {
    while (this.c + paramInt >= this.b.length)
    {
      byte[] arrayOfByte = new byte[this.b.length + this.a];
      System.arraycopy(this.b, 0, arrayOfByte, 0, this.c);
      this.b = arrayOfByte;
    }
  }
  
  public void a(byte paramByte)
  {
    a(1);
    this.b[this.c] = paramByte;
    this.c += 1;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    a(paramArrayOfByte.length);
    System.arraycopy(paramArrayOfByte, 0, this.b, this.c, paramArrayOfByte.length);
    this.c += paramArrayOfByte.length;
  }
  
  public byte[] a()
  {
    byte[] arrayOfByte = new byte[this.c];
    System.arraycopy(this.b, 0, arrayOfByte, 0, this.c);
    return arrayOfByte;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */