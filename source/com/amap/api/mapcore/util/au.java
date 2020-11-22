package com.amap.api.mapcore.util;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

class au
{
  RandomAccessFile a;
  
  public au()
    throws IOException
  {
    this("", 0L);
  }
  
  public au(String paramString, long paramLong)
    throws IOException
  {
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      if (!localFile.getParentFile().exists()) {
        localFile.getParentFile().mkdirs();
      }
      try
      {
        if (!localFile.exists()) {
          localFile.createNewFile();
        }
      }
      catch (IOException localIOException)
      {
        gk.c(localIOException, "FileAccessI", "create");
        localIOException.printStackTrace();
      }
    }
    this.a = new RandomAccessFile(paramString, "rw");
    this.a.seek(paramLong);
  }
  
  public int a(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      this.a.write(paramArrayOfByte);
      int i = paramArrayOfByte.length;
      return i;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
  
  public void a()
  {
    if (this.a != null)
    {
      try
      {
        this.a.close();
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
      this.a = null;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\amap\api\mapcore\util\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */