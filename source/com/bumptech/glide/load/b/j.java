package com.bumptech.glide.load.b;

import com.bumptech.glide.load.c;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

class j
  implements c
{
  private final String a;
  private final c b;
  
  public j(String paramString, c paramc)
  {
    this.a = paramString;
    this.b = paramc;
  }
  
  public void a(MessageDigest paramMessageDigest)
    throws UnsupportedEncodingException
  {
    paramMessageDigest.update(this.a.getBytes("UTF-8"));
    this.b.a(paramMessageDigest);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (j)paramObject;
      if (!this.a.equals(((j)paramObject).a)) {
        return false;
      }
      return this.b.equals(((j)paramObject).b);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.a.hashCode() * 31 + this.b.hashCode();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\b\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */