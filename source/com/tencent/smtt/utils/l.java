package com.tencent.smtt.utils;

import java.io.InputStream;
import java.util.zip.ZipEntry;

final class l
  implements k.b
{
  l(String paramString) {}
  
  public boolean a(InputStream paramInputStream, ZipEntry paramZipEntry, String paramString)
  {
    try
    {
      boolean bool = k.a(paramInputStream, paramZipEntry, this.a, paramString);
      return bool;
    }
    catch (Exception paramInputStream)
    {
      throw new Exception("copyFileIfChanged Exception", paramInputStream);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\utils\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */