package com.bumptech.glide.load.b.b;

import com.bumptech.glide.h.e;
import com.bumptech.glide.h.h;
import com.bumptech.glide.load.c;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class j
{
  private final e<c, String> a = new e(1000);
  
  public String a(c paramc)
  {
    synchronized (this.a)
    {
      Object localObject1 = (String)this.a.b(paramc);
      if (localObject1 == null)
      {
        try
        {
          ??? = MessageDigest.getInstance("SHA-256");
          paramc.a((MessageDigest)???);
          ??? = h.a(((MessageDigest)???).digest());
          localObject1 = ???;
        }
        catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
        {
          localNoSuchAlgorithmException.printStackTrace();
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
        synchronized (this.a)
        {
          this.a.b(paramc, localObject1);
          return (String)localObject1;
        }
      }
      return (String)localObject1;
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\b\b\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */