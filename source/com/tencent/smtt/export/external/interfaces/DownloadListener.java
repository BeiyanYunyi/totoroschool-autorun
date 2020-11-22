package com.tencent.smtt.export.external.interfaces;

public abstract interface DownloadListener
{
  public abstract void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong);
  
  public abstract void onDownloadStart(String paramString1, String paramString2, byte[] paramArrayOfByte, String paramString3, String paramString4, String paramString5, long paramLong, String paramString6, String paramString7);
  
  public abstract void onDownloadVideo(String paramString, long paramLong, int paramInt);
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\export\external\interfaces\DownloadListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */