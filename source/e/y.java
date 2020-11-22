package e;

import java.io.IOException;

public enum y
{
  private final String protocol;
  
  static
  {
    HTTP_2 = new y("HTTP_2", 3, "h2");
  }
  
  private y(String paramString)
  {
    this.protocol = paramString;
  }
  
  public static y get(String paramString)
    throws IOException
  {
    if (paramString.equals(HTTP_1_0.protocol)) {
      return HTTP_1_0;
    }
    if (paramString.equals(HTTP_1_1.protocol)) {
      return HTTP_1_1;
    }
    if (paramString.equals(H2_PRIOR_KNOWLEDGE.protocol)) {
      return H2_PRIOR_KNOWLEDGE;
    }
    if (paramString.equals(HTTP_2.protocol)) {
      return HTTP_2;
    }
    if (paramString.equals(SPDY_3.protocol)) {
      return SPDY_3;
    }
    if (paramString.equals(QUIC.protocol)) {
      return QUIC;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unexpected protocol: ");
    localStringBuilder.append(paramString);
    throw new IOException(localStringBuilder.toString());
  }
  
  public String toString()
  {
    return this.protocol;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\e\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */