package c.a;

public class w
{
  public static double a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = ag.a(paramArrayOfByte[paramInt], paramArrayOfByte[(paramInt + 1)], paramArrayOfByte[(paramInt + 2)], paramArrayOfByte[(paramInt + 3)]);
    int j = ag.a(paramArrayOfByte[(paramInt + 4)], paramArrayOfByte[(paramInt + 5)], paramArrayOfByte[(paramInt + 6)], paramArrayOfByte[(paramInt + 7)]);
    if ((0x80000000 & j) != 0) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    long l2 = j & 0x7FFFFFFF;
    long l1;
    if (i < 0) {
      l1 = i + 4294967296L;
    } else {
      l1 = i;
    }
    double d2 = Double.longBitsToDouble(l2 * 4294967296L + l1);
    double d1 = d2;
    if (paramInt != 0) {
      d1 = -d2;
    }
    return d1;
  }
  
  public static void a(double paramDouble, byte[] paramArrayOfByte, int paramInt)
  {
    long l = Double.doubleToLongBits(paramDouble);
    paramArrayOfByte[paramInt] = ((byte)(int)(0xFF & l));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(int)((0xFF00 & l) >> 8));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(int)((0xFF0000 & l) >> 16));
    paramArrayOfByte[(paramInt + 3)] = ((byte)(int)((0xFFFFFFFFFF000000 & l) >> 24));
    paramArrayOfByte[(paramInt + 4)] = ((byte)(int)((0xFF00000000 & l) >> 32));
    paramArrayOfByte[(paramInt + 5)] = ((byte)(int)((0xFF0000000000 & l) >> 40));
    paramArrayOfByte[(paramInt + 6)] = ((byte)(int)((0xFF000000000000 & l) >> 48));
    paramArrayOfByte[(paramInt + 7)] = ((byte)(int)((l & 0xFF00000000000000) >> 56));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\c\a\w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */