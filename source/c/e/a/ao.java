package c.e.a;

import c.a.ag;
import c.a.am;
import c.a.aq;
import c.b.c;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public class ao
  extends aq
{
  private static c a = c.a(ao.class);
  private static final a m = new a(null);
  private static final a n = new a(null);
  private static final a o = new a(null);
  private static final a p = new a(null);
  private static final a q = new a(null);
  private int b;
  private int c;
  private int d;
  private int e;
  private URL f;
  private File g;
  private String h;
  private String i;
  private a j;
  private byte[] k;
  private boolean l;
  
  private String a(String paramString)
  {
    int i1 = paramString.indexOf('.');
    Object localObject1;
    if (i1 == -1)
    {
      localObject1 = "";
    }
    else
    {
      localObject2 = paramString.substring(0, i1);
      localObject1 = paramString.substring(i1 + 1);
      paramString = (String)localObject2;
    }
    Object localObject2 = paramString;
    if (paramString.length() > 8)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString.substring(0, 6));
      ((StringBuilder)localObject2).append("~");
      ((StringBuilder)localObject2).append(paramString.length() - 8);
      localObject2 = ((StringBuilder)localObject2).toString().substring(0, 8);
    }
    paramString = ((String)localObject1).substring(0, Math.min(3, ((String)localObject1).length()));
    if (paramString.length() > 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append('.');
      ((StringBuilder)localObject1).append(paramString);
      return ((StringBuilder)localObject1).toString();
    }
    return (String)localObject2;
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    String str = this.f.toString();
    int i2 = paramArrayOfByte.length + 20 + (str.length() + 1) * 2;
    int i1 = i2;
    if (this.i != null) {
      i1 = i2 + ((this.i.length() + 1) * 2 + 4);
    }
    byte[] arrayOfByte = new byte[i1];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    i2 = paramArrayOfByte.length;
    i1 = i2;
    if (this.i != null)
    {
      ag.b(this.i.length() + 1, arrayOfByte, i2);
      am.b(this.i, arrayOfByte, i2 + 4);
      i1 = i2 + ((this.i.length() + 1) * 2 + 4);
    }
    arrayOfByte[i1] = -32;
    arrayOfByte[(i1 + 1)] = -55;
    arrayOfByte[(i1 + 2)] = -22;
    arrayOfByte[(i1 + 3)] = 121;
    arrayOfByte[(i1 + 4)] = -7;
    arrayOfByte[(i1 + 5)] = -70;
    arrayOfByte[(i1 + 6)] = -50;
    arrayOfByte[(i1 + 7)] = 17;
    arrayOfByte[(i1 + 8)] = -116;
    arrayOfByte[(i1 + 9)] = -126;
    arrayOfByte[(i1 + 10)] = 0;
    arrayOfByte[(i1 + 11)] = -86;
    arrayOfByte[(i1 + 12)] = 0;
    arrayOfByte[(i1 + 13)] = 75;
    arrayOfByte[(i1 + 14)] = -87;
    arrayOfByte[(i1 + 15)] = 11;
    ag.b((str.length() + 1) * 2, arrayOfByte, i1 + 16);
    am.b(str, arrayOfByte, i1 + 20);
    return arrayOfByte;
  }
  
  private byte[] b(byte[] paramArrayOfByte)
  {
    String str = this.g.getPath();
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + str.length() * 2 + 2 + 4];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    int i1 = paramArrayOfByte.length;
    ag.b(str.length() + 1, arrayOfByte, i1);
    am.b(str, arrayOfByte, i1 + 4);
    return arrayOfByte;
  }
  
  private byte[] c(byte[] paramArrayOfByte)
  {
    Object localObject2 = new ArrayList();
    Object localObject3 = new ArrayList();
    ((ArrayList)localObject2).add(this.g.getName());
    ((ArrayList)localObject3).add(a(this.g.getName()));
    for (Object localObject1 = this.g.getParentFile(); localObject1 != null; localObject1 = ((File)localObject1).getParentFile())
    {
      ((ArrayList)localObject2).add(((File)localObject1).getName());
      ((ArrayList)localObject3).add(a(((File)localObject1).getName()));
    }
    int i2 = ((ArrayList)localObject2).size() - 1;
    int i3 = 1;
    int i1 = 0;
    while (i3 != 0)
    {
      if (((String)((ArrayList)localObject2).get(i2)).equals(".."))
      {
        i1 += 1;
        ((ArrayList)localObject2).remove(i2);
        ((ArrayList)localObject3).remove(i2);
      }
      else
      {
        i3 = 0;
      }
      i2 -= 1;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localObject1 = new StringBuffer();
    if (this.g.getPath().charAt(1) == ':')
    {
      char c1 = this.g.getPath().charAt(0);
      if ((c1 != 'C') && (c1 != 'c'))
      {
        localStringBuffer.append(c1);
        localStringBuffer.append(':');
        ((StringBuffer)localObject1).append(c1);
        ((StringBuffer)localObject1).append(':');
      }
    }
    i2 = ((ArrayList)localObject2).size() - 1;
    while (i2 >= 0)
    {
      localStringBuffer.append((String)((ArrayList)localObject2).get(i2));
      ((StringBuffer)localObject1).append((String)((ArrayList)localObject3).get(i2));
      if (i2 != 0)
      {
        localStringBuffer.append("\\");
        ((StringBuffer)localObject1).append("\\");
      }
      i2 -= 1;
    }
    localObject2 = localStringBuffer.toString();
    localObject1 = ((StringBuffer)localObject1).toString();
    i3 = paramArrayOfByte.length + 4 + (((String)localObject1).length() + 1) + 16 + 2 + 8 + (((String)localObject2).length() + 1) * 2 + 24;
    i2 = i3;
    if (this.i != null) {
      i2 = i3 + ((this.i.length() + 1) * 2 + 4);
    }
    localObject3 = new byte[i2];
    System.arraycopy(paramArrayOfByte, 0, localObject3, 0, paramArrayOfByte.length);
    i3 = paramArrayOfByte.length;
    i2 = i3;
    if (this.i != null)
    {
      ag.b(this.i.length() + 1, (byte[])localObject3, i3);
      am.b(this.i, (byte[])localObject3, i3 + 4);
      i2 = i3 + ((this.i.length() + 1) * 2 + 4);
    }
    localObject3[i2] = 3;
    localObject3[(i2 + 1)] = 3;
    localObject3[(i2 + 2)] = 0;
    localObject3[(i2 + 3)] = 0;
    localObject3[(i2 + 4)] = 0;
    localObject3[(i2 + 5)] = 0;
    localObject3[(i2 + 6)] = 0;
    localObject3[(i2 + 7)] = 0;
    localObject3[(i2 + 8)] = -64;
    localObject3[(i2 + 9)] = 0;
    localObject3[(i2 + 10)] = 0;
    localObject3[(i2 + 11)] = 0;
    localObject3[(i2 + 12)] = 0;
    localObject3[(i2 + 13)] = 0;
    localObject3[(i2 + 14)] = 0;
    localObject3[(i2 + 15)] = 70;
    i2 += 16;
    ag.a(i1, (byte[])localObject3, i2);
    i1 = i2 + 2;
    ag.b(((String)localObject1).length() + 1, (byte[])localObject3, i1);
    am.a((String)localObject1, (byte[])localObject3, i1 + 4);
    i1 += ((String)localObject1).length() + 1 + 4;
    localObject3[i1] = -1;
    localObject3[(i1 + 1)] = -1;
    localObject3[(i1 + 2)] = -83;
    localObject3[(i1 + 3)] = -34;
    localObject3[(i1 + 4)] = 0;
    localObject3[(i1 + 5)] = 0;
    localObject3[(i1 + 6)] = 0;
    localObject3[(i1 + 7)] = 0;
    localObject3[(i1 + 8)] = 0;
    localObject3[(i1 + 9)] = 0;
    localObject3[(i1 + 10)] = 0;
    localObject3[(i1 + 11)] = 0;
    localObject3[(i1 + 12)] = 0;
    localObject3[(i1 + 13)] = 0;
    localObject3[(i1 + 14)] = 0;
    localObject3[(i1 + 15)] = 0;
    localObject3[(i1 + 16)] = 0;
    localObject3[(i1 + 17)] = 0;
    localObject3[(i1 + 18)] = 0;
    localObject3[(i1 + 19)] = 0;
    localObject3[(i1 + 20)] = 0;
    localObject3[(i1 + 21)] = 0;
    localObject3[(i1 + 22)] = 0;
    localObject3[(i1 + 23)] = 0;
    i1 += 24;
    ag.b(((String)localObject2).length() * 2 + 6, (byte[])localObject3, i1);
    i1 += 4;
    ag.b(((String)localObject2).length() * 2, (byte[])localObject3, i1);
    i1 += 4;
    localObject3[i1] = 3;
    localObject3[(i1 + 1)] = 0;
    am.b((String)localObject2, (byte[])localObject3, i1 + 2);
    ((String)localObject2).length();
    return (byte[])localObject3;
  }
  
  private byte[] d(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + 4 + (this.h.length() + 1) * 2];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
    int i1 = paramArrayOfByte.length;
    ag.b(this.h.length() + 1, arrayOfByte, i1);
    am.b(this.h, arrayOfByte, i1 + 4);
    return arrayOfByte;
  }
  
  public byte[] a()
  {
    if (!this.l) {
      return this.k;
    }
    byte[] arrayOfByte = new byte[32];
    int i2 = this.b;
    int i1 = 0;
    ag.a(i2, arrayOfByte, 0);
    ag.a(this.c, arrayOfByte, 2);
    ag.a(this.d, arrayOfByte, 4);
    ag.a(this.e, arrayOfByte, 6);
    arrayOfByte[8] = -48;
    arrayOfByte[9] = -55;
    arrayOfByte[10] = -22;
    arrayOfByte[11] = 121;
    arrayOfByte[12] = -7;
    arrayOfByte[13] = -70;
    arrayOfByte[14] = -50;
    arrayOfByte[15] = 17;
    arrayOfByte[16] = -116;
    arrayOfByte[17] = -126;
    arrayOfByte[18] = 0;
    arrayOfByte[19] = -86;
    arrayOfByte[20] = 0;
    arrayOfByte[21] = 75;
    arrayOfByte[22] = -87;
    arrayOfByte[23] = 11;
    arrayOfByte[24] = 2;
    arrayOfByte[25] = 0;
    arrayOfByte[26] = 0;
    arrayOfByte[27] = 0;
    if (e())
    {
      i1 = 3;
      if (this.i != null) {
        i1 = 23;
      }
    }
    else if (c())
    {
      i1 = 1;
      if (this.i != null) {
        i1 = 21;
      }
    }
    else if (f())
    {
      i1 = 8;
    }
    else if (d())
    {
      i1 = 259;
    }
    ag.b(i1, arrayOfByte, 28);
    if (e()) {
      this.k = a(arrayOfByte);
    } else if (c()) {
      this.k = c(arrayOfByte);
    } else if (f()) {
      this.k = d(arrayOfByte);
    } else if (d()) {
      this.k = b(arrayOfByte);
    }
    return this.k;
  }
  
  public boolean c()
  {
    return this.j == n;
  }
  
  public boolean d()
  {
    return this.j == o;
  }
  
  public boolean e()
  {
    return this.j == m;
  }
  
  public boolean f()
  {
    return this.j == p;
  }
  
  public String toString()
  {
    if (c()) {
      return this.g.toString();
    }
    if (e()) {
      return this.f.toString();
    }
    if (d()) {
      return this.g.toString();
    }
    return "";
  }
  
  private static class a {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\e\a\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */