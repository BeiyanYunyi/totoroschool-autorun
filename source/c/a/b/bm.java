package c.a.b;

import c.a.ag;
import c.b.c;
import c.m;
import java.util.Stack;

class bm
  extends ap
{
  private static c a = c.a(bm.class);
  private x b;
  private int c;
  private boolean d;
  private m e;
  
  public bm(x paramx, int paramInt, m paramm)
  {
    this.b = paramx;
    this.c = paramInt;
    this.d = false;
    this.e = paramm;
  }
  
  public bm(m paramm)
  {
    this.d = true;
    this.e = paramm;
  }
  
  private void b()
  {
    if (this.b == x.bO)
    {
      as[] arrayOfas = f();
      int i = arrayOfas.length - 1;
      while (i >= 0)
      {
        if ((arrayOfas[i] instanceof b)) {
          arrayOfas[i].i();
        }
        i -= 1;
      }
    }
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
    throws v
  {
    this.c = paramArrayOfByte[paramInt];
    paramInt = ag.a(paramArrayOfByte[(paramInt + 1)], paramArrayOfByte[(paramInt + 2)]);
    this.b = x.a(paramInt);
    if (this.b != x.dz) {
      return 3;
    }
    throw new v(v.UNRECOGNIZED_FUNCTION, paramInt);
  }
  
  x a()
  {
    return this.b;
  }
  
  public void a(StringBuffer paramStringBuffer)
  {
    paramStringBuffer.append(this.b.a(this.e));
    paramStringBuffer.append('(');
    if (this.c > 0)
    {
      as[] arrayOfas = f();
      boolean bool = this.d;
      int i = 1;
      if (bool)
      {
        arrayOfas[0].a(paramStringBuffer);
        while (i < this.c)
        {
          paramStringBuffer.append(',');
          arrayOfas[i].a(paramStringBuffer);
          i += 1;
        }
      }
      arrayOfas[(this.c - 1)].a(paramStringBuffer);
      i = this.c - 2;
      while (i >= 0)
      {
        paramStringBuffer.append(',');
        arrayOfas[i].a(paramStringBuffer);
        i -= 1;
      }
    }
    paramStringBuffer.append(')');
  }
  
  public void a(Stack paramStack)
  {
    as[] arrayOfas = new as[this.c];
    int i = this.c - 1;
    while (i >= 0)
    {
      arrayOfas[i] = ((as)paramStack.pop());
      i -= 1;
    }
    i = 0;
    while (i < this.c)
    {
      a(arrayOfas[i]);
      i += 1;
    }
  }
  
  byte[] c()
  {
    b();
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
    byte[] arrayOfByte1 = new byte[localObject.length + 4];
    System.arraycopy(localObject, 0, arrayOfByte1, 0, localObject.length);
    j = localObject.length;
    int i;
    if (!j()) {
      i = bh.K.a();
    } else {
      i = bh.K.c();
    }
    arrayOfByte1[j] = i;
    arrayOfByte1[(localObject.length + 1)] = ((byte)this.c);
    ag.a(this.b.a(), arrayOfByte1, localObject.length + 2);
    return arrayOfByte1;
  }
  
  int i_()
  {
    return 3;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\b\bm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */