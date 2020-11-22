package com.bumptech.glide.g;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

public class c
  implements com.bumptech.glide.load.c
{
  private final String a;
  
  public c(String paramString)
  {
    if (paramString != null)
    {
      this.a = paramString;
      return;
    }
    throw new NullPointerException("Signature cannot be null!");
  }
  
  public void a(MessageDigest paramMessageDigest)
    throws UnsupportedEncodingException
  {
    paramMessageDigest.update(this.a.getBytes("UTF-8"));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (c)paramObject;
      return this.a.equals(((c)paramObject).a);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StringSignature{signature='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\g\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */