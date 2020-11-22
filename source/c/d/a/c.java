package c.d.a;

import c.a.e;
import c.a.e.a;
import java.util.ArrayList;

public final class c
  extends e
{
  private static c.b.c c = c.b.c.a(c.class);
  private byte[] d;
  private int[] e;
  private int[] f;
  private ArrayList g;
  private e.a h;
  
  private e.a a(String paramString, e.a parama)
  {
    if (parama.h == -1) {
      return null;
    }
    parama = c(parama.h);
    if (parama.a.equalsIgnoreCase(paramString)) {
      return parama;
    }
    Object localObject = parama;
    e.a locala;
    while (((e.a)localObject).f != -1)
    {
      locala = c(((e.a)localObject).f);
      localObject = locala;
      if (locala.a.equalsIgnoreCase(paramString)) {
        return locala;
      }
    }
    localObject = parama;
    while (((e.a)localObject).g != -1)
    {
      locala = c(((e.a)localObject).g);
      localObject = locala;
      if (locala.a.equalsIgnoreCase(paramString)) {
        return locala;
      }
    }
    return a(paramString, parama);
  }
  
  private byte[] a(e.a parama)
  {
    int j = parama.e / 512;
    int i = j;
    if (parama.e % 512 != 0) {
      i = j + 1;
    }
    byte[] arrayOfByte = new byte[i * 512];
    j = parama.d;
    int k = 0;
    while ((j != -2) && (k < i))
    {
      System.arraycopy(this.d, (j + 1) * 512, arrayOfByte, k * 512, 512);
      k += 1;
      j = this.e[j];
    }
    if ((j != -2) && (k == i)) {
      c.b("Property storage size inconsistent with block chain.");
    }
    return arrayOfByte;
  }
  
  private byte[] b(e.a parama)
    throws b
  {
    byte[] arrayOfByte2 = d(this.h.d);
    int i = parama.d;
    Object localObject = new byte[0];
    int j = 0;
    while ((j <= this.f.length) && (i != -2))
    {
      byte[] arrayOfByte1 = new byte[localObject.length + 64];
      System.arraycopy(localObject, 0, arrayOfByte1, 0, localObject.length);
      System.arraycopy(arrayOfByte2, i * 64, arrayOfByte1, localObject.length, 64);
      int k = this.f[i];
      i = k;
      if (k == -1)
      {
        localObject = c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Incorrect terminator for small block stream ");
        localStringBuilder.append(parama.a);
        ((c.b.c)localObject).b(localStringBuilder.toString());
        i = -2;
      }
      j += 1;
      localObject = arrayOfByte1;
    }
    if (j <= this.f.length) {
      return (byte[])localObject;
    }
    throw new b(b.corruptFileFormat);
  }
  
  private e.a c(int paramInt)
  {
    return (e.a)this.g.get(paramInt);
  }
  
  private byte[] d(int paramInt)
    throws b
  {
    Object localObject = new byte[0];
    int i = paramInt;
    paramInt = 0;
    while ((paramInt <= this.e.length) && (i != -2))
    {
      byte[] arrayOfByte = new byte[localObject.length + 512];
      System.arraycopy(localObject, 0, arrayOfByte, 0, localObject.length);
      System.arraycopy(this.d, (i + 1) * 512, arrayOfByte, localObject.length, 512);
      if (this.e[i] != i)
      {
        i = this.e[i];
        paramInt += 1;
        localObject = arrayOfByte;
      }
      else
      {
        throw new b(b.corruptFileFormat);
      }
    }
    if (paramInt <= this.e.length) {
      return (byte[])localObject;
    }
    throw new b(b.corruptFileFormat);
  }
  
  public int a()
  {
    return this.g.size();
  }
  
  public e.a a(String paramString)
  {
    return a(paramString, this.h);
  }
  
  public byte[] a(int paramInt)
    throws b
  {
    e.a locala = c(paramInt);
    if ((locala.e < 4096) && (!locala.a.equalsIgnoreCase("Root Entry"))) {
      return b(locala);
    }
    return a(locala);
  }
  
  public e.a b(int paramInt)
  {
    return c(paramInt);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\d\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */