package com.loc;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class bx
  extends cd
{
  ByteArrayOutputStream a = new ByteArrayOutputStream();
  
  public bx() {}
  
  public bx(cd paramcd)
  {
    super(paramcd);
  }
  
  protected final byte[] a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = this.a.toByteArray();
    try
    {
      this.a.close();
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    this.a = new ByteArrayOutputStream();
    return paramArrayOfByte;
  }
  
  public final void b(byte[] paramArrayOfByte)
  {
    try
    {
      this.a.write(paramArrayOfByte);
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */