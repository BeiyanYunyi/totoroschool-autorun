package c.a.b;

import c.a.ag;
import c.b.c;
import c.m;
import java.util.Stack;

class e
  extends ap
{
  private static c a = c.a(e.class);
  private int b;
  private int c;
  private m d;
  private bm e;
  
  public e(bb parambb, m paramm)
  {
    this.d = paramm;
    if (parambb.a(this.d) == x.e)
    {
      this.b |= 0x10;
      return;
    }
    if (parambb.a(this.d) == x.dy) {
      this.b |= 0x2;
    }
  }
  
  public e(m paramm)
  {
    this.d = paramm;
  }
  
  private byte[] l()
  {
    Object localObject = this.e.f();
    int i = localObject.length;
    byte[] arrayOfByte2 = localObject[0].c();
    int j = arrayOfByte2.length;
    byte[] arrayOfByte1 = new byte[arrayOfByte2.length + 4];
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, arrayOfByte2.length);
    arrayOfByte1[j] = bh.L.a();
    arrayOfByte1[(j + 1)] = 2;
    j += 2;
    arrayOfByte2 = localObject[1].c();
    byte[] arrayOfByte3 = new byte[arrayOfByte1.length + arrayOfByte2.length];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte3, 0, arrayOfByte1.length);
    System.arraycopy(arrayOfByte2, 0, arrayOfByte3, arrayOfByte1.length, arrayOfByte2.length);
    int k = arrayOfByte3.length;
    arrayOfByte2 = new byte[arrayOfByte3.length + 4];
    System.arraycopy(arrayOfByte3, 0, arrayOfByte2, 0, arrayOfByte3.length);
    arrayOfByte2[k] = bh.L.a();
    arrayOfByte2[(k + 1)] = 8;
    k += 2;
    arrayOfByte1 = arrayOfByte2;
    if (i > 2)
    {
      ag.a(arrayOfByte2.length - j - 2, arrayOfByte2, j);
      arrayOfByte1 = localObject[(i - 1)].c();
      localObject = new byte[arrayOfByte2.length + arrayOfByte1.length];
      System.arraycopy(arrayOfByte2, 0, localObject, 0, arrayOfByte2.length);
      System.arraycopy(arrayOfByte1, 0, localObject, arrayOfByte2.length, arrayOfByte1.length);
      m = localObject.length;
      arrayOfByte1 = new byte[localObject.length + 4];
      System.arraycopy(localObject, 0, arrayOfByte1, 0, localObject.length);
      arrayOfByte1[m] = bh.L.a();
      arrayOfByte1[(m + 1)] = 8;
      arrayOfByte1[(m + 2)] = 3;
    }
    int m = arrayOfByte1.length;
    arrayOfByte2 = new byte[arrayOfByte1.length + 4];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    arrayOfByte2[m] = bh.K.a();
    arrayOfByte2[(m + 1)] = ((byte)i);
    arrayOfByte2[(m + 2)] = 1;
    arrayOfByte2[(m + 3)] = 0;
    m = arrayOfByte2.length - 1;
    if (i < 3) {
      ag.a(m - j - 5, arrayOfByte2, j);
    }
    ag.a(m - k - 2, arrayOfByte2, k);
    return arrayOfByte2;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    this.b = paramArrayOfByte[paramInt];
    this.c = ag.a(paramArrayOfByte[(paramInt + 1)], paramArrayOfByte[(paramInt + 2)]);
    if (!d()) {
      return 3;
    }
    return (this.c + 1) * 2 + 3;
  }
  
  void a(bm parambm)
  {
    this.e = parambm;
    this.b |= 0x2;
  }
  
  public void a(StringBuffer paramStringBuffer)
  {
    int j = this.b;
    int i = 0;
    as[] arrayOfas;
    if ((j & 0x10) != 0)
    {
      arrayOfas = f();
      paramStringBuffer.append(x.e.a(this.d));
      paramStringBuffer.append('(');
      arrayOfas[0].a(paramStringBuffer);
      paramStringBuffer.append(')');
      return;
    }
    if ((this.b & 0x2) != 0)
    {
      paramStringBuffer.append(x.dy.a(this.d));
      paramStringBuffer.append('(');
      arrayOfas = this.e.f();
      while (i < arrayOfas.length - 1)
      {
        arrayOfas[i].a(paramStringBuffer);
        paramStringBuffer.append(',');
        i += 1;
      }
      arrayOfas[(arrayOfas.length - 1)].a(paramStringBuffer);
      paramStringBuffer.append(')');
    }
  }
  
  public void a(Stack paramStack)
  {
    if ((this.b & 0x10) != 0)
    {
      a((as)paramStack.pop());
      return;
    }
    if ((this.b & 0x2) != 0) {
      a((as)paramStack.pop());
    }
  }
  
  public boolean a()
  {
    return (this.b & 0x10) != 0;
  }
  
  public boolean b()
  {
    return (this.b & 0x2) != 0;
  }
  
  byte[] c()
  {
    Object localObject = new byte[0];
    if (a())
    {
      as[] arrayOfas = f();
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
      byte[] arrayOfByte1 = new byte[localObject.length + 4];
      System.arraycopy(localObject, 0, arrayOfByte1, 0, localObject.length);
      arrayOfByte1[localObject.length] = bh.L.a();
      arrayOfByte1[(localObject.length + 1)] = 16;
      return arrayOfByte1;
    }
    if (b()) {
      return l();
    }
    return (byte[])localObject;
  }
  
  public boolean d()
  {
    return (this.b & 0x4) != 0;
  }
  
  int i_()
  {
    return 3;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */