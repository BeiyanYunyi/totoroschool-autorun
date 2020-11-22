package c.d.a;

import c.b.c;
import java.util.ArrayList;

public final class e
{
  private static final c a = c.a(e.class);
  private int b;
  private int c;
  private d d;
  private byte[] e;
  private ArrayList f;
  
  public byte[] a()
  {
    if (this.e == null) {
      this.e = this.d.a(this.c, this.b);
    }
    if (this.f != null)
    {
      byte[][] arrayOfByte = new byte[this.f.size()][];
      int i = 0;
      int j = 0;
      while (i < this.f.size())
      {
        arrayOfByte[i] = ((e)this.f.get(i)).a();
        j += arrayOfByte[i].length;
        i += 1;
      }
      byte[] arrayOfByte1 = new byte[this.e.length + j];
      System.arraycopy(this.e, 0, arrayOfByte1, 0, this.e.length);
      j = this.e.length;
      i = 0;
      while (i < arrayOfByte.length)
      {
        byte[] arrayOfByte2 = arrayOfByte[i];
        System.arraycopy(arrayOfByte2, 0, arrayOfByte1, j, arrayOfByte2.length);
        j += arrayOfByte2.length;
        i += 1;
      }
      this.e = arrayOfByte1;
    }
    return this.e;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\d\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */