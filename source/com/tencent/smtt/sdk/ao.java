package com.tencent.smtt.sdk;

import android.os.Build.VERSION;
import java.io.File;
import java.io.FileFilter;

final class ao
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    paramFile = paramFile.getName();
    if (paramFile == null) {
      return false;
    }
    if (paramFile.endsWith(".jar_is_first_load_dex_flag_file")) {
      return false;
    }
    return (Build.VERSION.SDK_INT < 21) || (!paramFile.endsWith(".dex"));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\sdk\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */