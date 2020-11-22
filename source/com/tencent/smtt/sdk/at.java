package com.tencent.smtt.sdk;

import java.io.File;
import java.io.FileFilter;

class at
  implements FileFilter
{
  at(am paramam) {}
  
  public boolean accept(File paramFile)
  {
    return (!paramFile.getName().endsWith(".dex")) && (!paramFile.getName().endsWith(".jar_is_first_load_dex_flag_file"));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\at.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */