package com.tencent.smtt.utils;

import android.text.TextUtils;
import java.io.File;
import java.io.FileFilter;

final class u
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    paramFile = paramFile.getName();
    return (!TextUtils.isEmpty(paramFile)) && (paramFile.endsWith(".dex"));
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\utils\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */