package com.pgyersdk.update;

import java.io.File;

public abstract interface DownloadFileListener
{
  public abstract void downloadFailed();
  
  public abstract void downloadSuccessful(File paramFile);
  
  public abstract void onProgressUpdate(Integer... paramVarArgs);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\update\DownloadFileListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */