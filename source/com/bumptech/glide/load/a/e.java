package com.bumptech.glide.load.a;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;

public class e
  extends g<ParcelFileDescriptor>
{
  public e(Context paramContext, Uri paramUri)
  {
    super(paramContext, paramUri);
  }
  
  protected ParcelFileDescriptor a(Uri paramUri, ContentResolver paramContentResolver)
    throws FileNotFoundException
  {
    return paramContentResolver.openAssetFileDescriptor(paramUri, "r").getParcelFileDescriptor();
  }
  
  protected void a(ParcelFileDescriptor paramParcelFileDescriptor)
    throws IOException
  {
    paramParcelFileDescriptor.close();
  }
}


/* Location:              C:\Users\lixia\Desktop\android反编译三件套\dex2jar-2.0\classes-dex2jar.jar!\com\bumptech\glide\load\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */