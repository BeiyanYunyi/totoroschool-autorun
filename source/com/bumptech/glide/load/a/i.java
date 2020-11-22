package com.bumptech.glide.load.a;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class i
  extends g<InputStream>
{
  public i(Context paramContext, Uri paramUri)
  {
    super(paramContext, paramUri);
  }
  
  protected InputStream a(Uri paramUri, ContentResolver paramContentResolver)
    throws FileNotFoundException
  {
    return paramContentResolver.openInputStream(paramUri);
  }
  
  protected void a(InputStream paramInputStream)
    throws IOException
  {
    paramInputStream.close();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\a\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */