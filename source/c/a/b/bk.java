package c.a.b;

import java.util.Stack;

abstract class bk
  extends ap
{
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    return 0;
  }
  
  abstract String a();
  
  public void a(StringBuffer paramStringBuffer)
  {
    as[] arrayOfas = f();
    paramStringBuffer.append(a());
    arrayOfas[0].a(paramStringBuffer);
  }
  
  public void a(Stack paramStack)
  {
    a((as)paramStack.pop());
  }
  
  abstract bh b();
  
  byte[] c()
  {
    byte[] arrayOfByte1 = f()[0].c();
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 1];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    arrayOfByte2[arrayOfByte1.length] = b().a();
    return arrayOfByte2;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\b\bk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */