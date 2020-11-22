package com.tencent.smtt.utils;

import java.io.File;

final class m
  implements k.a
{
  public boolean a(File paramFile1, File paramFile2)
  {
    return (paramFile1.length() == paramFile2.length()) && (paramFile1.lastModified() == paramFile2.lastModified());
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\utils\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */