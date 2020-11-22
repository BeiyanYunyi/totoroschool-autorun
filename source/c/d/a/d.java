package c.d.a;

import c.b.c;

public class d
{
  private static c a = c.a(d.class);
  private byte[] b;
  
  public byte[] a(int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    try
    {
      System.arraycopy(this.b, paramInt1, arrayOfByte, 0, paramInt2);
      return arrayOfByte;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      c localc = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Array index out of bounds at position ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" record length ");
      localStringBuilder.append(paramInt2);
      localc.a(localStringBuilder.toString());
      throw localArrayIndexOutOfBoundsException;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\d\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */