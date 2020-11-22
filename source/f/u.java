package f;

import java.nio.charset.Charset;

final class u
{
  public static final Charset a = Charset.forName("UTF-8");
  
  public static int a(int paramInt)
  {
    return (paramInt & 0xFF) << 24 | (0xFF000000 & paramInt) >>> 24 | (0xFF0000 & paramInt) >>> 8 | (0xFF00 & paramInt) << 8;
  }
  
  public static short a(short paramShort)
  {
    paramShort &= 0xFFFF;
    return (short)((paramShort & 0xFF) << 8 | (0xFF00 & paramShort) >>> 8);
  }
  
  public static void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (((paramLong2 | paramLong3) >= 0L) && (paramLong2 <= paramLong1) && (paramLong1 - paramLong2 >= paramLong3)) {
      return;
    }
    throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong3) }));
  }
  
  public static void a(Throwable paramThrowable)
  {
    b(paramThrowable);
  }
  
  public static boolean a(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    int i = 0;
    while (i < paramInt3)
    {
      if (paramArrayOfByte1[(i + paramInt1)] != paramArrayOfByte2[(i + paramInt2)]) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private static <T extends Throwable> void b(Throwable paramThrowable)
    throws Throwable
  {
    throw paramThrowable;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\f\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */