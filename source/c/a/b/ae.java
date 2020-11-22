package c.a.b;

import c.a.ag;

class ae
  extends bf
{
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    a(ag.a(paramArrayOfByte[(paramInt + 4)], paramArrayOfByte[(paramInt + 5)]));
    return 6;
  }
  
  public void a(StringBuffer paramStringBuffer)
  {
    as[] arrayOfas = b();
    if (arrayOfas.length == 1)
    {
      arrayOfas[0].a(paramStringBuffer);
      return;
    }
    if (arrayOfas.length == 2)
    {
      arrayOfas[1].a(paramStringBuffer);
      paramStringBuffer.append(':');
      arrayOfas[0].a(paramStringBuffer);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\b\ae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */