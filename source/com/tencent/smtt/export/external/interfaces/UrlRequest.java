package com.tencent.smtt.export.external.interfaces;

import java.nio.ByteBuffer;

public abstract class UrlRequest
{
  public abstract void cancel();
  
  public abstract void followRedirect();
  
  public abstract boolean isDone();
  
  public abstract void read(ByteBuffer paramByteBuffer);
  
  public abstract void start();
  
  public static abstract class Builder
  {
    public static final int REQUEST_PRIORITY_HIGHEST = 4;
    public static final int REQUEST_PRIORITY_IDLE = 0;
    public static final int REQUEST_PRIORITY_LOW = 2;
    public static final int REQUEST_PRIORITY_LOWEST = 1;
    public static final int REQUEST_PRIORITY_MEDIUM = 3;
    
    public abstract Builder addHeader(String paramString1, String paramString2);
    
    public abstract UrlRequest build();
    
    public abstract Builder disableCache();
    
    public abstract Builder setHttpMethod(String paramString);
    
    public abstract Builder setPriority(int paramInt);
  }
  
  public static abstract class Callback
  {
    public void onCanceled(UrlRequest paramUrlRequest, UrlResponseInfo paramUrlResponseInfo) {}
    
    public abstract void onFailed(UrlRequest paramUrlRequest, UrlResponseInfo paramUrlResponseInfo, X5netException paramX5netException);
    
    public abstract void onReadCompleted(UrlRequest paramUrlRequest, UrlResponseInfo paramUrlResponseInfo, ByteBuffer paramByteBuffer);
    
    public abstract void onRedirectReceived(UrlRequest paramUrlRequest, UrlResponseInfo paramUrlResponseInfo, String paramString);
    
    public abstract void onResponseStarted(UrlRequest paramUrlRequest, UrlResponseInfo paramUrlResponseInfo);
    
    public abstract void onSucceeded(UrlRequest paramUrlRequest, UrlResponseInfo paramUrlResponseInfo);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\export\external\interfaces\UrlRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */