package com.bumptech.glide.load.a;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.g;
import com.bumptech.glide.h.b;
import com.bumptech.glide.load.c.d;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class f
  implements c<InputStream>
{
  private static final b a = new a(null);
  private final d b;
  private final b c;
  private HttpURLConnection d;
  private InputStream e;
  private volatile boolean f;
  
  public f(d paramd)
  {
    this(paramd, a);
  }
  
  f(d paramd, b paramb)
  {
    this.b = paramd;
    this.c = paramb;
  }
  
  private InputStream a(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    if (TextUtils.isEmpty(paramHttpURLConnection.getContentEncoding()))
    {
      int i = paramHttpURLConnection.getContentLength();
      this.e = b.a(paramHttpURLConnection.getInputStream(), i);
    }
    else
    {
      if (Log.isLoggable("HttpUrlFetcher", 3))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Got non empty content encoding: ");
        localStringBuilder.append(paramHttpURLConnection.getContentEncoding());
        Log.d("HttpUrlFetcher", localStringBuilder.toString());
      }
      this.e = paramHttpURLConnection.getInputStream();
    }
    return this.e;
  }
  
  private InputStream a(URL paramURL1, int paramInt, URL paramURL2, Map<String, String> paramMap)
    throws IOException
  {
    if ((paramInt >= 5) || (paramURL2 != null)) {}
    try
    {
      if (paramURL1.toURI().equals(paramURL2.toURI())) {
        throw new IOException("In re-direct loop");
      }
    }
    catch (URISyntaxException paramURL2)
    {
      int i;
      int j;
      for (;;) {}
    }
    this.d = this.c.a(paramURL1);
    paramURL2 = paramMap.entrySet().iterator();
    while (paramURL2.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramURL2.next();
      this.d.addRequestProperty((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    this.d.setConnectTimeout(2500);
    this.d.setReadTimeout(2500);
    this.d.setUseCaches(false);
    this.d.setDoInput(true);
    this.d.connect();
    if (this.f) {
      return null;
    }
    i = this.d.getResponseCode();
    j = i / 100;
    if (j == 2) {
      return a(this.d);
    }
    if (j == 3)
    {
      paramURL2 = this.d.getHeaderField("Location");
      if (!TextUtils.isEmpty(paramURL2)) {
        return a(new URL(paramURL1, paramURL2), paramInt + 1, paramURL1, paramMap);
      }
      throw new IOException("Received empty or null redirect url");
    }
    if (i == -1) {
      throw new IOException("Unable to retrieve response code from HttpUrlConnection.");
    }
    paramURL1 = new StringBuilder();
    paramURL1.append("Request failed ");
    paramURL1.append(i);
    paramURL1.append(": ");
    paramURL1.append(this.d.getResponseMessage());
    throw new IOException(paramURL1.toString());
    throw new IOException("Too many (> 5) redirects!");
  }
  
  public void a()
  {
    if (this.e != null) {}
    try
    {
      this.e.close();
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    if (this.d != null) {
      this.d.disconnect();
    }
  }
  
  public InputStream b(g paramg)
    throws Exception
  {
    return a(this.b.a(), 0, null, this.b.b());
  }
  
  public String b()
  {
    return this.b.c();
  }
  
  public void c()
  {
    this.f = true;
  }
  
  private static class a
    implements f.b
  {
    public HttpURLConnection a(URL paramURL)
      throws IOException
    {
      return (HttpURLConnection)paramURL.openConnection();
    }
  }
  
  static abstract interface b
  {
    public abstract HttpURLConnection a(URL paramURL)
      throws IOException;
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\a\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */