package com.loc;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public final class bh
{
  public static final Charset a = Charset.forName("US-ASCII");
  static final Charset b = Charset.forName("UTF-8");
  
  static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (RuntimeException paramCloseable)
    {
      throw paramCloseable;
      return;
    }
    catch (Exception paramCloseable) {}
  }
  
  static void a(File paramFile)
    throws IOException
  {
    Object localObject = paramFile.listFiles();
    if (localObject != null)
    {
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        paramFile = localObject[i];
        if (paramFile.isDirectory()) {
          a(paramFile);
        }
        if (paramFile.delete())
        {
          i += 1;
        }
        else
        {
          localObject = new StringBuilder("failed to delete file: ");
          ((StringBuilder)localObject).append(paramFile);
          throw new IOException(((StringBuilder)localObject).toString());
        }
      }
      return;
    }
    localObject = new StringBuilder("not a readable directory: ");
    ((StringBuilder)localObject).append(paramFile);
    throw new IOException(((StringBuilder)localObject).toString());
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\loc\bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */