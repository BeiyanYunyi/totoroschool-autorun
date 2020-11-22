package com.tencent.smtt.export.external.interfaces;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public abstract class UrlResponseInfo
{
  public abstract Map<String, List<String>> getAllHeaders();
  
  public abstract List<Map.Entry<String, String>> getAllHeadersAsList();
  
  public abstract int getHttpStatusCode();
  
  public abstract String getHttpStatusText();
  
  public abstract String getNegotiatedProtocol();
  
  public abstract String getProxyServer();
  
  public abstract long getReceivedByteCount();
  
  public abstract String getUrl();
  
  public abstract List<String> getUrlChain();
  
  public abstract boolean wasCached();
  
  public static abstract class HeaderBlock
  {
    public abstract List<Map.Entry<String, String>> getAsList();
    
    public abstract Map<String, List<String>> getAsMap();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\tencent\smtt\export\external\interfaces\UrlResponseInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */