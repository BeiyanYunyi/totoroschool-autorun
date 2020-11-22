package c.a.b;

import c.b.c;
import java.util.Stack;

abstract class f
  extends ap
{
  private static final c a = c.a(f.class);
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    return 0;
  }
  
  abstract String a();
  
  public void a(StringBuffer paramStringBuffer)
  {
    as[] arrayOfas = f();
    arrayOfas[1].a(paramStringBuffer);
    paramStringBuffer.append(a());
    arrayOfas[0].a(paramStringBuffer);
  }
  
  public void a(Stack paramStack)
  {
    as localas = (as)paramStack.pop();
    paramStack = (as)paramStack.pop();
    a(localas);
    a(paramStack);
  }
  
  abstract bh b();
  
  byte[] c()
  {
    as[] arrayOfas = f();
    Object localObject = new byte[0];
    int i = arrayOfas.length - 1;
    while (i >= 0)
    {
      byte[] arrayOfByte2 = arrayOfas[i].c();
      arrayOfByte1 = new byte[localObject.length + arrayOfByte2.length];
      System.arraycopy(localObject, 0, arrayOfByte1, 0, localObject.length);
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, localObject.length, arrayOfByte2.length);
      i -= 1;
      localObject = arrayOfByte1;
    }
    byte[] arrayOfByte1 = new byte[localObject.length + 1];
    System.arraycopy(localObject, 0, arrayOfByte1, 0, localObject.length);
    arrayOfByte1[localObject.length] = b().a();
    return arrayOfByte1;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\b\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */