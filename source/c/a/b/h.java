package c.a.b;

import c.a.ag;
import c.b.a;
import c.b.c;
import c.m;
import java.util.Stack;

class h
  extends ap
{
  private static c a = c.a(h.class);
  private x b;
  private m c;
  
  public h(x paramx, m paramm)
  {
    this.b = paramx;
    this.c = paramm;
  }
  
  public h(m paramm)
  {
    this.c = paramm;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    byte b1 = paramArrayOfByte[paramInt];
    boolean bool = true;
    paramInt = ag.a(b1, paramArrayOfByte[(paramInt + 1)]);
    this.b = x.a(paramInt);
    if (this.b == x.dz) {
      bool = false;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("function code ");
    paramArrayOfByte.append(paramInt);
    a.a(bool, paramArrayOfByte.toString());
    return 2;
  }
  
  public void a(StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append(this.b.a(this.c));
    paramStringBuffer.append('(');
    int j = this.b.c();
    if (j > 0)
    {
      as[] arrayOfas = f();
      arrayOfas[0].a(paramStringBuffer);
      int i = 1;
      while (i < j)
      {
        paramStringBuffer.append(',');
        arrayOfas[i].a(paramStringBuffer);
        i += 1;
      }
    }
    paramStringBuffer.append(')');
  }
  
  public void a(Stack paramStack)
  {
    as[] arrayOfas = new as[this.b.c()];
    int i = this.b.c() - 1;
    while (i >= 0)
    {
      arrayOfas[i] = ((as)paramStack.pop());
      i -= 1;
    }
    i = 0;
    while (i < this.b.c())
    {
      a(arrayOfas[i]);
      i += 1;
    }
  }
  
  byte[] c()
  {
    as[] arrayOfas = f();
    Object localObject = new byte[0];
    int j = 0;
    while (j < arrayOfas.length)
    {
      byte[] arrayOfByte2 = arrayOfas[j].c();
      arrayOfByte1 = new byte[localObject.length + arrayOfByte2.length];
      System.arraycopy(localObject, 0, arrayOfByte1, 0, localObject.length);
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, localObject.length, arrayOfByte2.length);
      j += 1;
      localObject = arrayOfByte1;
    }
    byte[] arrayOfByte1 = new byte[localObject.length + 3];
    System.arraycopy(localObject, 0, arrayOfByte1, 0, localObject.length);
    j = localObject.length;
    int i;
    if (!j()) {
      i = bh.J.a();
    } else {
      i = bh.J.c();
    }
    arrayOfByte1[j] = i;
    ag.a(this.b.a(), arrayOfByte1, localObject.length + 1);
    return arrayOfByte1;
  }
  
  int i_()
  {
    return 3;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\b\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */