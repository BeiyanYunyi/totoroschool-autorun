package com.github.barteksc.pdfviewer.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Util
{
  private static final int DEFAULT_BUFFER_SIZE = 4096;
  
  public static int getDP(Context paramContext, int paramInt)
  {
    return (int)TypedValue.applyDimension(1, paramInt, paramContext.getResources().getDisplayMetrics());
  }
  
  public static byte[] toByteArray(InputStream paramInputStream)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['က'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (-1 == i) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    return localByteArrayOutputStream.toByteArray();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\github\barteksc\pdfviewer\util\Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */