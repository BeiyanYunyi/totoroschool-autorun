package com.autonavi.base.amap.mapcore.tools;

import java.io.ByteArrayOutputStream;

public class GLConvertUtil
{
  public static double convertDouble(byte[] paramArrayOfByte, int paramInt)
  {
    long l = 0L;
    int i = 0;
    while (i < 8)
    {
      l += ((paramArrayOfByte[(i + paramInt)] & 0xFF) << i * 8);
      i += 1;
    }
    return Double.longBitsToDouble(l);
  }
  
  public static byte[] convertInt(int paramInt)
  {
    return new byte[] { (byte)(paramInt & 0xFF), (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt >> 16 & 0xFF), (byte)(paramInt >> 24 & 0xFF) };
  }
  
  public static byte[] convertShort(int paramInt)
  {
    return new byte[] { (byte)(paramInt & 0xFF), (byte)(paramInt >> 8 & 0xFF) };
  }
  
  public static byte[] get1BString(String paramString)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramString = paramString.getBytes("UTF-8");
      localByteArrayOutputStream.write(new byte[] { (byte)paramString.length });
      localByteArrayOutputStream.write(paramString);
      paramString = localByteArrayOutputStream.toByteArray();
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return new byte[1];
  }
  
  public static int getInt(byte[] paramArrayOfByte, int paramInt)
  {
    return ((paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24) + ((paramArrayOfByte[(paramInt + 2)] & 0xFF) << 16) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8) + ((paramArrayOfByte[(paramInt + 0)] & 0xFF) << 0);
  }
  
  public static int getInt2(byte[] paramArrayOfByte, int paramInt)
  {
    return ((paramArrayOfByte[(paramInt + 0)] & 0xFF) << 24) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 16) + ((paramArrayOfByte[(paramInt + 2)] & 0xFF) << 8) + ((paramArrayOfByte[(paramInt + 3)] & 0xFF) << 0);
  }
  
  public static long getLong(byte[] paramArrayOfByte, int paramInt)
  {
    return ((paramArrayOfByte[(paramInt + 7)] & 0xFF) << 56) + ((paramArrayOfByte[(paramInt + 6)] & 0xFF) << 48) + ((paramArrayOfByte[(paramInt + 5)] & 0xFF) << 40) + ((paramArrayOfByte[(paramInt + 4)] & 0xFF) << 32) + ((paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24) + ((paramArrayOfByte[(paramInt + 2)] & 0xFF) << 16) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8) + ((paramArrayOfByte[(paramInt + 0)] & 0xFF) << 0);
  }
  
  public static short getShort(byte[] paramArrayOfByte, int paramInt)
  {
    return (short)(((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8) + ((paramArrayOfByte[(paramInt + 0)] & 0xFF) << 0));
  }
  
  public static short getShort2(byte[] paramArrayOfByte, int paramInt)
  {
    return (short)(((paramArrayOfByte[(paramInt + 0)] & 0xFF) << 8) + ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 0));
  }
  
  public static String getString(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, paramInt1, paramInt2, "UTF-8");
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;) {}
    }
    return "";
  }
  
  public static byte[] getSubBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
  
  public static int getUShort(byte[] paramArrayOfByte, int paramInt)
  {
    return ((paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8) + ((paramArrayOfByte[(paramInt + 0)] & 0xFF) << 0);
  }
  
  public static void moveArray(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    byte[] arrayOfByte = new byte[paramInt3];
    System.arraycopy(paramArrayOfByte1, paramInt1, arrayOfByte, 0, paramInt3);
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte2, paramInt2, paramInt3);
  }
  
  public static void writeInt(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    System.arraycopy(convertInt(paramInt2), 0, paramArrayOfByte, paramInt1, 4);
  }
  
  public static void writeShort(byte[] paramArrayOfByte, int paramInt, short paramShort)
  {
    System.arraycopy(convertShort(paramShort), 0, paramArrayOfByte, paramInt, 2);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\autonavi\base\amap\mapcore\tools\GLConvertUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */