package com.tencent.smtt.sdk;

import java.io.File;
import java.io.FileFilter;

final class bb
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".dex") ^ true;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\bb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */