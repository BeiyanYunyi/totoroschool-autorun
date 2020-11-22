package com.pgyersdk.f;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class d
{
  private final String a;
  private String b;
  private String c;
  private i d;
  private int e = 120000;
  private final Map<String, String> f;
  
  public d(String paramString)
  {
    this.a = paramString;
    this.f = new HashMap();
  }
  
  public d a(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public d a(String paramString1, String paramString2)
  {
    this.f.put(paramString1, paramString2);
    return this;
  }
  
  public d a(Map<String, String> paramMap, Context paramContext, File paramFile, List<Uri> paramList)
  {
    int i;
    boolean bool;
    try
    {
      this.d = new i();
      this.d.d();
      localObject = paramMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        this.d.a(str, (String)paramMap.get(str));
      }
      if (paramFile == null) {
        break label264;
      }
      paramMap = new FileInputStream(paramFile.getAbsolutePath());
      localObject = this.d;
      paramFile = paramFile.getName();
      ((i)localObject).a("voice", paramFile, paramMap, "audio/wav", false);
    }
    catch (IOException paramMap)
    {
      Object localObject;
      int j;
      throw new RuntimeException(paramMap);
    }
    if (i < paramList.size())
    {
      paramFile = (Uri)paramList.get(i);
      j = paramList.size();
      bool = true;
      if (i != j - 1) {
        break label275;
      }
    }
    for (;;)
    {
      paramMap = paramContext.getContentResolver().openInputStream(paramFile);
      paramFile = paramFile.getLastPathSegment();
      localObject = this.d;
      ((i)localObject).a("image[]", paramFile, paramMap, bool);
      i += 1;
      break;
      label264:
      do
      {
        this.d.e();
        paramMap = new StringBuilder();
        paramMap.append("multipart/form-data; boundary=");
        paramMap.append(this.d.a());
        a("Content-Type", paramMap.toString());
        return this;
      } while (paramList == null);
      i = 0;
      break;
      label275:
      bool = false;
    }
  }
  
  public HttpURLConnection a()
  {
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(this.a).openConnection();
      localHttpURLConnection.setConnectTimeout(this.e);
      localHttpURLConnection.setReadTimeout(this.e);
      int i = Build.VERSION.SDK_INT;
      if (i <= 9) {
        localHttpURLConnection.setRequestProperty("Connection", "close");
      }
      if (!TextUtils.isEmpty(this.b))
      {
        localHttpURLConnection.setRequestMethod(this.b);
        if (TextUtils.isEmpty(this.c))
        {
          localObject = this.b;
          if (!((String)localObject).equalsIgnoreCase("POST"))
          {
            localObject = this.b;
            if (!((String)localObject).equalsIgnoreCase("PUT")) {
              break label113;
            }
          }
        }
        localHttpURLConnection.setDoOutput(true);
      }
      label113:
      Object localObject = this.f.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localHttpURLConnection.setRequestProperty(str, (String)this.f.get(str));
      }
      if (!TextUtils.isEmpty(this.c))
      {
        localObject = localHttpURLConnection.getOutputStream();
        localObject = new BufferedWriter(new OutputStreamWriter((OutputStream)localObject, "UTF-8"));
        ((BufferedWriter)localObject).write(this.c);
        ((BufferedWriter)localObject).flush();
        ((BufferedWriter)localObject).close();
      }
      localObject = this.d;
      if (localObject != null)
      {
        localHttpURLConnection.setRequestProperty("Content-Length", String.valueOf(this.d.b()));
        localObject = new BufferedOutputStream(localHttpURLConnection.getOutputStream());
        ((BufferedOutputStream)localObject).write(this.d.c().toByteArray());
        ((BufferedOutputStream)localObject).flush();
        ((BufferedOutputStream)localObject).close();
      }
      return localHttpURLConnection;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException);
    }
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\pgyersdk\f\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */