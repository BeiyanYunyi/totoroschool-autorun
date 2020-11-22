package c.a.b;

import java.util.Stack;

class aq
  extends ap
{
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    return 0;
  }
  
  bh a()
  {
    return bh.u;
  }
  
  public void a(StringBuffer paramStringBuffer)
  {
    as[] arrayOfas = f();
    paramStringBuffer.append('(');
    arrayOfas[0].a(paramStringBuffer);
    paramStringBuffer.append(')');
  }
  
  public void a(Stack paramStack)
  {
    a((as)paramStack.pop());
  }
  
  byte[] c()
  {
    byte[] arrayOfByte1 = f()[0].c();
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 1];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    arrayOfByte2[arrayOfByte1.length] = a().a();
    return arrayOfByte2;
  }
  
  int i_()
  {
    return 4;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\b\aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */