package com.bumptech.glide.load.a;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class g<T>
  implements c<T>
{
  private final Uri a;
  private final Context b;
  private T c;
  
  public g(Context paramContext, Uri paramUri)
  {
    this.b = paramContext.getApplicationContext();
    this.a = paramUri;
  }
  
  public final T a(com.bumptech.glide.g paramg)
    throws Exception
  {
    paramg = this.b.getContentResolver();
    this.c = b(this.a, paramg);
    return (T)this.c;
  }
  
  public void a()
  {
    if (this.c != null) {
      try
      {
        a(this.c);
        return;
      }
      catch (IOException localIOException)
      {
        if (Log.isLoggable("LocalUriFetcher", 2)) {
          Log.v("LocalUriFetcher", "failed to close data", localIOException);
        }
      }
    }
  }
  
  protected abstract void a(T paramT)
    throws IOException;
  
  protected abstract T b(Uri paramUri, ContentResolver paramContentResolver)
    throws FileNotFoundException;
  
  public String b()
  {
    return this.a.toString();
  }
  
  public void c() {}
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */