package c.a;

import c.b.c;

public abstract class aq
  extends ak
  implements j
{
  private static c a = c.a(aq.class);
  
  protected aq(an paraman)
  {
    super(paraman);
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    int m = (paramArrayOfByte.length - 8224) / 8224 + 1;
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + m * 4];
    int j = 0;
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 8224);
    int k = 8224;
    int i = 8224;
    while (j < m)
    {
      int n = Math.min(paramArrayOfByte.length - k, 8224);
      ag.a(an.u.a, arrayOfByte, i);
      ag.a(n, arrayOfByte, i + 2);
      System.arraycopy(paramArrayOfByte, k, arrayOfByte, i + 4, n);
      k += n;
      i += n + 4;
      j += 1;
    }
    return arrayOfByte;
  }
  
  protected abstract byte[] a();
  
  public final byte[] g()
  {
    byte[] arrayOfByte2 = a();
    int i = arrayOfByte2.length;
    byte[] arrayOfByte1 = arrayOfByte2;
    if (arrayOfByte2.length > 8224)
    {
      arrayOfByte1 = a(arrayOfByte2);
      i = 8224;
    }
    arrayOfByte2 = new byte[arrayOfByte1.length + 4];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 4, arrayOfByte1.length);
    ag.a(o(), arrayOfByte2, 0);
    ag.a(i, arrayOfByte2, 2);
    return arrayOfByte2;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */