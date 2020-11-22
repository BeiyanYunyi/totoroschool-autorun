package com.bumptech.glide.load.c;

import android.net.Uri;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class d
{
  private final URL a;
  private final e b;
  private final String c;
  private String d;
  private URL e;
  
  public d(String paramString)
  {
    this(paramString, e.b);
  }
  
  public d(String paramString, e parame)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (parame != null)
      {
        this.c = paramString;
        this.a = null;
        this.b = parame;
        return;
      }
      throw new IllegalArgumentException("Headers must not be null");
    }
    parame = new StringBuilder();
    parame.append("String url must not be empty or null: ");
    parame.append(paramString);
    throw new IllegalArgumentException(parame.toString());
  }
  
  public d(URL paramURL)
  {
    this(paramURL, e.b);
  }
  
  public d(URL paramURL, e parame)
  {
    if (paramURL != null)
    {
      if (parame != null)
      {
        this.a = paramURL;
        this.c = null;
        this.b = parame;
        return;
      }
      throw new IllegalArgumentException("Headers must not be null");
    }
    throw new IllegalArgumentException("URL must not be null!");
  }
  
  private URL d()
    throws MalformedURLException
  {
    if (this.e == null) {
      this.e = new URL(e());
    }
    return this.e;
  }
  
  private String e()
  {
    if (TextUtils.isEmpty(this.d))
    {
      String str2 = this.c;
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = this.a.toString();
      }
      this.d = Uri.encode(str1, "@#&=*+-_.,:!?()/~'%");
    }
    return this.d;
  }
  
  public URL a()
    throws MalformedURLException
  {
    return d();
  }
  
  public Map<String, String> b()
  {
    return this.b.a();
  }
  
  public String c()
  {
    if (this.c != null) {
      return this.c;
    }
    return this.a.toString();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof d;
    boolean bool2 = false;
    if (bool1)
    {
      paramObject = (d)paramObject;
      bool1 = bool2;
      if (c().equals(((d)paramObject).c()))
      {
        bool1 = bool2;
        if (this.b.equals(((d)paramObject).b)) {
          bool1 = true;
        }
      }
      return bool1;
    }
    return false;
  }
  
  public int hashCode()
  {
    return c().hashCode() * 31 + this.b.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c());
    localStringBuilder.append('\n');
    localStringBuilder.append(this.b.toString());
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */