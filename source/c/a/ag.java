package c.a;

public final class ag
{
  public static int a(byte paramByte1, byte paramByte2)
  {
    return paramByte1 & 0xFF | (paramByte2 & 0xFF) << 8;
  }
  
  public static int a(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4)
  {
    return a(paramByte1, paramByte2) | a(paramByte3, paramByte4) << 16;
  }
  
  public static void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 & 0xFF));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)((paramInt1 & 0xFF00) >> 8));
  }
  
  public static byte[] a(int paramInt)
  {
    byte[] arrayOfByte = new byte[4];
    a(0xFFFF & paramInt, arrayOfByte, 0);
    a((paramInt & 0xFFFF0000) >> 16, arrayOfByte, 2);
    return arrayOfByte;
  }
  
  public static short b(byte paramByte1, byte paramByte2)
  {
    return (short)((short)(paramByte1 & 0xFF) | (short)(paramByte2 & 0xFF) << 8);
  }
  
  public static void b(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    byte[] arrayOfByte = a(paramInt1);
    paramArrayOfByte[paramInt2] = arrayOfByte[0];
    paramArrayOfByte[(paramInt2 + 1)] = arrayOfByte[1];
    paramArrayOfByte[(paramInt2 + 2)] = arrayOfByte[2];
    paramArrayOfByte[(paramInt2 + 3)] = arrayOfByte[3];
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */