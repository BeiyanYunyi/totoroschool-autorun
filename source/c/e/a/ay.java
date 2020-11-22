package c.e.a;

import c.b.c;
import java.io.IOException;
import java.io.OutputStream;

class ay
  implements aa
{
  private static c a = c.a(ay.class);
  private byte[] b;
  private int c;
  private int d;
  
  public ay(int paramInt1, int paramInt2)
  {
    this.b = new byte[paramInt1];
    this.c = paramInt2;
    this.d = 0;
  }
  
  public int a()
  {
    return this.d;
  }
  
  public void a(OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(this.b, 0, this.d);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    while (this.d + paramArrayOfByte.length > this.b.length)
    {
      byte[] arrayOfByte = new byte[this.b.length + this.c];
      System.arraycopy(this.b, 0, arrayOfByte, 0, this.d);
      this.b = arrayOfByte;
    }
    System.arraycopy(paramArrayOfByte, 0, this.b, this.d, paramArrayOfByte.length);
    this.d += paramArrayOfByte.length;
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    System.arraycopy(paramArrayOfByte, 0, this.b, paramInt, paramArrayOfByte.length);
  }
  
  public void b()
    throws IOException
  {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */