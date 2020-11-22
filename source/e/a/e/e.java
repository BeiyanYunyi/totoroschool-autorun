package e.a.e;

import e.a.c;
import f.f;
import java.io.IOException;

public final class e
{
  static final f a = f.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
  static final String[] b;
  static final String[] c;
  private static final String[] d = { "DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION" };
  
  static
  {
    b = new String[64];
    c = new String['Ā'];
    int k = 0;
    int i = 0;
    while (i < c.length)
    {
      c[i] = c.a("%8s", new Object[] { Integer.toBinaryString(i) }).replace(' ', '0');
      i += 1;
    }
    b[0] = "";
    b[1] = "END_STREAM";
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = 1;
    b[8] = "PADDED";
    int j = arrayOfInt.length;
    i = 0;
    Object localObject2;
    while (i < j)
    {
      m = arrayOfInt[i];
      localObject1 = b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(b[m]);
      ((StringBuilder)localObject2).append("|PADDED");
      localObject1[(m | 0x8)] = ((StringBuilder)localObject2).toString();
      i += 1;
    }
    b[4] = "END_HEADERS";
    b[32] = "PRIORITY";
    b[36] = "END_HEADERS|PRIORITY";
    Object localObject1 = new int[3];
    Object tmp264_262 = localObject1;
    tmp264_262[0] = 4;
    Object tmp268_264 = tmp264_262;
    tmp268_264[1] = 32;
    Object tmp273_268 = tmp268_264;
    tmp273_268[2] = 36;
    tmp273_268;
    int m = localObject1.length;
    i = 0;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      int n = localObject1[i];
      int i1 = arrayOfInt.length;
      j = 0;
      while (j < i1)
      {
        int i2 = arrayOfInt[j];
        localObject2 = b;
        int i3 = i2 | n;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(b[i2]);
        localStringBuilder.append('|');
        localStringBuilder.append(b[n]);
        localObject2[i3] = localStringBuilder.toString();
        localObject2 = b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(b[i2]);
        localStringBuilder.append('|');
        localStringBuilder.append(b[n]);
        localStringBuilder.append("|PADDED");
        localObject2[(i3 | 0x8)] = localStringBuilder.toString();
        j += 1;
      }
      i += 1;
    }
    while (j < b.length)
    {
      if (b[j] == null) {
        b[j] = c[j];
      }
      j += 1;
    }
  }
  
  static IllegalArgumentException a(String paramString, Object... paramVarArgs)
  {
    throw new IllegalArgumentException(c.a(paramString, paramVarArgs));
  }
  
  static String a(byte paramByte1, byte paramByte2)
  {
    if (paramByte2 == 0) {
      return "";
    }
    switch (paramByte1)
    {
    case 5: 
    default: 
      if (paramByte2 < b.length) {
        str = b[paramByte2];
      }
      break;
    case 4: 
    case 6: 
      if (paramByte2 == 1) {
        return "ACK";
      }
      return c[paramByte2];
    case 2: 
    case 3: 
    case 7: 
    case 8: 
      return c[paramByte2];
    }
    String str = c[paramByte2];
    if ((paramByte1 == 5) && ((paramByte2 & 0x4) != 0)) {
      return str.replace("HEADERS", "PUSH_PROMISE");
    }
    if ((paramByte1 == 0) && ((paramByte2 & 0x20) != 0)) {
      return str.replace("PRIORITY", "COMPRESSED");
    }
    return str;
  }
  
  static String a(boolean paramBoolean, int paramInt1, int paramInt2, byte paramByte1, byte paramByte2)
  {
    String str1;
    if (paramByte1 < d.length) {
      str1 = d[paramByte1];
    } else {
      str1 = c.a("0x%02x", new Object[] { Byte.valueOf(paramByte1) });
    }
    String str3 = a(paramByte1, paramByte2);
    String str2;
    if (paramBoolean) {
      str2 = "<<";
    } else {
      str2 = ">>";
    }
    return c.a("%s 0x%08x %5d %-13s %s", new Object[] { str2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), str1, str3 });
  }
  
  static IOException b(String paramString, Object... paramVarArgs)
    throws IOException
  {
    throw new IOException(c.a(paramString, paramVarArgs));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\a\e\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */