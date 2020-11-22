package com.totoro.school.utils;

import android.os.AsyncTask;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class g
  extends AsyncTask<String, Integer, File>
{
  private a a;
  private String b;
  private String c;
  
  public g(String paramString, a parama)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append("zxp");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("pdf");
    this.b = localStringBuilder.toString();
    this.c = paramString;
    this.a = parama;
  }
  
  protected File a(String... paramVarArgs)
  {
    Object localObject = paramVarArgs[0];
    if ((TextUtils.isEmpty((CharSequence)localObject)) && (this.a != null)) {
      this.a.a();
    }
    paramVarArgs = new File(this.b);
    if (!paramVarArgs.exists()) {
      paramVarArgs.mkdirs();
    }
    paramVarArgs = new StringBuilder();
    paramVarArgs.append(this.b);
    paramVarArgs.append(File.separator);
    paramVarArgs.append(this.c);
    paramVarArgs = new File(paramVarArgs.toString());
    if (paramVarArgs.exists()) {
      return paramVarArgs;
    }
    try
    {
      localObject = (HttpURLConnection)new URL((String)localObject).openConnection();
      ((HttpURLConnection)localObject).setConnectTimeout(10000);
      ((HttpURLConnection)localObject).setReadTimeout(10000);
      ((HttpURLConnection)localObject).setRequestMethod("GET");
      ((HttpURLConnection)localObject).setDoInput(true);
      ((HttpURLConnection)localObject).connect();
      int j = ((HttpURLConnection)localObject).getContentLength();
      if (((HttpURLConnection)localObject).getResponseCode() == 200)
      {
        InputStream localInputStream = ((HttpURLConnection)localObject).getInputStream();
        FileOutputStream localFileOutputStream = new FileOutputStream(paramVarArgs);
        byte[] arrayOfByte = new byte['Ѐ'];
        int i = 0;
        for (;;)
        {
          int k = localInputStream.read(arrayOfByte);
          if (k == -1) {
            break;
          }
          i += k;
          localFileOutputStream.write(arrayOfByte, 0, k);
          publishProgress(new Integer[] { Integer.valueOf(i), Integer.valueOf(j) });
        }
        localFileOutputStream.close();
        localInputStream.close();
        ((HttpURLConnection)localObject).disconnect();
      }
      return paramVarArgs;
    }
    catch (Exception paramVarArgs)
    {
      paramVarArgs.printStackTrace();
      if (this.a != null) {
        this.a.a();
      }
    }
    return null;
  }
  
  protected void a(File paramFile)
  {
    super.onCancelled(paramFile);
  }
  
  protected void a(Integer... paramVarArgs)
  {
    super.onProgressUpdate(paramVarArgs);
    if (this.a != null) {
      this.a.a(paramVarArgs[0], paramVarArgs[1]);
    }
  }
  
  protected void b(File paramFile)
  {
    super.onPostExecute(paramFile);
    if (this.a != null)
    {
      if ((paramFile != null) && (paramFile.exists()))
      {
        this.a.a(paramFile);
        return;
      }
      this.a.a();
    }
  }
  
  protected void onCancelled()
  {
    super.onCancelled();
    if (this.a != null) {
      this.a.a();
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
  }
  
  public void setOnLoadPDFListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(File paramFile);
    
    public abstract void a(Integer paramInteger1, Integer paramInteger2);
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\totoro\school\utils\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */